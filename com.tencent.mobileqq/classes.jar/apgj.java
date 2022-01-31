import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class apgj
  implements awrb<awog, awwp>
{
  public void a(awog paramawog, awwp paramawwp)
  {
    if ((paramawwp.a() != null) && (!TextUtils.isEmpty(paramawog.a())))
    {
      paramawwp.a().setVisibility(0);
      paramawwp.a().setText(paramawog.a());
    }
    if ((paramawwp.b() != null) && (!TextUtils.isEmpty(paramawog.b())))
    {
      paramawwp.b().setVisibility(0);
      paramawwp.b().setText(paramawog.b());
    }
    if ((paramawwp.c() != null) && (!TextUtils.isEmpty(paramawog.c())))
    {
      paramawwp.c().setVisibility(0);
      paramawwp.c().setText(paramawog.c());
    }
    if ((paramawog.d() == null) && (paramawwp.d() != null)) {
      paramawwp.d().setVisibility(8);
    }
    if ((paramawwp.d() != null) && (paramawog.d() != null))
    {
      paramawwp.d().setVisibility(0);
      paramawwp.d().setText(paramawog.d());
    }
    AsyncImageView localAsyncImageView = (AsyncImageView)paramawwp.b();
    Object localObject = (apgi)paramawog;
    String str = ((apgi)localObject).c();
    localObject = ((apgi)localObject).d();
    if (bbdj.b(str)) {
      apue.a(localAsyncImageView, str, apue.a((String)localObject));
    }
    for (;;)
    {
      paramawwp = paramawwp.a();
      if (paramawwp != null) {
        paramawwp.setOnClickListener(new apgk(this, paramawog));
      }
      return;
      localAsyncImageView.setDefaultImage(apue.b((String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apgj
 * JD-Core Version:    0.7.0.1
 */