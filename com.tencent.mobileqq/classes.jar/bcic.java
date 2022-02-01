import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;

public class bcic
  extends bcjc
{
  public bcic(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  public void b(bcfj parambcfj, bcnt parambcnt)
  {
    super.b(parambcfj, parambcnt);
    TextView localTextView;
    CharSequence localCharSequence;
    if ((parambcfj instanceof bccy))
    {
      bccy localbccy = (bccy)parambcfj;
      localTextView = ((bcnp)parambcnt).e();
      parambcfj = ((bcnp)parambcnt).f();
      parambcnt = ((bcnp)parambcnt).g();
      if (localTextView != null)
      {
        localCharSequence = localbccy.e();
        if (localCharSequence != null) {
          break label96;
        }
        localTextView.setText("");
        if (parambcnt != null) {
          parambcnt.setVisibility(8);
        }
      }
      if (parambcfj != null)
      {
        parambcnt = localbccy.f();
        if (parambcnt != null) {
          break label115;
        }
        parambcfj.setText("");
      }
    }
    label96:
    label115:
    do
    {
      do
      {
        return;
        localTextView.setText(localCharSequence);
        if (parambcnt == null) {
          break;
        }
        parambcnt.setVisibility(0);
        break;
        parambcfj.setText(parambcnt);
        return;
      } while (!(parambcfj instanceof bccx));
      parambcfj = (bccx)parambcfj;
      parambcnt = ((bcnp)parambcnt).h();
    } while (parambcnt == null);
    parambcfj = parambcfj.e();
    if (parambcfj == null)
    {
      parambcnt.setText("");
      return;
    }
    parambcnt.setText(parambcfj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcic
 * JD-Core Version:    0.7.0.1
 */