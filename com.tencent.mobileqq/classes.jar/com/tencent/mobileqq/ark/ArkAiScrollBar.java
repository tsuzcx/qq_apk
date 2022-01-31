package com.tencent.mobileqq.ark;

import aasu;
import aasv;
import android.content.Context;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.anim.AIOFooterViewDetector;
import com.tencent.mobileqq.apollo.ApolloResponseManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArkAiScrollBar
{
  private int jdField_a_of_type_Int;
  protected View a;
  public HorizontalScrollView a;
  public LinearLayout a;
  protected PopupWindow a;
  protected RelativeLayout a;
  protected ArkRecommendController a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new aasu(this);
  protected ArrayList a;
  protected boolean a;
  private int b = 1;
  private int c = 2;
  private int d = 3;
  
  public ArkAiScrollBar(ArkRecommendController paramArkRecommendController)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController = paramArkRecommendController;
  }
  
  private int a(String paramString1, String paramString2)
  {
    if (paramString1.equals(paramString2)) {
      return this.b;
    }
    if (paramString2.contains(paramString1)) {
      return this.c;
    }
    if (paramString1.contains(paramString2)) {
      return this.d;
    }
    return this.jdField_a_of_type_Int;
  }
  
  private void a(ArkAiInfo paramArkAiInfo, View.OnClickListener paramOnClickListener)
  {
    int k = 1;
    int i = 0;
    Object localObject2;
    int j;
    Object localObject1;
    for (;;)
    {
      if (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        localObject2 = ArkAiBubbleView.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i));
        if ((localObject2 != null) && (!((ArkAiBubbleView)localObject2).c))
        {
          j = a(paramArkAiInfo.g, ((ArkAiBubbleView)localObject2).a().g);
          localObject1 = new ArrayList(((ArkAiBubbleView)localObject2).a());
          if (j != this.jdField_a_of_type_Int) {}
        }
        else
        {
          i += 1;
          continue;
        }
        if (j == this.b)
        {
          i = 0;
          label101:
          if (i >= ((ArrayList)localObject1).size()) {
            break label557;
          }
          if (((ArkAiInfo)((ArrayList)localObject1).get(i)).jdField_a_of_type_JavaLangString.equals(paramArkAiInfo.jdField_a_of_type_JavaLangString)) {
            ((ArrayList)localObject1).set(i, paramArkAiInfo);
          }
        }
      }
    }
    label542:
    label557:
    for (i = k;; i = 0)
    {
      if (i == 0)
      {
        a(paramArkAiInfo, (ArrayList)localObject1);
        if (((ArrayList)localObject1).size() <= ArkRecommendController.d) {}
      }
      for (paramArkAiInfo = new ArrayList(((ArrayList)localObject1).subList(0, ArkRecommendController.d));; paramArkAiInfo = (ArkAiInfo)localObject1)
      {
        ((ArkAiBubbleView)localObject2).a(paramArkAiInfo);
        return;
        i += 1;
        break label101;
        if (((ArrayList)localObject1).size() == 1)
        {
          if (!((ArkAiInfo)((ArrayList)localObject1).get(0)).jdField_a_of_type_JavaLangString.equals(paramArkAiInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          ((ArkAiBubbleView)localObject2).a(paramArkAiInfo);
          return;
        }
        j = 0;
        for (;;)
        {
          if (j >= ((ArrayList)localObject1).size()) {
            break label310;
          }
          if (((ArkAiInfo)((ArrayList)localObject1).get(j)).jdField_a_of_type_JavaLangString.equals(paramArkAiInfo.jdField_a_of_type_JavaLangString))
          {
            ((ArrayList)localObject1).remove(j);
            ((ArkAiBubbleView)localObject2).a((ArkAiInfo)((ArrayList)localObject1).get(0));
            ((ArkAiBubbleView)localObject2).a((List)localObject1);
            break;
          }
          j += 1;
        }
        label310:
        break;
        localObject1 = null;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          i = 0;
          while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            if (((ArkAiBubbleView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c) {
              break label542;
            }
            localObject1 = (ArkAiBubbleView)this.jdField_a_of_type_JavaUtilArrayList.remove(i);
            label368:
            i += 1;
          }
        }
        for (;;)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArkAiBubbleView(this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController, this.jdField_a_of_type_AndroidWidgetLinearLayout);
          }
          ((ArkAiBubbleView)localObject2).c = false;
          if (this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getChildAt(0).getMeasuredWidth() <= this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getWidth() + this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getScrollX()) {}
          for (i = 1;; i = 0)
          {
            localObject1 = new ArrayList();
            if (paramArkAiInfo == null)
            {
              ArkAppCenter.b("ArkBubbleState", String.format("createBubble, newAppInfo is empty", new Object[0]));
              return;
            }
            ((ArrayList)localObject1).add(paramArkAiInfo);
            if (localObject1 == null)
            {
              ArkAppCenter.b("ArkBubbleState", String.format("createBubble, appInfos list is empty", new Object[0]));
              return;
            }
            ((ArkAiBubbleView)localObject2).a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this, (List)localObject1, paramOnClickListener);
            if (i == 0) {
              break;
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout.post(this.jdField_a_of_type_JavaLangRunnable);
            ArkAppCenter.b("ArkBubbleState", String.format("createBubble, showbubble is success", new Object[0]));
            return;
          }
          break label368;
          localObject1 = null;
        }
      }
    }
  }
  
  private boolean a(ArkAiInfo paramArkAiInfo, ArrayList paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      ArkAiInfo localArkAiInfo = (ArkAiInfo)localIterator.next();
      if ((localArkAiInfo.jdField_a_of_type_JavaLangString.equals(paramArkAiInfo.jdField_a_of_type_JavaLangString)) && (localArkAiInfo.b.equals(paramArkAiInfo.b)) && (localArkAiInfo.h.equals(paramArkAiInfo.h)))
      {
        localArkAiInfo.jdField_a_of_type_JavaUtilLinkedHashMap = paramArkAiInfo.jdField_a_of_type_JavaUtilLinkedHashMap;
        localArkAiInfo.f = paramArkAiInfo.f;
        localArkAiInfo.g = paramArkAiInfo.g;
        return false;
      }
    }
    paramArrayList.add(paramArkAiInfo);
    return true;
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkAiScrollBar", 2, "updatePosition.chatPie == null!");
      }
      return;
    }
    localObject = ((BaseChatPie)localObject).jdField_a_of_type_AndroidContentContext;
    int i = -this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    int j = AIOUtils.a(5.0F, ((Context)localObject).getResources());
    int k = this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getMeasuredHeight();
    this.jdField_a_of_type_AndroidWidgetPopupWindow.update(this.jdField_a_of_type_AndroidViewView, 0, i - j - k, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth(), -1);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Boolean) {
      ArkAppCenter.b("ArkAiScrollBar", "show, ArkAiScrollBar.posTaken");
    }
    label14:
    BaseChatPie localBaseChatPie;
    do
    {
      do
      {
        do
        {
          break label14;
          do
          {
            return;
          } while ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() == 0) || (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()));
          localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a();
          if (localBaseChatPie != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ArkAiScrollBar", 2, "show.chatPie == null!");
        return;
      } while (localBaseChatPie.K);
      Context localContext = localBaseChatPie.jdField_a_of_type_AndroidContentContext;
      if ((!localBaseChatPie.J) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector != null)) {
        localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a(AIOUtils.a(46.0F, localContext.getResources()), false, "arkAI");
      }
      int i = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.measure(i, i);
      i = -this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
      int j = AIOUtils.a(5.0F, localContext.getResources());
      int k = this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getMeasuredHeight();
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(k);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAsDropDown(this.jdField_a_of_type_AndroidViewView, 0, i - j - k);
      f();
    } while (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    ((ApolloResponseManager)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(231)).a();
  }
  
  private void h()
  {
    if (!this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()) {
      return;
    }
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a();
    if ((localBaseChatPie != null) && (!localBaseChatPie.J) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector != null)) {
      localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a();
    }
    this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
  }
  
  public void a()
  {
    ArkAppCenter.b("ArkAiScrollBar", "takePos, dismiss");
    this.jdField_a_of_type_Boolean = true;
    h();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    int i = 1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    ArkAiBubbleView localArkAiBubbleView;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localArkAiBubbleView = (ArkAiBubbleView)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      localArkAiBubbleView.c = true;
      if (this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getChildAt(0).getMeasuredWidth() > this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getWidth() + this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getScrollX()) {
        break label111;
      }
    }
    for (;;)
    {
      localArkAiBubbleView.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this, paramOnClickListener);
      if (i != 0) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
      localArkAiBubbleView = new ArkAiBubbleView(this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController, this.jdField_a_of_type_AndroidWidgetLinearLayout);
      break;
      label111:
      i = 0;
    }
  }
  
  public void a(ArkAiBubbleView paramArkAiBubbleView)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() == 0)
    {
      ArkAppCenter.b("ArkAiScrollBar", "onBubbleDisappeared, dismiss");
      h();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramArkAiBubbleView);
  }
  
  public void a(ArrayList paramArrayList, View.OnClickListener paramOnClickListener)
  {
    ArkAppCenter.b("ArkAiScrollBar", "showBubble");
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ArkAiInfo localArkAiInfo = (ArkAiInfo)paramArrayList.next();
      if (localArkAiInfo != null) {
        a(localArkAiInfo, paramOnClickListener);
      }
    }
  }
  
  public boolean a()
  {
    try
    {
      BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a();
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)LayoutInflater.from(localBaseChatPie.jdField_a_of_type_AndroidContentContext).inflate(2130968708, null));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.findViewById(2131363325));
      this.jdField_a_of_type_AndroidViewView = localBaseChatPie.c.findViewById(2131363494);
      this.jdField_a_of_type_AndroidViewView.addOnLayoutChangeListener(new aasv(this));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localBaseChatPie.c.findViewById(2131363492));
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_AndroidWidgetHorizontalScrollView, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth(), -2);
      return true;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkAiScrollBar", 2, localOutOfMemoryError.getMessage());
      }
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController = null;
      return false;
    }
    catch (InflateException localInflateException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ArkAiScrollBar", 2, localInflateException.getMessage());
        }
      }
    }
  }
  
  public void b()
  {
    ArkAppCenter.b("ArkAiScrollBar", "returnPos, show");
    this.jdField_a_of_type_Boolean = false;
    g();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    int i = 0;
    ArkAppCenter.b("ArkAiScrollBar", "sendClick, dismiss");
    this.jdField_a_of_type_Boolean = false;
    h();
    while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      ArkAiBubbleView localArkAiBubbleView = ArkAiBubbleView.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i));
      if (localArkAiBubbleView != null)
      {
        localArkAiBubbleView.b();
        this.jdField_a_of_type_JavaUtilArrayList.add(localArkAiBubbleView);
      }
      i += 1;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0);
  }
  
  public void d()
  {
    ArkAppCenter.b("ArkAiScrollBar", "destroy, dismiss");
    h();
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ArkAiBubbleView)((Iterator)localObject).next()).a();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        localObject = ArkAiBubbleView.a(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i));
        if (localObject != null) {
          ((ArkAiBubbleView)localObject).a();
        }
        i += 1;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()) {
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiScrollBar
 * JD-Core Version:    0.7.0.1
 */