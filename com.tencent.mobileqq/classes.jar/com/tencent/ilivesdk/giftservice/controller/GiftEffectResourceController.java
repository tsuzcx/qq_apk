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
    int i = 0;
    if (!paramFile.exists()) {
      this.mGiftService.getServiceAdapter().getLogger().e("GiftEffectResourceController", "file is not exists", new Object[0]);
    }
    do
    {
      return;
      if (paramFile.isFile())
      {
        paramFile.delete();
        return;
      }
    } while (!paramFile.isDirectory());
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      paramFile.delete();
      return;
    }
    int j = arrayOfFile.length;
    while (i < j)
    {
      deleteFile(arrayOfFile[i]);
      i += 1;
    }
    paramFile.delete();
  }
  
  private String getMediaFilePath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    File[] arrayOfFile = new File(paramString).listFiles();
    if (arrayOfFile == null) {
      return "";
    }
    int i = 0;
    while (i < arrayOfFile.length)
    {
      if (!arrayOfFile[i].isDirectory())
      {
        String str = arrayOfFile[i].getName();
        if (str.trim().toLowerCase().endsWith(".mp4")) {
          return paramString + str;
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
    if ((i >= 720) && (j >= 1280)) {
      if (isSupportAVCCodec()) {
        this.mVideoLevel = 1;
      }
    }
    for (;;)
    {
      if (isFEvsNine(i, j)) {
        this.mVideoLevel = 4;
      }
      if (Build.VERSION.SDK_INT <= this.MINI_SUPPORT_VERSION) {
        this.mVideoLevel = 2;
      }
      this.mGiftService.getServiceAdapter().getLogger().e("GiftEffectResourceController", " w=" + i + " h=" + j + "level=" + this.mVideoLevel, new Object[0]);
      return;
      this.mVideoLevel = 2;
      continue;
      this.mVideoLevel = 2;
    }
  }
  
  private boolean isFEvsNine(int paramInt1, int paramInt2)
  {
    return Math.abs(paramInt1 * 2 - paramInt2) < 200;
  }
  
  private boolean isGiftResMd5Update(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
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
    return false;
  }
  
  private boolean isResFileAvailable(GiftEffectResourceInfo paramGiftEffectResourceInfo)
  {
    if (paramGiftEffectResourceInfo == null) {}
    File localFile1;
    File localFile2;
    File localFile3;
    do
    {
      return false;
      if ((TextUtils.isEmpty(paramGiftEffectResourceInfo.mGiftRootPath)) || (TextUtils.isEmpty(paramGiftEffectResourceInfo.mLottieConfigFilePath)) || (TextUtils.isEmpty(paramGiftEffectResourceInfo.mLottiePlayConfigFilePath)) || (TextUtils.isEmpty(paramGiftEffectResourceInfo.mMediaFilePath)))
      {
        this.mGiftService.getServiceAdapter().getLogger().i("GiftEffectResourceController", "isResFileAvailable file path has not, giftid:" + paramGiftEffectResourceInfo.mGiftEffectId, new Object[0]);
        return false;
      }
      localFile1 = new File(paramGiftEffectResourceInfo.mMediaFilePath);
      localFile2 = new File(paramGiftEffectResourceInfo.mLottieConfigFilePath);
      localFile3 = new File(paramGiftEffectResourceInfo.mLottiePlayConfigFilePath);
    } while ((!localFile1.exists()) || (!localFile2.exists()) || (!localFile3.exists()));
    this.mGiftService.getServiceAdapter().getLogger().i("GiftEffectResourceController", "res is available, giftid:" + paramGiftEffectResourceInfo.mGiftEffectId, new Object[0]);
    return true;
  }
  
  private boolean isSupportAVCCodec()
  {
    this.mGiftService.getServiceAdapter().getLogger().i("GiftEffectResourceController", "isSupportAVCCodec in", new Object[0]);
    return Build.VERSION.SDK_INT >= 16;
  }
  
  private void loadLocalResMd5Info()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ThreadCenter.postLogicTask(new GiftEffectResourceController.3(this, new File(this.mGiftEffectResourceLocalFile.getPath() + "/", "giftMd5Config"), localStringBuilder));
  }
  
  private void notifyGiftEffectResInfoListener(List<GiftEffectResourceInfo> paramList)
  {
    if (this.mGetGiftEffectResInfoListener != null) {
      this.mGetGiftEffectResInfoListener.onCompleted(paramList);
    }
  }
  
  private void notifyGiftEffectResListener(GiftEffectResourceInfo paramGiftEffectResourceInfo)
  {
    if (this.mGetGiftEffectResListener != null) {
      this.mGetGiftEffectResListener.onCompleted(paramGiftEffectResourceInfo);
    }
  }
  
  private void saveLocalResMd5Info()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      Iterator localIterator = this.mLocalResMd5Map.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((localEntry != null) && (!TextUtils.isEmpty((CharSequence)localEntry.getKey())) && (!TextUtils.isEmpty((CharSequence)localEntry.getValue())))
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("giftId", localEntry.getKey());
          localJSONObject2.put("md5", localEntry.getValue());
          localJSONArray.put(localJSONObject2);
        }
      }
      String str;
      return;
    }
    catch (JSONException localJSONException)
    {
      this.mGiftService.getServiceAdapter().getLogger().e("GiftEffectResourceController", "saveLocalResMd5Info is error! " + localJSONException.getMessage(), new Object[0]);
      for (str = ""; TextUtils.isEmpty(str); str = str.toString())
      {
        this.mGiftService.getServiceAdapter().getLogger().e("GiftEffectResourceController", "saveLocalResMd5Info is error!", new Object[0]);
        return;
        str.put("list", localJSONArray);
      }
      ThreadCenter.postLogicTask(new GiftEffectResourceController.2(this, str));
    }
  }
  
  public void fetchGiftResByGiftEffectResInfo(GiftEffectResourceInfo paramGiftEffectResourceInfo, IGetGiftEffectResListener paramIGetGiftEffectResListener)
  {
    if (fetchLocalMemory(paramGiftEffectResourceInfo, paramIGetGiftEffectResListener)) {}
    while ((fetchLocalDisk(paramGiftEffectResourceInfo, paramIGetGiftEffectResListener)) || (fetchNetWork(paramGiftEffectResourceInfo, paramIGetGiftEffectResListener)) || (paramIGetGiftEffectResListener == null)) {
      return;
    }
    paramIGetGiftEffectResListener.onCompleted(null);
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
    paramGiftEffectResourceInfo.mLottieConfigFilePath = ((String)localObject + "data.json");
    paramGiftEffectResourceInfo.mLottiePlayConfigFilePath = ((String)localObject + "lottiestart.json");
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
    if ((paramGiftEffectResourceInfo == null) || (paramGiftEffectResourceInfo.mIsResUpdate)) {
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
  
  public boolean fetchNetWork(GiftEffectResourceInfo paramGiftEffectResourceInfo, IGetGiftEffectResListener paramIGetGiftEffectResListener)
  {
    if (paramGiftEffectResourceInfo == null) {}
    do
    {
      do
      {
        return false;
        this.mGiftEffectResourceMap.put(paramGiftEffectResourceInfo.mGiftEffectId, paramGiftEffectResourceInfo);
      } while (StringUtil.isEmpty(paramGiftEffectResourceInfo.mResourceUrl));
      String str = paramGiftEffectResourceInfo.mGiftEffectId + "_" + paramGiftEffectResourceInfo.mResourceMD5;
      int i = paramGiftEffectResourceInfo.mResourceUrl.indexOf(".");
      localObject = str;
      if (i > -1)
      {
        localObject = paramGiftEffectResourceInfo.mResourceUrl.substring(i);
        localObject = str + (String)localObject;
      }
    } while (StringUtil.isEmpty((String)localObject));
    this.mGiftService.getServiceAdapter().getLogger().i("GiftEffectResourceController", "resourceName is " + (String)localObject, new Object[0]);
    Object localObject = new File(this.mGiftEffectResourceLocalFile.getPath() + "/" + (String)localObject);
    this.mGiftService.getServiceAdapter().getDownLoader().start(paramGiftEffectResourceInfo.mResourceUrl, ((File)localObject).getPath(), 4, 0, new GiftEffectResourceController.4(this, paramIGetGiftEffectResListener, (File)localObject));
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
    if (this.runnable != null) {
      ThreadCenter.removeLogicTask(this.runnable);
    }
    ThreadCenter.clear(this);
  }
  
  public void queryH264GiftInfo(ArrayList<String> paramArrayList, IGetGiftEffectResInfoListener paramIGetGiftEffectResInfoListener)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      if (paramIGetGiftEffectResInfoListener != null) {
        paramIGetGiftEffectResInfoListener.onCompleted(null);
      }
      return;
    }
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
  }
  
  public void queryH264GiftRes(List<GiftEffectResourceInfo> paramList, IGetGiftEffectResListener paramIGetGiftEffectResListener)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GiftEffectResourceInfo localGiftEffectResourceInfo = (GiftEffectResourceInfo)paramList.next();
        if (localGiftEffectResourceInfo != null) {
          fetchGiftResByGiftEffectResInfo(localGiftEffectResourceInfo, paramIGetGiftEffectResListener);
        }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.controller.GiftEffectResourceController
 * JD-Core Version:    0.7.0.1
 */