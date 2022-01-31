import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

class ayuk
  extends wme
{
  ayuk(ayuj paramayuj) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody, Bundle paramBundle)
  {
    ayuj.a(this.a, null);
    if (ayuj.a(this.a))
    {
      aysb.b("TroopFileUploadSimpleWorker", aysb.a, "[" + ayuj.a(this.a) + "] onReqUploadFileResult.but stoped");
      return;
    }
    if ((paramUploadFileRspBody == null) || (!paramBoolean))
    {
      aysb.a("TroopFileUploadSimpleWorker", aysb.a, "[" + ayuj.a(this.a) + "] onReqUploadFileResult isSuccess:false  errCode:" + paramInt);
      ayuj.a(this.a, azle.z);
      ayuj.a(this.a, true);
      return;
    }
    int i = paramUploadFileRspBody.int32_ret_code.get();
    aysb.c("TroopFileUploadSimpleWorker", aysb.a, "[" + ayuj.a(this.a) + "] onReqUploadFileResult isSuccess:true  errCode:" + paramInt + " retCode:" + i);
    if (i < 0)
    {
      ayuj.a(this.a, false);
      paramInt = 207;
      switch (i)
      {
      }
      for (;;)
      {
        ayuj.a(this.a, paramInt);
        return;
        paramInt = 202;
        continue;
        paramInt = 208;
        continue;
        paramInt = 210;
        continue;
        if (ayuj.a(this.a) != 104)
        {
          ayuj.a(this.a, 104);
          ayuj.a(this.a);
          return;
          paramInt = 209;
          continue;
          paramInt = -136;
          continue;
          paramInt = -138;
          continue;
          ayuj.a(this.a, paramUploadFileRspBody.str_client_wording.get());
          paramInt = 704;
        }
      }
    }
    ayuj.b(this.a, paramUploadFileRspBody.str_file_id.get());
    ayuj.c(this.a, paramUploadFileRspBody.str_upload_ip.get());
    ayuj.d(this.a, paramUploadFileRspBody.str_server_dns.get());
    ayuj.a(this.a, paramUploadFileRspBody.bytes_check_key.get().toByteArray());
    ayuj.a(this.a, paramUploadFileRspBody.uint32_bus_id.get());
    aysb.c("TroopFileUploadSimpleWorker", aysb.a, "[" + ayuj.a(this.a) + "] onReqUploadFileResult fileid:" + ayuj.b(this.a) + " UploadIp:" + ayuj.c(this.a) + " ServerDns:" + ayuj.d(this.a) + " busId:" + ayuj.a(this.a));
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayuk
 * JD-Core Version:    0.7.0.1
 */