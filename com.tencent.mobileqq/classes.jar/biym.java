import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class biym
  extends bhwr
{
  private biym(biyk parambiyk) {}
  
  public void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "onGetLBSTemplateIds:" + paramBoolean + " req:" + paramInt);
    }
    if ((biyk.a(this.a) != null) && (biyk.a(this.a).hasMessages(paramInt))) {
      biyk.a(this.a, paramBoolean, paramArrayList, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biym
 * JD-Core Version:    0.7.0.1
 */