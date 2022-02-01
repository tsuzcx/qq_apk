package com.tencent.device.file;

import android.content.Intent;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.StringUtil;
import mqq.os.MqqHandler;

public class DevLittleVideoOperator
  extends BaseShortVideoOprerator
{
  public DevLittleVideoOperator() {}
  
  public DevLittleVideoOperator(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public MessageRecord a(ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    return null;
  }
  
  public MessageRecord a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    long l = System.currentTimeMillis();
    MessageForDevLittleVideo localMessageForDevLittleVideo = MessageRecordFactory.a(this.a, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_d_of_type_JavaLangString, paramShortVideoUploadInfo.b);
    localMessageForDevLittleVideo.videoFileName = paramShortVideoUploadInfo.h;
    if (paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString == null) {
      paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForDevLittleVideo.uuid = paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString;
    if (paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString == null) {
      paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForDevLittleVideo.mediacodecEncode = paramShortVideoUploadInfo.jdField_d_of_type_Boolean;
    localMessageForDevLittleVideo.md5 = paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString;
    localMessageForDevLittleVideo.videoFileFormat = 2;
    localMessageForDevLittleVideo.videoFileSize = paramShortVideoUploadInfo.jdField_e_of_type_Int;
    localMessageForDevLittleVideo.videoFileTime = paramShortVideoUploadInfo.f;
    localMessageForDevLittleVideo.thumbWidth = paramShortVideoUploadInfo.jdField_c_of_type_Int;
    localMessageForDevLittleVideo.thumbHeight = paramShortVideoUploadInfo.jdField_d_of_type_Int;
    localMessageForDevLittleVideo.mThumbFilePath = paramShortVideoUploadInfo.j;
    localMessageForDevLittleVideo.mVideoFileSourceDir = paramShortVideoUploadInfo.k;
    localMessageForDevLittleVideo.videoFileStatus = 1001;
    localMessageForDevLittleVideo.videoFileProgress = 0;
    localMessageForDevLittleVideo.extraflag = 32772;
    localMessageForDevLittleVideo.thumbMD5 = paramShortVideoUploadInfo.jdField_g_of_type_JavaLangString;
    if (paramShortVideoUploadInfo.l == null) {
      paramShortVideoUploadInfo.l = "";
    }
    localMessageForDevLittleVideo.fileSource = paramShortVideoUploadInfo.l;
    localMessageForDevLittleVideo.lastModified = 0L;
    localMessageForDevLittleVideo.issend = 1;
    localMessageForDevLittleVideo.uiOperatorFlag = 1;
    localMessageForDevLittleVideo.msg = HardCodeUtil.a(2131703272);
    localMessageForDevLittleVideo.serial();
    paramShortVideoUploadInfo.jdField_a_of_type_Long = localMessageForDevLittleVideo.uniseq;
    Logger.a(this.jdField_g_of_type_JavaLangString, this.f, "packmsg", "cost:" + (System.currentTimeMillis() - l));
    Logger.a(this.jdField_g_of_type_JavaLangString, this.f, "packMsg", "mr: " + localMessageForDevLittleVideo.toLogString() + "-" + localMessageForDevLittleVideo.toString());
    return localMessageForDevLittleVideo;
  }
  
  public ShortVideoForwardInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    return null;
  }
  
  public ShortVideoUploadInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    if (paramObject == null)
    {
      Logger.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "unknow obj");
      return null;
    }
    String str7 = "0";
    String str6 = "0";
    int m = 0;
    long l = 0L;
    int k = 0;
    String str5 = "";
    String str4 = "";
    Object localObject = "";
    String str3 = "";
    boolean bool = false;
    int j = 0;
    int i = 0;
    String str2 = "";
    String str1 = "";
    if ((paramObject instanceof Intent))
    {
      localObject = (Intent)paramObject;
      str7 = ((Intent)localObject).getStringExtra("uin");
      str6 = ((Intent)localObject).getStringExtra("troop_uin");
      m = ((Intent)localObject).getIntExtra("uintype", 1003);
      l = ((Intent)localObject).getLongExtra("file_send_size", 0L);
      ((Intent)localObject).getIntExtra("file_send_business_type", -1);
      k = ((Intent)localObject).getIntExtra("file_send_duration", -1);
      str5 = ((Intent)localObject).getStringExtra("file_send_path");
      str4 = ((Intent)localObject).getStringExtra("thumbfile_send_path");
      str3 = ((Intent)localObject).getStringExtra("file_shortvideo_md5");
      bool = ((Intent)localObject).getBooleanExtra("mediacodec_encode_enable", false);
      j = ((Intent)localObject).getIntExtra("thumbfile_send_width", 0);
      i = ((Intent)localObject).getIntExtra("thumbfile_send_height", 0);
      str2 = ((Intent)localObject).getStringExtra("thumbfile_md5");
      str1 = ((Intent)localObject).getStringExtra("file_source");
      localObject = ((Intent)localObject).getStringExtra("file_video_source_dir");
    }
    for (;;)
    {
      ShortVideoUploadInfo localShortVideoUploadInfo = new ShortVideoUploadInfo();
      localShortVideoUploadInfo.jdField_c_of_type_JavaLangString = str7;
      localShortVideoUploadInfo.h = str5;
      localShortVideoUploadInfo.j = str4;
      localShortVideoUploadInfo.b = m;
      localShortVideoUploadInfo.jdField_d_of_type_JavaLangString = str6;
      localShortVideoUploadInfo.jdField_e_of_type_Int = ((int)l);
      localShortVideoUploadInfo.f = k;
      localShortVideoUploadInfo.jdField_e_of_type_JavaLangString = str3;
      localShortVideoUploadInfo.jdField_d_of_type_Boolean = bool;
      localShortVideoUploadInfo.jdField_c_of_type_Int = j;
      localShortVideoUploadInfo.jdField_d_of_type_Int = i;
      localShortVideoUploadInfo.jdField_g_of_type_Int = paramShortVideoReq.a;
      localShortVideoUploadInfo.jdField_a_of_type_JavaLangObject = paramObject;
      localShortVideoUploadInfo.jdField_g_of_type_JavaLangString = str2;
      localShortVideoUploadInfo.l = str1;
      localShortVideoUploadInfo.k = ((String)localObject);
      Logger.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "");
      return localShortVideoUploadInfo;
      if ((paramObject instanceof MessageForDevLittleVideo))
      {
        localObject = (MessageForShortVideo)paramObject;
        str7 = ((MessageForShortVideo)localObject).frienduin;
        str6 = ((MessageForShortVideo)localObject).frienduin;
        m = ((MessageForShortVideo)localObject).istroop;
        l = ((MessageForShortVideo)localObject).videoFileSize;
        k = ((MessageForShortVideo)localObject).videoFileTime;
        str5 = ((MessageForShortVideo)localObject).videoFileName;
        str4 = ShortVideoUtils.getShortVideoThumbPicPath(((MessageForShortVideo)localObject).thumbMD5, "jpg");
        str3 = ((MessageForShortVideo)localObject).md5;
        bool = ((MessageForShortVideo)localObject).mediacodecEncode;
        j = ((MessageForShortVideo)localObject).thumbWidth;
        i = ((MessageForShortVideo)localObject).thumbHeight;
        str2 = ((MessageForShortVideo)localObject).thumbMD5;
        str1 = ((MessageForShortVideo)localObject).fileSource;
        localObject = ((MessageForShortVideo)localObject).mVideoFileSourceDir;
      }
    }
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    Logger.a(this.jdField_g_of_type_JavaLangString, this.f, "sendPic.start", "");
    ThreadManager.getSubThreadHandler().post(new DevLittleVideoOperator.1(this, paramShortVideoUploadInfo));
  }
  
  boolean a(String paramString)
  {
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    DeviceInfo localDeviceInfo = localSmartDeviceProxyMgr.a(Long.parseLong(paramString));
    if (localDeviceInfo == null) {
      return false;
    }
    if (localSmartDeviceProxyMgr.a(Long.parseLong(paramString)).booleanValue()) {
      return true;
    }
    if (localDeviceInfo.SSOBid_Platform == 1027) {
      return true;
    }
    if ((localDeviceInfo.SSOBid_Platform == 0) && (localDeviceInfo.SSOBid_Version.equals(""))) {
      return true;
    }
    paramString = localDeviceInfo.SSOBid_Version;
    return (!StringUtil.a(paramString)) && (Double.valueOf(paramString).doubleValue() >= 1.3D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.file.DevLittleVideoOperator
 * JD-Core Version:    0.7.0.1
 */