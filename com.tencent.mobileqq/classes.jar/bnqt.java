import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;

public final class bnqt
  extends Drawable.ConstantState
{
  int jdField_a_of_type_Int = 30;
  bnqv jdField_a_of_type_Bnqv;
  bnrc jdField_a_of_type_Bnrc;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  
  private bnqt(bnqp parambnqp) {}
  
  public int a()
  {
    if (this.jdField_a_of_type_Bnqv == null) {
      return 0;
    }
    return this.jdField_a_of_type_Bnqv.a();
  }
  
  public void a(Rect paramRect)
  {
    this.jdField_a_of_type_Bnqv.a(paramRect);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.equals(paramString))) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_Bnqv == null)
    {
      this.jdField_a_of_type_Bnqv = new bnqv(BaseApplicationImpl.getApplication());
      if (this.jdField_a_of_type_Bnrc == null) {
        this.jdField_a_of_type_Bnrc = new bnqu(this);
      }
      this.jdField_a_of_type_Bnqv.a(this.jdField_a_of_type_Bnrc);
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramString)))
      {
        if (!URLUtil.isNetworkUrl(paramString)) {
          break label148;
        }
        this.jdField_a_of_type_Bnqv.a(paramString, -1, true);
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
      this.jdField_a_of_type_Bnqv.a();
      break;
      label148:
      this.jdField_a_of_type_Bnqv.a(paramString, true);
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
    return new bnqp(this);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new bnqp(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqt
 * JD-Core Version:    0.7.0.1
 */