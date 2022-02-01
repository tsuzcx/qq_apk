import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

class bfxg
  extends aavn
{
  bfxg(bfxf parambfxf) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    if (paramBundle.getLong("troopUin") != this.a.jdField_a_of_type_Long) {}
    boolean bool;
    do
    {
      String str;
      do
      {
        return;
        str = paramBundle.getString("itemKey");
      } while ((str == null) || (!UUID.fromString(str).equals(this.a.a())) || (this.a.jdField_a_of_type_Boolean));
      i = paramBundle.getInt("thumbNail");
      bool = paramBundle.getBoolean("isPreview", false);
    } while ((i == 0) || (bool) || (i != this.a.jdField_a_of_type_Int));
    if ((paramDownloadFileRspBody == null) || (!paramBoolean))
    {
      bfvr.a("TroopFileDownloadWorker", bfvr.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFetchResult isSuccess:false  errCode:" + paramInt);
      this.a.c(bguk.A);
      return;
    }
    int i = paramDownloadFileRspBody.int32_ret_code.get();
    bfvr.c("TroopFileDownloadWorker", bfvr.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFetchResult isSuccess:true  errCode:" + paramInt + " retCode:" + i);
    if (i < 0)
    {
      if ((i != -103) && (i != -302) && (i != -301)) {
        break label779;
      }
      bfvr.a("TroopFileDownloadWorker", bfvr.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFetchResult  file is not exsit. retCode:" + i);
      this.a.jdField_a_of_type_Boolean = true;
      this.a.b(4);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ErrorCode = 0;
      bfva.a(this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 12);
      if (this.a.jdField_a_of_type_Bfxh != null) {
        this.a.jdField_a_of_type_Bfxh.a(this.a.a(), false, i, this.a);
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue = bhml.a(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue = this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue.toLowerCase();
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp = paramDownloadFileRspBody.str_download_ip.get();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS = paramDownloadFileRspBody.str_download_dns.get().toStringUtf8();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl = bhml.a(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Md5 = paramDownloadFileRspBody.bytes_md5.get().toByteArray();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.NameForSave = paramDownloadFileRspBody.str_save_file_name.get();
    if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp))
    {
      bfvr.a("TroopFileDownloadWorker", bfvr.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFetchResult DownloadIp is null");
      bguj.a("gfile", "ipnull", "", "", "", "");
    }
    i = paramDownloadFileRspBody.uint32_preview_port.get();
    bfvr.c("TroopFileDownloadWorker", bfvr.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFetchResult DownloadIp:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp + " DownloadDNS:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadDNS + " videoPort:" + i + " DownloadUrl:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadUrl + " cookieValue:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.cookieValue);
    if (paramDownloadFileRspBody.uint32_preview_port_https.has()) {}
    for (paramInt = paramDownloadFileRspBody.uint32_preview_port_https.get();; paramInt = 0)
    {
      paramBundle = null;
      if (paramDownloadFileRspBody.str_download_dns_https.has()) {
        paramBundle = paramDownloadFileRspBody.str_download_dns_https.get();
      }
      this.a.a(i, paramBundle, paramInt);
      return;
      label779:
      this.a.c(i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxg
 * JD-Core Version:    0.7.0.1
 */