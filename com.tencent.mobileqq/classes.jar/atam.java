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

public class atam
  extends asyn
{
  public atam(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(asyu paramasyu)
  {
    return 5;
  }
  
  public View a(ViewGroup paramViewGroup, asyu paramasyu)
  {
    paramViewGroup = (atan)paramasyu;
    paramasyu = new TextView(this.a);
    paramasyu.setTextColor(this.a.getResources().getColor(2131099738));
    paramasyu.setTextSize(1, 16.0F);
    paramasyu.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup.g = paramasyu;
    return paramasyu;
  }
  
  public asyu a()
  {
    return new atan(this);
  }
  
  public void f(asyu paramasyu)
  {
    paramasyu = (atan)paramasyu;
    Object localObject = (atav)paramasyu.a;
    String str = ((atav)localObject).n;
    localObject = baiw.a(this.a, ((atav)localObject).a, str);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramasyu.g.setVisibility(8);
      return;
    }
    paramasyu.g.setVisibility(0);
    if ((localObject instanceof SpannableString)) {
      paramasyu.g.setMovementMethod(LinkMovementMethod.getInstance());
    }
    paramasyu.g.setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atam
 * JD-Core Version:    0.7.0.1
 */