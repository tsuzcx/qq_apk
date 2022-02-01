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

class bfwt
  extends aavn
{
  bfwt(bfws parambfws) {}
  
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
    bgsg localbgsg = new bgsg();
    localbgsg.jdField_a_of_type_Int = -1;
    try
    {
      localbgsg.e = this.a.a().toString();
      localQQAppInterface = bfvp.a();
      if (localQQAppInterface == null)
      {
        bfvr.a("TroopFilePreviewWorker", bfvr.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult app=null");
        return;
      }
    }
    catch (NullPointerException paramBundle)
    {
      QQAppInterface localQQAppInterface;
      for (;;)
      {
        localbgsg.e = null;
      }
      antz localantz = (antz)localQQAppInterface.a(22);
      if ((paramDownloadFileRspBody == null) || (!paramBoolean))
      {
        bfvr.a("TroopFilePreviewWorker", bfvr.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult isSuccess:false  errCode:" + paramInt);
        bgri.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
        localbgsg.jdField_a_of_type_Boolean = false;
        localantz.c(localbgsg);
        return;
      }
      paramInt = paramDownloadFileRspBody.int32_ret_code.get();
      localbgsg.jdField_a_of_type_Int = paramInt;
      localbgsg.jdField_a_of_type_Boolean = false;
      String str = paramDownloadFileRspBody.str_download_ip.get();
      paramBundle = "";
      if (paramDownloadFileRspBody.str_download_dns.get() != null) {
        paramBundle = paramDownloadFileRspBody.str_download_dns.get().toString();
      }
      localbgsg.jdField_a_of_type_JavaLangString = str;
      if ((TextUtils.isEmpty(localbgsg.jdField_a_of_type_JavaLangString)) || (localbgsg.jdField_a_of_type_JavaLangString.equals("0.0.0.0"))) {
        localbgsg.jdField_a_of_type_JavaLangString = paramBundle;
      }
      localbgsg.b = String.valueOf(paramDownloadFileRspBody.uint32_preview_port.get());
      localbgsg.c = paramDownloadFileRspBody.str_ret_msg.get();
      localbgsg.d = bhml.a(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
      localbgsg.f = paramBundle;
      if (paramInt < 0)
      {
        bfvr.a("TroopFilePreviewWorker", bfvr.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult fail. retCode:" + paramInt + " retMsg:" + localbgsg.c);
        bgri.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
        if (TextUtils.isEmpty(localbgsg.c)) {
          localbgsg.c = anzj.a(2131714131);
        }
        localbgsg.jdField_a_of_type_Boolean = false;
        localantz.c(localbgsg);
        return;
      }
      bfvr.c("TroopFilePreviewWorker", bfvr.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult isSuccess:true  downloadip:" + str + " downloadDns:" + paramBundle + " port:" + localbgsg.b + " downloadKey:" + localbgsg.d + " retMsg:" + localbgsg.c + " httpsDomain:" + localbgsg.f);
      localbgsg.jdField_a_of_type_Boolean = true;
      localantz.c(localbgsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfwt
 * JD-Core Version:    0.7.0.1
 */