import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class avsx
{
  protected int a;
  protected Context a;
  protected Bitmap a;
  protected avsr a;
  
  public avsx(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public avsx(Context paramContext, int paramInt, avsr paramavsr)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Avsr = paramavsr;
  }
  
  public Bitmap a()
  {
    if (this.jdField_a_of_type_Avsr != null) {
      a(this.jdField_a_of_type_Avsr.a());
    }
    return null;
  }
  
  public void a(avst paramavst)
  {
    paramavst.c = 1.0F;
  }
  
  public Drawable[] a(QQAppInterface paramQQAppInterface)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avsx
 * JD-Core Version:    0.7.0.1
 */