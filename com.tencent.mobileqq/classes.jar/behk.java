import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

class behk
  extends zse
{
  behk(behj parambehj) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody, Bundle paramBundle)
  {
    behj.a(this.a, null);
    if (behj.a(this.a))
    {
      befc.b("TroopFileUploadSimpleWorker", befc.a, "[" + behj.a(this.a) + "] onReqUploadFileResult.but stoped");
      return;
    }
    if ((paramUploadFileRspBody == null) || (!paramBoolean))
    {
      befc.a("TroopFileUploadSimpleWorker", befc.a, "[" + behj.a(this.a) + "] onReqUploadFileResult isSuccess:false  errCode:" + paramInt);
      behj.a(this.a, bfdy.A);
      behj.a(this.a, true);
      return;
    }
    int i = paramUploadFileRspBody.int32_ret_code.get();
    befc.c("TroopFileUploadSimpleWorker", befc.a, "[" + behj.a(this.a) + "] onReqUploadFileResult isSuccess:true  errCode:" + paramInt + " retCode:" + i);
    if (i < 0)
    {
      behj.a(this.a, false);
      paramInt = 207;
      switch (i)
      {
      }
      for (;;)
      {
        behj.a(this.a, paramInt);
        return;
        paramInt = 202;
        continue;
        paramInt = 208;
        continue;
        paramInt = 210;
        continue;
        if (behj.a(this.a) != 104)
        {
          behj.a(this.a, 104);
          behj.a(this.a);
          return;
          paramInt = 209;
          continue;
          paramInt = -136;
          continue;
          paramInt = -138;
          continue;
          behj.a(this.a, paramUploadFileRspBody.str_client_wording.get());
          paramInt = 704;
        }
      }
    }
    behj.b(this.a, paramUploadFileRspBody.str_file_id.get());
    behj.c(this.a, paramUploadFileRspBody.str_upload_ip.get());
    behj.d(this.a, paramUploadFileRspBody.str_server_dns.get());
    behj.a(this.a, paramUploadFileRspBody.bytes_check_key.get().toByteArray());
    behj.a(this.a, paramUploadFileRspBody.uint32_bus_id.get());
    befc.c("TroopFileUploadSimpleWorker", befc.a, "[" + behj.a(this.a) + "] onReqUploadFileResult fileid:" + behj.b(this.a) + " UploadIp:" + behj.c(this.a) + " ServerDns:" + behj.d(this.a) + " busId:" + behj.a(this.a));
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     behk
 * JD-Core Version:    0.7.0.1
 */