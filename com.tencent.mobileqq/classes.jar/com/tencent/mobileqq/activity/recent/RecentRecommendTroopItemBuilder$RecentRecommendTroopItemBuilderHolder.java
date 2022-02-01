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
  public RelativeLayout a;
  public LinearLayout b;
  public TextView c;
  public TextView d;
  public ThemeImageView e;
  public SingleLineTextView f;
  public FolderTextView g;
  public Button h;
  TroopActiveLayout i;
  TroopLabelLayout j;
  public RecentItemRecommendTroopData k;
  
  public void a(RecentItemRecommendTroopData paramRecentItemRecommendTroopData, RecentFaceDecoder paramRecentFaceDecoder)
  {
    this.k = paramRecentItemRecommendTroopData;
    boolean bool;
    if (paramRecentItemRecommendTroopData.mUser != null) {
      bool = paramRecentItemRecommendTroopData.mUser.uin.equals("sp_uin_for_title");
    } else {
      bool = true;
    }
    if (bool)
    {
      this.b.setVisibility(8);
      this.a.setVisibility(0);
    }
    else
    {
      this.b.setVisibility(0);
      this.a.setVisibility(8);
      if (paramRecentItemRecommendTroopData.mUser != null)
      {
        this.f.setText(paramRecentItemRecommendTroopData.mUser.displayName);
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
        this.e.setImageDrawable(paramRecentFaceDecoder);
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
        this.i.setVisibility(0);
        this.i.setHotLevel(paramRecentFaceDecoder.activity);
      }
      else
      {
        this.i.setVisibility(8);
      }
      Object localObject = GroupViewAdapter.a((RecentRecommendTroopItem)paramRecentItemRecommendTroopData.mUser.extraInfo);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.j.setVisibility(0);
        this.j.setLabelType(1);
        this.j.a((ArrayList)localObject);
      }
      else
      {
        this.j.setVisibility(8);
      }
      if (paramRecentFaceDecoder.isJoined())
      {
        this.h.setEnabled(false);
        this.h.setText(2131897521);
        this.h.setMinWidth(ViewUtils.dip2px(60.0F));
        this.h.setMinWidth(ViewUtils.dip2px(29.0F));
        localObject = this.h;
        ((Button)localObject).setPadding(0, ((Button)localObject).getPaddingTop(), 0, this.h.getPaddingBottom());
        this.h.setBackgroundDrawable(null);
      }
      else
      {
        this.h.setEnabled(true);
        this.h.setText(2131897519);
        this.h.setMinWidth(0);
        this.h.setMinHeight(0);
        int m = ViewUtils.dip2px(16.0F);
        localObject = this.h;
        ((Button)localObject).setPadding(m, ((Button)localObject).getPaddingTop(), m, this.h.getPaddingBottom());
        this.h.setBackgroundResource(2130839494);
      }
      if (!TextUtils.isEmpty(paramRecentFaceDecoder.intro)) {
        this.g.setText(new QQText(paramRecentFaceDecoder.intro, 11, 16));
      } else {
        this.g.setText("");
      }
      paramRecentFaceDecoder = new StringBuilder();
      paramRecentFaceDecoder.append("bindData data.mUser.displayName: ");
      paramRecentFaceDecoder.append(paramRecentItemRecommendTroopData.mUser.displayName);
      QLog.d("", 2, paramRecentFaceDecoder.toString());
    }
    if (AppSetting.e)
    {
      paramRecentItemRecommendTroopData = this.b;
      paramRecentFaceDecoder = new StringBuilder();
      paramRecentFaceDecoder.append(this.f.getText());
      paramRecentFaceDecoder.append(" ");
      paramRecentFaceDecoder.append(this.g.getText());
      paramRecentItemRecommendTroopData.setContentDescription(paramRecentFaceDecoder.toString());
      paramRecentItemRecommendTroopData = this.f;
      paramRecentItemRecommendTroopData.setContentDescription(paramRecentItemRecommendTroopData.getText());
      paramRecentItemRecommendTroopData = this.g;
      paramRecentItemRecommendTroopData.setContentDescription(paramRecentItemRecommendTroopData.getText());
      this.a.setContentDescription(HardCodeUtil.a(2131910699));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentRecommendTroopItemBuilder.RecentRecommendTroopItemBuilderHolder
 * JD-Core Version:    0.7.0.1
 */