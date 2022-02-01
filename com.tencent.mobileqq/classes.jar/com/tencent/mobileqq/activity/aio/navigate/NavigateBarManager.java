package com.tencent.mobileqq.activity.aio.navigate;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class NavigateBarManager
  implements Handler.Callback
{
  private static int[] jdField_a_of_type_ArrayOfInt = { 2131374119, 2131374119 };
  private int jdField_a_of_type_Int = 18;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new NavigateBarManager.3(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new NavigateBarManager.4(this);
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new NavigateBarManager.1(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private NavigateBar jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBar;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<Integer, NavigateBar> jdField_a_of_type_JavaUtilHashMap;
  private Animation.AnimationListener jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = new NavigateBarManager.2(this);
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  
  public NavigateBarManager(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
  }
  
  private int a()
  {
    Object localObject1 = null;
    int i = 0;
    for (;;)
    {
      Object localObject2 = jdField_a_of_type_ArrayOfInt;
      if (i >= localObject2.length) {
        break;
      }
      View localView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(localObject2[i]);
      localObject2 = localObject1;
      if (localView != null) {
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (localView.getBottom() <= localObject1.getBottom()) {}
        }
        else
        {
          localObject2 = localView;
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (localObject1 != null) {
      return localObject1.getId();
    }
    return -1;
  }
  
  private void a(NavigateBar paramNavigateBar)
  {
    if (paramNavigateBar == null)
    {
      QLog.d("NavigateBarManager", 1, "show navigate bar, navigateBar == null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBar = paramNavigateBar;
    Object localObject1 = paramNavigateBar.a();
    if (localObject1 != null)
    {
      Object localObject2 = ((View)localObject1).getParent();
      if ((localObject2 instanceof ViewGroup)) {
        ((ViewGroup)localObject2).removeView((View)localObject1);
      }
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null)
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setMinimumHeight(ViewUtils.b(45.0F));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        int i = a();
        if (i != -1) {
          ((RelativeLayout.LayoutParams)localObject2).addRule(3, i);
        }
        ((RelativeLayout.LayoutParams)localObject2).topMargin = ViewUtils.a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject2);
      }
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(500L);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
      }
      if (this.jdField_b_of_type_AndroidViewAnimationAnimation == null)
      {
        this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(500L);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener);
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      if (paramNavigateBar.a() > 0L)
      {
        localObject1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        ((Message)localObject1).arg1 = paramNavigateBar.jdField_a_of_type_Int;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, paramNavigateBar.a());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager", 2, String.format("show navigate bar: %s", new Object[] { paramNavigateBar }));
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager", 2, String.format("hide navigate bar: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBar }));
    }
    Object localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if ((localObject != null) && (((RelativeLayout)localObject).getVisibility() == 0))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBar;
    if (localObject != null)
    {
      b(((NavigateBar)localObject).jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBar = null;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.entrySet();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    label23:
    NavigateBar localNavigateBar;
    for (Object localObject = null; localIterator.hasNext(); localObject = localNavigateBar)
    {
      localNavigateBar = (NavigateBar)((Map.Entry)localIterator.next()).getValue();
      if ((localObject != null) && (localNavigateBar.b <= localObject.b)) {
        break label23;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager", 2, String.format("refresh navigate bar: %s", new Object[] { localObject }));
    }
    if (localObject != null) {
      a(localObject);
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 5))
    {
      Object localObject;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              localObject = null;
            } else {
              localObject = new TroopAppShortcutHasNewAppNavBar(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt, 4);
            }
          }
          else {
            localObject = new TroopAppShortcutNavBar(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt, 4);
          }
        }
        else {
          localObject = new TroopDNANavBar(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt, 4);
        }
      }
      else {
        localObject = new IntimateInfoNavBar(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt, 4);
      }
      if (localObject != null)
      {
        boolean bool = ((NavigateBar)localObject).a();
        if (bool) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(((NavigateBar)localObject).jdField_a_of_type_Int), localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("NavigateBarManager", 2, String.format("addTask, barId: %s, needShow: %s", new Object[] { Integer.valueOf(((NavigateBar)localObject).jdField_a_of_type_Int), Boolean.valueOf(bool) }));
        }
      }
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null)
    {
      ((RelativeLayout)localObject).removeAllViews();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_b_of_type_AndroidWidgetRelativeLayout) != -1) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBar;
      if (localObject != null) {
        ((NavigateBar)localObject).d();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBar = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager", 2, "onDestroy");
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager", 2, String.format("removeTask, barId: %s", new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void d(int paramInt)
  {
    NavigateBar localNavigateBar = this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBar;
    if ((localNavigateBar != null) && (localNavigateBar.jdField_a_of_type_Int == paramInt)) {
      c();
    } else {
      b(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager", 2, String.format("hide navigate bar id: %s", new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      int i = paramMessage.arg1;
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBar;
      if ((paramMessage != null) && (i == paramMessage.jdField_a_of_type_Int))
      {
        c();
      }
      else
      {
        paramMessage = new StringBuilder();
        paramMessage.append("hide bar msg but not found, barId: ");
        paramMessage.append(i);
        QLog.d("NavigateBarManager", 1, paramMessage.toString());
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.NavigateBarManager
 * JD-Core Version:    0.7.0.1
 */