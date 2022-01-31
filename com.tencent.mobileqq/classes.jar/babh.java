import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.studymode.StudyModeSwitchDialog.btnSwitchOn.2;
import com.tencent.mobileqq.studymode.StudyModeSwitchDialog.ivClose.2;
import com.tencent.mobileqq.studymode.StudyModeSwitchDialog.manager.2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/StudyModeSwitchDialog;", "Landroid/app/Dialog;", "Lcom/tencent/mobileqq/studymode/ModeSwitchManager$OnModeChangeResultCallback;", "activity", "Lcom/tencent/mobileqq/app/BaseActivity;", "(Lcom/tencent/mobileqq/app/BaseActivity;)V", "btnSwitchOn", "Landroid/widget/Button;", "getBtnSwitchOn", "()Landroid/widget/Button;", "btnSwitchOn$delegate", "Lkotlin/Lazy;", "ivClose", "Landroid/widget/ImageView;", "getIvClose", "()Landroid/widget/ImageView;", "ivClose$delegate", "loadingDialog", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "manager", "Lcom/tencent/mobileqq/studymode/ModeSwitchManager;", "getManager", "()Lcom/tencent/mobileqq/studymode/ModeSwitchManager;", "manager$delegate", "onModeChangeComplete", "", "isSuccess", "", "targetType", "", "oldType", "message", "", "onModeChangeStart", "onModeSwitching", "onSelectModeRecover", "onSwitchClick", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class babh
  extends Dialog
  implements baav
{
  private bety jdField_a_of_type_Bety;
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private final Lazy jdField_a_of_type_KotlinLazy;
  private final Lazy b;
  private final Lazy c;
  
  public babh(@NotNull BaseActivity paramBaseActivity)
  {
    super((Context)paramBaseActivity, 2131755172);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new StudyModeSwitchDialog.ivClose.2(this));
    this.b = LazyKt.lazy((Function0)new StudyModeSwitchDialog.btnSwitchOn.2(this));
    this.c = LazyKt.lazy((Function0)new StudyModeSwitchDialog.manager.2(this));
    paramBaseActivity = getWindow();
    if (paramBaseActivity != null)
    {
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        paramBaseActivity.addFlags(67108864);
      }
      ImmersiveUtils.a(paramBaseActivity, true);
    }
    setContentView(2131558866);
    a().a((baav)this);
    a().setOnClickListener((View.OnClickListener)new babi(this));
    a().setOnClickListener((View.OnClickListener)new babj(this));
    setOnDismissListener((DialogInterface.OnDismissListener)new babk(this));
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800ADD4", "0X800ADD4", 0, 0, "", "", "", "");
  }
  
  private final Button a()
  {
    return (Button)this.b.getValue();
  }
  
  private final ImageView a()
  {
    return (ImageView)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  private final baau a()
  {
    return (baau)this.c.getValue();
  }
  
  private final void a()
  {
    if (a().a())
    {
      QQToast.a((Context)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131719907, 0).a();
      return;
    }
    if (baar.a() == 2)
    {
      QQToast.a((Context)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131720355, 0).a();
      dismiss();
      return;
    }
    int i = azmk.c();
    baax localbaax = a().a((Activity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, i, true);
    if ((!localbaax.a()) && (localbaax.a() == localbaax.b()))
    {
      QQToast.a((Context)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131720355, 0).a();
      dismiss();
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "dc00898", "", "", "0X800ADD5", "0X800ADD5", 0, 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    Context localContext;
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      localContext = (Context)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      if (!paramBoolean) {
        break label70;
      }
    }
    label70:
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      QQToast.a(localContext, paramInt1, (CharSequence)paramString, 0).a();
      paramString = this.jdField_a_of_type_Bety;
      if (paramString != null) {
        paramString.dismiss();
      }
      dismiss();
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    baaw.a(this, paramBoolean1, paramBoolean2, paramBoolean3, paramInt);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, @Nullable String paramString)
  {
    baaw.a(this, paramBoolean1, paramBoolean2, paramBoolean3, paramInt, paramString);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    bety localbety = this.jdField_a_of_type_Bety;
    if ((localbety != null) && (localbety.isShowing() == true))
    {
      localbety = this.jdField_a_of_type_Bety;
      if (localbety != null) {
        localbety.dismiss();
      }
    }
    this.jdField_a_of_type_Bety = new bety((Context)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localbety = this.jdField_a_of_type_Bety;
    if (localbety == null) {
      Intrinsics.throwNpe();
    }
    Window localWindow = localbety.getWindow();
    if (localWindow != null) {
      localWindow.setDimAmount(0.0F);
    }
    localbety.show();
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    bety localbety = this.jdField_a_of_type_Bety;
    if (localbety != null) {
      localbety.dismiss();
    }
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    QQToast.a((Context)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131719907, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babh
 * JD-Core Version:    0.7.0.1
 */