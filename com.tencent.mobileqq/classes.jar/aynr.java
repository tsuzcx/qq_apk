import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class aynr
  extends aylv
{
  public aynr(bcws parambcws, aylz paramaylz)
  {
    super(parambcws, paramaylz);
  }
  
  public void b(ayjl paramayjl, ayru paramayru)
  {
    super.b(paramayjl, paramayru);
    if (TextUtils.isEmpty(paramayjl.c()))
    {
      paramayru.c().setVisibility(8);
      ((aytn)paramayru).a().setVisibility(0);
      if (paramayru.b() != null)
      {
        paramayjl = ((aykv)paramayjl).d();
        if (!TextUtils.isEmpty(paramayjl)) {
          break label127;
        }
        paramayru.b().setVisibility(8);
      }
    }
    for (;;)
    {
      paramayru.d().setVisibility(8);
      return;
      paramayru.c().setVisibility(0);
      paramayru.c().setText(paramayjl.c());
      ((aytn)paramayru).a().setVisibility(8);
      break;
      label127:
      paramayru.b().setVisibility(0);
      paramayru.b().setText(paramayjl);
    }
  }
  
  protected void c(ayjl paramayjl, ayru paramayru)
  {
    super.c(paramayjl, paramayru);
    ((aytn)paramayru).a().setOnClickListener(new ayns(this, paramayjl));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynr
 * JD-Core Version:    0.7.0.1
 */