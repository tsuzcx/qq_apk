import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView<*>;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

class aprd
  implements AdapterView.OnItemClickListener
{
  aprd(apqz paramapqz) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    QQAppInterface localQQAppInterface = this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramLong = System.currentTimeMillis();
    bdjd.a(null, "AIO_EmoticonPanel_TabClick");
    paramAdapterView = this.a.a.jdField_b_of_type_JavaUtilList;
    if (paramAdapterView == null) {
      break label38;
    }
    label38:
    while (paramInt >= paramAdapterView.size()) {
      return;
    }
    this.a.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setSelection(paramInt);
    boolean bool;
    label98:
    Object localObject2;
    label157:
    label228:
    Object localObject1;
    if ((paramAdapterView.size() > EmoticonPanelController.d) && (((apsm)paramAdapterView.get(EmoticonPanelController.d)).jdField_a_of_type_Int == 8))
    {
      bool = true;
      EmoticonPanelController.jdField_a_of_type_Boolean = bool;
      paramAdapterView = (apsm)paramAdapterView.get(paramInt);
      if (paramAdapterView.jdField_a_of_type_Int != 8) {
        break label421;
      }
      localObject2 = alpo.a(2131704459);
      paramAdapterView = (ImageView)paramView.findViewById(2131375521);
      bool = false;
      if (paramAdapterView != null)
      {
        if (paramAdapterView.getVisibility() != 0) {
          break label409;
        }
        bool = true;
        paramAdapterView.setVisibility(8);
      }
      paramAdapterView = localQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
      paramAdapterView.edit().putBoolean("isClickRecommendRedpoint", true).putBoolean("is_red_when_click_recommend", bool).apply();
      int i = paramAdapterView.getInt("recommendRuleId", -1);
      paramView = localQQAppInterface.c();
      if (!bool) {
        break label415;
      }
      paramAdapterView = "1";
      VasWebviewUtil.reportCommercialDrainage(paramView, "ep_mall", "0X8005798", "", 0, 0, 0, "", "", "", paramAdapterView, "", i + "", "", 0, 0, 0, 0);
      localObject1 = "";
      paramView = "";
      paramAdapterView = "0X8005798";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramAdapterView)) {
        azmj.b(localQQAppInterface, "CliOper", "", "", "ep_mall", paramAdapterView, 0, 0, paramView, "", (String)localObject1, "");
      }
      if (EmoticonPanelController.jdField_b_of_type_Int == paramInt) {
        break;
      }
      EmoticonPanelController.jdField_b_of_type_Int = paramInt;
      this.a.a.e(paramInt);
      if (AppSetting.c) {
        QQAppInterface.f((String)localObject2);
      }
      bdjd.a("AIO_EmoticonPanel_TabClick", null);
      this.a.a.i = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmoticonPanelMallHelper", 2, "[Performance] TabsChanged duration:" + (System.currentTimeMillis() - paramLong));
      return;
      bool = false;
      break label98;
      label409:
      bool = false;
      break label157;
      label415:
      paramAdapterView = "";
      break label228;
      label421:
      if (paramAdapterView.jdField_a_of_type_Int == 9)
      {
        paramAdapterView = "0X8005797";
        localObject2 = alpo.a(2131704448);
        localObject1 = "";
        paramView = "";
      }
      else if (paramAdapterView.jdField_a_of_type_Int == 4)
      {
        localObject2 = alpo.a(2131704421);
        azmj.b(localQQAppInterface, "dc00898", "", "", "0x800a56e", "0x800a56e", 0, 0, "", "", "", "");
        ((apqu)this.a.a.a(2)).k();
        localObject1 = "";
        paramView = "";
        paramAdapterView = "0X8005799";
      }
      else
      {
        if (paramAdapterView.jdField_a_of_type_Int != 7) {
          break label549;
        }
        paramAdapterView = "0X800579A";
        localObject2 = alpo.a(2131704468);
        localObject1 = "";
        paramView = "";
      }
    }
    label549:
    label587:
    Object localObject4;
    Object localObject3;
    if (paramAdapterView.jdField_a_of_type_Int == 6)
    {
      localObject2 = paramAdapterView.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      if (localObject2 == null) {
        break label869;
      }
      paramView = ((EmoticonPackage)localObject2).epId;
      if (((EmoticonPackage)localObject2).status == 2)
      {
        paramAdapterView = "0X800584E";
        localObject1 = Integer.toString(this.a.a.a(paramView));
        localObject4 = alpo.a(2131704428) + ((EmoticonPackage)localObject2).name + alpo.a(2131704445);
        if (((EmoticonPackage)localObject2).status == 2) {
          break label846;
        }
        localObject4 = (String)localObject4 + alpo.a(2131704471);
        localObject3 = localObject1;
        localObject2 = paramAdapterView;
        paramAdapterView = (AdapterView<?>)localObject4;
        localObject1 = paramView;
        paramView = (View)localObject3;
      }
    }
    for (;;)
    {
      localObject3 = paramAdapterView;
      localObject4 = paramView;
      paramView = (View)localObject1;
      paramAdapterView = (AdapterView<?>)localObject2;
      localObject1 = localObject4;
      localObject2 = localObject3;
      break;
      paramAdapterView = "0X80059B8";
      break label587;
      if (paramAdapterView.jdField_a_of_type_Int == 11)
      {
        localObject2 = alpo.a(2131704469);
        paramAdapterView = (ImageView)paramView.findViewById(2131375521);
        if (paramAdapterView != null)
        {
          paramAdapterView.setVisibility(8);
          paramAdapterView = this.a.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
          if ((paramAdapterView != null) && (paramAdapterView.a != null)) {
            paramAdapterView.a.setShowRed(3, false);
          }
        }
        azmj.b(localQQAppInterface, "dc00898", "", "", "0X800A36D", "0X800A36D", 0, 0, "", "", "", "");
        localObject1 = "";
        paramView = "";
        paramAdapterView = "";
        break;
      }
      localObject2 = "";
      localObject1 = "";
      paramView = "";
      paramAdapterView = "";
      break;
      label846:
      localObject2 = paramView;
      localObject3 = paramAdapterView;
      paramAdapterView = (AdapterView<?>)localObject4;
      paramView = (View)localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      continue;
      label869:
      paramAdapterView = "";
      localObject2 = "";
      localObject1 = "";
      paramView = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aprd
 * JD-Core Version:    0.7.0.1
 */