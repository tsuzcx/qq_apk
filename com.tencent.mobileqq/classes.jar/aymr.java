import android.graphics.Bitmap;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.lang.ref.WeakReference;

public class aymr
  extends aynd
  implements ayog
{
  private aymt jdField_a_of_type_Aymt;
  private WeakReference<ayfh> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  
  public aymr(bcws parambcws, ayfh paramayfh)
  {
    super(parambcws);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramayfh);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    ayfh localayfh;
    do
    {
      return;
      localayfh = (ayfh)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localayfh == null);
    localayfh.notifyDataSetChanged();
  }
  
  private void a(int paramInt1, int paramInt2, ayoh paramayoh)
  {
    if (!(paramayoh instanceof ayor)) {
      return;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    ((ayor)paramayoh).b(bool);
    if (paramInt1 == 1)
    {
      ((ayor)paramayoh).a(true);
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      ((ayor)paramayoh).a(true);
      return;
    case 1: 
      ((ayor)paramayoh).a(true);
      return;
    }
    ((ayor)paramayoh).a(true);
  }
  
  public void a(ayjl paramayjl, ayru paramayru, Bitmap paramBitmap)
  {
    super.a(paramayjl, paramayru, paramBitmap);
  }
  
  public void a(ayof paramayof)
  {
    a();
  }
  
  public void a(ayof paramayof, String paramString1, String paramString2) {}
  
  public void b(ayjl paramayjl, ayru paramayru)
  {
    super.b(paramayjl, paramayru);
    if (!(paramayjl instanceof aykr)) {}
    do
    {
      do
      {
        return;
      } while (!(paramayru instanceof ayoh));
      paramayru = ((ayoh)paramayru).a();
      paramayru.a(((aykr)paramayjl).c(), ((aykr)paramayjl).d(), ((aykr)paramayjl).e());
      paramayru.a(this);
    } while (!(paramayru instanceof ayod));
    ((ayod)paramayru).a(true);
  }
  
  protected void c(ayjl paramayjl, ayru paramayru)
  {
    if (this.jdField_a_of_type_Aymt != null)
    {
      if (paramayru.a() != null) {
        paramayru.a().setOnClickListener(new ayms(this));
      }
      return;
    }
    super.c(paramayjl, paramayru);
  }
  
  public void d(ayjl paramayjl, ayru paramayru)
  {
    if (!(paramayru instanceof ayoh)) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    a(paramayjl.a(), paramayjl.b(), (ayoh)paramayru);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymr
 * JD-Core Version:    0.7.0.1
 */