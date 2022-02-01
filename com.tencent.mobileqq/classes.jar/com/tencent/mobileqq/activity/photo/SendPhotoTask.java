package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.activity.shortvideo.SendVideoInfo;
import com.tencent.mobileqq.activity.shortvideo.SendVideoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.utils.TroopGrayTipUtils;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.SendByFile;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SendPhotoTask
  implements Runnable
{
  WeakReference<BaseActivity> a;
  Handler b = null;
  ArrayList<String> c;
  ArrayList<String> d;
  HashMap<Integer, SendVideoInfo> e;
  public String f;
  int g;
  boolean h = true;
  int i;
  int j;
  boolean k = false;
  boolean l;
  Intent m;
  ArrayList<CompressInfo> n = new ArrayList();
  long o = 0L;
  long p = 0L;
  HashMap<String, PhotoSendParams> q;
  int r = 0;
  
  public SendPhotoTask(BaseActivity paramBaseActivity, Intent paramIntent, Handler paramHandler)
  {
    this.a = new WeakReference(paramBaseActivity);
    this.b = paramHandler;
    this.m = paramBaseActivity.getIntent();
    if (paramIntent != null) {
      this.m = paramIntent;
    }
    a(this.m);
    if (this.b != null)
    {
      paramBaseActivity = this.c;
      if ((paramBaseActivity == null) || (paramBaseActivity.isEmpty()))
      {
        paramBaseActivity = this.q;
        if ((paramBaseActivity == null) || (paramBaseActivity.isEmpty()))
        {
          paramBaseActivity = this.d;
          if ((paramBaseActivity == null) || (paramBaseActivity.isEmpty())) {
            break label155;
          }
        }
      }
      this.b.sendEmptyMessage(1);
      return;
      label155:
      this.b.sendEmptyMessage(4);
    }
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt != 1042) && (paramInt == 1054);
  }
  
  private boolean c()
  {
    if (this.m.hasExtra("presend_handler"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPhotoTask", 2, "presendPic ,sendPhotoTask return directly!");
      }
      return true;
    }
    return false;
  }
  
  protected CompressInfo a(int paramInt, Intent paramIntent)
  {
    return ((IPicBus)QRoute.api(IPicBus.class)).createCompressInfo(paramInt, paramIntent);
  }
  
  PicUploadInfo a(int paramInt)
  {
    return ((IPicBus)QRoute.api(IPicBus.class)).createPicUploadInfo(paramInt, this.m);
  }
  
  protected ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    Object localObject;
    while (i1 < this.c.size())
    {
      localObject = (String)this.c.get(i1);
      StringBuilder localStringBuilder;
      if (a((String)localObject))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sendPhotoTask. path invalid,path:");
        localStringBuilder.append((String)localObject);
        QLog.e("SendPhotoTask", 2, localStringBuilder.toString());
      }
      else if ((!a(i1, (String)localObject)) && (!c()) && (a((String)localObject, i1)))
      {
        localArrayList.add(localObject);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("sendPhotoTask, send Photo : ");
          localStringBuilder.append((String)localObject);
          QLog.d("SendPhotoTask", 2, localStringBuilder.toString());
        }
      }
      i1 += 1;
    }
    if ((localArrayList.size() >= 5) && (this.i == 1))
    {
      if (QLog.isColorLevel())
      {
        localObject = localArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          QLog.d("SendPhotoTask", 2, new Object[] { "sendPhotoTask,  mSendPaths path=", (String)((Iterator)localObject).next() });
        }
        QLog.d("SendPhotoTask", 2, new Object[] { "sendPhotoTask,  lastMessageUniseq=", Long.valueOf(this.p) });
      }
      a(localArrayList);
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendPhotoTask", 2, new Object[] { "sendPhotoTask,  mSendPaths size=", Integer.valueOf(localArrayList.size()) });
    }
    return localArrayList;
  }
  
  protected void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    this.g = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    this.h = paramIntent.getBooleanExtra("PicContants.NEED_COMPRESS", true);
    this.i = paramIntent.getIntExtra("uintype", 1003);
    this.k = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
    this.l = paramIntent.getBooleanExtra("send_in_background", false);
    this.c = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    this.d = this.m.getStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE");
    this.e = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.VIDEO_INFOS"));
    this.f = paramIntent.getStringExtra("uin");
    this.r = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    this.j = paramIntent.getIntExtra("key_confess_topicid", 0);
    this.q = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.photo_send_pic_type"));
    if (this.q == null) {
      this.q = new HashMap();
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append(" sendPhotoTask(),  mBusiType :");
      paramIntent.append(this.g);
      paramIntent.append(", mNeedCompress:");
      paramIntent.append(this.h);
      paramIntent.append(", mCurType:");
      paramIntent.append(this.i);
      paramIntent.append(",mIsWaitForResult:");
      paramIntent.append(this.k);
      paramIntent.append(",picQualityType: ");
      paramIntent.append(this.r);
      paramIntent.append(",mSendBackground = ");
      paramIntent.append(this.l);
      paramIntent.append("mPaths :");
      paramIntent.append(Arrays.toString(this.c.toArray()));
      paramIntent.append(", PhotoTypeSize:");
      paramIntent.append(this.q.size());
      QLog.d("SendPhotoTask", 2, paramIntent.toString());
    }
  }
  
  protected void a(BaseActivity paramBaseActivity, PicReq paramPicReq)
  {
    Object localObject;
    int i1;
    if ((paramBaseActivity != null) && (paramBaseActivity.app != null)) {
      if ((paramPicReq != null) && (paramPicReq.g != null))
      {
        a(paramBaseActivity.app, this.f, paramPicReq.g.n);
        if (paramPicReq.g.c == 9501)
        {
          b(paramBaseActivity, paramPicReq);
          return;
        }
        if ((paramPicReq.g.c == 9500) && ((paramPicReq.a == 2) || (paramPicReq.a == 4)))
        {
          localObject = paramBaseActivity.getIntent();
          this.m.removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
          ((Intent)localObject).setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.ChatActivity");
          ((Intent)localObject).putExtra("uin", paramPicReq.g.e);
          ((Intent)localObject).putExtra("key_confess_topicid", paramPicReq.g.K);
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(paramPicReq.g.n);
          ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
          ((Intent)localObject).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
          ((Intent)localObject).putExtra("PhotoConst.SEND_SIZE_SPEC", 2);
          ((Intent)localObject).addFlags(603979776);
          ((Intent)localObject).putExtra("param_compressInitTime", System.currentTimeMillis());
          i1 = ((Intent)localObject).getIntExtra(AlbumConstants.h, -1);
          if ((i1 != 80) && (i1 != 82)) {
            ((Intent)localObject).putExtra(AlbumConstants.h, 82);
          }
          paramBaseActivity.startActivityForResult((Intent)localObject, 2);
        }
        else
        {
          a(paramPicReq, paramBaseActivity.app);
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = new String[this.c.size()];
        this.c.toArray((Object[])localObject);
        boolean bool2 = paramBaseActivity.getIntent().getBooleanExtra("PhotoConst.IS_FORWARD", false);
        if (!bool2) {
          break label424;
        }
        i1 = paramBaseActivity.getIntent().getIntExtra("forward_source_uin_type", -1);
        if (paramPicReq.g != null)
        {
          int i2 = this.i;
          if (paramPicReq.g.t != 2) {
            break label429;
          }
          bool1 = true;
          StatisticConstants.a((String[])localObject, i2, bool1, bool2, i1, paramBaseActivity.app);
        }
        return;
      }
      catch (Exception paramBaseActivity)
      {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendPhotoTask", 2, "sendPhoto,sendReq is null,return!");
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SendPhotoTask", 2, "sendPhoto,activity or app is null,return!");
      }
      return;
      label424:
      i1 = -1;
      continue;
      label429:
      boolean bool1 = false;
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      ((IOrderMediaMsgService)paramQQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).enqueueMediaMsgByPath(paramString1, paramString2);
    }
  }
  
  protected void a(CompressInfo paramCompressInfo)
  {
    RichmediaService.a(paramCompressInfo);
  }
  
  protected void a(PicReq paramPicReq, QQAppInterface paramQQAppInterface)
  {
    ((IPicBus)QRoute.api(IPicBus.class)).launch(paramPicReq);
  }
  
  protected void a(List<String> paramList)
  {
    if ((this.a.get() != null) && (((BaseActivity)this.a.get()).app != null)) {
      TroopGrayTipUtils.a(((BaseActivity)this.a.get()).app, this.f, ((BaseActivity)this.a.get()).app.getCurrentUin(), paramList, this.p);
    }
  }
  
  protected boolean a(int paramInt, String paramString)
  {
    Object localObject = this.e;
    if ((localObject != null) && (((HashMap)localObject).get(Integer.valueOf(paramInt)) != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sendPhotoTask, send Video : ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("SendPhotoTask", 2, ((StringBuilder)localObject).toString());
      }
      localObject = (SendVideoInfo)this.e.get(Integer.valueOf(paramInt));
      Intent localIntent = new Intent();
      localIntent.putExtra("file_send_path", paramString);
      localIntent.putExtra("file_send_size", ((SendVideoInfo)localObject).fileSize);
      localIntent.putExtra("file_send_duration", ((SendVideoInfo)localObject).duration);
      localIntent.putExtra("uin", this.f);
      localIntent.putExtra("uintype", this.i);
      localIntent.putExtra("file_source", "album_flow");
      localIntent.putExtra("send_in_background", true);
      localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", this.r);
      b(localIntent);
      return true;
    }
    return false;
  }
  
  protected boolean a(PicReq paramPicReq, PicUploadInfo paramPicUploadInfo)
  {
    if (!paramPicReq.a(paramPicUploadInfo))
    {
      QLog.e("SendPhotoTask", 2, "sendPhotoTask. failed to bind the UpInfo to the sendReq");
      return false;
    }
    return true;
  }
  
  protected boolean a(PicUploadInfo paramPicUploadInfo)
  {
    CompressInfo localCompressInfo = a(this.g, this.m);
    if (localCompressInfo == null)
    {
      QLog.e("SendPhotoTask", 2, "sendPhotoTask. compressInfo is null!");
      return false;
    }
    localCompressInfo.v = this.i;
    localCompressInfo.w = true;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("SendPhoto,compressInfo.uinType");
      localStringBuilder.append(localCompressInfo.v);
      QLog.d("SendPhotoTask", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendPhotoTask, compress start.compressInfo.src = ");
      localStringBuilder.append(localCompressInfo.h);
      QLog.d("SendPhotoTask", 2, localStringBuilder.toString());
    }
    a(localCompressInfo);
    paramPicUploadInfo.n = localCompressInfo.l;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendPhotoTask,  compress finish, upInfo.localPath = ");
      localStringBuilder.append(paramPicUploadInfo.n);
      QLog.d("SendPhotoTask", 2, localStringBuilder.toString());
    }
    if ((localCompressInfo.p != 2) && (b(localCompressInfo.l))) {
      LogTag.a();
    }
    try
    {
      paramPicUploadInfo.r = b(localCompressInfo);
      if ((paramPicUploadInfo.r == null) || (!QLog.isColorLevel())) {
        break label370;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("@SendPhotoActivity.sendPhotoTask:");
      localStringBuilder.append(paramPicUploadInfo.r.toString());
      QLog.d("peak_pgjpeg", 2, localStringBuilder.toString());
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label308;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      label263:
      label308:
      label370:
      break label263;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("@ArrayIndexOutOfBoundsException occurred in PeakUtils.getSliceInfos， ");
      localStringBuilder.append(localCompressInfo.l);
      QLog.w("peak_pgjpeg", 2, localStringBuilder.toString());
      break label370;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("@OutOfMemoryError occurred in PeakUtils.getSliceInfos， ");
        localStringBuilder.append(localCompressInfo.l);
        localStringBuilder.append("'s size is ");
        localStringBuilder.append(FileUtils.getFileSizes(localCompressInfo.l));
        QLog.w("peak_pgjpeg", 2, localStringBuilder.toString());
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("@PeakUtils.getSliceInfos(");
    localStringBuilder.append(localCompressInfo.l);
    localStringBuilder.append(")");
    LogTag.a("peak_pgjpeg", localStringBuilder.toString());
    this.n.add(localCompressInfo);
    if (localCompressInfo.t)
    {
      paramPicUploadInfo.s = 1;
      Logger.a(paramPicUploadInfo, "fixProtocolType", "sendReq.upInfo.protocolType");
      return true;
    }
    paramPicUploadInfo.s = paramPicUploadInfo.j();
    return true;
  }
  
  protected boolean a(String paramString)
  {
    return FileUtils.fileExistsAndNotEmpty(paramString) ^ true;
  }
  
  protected boolean a(String paramString, int paramInt)
  {
    this.m.putExtra("PhotoConst.PHOTO_SEND_PATH", paramString);
    this.m.putExtra("PhotoConst.PHOTO_SEND_PATH_INDEX", paramInt);
    PicReq localPicReq = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(2, this.g);
    localPicReq.m = this.m.getIntExtra("KEY_MSG_FORWARD_ID", -1);
    PicUploadInfo localPicUploadInfo = a(this.g);
    if (!a(localPicReq, localPicUploadInfo)) {
      return false;
    }
    if (this.h)
    {
      if (!a(localPicUploadInfo)) {
        return false;
      }
    }
    else {
      localPicUploadInfo.n = paramString;
    }
    a((BaseActivity)this.a.get(), localPicReq);
    this.p = localPicUploadInfo.g;
    return true;
  }
  
  protected boolean a(String paramString, Parcelable paramParcelable)
  {
    this.m.putExtra("PhotoConst.PHOTO_SEND_PATH", paramString);
    this.m.putExtra("PhotoConst.photo_send_qzone_pic_file_params", paramParcelable);
    this.m.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1045);
    paramString = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(2, 1045);
    paramParcelable = a(1045);
    if (!a(paramString, paramParcelable)) {
      return false;
    }
    if (paramParcelable != null) {
      paramParcelable.n = null;
    }
    a((BaseActivity)this.a.get(), paramString);
    return true;
  }
  
  protected ArrayList<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.q.size() > 0)
    {
      Iterator localIterator = this.q.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        PhotoSendParams localPhotoSendParams = (PhotoSendParams)this.q.get(str);
        StringBuilder localStringBuilder;
        if ((!a(str)) && (localPhotoSendParams != null) && (!TextUtils.isEmpty(localPhotoSendParams.rawMd5)) && (localPhotoSendParams.fileSize > 0L) && (!TextUtils.isEmpty(localPhotoSendParams.rawDownloadUrl)))
        {
          if (a(str, localPhotoSendParams))
          {
            localArrayList.add(str);
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("sendPhotoTask Qzone path:");
              localStringBuilder.append(str);
              localStringBuilder.append(", photoMd5:");
              localStringBuilder.append(localPhotoSendParams.rawMd5);
              QLog.i("SendPhotoTask", 2, localStringBuilder.toString());
            }
          }
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("sendPhotoTask. path invalid, path:");
          localStringBuilder.append(str);
          localStringBuilder.append(", params:");
          if (localPhotoSendParams != null) {
            str = localPhotoSendParams.toString();
          } else {
            str = "";
          }
          localStringBuilder.append(str);
          QLog.e("SendPhotoTask", 2, localStringBuilder.toString());
        }
      }
    }
    return localArrayList;
  }
  
  protected ArrayList<Integer> b(CompressInfo paramCompressInfo)
  {
    return ((IPicUtil)QRoute.api(IPicUtil.class)).getSliceInfos(paramCompressInfo.l);
  }
  
  protected void b(Intent paramIntent)
  {
    paramIntent = new SendVideoTask((BaseActivity)this.a.get(), paramIntent);
    paramIntent.a();
    paramIntent.b();
  }
  
  protected void b(BaseActivity paramBaseActivity, PicReq paramPicReq)
  {
    Object localObject = (SmartDeviceProxyMgr)paramBaseActivity.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    boolean bool;
    if ((((SmartDeviceProxyMgr)localObject).c(Long.parseLong(paramPicReq.g.e))) && (((SmartDeviceProxyMgr)localObject).a(Long.parseLong(paramPicReq.g.e), 17))) {
      bool = true;
    } else {
      bool = false;
    }
    if (!Boolean.valueOf(bool).booleanValue())
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramPicReq.g.n);
      ((DeviceMsgHandle)paramBaseActivity.app.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).b().a(DeviceMsgHandle.d, paramPicReq.g.e, (List)localObject);
      return;
    }
    paramBaseActivity.runOnUiThread(new SendPhotoTask.1(this, (SmartDeviceProxyMgr)localObject, paramPicReq, paramBaseActivity));
  }
  
  protected boolean b(String paramString)
  {
    return ((IPicUtil)QRoute.api(IPicUtil.class)).isProgressiveJpeg(paramString);
  }
  
  public void run()
  {
    if (this.o > 0L) {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSendPhotoIdleCost", false, this.o, 0L, null, "");
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("SendPhoto, current pid=");
      ((StringBuilder)localObject1).append(Process.myPid());
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(this.a);
      ((StringBuilder)localObject1).append(", idleCost");
      ((StringBuilder)localObject1).append(this.o);
      QLog.d("SendPhotoTask", 2, ((StringBuilder)localObject1).toString());
    }
    long l1 = System.currentTimeMillis();
    if ((b(this.g)) && (QFileAssistantUtils.a(this.f)))
    {
      if (this.d == null) {
        this.d = new ArrayList();
      }
      this.d.addAll(this.c);
      this.c = null;
    }
    Object localObject1 = this.d;
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())) {
      SendByFile.a(((BaseActivity)this.a.get()).app, this.d, this.f, this.i);
    }
    if (this.c == null)
    {
      localObject1 = this.b;
      if (localObject1 != null) {
        ((Handler)localObject1).sendEmptyMessage(2);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sendPhotoTask, mPaths.size() : ");
      ((StringBuilder)localObject1).append(this.c.size());
      QLog.d("SendPhotoTask", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = a();
    ArrayList localArrayList = b();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("time cost:");
    ((StringBuilder)localObject2).append(System.currentTimeMillis() - l1);
    Logger.b("PIC_TAG_COST", "launch req ", ((StringBuilder)localObject2).toString());
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).addAll((Collection)localObject1);
    ((ArrayList)localObject2).addAll(localArrayList);
    if (((ArrayList)localObject2).size() > 0) {
      this.m.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
    }
    this.m.putExtra("param_selNum", ((ArrayList)localObject2).size());
    if (this.r == 2)
    {
      int i2 = ((ArrayList)localObject2).size();
      localObject1 = this.e;
      int i1;
      if (localObject1 != null) {
        i1 = ((HashMap)localObject1).size();
      } else {
        i1 = 0;
      }
      AlbumUtil.a(i2, i1);
    }
    localObject1 = this.b;
    if (localObject1 != null) {
      ((Handler)localObject1).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendPhotoTask
 * JD-Core Version:    0.7.0.1
 */