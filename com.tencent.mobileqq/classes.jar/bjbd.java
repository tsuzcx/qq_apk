import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class bjbd
  implements View.OnClickListener
{
  final WeakReference<QQAppInterface> a;
  final WeakReference<azxr> b;
  
  public bjbd(QQAppInterface paramQQAppInterface, azxr paramazxr)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramazxr);
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    azxr localazxr = (azxr)this.b.get();
    if ((localQQAppInterface == null) || (localazxr == null) || (localazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (((bggj)localQQAppInterface.getManager(346)).b(localazxr.jdField_a_of_type_JavaLangString)) {}
    for (Object localObject = bgtj.a().a(localazxr.jdField_a_of_type_JavaLangString, localazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);; localObject = bgtj.a().a(localazxr.jdField_a_of_type_JavaLangString, localazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, azyo.a(localQQAppInterface, localazxr.jdField_a_of_type_JavaLangString, localazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localazxr.jdField_a_of_type_ComTencentMobileqqDataCard), "3", "aio"))
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      paramView.getContext().startActivity(localIntent);
      if (bftp.a().a(localazxr.jdField_a_of_type_JavaLangString, localazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        localObject = paramView.findViewById(2131376418);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        bftp.a().a(localazxr.jdField_a_of_type_JavaLangString, localazxr.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
      }
      bftp.a("grp_data", "clk_medal");
      new bdlq(localQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("title_clk").a(new String[] { localazxr.jdField_a_of_type_JavaLangString }).a();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjbd
 * JD-Core Version:    0.7.0.1
 */