import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class bkpp
  extends bjpd
{
  private bkpp(bkpn parambkpn) {}
  
  public void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "onGetLBSTemplateIds:" + paramBoolean + " req:" + paramInt);
    }
    if ((bkpn.a(this.a) != null) && (bkpn.a(this.a).hasMessages(paramInt))) {
      bkpn.a(this.a, paramBoolean, paramArrayList, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkpp
 * JD-Core Version:    0.7.0.1
 */