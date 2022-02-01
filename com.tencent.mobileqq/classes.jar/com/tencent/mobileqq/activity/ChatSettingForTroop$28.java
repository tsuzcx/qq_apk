package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.Switch;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class ChatSettingForTroop$28
  extends Handler
{
  ChatSettingForTroop$28(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void handleMessage(Message paramMessage)
  {
    int j = 0;
    if ((this.a.jdField_c_of_type_Boolean) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {}
    Object localObject1;
    Object localObject2;
    label360:
    Object localObject3;
    label547:
    label838:
    Switch localSwitch;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (paramMessage.what)
            {
            default: 
              return;
            case 1: 
              this.a.c();
              return;
            case 6: 
              if (QLog.isColorLevel()) {
                QLog.i("Q.chatopttroop", 2, "MSG_UPDATE_TROOP_MEMBER_CARD");
              }
              break;
            }
          } while (this.a.jdField_a_of_type_ArrayOfAndroidViewView == null);
          paramMessage = (FormSimpleItem)this.a.jdField_a_of_type_ArrayOfAndroidViewView[6];
        } while (paramMessage == null);
        if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.chatopttroop", 2, "handle MSG_UPDATE_TROOP_MEMBER_CARD message and update nick");
          }
          localObject1 = new ColorNickText(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick, 16).a();
          paramMessage.setRightText((CharSequence)localObject1);
          ColorNickManager.a(paramMessage.a(), (Spannable)localObject1, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNickId);
        }
        while (paramMessage.a() != null)
        {
          paramMessage.a().setCompoundDrawablePadding(ViewUtils.b(9.0F));
          return;
          paramMessage.setRightText(this.a.getString(2131697574));
          ColorNickManager.a(paramMessage.a(), new SpannableString(""), this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNickId);
        }
        localObject2 = this.a.jdField_a_of_type_ArrayOfAndroidViewView[4];
      } while (localObject2 == null);
      localObject1 = null;
      if (paramMessage.obj != null) {
        localObject1 = (String)paramMessage.obj;
      }
      ChatSettingForTroop.a(this.a, (View)localObject2, (String)localObject1);
      return;
      if (QLog.isColorLevel())
      {
        if (this.a.e != null)
        {
          i = this.a.e.size();
          QLog.d("Q.chatopttroop", 2, "MSG_UPDATE_INFO memberListForCard.size = " + i);
        }
      }
      else
      {
        if (this.a.jdField_c_of_type_AndroidWidgetTextView != null) {
          this.a.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701827) + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + HardCodeUtil.a(2131701833));
        }
        this.a.b(true);
        this.a.e();
        this.a.a(this.a.e);
        ChatSettingForTroop.j(this.a);
        paramMessage = this.a;
        if (this.a.d) {
          break label547;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        ChatSettingForTroop.a(paramMessage, bool, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop);
        if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
          break;
        }
        ChatSettingForTroop.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopRemark);
        return;
        i = -1;
        break label360;
      }
      localObject3 = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags;
      localObject2 = new Intent(this.a, TroopTagViewActivity.class);
      ((Intent)localObject2).putExtra("troopuin", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      ((Intent)localObject2).putExtra("isAdmin", false);
      localObject1 = "";
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText))
      {
        paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText;
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          ((Intent)localObject2).putExtra("subclass", paramMessage);
        }
        if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
          break label838;
        }
        paramMessage = new StringBuffer();
        localObject1 = ((List)localObject3).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          paramMessage.append((String)localObject3 + "\n");
        }
        paramMessage = (Message)localObject1;
        i = j;
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean != null)
        {
          paramMessage = (Message)localObject1;
          i = j;
          if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.a))
          {
            paramMessage = (Message)localObject1;
            i = j;
            if (!HardCodeUtil.a(2131701820).equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.a))
            {
              paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.a;
              i = 1;
            }
          }
        }
      }
      paramMessage.deleteCharAt(paramMessage.length() - 1);
      ((Intent)localObject2).putExtra("tags", paramMessage.toString());
      ((Intent)localObject2).putExtra("act_type", 1);
      ((Intent)localObject2).putExtra("uin", this.a.app.getCurrentAccountUin());
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        this.a.startActivityForResult((Intent)localObject2, 11);
        return;
      }
      this.a.startActivity((Intent)localObject2);
      return;
      localObject2 = this.a.jdField_a_of_type_ArrayOfAndroidViewView[8];
      localObject3 = this.a.jdField_a_of_type_ArrayOfAndroidViewView[9];
      if ((localObject3 == null) || (localObject2 == null) || (!(localObject2 instanceof FormSwitchItem))) {
        break;
      }
      localObject1 = (FormSimpleItem)((View)localObject3).findViewById(2131369444);
      localSwitch = ((FormSwitchItem)localObject2).a();
      ((TextView)((View)localObject3).findViewById(2131369107)).setVisibility(8);
      paramMessage = "";
      Boolean localBoolean = (Boolean)this.a.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController.c.get(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      if ((localBoolean != null) && (localBoolean.booleanValue())) {
        break label1325;
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null);
    int i = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopmask;
    if (i == 1)
    {
      ((View)localObject2).setBackgroundResource(2130839582);
      ((View)localObject2).getBackground().setAlpha(255);
      if (localSwitch.isChecked())
      {
        localSwitch.setTag(Boolean.TRUE);
        localSwitch.setChecked(false);
      }
      ((View)localObject3).setVisibility(8);
      paramMessage = "";
      this.a.b.setVisibility(8);
      if (ChatSettingForTroop.a(this.a) != null) {
        ChatSettingForTroop.e(this.a);
      }
    }
    for (;;)
    {
      ((FormSimpleItem)localObject1).setRightText(new QQText(paramMessage, 3));
      TroopAssistantManager.a().c(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      return;
      ((View)localObject2).setBackgroundResource(2130839585);
      ((View)localObject2).getBackground().setAlpha(255);
      if (!localSwitch.isChecked())
      {
        localSwitch.setTag(Boolean.TRUE);
        localSwitch.setChecked(true);
      }
      ((View)localObject3).setVisibility(0);
      switch (i)
      {
      default: 
        paramMessage = "";
        break;
      case 2: 
        paramMessage = this.a.getString(2131697647);
        this.a.getString(2131697649);
        break;
      case 3: 
        paramMessage = this.a.getString(2131693115);
        this.a.getString(2131697645);
        break;
      case 4: 
        paramMessage = this.a.getString(2131697651);
        this.a.getString(2131697653);
        break;
        label1325:
        ((View)localObject3).setVisibility(0);
        ((View)localObject2).setBackgroundResource(2130839585);
        ((View)localObject2).getBackground().setAlpha(255);
        this.a.b.setVisibility(0);
      }
    }
    paramMessage = this.a.jdField_a_of_type_ArrayOfAndroidViewView[27];
    if (paramMessage != null)
    {
      localObject1 = (TextView)paramMessage.findViewById(2131379432);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setTextColor(Color.parseColor("#00b6f9"));
        if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
          ((TextView)localObject1).setAlpha(0.5F);
        }
      }
      paramMessage = (ProgressBar)paramMessage.findViewById(2131373501);
      if (paramMessage != null) {
        paramMessage.setVisibility(8);
      }
    }
    QQToast.a(this.a, 2, this.a.getString(2131690937), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.28
 * JD-Core Version:    0.7.0.1
 */