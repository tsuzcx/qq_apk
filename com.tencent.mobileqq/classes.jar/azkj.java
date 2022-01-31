import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView;
import java.util.ArrayList;
import java.util.Iterator;

public class azkj
  implements View.OnClickListener
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new azkk(this);
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  azkg jdField_a_of_type_Azkg;
  azlz jdField_a_of_type_Azlz = new azkl(this);
  azmb jdField_a_of_type_Azmb;
  ArrayList<azlv> jdField_a_of_type_JavaUtilArrayList;
  View jdField_b_of_type_AndroidViewView;
  ArrayList<azkh> jdField_b_of_type_JavaUtilArrayList;
  
  public azkj(azkg paramazkg, View paramView)
  {
    this.jdField_a_of_type_Azkg = paramazkg;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369284));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131364838);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    azkh localazkh = new azkh(paramView.findViewById(2131369285), 0);
    this.jdField_b_of_type_JavaUtilArrayList.add(localazkh);
    localazkh = new azkh(paramView.findViewById(2131369286), 1);
    this.jdField_b_of_type_JavaUtilArrayList.add(localazkh);
    localazkh = new azkh(paramView.findViewById(2131369287), 2);
    this.jdField_b_of_type_JavaUtilArrayList.add(localazkh);
    paramView = new azkh(paramView.findViewById(2131369288), 3);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
    paramView = new azlv((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131369289), paramazkg.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_Azlz);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
    paramazkg = new azlv((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131369290), paramazkg.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_Azlz);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramazkg);
  }
  
  public void a(azmb paramazmb)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((azlv)((Iterator)localObject).next()).a();
    }
    this.jdField_a_of_type_Azmb = paramazmb;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramazmb.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramazmb.jdField_b_of_type_JavaLangString);
    if (paramazmb.jdField_b_of_type_JavaLangString.equals(azkg.jdField_a_of_type_JavaLangString))
    {
      localObject = (TroopManager)this.jdField_a_of_type_Azkg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      boolean bool = ((TroopManager)localObject).c();
      if (((TroopManager)localObject).a.jdField_a_of_type_Boolean)
      {
        localObject = this.jdField_b_of_type_AndroidViewView;
        if (!bool) {
          break label181;
        }
      }
    }
    label181:
    for (int i = 8;; i = 0)
    {
      ((View)localObject).setVisibility(i);
      i = 0;
      while (i < paramazmb.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((azkh)this.jdField_b_of_type_JavaUtilArrayList.get(i)).a(this.jdField_a_of_type_Azkg.jdField_a_of_type_AndroidContentContext, (azmb)paramazmb.jdField_a_of_type_JavaUtilArrayList.get(i), this);
        i += 1;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    azkh localazkh = (azkh)paramView.getTag();
    if ((localazkh == null) || (localazkh.jdField_a_of_type_Azmb == null)) {
      return;
    }
    azmb localazmb = localazkh.jdField_a_of_type_Azmb;
    if (localazmb.jdField_a_of_type_JavaLangString == null) {}
    for (paramView = "";; paramView = localazmb.jdField_a_of_type_JavaLangString)
    {
      axqy.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, paramView, "", "", "");
      if (!localazmb.jdField_a_of_type_Boolean) {
        break;
      }
      int i = localazkh.jdField_a_of_type_Int / 2;
      ((azlv)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(localazkh, localazmb);
      return;
    }
    if (localazmb.jdField_b_of_type_Int == 1)
    {
      if ((localazmb.jdField_a_of_type_JavaLangString.equals("20001")) || (localazmb.jdField_a_of_type_JavaLangString.equals("20002")))
      {
        paramView = (TroopManager)this.jdField_a_of_type_Azkg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (paramView.a.jdField_a_of_type_Boolean)
        {
          paramView.g();
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        this.jdField_a_of_type_Azkg.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localazmb.jdField_a_of_type_JavaLangString);
        if (localazmb.jdField_a_of_type_JavaLangString.equals("20001")) {}
        for (paramView = "Clk_type_2";; paramView = "Clk_type_3")
        {
          axqy.b(this.jdField_a_of_type_Azkg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_mobile", "", "chose_type", paramView, 0, 0, "", "", "", "");
          return;
        }
      }
      if (localazmb.jdField_a_of_type_JavaLangString.equals("20003"))
      {
        QLog.e("vip_pretty.createNewTroop.CateListAdapter", 1, "click the create pretty troop icon");
        bbje.a(amza.c().a("category"), this.jdField_a_of_type_Azkg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), (Activity)this.jdField_a_of_type_Azkg.jdField_a_of_type_AndroidContentContext);
        axqy.b(this.jdField_a_of_type_Azkg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A582", 0, 0, "", "", "", "");
        return;
      }
      this.jdField_a_of_type_Azkg.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localazmb.jdField_a_of_type_JavaLangString, null);
      return;
    }
    this.jdField_a_of_type_Azkg.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localazmb.d, localazmb.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azkj
 * JD-Core Version:    0.7.0.1
 */