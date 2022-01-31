import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class bbyy
  extends bbwf
{
  bbyy(bbyt parambbyt, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "onDone, status=" + parambbwg.a() + ", task.errCode:" + parambbwg.jdField_a_of_type_Int + ", key=" + parambbwg.jdField_a_of_type_JavaLangString);
    }
    Bundle localBundle = parambbwg.a();
    if (localBundle == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onDone Err0, key:" + parambbwg.jdField_a_of_type_JavaLangString);
    }
    boolean bool;
    label121:
    do
    {
      return;
      if ((parambbwg.a() != 3) || (parambbwg.jdField_a_of_type_Int != 0)) {
        break;
      }
      bool = true;
      if (!bool) {
        QLog.e("VipFunCallManager", 1, "mDownloadListener onDone fail, task.getStatus():" + parambbwg.a() + ", task.errCode:" + parambbwg.jdField_a_of_type_Int);
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
      if ((localBundle.getBoolean("isIPC")) && (this.a.jdField_a_of_type_Bbwm != null))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("fcStatus", 3);
        ((Bundle)localObject).putInt("callId", i);
        ((Bundle)localObject).putInt("srcType", localBundle.getInt("srcType"));
        ((Bundle)localObject).putBoolean("result_boo", bool);
        ((Bundle)localObject).putInt("resourceType", j);
        this.a.jdField_a_of_type_Bbwm.a(i, parambbwg.a(), (Bundle)localObject);
      }
      if (9 != bbyt.a()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipFunCallManager", 2, "sendBroadcast :tencent.video.q2v.AnnimateDownloadFinish");
      }
      parambbwg = new Intent("tencent.video.q2v.AnnimateDownloadFinish");
      parambbwg.putExtra("fun_call_id", i);
      parambbwg.setPackage(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getPackageName());
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(parambbwg);
      return;
      bool = false;
      break label121;
      bool = bbdj.c((String)localObject + ".tmp", (String)localObject);
    }
  }
  
  public void onProgress(bbwg parambbwg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "onProgress, loaded=" + parambbwg.b + "percent=" + parambbwg.jdField_a_of_type_Float + ", key=" + parambbwg.jdField_a_of_type_JavaLangString);
    }
    Bundle localBundle1 = parambbwg.a();
    if (localBundle1 == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onProgress Err0, key:" + parambbwg.jdField_a_of_type_JavaLangString);
    }
    while ((localBundle1.getInt("dealType") == 0) || (!parambbwg.a().getBoolean("isIPC")) || (this.a.jdField_a_of_type_Bbwm == null)) {
      return;
    }
    Bundle localBundle2 = new Bundle();
    localBundle2.putInt("fcStatus", 2);
    localBundle2.putInt("callId", localBundle1.getInt("callId"));
    localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
    localBundle2.putInt("progress", (int)parambbwg.jdField_a_of_type_Float);
    localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
    this.a.jdField_a_of_type_Bbwm.a(localBundle2);
  }
  
  public boolean onStart(bbwg parambbwg)
  {
    Bundle localBundle = parambbwg.a();
    if (localBundle == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onStart Err0, key:" + parambbwg.jdField_a_of_type_JavaLangString);
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
        QLog.d("VipFunCallManager", 2, "onStart, loaded=" + parambbwg.b + ", percent=" + parambbwg.jdField_a_of_type_Float + ", resType=" + i + ", isIPC=" + bool);
      }
    } while ((!bool) || (this.a.jdField_a_of_type_Bbwm == null));
    parambbwg = new Bundle();
    parambbwg.putInt("fcStatus", 1);
    parambbwg.putInt("callId", localBundle.getInt("callId"));
    parambbwg.putInt("srcType", localBundle.getInt("srcType"));
    parambbwg.putInt("resourceType", i);
    this.a.jdField_a_of_type_Bbwm.a(parambbwg);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbyy
 * JD-Core Version:    0.7.0.1
 */