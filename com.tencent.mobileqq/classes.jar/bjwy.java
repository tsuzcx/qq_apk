import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;

public final class bjwy
  extends Drawable.ConstantState
{
  int jdField_a_of_type_Int = 30;
  bjxa jdField_a_of_type_Bjxa;
  bjxh jdField_a_of_type_Bjxh;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  
  private bjwy(bjwu parambjwu) {}
  
  public int a()
  {
    if (this.jdField_a_of_type_Bjxa == null) {
      return 0;
    }
    return this.jdField_a_of_type_Bjxa.a();
  }
  
  public void a(Rect paramRect)
  {
    this.jdField_a_of_type_Bjxa.a(paramRect);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.equals(paramString))) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_Bjxa == null)
    {
      this.jdField_a_of_type_Bjxa = new bjxa(BaseApplicationImpl.getApplication());
      if (this.jdField_a_of_type_Bjxh == null) {
        this.jdField_a_of_type_Bjxh = new bjwz(this);
      }
      this.jdField_a_of_type_Bjxa.a(this.jdField_a_of_type_Bjxh);
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramString)))
      {
        if (!URLUtil.isNetworkUrl(paramString)) {
          break label148;
        }
        this.jdField_a_of_type_Bjxa.a(paramString, -1, true);
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
      this.jdField_a_of_type_Bjxa.a();
      break;
      label148:
      this.jdField_a_of_type_Bjxa.a(paramString, true);
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
    return new bjwu(this);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new bjwu(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjwy
 * JD-Core Version:    0.7.0.1
 */