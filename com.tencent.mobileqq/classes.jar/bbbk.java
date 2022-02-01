import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;

public class bbbk
  extends bbck
{
  public bbbk(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  public void b(bayt parambayt, bbhb parambbhb)
  {
    super.b(parambayt, parambbhb);
    TextView localTextView;
    CharSequence localCharSequence;
    if ((parambayt instanceof bawi))
    {
      bawi localbawi = (bawi)parambayt;
      localTextView = ((bbgx)parambbhb).e();
      parambayt = ((bbgx)parambbhb).f();
      parambbhb = ((bbgx)parambbhb).g();
      if (localTextView != null)
      {
        localCharSequence = localbawi.e();
        if (localCharSequence != null) {
          break label96;
        }
        localTextView.setText("");
        if (parambbhb != null) {
          parambbhb.setVisibility(8);
        }
      }
      if (parambayt != null)
      {
        parambbhb = localbawi.f();
        if (parambbhb != null) {
          break label115;
        }
        parambayt.setText("");
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
        if (parambbhb == null) {
          break;
        }
        parambbhb.setVisibility(0);
        break;
        parambayt.setText(parambbhb);
        return;
      } while (!(parambayt instanceof bawh));
      parambayt = (bawh)parambayt;
      parambbhb = ((bbgx)parambbhb).h();
    } while (parambbhb == null);
    parambayt = parambayt.e();
    if (parambayt == null)
    {
      parambbhb.setText("");
      return;
    }
    parambbhb.setText(parambayt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbk
 * JD-Core Version:    0.7.0.1
 */