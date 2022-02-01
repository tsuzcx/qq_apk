import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class birw
  implements View.OnClickListener
{
  final WeakReference<QQAppInterface> a;
  final WeakReference<azrb> b;
  
  public birw(QQAppInterface paramQQAppInterface, azrb paramazrb)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramazrb);
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    azrb localazrb = (azrb)this.b.get();
    if ((localQQAppInterface == null) || (localazrb == null) || (localazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (((bfwu)localQQAppInterface.getManager(QQManagerFactory.TROOP_HONOR_MANAGER)).b(localazrb.jdField_a_of_type_JavaLangString)) {}
    for (Object localObject = bgld.a().a(localazrb.jdField_a_of_type_JavaLangString, localazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);; localObject = bgld.a().a(localazrb.jdField_a_of_type_JavaLangString, localazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, azry.a(localQQAppInterface, localazrb.jdField_a_of_type_JavaLangString, localazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localazrb.jdField_a_of_type_ComTencentMobileqqDataCard), "3", "aio"))
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      paramView.getContext().startActivity(localIntent);
      if (bfkd.a().a(localazrb.jdField_a_of_type_JavaLangString, localazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        localObject = paramView.findViewById(2131376435);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        bfkd.a().a(localazrb.jdField_a_of_type_JavaLangString, localazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
      }
      bfkd.a("grp_data", "clk_medal");
      new bdlf(localQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("title_clk").a(new String[] { localazrb.jdField_a_of_type_JavaLangString }).a();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     birw
 * JD-Core Version:    0.7.0.1
 */