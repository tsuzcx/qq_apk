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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.gamecenter.view.ShadowView;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.subaccount.AssociatedAccountListItemData;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.SubAccountControll.SubAccountUnReadItem;
import com.tencent.mobileqq.subaccount.UpArrowView;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableRelativeLayout;
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
  public ArrayList<AssociatedAccountListItemData> a;
  boolean a;
  private boolean b;
  
  public AssociatedAccountListAdapter(QQAppInterface paramQQAppInterface, ArrayList<AssociatedAccountListItemData> paramArrayList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Boolean = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_b_of_type_Boolean = SimpleUIUtil.a();
  }
  
  private int a(AssociatedAccountListItemData paramAssociatedAccountListItemData)
  {
    if ((paramAssociatedAccountListItemData.jdField_a_of_type_Int != 3) && (paramAssociatedAccountListItemData.jdField_a_of_type_Int != 7)) {}
    label172:
    label174:
    label178:
    for (;;)
    {
      return 0;
      if ((paramAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject instanceof SubAccountMessage)) {
        paramAssociatedAccountListItemData = ((SubAccountMessage)paramAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject).subUin;
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramAssociatedAccountListItemData)) {
          break label178;
        }
        Object localObject = (AssociatedAccountListItemData)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        if ((((AssociatedAccountListItemData)localObject).jdField_a_of_type_Int != 2) || (((AssociatedAccountListItemData)localObject).jdField_a_of_type_JavaLangObject == null) || (!(((AssociatedAccountListItemData)localObject).jdField_a_of_type_JavaLangObject instanceof ArrayList))) {
          break;
        }
        localObject = (ArrayList)((AssociatedAccountListItemData)localObject).jdField_a_of_type_JavaLangObject;
        int i = 0;
        for (;;)
        {
          if (i >= ((ArrayList)localObject).size()) {
            break label172;
          }
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)((AssociatedAccountListItemData)((ArrayList)localObject).get(i)).jdField_a_of_type_JavaLangObject;
          if ((!TextUtils.isEmpty(localSubAccountInfo.subuin)) && (localSubAccountInfo.subuin.equals(paramAssociatedAccountListItemData)))
          {
            return i;
            if (!(paramAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject instanceof SubAccountInfo)) {
              break label174;
            }
            paramAssociatedAccountListItemData = ((SubAccountInfo)paramAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject).subuin;
            break;
          }
          i += 1;
        }
        break;
        paramAssociatedAccountListItemData = "";
      }
    }
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    Object localObject;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131563063, paramViewGroup, false);
      paramViewGroup = new AssociatedAccountListAdapter.SubAccountViewHolder(this);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder = new AssociatedAccountListAdapter.ViewHolder(this);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131379432));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getPaint().setFakeBoldText(true);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131368603));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368618));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380942));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.d = paramView.findViewById(2131368047);
      paramViewGroup.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder = new AssociatedAccountListAdapter.ViewHolder(this);
      paramViewGroup.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131379447));
      paramViewGroup.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getPaint().setFakeBoldText(true);
      paramViewGroup.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131368609));
      paramViewGroup.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368619));
      paramViewGroup.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380943));
      paramViewGroup.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder.d = paramView.findViewById(2131368048);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368631);
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131368632);
      paramViewGroup.c = paramView.findViewById(2131362204);
      ((SingleLineTextView)paramView.findViewById(2131362169)).getPaint().setFakeBoldText(true);
      if ((paramViewGroup.c instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramViewGroup.c).a(true);
      }
      paramViewGroup.c.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setTag(paramViewGroup);
      localObject = (AssociatedAccountListItemData)getItem(paramInt);
      if (localObject != null) {
        break label345;
      }
    }
    for (;;)
    {
      return paramView;
      paramViewGroup = (AssociatedAccountListAdapter.SubAccountViewHolder)paramView.getTag();
      break;
      label345:
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
      while ((paramInt < localArrayList.size()) && (paramInt < 2))
      {
        AssociatedAccountListItemData localAssociatedAccountListItemData = (AssociatedAccountListItemData)localArrayList.get(paramInt);
        AssociatedAccountListAdapter.ViewHolder localViewHolder = paramViewGroup.jdField_a_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder;
        localObject = paramViewGroup.jdField_a_of_type_AndroidViewView;
        if (paramInt == 1)
        {
          localViewHolder = paramViewGroup.jdField_b_of_type_ComTencentMobileqqAdapterAssociatedAccountListAdapter$ViewHolder;
          localObject = paramViewGroup.jdField_b_of_type_AndroidViewView;
        }
        a(localViewHolder, localAssociatedAccountListItemData, (View)localObject);
        paramInt += 1;
        continue;
        paramInt = i;
        if (localArrayList.size() > 1)
        {
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(0);
          paramViewGroup.c.setVisibility(8);
          paramInt = i;
        }
      }
    }
  }
  
  private View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    int i;
    if (paramView == null)
    {
      i = 2131563059;
      if (paramInt2 == 7)
      {
        i = 2131563060;
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
        if ((AppSetting.d) && (!TextUtils.isEmpty(localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString))) {
          paramView.setContentDescription(localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString);
        }
      }
      return paramView;
      if (paramInt2 != 4) {
        break;
      }
      i = 2131563062;
      break;
      paramViewGroup = (AssociatedAccountListAdapter.ViewHolder)paramView.getTag();
    }
  }
  
  private void a(View paramView, AssociatedAccountListItemData paramAssociatedAccountListItemData)
  {
    if ((paramView == null) || (paramAssociatedAccountListItemData == null)) {
      return;
    }
    Object localObject1;
    Object localObject3;
    Object localObject2;
    switch (paramAssociatedAccountListItemData.jdField_b_of_type_Int)
    {
    default: 
      return;
    case 1: 
    case 2: 
      localObject1 = paramView.findViewById(2131365922);
      float f = DeviceInfoUtil.a();
      View localView;
      if (this.jdField_a_of_type_Boolean)
      {
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        localView = paramView.findViewById(2131369439);
        localObject3 = paramView.getLayoutParams();
        if (!paramAssociatedAccountListItemData.jdField_b_of_type_Boolean) {
          break label323;
        }
        localObject2 = paramView.findViewById(2131369420);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = paramView;
        }
        ((View)localObject1).setBackgroundResource(2130839575);
        if (localView != null) {
          localView.setVisibility(0);
        }
        ((ViewGroup.LayoutParams)localObject3).height = ((int)paramView.getResources().getDimension(2131296608));
        localObject1 = (UpArrowView)paramView.findViewById(2131363027);
        localObject2 = (ShadowView)paramView.findViewById(2131363045);
        if (localObject2 != null)
        {
          ((ShadowView)localObject2).setOriginColor(0);
          ((ShadowView)localObject2).setShadowProperties(AIOUtils.a(6.0F, ((ShadowView)localObject2).getResources()), 0.0F, AIOUtils.a(2.0F, ((ShadowView)localObject2).getResources()), Color.parseColor("#B3E0E1E7"));
        }
        if (localObject1 != null)
        {
          if (this.jdField_a_of_type_Boolean) {
            ((UpArrowView)localObject1).setTheme(true);
          }
          b((View)localObject1, paramAssociatedAccountListItemData);
        }
      }
      for (;;)
      {
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        return;
        if (localObject1 == null) {
          break;
        }
        ((View)localObject1).setVisibility(8);
        if (!(((View)localObject1).getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
          break;
        }
        localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
        if (paramAssociatedAccountListItemData.jdField_b_of_type_Int == 1) {}
        for (((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(f * 16.0F + 0.5D));; ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0)
        {
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          break;
        }
        label323:
        paramView.setBackgroundResource(2130839575);
        if (localView != null) {
          localView.setVisibility(8);
        }
        ((ViewGroup.LayoutParams)localObject3).height = ((int)paramView.getResources().getDimension(2131296606));
      }
    }
    if (paramAssociatedAccountListItemData.jdField_b_of_type_Boolean)
    {
      localObject1 = paramView.findViewById(2131369420);
      if (localObject1 != null) {
        break label591;
      }
      localObject1 = paramView;
    }
    label589:
    label591:
    for (;;)
    {
      localObject2 = (UpArrowView)paramView.findViewById(2131363027);
      localObject3 = (ShadowView)paramView.findViewById(2131363045);
      if (localObject3 != null)
      {
        ((ShadowView)localObject3).setOriginColor(0);
        ((ShadowView)localObject3).setShadowProperties(AIOUtils.a(6.0F, ((ShadowView)localObject3).getResources()), 0.0F, AIOUtils.a(2.0F, ((ShadowView)localObject3).getResources()), Color.parseColor("#B3E0E1E7"));
      }
      b((View)localObject2, paramAssociatedAccountListItemData);
      ((View)localObject1).setBackgroundResource(2130839575);
      for (;;)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label589;
        }
        localObject1 = paramView.findViewById(2131365922);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        if (!paramAssociatedAccountListItemData.jdField_b_of_type_Boolean) {
          break;
        }
        localObject1 = (UpArrowView)paramView.findViewById(2131363027);
        paramView = (ShadowView)paramView.findViewById(2131363045);
        if (paramView != null)
        {
          paramView.setOriginColor(0);
          paramView.setShadowProperties(AIOUtils.a(6.0F, paramView.getResources()), 0.0F, AIOUtils.a(2.0F, paramView.getResources()), Color.parseColor("#B3E0E1E7"));
        }
        if (localObject1 != null) {
          ((UpArrowView)localObject1).setTheme(true);
        }
        b((View)localObject1, paramAssociatedAccountListItemData);
        return;
        paramView.setBackgroundResource(2130839575);
      }
      break;
    }
  }
  
  private void a(AssociatedAccountListAdapter.ViewHolder paramViewHolder, AssociatedAccountListItemData paramAssociatedAccountListItemData, View paramView)
  {
    paramViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramAssociatedAccountListItemData.jdField_a_of_type_JavaLangString);
    Object localObject1 = (SubAccountInfo)paramAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject;
    Object localObject2;
    label115:
    int i;
    if (localObject1 != null)
    {
      localObject2 = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, ((SubAccountInfo)localObject1).subuin);
      if (paramAssociatedAccountListItemData.e == 0)
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        paramViewHolder.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable((Drawable)localObject2);
        paramViewHolder.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(((SubAccountInfo)localObject1).subuin);
        localObject1 = SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((SubAccountInfo)localObject1).subuin);
        if (((SubAccountControll.SubAccountUnReadItem)localObject1).jdField_a_of_type_Int <= 0) {
          break label251;
        }
        CustomWidgetUtil.a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 1, ((SubAccountControll.SubAccountUnReadItem)localObject1).jdField_a_of_type_Int, 0, 99, null);
      }
    }
    else
    {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountListItemData = paramAssociatedAccountListItemData;
      if (!paramAssociatedAccountListItemData.jdField_b_of_type_Boolean) {
        break label271;
      }
      paramViewHolder.d.setScaleX(1.0F);
      paramViewHolder.d.setScaleY(1.0F);
      boolean bool = QQTheme.e();
      localObject1 = paramViewHolder.d;
      localObject2 = paramViewHolder.d.getResources();
      if (!bool) {
        break label263;
      }
      i = 2130846463;
      label173:
      ((View)localObject1).setBackgroundDrawable(((Resources)localObject2).getDrawable(i));
    }
    for (;;)
    {
      paramView.setTag(paramViewHolder);
      if ((paramView instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramView).a(true);
      }
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((AppSetting.d) && (!TextUtils.isEmpty(paramAssociatedAccountListItemData.jdField_d_of_type_JavaLangString))) {
        paramView.setContentDescription(paramAssociatedAccountListItemData.jdField_d_of_type_JavaLangString);
      }
      return;
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130850804);
      break;
      label251:
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
      break label115;
      label263:
      i = 2130846462;
      break label173;
      label271:
      paramViewHolder.d.setScaleX(0.93F);
      paramViewHolder.d.setScaleY(0.93F);
      paramViewHolder.d.setBackgroundDrawable(null);
    }
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131563064, paramViewGroup, false);
      paramViewGroup = new AssociatedAccountListAdapter.ViewHolder(this);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131368603));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131379432));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380944));
      if ((paramView instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramView).a(true);
      }
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getPaint().setFakeBoldText(true);
      paramView.setTag(paramViewGroup);
    }
    AssociatedAccountListItemData localAssociatedAccountListItemData;
    for (;;)
    {
      localAssociatedAccountListItemData = (AssociatedAccountListItemData)getItem(paramInt);
      if (localAssociatedAccountListItemData != null) {
        break;
      }
      return paramView;
      paramViewGroup = (AssociatedAccountListAdapter.ViewHolder)paramView.getTag();
    }
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountListItemData = localAssociatedAccountListItemData;
    SimpleAccount localSimpleAccount = (SimpleAccount)localAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject;
    FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localSimpleAccount.getUin());
    paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localAssociatedAccountListItemData.jdField_a_of_type_JavaLangString);
    paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(localSimpleAccount.getUin());
    paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(localFaceDrawable);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
    int j = localAssociatedAccountListItemData.jdField_d_of_type_Int;
    if (j > 0) {
      i = 2130844931;
    }
    for (paramInt = 3;; paramInt = 0)
    {
      CustomWidgetUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, paramInt, j, i, 99, null);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((!AppSetting.d) || (TextUtils.isEmpty(localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString))) {
        break;
      }
      paramView.setContentDescription(localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString);
      return paramView;
    }
  }
  
  private void b(View paramView, AssociatedAccountListItemData paramAssociatedAccountListItemData)
  {
    if ((paramView == null) || (paramAssociatedAccountListItemData == null)) {
      return;
    }
    int i = a(paramAssociatedAccountListItemData);
    paramAssociatedAccountListItemData = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    int j = AIOUtils.a(43.0F, paramView.getResources());
    paramAssociatedAccountListItemData.leftMargin = (i * AIOUtils.a(73.0F, paramView.getResources()) + j - AIOUtils.a(6.0F, paramView.getResources()));
    paramView.setLayoutParams(paramAssociatedAccountListItemData);
  }
  
  private View c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AssociatedAccountListAdapter.ViewHolder localViewHolder;
    AssociatedAccountListItemData localAssociatedAccountListItemData;
    Resources localResources;
    SubAccountMessage localSubAccountMessage;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131563058, paramViewGroup, false);
      localViewHolder = new AssociatedAccountListAdapter.ViewHolder(this);
      localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131379432));
      localViewHolder.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramViewGroup.findViewById(2131368603));
      localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramViewGroup.findViewById(2131380944));
      localViewHolder.b = ((SingleLineTextView)paramViewGroup.findViewById(2131365699));
      paramViewGroup.setTag(localViewHolder);
      localAssociatedAccountListItemData = (AssociatedAccountListItemData)getItem(paramInt);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqSubaccountAssociatedAccountListItemData = localAssociatedAccountListItemData;
      localResources = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources();
      if (localAssociatedAccountListItemData != null)
      {
        localSubAccountMessage = (SubAccountMessage)localAssociatedAccountListItemData.jdField_a_of_type_JavaLangObject;
        paramView = localSubAccountMessage.sendername;
        if (localSubAccountMessage.istroop == 1) {
          paramView = localResources.getString(2131719617);
        }
        if (!TextUtils.isEmpty(paramView)) {
          break label1171;
        }
      }
    }
    label258:
    label267:
    label526:
    label1171:
    for (Object localObject = localSubAccountMessage.senderuin;; localObject = paramView)
    {
      localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject);
      if (((localSubAccountMessage.mEmoRecentMsg == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) && (localSubAccountMessage.msg != null)) {
        localSubAccountMessage.mEmoRecentMsg = new QQText(localSubAccountMessage.msg, 3, 16);
      }
      if (localSubAccountMessage.istroop == 1) {
        if (localSubAccountMessage.unreadNum > 0)
        {
          paramView = localResources.getString(2131719618);
          localViewHolder.b.setText(paramView);
          if ((localSubAccountMessage.mTimeString == null) || (localSubAccountMessage.mEmoRecentMsg == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) {
            localSubAccountMessage.mTimeString = TimeFormatterUtils.a(localSubAccountMessage.time * 1000L, true, SubAccountControll.jdField_a_of_type_JavaLangString);
          }
          if (localSubAccountMessage.istroop != 1) {
            localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(localSubAccountMessage.mTimeString, 0);
          }
          if (!AppConstants.SUBACCOUNT_TROOP_UIN.equals(localSubAccountMessage.senderuin)) {
            break label907;
          }
        }
      }
      try
      {
        paramView = BitmapFactory.decodeResource(localResources, 2130842654);
        if (!this.jdField_b_of_type_Boolean) {
          break label874;
        }
        paramView = QQAppInterface.getShapeRoundFaceBitmap(paramView, 3, 50, 50);
        label380:
        localViewHolder.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(paramView);
      }
      catch (OutOfMemoryError paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT_AssocQQ_Adapter", 2, QLog.getStackTraceString(paramView));
          }
        }
      }
      localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      int n = localSubAccountMessage.unreadNum;
      int i = 0;
      int j = 0;
      if ((n > 0) && (localSubAccountMessage.istroop == 1))
      {
        j = 2130850830;
        i = 1;
        paramView = "";
        paramInt = 0;
      }
      for (;;)
      {
        label441:
        localViewHolder.b.setExtendText(paramView, 1);
        localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramViewGroup);
        CustomWidgetUtil.a(localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, n, j, 99, null);
        StringBuilder localStringBuilder;
        float f;
        if ((AppSetting.d) && (TextUtils.isEmpty(localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString)))
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
          paramView = localResources.getColorStateList(2131167113);
          localObject = localResources.getColorStateList(2131167033);
          i = localResources.getColor(2131167145);
          localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor((ColorStateList)localObject);
          localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
          localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
          localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
          localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
          localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
          localViewHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
          if (paramInt == 0) {
            break label1151;
          }
          localViewHolder.b.setTextColor(i);
        }
        for (;;)
        {
          localViewHolder.b.setExtendTextColor(ColorStateList.valueOf(i), 1);
          localViewHolder.b.setExtendTextPadding((int)(f * 2.0F), 1);
          localViewHolder.b.setExtendTextSize(14.0F, 1);
          a(paramViewGroup, localAssociatedAccountListItemData);
          paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          if ((AppSetting.d) && (!TextUtils.isEmpty(localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString))) {
            paramViewGroup.setContentDescription(localAssociatedAccountListItemData.jdField_d_of_type_JavaLangString);
          }
          if (this.jdField_a_of_type_Boolean)
          {
            paramView = paramViewGroup.findViewById(2131365936);
            if (paramView != null) {
              paramView.setVisibility(8);
            }
          }
          return paramViewGroup;
          localViewHolder = (AssociatedAccountListAdapter.ViewHolder)paramView.getTag();
          paramViewGroup = paramView;
          break;
          paramView = localResources.getString(2131719619);
          break label258;
          localViewHolder.b.setText(localSubAccountMessage.mEmoRecentMsg);
          break label267;
          label874:
          paramView = QQAppInterface.getCircleFaceBitmap(paramView, 50, 50);
          break label380;
          paramView = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localSubAccountMessage.senderuin);
          localViewHolder.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(localSubAccountMessage.senderuin);
          localViewHolder.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(paramView);
          localViewHolder.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setVisibility(0);
          break label389;
          if (n <= 0) {
            break label1163;
          }
          paramInt = 2130850834;
          int k = 3;
          if ((2 == localAssociatedAccountListItemData.c) || (3 == localAssociatedAccountListItemData.c))
          {
            paramView = "[" + localResources.getString(2131717232) + "]";
            m = 0;
            i = k;
            j = paramInt;
            paramInt = m;
            break label441;
          }
          i = k;
          j = paramInt;
          if (!"RED_PACKET".equals(localSubAccountMessage.subExtr)) {
            break label1163;
          }
          paramView = "";
          int m = 1;
          i = k;
          j = paramInt;
          paramInt = m;
          break label441;
          if (localAssociatedAccountListItemData.jdField_d_of_type_Int == 1)
          {
            localStringBuilder.append("有一条未读");
            break label526;
          }
          if (localAssociatedAccountListItemData.jdField_d_of_type_Int == 2)
          {
            localStringBuilder.append("有两条未读");
            break label526;
          }
          if (localAssociatedAccountListItemData.jdField_d_of_type_Int <= 0) {
            break label526;
          }
          localStringBuilder.append("有").append(localAssociatedAccountListItemData.jdField_d_of_type_Int).append("条未读,");
          break label526;
          label1151:
          localViewHolder.b.setTextColor(paramView);
        }
        paramView = "";
        paramInt = 0;
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
    View localView;
    switch (i)
    {
    case 5: 
    default: 
      localView = paramView;
      if (paramView == null) {
        localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131563061, paramViewGroup, false);
      }
      paramView = localView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      localView = c(paramInt, paramView, paramViewGroup);
      continue;
      localView = b(paramInt, paramView, paramViewGroup);
      continue;
      localView = a(paramInt, paramView, paramViewGroup);
      continue;
      localView = a(paramInt, paramView, paramViewGroup, i);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AssociatedAccountListAdapter
 * JD-Core Version:    0.7.0.1
 */