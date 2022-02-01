import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;

public class aysf
  extends ayqg
{
  public aysf(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(ayqn paramayqn)
  {
    return 5;
  }
  
  public View a(ViewGroup paramViewGroup, ayqn paramayqn)
  {
    paramViewGroup = (aysg)paramayqn;
    paramayqn = new TextView(this.a);
    paramayqn.setTextColor(this.a.getResources().getColor(2131165343));
    paramayqn.setTextSize(1, 16.0F);
    paramayqn.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup.g = paramayqn;
    return paramayqn;
  }
  
  public ayqn a()
  {
    return new aysg(this);
  }
  
  public void f(ayqn paramayqn)
  {
    paramayqn = (aysg)paramayqn;
    Object localObject = (ayso)paramayqn.a;
    String str = ((ayso)localObject).n;
    localObject = bhsy.a(this.a, ((ayso)localObject).a, str);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramayqn.g.setVisibility(8);
      return;
    }
    paramayqn.g.setVisibility(0);
    if ((localObject instanceof SpannableString)) {
      paramayqn.g.setMovementMethod(LinkMovementMethod.getInstance());
    }
    paramayqn.g.setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysf
 * JD-Core Version:    0.7.0.1
 */