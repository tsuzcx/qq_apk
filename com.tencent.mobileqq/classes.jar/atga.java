import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class atga
  extends atfx
{
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, atft paramatft, atfv paramatfv)
  {
    paramViewGroup = paramViewGroup.getContext();
    if ((paramView != null) && (((atfv)paramView.getTag()).a == paramatfv.a)) {
      return paramView;
    }
    paramView = LayoutInflater.from(paramViewGroup).inflate(2131494043, null);
    paramView.setTag(paramatfv);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atga
 * JD-Core Version:    0.7.0.1
 */