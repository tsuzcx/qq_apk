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
import com.tencent.mobileqq.nearby.NearbyFlowerUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
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
    paramViewGroup = paramOnDragModeChangedListener;
    if (paramView != null)
    {
      paramViewGroup = paramOnDragModeChangedListener;
      if (paramView.getTag() != null)
      {
        paramViewGroup = paramOnDragModeChangedListener;
        if ((paramView.getTag() instanceof SayHelloListItemBuilder.SayHelloListItemHolder)) {
          paramViewGroup = (SayHelloListItemBuilder.SayHelloListItemHolder)paramView.getTag();
        }
      }
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = new SayHelloListItemBuilder.SayHelloListItemHolder();
      paramView = super.a(paramContext, 2131561563, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377459));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379092));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380944));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131365611));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379372));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131381704));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131367834));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131364463));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131382095));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131364584));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131365119));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377669));
      paramView.setTag(paramViewGroup);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a());
      }
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(13.0F, 1);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData)))
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
        paramOnDragModeChangedListener = null;
        if (paramRecentFaceDecoder != null) {
          paramOnDragModeChangedListener = paramRecentFaceDecoder.a(localRecentBaseData);
        }
        a(paramView, localRecentBaseData, paramContext, paramOnDragModeChangedListener);
      }
      for (;;)
      {
        super.a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        return paramView;
        if (paramViewGroup != null)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
        }
      }
    }
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    paramRecentBaseData = paramContext.getResources();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[0]));
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(Context paramContext, SayHelloListItemBuilder.SayHelloListItemHolder paramSayHelloListItemHolder, RecentSayHelloListItem paramRecentSayHelloListItem)
  {
    int k = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRecentSayHelloListItem.mTitleName);
    int j;
    label113:
    Object localObject;
    switch (paramRecentSayHelloListItem.gender)
    {
    default: 
      i = 2130840670;
      paramSayHelloListItemHolder.c.setBackgroundDrawable(TroopUtils.a(paramSayHelloListItemHolder.c.getResources(), Color.parseColor("#ff9cc4f7")));
      j = 0;
      if (paramRecentSayHelloListItem.age > 0)
      {
        paramSayHelloListItemHolder.c.setText(String.valueOf(paramRecentSayHelloListItem.age));
        localStringBuilder.append(paramRecentSayHelloListItem.age).append("岁");
        paramSayHelloListItemHolder.c.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        if (j == 0) {
          break label787;
        }
        paramSayHelloListItemHolder.c.setVisibility(0);
        i = 1;
        label141:
        if ((paramRecentSayHelloListItem.career > 0) && (paramRecentSayHelloListItem.career < 14)) {
          break label802;
        }
        paramSayHelloListItemHolder.d.setVisibility(8);
        label166:
        localObject = ProfileCardUtil.a((byte)paramRecentSayHelloListItem.constellation);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label877;
        }
        paramSayHelloListItemHolder.e.setVisibility(8);
        label193:
        if (paramRecentSayHelloListItem.vip <= 0) {
          break label940;
        }
        paramSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (paramRecentSayHelloListItem.vip != 1) {
          break label927;
        }
        paramSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841522);
        label226:
        paramSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColorStateList(2131167175));
        i += 1;
        label249:
        if (!paramRecentSayHelloListItem.charmIcon) {
          break label969;
        }
        if (paramSayHelloListItemHolder.f.getVisibility() != 0) {
          paramSayHelloListItemHolder.f.setVisibility(0);
        }
        paramSayHelloListItemHolder.f.setText("LV" + paramRecentSayHelloListItem.charmLevel);
        paramContext = paramSayHelloListItemHolder.f.getContext().getResources().getDrawable(2130845804);
        localObject = NearbyFlowerUtil.a(paramSayHelloListItemHolder.f.getContext());
        int m = Color.parseColor("#FFCC59");
        j = m;
        if (localObject != null)
        {
          j = m;
          if (paramRecentSayHelloListItem.charmLevel < localObject.length) {
            j = localObject[paramRecentSayHelloListItem.charmLevel];
          }
        }
        paramSayHelloListItemHolder.f.setBackgroundDrawable(TroopUtils.a(paramSayHelloListItemHolder.f.getContext().getResources(), j, paramContext));
        localStringBuilder.append(",").append("拥有魅力勋章");
        j = i + 1;
        label417:
        if ((paramRecentSayHelloListItem.commonId <= 0) || (TextUtils.isEmpty(paramRecentSayHelloListItem.common))) {
          break label1012;
        }
        j += 1;
        paramSayHelloListItemHolder.e.setVisibility(8);
        paramSayHelloListItemHolder.g.setVisibility(0);
        paramSayHelloListItemHolder.g.setText(paramRecentSayHelloListItem.common);
        paramSayHelloListItemHolder.g.setTag(Integer.valueOf(paramRecentSayHelloListItem.commonId));
        localStringBuilder.append(",").append(paramRecentSayHelloListItem.common);
      }
      break;
    }
    label787:
    label802:
    label877:
    label1012:
    for (int i = k;; i = 0)
    {
      if (i == 0)
      {
        paramSayHelloListItemHolder.g.setVisibility(8);
        paramSayHelloListItemHolder.g.setTag(Integer.valueOf(0));
      }
      if (j > 0) {
        paramSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      for (;;)
      {
        if (AppSetting.d)
        {
          if (paramRecentSayHelloListItem.mUnreadNum > 0) {
            localStringBuilder.append(",").append(paramRecentSayHelloListItem.mUnreadNum).append("条未读消息");
          }
          localStringBuilder.append(",").append(paramSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getText().toString());
          localStringBuilder.append(",").append(paramSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
          if (localStringBuilder.length() > 0) {
            paramRecentSayHelloListItem.mContentDesc = localStringBuilder.toString();
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.recent", 2, "talkback|" + localStringBuilder.toString());
          }
        }
        return;
        i = 2130841518;
        paramSayHelloListItemHolder.c.setBackgroundDrawable(TroopUtils.a(paramSayHelloListItemHolder.c.getResources(), Color.parseColor("#ff9cc4f7")));
        localStringBuilder.append(",").append("男");
        j = 1;
        break;
        i = 2130841516;
        paramSayHelloListItemHolder.c.setBackgroundDrawable(TroopUtils.a(paramSayHelloListItemHolder.c.getResources(), Color.parseColor("#ffffb4c8")));
        localStringBuilder.append(",").append("女");
        j = 1;
        break;
        paramSayHelloListItemHolder.c.setText("");
        break label113;
        paramSayHelloListItemHolder.c.setVisibility(8);
        i = 0;
        break label141;
        i += 1;
        paramSayHelloListItemHolder.d.setText(com.tencent.mobileqq.util.NearbyProfileUtil.e[paramRecentSayHelloListItem.career]);
        paramSayHelloListItemHolder.d.setBackgroundDrawable(TroopUtils.a(paramSayHelloListItemHolder.d.getResources(), Color.parseColor("#ff81d4f3")));
        paramSayHelloListItemHolder.d.setVisibility(0);
        localStringBuilder.append(",").append(com.tencent.mobileqq.util.NearbyProfileUtil.e[paramRecentSayHelloListItem.career]);
        break label166;
        i += 1;
        paramSayHelloListItemHolder.e.setText((CharSequence)localObject);
        paramSayHelloListItemHolder.e.setBackgroundResource(2130845866);
        paramSayHelloListItemHolder.e.setVisibility(0);
        localStringBuilder.append(",").append((String)localObject);
        break label193;
        paramSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841523);
        break label226;
        paramSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColorStateList(2131167100));
        paramSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label249;
        j = i;
        if (paramSayHelloListItemHolder.f.getVisibility() == 8) {
          break label417;
        }
        paramSayHelloListItemHolder.f.setVisibility(8);
        j = i;
        break label417;
        paramSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      QLog.i("Q.recent", 1, "bindView|param invalidate");
      return;
    }
    Object localObject = paramView.getTag();
    if ((localObject instanceof SayHelloListItemBuilder.SayHelloListItemHolder)) {}
    for (SayHelloListItemBuilder.SayHelloListItemHolder localSayHelloListItemHolder = (SayHelloListItemBuilder.SayHelloListItemHolder)localObject;; localSayHelloListItemHolder = null) {
      for (;;)
      {
        if (localSayHelloListItemHolder == null)
        {
          QLog.i("Q.recent", 1, "bindView|holder is null, tag = " + localObject);
          return;
        }
        localSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        RecentSayHelloListItem localRecentSayHelloListItem;
        CharSequence localCharSequence;
        int i;
        if ((paramRecentBaseData instanceof RecentSayHelloListItem))
        {
          localRecentSayHelloListItem = (RecentSayHelloListItem)paramRecentBaseData;
          localObject = localRecentSayHelloListItem.mTitleName;
          localCharSequence = localSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetTextView.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            localSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          i = paramRecentBaseData.mExtraInfoColor;
          paramDrawable = paramRecentBaseData.mMsgExtroInfo;
          if (paramDrawable == null) {
            break label471;
          }
          paramDrawable = paramDrawable.toString();
          if (!TextUtils.isEmpty(paramDrawable)) {
            localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
          }
          localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramDrawable, 1);
          localObject = localRecentSayHelloListItem.mLastMsg;
          localCharSequence = localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (paramDrawable.equals(localCharSequence)) {}
        }
        try
        {
          localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramDrawable);
          localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
          if (paramRecentBaseData.mStatus == 4) {
            localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(paramContext.getResources().getDrawable(2130839676), null);
          }
          localObject = localRecentSayHelloListItem.mShowTime;
          localCharSequence = localSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetTextView.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            localSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          m = localRecentSayHelloListItem.mUnreadNum;
          i = localRecentSayHelloListItem.mUnreadFlag;
          if (m > 0) {
            if (i == 0)
            {
              localSayHelloListItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
              k = 99;
              m = 0;
              j = 0;
              i = 0;
              CustomWidgetUtil.a(localSayHelloListItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, m, j, k, null);
              if (localSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
                localSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              }
              a(paramContext, localSayHelloListItemHolder, localRecentSayHelloListItem);
              if (!AppSetting.d) {
                break;
              }
              paramView.setContentDescription(paramRecentBaseData.mContentDesc);
              return;
              QLog.d("SayHelloListItemBuilder", 1, "data is not RecentSayHelloItem");
              throw new RuntimeException("data is null");
              label471:
              paramDrawable = "";
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int m;
            int k;
            int j;
            localException.printStackTrace();
            localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramDrawable + " ");
            continue;
            if (i == 2)
            {
              localSayHelloListItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
              m = 0;
              j = 0;
              i = 1;
              k = 99;
            }
            else if (i == 3)
            {
              j = 2130850838;
              if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
              localSayHelloListItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1);
              localSayHelloListItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167163));
              k = 99;
              i = 3;
            }
            else
            {
              j = 2130850834;
              localSayHelloListItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
              localSayHelloListItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167164));
              k = 99;
              i = 3;
              continue;
              k = 99;
              m = 0;
              j = 0;
              i = 0;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.SayHelloListItemBuilder
 * JD-Core Version:    0.7.0.1
 */