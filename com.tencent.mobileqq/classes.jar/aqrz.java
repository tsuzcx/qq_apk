import android.annotation.SuppressLint;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.qphone.base.util.QLog;

@SuppressLint({"NewApi"})
public class aqrz
  extends ViewOutlineProvider
{
  public int a;
  public int b;
  public int c;
  public int d;
  
  public aqrz(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOutlineProvider", 1, "----->getOutline");
    }
    paramView.getGlobalVisibleRect(new Rect());
    paramOutline.setRoundRect(new Rect(this.c, this.a, this.d, this.b), 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqrz
 * JD-Core Version:    0.7.0.1
 */