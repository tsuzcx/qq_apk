import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class audb
  extends aucy
{
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, aucu paramaucu, aucw paramaucw)
  {
    paramViewGroup = paramViewGroup.getContext();
    if ((paramView != null) && (((aucw)paramView.getTag()).a == paramaucw.a)) {
      return paramView;
    }
    paramView = LayoutInflater.from(paramViewGroup).inflate(2131559615, null);
    paramView.setTag(paramaucw);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audb
 * JD-Core Version:    0.7.0.1
 */