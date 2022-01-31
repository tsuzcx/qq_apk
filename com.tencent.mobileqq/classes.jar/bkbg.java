import android.os.Handler;
import cooperation.qzone.zipanimate.ZipAnimationDrawable.ZipAnimationState.1.1;

public class bkbg
  implements bkbo
{
  bkbg(bkbf parambkbf) {}
  
  public void onZipLoaded(boolean paramBoolean)
  {
    if (!this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_Boolean = paramBoolean;
      this.a.jdField_a_of_type_Bkbb.a.post(new ZipAnimationDrawable.ZipAnimationState.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkbg
 * JD-Core Version:    0.7.0.1
 */