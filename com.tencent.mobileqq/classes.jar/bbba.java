import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;

public class bbba
  extends bbbc
{
  public bbba(FaceDecoder paramFaceDecoder, bbbg parambbbg)
  {
    super(paramFaceDecoder, parambbbg);
  }
  
  public void b(bayt parambayt, bbhb parambbhb)
  {
    super.b(parambayt, parambbhb);
    if (TextUtils.isEmpty(parambayt.c()))
    {
      parambbhb.c().setVisibility(8);
      ((bbgu)parambbhb).a().setVisibility(0);
    }
    for (;;)
    {
      if (parambbhb.d() != null)
      {
        parambayt = parambayt.d();
        if (!TextUtils.isEmpty(parambayt)) {
          break;
        }
        parambbhb.d().setVisibility(8);
      }
      return;
      parambbhb.c().setVisibility(0);
      parambbhb.c().setText(parambayt.c());
      ((bbgu)parambbhb).a().setVisibility(8);
    }
    parambbhb.d().setVisibility(0);
    parambbhb.d().setText(parambayt);
  }
  
  protected void c(bayt parambayt, bbhb parambbhb)
  {
    super.c(parambayt, parambbhb);
    ((bbgu)parambbhb).a().setOnClickListener(new bbbb(this, parambayt));
  }
  
  public void d(bayt parambayt, bbhb parambbhb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbba
 * JD-Core Version:    0.7.0.1
 */