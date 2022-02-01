import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class asmw
  implements bbbn<bayt, bbhb>
{
  private asnb a;
  
  public void a(asnb paramasnb)
  {
    this.a = paramasnb;
  }
  
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
    asmv localasmv = (asmv)parambayt;
    View localView = parambbhb.a();
    parambbhb = (AsyncImageView)parambbhb.b();
    String str = localasmv.c();
    int i = localasmv.e();
    if (!TextUtils.isEmpty(str))
    {
      aszt.a(parambbhb, str, i);
      parambbhb.setOnClickListener(new asmx(this, parambayt));
      parambbhb = (CheckBox)localView.findViewById(2131366644);
      if (localasmv.d() <= 1) {
        break label336;
      }
      parambbhb.setVisibility(8);
    }
    for (;;)
    {
      parambbhb.setChecked(localasmv.b());
      localView.setOnClickListener(new asmy(this, parambayt));
      return;
      parambbhb.setDefaultImage(aszt.a(i));
      break;
      label336:
      parambbhb.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmw
 * JD-Core Version:    0.7.0.1
 */