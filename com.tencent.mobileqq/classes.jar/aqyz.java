import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class aqyz
  implements aymg<ayjl, ayru>
{
  private aqze a;
  
  public void a(aqze paramaqze)
  {
    this.a = paramaqze;
  }
  
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
    aqyy localaqyy = (aqyy)paramayjl;
    View localView = paramayru.a();
    paramayru = (AsyncImageView)paramayru.b();
    String str = localaqyy.c();
    int i = localaqyy.e();
    if (!TextUtils.isEmpty(str))
    {
      arni.a(paramayru, str, i);
      paramayru.setOnClickListener(new aqza(this, paramayjl));
      paramayru = (CheckBox)localView.findViewById(2131366313);
      if (localaqyy.d() <= 1) {
        break label336;
      }
      paramayru.setVisibility(8);
    }
    for (;;)
    {
      paramayru.setChecked(localaqyy.b());
      localView.setOnClickListener(new aqzb(this, paramayjl));
      return;
      paramayru.setDefaultImage(arni.a(i));
      break;
      label336:
      paramayru.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqyz
 * JD-Core Version:    0.7.0.1
 */