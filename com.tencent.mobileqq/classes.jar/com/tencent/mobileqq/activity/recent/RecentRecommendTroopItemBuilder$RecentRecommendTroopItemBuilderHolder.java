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
import com.tencent.mobileqq.troop.data.RecentRecommendTroopItem;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
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
    if (paramRecentItemRecommendTroopData.mUser != null) {}
    label534:
    label546:
    for (boolean bool = paramRecentItemRecommendTroopData.mUser.uin.equals("sp_uin_for_title");; bool = true)
    {
      if (bool)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if (AppSetting.d)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription(this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getText() + " " + this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.a());
          this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setContentDescription(this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getText());
          this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.a());
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(HardCodeUtil.a(2131713165));
        }
        return;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (paramRecentItemRecommendTroopData.mUser != null)
      {
        this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentItemRecommendTroopData.mUser.displayName);
        QLog.d("RecentRecommendTroopItemBuilder", 2, "bindData data.mUser.displayName: " + paramRecentItemRecommendTroopData.mUser.displayName);
        QLog.i("RecentAdapter", 2, "faceDecoder getFaceDrawable uin: " + paramRecentItemRecommendTroopData.mUser.uin);
        if (paramRecentFaceDecoder == null)
        {
          paramRecentFaceDecoder = null;
          label243:
          this.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(paramRecentFaceDecoder);
          if (!(paramRecentItemRecommendTroopData.mUser.extraInfo instanceof RecentRecommendTroopItem)) {
            break label632;
          }
        }
      }
      label323:
      label456:
      label620:
      label632:
      for (paramRecentFaceDecoder = (RecentRecommendTroopItem)paramRecentItemRecommendTroopData.mUser.extraInfo;; paramRecentFaceDecoder = null)
      {
        if (paramRecentFaceDecoder == null)
        {
          QLog.d("RecentRecommendTroopIte", 1, "bindData, troopItem == null");
          return;
          paramRecentFaceDecoder = paramRecentFaceDecoder.a(paramRecentItemRecommendTroopData);
          break label243;
        }
        if (paramRecentFaceDecoder.activity > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setHotLevel(paramRecentFaceDecoder.activity);
          ArrayList localArrayList = GroupViewAdapter.a((RecentRecommendTroopItem)paramRecentItemRecommendTroopData.mUser.extraInfo);
          if ((localArrayList == null) || (localArrayList.size() <= 0)) {
            break label534;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(localArrayList);
          label377:
          if (!paramRecentFaceDecoder.isJoined()) {
            break label546;
          }
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_a_of_type_AndroidWidgetButton.setText(2131699385);
          this.jdField_a_of_type_AndroidWidgetButton.setMinWidth(ViewUtils.a(60.0F));
          this.jdField_a_of_type_AndroidWidgetButton.setMinWidth(ViewUtils.a(29.0F));
          this.jdField_a_of_type_AndroidWidgetButton.setPadding(0, this.jdField_a_of_type_AndroidWidgetButton.getPaddingTop(), 0, this.jdField_a_of_type_AndroidWidgetButton.getPaddingBottom());
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
          if (TextUtils.isEmpty(paramRecentFaceDecoder.intro)) {
            break label620;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText(new QQText(paramRecentFaceDecoder.intro, 11, 16));
        }
        for (;;)
        {
          QLog.d("", 2, "bindData data.mUser.displayName: " + paramRecentItemRecommendTroopData.mUser.displayName);
          break;
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopActiveLayout.setVisibility(8);
          break label323;
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setVisibility(8);
          break label377;
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          this.jdField_a_of_type_AndroidWidgetButton.setText(2131699383);
          this.jdField_a_of_type_AndroidWidgetButton.setMinWidth(0);
          this.jdField_a_of_type_AndroidWidgetButton.setMinHeight(0);
          int i = ViewUtils.a(16.0F);
          this.jdField_a_of_type_AndroidWidgetButton.setPadding(i, this.jdField_a_of_type_AndroidWidgetButton.getPaddingTop(), i, this.jdField_a_of_type_AndroidWidgetButton.getPaddingBottom());
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839458);
          break label456;
          this.jdField_a_of_type_ComTencentMobileqqWidgetFolderTextView.setText("");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentRecommendTroopItemBuilder.RecentRecommendTroopItemBuilderHolder
 * JD-Core Version:    0.7.0.1
 */