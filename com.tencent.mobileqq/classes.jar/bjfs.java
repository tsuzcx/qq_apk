import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager.2;

public class bjfs
  implements bjfu
{
  public bjfs(QIMInformationPasterManager.2 param2) {}
  
  public void a(float paramFloat, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString, bkgd parambkgd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "isSucess:" + paramBoolean + " url:" + paramString + " item:" + parambkgd);
    }
    if (parambkgd.a() != null) {
      parambkgd.a().a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjfs
 * JD-Core Version:    0.7.0.1
 */