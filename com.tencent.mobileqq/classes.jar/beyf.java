import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

class beyf
  extends aaro
{
  beyf(beye parambeye) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody, Bundle paramBundle)
  {
    beye.a(this.a, null);
    if (beye.a(this.a))
    {
      bevx.b("TroopFileUploadSimpleWorker", bevx.a, "[" + beye.a(this.a) + "] onReqUploadFileResult.but stoped");
      return;
    }
    if ((paramUploadFileRspBody == null) || (!paramBoolean))
    {
      bevx.a("TroopFileUploadSimpleWorker", bevx.a, "[" + beye.a(this.a) + "] onReqUploadFileResult isSuccess:false  errCode:" + paramInt);
      beye.a(this.a, bfuj.A);
      beye.a(this.a, true);
      return;
    }
    int i = paramUploadFileRspBody.int32_ret_code.get();
    bevx.c("TroopFileUploadSimpleWorker", bevx.a, "[" + beye.a(this.a) + "] onReqUploadFileResult isSuccess:true  errCode:" + paramInt + " retCode:" + i);
    if (i < 0)
    {
      beye.a(this.a, false);
      paramInt = 207;
      switch (i)
      {
      }
      for (;;)
      {
        beye.a(this.a, paramInt);
        return;
        paramInt = 202;
        continue;
        paramInt = 208;
        continue;
        paramInt = 210;
        continue;
        if (beye.a(this.a) != 104)
        {
          beye.a(this.a, 104);
          beye.a(this.a);
          return;
          paramInt = 209;
          continue;
          paramInt = -136;
          continue;
          paramInt = -138;
          continue;
          beye.a(this.a, paramUploadFileRspBody.str_client_wording.get());
          paramInt = 704;
        }
      }
    }
    beye.b(this.a, paramUploadFileRspBody.str_file_id.get());
    beye.c(this.a, paramUploadFileRspBody.str_upload_ip.get());
    beye.d(this.a, paramUploadFileRspBody.str_server_dns.get());
    beye.a(this.a, paramUploadFileRspBody.bytes_check_key.get().toByteArray());
    beye.a(this.a, paramUploadFileRspBody.uint32_bus_id.get());
    bevx.c("TroopFileUploadSimpleWorker", bevx.a, "[" + beye.a(this.a) + "] onReqUploadFileResult fileid:" + beye.b(this.a) + " UploadIp:" + beye.c(this.a) + " ServerDns:" + beye.d(this.a) + " busId:" + beye.a(this.a));
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beyf
 * JD-Core Version:    0.7.0.1
 */