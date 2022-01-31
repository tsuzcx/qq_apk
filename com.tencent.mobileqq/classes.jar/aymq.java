import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.widget.immersive.ImmersiveUtils;

public class aymq
  extends aynd
{
  private Drawable a;
  
  public aymq(bcws parambcws)
  {
    super(parambcws);
  }
  
  private void a(ayru paramayru, TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a == null)
      {
        this.a = paramayru.a().getContext().getResources().getDrawable(2130841431);
        this.a.setBounds(0, 0, ImmersiveUtils.a(15.0F), ImmersiveUtils.a(15.0F));
      }
      paramTextView.setCompoundDrawables(null, null, this.a, null);
      return;
    }
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  private void b(ayru paramayru, ayjl paramayjl)
  {
    TextView localTextView = paramayru.a();
    Context localContext;
    boolean bool;
    if ((localTextView != null) && (paramayjl != null))
    {
      localContext = localTextView.getContext();
      if (!(paramayjl instanceof aykp)) {
        break label73;
      }
      paramayjl = ((aykp)paramayjl).a();
      if ((paramayjl != null) && (localContext != null))
      {
        if (paramayjl.certifiedGrade <= 0L) {
          break label68;
        }
        bool = true;
        a(paramayru, localTextView, bool);
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
      } while (!(paramayjl instanceof ayip));
      paramayjl = (ayip)paramayjl;
    } while ((paramayjl == null) || (localContext == null));
    a(paramayru, localTextView, paramayjl.b());
  }
  
  protected void a(ayru paramayru, ayjl paramayjl)
  {
    super.a(paramayru, paramayjl);
    if ((paramayjl instanceof aykp))
    {
      Object localObject = (aykp)paramayjl;
      PublicAccountInfo localPublicAccountInfo = ((aykp)localObject).a();
      if ((localPublicAccountInfo != null) && (localPublicAccountInfo.displayNumber != null) && (localPublicAccountInfo.displayNumber.equalsIgnoreCase(((aykp)localObject).a())))
      {
        localObject = new SpannableString(localPublicAccountInfo.name);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-16734752), 0, localPublicAccountInfo.name.length(), 33);
        paramayru.a().setText((CharSequence)localObject);
      }
    }
    b(paramayru, paramayjl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymq
 * JD-Core Version:    0.7.0.1
 */