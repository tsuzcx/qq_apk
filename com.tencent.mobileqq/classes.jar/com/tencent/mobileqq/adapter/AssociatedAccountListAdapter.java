package com.tencent.mobileqq.adapter;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.subaccount.AssociatedAccountListItemData;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.UpArrowView;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class AssociatedAccountListAdapter
  extends BaseAdapter
{
  public LayoutInflater a;
  public View.OnClickListener a;
  public QQAppInterface a;
  public ArrayList a;
  boolean a;
  
  public AssociatedAccountListAdapter(QQAppInterface paramQQAppInterface, ArrayList paramArrayList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Boolean = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AssociatedAccountListItemData localAssociatedAccountListItemData;
    SubAccountInfo localSubAccountInfo;
    FaceDrawable localFaceDrawable;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130971618, paramViewGroup, false);
      paramViewGroup = new AssociatedAccountListAdapter.ViewHolder(this);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131363378));
      paramViewGroup.b = ((SingleLineTextView)paramView.findViewById(2131365659));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131362719));
      paramView.setTag(paramViewGroup);
      localAssociatedAccountListItemData = (AssociatedAccountListItemData)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountListItemData = localAssociatedAccountListItemData;
      if (localAssociatedAccountListItemData != null)
      {
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localAssociatedAccountListItemData.jdField_a_of_type_JavaLangString);
        paramViewGroup.b.setText(localAssociatedAccountListItemData.jdField_c_of_type_JavaLangString);
        localSubAccountInfo = (SubAccountInfo)localAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject;
        if (localSubAccountInfo != null)
        {
          localFaceDrawable = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localSubAccountInfo.subuin);
          if (localAssociatedAccountListItemData.e != 0) {
            break label237;
          }
          paramView.findViewById(2131375184).setBackgroundDrawable(null);
        }
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(localFaceDrawable);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(localSubAccountInfo.subuin);
      a(paramView, localAssociatedAccountListItemData);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((AppSetting.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString))) {
        paramView.setContentDescription(localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString);
      }
      return paramView;
      paramViewGroup = (AssociatedAccountListAdapter.ViewHolder)paramView.getTag();
      break;
      label237:
      paramView.findViewById(2131375184).setBackgroundResource(2130846108);
    }
  }
  
  private View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    int i;
    if (paramView == null)
    {
      i = 2130971614;
      if (paramInt2 == 7)
      {
        i = 2130971615;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(i, paramViewGroup, false);
        paramViewGroup = new AssociatedAccountListAdapter.ViewHolder(this);
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      AssociatedAccountListItemData localAssociatedAccountListItemData = (AssociatedAccountListItemData)getItem(paramInt1);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountListItemData = localAssociatedAccountListItemData;
      if (localAssociatedAccountListItemData != null)
      {
        a(paramView, localAssociatedAccountListItemData);
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if ((AppSetting.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString))) {
          paramView.setContentDescription(localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString);
        }
      }
      return paramView;
      if (paramInt2 != 4) {
        break;
      }
      i = 2130971617;
      break;
      paramViewGroup = (AssociatedAccountListAdapter.ViewHolder)paramView.getTag();
    }
  }
  
  private void a(View paramView, AssociatedAccountListItemData paramAssociatedAccountListItemData)
  {
    if ((paramView == null) || (paramAssociatedAccountListItemData == null)) {}
    label285:
    label428:
    for (;;)
    {
      return;
      int i = 2130842533;
      if (this.jdField_a_of_type_Boolean) {
        i = 2130838623;
      }
      Object localObject1;
      Object localObject2;
      switch (paramAssociatedAccountListItemData.jdField_b_of_type_Int)
      {
      default: 
        return;
      case 1: 
        paramView.setBackgroundResource(2130838635);
        return;
      case 2: 
        paramView.setBackgroundResource(2130838623);
        return;
      case 3: 
      case 4: 
        localObject1 = paramView.findViewById(2131363630);
        View localView;
        float f;
        if (this.jdField_a_of_type_Boolean)
        {
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
          localView = paramView.findViewById(2131375194);
          localObject2 = paramView.getLayoutParams();
          f = DeviceInfoUtil.a();
          if (!paramAssociatedAccountListItemData.jdField_b_of_type_Boolean) {
            break label285;
          }
          localObject1 = paramView.findViewById(2131375190);
          paramAssociatedAccountListItemData = (AssociatedAccountListItemData)localObject1;
          if (localObject1 == null) {
            paramAssociatedAccountListItemData = paramView;
          }
          paramAssociatedAccountListItemData.setBackgroundResource(i);
          if (localView != null) {
            localView.setVisibility(0);
          }
          ((ViewGroup.LayoutParams)localObject2).height = ((int)(74.0F * f));
          if (this.jdField_a_of_type_Boolean)
          {
            paramAssociatedAccountListItemData = (UpArrowView)paramView.findViewById(2131363443);
            if (paramAssociatedAccountListItemData != null) {
              paramAssociatedAccountListItemData.setTheme(true);
            }
          }
        }
        for (;;)
        {
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          return;
          if (localObject1 == null) {
            break;
          }
          ((View)localObject1).setVisibility(0);
          if (!(((View)localObject1).getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            break;
          }
          localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
          if (paramAssociatedAccountListItemData.jdField_b_of_type_Int == 3) {}
          for (((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(12.0F * DeviceInfoUtil.a() + 0.5D));; ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0)
          {
            ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            break;
          }
          paramView.setBackgroundResource(i);
          if (localView != null) {
            localView.setVisibility(8);
          }
          ((ViewGroup.LayoutParams)localObject2).height = ((int)(66.0F * f));
        }
      }
      if (paramAssociatedAccountListItemData.jdField_b_of_type_Boolean)
      {
        localObject2 = paramView.findViewById(2131375190);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = paramView;
        }
        ((View)localObject1).setBackgroundResource(i);
      }
      for (;;)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label428;
        }
        localObject1 = paramView.findViewById(2131363630);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        if (!paramAssociatedAccountListItemData.jdField_b_of_type_Boolean) {
          break;
        }
        paramAssociatedAccountListItemData = paramView.findViewById(2131373108);
        if (paramAssociatedAccountListItemData != null) {
          paramAssociatedAccountListItemData.setVisibility(8);
        }
        paramView = (UpArrowView)paramView.findViewById(2131363443);
        if (paramView == null) {
          break;
        }
        paramView.setTheme(true);
        return;
        paramView.setBackgroundResource(i);
      }
    }
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AssociatedAccountListItemData localAssociatedAccountListItemData;
    FrameLayout localFrameLayout;
    int k;
    int i;
    float f1;
    float f2;
    int j;
    int m;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130971620, paramViewGroup, false);
      paramViewGroup = new AssociatedAccountListAdapter.ViewHolder(this);
      paramView.setTag(paramViewGroup);
      localAssociatedAccountListItemData = (AssociatedAccountListItemData)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountListItemData = localAssociatedAccountListItemData;
      if (localAssociatedAccountListItemData == null) {
        break label614;
      }
      paramViewGroup = (ArrayList)localAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject;
      if (paramViewGroup == null) {
        break label607;
      }
      localFrameLayout = (FrameLayout)paramView.findViewById(2131364073);
      k = paramViewGroup.size();
      i = localFrameLayout.getChildCount();
      f1 = DeviceInfoUtil.a();
      f2 = (float)DeviceInfoUtil.j();
      j = (int)(66.0F * f1 + 0.5F);
      m = (int)(90.0F * f1 + 0.5F);
      if ((f2 - 8.0F * f1) / j >= 5) {
        break label619;
      }
    }
    label607:
    label614:
    label619:
    for (paramInt = (int)(f2 - 8.0F * f1) / j;; paramInt = 5)
    {
      f1 = (f2 - 8.0F * f1 - paramInt * j) / (paramInt - 1) + 0.5F;
      if (f1 < 0.0F) {
        f1 = 0.0F;
      }
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        AssociatedAccountListAdapter.ViewHolder localViewHolder;
        if (k > i)
        {
          while (i < k)
          {
            localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130971619, null, false);
            localObject2 = new FrameLayout.LayoutParams(j, m);
            int n = i / paramInt;
            ((FrameLayout.LayoutParams)localObject2).leftMargin = ((int)(i % paramInt * (j + f1)));
            ((FrameLayout.LayoutParams)localObject2).topMargin = (n * m);
            localViewHolder = new AssociatedAccountListAdapter.ViewHolder(this);
            localViewHolder.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)((View)localObject1).findViewById(2131362719));
            localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject1).findViewById(2131363378));
            localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject1).findViewById(2131363207));
            ((View)localObject1).setTag(localViewHolder);
            localFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            i += 1;
          }
          paramViewGroup = (AssociatedAccountListAdapter.ViewHolder)paramView.getTag();
          break;
        }
        if (k < i)
        {
          paramInt = i - 1;
          while (paramInt >= k)
          {
            localFrameLayout.removeViewAt(paramInt);
            paramInt -= 1;
          }
        }
        paramInt = 0;
        while (paramInt < k)
        {
          localObject1 = (AssociatedAccountListItemData)paramViewGroup.get(paramInt);
          localObject2 = localFrameLayout.getChildAt(paramInt);
          localViewHolder = (AssociatedAccountListAdapter.ViewHolder)((View)localObject2).getTag();
          localViewHolder.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountListItemData = ((AssociatedAccountListItemData)localObject1);
          localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(((AssociatedAccountListItemData)localObject1).jdField_a_of_type_JavaLangString);
          SimpleAccount localSimpleAccount = (SimpleAccount)((AssociatedAccountListItemData)localObject1).jdField_a_of_type_JavaLangObject;
          FaceDrawable localFaceDrawable = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localSimpleAccount.getUin());
          localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(((AssociatedAccountListItemData)localObject1).jdField_a_of_type_JavaLangString);
          localViewHolder.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(localSimpleAccount.getUin());
          localViewHolder.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(localFaceDrawable);
          localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
          m = ((AssociatedAccountListItemData)localObject1).jdField_d_of_type_Int;
          i = 0;
          j = 0;
          if (m > 0)
          {
            j = 2130846056;
            i = 3;
          }
          localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
          CustomWidgetUtil.a(localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, m, j, 99, null);
          ((View)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          if ((AppSetting.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(((AssociatedAccountListItemData)localObject1).jdField_d_of_type_JavaLangString))) {
            ((View)localObject2).setContentDescription(((AssociatedAccountListItemData)localObject1).jdField_d_of_type_JavaLangString);
          }
          paramInt += 1;
        }
        a(paramView, localAssociatedAccountListItemData);
        return paramView;
      }
    }
  }
  
  private View c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    AssociatedAccountListItemData localAssociatedAccountListItemData;
    Resources localResources;
    SubAccountMessage localSubAccountMessage;
    Object localObject;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130971613, paramViewGroup, false);
      paramViewGroup = new AssociatedAccountListAdapter.ViewHolder(this);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131363378));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)localView.findViewById(2131362719));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131363207));
      paramViewGroup.b = ((SingleLineTextView)localView.findViewById(2131365659));
      localView.setTag(paramViewGroup);
      localAssociatedAccountListItemData = (AssociatedAccountListItemData)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountListItemData = localAssociatedAccountListItemData;
      localResources = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources();
      if (localAssociatedAccountListItemData != null)
      {
        localSubAccountMessage = (SubAccountMessage)localAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject;
        localObject = localSubAccountMessage.sendername;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label930;
        }
        localObject = localSubAccountMessage.senderuin;
      }
    }
    label903:
    label914:
    label930:
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject);
      if (((localSubAccountMessage.mEmoRecentMsg == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) && (localSubAccountMessage.msg != null)) {
        localSubAccountMessage.mEmoRecentMsg = new QQText(localSubAccountMessage.msg, 3, 16);
      }
      paramViewGroup.b.setText(localSubAccountMessage.mEmoRecentMsg);
      if ((localSubAccountMessage.mTimeString == null) || (localSubAccountMessage.mEmoRecentMsg == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) {
        localSubAccountMessage.mTimeString = TimeFormatterUtils.a(localSubAccountMessage.time * 1000L, true, SubAccountControll.jdField_a_of_type_JavaLangString);
      }
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(localSubAccountMessage.mTimeString, 0);
      paramView = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localSubAccountMessage.senderuin);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(localSubAccountMessage.senderuin);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(paramView);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      int m = localSubAccountMessage.unreadNum;
      paramInt = 0;
      int i = 0;
      int j;
      int k;
      if (m > 0)
      {
        j = 2130846055;
        k = 3;
        if ((2 == localAssociatedAccountListItemData.jdField_c_of_type_Int) || (3 == localAssociatedAccountListItemData.jdField_c_of_type_Int))
        {
          paramView = "[" + localResources.getString(2131437908) + "]";
          paramInt = 0;
          i = j;
        }
      }
      for (;;)
      {
        label423:
        paramViewGroup.b.setExtendText(paramView, 1);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, localView);
        CustomWidgetUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, k, m, i, 99, null);
        StringBuilder localStringBuilder;
        label506:
        float f;
        if ((AppSetting.jdField_b_of_type_Boolean) && (TextUtils.isEmpty(localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString)))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject).append(",");
          if (localAssociatedAccountListItemData.jdField_d_of_type_Int == 0)
          {
            if (paramView != null) {
              localStringBuilder.append(paramView + ",");
            }
            localStringBuilder.append(localSubAccountMessage.mEmoRecentMsg).append(",").append(localSubAccountMessage.mTimeString);
            localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString = localStringBuilder.toString();
          }
        }
        else
        {
          f = DeviceInfoUtil.a();
          paramView = localResources.getColorStateList(2131494265);
          localObject = localResources.getColorStateList(2131494217);
          i = localResources.getColor(2131494288);
          paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor((ColorStateList)localObject);
          paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
          paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
          paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
          paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
          paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
          paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
          if (paramInt == 0) {
            break label903;
          }
          paramViewGroup.b.setTextColor(i);
        }
        for (;;)
        {
          paramViewGroup.b.setExtendTextColor(ColorStateList.valueOf(i), 1);
          paramViewGroup.b.setExtendTextPadding((int)(f * 2.0F), 1);
          paramViewGroup.b.setExtendTextSize(14.0F, 1);
          a(localView, localAssociatedAccountListItemData);
          localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          if ((AppSetting.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString))) {
            localView.setContentDescription(localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString);
          }
          return localView;
          paramViewGroup = (AssociatedAccountListAdapter.ViewHolder)paramView.getTag();
          localView = paramView;
          break;
          paramInt = k;
          i = j;
          if (!"RED_PACKET".equals(localSubAccountMessage.subExtr)) {
            break label914;
          }
          paramView = "";
          paramInt = 1;
          i = j;
          break label423;
          if (localAssociatedAccountListItemData.jdField_d_of_type_Int == 1)
          {
            localStringBuilder.append("有一条未读");
            break label506;
          }
          if (localAssociatedAccountListItemData.jdField_d_of_type_Int == 2)
          {
            localStringBuilder.append("有两条未读");
            break label506;
          }
          if (localAssociatedAccountListItemData.jdField_d_of_type_Int <= 0) {
            break label506;
          }
          localStringBuilder.append("有").append(localAssociatedAccountListItemData.jdField_d_of_type_Int).append("条未读,");
          break label506;
          paramViewGroup.b.setTextColor(paramView);
        }
        paramView = "";
        j = 0;
        k = paramInt;
        paramInt = j;
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return paramInt;
    }
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return ((AssociatedAccountListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (QLog.isDevelopLevel()) {
      QLog.d("SUB_ACCOUNT_AssocQQ_Adapter", 2, "getView() position=" + paramInt + " viewType=" + i);
    }
    switch (i)
    {
    case 6: 
    default: 
      View localView = paramView;
      if (paramView == null) {
        localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130971616, paramViewGroup, false);
      }
      return localView;
    case 3: 
      return c(paramInt, paramView, paramViewGroup);
    case 5: 
      return b(paramInt, paramView, paramViewGroup);
    case 2: 
      return a(paramInt, paramView, paramViewGroup);
    }
    return a(paramInt, paramView, paramViewGroup, i);
  }
  
  public int getViewTypeCount()
  {
    return 8;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AssociatedAccountListAdapter
 * JD-Core Version:    0.7.0.1
 */