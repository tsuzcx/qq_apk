import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class apgb
  implements awrd<awoi, awwr>
{
  private apgg a;
  
  public void a(apgg paramapgg)
  {
    this.a = paramapgg;
  }
  
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
    apga localapga = (apga)paramawoi;
    View localView = paramawwr.a();
    paramawwr = (AsyncImageView)paramawwr.b();
    String str = localapga.c();
    int i = localapga.e();
    if (!TextUtils.isEmpty(str))
    {
      apug.a(paramawwr, str, i);
      paramawwr.setOnClickListener(new apgc(this, paramawoi));
      paramawwr = (CheckBox)localView.findViewById(2131366225);
      if (localapga.d() <= 1) {
        break label336;
      }
      paramawwr.setVisibility(8);
    }
    for (;;)
    {
      paramawwr.setChecked(localapga.b());
      localView.setOnClickListener(new apgd(this, paramawoi));
      return;
      paramawwr.setDefaultImage(apug.a(i));
      break;
      label336:
      paramawwr.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apgb
 * JD-Core Version:    0.7.0.1
 */