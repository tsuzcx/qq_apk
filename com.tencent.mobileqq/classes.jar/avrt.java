import android.graphics.Bitmap;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.lang.ref.WeakReference;

public class avrt
  extends avsf
  implements avti
{
  private avrv jdField_a_of_type_Avrv;
  private WeakReference<avkm> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  
  public avrt(azwg paramazwg, avkm paramavkm)
  {
    super(paramazwg);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramavkm);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    avkm localavkm;
    do
    {
      return;
      localavkm = (avkm)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localavkm == null);
    localavkm.notifyDataSetChanged();
  }
  
  private void a(int paramInt1, int paramInt2, avtj paramavtj)
  {
    if (!(paramavtj instanceof avtt)) {
      return;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    ((avtt)paramavtj).b(bool);
    if (paramInt1 == 1)
    {
      ((avtt)paramavtj).a(true);
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      ((avtt)paramavtj).a(true);
      return;
    case 1: 
      ((avtt)paramavtj).a(true);
      return;
    }
    ((avtt)paramavtj).a(true);
  }
  
  public void a(avon paramavon, avww paramavww, Bitmap paramBitmap)
  {
    super.a(paramavon, paramavww, paramBitmap);
  }
  
  public void a(avth paramavth)
  {
    a();
  }
  
  public void a(avth paramavth, String paramString1, String paramString2) {}
  
  public void b(avon paramavon, avww paramavww)
  {
    super.b(paramavon, paramavww);
    if (!(paramavon instanceof avpt)) {}
    do
    {
      do
      {
        return;
      } while (!(paramavww instanceof avtj));
      paramavww = ((avtj)paramavww).a();
      paramavww.a(((avpt)paramavon).c(), ((avpt)paramavon).d(), ((avpt)paramavon).e());
      paramavww.a(this);
    } while (!(paramavww instanceof avtf));
    ((avtf)paramavww).a(true);
  }
  
  protected void c(avon paramavon, avww paramavww)
  {
    if (this.jdField_a_of_type_Avrv != null)
    {
      if (paramavww.a() != null) {
        paramavww.a().setOnClickListener(new avru(this));
      }
      return;
    }
    super.c(paramavon, paramavww);
  }
  
  public void d(avon paramavon, avww paramavww)
  {
    if (!(paramavww instanceof avtj)) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    a(paramavon.a(), paramavon.b(), (avtj)paramavww);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrt
 * JD-Core Version:    0.7.0.1
 */