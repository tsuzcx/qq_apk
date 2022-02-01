import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.FileUtils;

public class atro
  implements bcif<bcfj, bcnt>
{
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
    AsyncImageView localAsyncImageView = (AsyncImageView)parambcnt.b();
    Object localObject = (atrn)parambcfj;
    String str = ((atrn)localObject).c();
    localObject = ((atrn)localObject).d();
    if (FileUtils.fileExistsAndNotEmpty(str)) {
      auea.a(localAsyncImageView, str, auea.a((String)localObject));
    }
    for (;;)
    {
      parambcnt = parambcnt.a();
      if (parambcnt != null) {
        parambcnt.setOnClickListener(new atrp(this, parambcfj));
      }
      return;
      localAsyncImageView.setDefaultImage(auea.b((String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atro
 * JD-Core Version:    0.7.0.1
 */