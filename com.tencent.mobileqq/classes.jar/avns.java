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

public class avns
  extends avlt
{
  public avns(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(avma paramavma)
  {
    return 5;
  }
  
  public View a(ViewGroup paramViewGroup, avma paramavma)
  {
    paramViewGroup = (avnt)paramavma;
    paramavma = new TextView(this.a);
    paramavma.setTextColor(this.a.getResources().getColor(2131165307));
    paramavma.setTextSize(1, 16.0F);
    paramavma.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup.g = paramavma;
    return paramavma;
  }
  
  public avma a()
  {
    return new avnt(this);
  }
  
  public void f(avma paramavma)
  {
    paramavma = (avnt)paramavma;
    Object localObject = (avob)paramavma.a;
    String str = ((avob)localObject).n;
    localObject = bdjl.a(this.a, ((avob)localObject).a, str);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramavma.g.setVisibility(8);
      return;
    }
    paramavma.g.setVisibility(0);
    if ((localObject instanceof SpannableString)) {
      paramavma.g.setMovementMethod(LinkMovementMethod.getInstance());
    }
    paramavma.g.setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avns
 * JD-Core Version:    0.7.0.1
 */