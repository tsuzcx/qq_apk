import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.widget.immersive.ImmersiveUtils;

public class bcip
  extends bcjc
{
  private Drawable a;
  
  public bcip(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  private void a(bcnt parambcnt, TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.a == null)
      {
        this.a = parambcnt.a().getContext().getResources().getDrawable(2130841803);
        this.a.setBounds(0, 0, ImmersiveUtils.a(15.0F), ImmersiveUtils.a(15.0F));
      }
      paramTextView.setCompoundDrawables(null, null, this.a, null);
      return;
    }
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  private void b(bcnt parambcnt, bcfj parambcfj)
  {
    TextView localTextView = parambcnt.a();
    Context localContext;
    boolean bool;
    if ((localTextView != null) && (parambcfj != null))
    {
      localContext = localTextView.getContext();
      if (!(parambcfj instanceof bcgn)) {
        break label73;
      }
      parambcfj = ((bcgn)parambcfj).a();
      if ((parambcfj != null) && (localContext != null))
      {
        if (parambcfj.certifiedGrade <= 0L) {
          break label68;
        }
        bool = true;
        a(parambcnt, localTextView, bool);
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
      } while (!(parambcfj instanceof bcen));
      parambcfj = (bcen)parambcfj;
    } while ((parambcfj == null) || (localContext == null));
    a(parambcnt, localTextView, parambcfj.b());
  }
  
  protected void a(bcnt parambcnt, bcfj parambcfj)
  {
    super.a(parambcnt, parambcfj);
    if ((parambcfj instanceof bcgn))
    {
      Object localObject = (bcgn)parambcfj;
      PublicAccountInfo localPublicAccountInfo = ((bcgn)localObject).a();
      if ((localPublicAccountInfo != null) && (localPublicAccountInfo.displayNumber != null) && (localPublicAccountInfo.displayNumber.equalsIgnoreCase(((bcgn)localObject).a())))
      {
        localObject = new SpannableString(localPublicAccountInfo.name);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-16734752), 0, localPublicAccountInfo.name.length(), 33);
        parambcnt.a().setText((CharSequence)localObject);
      }
    }
    b(parambcnt, parambcfj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcip
 * JD-Core Version:    0.7.0.1
 */