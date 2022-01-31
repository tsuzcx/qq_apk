import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class bakl
  extends akim
{
  bakl(bakk parambakk) {}
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(150);
      localStringBuilder.append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
      QLog.i("TroopGagMgr", 2, localStringBuilder.toString());
    }
    if (((paramInt1 == 6) || (paramInt1 == 3)) && (paramBoolean))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramString = (oidb_0x899.memberlist)paramList.next();
        if ((paramString != null) && (paramString.uint64_member_uin.has()) && (paramString.uint32_shutup_timestap.has()))
        {
          paramLong2 = paramString.uint32_shutup_timestap.get();
          long l = paramString.uint64_member_uin.get();
          ((TroopManager)this.a.a.getManager(52)).a(paramLong1 + "", l + "", paramLong2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bakl
 * JD-Core Version:    0.7.0.1
 */