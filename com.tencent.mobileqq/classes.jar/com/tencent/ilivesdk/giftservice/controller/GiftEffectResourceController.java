package com.tencent.ilivesdk.giftservice.controller;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.downloader.DownLoaderInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.utils.FileUtil;
import com.tencent.falco.utils.StringUtil;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilivesdk.giftservice.GiftService;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceAdapter;
import com.tencent.ilivesdk.giftservice_interface.model.GiftEffectResourceInfo;
import com.tencent.ilivesdk.giftservice_interface.model.IGetGiftEffectResInfoListener;
import com.tencent.ilivesdk.giftservice_interface.model.IGetGiftEffectResListener;
import com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano.BatchGetLuxuryGiftVideoConfigReq;
import com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano.VideoReq;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GiftEffectResourceController
  implements ThreadCenter.HandlerKeyable
{
  private static final String TAG = "GiftEffectResourceController";
  private int MINI_SUPPORT_VERSION = 19;
  private Context mContext;
  private IGetGiftEffectResInfoListener mGetGiftEffectResInfoListener;
  private IGetGiftEffectResListener mGetGiftEffectResListener;
  private File mGiftEffectResourceLocalFile;
  private Map<String, GiftEffectResourceInfo> mGiftEffectResourceMap = new HashMap();
  private GiftService mGiftService;
  private Map<String, String> mLocalResMd5Map = new HashMap();
  private int mVideoLevel = 1;
  private Runnable runnable = null;
  
  private void deleteFile(File paramFile)
  {
    boolean bool = paramFile.exists();
    int i = 0;
    if (!bool)
    {
      this.mGiftService.getServiceAdapter().getLogger().e("GiftEffectResourceController", "file is not exists", new Object[0]);
      return;
    }
    if (paramFile.isFile())
    {
      paramFile.delete();
      return;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length != 0))
      {
        int j = arrayOfFile.length;
        while (i < j)
        {
          deleteFile(arrayOfFile[i]);
          i += 1;
        }
        paramFile.delete();
        return;
      }
      paramFile.delete();
    }
  }
  
  private String getMediaFilePath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    Object localObject = new File(paramString).listFiles();
    if (localObject == null) {
      return "";
    }
    int i = 0;
    while (i < localObject.length)
    {
      if (!localObject[i].isDirectory())
      {
        String str = localObject[i].getName();
        if (str.trim().toLowerCase().endsWith(".mp4"))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(str);
          return ((StringBuilder)localObject).toString();
        }
      }
      i += 1;
    }
    return "";
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mGiftEffectResourceLocalFile = new File(paramContext.getExternalFilesDir(null), "/tencent/now/file");
    initVideoLevel();
    loadLocalResMd5Info();
  }
  
  private void initVideoLevel()
  {
    int i = UIUtil.getScreenWidth(this.mContext);
    int j = UIUtil.getScreenHeight(this.mContext);
    if ((i >= 720) && (j >= 1280))
    {
      if (isSupportAVCCodec()) {
        this.mVideoLevel = 1;
      } else {
        this.mVideoLevel = 2;
      }
    }
    else {
      this.mVideoLevel = 2;
    }
    if (isFEvsNine(i, j)) {
      this.mVideoLevel = 4;
    }
    if (Build.VERSION.SDK_INT <= this.MINI_SUPPORT_VERSION) {
      this.mVideoLevel = 2;
    }
    LogInterface localLogInterface = this.mGiftService.getServiceAdapter().getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" w=");
    localStringBuilder.append(i);
    localStringBuilder.append(" h=");
    localStringBuilder.append(j);
    localStringBuilder.append("level=");
    localStringBuilder.append(this.mVideoLevel);
    localLogInterface.e("GiftEffectResourceController", localStringBuilder.toString(), new Object[0]);
  }
  
  private boolean isFEvsNine(int paramInt1, int paramInt2)
  {
    return Math.abs(paramInt1 * 2 - paramInt2) < 200;
  }
  
  private boolean isGiftResMd5Update(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      if (!this.mLocalResMd5Map.containsKey(paramString1))
      {
        this.mLocalResMd5Map.put(paramString1, paramString2);
        return true;
      }
      String str = (String)this.mLocalResMd5Map.get(paramString1);
      if (TextUtils.isEmpty(str))
      {
        this.mLocalResMd5Map.put(paramString1, paramString2);
        return true;
      }
      if (!paramString2.equals(str))
      {
        this.mLocalResMd5Map.put(paramString1, paramString2);
        return true;
      }
    }
    return false;
  }
  
  private boolean isResFileAvailable(GiftEffectResourceInfo paramGiftEffectResourceInfo)
  {
    if (paramGiftEffectResourceInfo == null) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramGiftEffectResourceInfo.mGiftRootPath)) && (!TextUtils.isEmpty(paramGiftEffectResourceInfo.mLottieConfigFilePath)) && (!TextUtils.isEmpty(paramGiftEffectResourceInfo.mLottiePlayConfigFilePath)) && (!TextUtils.isEmpty(paramGiftEffectResourceInfo.mMediaFilePath)))
    {
      localObject1 = new File(paramGiftEffectResourceInfo.mMediaFilePath);
      localObject2 = new File(paramGiftEffectResourceInfo.mLottieConfigFilePath);
      File localFile = new File(paramGiftEffectResourceInfo.mLottiePlayConfigFilePath);
      if ((((File)localObject1).exists()) && (((File)localObject2).exists()) && (localFile.exists()))
      {
        localObject1 = this.mGiftService.getServiceAdapter().getLogger();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("res is available, giftid:");
        ((StringBuilder)localObject2).append(paramGiftEffectResourceInfo.mGiftEffectId);
        ((LogInterface)localObject1).i("GiftEffectResourceController", ((StringBuilder)localObject2).toString(), new Object[0]);
        return true;
      }
      return false;
    }
    Object localObject1 = this.mGiftService.getServiceAdapter().getLogger();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("isResFileAvailable file path has not, giftid:");
    ((StringBuilder)localObject2).append(paramGiftEffectResourceInfo.mGiftEffectId);
    ((LogInterface)localObject1).i("GiftEffectResourceController", ((StringBuilder)localObject2).toString(), new Object[0]);
    return false;
  }
  
  private boolean isSupportAVCCodec()
  {
    this.mGiftService.getServiceAdapter().getLogger().i("GiftEffectResourceController", "isSupportAVCCodec in", new Object[0]);
    return Build.VERSION.SDK_INT >= 16;
  }
  
  private void loadLocalResMd5Info()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(this.mGiftEffectResourceLocalFile.getPath());
    localStringBuilder2.append("/");
    ThreadCenter.postLogicTask(new GiftEffectResourceController.3(this, new File(localStringBuilder2.toString(), "giftMd5Config"), localStringBuilder1));
  }
  
  private void notifyGiftEffectResInfoListener(List<GiftEffectResourceInfo> paramList)
  {
    IGetGiftEffectResInfoListener localIGetGiftEffectResInfoListener = this.mGetGiftEffectResInfoListener;
    if (localIGetGiftEffectResInfoListener != null) {
      localIGetGiftEffectResInfoListener.onCompleted(paramList);
    }
  }
  
  private void notifyGiftEffectResListener(GiftEffectResourceInfo paramGiftEffectResourceInfo)
  {
    IGetGiftEffectResListener localIGetGiftEffectResListener = this.mGetGiftEffectResListener;
    if (localIGetGiftEffectResListener != null) {
      localIGetGiftEffectResListener.onCompleted(paramGiftEffectResourceInfo);
    }
  }
  
  private void saveLocalResMd5Info()
  {
    Object localObject1 = new JSONObject();
    Object localObject2 = new JSONArray();
    String str;
    try
    {
      localObject3 = this.mLocalResMd5Map.entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
        if ((localEntry != null) && (!TextUtils.isEmpty((CharSequence)localEntry.getKey())) && (!TextUtils.isEmpty((CharSequence)localEntry.getValue())))
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("giftId", localEntry.getKey());
          localJSONObject.put("md5", localEntry.getValue());
          ((JSONArray)localObject2).put(localJSONObject);
        }
      }
      ((JSONObject)localObject1).put("list", localObject2);
      localObject1 = ((JSONObject)localObject1).toString();
    }
    catch (JSONException localJSONException)
    {
      localObject2 = this.mGiftService.getServiceAdapter().getLogger();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("saveLocalResMd5Info is error! ");
      ((StringBuilder)localObject3).append(localJSONException.getMessage());
      ((LogInterface)localObject2).e("GiftEffectResourceController", ((StringBuilder)localObject3).toString(), new Object[0]);
      str = "";
    }
    if (TextUtils.isEmpty(str))
    {
      this.mGiftService.getServiceAdapter().getLogger().e("GiftEffectResourceController", "saveLocalResMd5Info is error!", new Object[0]);
      return;
    }
    ThreadCenter.postLogicTask(new GiftEffectResourceController.2(this, str));
  }
  
  public void fetchGiftResByGiftEffectResInfo(GiftEffectResourceInfo paramGiftEffectResourceInfo, IGetGiftEffectResListener paramIGetGiftEffectResListener)
  {
    if (fetchLocalMemory(paramGiftEffectResourceInfo, paramIGetGiftEffectResListener)) {
      return;
    }
    if (fetchLocalDisk(paramGiftEffectResourceInfo, paramIGetGiftEffectResListener)) {
      return;
    }
    if ((!fetchNetWork(paramGiftEffectResourceInfo, paramIGetGiftEffectResListener)) && (paramIGetGiftEffectResListener != null)) {
      paramIGetGiftEffectResListener.onCompleted(null);
    }
  }
  
  public boolean fetchLocalDisk(GiftEffectResourceInfo paramGiftEffectResourceInfo, IGetGiftEffectResListener paramIGetGiftEffectResListener)
  {
    if (paramGiftEffectResourceInfo == null) {
      return false;
    }
    Object localObject = new StringBuffer(this.mGiftEffectResourceLocalFile.getPath());
    ((StringBuffer)localObject).append("/");
    ((StringBuffer)localObject).append(paramGiftEffectResourceInfo.mGiftEffectId);
    ((StringBuffer)localObject).append("/");
    ((StringBuffer)localObject).append(paramGiftEffectResourceInfo.mGiftEffectId);
    ((StringBuffer)localObject).append("/");
    localObject = ((StringBuffer)localObject).toString();
    if (!FileUtil.exists((String)localObject))
    {
      this.mGiftService.getServiceAdapter().getLogger().i("GiftEffectResourceController", "fetchLocalDisk local disk has no gift!", new Object[0]);
      return false;
    }
    if (paramGiftEffectResourceInfo.mIsResUpdate)
    {
      deleteFile(new File((String)localObject));
      return false;
    }
    paramGiftEffectResourceInfo.mGiftRootPath = ((String)localObject);
    paramGiftEffectResourceInfo.mMediaFilePath = getMediaFilePath((String)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("data.json");
    paramGiftEffectResourceInfo.mLottieConfigFilePath = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("lottiestart.json");
    paramGiftEffectResourceInfo.mLottiePlayConfigFilePath = localStringBuilder.toString();
    if (!isResFileAvailable(paramGiftEffectResourceInfo))
    {
      this.mGiftService.getServiceAdapter().getLogger().i("GiftEffectResourceController", "fetchLocalDisk isResFileAvailable is not available", new Object[0]);
      return false;
    }
    this.mGiftEffectResourceMap.put(paramGiftEffectResourceInfo.mGiftEffectId, paramGiftEffectResourceInfo);
    paramGiftEffectResourceInfo = (GiftEffectResourceInfo)this.mGiftEffectResourceMap.get(paramGiftEffectResourceInfo.mGiftEffectId);
    if (paramIGetGiftEffectResListener != null) {
      paramIGetGiftEffectResListener.onCompleted(paramGiftEffectResourceInfo);
    }
    notifyGiftEffectResListener(paramGiftEffectResourceInfo);
    return true;
  }
  
  public boolean fetchLocalMemory(GiftEffectResourceInfo paramGiftEffectResourceInfo, IGetGiftEffectResListener paramIGetGiftEffectResListener)
  {
    if (paramGiftEffectResourceInfo != null)
    {
      if (paramGiftEffectResourceInfo.mIsResUpdate) {
        return false;
      }
      if (!this.mGiftEffectResourceMap.containsKey(paramGiftEffectResourceInfo.mGiftEffectId))
      {
        this.mGiftService.getServiceAdapter().getLogger().i("GiftEffectResourceController", "local has no gift info", new Object[0]);
        return false;
      }
      paramGiftEffectResourceInfo = (GiftEffectResourceInfo)this.mGiftEffectResourceMap.get(paramGiftEffectResourceInfo.mGiftEffectId);
      if (paramGiftEffectResourceInfo == null) {
        return false;
      }
      String str = paramGiftEffectResourceInfo.mGiftRootPath;
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      if (!FileUtil.exists(str))
      {
        this.mGiftService.getServiceAdapter().getLogger().i("GiftEffectResourceController", "fetchLocalMemory local has no gift info", new Object[0]);
        return false;
      }
      if (!isResFileAvailable((GiftEffectResourceInfo)this.mGiftEffectResourceMap.get(paramGiftEffectResourceInfo.mGiftEffectId)))
      {
        this.mGiftService.getServiceAdapter().getLogger().i("GiftEffectResourceController", "fetchLocalMemory isResFileAvailable is not available", new Object[0]);
        return false;
      }
      if (paramIGetGiftEffectResListener != null) {
        paramIGetGiftEffectResListener.onCompleted(paramGiftEffectResourceInfo);
      }
      notifyGiftEffectResListener(paramGiftEffectResourceInfo);
      return true;
    }
    return false;
  }
  
  public boolean fetchNetWork(GiftEffectResourceInfo paramGiftEffectResourceInfo, IGetGiftEffectResListener paramIGetGiftEffectResListener)
  {
    if (paramGiftEffectResourceInfo == null) {
      return false;
    }
    this.mGiftEffectResourceMap.put(paramGiftEffectResourceInfo.mGiftEffectId, paramGiftEffectResourceInfo);
    if (StringUtil.isEmpty(paramGiftEffectResourceInfo.mResourceUrl)) {
      return false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramGiftEffectResourceInfo.mGiftEffectId);
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramGiftEffectResourceInfo.mResourceMD5);
    Object localObject2 = ((StringBuilder)localObject1).toString();
    int i = paramGiftEffectResourceInfo.mResourceUrl.indexOf(".");
    localObject1 = localObject2;
    if (i > -1)
    {
      localObject1 = paramGiftEffectResourceInfo.mResourceUrl.substring(i);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append((String)localObject1);
      localObject1 = localStringBuilder.toString();
    }
    if (StringUtil.isEmpty((String)localObject1)) {
      return false;
    }
    localObject2 = this.mGiftService.getServiceAdapter().getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resourceName is ");
    localStringBuilder.append((String)localObject1);
    ((LogInterface)localObject2).i("GiftEffectResourceController", localStringBuilder.toString(), new Object[0]);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.mGiftEffectResourceLocalFile.getPath());
    ((StringBuilder)localObject2).append("/");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = new File(((StringBuilder)localObject2).toString());
    this.mGiftService.getServiceAdapter().getDownLoader().start(paramGiftEffectResourceInfo.mResourceUrl, ((File)localObject1).getPath(), 4, 0, new GiftEffectResourceController.4(this, paramIGetGiftEffectResListener, (File)localObject1));
    return true;
  }
  
  public Map<String, GiftEffectResourceInfo> getGiftEffectResourceMap()
  {
    return this.mGiftEffectResourceMap;
  }
  
  public int getVideoLevel()
  {
    return this.mVideoLevel;
  }
  
  public void init(Context paramContext, GiftService paramGiftService)
  {
    this.mGiftService = paramGiftService;
    init(paramContext);
  }
  
  public void onDestroy()
  {
    Runnable localRunnable = this.runnable;
    if (localRunnable != null) {
      ThreadCenter.removeLogicTask(localRunnable);
    }
    ThreadCenter.clear(this);
  }
  
  public void queryH264GiftInfo(ArrayList<String> paramArrayList, IGetGiftEffectResInfoListener paramIGetGiftEffectResInfoListener)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      BatchGetLuxuryGiftVideoConfigReq localBatchGetLuxuryGiftVideoConfigReq = new BatchGetLuxuryGiftVideoConfigReq();
      VideoReq[] arrayOfVideoReq = new VideoReq[paramArrayList.size()];
      int i = 0;
      while (i < paramArrayList.size())
      {
        VideoReq localVideoReq = new VideoReq();
        localVideoReq.lgeId = ((String)paramArrayList.get(i));
        localVideoReq.level = this.mVideoLevel;
        arrayOfVideoReq[i] = localVideoReq;
        i += 1;
      }
      localBatchGetLuxuryGiftVideoConfigReq.videoReq = arrayOfVideoReq;
      paramArrayList = MessageNano.toByteArray(localBatchGetLuxuryGiftVideoConfigReq);
      this.mGiftService.getServiceAdapter().getChannel().send(30224, 1, paramArrayList, new GiftEffectResourceController.1(this, paramIGetGiftEffectResInfoListener));
      return;
    }
    if (paramIGetGiftEffectResInfoListener != null) {
      paramIGetGiftEffectResInfoListener.onCompleted(null);
    }
  }
  
  public void queryH264GiftRes(List<GiftEffectResourceInfo> paramList, IGetGiftEffectResListener paramIGetGiftEffectResListener)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      GiftEffectResourceInfo localGiftEffectResourceInfo = (GiftEffectResourceInfo)paramList.next();
      if (localGiftEffectResourceInfo != null) {
        fetchGiftResByGiftEffectResInfo(localGiftEffectResourceInfo, paramIGetGiftEffectResListener);
      }
    }
  }
  
  public void setGetGiftEffectResInfoListener(IGetGiftEffectResInfoListener paramIGetGiftEffectResInfoListener)
  {
    if (paramIGetGiftEffectResInfoListener == null) {
      return;
    }
    this.mGetGiftEffectResInfoListener = paramIGetGiftEffectResInfoListener;
  }
  
  public void setGetGiftEffectResListener(IGetGiftEffectResListener paramIGetGiftEffectResListener)
  {
    if (paramIGetGiftEffectResListener == null) {
      return;
    }
    this.mGetGiftEffectResListener = paramIGetGiftEffectResListener;
  }
  
  public void switch2LowLevel()
  {
    this.mVideoLevel = 2;
    this.mGiftService.getServiceAdapter().getLogger().i("GiftEffectResourceController", "switch 2 low level", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.controller.GiftEffectResourceController
 * JD-Core Version:    0.7.0.1
 */