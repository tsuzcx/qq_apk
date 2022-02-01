import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ayii
  extends ayif
{
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, ayib paramayib, ayid paramayid)
  {
    paramViewGroup = paramViewGroup.getContext();
    if ((paramView != null) && (((ayid)paramView.getTag()).a == paramayid.a)) {
      return paramView;
    }
    paramView = LayoutInflater.from(paramViewGroup).inflate(2131559804, null);
    paramView.setTag(paramayid);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayii
 * JD-Core Version:    0.7.0.1
 */