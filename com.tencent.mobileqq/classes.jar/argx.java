import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

class argx
  extends ypt
{
  argx(argq paramargq, argd paramargd) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Argd == null) {}
    Object localObject;
    label612:
    do
    {
      do
      {
        do
        {
          return;
          if (paramDownloadFileRspBody == null)
          {
            if (QLog.isDevelopLevel()) {
              QLog.e("TroopFileModel<FileAssistant>", 4, "error DownloadFileRspBody is null!!!!!");
            }
            this.jdField_a_of_type_Argd.c();
            return;
          }
          long l = paramBundle.getLong("troopUin");
          localObject = TroopFileTransferManager.a(l);
          if (localObject == null)
          {
            if (QLog.isDevelopLevel()) {
              QLog.e("TroopFileModel<FileAssistant>", 4, "bad troopUin" + l);
            }
            this.jdField_a_of_type_Argd.c();
            return;
          }
          paramBundle = paramBundle.getString("itemKey");
          if (paramBundle == null)
          {
            this.jdField_a_of_type_Argd.c();
            return;
          }
          localObject = ((TroopFileTransferManager)localObject).a(UUID.fromString(paramBundle));
          if (localObject == null)
          {
            if (QLog.isDevelopLevel()) {
              QLog.e("TroopFileModel<FileAssistant>", 4, "bad item key" + paramBundle);
            }
            this.jdField_a_of_type_Argd.c();
            return;
          }
          paramInt = paramDownloadFileRspBody.int32_ret_code.get();
          if (QLog.isDevelopLevel()) {
            QLog.e("TroopFileModel<FileAssistant>", 4, String.format("onRspDownload - retCode: %d", new Object[] { Integer.valueOf(paramInt) }));
          }
          ((TroopFileTransferManager.Item)localObject).cookieValue = bdcv.a(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
          if (((TroopFileTransferManager.Item)localObject).cookieValue != null) {
            ((TroopFileTransferManager.Item)localObject).cookieValue = ((TroopFileTransferManager.Item)localObject).cookieValue.toLowerCase();
          }
          ((TroopFileTransferManager.Item)localObject).DownloadIp = paramDownloadFileRspBody.str_download_ip.get();
          ((TroopFileTransferManager.Item)localObject).DownloadUrl = bdcv.a(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
          ((TroopFileTransferManager.Item)localObject).Md5 = paramDownloadFileRspBody.bytes_md5.get().toByteArray();
          ((TroopFileTransferManager.Item)localObject).NameForSave = paramDownloadFileRspBody.str_save_file_name.get();
          if ((paramInt != -133) && (paramInt != -132) && (paramInt != -134)) {
            break;
          }
          this.jdField_a_of_type_Argd.c();
        } while (!QLog.isDevelopLevel());
        QLog.i("TroopFileModel<FileAssistant>", 4, "file invalidate retCode = " + paramInt);
        return;
        if ((paramInt != -103) && (paramInt != -301)) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("TroopFileModel<FileAssistant>", 4, "file invalidate retCode = " + paramInt);
      return;
      paramDownloadFileRspBody = arcy.a(((TroopFileTransferManager.Item)localObject).DownloadIp, ((TroopFileTransferManager.Item)localObject).DownloadUrl, ((TroopFileTransferManager.Item)localObject).FilePath, ((TroopFileTransferManager.Item)localObject).cookieValue, "");
      if (!TextUtils.isEmpty(paramDownloadFileRspBody))
      {
        this.jdField_a_of_type_Argd.a(paramDownloadFileRspBody, ((TroopFileTransferManager.Item)localObject).cookieValue);
        if (QLog.isColorLevel()) {
          QLog.e("zivonchen", 2, "url = " + paramDownloadFileRspBody + ", cookies = " + ((TroopFileTransferManager.Item)localObject).cookieValue);
        }
        if (this.jdField_a_of_type_Argq.a.a() != null)
        {
          paramDownloadFileRspBody = String.valueOf(this.jdField_a_of_type_Argq.a.a().TroopUin);
          if (this.jdField_a_of_type_Argq.a.a() == null) {
            break label612;
          }
        }
        for (paramBundle = arni.b(this.jdField_a_of_type_Argq.a.a().nFileType);; paramBundle = "unknow")
        {
          azmj.b(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, paramDownloadFileRspBody, "", paramBundle, "1");
          return;
          paramDownloadFileRspBody = "";
          break;
        }
      }
      this.jdField_a_of_type_Argd.c();
    } while (!QLog.isColorLevel());
    QLog.e("zivonchen", 2, "url = " + paramDownloadFileRspBody + ", cookies = " + ((TroopFileTransferManager.Item)localObject).cookieValue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     argx
 * JD-Core Version:    0.7.0.1
 */