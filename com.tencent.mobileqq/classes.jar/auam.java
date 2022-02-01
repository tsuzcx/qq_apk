import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class auam
  implements bcil<bcfr, bcnz>
{
  private auar a;
  
  public void a(auar paramauar)
  {
    this.a = paramauar;
  }
  
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
    aual localaual = (aual)parambcfr;
    View localView = parambcnz.a();
    parambcnz = (AsyncImageView)parambcnz.b();
    String str = localaual.c();
    int i = localaual.e();
    if (!TextUtils.isEmpty(str))
    {
      aunj.a(parambcnz, str, i);
      parambcnz.setOnClickListener(new auan(this, parambcfr));
      parambcnz = (CheckBox)localView.findViewById(2131366617);
      if (localaual.d() <= 1) {
        break label336;
      }
      parambcnz.setVisibility(8);
    }
    for (;;)
    {
      parambcnz.setChecked(localaual.b());
      localView.setOnClickListener(new auao(this, parambcfr));
      return;
      parambcnz.setDefaultImage(aunj.a(i));
      break;
      label336:
      parambcnz.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auam
 * JD-Core Version:    0.7.0.1
 */