import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

class bbtl
  extends ypx
{
  bbtl(bbtk parambbtk) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody, Bundle paramBundle)
  {
    bbtk.a(this.a, null);
    if (bbtk.a(this.a))
    {
      bbrc.b("TroopFileUploadSimpleWorker", bbrc.a, "[" + bbtk.a(this.a) + "] onReqUploadFileResult.but stoped");
      return;
    }
    if ((paramUploadFileRspBody == null) || (!paramBoolean))
    {
      bbrc.a("TroopFileUploadSimpleWorker", bbrc.a, "[" + bbtk.a(this.a) + "] onReqUploadFileResult isSuccess:false  errCode:" + paramInt);
      bbtk.a(this.a, bclj.A);
      bbtk.a(this.a, true);
      return;
    }
    int i = paramUploadFileRspBody.int32_ret_code.get();
    bbrc.c("TroopFileUploadSimpleWorker", bbrc.a, "[" + bbtk.a(this.a) + "] onReqUploadFileResult isSuccess:true  errCode:" + paramInt + " retCode:" + i);
    if (i < 0)
    {
      bbtk.a(this.a, false);
      paramInt = 207;
      switch (i)
      {
      }
      for (;;)
      {
        bbtk.a(this.a, paramInt);
        return;
        paramInt = 202;
        continue;
        paramInt = 208;
        continue;
        paramInt = 210;
        continue;
        if (bbtk.a(this.a) != 104)
        {
          bbtk.a(this.a, 104);
          bbtk.a(this.a);
          return;
          paramInt = 209;
          continue;
          paramInt = -136;
          continue;
          paramInt = -138;
          continue;
          bbtk.a(this.a, paramUploadFileRspBody.str_client_wording.get());
          paramInt = 704;
        }
      }
    }
    bbtk.b(this.a, paramUploadFileRspBody.str_file_id.get());
    bbtk.c(this.a, paramUploadFileRspBody.str_upload_ip.get());
    bbtk.d(this.a, paramUploadFileRspBody.str_server_dns.get());
    bbtk.a(this.a, paramUploadFileRspBody.bytes_check_key.get().toByteArray());
    bbtk.a(this.a, paramUploadFileRspBody.uint32_bus_id.get());
    bbrc.c("TroopFileUploadSimpleWorker", bbrc.a, "[" + bbtk.a(this.a) + "] onReqUploadFileResult fileid:" + bbtk.b(this.a) + " UploadIp:" + bbtk.c(this.a) + " ServerDns:" + bbtk.d(this.a) + " busId:" + bbtk.a(this.a));
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbtl
 * JD-Core Version:    0.7.0.1
 */