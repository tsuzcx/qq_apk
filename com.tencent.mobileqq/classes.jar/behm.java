import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadWorker.1.1;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

public class behm
  extends zse
{
  behm(behl parambehl) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody, Bundle paramBundle)
  {
    long l = paramBundle.getLong("troopUin");
    if (!behl.a(this.a, paramBundle, l)) {
      return;
    }
    if ((paramUploadFileRspBody == null) || (!paramBoolean))
    {
      befc.a("TroopFileUploadWorker", befc.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqUploadFileResult isSuccess:false  errCode:" + paramInt);
      this.a.jdField_a_of_type_Been.c = 1;
      this.a.jdField_a_of_type_Been.d = paramInt;
      paramUploadFileRspBody = new bfay(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.a.d, 3, 207);
      this.a.a(true, bfdy.b, bfdy.A, paramUploadFileRspBody);
      return;
    }
    int j = paramUploadFileRspBody.int32_ret_code.get();
    befc.c("TroopFileUploadWorker", befc.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqUploadFileResult isSuccess:true  errCode:" + paramInt + " retCode:" + j);
    if (j < 0)
    {
      paramBundle = null;
      int i;
      switch (j)
      {
      default: 
        i = 207;
        paramBoolean = true;
        paramUploadFileRspBody = paramBundle;
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Been.c = 1;
        this.a.jdField_a_of_type_Been.d = j;
        paramBundle = paramUploadFileRspBody;
        if (paramUploadFileRspBody == null) {
          paramBundle = new bfay(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, l, 3, i);
        }
        this.a.a(paramBoolean, bfdy.c, paramInt, paramBundle);
        return;
        i = 202;
        paramBoolean = true;
        paramUploadFileRspBody = paramBundle;
        continue;
        i = 208;
        paramBoolean = true;
        paramUploadFileRspBody = paramBundle;
        continue;
        new Handler(Looper.getMainLooper()).postDelayed(new TroopFileUploadWorker.1.1(this, l), 1000L);
        return;
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId != 104)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId = 104;
          this.a.m();
          return;
        }
        i = 204;
        paramBoolean = true;
        paramUploadFileRspBody = paramBundle;
        continue;
        i = 209;
        paramBoolean = true;
        paramUploadFileRspBody = paramBundle;
        continue;
        i = -136;
        paramBoolean = true;
        paramUploadFileRspBody = paramBundle;
        continue;
        i = -138;
        paramBoolean = true;
        paramUploadFileRspBody = paramBundle;
        continue;
        paramUploadFileRspBody = paramUploadFileRspBody.str_client_wording.get();
        paramUploadFileRspBody = new bfay(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, l, 3, 704, paramUploadFileRspBody);
        i = 207;
        paramBoolean = false;
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath = paramUploadFileRspBody.str_file_id.get();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp = paramUploadFileRspBody.str_upload_ip.get();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns = paramUploadFileRspBody.str_server_dns.get();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.CheckKey = paramUploadFileRspBody.bytes_check_key.get().toByteArray();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId = paramUploadFileRspBody.uint32_bus_id.get();
    befc.c("TroopFileUploadWorker", befc.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqUploadFileResult fileid:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath + " UploadIp:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp + " ServerDns:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ServerDns + " busId:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId);
    this.a.a(paramUploadFileRspBody);
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     behm
 * JD-Core Version:    0.7.0.1
 */