import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class aufy
{
  protected int a;
  protected Context a;
  protected Bitmap a;
  protected aufs a;
  
  public aufy(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public aufy(Context paramContext, int paramInt, aufs paramaufs)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Aufs = paramaufs;
  }
  
  public Bitmap a()
  {
    if (this.jdField_a_of_type_Aufs != null) {
      a(this.jdField_a_of_type_Aufs.a());
    }
    return null;
  }
  
  public void a(aufu paramaufu)
  {
    paramaufu.c = 1.0F;
  }
  
  public Drawable[] a(QQAppInterface paramQQAppInterface)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aufy
 * JD-Core Version:    0.7.0.1
 */