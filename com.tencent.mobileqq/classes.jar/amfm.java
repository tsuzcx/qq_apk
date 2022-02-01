import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amfm
  implements View.OnClickListener
{
  amfm(amfk paramamfk) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
    Object localObject = (View)paramView.getParent();
    if ((localObject instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)localObject).d();
    }
    localObject = paramView.getTag();
    if (!(localObject instanceof TroopInfo))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    TroopInfo localTroopInfo = (TroopInfo)localObject;
    boolean bool = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(localTroopInfo.troopuin);
    localObject = (anie)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
    int i;
    label111:
    bcsy localbcsy;
    label133:
    label205:
    String str;
    if (bool)
    {
      i = 1;
      if (!((anie)localObject).a(localTroopInfo.troopcode, i)) {
        break label261;
      }
      if (!bool) {
        break label263;
      }
      localObject = "Clk_uncommgrp";
      bcst.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_contactlist", (String)localObject, 0, 0, localTroopInfo.troopuin, "", "", "");
      localbcsy = new bcsy(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_set").c("Grp_contactlist");
      if (!bool) {
        break label270;
      }
      localObject = "Clk_unstick";
      localbcsy = localbcsy.d((String)localObject);
      str = localTroopInfo.troopuin;
      if (!localTroopInfo.hasSetTroopHead()) {
        break label277;
      }
    }
    label261:
    label263:
    label270:
    label277:
    for (localObject = "1";; localObject = "0")
    {
      localbcsy.a(new String[] { str, localObject }).a();
      break;
      i = 0;
      break label111;
      break;
      localObject = "Clk_setcommgrp";
      break label133;
      localObject = "Clk_stick";
      break label205;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfm
 * JD-Core Version:    0.7.0.1
 */