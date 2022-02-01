package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.nearby.api.INearbyFlowerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.BizTroopUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class SayHelloListItemBuilder
  extends RecentItemBaseBuilder
{
  private List<String> a;
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramOnDragModeChangedListener = null;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof SayHelloListItemBuilder.SayHelloListItemHolder))) {
      paramViewGroup = (SayHelloListItemBuilder.SayHelloListItemHolder)paramView.getTag();
    } else {
      paramViewGroup = null;
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = new SayHelloListItemBuilder.SayHelloListItemHolder();
      paramView = super.a(paramContext, 2131561404, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376905));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378461));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380210));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131365453));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378723));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380937));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131367601));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131364353));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131381297));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131364471));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131364999));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377106));
      paramView.setTag(paramViewGroup);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a());
      }
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(13.0F, 1);
    }
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData)))
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
      if (paramRecentFaceDecoder != null) {
        paramOnDragModeChangedListener = paramRecentFaceDecoder.a(localRecentBaseData);
      }
      a(paramView, localRecentBaseData, paramContext, paramOnDragModeChangedListener);
    }
    else if (paramViewGroup != null)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("");
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
    }
    super.a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
    paramView.setOnClickListener(paramOnClickListener);
    paramView.setOnLongClickListener(paramOnLongClickListener);
    paramView.setTag(-1, Integer.valueOf(paramInt));
    return paramView;
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData != null) && (paramContext != null))
    {
      paramRecentBaseData = paramContext.getResources();
      paramContext = this.jdField_a_of_type_JavaUtilList;
      if (paramContext == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      } else {
        paramContext.clear();
      }
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[0]));
      return this.jdField_a_of_type_JavaUtilList;
    }
    return null;
  }
  
  public void a(Context paramContext, SayHelloListItemBuilder.SayHelloListItemHolder paramSayHelloListItemHolder, RecentSayHelloListItem paramRecentSayHelloListItem)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRecentSayHelloListItem.mTitleName);
    int i = paramRecentSayHelloListItem.gender;
    int k = 1;
    if (i != 1)
    {
      if (i != 2)
      {
        i = 2130840545;
        paramSayHelloListItemHolder.c.setBackgroundDrawable(BizTroopUtil.a(paramSayHelloListItemHolder.c.getResources(), Color.parseColor("#ff9cc4f7")));
        j = 0;
        break label162;
      }
      i = 2130841397;
      paramSayHelloListItemHolder.c.setBackgroundDrawable(BizTroopUtil.a(paramSayHelloListItemHolder.c.getResources(), Color.parseColor("#ffffb4c8")));
      localStringBuilder.append(",");
      localStringBuilder.append("女");
    }
    else
    {
      i = 2130841399;
      paramSayHelloListItemHolder.c.setBackgroundDrawable(BizTroopUtil.a(paramSayHelloListItemHolder.c.getResources(), Color.parseColor("#ff9cc4f7")));
      localStringBuilder.append(",");
      localStringBuilder.append("男");
    }
    int j = 1;
    label162:
    if (paramRecentSayHelloListItem.age > 0)
    {
      paramSayHelloListItemHolder.c.setText(String.valueOf(paramRecentSayHelloListItem.age));
      localStringBuilder.append(paramRecentSayHelloListItem.age);
      localStringBuilder.append("岁");
    }
    else
    {
      paramSayHelloListItemHolder.c.setText("");
    }
    paramSayHelloListItemHolder.c.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    if (j != 0)
    {
      paramSayHelloListItemHolder.c.setVisibility(0);
      i = 1;
    }
    else
    {
      paramSayHelloListItemHolder.c.setVisibility(8);
      i = 0;
    }
    if ((paramRecentSayHelloListItem.career > 0) && (paramRecentSayHelloListItem.career < 14))
    {
      i += 1;
      paramSayHelloListItemHolder.d.setText(com.tencent.mobileqq.util.NearbyProfileUtil.e[paramRecentSayHelloListItem.career]);
      paramSayHelloListItemHolder.d.setBackgroundDrawable(BizTroopUtil.a(paramSayHelloListItemHolder.d.getResources(), Color.parseColor("#ff81d4f3")));
      paramSayHelloListItemHolder.d.setVisibility(0);
      localStringBuilder.append(",");
      localStringBuilder.append(com.tencent.mobileqq.util.NearbyProfileUtil.e[paramRecentSayHelloListItem.career]);
    }
    else
    {
      paramSayHelloListItemHolder.d.setVisibility(8);
    }
    Object localObject = ProfileCardUtil.a((byte)paramRecentSayHelloListItem.constellation);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramSayHelloListItemHolder.e.setVisibility(8);
    }
    else
    {
      i += 1;
      paramSayHelloListItemHolder.e.setText((CharSequence)localObject);
      paramSayHelloListItemHolder.e.setBackgroundResource(2130845739);
      paramSayHelloListItemHolder.e.setVisibility(0);
      localStringBuilder.append(",");
      localStringBuilder.append((String)localObject);
    }
    if (paramRecentSayHelloListItem.vip > 0)
    {
      paramSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramRecentSayHelloListItem.vip == 1) {
        paramSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841403);
      } else {
        paramSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841404);
      }
      paramSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColorStateList(2131167200));
      j = i + 1;
    }
    else
    {
      paramSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColorStateList(2131167124));
      paramSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      j = i;
    }
    if (paramRecentSayHelloListItem.charmIcon)
    {
      if (paramSayHelloListItemHolder.f.getVisibility() != 0) {
        paramSayHelloListItemHolder.f.setVisibility(0);
      }
      j += 1;
      paramContext = paramSayHelloListItemHolder.f;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LV");
      ((StringBuilder)localObject).append(paramRecentSayHelloListItem.charmLevel);
      paramContext.setText(((StringBuilder)localObject).toString());
      paramContext = paramSayHelloListItemHolder.f.getContext().getResources().getDrawable(2130845677);
      localObject = ((INearbyFlowerUtil)QRoute.api(INearbyFlowerUtil.class)).getGlamourLevelColors(paramSayHelloListItemHolder.f.getContext());
      int m = Color.parseColor("#FFCC59");
      i = m;
      if (localObject != null)
      {
        i = m;
        if (paramRecentSayHelloListItem.charmLevel < localObject.length) {
          i = localObject[paramRecentSayHelloListItem.charmLevel];
        }
      }
      paramSayHelloListItemHolder.f.setBackgroundDrawable(BizTroopUtil.a(paramSayHelloListItemHolder.f.getContext().getResources(), i, paramContext));
      localStringBuilder.append(",");
      localStringBuilder.append("拥有魅力勋章");
      i = j;
    }
    else
    {
      i = j;
      if (paramSayHelloListItemHolder.f.getVisibility() != 8)
      {
        paramSayHelloListItemHolder.f.setVisibility(8);
        i = j;
      }
    }
    if ((paramRecentSayHelloListItem.commonId > 0) && (!TextUtils.isEmpty(paramRecentSayHelloListItem.common)))
    {
      i += 1;
      paramSayHelloListItemHolder.e.setVisibility(8);
      paramSayHelloListItemHolder.g.setVisibility(0);
      paramSayHelloListItemHolder.g.setText(paramRecentSayHelloListItem.common);
      paramSayHelloListItemHolder.g.setTag(Integer.valueOf(paramRecentSayHelloListItem.commonId));
      localStringBuilder.append(",");
      localStringBuilder.append(paramRecentSayHelloListItem.common);
      j = k;
    }
    else
    {
      j = 0;
    }
    if (j == 0)
    {
      paramSayHelloListItemHolder.g.setVisibility(8);
      paramSayHelloListItemHolder.g.setTag(Integer.valueOf(0));
    }
    if (i > 0) {
      paramSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    } else {
      paramSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    }
    if (AppSetting.d)
    {
      if (paramRecentSayHelloListItem.mUnreadNum > 0)
      {
        localStringBuilder.append(",");
        localStringBuilder.append(paramRecentSayHelloListItem.mUnreadNum);
        localStringBuilder.append("条未读消息");
      }
      localStringBuilder.append(",");
      localStringBuilder.append(paramSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getText().toString());
      localStringBuilder.append(",");
      localStringBuilder.append(paramSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
      if (localStringBuilder.length() > 0) {
        paramRecentSayHelloListItem.mContentDesc = localStringBuilder.toString();
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("talkback|");
        paramContext.append(localStringBuilder.toString());
        QLog.i("Q.recent", 2, paramContext.toString());
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView != null) && (paramRecentBaseData != null))
    {
      Object localObject1 = paramView.getTag();
      SayHelloListItemBuilder.SayHelloListItemHolder localSayHelloListItemHolder;
      if ((localObject1 instanceof SayHelloListItemBuilder.SayHelloListItemHolder)) {
        localSayHelloListItemHolder = (SayHelloListItemBuilder.SayHelloListItemHolder)localObject1;
      } else {
        localSayHelloListItemHolder = null;
      }
      if (localSayHelloListItemHolder == null)
      {
        paramView = new StringBuilder();
        paramView.append("bindView|holder is null, tag = ");
        paramView.append(localObject1);
        QLog.i("Q.recent", 1, paramView.toString());
        return;
      }
      localSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      if ((paramRecentBaseData instanceof RecentSayHelloListItem))
      {
        RecentSayHelloListItem localRecentSayHelloListItem = (RecentSayHelloListItem)paramRecentBaseData;
        localObject1 = localRecentSayHelloListItem.mTitleName;
        Object localObject3 = localSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetTextView.getText();
        paramDrawable = (Drawable)localObject1;
        if (localObject1 == null) {
          paramDrawable = "";
        }
        if (!paramDrawable.equals(localObject3)) {
          localSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramDrawable);
        }
        int i = paramRecentBaseData.mExtraInfoColor;
        paramDrawable = paramRecentBaseData.mMsgExtroInfo;
        if (paramDrawable != null) {
          paramDrawable = paramDrawable.toString();
        } else {
          paramDrawable = "";
        }
        if (!TextUtils.isEmpty(paramDrawable)) {
          localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
        }
        localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramDrawable, 1);
        paramDrawable = localRecentSayHelloListItem.mLastMsg;
        localObject1 = localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getText();
        if (paramDrawable == null) {
          paramDrawable = "";
        }
        if (!paramDrawable.equals(localObject1)) {
          try
          {
            localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramDrawable);
            localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            localObject2 = localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramDrawable);
            ((StringBuilder)localObject3).append(" ");
            ((SingleLineTextView)localObject2).setText(((StringBuilder)localObject3).toString());
          }
        }
        if (paramRecentBaseData.mStatus == 4) {
          localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(paramContext.getResources().getDrawable(2130839534), null);
        }
        Object localObject2 = localRecentSayHelloListItem.mShowTime;
        localObject3 = localSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetTextView.getText();
        paramDrawable = (Drawable)localObject2;
        if (localObject2 == null) {
          paramDrawable = "";
        }
        if (!paramDrawable.equals(localObject3)) {
          localSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramDrawable);
        }
        int j = localRecentSayHelloListItem.mUnreadNum;
        i = localRecentSayHelloListItem.mUnreadFlag;
        if (j > 0) {
          if (i == 0)
          {
            localSayHelloListItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
          }
          else
          {
            if (i == 2)
            {
              localSayHelloListItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
              i = 1;
              break label554;
            }
            if (i == 3)
            {
              boolean bool = paramRecentBaseData instanceof RecentTroopAssistantItem;
              localSayHelloListItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1);
              localSayHelloListItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167188));
              i = 3;
              k = 2130850774;
              break label560;
            }
            localSayHelloListItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
            localSayHelloListItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167189));
            i = 3;
            k = 2130850770;
            break label560;
          }
        }
        i = 0;
        label554:
        j = 0;
        int k = 0;
        label560:
        CustomWidgetUtil.a(localSayHelloListItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, j, k, 99, null);
        if (localSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
          localSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        a(paramContext, localSayHelloListItemHolder, localRecentSayHelloListItem);
        if (AppSetting.d) {
          paramView.setContentDescription(paramRecentBaseData.mContentDesc);
        }
        return;
      }
      QLog.d("SayHelloListItemBuilder", 1, "data is not RecentSayHelloItem");
      throw new RuntimeException("data is null");
    }
    QLog.i("Q.recent", 1, "bindView|param invalidate");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.SayHelloListItemBuilder
 * JD-Core Version:    0.7.0.1
 */