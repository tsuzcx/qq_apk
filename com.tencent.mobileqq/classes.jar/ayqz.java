import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ayqz
  extends ayrm
{
  private Drawable a;
  
  public ayqz(bdbb parambdbb)
  {
    super(parambdbb);
  }
  
  private void a(aywd paramaywd, TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a == null)
      {
        this.a = paramaywd.a().getContext().getResources().getDrawable(2130841432);
        this.a.setBounds(0, 0, ImmersiveUtils.a(15.0F), ImmersiveUtils.a(15.0F));
      }
      paramTextView.setCompoundDrawables(null, null, this.a, null);
      return;
    }
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  private void b(aywd paramaywd, aynu paramaynu)
  {
    TextView localTextView = paramaywd.a();
    Context localContext;
    boolean bool;
    if ((localTextView != null) && (paramaynu != null))
    {
      localContext = localTextView.getContext();
      if (!(paramaynu instanceof ayoy)) {
        break label73;
      }
      paramaynu = ((ayoy)paramaynu).a();
      if ((paramaynu != null) && (localContext != null))
      {
        if (paramaynu.certifiedGrade <= 0L) {
          break label68;
        }
        bool = true;
        a(paramaywd, localTextView, bool);
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
      } while (!(paramaynu instanceof aymy));
      paramaynu = (aymy)paramaynu;
    } while ((paramaynu == null) || (localContext == null));
    a(paramaywd, localTextView, paramaynu.b());
  }
  
  protected void a(aywd paramaywd, aynu paramaynu)
  {
    super.a(paramaywd, paramaynu);
    if ((paramaynu instanceof ayoy))
    {
      Object localObject = (ayoy)paramaynu;
      PublicAccountInfo localPublicAccountInfo = ((ayoy)localObject).a();
      if ((localPublicAccountInfo != null) && (localPublicAccountInfo.displayNumber != null) && (localPublicAccountInfo.displayNumber.equalsIgnoreCase(((ayoy)localObject).a())))
      {
        localObject = new SpannableString(localPublicAccountInfo.name);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-16734752), 0, localPublicAccountInfo.name.length(), 33);
        paramaywd.a().setText((CharSequence)localObject);
      }
    }
    b(paramaywd, paramaynu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqz
 * JD-Core Version:    0.7.0.1
 */