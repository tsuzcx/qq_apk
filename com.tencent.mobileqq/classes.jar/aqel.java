import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class aqel
{
  protected int a;
  protected Context a;
  protected Bitmap a;
  protected aqef a;
  
  public aqel(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public aqel(Context paramContext, int paramInt, aqef paramaqef)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Aqef = paramaqef;
  }
  
  public Bitmap a()
  {
    if (this.jdField_a_of_type_Aqef != null) {
      a(this.jdField_a_of_type_Aqef.a());
    }
    return null;
  }
  
  public void a(aqeh paramaqeh)
  {
    paramaqeh.c = 1.0F;
  }
  
  public Drawable[] a(QQAppInterface paramQQAppInterface)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqel
 * JD-Core Version:    0.7.0.1
 */