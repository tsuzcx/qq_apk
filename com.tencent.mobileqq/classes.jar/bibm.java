import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class bibm
  extends bhyn
{
  bibm(bibh parambibh, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "onDone, status=" + parambhyo.a() + ", task.errCode:" + parambhyo.jdField_a_of_type_Int + ", key=" + parambhyo.jdField_a_of_type_JavaLangString);
    }
    Bundle localBundle = parambhyo.a();
    if (localBundle == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onDone Err0, key:" + parambhyo.jdField_a_of_type_JavaLangString);
    }
    boolean bool;
    label121:
    do
    {
      return;
      if ((parambhyo.a() != 3) || (parambhyo.jdField_a_of_type_Int != 0)) {
        break;
      }
      bool = true;
      if (!bool) {
        QLog.e("VipFunCallManager", 1, "mDownloadListener onDone fail, task.getStatus():" + parambhyo.a() + ", task.errCode:" + parambhyo.jdField_a_of_type_Int);
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
      if ((localBundle.getBoolean("isIPC")) && (this.a.jdField_a_of_type_Bhyu != null))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("fcStatus", 3);
        ((Bundle)localObject).putInt("callId", i);
        ((Bundle)localObject).putInt("srcType", localBundle.getInt("srcType"));
        ((Bundle)localObject).putBoolean("result_boo", bool);
        ((Bundle)localObject).putInt("resourceType", j);
        this.a.jdField_a_of_type_Bhyu.a(i, parambhyo.a(), (Bundle)localObject);
      }
      if (9 != bibh.a()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipFunCallManager", 2, "sendBroadcast :tencent.video.q2v.AnnimateDownloadFinish");
      }
      parambhyo = new Intent("tencent.video.q2v.AnnimateDownloadFinish");
      parambhyo.putExtra("fun_call_id", i);
      parambhyo.setPackage(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getPackageName());
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(parambhyo);
      return;
      bool = false;
      break label121;
      bool = FileUtils.rename((String)localObject + ".tmp", (String)localObject);
    }
  }
  
  public void onProgress(bhyo parambhyo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "onProgress, loaded=" + parambhyo.b + "percent=" + parambhyo.jdField_a_of_type_Float + ", key=" + parambhyo.jdField_a_of_type_JavaLangString);
    }
    Bundle localBundle1 = parambhyo.a();
    if (localBundle1 == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onProgress Err0, key:" + parambhyo.jdField_a_of_type_JavaLangString);
    }
    while ((localBundle1.getInt("dealType") == 0) || (!parambhyo.a().getBoolean("isIPC")) || (this.a.jdField_a_of_type_Bhyu == null)) {
      return;
    }
    Bundle localBundle2 = new Bundle();
    localBundle2.putInt("fcStatus", 2);
    localBundle2.putInt("callId", localBundle1.getInt("callId"));
    localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
    localBundle2.putInt("progress", (int)parambhyo.jdField_a_of_type_Float);
    localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
    this.a.jdField_a_of_type_Bhyu.a(localBundle2);
  }
  
  public boolean onStart(bhyo parambhyo)
  {
    Bundle localBundle = parambhyo.a();
    if (localBundle == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onStart Err0, key:" + parambhyo.jdField_a_of_type_JavaLangString);
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
        QLog.d("VipFunCallManager", 2, "onStart, loaded=" + parambhyo.b + ", percent=" + parambhyo.jdField_a_of_type_Float + ", resType=" + i + ", isIPC=" + bool);
      }
    } while ((!bool) || (this.a.jdField_a_of_type_Bhyu == null));
    parambhyo = new Bundle();
    parambhyo.putInt("fcStatus", 1);
    parambhyo.putInt("callId", localBundle.getInt("callId"));
    parambhyo.putInt("srcType", localBundle.getInt("srcType"));
    parambhyo.putInt("resourceType", i);
    this.a.jdField_a_of_type_Bhyu.a(parambhyo);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bibm
 * JD-Core Version:    0.7.0.1
 */