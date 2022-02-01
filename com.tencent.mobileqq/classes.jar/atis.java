import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class atis
  implements bbps<bbmy, bbvg>
{
  private atix a;
  
  public void a(atix paramatix)
  {
    this.a = paramatix;
  }
  
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
    atir localatir = (atir)parambbmy;
    View localView = parambbvg.a();
    parambbvg = (AsyncImageView)parambbvg.b();
    String str = localatir.c();
    int i = localatir.e();
    if (!TextUtils.isEmpty(str))
    {
      atvo.a(parambbvg, str, i);
      parambbvg.setOnClickListener(new atit(this, parambbmy));
      parambbvg = (CheckBox)localView.findViewById(2131366568);
      if (localatir.d() <= 1) {
        break label336;
      }
      parambbvg.setVisibility(8);
    }
    for (;;)
    {
      parambbvg.setChecked(localatir.b());
      localView.setOnClickListener(new atiu(this, parambbmy));
      return;
      parambbvg.setDefaultImage(atvo.a(i));
      break;
      label336:
      parambbvg.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atis
 * JD-Core Version:    0.7.0.1
 */