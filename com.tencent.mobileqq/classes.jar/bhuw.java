import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;

public final class bhuw
  extends Drawable.ConstantState
{
  int jdField_a_of_type_Int = 30;
  bhuy jdField_a_of_type_Bhuy;
  bhvf jdField_a_of_type_Bhvf;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  
  private bhuw(bhus parambhus) {}
  
  public int a()
  {
    if (this.jdField_a_of_type_Bhuy == null) {
      return 0;
    }
    return this.jdField_a_of_type_Bhuy.a();
  }
  
  public void a(Rect paramRect)
  {
    this.jdField_a_of_type_Bhuy.a(paramRect);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.equals(paramString))) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_Bhuy == null)
    {
      this.jdField_a_of_type_Bhuy = new bhuy(BaseApplicationImpl.getApplication());
      if (this.jdField_a_of_type_Bhvf == null) {
        this.jdField_a_of_type_Bhvf = new bhux(this);
      }
      this.jdField_a_of_type_Bhuy.a(this.jdField_a_of_type_Bhvf);
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramString)))
      {
        if (!URLUtil.isNetworkUrl(paramString)) {
          break label148;
        }
        this.jdField_a_of_type_Bhuy.a(paramString, -1, true);
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
      this.jdField_a_of_type_Bhuy.a();
      break;
      label148:
      this.jdField_a_of_type_Bhuy.a(paramString, true);
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
    return new bhus(this);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new bhus(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhuw
 * JD-Core Version:    0.7.0.1
 */