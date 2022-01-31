import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class aopa
  implements avri<avon, avww>
{
  public void a(avon paramavon, avww paramavww)
  {
    if ((paramavww.a() != null) && (!TextUtils.isEmpty(paramavon.a())))
    {
      paramavww.a().setVisibility(0);
      paramavww.a().setText(paramavon.a());
    }
    if ((paramavww.b() != null) && (!TextUtils.isEmpty(paramavon.b())))
    {
      paramavww.b().setVisibility(0);
      paramavww.b().setText(paramavon.b());
    }
    if ((paramavww.c() != null) && (!TextUtils.isEmpty(paramavon.c())))
    {
      paramavww.c().setVisibility(0);
      paramavww.c().setText(paramavon.c());
    }
    if ((paramavon.d() == null) && (paramavww.d() != null)) {
      paramavww.d().setVisibility(8);
    }
    if ((paramavww.d() != null) && (paramavon.d() != null))
    {
      paramavww.d().setVisibility(0);
      paramavww.d().setText(paramavon.d());
    }
    AsyncImageView localAsyncImageView = (AsyncImageView)paramavww.b();
    Object localObject = (aooz)paramavon;
    String str = ((aooz)localObject).c();
    localObject = ((aooz)localObject).d();
    if (bace.b(str)) {
      apck.a(localAsyncImageView, str, apck.a((String)localObject));
    }
    for (;;)
    {
      paramavww = paramavww.a();
      if (paramavww != null) {
        paramavww.setOnClickListener(new aopb(this, paramavon));
      }
      return;
      localAsyncImageView.setDefaultImage(apck.b((String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aopa
 * JD-Core Version:    0.7.0.1
 */