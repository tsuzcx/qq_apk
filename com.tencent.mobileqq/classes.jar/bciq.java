import android.graphics.Bitmap;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.lang.ref.WeakReference;

public class bciq
  extends bcjc
  implements bckf
{
  private bcis jdField_a_of_type_Bcis;
  private WeakReference<bcbf> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  
  public bciq(FaceDecoder paramFaceDecoder, bcbf parambcbf)
  {
    super(paramFaceDecoder);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambcbf);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    bcbf localbcbf;
    do
    {
      return;
      localbcbf = (bcbf)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localbcbf == null);
    localbcbf.notifyDataSetChanged();
  }
  
  private void a(int paramInt1, int paramInt2, bckg parambckg)
  {
    if (!(parambckg instanceof bckq)) {
      return;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    ((bckq)parambckg).b(bool);
    if (paramInt1 == 1)
    {
      ((bckq)parambckg).a(true);
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      ((bckq)parambckg).a(true);
      return;
    case 1: 
      ((bckq)parambckg).a(true);
      return;
    }
    ((bckq)parambckg).a(true);
  }
  
  public void a(bcfj parambcfj, bcnt parambcnt, Bitmap paramBitmap)
  {
    super.a(parambcfj, parambcnt, paramBitmap);
  }
  
  public void a(bcke parambcke)
  {
    a();
  }
  
  public void a(bcke parambcke, String paramString1, String paramString2) {}
  
  public void b(bcfj parambcfj, bcnt parambcnt)
  {
    super.b(parambcfj, parambcnt);
    if (!(parambcfj instanceof bcgp)) {}
    do
    {
      do
      {
        return;
      } while (!(parambcnt instanceof bckg));
      parambcnt = ((bckg)parambcnt).a();
      parambcnt.a(((bcgp)parambcfj).c(), ((bcgp)parambcfj).d(), ((bcgp)parambcfj).e());
      parambcnt.a(this);
    } while (!(parambcnt instanceof bckc));
    ((bckc)parambcnt).a(true);
  }
  
  protected void c(bcfj parambcfj, bcnt parambcnt)
  {
    if (this.jdField_a_of_type_Bcis != null)
    {
      if (parambcnt.a() != null) {
        parambcnt.a().setOnClickListener(new bcir(this));
      }
      return;
    }
    super.c(parambcfj, parambcnt);
  }
  
  public void d(bcfj parambcfj, bcnt parambcnt)
  {
    if (!(parambcnt instanceof bckg)) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    a(parambcfj.a(), parambcfj.b(), (bckg)parambcnt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bciq
 * JD-Core Version:    0.7.0.1
 */