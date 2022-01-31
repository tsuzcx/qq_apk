import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;

public final class bkbf
  extends Drawable.ConstantState
{
  int jdField_a_of_type_Int = 30;
  bkbh jdField_a_of_type_Bkbh;
  bkbo jdField_a_of_type_Bkbo;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  
  private bkbf(bkbb parambkbb) {}
  
  public int a()
  {
    if (this.jdField_a_of_type_Bkbh == null) {
      return 0;
    }
    return this.jdField_a_of_type_Bkbh.a();
  }
  
  public void a(Rect paramRect)
  {
    this.jdField_a_of_type_Bkbh.a(paramRect);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.equals(paramString))) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_Bkbh == null)
    {
      this.jdField_a_of_type_Bkbh = new bkbh(BaseApplicationImpl.getApplication());
      if (this.jdField_a_of_type_Bkbo == null) {
        this.jdField_a_of_type_Bkbo = new bkbg(this);
      }
      this.jdField_a_of_type_Bkbh.a(this.jdField_a_of_type_Bkbo);
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramString)))
      {
        if (!URLUtil.isNetworkUrl(paramString)) {
          break label148;
        }
        this.jdField_a_of_type_Bkbh.a(paramString, -1, true);
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
      this.jdField_a_of_type_Bkbh.a();
      break;
      label148:
      this.jdField_a_of_type_Bkbh.a(paramString, true);
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
    return new bkbb(this);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new bkbb(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkbf
 * JD-Core Version:    0.7.0.1
 */