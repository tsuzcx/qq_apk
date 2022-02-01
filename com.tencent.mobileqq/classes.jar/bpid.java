import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class bpid
  extends boqp
{
  private bpid(bpib parambpib) {}
  
  public void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "onGetLBSTemplateIds:" + paramBoolean + " req:" + paramInt);
    }
    if ((bpib.a(this.a) != null) && (bpib.a(this.a).hasMessages(paramInt))) {
      bpib.a(this.a, paramBoolean, paramArrayList, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpid
 * JD-Core Version:    0.7.0.1
 */