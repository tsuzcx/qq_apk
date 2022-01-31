import android.graphics.Bitmap;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.lang.ref.WeakReference;

public class awro
  extends awsa
  implements awtd
{
  private awrq jdField_a_of_type_Awrq;
  private WeakReference<awkh> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  
  public awro(baxy parambaxy, awkh paramawkh)
  {
    super(parambaxy);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramawkh);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    awkh localawkh;
    do
    {
      return;
      localawkh = (awkh)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localawkh == null);
    localawkh.notifyDataSetChanged();
  }
  
  private void a(int paramInt1, int paramInt2, awte paramawte)
  {
    if (!(paramawte instanceof awto)) {
      return;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    ((awto)paramawte).b(bool);
    if (paramInt1 == 1)
    {
      ((awto)paramawte).a(true);
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      ((awto)paramawte).a(true);
      return;
    case 1: 
      ((awto)paramawte).a(true);
      return;
    }
    ((awto)paramawte).a(true);
  }
  
  public void a(awoi paramawoi, awwr paramawwr, Bitmap paramBitmap)
  {
    super.a(paramawoi, paramawwr, paramBitmap);
  }
  
  public void a(awtc paramawtc)
  {
    a();
  }
  
  public void a(awtc paramawtc, String paramString1, String paramString2) {}
  
  public void b(awoi paramawoi, awwr paramawwr)
  {
    super.b(paramawoi, paramawwr);
    if (!(paramawoi instanceof awpo)) {}
    do
    {
      do
      {
        return;
      } while (!(paramawwr instanceof awte));
      paramawwr = ((awte)paramawwr).a();
      paramawwr.a(((awpo)paramawoi).c(), ((awpo)paramawoi).d(), ((awpo)paramawoi).e());
      paramawwr.a(this);
    } while (!(paramawwr instanceof awta));
    ((awta)paramawwr).a(true);
  }
  
  protected void c(awoi paramawoi, awwr paramawwr)
  {
    if (this.jdField_a_of_type_Awrq != null)
    {
      if (paramawwr.a() != null) {
        paramawwr.a().setOnClickListener(new awrp(this));
      }
      return;
    }
    super.c(paramawoi, paramawwr);
  }
  
  public void d(awoi paramawoi, awwr paramawwr)
  {
    if (!(paramawwr instanceof awte)) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    a(paramawoi.a(), paramawoi.b(), (awte)paramawwr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awro
 * JD-Core Version:    0.7.0.1
 */