import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.tencent.TMG.utils.QLog;

public class amcs
{
  private static final int b = Color.rgb(123, 113, 30);
  private static final int c = Color.argb(64, 125, 113, 30);
  private static final int d = Color.rgb(162, 116, 4);
  private static final int e = Color.argb(64, 213, 185, 118);
  public int a = 0;
  
  private amcj a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      if ((paramView.getParent() instanceof amcj)) {
        return (amcj)paramView.getParent();
      }
    } while (!(paramView instanceof amcj));
    return (amcj)paramView;
  }
  
  void a(View paramView, amcb paramamcb)
  {
    amcj localamcj = a(paramView);
    if (localamcj == null) {}
    amcl localamcl;
    do
    {
      return;
      localamcl = localamcj.delegate();
    } while ((localamcl == null) || (!localamcl.b()) || (localamcj.hasSelected()));
    if (this.a == 2)
    {
      localamcl.c(d);
      localamcl.b(e);
    }
    for (;;)
    {
      localamcl.a(paramamcb);
      localamcj.doSelecting(null);
      return;
      if (this.a == 1)
      {
        localamcl.c(b);
        localamcl.b(c);
      }
      else
      {
        paramView = paramView.getResources();
        int i = paramView.getColorStateList(2131166967).getDefaultColor();
        int j = paramView.getColorStateList(2131166969).getDefaultColor();
        localamcl.c(i);
        localamcl.b(j);
        if (QLog.isColorLevel()) {
          QLog.d("ChatAdapterSelectableHelper", 0, "Load Select color, cursor=" + i + ", component=" + j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amcs
 * JD-Core Version:    0.7.0.1
 */