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

public class axzl
  extends axxm
{
  public axzl(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(axxt paramaxxt)
  {
    return 5;
  }
  
  public View a(ViewGroup paramViewGroup, axxt paramaxxt)
  {
    paramViewGroup = (axzm)paramaxxt;
    paramaxxt = new TextView(this.a);
    paramaxxt.setTextColor(this.a.getResources().getColor(2131165343));
    paramaxxt.setTextSize(1, 16.0F);
    paramaxxt.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup.g = paramaxxt;
    return paramaxxt;
  }
  
  public axxt a()
  {
    return new axzm(this);
  }
  
  public void f(axxt paramaxxt)
  {
    paramaxxt = (axzm)paramaxxt;
    Object localObject = (axzu)paramaxxt.a;
    String str = ((axzu)localObject).n;
    localObject = bgsw.a(this.a, ((axzu)localObject).a, str);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramaxxt.g.setVisibility(8);
      return;
    }
    paramaxxt.g.setVisibility(0);
    if ((localObject instanceof SpannableString)) {
      paramaxxt.g.setMovementMethod(LinkMovementMethod.getInstance());
    }
    paramaxxt.g.setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzl
 * JD-Core Version:    0.7.0.1
 */