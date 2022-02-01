import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;

public class bchs
  extends bchu
{
  public bchs(FaceDecoder paramFaceDecoder, bchy parambchy)
  {
    super(paramFaceDecoder, parambchy);
  }
  
  public void b(bcfj parambcfj, bcnt parambcnt)
  {
    super.b(parambcfj, parambcnt);
    if (TextUtils.isEmpty(parambcfj.c()))
    {
      parambcnt.c().setVisibility(8);
      ((bcnm)parambcnt).a().setVisibility(0);
    }
    for (;;)
    {
      if (parambcnt.d() != null)
      {
        parambcfj = parambcfj.d();
        if (!TextUtils.isEmpty(parambcfj)) {
          break;
        }
        parambcnt.d().setVisibility(8);
      }
      return;
      parambcnt.c().setVisibility(0);
      parambcnt.c().setText(parambcfj.c());
      ((bcnm)parambcnt).a().setVisibility(8);
    }
    parambcnt.d().setVisibility(0);
    parambcnt.d().setText(parambcfj);
  }
  
  protected void c(bcfj parambcfj, bcnt parambcnt)
  {
    super.c(parambcfj, parambcnt);
    ((bcnm)parambcnt).a().setOnClickListener(new bcht(this, parambcfj));
  }
  
  public void d(bcfj parambcfj, bcnt parambcnt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchs
 * JD-Core Version:    0.7.0.1
 */