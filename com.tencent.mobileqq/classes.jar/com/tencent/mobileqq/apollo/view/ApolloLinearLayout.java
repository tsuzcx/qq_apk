package com.tencent.mobileqq.apollo.view;

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
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloPanelManager;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import zep;
import zeq;
import zer;

public class ApolloLinearLayout
  extends LinearLayout
{
  public static Rect a;
  public static int e;
  int a;
  public View a;
  public FrameLayout a;
  public BaseChatPie a;
  public SessionInfo a;
  public VasExtensionObserver a;
  public AtomicInteger a;
  public zer a;
  public boolean a;
  int jdField_b_of_type_Int = 4;
  View jdField_b_of_type_AndroidViewView = null;
  public FrameLayout b;
  public AtomicInteger b;
  public boolean b;
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
    this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver = new zeq(this);
  }
  
  public ApolloLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver = new zeq(this);
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
    int m = (int)((int)((int)((int)((int)(XPanelContainer.jdField_a_of_type_Int - (XPanelContainer.d * 0.25D + 12.0F * f2)) - 14.0F * paramContext.getResources().getDisplayMetrics().scaledDensity * 2.0F) - (12.0F * f2 + 10.0F * f2 + 10.0F * f2)) - 6.0F * f2) - 40.0F * f2) / 2;
    e = m;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloLinearLayout", 2, "panel height = " + XPanelContainer.jdField_a_of_type_Int + "imgHeight = " + m + "addHeight=" + XPanelContainer.d);
    }
    int i = 0;
    while (i < paramInt2)
    {
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, (int)(14.0F * paramContext.getResources().getDisplayMetrics().scaledDensity) + m + (int)(6.0F * f2));
      localLayoutParams.leftMargin = ((int)(15.0F * f2));
      localLayoutParams.rightMargin = ((int)(15.0F * f2));
      localLinearLayout.setOrientation(0);
      int j;
      label256:
      Object localObject1;
      View localView;
      Object localObject2;
      int k;
      if (i == 0) {
        if (XPanelContainer.d > 0)
        {
          localLayoutParams.topMargin = ((int)(12.0F * f2));
          j = 0;
          if (j >= paramInt1) {
            break label772;
          }
          localObject1 = new LinearLayout.LayoutParams(-1, -1);
          ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
          localView = LayoutInflater.from(paramContext).inflate(2130968693, null);
          localLinearLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
          localObject1 = new ApolloLinearLayout.ViewHolder();
          ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131363248));
          ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363237));
          ((ApolloLinearLayout.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363239));
          ((ApolloLinearLayout.ViewHolder)localObject1).e = ((ImageView)localView.findViewById(2131363236));
          ((ApolloLinearLayout.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131363238));
          localObject2 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).height = m;
          ((RelativeLayout.LayoutParams)localObject2).width = m;
          ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363246));
          ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131363240));
          localObject2 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).width = (m / 2);
          ((RelativeLayout.LayoutParams)localObject2).height = (m / 2);
          ((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131363242));
          localObject2 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).width = ((AIOUtils.a(8.0F, getResources()) + m) / 2);
          if (XPanelContainer.d <= 0) {
            break label744;
          }
          k = AIOUtils.a(16.0F, getResources());
          label536:
          ((RelativeLayout.LayoutParams)localObject2).height = k;
          ((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363244));
          localObject2 = ((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView;
          if (XPanelContainer.d <= 0) {
            break label758;
          }
          f1 = 8.0F;
          label575:
          ((TextView)localObject2).setTextSize(f1);
          localObject2 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
          if (XPanelContainer.d <= 0) {
            break label765;
          }
        }
      }
      label744:
      label758:
      label765:
      for (float f1 = 16.0F;; f1 = 10.0F)
      {
        ((RelativeLayout.LayoutParams)localObject2).width = ((m - AIOUtils.a(f1, getResources())) / 2);
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363243));
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363247));
        ((ApolloLinearLayout.ViewHolder)localObject1).d = ((ImageView)localView.findViewById(2131363241));
        ((RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject1).d.getLayoutParams()).width = ((m - AIOUtils.a(4.0F, getResources())) / 2);
        localView.setTag(localObject1);
        j += 1;
        break label256;
        localLayoutParams.topMargin = ((int)(12.0F * f2));
        break;
        localLayoutParams.topMargin = ((int)(6.0F * f2));
        break;
        k = AIOUtils.a(12.0F, getResources());
        break label536;
        f1 = 6.0F;
        break label575;
      }
      label772:
      super.addView(localLinearLayout, localLayoutParams);
      i += 1;
    }
    super.setTag(Integer.valueOf(XPanelContainer.d));
  }
  
  private static void a(ApolloLinearLayout.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramInt);
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
        View localView = LayoutInflater.from(paramContext).inflate(2130968694, null);
        localLinearLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
        localObject1 = new ApolloLinearLayout.ViewHolder();
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131363248));
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363237));
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363239));
        ((ApolloLinearLayout.ViewHolder)localObject1).e = ((ImageView)localView.findViewById(2131363236));
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131363238));
        Object localObject2 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).height = m;
        ((RelativeLayout.LayoutParams)localObject2).width = m;
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363246));
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131363240));
        localObject2 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = (m / 2);
        ((RelativeLayout.LayoutParams)localObject2).height = (m / 2);
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131363242));
        localObject2 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = ((AIOUtils.a(8.0F, getResources()) + m) / 2);
        int k;
        if (XPanelContainer.d > 0)
        {
          k = AIOUtils.a(16.0F, getResources());
          label499:
          ((RelativeLayout.LayoutParams)localObject2).height = k;
          ((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363244));
          localObject2 = ((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView;
          if (XPanelContainer.d <= 0) {
            break label693;
          }
          f1 = 8.0F;
          label538:
          ((TextView)localObject2).setTextSize(f1);
          localObject2 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
          if (XPanelContainer.d <= 0) {
            break label700;
          }
        }
        label693:
        label700:
        for (float f1 = 16.0F;; f1 = 10.0F)
        {
          ((RelativeLayout.LayoutParams)localObject2).width = ((m - AIOUtils.a(f1, getResources())) / 2);
          ((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363243));
          ((ApolloLinearLayout.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363247));
          ((ApolloLinearLayout.ViewHolder)localObject1).d = ((ImageView)localView.findViewById(2131363241));
          ((RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject1).d.getLayoutParams()).width = ((m - AIOUtils.a(4.0F, getResources())) / 2);
          localView.setTag(localObject1);
          j += 1;
          break;
          k = AIOUtils.a(12.0F, getResources());
          break label499;
          f1 = 6.0F;
          break label538;
        }
      }
      super.addView(localLinearLayout, localLayoutParams);
      i += 1;
    }
    super.setTag(Integer.valueOf(XPanelContainer.d));
  }
  
  public static void setApolloActionIcon(int paramInt, ApolloActionData paramApolloActionData, ApolloLinearLayout.ViewHolder paramViewHolder)
  {
    if ((paramInt & 0x1) > 0) {
      paramViewHolder.d.setVisibility(0);
    }
    if ((paramInt & 0x40) > 0) {
      a(paramViewHolder, 2130838123);
    }
    if ((paramInt & 0x80) > 0)
    {
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramApolloActionData.currencyNum));
      a(paramViewHolder, 2130838126);
    }
    if ((paramInt & 0x100) > 0)
    {
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      ApolloUtil.b(paramViewHolder.jdField_b_of_type_AndroidWidgetImageView, paramApolloActionData.vipLevel);
    }
    if ((paramInt & 0x200) > 0) {
      a(paramViewHolder, 2130838125);
    }
    if ((paramInt & 0x4) > 0) {
      a(paramViewHolder, 2130838131);
    }
    if ((paramInt & 0x8) > 0) {
      a(paramViewHolder, 2130838131);
    }
    if ((paramInt & 0x10) > 0) {
      a(paramViewHolder, 2130838131);
    }
    if ((paramInt & 0x20) > 0) {
      a(paramViewHolder, 2130838133);
    }
    if ((paramInt & 0x2) > 0) {
      a(paramViewHolder, 2130838129);
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
      Object localObject3 = (ApolloLinearLayout.ViewHolder)((View)localObject2).getTag();
      if (localObject3 != null)
      {
        localObject3 = ((ApolloLinearLayout.ViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo;
        if ((localObject3 != null) && (((ApolloInfo)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (((ApolloInfo)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramApolloActionData.actionId)) {
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
          localObject = (ApolloLinearLayout.ViewHolder)((View)localObject).getTag();
          if ((localObject != null) && (((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView != null))
          {
            ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
            ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
            ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText("");
            ((ApolloLinearLayout.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            ((ApolloLinearLayout.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
            ((ApolloLinearLayout.ViewHolder)localObject).d.setVisibility(8);
            ((ApolloLinearLayout.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo = null;
            ((ApolloLinearLayout.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            ((ApolloLinearLayout.ViewHolder)localObject).e.setVisibility(8);
            if (((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
              ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
            }
            if (((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
              ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
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
    Object localObject = (ApolloLinearLayout.ViewHolder)paramView.getTag();
    if ((((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_b_of_type_Int == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLinearLayout", 2, "apollo shop item = " + paramView.getClass());
      }
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).b(String.valueOf("103100.103200"));
      if (((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      }
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null, "aio", ApolloConstant.X, null);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "enter_aio_clk", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "0", "0", "AioMall", String.valueOf(System.currentTimeMillis() / 1000L) });
      }
    }
    label981:
    label983:
    do
    {
      boolean bool2;
      do
      {
        do
        {
          do
          {
            boolean bool1;
            for (;;)
            {
              return;
              if ((((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_b_of_type_Int == 2))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloLinearLayout", 2, "apollo fav manager item = " + paramView.getClass());
                }
                paramView = new Intent();
                paramView.putExtra("extra_key_url_append", "&view=customize_action");
                ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramView, "aio", ApolloConstant.X, null);
                return;
              }
              if ((((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo != null) && (((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.status != 0))
              {
                localObject = ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo;
                ((ApolloInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin = null;
                ((ApolloInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.boy1 = null;
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloLinearLayout", 2, "click action " + ((ApolloInfo)localObject).toString());
                }
                if (!ApolloUtil.a(((ApolloInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, ((ApolloInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloLinearLayout", 2, "action status = done but res don't exist actionid=" + ((ApolloInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
                  }
                  a(((ApolloInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData);
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
                  if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
                    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_clk", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, -1, 0, new String[] { "" + ((ApolloInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "655_" + ((ApolloInfo)localObject).jdField_a_of_type_Int, "", String.valueOf(System.currentTimeMillis() / 1000L) });
                  }
                }
                for (;;)
                {
                  if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
                    break label981;
                  }
                  ApolloDaoManager localApolloDaoManager = (ApolloDaoManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
                  bool1 = localApolloDaoManager.a(((ApolloInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
                  bool2 = localApolloDaoManager.b(((ApolloInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
                  if (((((ApolloInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.feeType != 6) && (((ApolloInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.feeType != 7)) || (bool1) || (bool2)) {
                    break label983;
                  }
                  ImageView localImageView = (ImageView)paramView.findViewById(2131363192);
                  ((RelativeLayout.LayoutParams)localImageView.getLayoutParams()).topMargin = ((int)(e / 2 - 7.0F * super.getResources().getDisplayMetrics().density));
                  localImageView.setVisibility(0);
                  paramView.setClickable(false);
                  if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
                    break;
                  }
                  b(localApolloDaoManager.a(((ApolloInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId));
                  return;
                  if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
                    if (((ApolloInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum == 0) {
                      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "g_action_single_clk", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, -1, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), new String[] { "" + ((ApolloInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "655_" + ((ApolloInfo)localObject).jdField_a_of_type_Int, "", String.valueOf(System.currentTimeMillis() / 1000L) });
                    } else if (((ApolloInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum != 1) {}
                  }
                }
              }
            }
            if ((((ApolloInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.feeType != 2) || (bool1) || (bool2)) {
              break;
            }
          } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
          paramView = ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a();
        } while (paramView == null);
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, (ApolloInfo)localObject);
        return;
      } while (((((ApolloInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.feeType == 9) && (!bool2) && (!a(((ApolloInfo)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData))) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
      paramView = ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a();
    } while (paramView == null);
    paramView.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, (ApolloInfo)localObject);
  }
  
  public void a(View paramView, ApolloInfo paramApolloInfo)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramApolloInfo);
  }
  
  public void a(BaseChatPie paramBaseChatPie, ApolloInfo paramApolloInfo)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramApolloInfo == null)) {}
    ApolloPanelManager localApolloPanelManager;
    do
    {
      return;
      localApolloPanelManager = ((ApolloManager)paramBaseChatPie.a().getManager(152)).a();
    } while (localApolloPanelManager == null);
    localApolloPanelManager.c(paramBaseChatPie, paramApolloInfo);
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {
      return;
    }
    ThreadManager.post(new zep(this, paramApolloActionData), 5, null, false);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramApolloActionData == null)) {
      return false;
    }
    Object localObject1 = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
    HashMap localHashMap = new HashMap();
    new StringBuilder().append(ApolloConstant.I).append("&actionId=").append(paramApolloActionData.actionId).append("&_bid=2282").toString();
    Object localObject3;
    Object localObject2;
    if (((ApolloManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
    {
      if (((ApolloManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) < paramApolloActionData.vipLevel)
      {
        int i = ((ApolloManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        localObject3 = super.getResources().getString(2131438234);
        localObject1 = super.getResources().getString(2131438228);
        localObject2 = super.getResources().getString(2131436153);
        localObject3 = String.format((String)localObject3, new Object[] { Integer.valueOf(paramApolloActionData.vipLevel), Integer.valueOf(i) });
        localHashMap.put("APOLLO_POP_TYPE", "dialog");
        localHashMap.put("feeType", String.valueOf(paramApolloActionData.feeType));
        localHashMap.put("title", localObject1);
        localHashMap.put("content", localObject3);
        localHashMap.put("rightString", localObject2);
        localHashMap.put("url", "onlyRightType");
        localHashMap.put("actionId", "" + paramApolloActionData.actionId);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          return false;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (localObject1 != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "level_alert_show", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + paramApolloActionData.actionId, "0" });
          }
          paramApolloActionData = ((MqqHandler)localObject1).obtainMessage(45);
          paramApolloActionData.obj = localHashMap;
          paramApolloActionData.sendToTarget();
        }
        return false;
      }
    }
    else
    {
      Object localObject4;
      String str2;
      Object localObject5;
      String str3;
      String str1;
      if ((((ApolloManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) >= paramApolloActionData.vipLevel) || (paramApolloActionData.vipLevel == 1))
      {
        localObject4 = super.getResources().getString(2131438227);
        str2 = super.getResources().getString(2131438228);
        localObject5 = super.getResources().getString(2131438230);
        str3 = ApolloConstant.I + "&actionId=" + paramApolloActionData.actionId + "&_bid=2282";
        str1 = str3;
        localObject3 = localObject5;
        localObject2 = str2;
        localObject1 = localObject4;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
          break label948;
        }
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "vip_alert_show", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + paramApolloActionData.actionId, "0" });
        localObject1 = str3;
        localObject2 = str2;
      }
      for (localObject3 = localObject4;; localObject3 = localObject4)
      {
        localHashMap.put("APOLLO_POP_TYPE", "dialog");
        localHashMap.put("feeType", String.valueOf(paramApolloActionData.feeType));
        localHashMap.put("title", localObject2);
        localHashMap.put("content", localObject3);
        localHashMap.put("rightString", localObject5);
        localHashMap.put("url", localObject1);
        localHashMap.put("actionId", "" + paramApolloActionData.actionId);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
          break;
        }
        return false;
        localObject1 = super.getResources().getString(2131438233);
        localObject4 = super.getResources().getString(2131438228);
        str2 = super.getResources().getString(2131438230);
        localObject5 = String.format((String)localObject1, new Object[] { Integer.valueOf(paramApolloActionData.vipLevel) });
        str3 = "moreInfo";
        str1 = str3;
        localObject3 = str2;
        localObject2 = localObject4;
        localObject1 = localObject5;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
        {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "level_alert_show", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 1, new String[] { "" + paramApolloActionData.actionId, "0" });
          localObject1 = localObject5;
          localObject2 = localObject4;
          localObject3 = str2;
          str1 = str3;
        }
        label948:
        localObject4 = localObject1;
        localObject1 = str1;
        localObject5 = localObject3;
      }
      paramApolloActionData = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramApolloActionData == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
    ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(paramApolloActionData.actionId, null, null, 0, 0.0F, 0, "actionPanel");
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
    label565:
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Zer != null)) {
              super.removeCallbacks(this.jdField_a_of_type_Zer);
            }
            if ((this.jdField_a_of_type_AndroidViewView != null) && (!this.jdField_b_of_type_Boolean)) {
              a(this.jdField_a_of_type_AndroidViewView);
            }
            if (this.jdField_b_of_type_AndroidViewView != null)
            {
              paramMotionEvent = this.jdField_b_of_type_AndroidViewView;
              if ((paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
              {
                paramMotionEvent = (ApolloLinearLayout.ViewHolder)paramMotionEvent.getTag();
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
          if (this.jdField_a_of_type_Zer == null) {
            this.jdField_a_of_type_Zer = new zer(this);
          }
          this.jdField_a_of_type_Zer.a();
          super.postDelayed(this.jdField_a_of_type_Zer, ViewConfiguration.getLongPressTimeout());
          paramMotionEvent = (ApolloLinearLayout.ViewHolder)this.jdField_a_of_type_AndroidViewView.getTag();
        } while ((paramMotionEvent == null) || (paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView == null) || (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo == null));
        paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838118);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
        return true;
        super.setPressed(false);
        if (this.jdField_a_of_type_Zer != null) {
          super.removeCallbacks(this.jdField_a_of_type_Zer);
        }
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          paramMotionEvent = this.jdField_b_of_type_AndroidViewView;
          if ((paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
          {
            paramMotionEvent = (ApolloLinearLayout.ViewHolder)paramMotionEvent.getTag();
            if (paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView != null) {
              paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
            }
          }
        }
        b();
        this.jdField_a_of_type_AndroidViewView = null;
        return true;
        if ((!this.jdField_b_of_type_Boolean) || ((a(this.jdField_a_of_type_AndroidViewView, jdField_a_of_type_AndroidGraphicsRect)) && (jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))) {
          break label565;
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
            paramMotionEvent = (ApolloLinearLayout.ViewHolder)paramMotionEvent.getTag();
            if (paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView != null) {
              paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
            }
          }
        }
        paramMotionEvent = (ApolloLinearLayout.ViewHolder)this.jdField_a_of_type_AndroidViewView.getTag();
        if ((paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView != null) && (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo != null))
        {
          paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838118);
          this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
        }
      } while ((paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo == null) || (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null) || (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.status != 1) || (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo == null) || (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_b_of_type_Int == 1));
      a(this.jdField_a_of_type_AndroidViewView, paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo);
      return true;
      b();
      return true;
    } while ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_AndroidViewView == null) || ((a(this.jdField_a_of_type_AndroidViewView, jdField_a_of_type_AndroidGraphicsRect)) && (jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))));
    this.jdField_a_of_type_AndroidViewView = null;
    return true;
  }
  
  public void setCallback(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public void setSessionInfo(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloLinearLayout
 * JD-Core Version:    0.7.0.1
 */