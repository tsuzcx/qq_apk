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
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

public class anyk
  implements AdapterView.OnItemClickListener
{
  public anyk(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramLong = System.currentTimeMillis();
    bbjv.a(null, "AIO_EmoticonPanel_TabClick");
    paramAdapterView = this.a.jdField_a_of_type_JavaUtilList;
    if (paramAdapterView == null) {
      break label23;
    }
    label23:
    while (paramInt >= paramAdapterView.size()) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setSelection(paramInt);
    boolean bool;
    label80:
    Object localObject2;
    label139:
    label220:
    Object localObject1;
    if ((paramAdapterView.size() > EmoticonMainPanel.e) && (((aoak)paramAdapterView.get(EmoticonMainPanel.e)).jdField_a_of_type_Int == 8))
    {
      bool = true;
      EmoticonMainPanel.g = bool;
      paramAdapterView = (aoak)paramAdapterView.get(paramInt);
      if (paramAdapterView.jdField_a_of_type_Int != 8) {
        break label413;
      }
      localObject2 = ajyc.a(2131704076);
      paramAdapterView = (ImageView)paramView.findViewById(2131375038);
      bool = false;
      if (paramAdapterView != null)
      {
        if (paramAdapterView.getVisibility() != 0) {
          break label401;
        }
        bool = true;
        paramAdapterView.setVisibility(8);
      }
      paramAdapterView = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
      paramAdapterView.edit().putBoolean("isClickRecommendRedpoint", true).putBoolean("is_red_when_click_recommend", bool).apply();
      int i = paramAdapterView.getInt("recommendRuleId", -1);
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      if (!bool) {
        break label407;
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
        axqw.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", paramAdapterView, 0, 0, paramView, "", (String)localObject1, "");
      }
      if (EmoticonMainPanel.c == paramInt) {
        break;
      }
      EmoticonMainPanel.c = paramInt;
      this.a.e(paramInt);
      if (AppSetting.d) {
        QQAppInterface.f((String)localObject2);
      }
      bbjv.a("AIO_EmoticonPanel_TabClick", null);
      EmoticonMainPanel.a(this.a, true);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmoticonMainPanel", 2, "[Performance] TabsChanged duration:" + (System.currentTimeMillis() - paramLong));
      return;
      bool = false;
      break label80;
      label401:
      bool = false;
      break label139;
      label407:
      paramAdapterView = "";
      break label220;
      label413:
      if (paramAdapterView.jdField_a_of_type_Int == 9)
      {
        paramAdapterView = "0X8005797";
        localObject2 = ajyc.a(2131704065);
        localObject1 = "";
        paramView = "";
      }
      else if (paramAdapterView.jdField_a_of_type_Int == 4)
      {
        localObject2 = ajyc.a(2131704038);
        axqw.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0x800a56e", "0x800a56e", 0, 0, "", "", "", "");
        this.a.l();
        localObject1 = "";
        paramView = "";
        paramAdapterView = "0X8005799";
      }
      else
      {
        if (paramAdapterView.jdField_a_of_type_Int != 7) {
          break label536;
        }
        paramAdapterView = "0X800579A";
        localObject2 = ajyc.a(2131704085);
        localObject1 = "";
        paramView = "";
      }
    }
    label536:
    label574:
    Object localObject4;
    Object localObject3;
    if (paramAdapterView.jdField_a_of_type_Int == 6)
    {
      localObject2 = paramAdapterView.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      if (localObject2 == null) {
        break label861;
      }
      paramView = ((EmoticonPackage)localObject2).epId;
      if (((EmoticonPackage)localObject2).status == 2)
      {
        paramAdapterView = "0X800584E";
        localObject1 = Integer.toString(this.a.a(paramView));
        localObject4 = ajyc.a(2131704045) + ((EmoticonPackage)localObject2).name + ajyc.a(2131704062);
        if (((EmoticonPackage)localObject2).status == 2) {
          break label838;
        }
        localObject4 = (String)localObject4 + ajyc.a(2131704088);
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
      break label574;
      if (paramAdapterView.jdField_a_of_type_Int == 11)
      {
        localObject2 = ajyc.a(2131704086);
        paramAdapterView = (ImageView)paramView.findViewById(2131375038);
        if (paramAdapterView != null)
        {
          paramAdapterView.setVisibility(8);
          if ((EmoticonMainPanel.a(this.a) != null) && (EmoticonMainPanel.a(this.a).a != null)) {
            EmoticonMainPanel.a(this.a).a.setShowRed(3, false);
          }
        }
        axqw.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A36D", "0X800A36D", 0, 0, "", "", "", "");
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
      label838:
      localObject2 = paramView;
      localObject3 = paramAdapterView;
      paramAdapterView = (AdapterView<?>)localObject4;
      paramView = (View)localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      continue;
      label861:
      paramAdapterView = "";
      localObject2 = "";
      localObject1 = "";
      paramView = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anyk
 * JD-Core Version:    0.7.0.1
 */