import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.widget.immersive.ImmersiveUtils;

public class bciv
  extends bcji
{
  private Drawable a;
  
  public bciv(aoof paramaoof)
  {
    super(paramaoof);
  }
  
  private void a(bcnz parambcnz, TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a == null)
      {
        this.a = parambcnz.a().getContext().getResources().getDrawable(2130841751);
        this.a.setBounds(0, 0, ImmersiveUtils.a(15.0F), ImmersiveUtils.a(15.0F));
      }
      paramTextView.setCompoundDrawables(null, null, this.a, null);
      return;
    }
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  private void b(bcnz parambcnz, bcfr parambcfr)
  {
    TextView localTextView = parambcnz.a();
    Context localContext;
    boolean bool;
    if ((localTextView != null) && (parambcfr != null))
    {
      localContext = localTextView.getContext();
      if (!(parambcfr instanceof bcgv)) {
        break label73;
      }
      parambcfr = ((bcgv)parambcfr).a();
      if ((parambcfr != null) && (localContext != null))
      {
        if (parambcfr.certifiedGrade <= 0L) {
          break label68;
        }
        bool = true;
        a(parambcnz, localTextView, bool);
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
      } while (!(parambcfr instanceof bcev));
      parambcfr = (bcev)parambcfr;
    } while ((parambcfr == null) || (localContext == null));
    a(parambcnz, localTextView, parambcfr.b());
  }
  
  protected void a(bcnz parambcnz, bcfr parambcfr)
  {
    super.a(parambcnz, parambcfr);
    if ((parambcfr instanceof bcgv))
    {
      Object localObject = (bcgv)parambcfr;
      PublicAccountInfo localPublicAccountInfo = ((bcgv)localObject).a();
      if ((localPublicAccountInfo != null) && (localPublicAccountInfo.displayNumber != null) && (localPublicAccountInfo.displayNumber.equalsIgnoreCase(((bcgv)localObject).a())))
      {
        localObject = new SpannableString(localPublicAccountInfo.name);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-16734752), 0, localPublicAccountInfo.name.length(), 33);
        parambcnz.a().setText((CharSequence)localObject);
      }
    }
    b(parambcnz, parambcfr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bciv
 * JD-Core Version:    0.7.0.1
 */