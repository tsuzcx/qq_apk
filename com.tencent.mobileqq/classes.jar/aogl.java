import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.poi.LbsPackObserver;
import dov.com.tencent.mobileqq.activity.richmedia.LBSDetetor;
import java.util.ArrayList;

public class aogl
  extends LbsPackObserver
{
  private aogl(LBSDetetor paramLBSDetetor) {}
  
  public void a(int paramInt, boolean paramBoolean, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "onGetLBSTemplateIds:" + paramBoolean + " req:" + paramInt);
    }
    if ((LBSDetetor.a(this.a) != null) && (LBSDetetor.a(this.a).hasMessages(paramInt))) {
      LBSDetetor.a(this.a, paramBoolean, paramArrayList, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aogl
 * JD-Core Version:    0.7.0.1
 */