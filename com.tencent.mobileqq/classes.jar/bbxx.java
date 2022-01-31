import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.ResendRspBody;

class bbxx
  extends yuk
{
  bbxx(bbxv parambbxv) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.ResendRspBody paramResendRspBody, Bundle paramBundle)
  {
    if (paramBundle.getLong("troopUin") != this.a.d) {}
    do
    {
      return;
      paramBundle = paramBundle.getString("itemKey");
    } while ((paramBundle == null) || (!UUID.fromString(paramBundle).equals(this.a.a())));
    if (this.a.jdField_a_of_type_Boolean)
    {
      bbvl.b("TroopFileUploadWorker", bbvl.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqResendFileResult.but stoped");
      return;
    }
    if ((paramResendRspBody == null) || (!paramBoolean))
    {
      bbvl.a("TroopFileUploadWorker", bbvl.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqResendFileResult isSuccess:false  errCode:" + paramInt);
      paramResendRspBody = new bcmr(this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.a.d, 3, 207);
      this.a.jdField_a_of_type_Bbux.c = 1;
      this.a.jdField_a_of_type_Bbux.d = paramInt;
      this.a.a(true, bcps.b, bcps.A, paramResendRspBody);
      return;
    }
    int i = paramResendRspBody.int32_ret_code.get();
    bbvl.c("TroopFileUploadWorker", bbvl.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqResendFileResult isSuccess:true  errCode:" + paramInt + " retCode:" + i);
    if (i < 0)
    {
      switch (paramResendRspBody.int32_ret_code.get())
      {
      default: 
        paramInt = 1;
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Bbux.c = 1;
        this.a.jdField_a_of_type_Bbux.d = i;
        if (paramInt != 206) {
          break;
        }
        bbuv.b(this.a.d, this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, paramInt);
        this.a.a(false, bcps.c, i);
        return;
        paramInt = 101;
        continue;
        paramInt = 102;
        continue;
        paramInt = 206;
        continue;
        paramInt = -136;
        continue;
        paramInt = -138;
      }
      this.a.a(true, bcps.c, i, paramInt);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp = paramResendRspBody.str_upload_ip.get();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.CheckKey = paramResendRspBody.bytes_check_key.get().toByteArray();
    bbvl.c("TroopFileUploadWorker", bbvl.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqResendFileResult fileid:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath + " UploadIp:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.UploadIp + " busId:" + this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId);
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxx
 * JD-Core Version:    0.7.0.1
 */