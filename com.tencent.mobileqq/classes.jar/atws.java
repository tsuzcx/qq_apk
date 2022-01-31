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

public class atws
  extends atut
{
  public atws(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(atva paramatva)
  {
    return 5;
  }
  
  public View a(ViewGroup paramViewGroup, atva paramatva)
  {
    paramViewGroup = (atwt)paramatva;
    paramatva = new TextView(this.a);
    paramatva.setTextColor(this.a.getResources().getColor(2131165275));
    paramatva.setTextSize(1, 16.0F);
    paramatva.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramViewGroup.g = paramatva;
    return paramatva;
  }
  
  public atva a()
  {
    return new atwt(this);
  }
  
  public void f(atva paramatva)
  {
    paramatva = (atwt)paramatva;
    Object localObject = (atxb)paramatva.a;
    String str = ((atxb)localObject).n;
    localObject = bbkr.a(this.a, ((atxb)localObject).a, str);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramatva.g.setVisibility(8);
      return;
    }
    paramatva.g.setVisibility(0);
    if ((localObject instanceof SpannableString)) {
      paramatva.g.setMovementMethod(LinkMovementMethod.getInstance());
    }
    paramatva.g.setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atws
 * JD-Core Version:    0.7.0.1
 */