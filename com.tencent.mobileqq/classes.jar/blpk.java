import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicBoolean;

class blpk
  implements Animation.AnimationListener
{
  blpk(blpb paramblpb, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    blpb.a(this.jdField_a_of_type_Blpb, false);
    blpb.b(this.jdField_a_of_type_Blpb).setVisibility(8);
    blpb.a(this.jdField_a_of_type_Blpb).setVisibility(8);
    if ((this.jdField_a_of_type_Boolean) && (!blpb.a(this.jdField_a_of_type_Blpb).get())) {
      blpb.a(this.jdField_a_of_type_Blpb, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    blpb.a(this.jdField_a_of_type_Blpb, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpk
 * JD-Core Version:    0.7.0.1
 */