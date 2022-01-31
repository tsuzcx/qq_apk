import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class bnfl
  extends bmez
{
  private bnfl(bnfj parambnfj) {}
  
  public void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "onGetLBSTemplateIds:" + paramBoolean + " req:" + paramInt);
    }
    if ((bnfj.a(this.a) != null) && (bnfj.a(this.a).hasMessages(paramInt))) {
      bnfj.a(this.a, paramBoolean, paramArrayList, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfl
 * JD-Core Version:    0.7.0.1
 */