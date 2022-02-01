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

public class axfn
  extends axdo
{
  public axfn(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(axdv paramaxdv)
  {
    return 5;
  }
  
  public View a(ViewGroup paramViewGroup, axdv paramaxdv)
  {
    paramViewGroup = (axfo)paramaxdv;
    paramaxdv = new TextView(this.a);
    paramaxdv.setTextColor(this.a.getResources().getColor(2131165351));
    paramaxdv.setTextSize(1, 16.0F);
    paramaxdv.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup.g = paramaxdv;
    return paramaxdv;
  }
  
  public axdv a()
  {
    return new axfo(this);
  }
  
  public void f(axdv paramaxdv)
  {
    paramaxdv = (axfo)paramaxdv;
    Object localObject = (axfw)paramaxdv.a;
    String str = ((axfw)localObject).n;
    localObject = bfzn.a(this.a, ((axfw)localObject).a, str);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramaxdv.g.setVisibility(8);
      return;
    }
    paramaxdv.g.setVisibility(0);
    if ((localObject instanceof SpannableString)) {
      paramaxdv.g.setMovementMethod(LinkMovementMethod.getInstance());
    }
    paramaxdv.g.setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axfn
 * JD-Core Version:    0.7.0.1
 */