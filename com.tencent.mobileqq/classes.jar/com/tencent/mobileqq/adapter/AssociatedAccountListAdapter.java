package com.tencent.mobileqq.adapter;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.subaccount.AssociatedAccountListItemData;
import com.tencent.mobileqq.subaccount.CustomWidgetUtil;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.UpArrowView;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService.SubAccountUnReadItem;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountControlServiceImpl;
import com.tencent.mobileqq.subaccount.view.ShadowView;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class AssociatedAccountListAdapter
  extends BaseAdapter
{
  public LayoutInflater a;
  public View.OnClickListener a;
  public AppInterface a;
  public ArrayList<AssociatedAccountListItemData> a;
  boolean a;
  private boolean b;
  
  public AssociatedAccountListAdapter(AppInterface paramAppInterface, ArrayList<AssociatedAccountListItemData> paramArrayList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication());
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Boolean = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_b_of_type_Boolean = SimpleUIUtil.a();
  }
  
  private int a(AssociatedAccountListItemData paramAssociatedAccountListItemData)
  {
    if ((paramAssociatedAccountListItemData.jdField_a_of_type_Int != 3) && (paramAssociatedAccountListItemData.jdField_a_of_type_Int != 7)) {
      return 0;
    }
    if ((paramAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject instanceof SubAccountMessage)) {
      paramAssociatedAccountListItemData = ((SubAccountMessage)paramAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject).subUin;
    } else if ((paramAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject instanceof SubAccountInfo)) {
      paramAssociatedAccountListItemData = ((SubAccountInfo)paramAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject).subuin;
    } else {
      paramAssociatedAccountListItemData = "";
    }
    if (TextUtils.isEmpty(paramAssociatedAccountListItemData)) {
      return 0;
    }
    Object localObject = (AssociatedAccountListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    if ((((AssociatedAccountListItemData)localObject).jdField_a_of_type_Int == 2) && (((AssociatedAccountListItemData)localObject).jdField_a_of_type_JavaLangObject != null) && ((((AssociatedAccountListItemData)localObject).jdField_a_of_type_JavaLangObject instanceof ArrayList)))
    {
      localObject = (ArrayList)((AssociatedAccountListItemData)localObject).jdField_a_of_type_JavaLangObject;
      int i = 0;
      while (i < ((ArrayList)localObject).size())
      {
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)((AssociatedAccountListItemData)((ArrayList)localObject).get(i)).jdField_a_of_type_JavaLangObject;
        if ((!TextUtils.isEmpty(localSubAccountInfo.subuin)) && (localSubAccountInfo.subuin.equals(paramAssociatedAccountListItemData))) {
          return i;
        }
        i += 1;
      }
    }
    return 0;
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562887, paramViewGroup, false);
      paramViewGroup = new AssociatedAccountListAdapter.SubAccountViewHolder(this);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder = new AssociatedAccountListAdapter.ViewHolder(this);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131378784));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getPaint().setFakeBoldText(true);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131368343));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368357));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380208));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.d = paramView.findViewById(2131367800);
      paramViewGroup.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder = new AssociatedAccountListAdapter.ViewHolder(this);
      paramViewGroup.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131378799));
      paramViewGroup.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getPaint().setFakeBoldText(true);
      paramViewGroup.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131368348));
      paramViewGroup.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368358));
      paramViewGroup.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380209));
      paramViewGroup.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.d = paramView.findViewById(2131367801);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368368);
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131368369);
      paramViewGroup.c = paramView.findViewById(2131362229);
      ((SingleLineTextView)paramView.findViewById(2131362195)).getPaint().setFakeBoldText(true);
      if ((paramViewGroup.c instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramViewGroup.c).enableAlphaClick(true);
      }
      paramViewGroup.c.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (AssociatedAccountListAdapter.SubAccountViewHolder)paramView.getTag();
    }
    Object localObject = (AssociatedAccountListItemData)getItem(paramInt);
    if (localObject == null) {
      return paramView;
    }
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountListItemData = ((AssociatedAccountListItemData)localObject);
    a(paramView, (AssociatedAccountListItemData)localObject);
    ArrayList localArrayList = (ArrayList)((AssociatedAccountListItemData)localObject).jdField_a_of_type_JavaLangObject;
    if (localArrayList.size() == 1)
    {
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramViewGroup.c.setVisibility(0);
      paramInt = i;
    }
    else
    {
      paramInt = i;
      if (localArrayList.size() > 1)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup.c.setVisibility(8);
        paramInt = i;
      }
    }
    while ((paramInt < localArrayList.size()) && (paramInt < 2))
    {
      AssociatedAccountListItemData localAssociatedAccountListItemData = (AssociatedAccountListItemData)localArrayList.get(paramInt);
      localObject = paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder;
      View localView = paramViewGroup.jdField_a_of_type_AndroidViewView;
      if (paramInt == 1)
      {
        localObject = paramViewGroup.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder;
        localView = paramViewGroup.jdField_b_of_type_AndroidViewView;
      }
      a((AssociatedAccountListAdapter.ViewHolder)localObject, localAssociatedAccountListItemData, localView);
      paramInt += 1;
    }
    return paramView;
  }
  
  private View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    if (paramView == null)
    {
      int i = 2131562883;
      if (paramInt2 == 7) {
        i = 2131562884;
      } else if (paramInt2 == 4) {
        i = 2131562886;
      }
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(i, paramViewGroup, false);
      paramViewGroup = new AssociatedAccountListAdapter.ViewHolder(this);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (AssociatedAccountListAdapter.ViewHolder)paramView.getTag();
    }
    AssociatedAccountListItemData localAssociatedAccountListItemData = (AssociatedAccountListItemData)getItem(paramInt1);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountListItemData = localAssociatedAccountListItemData;
    if (localAssociatedAccountListItemData != null)
    {
      a(paramView, localAssociatedAccountListItemData);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((AppSetting.d) && (!TextUtils.isEmpty(localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString))) {
        paramView.setContentDescription(localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString);
      }
    }
    return paramView;
  }
  
  private void a(View paramView, AssociatedAccountListItemData paramAssociatedAccountListItemData)
  {
    if (paramView != null)
    {
      if (paramAssociatedAccountListItemData == null) {
        return;
      }
      int i = paramAssociatedAccountListItemData.jdField_b_of_type_Int;
      Object localObject2;
      Object localObject1;
      Object localObject3;
      if ((i != 1) && (i != 2))
      {
        if (i != 3) {
          return;
        }
        if (paramAssociatedAccountListItemData.jdField_b_of_type_Boolean)
        {
          localObject2 = paramView.findViewById(2131369148);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = paramView;
          }
          localObject2 = (UpArrowView)paramView.findViewById(2131362975);
          localObject3 = (ShadowView)paramView.findViewById(2131362992);
          if (localObject3 != null)
          {
            ((ShadowView)localObject3).setOriginColor(0);
            ((ShadowView)localObject3).setShadowProperties(ViewUtils.a(6.0F), 0.0F, ViewUtils.a(2.0F), Color.parseColor("#B3E0E1E7"));
          }
          b((View)localObject2, paramAssociatedAccountListItemData);
          ((View)localObject1).setBackgroundResource(2130839433);
        }
        else
        {
          paramView.setBackgroundResource(2130839433);
        }
        if (this.jdField_a_of_type_Boolean)
        {
          localObject1 = paramView.findViewById(2131365759);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
          if (paramAssociatedAccountListItemData.jdField_b_of_type_Boolean)
          {
            localObject1 = (UpArrowView)paramView.findViewById(2131362975);
            paramView = (ShadowView)paramView.findViewById(2131362992);
            if (paramView != null)
            {
              paramView.setOriginColor(0);
              paramView.setShadowProperties(ViewUtils.a(6.0F), 0.0F, ViewUtils.a(2.0F), Color.parseColor("#B3E0E1E7"));
            }
            if (localObject1 != null) {
              ((UpArrowView)localObject1).setTheme(true);
            }
            b((View)localObject1, paramAssociatedAccountListItemData);
          }
        }
      }
      else
      {
        localObject1 = paramView.findViewById(2131365759);
        float f = DeviceInfoUtil.a();
        if (this.jdField_a_of_type_Boolean)
        {
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
        }
        else if (localObject1 != null)
        {
          ((View)localObject1).setVisibility(8);
          if ((((View)localObject1).getLayoutParams() instanceof RelativeLayout.LayoutParams))
          {
            localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
            if (paramAssociatedAccountListItemData.jdField_b_of_type_Int == 1)
            {
              double d = f * 16.0F;
              Double.isNaN(d);
              ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(d + 0.5D));
            }
            else
            {
              ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
            }
            ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
        View localView = paramView.findViewById(2131369167);
        localObject3 = paramView.getLayoutParams();
        if (paramAssociatedAccountListItemData.jdField_b_of_type_Boolean)
        {
          localObject2 = paramView.findViewById(2131369148);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = paramView;
          }
          ((View)localObject1).setBackgroundResource(2130839433);
          if (localView != null) {
            localView.setVisibility(0);
          }
          ((ViewGroup.LayoutParams)localObject3).height = ((int)paramView.getResources().getDimension(2131296587));
          localObject1 = (UpArrowView)paramView.findViewById(2131362975);
          localObject2 = (ShadowView)paramView.findViewById(2131362992);
          if (localObject2 != null)
          {
            ((ShadowView)localObject2).setOriginColor(0);
            ((ShadowView)localObject2).setShadowProperties(ViewUtils.a(6.0F), 0.0F, ViewUtils.a(2.0F), Color.parseColor("#B3E0E1E7"));
          }
          if (localObject1 != null)
          {
            if (this.jdField_a_of_type_Boolean) {
              ((UpArrowView)localObject1).setTheme(true);
            }
            b((View)localObject1, paramAssociatedAccountListItemData);
          }
        }
        else
        {
          paramView.setBackgroundResource(2130839433);
          if (localView != null) {
            localView.setVisibility(8);
          }
          ((ViewGroup.LayoutParams)localObject3).height = ((int)paramView.getResources().getDimension(2131296585));
        }
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      }
    }
  }
  
  private void a(AssociatedAccountListAdapter.ViewHolder paramViewHolder, AssociatedAccountListItemData paramAssociatedAccountListItemData, View paramView)
  {
    paramViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramAssociatedAccountListItemData.jdField_a_of_type_JavaLangString);
    Object localObject1 = (SubAccountInfo)paramAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 1, ((SubAccountInfo)localObject1).subuin);
      if (paramAssociatedAccountListItemData.e == 0) {
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      } else {
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130850730);
      }
      paramViewHolder.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable((Drawable)localObject2);
      paramViewHolder.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(((SubAccountInfo)localObject1).subuin);
      localObject1 = SubAccountControllUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((SubAccountInfo)localObject1).subuin);
      if (((ISubAccountControlService.SubAccountUnReadItem)localObject1).jdField_a_of_type_Int > 0) {
        CustomWidgetUtil.a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 1, ((ISubAccountControlService.SubAccountUnReadItem)localObject1).jdField_a_of_type_Int, 0, 99, null);
      } else {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
      }
    }
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountListItemData = paramAssociatedAccountListItemData;
    if (paramAssociatedAccountListItemData.jdField_b_of_type_Boolean)
    {
      paramViewHolder.d.setScaleX(1.0F);
      paramViewHolder.d.setScaleY(1.0F);
      boolean bool = QQTheme.f();
      localObject1 = paramViewHolder.d;
      localObject2 = paramViewHolder.d.getResources();
      int i;
      if (bool) {
        i = 2130846343;
      } else {
        i = 2130846342;
      }
      ((View)localObject1).setBackgroundDrawable(((Resources)localObject2).getDrawable(i));
    }
    else
    {
      paramViewHolder.d.setScaleX(0.93F);
      paramViewHolder.d.setScaleY(0.93F);
      paramViewHolder.d.setBackgroundDrawable(null);
    }
    paramView.setTag(paramViewHolder);
    if ((paramView instanceof AlphaClickableRelativeLayout)) {
      ((AlphaClickableRelativeLayout)paramView).enableAlphaClick(true);
    }
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if ((AppSetting.d) && (!TextUtils.isEmpty(paramAssociatedAccountListItemData.jdField_d_of_type_JavaLangString))) {
      paramView.setContentDescription(paramAssociatedAccountListItemData.jdField_d_of_type_JavaLangString);
    }
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562888, paramViewGroup, false);
      paramViewGroup = new AssociatedAccountListAdapter.ViewHolder(this);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131368343));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131378784));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380210));
      if ((paramView instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramView).enableAlphaClick(true);
      }
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getPaint().setFakeBoldText(true);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (AssociatedAccountListAdapter.ViewHolder)paramView.getTag();
    }
    AssociatedAccountListItemData localAssociatedAccountListItemData = (AssociatedAccountListItemData)getItem(paramInt);
    if (localAssociatedAccountListItemData == null) {
      return paramView;
    }
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountListItemData = localAssociatedAccountListItemData;
    SimpleAccount localSimpleAccount = (SimpleAccount)localAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject;
    FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 1, localSimpleAccount.getUin());
    paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localAssociatedAccountListItemData.jdField_a_of_type_JavaLangString);
    paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(localSimpleAccount.getUin());
    paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(localFaceDrawable);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
    int j = localAssociatedAccountListItemData.jdField_d_of_type_Int;
    int i;
    if (j > 0)
    {
      paramInt = 3;
      i = 2130844807;
    }
    else
    {
      paramInt = 0;
      i = 0;
    }
    CustomWidgetUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, paramInt, j, i, 99, null);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if ((AppSetting.d) && (!TextUtils.isEmpty(localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString))) {
      paramView.setContentDescription(localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString);
    }
    return paramView;
  }
  
  private void b(View paramView, AssociatedAccountListItemData paramAssociatedAccountListItemData)
  {
    if (paramView != null)
    {
      if (paramAssociatedAccountListItemData == null) {
        return;
      }
      int i = a(paramAssociatedAccountListItemData);
      paramAssociatedAccountListItemData = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      paramAssociatedAccountListItemData.leftMargin = (ViewUtils.a(43.0F) + ViewUtils.a(73.0F) * i - ViewUtils.a(6.0F));
      paramView.setLayoutParams(paramAssociatedAccountListItemData);
    }
  }
  
  private View c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    AssociatedAccountListAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562882, paramViewGroup, false);
      localViewHolder = new AssociatedAccountListAdapter.ViewHolder(this);
      localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131378784));
      localViewHolder.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)localView.findViewById(2131368343));
      localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131380210));
      localViewHolder.b = ((SingleLineTextView)localView.findViewById(2131365536));
      localView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (AssociatedAccountListAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
    }
    AssociatedAccountListItemData localAssociatedAccountListItemData = (AssociatedAccountListItemData)getItem(paramInt);
    localViewHolder.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountListItemData = localAssociatedAccountListItemData;
    Resources localResources = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getResources();
    if (localAssociatedAccountListItemData != null)
    {
      SubAccountMessage localSubAccountMessage = (SubAccountMessage)localAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject;
      paramView = localSubAccountMessage.sendername;
      if (localSubAccountMessage.istroop == 1) {
        paramView = localResources.getString(2131719336);
      }
      Object localObject = paramView;
      if (TextUtils.isEmpty(paramView)) {
        localObject = localSubAccountMessage.senderuin;
      }
      localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject);
      if (((localSubAccountMessage.mEmoRecentMsg == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) && (localSubAccountMessage.msg != null)) {
        localSubAccountMessage.mEmoRecentMsg = new QQText(localSubAccountMessage.msg, 3, 16);
      }
      if (localSubAccountMessage.istroop == 1)
      {
        if (localSubAccountMessage.unreadNum > 0) {
          i = 2131719337;
        } else {
          i = 2131719338;
        }
        paramView = localResources.getString(i);
        localViewHolder.b.setText(paramView);
      }
      else
      {
        localViewHolder.b.setText(localSubAccountMessage.mEmoRecentMsg);
      }
      if ((localSubAccountMessage.mTimeString == null) || (localSubAccountMessage.mEmoRecentMsg == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) {
        localSubAccountMessage.mTimeString = TimeFormatterUtils.a(localSubAccountMessage.time * 1000L, true, SubAccountControlServiceImpl.DateFormate);
      }
      if (localSubAccountMessage.istroop != 1) {
        localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(localSubAccountMessage.mTimeString, 0);
      }
      if (AppConstants.SUBACCOUNT_TROOP_UIN.equals(localSubAccountMessage.senderuin))
      {
        try
        {
          paramView = BitmapFactory.decodeResource(localResources, 2130842553);
          if (this.jdField_b_of_type_Boolean) {
            paramView = ((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).getShapeRoundFaceBitmap(paramView, 3, 50, 50);
          } else {
            paramView = BaseImageUtil.a(paramView, 50, 50);
          }
          localViewHolder.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(paramView);
        }
        catch (OutOfMemoryError paramView)
        {
          if (!QLog.isColorLevel()) {
            break label533;
          }
        }
        QLog.d("SUB_ACCOUNT_AssocQQ_Adapter", 2, QLog.getStackTraceString(paramView));
      }
      else
      {
        paramView = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 1, localSubAccountMessage.senderuin);
        localViewHolder.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(localSubAccountMessage.senderuin);
        localViewHolder.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(paramView);
        localViewHolder.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setVisibility(0);
      }
      label533:
      localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      int k = localSubAccountMessage.unreadNum;
      paramView = "";
      int j;
      if ((k > 0) && (localSubAccountMessage.istroop == 1))
      {
        paramInt = 0;
        i = 1;
        j = 2130850766;
      }
      else if (k > 0)
      {
        if ((2 != localAssociatedAccountListItemData.c) && (3 != localAssociatedAccountListItemData.c))
        {
          paramViewGroup = paramView;
          if ("RED_PACKET".equals(localSubAccountMessage.subExtr))
          {
            paramInt = 1;
            break label675;
          }
        }
        else
        {
          paramView = new StringBuilder();
          paramView.append("[");
          paramView.append(localResources.getString(2131716891));
          paramView.append("]");
          paramViewGroup = paramView.toString();
        }
        paramInt = 0;
        paramView = paramViewGroup;
        label675:
        i = 3;
        j = 2130850770;
      }
      else
      {
        paramInt = 0;
        i = 0;
        j = 0;
      }
      localViewHolder.b.setExtendText(paramView, 1);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, localView);
      CustomWidgetUtil.a(localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, k, j, 99, null);
      if ((AppSetting.d) && (TextUtils.isEmpty(localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString)))
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append((String)localObject);
        paramViewGroup.append(",");
        if (localAssociatedAccountListItemData.jdField_d_of_type_Int != 0) {
          if (localAssociatedAccountListItemData.jdField_d_of_type_Int == 1)
          {
            paramViewGroup.append("有一条未读");
          }
          else if (localAssociatedAccountListItemData.jdField_d_of_type_Int == 2)
          {
            paramViewGroup.append("有两条未读");
          }
          else if (localAssociatedAccountListItemData.jdField_d_of_type_Int > 0)
          {
            paramViewGroup.append("有");
            paramViewGroup.append(localAssociatedAccountListItemData.jdField_d_of_type_Int);
            paramViewGroup.append("条未读,");
          }
        }
        if (paramView != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramView);
          ((StringBuilder)localObject).append(",");
          paramViewGroup.append(((StringBuilder)localObject).toString());
        }
        paramViewGroup.append(localSubAccountMessage.mEmoRecentMsg);
        paramViewGroup.append(",");
        paramViewGroup.append(localSubAccountMessage.mTimeString);
        localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString = paramViewGroup.toString();
      }
      float f = DeviceInfoUtil.a();
      paramView = localResources.getColorStateList(2131167138);
      paramViewGroup = localResources.getColorStateList(2131167056);
      int i = localResources.getColor(2131167170);
      localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramViewGroup);
      localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
      localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
      localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
      localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
      localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
      if (paramInt != 0) {
        localViewHolder.b.setTextColor(i);
      } else {
        localViewHolder.b.setTextColor(paramView);
      }
      localViewHolder.b.setExtendTextColor(ColorStateList.valueOf(i), 1);
      localViewHolder.b.setExtendTextPadding((int)(f * 2.0F), 1);
      localViewHolder.b.setExtendTextSize(14.0F, 1);
      a(localView, localAssociatedAccountListItemData);
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((AppSetting.d) && (!TextUtils.isEmpty(localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString))) {
        localView.setContentDescription(localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        paramView = localView.findViewById(2131365773);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
      }
    }
    return localView;
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      return localArrayList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (paramInt >= 0) && (paramInt < localArrayList.size())) {
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
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (paramInt >= 0) && (paramInt < localArrayList.size())) {
      return ((AssociatedAccountListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getView() position=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" viewType=");
      ((StringBuilder)localObject).append(i);
      QLog.d("SUB_ACCOUNT_AssocQQ_Adapter", 2, ((StringBuilder)localObject).toString());
    }
    if (i != 1) {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            if (i != 6)
            {
              if (i != 7)
              {
                localObject = paramView;
                if (paramView == null) {
                  localObject = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562885, paramViewGroup, false);
                }
                paramView = (View)localObject;
                break label179;
              }
            }
            else
            {
              localObject = b(paramInt, paramView, paramViewGroup);
              break label179;
            }
          }
        }
        else
        {
          localObject = c(paramInt, paramView, paramViewGroup);
          break label179;
        }
      }
      else
      {
        localObject = a(paramInt, paramView, paramViewGroup);
        break label179;
      }
    }
    Object localObject = a(paramInt, paramView, paramViewGroup, i);
    label179:
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AssociatedAccountListAdapter
 * JD-Core Version:    0.7.0.1
 */