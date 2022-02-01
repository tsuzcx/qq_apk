package com.tencent.mobileqq.ark;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkAppModuleCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.List;

public class ArkAiAppPanel
{
  private static int jdField_a_of_type_Int = 3;
  AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new ArkAiAppPanel.5(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private ArkAppContainer.ArkAppModuleCallback jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer$ArkAppModuleCallback = new ArkAiAppPanel.1(this);
  private ArkAppRootLayout jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout;
  private ArkAppView jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
  private ArkAiAppPanel.ArkInputPanelTabAdapter jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel$ArkInputPanelTabAdapter;
  private ArkAiAppPanel.DismissCallback jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel$DismissCallback;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private ArrayList<ArkAioContainerWrapper> jdField_a_of_type_JavaUtilArrayList;
  private List<ArkAiInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private ArrayList<Boolean> jdField_b_of_type_JavaUtilArrayList;
  
  public ArkAiAppPanel(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkAiAppPanel", 2, "initArkApp.aioContext == null!");
      }
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      int j = this.jdField_b_of_type_Int;
      if (i <= j) {
        return;
      }
      localObject1 = (ArkAiInfo)this.jdField_a_of_type_JavaUtilList.get(j);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
      j = BaseChatItemLayout.z;
      int k = XPanelContainer.jdField_a_of_type_Int;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout;
      i = j;
      if (localObject2 != null)
      {
        i = j;
        if (((ArkAppRootLayout)localObject2).getParent() != null) {
          i = ((View)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.getParent()).getMeasuredWidth();
        }
      }
      localObject2 = (ArkAioContainerWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int);
      ((ArkAioContainerWrapper)localObject2).a(((ArkAiInfo)localObject1).a, ((ArkAiInfo)localObject1).b, ((ArkAiInfo)localObject1).c, ((ArkAiInfo)localObject1).e, ArkAppCenterUtil.a(), null, (SessionInfo)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
      if (Boolean.FALSE.equals(this.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)))
      {
        ArkAppDataReport.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), "ShowView", ((ArkAiInfo)localObject1).a, null, ArkAppDataReport.g, 0, 0);
        this.jdField_b_of_type_JavaUtilArrayList.set(this.jdField_b_of_type_Int, Boolean.TRUE);
      }
      if (paramBoolean)
      {
        j = MessageForArkApp.dp2px(36.0F);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        j = 0;
      }
      k -= j;
      ((ArkAioContainerWrapper)localObject2).setViewRect(((ArkAioContainerWrapper)localObject2).descaleRect(new Rect(0, 0, i, k)));
      ((ArkAioContainerWrapper)localObject2).setFixSize(i, k);
      ((ArkAioContainerWrapper)localObject2).setMaxSize(i, k);
      ((ArkAioContainerWrapper)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer$ArkAppModuleCallback);
      QLog.d("ArkAiAppPanel", 2, String.format("ArkAiAppPanel.initArkApp app:%s view%s width:%d height:%d.", new Object[] { ((ArkAiInfo)localObject1).a, ((ArkAiInfo)localObject1).b, Integer.valueOf(i), Integer.valueOf(k) }));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.a((ArkAppContainer)localObject2, null);
      localObject1 = new RelativeLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getLayoutParams());
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, j);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
  }
  
  private void d()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if (localObject1 != null)
    {
      if (((List)localObject1).size() <= 0) {
        return;
      }
      if (this.jdField_a_of_type_JavaUtilArrayList == null)
      {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      }
      else
      {
        i = 0;
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject1 = (ArkAioContainerWrapper)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (localObject1 != null) {
            ((ArkAioContainerWrapper)localObject1).doOnEvent(2);
          }
          i += 1;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_b_of_type_JavaUtilArrayList.clear();
      }
      localObject1 = new ArrayList();
      Object localObject2 = this.jdField_a_of_type_JavaUtilList;
      if (localObject2 == null) {
        i = 0;
      } else {
        i = ((List)localObject2).size();
      }
      int j = 0;
      while ((j < jdField_a_of_type_Int) && (j < i))
      {
        ((ArrayList)localObject1).add(this.jdField_a_of_type_JavaUtilList.get(j));
        localObject2 = new ArkAioContainerWrapper();
        ((ArkAioContainerWrapper)localObject2).a = new ArkAppMessage.Config();
        ((ArkAioContainerWrapper)localObject2).a.round = Integer.valueOf(1);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        this.jdField_b_of_type_JavaUtilArrayList.add(Boolean.FALSE);
        j += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel$ArkInputPanelTabAdapter.a((List)localObject1);
      localObject1 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getSelectedView();
      if (localObject1 != null) {
        ((View)localObject1).setSelected(false);
      }
      int i = this.jdField_b_of_type_Int;
      if ((i < 0) || (i >= this.jdField_a_of_type_JavaUtilList.size())) {
        this.jdField_b_of_type_Int = 0;
      }
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setSelection(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.postDelayed(new ArkAiAppPanel.2(this), 500L);
    }
  }
  
  private void e()
  {
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout = ((ArkAppRootLayout)LayoutInflater.from(localBaseActivity).inflate(2131559249, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.setDisableParentReturn(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.findViewById(2131362947));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setBorderType(0);
    ArkAppView localArkAppView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    localArkAppView.setOnTouchListener(localArkAppView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setCallback(new ArkAiAppPanel.3(this));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.findViewById(2131362950));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel$ArkInputPanelTabAdapter = new ArkAiAppPanel.ArkInputPanelTabAdapter(this, localBaseActivity);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel$ArkInputPanelTabAdapter);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.findViewById(2131362962));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ArkAiAppPanel.4(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.findViewById(2131362964));
  }
  
  public ArkAppRootLayout a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout == null) {
      e();
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 0))
    {
      this.jdField_a_of_type_Boolean = true;
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout;
    }
    return null;
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
  
  public void a(List<ArkAiInfo> paramList, int paramInt, ArkAiAppPanel.DismissCallback paramDismissCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel$DismissCallback = paramDismissCallback;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_b_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a() != 22)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().b(22);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    if (localObject != null) {
      ((ArkAppView)localObject).setOnTouchListener(null);
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (ArkAiInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localObject != null) {
          ArkAppCenterCheckEvent.a(((ArkAiInfo)localObject).a);
        }
        i += 1;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel$DismissCallback;
      if (localObject != null) {
        ((ArkAiAppPanel.DismissCallback)localObject).a(this.jdField_a_of_type_JavaUtilList);
      }
      this.jdField_a_of_type_JavaUtilList = null;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiAppPanel
 * JD-Core Version:    0.7.0.1
 */