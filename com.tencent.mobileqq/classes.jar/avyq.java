import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class avyq
  extends avyn
{
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, avyj paramavyj, avyl paramavyl)
  {
    paramViewGroup = paramViewGroup.getContext();
    if ((paramView != null) && (((avyl)paramView.getTag()).a == paramavyl.a)) {
      return paramView;
    }
    paramView = LayoutInflater.from(paramViewGroup).inflate(2131559667, null);
    paramView.setTag(paramavyl);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avyq
 * JD-Core Version:    0.7.0.1
 */