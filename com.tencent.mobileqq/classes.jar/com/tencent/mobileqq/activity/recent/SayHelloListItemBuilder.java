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
  private List a;
  
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
      paramView = super.a(paramContext, 2130970597, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371224));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363921));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131363211));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131364896));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365242));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364891));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131369955));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131369956));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131364893));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131370542));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131365238));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131365231));
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
  
  public List a(RecentBaseData paramRecentBaseData, Context paramContext)
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
    int i;
    int j;
    if (paramRecentSayHelloListItem.k > 0)
    {
      paramSayHelloListItemHolder.c.setText(String.valueOf(paramRecentSayHelloListItem.k));
      localStringBuilder.append(paramRecentSayHelloListItem.jdField_b_of_type_JavaLangString);
      switch (paramRecentSayHelloListItem.l)
      {
      default: 
        i = 2130839267;
        paramSayHelloListItemHolder.c.setBackgroundDrawable(TroopUtils.a(paramSayHelloListItemHolder.c.getResources(), Color.parseColor("#ff9cc4f7")));
        j = 0;
      }
    }
    for (;;)
    {
      label97:
      if ((AppSetting.b) && (paramRecentSayHelloListItem.k > 0)) {
        localStringBuilder.append(paramRecentSayHelloListItem.k).append("岁");
      }
      paramSayHelloListItemHolder.c.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      label153:
      label178:
      Object localObject;
      label205:
      label238:
      int m;
      if (j != 0)
      {
        paramSayHelloListItemHolder.c.setVisibility(0);
        i = 1;
        if ((paramRecentSayHelloListItem.m > 0) && (paramRecentSayHelloListItem.m < 14)) {
          break label874;
        }
        paramSayHelloListItemHolder.d.setVisibility(8);
        localObject = ProfileCardUtil.a((byte)paramRecentSayHelloListItem.n);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label963;
        }
        paramSayHelloListItemHolder.e.setVisibility(8);
        if (paramRecentSayHelloListItem.j <= 0) {
          break label1040;
        }
        paramSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (paramRecentSayHelloListItem.j != 1) {
          break label1027;
        }
        paramSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839504);
        paramSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColorStateList(2131494308));
        i += 1;
        label261:
        if (!paramRecentSayHelloListItem.jdField_d_of_type_Boolean) {
          break label1069;
        }
        if (paramSayHelloListItemHolder.f.getVisibility() != 0) {
          paramSayHelloListItemHolder.f.setVisibility(0);
        }
        paramSayHelloListItemHolder.f.setText("LV" + paramRecentSayHelloListItem.o);
        paramContext = paramSayHelloListItemHolder.f.getContext().getResources().getDrawable(2130842873);
        localObject = NearbyFlowerUtil.a(paramSayHelloListItemHolder.f.getContext());
        m = Color.parseColor("#FFCC59");
        j = m;
        if (localObject != null)
        {
          j = m;
          if (paramRecentSayHelloListItem.o < localObject.length) {
            j = localObject[paramRecentSayHelloListItem.o];
          }
        }
        paramSayHelloListItemHolder.f.setBackgroundDrawable(TroopUtils.a(paramSayHelloListItemHolder.f.getContext().getResources(), j, paramContext));
        if (AppSetting.b) {
          localStringBuilder.append(",").append("拥有魅力勋章");
        }
        j = i + 1;
        label435:
        if ((paramRecentSayHelloListItem.p <= 0) || (TextUtils.isEmpty(paramRecentSayHelloListItem.a))) {
          break label1112;
        }
        m = j + 1;
        paramSayHelloListItemHolder.e.setVisibility(8);
        paramSayHelloListItemHolder.g.setVisibility(0);
        paramSayHelloListItemHolder.g.setText(paramRecentSayHelloListItem.a);
        paramSayHelloListItemHolder.g.setTag(Integer.valueOf(paramRecentSayHelloListItem.p));
        j = m;
        i = k;
        if (AppSetting.b)
        {
          localStringBuilder.append(",").append(paramRecentSayHelloListItem.a);
          i = k;
          j = m;
        }
      }
      for (;;)
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
          if (AppSetting.b)
          {
            if (paramRecentSayHelloListItem.jdField_c_of_type_Int > 0) {
              localStringBuilder.append(",").append(paramRecentSayHelloListItem.jdField_c_of_type_Int).append("条未读消息");
            }
            localStringBuilder.append(",").append(paramSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a().toString());
            localStringBuilder.append(",").append(paramSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
            if (localStringBuilder.length() > 0) {
              paramRecentSayHelloListItem.jdField_d_of_type_JavaLangString = localStringBuilder.toString();
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.recent", 2, "talkback|" + localStringBuilder.toString());
            }
          }
          return;
          paramSayHelloListItemHolder.c.setText("");
          break;
          j = 2130839502;
          paramSayHelloListItemHolder.c.setBackgroundDrawable(TroopUtils.a(paramSayHelloListItemHolder.c.getResources(), Color.parseColor("#ff9cc4f7")));
          i = j;
          if (!AppSetting.b) {
            break label1118;
          }
          localStringBuilder.append(",").append("男");
          m = 1;
          i = j;
          j = m;
          break label97;
          j = 2130839500;
          paramSayHelloListItemHolder.c.setBackgroundDrawable(TroopUtils.a(paramSayHelloListItemHolder.c.getResources(), Color.parseColor("#ffffb4c8")));
          i = j;
          if (!AppSetting.b) {
            break label1118;
          }
          localStringBuilder.append(",").append("女");
          m = 1;
          i = j;
          j = m;
          break label97;
          paramSayHelloListItemHolder.c.setVisibility(8);
          i = 0;
          break label153;
          label874:
          j = i + 1;
          paramSayHelloListItemHolder.d.setText(com.tencent.mobileqq.util.NearbyProfileUtil.e[paramRecentSayHelloListItem.m]);
          paramSayHelloListItemHolder.d.setBackgroundDrawable(TroopUtils.a(paramSayHelloListItemHolder.d.getResources(), Color.parseColor("#ff81d4f3")));
          paramSayHelloListItemHolder.d.setVisibility(0);
          i = j;
          if (!AppSetting.b) {
            break label178;
          }
          localStringBuilder.append(",").append(com.tencent.mobileqq.util.NearbyProfileUtil.e[paramRecentSayHelloListItem.m]);
          i = j;
          break label178;
          label963:
          j = i + 1;
          paramSayHelloListItemHolder.e.setText((CharSequence)localObject);
          paramSayHelloListItemHolder.e.setBackgroundResource(2130842926);
          paramSayHelloListItemHolder.e.setVisibility(0);
          i = j;
          if (!AppSetting.b) {
            break label205;
          }
          localStringBuilder.append(",").append((String)localObject);
          i = j;
          break label205;
          label1027:
          paramSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839505);
          break label238;
          label1040:
          paramSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColorStateList(2131494263));
          paramSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          break label261;
          label1069:
          j = i;
          if (paramSayHelloListItemHolder.f.getVisibility() == 8) {
            break label435;
          }
          paramSayHelloListItemHolder.f.setVisibility(8);
          j = i;
          break label435;
          paramSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
        }
        label1112:
        i = 0;
      }
      label1118:
      j = 1;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    Object localObject = paramView.getTag();
    if ((localObject instanceof SayHelloListItemBuilder.SayHelloListItemHolder)) {}
    for (SayHelloListItemBuilder.SayHelloListItemHolder localSayHelloListItemHolder = (SayHelloListItemBuilder.SayHelloListItemHolder)localObject;; localSayHelloListItemHolder = null) {
      for (;;)
      {
        if (localSayHelloListItemHolder == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject);
          return;
        }
        localSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        RecentSayHelloListItem localRecentSayHelloListItem;
        CharSequence localCharSequence;
        int i;
        if ((paramRecentBaseData instanceof RecentSayHelloListItem))
        {
          localRecentSayHelloListItem = (RecentSayHelloListItem)paramRecentBaseData;
          localObject = localRecentSayHelloListItem.jdField_b_of_type_JavaLangString;
          localCharSequence = localSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetTextView.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            localSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          i = paramRecentBaseData.e;
          paramDrawable = paramRecentBaseData.jdField_d_of_type_JavaLangCharSequence;
          if (paramDrawable == null) {
            break label489;
          }
          paramDrawable = paramDrawable.toString();
          if (!TextUtils.isEmpty(paramDrawable)) {
            localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
          }
          localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramDrawable, 1);
          localObject = localRecentSayHelloListItem.jdField_c_of_type_JavaLangCharSequence;
          localCharSequence = localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a();
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
          if (paramRecentBaseData.a == 4) {
            localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(paramContext.getResources().getDrawable(2130838710), null);
          }
          localObject = localRecentSayHelloListItem.jdField_c_of_type_JavaLangString;
          localCharSequence = localSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetTextView.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            localSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          m = localRecentSayHelloListItem.jdField_c_of_type_Int;
          i = localRecentSayHelloListItem.jdField_b_of_type_Int;
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
              if (!AppSetting.b) {
                break;
              }
              paramView.setContentDescription(paramRecentBaseData.jdField_d_of_type_JavaLangString);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("SayHelloListItemBuilder", 2, "data is not RecentSayHelloItem");
              }
              throw new RuntimeException("data is null");
              label489:
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
              j = 2130846138;
              if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
              localSayHelloListItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1);
              k = 99;
              i = 3;
            }
            else
            {
              j = 2130846137;
              localSayHelloListItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.SayHelloListItemBuilder
 * JD-Core Version:    0.7.0.1
 */