import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class atrc
  implements bcif<bcfj, bcnt>
{
  private atrh a;
  
  public void a(atrh paramatrh)
  {
    this.a = paramatrh;
  }
  
  public void a(bcfj parambcfj, bcnt parambcnt)
  {
    if ((parambcnt.a() != null) && (!TextUtils.isEmpty(parambcfj.a())))
    {
      parambcnt.a().setVisibility(0);
      parambcnt.a().setText(parambcfj.a());
    }
    if ((parambcnt.b() != null) && (!TextUtils.isEmpty(parambcfj.b())))
    {
      parambcnt.b().setVisibility(0);
      parambcnt.b().setText(parambcfj.b());
    }
    if ((parambcnt.c() != null) && (!TextUtils.isEmpty(parambcfj.c())))
    {
      parambcnt.c().setVisibility(0);
      parambcnt.c().setText(parambcfj.c());
    }
    if ((parambcfj.d() == null) && (parambcnt.d() != null)) {
      parambcnt.d().setVisibility(8);
    }
    if ((parambcnt.d() != null) && (parambcfj.d() != null))
    {
      parambcnt.d().setVisibility(0);
      parambcnt.d().setText(parambcfj.d());
    }
    atrb localatrb = (atrb)parambcfj;
    View localView = parambcnt.a();
    parambcnt = (AsyncImageView)parambcnt.b();
    String str = localatrb.c();
    int i = localatrb.e();
    if (!TextUtils.isEmpty(str))
    {
      auea.a(parambcnt, str, i);
      parambcnt.setOnClickListener(new atrd(this, parambcfj));
      parambcnt = (CheckBox)localView.findViewById(2131366755);
      if (localatrb.d() <= 1) {
        break label336;
      }
      parambcnt.setVisibility(8);
    }
    for (;;)
    {
      parambcnt.setChecked(localatrb.b());
      localView.setOnClickListener(new atre(this, parambcfj));
      return;
      parambcnt.setDefaultImage(auea.a(i));
      break;
      label336:
      parambcnt.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atrc
 * JD-Core Version:    0.7.0.1
 */