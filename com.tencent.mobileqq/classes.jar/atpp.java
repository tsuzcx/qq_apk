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

class atpp
  extends aark
{
  atpp(atpf paramatpf) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    if (atpf.a(this.a) == null) {}
    Object localObject;
    label546:
    do
    {
      do
      {
        return;
        if (paramDownloadFileRspBody == null)
        {
          QLog.i("TroopFileModel<FileAssistant>", 1, "requestOnlinePreviewDownloadUrl: error DownloadFileRspBody is null!");
          atpf.a(this.a).c();
          return;
        }
        long l = paramBundle.getLong("troopUin");
        localObject = TroopFileTransferManager.a(l);
        if (localObject == null)
        {
          QLog.i("TroopFileModel<FileAssistant>", 1, "requestOnlinePreviewDownloadUrl: error bad troopUin[" + l + "]");
          atpf.a(this.a).c();
          return;
        }
        paramBundle = paramBundle.getString("itemKey");
        if (paramBundle == null)
        {
          atpf.a(this.a).c();
          return;
        }
        localObject = ((TroopFileTransferManager)localObject).a(UUID.fromString(paramBundle));
        if (localObject == null)
        {
          QLog.i("TroopFileModel<FileAssistant>", 1, "requestOnlinePreviewDownloadUrl: error bad item key" + paramBundle + "]");
          atpf.a(this.a).c();
          return;
        }
        paramInt = paramDownloadFileRspBody.int32_ret_code.get();
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileModel<FileAssistant>", 2, "requestOnlinePreviewDownloadUrl: onRspDownload - retCode[" + paramInt + "]");
        }
      } while (atpf.a(this.a, paramInt, atpf.a(this.a)));
      ((TroopFileTransferManager.Item)localObject).cookieValue = bgmj.a(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
      if (((TroopFileTransferManager.Item)localObject).cookieValue != null) {
        ((TroopFileTransferManager.Item)localObject).cookieValue = ((TroopFileTransferManager.Item)localObject).cookieValue.toLowerCase();
      }
      ((TroopFileTransferManager.Item)localObject).DownloadIp = paramDownloadFileRspBody.str_download_ip.get();
      ((TroopFileTransferManager.Item)localObject).DownloadUrl = bgmj.a(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
      ((TroopFileTransferManager.Item)localObject).Md5 = paramDownloadFileRspBody.bytes_md5.get().toByteArray();
      ((TroopFileTransferManager.Item)localObject).NameForSave = paramDownloadFileRspBody.str_save_file_name.get();
      paramDownloadFileRspBody = atlv.a(((TroopFileTransferManager.Item)localObject).DownloadIp, ((TroopFileTransferManager.Item)localObject).DownloadUrl, ((TroopFileTransferManager.Item)localObject).FilePath, ((TroopFileTransferManager.Item)localObject).cookieValue, "");
      if (!TextUtils.isEmpty(paramDownloadFileRspBody))
      {
        atpf.a(this.a).a(paramDownloadFileRspBody, ((TroopFileTransferManager.Item)localObject).cookieValue);
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileModel<FileAssistant>", 2, "requestOnlinePreviewDownloadUrl: url[" + paramDownloadFileRspBody + "], cookies [" + ((TroopFileTransferManager.Item)localObject).cookieValue + "]");
        }
        if (this.a.a.a() != null)
        {
          paramDownloadFileRspBody = String.valueOf(this.a.a.a().TroopUin);
          if (this.a.a.a() == null) {
            break label546;
          }
        }
        for (paramBundle = atvo.b(this.a.a.a().nFileType);; paramBundle = "unknow")
        {
          bcst.b(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, paramDownloadFileRspBody, "", paramBundle, "1");
          return;
          paramDownloadFileRspBody = "";
          break;
        }
      }
      atpf.a(this.a).c();
    } while (!QLog.isColorLevel());
    QLog.i("TroopFileModel<FileAssistant>", 2, "requestOnlinePreviewDownloadUrl: url[" + paramDownloadFileRspBody + "], cookies [" + ((TroopFileTransferManager.Item)localObject).cookieValue + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atpp
 * JD-Core Version:    0.7.0.1
 */