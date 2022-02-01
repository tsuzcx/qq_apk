import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager.2;

public class bpqo
  implements bpqq
{
  public bpqo(QIMInformationPasterManager.2 param2) {}
  
  public void a(float paramFloat, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString, bqpa parambqpa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "isSucess:" + paramBoolean + " url:" + paramString + " item:" + parambqpa);
    }
    if (parambqpa.a() != null) {
      parambqpa.a().a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpqo
 * JD-Core Version:    0.7.0.1
 */