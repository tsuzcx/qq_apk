import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.HexUtil;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

class bfnh
  extends aahm
{
  bfnh(bfng parambfng) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    if (!paramBundle.getBoolean("isPreview", false)) {}
    do
    {
      do
      {
        return;
      } while (paramBundle.getLong("troopUin") != this.a.jdField_a_of_type_Long);
      paramBundle = paramBundle.getString("itemKey");
    } while ((paramBundle == null) || (!UUID.fromString(paramBundle).equals(this.a.a())));
    bgka localbgka = new bgka();
    localbgka.jdField_a_of_type_Int = -1;
    try
    {
      localbgka.e = this.a.a().toString();
      localQQAppInterface = bfmd.a();
      if (localQQAppInterface == null)
      {
        bfmf.a("TroopFilePreviewWorker", bfmf.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult app=null");
        return;
      }
    }
    catch (NullPointerException paramBundle)
    {
      QQAppInterface localQQAppInterface;
      for (;;)
      {
        localbgka.e = null;
      }
      anrb localanrb = (anrb)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
      if ((paramDownloadFileRspBody == null) || (!paramBoolean))
      {
        bfmf.a("TroopFilePreviewWorker", bfmf.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult isSuccess:false  errCode:" + paramInt);
        bgjc.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
        localbgka.jdField_a_of_type_Boolean = false;
        localanrb.c(localbgka);
        return;
      }
      paramInt = paramDownloadFileRspBody.int32_ret_code.get();
      localbgka.jdField_a_of_type_Int = paramInt;
      localbgka.jdField_a_of_type_Boolean = false;
      String str = paramDownloadFileRspBody.str_download_ip.get();
      paramBundle = "";
      if (paramDownloadFileRspBody.str_download_dns.get() != null) {
        paramBundle = paramDownloadFileRspBody.str_download_dns.get().toString();
      }
      localbgka.jdField_a_of_type_JavaLangString = str;
      if ((TextUtils.isEmpty(localbgka.jdField_a_of_type_JavaLangString)) || (localbgka.jdField_a_of_type_JavaLangString.equals("0.0.0.0"))) {
        localbgka.jdField_a_of_type_JavaLangString = paramBundle;
      }
      localbgka.b = String.valueOf(paramDownloadFileRspBody.uint32_preview_port.get());
      localbgka.c = paramDownloadFileRspBody.str_ret_msg.get();
      localbgka.d = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
      localbgka.f = paramBundle;
      if (paramInt < 0)
      {
        bfmf.a("TroopFilePreviewWorker", bfmf.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult fail. retCode:" + paramInt + " retMsg:" + localbgka.c);
        bgjc.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
        if (TextUtils.isEmpty(localbgka.c)) {
          localbgka.c = anvx.a(2131714710);
        }
        localbgka.jdField_a_of_type_Boolean = false;
        localanrb.c(localbgka);
        return;
      }
      bfmf.c("TroopFilePreviewWorker", bfmf.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult isSuccess:true  downloadip:" + str + " downloadDns:" + paramBundle + " port:" + localbgka.b + " downloadKey:" + localbgka.d + " retMsg:" + localbgka.c + " httpsDomain:" + localbgka.f);
      localbgka.jdField_a_of_type_Boolean = true;
      localanrb.c(localbgka);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfnh
 * JD-Core Version:    0.7.0.1
 */