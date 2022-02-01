package com.tencent.mobileqq.activity.aio.photo;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class AIOImageProviderService$TroopFileObserver
  extends BizTroopObserver
{
  AIOImageProviderService$TroopFileObserver(AIOImageProviderService paramAIOImageProviderService) {}
  
  private void a(TroopFileStatusInfo paramTroopFileStatusInfo, MessageForTroopFile paramMessageForTroopFile)
  {
    boolean bool = FileUtils.fileExistsAndNotEmpty(paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString);
    String str = "";
    Object localObject2;
    if (bool)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 0, 16, 1, paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString, false);
    }
    else if (paramTroopFileStatusInfo.j != 0)
    {
      try
      {
        Object localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("errorType", "thumb_download");
        ((JSONObject)localObject1).put("errorCode", paramTroopFileStatusInfo.j);
        localObject1 = ((JSONObject)localObject1).toString();
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        localObject2 = "";
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 0, 18, 2, (String)localObject2, false);
    }
    if (FileUtils.fileExistsAndNotEmpty(paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 0, 18, 1, paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString, false);
      return;
    }
    if (paramTroopFileStatusInfo.j != 0)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("errorType", "thumb_download");
        ((JSONObject)localObject2).put("errorCode", paramTroopFileStatusInfo.j);
        paramTroopFileStatusInfo = ((JSONObject)localObject2).toString();
      }
      catch (JSONException paramTroopFileStatusInfo)
      {
        paramTroopFileStatusInfo.printStackTrace();
        paramTroopFileStatusInfo = str;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 0, 18, 2, paramTroopFileStatusInfo, false);
    }
  }
  
  private void b(TroopFileStatusInfo paramTroopFileStatusInfo, MessageForTroopFile paramMessageForTroopFile)
  {
    if (AIOImageProviderService.a(this.a, paramMessageForTroopFile))
    {
      if ((paramTroopFileStatusInfo.b == 8) && (paramTroopFileStatusInfo.jdField_c_of_type_Long > 0L))
      {
        int i = (int)((float)paramTroopFileStatusInfo.jdField_d_of_type_Long / (float)paramTroopFileStatusInfo.jdField_c_of_type_Long * 10000.0F);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 0, 1, i, paramTroopFileStatusInfo.jdField_c_of_type_Long, true);
        return;
      }
      if (paramTroopFileStatusInfo.b == 11)
      {
        if (this.a.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramMessageForTroopFile.uniseq)))
        {
          Context localContext = BaseApplicationImpl.sApplication.getBaseContext();
          if (localContext != null) {
            FileManagerUtil.a(localContext, paramTroopFileStatusInfo.a);
          } else {
            QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file save album].");
          }
          this.a.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramMessageForTroopFile.uniseq));
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 1, 269484034, 1, paramTroopFileStatusInfo.a, false);
        return;
      }
      if ((paramTroopFileStatusInfo.b == 12) || (paramTroopFileStatusInfo.b == 10)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 0, 269484034, 2, paramTroopFileStatusInfo.a, false);
      }
    }
    else
    {
      if (paramMessageForTroopFile.isPause)
      {
        if (QLog.isDevelopLevel())
        {
          paramMessageForTroopFile = new StringBuilder();
          paramMessageForTroopFile.append("troopFilemsg Pauseed, return! current Status:");
          paramMessageForTroopFile.append(paramTroopFileStatusInfo.b);
          QLog.i("TroopStatusDebug", 1, paramMessageForTroopFile.toString());
        }
        return;
      }
      if ((paramTroopFileStatusInfo.b == 8) && (paramTroopFileStatusInfo.jdField_c_of_type_Long > 0L))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 0, 20, (int)(paramTroopFileStatusInfo.jdField_d_of_type_Long * 10000L / paramTroopFileStatusInfo.jdField_c_of_type_Long), paramMessageForTroopFile.fileSize, true);
        return;
      }
      if (paramTroopFileStatusInfo.b == 11)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 0, 20, 1, paramTroopFileStatusInfo.a, false);
        return;
      }
      if ((paramTroopFileStatusInfo.b == 12) || (paramTroopFileStatusInfo.b == 10)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 0, 20, 2, "TroopFileError", false);
      }
    }
  }
  
  protected void a(Object paramObject)
  {
    TroopFileStatusInfo localTroopFileStatusInfo = (TroopFileStatusInfo)paramObject;
    if (localTroopFileStatusInfo != null) {
      paramObject = AIOImageProviderService.a(this.a, localTroopFileStatusInfo.e);
    } else {
      paramObject = null;
    }
    if ((localTroopFileStatusInfo != null) && (paramObject != null))
    {
      if (!paramObject.url.equals(localTroopFileStatusInfo.e))
      {
        paramObject = new StringBuilder();
        paramObject.append("OnFileTransferProgress: error, file info not match message. fileId[");
        paramObject.append(localTroopFileStatusInfo.e);
        paramObject.append("]");
        QLog.i("AIOImageProviderService", 2, paramObject.toString());
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack == null)
      {
        QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, callback is null.");
        return;
      }
      a(localTroopFileStatusInfo, paramObject);
      b(localTroopFileStatusInfo, paramObject);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTroopFileStatusUpdate: error, info[");
    localStringBuilder.append(localTroopFileStatusInfo);
    localStringBuilder.append("] troopFileMsg[");
    localStringBuilder.append(paramObject);
    localStringBuilder.append("]");
    QLog.i("AIOImageProviderService", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.TroopFileObserver
 * JD-Core Version:    0.7.0.1
 */