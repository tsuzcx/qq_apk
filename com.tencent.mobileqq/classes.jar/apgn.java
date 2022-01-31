import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class apgn
  implements awrd<awoi, awwr>
{
  public void a(awoi paramawoi, awwr paramawwr)
  {
    if ((paramawwr.a() != null) && (!TextUtils.isEmpty(paramawoi.a())))
    {
      paramawwr.a().setVisibility(0);
      paramawwr.a().setText(paramawoi.a());
    }
    if ((paramawwr.b() != null) && (!TextUtils.isEmpty(paramawoi.b())))
    {
      paramawwr.b().setVisibility(0);
      paramawwr.b().setText(paramawoi.b());
    }
    if ((paramawwr.c() != null) && (!TextUtils.isEmpty(paramawoi.c())))
    {
      paramawwr.c().setVisibility(0);
      paramawwr.c().setText(paramawoi.c());
    }
    if ((paramawoi.d() == null) && (paramawwr.d() != null)) {
      paramawwr.d().setVisibility(8);
    }
    if ((paramawwr.d() != null) && (paramawoi.d() != null))
    {
      paramawwr.d().setVisibility(0);
      paramawwr.d().setText(paramawoi.d());
    }
    AsyncImageView localAsyncImageView = (AsyncImageView)paramawwr.b();
    Object localObject = (apgm)paramawoi;
    String str = ((apgm)localObject).c();
    localObject = ((apgm)localObject).d();
    if (bbdx.b(str)) {
      apug.a(localAsyncImageView, str, apug.a((String)localObject));
    }
    for (;;)
    {
      paramawwr = paramawwr.a();
      if (paramawwr != null) {
        paramawwr.setOnClickListener(new apgo(this, paramawoi));
      }
      return;
      localAsyncImageView.setDefaultImage(apug.b((String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apgn
 * JD-Core Version:    0.7.0.1
 */