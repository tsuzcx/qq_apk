import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class bnsl
  extends bnax
{
  private bnsl(bnsj parambnsj) {}
  
  public void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "onGetLBSTemplateIds:" + paramBoolean + " req:" + paramInt);
    }
    if ((bnsj.a(this.a) != null) && (bnsj.a(this.a).hasMessages(paramInt))) {
      bnsj.a(this.a, paramBoolean, paramArrayList, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsl
 * JD-Core Version:    0.7.0.1
 */