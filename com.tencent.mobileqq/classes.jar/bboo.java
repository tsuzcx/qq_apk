import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class bboo
  extends bbwf
{
  bboo(bbon parambbon, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bbwg parambbwg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onDone, status=" + parambbwg.a());
    }
    Bundle localBundle = parambbwg.a();
    int k = localBundle.getInt("callId");
    int i = localBundle.getInt("resourceType");
    boolean bool1;
    boolean bool2;
    Object localObject;
    if (parambbwg.a() == 3)
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
      if ((this.a.jdField_a_of_type_Bbwm != null) && (parambbwg.a().getBoolean("isIPC")))
      {
        parambbwg = new Bundle();
        parambbwg.putString("status", "onDone");
        parambbwg.putInt("fcStatus", 3);
        parambbwg.putInt("id", k);
        parambbwg.putInt("callId", k);
        parambbwg.putInt("srcType", localBundle.getInt("srcType"));
        parambbwg.putBoolean("result", bool2);
        parambbwg.putInt("resourceType", localBundle.getInt("resourceType"));
        parambbwg.putString("colorType", localBundle.getString("colorType"));
        parambbwg.putBoolean("result_boo", bool2);
        parambbwg.putInt("resourceType", i);
        this.a.jdField_a_of_type_Bbwm.a(parambbwg);
      }
      if (i == 3)
      {
        parambbwg = (akfw)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
        i = parambbwg.g();
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
          axqw.b((QQAppInterface)localObject, "CliOper", "", "", "0X8004A22", "0X8004A22", 0, j, "" + i, k + "", "", "");
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
        axqw.b(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, i, "" + parambbwg.g(), k + "", "", "");
        return;
        bool1 = false;
        break;
        label481:
        bool1 = bbdj.c((String)localObject + ".tmp", (String)localObject);
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
  
  public void onProgress(bbwg parambbwg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onProgress, loaded=" + parambbwg.b + "percent=" + parambbwg.a);
    }
    if ((parambbwg.a().getBoolean("isIPC")) && (this.a.jdField_a_of_type_Bbwm != null))
    {
      Bundle localBundle1 = parambbwg.a();
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("status", "onProgress");
      localBundle2.putInt("fcStatus", 2);
      localBundle2.putInt("id", localBundle1.getInt("callId"));
      localBundle2.putInt("callId", localBundle1.getInt("callId"));
      localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
      localBundle2.putInt("progress", (int)parambbwg.a);
      localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
      localBundle2.putString("colorType", localBundle1.getString("colorType"));
      this.a.jdField_a_of_type_Bbwm.a(localBundle2);
    }
  }
  
  public boolean onStart(bbwg parambbwg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onStart, loaded=" + parambbwg.b + "percent=" + parambbwg.a);
    }
    if ((parambbwg.a().getBoolean("isIPC")) && (this.a.jdField_a_of_type_Bbwm != null))
    {
      parambbwg = parambbwg.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("status", "onStart");
      localBundle.putInt("id", parambbwg.getInt("callId"));
      localBundle.putInt("fcStatus", 1);
      localBundle.putInt("callId", parambbwg.getInt("callId"));
      localBundle.putInt("srcType", parambbwg.getInt("srcType"));
      localBundle.putInt("resourceType", parambbwg.getInt("resourceType"));
      localBundle.putString("colorType", parambbwg.getString("colorType"));
      this.a.jdField_a_of_type_Bbwm.a(localBundle);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bboo
 * JD-Core Version:    0.7.0.1
 */