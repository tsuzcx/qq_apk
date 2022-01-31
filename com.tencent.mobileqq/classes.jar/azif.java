import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;

public class azif
  implements URLDrawable.URLDrawableListener
{
  public azif(TroopCreateLogicActivity paramTroopCreateLogicActivity, URLDrawable paramURLDrawable, azih paramazih) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_Azih.a(null);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.jdField_a_of_type_Azih.a(null);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = bdig.a(this.jdField_a_of_type_ComTencentImageURLDrawable, 100, 100);
    this.jdField_a_of_type_Azih.a(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azif
 * JD-Core Version:    0.7.0.1
 */