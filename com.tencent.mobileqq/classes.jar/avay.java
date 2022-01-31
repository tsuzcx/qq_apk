import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

public class avay
{
  private final int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new avaz(this);
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private boolean jdField_a_of_type_Boolean;
  private final int b;
  private int c;
  private int d;
  
  public avay(View paramView)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_Int = bawz.a(this.jdField_a_of_type_AndroidViewView.getContext(), 15.0F);
      this.b = ((int)(this.jdField_a_of_type_Int / 1.5D));
      return;
    }
    throw new IllegalArgumentException("Wrapped View shouldn't be null!");
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.c = 0;
    this.d = 0;
    for (;;)
    {
      int j = (int)(this.b * (Math.random() * 2.0D - 1.0D));
      int i = (int)Math.sqrt(this.b * this.b - j * j);
      if (Math.random() > 0.5D) {}
      while ((this.c + j) * (this.c + j) + (this.d + i) * (this.d + i) <= this.jdField_a_of_type_Int * this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(this.c, this.c + j, this.d, this.d + i);
        this.c = (j + this.c);
        this.d = (i + this.d);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(this.b * (int)(50.0D + Math.random() * 30.0D));
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
        return;
        i = -i;
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewView.getAnimation() == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    if (a()) {
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avay
 * JD-Core Version:    0.7.0.1
 */