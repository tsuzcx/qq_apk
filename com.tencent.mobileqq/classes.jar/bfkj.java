import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;

public class bfkj
  implements URLDrawable.URLDrawableListener
{
  public bfkj(TroopCreateLogicActivity paramTroopCreateLogicActivity, URLDrawable paramURLDrawable, bfkl parambfkl) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_Bfkl.a(null);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.jdField_a_of_type_Bfkl.a(null);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = bjtv.a(this.jdField_a_of_type_ComTencentImageURLDrawable, 100, 100);
    this.jdField_a_of_type_Bfkl.a(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfkj
 * JD-Core Version:    0.7.0.1
 */