import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class avuh
  extends avue
{
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, avua paramavua, avuc paramavuc)
  {
    paramViewGroup = paramViewGroup.getContext();
    if ((paramView != null) && (((avuc)paramView.getTag()).a == paramavuc.a)) {
      return paramView;
    }
    paramView = LayoutInflater.from(paramViewGroup).inflate(2131559668, null);
    paramView.setTag(paramavuc);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avuh
 * JD-Core Version:    0.7.0.1
 */