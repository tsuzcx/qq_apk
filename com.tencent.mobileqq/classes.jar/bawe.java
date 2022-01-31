import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class bawe
  extends batl
{
  bawe(bavz parambavz, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "onDone, status=" + parambatm.a() + ", task.errCode:" + parambatm.jdField_a_of_type_Int + ", key=" + parambatm.jdField_a_of_type_JavaLangString);
    }
    Bundle localBundle = parambatm.a();
    if (localBundle == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onDone Err0, key:" + parambatm.jdField_a_of_type_JavaLangString);
    }
    boolean bool;
    label121:
    do
    {
      return;
      if ((parambatm.a() != 3) || (parambatm.jdField_a_of_type_Int != 0)) {
        break;
      }
      bool = true;
      if (!bool) {
        QLog.e("VipFunCallManager", 1, "mDownloadListener onDone fail, task.getStatus():" + parambatm.a() + ", task.errCode:" + parambatm.jdField_a_of_type_Int);
      }
    } while (localBundle.getInt("dealType") == 0);
    int i = localBundle.getInt("callId");
    int j = localBundle.getInt("resourceType");
    Object localObject = localBundle.getString("path");
    if (localBundle.getBoolean("isExists", false)) {}
    for (;;)
    {
      if (!bool) {
        QLog.e("VipFunCallManager", 1, "mDownloadListener onDone rename failure. path:" + (String)localObject);
      }
      if ((localBundle.getBoolean("isIPC")) && (this.a.jdField_a_of_type_Bats != null))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("fcStatus", 3);
        ((Bundle)localObject).putInt("callId", i);
        ((Bundle)localObject).putInt("srcType", localBundle.getInt("srcType"));
        ((Bundle)localObject).putBoolean("result_boo", bool);
        ((Bundle)localObject).putInt("resourceType", j);
        this.a.jdField_a_of_type_Bats.a(i, parambatm.a(), (Bundle)localObject);
      }
      if (9 != bavz.a()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipFunCallManager", 2, "sendBroadcast :tencent.video.q2v.AnnimateDownloadFinish");
      }
      parambatm = new Intent("tencent.video.q2v.AnnimateDownloadFinish");
      parambatm.putExtra("fun_call_id", i);
      parambatm.setPackage(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getPackageName());
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(parambatm);
      return;
      bool = false;
      break label121;
      bool = bace.c((String)localObject + ".tmp", (String)localObject);
    }
  }
  
  public void onProgress(batm parambatm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "onProgress, loaded=" + parambatm.b + "percent=" + parambatm.jdField_a_of_type_Float + ", key=" + parambatm.jdField_a_of_type_JavaLangString);
    }
    Bundle localBundle1 = parambatm.a();
    if (localBundle1 == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onProgress Err0, key:" + parambatm.jdField_a_of_type_JavaLangString);
    }
    while ((localBundle1.getInt("dealType") == 0) || (!parambatm.a().getBoolean("isIPC")) || (this.a.jdField_a_of_type_Bats == null)) {
      return;
    }
    Bundle localBundle2 = new Bundle();
    localBundle2.putInt("fcStatus", 2);
    localBundle2.putInt("callId", localBundle1.getInt("callId"));
    localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
    localBundle2.putInt("progress", (int)parambatm.jdField_a_of_type_Float);
    localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
    this.a.jdField_a_of_type_Bats.a(localBundle2);
  }
  
  public boolean onStart(batm parambatm)
  {
    Bundle localBundle = parambatm.a();
    if (localBundle == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onStart Err0, key:" + parambatm.jdField_a_of_type_JavaLangString);
    }
    int i;
    boolean bool;
    do
    {
      do
      {
        return true;
      } while (localBundle.getInt("dealType") == 0);
      i = localBundle.getInt("resourceType");
      bool = localBundle.getBoolean("isIPC");
      if (QLog.isColorLevel()) {
        QLog.d("VipFunCallManager", 2, "onStart, loaded=" + parambatm.b + ", percent=" + parambatm.jdField_a_of_type_Float + ", resType=" + i + ", isIPC=" + bool);
      }
    } while ((!bool) || (this.a.jdField_a_of_type_Bats == null));
    parambatm = new Bundle();
    parambatm.putInt("fcStatus", 1);
    parambatm.putInt("callId", localBundle.getInt("callId"));
    parambatm.putInt("srcType", localBundle.getInt("srcType"));
    parambatm.putInt("resourceType", i);
    this.a.jdField_a_of_type_Bats.a(parambatm);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bawe
 * JD-Core Version:    0.7.0.1
 */