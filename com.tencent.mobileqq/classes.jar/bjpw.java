import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qconn.protofile.auth.AuthResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class bjpw
  implements BusinessObserver
{
  bjpw(bjpv parambjpv, long paramLong, bjzb parambjzb, bjpq parambjpq, boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    Object localObject1 = paramBundle.getString("ssoAccount");
    QLog.d("SDK_LOGIN.ProxyAuthManager", 1, new Object[] { "ssoAccount: " + (String)localObject1 + ", uin=*" + bjqq.a(this.jdField_a_of_type_Bjzb.jdField_a_of_type_JavaLangString) + ", timeCost=" + l1, ", isSuccess=", Boolean.valueOf(paramBoolean) });
    if (!this.jdField_a_of_type_Bjzb.jdField_a_of_type_JavaLangString.equals(localObject1))
    {
      this.jdField_a_of_type_Bjpq.a(false, -1, null);
      return;
    }
    int i = paramBundle.getInt("code");
    Object localObject2;
    if (paramBoolean)
    {
      paramInt = 0;
      localObject1 = new auth.AuthResponse();
      localObject2 = localObject1;
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          byte[] arrayOfByte2 = paramBundle.getByteArray("data");
          byte[] arrayOfByte1 = arrayOfByte2;
          localObject2 = localObject1;
          if (this.jdField_a_of_type_Boolean)
          {
            localObject2 = localObject1;
            arrayOfByte1 = bjzy.b(arrayOfByte2, this.jdField_a_of_type_Bjzb);
          }
          if (arrayOfByte1 == null) {
            break label757;
          }
          localObject2 = localObject1;
          l2 = arrayOfByte1.length;
          localObject2 = localObject1;
          localObject1 = (auth.AuthResponse)((auth.AuthResponse)localObject1).mergeFrom(arrayOfByte1);
          localObject2 = localObject1;
          j = ((auth.AuthResponse)localObject1).ret.get();
          i = j;
        }
        catch (Exception paramBundle)
        {
          long l2;
          int j;
          long l3;
          localObject1 = localObject2;
        }
        try
        {
          localObject2 = ((auth.AuthResponse)localObject1).state.get();
          QLog.d("SDK_LOGIN.ProxyAuthManager", 1, new Object[] { "code=", Integer.valueOf(i), ", respState=", localObject2, ", reqState=", this.jdField_a_of_type_JavaLangString });
          if ((i != 0) || (!this.jdField_a_of_type_JavaLangString.equals(localObject2))) {
            break label752;
          }
          this.jdField_a_of_type_Bjpq.a(true, i, bjpr.a((auth.AuthResponse)localObject1));
          paramInt = 1;
        }
        catch (Exception paramBundle)
        {
          break label597;
          paramInt = 0;
          continue;
        }
        try
        {
          l3 = ((auth.AuthResponse)localObject1).toByteArray().length;
          j = ((auth.AuthResponse)localObject1).ret.get();
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("report_type", "103");
          ((Bundle)localObject2).putString("act_type", "13");
          if (paramBundle.getBoolean("isShort", false))
          {
            paramBundle = "2";
            ((Bundle)localObject2).putString("intext_3", paramBundle);
            ((Bundle)localObject2).putString("stringext_1", this.b);
            ((Bundle)localObject2).putString("intext_2", "" + j);
            ((Bundle)localObject2).putString("intext_5", "" + l1);
            bjqh.a().a((Bundle)localObject2, this.c, this.jdField_a_of_type_Bjzb.jdField_a_of_type_JavaLangString, false);
            bjvn.a().a("agent_authority", this.jdField_a_of_type_Long, l2, l3, 0, Long.parseLong(this.jdField_a_of_type_Bjzb.jdField_a_of_type_JavaLangString), "1000069", "ret: " + j);
            bjvq.a().a(0, "LOGIN_AUTH", this.jdField_a_of_type_Bjzb.jdField_a_of_type_JavaLangString, this.c, null, Long.valueOf(SystemClock.elapsedRealtime()), j, 1, null);
            if (paramInt != 0) {
              break;
            }
            this.jdField_a_of_type_Bjpq.a(false, i, bjpr.a((auth.AuthResponse)localObject1));
            return;
          }
          paramBundle = "1";
          continue;
          try
          {
            QLog.d("SDK_LOGIN.ProxyAuthManager", 1, "-->success report exception cmd: agent_authority", paramBundle);
          }
          catch (Exception paramBundle)
          {
            break label597;
          }
        }
        catch (Exception paramBundle) {}
      }
      label597:
      this.jdField_a_of_type_Bjpq.a(false, i, null);
      continue;
      this.jdField_a_of_type_Bjpq.a(false, i, null);
      try
      {
        bjvn.a().a("agent_authority", this.jdField_a_of_type_Long, 0L, 0L, i, Long.parseLong(this.jdField_a_of_type_Bjzb.jdField_a_of_type_JavaLangString), "1000069", "");
        bjvq.a().a(1, "LOGIN_AUTH", this.jdField_a_of_type_Bjzb.jdField_a_of_type_JavaLangString, this.c, null, Long.valueOf(SystemClock.elapsedRealtime()), 3002, 1, "");
        bjqh.a().a(this.jdField_a_of_type_Bjzb.jdField_a_of_type_JavaLangString, "", this.c, "1", "6", "" + 3002, false);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.d("SDK_LOGIN.ProxyAuthManager", 1, "-->failed report exception cmd: agent_authority", paramBundle);
        return;
      }
      label752:
      label757:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjpw
 * JD-Core Version:    0.7.0.1
 */