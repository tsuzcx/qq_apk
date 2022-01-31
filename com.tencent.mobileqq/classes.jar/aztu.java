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

class aztu
  extends xbd
{
  aztu(aztt paramaztt) {}
  
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
    bakf localbakf = new bakf();
    localbakf.jdField_a_of_type_Int = -1;
    try
    {
      localbakf.e = this.a.a().toString();
      localQQAppInterface = azsp.a();
      if (localQQAppInterface == null)
      {
        azsr.a("TroopFilePreviewWorker", azsr.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult app=null");
        return;
      }
    }
    catch (NullPointerException paramBundle)
    {
      QQAppInterface localQQAppInterface;
      for (;;)
      {
        localbakf.e = null;
      }
      ajsz localajsz = (ajsz)localQQAppInterface.a(22);
      if ((paramDownloadFileRspBody == null) || (!paramBoolean))
      {
        azsr.a("TroopFilePreviewWorker", azsr.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult isSuccess:false  errCode:" + paramInt);
        bajf.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
        localbakf.jdField_a_of_type_Boolean = false;
        localajsz.c(localbakf);
        return;
      }
      paramInt = paramDownloadFileRspBody.int32_ret_code.get();
      localbakf.jdField_a_of_type_Int = paramInt;
      localbakf.jdField_a_of_type_Boolean = false;
      String str = paramDownloadFileRspBody.str_download_ip.get();
      paramBundle = "";
      if (paramDownloadFileRspBody.str_download_dns.get() != null) {
        paramBundle = paramDownloadFileRspBody.str_download_dns.get().toString();
      }
      localbakf.jdField_a_of_type_JavaLangString = str;
      if ((TextUtils.isEmpty(localbakf.jdField_a_of_type_JavaLangString)) || (localbakf.jdField_a_of_type_JavaLangString.equals("0.0.0.0"))) {
        localbakf.jdField_a_of_type_JavaLangString = paramBundle;
      }
      localbakf.b = String.valueOf(paramDownloadFileRspBody.uint32_preview_port.get());
      localbakf.c = paramDownloadFileRspBody.str_ret_msg.get();
      localbakf.d = bbdm.a(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
      localbakf.f = paramBundle;
      if (paramInt < 0)
      {
        azsr.a("TroopFilePreviewWorker", azsr.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult fail. retCode:" + paramInt + " retMsg:" + localbakf.c);
        bajf.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
        if (TextUtils.isEmpty(localbakf.c)) {
          localbakf.c = ajyc.a(2131715346);
        }
        localbakf.jdField_a_of_type_Boolean = false;
        localajsz.c(localbakf);
        return;
      }
      azsr.c("TroopFilePreviewWorker", azsr.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult isSuccess:true  downloadip:" + str + " downloadDns:" + paramBundle + " port:" + localbakf.b + " downloadKey:" + localbakf.d + " retMsg:" + localbakf.c + " httpsDomain:" + localbakf.f);
      localbakf.jdField_a_of_type_Boolean = true;
      localajsz.c(localbakf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aztu
 * JD-Core Version:    0.7.0.1
 */