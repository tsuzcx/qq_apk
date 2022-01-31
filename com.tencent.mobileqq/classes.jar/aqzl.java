import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class aqzl
  implements aymg<ayjl, ayru>
{
  public void a(ayjl paramayjl, ayru paramayru)
  {
    if ((paramayru.a() != null) && (!TextUtils.isEmpty(paramayjl.a())))
    {
      paramayru.a().setVisibility(0);
      paramayru.a().setText(paramayjl.a());
    }
    if ((paramayru.b() != null) && (!TextUtils.isEmpty(paramayjl.b())))
    {
      paramayru.b().setVisibility(0);
      paramayru.b().setText(paramayjl.b());
    }
    if ((paramayru.c() != null) && (!TextUtils.isEmpty(paramayjl.c())))
    {
      paramayru.c().setVisibility(0);
      paramayru.c().setText(paramayjl.c());
    }
    if ((paramayjl.d() == null) && (paramayru.d() != null)) {
      paramayru.d().setVisibility(8);
    }
    if ((paramayru.d() != null) && (paramayjl.d() != null))
    {
      paramayru.d().setVisibility(0);
      paramayru.d().setText(paramayjl.d());
    }
    AsyncImageView localAsyncImageView = (AsyncImageView)paramayru.b();
    Object localObject = (aqzk)paramayjl;
    String str = ((aqzk)localObject).c();
    localObject = ((aqzk)localObject).d();
    if (bdcs.b(str)) {
      arni.a(localAsyncImageView, str, arni.a((String)localObject));
    }
    for (;;)
    {
      paramayru = paramayru.a();
      if (paramayru != null) {
        paramayru.setOnClickListener(new aqzm(this, paramayjl));
      }
      return;
      localAsyncImageView.setDefaultImage(arni.b((String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqzl
 * JD-Core Version:    0.7.0.1
 */