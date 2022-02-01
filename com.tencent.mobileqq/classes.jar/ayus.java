import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ayus
  extends ayup
{
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, ayul paramayul, ayun paramayun)
  {
    paramViewGroup = paramViewGroup.getContext();
    if ((paramView != null) && (((ayun)paramView.getTag()).a == paramayun.a)) {
      return paramView;
    }
    paramView = LayoutInflater.from(paramViewGroup).inflate(2131559856, null);
    paramView.setTag(paramayun);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayus
 * JD-Core Version:    0.7.0.1
 */