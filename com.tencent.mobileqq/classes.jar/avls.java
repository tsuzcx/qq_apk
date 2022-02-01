import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class avls
{
  protected int a;
  protected Context a;
  protected Bitmap a;
  protected avlm a;
  
  public avls(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public avls(Context paramContext, int paramInt, avlm paramavlm)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Avlm = paramavlm;
  }
  
  public Bitmap a()
  {
    if (this.jdField_a_of_type_Avlm != null) {
      a(this.jdField_a_of_type_Avlm.a());
    }
    return null;
  }
  
  public void a(avlo paramavlo)
  {
    paramavlo.c = 1.0F;
  }
  
  public Drawable[] a(QQAppInterface paramQQAppInterface)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avls
 * JD-Core Version:    0.7.0.1
 */