import android.os.Bundle;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.Map;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.TransFileRspBody;

class bcmy
  extends yul
{
  bcmy(bcmu parambcmu) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d9.TransFileRspBody paramTransFileRspBody, Bundle paramBundle)
  {
    Object localObject = this.a;
    ((bcmu)localObject).jdField_a_of_type_Int -= 1;
    if ((!paramBoolean) || (paramTransFileRspBody == null)) {
      bbvl.a("TroopFileManager", bbvl.jdField_a_of_type_Int, "onTransFileResult:  isSuccess:false");
    }
    do
    {
      return;
      localObject = paramBundle.getString("fileId");
      paramBundle = (bbsa)this.a.c.get(localObject);
    } while (paramBundle == null);
    int i = paramTransFileRspBody.int32_ret_code.get();
    bbvl.c("TroopFileManager", bbvl.jdField_a_of_type_Int, "onTransFileResult: fileId:" + (String)localObject + " isSuccess:" + paramBoolean + " errCode:" + paramInt + " retCode:" + i);
    if (i < 0)
    {
      paramInt = 501;
      switch (i)
      {
      }
      for (;;)
      {
        this.a.a(paramBundle, paramInt);
        return;
        paramInt = 504;
        continue;
        paramInt = 103;
        continue;
        paramInt = 101;
        continue;
        paramInt = 503;
        continue;
        paramInt = 502;
      }
    }
    paramTransFileRspBody = paramTransFileRspBody.str_save_file_path.get();
    this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(paramBundle.jdField_a_of_type_JavaUtilUUID, paramTransFileRspBody);
    paramBundle.b = paramTransFileRspBody;
    paramBundle.jdField_a_of_type_Int = 102;
    paramBundle.c = 0;
    this.a.c.remove(localObject);
    this.a.c.put(paramTransFileRspBody, paramBundle);
    this.a.d(paramBundle);
    paramTransFileRspBody = (bcna)this.a.d.get(paramBundle.f);
    if (paramTransFileRspBody != null) {
      paramTransFileRspBody.a = null;
    }
    this.a.a(paramBundle, 505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmy
 * JD-Core Version:    0.7.0.1
 */