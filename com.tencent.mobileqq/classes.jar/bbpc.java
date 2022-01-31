import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class bbpc
  extends bbwt
{
  bbpc(bbpb parambbpb, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bbwu parambbwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onDone, status=" + parambbwu.a());
    }
    Bundle localBundle = parambbwu.a();
    int k = localBundle.getInt("callId");
    int i = localBundle.getInt("resourceType");
    boolean bool1;
    boolean bool2;
    Object localObject;
    if (parambbwu.a() == 3)
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
      if ((this.a.jdField_a_of_type_Bbxa != null) && (parambbwu.a().getBoolean("isIPC")))
      {
        parambbwu = new Bundle();
        parambbwu.putString("status", "onDone");
        parambbwu.putInt("fcStatus", 3);
        parambbwu.putInt("id", k);
        parambbwu.putInt("callId", k);
        parambbwu.putInt("srcType", localBundle.getInt("srcType"));
        parambbwu.putBoolean("result", bool2);
        parambbwu.putInt("resourceType", localBundle.getInt("resourceType"));
        parambbwu.putString("colorType", localBundle.getString("colorType"));
        parambbwu.putBoolean("result_boo", bool2);
        parambbwu.putInt("resourceType", i);
        this.a.jdField_a_of_type_Bbxa.a(parambbwu);
      }
      if (i == 3)
      {
        parambbwu = (akfv)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
        i = parambbwu.g();
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
          axqy.b((QQAppInterface)localObject, "CliOper", "", "", "0X8004A22", "0X8004A22", 0, j, "" + i, k + "", "", "");
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
        axqy.b(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, i, "" + parambbwu.g(), k + "", "", "");
        return;
        bool1 = false;
        break;
        label481:
        bool1 = bbdx.c((String)localObject + ".tmp", (String)localObject);
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
  
  public void onProgress(bbwu parambbwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onProgress, loaded=" + parambbwu.b + "percent=" + parambbwu.a);
    }
    if ((parambbwu.a().getBoolean("isIPC")) && (this.a.jdField_a_of_type_Bbxa != null))
    {
      Bundle localBundle1 = parambbwu.a();
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("status", "onProgress");
      localBundle2.putInt("fcStatus", 2);
      localBundle2.putInt("id", localBundle1.getInt("callId"));
      localBundle2.putInt("callId", localBundle1.getInt("callId"));
      localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
      localBundle2.putInt("progress", (int)parambbwu.a);
      localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
      localBundle2.putString("colorType", localBundle1.getString("colorType"));
      this.a.jdField_a_of_type_Bbxa.a(localBundle2);
    }
  }
  
  public boolean onStart(bbwu parambbwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onStart, loaded=" + parambbwu.b + "percent=" + parambbwu.a);
    }
    if ((parambbwu.a().getBoolean("isIPC")) && (this.a.jdField_a_of_type_Bbxa != null))
    {
      parambbwu = parambbwu.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("status", "onStart");
      localBundle.putInt("id", parambbwu.getInt("callId"));
      localBundle.putInt("fcStatus", 1);
      localBundle.putInt("callId", parambbwu.getInt("callId"));
      localBundle.putInt("srcType", parambbwu.getInt("srcType"));
      localBundle.putInt("resourceType", parambbwu.getInt("resourceType"));
      localBundle.putString("colorType", parambbwu.getString("colorType"));
      this.a.jdField_a_of_type_Bbxa.a(localBundle);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbpc
 * JD-Core Version:    0.7.0.1
 */