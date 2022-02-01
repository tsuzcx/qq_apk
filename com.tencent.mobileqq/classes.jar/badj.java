import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.diy.DiyTextView;
import com.tencent.mobileqq.profile.view.SingleTouchLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/component/background/VasProfileSimpleBackgroundComponent;", "Lcom/tencent/mobileqq/profilecard/vas/component/background/VasProfileBackgroundComponent;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profile/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profile/ProfileCardInfo;)V", "mDiyTextLayout", "Lcom/tencent/mobileqq/profile/view/SingleTouchLayout;", "mDiyTextMask", "Landroid/view/View;", "mDiyTextView", "Lcom/tencent/mobileqq/profile/diy/DiyTextView;", "getDiyTextCenterPoint", "Landroid/graphics/PointF;", "onCreate", "", "activity", "Lcom/tencent/mobileqq/app/BaseActivity;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onVasDataUpdate", "", "data", "Lcom/tencent/mobileqq/profilecard/vas/VasProfileData;", "updateDiyText", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class badj
  extends badf
{
  private View jdField_a_of_type_AndroidViewView;
  private DiyTextView jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView;
  private SingleTouchLayout jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout;
  
  public badj(@Nullable azxt paramazxt, @Nullable azrb paramazrb)
  {
    super(paramazxt, paramazrb);
  }
  
  private final void a(badb parambadb)
  {
    int j = -77;
    bada localbada = parambadb.a();
    Object localObject = (CharSequence)localbada.a();
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if ((i != 0) || (parambadb.a() != azri.g)) {
        break label379;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView == null)
      {
        parambadb = new DiyTextView(a().getContext());
        parambadb.setOnMeasuredListener((afkl)new badk(this));
        this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView = parambadb;
      }
      parambadb = this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView;
      if (parambadb == null) {
        Intrinsics.throwNpe();
      }
      parambadb.setMaxSize(a().getWidth() * 2 / 3);
      parambadb.setVisibility(0);
      parambadb.setHiBoom(localbada.a(), 1, avkh.b);
      parambadb.setText((CharSequence)localbada.a());
      parambadb = this.jdField_a_of_type_AndroidViewView;
      if (parambadb == null) {
        Intrinsics.throwNpe();
      }
      i = (int)(localbada.e() * 'ÿ');
      if (i >= -77) {
        break label359;
      }
      i = j;
    }
    label418:
    for (;;)
    {
      label189:
      if (i > 0) {}
      for (j = -16777216;; j = -1)
      {
        parambadb.setBackgroundColor(j);
        parambadb = parambadb.getBackground();
        Intrinsics.checkExpressionValueIsNotNull(parambadb, "background");
        parambadb.setAlpha(Math.abs(i));
        parambadb = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout;
        if (parambadb == null) {
          Intrinsics.throwNpe();
        }
        parambadb.setVisibility(0);
        parambadb.a((View)this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView);
        parambadb.setImageDegree(localbada.c());
        parambadb.setImageScale(localbada.d());
        localObject = a().getContext();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "containerView.context");
        localObject = ((Context)localObject).getResources();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "containerView.context.resources");
        localObject = ((Resources)localObject).getDisplayMetrics();
        float f1 = localbada.a();
        float f2 = ((DisplayMetrics)localObject).widthPixels;
        float f3 = localbada.b();
        parambadb.setCenterPoint(f1 * f2, ((DisplayMetrics)localObject).heightPixels * f3);
        parambadb.a();
        parambadb.invalidate();
        return;
        i = 0;
        break;
        label359:
        if (i <= 77) {
          break label418;
        }
        i = 77;
        break label189;
      }
      label379:
      parambadb = this.jdField_a_of_type_AndroidViewView;
      if (parambadb != null) {
        parambadb.setVisibility(8);
      }
      parambadb = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout;
      if (parambadb != null) {
        parambadb.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView = ((DiyTextView)null);
      return;
    }
  }
  
  @NotNull
  public final PointF a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout;
    if (localObject != null)
    {
      localObject = ((SingleTouchLayout)localObject).a();
      if (localObject != null) {
        return localObject;
      }
    }
    return new PointF();
  }
  
  public void a(@NotNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseActivity, "activity");
    super.a(paramBaseActivity, paramBundle);
    paramBundle = new View((Context)paramBaseActivity);
    paramBundle.setBackgroundColor(-16777216);
    paramBundle.setVisibility(8);
    paramBundle.setContentDescription((CharSequence)"qqvip_diy_text_mask");
    a().addView(paramBundle);
    this.jdField_a_of_type_AndroidViewView = paramBundle;
    paramBaseActivity = new SingleTouchLayout((Context)paramBaseActivity);
    paramBaseActivity.setVisibility(8);
    paramBaseActivity.setEditable(false);
    paramBaseActivity.setMovable(false);
    paramBaseActivity.setContentDescription((CharSequence)"qqvip_diy_text");
    a().addView((View)paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout = paramBaseActivity;
  }
  
  public boolean a(@NotNull badb parambadb)
  {
    Intrinsics.checkParameterIsNotNull(parambadb, "data");
    super.a(parambadb);
    a(parambadb);
    return true;
  }
  
  public void f()
  {
    super.f();
    a().removeView(this.jdField_a_of_type_AndroidViewView);
    a().removeView((View)this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     badj
 * JD-Core Version:    0.7.0.1
 */