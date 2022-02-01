import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.widget.immersive.ImmersiveUtils;

public class bbqc
  extends bbqp
{
  private Drawable a;
  
  public bbqc(aobu paramaobu)
  {
    super(paramaobu);
  }
  
  private void a(bbvg parambbvg, TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a == null)
      {
        this.a = parambbvg.a().getContext().getResources().getDrawable(2130841741);
        this.a.setBounds(0, 0, ImmersiveUtils.a(15.0F), ImmersiveUtils.a(15.0F));
      }
      paramTextView.setCompoundDrawables(null, null, this.a, null);
      return;
    }
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  private void b(bbvg parambbvg, bbmy parambbmy)
  {
    TextView localTextView = parambbvg.a();
    Context localContext;
    boolean bool;
    if ((localTextView != null) && (parambbmy != null))
    {
      localContext = localTextView.getContext();
      if (!(parambbmy instanceof bboc)) {
        break label73;
      }
      parambbmy = ((bboc)parambbmy).a();
      if ((parambbmy != null) && (localContext != null))
      {
        if (parambbmy.certifiedGrade <= 0L) {
          break label68;
        }
        bool = true;
        a(parambbvg, localTextView, bool);
      }
    }
    label68:
    label73:
    do
    {
      do
      {
        return;
        bool = false;
        break;
      } while (!(parambbmy instanceof bbmc));
      parambbmy = (bbmc)parambbmy;
    } while ((parambbmy == null) || (localContext == null));
    a(parambbvg, localTextView, parambbmy.b());
  }
  
  protected void a(bbvg parambbvg, bbmy parambbmy)
  {
    super.a(parambbvg, parambbmy);
    if ((parambbmy instanceof bboc))
    {
      Object localObject = (bboc)parambbmy;
      PublicAccountInfo localPublicAccountInfo = ((bboc)localObject).a();
      if ((localPublicAccountInfo != null) && (localPublicAccountInfo.displayNumber != null) && (localPublicAccountInfo.displayNumber.equalsIgnoreCase(((bboc)localObject).a())))
      {
        localObject = new SpannableString(localPublicAccountInfo.name);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-16734752), 0, localPublicAccountInfo.name.length(), 33);
        parambbvg.a().setText((CharSequence)localObject);
      }
    }
    b(parambbvg, parambbmy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqc
 * JD-Core Version:    0.7.0.1
 */