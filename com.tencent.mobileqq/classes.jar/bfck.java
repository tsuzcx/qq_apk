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

class bfck
  extends nme
{
  bfck(bfci parambfci, bfch parambfch) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_iodb_oxcd1. onResult error=" + paramInt + " data=" + paramArrayOfByte + " callback=" + this.jdField_a_of_type_Bfch);
      }
      this.jdField_a_of_type_Bfch.a(-1, "errorCode=" + paramInt);
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
            bfct localbfct = new bfct();
            localbfct.a = localStockItem.int32_productid.get();
            localbfct.b = localStockItem.int32_amount.get();
            paramBundle.add(localbfct);
            paramInt += 1;
            continue;
          }
        }
        if (paramArrayOfByte.empty_package_page.has())
        {
          paramArrayOfByte = (Oidb_0xcd1.EmptyPackagePage)paramArrayOfByte.empty_package_page.get();
          if (paramArrayOfByte != null)
          {
            paramArrayOfByte = new ztd(paramArrayOfByte);
            if (this.jdField_a_of_type_Bfch == null) {
              break;
            }
            this.jdField_a_of_type_Bfch.a(paramBundle, paramArrayOfByte);
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.i(".troop.send_gift", 2, "send_iodb_oxcd1. InvalidProtocolBufferMicroException:" + paramArrayOfByte);
        }
        this.jdField_a_of_type_Bfch.a(-1, "InvalidProtocolBufferMicroException");
        return;
      }
      paramArrayOfByte = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfck
 * JD-Core Version:    0.7.0.1
 */