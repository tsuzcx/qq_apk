import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class axoj
  extends axog
{
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, axoc paramaxoc, axoe paramaxoe)
  {
    paramViewGroup = paramViewGroup.getContext();
    if ((paramView != null) && (((axoe)paramView.getTag()).a == paramaxoe.a)) {
      return paramView;
    }
    paramView = LayoutInflater.from(paramViewGroup).inflate(2131559812, null);
    paramView.setTag(paramaxoe);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axoj
 * JD-Core Version:    0.7.0.1
 */