import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.widget.immersive.ImmersiveUtils;

public class bbbx
  extends bbck
{
  private Drawable a;
  
  public bbbx(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  private void a(bbhb parambbhb, TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a == null)
      {
        this.a = parambbhb.a().getContext().getResources().getDrawable(2130841793);
        this.a.setBounds(0, 0, ImmersiveUtils.a(15.0F), ImmersiveUtils.a(15.0F));
      }
      paramTextView.setCompoundDrawables(null, null, this.a, null);
      return;
    }
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  private void b(bbhb parambbhb, bayt parambayt)
  {
    TextView localTextView = parambbhb.a();
    Context localContext;
    boolean bool;
    if ((localTextView != null) && (parambayt != null))
    {
      localContext = localTextView.getContext();
      if (!(parambayt instanceof bazx)) {
        break label73;
      }
      parambayt = ((bazx)parambayt).a();
      if ((parambayt != null) && (localContext != null))
      {
        if (parambayt.certifiedGrade <= 0L) {
          break label68;
        }
        bool = true;
        a(parambbhb, localTextView, bool);
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
      } while (!(parambayt instanceof baxx));
      parambayt = (baxx)parambayt;
    } while ((parambayt == null) || (localContext == null));
    a(parambbhb, localTextView, parambayt.b());
  }
  
  protected void a(bbhb parambbhb, bayt parambayt)
  {
    super.a(parambbhb, parambayt);
    if ((parambayt instanceof bazx))
    {
      Object localObject = (bazx)parambayt;
      PublicAccountInfo localPublicAccountInfo = ((bazx)localObject).a();
      if ((localPublicAccountInfo != null) && (localPublicAccountInfo.displayNumber != null) && (localPublicAccountInfo.displayNumber.equalsIgnoreCase(((bazx)localObject).a())))
      {
        localObject = new SpannableString(localPublicAccountInfo.name);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-16734752), 0, localPublicAccountInfo.name.length(), 33);
        parambbhb.a().setText((CharSequence)localObject);
      }
    }
    b(parambbhb, parambayt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbx
 * JD-Core Version:    0.7.0.1
 */