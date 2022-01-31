import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class aqyp
{
  protected int a;
  protected Context a;
  protected Bitmap a;
  protected aqyj a;
  
  public aqyp(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public aqyp(Context paramContext, int paramInt, aqyj paramaqyj)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Aqyj = paramaqyj;
  }
  
  public Bitmap a()
  {
    if (this.jdField_a_of_type_Aqyj != null) {
      a(this.jdField_a_of_type_Aqyj.a());
    }
    return null;
  }
  
  public void a(aqyl paramaqyl)
  {
    paramaqyl.c = 1.0F;
  }
  
  public Drawable[] a(QQAppInterface paramQQAppInterface)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqyp
 * JD-Core Version:    0.7.0.1
 */