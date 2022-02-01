import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;

public class bcjq
  extends bchu
{
  public bcjq(FaceDecoder paramFaceDecoder, bchy parambchy)
  {
    super(paramFaceDecoder, parambchy);
  }
  
  public void b(bcfj parambcfj, bcnt parambcnt)
  {
    super.b(parambcfj, parambcnt);
    if (TextUtils.isEmpty(parambcfj.c()))
    {
      parambcnt.c().setVisibility(8);
      ((bcpk)parambcnt).a().setVisibility(0);
      if (parambcnt.b() != null)
      {
        parambcfj = ((bcgt)parambcfj).d();
        if (!TextUtils.isEmpty(parambcfj)) {
          break label127;
        }
        parambcnt.b().setVisibility(8);
      }
    }
    for (;;)
    {
      parambcnt.d().setVisibility(8);
      return;
      parambcnt.c().setVisibility(0);
      parambcnt.c().setText(parambcfj.c());
      ((bcpk)parambcnt).a().setVisibility(8);
      break;
      label127:
      parambcnt.b().setVisibility(0);
      parambcnt.b().setText(parambcfj);
    }
  }
  
  protected void c(bcfj parambcfj, bcnt parambcnt)
  {
    super.c(parambcfj, parambcnt);
    ((bcpk)parambcnt).a().setOnClickListener(new bcjr(this, parambcfj));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjq
 * JD-Core Version:    0.7.0.1
 */