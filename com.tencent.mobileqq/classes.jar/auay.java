import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class auay
  implements bcil<bcfr, bcnz>
{
  public void a(bcfr parambcfr, bcnz parambcnz)
  {
    if ((parambcnz.a() != null) && (!TextUtils.isEmpty(parambcfr.a())))
    {
      parambcnz.a().setVisibility(0);
      parambcnz.a().setText(parambcfr.a());
    }
    if ((parambcnz.b() != null) && (!TextUtils.isEmpty(parambcfr.b())))
    {
      parambcnz.b().setVisibility(0);
      parambcnz.b().setText(parambcfr.b());
    }
    if ((parambcnz.c() != null) && (!TextUtils.isEmpty(parambcfr.c())))
    {
      parambcnz.c().setVisibility(0);
      parambcnz.c().setText(parambcfr.c());
    }
    if ((parambcfr.d() == null) && (parambcnz.d() != null)) {
      parambcnz.d().setVisibility(8);
    }
    if ((parambcnz.d() != null) && (parambcfr.d() != null))
    {
      parambcnz.d().setVisibility(0);
      parambcnz.d().setText(parambcfr.d());
    }
    AsyncImageView localAsyncImageView = (AsyncImageView)parambcnz.b();
    Object localObject = (auax)parambcfr;
    String str = ((auax)localObject).c();
    localObject = ((auax)localObject).d();
    if (bhmi.b(str)) {
      aunj.a(localAsyncImageView, str, aunj.a((String)localObject));
    }
    for (;;)
    {
      parambcnz = parambcnz.a();
      if (parambcnz != null) {
        parambcnz.setOnClickListener(new auaz(this, parambcfr));
      }
      return;
      localAsyncImageView.setDefaultImage(aunj.b((String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auay
 * JD-Core Version:    0.7.0.1
 */