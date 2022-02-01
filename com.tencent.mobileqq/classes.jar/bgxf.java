import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class bgxf
  extends bhhe
{
  bgxf(bgxe parambgxe, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bhhf parambhhf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onDone, status=" + parambhhf.a());
    }
    Bundle localBundle = parambhhf.a();
    int k = localBundle.getInt("callId");
    int i = localBundle.getInt("resourceType");
    boolean bool1;
    boolean bool2;
    Object localObject;
    if (parambhhf.a() == 3)
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
      if ((this.a.jdField_a_of_type_Bhhl != null) && (parambhhf.a().getBoolean("isIPC")))
      {
        parambhhf = new Bundle();
        parambhhf.putString("status", "onDone");
        parambhhf.putInt("fcStatus", 3);
        parambhhf.putInt("id", k);
        parambhhf.putInt("callId", k);
        parambhhf.putInt("srcType", localBundle.getInt("srcType"));
        parambhhf.putBoolean("result", bool2);
        parambhhf.putInt("resourceType", localBundle.getInt("resourceType"));
        parambhhf.putString("colorType", localBundle.getString("colorType"));
        parambhhf.putBoolean("result_boo", bool2);
        parambhhf.putInt("resourceType", i);
        this.a.jdField_a_of_type_Bhhl.a(parambhhf);
      }
      if (i == 3)
      {
        parambhhf = (anuk)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
        i = parambhhf.g();
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
          bcst.b((QQAppInterface)localObject, "CliOper", "", "", "0X8004A22", "0X8004A22", 0, j, "" + i, k + "", "", "");
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
        bcst.b(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, i, "" + parambhhf.g(), k + "", "", "");
        return;
        bool1 = false;
        break;
        label481:
        bool1 = bgmg.c((String)localObject + ".tmp", (String)localObject);
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
  
  public void onProgress(bhhf parambhhf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onProgress, loaded=" + parambhhf.b + "percent=" + parambhhf.a);
    }
    if ((parambhhf.a().getBoolean("isIPC")) && (this.a.jdField_a_of_type_Bhhl != null))
    {
      Bundle localBundle1 = parambhhf.a();
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("status", "onProgress");
      localBundle2.putInt("fcStatus", 2);
      localBundle2.putInt("id", localBundle1.getInt("callId"));
      localBundle2.putInt("callId", localBundle1.getInt("callId"));
      localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
      localBundle2.putInt("progress", (int)parambhhf.a);
      localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
      localBundle2.putString("colorType", localBundle1.getString("colorType"));
      this.a.jdField_a_of_type_Bhhl.a(localBundle2);
    }
  }
  
  public boolean onStart(bhhf parambhhf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onStart, loaded=" + parambhhf.b + "percent=" + parambhhf.a);
    }
    if ((parambhhf.a().getBoolean("isIPC")) && (this.a.jdField_a_of_type_Bhhl != null))
    {
      parambhhf = parambhhf.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("status", "onStart");
      localBundle.putInt("id", parambhhf.getInt("callId"));
      localBundle.putInt("fcStatus", 1);
      localBundle.putInt("callId", parambhhf.getInt("callId"));
      localBundle.putInt("srcType", parambhhf.getInt("srcType"));
      localBundle.putInt("resourceType", parambhhf.getInt("resourceType"));
      localBundle.putString("colorType", parambhhf.getString("colorType"));
      this.a.jdField_a_of_type_Bhhl.a(localBundle);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgxf
 * JD-Core Version:    0.7.0.1
 */