import android.content.Context;
import com.tencent.mobileqq.widget.GifAnimationDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bive
  extends GifAnimationDrawable
{
  public bive(Context paramContext, ArrayList<String> paramArrayList, long paramLong)
  {
    super(paramContext, paramArrayList, paramLong);
  }
  
  public void start()
  {
    if (!this.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zswp20pro", 2, "start");
      }
      this.a = true;
      this.b = true;
      this.d = false;
      a();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("zswp20pro", 2, "start but isRunning");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bive
 * JD-Core Version:    0.7.0.1
 */