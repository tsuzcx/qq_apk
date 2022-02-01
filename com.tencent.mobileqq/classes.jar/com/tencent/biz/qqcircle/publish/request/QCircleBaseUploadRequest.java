package com.tencent.biz.qqcircle.publish.request;

import FileUpload.PicExtendInfo;
import NS_MOBILE_OPERATION.LbsInfo;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AppSetting;
import com.tencent.biz.qcircleshadow.lib.variation.HostSecUtil;
import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.biz.qqcircle.publish.publishconst.QzoneUploadConst;
import com.tencent.biz.qqcircle.publish.request.provider.UploadFlowMsgProvider;
import com.tencent.biz.qqcircle.publish.util.ExtendExifInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.IUploadTaskManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.model.LocalImageShootInfo;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class QCircleBaseUploadRequest
  extends QCircleRequest
  implements UploadFlowMsgProvider
{
  public String a;
  public String b;
  
  public QCircleBaseUploadRequest() {}
  
  public QCircleBaseUploadRequest(String paramString)
  {
    super(paramString);
  }
  
  protected int a(int paramInt, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder();
    paramString.append(str);
    paramString.append(String.valueOf(paramInt));
    return paramInt + paramString.toString().hashCode();
  }
  
  protected String a(ExtendExifInterface paramExtendExifInterface, String paramString)
  {
    paramExtendExifInterface = paramExtendExifInterface.getAttribute("DateTime");
    StringBuilder localStringBuilder;
    if (paramExtendExifInterface == null)
    {
      paramExtendExifInterface = String.valueOf(new File(paramString).lastModified());
      if (QLog.isColorLevel())
      {
        paramString = this.m;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("exif is null, get dateString:");
        localStringBuilder.append(paramExtendExifInterface);
        QLog.d(paramString, 2, localStringBuilder.toString());
      }
      if (paramExtendExifInterface.equals("0")) {
        return "";
      }
      paramExtendExifInterface = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date(Long.parseLong(paramExtendExifInterface)));
      if (paramExtendExifInterface != null)
      {
        if (QLog.isColorLevel())
        {
          paramString = this.m;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("dateString:");
          localStringBuilder.append(paramExtendExifInterface);
          QLog.d(paramString, 2, localStringBuilder.toString());
        }
        return paramExtendExifInterface;
      }
      return "";
    }
    if (QLog.isColorLevel())
    {
      paramString = this.m;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("exif :");
      localStringBuilder.append(paramExtendExifInterface);
      QLog.d(paramString, 2, localStringBuilder.toString());
    }
    return paramExtendExifInterface;
  }
  
  protected String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return HostSecUtil.getFileMd5(paramString);
    }
    return null;
  }
  
  protected void a(ImageUploadTask paramImageUploadTask)
  {
    if (paramImageUploadTask.stExtendInfo.mapParams != null)
    {
      localObject = LocalImageShootInfo.createFrom(paramImageUploadTask.uploadFilePath);
      if (localObject == null) {
        return;
      }
      LbsInfo localLbsInfo = LbsDataV2.parceToLbsInfo((LocalImageShootInfo)localObject);
      if (localLbsInfo != null)
      {
        if (localLbsInfo.lbs_x != null) {
          paramImageUploadTask.stExtendInfo.mapParams.put("geo_x", String.valueOf(localLbsInfo.lbs_x));
        }
        if (localLbsInfo.lbs_y != null) {
          paramImageUploadTask.stExtendInfo.mapParams.put("geo_y", String.valueOf(localLbsInfo.lbs_y));
        }
      }
      if (((LocalImageShootInfo)localObject).captureTime <= 0L) {}
    }
    try
    {
      localObject = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date(((LocalImageShootInfo)localObject).captureTime));
    }
    catch (Exception localException)
    {
      label126:
      break label126;
    }
    Object localObject = "";
    if (localObject != null) {
      paramImageUploadTask.stExtendInfo.mapParams.put("Exif_Time", localObject);
    }
  }
  
  protected void a(ImageUploadTask paramImageUploadTask, GpsInfo4LocalImage paramGpsInfo4LocalImage)
  {
    if ((paramImageUploadTask != null) && (paramImageUploadTask.stExtendInfo != null) && (paramImageUploadTask.stExtendInfo.mapParams != null) && (paramGpsInfo4LocalImage != null))
    {
      paramImageUploadTask.stExtendInfo.mapParams.put("geo_x", String.valueOf(paramGpsInfo4LocalImage.longtitude));
      paramImageUploadTask.stExtendInfo.mapParams.put("geo_y", String.valueOf(paramGpsInfo4LocalImage.latitude));
    }
  }
  
  protected void a(ImageUploadTask paramImageUploadTask, String paramString)
  {
    long l;
    if ((paramImageUploadTask != null) && (paramImageUploadTask.stExtendInfo != null) && (paramImageUploadTask.stExtendInfo.mapParams != null))
    {
      l = new File(paramString).lastModified();
      if (l <= 0L) {}
    }
    try
    {
      paramString = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date(l));
    }
    catch (Exception paramString)
    {
      label63:
      break label63;
    }
    paramString = "";
    if (paramString != null) {
      paramImageUploadTask.stExtendInfo.mapParams.put("Exif_Time", paramString);
    }
  }
  
  protected void a(ImageUploadTask paramImageUploadTask, Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if (paramImageUploadTask.stExtendInfo.mapParams != null)
      {
        if (paramMap.get("geo_x") != null) {
          paramImageUploadTask.stExtendInfo.mapParams.put("geo_x", paramMap.get("geo_x"));
        }
        if (paramMap.get("geo_y") != null) {
          paramImageUploadTask.stExtendInfo.mapParams.put("geo_y", paramMap.get("geo_y"));
        }
        if (paramMap.get("geo_id") != null) {
          paramImageUploadTask.stExtendInfo.mapParams.put("geo_id", paramMap.get("geo_id"));
        }
        if (paramMap.get("geo_idname") != null) {
          paramImageUploadTask.stExtendInfo.mapParams.put("geo_idname", paramMap.get("geo_idname"));
        }
        if (paramMap.get("geo_name") != null) {
          paramImageUploadTask.stExtendInfo.mapParams.put("geo_name", paramMap.get("geo_name"));
        }
        if (paramMap.get("shoottime") != null) {
          paramImageUploadTask.stExtendInfo.mapParams.put("Exif_Time", paramMap.get("shoottime"));
        }
      }
      if (paramImageUploadTask.stExternalMapExt == null) {
        paramImageUploadTask.stExternalMapExt = new HashMap();
      }
      if (paramMap.get("jump_type") != null) {
        paramImageUploadTask.stExternalMapExt.put("jump_type", paramMap.get("jump_type"));
      }
      if (paramMap.get("jump_id") != null) {
        paramImageUploadTask.stExternalMapExt.put("jump_id", paramMap.get("jump_id"));
      }
    }
  }
  
  public abstract void a(byte[] paramArrayOfByte);
  
  public boolean a()
  {
    return false;
  }
  
  protected boolean a(AbstractUploadTask paramAbstractUploadTask)
  {
    if (QCircleHostConstants._AppSetting.isDebugVersion())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("UPWAY = ");
      ((StringBuilder)localObject1).append(paramAbstractUploadTask.uploadEntrance);
      ((StringBuilder)localObject1).append(",refer = ");
      ((StringBuilder)localObject1).append(e());
      localObject1 = ((StringBuilder)localObject1).toString();
      QLog.i(this.m, 1, (String)localObject1);
    }
    if ((LoginData.a().e() != null) && (paramAbstractUploadTask.vLoginData != null) && (paramAbstractUploadTask.vLoginData.length != 0))
    {
      localObject1 = new HashMap();
      if (!TextUtils.isEmpty(this.b)) {
        ((HashMap)localObject1).put("task_state", this.b);
      }
      this.a = e();
      if (!TextUtils.isEmpty(this.a)) {
        ((HashMap)localObject1).put("business_refer", this.a);
      }
      if (!TextUtils.isEmpty(this.a)) {
        paramAbstractUploadTask.uiRefer = this.a;
      }
      paramAbstractUploadTask.transferData = ((Map)localObject1);
      if (paramAbstractUploadTask.flowId == 0)
      {
        paramAbstractUploadTask.flowId = a(0, paramAbstractUploadTask.getFilePath());
        localObject1 = this.m;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("validAndUpload reset task flowId to ");
        ((StringBuilder)localObject2).append(paramAbstractUploadTask.flowId);
        QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      int i = b(paramAbstractUploadTask);
      if (i != 0)
      {
        localObject1 = QzoneUploadConst.a(i);
        localObject2 = this.m;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.m);
        localStringBuilder.append(" check not pass errMsg:");
        localStringBuilder.append((String)localObject1);
        QLog.w((String)localObject2, 1, localStringBuilder.toString());
        paramAbstractUploadTask.uploadTaskCallback.onUploadError(paramAbstractUploadTask, i, (String)localObject1);
        return false;
      }
      paramAbstractUploadTask.transferData.put("task_state", "running_task");
      boolean bool = ((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).upload(paramAbstractUploadTask);
      localObject1 = this.m;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.m);
      ((StringBuilder)localObject2).append(", submit upload SDK succeed ? : ");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(", flowId:");
      ((StringBuilder)localObject2).append(paramAbstractUploadTask.flowId);
      ((StringBuilder)localObject2).append(", path:");
      ((StringBuilder)localObject2).append(paramAbstractUploadTask.uploadFilePath);
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return true;
    }
    Object localObject1 = this.m;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.m);
    ((StringBuilder)localObject2).append(" no login, stop upload");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    paramAbstractUploadTask.uploadTaskCallback.onUploadError(paramAbstractUploadTask, 1705, QzoneUploadConst.a(1705));
    return false;
  }
  
  protected int b(AbstractUploadTask paramAbstractUploadTask)
  {
    paramAbstractUploadTask = paramAbstractUploadTask.uploadFilePath;
    if (TextUtils.isEmpty(paramAbstractUploadTask))
    {
      paramAbstractUploadTask = this.m;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.m);
      ((StringBuilder)localObject).append("file length:0");
      QLog.w(paramAbstractUploadTask, 1, ((StringBuilder)localObject).toString());
      return 1700;
    }
    Object localObject = new File(paramAbstractUploadTask);
    if ((((File)localObject).exists()) && (((File)localObject).length() != 0L) && (!((File)localObject).isDirectory())) {
      return 0;
    }
    String str = this.m;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.m);
    localStringBuilder.append(" checkValidValue filepath=");
    localStringBuilder.append(paramAbstractUploadTask);
    localStringBuilder.append(" fileExist:");
    localStringBuilder.append(((File)localObject).exists());
    localStringBuilder.append(" fileLen:");
    localStringBuilder.append(((File)localObject).length());
    QLog.w(str, 1, localStringBuilder.toString());
    return 1700;
  }
  
  protected GpsInfo4LocalImage b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    paramString = LocalImageShootInfo.getGpsInfoForVideo(localMediaMetadataRetriever, paramString);
    localMediaMetadataRetriever.release();
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.request.QCircleBaseUploadRequest
 * JD-Core Version:    0.7.0.1
 */