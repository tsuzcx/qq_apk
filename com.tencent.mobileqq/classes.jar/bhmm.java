import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class bhmm
  extends bhyn
{
  bhmm(bhml parambhml, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bhyo parambhyo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onDone, status=" + parambhyo.a());
    }
    Bundle localBundle = parambhyo.a();
    int k = localBundle.getInt("callId");
    int i = localBundle.getInt("resourceType");
    boolean bool1;
    boolean bool2;
    Object localObject;
    if (parambhyo.a() == 3)
    {
      bool1 = true;
      bool2 = bool1;
      if (bool1)
      {
        bool2 = localBundle.getBoolean("isExists", false);
        localObject = localBundle.getString("path");
        if (!bool2) {
          break label482;
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
      if ((this.a.jdField_a_of_type_Bhyu != null) && (parambhyo.a().getBoolean("isIPC")))
      {
        parambhyo = new Bundle();
        parambhyo.putString("status", "onDone");
        parambhyo.putInt("fcStatus", 3);
        parambhyo.putInt("id", k);
        parambhyo.putInt("callId", k);
        parambhyo.putInt("srcType", localBundle.getInt("srcType"));
        parambhyo.putBoolean("result", bool2);
        parambhyo.putInt("resourceType", localBundle.getInt("resourceType"));
        parambhyo.putString("colorType", localBundle.getString("colorType"));
        parambhyo.putBoolean("result_boo", bool2);
        parambhyo.putInt("resourceType", i);
        this.a.jdField_a_of_type_Bhyu.a(parambhyo);
      }
      if (i == 3)
      {
        parambhyo = (aocy)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
        i = parambhyo.g();
        if (i != 2) {
          break label512;
        }
        i = 0;
      }
    }
    label512:
    label527:
    label532:
    for (;;)
    {
      label300:
      int j;
      if ("colorring".equals(localBundle.getString("colorType")))
      {
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (bool2)
        {
          j = 0;
          label331:
          bdla.b((QQAppInterface)localObject, "CliOper", "", "", "0X8004A22", "0X8004A22", 0, j, "" + i, k + "", "", "");
        }
      }
      else if ("comering".equals(localBundle.getString("colorType")))
      {
        if (!bool2) {
          break label527;
        }
      }
      for (i = 0;; i = 1)
      {
        bdla.b(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, i, "" + parambhyo.g(), k + "", "", "");
        return;
        bool1 = false;
        break;
        label482:
        bool1 = FileUtils.rename((String)localObject + ".tmp", (String)localObject);
        break label101;
        if (i != 3) {
          break label532;
        }
        i = 2;
        break label300;
        j = 1;
        break label331;
      }
    }
  }
  
  public void onProgress(bhyo parambhyo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onProgress, loaded=" + parambhyo.b + "percent=" + parambhyo.a);
    }
    if ((parambhyo.a().getBoolean("isIPC")) && (this.a.jdField_a_of_type_Bhyu != null))
    {
      Bundle localBundle1 = parambhyo.a();
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("status", "onProgress");
      localBundle2.putInt("fcStatus", 2);
      localBundle2.putInt("id", localBundle1.getInt("callId"));
      localBundle2.putInt("callId", localBundle1.getInt("callId"));
      localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
      localBundle2.putInt("progress", (int)parambhyo.a);
      localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
      localBundle2.putString("colorType", localBundle1.getString("colorType"));
      this.a.jdField_a_of_type_Bhyu.a(localBundle2);
    }
  }
  
  public boolean onStart(bhyo parambhyo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onStart, loaded=" + parambhyo.b + "percent=" + parambhyo.a);
    }
    if ((parambhyo.a().getBoolean("isIPC")) && (this.a.jdField_a_of_type_Bhyu != null))
    {
      parambhyo = parambhyo.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("status", "onStart");
      localBundle.putInt("id", parambhyo.getInt("callId"));
      localBundle.putInt("fcStatus", 1);
      localBundle.putInt("callId", parambhyo.getInt("callId"));
      localBundle.putInt("srcType", parambhyo.getInt("srcType"));
      localBundle.putInt("resourceType", parambhyo.getInt("resourceType"));
      localBundle.putString("colorType", parambhyo.getString("colorType"));
      this.a.jdField_a_of_type_Bhyu.a(localBundle);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhmm
 * JD-Core Version:    0.7.0.1
 */