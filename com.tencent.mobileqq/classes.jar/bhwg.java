import android.os.Handler;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.ApngQueuePlayer.RepeatListener.1;

public class bhwg
  implements ApngDrawable.OnPlayRepeatListener
{
  private int a;
  
  bhwg(bhwc parambhwc) {}
  
  public void a(ApngImage paramApngImage)
  {
    this.jdField_a_of_type_Int = paramApngImage.apngLoop;
    paramApngImage.setOnPlayRepeatListener(this);
  }
  
  public void onPlayRepeat(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int) {
      ThreadManagerV2.getUIHandlerV2().post(new ApngQueuePlayer.RepeatListener.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhwg
 * JD-Core Version:    0.7.0.1
 */