package com.tencent.mobileqq.ark;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkViewExtraInterface;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;

public class ArkAdapterItemForTextMsg
  implements ArkAdapterItemInterface
{
  public int a;
  public RecommendCommonMessage.ArkMsgAppInfo a;
  public RecommendCommonMessage a;
  public int b;
  public int c;
  
  private void a(Context paramContext)
  {
    new QQToastNotifier(paramContext).a(2131719023, paramContext.getResources().getDimensionPixelSize(2131299166), 1, 0);
  }
  
  private void a(ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder)
  {
    paramArkHorizontalListViewAdapter = new ArkAdapterItemForTextMsg.2(this, paramArkHorizontalListViewAdapter);
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramArkHorizontalListViewAdapter);
  }
  
  public void attachArkView(ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, int paramInt)
  {
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130845018);
    ArkAppView localArkAppView = paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    localArkAppView.setBorderType(3);
    localArkAppView.setClipRadiusTop(16.0F);
    localArkAppView.setClipRadius(0.0F);
    if (this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer = new ArkAioContainerWrapper();
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer.a(paramArkHorizontalListViewAdapter);
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer.a = new ArkAppMessage.Config();
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer.a.autoSize = Integer.valueOf(1);
      ArkAppDataReport.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "ShowView", this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, null, ArkAppDataReport.f, 0, 0);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer;
    if (this.c > 0) {
      ((ArkAioContainerWrapper)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appVer, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.meta, ArkAppCenterUtil.a(), this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo, paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (;;)
    {
      ((ArkAioContainerWrapper)localObject).setFixSize(ArkAppCenterUtil.jdField_a_of_type_Int, ArkAppCenterUtil.jdField_a_of_type_Int);
      ((ArkAioContainerWrapper)localObject).setMaxSize(ArkAppCenterUtil.jdField_a_of_type_Int, ArkAppCenterUtil.jdField_a_of_type_Int);
      ((ArkAioContainerWrapper)localObject).setMinSize(ArkAppCenterUtil.jdField_a_of_type_Int * 7 / 10, ArkAppCenterUtil.jdField_a_of_type_Int);
      QLog.d("ArkAdapterItemForTextMsg", 1, new Object[] { "ArkFold.attachArkView appName:", this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, ", getChatbubbleMaxWidth=", Integer.valueOf(ArkAppCenterUtil.jdField_a_of_type_Int) });
      localObject = new ArkAdapterItemForTextMsg.1(this, paramItemViewHolder, paramArkHorizontalListViewAdapter, paramInt, (ArkAioContainerWrapper)localObject);
      paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer, paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
      localArkAppView.setOnTouchListener(paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
      localArkAppView.setOnLongClickListener(paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
      localArkAppView.setLoadCallback((ArkViewImplement.LoadCallback)localObject);
      return;
      ((ArkAioContainerWrapper)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appVer, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.meta, ArkAppCenterUtil.a(), this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage, paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
  }
  
  public void clickTail(ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, ArkAppItemBubbleBuilder.Holder paramHolder, Context paramContext) {}
  
  public void destroyContainerByRemove()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.doOnEvent(2);
  }
  
  public ArkAdapterItemInterface extendArkCardByOpen(ArkAppContainer paramArkAppContainer, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer == paramArkAppContainer)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextList;
      int i = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mOpenCardAppInfoList.size();
      if (((ArrayList)localObject).size() == 1)
      {
        localObject = ((RecommendCommonMessage.ArkContextInfo)((ArrayList)localObject).get(0)).contextAppInfoList;
        if ((((LinkedList)localObject).size() == 1) && (i >= ArkRecommendController.jdField_a_of_type_Int - 1)) {
          return null;
        }
        if ((((LinkedList)localObject).size() > 1) && (i >= ArkRecommendController.c - 1)) {
          return null;
        }
      }
      else if ((((ArrayList)localObject).size() > 1) && (i >= ArkRecommendController.c - 1))
      {
        return null;
      }
      localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (localObject == null) {
        return null;
      }
      localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
      localObject = new ArkAdapterItemForTextMsg();
      ((ArkAdapterItemForTextMsg)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage;
      ((ArkAdapterItemForTextMsg)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo = new RecommendCommonMessage.ArkMsgAppInfo();
      ((ArkAdapterItemForTextMsg)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName = paramArkAppContainer.getAppName();
      ((ArkAdapterItemForTextMsg)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appPath = ArkAppMgr.getInstance().getAppPathByNameFromLocal(((ArkAdapterItemForTextMsg)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, ((ArkAdapterItemForTextMsg)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView, null, false);
      ((ArkAdapterItemForTextMsg)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView = paramString1;
      ((ArkAdapterItemForTextMsg)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.meta = paramString2;
      ((ArkAdapterItemForTextMsg)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      ((ArkAdapterItemForTextMsg)localObject).b = this.b;
      ((ArkAdapterItemForTextMsg)localObject).c = (this.b + 1);
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mOpenCardAppInfoList.add(0, ((ArkAdapterItemForTextMsg)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo);
      return localObject;
    }
    return null;
  }
  
  public String[] getArkAppNameAndPath()
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName;
    arrayOfString[1] = null;
    arrayOfString[2] = null;
    if ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null) {
      return arrayOfString;
    }
    arrayOfString[1] = ArkAppMgr.getInstance().getAppPathByNameFromLocal(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView, null, false);
    arrayOfString[2] = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView;
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAdapterItemForTextMsg
 * JD-Core Version:    0.7.0.1
 */