import android.graphics.Bitmap;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.lang.ref.WeakReference;

public class bciw
  extends bcji
  implements bckl
{
  private bciy jdField_a_of_type_Bciy;
  private WeakReference<bcbl> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  
  public bciw(aoof paramaoof, bcbl parambcbl)
  {
    super(paramaoof);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambcbl);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    bcbl localbcbl;
    do
    {
      return;
      localbcbl = (bcbl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localbcbl == null);
    localbcbl.notifyDataSetChanged();
  }
  
  private void a(int paramInt1, int paramInt2, bckm parambckm)
  {
    if (!(parambckm instanceof bckw)) {
      return;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    ((bckw)parambckm).b(bool);
    if (paramInt1 == 1)
    {
      ((bckw)parambckm).a(true);
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      ((bckw)parambckm).a(true);
      return;
    case 1: 
      ((bckw)parambckm).a(true);
      return;
    }
    ((bckw)parambckm).a(true);
  }
  
  public void a(bcfr parambcfr, bcnz parambcnz, Bitmap paramBitmap)
  {
    super.a(parambcfr, parambcnz, paramBitmap);
  }
  
  public void a(bckk parambckk)
  {
    a();
  }
  
  public void a(bckk parambckk, String paramString1, String paramString2) {}
  
  public void b(bcfr parambcfr, bcnz parambcnz)
  {
    super.b(parambcfr, parambcnz);
    if (!(parambcfr instanceof bcgx)) {}
    do
    {
      do
      {
        return;
      } while (!(parambcnz instanceof bckm));
      parambcnz = ((bckm)parambcnz).a();
      parambcnz.a(((bcgx)parambcfr).c(), ((bcgx)parambcfr).d(), ((bcgx)parambcfr).e());
      parambcnz.a(this);
    } while (!(parambcnz instanceof bcki));
    ((bcki)parambcnz).a(true);
  }
  
  protected void c(bcfr parambcfr, bcnz parambcnz)
  {
    if (this.jdField_a_of_type_Bciy != null)
    {
      if (parambcnz.a() != null) {
        parambcnz.a().setOnClickListener(new bcix(this));
      }
      return;
    }
    super.c(parambcfr, parambcnz);
  }
  
  public void d(bcfr parambcfr, bcnz parambcnz)
  {
    if (!(parambcnz instanceof bckm)) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    a(parambcfr.a(), parambcfr.b(), (bckm)parambcnz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bciw
 * JD-Core Version:    0.7.0.1
 */