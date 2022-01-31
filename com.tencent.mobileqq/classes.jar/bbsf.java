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

class bbsf
  extends ypt
{
  bbsf(bbse parambbse) {}
  
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
    bcjg localbcjg = new bcjg();
    localbcjg.jdField_a_of_type_Int = -1;
    try
    {
      localbcjg.e = this.a.a().toString();
      localQQAppInterface = bbra.a();
      if (localQQAppInterface == null)
      {
        bbrc.a("TroopFilePreviewWorker", bbrc.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult app=null");
        return;
      }
    }
    catch (NullPointerException paramBundle)
    {
      QQAppInterface localQQAppInterface;
      for (;;)
      {
        localbcjg.e = null;
      }
      alkk localalkk = (alkk)localQQAppInterface.a(22);
      if ((paramDownloadFileRspBody == null) || (!paramBoolean))
      {
        bbrc.a("TroopFilePreviewWorker", bbrc.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult isSuccess:false  errCode:" + paramInt);
        bcig.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
        localbcjg.jdField_a_of_type_Boolean = false;
        localalkk.c(localbcjg);
        return;
      }
      paramInt = paramDownloadFileRspBody.int32_ret_code.get();
      localbcjg.jdField_a_of_type_Int = paramInt;
      localbcjg.jdField_a_of_type_Boolean = false;
      String str = paramDownloadFileRspBody.str_download_ip.get();
      paramBundle = "";
      if (paramDownloadFileRspBody.str_download_dns.get() != null) {
        paramBundle = paramDownloadFileRspBody.str_download_dns.get().toString();
      }
      localbcjg.jdField_a_of_type_JavaLangString = str;
      if ((TextUtils.isEmpty(localbcjg.jdField_a_of_type_JavaLangString)) || (localbcjg.jdField_a_of_type_JavaLangString.equals("0.0.0.0"))) {
        localbcjg.jdField_a_of_type_JavaLangString = paramBundle;
      }
      localbcjg.b = String.valueOf(paramDownloadFileRspBody.uint32_preview_port.get());
      localbcjg.c = paramDownloadFileRspBody.str_ret_msg.get();
      localbcjg.d = bdcv.a(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
      localbcjg.f = paramBundle;
      if (paramInt < 0)
      {
        bbrc.a("TroopFilePreviewWorker", bbrc.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult fail. retCode:" + paramInt + " retMsg:" + localbcjg.c);
        bcig.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
        if (TextUtils.isEmpty(localbcjg.c)) {
          localbcjg.c = alpo.a(2131715729);
        }
        localbcjg.jdField_a_of_type_Boolean = false;
        localalkk.c(localbcjg);
        return;
      }
      bbrc.c("TroopFilePreviewWorker", bbrc.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult isSuccess:true  downloadip:" + str + " downloadDns:" + paramBundle + " port:" + localbcjg.b + " downloadKey:" + localbcjg.d + " retMsg:" + localbcjg.c + " httpsDomain:" + localbcjg.f);
      localbcjg.jdField_a_of_type_Boolean = true;
      localalkk.c(localbcjg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsf
 * JD-Core Version:    0.7.0.1
 */