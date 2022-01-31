import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.widget.immersive.ImmersiveUtils;

public class avrs
  extends avsf
{
  private Drawable a;
  
  public avrs(azwg paramazwg)
  {
    super(paramazwg);
  }
  
  private void a(avww paramavww, TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a == null)
      {
        this.a = paramavww.a().getContext().getResources().getDrawable(2130841234);
        this.a.setBounds(0, 0, ImmersiveUtils.a(15.0F), ImmersiveUtils.a(15.0F));
      }
      paramTextView.setCompoundDrawables(null, null, this.a, null);
      return;
    }
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  private void b(avww paramavww, avon paramavon)
  {
    TextView localTextView = paramavww.a();
    Context localContext;
    boolean bool;
    if ((localTextView != null) && (paramavon != null))
    {
      localContext = localTextView.getContext();
      if (!(paramavon instanceof avpr)) {
        break label73;
      }
      paramavon = ((avpr)paramavon).a();
      if ((paramavon != null) && (localContext != null))
      {
        if (paramavon.certifiedGrade <= 0L) {
          break label68;
        }
        bool = true;
        a(paramavww, localTextView, bool);
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
      } while (!(paramavon instanceof avnr));
      paramavon = (avnr)paramavon;
    } while ((paramavon == null) || (localContext == null));
    a(paramavww, localTextView, paramavon.b());
  }
  
  protected void a(avww paramavww, avon paramavon)
  {
    super.a(paramavww, paramavon);
    if ((paramavon instanceof avpr))
    {
      Object localObject = (avpr)paramavon;
      PublicAccountInfo localPublicAccountInfo = ((avpr)localObject).a();
      if ((localPublicAccountInfo != null) && (localPublicAccountInfo.displayNumber != null) && (localPublicAccountInfo.displayNumber.equalsIgnoreCase(((avpr)localObject).a())))
      {
        localObject = new SpannableString(localPublicAccountInfo.name);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-16734752), 0, localPublicAccountInfo.name.length(), 33);
        paramavww.a().setText((CharSequence)localObject);
      }
    }
    b(paramavww, paramavon);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrs
 * JD-Core Version:    0.7.0.1
 */