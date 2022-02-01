import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.Observable;
import java.util.Observer;

public class bddy
  extends bddu
  implements Observer
{
  private Context jdField_a_of_type_AndroidContentContext;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bddp jdField_a_of_type_Bddp;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  
  public bddy(DiniFlyAnimationView paramDiniFlyAnimationView, RelativeLayout paramRelativeLayout, Context paramContext, bddn parambddn, bddp parambddp)
  {
    super(parambddn);
    if (parambddn != null) {
      parambddn.addObserver(this);
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_Bddp = parambddp;
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = paramDiniFlyAnimationView;
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new bddz(this));
      if ((this.jdField_a_of_type_Bddp != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bddp.m))) {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimationFromUrl(this.jdField_a_of_type_Bddp.m);
      }
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_Bddp == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Bddp.m))) {
      return;
    }
    int i = ScreenUtil.getInstantScreenHeight(this.jdField_a_of_type_AndroidContentContext);
    Object localObject = new int[2];
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLocationOnScreen((int[])localObject);
    int j = localObject[1];
    int k = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).bottomMargin = (i - j - k - ViewUtils.dpToPx(30.0F));
    if (((FrameLayout.LayoutParams)localObject).bottomMargin + ViewUtils.dpToPx(170.0F) > i) {
      ((FrameLayout.LayoutParams)localObject).bottomMargin = (i - ViewUtils.dpToPx(170.0F) + ViewUtils.dpToPx(30.0F));
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimationFromUrl(this.jdField_a_of_type_Bddp.m);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(false);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.removeAllAnimatorListener();
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()) {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.endAnimation();
      }
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = null;
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(paramInt);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!(paramObject instanceof Integer)) {}
    while (((Integer)paramObject).intValue() != 4) {
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddy
 * JD-Core Version:    0.7.0.1
 */