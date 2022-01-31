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

class aztw
  extends xba
{
  aztw(aztv paramaztv) {}
  
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
    bakt localbakt = new bakt();
    localbakt.jdField_a_of_type_Int = -1;
    try
    {
      localbakt.e = this.a.a().toString();
      localQQAppInterface = azsr.a();
      if (localQQAppInterface == null)
      {
        azst.a("TroopFilePreviewWorker", azst.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult app=null");
        return;
      }
    }
    catch (NullPointerException paramBundle)
    {
      QQAppInterface localQQAppInterface;
      for (;;)
      {
        localbakt.e = null;
      }
      ajsx localajsx = (ajsx)localQQAppInterface.a(22);
      if ((paramDownloadFileRspBody == null) || (!paramBoolean))
      {
        azst.a("TroopFilePreviewWorker", azst.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult isSuccess:false  errCode:" + paramInt);
        bajt.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
        localbakt.jdField_a_of_type_Boolean = false;
        localajsx.c(localbakt);
        return;
      }
      paramInt = paramDownloadFileRspBody.int32_ret_code.get();
      localbakt.jdField_a_of_type_Int = paramInt;
      localbakt.jdField_a_of_type_Boolean = false;
      String str = paramDownloadFileRspBody.str_download_ip.get();
      paramBundle = "";
      if (paramDownloadFileRspBody.str_download_dns.get() != null) {
        paramBundle = paramDownloadFileRspBody.str_download_dns.get().toString();
      }
      localbakt.jdField_a_of_type_JavaLangString = str;
      if ((TextUtils.isEmpty(localbakt.jdField_a_of_type_JavaLangString)) || (localbakt.jdField_a_of_type_JavaLangString.equals("0.0.0.0"))) {
        localbakt.jdField_a_of_type_JavaLangString = paramBundle;
      }
      localbakt.b = String.valueOf(paramDownloadFileRspBody.uint32_preview_port.get());
      localbakt.c = paramDownloadFileRspBody.str_ret_msg.get();
      localbakt.d = bbea.a(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
      localbakt.f = paramBundle;
      if (paramInt < 0)
      {
        azst.a("TroopFilePreviewWorker", azst.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult fail. retCode:" + paramInt + " retMsg:" + localbakt.c);
        bajt.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
        if (TextUtils.isEmpty(localbakt.c)) {
          localbakt.c = ajya.a(2131715357);
        }
        localbakt.jdField_a_of_type_Boolean = false;
        localajsx.c(localbakt);
        return;
      }
      azst.c("TroopFilePreviewWorker", azst.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult isSuccess:true  downloadip:" + str + " downloadDns:" + paramBundle + " port:" + localbakt.b + " downloadKey:" + localbakt.d + " retMsg:" + localbakt.c + " httpsDomain:" + localbakt.f);
      localbakt.jdField_a_of_type_Boolean = true;
      localajsx.c(localbakt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aztw
 * JD-Core Version:    0.7.0.1
 */