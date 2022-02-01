import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0x487.oidb_0x487.RspBody;

class bfhn
  extends ntf
{
  bfhn(bfhm parambfhm, long paramLong) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_pubaccount", 2, "TroopEntranceBar fetchBindTroopInfo onResult, errorCode=" + paramInt);
    }
    if ((paramInt == 0) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      try
      {
        Object localObject = new oidb_0x487.RspBody();
        ((oidb_0x487.RspBody)localObject).mergeFrom(paramArrayOfByte);
        paramInt = ((oidb_0x487.RspBody)localObject).uint32_result.get();
        if (QLog.isColorLevel())
        {
          if (!((oidb_0x487.RspBody)localObject).bytes_errmsg.has()) {
            break label563;
          }
          paramArrayOfByte = ((oidb_0x487.RspBody)localObject).bytes_errmsg.get().toStringUtf8();
          QLog.d(".troop.troop_pubaccount", 2, "fetchBindTroopInfo onResult, ret=" + paramInt + "," + paramArrayOfByte);
        }
        if ((paramInt == 0) && (((oidb_0x487.RspBody)localObject).uint32_groups_flag.has()))
        {
          this.jdField_a_of_type_Bfhm.jdField_a_of_type_Int = ((oidb_0x487.RspBody)localObject).uint32_groups_flag.get();
          bfhm.a(this.jdField_a_of_type_Bfhm);
          this.jdField_a_of_type_Bfhm.notifyObservers(Integer.valueOf(0));
          return;
        }
        if ((paramInt == 0) && (((oidb_0x487.RspBody)localObject).uint32_follow_state.has()))
        {
          paramBundle = (bgiy)this.jdField_a_of_type_Bfhm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
          paramInt = ((oidb_0x487.RspBody)localObject).uint32_follow_state.get();
          int i = ((oidb_0x487.RspBody)localObject).uint32_remind_flag.get();
          if (i == 1)
          {
            localObject = (QQAppInterface)this.b.get();
            if (localObject == null) {
              break label562;
            }
            String str = ((QQAppInterface)localObject).getCurrentUin();
            paramArrayOfByte = (TicketManager)((QQAppInterface)localObject).getManager(2);
            if (paramArrayOfByte == null) {
              break label557;
            }
            paramArrayOfByte = paramArrayOfByte.getSkey(str);
            HashMap localHashMap = new HashMap();
            Bundle localBundle = new Bundle();
            localBundle.putString("op", "0");
            localBundle.putString("puin", "" + this.jdField_a_of_type_Long);
            localBundle.putString("Cookie", "uin=" + str + ";skey=" + paramArrayOfByte);
            localBundle.putString("Referer", "https://buluo.qq.com");
            localHashMap.put("BUNDLE", localBundle);
            localHashMap.put("CONTEXT", ((QQAppInterface)localObject).getApp().getApplicationContext());
            new bghj("https://buluo.qq.com/cgi-bin/bar/extra/clean_temp_follow_state", "", new bfho(this, paramBundle, i), 1000, null).a(localHashMap);
          }
          paramBundle.a(this.jdField_a_of_type_Bfhm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, paramInt, i);
          if (paramInt == 1)
          {
            bfhm.b(this.jdField_a_of_type_Bfhm);
            this.jdField_a_of_type_Bfhm.notifyObservers(Integer.valueOf(1));
            return;
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d(".troop.troop_pubaccount", 2, "fetchBindTroopInfo, exception=" + paramArrayOfByte.toString());
        }
      }
      for (;;)
      {
        bfhm.c(this.jdField_a_of_type_Bfhm);
        this.jdField_a_of_type_Bfhm.notifyObservers();
        return;
        QLog.d(".troop.troop_pubaccount", 2, "fetchBindTroopInfo error. errorCode=" + paramInt);
      }
      label557:
      paramArrayOfByte = null;
      continue;
      label562:
      return;
      label563:
      paramArrayOfByte = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfhn
 * JD-Core Version:    0.7.0.1
 */