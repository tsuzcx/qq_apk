import android.graphics.Bitmap;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.lang.ref.WeakReference;

public class awrm
  extends awry
  implements awtb
{
  private awro jdField_a_of_type_Awro;
  private WeakReference<awkf> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  
  public awrm(baxk parambaxk, awkf paramawkf)
  {
    super(parambaxk);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramawkf);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    awkf localawkf;
    do
    {
      return;
      localawkf = (awkf)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localawkf == null);
    localawkf.notifyDataSetChanged();
  }
  
  private void a(int paramInt1, int paramInt2, awtc paramawtc)
  {
    if (!(paramawtc instanceof awtm)) {
      return;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    ((awtm)paramawtc).b(bool);
    if (paramInt1 == 1)
    {
      ((awtm)paramawtc).a(true);
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      ((awtm)paramawtc).a(true);
      return;
    case 1: 
      ((awtm)paramawtc).a(true);
      return;
    }
    ((awtm)paramawtc).a(true);
  }
  
  public void a(awog paramawog, awwp paramawwp, Bitmap paramBitmap)
  {
    super.a(paramawog, paramawwp, paramBitmap);
  }
  
  public void a(awta paramawta)
  {
    a();
  }
  
  public void a(awta paramawta, String paramString1, String paramString2) {}
  
  public void b(awog paramawog, awwp paramawwp)
  {
    super.b(paramawog, paramawwp);
    if (!(paramawog instanceof awpm)) {}
    do
    {
      do
      {
        return;
      } while (!(paramawwp instanceof awtc));
      paramawwp = ((awtc)paramawwp).a();
      paramawwp.a(((awpm)paramawog).c(), ((awpm)paramawog).d(), ((awpm)paramawog).e());
      paramawwp.a(this);
    } while (!(paramawwp instanceof awsy));
    ((awsy)paramawwp).a(true);
  }
  
  protected void c(awog paramawog, awwp paramawwp)
  {
    if (this.jdField_a_of_type_Awro != null)
    {
      if (paramawwp.a() != null) {
        paramawwp.a().setOnClickListener(new awrn(this));
      }
      return;
    }
    super.c(paramawog, paramawwp);
  }
  
  public void d(awog paramawog, awwp paramawwp)
  {
    if (!(paramawwp instanceof awtc)) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    a(paramawog.a(), paramawog.b(), (awtc)paramawwp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrm
 * JD-Core Version:    0.7.0.1
 */