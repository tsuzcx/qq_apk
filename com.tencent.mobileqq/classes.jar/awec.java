import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class awec
  extends RecyclerView.ViewHolder
{
  private TextView a;
  
  public awec(Context paramContext, View paramView, boolean paramBoolean)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(2131379001));
    if (paramBoolean)
    {
      this.a.setTextColor(paramContext.getResources().getColor(2131165775));
      return;
    }
    this.a.setTextColor(paramContext.getResources().getColor(2131165774));
  }
  
  public void a(awdt paramawdt)
  {
    if (TextUtils.isEmpty(paramawdt.a))
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(0);
    this.a.setText(paramawdt.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awec
 * JD-Core Version:    0.7.0.1
 */