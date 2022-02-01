package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Message;
import android.util.AttributeSet;
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
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelManager;
import com.tencent.mobileqq.apollo.api.IApolloActionUsedManager;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloActionUsedManagerImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.emotionview.EmoticonPanelCmShowHelper;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class ApolloLinearLayout
  extends LinearLayout
{
  public static int a;
  public static Rect a;
  View jdField_a_of_type_AndroidViewView = null;
  public FrameLayout a;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  ApolloExtensionObserver jdField_a_of_type_ComTencentMobileqqApolloHandlerApolloExtensionObserver = new ApolloLinearLayout.2(this);
  public ApolloLinearLayout.CheckForLongPress a;
  private ApolloLinearLayout.OnSendListener jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$OnSendListener;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public boolean a;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  public FrameLayout b;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  boolean jdField_b_of_type_Boolean;
  private int c = 0;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public ApolloLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public ApolloLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    super.setOrientation(1);
    this.jdField_b_of_type_Int = paramInt1;
    if (this.jdField_b_of_type_Int == 4)
    {
      b(paramContext, paramInt2, paramInt3);
      return;
    }
    a(paramContext, paramInt2, paramInt3);
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2)
  {
    float f1 = DeviceInfoUtil.b(super.getContext()) / 750.0F;
    int m = (int)(15.0F * f1);
    int i = (int)(f1 * 30.0F);
    int n = (DeviceInfoUtil.b(super.getContext()) - m * 2 - i * 8) / 4;
    jdField_a_of_type_Int = n;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("panel height = ");
      ((StringBuilder)localObject1).append(XPanelContainer.jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append("imgHeight = ");
      ((StringBuilder)localObject1).append(n);
      ((StringBuilder)localObject1).append("addHeight=");
      ((StringBuilder)localObject1).append(XPanelContainer.d);
      QLog.d("[cmshow]ApolloLinearLayout", 2, ((StringBuilder)localObject1).toString());
    }
    i = 0;
    while (i < paramInt2)
    {
      localObject1 = new LinearLayout(paramContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, ViewUtils.a(14.0F) + n + ViewUtils.a(6.0F));
      localLayoutParams.leftMargin = m;
      localLayoutParams.rightMargin = m;
      ((LinearLayout)localObject1).setOrientation(0);
      ((LinearLayout)localObject1).setShowDividers(0);
      if (i == 0) {
        localLayoutParams.topMargin = ViewUtils.a(10.0F);
      } else {
        localLayoutParams.topMargin = ViewUtils.a(6.0F);
      }
      int j = 0;
      while (j < paramInt1)
      {
        Object localObject2 = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
        View localView = LayoutInflater.from(paramContext).inflate(2131558624, null);
        ((LinearLayout)localObject1).addView(localView, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new ApolloLinearLayout.ViewHolder();
        ((ApolloLinearLayout.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362744));
        ((ApolloLinearLayout.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363156));
        ((ApolloLinearLayout.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362742));
        ((ApolloLinearLayout.ViewHolder)localObject2).e = ((ImageView)localView.findViewById(2131362740));
        ((ApolloLinearLayout.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362741));
        Object localObject3 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject3).height = n;
        ((RelativeLayout.LayoutParams)localObject3).width = n;
        ((ApolloLinearLayout.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362775));
        ((ApolloLinearLayout.ViewHolder)localObject2).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131362778));
        localObject3 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject2).jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        int k = n / 2;
        ((RelativeLayout.LayoutParams)localObject3).width = k;
        ((RelativeLayout.LayoutParams)localObject3).height = k;
        ((ApolloLinearLayout.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362781));
        localObject3 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        f1 = 8.0F;
        ((RelativeLayout.LayoutParams)localObject3).width = ((n + ViewUtils.a(8.0F)) / 2);
        k = XPanelContainer.d;
        float f2 = 16.0F;
        if (k > 0) {
          k = ViewUtils.a(16.0F);
        } else {
          k = ViewUtils.a(12.0F);
        }
        ((RelativeLayout.LayoutParams)localObject3).height = k;
        ((ApolloLinearLayout.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362774));
        localObject3 = ((ApolloLinearLayout.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView;
        if (XPanelContainer.d <= 0) {
          f1 = 6.0F;
        }
        ((TextView)localObject3).setTextSize(f1);
        localObject3 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        if (XPanelContainer.d > 0) {
          f1 = f2;
        } else {
          f1 = 10.0F;
        }
        ((RelativeLayout.LayoutParams)localObject3).width = ((n - ViewUtils.a(f1)) / 2);
        ((ApolloLinearLayout.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362780));
        ((ApolloLinearLayout.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362777));
        ((ApolloLinearLayout.ViewHolder)localObject2).d = ((ImageView)localView.findViewById(2131362779));
        ((RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject2).d.getLayoutParams()).width = ((n - ViewUtils.a(4.0F)) / 2);
        localView.setTag(localObject2);
        j += 1;
      }
      super.addView((View)localObject1, localLayoutParams);
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
    int m = (int)((DeviceInfoUtil.b(super.getContext()) - (ViewUtils.a(20.0F) + ViewUtils.a(10.0F) + ViewUtils.a(20.0F))) / 2 * 0.3765432F);
    jdField_a_of_type_Int = m;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("panel height = ");
      ((StringBuilder)localObject1).append(XPanelContainer.jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append("imgHeight = ");
      ((StringBuilder)localObject1).append(m);
      ((StringBuilder)localObject1).append("addHeight=");
      ((StringBuilder)localObject1).append(XPanelContainer.d);
      QLog.d("[cmshow]ApolloLinearLayout", 2, ((StringBuilder)localObject1).toString());
    }
    int i = 0;
    while (i < paramInt2)
    {
      localObject1 = new LinearLayout(paramContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, m);
      localLayoutParams.leftMargin = ViewUtils.a(10.0F);
      localLayoutParams.rightMargin = ViewUtils.a(20.0F);
      ((LinearLayout)localObject1).setOrientation(0);
      if (i == 1) {
        localLayoutParams.topMargin = ViewUtils.a(10.0F);
      }
      int j = 0;
      while (j < paramInt1)
      {
        Object localObject2 = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = ViewUtils.a(10.0F);
        View localView = LayoutInflater.from(paramContext).inflate(2131558625, null);
        ((LinearLayout)localObject1).addView(localView, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new ApolloLinearLayout.ViewHolder();
        ((ApolloLinearLayout.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362744));
        ((ApolloLinearLayout.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363156));
        ((ApolloLinearLayout.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362742));
        ((ApolloLinearLayout.ViewHolder)localObject2).e = ((ImageView)localView.findViewById(2131362740));
        ((ApolloLinearLayout.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362741));
        Object localObject3 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject3).height = m;
        ((RelativeLayout.LayoutParams)localObject3).width = m;
        ((ApolloLinearLayout.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362775));
        ((ApolloLinearLayout.ViewHolder)localObject2).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131362778));
        localObject3 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject2).jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        int k = m / 2;
        ((RelativeLayout.LayoutParams)localObject3).width = k;
        ((RelativeLayout.LayoutParams)localObject3).height = k;
        ((ApolloLinearLayout.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362781));
        localObject3 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        float f1 = 8.0F;
        ((RelativeLayout.LayoutParams)localObject3).width = ((m + ViewUtils.a(8.0F)) / 2);
        k = XPanelContainer.d;
        float f2 = 16.0F;
        if (k > 0) {
          k = ViewUtils.a(16.0F);
        } else {
          k = ViewUtils.a(12.0F);
        }
        ((RelativeLayout.LayoutParams)localObject3).height = k;
        ((ApolloLinearLayout.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362774));
        localObject3 = ((ApolloLinearLayout.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView;
        if (XPanelContainer.d <= 0) {
          f1 = 6.0F;
        }
        ((TextView)localObject3).setTextSize(f1);
        localObject3 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        if (XPanelContainer.d > 0) {
          f1 = f2;
        } else {
          f1 = 10.0F;
        }
        ((RelativeLayout.LayoutParams)localObject3).width = ((m - ViewUtils.a(f1)) / 2);
        ((ApolloLinearLayout.ViewHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362780));
        ((ApolloLinearLayout.ViewHolder)localObject2).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362777));
        ((ApolloLinearLayout.ViewHolder)localObject2).d = ((ImageView)localView.findViewById(2131362779));
        ((RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject2).d.getLayoutParams()).width = ((m - ViewUtils.a(4.0F)) / 2);
        localView.setTag(localObject2);
        j += 1;
      }
      super.addView((View)localObject1, localLayoutParams);
      i += 1;
    }
    super.setTag(Integer.valueOf(XPanelContainer.d));
  }
  
  public static void setApolloActionIcon(int paramInt, ApolloActionData paramApolloActionData, ApolloLinearLayout.ViewHolder paramViewHolder)
  {
    if ((paramInt & 0x1) > 0)
    {
      paramViewHolder.d.setImageResource(2130838541);
      paramViewHolder.d.setVisibility(0);
    }
    if ((paramInt & 0x400) > 0)
    {
      paramViewHolder.d.setImageResource(2130838538);
      paramViewHolder.d.setVisibility(0);
    }
    if ((paramInt & 0x40) > 0) {
      a(paramViewHolder, 2130838525);
    }
    if ((paramInt & 0x80) > 0)
    {
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramApolloActionData.currencyNum));
      a(paramViewHolder, 2130838534);
    }
    if ((paramInt & 0x200) > 0) {
      a(paramViewHolder, 2130838527);
    }
    if ((paramInt & 0x4) > 0) {
      a(paramViewHolder, 2130838540);
    }
    if ((paramInt & 0x8) > 0) {
      a(paramViewHolder, 2130838540);
    }
    if ((paramInt & 0x10) > 0) {
      a(paramViewHolder, 2130838540);
    }
    if ((paramInt & 0x2) > 0) {
      a(paramViewHolder, 2130838536);
    }
    if ((paramInt & 0x2000) > 0)
    {
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      ApolloUtilImpl.setApolloVipIcon(paramViewHolder.jdField_b_of_type_AndroidWidgetImageView, true, true);
    }
    paramApolloActionData = (RelativeLayout.LayoutParams)paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    if (paramApolloActionData != null)
    {
      paramApolloActionData.addRule(9);
      paramApolloActionData.addRule(11, 0);
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
    if (paramApolloActionData == null) {
      return null;
    }
    Object localObject1 = null;
    int i = 0;
    while (i < super.getChildCount())
    {
      LinearLayout localLinearLayout = (LinearLayout)super.getChildAt(i);
      int j = 0;
      Object localObject2;
      for (;;)
      {
        localObject2 = localObject1;
        if (j >= localLinearLayout.getChildCount()) {
          break;
        }
        localObject2 = localLinearLayout.getChildAt(j);
        Object localObject3 = (ApolloLinearLayout.ViewHolder)((View)localObject2).getTag();
        if (localObject3 != null)
        {
          localObject3 = ((ApolloLinearLayout.ViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo;
          if ((localObject3 != null) && (((ApolloInfo)localObject3).mAction != null) && (((ApolloInfo)localObject3).mAction.actionId == paramApolloActionData.actionId)) {
            break;
          }
        }
        j += 1;
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
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
            ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo = null;
            ((ApolloLinearLayout.ViewHolder)localObject).jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            ((ApolloLinearLayout.ViewHolder)localObject).e.setVisibility(8);
            if (((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null) {
              ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.d();
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
  }
  
  public void a(View paramView)
  {
    Object localObject1 = (ApolloLinearLayout.ViewHolder)paramView.getTag();
    Object localObject2;
    if ((((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mType == 1))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("apollo shop item = ");
        ((StringBuilder)localObject2).append(paramView.getClass());
        QLog.d("[cmshow]ApolloLinearLayout", 2, ((StringBuilder)localObject2).toString());
      }
      ((IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("103100.103200");
      if (((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null) {
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.d();
      }
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, "aio", ApolloConstant.z, null);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "enter_aio_clk", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "0", "0", "AioMall", String.valueOf(System.currentTimeMillis() / 1000L) });
      }
      return;
    }
    if ((((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mType == 2))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("apollo fav manager item = ");
        ((StringBuilder)localObject1).append(paramView.getClass());
        QLog.d("[cmshow]ApolloLinearLayout", 2, ((StringBuilder)localObject1).toString());
      }
      paramView = new Intent();
      paramView.putExtra("extra_key_url_append", "&view=customize_action");
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, "aio", ApolloConstant.z, null);
      return;
    }
    if (((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo != null)
    {
      if (((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mAction == null) {
        return;
      }
      localObject1 = ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo;
      ((ApolloInfo)localObject1).mAction.peerUin = null;
      ((ApolloInfo)localObject1).mAction.boy1 = null;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("click action ");
        ((StringBuilder)localObject2).append(((ApolloInfo)localObject1).toString());
        QLog.d("[cmshow]ApolloLinearLayout", 2, ((StringBuilder)localObject2).toString());
      }
      if (!CMResUtil.a(((ApolloInfo)localObject1).mAction.actionId, ((ApolloInfo)localObject1).mAction.personNum))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("action status = done but res don't exist actionid=");
          ((StringBuilder)localObject2).append(((ApolloInfo)localObject1).mAction.actionId);
          QLog.d("[cmshow]ApolloLinearLayout", 2, ((StringBuilder)localObject2).toString());
        }
        a(((ApolloInfo)localObject1).mAction);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if (localObject2 != null)
      {
        if (((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          return;
        }
        Object localObject3;
        Object localObject4;
        StringBuilder localStringBuilder;
        int i;
        if (CmShowAioMatcherImpl.judgeSupported(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("");
          ((StringBuilder)localObject4).append(((ApolloInfo)localObject1).mAction.actionId);
          localObject4 = ((StringBuilder)localObject4).toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("655_");
          localStringBuilder.append(((ApolloInfo)localObject1).mPackageId);
          VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "action_clk", (String)localObject3, -1, 0, new String[] { localObject4, localStringBuilder.toString(), "", String.valueOf(System.currentTimeMillis() / 1000L) });
        }
        else if (CmShowAioMatcherImpl.judgeSupported(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 2))
        {
          if (((ApolloInfo)localObject1).mAction.personNum == 0)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
            i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("");
            ((StringBuilder)localObject4).append(((ApolloInfo)localObject1).mAction.actionId);
            localObject4 = ((StringBuilder)localObject4).toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("655_");
            localStringBuilder.append(((ApolloInfo)localObject1).mPackageId);
            VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "g_action_single_clk", (String)localObject3, -1, i, new String[] { localObject4, localStringBuilder.toString(), "", String.valueOf(System.currentTimeMillis() / 1000L) });
          }
          else
          {
            i = ((ApolloInfo)localObject1).mAction.personNum;
          }
        }
        if (((ApolloInfo)localObject1).mPackageId == 9)
        {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "y_bqclick", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(((ApolloInfo)localObject1).mAction.personNum), String.valueOf(((ApolloInfo)localObject1).mAction.actionId), "", "" });
          ApolloDtReportUtil.a("panel", "sticker", "click", new DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)).c(String.valueOf(((ApolloInfo)localObject1).mAction.actionId)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a());
        }
        if (this.c == 1) {
          ApolloDtReportUtil.a("aio", "emojicmtab", "clicksticker", new DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)).c(String.valueOf(((ApolloInfo)localObject1).mAction.actionId)).h(EmoticonPanelCmShowHelper.a()).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a());
        } else {
          ApolloDtReportUtil.a("panel", ApolloDtReportUtil.a(((ApolloInfo)localObject1).mPackageId), "click", new DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)).c(String.valueOf(((ApolloInfo)localObject1).mAction.actionId)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a());
        }
        if ((ApolloDtReportUtil.a.containsKey(Integer.valueOf(((ApolloInfo)localObject1).mPackageId))) && (ApolloDtReportUtil.a.get(Integer.valueOf(((ApolloInfo)localObject1).mPackageId)) != null))
        {
          localObject2 = new DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
          if (((ApolloInfo)localObject1).mPackageId == 9) {
            i = 1;
          } else {
            i = 0;
          }
          ApolloDtReportUtil.a("aio", "tagpage", "clicktagaction", ((DtReportParamsBuilder)localObject2).c(i).e(((ApolloInfo)localObject1).mAction.personNum).a((String)ApolloDtReportUtil.a.get(Integer.valueOf(((ApolloInfo)localObject1).mPackageId))).a());
        }
        localObject2 = (ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
        boolean bool1 = ((ApolloDaoManagerServiceImpl)localObject2).isObtainActionById(((ApolloInfo)localObject1).mAction.actionId);
        boolean bool2 = ((ApolloDaoManagerServiceImpl)localObject2).isLimitFreeActionById(((ApolloInfo)localObject1).mAction.actionId);
        if (((((ApolloInfo)localObject1).mAction.feeType == 6) || (((ApolloInfo)localObject1).mAction.feeType == 7)) && (!bool1) && (!bool2))
        {
          localObject3 = (ImageView)paramView.findViewById(2131378780);
          ((RelativeLayout.LayoutParams)((ImageView)localObject3).getLayoutParams()).topMargin = (jdField_a_of_type_Int / 2 - ViewUtils.a(7.0F));
          ((ImageView)localObject3).setVisibility(0);
          paramView.setClickable(false);
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
          if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
            b(((ApolloDaoManagerServiceImpl)localObject2).findActionById(((ApolloInfo)localObject1).mAction.actionId));
          }
          return;
        }
        if ((((ApolloInfo)localObject1).mAction.feeType == 2) && (!bool1) && (!bool2))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
          if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
          {
            paramView = ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloPanelManager();
            if (paramView != null) {
              paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, (ApolloInfo)localObject1);
            }
          }
          return;
        }
        if ((((ApolloInfo)localObject1).mAction.feeType == 9) && (!bool2) && (!a(((ApolloInfo)localObject1).mAction))) {
          return;
        }
        paramView = ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloPanelManager();
        if (paramView != null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
          if (localObject2 != null)
          {
            paramView.a(((BaseChatPie)localObject2).b(), (ApolloInfo)localObject1);
            if ((((ApolloInfo)localObject1).mPackageId == 0) || (((ApolloInfo)localObject1).mPackageId == 1) || (((ApolloInfo)localObject1).mPackageId == 9)) {
              ((ApolloActionUsedManagerImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloActionUsedManager.class, "all")).saveActionIdData(((ApolloInfo)localObject1).mPackageId, ((ApolloInfo)localObject1).mAction.actionId);
            }
            paramView = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$OnSendListener;
            if (paramView != null) {
              paramView.a();
            }
          }
        }
      }
    }
  }
  
  public void a(View paramView, ApolloInfo paramApolloInfo)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramApolloInfo);
  }
  
  protected void a(BaseChatPie paramBaseChatPie, ApolloInfo paramApolloInfo)
  {
    if ((paramBaseChatPie != null) && (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (paramApolloInfo == null) {
        return;
      }
      ApolloPanelManager localApolloPanelManager = ((ApolloManagerServiceImpl)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloPanelManager();
      if (localApolloPanelManager != null) {
        localApolloPanelManager.b(paramBaseChatPie, paramApolloInfo);
      }
    }
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        if (paramApolloActionData == null) {
          return false;
        }
        Object localObject2 = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
        localObject1 = new HashMap();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(ApolloConstant.k);
        ((StringBuilder)localObject3).append("&actionId=");
        ((StringBuilder)localObject3).append(paramApolloActionData.actionId);
        ((StringBuilder)localObject3).append("&_bid=2282");
        ((StringBuilder)localObject3).toString();
        if (!((ApolloManagerServiceImpl)localObject2).isSuperYellow(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))
        {
          localObject2 = super.getResources().getString(2131690041);
          localObject3 = super.getResources().getString(2131690042);
          String str = super.getResources().getString(2131690040);
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(ApolloConstant.k);
          ((StringBuilder)localObject4).append("&actionId=");
          ((StringBuilder)localObject4).append(paramApolloActionData.actionId);
          ((StringBuilder)localObject4).append("&_bid=2282");
          localObject4 = ((StringBuilder)localObject4).toString();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
          {
            QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            int i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(paramApolloActionData.actionId);
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "vip_alert_show", i, 0, new String[] { localStringBuilder.toString(), "0" });
          }
          ((Map)localObject1).put("APOLLO_POP_TYPE", "dialog");
          ((Map)localObject1).put("feeType", String.valueOf(paramApolloActionData.feeType));
          ((Map)localObject1).put("title", localObject3);
          ((Map)localObject1).put("content", localObject2);
          ((Map)localObject1).put("rightString", str);
          ((Map)localObject1).put("url", localObject4);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(paramApolloActionData.actionId);
          ((Map)localObject1).put("actionId", ((StringBuilder)localObject2).toString());
          ((Map)localObject1).put("personNum", String.valueOf(paramApolloActionData.personNum));
          paramApolloActionData = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
          if (paramApolloActionData != null)
          {
            if (paramApolloActionData.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
              return false;
            }
            paramApolloActionData = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
            bool1 = bool2;
            if (paramApolloActionData != null)
            {
              paramApolloActionData = paramApolloActionData.obtainMessage(45);
              paramApolloActionData.obj = localObject1;
              paramApolloActionData.sendToTarget();
              return false;
            }
          }
          else
          {
            return false;
          }
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
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
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (paramApolloActionData == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloHandlerApolloExtensionObserver);
      ((ApolloExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(paramApolloActionData.actionId, null, null, 0, 0.0F, 0, "actionPanel");
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
          super.setPressed(false);
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$CheckForLongPress;
          if (paramMotionEvent != null) {
            super.removeCallbacks(paramMotionEvent);
          }
          paramMotionEvent = this.jdField_a_of_type_AndroidViewView;
          if ((paramMotionEvent != null) && (paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
          {
            paramMotionEvent = (ApolloLinearLayout.ViewHolder)paramMotionEvent.getTag();
            if (paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView != null) {
              paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
            }
          }
          b();
          this.jdField_b_of_type_AndroidViewView = null;
          return true;
        }
        if ((this.jdField_b_of_type_Boolean) && ((!a(this.jdField_b_of_type_AndroidViewView, jdField_a_of_type_AndroidGraphicsRect)) || (!jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
        {
          this.jdField_b_of_type_AndroidViewView = a(paramMotionEvent.getX(), paramMotionEvent.getY());
          paramMotionEvent = this.jdField_b_of_type_AndroidViewView;
          if ((paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
          {
            paramMotionEvent = this.jdField_a_of_type_AndroidViewView;
            if ((paramMotionEvent != null) && (paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
            {
              paramMotionEvent = (ApolloLinearLayout.ViewHolder)paramMotionEvent.getTag();
              if (paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView != null) {
                paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
              }
            }
            paramMotionEvent = (ApolloLinearLayout.ViewHolder)this.jdField_b_of_type_AndroidViewView.getTag();
            if ((paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView != null) && (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo != null))
            {
              paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838520);
              this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
            }
            if (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo != null)
            {
              if (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mAction == null) {
                return true;
              }
              if ((paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo != null) && (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mType != 1))
              {
                a(this.jdField_b_of_type_AndroidViewView, paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo);
                return true;
              }
            }
          }
          else
          {
            b();
            return true;
          }
        }
        else if (!this.jdField_b_of_type_Boolean)
        {
          View localView = this.jdField_b_of_type_AndroidViewView;
          if ((localView != null) && ((!a(localView, jdField_a_of_type_AndroidGraphicsRect)) || (!jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
          {
            this.jdField_b_of_type_AndroidViewView = null;
            return true;
          }
        }
      }
      else
      {
        if (!this.jdField_b_of_type_Boolean)
        {
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$CheckForLongPress;
          if (paramMotionEvent != null) {
            super.removeCallbacks(paramMotionEvent);
          }
        }
        paramMotionEvent = this.jdField_b_of_type_AndroidViewView;
        if ((paramMotionEvent != null) && (!this.jdField_b_of_type_Boolean)) {
          a(paramMotionEvent);
        }
        paramMotionEvent = this.jdField_a_of_type_AndroidViewView;
        if ((paramMotionEvent != null) && (paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
        {
          paramMotionEvent = (ApolloLinearLayout.ViewHolder)paramMotionEvent.getTag();
          if (paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView != null) {
            paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
          }
        }
        b();
        this.jdField_b_of_type_AndroidViewView = null;
        return true;
      }
    }
    else
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_b_of_type_AndroidViewView = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$CheckForLongPress == null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$CheckForLongPress = new ApolloLinearLayout.CheckForLongPress(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$CheckForLongPress.a();
        super.postDelayed(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$CheckForLongPress, ViewConfiguration.getLongPressTimeout());
        paramMotionEvent = (ApolloLinearLayout.ViewHolder)this.jdField_b_of_type_AndroidViewView.getTag();
        if ((paramMotionEvent != null) && (paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView != null) && (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo != null))
        {
          paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838520);
          this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
        }
      }
    }
    return true;
  }
  
  public void setCallback(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public void setOnSendListener(ApolloLinearLayout.OnSendListener paramOnSendListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$OnSendListener = paramOnSendListener;
  }
  
  public void setPanelType(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setSessionInfo(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloLinearLayout
 * JD-Core Version:    0.7.0.1
 */