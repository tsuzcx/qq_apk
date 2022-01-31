import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class apfx
  implements awrb<awog, awwp>
{
  private apgc a;
  
  public void a(apgc paramapgc)
  {
    this.a = paramapgc;
  }
  
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
    apfw localapfw = (apfw)paramawog;
    View localView = paramawwp.a();
    paramawwp = (AsyncImageView)paramawwp.b();
    String str = localapfw.c();
    int i = localapfw.e();
    if (!TextUtils.isEmpty(str))
    {
      apue.a(paramawwp, str, i);
      paramawwp.setOnClickListener(new apfy(this, paramawog));
      paramawwp = (CheckBox)localView.findViewById(2131366225);
      if (localapfw.d() <= 1) {
        break label336;
      }
      paramawwp.setVisibility(8);
    }
    for (;;)
    {
      paramawwp.setChecked(localapfw.b());
      localView.setOnClickListener(new apfz(this, paramawog));
      return;
      paramawwp.setDefaultImage(apue.a(i));
      break;
      label336:
      paramawwp.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apfx
 * JD-Core Version:    0.7.0.1
 */