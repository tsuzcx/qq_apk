import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;

public final class bgmf
  extends Drawable.ConstantState
{
  int jdField_a_of_type_Int = 30;
  bgmh jdField_a_of_type_Bgmh;
  bgmo jdField_a_of_type_Bgmo;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  
  private bgmf(bgmb parambgmb) {}
  
  public int a()
  {
    if (this.jdField_a_of_type_Bgmh == null) {
      return 0;
    }
    return this.jdField_a_of_type_Bgmh.a();
  }
  
  public void a(Rect paramRect)
  {
    this.jdField_a_of_type_Bgmh.a(paramRect);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.equals(paramString))) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_Bgmh == null)
    {
      this.jdField_a_of_type_Bgmh = new bgmh(BaseApplicationImpl.getApplication());
      if (this.jdField_a_of_type_Bgmo == null) {
        this.jdField_a_of_type_Bgmo = new bgmg(this);
      }
      this.jdField_a_of_type_Bgmh.a(this.jdField_a_of_type_Bgmo);
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramString)))
      {
        if (!URLUtil.isNetworkUrl(paramString)) {
          break label148;
        }
        this.jdField_a_of_type_Bgmh.a(paramString, -1, true);
      }
    }
    for (;;)
    {
      if (paramInt > 0) {
        this.jdField_a_of_type_Int = paramInt;
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_Bgmh.a();
      break;
      label148:
      this.jdField_a_of_type_Bgmh.a(paramString, true);
    }
  }
  
  public int b()
  {
    return a() * 1000 / this.jdField_a_of_type_Int;
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  public Drawable newDrawable()
  {
    return new bgmb(this);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new bgmb(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgmf
 * JD-Core Version:    0.7.0.1
 */