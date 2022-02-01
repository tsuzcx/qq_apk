package com.tencent.mobileqq.apollo.view.pannel;

import amme;
import amna;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anka;
import ankc;
import annl;
import annz;
import anoa;
import bbbq;
import bhow;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class ApolloLinearLayout
  extends LinearLayout
{
  public static Rect a;
  public static int e;
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  public FrameLayout a;
  public bhow a;
  public SessionInfo a;
  public BaseChatPie a;
  public ApolloLinearLayout.CheckForLongPress a;
  public AtomicInteger a;
  public boolean a;
  int jdField_b_of_type_Int = 4;
  View jdField_b_of_type_AndroidViewView = null;
  public FrameLayout b;
  public AtomicInteger b;
  boolean jdField_b_of_type_Boolean;
  int c = 2;
  int d;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public ApolloLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_Bhow = new annz(this);
  }
  
  public ApolloLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_Bhow = new annz(this);
    super.setOrientation(1);
    this.d = paramInt1;
    if (this.d == 4)
    {
      b(paramContext, paramInt2, paramInt3);
      return;
    }
    a(paramContext, paramInt2, paramInt3);
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2)
  {
    float f2 = paramContext.getResources().getDisplayMetrics().density;
    float f1 = DeviceInfoUtil.getAppDisplayWidth(super.getContext()) / 750.0F;
    int m = (int)(15.0F * f1);
    int i = (int)(f1 * 30.0F);
    int n = (DeviceInfoUtil.getAppDisplayWidth(super.getContext()) - m * 2 - i * 8) / 4;
    e = n;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloLinearLayout", 2, "panel height = " + XPanelContainer.jdField_a_of_type_Int + "imgHeight = " + n + "addHeight=" + XPanelContainer.d);
    }
    i = 0;
    while (i < paramInt2)
    {
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, (int)(14.0F * paramContext.getResources().getDisplayMetrics().scaledDensity) + n + (int)(6.0F * f2));
      localLayoutParams.leftMargin = m;
      localLayoutParams.rightMargin = m;
      localLinearLayout.setOrientation(0);
      localLinearLayout.setShowDividers(0);
      int j;
      label220:
      Object localObject1;
      View localView;
      Object localObject2;
      int k;
      if (i == 0)
      {
        localLayoutParams.topMargin = ((int)(10.0F * f2));
        j = 0;
        if (j >= paramInt1) {
          break label727;
        }
        localObject1 = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
        localView = LayoutInflater.from(paramContext).inflate(2131558699, null);
        localLinearLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
        localObject1 = new anoa();
        ((anoa)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362764));
        ((anoa)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363166));
        ((anoa)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362762));
        ((anoa)localObject1).e = ((ImageView)localView.findViewById(2131362760));
        ((anoa)localObject1).jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362761));
        localObject2 = (RelativeLayout.LayoutParams)((anoa)localObject1).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).height = n;
        ((RelativeLayout.LayoutParams)localObject2).width = n;
        ((anoa)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362799));
        ((anoa)localObject1).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131362802));
        localObject2 = (RelativeLayout.LayoutParams)((anoa)localObject1).jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = (n / 2);
        ((RelativeLayout.LayoutParams)localObject2).height = (n / 2);
        ((anoa)localObject1).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362805));
        localObject2 = (RelativeLayout.LayoutParams)((anoa)localObject1).jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = ((AIOUtils.dp2px(8.0F, getResources()) + n) / 2);
        if (XPanelContainer.d <= 0) {
          break label698;
        }
        k = AIOUtils.dp2px(16.0F, getResources());
        label501:
        ((RelativeLayout.LayoutParams)localObject2).height = k;
        ((anoa)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362798));
        localObject2 = ((anoa)localObject1).jdField_b_of_type_AndroidWidgetTextView;
        if (XPanelContainer.d <= 0) {
          break label713;
        }
        f1 = 8.0F;
        label541:
        ((TextView)localObject2).setTextSize(f1);
        localObject2 = (RelativeLayout.LayoutParams)((anoa)localObject1).jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        if (XPanelContainer.d <= 0) {
          break label720;
        }
      }
      label698:
      label713:
      label720:
      for (f1 = 16.0F;; f1 = 10.0F)
      {
        ((RelativeLayout.LayoutParams)localObject2).width = ((n - AIOUtils.dp2px(f1, getResources())) / 2);
        ((anoa)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362804));
        ((anoa)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362801));
        ((anoa)localObject1).d = ((ImageView)localView.findViewById(2131362803));
        ((RelativeLayout.LayoutParams)((anoa)localObject1).d.getLayoutParams()).width = ((n - AIOUtils.dp2px(4.0F, getResources())) / 2);
        localView.setTag(localObject1);
        j += 1;
        break label220;
        localLayoutParams.topMargin = ((int)(6.0F * f2));
        break;
        k = AIOUtils.dp2px(12.0F, getResources());
        break label501;
        f1 = 6.0F;
        break label541;
      }
      label727:
      super.addView(localLinearLayout, localLayoutParams);
      i += 1;
    }
    super.setTag(Integer.valueOf(XPanelContainer.d));
  }
  
  private static void a(anoa paramanoa, int paramInt)
  {
    paramanoa.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    paramanoa.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
  
  private void b(Context paramContext, int paramInt1, int paramInt2)
  {
    float f2 = paramContext.getResources().getDisplayMetrics().density;
    int m = (int)((int)((int)((int)(XPanelContainer.jdField_a_of_type_Int - (XPanelContainer.d * 0.25D + 50.0F * f2)) - (10.0F * f2 + 10.0F * f2)) - 10.0F * f2) - 40.0F * f2) / 2;
    e = m;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloLinearLayout", 2, "panel height = " + XPanelContainer.jdField_a_of_type_Int + "imgHeight = " + m + "addHeight=" + XPanelContainer.d);
    }
    int i = 0;
    while (i < paramInt2)
    {
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, m);
      localLayoutParams.leftMargin = ((int)(10.0F * f2));
      localLayoutParams.rightMargin = ((int)(20.0F * f2));
      localLinearLayout.setOrientation(0);
      if (i == 1) {
        localLayoutParams.topMargin = ((int)(10.0F * f2));
      }
      int j = 0;
      if (j < paramInt1)
      {
        Object localObject1 = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject1).leftMargin = ((int)(10.0F * f2));
        View localView = LayoutInflater.from(paramContext).inflate(2131558700, null);
        localLinearLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
        localObject1 = new anoa();
        ((anoa)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362764));
        ((anoa)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363166));
        ((anoa)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362762));
        ((anoa)localObject1).e = ((ImageView)localView.findViewById(2131362760));
        ((anoa)localObject1).jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362761));
        Object localObject2 = (RelativeLayout.LayoutParams)((anoa)localObject1).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).height = m;
        ((RelativeLayout.LayoutParams)localObject2).width = m;
        ((anoa)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362799));
        ((anoa)localObject1).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131362802));
        localObject2 = (RelativeLayout.LayoutParams)((anoa)localObject1).jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = (m / 2);
        ((RelativeLayout.LayoutParams)localObject2).height = (m / 2);
        ((anoa)localObject1).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362805));
        localObject2 = (RelativeLayout.LayoutParams)((anoa)localObject1).jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = ((AIOUtils.dp2px(8.0F, getResources()) + m) / 2);
        int k;
        if (XPanelContainer.d > 0)
        {
          k = AIOUtils.dp2px(16.0F, getResources());
          label501:
          ((RelativeLayout.LayoutParams)localObject2).height = k;
          ((anoa)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362798));
          localObject2 = ((anoa)localObject1).jdField_b_of_type_AndroidWidgetTextView;
          if (XPanelContainer.d <= 0) {
            break label699;
          }
          f1 = 8.0F;
          label541:
          ((TextView)localObject2).setTextSize(f1);
          localObject2 = (RelativeLayout.LayoutParams)((anoa)localObject1).jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
          if (XPanelContainer.d <= 0) {
            break label706;
          }
        }
        label699:
        label706:
        for (float f1 = 16.0F;; f1 = 10.0F)
        {
          ((RelativeLayout.LayoutParams)localObject2).width = ((m - AIOUtils.dp2px(f1, getResources())) / 2);
          ((anoa)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362804));
          ((anoa)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362801));
          ((anoa)localObject1).d = ((ImageView)localView.findViewById(2131362803));
          ((RelativeLayout.LayoutParams)((anoa)localObject1).d.getLayoutParams()).width = ((m - AIOUtils.dp2px(4.0F, getResources())) / 2);
          localView.setTag(localObject1);
          j += 1;
          break;
          k = AIOUtils.dp2px(12.0F, getResources());
          break label501;
          f1 = 6.0F;
          break label541;
        }
      }
      super.addView(localLinearLayout, localLayoutParams);
      i += 1;
    }
    super.setTag(Integer.valueOf(XPanelContainer.d));
  }
  
  public static void setApolloActionIcon(int paramInt, ApolloActionData paramApolloActionData, anoa paramanoa)
  {
    int i = 1;
    if ((paramInt & 0x1) > 0)
    {
      paramanoa.d.setImageResource(2130838627);
      paramanoa.d.setVisibility(0);
    }
    if ((paramInt & 0x400) > 0)
    {
      paramanoa.d.setImageResource(2130838624);
      paramanoa.d.setVisibility(0);
    }
    if ((paramInt & 0x40) > 0) {
      a(paramanoa, 2130838616);
    }
    if ((paramInt & 0x80) > 0)
    {
      paramanoa.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramanoa.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramApolloActionData.currencyNum));
      a(paramanoa, 2130838619);
    }
    if ((paramInt & 0x200) > 0) {
      a(paramanoa, 2130838618);
    }
    if ((paramInt & 0x4) > 0) {
      a(paramanoa, 2130838626);
    }
    if ((paramInt & 0x8) > 0) {
      a(paramanoa, 2130838626);
    }
    if ((paramInt & 0x10) > 0) {
      a(paramanoa, 2130838626);
    }
    if ((paramInt & 0x2) > 0) {
      a(paramanoa, 2130838622);
    }
    if ((paramInt & 0x2000) > 0)
    {
      paramanoa.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      ApolloUtil.a(paramanoa.jdField_b_of_type_AndroidWidgetImageView, true, true);
    }
    paramInt = i;
    if (paramApolloActionData.feeType == 10)
    {
      paramInt = i;
      if (!ApolloUtil.a(paramanoa.jdField_b_of_type_AndroidWidgetImageView.getContext()))
      {
        paramanoa.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramanoa.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838621);
        paramApolloActionData = (RelativeLayout.LayoutParams)paramanoa.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
        if (paramApolloActionData != null)
        {
          paramApolloActionData.addRule(11);
          paramApolloActionData.addRule(9, 0);
        }
        paramInt = 0;
      }
    }
    if (paramInt != 0)
    {
      paramApolloActionData = (RelativeLayout.LayoutParams)paramanoa.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      if (paramApolloActionData != null)
      {
        paramApolloActionData.addRule(9);
        paramApolloActionData.addRule(11, 0);
      }
    }
  }
  
  public View a(float paramFloat1, float paramFloat2)
  {
    int i = super.getChildCount() - 1;
    while (i >= 0)
    {
      LinearLayout localLinearLayout = (LinearLayout)super.getChildAt(i);
      float f1 = super.getScrollX() + paramFloat1 - localLinearLayout.getLeft();
      float f2 = super.getScrollY() + paramFloat2 - localLinearLayout.getTop();
      if ((f1 >= 0.0F) && (f1 <= localLinearLayout.getWidth()) && (f2 >= 0.0F) && (f2 < localLinearLayout.getHeight()))
      {
        int j = localLinearLayout.getChildCount() - 1;
        while (j >= 0)
        {
          View localView = localLinearLayout.getChildAt(j);
          float f3 = localLinearLayout.getScrollX() + f1 - localView.getLeft();
          float f4 = localLinearLayout.getScrollY() + f2 - localView.getTop();
          if ((f3 >= 0.0F) && (f3 <= localView.getWidth()) && (f4 >= 0.0F) && (f4 < localView.getHeight())) {
            return localView;
          }
          j -= 1;
        }
      }
      i -= 1;
    }
    return null;
  }
  
  public View a(ApolloActionData paramApolloActionData)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramApolloActionData == null) {}
    int i;
    do
    {
      return localObject2;
      i = 0;
      localObject2 = localObject1;
    } while (i >= super.getChildCount());
    LinearLayout localLinearLayout = (LinearLayout)super.getChildAt(i);
    int j = 0;
    label39:
    if (j < localLinearLayout.getChildCount())
    {
      localObject2 = localLinearLayout.getChildAt(j);
      Object localObject3 = (anoa)((View)localObject2).getTag();
      if (localObject3 != null)
      {
        localObject3 = ((anoa)localObject3).jdField_a_of_type_Annl;
        if ((localObject3 != null) && (((annl)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (((annl)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramApolloActionData.actionId)) {
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      j += 1;
      break label39;
    }
  }
  
  public void a()
  {
    int i = 0;
    while (i < super.getChildCount())
    {
      LinearLayout localLinearLayout = (LinearLayout)super.getChildAt(i);
      int k = localLinearLayout.getChildCount();
      int j = 0;
      while (j < k)
      {
        Object localObject = localLinearLayout.getChildAt(j);
        if (localObject != null)
        {
          localObject = (anoa)((View)localObject).getTag();
          if ((localObject != null) && (((anoa)localObject).jdField_a_of_type_AndroidWidgetImageView != null))
          {
            ((anoa)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
            ((anoa)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
            ((anoa)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            ((anoa)localObject).jdField_a_of_type_AndroidWidgetTextView.setText("");
            ((anoa)localObject).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            ((anoa)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            ((anoa)localObject).jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
            ((anoa)localObject).d.setVisibility(8);
            ((anoa)localObject).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            ((anoa)localObject).jdField_a_of_type_Annl = null;
            ((anoa)localObject).jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            ((anoa)localObject).e.setVisibility(8);
            if (((anoa)localObject).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
              ((anoa)localObject).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
            }
            if (((anoa)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
              ((anoa)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
            }
          }
        }
        j += 1;
      }
      i += 1;
    }
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(View paramView)
  {
    Object localObject = (anoa)paramView.getTag();
    if ((((anoa)localObject).jdField_a_of_type_Annl != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (((anoa)localObject).jdField_a_of_type_Annl.jdField_b_of_type_Int == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLinearLayout", 2, "apollo shop item = " + paramView.getClass());
      }
      ((bbbq)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).b(String.valueOf("103100.103200"));
      if (((anoa)localObject).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        ((anoa)localObject).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
      }
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity, null, "aio", anka.u, null);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "enter_aio_clk", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { "0", "0", "AioMall", String.valueOf(System.currentTimeMillis() / 1000L) });
      }
    }
    label1027:
    do
    {
      do
      {
        boolean bool2;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if ((((anoa)localObject).jdField_a_of_type_Annl != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (((anoa)localObject).jdField_a_of_type_Annl.jdField_b_of_type_Int == 2))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloLinearLayout", 2, "apollo fav manager item = " + paramView.getClass());
                    }
                    paramView = new Intent();
                    paramView.putExtra("extra_key_url_append", "&view=customize_action");
                    ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mActivity, paramView, "aio", anka.u, null);
                    return;
                  }
                } while ((((anoa)localObject).jdField_a_of_type_Annl == null) || (((anoa)localObject).jdField_a_of_type_Annl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null));
                localObject = ((anoa)localObject).jdField_a_of_type_Annl;
                ((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin = null;
                ((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.boy1 = null;
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloLinearLayout", 2, "click action " + ((annl)localObject).toString());
                }
                if (!ApolloUtil.a(((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, ((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloLinearLayout", 2, "action status = done but res don't exist actionid=" + ((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
                  }
                  a(((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData);
                }
              } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null));
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 0) {
                VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "action_clk", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, -1, 0, new String[] { "" + ((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "655_" + ((annl)localObject).jdField_a_of_type_Int, "", String.valueOf(System.currentTimeMillis() / 1000L) });
              }
              boolean bool1;
              for (;;)
              {
                if (((annl)localObject).jdField_a_of_type_Int == 9) {
                  VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "y_bqclick", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { String.valueOf(((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum), String.valueOf(((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId), "", "" });
                }
                ankc localankc = (ankc)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
                bool1 = localankc.b(((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
                bool2 = localankc.c(((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
                if (((((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.feeType != 6) && (((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.feeType != 7)) || (bool1) || (bool2)) {
                  break label1027;
                }
                ImageView localImageView = (ImageView)paramView.findViewById(2131378997);
                ((RelativeLayout.LayoutParams)localImageView.getLayoutParams()).topMargin = ((int)(e / 2 - 7.0F * super.getResources().getDisplayMetrics().density));
                localImageView.setVisibility(0);
                paramView.setClickable(false);
                if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {
                  break;
                }
                b(localankc.a(((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId));
                return;
                if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000)) {
                  if (((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum == 0) {
                    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "g_action_single_clk", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, -1, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), new String[] { "" + ((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "655_" + ((annl)localObject).jdField_a_of_type_Int, "", String.valueOf(System.currentTimeMillis() / 1000L) });
                  } else if (((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum != 1) {}
                }
              }
              if ((((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.feeType != 2) || (bool1) || (bool2)) {
                break;
              }
            } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null));
            paramView = ((amme)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER)).a();
          } while (paramView == null);
          paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, (annl)localObject);
          return;
        } while ((((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.feeType == 9) && (!bool2) && (!a(((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData)));
        if (((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.feeType == 10)
        {
          if (!ApolloUtil.a(getContext()))
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mApolloPanel != null))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mApolloPanel.c(((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData);
              return;
            }
            QLog.e("ApolloLinearLayout", 1, "click kapu action, callback null");
            return;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getSessionInfo() != null)) {
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "sendunlockedsucces", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getSessionInfo().curType), 0, new String[] { String.valueOf(((annl)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId) });
          }
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null));
      paramView = ((amme)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER)).a();
    } while (paramView == null);
    paramView.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, (annl)localObject);
  }
  
  public void a(View paramView, annl paramannl)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramannl);
  }
  
  public void a(BaseChatPie paramBaseChatPie, annl paramannl)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.app == null) || (paramannl == null)) {}
    amna localamna;
    do
    {
      return;
      localamna = ((amme)paramBaseChatPie.getApp().getManager(QQManagerFactory.APOLLO_MANAGER)).a();
    } while (localamna == null);
    localamna.c(paramBaseChatPie, paramannl);
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {
      return;
    }
    ThreadManager.post(new ApolloLinearLayout.1(this, paramApolloActionData), 5, null, false);
  }
  
  public boolean a(View paramView, Rect paramRect)
  {
    if (paramView == null) {
      return false;
    }
    paramView.getDrawingRect(paramRect);
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    paramRect.offset(paramView.getLeft() - localViewGroup.getScrollX(), paramView.getTop() - localViewGroup.getScrollY());
    paramView = (ViewGroup)localViewGroup.getParent();
    paramRect.offset(localViewGroup.getLeft() - paramView.getScrollX(), localViewGroup.getTop() - paramView.getScrollY());
    return true;
  }
  
  public boolean a(ApolloActionData paramApolloActionData)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null) || (paramApolloActionData == null)) {
      return false;
    }
    Object localObject = (amme)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER);
    HashMap localHashMap = new HashMap();
    new StringBuilder().append(anka.f).append("&actionId=").append(paramApolloActionData.actionId).append("&_bid=2282").toString();
    if (!((amme)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin()))
    {
      localObject = super.getResources().getString(2131690073);
      String str1 = super.getResources().getString(2131690074);
      String str2 = super.getResources().getString(2131690072);
      String str3 = anka.f + "&actionId=" + paramApolloActionData.actionId + "&_bid=2282";
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", "vip_alert_show", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { "" + paramApolloActionData.actionId, "0" });
      }
      localHashMap.put("APOLLO_POP_TYPE", "dialog");
      localHashMap.put("feeType", String.valueOf(paramApolloActionData.feeType));
      localHashMap.put("title", str1);
      localHashMap.put("content", localObject);
      localHashMap.put("rightString", str2);
      localHashMap.put("url", str3);
      localHashMap.put("actionId", "" + paramApolloActionData.actionId);
      localHashMap.put("personNum", String.valueOf(paramApolloActionData.personNum));
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null)) {
        return false;
      }
      paramApolloActionData = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getHandler(ChatActivity.class);
      if (paramApolloActionData != null)
      {
        paramApolloActionData = paramApolloActionData.obtainMessage(45);
        paramApolloActionData.obj = localHashMap;
        paramApolloActionData.sendToTarget();
      }
      return false;
    }
    return true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_Boolean))
    {
      ((WindowManager)super.getContext().getSystemService("window")).removeViewImmediate(this.jdField_b_of_type_AndroidWidgetFrameLayout);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void b(ApolloActionData paramApolloActionData)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null) || (paramApolloActionData == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.addObserver(this.jdField_a_of_type_Bhow);
    ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(paramApolloActionData.actionId, null, null, 0, 0.0F, 0, "actionPanel");
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    label551:
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayout$CheckForLongPress != null)) {
              super.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayout$CheckForLongPress);
            }
            if ((this.jdField_a_of_type_AndroidViewView != null) && (!this.jdField_b_of_type_Boolean)) {
              a(this.jdField_a_of_type_AndroidViewView);
            }
            if (this.jdField_b_of_type_AndroidViewView != null)
            {
              paramMotionEvent = this.jdField_b_of_type_AndroidViewView;
              if ((paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
              {
                paramMotionEvent = (anoa)paramMotionEvent.getTag();
                if (paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView != null) {
                  paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
                }
              }
            }
            b();
            this.jdField_a_of_type_AndroidViewView = null;
            return true;
            this.jdField_b_of_type_Boolean = false;
            this.jdField_a_of_type_AndroidViewView = a(paramMotionEvent.getX(), paramMotionEvent.getY());
          } while (this.jdField_a_of_type_AndroidViewView == null);
          if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayout$CheckForLongPress == null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayout$CheckForLongPress = new ApolloLinearLayout.CheckForLongPress(this);
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayout$CheckForLongPress.a();
          super.postDelayed(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayout$CheckForLongPress, ViewConfiguration.getLongPressTimeout());
          paramMotionEvent = (anoa)this.jdField_a_of_type_AndroidViewView.getTag();
        } while ((paramMotionEvent == null) || (paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView == null) || (paramMotionEvent.jdField_a_of_type_Annl == null));
        paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838611);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
        return true;
        super.setPressed(false);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayout$CheckForLongPress != null) {
          super.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayout$CheckForLongPress);
        }
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          paramMotionEvent = this.jdField_b_of_type_AndroidViewView;
          if ((paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
          {
            paramMotionEvent = (anoa)paramMotionEvent.getTag();
            if (paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView != null) {
              paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
            }
          }
        }
        b();
        this.jdField_a_of_type_AndroidViewView = null;
        return true;
        if ((!this.jdField_b_of_type_Boolean) || ((a(this.jdField_a_of_type_AndroidViewView, jdField_a_of_type_AndroidGraphicsRect)) && (jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))) {
          break label551;
        }
        this.jdField_a_of_type_AndroidViewView = a(paramMotionEvent.getX(), paramMotionEvent.getY());
        if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView.getTag() == null)) {
          break;
        }
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          paramMotionEvent = this.jdField_b_of_type_AndroidViewView;
          if ((paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
          {
            paramMotionEvent = (anoa)paramMotionEvent.getTag();
            if (paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView != null) {
              paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
            }
          }
        }
        paramMotionEvent = (anoa)this.jdField_a_of_type_AndroidViewView.getTag();
        if ((paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView != null) && (paramMotionEvent.jdField_a_of_type_Annl != null))
        {
          paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838611);
          this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
        }
      } while ((paramMotionEvent.jdField_a_of_type_Annl == null) || (paramMotionEvent.jdField_a_of_type_Annl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null) || (paramMotionEvent.jdField_a_of_type_Annl == null) || (paramMotionEvent.jdField_a_of_type_Annl.jdField_b_of_type_Int == 1));
      a(this.jdField_a_of_type_AndroidViewView, paramMotionEvent.jdField_a_of_type_Annl);
      return true;
      b();
      return true;
    } while ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_AndroidViewView == null) || ((a(this.jdField_a_of_type_AndroidViewView, jdField_a_of_type_AndroidGraphicsRect)) && (jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))));
    this.jdField_a_of_type_AndroidViewView = null;
    return true;
  }
  
  public void setCallback(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public void setSessionInfo(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloLinearLayout
 * JD-Core Version:    0.7.0.1
 */