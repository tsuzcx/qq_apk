package com.tencent.mobileqq.ark;

import aaro;
import aarp;
import aarq;
import aarr;
import aart;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkAppModuleCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;

public class ArkAiAppPanel
{
  private static int jdField_a_of_type_Int = 3;
  AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new aart(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private ArkAppContainer.ArkAppModuleCallback jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer$ArkAppModuleCallback = new aaro(this);
  private ArkAppRootLayout jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout;
  private ArkAppView jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
  private ArkAiAppPanel.ArkInputPanelTabAdapter jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel$ArkInputPanelTabAdapter;
  private ArkAiAppPanel.DismissCallback jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel$DismissCallback;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  
  public ArkAiAppPanel(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ArkAiAppPanel", 2, "initArkApp.chatPie == null!");
      }
    }
    while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0) || (this.jdField_a_of_type_JavaUtilList.size() <= this.jdField_b_of_type_Int)) {
      return;
    }
    ArkAiInfo localArkAiInfo = (ArkAiInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int);
    Context localContext = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext;
    int i = BaseChatItemLayout.x;
    int k = XPanelContainer.jdField_a_of_type_Int;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.getParent() != null)) {
      i = ((View)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.getParent()).getMeasuredWidth();
    }
    for (;;)
    {
      ArkAioContainerWrapper localArkAioContainerWrapper = (ArkAioContainerWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int);
      localArkAioContainerWrapper.a(localArkAiInfo.a, localArkAiInfo.b, localArkAiInfo.c, localArkAiInfo.f, localContext.getResources().getDisplayMetrics().scaledDensity, null, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      Object localObject;
      int j;
      if (Boolean.FALSE.equals(this.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)))
      {
        ArkAppDataReport.d(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArkAiInfo.a, ArkAppDataReport.g, 0);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          ArkAppHandler localArkAppHandler = (ArkAppHandler)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(95);
          localObject = null;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
            if (localObject == null) {
              localObject = null;
            }
          }
          else
          {
            localArkAppHandler.a(100, 4, 1, null, null, localArkAiInfo.a, localArkAiInfo.b, (String)localObject, 0, 0);
          }
        }
        else
        {
          this.jdField_b_of_type_JavaUtilArrayList.set(this.jdField_b_of_type_Int, Boolean.TRUE);
        }
      }
      else
      {
        j = 0;
        if (!paramBoolean) {
          break label489;
        }
        j = AIOUtils.a(36.0F, localContext.getResources());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      for (;;)
      {
        k -= j;
        localArkAioContainerWrapper.setViewRect(localArkAioContainerWrapper.descaleRect(new Rect(0, 0, i, k)));
        localArkAioContainerWrapper.setFixSize(i, k);
        localArkAioContainerWrapper.setMaxSize(i, k);
        localArkAioContainerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer$ArkAppModuleCallback);
        QLog.d("ArkAiAppPanel", 2, String.format("ArkAiAppPanel.initArkApp app:%s view%s.", new Object[] { localArkAiInfo.a, localArkAiInfo.b }));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.a(localArkAioContainerWrapper, null);
        localObject = new RelativeLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getLayoutParams());
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, j);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
        localObject = localObject.toString();
        break;
        label489:
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      localObject = new ArrayList();
      if (this.jdField_a_of_type_JavaUtilList != null) {
        break label214;
      }
    }
    label214:
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.size())
    {
      int j = 0;
      while ((j < jdField_a_of_type_Int) && (j < i))
      {
        ((ArrayList)localObject).add(this.jdField_a_of_type_JavaUtilList.get(j));
        ArkAioContainerWrapper localArkAioContainerWrapper = new ArkAioContainerWrapper();
        localArkAioContainerWrapper.a = new ArkAppMessage.Config();
        localArkAioContainerWrapper.a.round = Integer.valueOf(1);
        this.jdField_a_of_type_JavaUtilArrayList.add(localArkAioContainerWrapper);
        this.jdField_b_of_type_JavaUtilArrayList.add(Boolean.FALSE);
        j += 1;
      }
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject = (ArkAioContainerWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localObject != null) {
          ((ArkAioContainerWrapper)localObject).doOnEvent(2);
        }
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      break;
    }
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel$ArkInputPanelTabAdapter.a((List)localObject);
    Object localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getSelectedView();
    if (localObject != null) {
      ((View)localObject).setSelected(false);
    }
    if ((this.jdField_b_of_type_Int < 0) || (this.jdField_b_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())) {
      this.jdField_b_of_type_Int = 0;
    }
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setSelection(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.postDelayed(new aarp(this), 500L);
  }
  
  private void e()
  {
    Context localContext = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout = ((ArkAppRootLayout)LayoutInflater.from(localContext).inflate(2130969032, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.setDisableParentReturn(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.findViewById(2131363312));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setBorderType(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setCallback(new aarq(this));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.findViewById(2131364812));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel$ArkInputPanelTabAdapter = new ArkAiAppPanel.ArkInputPanelTabAdapter(this, localContext);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel$ArkInputPanelTabAdapter);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.findViewById(2131364813));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aarr(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.findViewById(2131364811));
  }
  
  public View a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout == null) {
      e();
    }
    this.jdField_a_of_type_Boolean = true;
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ArkAioContainerWrapper localArkAioContainerWrapper = (ArkAioContainerWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localArkAioContainerWrapper != null) {
          localArkAioContainerWrapper.doOnEvent(2);
        }
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void a(List paramList, int paramInt, ArkAiAppPanel.DismissCallback paramDismissCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel$DismissCallback = paramDismissCallback;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_b_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f() != 22)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(Integer.valueOf(22));
      return;
    }
    d();
    this.jdField_a_of_type_Boolean = true;
    a(this.jdField_a_of_type_Boolean);
  }
  
  public void b()
  {
    d();
    a(this.jdField_a_of_type_Boolean);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnTouchListener(null);
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        ArkAiInfo localArkAiInfo = (ArkAiInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localArkAiInfo != null) {
          ArkAppCenterCheckEvent.a(localArkAiInfo.a);
        }
        i += 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel$DismissCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel$DismissCallback.a(this.jdField_a_of_type_JavaUtilList);
      }
      this.jdField_a_of_type_JavaUtilList = null;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiAppPanel
 * JD-Core Version:    0.7.0.1
 */