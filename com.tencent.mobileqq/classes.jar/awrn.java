import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.widget.immersive.ImmersiveUtils;

public class awrn
  extends awsa
{
  private Drawable a;
  
  public awrn(baxy parambaxy)
  {
    super(parambaxy);
  }
  
  private void a(awwr paramawwr, TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a == null)
      {
        this.a = paramawwr.a().getContext().getResources().getDrawable(2130841310);
        this.a.setBounds(0, 0, ImmersiveUtils.a(15.0F), ImmersiveUtils.a(15.0F));
      }
      paramTextView.setCompoundDrawables(null, null, this.a, null);
      return;
    }
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  private void b(awwr paramawwr, awoi paramawoi)
  {
    TextView localTextView = paramawwr.a();
    Context localContext;
    boolean bool;
    if ((localTextView != null) && (paramawoi != null))
    {
      localContext = localTextView.getContext();
      if (!(paramawoi instanceof awpm)) {
        break label73;
      }
      paramawoi = ((awpm)paramawoi).a();
      if ((paramawoi != null) && (localContext != null))
      {
        if (paramawoi.certifiedGrade <= 0L) {
          break label68;
        }
        bool = true;
        a(paramawwr, localTextView, bool);
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
      } while (!(paramawoi instanceof awnm));
      paramawoi = (awnm)paramawoi;
    } while ((paramawoi == null) || (localContext == null));
    a(paramawwr, localTextView, paramawoi.b());
  }
  
  protected void a(awwr paramawwr, awoi paramawoi)
  {
    super.a(paramawwr, paramawoi);
    if ((paramawoi instanceof awpm))
    {
      Object localObject = (awpm)paramawoi;
      PublicAccountInfo localPublicAccountInfo = ((awpm)localObject).a();
      if ((localPublicAccountInfo != null) && (localPublicAccountInfo.displayNumber != null) && (localPublicAccountInfo.displayNumber.equalsIgnoreCase(((awpm)localObject).a())))
      {
        localObject = new SpannableString(localPublicAccountInfo.name);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-16734752), 0, localPublicAccountInfo.name.length(), 33);
        paramawwr.a().setText((CharSequence)localObject);
      }
    }
    b(paramawwr, paramawoi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrn
 * JD-Core Version:    0.7.0.1
 */