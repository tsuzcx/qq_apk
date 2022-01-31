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

public class avsb
  extends avqc
{
  public avsb(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(avqj paramavqj)
  {
    return 5;
  }
  
  public View a(ViewGroup paramViewGroup, avqj paramavqj)
  {
    paramViewGroup = (avsc)paramavqj;
    paramavqj = new TextView(this.a);
    paramavqj.setTextColor(this.a.getResources().getColor(2131165307));
    paramavqj.setTextSize(1, 16.0F);
    paramavqj.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup.g = paramavqj;
    return paramavqj;
  }
  
  public avqj a()
  {
    return new avsc(this);
  }
  
  public void f(avqj paramavqj)
  {
    paramavqj = (avsc)paramavqj;
    Object localObject = (avsk)paramavqj.a;
    String str = ((avsk)localObject).n;
    localObject = bdnu.a(this.a, ((avsk)localObject).a, str);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramavqj.g.setVisibility(8);
      return;
    }
    paramavqj.g.setVisibility(0);
    if ((localObject instanceof SpannableString)) {
      paramavqj.g.setMovementMethod(LinkMovementMethod.getInstance());
    }
    paramavqj.g.setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avsb
 * JD-Core Version:    0.7.0.1
 */