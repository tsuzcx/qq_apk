import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class bgug
  implements bgui
{
  bgug(bgua parambgua) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopShareUtility", 2, "shareToMobileQQ uploadNewTroopHeader result = " + paramBoolean + ",url = " + paramString);
    }
    if (paramBoolean)
    {
      this.a.d = paramString;
      bgua.e(this.a);
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, anvx.a(2131715148), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgug
 * JD-Core Version:    0.7.0.1
 */