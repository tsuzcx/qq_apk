import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class bhxj
  extends biht
{
  bhxj(bhxi parambhxi, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bihu parambihu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onDone, status=" + parambihu.a());
    }
    Bundle localBundle = parambihu.a();
    int k = localBundle.getInt("callId");
    int i = localBundle.getInt("resourceType");
    boolean bool1;
    boolean bool2;
    Object localObject;
    if (parambihu.a() == 3)
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
      if ((this.a.jdField_a_of_type_Biia != null) && (parambihu.a().getBoolean("isIPC")))
      {
        parambihu = new Bundle();
        parambihu.putString("status", "onDone");
        parambihu.putInt("fcStatus", 3);
        parambihu.putInt("id", k);
        parambihu.putInt("callId", k);
        parambihu.putInt("srcType", localBundle.getInt("srcType"));
        parambihu.putBoolean("result", bool2);
        parambihu.putInt("resourceType", localBundle.getInt("resourceType"));
        parambihu.putString("colorType", localBundle.getString("colorType"));
        parambihu.putBoolean("result_boo", bool2);
        parambihu.putInt("resourceType", i);
        this.a.jdField_a_of_type_Biia.a(parambihu);
      }
      if (i == 3)
      {
        parambihu = (aogu)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
        i = parambihu.g();
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
          bdll.b((QQAppInterface)localObject, "CliOper", "", "", "0X8004A22", "0X8004A22", 0, j, "" + i, k + "", "", "");
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
        bdll.b(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, i, "" + parambihu.g(), k + "", "", "");
        return;
        bool1 = false;
        break;
        label481:
        bool1 = bhmi.c((String)localObject + ".tmp", (String)localObject);
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
  
  public void onProgress(bihu parambihu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onProgress, loaded=" + parambihu.b + "percent=" + parambihu.a);
    }
    if ((parambihu.a().getBoolean("isIPC")) && (this.a.jdField_a_of_type_Biia != null))
    {
      Bundle localBundle1 = parambihu.a();
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("status", "onProgress");
      localBundle2.putInt("fcStatus", 2);
      localBundle2.putInt("id", localBundle1.getInt("callId"));
      localBundle2.putInt("callId", localBundle1.getInt("callId"));
      localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
      localBundle2.putInt("progress", (int)parambihu.a);
      localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
      localBundle2.putString("colorType", localBundle1.getString("colorType"));
      this.a.jdField_a_of_type_Biia.a(localBundle2);
    }
  }
  
  public boolean onStart(bihu parambihu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onStart, loaded=" + parambihu.b + "percent=" + parambihu.a);
    }
    if ((parambihu.a().getBoolean("isIPC")) && (this.a.jdField_a_of_type_Biia != null))
    {
      parambihu = parambihu.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("status", "onStart");
      localBundle.putInt("id", parambihu.getInt("callId"));
      localBundle.putInt("fcStatus", 1);
      localBundle.putInt("callId", parambihu.getInt("callId"));
      localBundle.putInt("srcType", parambihu.getInt("srcType"));
      localBundle.putInt("resourceType", parambihu.getInt("resourceType"));
      localBundle.putString("colorType", parambihu.getString("colorType"));
      this.a.jdField_a_of_type_Biia.a(localBundle);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhxj
 * JD-Core Version:    0.7.0.1
 */