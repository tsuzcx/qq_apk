import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class aylt
  extends aylv
{
  public aylt(bcws parambcws, aylz paramaylz)
  {
    super(parambcws, paramaylz);
  }
  
  public void b(ayjl paramayjl, ayru paramayru)
  {
    super.b(paramayjl, paramayru);
    if (TextUtils.isEmpty(paramayjl.c()))
    {
      paramayru.c().setVisibility(8);
      ((ayrn)paramayru).a().setVisibility(0);
    }
    for (;;)
    {
      if (paramayru.d() != null)
      {
        paramayjl = paramayjl.d();
        if (!TextUtils.isEmpty(paramayjl)) {
          break;
        }
        paramayru.d().setVisibility(8);
      }
      return;
      paramayru.c().setVisibility(0);
      paramayru.c().setText(paramayjl.c());
      ((ayrn)paramayru).a().setVisibility(8);
    }
    paramayru.d().setVisibility(0);
    paramayru.d().setText(paramayjl);
  }
  
  protected void c(ayjl paramayjl, ayru paramayru)
  {
    super.c(paramayjl, paramayru);
    ((ayrn)paramayru).a().setOnClickListener(new aylu(this, paramayjl));
  }
  
  public void d(ayjl paramayjl, ayru paramayru) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylt
 * JD-Core Version:    0.7.0.1
 */