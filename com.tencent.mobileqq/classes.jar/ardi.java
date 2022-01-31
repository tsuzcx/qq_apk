import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class ardi
  implements ayqp<aynu, aywd>
{
  private ardn a;
  
  public void a(ardn paramardn)
  {
    this.a = paramardn;
  }
  
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
    ardh localardh = (ardh)paramaynu;
    View localView = paramaywd.a();
    paramaywd = (AsyncImageView)paramaywd.b();
    String str = localardh.c();
    int i = localardh.e();
    if (!TextUtils.isEmpty(str))
    {
      arrr.a(paramaywd, str, i);
      paramaywd.setOnClickListener(new ardj(this, paramaynu));
      paramaywd = (CheckBox)localView.findViewById(2131366315);
      if (localardh.d() <= 1) {
        break label336;
      }
      paramaywd.setVisibility(8);
    }
    for (;;)
    {
      paramaywd.setChecked(localardh.b());
      localView.setOnClickListener(new ardk(this, paramaynu));
      return;
      paramaywd.setDefaultImage(arrr.a(i));
      break;
      label336:
      paramaywd.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ardi
 * JD-Core Version:    0.7.0.1
 */