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
    if (FileUtils.b(paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 0, 16, 1, paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString, false);
    }
    label157:
    do
    {
      for (;;)
      {
        if (!FileUtils.b(paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString)) {
          break label157;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 0, 18, 1, paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString, false);
        return;
        if (paramTroopFileStatusInfo.j != 0) {
          localObject1 = "";
        }
        try
        {
          Object localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("errorType", "thumb_download");
          ((JSONObject)localObject2).put("errorCode", paramTroopFileStatusInfo.j);
          localObject2 = ((JSONObject)localObject2).toString();
          localObject1 = localObject2;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 0, 18, 2, (String)localObject1, false);
      }
    } while (paramTroopFileStatusInfo.j == 0);
    Object localObject1 = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("errorType", "thumb_download");
      localJSONObject.put("errorCode", paramTroopFileStatusInfo.j);
      paramTroopFileStatusInfo = localJSONObject.toString();
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 0, 18, 2, paramTroopFileStatusInfo, false);
      return;
    }
    catch (JSONException paramTroopFileStatusInfo)
    {
      for (;;)
      {
        paramTroopFileStatusInfo.printStackTrace();
        paramTroopFileStatusInfo = (TroopFileStatusInfo)localObject1;
      }
    }
  }
  
  private void b(TroopFileStatusInfo paramTroopFileStatusInfo, MessageForTroopFile paramMessageForTroopFile)
  {
    if (AIOImageProviderService.a(this.a, paramMessageForTroopFile)) {
      if ((paramTroopFileStatusInfo.b == 8) && (paramTroopFileStatusInfo.jdField_c_of_type_Long > 0L))
      {
        int i = (int)((float)paramTroopFileStatusInfo.jdField_d_of_type_Long / (float)paramTroopFileStatusInfo.jdField_c_of_type_Long * 10000.0F);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 0, 1, i, paramTroopFileStatusInfo.jdField_c_of_type_Long, true);
      }
    }
    label165:
    do
    {
      do
      {
        do
        {
          return;
          if (paramTroopFileStatusInfo.b == 11)
          {
            if (this.a.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramMessageForTroopFile.uniseq)))
            {
              Context localContext = BaseApplicationImpl.sApplication.getBaseContext();
              if (localContext == null) {
                break label165;
              }
              FileManagerUtil.a(localContext, paramTroopFileStatusInfo.a);
            }
            for (;;)
            {
              this.a.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramMessageForTroopFile.uniseq));
              this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 1, 269484034, 1, paramTroopFileStatusInfo.a, false);
              return;
              QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file save album].");
            }
          }
        } while ((paramTroopFileStatusInfo.b != 12) && (paramTroopFileStatusInfo.b != 10));
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 0, 269484034, 2, paramTroopFileStatusInfo.a, false);
        return;
        if (!paramMessageForTroopFile.isPause) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("TroopStatusDebug", 1, "troopFilemsg Pauseed, return! current Status:" + paramTroopFileStatusInfo.b);
      return;
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
    } while ((paramTroopFileStatusInfo.b != 12) && (paramTroopFileStatusInfo.b != 10));
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(paramMessageForTroopFile.uniseq, 0, 20, 2, "TroopFileError", false);
  }
  
  public void onTroopFileStatusUpdate(Object paramObject)
  {
    TroopFileStatusInfo localTroopFileStatusInfo = (TroopFileStatusInfo)paramObject;
    paramObject = null;
    if (localTroopFileStatusInfo != null) {
      paramObject = AIOImageProviderService.a(this.a, localTroopFileStatusInfo.e);
    }
    if ((localTroopFileStatusInfo == null) || (paramObject == null))
    {
      QLog.i("AIOImageProviderService", 2, "onTroopFileStatusUpdate: error, info[" + localTroopFileStatusInfo + "] troopFileMsg[" + paramObject + "]");
      return;
    }
    if (!paramObject.url.equals(localTroopFileStatusInfo.e))
    {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, file info not match message. fileId[" + localTroopFileStatusInfo.e + "]");
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack == null)
    {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, callback is null.");
      return;
    }
    a(localTroopFileStatusInfo, paramObject);
    b(localTroopFileStatusInfo, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.TroopFileObserver
 * JD-Core Version:    0.7.0.1
 */