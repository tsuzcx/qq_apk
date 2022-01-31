import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;

class arbm
  extends QIPCModule
{
  public arbm(arbl paramarbl, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    bflp.c("WeiyunDownloadServiceIPC", "onCall action|" + paramString + " params|" + paramBundle + " callbackId|" + paramInt);
    Object localObject;
    QQAppInterface localQQAppInterface;
    if (paramBundle == null)
    {
      localObject = null;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        arbl.a = (String)localObject;
      }
      if (!TextUtils.isEmpty(paramString))
      {
        localQQAppInterface = arbl.a(this.a);
        if (localQQAppInterface != null) {
          break label103;
        }
        bflp.c("WeiyunDownloadServiceIPC", "onCall action but appInterface is null");
      }
    }
    label103:
    do
    {
      do
      {
        return null;
        localObject = paramBundle.getString("process");
        break;
        if (((!"WeiyunDownloadServiceIPC_Action__Download".equals(paramString)) && (!"WeiyunDownloadServiceIPC_Action__Resume".equals(paramString))) || (paramBundle == null)) {
          break label394;
        }
        if (QLog.isColorLevel()) {
          QLog.d("WeiyunDownloadServiceIPC", 2, "AIDL : start weiyunDownload");
        }
        localObject = (String)paramBundle.get("file_id");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          bflp.c("WeiyunDownloadServiceIPC", "onCall action but file_id is null");
          return null;
        }
        FileManagerEntity localFileManagerEntity = localQQAppInterface.a().c((String)localObject);
        localObject = localFileManagerEntity;
        if (localFileManagerEntity != null) {
          break label213;
        }
      } while ("WeiyunDownloadServiceIPC_Action__Resume".equals(paramString));
      localObject = arrr.a(paramBundle);
      localQQAppInterface.a().b((FileManagerEntity)localObject);
      paramString = (String)paramBundle.get("downloadId");
      ((FileManagerEntity)localObject).nOpType = 50;
      ((FileManagerEntity)localObject).cloudType = 2;
      ((FileManagerEntity)localObject).miniAppDownloadId = paramString;
      arbl.a(this.a).put(paramString, Long.valueOf(((FileManagerEntity)localObject).nSessionId));
      if (arrr.b(((FileManagerEntity)localObject).getFilePath()))
      {
        paramString = new Bundle();
        paramString.putString("taskId", ((FileManagerEntity)localObject).miniAppDownloadId);
        paramString.putString("filePath", ((FileManagerEntity)localObject).getFilePath());
        QIPCServerHelper.getInstance().callClient(arbl.a, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Suc", paramString, null);
        paramString = new Bundle();
        paramString.putString("taskId", ((FileManagerEntity)localObject).miniAppDownloadId);
        paramString.putInt("retCode", 1);
        paramString.putString("retMsg", "");
        QIPCServerHelper.getInstance().callClient(arbl.a, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Complete", paramString, null);
        return null;
      }
      localQQAppInterface.a().a((FileManagerEntity)localObject);
      localQQAppInterface.a().a(((FileManagerEntity)localObject).nSessionId);
      return null;
    } while (((!"WeiyunDownloadServiceIPC_Action__Cancel".equals(paramString)) && (!"WeiyunDownloadServiceIPC_Action__Pause".equals(paramString))) || (paramBundle == null));
    label213:
    if (QLog.isColorLevel()) {
      QLog.d("WeiyunDownloadServiceIPC", 2, "AIDL : end weiyunDownload");
    }
    label394:
    paramString = paramBundle.getString("downloadId");
    localQQAppInterface.a().a(((Long)arbl.a(this.a).get(paramString)).longValue());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arbm
 * JD-Core Version:    0.7.0.1
 */