import android.graphics.Bitmap;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.lang.ref.WeakReference;

public class ayra
  extends ayrm
  implements aysp
{
  private ayrc jdField_a_of_type_Ayrc;
  private WeakReference<ayjq> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  
  public ayra(bdbb parambdbb, ayjq paramayjq)
  {
    super(parambdbb);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramayjq);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    ayjq localayjq;
    do
    {
      return;
      localayjq = (ayjq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localayjq == null);
    localayjq.notifyDataSetChanged();
  }
  
  private void a(int paramInt1, int paramInt2, aysq paramaysq)
  {
    if (!(paramaysq instanceof ayta)) {
      return;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    ((ayta)paramaysq).b(bool);
    if (paramInt1 == 1)
    {
      ((ayta)paramaysq).a(true);
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      ((ayta)paramaysq).a(true);
      return;
    case 1: 
      ((ayta)paramaysq).a(true);
      return;
    }
    ((ayta)paramaysq).a(true);
  }
  
  public void a(aynu paramaynu, aywd paramaywd, Bitmap paramBitmap)
  {
    super.a(paramaynu, paramaywd, paramBitmap);
  }
  
  public void a(ayso paramayso)
  {
    a();
  }
  
  public void a(ayso paramayso, String paramString1, String paramString2) {}
  
  public void b(aynu paramaynu, aywd paramaywd)
  {
    super.b(paramaynu, paramaywd);
    if (!(paramaynu instanceof aypa)) {}
    do
    {
      do
      {
        return;
      } while (!(paramaywd instanceof aysq));
      paramaywd = ((aysq)paramaywd).a();
      paramaywd.a(((aypa)paramaynu).c(), ((aypa)paramaynu).d(), ((aypa)paramaynu).e());
      paramaywd.a(this);
    } while (!(paramaywd instanceof aysm));
    ((aysm)paramaywd).a(true);
  }
  
  protected void c(aynu paramaynu, aywd paramaywd)
  {
    if (this.jdField_a_of_type_Ayrc != null)
    {
      if (paramaywd.a() != null) {
        paramaywd.a().setOnClickListener(new ayrb(this));
      }
      return;
    }
    super.c(paramaynu, paramaywd);
  }
  
  public void d(aynu paramaynu, aywd paramaywd)
  {
    if (!(paramaywd instanceof aysq)) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    a(paramaynu.a(), paramaynu.b(), (aysq)paramaywd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayra
 * JD-Core Version:    0.7.0.1
 */