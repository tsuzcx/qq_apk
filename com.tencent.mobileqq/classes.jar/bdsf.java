import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class bdsf
  extends bead
{
  bdsf(bdse parambdse, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(beae parambeae)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onDone, status=" + parambeae.a());
    }
    Bundle localBundle = parambeae.a();
    int k = localBundle.getInt("callId");
    int i = localBundle.getInt("resourceType");
    boolean bool1;
    boolean bool2;
    Object localObject;
    if (parambeae.a() == 3)
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
      if ((this.a.jdField_a_of_type_Beak != null) && (parambeae.a().getBoolean("isIPC")))
      {
        parambeae = new Bundle();
        parambeae.putString("status", "onDone");
        parambeae.putInt("fcStatus", 3);
        parambeae.putInt("id", k);
        parambeae.putInt("callId", k);
        parambeae.putInt("srcType", localBundle.getInt("srcType"));
        parambeae.putBoolean("result", bool2);
        parambeae.putInt("resourceType", localBundle.getInt("resourceType"));
        parambeae.putString("colorType", localBundle.getString("colorType"));
        parambeae.putBoolean("result_boo", bool2);
        parambeae.putInt("resourceType", i);
        this.a.jdField_a_of_type_Beak.a(parambeae);
      }
      if (i == 3)
      {
        parambeae = (amca)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
        i = parambeae.g();
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
          azqs.b((QQAppInterface)localObject, "CliOper", "", "", "0X8004A22", "0X8004A22", 0, j, "" + i, k + "", "", "");
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
        azqs.b(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, i, "" + parambeae.g(), k + "", "", "");
        return;
        bool1 = false;
        break;
        label481:
        bool1 = bdhb.c((String)localObject + ".tmp", (String)localObject);
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
  
  public void onProgress(beae parambeae)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onProgress, loaded=" + parambeae.b + "percent=" + parambeae.a);
    }
    if ((parambeae.a().getBoolean("isIPC")) && (this.a.jdField_a_of_type_Beak != null))
    {
      Bundle localBundle1 = parambeae.a();
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("status", "onProgress");
      localBundle2.putInt("fcStatus", 2);
      localBundle2.putInt("id", localBundle1.getInt("callId"));
      localBundle2.putInt("callId", localBundle1.getInt("callId"));
      localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
      localBundle2.putInt("progress", (int)parambeae.a);
      localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
      localBundle2.putString("colorType", localBundle1.getString("colorType"));
      this.a.jdField_a_of_type_Beak.a(localBundle2);
    }
  }
  
  public boolean onStart(beae parambeae)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onStart, loaded=" + parambeae.b + "percent=" + parambeae.a);
    }
    if ((parambeae.a().getBoolean("isIPC")) && (this.a.jdField_a_of_type_Beak != null))
    {
      parambeae = parambeae.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("status", "onStart");
      localBundle.putInt("id", parambeae.getInt("callId"));
      localBundle.putInt("fcStatus", 1);
      localBundle.putInt("callId", parambeae.getInt("callId"));
      localBundle.putInt("srcType", parambeae.getInt("srcType"));
      localBundle.putInt("resourceType", parambeae.getInt("resourceType"));
      localBundle.putString("colorType", parambeae.getString("colorType"));
      this.a.jdField_a_of_type_Beak.a(localBundle);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsf
 * JD-Core Version:    0.7.0.1
 */