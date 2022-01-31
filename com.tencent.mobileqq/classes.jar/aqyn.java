import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class aqyn
{
  protected int a;
  protected Context a;
  protected Bitmap a;
  protected aqyh a;
  
  public aqyn(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public aqyn(Context paramContext, int paramInt, aqyh paramaqyh)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Aqyh = paramaqyh;
  }
  
  public Bitmap a()
  {
    if (this.jdField_a_of_type_Aqyh != null) {
      a(this.jdField_a_of_type_Aqyh.a());
    }
    return null;
  }
  
  public void a(aqyj paramaqyj)
  {
    paramaqyj.c = 1.0F;
  }
  
  public Drawable[] a(QQAppInterface paramQQAppInterface)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqyn
 * JD-Core Version:    0.7.0.1
 */