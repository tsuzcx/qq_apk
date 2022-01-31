import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class becw
  extends bead
{
  becw(becr parambecr, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(beae parambeae)
  {
    super.onDone(parambeae);
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "onDone, status=" + parambeae.a() + ", task.errCode:" + parambeae.jdField_a_of_type_Int + ", key=" + parambeae.jdField_a_of_type_JavaLangString);
    }
    Bundle localBundle = parambeae.a();
    if (localBundle == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onDone Err0, key:" + parambeae.jdField_a_of_type_JavaLangString);
    }
    boolean bool;
    label121:
    do
    {
      return;
      if ((parambeae.a() != 3) || (parambeae.jdField_a_of_type_Int != 0)) {
        break;
      }
      bool = true;
      if (!bool) {
        QLog.e("VipFunCallManager", 1, "mDownloadListener onDone fail, task.getStatus():" + parambeae.a() + ", task.errCode:" + parambeae.jdField_a_of_type_Int);
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
      if ((localBundle.getBoolean("isIPC")) && (this.a.jdField_a_of_type_Beak != null))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("fcStatus", 3);
        ((Bundle)localObject).putInt("callId", i);
        ((Bundle)localObject).putInt("srcType", localBundle.getInt("srcType"));
        ((Bundle)localObject).putBoolean("result_boo", bool);
        ((Bundle)localObject).putInt("resourceType", j);
        this.a.jdField_a_of_type_Beak.a(i, parambeae.a(), (Bundle)localObject);
      }
      if (9 != becr.a()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipFunCallManager", 2, "sendBroadcast :tencent.video.q2v.AnnimateDownloadFinish");
      }
      parambeae = new Intent("tencent.video.q2v.AnnimateDownloadFinish");
      parambeae.putExtra("fun_call_id", i);
      parambeae.setPackage(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getPackageName());
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(parambeae);
      return;
      bool = false;
      break label121;
      bool = bdhb.c((String)localObject + ".tmp", (String)localObject);
    }
  }
  
  public void onProgress(beae parambeae)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "onProgress, loaded=" + parambeae.b + "percent=" + parambeae.jdField_a_of_type_Float + ", key=" + parambeae.jdField_a_of_type_JavaLangString);
    }
    Bundle localBundle1 = parambeae.a();
    if (localBundle1 == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onProgress Err0, key:" + parambeae.jdField_a_of_type_JavaLangString);
    }
    while ((localBundle1.getInt("dealType") == 0) || (!parambeae.a().getBoolean("isIPC")) || (this.a.jdField_a_of_type_Beak == null)) {
      return;
    }
    Bundle localBundle2 = new Bundle();
    localBundle2.putInt("fcStatus", 2);
    localBundle2.putInt("callId", localBundle1.getInt("callId"));
    localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
    localBundle2.putInt("progress", (int)parambeae.jdField_a_of_type_Float);
    localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
    this.a.jdField_a_of_type_Beak.a(localBundle2);
  }
  
  public boolean onStart(beae parambeae)
  {
    Bundle localBundle = parambeae.a();
    if (localBundle == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onStart Err0, key:" + parambeae.jdField_a_of_type_JavaLangString);
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
        QLog.d("VipFunCallManager", 2, "onStart, loaded=" + parambeae.b + ", percent=" + parambeae.jdField_a_of_type_Float + ", resType=" + i + ", isIPC=" + bool);
      }
    } while ((!bool) || (this.a.jdField_a_of_type_Beak == null));
    parambeae = new Bundle();
    parambeae.putInt("fcStatus", 1);
    parambeae.putInt("callId", localBundle.getInt("callId"));
    parambeae.putInt("srcType", localBundle.getInt("srcType"));
    parambeae.putInt("resourceType", i);
    this.a.jdField_a_of_type_Beak.a(parambeae);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     becw
 * JD-Core Version:    0.7.0.1
 */