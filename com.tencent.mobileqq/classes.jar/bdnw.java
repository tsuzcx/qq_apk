import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class bdnw
  extends bdvu
{
  bdnw(bdnv parambdnv, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bdvv parambdvv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onDone, status=" + parambdvv.a());
    }
    Bundle localBundle = parambdvv.a();
    int k = localBundle.getInt("callId");
    int i = localBundle.getInt("resourceType");
    boolean bool1;
    boolean bool2;
    Object localObject;
    if (parambdvv.a() == 3)
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
      if ((this.a.jdField_a_of_type_Bdwb != null) && (parambdvv.a().getBoolean("isIPC")))
      {
        parambdvv = new Bundle();
        parambdvv.putString("status", "onDone");
        parambdvv.putInt("fcStatus", 3);
        parambdvv.putInt("id", k);
        parambdvv.putInt("callId", k);
        parambdvv.putInt("srcType", localBundle.getInt("srcType"));
        parambdvv.putBoolean("result", bool2);
        parambdvv.putInt("resourceType", localBundle.getInt("resourceType"));
        parambdvv.putString("colorType", localBundle.getString("colorType"));
        parambdvv.putBoolean("result_boo", bool2);
        parambdvv.putInt("resourceType", i);
        this.a.jdField_a_of_type_Bdwb.a(parambdvv);
      }
      if (i == 3)
      {
        parambdvv = (alxl)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
        i = parambdvv.g();
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
          azmj.b((QQAppInterface)localObject, "CliOper", "", "", "0X8004A22", "0X8004A22", 0, j, "" + i, k + "", "", "");
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
        azmj.b(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, i, "" + parambdvv.g(), k + "", "", "");
        return;
        bool1 = false;
        break;
        label481:
        bool1 = bdcs.c((String)localObject + ".tmp", (String)localObject);
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
  
  public void onProgress(bdvv parambdvv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onProgress, loaded=" + parambdvv.b + "percent=" + parambdvv.a);
    }
    if ((parambdvv.a().getBoolean("isIPC")) && (this.a.jdField_a_of_type_Bdwb != null))
    {
      Bundle localBundle1 = parambdvv.a();
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("status", "onProgress");
      localBundle2.putInt("fcStatus", 2);
      localBundle2.putInt("id", localBundle1.getInt("callId"));
      localBundle2.putInt("callId", localBundle1.getInt("callId"));
      localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
      localBundle2.putInt("progress", (int)parambdvv.a);
      localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
      localBundle2.putString("colorType", localBundle1.getString("colorType"));
      this.a.jdField_a_of_type_Bdwb.a(localBundle2);
    }
  }
  
  public boolean onStart(bdvv parambdvv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onStart, loaded=" + parambdvv.b + "percent=" + parambdvv.a);
    }
    if ((parambdvv.a().getBoolean("isIPC")) && (this.a.jdField_a_of_type_Bdwb != null))
    {
      parambdvv = parambdvv.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("status", "onStart");
      localBundle.putInt("id", parambdvv.getInt("callId"));
      localBundle.putInt("fcStatus", 1);
      localBundle.putInt("callId", parambdvv.getInt("callId"));
      localBundle.putInt("srcType", parambdvv.getInt("srcType"));
      localBundle.putInt("resourceType", parambdvv.getInt("resourceType"));
      localBundle.putString("colorType", parambdvv.getString("colorType"));
      this.a.jdField_a_of_type_Bdwb.a(localBundle);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdnw
 * JD-Core Version:    0.7.0.1
 */