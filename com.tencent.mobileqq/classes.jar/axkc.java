import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.qzonevip.gift.particle.ParticleExplodeView;
import java.util.ArrayList;

public class axkc
  extends AnimatorListenerAdapter
{
  public axkc(ParticleExplodeView paramParticleExplodeView) {}
  
  public void onAnimationEnd(Animator arg1)
  {
    synchronized (this.a.jdField_a_of_type_JavaLangObject)
    {
      this.a.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axkc
 * JD-Core Version:    0.7.0.1
 */