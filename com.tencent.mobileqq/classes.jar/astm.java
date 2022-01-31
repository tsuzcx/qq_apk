import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class astm
{
  protected int a;
  protected Context a;
  protected Bitmap a;
  protected astg a;
  
  public astm(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public astm(Context paramContext, int paramInt, astg paramastg)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Astg = paramastg;
  }
  
  public Bitmap a()
  {
    if (this.jdField_a_of_type_Astg != null) {
      a(this.jdField_a_of_type_Astg.a());
    }
    return null;
  }
  
  public void a(asti paramasti)
  {
    paramasti.c = 1.0F;
  }
  
  public Drawable[] a(QQAppInterface paramQQAppInterface)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astm
 * JD-Core Version:    0.7.0.1
 */