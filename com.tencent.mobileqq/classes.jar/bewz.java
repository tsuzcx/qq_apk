import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

class bewz
  extends aark
{
  bewz(bewy parambewy) {}
  
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
    bfsf localbfsf = new bfsf();
    localbfsf.jdField_a_of_type_Int = -1;
    try
    {
      localbfsf.e = this.a.a().toString();
      localQQAppInterface = bevv.a();
      if (localQQAppInterface == null)
      {
        bevx.a("TroopFilePreviewWorker", bevx.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult app=null");
        return;
      }
    }
    catch (NullPointerException paramBundle)
    {
      QQAppInterface localQQAppInterface;
      for (;;)
      {
        localbfsf.e = null;
      }
      anie localanie = (anie)localQQAppInterface.a(22);
      if ((paramDownloadFileRspBody == null) || (!paramBoolean))
      {
        bevx.a("TroopFilePreviewWorker", bevx.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult isSuccess:false  errCode:" + paramInt);
        bfrh.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
        localbfsf.jdField_a_of_type_Boolean = false;
        localanie.c(localbfsf);
        return;
      }
      paramInt = paramDownloadFileRspBody.int32_ret_code.get();
      localbfsf.jdField_a_of_type_Int = paramInt;
      localbfsf.jdField_a_of_type_Boolean = false;
      String str = paramDownloadFileRspBody.str_download_ip.get();
      paramBundle = "";
      if (paramDownloadFileRspBody.str_download_dns.get() != null) {
        paramBundle = paramDownloadFileRspBody.str_download_dns.get().toString();
      }
      localbfsf.jdField_a_of_type_JavaLangString = str;
      if ((TextUtils.isEmpty(localbfsf.jdField_a_of_type_JavaLangString)) || (localbfsf.jdField_a_of_type_JavaLangString.equals("0.0.0.0"))) {
        localbfsf.jdField_a_of_type_JavaLangString = paramBundle;
      }
      localbfsf.b = String.valueOf(paramDownloadFileRspBody.uint32_preview_port.get());
      localbfsf.c = paramDownloadFileRspBody.str_ret_msg.get();
      localbfsf.d = bgmj.a(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
      localbfsf.f = paramBundle;
      if (paramInt < 0)
      {
        bevx.a("TroopFilePreviewWorker", bevx.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult fail. retCode:" + paramInt + " retMsg:" + localbfsf.c);
        bfrh.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
        if (TextUtils.isEmpty(localbfsf.c)) {
          localbfsf.c = anni.a(2131714022);
        }
        localbfsf.jdField_a_of_type_Boolean = false;
        localanie.c(localbfsf);
        return;
      }
      bevx.c("TroopFilePreviewWorker", bevx.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult isSuccess:true  downloadip:" + str + " downloadDns:" + paramBundle + " port:" + localbfsf.b + " downloadKey:" + localbfsf.d + " retMsg:" + localbfsf.c + " httpsDomain:" + localbfsf.f);
      localbfsf.jdField_a_of_type_Boolean = true;
      localanie.c(localbfsf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bewz
 * JD-Core Version:    0.7.0.1
 */