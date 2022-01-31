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

public class azkh
  implements View.OnClickListener
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new azki(this);
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  azke jdField_a_of_type_Azke;
  azlx jdField_a_of_type_Azlx = new azkj(this);
  azlz jdField_a_of_type_Azlz;
  ArrayList<azlt> jdField_a_of_type_JavaUtilArrayList;
  View jdField_b_of_type_AndroidViewView;
  ArrayList<azkf> jdField_b_of_type_JavaUtilArrayList;
  
  public azkh(azke paramazke, View paramView)
  {
    this.jdField_a_of_type_Azke = paramazke;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369284));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131364839);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    azkf localazkf = new azkf(paramView.findViewById(2131369285), 0);
    this.jdField_b_of_type_JavaUtilArrayList.add(localazkf);
    localazkf = new azkf(paramView.findViewById(2131369286), 1);
    this.jdField_b_of_type_JavaUtilArrayList.add(localazkf);
    localazkf = new azkf(paramView.findViewById(2131369287), 2);
    this.jdField_b_of_type_JavaUtilArrayList.add(localazkf);
    paramView = new azkf(paramView.findViewById(2131369288), 3);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
    paramView = new azlt((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131369289), paramazke.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_Azlx);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
    paramazke = new azlt((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131369290), paramazke.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_Azlx);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramazke);
  }
  
  public void a(azlz paramazlz)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((azlt)((Iterator)localObject).next()).a();
    }
    this.jdField_a_of_type_Azlz = paramazlz;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramazlz.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramazlz.jdField_b_of_type_JavaLangString);
    if (paramazlz.jdField_b_of_type_JavaLangString.equals(azke.jdField_a_of_type_JavaLangString))
    {
      localObject = (TroopManager)this.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
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
      while (i < paramazlz.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((azkf)this.jdField_b_of_type_JavaUtilArrayList.get(i)).a(this.jdField_a_of_type_Azke.jdField_a_of_type_AndroidContentContext, (azlz)paramazlz.jdField_a_of_type_JavaUtilArrayList.get(i), this);
        i += 1;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    azkf localazkf = (azkf)paramView.getTag();
    if ((localazkf == null) || (localazkf.jdField_a_of_type_Azlz == null)) {
      return;
    }
    azlz localazlz = localazkf.jdField_a_of_type_Azlz;
    if (localazlz.jdField_a_of_type_JavaLangString == null) {}
    for (paramView = "";; paramView = localazlz.jdField_a_of_type_JavaLangString)
    {
      axqw.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, paramView, "", "", "");
      if (!localazlz.jdField_a_of_type_Boolean) {
        break;
      }
      int i = localazkf.jdField_a_of_type_Int / 2;
      ((azlt)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(localazkf, localazlz);
      return;
    }
    if (localazlz.jdField_b_of_type_Int == 1)
    {
      if ((localazlz.jdField_a_of_type_JavaLangString.equals("20001")) || (localazlz.jdField_a_of_type_JavaLangString.equals("20002")))
      {
        paramView = (TroopManager)this.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (paramView.a.jdField_a_of_type_Boolean)
        {
          paramView.g();
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        this.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localazlz.jdField_a_of_type_JavaLangString);
        if (localazlz.jdField_a_of_type_JavaLangString.equals("20001")) {}
        for (paramView = "Clk_type_2";; paramView = "Clk_type_3")
        {
          axqw.b(this.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_mobile", "", "chose_type", paramView, 0, 0, "", "", "", "");
          return;
        }
      }
      if (localazlz.jdField_a_of_type_JavaLangString.equals("20003"))
      {
        QLog.e("vip_pretty.createNewTroop.CateListAdapter", 1, "click the create pretty troop icon");
        bbiq.a(amyt.c().a("category"), this.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), (Activity)this.jdField_a_of_type_Azke.jdField_a_of_type_AndroidContentContext);
        axqw.b(this.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A582", 0, 0, "", "", "", "");
        return;
      }
      this.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localazlz.jdField_a_of_type_JavaLangString, null);
      return;
    }
    this.jdField_a_of_type_Azke.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localazlz.d, localazlz.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azkh
 * JD-Core Version:    0.7.0.1
 */