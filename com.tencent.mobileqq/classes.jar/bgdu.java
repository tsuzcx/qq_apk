import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class bgdu
  extends bgod
{
  bgdu(bgdt parambgdt, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bgoe parambgoe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onDone, status=" + parambgoe.a());
    }
    Bundle localBundle = parambgoe.a();
    int k = localBundle.getInt("callId");
    int i = localBundle.getInt("resourceType");
    boolean bool1;
    boolean bool2;
    Object localObject;
    if (parambgoe.a() == 3)
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
      if ((this.a.jdField_a_of_type_Bgok != null) && (parambgoe.a().getBoolean("isIPC")))
      {
        parambgoe = new Bundle();
        parambgoe.putString("status", "onDone");
        parambgoe.putInt("fcStatus", 3);
        parambgoe.putInt("id", k);
        parambgoe.putInt("callId", k);
        parambgoe.putInt("srcType", localBundle.getInt("srcType"));
        parambgoe.putBoolean("result", bool2);
        parambgoe.putInt("resourceType", localBundle.getInt("resourceType"));
        parambgoe.putString("colorType", localBundle.getString("colorType"));
        parambgoe.putBoolean("result_boo", bool2);
        parambgoe.putInt("resourceType", i);
        this.a.jdField_a_of_type_Bgok.a(parambgoe);
      }
      if (i == 3)
      {
        parambgoe = (anaj)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(13);
        i = parambgoe.g();
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
          bcef.b((QQAppInterface)localObject, "CliOper", "", "", "0X8004A22", "0X8004A22", 0, j, "" + i, k + "", "", "");
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
        bcef.b(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, i, "" + parambgoe.g(), k + "", "", "");
        return;
        bool1 = false;
        break;
        label481:
        bool1 = FileUtils.rename((String)localObject + ".tmp", (String)localObject);
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
  
  public void onProgress(bgoe parambgoe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onProgress, loaded=" + parambgoe.b + "percent=" + parambgoe.a);
    }
    if ((parambgoe.a().getBoolean("isIPC")) && (this.a.jdField_a_of_type_Bgok != null))
    {
      Bundle localBundle1 = parambgoe.a();
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("status", "onProgress");
      localBundle2.putInt("fcStatus", 2);
      localBundle2.putInt("id", localBundle1.getInt("callId"));
      localBundle2.putInt("callId", localBundle1.getInt("callId"));
      localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
      localBundle2.putInt("progress", (int)parambgoe.a);
      localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
      localBundle2.putString("colorType", localBundle1.getString("colorType"));
      this.a.jdField_a_of_type_Bgok.a(localBundle2);
    }
  }
  
  public boolean onStart(bgoe parambgoe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "onStart, loaded=" + parambgoe.b + "percent=" + parambgoe.a);
    }
    if ((parambgoe.a().getBoolean("isIPC")) && (this.a.jdField_a_of_type_Bgok != null))
    {
      parambgoe = parambgoe.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("status", "onStart");
      localBundle.putInt("id", parambgoe.getInt("callId"));
      localBundle.putInt("fcStatus", 1);
      localBundle.putInt("callId", parambgoe.getInt("callId"));
      localBundle.putInt("srcType", parambgoe.getInt("srcType"));
      localBundle.putInt("resourceType", parambgoe.getInt("resourceType"));
      localBundle.putString("colorType", parambgoe.getString("colorType"));
      this.a.jdField_a_of_type_Bgok.a(localBundle);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdu
 * JD-Core Version:    0.7.0.1
 */