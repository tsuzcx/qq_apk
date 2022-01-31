import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

class areu
  extends ypt
{
  areu(aret paramaret, aqtd paramaqtd) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    if (paramDownloadFileRspBody == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("VideoForTroop<QFile>", 4, "error DownloadFileRspBody is null!!!!!");
      }
      this.jdField_a_of_type_Aqtd.a(-1, "");
      return;
    }
    paramBundle = TroopFileTransferManager.a(aret.a(this.jdField_a_of_type_Aret).b);
    if (paramBundle == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "getUrl: onReqDownloadFileResult: get troopFileTransferManager failed.");
      return;
    }
    paramBundle = paramBundle.a(aret.a(this.jdField_a_of_type_Aret));
    if (paramBundle == null)
    {
      this.jdField_a_of_type_Aqtd.a(-2, "");
      return;
    }
    paramInt = paramDownloadFileRspBody.int32_ret_code.get();
    QLog.e("VideoForTroop<QFile>", 1, String.format("onRspDownload - retCode: %d", new Object[] { Integer.valueOf(paramInt) }));
    if (paramDownloadFileRspBody.bytes_cookie_val.has())
    {
      paramBundle.cookieValue = bdcv.a(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
      paramBundle.cookieValue = paramBundle.cookieValue.toLowerCase();
    }
    paramBundle.DownloadIp = paramDownloadFileRspBody.str_download_ip.get();
    paramBundle.DownloadUrl = bdcv.a(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
    paramBundle.Md5 = paramDownloadFileRspBody.bytes_md5.get().toByteArray();
    paramBundle.NameForSave = paramDownloadFileRspBody.str_save_file_name.get();
    if ((paramInt == -133) || (paramInt == -132) || (paramInt == -134))
    {
      QLog.w("VideoForTroop<QFile>", 1, "file invalidate retCode = " + paramInt);
      this.jdField_a_of_type_Aqtd.a(paramInt, "");
      return;
    }
    if ((paramInt == -103) || (paramInt == -301))
    {
      QLog.w("VideoForTroop<QFile>", 1, "file invalidate retCode = " + paramInt);
      return;
    }
    paramDownloadFileRspBody = arcy.a(paramBundle.DownloadIp, paramBundle.DownloadUrl, paramBundle.FilePath, paramBundle.cookieValue, "");
    if (QLog.isColorLevel()) {
      QLog.e("VideoForTroop<QFile>", 2, "url = " + paramDownloadFileRspBody + ", cookies = " + paramBundle.cookieValue);
    }
    if (!TextUtils.isEmpty(paramDownloadFileRspBody))
    {
      this.jdField_a_of_type_Aqtd.a(paramDownloadFileRspBody, paramBundle.cookieValue);
      return;
    }
    this.jdField_a_of_type_Aqtd.a(-3, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     areu
 * JD-Core Version:    0.7.0.1
 */