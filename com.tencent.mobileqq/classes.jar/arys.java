import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.MobileQQ;

class arys
  implements AdapterView.OnItemClickListener
{
  arys(aryo paramaryo) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    QQAppInterface localQQAppInterface = this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    long l = System.currentTimeMillis();
    bgso.a(null, "AIO_EmoticonPanel_TabClick");
    Object localObject1 = this.a.a.jdField_b_of_type_JavaUtilList;
    if (localObject1 == null) {}
    while ((paramInt >= ((List)localObject1).size()) || (((aryw)this.a.a.a(8)).b(paramInt)))
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelMallHelper", 2, "mOnItemClicked position: " + paramInt);
    }
    aryo.a(this.a, true);
    aryo.a(this.a, 1);
    this.a.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewHorizontalListViewEx.setSelection(paramInt);
    boolean bool;
    label185:
    Object localObject2;
    Object localObject6;
    Object localObject4;
    label262:
    int i;
    Object localObject3;
    if ((((List)localObject1).size() > EmoticonPanelController.d) && (((asaf)((List)localObject1).get(EmoticonPanelController.d)).jdField_a_of_type_Int == 8))
    {
      bool = true;
      EmoticonPanelController.jdField_a_of_type_Boolean = bool;
      localObject2 = (asaf)((List)localObject1).get(paramInt);
      localObject1 = "";
      localObject6 = "";
      localObject4 = "";
      if (((asaf)localObject2).jdField_a_of_type_Int != 8) {
        break label594;
      }
      localObject2 = anni.a(2131702868);
      localObject1 = (ImageView)paramView.findViewById(2131376296);
      bool = false;
      if (localObject1 != null)
      {
        if (((ImageView)localObject1).getVisibility() != 0) {
          break label581;
        }
        bool = true;
        ((ImageView)localObject1).setVisibility(8);
      }
      localObject1 = localQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
      ((SharedPreferences)localObject1).edit().putBoolean("isClickRecommendRedpoint", true).putBoolean("is_red_when_click_recommend", bool).apply();
      i = ((SharedPreferences)localObject1).getInt("recommendRuleId", -1);
      localObject3 = localQQAppInterface.c();
      if (!bool) {
        break label587;
      }
      localObject1 = "1";
      label339:
      VasWebviewUtil.reportCommercialDrainage((String)localObject3, "ep_mall", "0X8005798", "", 0, 0, 0, "", "", "", (String)localObject1, "", i + "", "", 0, 0, 0, 0);
      bool = false;
      localObject1 = "0X800AE0B";
      localObject3 = "0X8005798";
    }
    for (;;)
    {
      i = this.a.a.a(bool);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (i != 0)) {
        bcst.b(localQQAppInterface, "dc00898", "", "", (String)localObject1, (String)localObject1, i, 0, "1", "", "", "");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        bcst.b(localQQAppInterface, "CliOper", "", "", "ep_mall", (String)localObject3, 0, 0, (String)localObject6, "", (String)localObject4, "");
      }
      if (EmoticonPanelController.jdField_b_of_type_Int == paramInt) {
        break;
      }
      EmoticonPanelController.jdField_b_of_type_Int = paramInt;
      this.a.a.e(paramInt);
      if (AppSetting.c) {
        QQAppInterface.f((String)localObject2);
      }
      bgso.a("AIO_EmoticonPanel_TabClick", null);
      this.a.a.i = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmoticonPanelMallHelper", 2, "[Performance] TabsChanged duration:" + (System.currentTimeMillis() - l));
      break;
      bool = false;
      break label185;
      label581:
      bool = false;
      break label262;
      label587:
      localObject1 = "";
      break label339;
      label594:
      if (((asaf)localObject2).jdField_a_of_type_Int == 9)
      {
        localObject1 = "0X800AE0D";
        bool = false;
        localObject2 = anni.a(2131702857);
        localObject3 = "0X8005797";
      }
      else if (((asaf)localObject2).jdField_a_of_type_Int == 4)
      {
        localObject2 = anni.a(2131702830);
        bcst.b(localQQAppInterface, "dc00898", "", "", "0x800a56e", "0x800a56e", 0, 0, "", "", "", "");
        ((aryf)this.a.a.a(2)).c();
        bool = true;
        localObject1 = "0X800AE08";
        localObject3 = "0X8005799";
      }
      else
      {
        if (((asaf)localObject2).jdField_a_of_type_Int != 7) {
          break label733;
        }
        localObject1 = "0X800AE07";
        localObject2 = anni.a(2131702877);
        bool = true;
        localObject3 = "0X800579A";
      }
    }
    label733:
    Object localObject5;
    if (((asaf)localObject2).jdField_a_of_type_Int == 6)
    {
      localObject4 = ((asaf)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      if (localObject4 == null) {
        break label1146;
      }
      localObject2 = ((EmoticonPackage)localObject4).epId;
      if (((EmoticonPackage)localObject4).status == 2)
      {
        localObject1 = "0X800584E";
        label776:
        localObject3 = Integer.toString(this.a.a.a((String)localObject2));
        localObject6 = anni.a(2131702837) + ((EmoticonPackage)localObject4).name + anni.a(2131702854);
        if (((EmoticonPackage)localObject4).status == 2) {
          break label1119;
        }
        localObject6 = (String)localObject6 + anni.a(2131702880);
        localObject5 = localObject3;
        localObject4 = localObject1;
        localObject1 = localObject6;
        localObject3 = localObject2;
        localObject2 = localObject5;
      }
    }
    for (;;)
    {
      Object localObject7 = localObject1;
      localObject5 = localObject2;
      localObject6 = localObject3;
      localObject3 = localObject4;
      bool = false;
      localObject1 = "0X800AE0C";
      localObject2 = localObject7;
      localObject4 = localObject5;
      break;
      localObject1 = "0X80059B8";
      break label776;
      if (((asaf)localObject2).jdField_a_of_type_Int == 11)
      {
        localObject2 = anni.a(2131702878);
        localObject1 = (ImageView)paramView.findViewById(2131376296);
        if (localObject1 != null)
        {
          ((ImageView)localObject1).setVisibility(8);
          localObject1 = this.a.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
          if ((localObject1 != null) && (((BaseChatPie)localObject1).a != null)) {
            ((BaseChatPie)localObject1).a.setShowRed(3, false);
          }
        }
        bcst.b(localQQAppInterface, "dc00898", "", "", "0X800A36D", "0X800A36D", 0, 0, "", "", "", "");
        bool = true;
        localObject1 = "0X800AE0A";
        localObject3 = "";
        break;
      }
      if (((asaf)localObject2).jdField_a_of_type_Int == 12)
      {
        localObject1 = "0X800AE09";
        bool = true;
        localObject3 = "";
        localObject2 = "";
        break;
      }
      if (((asaf)localObject2).jdField_a_of_type_Int == 10)
      {
        bool = false;
        localObject1 = "0X800AE0C";
        localObject2 = "";
        localObject3 = "";
        break;
      }
      bool = true;
      localObject3 = "";
      localObject2 = "";
      break;
      label1119:
      localObject4 = localObject2;
      localObject5 = localObject1;
      localObject1 = localObject6;
      localObject2 = localObject3;
      localObject3 = localObject4;
      localObject4 = localObject5;
      continue;
      label1146:
      localObject1 = "";
      localObject4 = "";
      localObject3 = "";
      localObject2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arys
 * JD-Core Version:    0.7.0.1
 */