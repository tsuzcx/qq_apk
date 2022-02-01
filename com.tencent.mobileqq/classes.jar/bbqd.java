import android.graphics.Bitmap;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.lang.ref.WeakReference;

public class bbqd
  extends bbqp
  implements bbrs
{
  private bbqf jdField_a_of_type_Bbqf;
  private WeakReference<bbir> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  
  public bbqd(aobu paramaobu, bbir parambbir)
  {
    super(paramaobu);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambbir);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    bbir localbbir;
    do
    {
      return;
      localbbir = (bbir)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localbbir == null);
    localbbir.notifyDataSetChanged();
  }
  
  private void a(int paramInt1, int paramInt2, bbrt parambbrt)
  {
    if (!(parambbrt instanceof bbsd)) {
      return;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    ((bbsd)parambbrt).b(bool);
    if (paramInt1 == 1)
    {
      ((bbsd)parambbrt).a(true);
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      ((bbsd)parambbrt).a(true);
      return;
    case 1: 
      ((bbsd)parambbrt).a(true);
      return;
    }
    ((bbsd)parambbrt).a(true);
  }
  
  public void a(bbmy parambbmy, bbvg parambbvg, Bitmap paramBitmap)
  {
    super.a(parambbmy, parambbvg, paramBitmap);
  }
  
  public void a(bbrr parambbrr)
  {
    a();
  }
  
  public void a(bbrr parambbrr, String paramString1, String paramString2) {}
  
  public void b(bbmy parambbmy, bbvg parambbvg)
  {
    super.b(parambbmy, parambbvg);
    if (!(parambbmy instanceof bboe)) {}
    do
    {
      do
      {
        return;
      } while (!(parambbvg instanceof bbrt));
      parambbvg = ((bbrt)parambbvg).a();
      parambbvg.a(((bboe)parambbmy).c(), ((bboe)parambbmy).d(), ((bboe)parambbmy).e());
      parambbvg.a(this);
    } while (!(parambbvg instanceof bbrp));
    ((bbrp)parambbvg).a(true);
  }
  
  protected void c(bbmy parambbmy, bbvg parambbvg)
  {
    if (this.jdField_a_of_type_Bbqf != null)
    {
      if (parambbvg.a() != null) {
        parambbvg.a().setOnClickListener(new bbqe(this));
      }
      return;
    }
    super.c(parambbmy, parambbvg);
  }
  
  public void d(bbmy parambbmy, bbvg parambbvg)
  {
    if (!(parambbvg instanceof bbrt)) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    a(parambbmy.a(), parambbmy.b(), (bbrt)parambbvg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqd
 * JD-Core Version:    0.7.0.1
 */