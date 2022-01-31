import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.nearby.now.StoryPlayController;

public class atgs
  implements URLDrawable.URLDrawableListener
{
  public atgs(StoryPlayController paramStoryPlayController, atky paramatky) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_Atky != null) {
      this.jdField_a_of_type_Atky.a(paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight(), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atgs
 * JD-Core Version:    0.7.0.1
 */