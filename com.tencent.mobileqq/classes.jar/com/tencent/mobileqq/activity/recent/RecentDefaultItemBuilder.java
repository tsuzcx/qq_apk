package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.nearby.profilecard.MiniCardManagerUtils;
import com.tencent.mobileqq.newnearby.INearbyMsgbox;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.IRecentImgv;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;

public class RecentDefaultItemBuilder
  extends RecentItemBaseBuilder
{
  public static int a;
  private List<String> b;
  
  public static void a(int paramInt, TextView paramTextView, View... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramInt <= 0) {
        return;
      }
      int m = paramVarArgs.length;
      int j = 0;
      int i = 0;
      while (j < m)
      {
        Object localObject1 = paramVarArgs[j];
        if (((View)localObject1).getVisibility() != 8)
        {
          if ((localObject1 instanceof TextView))
          {
            Object localObject2 = (TextView)localObject1;
            String str = ((TextView)localObject2).getText().toString();
            k = i;
            if (!TextUtils.isEmpty(str))
            {
              localObject2 = ((TextView)localObject2).getPaint();
              k = (int)(i + (((TextPaint)localObject2).measureText(str) + 0.5F));
            }
            i = k + ((View)localObject1).getPaddingLeft();
            k = ((View)localObject1).getPaddingRight();
          }
          else
          {
            k = ((View)localObject1).getWidth();
          }
          localObject1 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
          k = i + k + ((LinearLayout.LayoutParams)localObject1).leftMargin + ((LinearLayout.LayoutParams)localObject1).rightMargin;
          i = k;
          if (k > paramInt)
          {
            j = 0;
            break label189;
          }
        }
        j += 1;
      }
      j = 1;
      int k = i;
      label189:
      if (k == 0) {
        return;
      }
      i = j;
      if (j != 0)
      {
        paramVarArgs = paramTextView.getText().toString();
        if (!TextUtils.isEmpty(paramVarArgs)) {
          i = (int)(paramTextView.getPaint().measureText(paramVarArgs) + 0.5F);
        } else {
          i = 0;
        }
        if (i + k < paramInt) {
          i = 1;
        } else {
          i = 0;
        }
      }
      paramTextView = (LinearLayout.LayoutParams)paramTextView.getLayoutParams();
      if (i != 0)
      {
        paramTextView.weight = 0.0F;
        return;
      }
      paramTextView.weight = 1.0F;
    }
  }
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, RecentDefaultItemBuilder.RecentItemDefaultHolder paramRecentItemDefaultHolder)
  {
    int j = paramRecentBaseData.mUnreadNum;
    int i = paramRecentBaseData.mUnreadFlag;
    if (j > 0) {
      if (i == 0)
      {
        paramRecentItemDefaultHolder.b.setDragViewType(-1, paramView);
      }
      else
      {
        if (i == 2)
        {
          paramRecentItemDefaultHolder.b.setDragViewType(-1, paramView);
          i = 1;
          break label195;
        }
        if (i == 3)
        {
          ExpEntityInfo localExpEntityInfo = ABTestController.a().a("message_reminder_layer2_1505_20210618");
          localExpEntityInfo.h();
          if (localExpEntityInfo.f())
          {
            k = 11;
            j = 0;
            i = 2130852597;
          }
          else
          {
            boolean bool = paramRecentBaseData instanceof RecentTroopAssistantItem;
            paramRecentItemDefaultHolder.b.setTextColor(paramContext.getResources().getColor(2131168173));
            k = 3;
            i = 2130852596;
          }
          paramRecentItemDefaultHolder.b.setDragViewType(1, paramView);
          int m = i;
          i = k;
          k = m;
          break label201;
        }
        paramRecentItemDefaultHolder.b.setDragViewType(0, paramView);
        paramRecentItemDefaultHolder.b.setTextColor(paramContext.getResources().getColor(2131168174));
        i = 3;
        k = 2130852592;
        break label201;
      }
    }
    i = 0;
    label195:
    j = 0;
    int k = 0;
    label201:
    CustomWidgetUtil.a(paramRecentItemDefaultHolder.b, i, j, k, 99, null);
  }
  
  private void a(RecentBaseData paramRecentBaseData, Context paramContext, RecentDefaultItemBuilder.RecentItemDefaultHolder paramRecentItemDefaultHolder)
  {
    if (MiniCardManagerUtils.a(paramRecentBaseData.getRecentUserUin()))
    {
      paramRecentBaseData = MiniCardManagerUtils.b(paramRecentBaseData.getRecentUserUin());
      if (!((INearbyMsgbox)QRoute.api(INearbyMsgbox.class)).isNewNearby()) {
        paramRecentItemDefaultHolder.e.setText(paramRecentBaseData.nick.get());
      }
      ((IImageLoader)QRoute.api(IImageLoader.class)).displayImage(paramRecentItemDefaultHolder.a, paramRecentBaseData.logo.get(), paramContext.getResources().getDrawable(2130847053), paramContext.getResources().getDrawable(2130847053), null, true);
    }
  }
  
  private void a(RecentBaseData paramRecentBaseData, RecentDefaultItemBuilder.RecentItemDefaultHolder paramRecentItemDefaultHolder)
  {
    CharSequence localCharSequence1 = paramRecentBaseData.mMsgExtroInfo;
    CharSequence localCharSequence2 = paramRecentItemDefaultHolder.h.getText();
    int i = paramRecentItemDefaultHolder.h.getCurrentTextColor();
    Object localObject = localCharSequence1;
    if (localCharSequence1 == null) {
      localObject = "";
    }
    if (!localObject.equals(localCharSequence2)) {
      paramRecentItemDefaultHolder.h.setText((CharSequence)localObject);
    }
    if ((i != paramRecentBaseData.mExtraInfoColor) && (paramRecentBaseData.mExtraInfoColor != 0)) {
      paramRecentItemDefaultHolder.h.setTextColor(paramRecentBaseData.mExtraInfoColor);
    }
  }
  
  private int b(View paramView)
  {
    int i = paramView.getResources().getDisplayMetrics().widthPixels;
    int j = paramView.getPaddingRight();
    int k = paramView.getPaddingLeft();
    paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    return i - (j + 0 + k + paramView.leftMargin + paramView.rightMargin);
  }
  
  private void b(RecentBaseData paramRecentBaseData, RecentDefaultItemBuilder.RecentItemDefaultHolder paramRecentItemDefaultHolder)
  {
    CharSequence localCharSequence1 = paramRecentBaseData.mLastMsg;
    CharSequence localCharSequence2 = paramRecentItemDefaultHolder.i.getText();
    paramRecentBaseData = localCharSequence1;
    if (localCharSequence1 == null) {
      paramRecentBaseData = "";
    }
    if (!paramRecentBaseData.equals(localCharSequence2)) {
      try
      {
        paramRecentItemDefaultHolder.i.setText(paramRecentBaseData);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        paramRecentItemDefaultHolder = paramRecentItemDefaultHolder.i;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramRecentBaseData);
        localStringBuilder.append(" ");
        paramRecentItemDefaultHolder.setText(localStringBuilder.toString());
      }
    }
  }
  
  private void c(RecentBaseData paramRecentBaseData, RecentDefaultItemBuilder.RecentItemDefaultHolder paramRecentItemDefaultHolder)
  {
    String str = paramRecentBaseData.mShowTime;
    CharSequence localCharSequence = paramRecentItemDefaultHolder.c.getText();
    paramRecentBaseData = str;
    if (str == null) {
      paramRecentBaseData = "";
    }
    if (!paramRecentBaseData.equals(localCharSequence)) {
      paramRecentItemDefaultHolder.c.setText(paramRecentBaseData);
    }
  }
  
  private void d(RecentBaseData paramRecentBaseData, RecentDefaultItemBuilder.RecentItemDefaultHolder paramRecentItemDefaultHolder)
  {
    if ((paramRecentBaseData.mMenuFlag & 0xF0) == 32)
    {
      paramRecentItemDefaultHolder.leftView.setBackgroundResource(2130839578);
      return;
    }
    paramRecentItemDefaultHolder.leftView.setBackgroundResource(2130839577);
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramOnDragModeChangedListener = null;
    if ((paramView != null) && ((paramView.getTag() instanceof RecentDefaultItemBuilder.RecentItemDefaultHolder))) {
      paramViewGroup = (RecentDefaultItemBuilder.RecentItemDefaultHolder)paramView.getTag();
    } else {
      paramViewGroup = null;
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = new RecentDefaultItemBuilder.RecentItemDefaultHolder();
      if (((INearbyMsgbox)QRoute.api(INearbyMsgbox.class)).isNewNearby()) {
        paramView = a(paramContext, 2131629168, paramViewGroup);
      } else {
        paramView = a(paramContext, 2131629159, paramViewGroup);
      }
      paramViewGroup.a = ((ThemeImageView)paramView.findViewById(2131435219));
      paramViewGroup.a.setSupportMaskView(true);
      paramViewGroup.b = ((DragTextView)paramView.findViewById(2131449128));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131436844));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131431396));
      paramViewGroup.e = ((TextView)paramView.findViewById(16908308));
      paramViewGroup.f = ((ImageView)paramView.findViewById(2131446326));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131434375));
      paramViewGroup.h = ((TextView)paramView.findViewById(2131432706));
      paramViewGroup.i = ((TextView)paramView.findViewById(16908309));
      paramViewGroup.i.setGravity(16);
      if (((INearbyMsgbox)QRoute.api(INearbyMsgbox.class)).isNewNearby())
      {
        paramViewGroup.j = paramView.findViewById(2131439160);
        paramViewGroup.k = ((TextView)paramView.findViewById(2131445254));
        paramViewGroup.l = ((TextView)paramView.findViewById(2131437995));
      }
      a(paramView, paramViewGroup.c, paramContext);
      paramView.setTag(paramViewGroup);
      if (this.f != null) {
        paramViewGroup.b.setOnModeChangeListener(this.f.b());
      }
    }
    paramViewGroup.b.setTag(Integer.valueOf(paramInt));
    if (AppSetting.e) {
      paramView.setContentDescription(null);
    }
    if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData)))
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
      if (paramRecentFaceDecoder != null) {
        paramOnDragModeChangedListener = paramRecentFaceDecoder.a(localRecentBaseData);
      }
      a(paramView, localRecentBaseData, paramContext, paramOnDragModeChangedListener);
      if ((paramObject instanceof RecentItemEcShop))
      {
        paramViewGroup.a.setOnClickListener(paramOnClickListener);
        paramViewGroup.a.setTag(-1, Integer.valueOf(paramInt));
        if (AppSetting.e) {
          paramViewGroup.a.setContentDescription(String.format(HardCodeUtil.a(2131910642), new Object[] { ((RecentItemEcShop)paramObject).getTitleName() }));
        }
      }
    }
    else if (paramViewGroup != null)
    {
      paramViewGroup.e.setText("");
      paramViewGroup.f.setVisibility(8);
      paramViewGroup.g.setVisibility(8);
      paramViewGroup.g.setText("");
      paramViewGroup.h.setText("");
      paramViewGroup.i.setText("");
      paramViewGroup.c.setText("");
      paramViewGroup.d.setImageDrawable(null);
    }
    a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
    paramView.setOnClickListener(paramOnClickListener);
    paramView.setOnLongClickListener(paramOnLongClickListener);
    paramView.setTag(-1, Integer.valueOf(paramInt));
    return paramView;
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData != null) && (paramContext != null))
    {
      int i = paramRecentBaseData.mMenuFlag;
      paramRecentBaseData = paramContext.getResources();
      paramContext = this.b;
      if (paramContext == null) {
        this.b = new ArrayList();
      } else {
        paramContext.clear();
      }
      int j = 0xF0000 & i;
      if (j == 131072) {
        this.b.add(paramRecentBaseData.getString(c[5]));
      } else if (j == 65536) {
        this.b.add(paramRecentBaseData.getString(c[4]));
      }
      j = i & 0xF0;
      if (j == 32) {
        this.b.add(paramRecentBaseData.getString(c[2]));
      } else if (j == 16) {
        this.b.add(paramRecentBaseData.getString(c[3]));
      }
      if ((i & 0xF) == 1) {
        this.b.add(paramRecentBaseData.getString(c[0]));
      }
      return this.b;
    }
    return null;
  }
  
  protected void a(View paramView, TextView paramTextView, Context paramContext)
  {
    try
    {
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131447064);
      String str = TimeManager.a().a("000000", 1225168973512L);
      paramView = str;
      if (TextUtils.isEmpty(str)) {
        paramView = TimeManager.a().b();
      }
      int j = 0;
      int i = j;
      if (!TextUtils.isEmpty(paramView))
      {
        i = j;
        if (paramView.length() != 10) {
          i = 1;
        }
      }
      if ((a <= 0) || (i != 0))
      {
        float f2 = paramContext.getResources().getDisplayMetrics().density;
        paramContext = paramTextView.getPaint();
        paramTextView = paramContext;
        if (paramContext == null)
        {
          paramTextView = new TextPaint();
          paramTextView.setTextSize(12.0F * f2);
        }
        if (i != 0)
        {
          float f1 = paramTextView.measureText("yyyy-MM-dd");
          f2 *= 6.0F;
          i = (int)(f1 + f2);
          j = (int)(paramTextView.measureText(paramView) + f2);
          if (j > i) {
            a = j;
          } else {
            a = i;
          }
        }
        else
        {
          a = (int)(paramTextView.measureText("yyyy-MM-dd") + f2 * 6.0F);
        }
      }
      if (localLinearLayout.getPaddingRight() < a)
      {
        i = localLinearLayout.getPaddingLeft();
        j = localLinearLayout.getPaddingTop();
        int k = localLinearLayout.getPaddingBottom();
        int m = a;
        localLinearLayout.setPadding(i, j, a, k);
        return;
      }
    }
    catch (Exception paramView)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("RecentDefaultItemBuilder", 4, paramView.toString());
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView != null) && (paramRecentBaseData != null))
    {
      Object localObject = paramView.getTag();
      RecentDefaultItemBuilder.RecentItemDefaultHolder localRecentItemDefaultHolder = null;
      if ((localObject instanceof RecentDefaultItemBuilder.RecentItemDefaultHolder)) {
        localRecentItemDefaultHolder = (RecentDefaultItemBuilder.RecentItemDefaultHolder)localObject;
      }
      if (localRecentItemDefaultHolder == null)
      {
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("bindView|holder is null, tag = ");
          paramView.append(localObject);
          QLog.i("Q.recent", 2, paramView.toString());
        }
        return;
      }
      localRecentItemDefaultHolder.a.setImageDrawable(paramDrawable);
      localObject = paramRecentBaseData.mTitleName;
      CharSequence localCharSequence = localRecentItemDefaultHolder.e.getText();
      paramDrawable = (Drawable)localObject;
      if (localObject == null) {
        paramDrawable = "";
      }
      if (((INearbyMsgbox)QRoute.api(INearbyMsgbox.class)).isNewNearby()) {
        ((INearbyMsgbox)QRoute.api(INearbyMsgbox.class)).updateMsgBoxItemView(paramView, localRecentItemDefaultHolder, Long.valueOf(paramRecentBaseData.getRecentUserUin()).longValue());
      } else if (!paramDrawable.equals(localCharSequence)) {
        localRecentItemDefaultHolder.e.setText(paramDrawable);
      }
      a(paramRecentBaseData, paramContext, localRecentItemDefaultHolder);
      int i = paramRecentBaseData.mAuthenIconId;
      if (i > 0)
      {
        localRecentItemDefaultHolder.f.setVisibility(0);
        localRecentItemDefaultHolder.f.setImageResource(i);
      }
      else
      {
        localRecentItemDefaultHolder.f.setVisibility(8);
      }
      localObject = paramRecentBaseData.mExtraInfo;
      localCharSequence = localRecentItemDefaultHolder.g.getText();
      paramDrawable = (Drawable)localObject;
      if (localObject == null) {
        paramDrawable = "";
      }
      if (TextUtils.isEmpty(paramDrawable))
      {
        localRecentItemDefaultHolder.g.setVisibility(8);
      }
      else
      {
        if (!paramDrawable.equals(localCharSequence)) {
          localRecentItemDefaultHolder.g.setText(paramDrawable);
        }
        localRecentItemDefaultHolder.g.setVisibility(0);
      }
      a(b((View)localRecentItemDefaultHolder.e.getParent()), localRecentItemDefaultHolder.e, new View[] { localRecentItemDefaultHolder.f, localRecentItemDefaultHolder.g });
      a(paramRecentBaseData, localRecentItemDefaultHolder);
      b(paramRecentBaseData, localRecentItemDefaultHolder);
      c(paramRecentBaseData, localRecentItemDefaultHolder);
      a(localRecentItemDefaultHolder, paramRecentBaseData);
      a(paramView, paramRecentBaseData, paramContext, localRecentItemDefaultHolder);
      if (localRecentItemDefaultHolder.c.getVisibility() != 0) {
        localRecentItemDefaultHolder.c.setVisibility(0);
      }
      if (AppSetting.e) {
        paramView.setContentDescription(paramRecentBaseData.mContentDesc);
      }
      d(paramRecentBaseData, localRecentItemDefaultHolder);
      long l = paramRecentBaseData.getFaceExtraFlag();
      if ((localRecentItemDefaultHolder.a instanceof IRecentImgv)) {
        ((IRecentImgv)localRecentItemDefaultHolder.a).showTroopCreditStatus(l);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "bindView|param invalidate");
    }
  }
  
  public void a(RecentDefaultItemBuilder.RecentItemDefaultHolder paramRecentItemDefaultHolder, RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.mStatus;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              paramRecentItemDefaultHolder.d.setVisibility(8);
              paramRecentItemDefaultHolder.d.setImageDrawable(null);
              return;
            }
            paramRecentItemDefaultHolder.d.setVisibility(0);
            paramRecentItemDefaultHolder.d.setImageResource(2130843135);
            return;
          }
          paramRecentItemDefaultHolder.d.setVisibility(0);
          paramRecentItemDefaultHolder.d.setImageResource(2130839732);
          return;
        }
        paramRecentItemDefaultHolder.d.setVisibility(0);
        if (paramRecentBaseData.mIsGroupVideo)
        {
          paramRecentItemDefaultHolder.d.setImageResource(2130843134);
          return;
        }
        paramRecentItemDefaultHolder.d.setImageResource(2130843135);
        return;
      }
      paramRecentItemDefaultHolder.d.setVisibility(0);
      if (paramRecentBaseData.mIsGroupVideo)
      {
        paramRecentItemDefaultHolder.d.setImageResource(2130843134);
        return;
      }
      paramRecentItemDefaultHolder.d.setImageResource(2130843124);
      return;
    }
    paramRecentItemDefaultHolder.d.setVisibility(0);
    paramRecentItemDefaultHolder.d.setImageResource(2130843124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentDefaultItemBuilder
 * JD-Core Version:    0.7.0.1
 */