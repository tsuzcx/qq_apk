package com.tencent.mobileqq.adapter;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
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
  public AppInterface b;
  public ArrayList<AssociatedAccountListItemData> c;
  public View.OnClickListener d;
  boolean e;
  private boolean f;
  
  public AssociatedAccountListAdapter(AppInterface paramAppInterface, ArrayList<AssociatedAccountListItemData> paramArrayList, View.OnClickListener paramOnClickListener)
  {
    this.b = paramAppInterface;
    this.c = paramArrayList;
    this.a = LayoutInflater.from(this.b.getApplication());
    this.d = paramOnClickListener;
    this.e = ThemeUtil.isInNightMode(this.b);
    this.f = SimpleUIUtil.e();
  }
  
  private int a(AssociatedAccountListItemData paramAssociatedAccountListItemData)
  {
    if ((paramAssociatedAccountListItemData.a != 3) && (paramAssociatedAccountListItemData.a != 7)) {
      return 0;
    }
    if ((paramAssociatedAccountListItemData.l instanceof SubAccountMessage)) {
      paramAssociatedAccountListItemData = ((SubAccountMessage)paramAssociatedAccountListItemData.l).subUin;
    } else if ((paramAssociatedAccountListItemData.l instanceof SubAccountInfo)) {
      paramAssociatedAccountListItemData = ((SubAccountInfo)paramAssociatedAccountListItemData.l).subuin;
    } else {
      paramAssociatedAccountListItemData = "";
    }
    if (TextUtils.isEmpty(paramAssociatedAccountListItemData)) {
      return 0;
    }
    Object localObject = (AssociatedAccountListItemData)this.c.get(0);
    if ((((AssociatedAccountListItemData)localObject).a == 2) && (((AssociatedAccountListItemData)localObject).l != null) && ((((AssociatedAccountListItemData)localObject).l instanceof ArrayList)))
    {
      localObject = (ArrayList)((AssociatedAccountListItemData)localObject).l;
      int i = 0;
      while (i < ((ArrayList)localObject).size())
      {
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)((AssociatedAccountListItemData)((ArrayList)localObject).get(i)).l;
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
      paramView = this.a.inflate(2131629339, paramViewGroup, false);
      paramViewGroup = new AssociatedAccountListAdapter.SubAccountViewHolder(this);
      paramViewGroup.a = new AssociatedAccountListAdapter.ViewHolder(this);
      paramViewGroup.a.h = ((SingleLineTextView)paramView.findViewById(2131447463));
      paramViewGroup.a.h.getPaint().setFakeBoldText(true);
      paramViewGroup.a.g = ((FixSizeImageView)paramView.findViewById(2131435219));
      paramViewGroup.a.k = ((ImageView)paramView.findViewById(2131435235));
      paramViewGroup.a.j = ((DragTextView)paramView.findViewById(2131449126));
      paramViewGroup.a.l = paramView.findViewById(2131434373);
      paramViewGroup.b = new AssociatedAccountListAdapter.ViewHolder(this);
      paramViewGroup.b.h = ((SingleLineTextView)paramView.findViewById(2131447480));
      paramViewGroup.b.h.getPaint().setFakeBoldText(true);
      paramViewGroup.b.g = ((FixSizeImageView)paramView.findViewById(2131435225));
      paramViewGroup.b.k = ((ImageView)paramView.findViewById(2131435236));
      paramViewGroup.b.j = ((DragTextView)paramView.findViewById(2131449127));
      paramViewGroup.b.l = paramView.findViewById(2131434374);
      paramViewGroup.c = paramView.findViewById(2131435248);
      paramViewGroup.d = paramView.findViewById(2131435249);
      paramViewGroup.e = paramView.findViewById(2131427810);
      ((SingleLineTextView)paramView.findViewById(2131427778)).getPaint().setFakeBoldText(true);
      if ((paramViewGroup.e instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramViewGroup.e).enableAlphaClick(true);
      }
      paramViewGroup.e.setOnClickListener(this.d);
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
    paramViewGroup.m = ((AssociatedAccountListItemData)localObject);
    a(paramView, (AssociatedAccountListItemData)localObject);
    ArrayList localArrayList = (ArrayList)((AssociatedAccountListItemData)localObject).l;
    if (localArrayList.size() == 1)
    {
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.d.setVisibility(8);
      paramViewGroup.e.setVisibility(0);
      paramInt = i;
    }
    else
    {
      paramInt = i;
      if (localArrayList.size() > 1)
      {
        paramViewGroup.c.setVisibility(0);
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.e.setVisibility(8);
        paramInt = i;
      }
    }
    while ((paramInt < localArrayList.size()) && (paramInt < 2))
    {
      AssociatedAccountListItemData localAssociatedAccountListItemData = (AssociatedAccountListItemData)localArrayList.get(paramInt);
      localObject = paramViewGroup.a;
      View localView = paramViewGroup.c;
      if (paramInt == 1)
      {
        localObject = paramViewGroup.b;
        localView = paramViewGroup.d;
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
      int i = 2131629335;
      if (paramInt2 == 7) {
        i = 2131629336;
      } else if (paramInt2 == 4) {
        i = 2131629338;
      }
      paramView = this.a.inflate(i, paramViewGroup, false);
      paramViewGroup = new AssociatedAccountListAdapter.ViewHolder(this);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (AssociatedAccountListAdapter.ViewHolder)paramView.getTag();
    }
    AssociatedAccountListItemData localAssociatedAccountListItemData = (AssociatedAccountListItemData)getItem(paramInt1);
    paramViewGroup.m = localAssociatedAccountListItemData;
    if (localAssociatedAccountListItemData != null)
    {
      a(paramView, localAssociatedAccountListItemData);
      paramView.setOnClickListener(this.d);
      if ((AppSetting.e) && (!TextUtils.isEmpty(localAssociatedAccountListItemData.h))) {
        paramView.setContentDescription(localAssociatedAccountListItemData.h);
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
      int i = paramAssociatedAccountListItemData.d;
      Object localObject2;
      Object localObject1;
      Object localObject3;
      if ((i != 1) && (i != 2))
      {
        if (i != 3) {
          return;
        }
        if (paramAssociatedAccountListItemData.k)
        {
          localObject2 = paramView.findViewById(2131436119);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = paramView;
          }
          localObject2 = (UpArrowView)paramView.findViewById(2131428774);
          localObject3 = (ShadowView)paramView.findViewById(2131428793);
          if (localObject3 != null)
          {
            ((ShadowView)localObject3).setOriginColor(0);
            ((ShadowView)localObject3).setShadowProperties(ViewUtils.dip2px(6.0F), 0.0F, ViewUtils.dip2px(2.0F), Color.parseColor("#B3E0E1E7"));
          }
          b((View)localObject2, paramAssociatedAccountListItemData);
          ((View)localObject1).setBackgroundResource(2130839622);
        }
        else
        {
          paramView.setBackgroundResource(2130839622);
        }
        if (this.e)
        {
          localObject1 = paramView.findViewById(2131432003);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
          if (paramAssociatedAccountListItemData.k)
          {
            localObject1 = (UpArrowView)paramView.findViewById(2131428774);
            paramView = (ShadowView)paramView.findViewById(2131428793);
            if (paramView != null)
            {
              paramView.setOriginColor(0);
              paramView.setShadowProperties(ViewUtils.dip2px(6.0F), 0.0F, ViewUtils.dip2px(2.0F), Color.parseColor("#B3E0E1E7"));
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
        localObject1 = paramView.findViewById(2131432003);
        float f1 = DeviceInfoUtil.A();
        if (this.e)
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
            if (paramAssociatedAccountListItemData.d == 1)
            {
              double d1 = f1 * 16.0F;
              Double.isNaN(d1);
              ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(d1 + 0.5D));
            }
            else
            {
              ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
            }
            ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
        }
        View localView = paramView.findViewById(2131436140);
        localObject3 = paramView.getLayoutParams();
        if (paramAssociatedAccountListItemData.k)
        {
          localObject2 = paramView.findViewById(2131436119);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = paramView;
          }
          ((View)localObject1).setBackgroundResource(2130839622);
          if (localView != null) {
            localView.setVisibility(0);
          }
          ((ViewGroup.LayoutParams)localObject3).height = ((int)paramView.getResources().getDimension(2131296883));
          localObject1 = (UpArrowView)paramView.findViewById(2131428774);
          localObject2 = (ShadowView)paramView.findViewById(2131428793);
          if (localObject2 != null)
          {
            ((ShadowView)localObject2).setOriginColor(0);
            ((ShadowView)localObject2).setShadowProperties(ViewUtils.dip2px(6.0F), 0.0F, ViewUtils.dip2px(2.0F), Color.parseColor("#B3E0E1E7"));
          }
          if (localObject1 != null)
          {
            if (this.e) {
              ((UpArrowView)localObject1).setTheme(true);
            }
            b((View)localObject1, paramAssociatedAccountListItemData);
          }
        }
        else
        {
          paramView.setBackgroundResource(2130839622);
          if (localView != null) {
            localView.setVisibility(8);
          }
          ((ViewGroup.LayoutParams)localObject3).height = ((int)paramView.getResources().getDimension(2131296881));
        }
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      }
    }
  }
  
  private void a(AssociatedAccountListAdapter.ViewHolder paramViewHolder, AssociatedAccountListItemData paramAssociatedAccountListItemData, View paramView)
  {
    paramViewHolder.h.setText(paramAssociatedAccountListItemData.b);
    Object localObject = (SubAccountInfo)paramAssociatedAccountListItemData.l;
    if (localObject != null)
    {
      FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.b, 1, ((SubAccountInfo)localObject).subuin);
      if (paramAssociatedAccountListItemData.j == 0) {
        paramViewHolder.k.setBackgroundDrawable(null);
      } else {
        paramViewHolder.k.setBackgroundResource(2130852534);
      }
      paramViewHolder.g.setImageDrawable(localFaceDrawable);
      paramViewHolder.g.setTag(((SubAccountInfo)localObject).subuin);
      localObject = SubAccountControllUtil.k(this.b, ((SubAccountInfo)localObject).subuin);
      if (((ISubAccountControlService.SubAccountUnReadItem)localObject).a > 0) {
        CustomWidgetUtil.a(paramViewHolder.j, 1, ((ISubAccountControlService.SubAccountUnReadItem)localObject).a, 0, 99, null);
      } else {
        paramViewHolder.j.setVisibility(8);
      }
    }
    paramViewHolder.m = paramAssociatedAccountListItemData;
    if (paramAssociatedAccountListItemData.k)
    {
      paramViewHolder.l.setScaleX(1.0F);
      paramViewHolder.l.setScaleY(1.0F);
      paramViewHolder.l.setBackgroundDrawable(paramViewHolder.l.getResources().getDrawable(2130847815));
    }
    else
    {
      paramViewHolder.l.setScaleX(0.93F);
      paramViewHolder.l.setScaleY(0.93F);
      paramViewHolder.l.setBackgroundDrawable(null);
    }
    paramView.setTag(paramViewHolder);
    if ((paramView instanceof AlphaClickableRelativeLayout)) {
      ((AlphaClickableRelativeLayout)paramView).enableAlphaClick(true);
    }
    paramView.setOnClickListener(this.d);
    if ((AppSetting.e) && (!TextUtils.isEmpty(paramAssociatedAccountListItemData.h))) {
      paramView.setContentDescription(paramAssociatedAccountListItemData.h);
    }
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.a.inflate(2131629340, paramViewGroup, false);
      paramViewGroup = new AssociatedAccountListAdapter.ViewHolder(this);
      paramViewGroup.g = ((FixSizeImageView)paramView.findViewById(2131435219));
      paramViewGroup.h = ((SingleLineTextView)paramView.findViewById(2131447463));
      paramViewGroup.j = ((DragTextView)paramView.findViewById(2131449128));
      if ((paramView instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramView).enableAlphaClick(true);
      }
      paramViewGroup.h.getPaint().setFakeBoldText(true);
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
    paramViewGroup.m = localAssociatedAccountListItemData;
    SimpleAccount localSimpleAccount = (SimpleAccount)localAssociatedAccountListItemData.l;
    FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.b, 1, localSimpleAccount.getUin());
    paramViewGroup.h.setText(localAssociatedAccountListItemData.b);
    paramViewGroup.g.setTag(localSimpleAccount.getUin());
    paramViewGroup.g.setImageDrawable(localFaceDrawable);
    paramViewGroup.j.setDragViewType(1, paramView);
    int j = localAssociatedAccountListItemData.g;
    int i;
    if (j > 0)
    {
      paramInt = 3;
      i = 2130846241;
    }
    else
    {
      paramInt = 0;
      i = 0;
    }
    CustomWidgetUtil.a(paramViewGroup.j, paramInt, j, i, 99, null);
    paramView.setOnClickListener(this.d);
    if ((AppSetting.e) && (!TextUtils.isEmpty(localAssociatedAccountListItemData.h))) {
      paramView.setContentDescription(localAssociatedAccountListItemData.h);
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
      paramAssociatedAccountListItemData.leftMargin = (ViewUtils.dip2px(43.0F) + ViewUtils.dip2px(73.0F) * i - ViewUtils.dip2px(6.0F));
      paramView.setLayoutParams(paramAssociatedAccountListItemData);
    }
  }
  
  private View c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    AssociatedAccountListAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localView = this.a.inflate(2131629334, paramViewGroup, false);
      localViewHolder = new AssociatedAccountListAdapter.ViewHolder(this);
      localViewHolder.h = ((SingleLineTextView)localView.findViewById(2131447463));
      localViewHolder.g = ((FixSizeImageView)localView.findViewById(2131435219));
      localViewHolder.j = ((DragTextView)localView.findViewById(2131449128));
      localViewHolder.i = ((SingleLineTextView)localView.findViewById(2131431757));
      localView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (AssociatedAccountListAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
    }
    AssociatedAccountListItemData localAssociatedAccountListItemData = (AssociatedAccountListItemData)getItem(paramInt);
    localViewHolder.m = localAssociatedAccountListItemData;
    Resources localResources = this.b.getApplication().getResources();
    if (localAssociatedAccountListItemData != null)
    {
      SubAccountMessage localSubAccountMessage = (SubAccountMessage)localAssociatedAccountListItemData.l;
      paramView = localSubAccountMessage.sendername;
      if (localSubAccountMessage.istroop == 1) {
        paramView = localResources.getString(2131916888);
      }
      Object localObject = paramView;
      if (TextUtils.isEmpty(paramView)) {
        localObject = localSubAccountMessage.senderuin;
      }
      localViewHolder.h.setText((CharSequence)localObject);
      if (((localSubAccountMessage.mEmoRecentMsg == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) && (localSubAccountMessage.msg != null)) {
        localSubAccountMessage.mEmoRecentMsg = new QQText(localSubAccountMessage.msg, 3, 16);
      }
      if (localSubAccountMessage.istroop == 1)
      {
        if (localSubAccountMessage.unreadNum > 0) {
          i = 2131916889;
        } else {
          i = 2131916890;
        }
        paramView = localResources.getString(i);
        localViewHolder.i.setText(paramView);
      }
      else
      {
        localViewHolder.i.setText(localSubAccountMessage.mEmoRecentMsg);
      }
      if ((localSubAccountMessage.mTimeString == null) || (localSubAccountMessage.mEmoRecentMsg == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) {
        localSubAccountMessage.mTimeString = TimeFormatterUtils.a(localSubAccountMessage.time * 1000L, true, SubAccountControlServiceImpl.DateFormate);
      }
      if (localSubAccountMessage.istroop != 1) {
        localViewHolder.h.setExtendText(localSubAccountMessage.mTimeString, 0);
      }
      if (AppConstants.SUBACCOUNT_TROOP_UIN.equals(localSubAccountMessage.senderuin))
      {
        try
        {
          paramView = BitmapFactory.decodeResource(localResources, 2130843506);
          if (this.f) {
            paramView = ((IQQAvatarUtilApi)QRoute.api(IQQAvatarUtilApi.class)).getShapeRoundFaceBitmap(paramView, 3, 50, 50);
          } else {
            paramView = BaseImageUtil.a(paramView, 50, 50);
          }
          localViewHolder.g.setImageBitmap(paramView);
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
        paramView = FaceDrawable.getFaceDrawable(this.b, 1, localSubAccountMessage.senderuin);
        localViewHolder.g.setTag(localSubAccountMessage.senderuin);
        localViewHolder.g.setImageDrawable(paramView);
        localViewHolder.g.setVisibility(0);
      }
      label533:
      localViewHolder.j.setTag(Integer.valueOf(paramInt));
      int k = localSubAccountMessage.unreadNum;
      paramView = "";
      int j;
      if ((k > 0) && (localSubAccountMessage.istroop == 1))
      {
        paramInt = 0;
        i = 1;
        j = 2130852588;
      }
      else if (k > 0)
      {
        if ((2 != localAssociatedAccountListItemData.f) && (3 != localAssociatedAccountListItemData.f))
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
          paramView.append(localResources.getString(2131914364));
          paramView.append("]");
          paramViewGroup = paramView.toString();
        }
        paramInt = 0;
        paramView = paramViewGroup;
        label675:
        i = 3;
        j = 2130852592;
      }
      else
      {
        paramInt = 0;
        i = 0;
        j = 0;
      }
      localViewHolder.i.setExtendText(paramView, 1);
      localViewHolder.j.setDragViewType(0, localView);
      CustomWidgetUtil.a(localViewHolder.j, i, k, j, 99, null);
      if ((AppSetting.e) && (TextUtils.isEmpty(localAssociatedAccountListItemData.h)))
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append((String)localObject);
        paramViewGroup.append(",");
        if (localAssociatedAccountListItemData.g != 0) {
          if (localAssociatedAccountListItemData.g == 1)
          {
            paramViewGroup.append("有一条未读");
          }
          else if (localAssociatedAccountListItemData.g == 2)
          {
            paramViewGroup.append("有两条未读");
          }
          else if (localAssociatedAccountListItemData.g > 0)
          {
            paramViewGroup.append("有");
            paramViewGroup.append(localAssociatedAccountListItemData.g);
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
        localAssociatedAccountListItemData.h = paramViewGroup.toString();
      }
      float f1 = DeviceInfoUtil.A();
      paramView = localResources.getColorStateList(2131168118);
      paramViewGroup = localResources.getColorStateList(2131167993);
      int i = localResources.getColor(2131168153);
      localViewHolder.h.setTextColor(paramViewGroup);
      localViewHolder.h.setExtendTextColor(paramView, 0);
      localViewHolder.h.setExtendTextSize(12.0F, 0);
      localViewHolder.h.setCompoundDrawablePadding((int)(3.0F * f1));
      localViewHolder.h.setExtendTextPadding((int)(5.0F * f1), 2);
      localViewHolder.h.setExtendTextColor(paramView, 2);
      localViewHolder.h.setExtendTextSize(17.0F, 2);
      if (paramInt != 0) {
        localViewHolder.i.setTextColor(i);
      } else {
        localViewHolder.i.setTextColor(paramView);
      }
      localViewHolder.i.setExtendTextColor(ColorStateList.valueOf(i), 1);
      localViewHolder.i.setExtendTextPadding((int)(f1 * 2.0F), 1);
      localViewHolder.i.setExtendTextSize(14.0F, 1);
      a(localView, localAssociatedAccountListItemData);
      localView.setOnClickListener(this.d);
      if ((AppSetting.e) && (!TextUtils.isEmpty(localAssociatedAccountListItemData.h))) {
        localView.setContentDescription(localAssociatedAccountListItemData.h);
      }
      if (this.e)
      {
        paramView = localView.findViewById(2131432030);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
      }
    }
    return localView;
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.c;
    if (localArrayList != null) {
      return localArrayList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    ArrayList localArrayList = this.c;
    if ((localArrayList != null) && (paramInt >= 0) && (paramInt < localArrayList.size())) {
      return this.c.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.c != null) {
      return paramInt;
    }
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    ArrayList localArrayList = this.c;
    if ((localArrayList != null) && (paramInt >= 0) && (paramInt < localArrayList.size())) {
      return ((AssociatedAccountListItemData)this.c.get(paramInt)).a;
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
                  localObject = this.a.inflate(2131629337, paramViewGroup, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AssociatedAccountListAdapter
 * JD-Core Version:    0.7.0.1
 */