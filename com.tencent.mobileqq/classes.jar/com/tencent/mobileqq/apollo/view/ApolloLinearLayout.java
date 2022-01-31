package com.tencent.mobileqq.apollo.view;

import actn;
import airz;
import aisr;
import ajmu;
import ajmw;
import ajpz;
import ajqa;
import ajqb;
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
import avpq;
import bbqp;
import bbqu;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.redtouch.RedTouch;
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
  public static int e;
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  public FrameLayout a;
  public bbqu a;
  public BaseChatPie a;
  public SessionInfo a;
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
    this.jdField_a_of_type_Bbqu = new ajqa(this);
  }
  
  public ApolloLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_Bbqu = new ajqa(this);
    super.setOrientation(1);
    this.d = paramInt1;
    if (this.d == 4)
    {
      b(paramContext, paramInt2, paramInt3);
      return;
    }
    a(paramContext, paramInt2, paramInt3);
  }
  
  private static void a(ajqb paramajqb, int paramInt)
  {
    paramajqb.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    paramajqb.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramInt);
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
            break label773;
          }
          localObject1 = new LinearLayout.LayoutParams(-1, -1);
          ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
          localView = LayoutInflater.from(paramContext).inflate(2131558619, null);
          localLinearLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
          localObject1 = new ajqb();
          ((ajqb)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362590));
          ((ajqb)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362961));
          ((ajqb)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362588));
          ((ajqb)localObject1).e = ((ImageView)localView.findViewById(2131362586));
          ((ajqb)localObject1).jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362587));
          localObject2 = (RelativeLayout.LayoutParams)((ajqb)localObject1).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).height = m;
          ((RelativeLayout.LayoutParams)localObject2).width = m;
          ((ajqb)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362624));
          ((ajqb)localObject1).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131362627));
          localObject2 = (RelativeLayout.LayoutParams)((ajqb)localObject1).jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).width = (m / 2);
          ((RelativeLayout.LayoutParams)localObject2).height = (m / 2);
          ((ajqb)localObject1).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362630));
          localObject2 = (RelativeLayout.LayoutParams)((ajqb)localObject1).jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).width = ((actn.a(8.0F, getResources()) + m) / 2);
          if (XPanelContainer.d <= 0) {
            break label745;
          }
          k = actn.a(16.0F, getResources());
          label536:
          ((RelativeLayout.LayoutParams)localObject2).height = k;
          ((ajqb)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362623));
          localObject2 = ((ajqb)localObject1).jdField_b_of_type_AndroidWidgetTextView;
          if (XPanelContainer.d <= 0) {
            break label759;
          }
          f1 = 8.0F;
          label575:
          ((TextView)localObject2).setTextSize(f1);
          localObject2 = (RelativeLayout.LayoutParams)((ajqb)localObject1).jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
          if (XPanelContainer.d <= 0) {
            break label766;
          }
        }
      }
      label745:
      label759:
      label766:
      for (float f1 = 16.0F;; f1 = 10.0F)
      {
        ((RelativeLayout.LayoutParams)localObject2).width = ((m - actn.a(f1, getResources())) / 2);
        ((ajqb)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362629));
        ((ajqb)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362626));
        ((ajqb)localObject1).d = ((ImageView)localView.findViewById(2131362628));
        ((RelativeLayout.LayoutParams)((ajqb)localObject1).d.getLayoutParams()).width = ((m - actn.a(4.0F, getResources())) / 2);
        localView.setTag(localObject1);
        j += 1;
        break label256;
        localLayoutParams.topMargin = ((int)(12.0F * f2));
        break;
        localLayoutParams.topMargin = ((int)(6.0F * f2));
        break;
        k = actn.a(12.0F, getResources());
        break label536;
        f1 = 6.0F;
        break label575;
      }
      label773:
      super.addView(localLinearLayout, localLayoutParams);
      i += 1;
    }
    super.setTag(Integer.valueOf(XPanelContainer.d));
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
        View localView = LayoutInflater.from(paramContext).inflate(2131558620, null);
        localLinearLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
        localObject1 = new ajqb();
        ((ajqb)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362590));
        ((ajqb)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362961));
        ((ajqb)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362588));
        ((ajqb)localObject1).e = ((ImageView)localView.findViewById(2131362586));
        ((ajqb)localObject1).jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362587));
        Object localObject2 = (RelativeLayout.LayoutParams)((ajqb)localObject1).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).height = m;
        ((RelativeLayout.LayoutParams)localObject2).width = m;
        ((ajqb)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362624));
        ((ajqb)localObject1).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131362627));
        localObject2 = (RelativeLayout.LayoutParams)((ajqb)localObject1).jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = (m / 2);
        ((RelativeLayout.LayoutParams)localObject2).height = (m / 2);
        ((ajqb)localObject1).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362630));
        localObject2 = (RelativeLayout.LayoutParams)((ajqb)localObject1).jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = ((actn.a(8.0F, getResources()) + m) / 2);
        int k;
        if (XPanelContainer.d > 0)
        {
          k = actn.a(16.0F, getResources());
          label499:
          ((RelativeLayout.LayoutParams)localObject2).height = k;
          ((ajqb)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362623));
          localObject2 = ((ajqb)localObject1).jdField_b_of_type_AndroidWidgetTextView;
          if (XPanelContainer.d <= 0) {
            break label694;
          }
          f1 = 8.0F;
          label538:
          ((TextView)localObject2).setTextSize(f1);
          localObject2 = (RelativeLayout.LayoutParams)((ajqb)localObject1).jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
          if (XPanelContainer.d <= 0) {
            break label701;
          }
        }
        label694:
        label701:
        for (float f1 = 16.0F;; f1 = 10.0F)
        {
          ((RelativeLayout.LayoutParams)localObject2).width = ((m - actn.a(f1, getResources())) / 2);
          ((ajqb)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362629));
          ((ajqb)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362626));
          ((ajqb)localObject1).d = ((ImageView)localView.findViewById(2131362628));
          ((RelativeLayout.LayoutParams)((ajqb)localObject1).d.getLayoutParams()).width = ((m - actn.a(4.0F, getResources())) / 2);
          localView.setTag(localObject1);
          j += 1;
          break;
          k = actn.a(12.0F, getResources());
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
  
  public static void setApolloActionIcon(int paramInt, ApolloActionData paramApolloActionData, ajqb paramajqb)
  {
    if ((paramInt & 0x1) > 0)
    {
      paramajqb.d.setImageResource(2130838405);
      paramajqb.d.setVisibility(0);
    }
    if ((paramInt & 0x400) > 0)
    {
      paramajqb.d.setImageResource(2130838402);
      paramajqb.d.setVisibility(0);
    }
    if ((paramInt & 0x40) > 0) {
      a(paramajqb, 2130838395);
    }
    if ((paramInt & 0x80) > 0)
    {
      paramajqb.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramajqb.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramApolloActionData.currencyNum));
      a(paramajqb, 2130838398);
    }
    if ((paramInt & 0x200) > 0) {
      a(paramajqb, 2130838397);
    }
    if ((paramInt & 0x4) > 0) {
      a(paramajqb, 2130838404);
    }
    if ((paramInt & 0x8) > 0) {
      a(paramajqb, 2130838404);
    }
    if ((paramInt & 0x10) > 0) {
      a(paramajqb, 2130838404);
    }
    if ((paramInt & 0x2) > 0) {
      a(paramajqb, 2130838400);
    }
    if ((paramInt & 0x2000) > 0)
    {
      paramajqb.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      ApolloUtil.a(paramajqb.jdField_b_of_type_AndroidWidgetImageView, true, true);
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
      Object localObject3 = (ajqb)((View)localObject2).getTag();
      if (localObject3 != null)
      {
        localObject3 = ((ajqb)localObject3).jdField_a_of_type_Ajpz;
        if ((localObject3 != null) && (((ajpz)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (((ajpz)localObject3).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId == paramApolloActionData.actionId)) {
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
          localObject = (ajqb)((View)localObject).getTag();
          if ((localObject != null) && (((ajqb)localObject).jdField_a_of_type_AndroidWidgetImageView != null))
          {
            ((ajqb)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
            ((ajqb)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
            ((ajqb)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            ((ajqb)localObject).jdField_a_of_type_AndroidWidgetTextView.setText("");
            ((ajqb)localObject).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            ((ajqb)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            ((ajqb)localObject).jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
            ((ajqb)localObject).d.setVisibility(8);
            ((ajqb)localObject).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            ((ajqb)localObject).jdField_a_of_type_Ajpz = null;
            ((ajqb)localObject).jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            ((ajqb)localObject).e.setVisibility(8);
            if (((ajqb)localObject).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
              ((ajqb)localObject).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
            }
            if (((ajqb)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
              ((ajqb)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
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
    Object localObject = (ajqb)paramView.getTag();
    if ((((ajqb)localObject).jdField_a_of_type_Ajpz != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (((ajqb)localObject).jdField_a_of_type_Ajpz.jdField_b_of_type_Int == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloLinearLayout", 2, "apollo shop item = " + paramView.getClass());
      }
      ((avpq)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b(String.valueOf("103100.103200"));
      if (((ajqb)localObject).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
        ((ajqb)localObject).jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      }
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null, "aio", ajmu.ah, null);
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
              if ((((ajqb)localObject).jdField_a_of_type_Ajpz != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (((ajqb)localObject).jdField_a_of_type_Ajpz.jdField_b_of_type_Int == 2))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloLinearLayout", 2, "apollo fav manager item = " + paramView.getClass());
                }
                paramView = new Intent();
                paramView.putExtra("extra_key_url_append", "&view=customize_action");
                ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramView, "aio", ajmu.ah, null);
                return;
              }
              if ((((ajqb)localObject).jdField_a_of_type_Ajpz != null) && (((ajqb)localObject).jdField_a_of_type_Ajpz.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) && (((ajqb)localObject).jdField_a_of_type_Ajpz.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.status != 0))
              {
                localObject = ((ajqb)localObject).jdField_a_of_type_Ajpz;
                ((ajpz)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin = null;
                ((ajpz)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.boy1 = null;
                if (QLog.isColorLevel()) {
                  QLog.d("ApolloLinearLayout", 2, "click action " + ((ajpz)localObject).toString());
                }
                if (!ApolloUtil.a(((ajpz)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, ((ajpz)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloLinearLayout", 2, "action status = done but res don't exist actionid=" + ((ajpz)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
                  }
                  a(((ajpz)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData);
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
                  if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
                    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_clk", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, -1, 0, new String[] { "" + ((ajpz)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "655_" + ((ajpz)localObject).jdField_a_of_type_Int, "", String.valueOf(System.currentTimeMillis() / 1000L) });
                  }
                }
                for (;;)
                {
                  if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
                    break label981;
                  }
                  ajmw localajmw = (ajmw)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
                  bool1 = localajmw.b(((ajpz)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
                  bool2 = localajmw.c(((ajpz)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
                  if (((((ajpz)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.feeType != 6) && (((ajpz)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.feeType != 7)) || (bool1) || (bool2)) {
                    break label983;
                  }
                  ImageView localImageView = (ImageView)paramView.findViewById(2131377346);
                  ((RelativeLayout.LayoutParams)localImageView.getLayoutParams()).topMargin = ((int)(e / 2 - 7.0F * super.getResources().getDisplayMetrics().density));
                  localImageView.setVisibility(0);
                  paramView.setClickable(false);
                  if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
                    break;
                  }
                  b(localajmw.a(((ajpz)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId));
                  return;
                  if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
                    if (((ajpz)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum == 0) {
                      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "g_action_single_clk", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, -1, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), new String[] { "" + ((ajpz)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "655_" + ((ajpz)localObject).jdField_a_of_type_Int, "", String.valueOf(System.currentTimeMillis() / 1000L) });
                    } else if (((ajpz)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum != 1) {}
                  }
                }
              }
            }
            if ((((ajpz)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.feeType != 2) || (bool1) || (bool2)) {
              break;
            }
          } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
          paramView = ((airz)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a();
        } while (paramView == null);
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, (ajpz)localObject);
        return;
      } while (((((ajpz)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData.feeType == 9) && (!bool2) && (!a(((ajpz)localObject).jdField_a_of_type_ComTencentMobileqqDataApolloActionData))) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
      paramView = ((airz)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a();
    } while (paramView == null);
    paramView.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, (ajpz)localObject);
  }
  
  public void a(View paramView, ajpz paramajpz)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, paramajpz);
  }
  
  public void a(BaseChatPie paramBaseChatPie, ajpz paramajpz)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramajpz == null)) {}
    aisr localaisr;
    do
    {
      return;
      localaisr = ((airz)paramBaseChatPie.a().getManager(153)).a();
    } while (localaisr == null);
    localaisr.c(paramBaseChatPie, paramajpz);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramApolloActionData == null)) {
      return false;
    }
    Object localObject = (airz)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
    HashMap localHashMap = new HashMap();
    new StringBuilder().append(ajmu.S).append("&actionId=").append(paramApolloActionData.actionId).append("&_bid=2282").toString();
    if (!((airz)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
    {
      localObject = super.getResources().getString(2131690080);
      String str1 = super.getResources().getString(2131690085);
      String str2 = super.getResources().getString(2131690079);
      String str3 = ajmu.S + "&actionId=" + paramApolloActionData.actionId + "&_bid=2282";
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "vip_alert_show", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + paramApolloActionData.actionId, "0" });
      }
      localHashMap.put("APOLLO_POP_TYPE", "dialog");
      localHashMap.put("feeType", String.valueOf(paramApolloActionData.feeType));
      localHashMap.put("title", str1);
      localHashMap.put("content", localObject);
      localHashMap.put("rightString", str2);
      localHashMap.put("url", str3);
      localHashMap.put("actionId", "" + paramApolloActionData.actionId);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
        return false;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bbqu);
    ((bbqp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(paramApolloActionData.actionId, null, null, 0, 0.0F, 0, "actionPanel");
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
            if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$CheckForLongPress != null)) {
              super.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$CheckForLongPress);
            }
            if ((this.jdField_a_of_type_AndroidViewView != null) && (!this.jdField_b_of_type_Boolean)) {
              a(this.jdField_a_of_type_AndroidViewView);
            }
            if (this.jdField_b_of_type_AndroidViewView != null)
            {
              paramMotionEvent = this.jdField_b_of_type_AndroidViewView;
              if ((paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
              {
                paramMotionEvent = (ajqb)paramMotionEvent.getTag();
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
          if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$CheckForLongPress == null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$CheckForLongPress = new ApolloLinearLayout.CheckForLongPress(this);
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$CheckForLongPress.a();
          super.postDelayed(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$CheckForLongPress, ViewConfiguration.getLongPressTimeout());
          paramMotionEvent = (ajqb)this.jdField_a_of_type_AndroidViewView.getTag();
        } while ((paramMotionEvent == null) || (paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView == null) || (paramMotionEvent.jdField_a_of_type_Ajpz == null));
        paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838390);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
        return true;
        super.setPressed(false);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$CheckForLongPress != null) {
          super.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$CheckForLongPress);
        }
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          paramMotionEvent = this.jdField_b_of_type_AndroidViewView;
          if ((paramMotionEvent != null) && (paramMotionEvent.getTag() != null))
          {
            paramMotionEvent = (ajqb)paramMotionEvent.getTag();
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
            paramMotionEvent = (ajqb)paramMotionEvent.getTag();
            if (paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView != null) {
              paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
            }
          }
        }
        paramMotionEvent = (ajqb)this.jdField_a_of_type_AndroidViewView.getTag();
        if ((paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView != null) && (paramMotionEvent.jdField_a_of_type_Ajpz != null))
        {
          paramMotionEvent.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838390);
          this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
        }
      } while ((paramMotionEvent.jdField_a_of_type_Ajpz == null) || (paramMotionEvent.jdField_a_of_type_Ajpz.jdField_a_of_type_ComTencentMobileqqDataApolloActionData == null) || (paramMotionEvent.jdField_a_of_type_Ajpz.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.status != 1) || (paramMotionEvent.jdField_a_of_type_Ajpz == null) || (paramMotionEvent.jdField_a_of_type_Ajpz.jdField_b_of_type_Int == 1));
      a(this.jdField_a_of_type_AndroidViewView, paramMotionEvent.jdField_a_of_type_Ajpz);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloLinearLayout
 * JD-Core Version:    0.7.0.1
 */