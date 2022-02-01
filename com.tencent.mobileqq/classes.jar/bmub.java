import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.apollo.view.ApolloLottieAnim;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

public class bmub
  extends bmuf
{
  protected ApolloLottieAnim a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  
  public bmub(String paramString, View paramView)
  {
    super(paramString, paramView);
  }
  
  protected ApolloLottieAnim a(Context paramContext)
  {
    paramContext = new bhij(null, paramContext);
    paramContext.a((int)(MemoryManager.a() / 2L));
    return paramContext;
  }
  
  protected void a(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    super.a(paramString1, paramString2);
    if (!(this.jdField_a_of_type_AndroidViewView instanceof ImageView)) {}
    do
    {
      return;
      if ("content".equals(paramString1))
      {
        this.jdField_a_of_type_JavaLangString = paramString2;
        return;
      }
      if ("loop".equals(paramString1))
      {
        if (Integer.parseInt(paramString2) == 1) {}
        for (;;)
        {
          this.jdField_a_of_type_Boolean = bool1;
          return;
          bool1 = false;
        }
      }
    } while (!"auto_play".equals(paramString1));
    if (Integer.parseInt(paramString2) == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.b = bool1;
      return;
    }
  }
  
  protected void b()
  {
    super.b();
    if (!(this.jdField_a_of_type_AndroidViewView instanceof DiniFlyAnimationView)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim = a(this.jdField_a_of_type_AndroidViewView.getContext());
    }
    ((DiniFlyAnimationView)this.jdField_a_of_type_AndroidViewView).loop(this.jdField_a_of_type_Boolean);
    ((DiniFlyAnimationView)this.jdField_a_of_type_AndroidViewView).setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (QLog.isColorLevel()) {
      QLog.i("JsonInflateViewModel", 0, " lottie url = " + this.jdField_a_of_type_JavaLangString);
    }
    ApolloLottieAnim localApolloLottieAnim1 = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
    DiniFlyAnimationView localDiniFlyAnimationView = (DiniFlyAnimationView)this.jdField_a_of_type_AndroidViewView;
    String str = this.jdField_a_of_type_JavaLangString;
    ApolloLottieAnim localApolloLottieAnim2 = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
    localApolloLottieAnim1.a(localDiniFlyAnimationView, str, ApolloLottieAnim.a(this.jdField_a_of_type_JavaLangString), this.b);
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.c();
    }
  }
  
  public void e()
  {
    super.e();
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof DiniFlyAnimationView))) {
      ((DiniFlyAnimationView)this.jdField_a_of_type_AndroidViewView).pauseAnimation();
    }
  }
  
  public void f()
  {
    super.f();
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof DiniFlyAnimationView))) {
      ((DiniFlyAnimationView)this.jdField_a_of_type_AndroidViewView).playAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmub
 * JD-Core Version:    0.7.0.1
 */