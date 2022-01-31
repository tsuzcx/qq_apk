import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;

public final class bhvn
  extends Drawable.ConstantState
{
  int jdField_a_of_type_Int = 30;
  bhvp jdField_a_of_type_Bhvp;
  bhvw jdField_a_of_type_Bhvw;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  
  private bhvn(bhvj parambhvj) {}
  
  public int a()
  {
    if (this.jdField_a_of_type_Bhvp == null) {
      return 0;
    }
    return this.jdField_a_of_type_Bhvp.a();
  }
  
  public void a(Rect paramRect)
  {
    this.jdField_a_of_type_Bhvp.a(paramRect);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.equals(paramString))) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_Bhvp == null)
    {
      this.jdField_a_of_type_Bhvp = new bhvp(BaseApplicationImpl.getApplication());
      if (this.jdField_a_of_type_Bhvw == null) {
        this.jdField_a_of_type_Bhvw = new bhvo(this);
      }
      this.jdField_a_of_type_Bhvp.a(this.jdField_a_of_type_Bhvw);
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramString)))
      {
        if (!URLUtil.isNetworkUrl(paramString)) {
          break label148;
        }
        this.jdField_a_of_type_Bhvp.a(paramString, -1, true);
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
      this.jdField_a_of_type_Bhvp.a();
      break;
      label148:
      this.jdField_a_of_type_Bhvp.a(paramString, true);
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
    return new bhvj(this);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new bhvj(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhvn
 * JD-Core Version:    0.7.0.1
 */