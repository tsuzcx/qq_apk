import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class atje
  implements bbps<bbmy, bbvg>
{
  public void a(bbmy parambbmy, bbvg parambbvg)
  {
    if ((parambbvg.a() != null) && (!TextUtils.isEmpty(parambbmy.a())))
    {
      parambbvg.a().setVisibility(0);
      parambbvg.a().setText(parambbmy.a());
    }
    if ((parambbvg.b() != null) && (!TextUtils.isEmpty(parambbmy.b())))
    {
      parambbvg.b().setVisibility(0);
      parambbvg.b().setText(parambbmy.b());
    }
    if ((parambbvg.c() != null) && (!TextUtils.isEmpty(parambbmy.c())))
    {
      parambbvg.c().setVisibility(0);
      parambbvg.c().setText(parambbmy.c());
    }
    if ((parambbmy.d() == null) && (parambbvg.d() != null)) {
      parambbvg.d().setVisibility(8);
    }
    if ((parambbvg.d() != null) && (parambbmy.d() != null))
    {
      parambbvg.d().setVisibility(0);
      parambbvg.d().setText(parambbmy.d());
    }
    AsyncImageView localAsyncImageView = (AsyncImageView)parambbvg.b();
    Object localObject = (atjd)parambbmy;
    String str = ((atjd)localObject).c();
    localObject = ((atjd)localObject).d();
    if (bgmg.b(str)) {
      atvo.a(localAsyncImageView, str, atvo.a((String)localObject));
    }
    for (;;)
    {
      parambbvg = parambbvg.a();
      if (parambbvg != null) {
        parambbvg.setOnClickListener(new atjf(this, parambbmy));
      }
      return;
      localAsyncImageView.setDefaultImage(atvo.b((String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atje
 * JD-Core Version:    0.7.0.1
 */