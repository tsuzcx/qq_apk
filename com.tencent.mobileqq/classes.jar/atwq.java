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

public class atwq
  extends atur
{
  public atwq(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(atuy paramatuy)
  {
    return 5;
  }
  
  public View a(ViewGroup paramViewGroup, atuy paramatuy)
  {
    paramViewGroup = (atwr)paramatuy;
    paramatuy = new TextView(this.a);
    paramatuy.setTextColor(this.a.getResources().getColor(2131165275));
    paramatuy.setTextSize(1, 16.0F);
    paramatuy.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup.g = paramatuy;
    return paramatuy;
  }
  
  public atuy a()
  {
    return new atwr(this);
  }
  
  public void f(atuy paramatuy)
  {
    paramatuy = (atwr)paramatuy;
    Object localObject = (atwz)paramatuy.a;
    String str = ((atwz)localObject).n;
    localObject = bbkd.a(this.a, ((atwz)localObject).a, str);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramatuy.g.setVisibility(8);
      return;
    }
    paramatuy.g.setVisibility(0);
    if ((localObject instanceof SpannableString)) {
      paramatuy.g.setMovementMethod(LinkMovementMethod.getInstance());
    }
    paramatuy.g.setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atwq
 * JD-Core Version:    0.7.0.1
 */