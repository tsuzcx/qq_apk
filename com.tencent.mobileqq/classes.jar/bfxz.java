import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

class bfxz
  extends aavr
{
  bfxz(bfxy parambfxy) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody, Bundle paramBundle)
  {
    bfxy.a(this.a, null);
    if (bfxy.a(this.a))
    {
      bfvr.b("TroopFileUploadSimpleWorker", bfvr.a, "[" + bfxy.a(this.a) + "] onReqUploadFileResult.but stoped");
      return;
    }
    if ((paramUploadFileRspBody == null) || (!paramBoolean))
    {
      bfvr.a("TroopFileUploadSimpleWorker", bfvr.a, "[" + bfxy.a(this.a) + "] onReqUploadFileResult isSuccess:false  errCode:" + paramInt);
      bfxy.a(this.a, bguk.A);
      bfxy.a(this.a, true);
      return;
    }
    int i = paramUploadFileRspBody.int32_ret_code.get();
    bfvr.c("TroopFileUploadSimpleWorker", bfvr.a, "[" + bfxy.a(this.a) + "] onReqUploadFileResult isSuccess:true  errCode:" + paramInt + " retCode:" + i);
    if (i < 0)
    {
      bfxy.a(this.a, false);
      paramInt = 207;
      switch (i)
      {
      }
      for (;;)
      {
        bfxy.a(this.a, paramInt);
        return;
        paramInt = 202;
        continue;
        paramInt = 208;
        continue;
        paramInt = 210;
        continue;
        if (bfxy.a(this.a) != 104)
        {
          bfxy.a(this.a, 104);
          bfxy.a(this.a);
          return;
          paramInt = 209;
          continue;
          paramInt = -136;
          continue;
          paramInt = -138;
          continue;
          bfxy.a(this.a, paramUploadFileRspBody.str_client_wording.get());
          paramInt = 704;
        }
      }
    }
    bfxy.b(this.a, paramUploadFileRspBody.str_file_id.get());
    bfxy.c(this.a, paramUploadFileRspBody.str_upload_ip.get());
    bfxy.d(this.a, paramUploadFileRspBody.str_server_dns.get());
    bfxy.a(this.a, paramUploadFileRspBody.bytes_check_key.get().toByteArray());
    bfxy.a(this.a, paramUploadFileRspBody.uint32_bus_id.get());
    bfvr.c("TroopFileUploadSimpleWorker", bfvr.a, "[" + bfxy.a(this.a) + "] onReqUploadFileResult fileid:" + bfxy.b(this.a) + " UploadIp:" + bfxy.c(this.a) + " ServerDns:" + bfxy.d(this.a) + " busId:" + bfxy.a(this.a));
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxz
 * JD-Core Version:    0.7.0.1
 */