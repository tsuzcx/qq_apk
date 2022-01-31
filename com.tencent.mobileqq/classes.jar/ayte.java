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

class ayte
  extends wma
{
  ayte(aytd paramaytd) {}
  
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
    azjc localazjc = new azjc();
    localazjc.jdField_a_of_type_Int = -1;
    try
    {
      localazjc.e = this.a.a().toString();
      localQQAppInterface = ayrz.a();
      if (localQQAppInterface == null)
      {
        aysb.a("TroopFilePreviewWorker", aysb.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult app=null");
        return;
      }
    }
    catch (NullPointerException paramBundle)
    {
      QQAppInterface localQQAppInterface;
      for (;;)
      {
        localazjc.e = null;
      }
      ajex localajex = (ajex)localQQAppInterface.a(22);
      if ((paramDownloadFileRspBody == null) || (!paramBoolean))
      {
        aysb.a("TroopFilePreviewWorker", aysb.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult isSuccess:false  errCode:" + paramInt);
        azic.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
        localazjc.jdField_a_of_type_Boolean = false;
        localajex.c(localazjc);
        return;
      }
      paramInt = paramDownloadFileRspBody.int32_ret_code.get();
      localazjc.jdField_a_of_type_Int = paramInt;
      localazjc.jdField_a_of_type_Boolean = false;
      String str = paramDownloadFileRspBody.str_download_ip.get();
      paramBundle = "";
      if (paramDownloadFileRspBody.str_download_dns.get() != null) {
        paramBundle = paramDownloadFileRspBody.str_download_dns.get().toString();
      }
      localazjc.jdField_a_of_type_JavaLangString = str;
      if ((TextUtils.isEmpty(localazjc.jdField_a_of_type_JavaLangString)) || (localazjc.jdField_a_of_type_JavaLangString.equals("0.0.0.0"))) {
        localazjc.jdField_a_of_type_JavaLangString = paramBundle;
      }
      localazjc.b = String.valueOf(paramDownloadFileRspBody.uint32_preview_port.get());
      localazjc.c = paramDownloadFileRspBody.str_ret_msg.get();
      localazjc.d = bach.a(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
      localazjc.f = paramBundle;
      if (paramInt < 0)
      {
        aysb.a("TroopFilePreviewWorker", aysb.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult fail. retCode:" + paramInt + " retMsg:" + localazjc.c);
        azic.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
        if (TextUtils.isEmpty(localazjc.c)) {
          localazjc.c = ajjy.a(2131649556);
        }
        localazjc.jdField_a_of_type_Boolean = false;
        localajex.c(localazjc);
        return;
      }
      aysb.c("TroopFilePreviewWorker", aysb.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult isSuccess:true  downloadip:" + str + " downloadDns:" + paramBundle + " port:" + localazjc.b + " downloadKey:" + localazjc.d + " retMsg:" + localazjc.c + " httpsDomain:" + localazjc.f);
      localazjc.jdField_a_of_type_Boolean = true;
      localajex.c(localazjc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayte
 * JD-Core Version:    0.7.0.1
 */