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

public class ayls
  extends ayjt
{
  public ayls(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(ayka paramayka)
  {
    return 5;
  }
  
  public View a(ViewGroup paramViewGroup, ayka paramayka)
  {
    paramViewGroup = (aylt)paramayka;
    paramayka = new TextView(this.a);
    paramayka.setTextColor(this.a.getResources().getColor(2131165357));
    paramayka.setTextSize(1, 16.0F);
    paramayka.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup.g = paramayka;
    return paramayka;
  }
  
  public ayka a()
  {
    return new aylt(this);
  }
  
  public void f(ayka paramayka)
  {
    paramayka = (aylt)paramayka;
    Object localObject = (aymb)paramayka.a;
    String str = ((aymb)localObject).n;
    localObject = bhif.a(this.a, ((aymb)localObject).a, str);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramayka.g.setVisibility(8);
      return;
    }
    paramayka.g.setVisibility(0);
    if ((localObject instanceof SpannableString)) {
      paramayka.g.setMovementMethod(LinkMovementMethod.getInstance());
    }
    paramayka.g.setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayls
 * JD-Core Version:    0.7.0.1
 */