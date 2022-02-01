import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

class aufm
  extends aavn
{
  aufm(aufl paramaufl, atvm paramatvm) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    if (paramDownloadFileRspBody == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("VideoForTroop<QFile>", 4, "error DownloadFileRspBody is null!!!!!");
      }
      this.jdField_a_of_type_Atvm.a(-1, "");
      return;
    }
    paramBundle = TroopFileTransferManager.a(aufl.a(this.jdField_a_of_type_Aufl).b);
    if (paramBundle == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "getUrl: onReqDownloadFileResult: get troopFileTransferManager failed.");
      return;
    }
    TroopFileTransferManager.Item localItem = paramBundle.a(aufl.a(this.jdField_a_of_type_Aufl));
    if (localItem == null)
    {
      this.jdField_a_of_type_Atvm.a(-2, "");
      return;
    }
    paramInt = paramDownloadFileRspBody.int32_ret_code.get();
    QLog.e("VideoForTroop<QFile>", 1, String.format("onRspDownload - retCode: %d", new Object[] { Integer.valueOf(paramInt) }));
    if (paramDownloadFileRspBody.bytes_cookie_val.has())
    {
      localItem.cookieValue = bhml.a(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
      localItem.cookieValue = localItem.cookieValue.toLowerCase();
    }
    localItem.DownloadIp = paramDownloadFileRspBody.str_download_ip.get();
    localItem.DownloadUrl = bhml.a(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
    localItem.Md5 = paramDownloadFileRspBody.bytes_md5.get().toByteArray();
    localItem.NameForSave = paramDownloadFileRspBody.str_save_file_name.get();
    if ((paramInt == -133) || (paramInt == -132) || (paramInt == -134))
    {
      QLog.w("VideoForTroop<QFile>", 1, "file invalidate retCode = " + paramInt);
      paramDownloadFileRspBody = String.format(this.jdField_a_of_type_Aufl.a.getApp().getBaseContext().getString(2131696648), new Object[] { localItem.FileName });
      this.jdField_a_of_type_Atvm.a(paramInt, paramDownloadFileRspBody);
      return;
    }
    if ((paramInt == -103) || (paramInt == -301))
    {
      QLog.w("VideoForTroop<QFile>", 1, "file invalidate retCode = " + paramInt);
      paramDownloadFileRspBody = String.format(this.jdField_a_of_type_Aufl.a.getApp().getBaseContext().getString(2131696649), new Object[] { localItem.FileName });
      this.jdField_a_of_type_Atvm.a(paramInt, paramDownloadFileRspBody);
      return;
    }
    paramBundle = localItem.DownloadIp;
    String str = paramDownloadFileRspBody.str_download_dns.get().toStringUtf8();
    paramDownloadFileRspBody = paramBundle;
    if (!TextUtils.isEmpty(str))
    {
      paramDownloadFileRspBody = paramBundle;
      if (atul.a().a(this.jdField_a_of_type_Aufl.a, 3))
      {
        QLog.i("VideoForTroop<QFile>", 1, "[IPv6-File] troopVideo download. is config enable IPv6. domain[" + str + "]");
        paramDownloadFileRspBody = new atum(str, 0);
        paramDownloadFileRspBody = atul.a().a(this.jdField_a_of_type_Aufl.a, paramDownloadFileRspBody, 3);
        if ((paramDownloadFileRspBody == null) || (paramDownloadFileRspBody.a())) {
          break label645;
        }
        paramDownloadFileRspBody = (atun)paramDownloadFileRspBody.a.get(0);
        if ((paramDownloadFileRspBody == null) || (TextUtils.isEmpty(paramDownloadFileRspBody.a))) {
          break label674;
        }
        paramDownloadFileRspBody = paramDownloadFileRspBody.a;
        QLog.i("VideoForTroop<QFile>", 1, "[IPv6-File] troopVideo download. use IPv6. hostlist:" + paramDownloadFileRspBody);
      }
    }
    for (;;)
    {
      paramDownloadFileRspBody = audq.a(paramDownloadFileRspBody, localItem.DownloadUrl, localItem.FilePath, localItem.cookieValue, "");
      QLog.i("VideoForTroop<QFile>", 1, "troopVideo download. downloadUrl:" + paramDownloadFileRspBody);
      if (!TextUtils.isEmpty(paramDownloadFileRspBody))
      {
        this.jdField_a_of_type_Atvm.a(paramDownloadFileRspBody, localItem.cookieValue);
        return;
        label645:
        QLog.i("VideoForTroop<QFile>", 1, "[IPv6-File] troopVideo download. use IPv4");
        paramDownloadFileRspBody = paramBundle;
      }
      else
      {
        this.jdField_a_of_type_Atvm.a(-3, "");
        return;
        label674:
        paramDownloadFileRspBody = paramBundle;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aufm
 * JD-Core Version:    0.7.0.1
 */