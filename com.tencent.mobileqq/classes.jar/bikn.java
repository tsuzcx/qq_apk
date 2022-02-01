import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class bikn
  extends biht
{
  bikn(biki parambiki, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "onDone, status=" + parambihu.a() + ", task.errCode:" + parambihu.jdField_a_of_type_Int + ", key=" + parambihu.jdField_a_of_type_JavaLangString);
    }
    Bundle localBundle = parambihu.a();
    if (localBundle == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onDone Err0, key:" + parambihu.jdField_a_of_type_JavaLangString);
    }
    boolean bool;
    label121:
    do
    {
      return;
      if ((parambihu.a() != 3) || (parambihu.jdField_a_of_type_Int != 0)) {
        break;
      }
      bool = true;
      if (!bool) {
        QLog.e("VipFunCallManager", 1, "mDownloadListener onDone fail, task.getStatus():" + parambihu.a() + ", task.errCode:" + parambihu.jdField_a_of_type_Int);
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
      if ((localBundle.getBoolean("isIPC")) && (this.a.jdField_a_of_type_Biia != null))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("fcStatus", 3);
        ((Bundle)localObject).putInt("callId", i);
        ((Bundle)localObject).putInt("srcType", localBundle.getInt("srcType"));
        ((Bundle)localObject).putBoolean("result_boo", bool);
        ((Bundle)localObject).putInt("resourceType", j);
        this.a.jdField_a_of_type_Biia.a(i, parambihu.a(), (Bundle)localObject);
      }
      if (9 != biki.a()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipFunCallManager", 2, "sendBroadcast :tencent.video.q2v.AnnimateDownloadFinish");
      }
      parambihu = new Intent("tencent.video.q2v.AnnimateDownloadFinish");
      parambihu.putExtra("fun_call_id", i);
      parambihu.setPackage(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getPackageName());
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(parambihu);
      return;
      bool = false;
      break label121;
      bool = bhmi.c((String)localObject + ".tmp", (String)localObject);
    }
  }
  
  public void onProgress(bihu parambihu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallManager", 2, "onProgress, loaded=" + parambihu.b + "percent=" + parambihu.jdField_a_of_type_Float + ", key=" + parambihu.jdField_a_of_type_JavaLangString);
    }
    Bundle localBundle1 = parambihu.a();
    if (localBundle1 == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onProgress Err0, key:" + parambihu.jdField_a_of_type_JavaLangString);
    }
    while ((localBundle1.getInt("dealType") == 0) || (!parambihu.a().getBoolean("isIPC")) || (this.a.jdField_a_of_type_Biia == null)) {
      return;
    }
    Bundle localBundle2 = new Bundle();
    localBundle2.putInt("fcStatus", 2);
    localBundle2.putInt("callId", localBundle1.getInt("callId"));
    localBundle2.putInt("srcType", localBundle1.getInt("srcType"));
    localBundle2.putInt("progress", (int)parambihu.jdField_a_of_type_Float);
    localBundle2.putInt("resourceType", localBundle1.getInt("resourceType"));
    this.a.jdField_a_of_type_Biia.a(localBundle2);
  }
  
  public boolean onStart(bihu parambihu)
  {
    Bundle localBundle = parambihu.a();
    if (localBundle == null) {
      QLog.e("VipFunCallManager", 1, "mDownloadListener onStart Err0, key:" + parambihu.jdField_a_of_type_JavaLangString);
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
        QLog.d("VipFunCallManager", 2, "onStart, loaded=" + parambihu.b + ", percent=" + parambihu.jdField_a_of_type_Float + ", resType=" + i + ", isIPC=" + bool);
      }
    } while ((!bool) || (this.a.jdField_a_of_type_Biia == null));
    parambihu = new Bundle();
    parambihu.putInt("fcStatus", 1);
    parambihu.putInt("callId", localBundle.getInt("callId"));
    parambihu.putInt("srcType", localBundle.getInt("srcType"));
    parambihu.putInt("resourceType", i);
    this.a.jdField_a_of_type_Biia.a(parambihu);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bikn
 * JD-Core Version:    0.7.0.1
 */