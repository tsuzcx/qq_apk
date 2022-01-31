import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenStatusReceiver;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;

public abstract class betp
  implements View.OnClickListener
{
  public Context a;
  public FrameLayout a;
  public ImageView a;
  public RelativeLayout a;
  public betn a;
  public FloatingScreenContainer a;
  public FloatingScreenStatusReceiver a;
  
  betp(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
  }
  
  public int a(FloatingScreenParams paramFloatingScreenParams, View paramView)
  {
    FloatingScreenParams localFloatingScreenParams = paramFloatingScreenParams;
    if (paramFloatingScreenParams == null)
    {
      if (this.jdField_a_of_type_AndroidContentContext != null) {
        localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().build();
      }
    }
    else
    {
      a(paramView);
      a(localFloatingScreenParams.getInnerRoundCorner(), localFloatingScreenParams.getOuterRoundCorner());
      b(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.a(this.jdField_a_of_type_AndroidWidgetFrameLayout, localFloatingScreenParams);
      c();
      d();
      return 0;
    }
    return 2;
  }
  
  public IVideoOuterStatusListener a(IVideoInnerStatusListener paramIVideoInnerStatusListener)
  {
    return null;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.setOutlineProvider(new besw(paramInt2));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.setClipToOutline(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.setElevation(15.0F);
        aqcn.a(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845716));
      }
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setOutlineProvider(new besw(paramInt1));
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setClipToOutline(true);
      }
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer = new FloatingScreenContainer(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.setBackgroundColor(paramContext.getResources().getColor(2131167138));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setId(2131373614);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(paramContext.getResources().getColor(2131167138));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)View.inflate(paramContext, 2131561378, null));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373601));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alpo.a(2131705007));
    a(new View[] { this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidWidgetImageView });
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    b(paramView);
    paramView.setId(2131373616);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView, new FrameLayout.LayoutParams(-1, -1));
    b(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void a(betm parambetm) {}
  
  public void a(betn parambetn)
  {
    this.jdField_a_of_type_Betn = parambetn;
  }
  
  public void a(IFullScreenEnterListener paramIFullScreenEnterListener) {}
  
  public void a(boolean paramBoolean, View... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return;
    }
    int j = paramVarArgs.length;
    int i = 0;
    label11:
    View localView;
    if (i < j)
    {
      localView = paramVarArgs[i];
      if (localView != null)
      {
        if (!paramBoolean) {
          break label44;
        }
        localView.setVisibility(0);
      }
    }
    for (;;)
    {
      i += 1;
      break label11;
      break;
      label44:
      localView.setVisibility(4);
    }
  }
  
  public void a(View... paramVarArgs)
  {
    if (paramVarArgs == null) {}
    for (;;)
    {
      return;
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        View localView = paramVarArgs[i];
        if (localView != null) {
          localView.setOnClickListener(this);
        }
        i += 1;
      }
    }
  }
  
  public void b(int paramInt)
  {
    if ((paramInt != 1) || (this.jdField_a_of_type_Betn == null) || (!this.jdField_a_of_type_Betn.a()))
    {
      this.jdField_a_of_type_Betn = null;
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.d()))
      {
        b(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        a(false, new View[] { this.jdField_a_of_type_AndroidWidgetImageView });
        this.jdField_a_of_type_Betn = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenStatusReceiver != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenStatusReceiver.a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenStatusReceiver = null;
      }
    }
  }
  
  public void b(View paramView)
  {
    if (paramView != null) {}
    try
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(paramView);
      }
      return;
    }
    catch (ClassCastException paramView)
    {
      paramView.printStackTrace();
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  public void b(boolean paramBoolean, View... paramVarArgs)
  {
    if (paramVarArgs == null) {}
    for (;;)
    {
      return;
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        View localView = paramVarArgs[i];
        if (localView != null) {
          localView.setEnabled(paramBoolean);
        }
        i += 1;
      }
    }
  }
  
  public void c()
  {
    a(true, new View[] { this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer, this.jdField_a_of_type_AndroidWidgetImageView });
  }
  
  public void d() {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131373601) {
      b(1);
    }
    while ((i != 2131373607) || (this.jdField_a_of_type_Betn == null)) {
      return;
    }
    this.jdField_a_of_type_Betn.a(this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.a(), this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betp
 * JD-Core Version:    0.7.0.1
 */