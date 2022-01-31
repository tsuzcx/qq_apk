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

class bbwo
  extends yui
{
  bbwo(bbwn parambbwn) {}
  
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
    bcnp localbcnp = new bcnp();
    localbcnp.jdField_a_of_type_Int = -1;
    try
    {
      localbcnp.e = this.a.a().toString();
      localQQAppInterface = bbvj.a();
      if (localQQAppInterface == null)
      {
        bbvl.a("TroopFilePreviewWorker", bbvl.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult app=null");
        return;
      }
    }
    catch (NullPointerException paramBundle)
    {
      QQAppInterface localQQAppInterface;
      for (;;)
      {
        localbcnp.e = null;
      }
      aloz localaloz = (aloz)localQQAppInterface.a(22);
      if ((paramDownloadFileRspBody == null) || (!paramBoolean))
      {
        bbvl.a("TroopFilePreviewWorker", bbvl.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult isSuccess:false  errCode:" + paramInt);
        bcmp.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
        localbcnp.jdField_a_of_type_Boolean = false;
        localaloz.c(localbcnp);
        return;
      }
      paramInt = paramDownloadFileRspBody.int32_ret_code.get();
      localbcnp.jdField_a_of_type_Int = paramInt;
      localbcnp.jdField_a_of_type_Boolean = false;
      String str = paramDownloadFileRspBody.str_download_ip.get();
      paramBundle = "";
      if (paramDownloadFileRspBody.str_download_dns.get() != null) {
        paramBundle = paramDownloadFileRspBody.str_download_dns.get().toString();
      }
      localbcnp.jdField_a_of_type_JavaLangString = str;
      if ((TextUtils.isEmpty(localbcnp.jdField_a_of_type_JavaLangString)) || (localbcnp.jdField_a_of_type_JavaLangString.equals("0.0.0.0"))) {
        localbcnp.jdField_a_of_type_JavaLangString = paramBundle;
      }
      localbcnp.b = String.valueOf(paramDownloadFileRspBody.uint32_preview_port.get());
      localbcnp.c = paramDownloadFileRspBody.str_ret_msg.get();
      localbcnp.d = bdhe.a(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
      localbcnp.f = paramBundle;
      if (paramInt < 0)
      {
        bbvl.a("TroopFilePreviewWorker", bbvl.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult fail. retCode:" + paramInt + " retMsg:" + localbcnp.c);
        bcmp.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
        if (TextUtils.isEmpty(localbcnp.c)) {
          localbcnp.c = alud.a(2131715741);
        }
        localbcnp.jdField_a_of_type_Boolean = false;
        localaloz.c(localbcnp);
        return;
      }
      bbvl.c("TroopFilePreviewWorker", bbvl.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult isSuccess:true  downloadip:" + str + " downloadDns:" + paramBundle + " port:" + localbcnp.b + " downloadKey:" + localbcnp.d + " retMsg:" + localbcnp.c + " httpsDomain:" + localbcnp.f);
      localbcnp.jdField_a_of_type_Boolean = true;
      localaloz.c(localbcnp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwo
 * JD-Core Version:    0.7.0.1
 */