import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskHttpUpload;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.ResendRspBody;

public class bgjs
  extends aaho
{
  public bgjs(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.ResendRspBody paramResendRspBody, Bundle paramBundle)
  {
    long l = paramBundle.getLong("troopUin");
    TroopFileTransferManager localTroopFileTransferManager;
    Object localObject;
    try
    {
      localTroopFileTransferManager = (TroopFileTransferManager)TroopFileTransferManager.a().get(Long.valueOf(l));
      if (localTroopFileTransferManager == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileTransferManager", 4, "bad troopUin" + l);
        }
        return;
      }
      paramBundle = paramBundle.getString("itemKey");
      if (paramBundle == null) {
        return;
      }
      localObject = UUID.fromString(paramBundle);
      try
      {
        localObject = (TroopFileTransferManager.Item)localTroopFileTransferManager.jdField_a_of_type_JavaUtilMap.get(localObject);
        if (localObject == null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("TroopFileTransferManager", 4, "bad item key" + paramBundle);
          }
          return;
        }
      }
      finally {}
    }
    finally {}
    if (!paramBoolean)
    {
      paramResendRspBody = new bgje(((TroopFileTransferManager.Item)localObject).FileName, this.a.e, 3, 207);
      this.a.a((TroopFileTransferManager.Item)localObject, 3, paramResendRspBody);
      if (QLog.isDevelopLevel()) {
        QLog.w("TroopFileTransferManager", 2, "onReqResendFileResult,erroCode=" + paramInt);
      }
    }
    else
    {
      if (paramResendRspBody.int32_ret_code.get() < 0)
      {
        paramInt = 1;
        switch (paramResendRspBody.int32_ret_code.get())
        {
        }
        for (;;)
        {
          this.a.a((TroopFileTransferManager.Item)localObject, 3, paramInt);
          return;
          paramInt = 101;
          continue;
          paramInt = 102;
          continue;
          TroopFileTransferManager.a(this.a, (TroopFileTransferManager.Item)localObject, 206);
          TroopFileTransferManager.a(this.a, (TroopFileTransferManager.Item)localObject);
          return;
          paramInt = -136;
          TroopFileTransferManager.a(this.a, (TroopFileTransferManager.Item)localObject);
          continue;
          paramInt = -138;
          TroopFileTransferManager.a(this.a, (TroopFileTransferManager.Item)localObject);
        }
      }
      ((TroopFileTransferManager.Item)localObject).UploadIp = paramResendRspBody.str_upload_ip.get();
      ((TroopFileTransferManager.Item)localObject).CheckKey = paramResendRspBody.bytes_check_key.get().toByteArray();
      if (!this.a.b((TroopFileTransferManager.Item)localObject)) {
        this.a.jdField_a_of_type_ArrayOfBgkb[2].a(new TroopFileTransferManager.TaskHttpUpload(this.a, (TroopFileTransferManager.Item)localObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgjs
 * JD-Core Version:    0.7.0.1
 */