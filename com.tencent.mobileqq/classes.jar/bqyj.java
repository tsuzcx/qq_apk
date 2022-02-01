import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class bqyj
  extends bpya
{
  private bqyj(bqyh parambqyh) {}
  
  public void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "onGetLBSTemplateIds:" + paramBoolean + " req:" + paramInt);
    }
    if ((bqyh.a(this.a) != null) && (bqyh.a(this.a).hasMessages(paramInt))) {
      bqyh.a(this.a, paramBoolean, paramArrayList, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqyj
 * JD-Core Version:    0.7.0.1
 */