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
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  Intent jdField_a_of_type_AndroidContentIntent;
  Handler jdField_a_of_type_AndroidOsHandler = null;
  public String a;
  WeakReference<BaseActivity> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  HashMap<Integer, SendVideoInfo> jdField_a_of_type_JavaUtilHashMap;
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
      paramBaseActivity = this.jdField_a_of_type_JavaUtilArrayList;
      if ((paramBaseActivity == null) || (paramBaseActivity.isEmpty()))
      {
        paramBaseActivity = this.jdField_b_of_type_JavaUtilHashMap;
        if ((paramBaseActivity == null) || (paramBaseActivity.isEmpty()))
        {
          paramBaseActivity = this.jdField_b_of_type_JavaUtilArrayList;
          if ((paramBaseActivity == null) || (paramBaseActivity.isEmpty())) {
            break label155;
          }
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      label155:
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    }
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
    return ((IPicBus)QRoute.api(IPicBus.class)).createCompressInfo(paramInt, paramIntent);
  }
  
  PicUploadInfo a(int paramInt)
  {
    return ((IPicBus)QRoute.api(IPicBus.class)).createPicUploadInfo(paramInt, this.jdField_a_of_type_AndroidContentIntent);
  }
  
  protected ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      StringBuilder localStringBuilder;
      if (a((String)localObject))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sendPhotoTask. path invalid,path:");
        localStringBuilder.append((String)localObject);
        QLog.e("SendPhotoTask", 2, localStringBuilder.toString());
      }
      else if ((!a(i, (String)localObject)) && (!a()) && (a((String)localObject, i)))
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
      i += 1;
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
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendPhotoTask", 2, new Object[] { "sendPhotoTask,  mSendPaths size=", Integer.valueOf(localArrayList.size()) });
    }
    return localArrayList;
  }
  
  protected ArrayList<Integer> a(CompressInfo paramCompressInfo)
  {
    return ((IPicUtil)QRoute.api(IPicUtil.class)).getSliceInfos(paramCompressInfo.jdField_e_of_type_JavaLangString);
  }
  
  protected void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
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
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append(" sendPhotoTask(),  mBusiType :");
      paramIntent.append(this.jdField_a_of_type_Int);
      paramIntent.append(", mNeedCompress:");
      paramIntent.append(this.jdField_a_of_type_Boolean);
      paramIntent.append(", mCurType:");
      paramIntent.append(this.jdField_b_of_type_Int);
      paramIntent.append(",mIsWaitForResult:");
      paramIntent.append(this.jdField_b_of_type_Boolean);
      paramIntent.append(",picQualityType: ");
      paramIntent.append(this.d);
      paramIntent.append(",mSendBackground = ");
      paramIntent.append(this.jdField_c_of_type_Boolean);
      paramIntent.append("mPaths :");
      paramIntent.append(Arrays.toString(this.jdField_a_of_type_JavaUtilArrayList.toArray()));
      paramIntent.append(", PhotoTypeSize:");
      paramIntent.append(this.jdField_b_of_type_JavaUtilHashMap.size());
      QLog.d("SendPhotoTask", 2, paramIntent.toString());
    }
  }
  
  protected void a(BaseActivity paramBaseActivity, PicReq paramPicReq)
  {
    Object localObject;
    int i;
    if ((paramBaseActivity != null) && (paramBaseActivity.app != null)) {
      if ((paramPicReq != null) && (paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo != null))
      {
        a(paramBaseActivity.app, this.jdField_a_of_type_JavaLangString, paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString);
        if (paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Int == 9501)
        {
          b(paramBaseActivity, paramPicReq);
          return;
        }
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
          i = ((Intent)localObject).getIntExtra(AlbumConstants.h, -1);
          if ((i != 80) && (i != 82)) {
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
        localObject = new String[this.jdField_a_of_type_JavaUtilArrayList.size()];
        this.jdField_a_of_type_JavaUtilArrayList.toArray((Object[])localObject);
        boolean bool2 = paramBaseActivity.getIntent().getBooleanExtra("PhotoConst.IS_FORWARD", false);
        if (!bool2) {
          break label423;
        }
        i = paramBaseActivity.getIntent().getIntExtra("forward_source_uin_type", -1);
        if (paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo != null)
        {
          int j = this.jdField_b_of_type_Int;
          if (paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.h != 2) {
            break label428;
          }
          bool1 = true;
          StatisticConstants.a((String[])localObject, j, bool1, bool2, i, paramBaseActivity.app);
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
      label423:
      i = -1;
      continue;
      label428:
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
    if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app != null)) {
      TroopGrayTipUtils.a(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app, this.jdField_a_of_type_JavaLangString, ((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app.getCurrentUin(), paramList, this.jdField_b_of_type_Long);
    }
  }
  
  protected boolean a(int paramInt, String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if ((localObject != null) && (((HashMap)localObject).get(Integer.valueOf(paramInt)) != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sendPhotoTask, send Video : ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("SendPhotoTask", 2, ((StringBuilder)localObject).toString());
      }
      localObject = (SendVideoInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      Intent localIntent = new Intent();
      localIntent.putExtra("file_send_path", paramString);
      localIntent.putExtra("file_send_size", ((SendVideoInfo)localObject).fileSize);
      localIntent.putExtra("file_send_duration", ((SendVideoInfo)localObject).duration);
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
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("SendPhoto,compressInfo.uinType");
      localStringBuilder.append(localCompressInfo.j);
      QLog.d("SendPhotoTask", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendPhotoTask, compress start.compressInfo.src = ");
      localStringBuilder.append(localCompressInfo.c);
      QLog.d("SendPhotoTask", 2, localStringBuilder.toString());
    }
    a(localCompressInfo);
    paramPicUploadInfo.jdField_g_of_type_JavaLangString = localCompressInfo.jdField_e_of_type_JavaLangString;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendPhotoTask,  compress finish, upInfo.localPath = ");
      localStringBuilder.append(paramPicUploadInfo.jdField_g_of_type_JavaLangString);
      QLog.d("SendPhotoTask", 2, localStringBuilder.toString());
    }
    if ((localCompressInfo.jdField_g_of_type_Int != 2) && (b(localCompressInfo.jdField_e_of_type_JavaLangString))) {
      LogTag.a();
    }
    try
    {
      paramPicUploadInfo.jdField_a_of_type_JavaUtilArrayList = a(localCompressInfo);
      if ((paramPicUploadInfo.jdField_a_of_type_JavaUtilArrayList == null) || (!QLog.isColorLevel())) {
        break label370;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("@SendPhotoActivity.sendPhotoTask:");
      localStringBuilder.append(paramPicUploadInfo.jdField_a_of_type_JavaUtilArrayList.toString());
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
      localStringBuilder.append(localCompressInfo.jdField_e_of_type_JavaLangString);
      QLog.w("peak_pgjpeg", 2, localStringBuilder.toString());
      break label370;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("@OutOfMemoryError occurred in PeakUtils.getSliceInfos， ");
        localStringBuilder.append(localCompressInfo.jdField_e_of_type_JavaLangString);
        localStringBuilder.append("'s size is ");
        localStringBuilder.append(FileUtils.getFileSizes(localCompressInfo.jdField_e_of_type_JavaLangString));
        QLog.w("peak_pgjpeg", 2, localStringBuilder.toString());
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("@PeakUtils.getSliceInfos(");
    localStringBuilder.append(localCompressInfo.jdField_e_of_type_JavaLangString);
    localStringBuilder.append(")");
    LogTag.a("peak_pgjpeg", localStringBuilder.toString());
    this.jdField_c_of_type_JavaUtilArrayList.add(localCompressInfo);
    if (localCompressInfo.jdField_e_of_type_Boolean)
    {
      paramPicUploadInfo.jdField_g_of_type_Int = 1;
      Logger.a(paramPicUploadInfo, "fixProtocolType", "sendReq.upInfo.protocolType");
      return true;
    }
    paramPicUploadInfo.jdField_g_of_type_Int = paramPicUploadInfo.a();
    return true;
  }
  
  protected boolean a(String paramString)
  {
    return FileUtils.fileExistsAndNotEmpty(paramString) ^ true;
  }
  
  protected boolean a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.PHOTO_SEND_PATH", paramString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.PHOTO_SEND_PATH_INDEX", paramInt);
    PicReq localPicReq = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(2, this.jdField_a_of_type_Int);
    localPicReq.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("KEY_MSG_FORWARD_ID", -1);
    PicUploadInfo localPicUploadInfo = a(this.jdField_a_of_type_Int);
    if (!a(localPicReq, localPicUploadInfo)) {
      return false;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (!a(localPicUploadInfo)) {
        return false;
      }
    }
    else {
      localPicUploadInfo.jdField_g_of_type_JavaLangString = paramString;
    }
    a((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localPicReq);
    this.jdField_b_of_type_Long = localPicUploadInfo.jdField_a_of_type_Long;
    return true;
  }
  
  protected boolean a(String paramString, Parcelable paramParcelable)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.PHOTO_SEND_PATH", paramString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.photo_send_qzone_pic_file_params", paramParcelable);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1045);
    paramString = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(2, 1045);
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
        String str = (String)localIterator.next();
        PhotoSendParams localPhotoSendParams = (PhotoSendParams)this.jdField_b_of_type_JavaUtilHashMap.get(str);
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
  
  protected void b(Intent paramIntent)
  {
    paramIntent = new SendVideoTask((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramIntent);
    paramIntent.a();
    paramIntent.a();
  }
  
  protected void b(BaseActivity paramBaseActivity, PicReq paramPicReq)
  {
    Object localObject = (SmartDeviceProxyMgr)paramBaseActivity.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    boolean bool;
    if ((((SmartDeviceProxyMgr)localObject).c(Long.parseLong(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c))) && (((SmartDeviceProxyMgr)localObject).a(Long.parseLong(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c), 17))) {
      bool = true;
    } else {
      bool = false;
    }
    if (!Boolean.valueOf(bool).booleanValue())
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
    return ((IPicUtil)QRoute.api(IPicUtil.class)).isProgressiveJpeg(paramString);
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Long > 0L) {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSendPhotoIdleCost", false, this.jdField_a_of_type_Long, 0L, null, "");
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("SendPhoto, current pid=");
      ((StringBuilder)localObject1).append(Process.myPid());
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangRefWeakReference);
      ((StringBuilder)localObject1).append(", idleCost");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
      QLog.d("SendPhotoTask", 2, ((StringBuilder)localObject1).toString());
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
    Object localObject1 = this.jdField_b_of_type_JavaUtilArrayList;
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())) {
      SendByFile.a(((BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app, this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidOsHandler;
      if (localObject1 != null) {
        ((Handler)localObject1).sendEmptyMessage(2);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sendPhotoTask, mPaths.size() : ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilArrayList.size());
      QLog.d("SendPhotoTask", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = a();
    ArrayList localArrayList = b();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("time cost:");
    ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
    Logger.b("PIC_TAG_COST", "launch req ", ((StringBuilder)localObject2).toString());
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).addAll((Collection)localObject1);
    ((ArrayList)localObject2).addAll(localArrayList);
    if (((ArrayList)localObject2).size() > 0) {
      this.jdField_a_of_type_AndroidContentIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
    }
    this.jdField_a_of_type_AndroidContentIntent.putExtra("param_selNum", ((ArrayList)localObject2).size());
    if (this.d == 2)
    {
      int j = ((ArrayList)localObject2).size();
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
      int i;
      if (localObject1 != null) {
        i = ((HashMap)localObject1).size();
      } else {
        i = 0;
      }
      AlbumUtil.a(j, i);
    }
    localObject1 = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject1 != null) {
      ((Handler)localObject1).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SendPhotoTask
 * JD-Core Version:    0.7.0.1
 */