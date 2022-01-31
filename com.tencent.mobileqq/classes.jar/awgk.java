import android.view.View;
import com.tencent.mobileqq.screendetect.ScreenShotFragment;
import com.tencent.qphone.base.util.QLog;

public class awgk
  implements awgd
{
  public awgk(ScreenShotFragment paramScreenShotFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "ScreenShotInnerAdapter OnItemClickListener : position = " + paramInt + ", view = " + paramView);
    }
    ScreenShotFragment.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awgk
 * JD-Core Version:    0.7.0.1
 */