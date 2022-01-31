import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class bdyn
  extends bdvu
{
  bdyn(bdyi parambdyi, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "onDone, status=" + parambdvv.a() + ", task.errCode:" + parambdvv.jdField_a_of_type_Int + ", key=" + parambdvv.jdField_a_of_type_JavaLangString);
    }
    Bundle localBundle = parambdvv.a();
    if (localBundle == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onDone Err0, key:" + parambdvv.jdField_a_of_type_JavaLangString);
    }
    boolean bool;
    label121:
    do
    {
      return;
      if ((parambdvv.a() != 3) || (parambdvv.jdField_a_of_type_Int != 0)) {
        break;
      }
      bool = true;
      if (!bool) {
        QLog.e("VipFunCallManager", 1, "mDownloadListener onDone fail, task.getStatus():" + parambdvv.a() + ", task.errCode:" + parambdvv.jdField_a_of_type_Int);
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
      if ((localBundle.getBoolean("isIPC")) && (this.a.jdField_a_of_type_Bdwb != null))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("fcStatus", 3);
        ((Bundle)localObject).putInt("callId", i);
        ((Bundle)localObject).putInt("srcType", localBundle.getInt("srcType"));
        ((Bundle)localObject).putBoolean("result_boo", bool);
        ((Bundle)localObject).putInt("resourceType", j);
        this.a.jdField_a_of_type_Bdwb.a(i, parambdvv.a(), (Bundle)localObject);
      }
      if (9 != bdyi.a()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipFunCallManager", 2, "sendBroadcast :tencent.video.q2v.AnnimateDownloadFinish");
      }
      parambdvv = new Intent("tencent.video.q2v.AnnimateDownloadFinish");
      parambdvv.putExtra("fun_call_id", i);
      parambdvv.setPackage(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getPackageName());
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(parambdvv);
      return;
      bool = false;
      break label121;
      bool = bdcs.c((String)localObject + ".tmp", (String)localObject);
    }
  }
  
  public void onProgress(bdvv parambdvv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "onProgress, loaded=" + parambdvv.b + "percent=" + parambdvv.jdField_a_of_type_Float + ", key=" + parambdvv.jdField_a_of_type_JavaLangString);
    }
    Bundle localBundle1 = parambdvv.a();
    if (localBundle1 == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onProgress Err0, key:" + parambdvv.jdField_a_of_type_JavaLangString);
    }
    while ((localBundle1.getInt("dealType") == 0) || (!parambdvv.a().getBoolean("isIPC")) || (this.a.jdField_a_of_type_Bdwb == null)) {
      return;
    }
    Bundle localBundle2 = new Bundle();
    localBundle2.putInt("fcStatus", 2);
    localBundle2.putInt("callId", localBundle1.getInt("callId"));
    localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
    localBundle2.putInt("progress", (int)parambdvv.jdField_a_of_type_Float);
    localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
    this.a.jdField_a_of_type_Bdwb.a(localBundle2);
  }
  
  public boolean onStart(bdvv parambdvv)
  {
    Bundle localBundle = parambdvv.a();
    if (localBundle == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onStart Err0, key:" + parambdvv.jdField_a_of_type_JavaLangString);
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
        QLog.d("VipFunCallManager", 2, "onStart, loaded=" + parambdvv.b + ", percent=" + parambdvv.jdField_a_of_type_Float + ", resType=" + i + ", isIPC=" + bool);
      }
    } while ((!bool) || (this.a.jdField_a_of_type_Bdwb == null));
    parambdvv = new Bundle();
    parambdvv.putInt("fcStatus", 1);
    parambdvv.putInt("callId", localBundle.getInt("callId"));
    parambdvv.putInt("srcType", localBundle.getInt("srcType"));
    parambdvv.putInt("resourceType", i);
    this.a.jdField_a_of_type_Bdwb.a(parambdvv);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyn
 * JD-Core Version:    0.7.0.1
 */