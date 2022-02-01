import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class bdwg
  implements View.OnClickListener
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bdwh(this);
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bdwd jdField_a_of_type_Bdwd;
  bdxw jdField_a_of_type_Bdxw = new bdwi(this);
  bdxy jdField_a_of_type_Bdxy;
  ArrayList<bdxs> jdField_a_of_type_JavaUtilArrayList;
  View jdField_b_of_type_AndroidViewView;
  ArrayList<bdwe> jdField_b_of_type_JavaUtilArrayList;
  
  public bdwg(bdwd parambdwd, View paramView)
  {
    this.jdField_a_of_type_Bdwd = parambdwd;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370027));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365230);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    bdwe localbdwe = new bdwe(paramView.findViewById(2131370028), 0);
    this.jdField_b_of_type_JavaUtilArrayList.add(localbdwe);
    localbdwe = new bdwe(paramView.findViewById(2131370029), 1);
    this.jdField_b_of_type_JavaUtilArrayList.add(localbdwe);
    localbdwe = new bdwe(paramView.findViewById(2131370030), 2);
    this.jdField_b_of_type_JavaUtilArrayList.add(localbdwe);
    paramView = new bdwe(paramView.findViewById(2131370031), 3);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
    paramView = new bdxs((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131370032), parambdwd.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_Bdxw);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
    parambdwd = new bdxs((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131370033), parambdwd.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_Bdxw);
    this.jdField_a_of_type_JavaUtilArrayList.add(parambdwd);
  }
  
  public void a(bdxy parambdxy)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bdxs)((Iterator)localObject).next()).a();
    }
    this.jdField_a_of_type_Bdxy = parambdxy;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambdxy.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(parambdxy.jdField_b_of_type_JavaLangString);
    if (parambdxy.jdField_b_of_type_JavaLangString.equals(bdwd.jdField_a_of_type_JavaLangString))
    {
      localObject = (TroopManager)this.jdField_a_of_type_Bdwd.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
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
      while (i < parambdxy.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((bdwe)this.jdField_b_of_type_JavaUtilArrayList.get(i)).a(this.jdField_a_of_type_Bdwd.jdField_a_of_type_AndroidContentContext, (bdxy)parambdxy.jdField_a_of_type_JavaUtilArrayList.get(i), this);
        i += 1;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    bdwe localbdwe = (bdwe)paramView.getTag();
    if ((localbdwe == null) || (localbdwe.jdField_a_of_type_Bdxy == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdxy localbdxy = localbdwe.jdField_a_of_type_Bdxy;
      if (localbdxy.jdField_a_of_type_JavaLangString == null) {}
      for (Object localObject = "";; localObject = localbdxy.jdField_a_of_type_JavaLangString)
      {
        bcef.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, (String)localObject, "", "", "");
        if (!localbdxy.jdField_a_of_type_Boolean) {
          break label118;
        }
        int i = localbdwe.jdField_a_of_type_Int / 2;
        ((bdxs)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(localbdwe, localbdxy);
        break;
      }
      label118:
      if (localbdxy.jdField_b_of_type_Int == 1)
      {
        if ((localbdxy.jdField_a_of_type_JavaLangString.equals("20001")) || (localbdxy.jdField_a_of_type_JavaLangString.equals("20002")))
        {
          localObject = (TroopManager)this.jdField_a_of_type_Bdwd.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          if (((TroopManager)localObject).a.jdField_a_of_type_Boolean)
          {
            ((TroopManager)localObject).g();
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          }
          this.jdField_a_of_type_Bdwd.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localbdxy.jdField_a_of_type_JavaLangString);
          if (localbdxy.jdField_a_of_type_JavaLangString.equals("20001")) {}
          for (localObject = "Clk_type_2";; localObject = "Clk_type_3")
          {
            bcef.b(this.jdField_a_of_type_Bdwd.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_mobile", "", "chose_type", (String)localObject, 0, 0, "", "", "", "");
            break;
          }
        }
        if (localbdxy.jdField_a_of_type_JavaLangString.equals("20003"))
        {
          QLog.e("vip_pretty.createNewTroop.CateListAdapter", 1, "click the create pretty troop icon");
          bfyi.a(aqgn.c().a("category"), this.jdField_a_of_type_Bdwd.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), (Activity)this.jdField_a_of_type_Bdwd.jdField_a_of_type_AndroidContentContext);
          bcef.b(this.jdField_a_of_type_Bdwd.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A582", 0, 0, "", "", "", "");
        }
        else
        {
          this.jdField_a_of_type_Bdwd.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localbdxy.jdField_a_of_type_JavaLangString, null);
        }
      }
      else
      {
        this.jdField_a_of_type_Bdwd.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localbdxy.d, localbdxy.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwg
 * JD-Core Version:    0.7.0.1
 */