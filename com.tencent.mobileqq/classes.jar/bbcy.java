import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;

public class bbcy
  extends bbbc
{
  public bbcy(FaceDecoder paramFaceDecoder, bbbg parambbbg)
  {
    super(paramFaceDecoder, parambbbg);
  }
  
  public void b(bayt parambayt, bbhb parambbhb)
  {
    super.b(parambayt, parambbhb);
    if (TextUtils.isEmpty(parambayt.c()))
    {
      parambbhb.c().setVisibility(8);
      ((bbis)parambbhb).a().setVisibility(0);
      if (parambbhb.b() != null)
      {
        parambayt = ((bbad)parambayt).d();
        if (!TextUtils.isEmpty(parambayt)) {
          break label127;
        }
        parambbhb.b().setVisibility(8);
      }
    }
    for (;;)
    {
      parambbhb.d().setVisibility(8);
      return;
      parambbhb.c().setVisibility(0);
      parambbhb.c().setText(parambayt.c());
      ((bbis)parambbhb).a().setVisibility(8);
      break;
      label127:
      parambbhb.b().setVisibility(0);
      parambbhb.b().setText(parambayt);
    }
  }
  
  protected void c(bayt parambayt, bbhb parambbhb)
  {
    super.c(parambayt, parambbhb);
    ((bbis)parambbhb).a().setOnClickListener(new bbcz(this, parambayt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcy
 * JD-Core Version:    0.7.0.1
 */