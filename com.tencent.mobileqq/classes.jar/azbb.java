import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class azbb
  extends azay
{
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, azau paramazau, azaw paramazaw)
  {
    paramViewGroup = paramViewGroup.getContext();
    if ((paramView != null) && (((azaw)paramView.getTag()).a == paramazaw.a)) {
      return paramView;
    }
    paramView = LayoutInflater.from(paramViewGroup).inflate(2131559810, null);
    paramView.setTag(paramazaw);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azbb
 * JD-Core Version:    0.7.0.1
 */