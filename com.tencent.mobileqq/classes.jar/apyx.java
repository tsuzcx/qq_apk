import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.qphone.base.util.QLog;

class apyx
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  apyx(apyw paramapyw, String paramString) {}
  
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling onReleaseAndReload onGetAppPathByName app=" + this.jdField_a_of_type_JavaLangString + ",retcode=" + paramInt + ",msg=" + paramString);
    if ((paramInt == 0) && (paramAppPathInfo != null) && (paramAppPathInfo.path != null)) {
      apyu.a(this.jdField_a_of_type_Apyw.a, this.jdField_a_of_type_JavaLangString, paramAppPathInfo.path, apyu.a(this.jdField_a_of_type_Apyw.a), 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apyx
 * JD-Core Version:    0.7.0.1
 */