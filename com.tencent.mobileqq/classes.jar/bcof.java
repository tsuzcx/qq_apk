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

class bcof
  extends nab
{
  bcof(bcod parambcod, bcoc parambcoc) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_gift", 2, "send_iodb_oxcd1. onResult error=" + paramInt + " data=" + paramArrayOfByte + " callback=" + this.jdField_a_of_type_Bcoc);
      }
      this.jdField_a_of_type_Bcoc.a(-1, "errorCode=" + paramInt);
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
            bcoo localbcoo = new bcoo();
            localbcoo.a = localStockItem.int32_productid.get();
            localbcoo.b = localStockItem.int32_amount.get();
            paramBundle.add(localbcoo);
            paramInt += 1;
            continue;
          }
        }
        if (paramArrayOfByte.empty_package_page.has())
        {
          paramArrayOfByte = (Oidb_0xcd1.EmptyPackagePage)paramArrayOfByte.empty_package_page.get();
          if (paramArrayOfByte != null)
          {
            paramArrayOfByte = new yvm(paramArrayOfByte);
            if (this.jdField_a_of_type_Bcoc == null) {
              break;
            }
            this.jdField_a_of_type_Bcoc.a(paramBundle, paramArrayOfByte);
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.i(".troop.send_gift", 2, "send_iodb_oxcd1. InvalidProtocolBufferMicroException:" + paramArrayOfByte);
        }
        this.jdField_a_of_type_Bcoc.a(-1, "InvalidProtocolBufferMicroException");
        return;
      }
      paramArrayOfByte = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcof
 * JD-Core Version:    0.7.0.1
 */