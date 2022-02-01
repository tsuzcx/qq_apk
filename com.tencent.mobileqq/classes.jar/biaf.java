import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class biaf
  implements View.OnClickListener
{
  final WeakReference<QQAppInterface> a;
  final WeakReference<azfe> b;
  
  public biaf(QQAppInterface paramQQAppInterface, azfe paramazfe)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramazfe);
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    azfe localazfe = (azfe)this.b.get();
    if ((localQQAppInterface == null) || (localazfe == null) || (localazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (((bfgp)localQQAppInterface.getManager(346)).b(localazfe.jdField_a_of_type_JavaLangString)) {}
    for (Object localObject = bfti.a().a(localazfe.jdField_a_of_type_JavaLangString, localazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);; localObject = bfti.a().a(localazfe.jdField_a_of_type_JavaLangString, localazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, azgc.a(localQQAppInterface, localazfe.jdField_a_of_type_JavaLangString, localazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localazfe.jdField_a_of_type_ComTencentMobileqqDataCard), "3", "aio"))
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      paramView.getContext().startActivity(localIntent);
      if (beui.a().a(localazfe.jdField_a_of_type_JavaLangString, localazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        localObject = paramView.findViewById(2131376278);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        beui.a().a(localazfe.jdField_a_of_type_JavaLangString, localazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
      }
      beui.a("grp_data", "clk_medal");
      new bcsy(localQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("title_clk").a(new String[] { localazfe.jdField_a_of_type_JavaLangString }).a();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biaf
 * JD-Core Version:    0.7.0.1
 */