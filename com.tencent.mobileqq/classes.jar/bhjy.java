import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class bhjy
  extends bhhe
{
  bhjy(bhjt parambhjt, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "onDone, status=" + parambhhf.a() + ", task.errCode:" + parambhhf.jdField_a_of_type_Int + ", key=" + parambhhf.jdField_a_of_type_JavaLangString);
    }
    Bundle localBundle = parambhhf.a();
    if (localBundle == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onDone Err0, key:" + parambhhf.jdField_a_of_type_JavaLangString);
    }
    boolean bool;
    label121:
    do
    {
      return;
      if ((parambhhf.a() != 3) || (parambhhf.jdField_a_of_type_Int != 0)) {
        break;
      }
      bool = true;
      if (!bool) {
        QLog.e("VipFunCallManager", 1, "mDownloadListener onDone fail, task.getStatus():" + parambhhf.a() + ", task.errCode:" + parambhhf.jdField_a_of_type_Int);
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
      if ((localBundle.getBoolean("isIPC")) && (this.a.jdField_a_of_type_Bhhl != null))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("fcStatus", 3);
        ((Bundle)localObject).putInt("callId", i);
        ((Bundle)localObject).putInt("srcType", localBundle.getInt("srcType"));
        ((Bundle)localObject).putBoolean("result_boo", bool);
        ((Bundle)localObject).putInt("resourceType", j);
        this.a.jdField_a_of_type_Bhhl.a(i, parambhhf.a(), (Bundle)localObject);
      }
      if (9 != bhjt.a()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipFunCallManager", 2, "sendBroadcast :tencent.video.q2v.AnnimateDownloadFinish");
      }
      parambhhf = new Intent("tencent.video.q2v.AnnimateDownloadFinish");
      parambhhf.putExtra("fun_call_id", i);
      parambhhf.setPackage(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getPackageName());
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(parambhhf);
      return;
      bool = false;
      break label121;
      bool = bgmg.c((String)localObject + ".tmp", (String)localObject);
    }
  }
  
  public void onProgress(bhhf parambhhf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "onProgress, loaded=" + parambhhf.b + "percent=" + parambhhf.jdField_a_of_type_Float + ", key=" + parambhhf.jdField_a_of_type_JavaLangString);
    }
    Bundle localBundle1 = parambhhf.a();
    if (localBundle1 == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onProgress Err0, key:" + parambhhf.jdField_a_of_type_JavaLangString);
    }
    while ((localBundle1.getInt("dealType") == 0) || (!parambhhf.a().getBoolean("isIPC")) || (this.a.jdField_a_of_type_Bhhl == null)) {
      return;
    }
    Bundle localBundle2 = new Bundle();
    localBundle2.putInt("fcStatus", 2);
    localBundle2.putInt("callId", localBundle1.getInt("callId"));
    localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
    localBundle2.putInt("progress", (int)parambhhf.jdField_a_of_type_Float);
    localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
    this.a.jdField_a_of_type_Bhhl.a(localBundle2);
  }
  
  public boolean onStart(bhhf parambhhf)
  {
    Bundle localBundle = parambhhf.a();
    if (localBundle == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onStart Err0, key:" + parambhhf.jdField_a_of_type_JavaLangString);
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
        QLog.d("VipFunCallManager", 2, "onStart, loaded=" + parambhhf.b + ", percent=" + parambhhf.jdField_a_of_type_Float + ", resType=" + i + ", isIPC=" + bool);
      }
    } while ((!bool) || (this.a.jdField_a_of_type_Bhhl == null));
    parambhhf = new Bundle();
    parambhhf.putInt("fcStatus", 1);
    parambhhf.putInt("callId", localBundle.getInt("callId"));
    parambhhf.putInt("srcType", localBundle.getInt("srcType"));
    parambhhf.putInt("resourceType", i);
    this.a.jdField_a_of_type_Bhhl.a(parambhhf);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhjy
 * JD-Core Version:    0.7.0.1
 */