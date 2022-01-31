import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class audd
  extends auda
{
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, aucw paramaucw, aucy paramaucy)
  {
    paramViewGroup = paramViewGroup.getContext();
    if ((paramView != null) && (((aucy)paramView.getTag()).a == paramaucy.a)) {
      return paramView;
    }
    paramView = LayoutInflater.from(paramViewGroup).inflate(2131559615, null);
    paramView.setTag(paramaucy);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audd
 * JD-Core Version:    0.7.0.1
 */