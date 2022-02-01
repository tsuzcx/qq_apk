package com.tencent.mobileqq.apollo.view.pannel;

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
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloPanelManager;
import com.tencent.mobileqq.apollo.api.IApolloActionUsedManagerService;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionObserverImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloActionUsedManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
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
  public static Rect a;
  public static int c;
  public static int d;
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  public FrameLayout a;
  public SessionInfo a;
  public BaseChatPie a;
  ApolloExtensionObserverImpl jdField_a_of_type_ComTencentMobileqqApolloApiHandlerImplApolloExtensionObserverImpl = new ApolloLinearLayout.2(this);
  public ApolloLinearLayout.CheckForLongPress a;
  private ApolloLinearLayout.OnSendListener jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayout$OnSendListener;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public boolean a;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView = null;
  public FrameLayout b;
  AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  boolean jdField_b_of_type_Boolean;
  private int e = 0;
  
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
    c();
    if (this.jdField_b_of_type_Int == 4)
    {
      b(paramContext, paramInt2, paramInt3);
      return;
    }
    a(paramContext, paramInt2, paramInt3);
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2)
  {
    float f2 = paramContext.getResources().getDisplayMetrics().density;
    float f1 = DeviceInfoUtil.b(super.getContext()) / 750.0F;
    int m = (int)(15.0F * f1);
    int i = (int)(f1 * 30.0F);
    int n = (DeviceInfoUtil.b(super.getContext()) - m * 2 - i * 8) / 4;
    c = n;
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
        localView = LayoutInflater.from(paramContext).inflate(2131558727, null);
        localLinearLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
        localObject1 = new ApolloLinearLayout.ViewHolder();
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362794));
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363217));
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362792));
        ((ApolloLinearLayout.ViewHolder)localObject1).e = ((ImageView)localView.findViewById(2131362790));
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362791));
        localObject2 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).height = n;
        ((RelativeLayout.LayoutParams)localObject2).width = n;
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362831));
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131362834));
        localObject2 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = (n / 2);
        ((RelativeLayout.LayoutParams)localObject2).height = (n / 2);
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362837));
        localObject2 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = ((AIOUtils.a(8.0F, getResources()) + n) / 2);
        if (XPanelContainer.d <= 0) {
          break label698;
        }
        k = AIOUtils.a(16.0F, getResources());
        label501:
        ((RelativeLayout.LayoutParams)localObject2).height = k;
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362830));
        localObject2 = ((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView;
        if (XPanelContainer.d <= 0) {
          break label713;
        }
        f1 = 8.0F;
        label541:
        ((TextView)localObject2).setTextSize(f1);
        localObject2 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        if (XPanelContainer.d <= 0) {
          break label720;
        }
      }
      label698:
      label713:
      label720:
      for (f1 = 16.0F;; f1 = 10.0F)
      {
        ((RelativeLayout.LayoutParams)localObject2).width = ((n - AIOUtils.a(f1, getResources())) / 2);
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362836));
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362833));
        ((ApolloLinearLayout.ViewHolder)localObject1).d = ((ImageView)localView.findViewById(2131362835));
        ((RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject1).d.getLayoutParams()).width = ((n - AIOUtils.a(4.0F, getResources())) / 2);
        localView.setTag(localObject1);
        j += 1;
        break label220;
        localLayoutParams.topMargin = ((int)(6.0F * f2));
        break;
        k = AIOUtils.a(12.0F, getResources());
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
  
  private static void a(ApolloLinearLayout.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
  
  private void b(Context paramContext, int paramInt1, int paramInt2)
  {
    float f2 = paramContext.getResources().getDisplayMetrics().density;
    int m = (int)((int)((int)((int)(d - (XPanelContainer.d * 0.25D + 50.0F * f2)) - (10.0F * f2 + 10.0F * f2)) - 10.0F * f2) - 40.0F * f2) / 2;
    c = m;
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
        View localView = LayoutInflater.from(paramContext).inflate(2131558728, null);
        localLinearLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
        localObject1 = new ApolloLinearLayout.ViewHolder();
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362794));
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363217));
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362792));
        ((ApolloLinearLayout.ViewHolder)localObject1).e = ((ImageView)localView.findViewById(2131362790));
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362791));
        Object localObject2 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).height = m;
        ((RelativeLayout.LayoutParams)localObject2).width = m;
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362831));
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131362834));
        localObject2 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = (m / 2);
        ((RelativeLayout.LayoutParams)localObject2).height = (m / 2);
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362837));
        localObject2 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = ((AIOUtils.a(8.0F, getResources()) + m) / 2);
        int k;
        if (XPanelContainer.d > 0)
        {
          k = AIOUtils.a(16.0F, getResources());
          label501:
          ((RelativeLayout.LayoutParams)localObject2).height = k;
          ((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362830));
          localObject2 = ((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView;
          if (XPanelContainer.d <= 0) {
            break label699;
          }
          f1 = 8.0F;
          label541:
          ((TextView)localObject2).setTextSize(f1);
          localObject2 = (RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
          if (XPanelContainer.d <= 0) {
            break label706;
          }
        }
        label699:
        label706:
        for (float f1 = 16.0F;; f1 = 10.0F)
        {
          ((RelativeLayout.LayoutParams)localObject2).width = ((m - AIOUtils.a(f1, getResources())) / 2);
          ((ApolloLinearLayout.ViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362836));
          ((ApolloLinearLayout.ViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362833));
          ((ApolloLinearLayout.ViewHolder)localObject1).d = ((ImageView)localView.findViewById(2131362835));
          ((RelativeLayout.LayoutParams)((ApolloLinearLayout.ViewHolder)localObject1).d.getLayoutParams()).width = ((m - AIOUtils.a(4.0F, getResources())) / 2);
          localView.setTag(localObject1);
          j += 1;
          break;
          k = AIOUtils.a(12.0F, getResources());
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
  
  private void c()
  {
    if (d == 0) {
      d = XPanelContainer.jdField_a_of_type_Int;
    }
  }
  
  public static void setApolloActionIcon(int paramInt, ApolloActionData paramApolloActionData, ApolloLinearLayout.ViewHolder paramViewHolder)
  {
    if ((paramInt & 0x1) > 0)
    {
      paramViewHolder.d.setImageResource(2130838696);
      paramViewHolder.d.setVisibility(0);
    }
    if ((paramInt & 0x400) > 0)
    {
      paramViewHolder.d.setImageResource(2130838693);
      paramViewHolder.d.setVisibility(0);
    }
    if ((paramInt & 0x40) > 0) {
      a(paramViewHolder, 2130838686);
    }
    if ((paramInt & 0x80) > 0)
    {
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramApolloActionData.currencyNum));
      a(paramViewHolder, 2130838689);
    }
    if ((paramInt & 0x200) > 0) {
      a(paramViewHolder, 2130838688);
    }
    if ((paramInt & 0x4) > 0) {
      a(paramViewHolder, 2130838695);
    }
    if ((paramInt & 0x8) > 0) {
      a(paramViewHolder, 2130838695);
    }
    if ((paramInt & 0x10) > 0) {
      a(paramViewHolder, 2130838695);
    }
    if ((paramInt & 0x2) > 0) {
      a(paramViewHolder, 2130838691);
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
        localObject3 = ((ApolloLinearLayout.ViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo;
        if ((localObject3 != null) && (((ApolloInfo)localObject3).mAction != null) && (((ApolloInfo)localObject3).mAction.actionId == paramApolloActionData.actionId)) {
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
            ((ApolloLinearLayout.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo = null;
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
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(View paramView)
  {
    Object localObject1 = (ApolloLinearLayout.ViewHolder)paramView.getTag();
    if ((((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mType == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLinearLayout", 2, "apollo shop item = " + paramView.getClass());
      }
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).b(String.valueOf("103100.103200"));
      if (((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null) {
        ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.d();
      }
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null, "aio", ApolloConstant.u, null);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "enter_aio_clk", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "0", "0", "AioMall", String.valueOf(System.currentTimeMillis() / 1000L) });
      }
    }
    label632:
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
                  if ((((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mType == 2))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ApolloLinearLayout", 2, "apollo fav manager item = " + paramView.getClass());
                    }
                    paramView = new Intent();
                    paramView.putExtra("extra_key_url_append", "&view=customize_action");
                    ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramView, "aio", ApolloConstant.u, null);
                    return;
                  }
                } while ((((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo == null) || (((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mAction == null));
                localObject1 = ((ApolloLinearLayout.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo;
                ((ApolloInfo)localObject1).mAction.peerUin = null;
                ((ApolloInfo)localObject1).mAction.boy1 = null;
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloLinearLayout", 2, "click action " + ((ApolloInfo)localObject1).toString());
                }
                if (!ApolloUtilImpl.isActionResDone(((ApolloInfo)localObject1).mAction.actionId, ((ApolloInfo)localObject1).mAction.personNum))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloLinearLayout", 2, "action status = done but res don't exist actionid=" + ((ApolloInfo)localObject1).mAction.actionId);
                  }
                  a(((ApolloInfo)localObject1).mAction);
                }
              } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
              Object localObject2;
              if (CmShowAioMatcher.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1))
              {
                VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_clk", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, -1, 0, new String[] { "" + ((ApolloInfo)localObject1).mAction.actionId, "655_" + ((ApolloInfo)localObject1).mPackageId, "", String.valueOf(System.currentTimeMillis() / 1000L) });
                if (((ApolloInfo)localObject1).mPackageId == 9)
                {
                  VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "y_bqclick", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(((ApolloInfo)localObject1).mAction.personNum), String.valueOf(((ApolloInfo)localObject1).mAction.actionId), "", "" });
                  ApolloDtReportUtil.a("panel", "sticker", "click", new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)).c(String.valueOf(((ApolloInfo)localObject1).mAction.actionId)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a());
                }
                if (this.e != 1) {
                  break label1366;
                }
                ApolloDtReportUtil.a("aio", "emojicmtab", "clicksticker", new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)).c(String.valueOf(((ApolloInfo)localObject1).mAction.actionId)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a());
                if ((ApolloDtReportUtil.a.containsKey(Integer.valueOf(((ApolloInfo)localObject1).mPackageId))) && (ApolloDtReportUtil.a.get(Integer.valueOf(((ApolloInfo)localObject1).mPackageId)) != null))
                {
                  localObject2 = new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
                  if (((ApolloInfo)localObject1).mPackageId != 9) {
                    break label1446;
                  }
                }
              }
              boolean bool1;
              for (int i = 1;; i = 0)
              {
                ApolloDtReportUtil.a("aio", "tagpage", "clicktagaction", ((ApolloDtReportUtil.DtReportParamsBuilder)localObject2).c(i).e(((ApolloInfo)localObject1).mAction.personNum).a((String)ApolloDtReportUtil.a.get(Integer.valueOf(((ApolloInfo)localObject1).mPackageId))).a());
                localObject2 = (ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
                bool1 = ((ApolloDaoManagerServiceImpl)localObject2).isObtainActionById(((ApolloInfo)localObject1).mAction.actionId);
                bool2 = ((ApolloDaoManagerServiceImpl)localObject2).isLimitFreeActionById(((ApolloInfo)localObject1).mAction.actionId);
                if (((((ApolloInfo)localObject1).mAction.feeType != 6) && (((ApolloInfo)localObject1).mAction.feeType != 7)) || (bool1) || (bool2)) {
                  break label1451;
                }
                ImageView localImageView = (ImageView)paramView.findViewById(2131379428);
                ((RelativeLayout.LayoutParams)localImageView.getLayoutParams()).topMargin = ((int)(c / 2 - 7.0F * super.getResources().getDisplayMetrics().density));
                localImageView.setVisibility(0);
                paramView.setClickable(false);
                if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
                  break;
                }
                b(((ApolloDaoManagerServiceImpl)localObject2).findActionById(((ApolloInfo)localObject1).mAction.actionId));
                return;
                if (!CmShowAioMatcher.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 2)) {
                  break label632;
                }
                if (((ApolloInfo)localObject1).mAction.personNum == 0)
                {
                  VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "g_action_single_clk", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, -1, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), new String[] { "" + ((ApolloInfo)localObject1).mAction.actionId, "655_" + ((ApolloInfo)localObject1).mPackageId, "", String.valueOf(System.currentTimeMillis() / 1000L) });
                  break label632;
                }
                if (((ApolloInfo)localObject1).mAction.personNum != 1) {
                  break label632;
                }
                break label632;
                ApolloDtReportUtil.a("panel", ApolloDtReportUtil.a(((ApolloInfo)localObject1).mPackageId), "click", new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)).c(String.valueOf(((ApolloInfo)localObject1).mAction.actionId)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a());
                break label886;
              }
              if ((((ApolloInfo)localObject1).mAction.feeType != 2) || (bool1) || (bool2)) {
                break;
              }
            } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
            paramView = ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloPanelManager();
          } while (paramView == null);
          paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, (ApolloInfo)localObject1);
          return;
        } while ((((ApolloInfo)localObject1).mAction.feeType == 9) && (!bool2) && (!a(((ApolloInfo)localObject1).mAction)));
        paramView = ((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloPanelManager();
      } while (paramView == null);
      paramView.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, (ApolloInfo)localObject1);
      if ((((ApolloInfo)localObject1).mPackageId == 0) || (((ApolloInfo)localObject1).mPackageId == 1) || (((ApolloInfo)localObject1).mPackageId == 9)) {
        ((ApolloActionUsedManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloActionUsedManagerService.class, "all")).saveActionIdData(((ApolloInfo)localObject1).mPackageId, ((ApolloInfo)localObject1).mAction.actionId);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayout$OnSendListener == null);
    label886:
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayout$OnSendListener.a();
    label1366:
  }
  
  public void a(View paramView, ApolloInfo paramApolloInfo)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramApolloInfo);
  }
  
  public void a(BaseChatPie paramBaseChatPie, ApolloInfo paramApolloInfo)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramApolloInfo == null)) {}
    ApolloPanelManager localApolloPanelManager;
    do
    {
      return;
      localApolloPanelManager = ((ApolloManagerServiceImpl)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloPanelManager();
    } while (localApolloPanelManager == null);
    localApolloPanelManager.c(paramBaseChatPie, paramApolloInfo);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramApolloActionData == null)) {
      return false;
    }
    Object localObject = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    HashMap localHashMap = new HashMap();
    new StringBuilder().append(ApolloConstant.f).append("&actionId=").append(paramApolloActionData.actionId).append("&_bid=2282").toString();
    if (!((ApolloManagerServiceImpl)localObject).isSuperYellow(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))
    {
      localObject = super.getResources().getString(2131690124);
      String str1 = super.getResources().getString(2131690125);
      String str2 = super.getResources().getString(2131690123);
      String str3 = ApolloConstant.f + "&actionId=" + paramApolloActionData.actionId + "&_bid=2282";
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "vip_alert_show", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + paramApolloActionData.actionId, "0" });
      }
      localHashMap.put("APOLLO_POP_TYPE", "dialog");
      localHashMap.put("feeType", String.valueOf(paramApolloActionData.feeType));
      localHashMap.put("title", str1);
      localHashMap.put("content", localObject);
      localHashMap.put("rightString", str2);
      localHashMap.put("url", str3);
      localHashMap.put("actionId", "" + paramApolloActionData.actionId);
      localHashMap.put("personNum", String.valueOf(paramApolloActionData.personNum));
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
        return false;
      }
      paramApolloActionData = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramApolloActionData == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerImplApolloExtensionObserverImpl);
    ((ApolloExtensionHandlerImpl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(paramApolloActionData.actionId, null, null, 0, 0.0F, 0, "actionPanel");
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
          if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayout$CheckForLongPress == null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayout$CheckForLongPress = new ApolloLinearLayout.CheckForLongPress(this);
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayout$CheckForLongPress.a();
          super.postDelayed(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayout$CheckForLongPress, ViewConfiguration.getLongPressTimeout());
          paramMotionEvent = (ApolloLinearLayout.ViewHolder)this.jdField_a_of_type_AndroidViewView.getTag();
        } while ((paramMotionEvent == null) || (paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView == null) || (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo == null));
        paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838681);
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
            paramMotionEvent = (ApolloLinearLayout.ViewHolder)paramMotionEvent.getTag();
            if (paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView != null) {
              paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
            }
          }
        }
        paramMotionEvent = (ApolloLinearLayout.ViewHolder)this.jdField_a_of_type_AndroidViewView.getTag();
        if ((paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView != null) && (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo != null))
        {
          paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838681);
          this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
        }
      } while ((paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo == null) || (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mAction == null) || (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo == null) || (paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mType == 1));
      a(this.jdField_a_of_type_AndroidViewView, paramMotionEvent.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo);
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
  
  public void setOnSendListener(ApolloLinearLayout.OnSendListener paramOnSendListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayout$OnSendListener = paramOnSendListener;
  }
  
  public void setPanelType(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setSessionInfo(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloLinearLayout
 * JD-Core Version:    0.7.0.1
 */