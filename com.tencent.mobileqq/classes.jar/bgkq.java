import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xcd1.Oidb_0xcd1.EmptyPackagePage;
import tencent.im.oidb.cmd0xcd1.Oidb_0xcd1.GetPackageShopRsp;
import tencent.im.oidb.cmd0xcd1.Oidb_0xcd1.RspBody;
import tencent.im.oidb.cmd0xcd1.Oidb_0xcd1.StockItem;

class bgkq
  extends nte
{
  bgkq(bgko parambgko, bgkn parambgkn) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_iodb_oxcd1. onResult error=" + paramInt + " data=" + paramArrayOfByte + " callback=" + this.jdField_a_of_type_Bgkn);
      }
      this.jdField_a_of_type_Bgkn.a(-1, "errorCode=" + paramInt);
    }
    do
    {
      return;
      paramBundle = new Oidb_0xcd1.RspBody();
      if (paramArrayOfByte != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(".troop.send_gift", 2, "send_iodb_oxcd1. onResult erro data=" + null);
    return;
    for (;;)
    {
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (!paramBundle.get_pack_rsp.has()) {
          break;
        }
        paramArrayOfByte = new Oidb_0xcd1.GetPackageShopRsp();
        paramArrayOfByte.mergeFrom(((Oidb_0xcd1.GetPackageShopRsp)paramBundle.get_pack_rsp.get()).toByteArray());
        paramBundle = new ArrayList();
        if (paramArrayOfByte.msg_stock.has())
        {
          List localList = paramArrayOfByte.msg_stock.get();
          paramInt = 0;
          if (paramInt < localList.size())
          {
            Oidb_0xcd1.StockItem localStockItem = (Oidb_0xcd1.StockItem)localList.get(paramInt);
            bgkz localbgkz = new bgkz();
            localbgkz.a = localStockItem.int32_productid.get();
            localbgkz.b = localStockItem.int32_amount.get();
            paramBundle.add(localbgkz);
            paramInt += 1;
            continue;
          }
        }
        if (paramArrayOfByte.empty_package_page.has())
        {
          paramArrayOfByte = (Oidb_0xcd1.EmptyPackagePage)paramArrayOfByte.empty_package_page.get();
          if (paramArrayOfByte != null)
          {
            paramArrayOfByte = new aaip(paramArrayOfByte);
            if (this.jdField_a_of_type_Bgkn == null) {
              break;
            }
            this.jdField_a_of_type_Bgkn.a(paramBundle, paramArrayOfByte);
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.i(".troop.send_gift", 2, "send_iodb_oxcd1. InvalidProtocolBufferMicroException:" + paramArrayOfByte);
        }
        this.jdField_a_of_type_Bgkn.a(-1, "InvalidProtocolBufferMicroException");
        return;
      }
      paramArrayOfByte = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgkq
 * JD-Core Version:    0.7.0.1
 */