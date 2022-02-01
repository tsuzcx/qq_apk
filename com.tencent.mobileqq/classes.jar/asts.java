import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/extendfriend/wiget/ColdPalaceTipDialog$init$1$3"}, k=3, mv={1, 1, 16})
final class asts
  implements View.OnClickListener
{
  asts(astp paramastp, Context paramContext, String paramString, QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      if (this.jdField_a_of_type_Astp.isShowing()) {
        this.jdField_a_of_type_Astp.dismiss();
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, (CharSequence)this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692125), 0).a();
    }
    for (;;)
    {
      bdla.b(null, "dc00898", "", "", "0X800B2CF", "0X800B2CF", 1, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        BusinessHandler localBusinessHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
        if (localBusinessHandler == null) {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.extendfriend.ExtendFriendHandler");
        }
        ((aslm)localBusinessHandler).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_Astp.isShowing()) {
          this.jdField_a_of_type_Astp.dismiss();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asts
 * JD-Core Version:    0.7.0.1
 */