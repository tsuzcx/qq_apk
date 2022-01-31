import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.qzonevip.gift.particle.ParticleExplodeView;
import java.util.ArrayList;

public class avny
  extends AnimatorListenerAdapter
{
  public avny(ParticleExplodeView paramParticleExplodeView) {}
  
  public void onAnimationEnd(Animator arg1)
  {
    synchronized (this.a.jdField_a_of_type_JavaLangObject)
    {
      this.a.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avny
 * JD-Core Version:    0.7.0.1
 */