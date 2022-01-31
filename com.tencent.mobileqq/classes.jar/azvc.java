import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

class azvc
  extends xbe
{
  azvc(azvb paramazvb) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody, Bundle paramBundle)
  {
    azvb.a(this.a, null);
    if (azvb.a(this.a))
    {
      azst.b("TroopFileUploadSimpleWorker", azst.a, "[" + azvb.a(this.a) + "] onReqUploadFileResult.but stoped");
      return;
    }
    if ((paramUploadFileRspBody == null) || (!paramBoolean))
    {
      azst.a("TroopFileUploadSimpleWorker", azst.a, "[" + azvb.a(this.a) + "] onReqUploadFileResult isSuccess:false  errCode:" + paramInt);
      azvb.a(this.a, bamw.A);
      azvb.a(this.a, true);
      return;
    }
    int i = paramUploadFileRspBody.int32_ret_code.get();
    azst.c("TroopFileUploadSimpleWorker", azst.a, "[" + azvb.a(this.a) + "] onReqUploadFileResult isSuccess:true  errCode:" + paramInt + " retCode:" + i);
    if (i < 0)
    {
      azvb.a(this.a, false);
      paramInt = 207;
      switch (i)
      {
      }
      for (;;)
      {
        azvb.a(this.a, paramInt);
        return;
        paramInt = 202;
        continue;
        paramInt = 208;
        continue;
        paramInt = 210;
        continue;
        if (azvb.a(this.a) != 104)
        {
          azvb.a(this.a, 104);
          azvb.a(this.a);
          return;
          paramInt = 209;
          continue;
          paramInt = -136;
          continue;
          paramInt = -138;
          continue;
          azvb.a(this.a, paramUploadFileRspBody.str_client_wording.get());
          paramInt = 704;
        }
      }
    }
    azvb.b(this.a, paramUploadFileRspBody.str_file_id.get());
    azvb.c(this.a, paramUploadFileRspBody.str_upload_ip.get());
    azvb.d(this.a, paramUploadFileRspBody.str_server_dns.get());
    azvb.a(this.a, paramUploadFileRspBody.bytes_check_key.get().toByteArray());
    azvb.a(this.a, paramUploadFileRspBody.uint32_bus_id.get());
    azst.c("TroopFileUploadSimpleWorker", azst.a, "[" + azvb.a(this.a) + "] onReqUploadFileResult fileid:" + azvb.b(this.a) + " UploadIp:" + azvb.c(this.a) + " ServerDns:" + azvb.d(this.a) + " busId:" + azvb.a(this.a));
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azvc
 * JD-Core Version:    0.7.0.1
 */