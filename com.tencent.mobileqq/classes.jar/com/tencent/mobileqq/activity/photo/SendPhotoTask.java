package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceComnFileMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.utils.TroopGrayTipUtils;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.SendByFile;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SendPhotoTask
  implements Runnable
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  Intent jdField_a_of_type_AndroidContentIntent;
  Handler jdField_a_of_type_AndroidOsHandler = null;
  public String a;
  WeakReference<BaseActivity> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  HashMap<Integer, SendVideoActivity.SendVideoInfo> jdField_a_of_type_JavaUtilHashMap;
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = 0L;
  ArrayList<String> jdField_b_of_type_JavaUtilArrayList;
  HashMap<String, PhotoSendParams> jdField_b_of_type_JavaUtilHashMap;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  ArrayList<CompressInfo> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_c_of_type_Boolean;
  int d = 0;
  
  public SendPhotoTask(BaseActivity paramBaseActivity, Intent paramIntent, Handler paramHandler)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_AndroidContentIntent = paramBaseActivity.getIntent();
    if (paramIntent != null) {
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    }
    a(this.jdField_a_of_type_AndroidContentIntent);
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) && ((this.jdField_b_of_type_JavaUtilHashMap == null) || (this.jdField_b_of_type_JavaUtilHashMap.isEmpty())) && ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.isEmpty()))) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_AndroidContentIntent.hasExtra("presend_handler"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPhotoTask", 2, "presendPic ,sendPhotoTask return directly!");
      }
      return true;
    }
    return false;
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt != 1042) && (paramInt == 1054);
  }
  
  protected CompressInfo a(int paramInt, Intent paramIntent)
  {
    return PicBusiManager.a(paramInt, paramIntent);
  }
  
  PicUploadInfo a(int paramInt)
  {
    return PicBusiManager.a(paramInt, this.jdField_a_of_type_AndroidContentIntent);
  }
  
  protected ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (a((String)localObject)) {
        QLog.e("SendPhotoTask", 2, "sendPhotoTask. path invalid,path:" + (String)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((!a(i, (String)localObject)) && (!a()) && (a((String)localObject, i)))
        {
          localArrayList.add(localObject);
          if (QLog.isColorLevel()) {
            QLog.d("SendPhotoTask", 2, "sendPhotoTask, send Photo : " + (String)localObject);
          }
        }
      }
    }
    if ((localArrayList.size() >= 5) && (this.jdField_b_of_type_Int == 1))
    {
      if (QLog.isColorLevel())
      {
        localObject = localArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          QLog.d("SendPhotoTask", 2, new Object[] { "sendPhotoTask,  mSendPaths path=", (String)((Iterator)localObject).next() });
        }
        QLog.d("SendPhotoTask", 2, new Object[] { "sendPhotoTask,  lastMessageUniseq=", Long.valueOf(this.jdField_b_of_type_Long) });
      }
      a(localArrayList);
    }
    while (!QLog.isColorLevel()) {
      return localArrayList;
    }
    QLog.d("SendPhotoTask", 2, new Object[] { "sendPhotoTask,  mSendPaths size=", Integer.valueOf(localArrayList.size()) });
    return localArrayList;
  }
  
  protected ArrayList<Integer> a(CompressInfo paramCompressInfo)
  {
    return PeakUtils.a(paramCompressInfo.jdField_e_of_type_JavaLangString);
  }
  
  protected void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PicContants.NEED_COMPRESS", true);
      this.jdField_b_of_type_Int = paramIntent.getIntExtra("uintype", 1003);
      this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
      this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("send_in_background", false);
      this.jdField_a_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      this.jdField_b_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE");
      this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.VIDEO_INFOS"));
      this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
      this.d = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      this.jdField_c_of_type_Int = paramIntent.getIntExtra("key_confess_topicid", 0);
      this.jdField_b_of_type_JavaUtilHashMap = ((HashMap)paramIntent.getSerializableExtra("PhotoConst.photo_send_pic_type"));
      if (this.jdField_b_of_type_JavaUtilHashMap == null) {
        this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
      }
    } while (!QLog.isColorLevel());
    QLog.d("SendPhotoTask", 2, " sendPhotoTask(),  mBusiType :" + this.jdField_a_of_type_Int + ", mNeedCompress:" + this.jdField_a_of_type_Boolean + ", mCurType:" + this.jdField_b_of_type_Int + ",mIsWaitForResult:" + this.jdField_b_of_type_Boolean + ",picQualityType: " + this.d + ",mSendBackground = " + this.jdField_c_of_type_Boolean + "mPaths :" + Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray()) + ", PhotoTypeSize:" + this.jdField_b_of_type_JavaUtilHashMap.size());
  }
  
  protected void a(BaseActivity paramBaseActivity, PicReq paramPicReq)
  {
    boolean bool1 = false;
    int i = -1;
    if ((paramBaseActivity == null) || (paramBaseActivity.app == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("SendPhotoTask", 2, "sendPhoto,activity or app is null,return!");
      }
    }
    do
    {
      return;
      if ((paramPicReq != null) && (paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SendPhotoTask", 2, "sendPhoto,sendReq is null,return!");
    return;
    a(paramBaseActivity.app, this.jdField_a_of_type_JavaLangString, paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString);
    if (paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Int == 9501)
    {
      b(paramBaseActivity, paramPicReq);
      return;
    }
    Object localObject;
    int j;
    if ((paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Int == 9500) && ((paramPicReq.jdField_a_of_type_Int == 2) || (paramPicReq.jdField_a_of_type_Int == 4)))
    {
      localObject = paramBaseActivity.getIntent();
      this.jdField_a_of_type_AndroidContentIntent.removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
      ((Intent)localObject).setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.ChatActivity");
      ((Intent)localObject).putExtra("uin", paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c);
      ((Intent)localObject).putExtra("key_confess_topicid", paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.o);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString);
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      ((Intent)localObject).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
      ((Intent)localObject).putExtra("PhotoConst.SEND_SIZE_SPEC", 2);
      ((Intent)localObject).addFlags(603979776);
      ((Intent)localObject).putExtra("param_compressInitTime", System.currentTimeMillis());
      j = ((Intent)localObject).getIntExtra(AlbumConstants.h, -1);
      if ((j != 80) && (j != 82)) {
        ((Intent)localObject).putExtra(AlbumConstants.h, 82);
      }
      paramBaseActivity.startActivityForResult((Intent)localObject, 2);
    }
    for (;;)
    {
      try
      {
        localObject = new String[this.jdField_a_of_type_JavaUtilArrayList.size()];
        this.jdField_a_of_type_JavaUtilArrayList.toArray((Object[])localObject);
        boolean bool2 = paramBaseActivity.getIntent().getBooleanExtra("PhotoConst.IS_FORWARD", false);
        if (bool2) {
          i = paramBaseActivity.getIntent().getIntExtra("forward_source_uin_type", -1);
        }
        if (paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo == null) {
          break;
        }
        j = this.jdField_b_of_type_Int;
        if (paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.h == 2) {
          bool1 = true;
        }
        StatisticConstants.a((String[])localObject, j, bool1, bool2, i, paramBaseActivity.app);
        return;
      }
      catch (Exception paramBaseActivity)
      {
        return;
      }
      a(paramPicReq, paramBaseActivity.app);
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    ((OrderMediaMsgManager)paramQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(paramString1, paramString2);
  }
  
  protected void a(CompressInfo paramCompressInfo)
  {
    RichmediaService.a(paramCompressInfo);
  }
  
  protected void a(PicReq paramPicReq, QQAppInterface paramQQAppInterface)
  {
    PicBusiManager.a(paramPicReq);
  }
  
  protected void a(List<String> paramList)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app != null)) {
      TroopGrayTipUtils.a(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app, this.jdField_a_of_type_JavaLangString, ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app.getCurrentUin(), paramList, this.jdField_b_of_type_Long);
    }
  }
  
  protected boolean a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)) != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPhotoTask", 2, "sendPhotoTask, send Video : " + paramString);
      }
      SendVideoActivity.SendVideoInfo localSendVideoInfo = (SendVideoActivity.SendVideoInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      Intent localIntent = new Intent();
      localIntent.putExtra("file_send_path", paramString);
      localIntent.putExtra("file_send_size", localSendVideoInfo.fileSize);
      localIntent.putExtra("file_send_duration", localSendVideoInfo.duration);
      localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uintype", this.jdField_b_of_type_Int);
      localIntent.putExtra("file_source", "album_flow");
      localIntent.putExtra("send_in_background", true);
      localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", this.d);
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
    CompressInfo localCompressInfo = a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentIntent);
    if (localCompressInfo == null)
    {
      QLog.e("SendPhotoTask", 2, "sendPhotoTask. compressInfo is null!");
      return false;
    }
    localCompressInfo.j = this.jdField_b_of_type_Int;
    localCompressInfo.jdField_g_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("SendPhotoTask", 2, "SendPhoto,compressInfo.uinType" + localCompressInfo.j);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendPhotoTask", 2, "sendPhotoTask, compress start.compressInfo.src = " + localCompressInfo.c);
    }
    a(localCompressInfo);
    paramPicUploadInfo.jdField_g_of_type_JavaLangString = localCompressInfo.jdField_e_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("SendPhotoTask", 2, "sendPhotoTask,  compress finish, upInfo.localPath = " + paramPicUploadInfo.jdField_g_of_type_JavaLangString);
    }
    if ((localCompressInfo.jdField_g_of_type_Int != 2) && (b(localCompressInfo.jdField_e_of_type_JavaLangString))) {
      LogTag.a();
    }
    try
    {
      paramPicUploadInfo.jdField_a_of_type_JavaUtilArrayList = a(localCompressInfo);
      if ((paramPicUploadInfo.jdField_a_of_type_JavaUtilArrayList != null) && (QLog.isColorLevel())) {
        QLog.d("peak_pgjpeg", 2, "@SendPhotoActivity.sendPhotoTask:" + paramPicUploadInfo.jdField_a_of_type_JavaUtilArrayList.toString());
      }
      LogTag.a("peak_pgjpeg", "@PeakUtils.getSliceInfos(" + localCompressInfo.jdField_e_of_type_JavaLangString + ")");
      this.jdField_c_of_type_JavaUtilArrayList.add(localCompressInfo);
      if (localCompressInfo.jdField_e_of_type_Boolean)
      {
        paramPicUploadInfo.jdField_g_of_type_Int = 1;
        Logger.a(paramPicUploadInfo, "fixProtocolType", "sendReq.upInfo.protocolType");
        return true;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("peak_pgjpeg", 2, "@OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + localCompressInfo.jdField_e_of_type_JavaLangString + "'s size is " + FileUtils.a(localCompressInfo.jdField_e_of_type_JavaLangString));
        }
      }
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("peak_pgjpeg", 2, "@ArrayIndexOutOfBoundsException occurred in PeakUtils.getSliceInfos， " + localCompressInfo.jdField_e_of_type_JavaLangString);
        }
      }
      paramPicUploadInfo.jdField_g_of_type_Int = paramPicUploadInfo.a();
    }
    return true;
  }
  
  protected boolean a(String paramString)
  {
    return !FileUtils.b(paramString);
  }
  
  protected boolean a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.PHOTO_SEND_PATH", paramString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.PHOTO_SEND_PATH_INDEX", paramInt);
    PicReq localPicReq = PicBusiManager.a(2, this.jdField_a_of_type_Int);
    localPicReq.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("KEY_MSG_FORWARD_ID", -1);
    PicUploadInfo localPicUploadInfo = a(this.jdField_a_of_type_Int);
    if (!a(localPicReq, localPicUploadInfo)) {}
    do
    {
      return false;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!a(localPicUploadInfo));
    for (;;)
    {
      a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localPicReq);
      this.jdField_b_of_type_Long = localPicUploadInfo.jdField_a_of_type_Long;
      return true;
      localPicUploadInfo.jdField_g_of_type_JavaLangString = paramString;
    }
  }
  
  protected boolean a(String paramString, Parcelable paramParcelable)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.PHOTO_SEND_PATH", paramString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.photo_send_qzone_pic_file_params", paramParcelable);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1045);
    paramString = PicBusiManager.a(2, 1045);
    paramParcelable = a(1045);
    if (!a(paramString, paramParcelable)) {
      return false;
    }
    if (paramParcelable != null) {
      paramParcelable.jdField_g_of_type_JavaLangString = null;
    }
    a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString);
    return true;
  }
  
  protected ArrayList<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_b_of_type_JavaUtilHashMap.size() > 0)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        Object localObject1 = (PhotoSendParams)this.jdField_b_of_type_JavaUtilHashMap.get(localObject2);
        if ((a((String)localObject2)) || (localObject1 == null) || (TextUtils.isEmpty(((PhotoSendParams)localObject1).rawMd5)) || (((PhotoSendParams)localObject1).fileSize <= 0L) || (TextUtils.isEmpty(((PhotoSendParams)localObject1).rawDownloadUrl)))
        {
          localObject2 = new StringBuilder().append("sendPhotoTask. path invalid, path:").append((String)localObject2).append(", params:");
          if (localObject1 != null) {}
          for (localObject1 = ((PhotoSendParams)localObject1).toString();; localObject1 = "")
          {
            QLog.e("SendPhotoTask", 2, (String)localObject1);
            break;
          }
        }
        if (a((String)localObject2, (Parcelable)localObject1))
        {
          localArrayList.add(localObject2);
          if (QLog.isColorLevel()) {
            QLog.i("SendPhotoTask", 2, "sendPhotoTask Qzone path:" + (String)localObject2 + ", photoMd5:" + ((PhotoSendParams)localObject1).rawMd5);
          }
        }
      }
    }
    return localArrayList;
  }
  
  protected void b(Intent paramIntent)
  {
    paramIntent = new SendVideoActivity.SendVideoTask((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramIntent);
    paramIntent.a();
    paramIntent.a();
  }
  
  protected void b(BaseActivity paramBaseActivity, PicReq paramPicReq)
  {
    Object localObject = (SmartDeviceProxyMgr)paramBaseActivity.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    if ((((SmartDeviceProxyMgr)localObject).c(Long.parseLong(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c))) && (((SmartDeviceProxyMgr)localObject).a(Long.parseLong(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c), 17))) {}
    for (boolean bool = true; !Boolean.valueOf(bool).booleanValue(); bool = false)
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString);
      ((DeviceMsgHandle)paramBaseActivity.app.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(DeviceMsgHandle.d, paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c, (List)localObject);
      return;
    }
    paramBaseActivity.runOnUiThread(new SendPhotoTask.1(this, (SmartDeviceProxyMgr)localObject, paramPicReq, paramBaseActivity));
  }
  
  protected boolean b(String paramString)
  {
    return PeakUtils.a(paramString);
  }
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_Long > 0L) {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSendPhotoIdleCost", false, this.jdField_a_of_type_Long, 0L, null, "");
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendPhotoTask", 2, "SendPhoto, current pid=" + Process.myPid() + "," + this.jdField_a_of_type_JavaLangRefWeakReference + ", idleCost" + this.jdField_a_of_type_Long);
    }
    long l = System.currentTimeMillis();
    if ((a(this.jdField_a_of_type_Int)) && (QFileAssistantUtils.a(this.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_b_of_type_JavaUtilArrayList == null) {
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (!this.jdField_b_of_type_JavaUtilArrayList.isEmpty())) {
      SendByFile.a(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app, this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SendPhotoTask", 2, "sendPhotoTask, mPaths.size() : " + this.jdField_a_of_type_JavaUtilArrayList.size());
      }
      ArrayList localArrayList1 = a();
      ArrayList localArrayList2 = b();
      Logger.b("PIC_TAG_COST", "launch req ", "time cost:" + (System.currentTimeMillis() - l));
      ArrayList localArrayList3 = new ArrayList();
      localArrayList3.addAll(localArrayList1);
      localArrayList3.addAll(localArrayList2);
      if (localArrayList3.size() > 0) {
        this.jdField_a_of_type_AndroidContentIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList3);
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("param_selNum", localArrayList3.size());
      if (this.d == 2)
      {
        int j = localArrayList3.size();
        if (this.jdField_a_of_type_JavaUtilHashMap != null) {
          i = this.jdField_a_of_type_JavaUtilHashMap.size();
        }
        AlbumUtil.a(j, i);
      }
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendPhotoTask
 * JD-Core Version:    0.7.0.1
 */