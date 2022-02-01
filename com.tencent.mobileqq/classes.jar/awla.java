import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.theme.ThemeUtil;

public class awla
  extends RecyclerView.ViewHolder
{
  private TextView a;
  
  public awla(Context paramContext, View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(2131378936));
    if (ThemeUtil.isNowThemeIsNight(null, false, null))
    {
      this.a.setTextColor(paramContext.getResources().getColor(2131165756));
      return;
    }
    this.a.setTextColor(paramContext.getResources().getColor(2131165755));
  }
  
  public void a(awkq paramawkq)
  {
    if (TextUtils.isEmpty(paramawkq.a))
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(0);
    this.a.setText(paramawkq.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awla
 * JD-Core Version:    0.7.0.1
 */