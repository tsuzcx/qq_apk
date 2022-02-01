import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

class bfon
  extends aahq
{
  bfon(bfom parambfom) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody, Bundle paramBundle)
  {
    bfom.a(this.a, null);
    if (bfom.a(this.a))
    {
      bfmf.b("TroopFileUploadSimpleWorker", bfmf.a, "[" + bfom.a(this.a) + "] onReqUploadFileResult.but stoped");
      return;
    }
    if ((paramUploadFileRspBody == null) || (!paramBoolean))
    {
      bfmf.a("TroopFileUploadSimpleWorker", bfmf.a, "[" + bfom.a(this.a) + "] onReqUploadFileResult isSuccess:false  errCode:" + paramInt);
      bfom.a(this.a, bgme.A);
      bfom.a(this.a, true);
      return;
    }
    int i = paramUploadFileRspBody.int32_ret_code.get();
    bfmf.c("TroopFileUploadSimpleWorker", bfmf.a, "[" + bfom.a(this.a) + "] onReqUploadFileResult isSuccess:true  errCode:" + paramInt + " retCode:" + i);
    if (i < 0)
    {
      bfom.a(this.a, false);
      paramInt = 207;
      switch (i)
      {
      }
      for (;;)
      {
        bfom.a(this.a, paramInt);
        return;
        paramInt = 202;
        continue;
        paramInt = 208;
        continue;
        paramInt = 210;
        continue;
        if (bfom.a(this.a) != 104)
        {
          bfom.a(this.a, 104);
          bfom.a(this.a);
          return;
          paramInt = 209;
          continue;
          paramInt = -136;
          continue;
          paramInt = -138;
          continue;
          bfom.a(this.a, paramUploadFileRspBody.str_client_wording.get());
          paramInt = 704;
        }
      }
    }
    bfom.b(this.a, paramUploadFileRspBody.str_file_id.get());
    bfom.c(this.a, paramUploadFileRspBody.str_upload_ip.get());
    bfom.d(this.a, paramUploadFileRspBody.str_server_dns.get());
    bfom.a(this.a, paramUploadFileRspBody.bytes_check_key.get().toByteArray());
    bfom.a(this.a, paramUploadFileRspBody.uint32_bus_id.get());
    bfmf.c("TroopFileUploadSimpleWorker", bfmf.a, "[" + bfom.a(this.a) + "] onReqUploadFileResult fileid:" + bfom.b(this.a) + " UploadIp:" + bfom.c(this.a) + " ServerDns:" + bfom.d(this.a) + " busId:" + bfom.a(this.a));
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfon
 * JD-Core Version:    0.7.0.1
 */