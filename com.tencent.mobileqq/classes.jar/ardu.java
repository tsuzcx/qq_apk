import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class ardu
  implements ayqp<aynu, aywd>
{
  public void a(aynu paramaynu, aywd paramaywd)
  {
    if ((paramaywd.a() != null) && (!TextUtils.isEmpty(paramaynu.a())))
    {
      paramaywd.a().setVisibility(0);
      paramaywd.a().setText(paramaynu.a());
    }
    if ((paramaywd.b() != null) && (!TextUtils.isEmpty(paramaynu.b())))
    {
      paramaywd.b().setVisibility(0);
      paramaywd.b().setText(paramaynu.b());
    }
    if ((paramaywd.c() != null) && (!TextUtils.isEmpty(paramaynu.c())))
    {
      paramaywd.c().setVisibility(0);
      paramaywd.c().setText(paramaynu.c());
    }
    if ((paramaynu.d() == null) && (paramaywd.d() != null)) {
      paramaywd.d().setVisibility(8);
    }
    if ((paramaywd.d() != null) && (paramaynu.d() != null))
    {
      paramaywd.d().setVisibility(0);
      paramaywd.d().setText(paramaynu.d());
    }
    AsyncImageView localAsyncImageView = (AsyncImageView)paramaywd.b();
    Object localObject = (ardt)paramaynu;
    String str = ((ardt)localObject).c();
    localObject = ((ardt)localObject).d();
    if (bdhb.b(str)) {
      arrr.a(localAsyncImageView, str, arrr.a((String)localObject));
    }
    for (;;)
    {
      paramaywd = paramaywd.a();
      if (paramaywd != null) {
        paramaywd.setOnClickListener(new ardv(this, paramaynu));
      }
      return;
      localAsyncImageView.setDefaultImage(arrr.b((String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ardu
 * JD-Core Version:    0.7.0.1
 */