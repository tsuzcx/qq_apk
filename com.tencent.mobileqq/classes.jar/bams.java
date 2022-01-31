import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class bams
  extends batl
{
  bams(bamr parambamr, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(batm parambatm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onDone, status=" + parambatm.a());
    }
    Bundle localBundle = parambatm.a();
    int k = localBundle.getInt("callId");
    int i = localBundle.getInt("resourceType");
    boolean bool1;
    boolean bool2;
    Object localObject;
    if (parambatm.a() == 3)
    {
      bool1 = true;
      bool2 = bool1;
      if (bool1)
      {
        bool2 = localBundle.getBoolean("isExists", false);
        localObject = localBundle.getString("path");
        if (!bool2) {
          break label481;
        }
        label101:
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("ColorRingManager", 2, "rename failure.");
            bool2 = bool1;
          }
        }
      }
      if ((this.a.jdField_a_of_type_Bats != null) && (parambatm.a().getBoolean("isIPC")))
      {
        parambatm = new Bundle();
        parambatm.putString("status", "onDone");
        parambatm.putInt("fcStatus", 3);
        parambatm.putInt("id", k);
        parambatm.putInt("callId", k);
        parambatm.putInt("srcType", localBundle.getInt("srcType"));
        parambatm.putBoolean("result", bool2);
        parambatm.putInt("resourceType", localBundle.getInt("resourceType"));
        parambatm.putString("colorType", localBundle.getString("colorType"));
        parambatm.putBoolean("result_boo", bool2);
        parambatm.putInt("resourceType", i);
        this.a.jdField_a_of_type_Bats.a(parambatm);
      }
      if (i == 3)
      {
        parambatm = (ajrm)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
        i = parambatm.g();
        if (i != 2) {
          break label511;
        }
        i = 0;
      }
    }
    label526:
    label531:
    for (;;)
    {
      label299:
      int j;
      if ("colorring".equals(localBundle.getString("colorType")))
      {
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (bool2)
        {
          j = 0;
          label330:
          awqx.b((QQAppInterface)localObject, "CliOper", "", "", "0X8004A22", "0X8004A22", 0, j, "" + i, k + "", "", "");
        }
      }
      else if ("comering".equals(localBundle.getString("colorType")))
      {
        if (!bool2) {
          break label526;
        }
      }
      for (i = 0;; i = 1)
      {
        awqx.b(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, i, "" + parambatm.g(), k + "", "", "");
        return;
        bool1 = false;
        break;
        label481:
        bool1 = bace.c((String)localObject + ".tmp", (String)localObject);
        break label101;
        label511:
        if (i != 3) {
          break label531;
        }
        i = 2;
        break label299;
        j = 1;
        break label330;
      }
    }
  }
  
  public void onProgress(batm parambatm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onProgress, loaded=" + parambatm.b + "percent=" + parambatm.a);
    }
    if ((parambatm.a().getBoolean("isIPC")) && (this.a.jdField_a_of_type_Bats != null))
    {
      Bundle localBundle1 = parambatm.a();
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("status", "onProgress");
      localBundle2.putInt("fcStatus", 2);
      localBundle2.putInt("id", localBundle1.getInt("callId"));
      localBundle2.putInt("callId", localBundle1.getInt("callId"));
      localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
      localBundle2.putInt("progress", (int)parambatm.a);
      localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
      localBundle2.putString("colorType", localBundle1.getString("colorType"));
      this.a.jdField_a_of_type_Bats.a(localBundle2);
    }
  }
  
  public boolean onStart(batm parambatm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onStart, loaded=" + parambatm.b + "percent=" + parambatm.a);
    }
    if ((parambatm.a().getBoolean("isIPC")) && (this.a.jdField_a_of_type_Bats != null))
    {
      parambatm = parambatm.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("status", "onStart");
      localBundle.putInt("id", parambatm.getInt("callId"));
      localBundle.putInt("fcStatus", 1);
      localBundle.putInt("callId", parambatm.getInt("callId"));
      localBundle.putInt("srcType", parambatm.getInt("srcType"));
      localBundle.putInt("resourceType", parambatm.getInt("resourceType"));
      localBundle.putString("colorType", parambatm.getString("colorType"));
      this.a.jdField_a_of_type_Bats.a(localBundle);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bams
 * JD-Core Version:    0.7.0.1
 */