import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class bbzm
  extends bbwt
{
  bbzm(bbzh parambbzh, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "onDone, status=" + parambbwu.a() + ", task.errCode:" + parambbwu.jdField_a_of_type_Int + ", key=" + parambbwu.jdField_a_of_type_JavaLangString);
    }
    Bundle localBundle = parambbwu.a();
    if (localBundle == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onDone Err0, key:" + parambbwu.jdField_a_of_type_JavaLangString);
    }
    boolean bool;
    label121:
    do
    {
      return;
      if ((parambbwu.a() != 3) || (parambbwu.jdField_a_of_type_Int != 0)) {
        break;
      }
      bool = true;
      if (!bool) {
        QLog.e("VipFunCallManager", 1, "mDownloadListener onDone fail, task.getStatus():" + parambbwu.a() + ", task.errCode:" + parambbwu.jdField_a_of_type_Int);
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
      if ((localBundle.getBoolean("isIPC")) && (this.a.jdField_a_of_type_Bbxa != null))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("fcStatus", 3);
        ((Bundle)localObject).putInt("callId", i);
        ((Bundle)localObject).putInt("srcType", localBundle.getInt("srcType"));
        ((Bundle)localObject).putBoolean("result_boo", bool);
        ((Bundle)localObject).putInt("resourceType", j);
        this.a.jdField_a_of_type_Bbxa.a(i, parambbwu.a(), (Bundle)localObject);
      }
      if (9 != bbzh.a()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipFunCallManager", 2, "sendBroadcast :tencent.video.q2v.AnnimateDownloadFinish");
      }
      parambbwu = new Intent("tencent.video.q2v.AnnimateDownloadFinish");
      parambbwu.putExtra("fun_call_id", i);
      parambbwu.setPackage(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getPackageName());
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(parambbwu);
      return;
      bool = false;
      break label121;
      bool = bbdx.c((String)localObject + ".tmp", (String)localObject);
    }
  }
  
  public void onProgress(bbwu parambbwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "onProgress, loaded=" + parambbwu.b + "percent=" + parambbwu.jdField_a_of_type_Float + ", key=" + parambbwu.jdField_a_of_type_JavaLangString);
    }
    Bundle localBundle1 = parambbwu.a();
    if (localBundle1 == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onProgress Err0, key:" + parambbwu.jdField_a_of_type_JavaLangString);
    }
    while ((localBundle1.getInt("dealType") == 0) || (!parambbwu.a().getBoolean("isIPC")) || (this.a.jdField_a_of_type_Bbxa == null)) {
      return;
    }
    Bundle localBundle2 = new Bundle();
    localBundle2.putInt("fcStatus", 2);
    localBundle2.putInt("callId", localBundle1.getInt("callId"));
    localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
    localBundle2.putInt("progress", (int)parambbwu.jdField_a_of_type_Float);
    localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
    this.a.jdField_a_of_type_Bbxa.a(localBundle2);
  }
  
  public boolean onStart(bbwu parambbwu)
  {
    Bundle localBundle = parambbwu.a();
    if (localBundle == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onStart Err0, key:" + parambbwu.jdField_a_of_type_JavaLangString);
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
        QLog.d("VipFunCallManager", 2, "onStart, loaded=" + parambbwu.b + ", percent=" + parambbwu.jdField_a_of_type_Float + ", resType=" + i + ", isIPC=" + bool);
      }
    } while ((!bool) || (this.a.jdField_a_of_type_Bbxa == null));
    parambbwu = new Bundle();
    parambbwu.putInt("fcStatus", 1);
    parambbwu.putInt("callId", localBundle.getInt("callId"));
    parambbwu.putInt("srcType", localBundle.getInt("srcType"));
    parambbwu.putInt("resourceType", i);
    this.a.jdField_a_of_type_Bbxa.a(parambbwu);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbzm
 * JD-Core Version:    0.7.0.1
 */