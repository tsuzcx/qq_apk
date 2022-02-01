import android.graphics.Bitmap;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.lang.ref.WeakReference;

public class bbby
  extends bbck
  implements bbdn
{
  private bbca jdField_a_of_type_Bbca;
  private WeakReference<baup> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  
  public bbby(FaceDecoder paramFaceDecoder, baup parambaup)
  {
    super(paramFaceDecoder);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambaup);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    baup localbaup;
    do
    {
      return;
      localbaup = (baup)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localbaup == null);
    localbaup.notifyDataSetChanged();
  }
  
  private void a(int paramInt1, int paramInt2, bbdo parambbdo)
  {
    if (!(parambbdo instanceof bbdy)) {
      return;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    ((bbdy)parambbdo).b(bool);
    if (paramInt1 == 1)
    {
      ((bbdy)parambbdo).a(true);
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      ((bbdy)parambbdo).a(true);
      return;
    case 1: 
      ((bbdy)parambbdo).a(true);
      return;
    }
    ((bbdy)parambbdo).a(true);
  }
  
  public void a(bayt parambayt, bbhb parambbhb, Bitmap paramBitmap)
  {
    super.a(parambayt, parambbhb, paramBitmap);
  }
  
  public void a(bbdm parambbdm)
  {
    a();
  }
  
  public void a(bbdm parambbdm, String paramString1, String paramString2) {}
  
  public void b(bayt parambayt, bbhb parambbhb)
  {
    super.b(parambayt, parambbhb);
    if (!(parambayt instanceof bazz)) {}
    do
    {
      do
      {
        return;
      } while (!(parambbhb instanceof bbdo));
      parambbhb = ((bbdo)parambbhb).a();
      parambbhb.a(((bazz)parambayt).c(), ((bazz)parambayt).d(), ((bazz)parambayt).e());
      parambbhb.a(this);
    } while (!(parambbhb instanceof bbdk));
    ((bbdk)parambbhb).a(true);
  }
  
  protected void c(bayt parambayt, bbhb parambbhb)
  {
    if (this.jdField_a_of_type_Bbca != null)
    {
      if (parambbhb.a() != null) {
        parambbhb.a().setOnClickListener(new bbbz(this));
      }
      return;
    }
    super.c(parambayt, parambbhb);
  }
  
  public void d(bayt parambayt, bbhb parambbhb)
  {
    if (!(parambbhb instanceof bbdo)) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    a(parambayt.a(), parambayt.b(), (bbdo)parambbhb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbby
 * JD-Core Version:    0.7.0.1
 */