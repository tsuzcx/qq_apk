import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

class azva
  extends xbh
{
  azva(azuz paramazuz) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody, Bundle paramBundle)
  {
    azuz.a(this.a, null);
    if (azuz.a(this.a))
    {
      azsr.b("TroopFileUploadSimpleWorker", azsr.a, "[" + azuz.a(this.a) + "] onReqUploadFileResult.but stoped");
      return;
    }
    if ((paramUploadFileRspBody == null) || (!paramBoolean))
    {
      azsr.a("TroopFileUploadSimpleWorker", azsr.a, "[" + azuz.a(this.a) + "] onReqUploadFileResult isSuccess:false  errCode:" + paramInt);
      azuz.a(this.a, bami.A);
      azuz.a(this.a, true);
      return;
    }
    int i = paramUploadFileRspBody.int32_ret_code.get();
    azsr.c("TroopFileUploadSimpleWorker", azsr.a, "[" + azuz.a(this.a) + "] onReqUploadFileResult isSuccess:true  errCode:" + paramInt + " retCode:" + i);
    if (i < 0)
    {
      azuz.a(this.a, false);
      paramInt = 207;
      switch (i)
      {
      }
      for (;;)
      {
        azuz.a(this.a, paramInt);
        return;
        paramInt = 202;
        continue;
        paramInt = 208;
        continue;
        paramInt = 210;
        continue;
        if (azuz.a(this.a) != 104)
        {
          azuz.a(this.a, 104);
          azuz.a(this.a);
          return;
          paramInt = 209;
          continue;
          paramInt = -136;
          continue;
          paramInt = -138;
          continue;
          azuz.a(this.a, paramUploadFileRspBody.str_client_wording.get());
          paramInt = 704;
        }
      }
    }
    azuz.b(this.a, paramUploadFileRspBody.str_file_id.get());
    azuz.c(this.a, paramUploadFileRspBody.str_upload_ip.get());
    azuz.d(this.a, paramUploadFileRspBody.str_server_dns.get());
    azuz.a(this.a, paramUploadFileRspBody.bytes_check_key.get().toByteArray());
    azuz.a(this.a, paramUploadFileRspBody.uint32_bus_id.get());
    azsr.c("TroopFileUploadSimpleWorker", azsr.a, "[" + azuz.a(this.a) + "] onReqUploadFileResult fileid:" + azuz.b(this.a) + " UploadIp:" + azuz.c(this.a) + " ServerDns:" + azuz.d(this.a) + " busId:" + azuz.a(this.a));
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azva
 * JD-Core Version:    0.7.0.1
 */