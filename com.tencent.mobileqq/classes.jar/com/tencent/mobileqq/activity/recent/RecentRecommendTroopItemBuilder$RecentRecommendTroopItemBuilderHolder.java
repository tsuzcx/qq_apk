package com.tencent.mobileqq.activity.recent;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.addContactTroopView.GroupViewAdapter;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.data.RecentItemRecommendTroopData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.recommend.data.RecentRecommendTroopItem;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;

public class RecentRecommendTroopItemBuilder$RecentRecommendTroopItemBuilderHolder
  extends RecentItemBaseBuilder.RecentItemBaseHolder
{
  public Button a;
  public LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  public RecentItemRecommendTroopData a;
  TroopActiveLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout;
  TroopLabelLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout;
  public FolderTextView a;
  public SingleLineTextView a;
  public ThemeImageView a;
  public TextView b;
  
  public void a(RecentItemRecommendTroopData paramRecentItemRecommendTroopData, RecentFaceDecoder paramRecentFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemRecommendTroopData = paramRecentItemRecommendTroopData;
    boolean bool;
    if (paramRecentItemRecommendTroopData.mUser != null) {
      bool = paramRecentItemRecommendTroopData.mUser.uin.equals("sp_uin_for_title");
    } else {
      bool = true;
    }
    if (bool)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (paramRecentItemRecommendTroopData.mUser != null)
      {
        this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentItemRecommendTroopData.mUser.displayName);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("bindData data.mUser.displayName: ");
        ((StringBuilder)localObject).append(paramRecentItemRecommendTroopData.mUser.displayName);
        QLog.d("RecentRecommendTroopItemBuilder", 2, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("faceDecoder getFaceDrawable uin: ");
        ((StringBuilder)localObject).append(paramRecentItemRecommendTroopData.mUser.uin);
        QLog.i("RecentAdapter", 2, ((StringBuilder)localObject).toString());
        if (paramRecentFaceDecoder == null) {
          paramRecentFaceDecoder = null;
        } else {
          paramRecentFaceDecoder = paramRecentFaceDecoder.a(paramRecentItemRecommendTroopData);
        }
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(paramRecentFaceDecoder);
        if ((paramRecentItemRecommendTroopData.mUser.extraInfo instanceof RecentRecommendTroopItem))
        {
          paramRecentFaceDecoder = (RecentRecommendTroopItem)paramRecentItemRecommendTroopData.mUser.extraInfo;
          break label229;
        }
      }
      paramRecentFaceDecoder = null;
      label229:
      if (paramRecentFaceDecoder == null)
      {
        QLog.d("RecentRecommendTroopIte", 1, "bindData, troopItem == null");
        return;
      }
      if (paramRecentFaceDecoder.activity > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setHotLevel(paramRecentFaceDecoder.activity);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(8);
      }
      Object localObject = GroupViewAdapter.a((RecentRecommendTroopItem)paramRecentItemRecommendTroopData.mUser.extraInfo);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a((ArrayList)localObject);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(8);
      }
      if (paramRecentFaceDecoder.isJoined())
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131699490);
        this.jdField_a_of_type_AndroidWidgetButton.setMinWidth(ViewUtils.a(60.0F));
        this.jdField_a_of_type_AndroidWidgetButton.setMinWidth(ViewUtils.a(29.0F));
        localObject = this.jdField_a_of_type_AndroidWidgetButton;
        ((Button)localObject).setPadding(0, ((Button)localObject).getPaddingTop(), 0, this.jdField_a_of_type_AndroidWidgetButton.getPaddingBottom());
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131699488);
        this.jdField_a_of_type_AndroidWidgetButton.setMinWidth(0);
        this.jdField_a_of_type_AndroidWidgetButton.setMinHeight(0);
        int i = ViewUtils.a(16.0F);
        localObject = this.jdField_a_of_type_AndroidWidgetButton;
        ((Button)localObject).setPadding(i, ((Button)localObject).getPaddingTop(), i, this.jdField_a_of_type_AndroidWidgetButton.getPaddingBottom());
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839314);
      }
      if (!TextUtils.isEmpty(paramRecentFaceDecoder.intro)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText(new QQText(paramRecentFaceDecoder.intro, 11, 16));
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText("");
      }
      paramRecentFaceDecoder = new StringBuilder();
      paramRecentFaceDecoder.append("bindData data.mUser.displayName: ");
      paramRecentFaceDecoder.append(paramRecentItemRecommendTroopData.mUser.displayName);
      QLog.d("", 2, paramRecentFaceDecoder.toString());
    }
    if (AppSetting.d)
    {
      paramRecentItemRecommendTroopData = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      paramRecentFaceDecoder = new StringBuilder();
      paramRecentFaceDecoder.append(this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getText());
      paramRecentFaceDecoder.append(" ");
      paramRecentFaceDecoder.append(this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.a());
      paramRecentItemRecommendTroopData.setContentDescription(paramRecentFaceDecoder.toString());
      paramRecentItemRecommendTroopData = this.jdField_a_of_type_ComTencentWidgetSingleLineTextView;
      paramRecentItemRecommendTroopData.setContentDescription(paramRecentItemRecommendTroopData.getText());
      paramRecentItemRecommendTroopData = this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView;
      paramRecentItemRecommendTroopData.setContentDescription(paramRecentItemRecommendTroopData.a());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(HardCodeUtil.a(2131713140));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentRecommendTroopItemBuilder.RecentRecommendTroopItemBuilderHolder
 * JD-Core Version:    0.7.0.1
 */