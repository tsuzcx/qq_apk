import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.filemanager.forward.TroopFileToTroopForwarder.2;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;

public class azub
  extends azur
{
  xbc a;
  
  protected azub(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    super(paramLong, paramItem);
    this.jdField_a_of_type_Xbc = new azuc(this);
  }
  
  public static azub a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      azsr.a("TroopFileToTroopForwarder", azsr.a, "getTroop2TroopForwarder. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      azsr.a("TroopFileToTroopForwarder", azsr.a, "getTroop2TroopForwarder. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      azsr.a("TroopFileToTroopForwarder", azsr.a, "getTroop2TroopForwarder. item.id=null");
      return null;
    }
    if (paramItem.ForwardTroopuin == 0L)
    {
      azsr.a("TroopFileToTroopForwarder", azsr.a, "getTroop2TroopForwarder. ForwardTroopuin=0");
      return null;
    }
    if ((paramItem.BusId != 102) && (paramItem.BusId != 104))
    {
      azsr.a("TroopFileToTroopForwarder", azsr.a, "getTroop2TroopForwarder. BusId err:" + paramItem.BusId);
      return null;
    }
    if (TextUtils.isEmpty(paramItem.ForwardPath))
    {
      azsr.a("TroopFileToTroopForwarder", azsr.a, "getTroop2TroopForwarder. ForwardPath=null");
      return null;
    }
    return new azub(paramLong, paramItem);
  }
  
  private final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    paramString2 = azsp.a();
    azsr.c("TroopFileToTroopForwarder", azsr.a, "[" + this.jdField_a_of_type_JavaLangString + "] onFowardToTroopResult isSuccess:true retCode:" + paramInt1);
    if (paramInt1 < 0)
    {
      paramInt2 = 207;
      switch (paramInt1)
      {
      default: 
        paramString1 = paramString3;
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        paramString1 = new bajh(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ForwardTroopuin, 5, paramInt1, paramString1);
        azsb.a(this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 5, paramString1);
        if (paramString2 == null) {
          break;
        }
        paramString1 = paramString2.a().a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.entrySessionID);
        if (paramString1 != null)
        {
          long l = paramString1.structMsgSeq;
          paramString2.a().b("" + this.d, 1, l);
        }
        return;
        paramInt1 = 202;
        paramString1 = paramString3;
        continue;
        paramInt1 = 600;
        paramString1 = paramString3;
        continue;
        paramInt1 = 701;
        paramString1 = paramString3;
        continue;
        paramInt1 = 706;
        paramString1 = ajyc.a(2131715343);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId == 102)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId = 104;
          if (paramString2 != null)
          {
            azsr.b("TroopFileToTroopForwarder", azsr.a, "[" + this.jdField_a_of_type_JavaLangString + "] onFowardToTroopResult: space no enough. fowrd temp.");
            xap.a(paramString2, false, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.d, 0L, this.jdField_a_of_type_Xbc);
            return;
          }
          paramInt1 = 204;
          paramString1 = paramString3;
        }
        else
        {
          paramInt1 = 204;
          paramString1 = paramString3;
          continue;
          paramInt1 = -139;
          paramString1 = paramString3;
          continue;
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile)) && (new VFSFile(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile).exists()))
          {
            azsr.b("TroopFileToTroopForwarder", azsr.a, "[" + this.jdField_a_of_type_JavaLangString + "] onFowardToTroopResult: -6101. start local uploadl.");
            azuu.a().a(this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, null);
            return;
          }
          paramInt1 = 603;
          paramString1 = paramString3;
          continue;
          paramInt1 = 705;
          paramString1 = paramString3;
        }
      }
      azsr.a("TroopFileToTroopForwarder", azsr.a, "[" + this.jdField_a_of_type_JavaLangString + "] onFowardToTroopResult fail. removeMsgByUniseq fail.");
      return;
    }
    new Handler(Looper.getMainLooper()).post(new TroopFileToTroopForwarder.2(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath = paramString1;
    azsr.c("TroopFileToTroopForwarder", azsr.a, "[" + this.jdField_a_of_type_JavaLangString + "] onFowardToTroopResult sucess. mItem.FilePath:" + paramString1);
    paramString3 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getInfo(this.d);
    if (paramString3 != null) {
      paramString3.e = paramString1;
    }
    if (paramString2 != null)
    {
      paramString2 = paramString2.a().a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.entrySessionID);
      if (paramString2 != null) {
        paramString2.strTroopFilePath = paramString1;
      }
    }
    for (;;)
    {
      azsb.a(this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 7, 0);
      j();
      return;
      azsr.a("TroopFileToTroopForwarder", azsr.a, "[" + this.jdField_a_of_type_JavaLangString + "] onFowardToTroopResult sucess. update entity.strTroopFilePath fail.");
    }
  }
  
  private int b()
  {
    QQAppInterface localQQAppInterface = azsp.a();
    if (localQQAppInterface == null)
    {
      azsr.a("TroopFileToTroopForwarder", azsr.a, "[" + this.jdField_a_of_type_JavaLangString + "] startTroop2Troop app=null");
      return -1;
    }
    azsr.c("TroopFileToTroopForwarder", azsr.a, "[" + this.jdField_a_of_type_JavaLangString + "] startTroop2Troop. BusId:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId + " ForwardBusId:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ForwardBusId + " ForwardPath:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ForwardPath + " entrySessionID:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.entrySessionID + " with:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.width + " height:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.height);
    xap.a(localQQAppInterface, false, this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.d, 0L, this.jdField_a_of_type_Xbc);
    azsb.a(this.d, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 4, 0);
    return 0;
  }
  
  public int a()
  {
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azub
 * JD-Core Version:    0.7.0.1
 */