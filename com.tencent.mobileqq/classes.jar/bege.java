import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.HexUtil;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

class bege
  extends zsa
{
  bege(begd parambegd) {}
  
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
    bfbu localbfbu = new bfbu();
    localbfbu.jdField_a_of_type_Int = -1;
    try
    {
      localbfbu.e = this.a.a().toString();
      localQQAppInterface = befa.a();
      if (localQQAppInterface == null)
      {
        befc.a("TroopFilePreviewWorker", befc.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult app=null");
        return;
      }
    }
    catch (NullPointerException paramBundle)
    {
      QQAppInterface localQQAppInterface;
      for (;;)
      {
        localbfbu.e = null;
      }
      amoo localamoo = (amoo)localQQAppInterface.getBusinessHandler(22);
      if ((paramDownloadFileRspBody == null) || (!paramBoolean))
      {
        befc.a("TroopFilePreviewWorker", befc.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult isSuccess:false  errCode:" + paramInt);
        bfaw.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
        localbfbu.jdField_a_of_type_Boolean = false;
        localamoo.c(localbfbu);
        return;
      }
      paramInt = paramDownloadFileRspBody.int32_ret_code.get();
      localbfbu.jdField_a_of_type_Int = paramInt;
      localbfbu.jdField_a_of_type_Boolean = false;
      String str = paramDownloadFileRspBody.str_download_ip.get();
      paramBundle = "";
      if (paramDownloadFileRspBody.str_download_dns.get() != null) {
        paramBundle = paramDownloadFileRspBody.str_download_dns.get().toString();
      }
      localbfbu.jdField_a_of_type_JavaLangString = str;
      if ((TextUtils.isEmpty(localbfbu.jdField_a_of_type_JavaLangString)) || (localbfbu.jdField_a_of_type_JavaLangString.equals("0.0.0.0"))) {
        localbfbu.jdField_a_of_type_JavaLangString = paramBundle;
      }
      localbfbu.b = String.valueOf(paramDownloadFileRspBody.uint32_preview_port.get());
      localbfbu.c = paramDownloadFileRspBody.str_ret_msg.get();
      localbfbu.d = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
      localbfbu.f = paramBundle;
      if (paramInt < 0)
      {
        befc.a("TroopFilePreviewWorker", befc.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult fail. retCode:" + paramInt + " retMsg:" + localbfbu.c);
        bfaw.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
        if (TextUtils.isEmpty(localbfbu.c)) {
          localbfbu.c = amtj.a(2131714363);
        }
        localbfbu.jdField_a_of_type_Boolean = false;
        localamoo.c(localbfbu);
        return;
      }
      befc.c("TroopFilePreviewWorker", befc.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult isSuccess:true  downloadip:" + str + " downloadDns:" + paramBundle + " port:" + localbfbu.b + " downloadKey:" + localbfbu.d + " retMsg:" + localbfbu.c + " httpsDomain:" + localbfbu.f);
      localbfbu.jdField_a_of_type_Boolean = true;
      localamoo.c(localbfbu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bege
 * JD-Core Version:    0.7.0.1
 */