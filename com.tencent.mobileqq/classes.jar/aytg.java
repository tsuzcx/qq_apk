import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.List;

class aytg
  extends wlu
{
  aytg(aytf paramaytf) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, ByteStringMicro paramByteStringMicro1, String paramString4, ByteStringMicro paramByteStringMicro2, Bundle paramBundle)
  {
    if (!paramBoolean)
    {
      aysb.a("TroopZipInnerFileDownloadWorker", aysb.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqDownloadResult isSuccess:false  errCode:" + paramInt1);
      this.a.jdField_a_of_type_Ayrn.c = 2;
      this.a.a(true, azle.b, azle.z, 103);
      return;
    }
    aysb.c("TroopZipInnerFileDownloadWorker", aysb.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqDownloadResult isSuccess:true  int32_ret_code:" + paramInt1);
    if ((paramInt1 == 0) || ((TextUtils.isEmpty(paramString3)) && (paramInt2 == 0)))
    {
      aysb.a("TroopZipInnerFileDownloadWorker", aysb.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqDownloadResult. no host");
      this.a.jdField_a_of_type_Ayrn.c = 1;
      this.a.jdField_a_of_type_Ayrn.d = 101;
      this.a.a(true, azle.c, azle.x, 1);
      return;
    }
    paramString1 = apck.a(paramByteStringMicro1);
    if (TextUtils.isEmpty(paramString1))
    {
      aysb.a("TroopZipInnerFileDownloadWorker", aysb.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqDownloadResult. no string_download_url");
      this.a.jdField_a_of_type_Ayrn.c = 1;
      this.a.jdField_a_of_type_Ayrn.d = 102;
      this.a.a(true, azle.b, azle.w, 1);
      return;
    }
    paramString2 = befm.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipInnerPath);
    paramByteStringMicro1 = (QQAppInterface)this.b.get();
    if ((paramByteStringMicro1 != null) && (azjg.b(paramByteStringMicro1)) && (azjg.c(paramByteStringMicro1)) && (paramBundle != null))
    {
      paramByteStringMicro1 = paramBundle.getString("strHttpsDomain");
      if (!TextUtils.isEmpty(paramByteStringMicro1))
      {
        this.a.jdField_a_of_type_Boolean = true;
        this.a.g = paramByteStringMicro1;
        int i = (short)paramBundle.getInt("httpsPort", 0);
        paramInt1 = i;
        if (i != 0) {}
      }
    }
    for (paramInt1 = 443;; paramInt1 = 0)
    {
      if (this.a.jdField_a_of_type_Boolean) {}
      for (;;)
      {
        this.a.f = ("/ftn_compress_getfile/rkey=" + paramString1 + "&filetype=" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.zipType + "&path=" + paramString2 + "&mType=Other");
        paramString1 = paramString3 + ":" + paramInt1;
        this.a.jdField_a_of_type_JavaUtilList.add(paramString1);
        if (paramInt2 != 0)
        {
          paramString2 = this.a.a(paramInt2) + ":" + paramInt1;
          this.a.jdField_a_of_type_JavaUtilList.add(paramString2);
        }
        if (this.a.jdField_a_of_type_Boolean) {
          paramString1 = "https://" + paramString1 + this.a.f;
        }
        for (;;)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.PreviewUrl = paramString1;
          try
          {
            paramString1 = new URL(paramString1);
            this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.DownloadIp = paramString1.getHost();
            aysb.c("TroopZipInnerFileDownloadWorker", aysb.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqDownloadResult. str_download_dns:" + paramString3 + " int32_server_ip:" + paramInt2 + " int32_server_port:" + paramInt3 + " mUrlParm:" + this.a.f + " port:" + paramInt1 + " isHttps:" + this.a.jdField_a_of_type_Boolean + " httpsDomain:" + this.a.g);
            this.a.g();
            return;
            paramString1 = "http://" + paramString1 + this.a.f;
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              paramString1.printStackTrace();
            }
          }
        }
        paramInt1 = paramInt3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aytg
 * JD-Core Version:    0.7.0.1
 */