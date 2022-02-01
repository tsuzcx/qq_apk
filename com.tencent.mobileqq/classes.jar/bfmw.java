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

public class bfmw
  implements View.OnClickListener
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bfmx(this);
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bfmt jdField_a_of_type_Bfmt;
  bfom jdField_a_of_type_Bfom = new bfmy(this);
  bfoo jdField_a_of_type_Bfoo;
  ArrayList<bfoi> jdField_a_of_type_JavaUtilArrayList;
  View jdField_b_of_type_AndroidViewView;
  ArrayList<bfmu> jdField_b_of_type_JavaUtilArrayList;
  
  public bfmw(bfmt parambfmt, View paramView)
  {
    this.jdField_a_of_type_Bfmt = parambfmt;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370030));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365205);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    bfmu localbfmu = new bfmu(paramView.findViewById(2131370031), 0);
    this.jdField_b_of_type_JavaUtilArrayList.add(localbfmu);
    localbfmu = new bfmu(paramView.findViewById(2131370032), 1);
    this.jdField_b_of_type_JavaUtilArrayList.add(localbfmu);
    localbfmu = new bfmu(paramView.findViewById(2131370033), 2);
    this.jdField_b_of_type_JavaUtilArrayList.add(localbfmu);
    paramView = new bfmu(paramView.findViewById(2131370034), 3);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramView);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
    paramView = new bfoi((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131370035), parambfmt.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_Bfom);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
    parambfmt = new bfoi((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131370036), parambfmt.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_Bfom);
    this.jdField_a_of_type_JavaUtilArrayList.add(parambfmt);
  }
  
  public void a(bfoo parambfoo)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bfoi)((Iterator)localObject).next()).a();
    }
    this.jdField_a_of_type_Bfoo = parambfoo;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(parambfoo.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(parambfoo.jdField_b_of_type_JavaLangString);
    if (parambfoo.jdField_b_of_type_JavaLangString.equals(bfmt.jdField_a_of_type_JavaLangString))
    {
      localObject = (TroopManager)this.jdField_a_of_type_Bfmt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
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
      while (i < parambfoo.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((bfmu)this.jdField_b_of_type_JavaUtilArrayList.get(i)).a(this.jdField_a_of_type_Bfmt.jdField_a_of_type_AndroidContentContext, (bfoo)parambfoo.jdField_a_of_type_JavaUtilArrayList.get(i), this);
        i += 1;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    bfmu localbfmu = (bfmu)paramView.getTag();
    if ((localbfmu == null) || (localbfmu.jdField_a_of_type_Bfoo == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bfoo localbfoo = localbfmu.jdField_a_of_type_Bfoo;
      if (localbfoo.jdField_a_of_type_JavaLangString == null) {}
      for (Object localObject = "";; localObject = localbfoo.jdField_a_of_type_JavaLangString)
      {
        bdll.b(null, "dc00899", "grp_create", "", "grp_create_bytype", "clk_grptype", 0, 0, (String)localObject, "", "", "");
        if (!localbfoo.jdField_a_of_type_Boolean) {
          break label118;
        }
        int i = localbfmu.jdField_a_of_type_Int / 2;
        ((bfoi)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(localbfmu, localbfoo);
        break;
      }
      label118:
      if (localbfoo.jdField_b_of_type_Int == 1)
      {
        if ((localbfoo.jdField_a_of_type_JavaLangString.equals("20001")) || (localbfoo.jdField_a_of_type_JavaLangString.equals("20002")))
        {
          localObject = (TroopManager)this.jdField_a_of_type_Bfmt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
          if (((TroopManager)localObject).a.jdField_a_of_type_Boolean)
          {
            ((TroopManager)localObject).g();
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          }
          this.jdField_a_of_type_Bfmt.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localbfoo.jdField_a_of_type_JavaLangString);
          if (localbfoo.jdField_a_of_type_JavaLangString.equals("20001")) {}
          for (localObject = "Clk_type_2";; localObject = "Clk_type_3")
          {
            bdll.b(this.jdField_a_of_type_Bfmt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_mobile", "", "chose_type", (String)localObject, 0, 0, "", "", "", "");
            break;
          }
        }
        if (localbfoo.jdField_a_of_type_JavaLangString.equals("20003"))
        {
          QLog.e("vip_pretty.createNewTroop.CateListAdapter", 1, "click the create pretty troop icon");
          bhrn.a(armq.c().a("category"), this.jdField_a_of_type_Bfmt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), (Activity)this.jdField_a_of_type_Bfmt.jdField_a_of_type_AndroidContentContext);
          bdll.b(this.jdField_a_of_type_Bfmt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A582", 0, 0, "", "", "", "");
        }
        else
        {
          this.jdField_a_of_type_Bfmt.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localbfoo.jdField_a_of_type_JavaLangString, null);
        }
      }
      else
      {
        this.jdField_a_of_type_Bfmt.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCateView.a(localbfoo.d, localbfoo.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmw
 * JD-Core Version:    0.7.0.1
 */