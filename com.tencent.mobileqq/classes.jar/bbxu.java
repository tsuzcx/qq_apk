import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

class bbxu
  extends yum
{
  bbxu(bbxt parambbxt) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody, Bundle paramBundle)
  {
    bbxt.a(this.a, null);
    if (bbxt.a(this.a))
    {
      bbvl.b("TroopFileUploadSimpleWorker", bbvl.a, "[" + bbxt.a(this.a) + "] onReqUploadFileResult.but stoped");
      return;
    }
    if ((paramUploadFileRspBody == null) || (!paramBoolean))
    {
      bbvl.a("TroopFileUploadSimpleWorker", bbvl.a, "[" + bbxt.a(this.a) + "] onReqUploadFileResult isSuccess:false  errCode:" + paramInt);
      bbxt.a(this.a, bcps.A);
      bbxt.a(this.a, true);
      return;
    }
    int i = paramUploadFileRspBody.int32_ret_code.get();
    bbvl.c("TroopFileUploadSimpleWorker", bbvl.a, "[" + bbxt.a(this.a) + "] onReqUploadFileResult isSuccess:true  errCode:" + paramInt + " retCode:" + i);
    if (i < 0)
    {
      bbxt.a(this.a, false);
      paramInt = 207;
      switch (i)
      {
      }
      for (;;)
      {
        bbxt.a(this.a, paramInt);
        return;
        paramInt = 202;
        continue;
        paramInt = 208;
        continue;
        paramInt = 210;
        continue;
        if (bbxt.a(this.a) != 104)
        {
          bbxt.a(this.a, 104);
          bbxt.a(this.a);
          return;
          paramInt = 209;
          continue;
          paramInt = -136;
          continue;
          paramInt = -138;
          continue;
          bbxt.a(this.a, paramUploadFileRspBody.str_client_wording.get());
          paramInt = 704;
        }
      }
    }
    bbxt.b(this.a, paramUploadFileRspBody.str_file_id.get());
    bbxt.c(this.a, paramUploadFileRspBody.str_upload_ip.get());
    bbxt.d(this.a, paramUploadFileRspBody.str_server_dns.get());
    bbxt.a(this.a, paramUploadFileRspBody.bytes_check_key.get().toByteArray());
    bbxt.a(this.a, paramUploadFileRspBody.uint32_bus_id.get());
    bbvl.c("TroopFileUploadSimpleWorker", bbvl.a, "[" + bbxt.a(this.a) + "] onReqUploadFileResult fileid:" + bbxt.b(this.a) + " UploadIp:" + bbxt.c(this.a) + " ServerDns:" + bbxt.d(this.a) + " busId:" + bbxt.a(this.a));
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxu
 * JD-Core Version:    0.7.0.1
 */