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
    boolean bool = FileUtils.fileExistsAndNotEmpty(paramTroopFileStatusInfo.n);
    String str = "";
    Object localObject2;
    if (bool)
    {
      this.a.y.a(paramMessageForTroopFile.uniseq, 0, 16, 1, paramTroopFileStatusInfo.n, false);
    }
    else if (paramTroopFileStatusInfo.H != 0)
    {
      try
      {
        Object localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("errorType", "thumb_download");
        ((JSONObject)localObject1).put("errorCode", paramTroopFileStatusInfo.H);
        localObject1 = ((JSONObject)localObject1).toString();
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        localObject2 = "";
      }
      this.a.y.a(paramMessageForTroopFile.uniseq, 0, 18, 2, (String)localObject2, false);
    }
    if (FileUtils.fileExistsAndNotEmpty(paramTroopFileStatusInfo.m))
    {
      this.a.y.a(paramMessageForTroopFile.uniseq, 0, 18, 1, paramTroopFileStatusInfo.m, false);
      return;
    }
    if (paramTroopFileStatusInfo.H != 0)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("errorType", "thumb_download");
        ((JSONObject)localObject2).put("errorCode", paramTroopFileStatusInfo.H);
        paramTroopFileStatusInfo = ((JSONObject)localObject2).toString();
      }
      catch (JSONException paramTroopFileStatusInfo)
      {
        paramTroopFileStatusInfo.printStackTrace();
        paramTroopFileStatusInfo = str;
      }
      this.a.y.a(paramMessageForTroopFile.uniseq, 0, 18, 2, paramTroopFileStatusInfo, false);
    }
  }
  
  private void b(TroopFileStatusInfo paramTroopFileStatusInfo, MessageForTroopFile paramMessageForTroopFile)
  {
    if (AIOImageProviderService.a(this.a, paramMessageForTroopFile))
    {
      if ((paramTroopFileStatusInfo.e == 8) && (paramTroopFileStatusInfo.i > 0L))
      {
        int i = (int)((float)paramTroopFileStatusInfo.j / (float)paramTroopFileStatusInfo.i * 10000.0F);
        this.a.y.a(paramMessageForTroopFile.uniseq, 0, 1, i, paramTroopFileStatusInfo.i, true);
        return;
      }
      if (paramTroopFileStatusInfo.e == 11)
      {
        if (this.a.x.contains(Long.valueOf(paramMessageForTroopFile.uniseq)))
        {
          Context localContext = BaseApplicationImpl.sApplication.getBaseContext();
          if (localContext != null) {
            FileManagerUtil.a(localContext, paramTroopFileStatusInfo.k);
          } else {
            QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [troop file save album].");
          }
          this.a.x.remove(Long.valueOf(paramMessageForTroopFile.uniseq));
        }
        this.a.y.a(paramMessageForTroopFile.uniseq, 1, 269484034, 1, paramTroopFileStatusInfo.k, false);
        return;
      }
      if ((paramTroopFileStatusInfo.e == 12) || (paramTroopFileStatusInfo.e == 10)) {
        this.a.y.a(paramMessageForTroopFile.uniseq, 0, 269484034, 2, paramTroopFileStatusInfo.k, false);
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
          paramMessageForTroopFile.append(paramTroopFileStatusInfo.e);
          QLog.i("TroopStatusDebug", 1, paramMessageForTroopFile.toString());
        }
        return;
      }
      if ((paramTroopFileStatusInfo.e == 8) && (paramTroopFileStatusInfo.i > 0L))
      {
        this.a.y.a(paramMessageForTroopFile.uniseq, 0, 20, (int)(paramTroopFileStatusInfo.j * 10000L / paramTroopFileStatusInfo.i), paramMessageForTroopFile.fileSize, true);
        return;
      }
      if (paramTroopFileStatusInfo.e == 11)
      {
        this.a.y.a(paramMessageForTroopFile.uniseq, 0, 20, 1, paramTroopFileStatusInfo.k, false);
        return;
      }
      if ((paramTroopFileStatusInfo.e == 12) || (paramTroopFileStatusInfo.e == 10)) {
        this.a.y.a(paramMessageForTroopFile.uniseq, 0, 20, 2, "TroopFileError", false);
      }
    }
  }
  
  protected void a(Object paramObject)
  {
    TroopFileStatusInfo localTroopFileStatusInfo = (TroopFileStatusInfo)paramObject;
    if (localTroopFileStatusInfo != null) {
      paramObject = AIOImageProviderService.a(this.a, localTroopFileStatusInfo.r);
    } else {
      paramObject = null;
    }
    if ((localTroopFileStatusInfo != null) && (paramObject != null))
    {
      if (!paramObject.url.equals(localTroopFileStatusInfo.r))
      {
        paramObject = new StringBuilder();
        paramObject.append("OnFileTransferProgress: error, file info not match message. fileId[");
        paramObject.append(localTroopFileStatusInfo.r);
        paramObject.append("]");
        QLog.i("AIOImageProviderService", 2, paramObject.toString());
        return;
      }
      if (this.a.y == null)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.TroopFileObserver
 * JD-Core Version:    0.7.0.1
 */