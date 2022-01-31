import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.widget.immersive.ImmersiveUtils;

public class awrl
  extends awry
{
  private Drawable a;
  
  public awrl(baxk parambaxk)
  {
    super(parambaxk);
  }
  
  private void a(awwp paramawwp, TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a == null)
      {
        this.a = paramawwp.a().getContext().getResources().getDrawable(2130841313);
        this.a.setBounds(0, 0, ImmersiveUtils.a(15.0F), ImmersiveUtils.a(15.0F));
      }
      paramTextView.setCompoundDrawables(null, null, this.a, null);
      return;
    }
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  private void b(awwp paramawwp, awog paramawog)
  {
    TextView localTextView = paramawwp.a();
    Context localContext;
    boolean bool;
    if ((localTextView != null) && (paramawog != null))
    {
      localContext = localTextView.getContext();
      if (!(paramawog instanceof awpk)) {
        break label73;
      }
      paramawog = ((awpk)paramawog).a();
      if ((paramawog != null) && (localContext != null))
      {
        if (paramawog.certifiedGrade <= 0L) {
          break label68;
        }
        bool = true;
        a(paramawwp, localTextView, bool);
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
      } while (!(paramawog instanceof awnk));
      paramawog = (awnk)paramawog;
    } while ((paramawog == null) || (localContext == null));
    a(paramawwp, localTextView, paramawog.b());
  }
  
  protected void a(awwp paramawwp, awog paramawog)
  {
    super.a(paramawwp, paramawog);
    if ((paramawog instanceof awpk))
    {
      Object localObject = (awpk)paramawog;
      PublicAccountInfo localPublicAccountInfo = ((awpk)localObject).a();
      if ((localPublicAccountInfo != null) && (localPublicAccountInfo.displayNumber != null) && (localPublicAccountInfo.displayNumber.equalsIgnoreCase(((awpk)localObject).a())))
      {
        localObject = new SpannableString(localPublicAccountInfo.name);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-16734752), 0, localPublicAccountInfo.name.length(), 33);
        paramawwp.a().setText((CharSequence)localObject);
      }
    }
    b(paramawwp, paramawog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrl
 * JD-Core Version:    0.7.0.1
 */