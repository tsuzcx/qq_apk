package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ChatSettingForTroop$ListAdapter
  extends BaseAdapter
{
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager = null;
  private boolean jdField_a_of_type_Boolean = true;
  
  public ChatSettingForTroop$ListAdapter(ChatSettingForTroop paramChatSettingForTroop)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramChatSettingForTroop.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
    a();
    if (QLog.isColorLevel()) {
      if ("construct ListAdapter  memberUins.size = " + paramChatSettingForTroop.jdField_d_of_type_JavaUtilList == null) {
        break label99;
      }
    }
    label99:
    for (int i = paramChatSettingForTroop.jdField_d_of_type_JavaUtilList.size();; i = -1)
    {
      QLog.d("Q.chatopttroop", 2, new Object[] { Integer.valueOf(i) });
      return;
    }
  }
  
  private void a()
  {
    if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {}
    for (boolean bool = true; ((!this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mMemberInvitingFlag) && (!this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())) || ((!this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 3) && (!bool)); bool = false)
    {
      this.jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "隐藏邀请按钮：mMemberInvitingFlag=" + this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mMemberInvitingFlag + ", mTroopInfoData.isOwnerOrAdim() = " + this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim() + ", mTroopInfoData.cGroupOption=" + this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption + ", isPayToJoinTroop=" + bool);
      }
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList.size())
    {
      int j = i;
      if (this.jdField_a_of_type_Boolean)
      {
        j = i;
        if (i != 0) {
          j = i + 1;
        }
      }
      return Math.min(5, j);
    }
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList.size())) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    DiscussionInfoCardActivity.ViewHolder localViewHolder;
    Object localObject1;
    TextView localTextView;
    ImageView localImageView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.getLayoutInflater().inflate(2131558943, null);
      localView.setMinimumHeight(ViewUtils.b(57.0F));
      localViewHolder = new DiscussionInfoCardActivity.ViewHolder();
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368603));
      localObject1 = (RelativeLayout.LayoutParams)localViewHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      int i = ViewUtils.b(35.0F);
      ((RelativeLayout.LayoutParams)localObject1).height = i;
      ((RelativeLayout.LayoutParams)localObject1).width = i;
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ViewUtils.b(7.0F);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((ColorNickTextView)localView.findViewById(2131372115));
      localView.setTag(localViewHolder);
      localView.setVisibility(0);
      localView.setFocusable(false);
      localTextView = localViewHolder.jdField_a_of_type_AndroidWidgetTextView;
      localImageView = localViewHolder.jdField_a_of_type_AndroidWidgetImageView;
      if ((!this.jdField_a_of_type_Boolean) || (paramInt != getCount() - 1)) {
        break label304;
      }
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.getString(2131693523));
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.getResources().getColor(2131167036));
      localImageView.setBackgroundDrawable(null);
      localImageView.setImageResource(2130839309);
      localImageView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_AndroidViewView$OnTouchListener);
      localImageView.setEnabled(true);
      localImageView.setTag(Integer.valueOf(2));
      localViewHolder.jdField_a_of_type_JavaLangString = "";
    }
    label304:
    String str;
    for (;;)
    {
      if (AppSetting.jdField_d_of_type_Boolean) {
        ViewCompat.setImportantForAccessibility(localImageView, 2);
      }
      localImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      localViewHolder = (DiscussionInfoCardActivity.ViewHolder)paramView.getTag();
      localView = paramView;
      break;
      if (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList.size())
      {
        localImageView.setImageResource(2130845079);
        localTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.getResources().getColor(2131167036));
        str = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_JavaUtilList.get(paramInt) + "";
        localViewHolder.jdField_a_of_type_JavaLangString = str;
        if (!TextUtils.isEmpty(str)) {
          break label413;
        }
        localTextView.setText("");
        localImageView.setImageDrawable(ImageUtil.c());
      }
    }
    label413:
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, str)) {}
    for (Object localObject2 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, str, true);; localObject2 = str)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = str;
        }
        localObject2 = localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_d_of_type_Boolean)
        {
          localObject2 = localObject1;
          if (TextUtils.isDigitsOnly((CharSequence)localObject1)) {
            localObject2 = HardCodeUtil.a(2131701831);
          }
        }
        localObject1 = new ColorNickText((CharSequence)localObject2, 12).a();
        localTextView.setText((CharSequence)localObject1);
        ColorNickManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app, localTextView, (Spannable)localObject1);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a(localViewHolder, null, true);
      localImageView.setTag(2131378910, str);
      localImageView.setTag(Integer.valueOf(3));
      break;
      ((ITroopMemberNameService)this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberNameAsync(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, str, new ChatSettingForTroop.ListAdapter.1(this, localViewHolder, str, localTextView));
    }
  }
  
  public void notifyDataSetChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "notifyDataSetChanged");
    }
    a();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.ListAdapter
 * JD-Core Version:    0.7.0.1
 */