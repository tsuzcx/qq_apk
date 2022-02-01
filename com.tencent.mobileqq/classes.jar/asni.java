import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.FileUtils;

public class asni
  implements bbbn<bayt, bbhb>
{
  public void a(bayt parambayt, bbhb parambbhb)
  {
    if ((parambbhb.a() != null) && (!TextUtils.isEmpty(parambayt.a())))
    {
      parambbhb.a().setVisibility(0);
      parambbhb.a().setText(parambayt.a());
    }
    if ((parambbhb.b() != null) && (!TextUtils.isEmpty(parambayt.b())))
    {
      parambbhb.b().setVisibility(0);
      parambbhb.b().setText(parambayt.b());
    }
    if ((parambbhb.c() != null) && (!TextUtils.isEmpty(parambayt.c())))
    {
      parambbhb.c().setVisibility(0);
      parambbhb.c().setText(parambayt.c());
    }
    if ((parambayt.d() == null) && (parambbhb.d() != null)) {
      parambbhb.d().setVisibility(8);
    }
    if ((parambbhb.d() != null) && (parambayt.d() != null))
    {
      parambbhb.d().setVisibility(0);
      parambbhb.d().setText(parambayt.d());
    }
    AsyncImageView localAsyncImageView = (AsyncImageView)parambbhb.b();
    Object localObject = (asnh)parambayt;
    String str = ((asnh)localObject).c();
    localObject = ((asnh)localObject).d();
    if (FileUtils.fileExistsAndNotEmpty(str)) {
      aszt.a(localAsyncImageView, str, aszt.a((String)localObject));
    }
    for (;;)
    {
      parambbhb = parambbhb.a();
      if (parambbhb != null) {
        parambbhb.setOnClickListener(new asnj(this, parambayt));
      }
      return;
      localAsyncImageView.setDefaultImage(aszt.b((String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asni
 * JD-Core Version:    0.7.0.1
 */