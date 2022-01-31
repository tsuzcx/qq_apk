package com.tencent.mobileqq.ark;

import aari;
import aarj;
import aark;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkViewExtraInterface;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.mobileqq.widget.QQToastNotifier;
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
    new QQToastNotifier(paramContext).a(2131434464, paramContext.getResources().getDimensionPixelSize(2131558448), 1, 0);
  }
  
  private void a(ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder)
  {
    paramArkHorizontalListViewAdapter = new aark(this, paramArkHorizontalListViewAdapter);
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramArkHorizontalListViewAdapter);
  }
  
  public void attachArkView(ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, int paramInt)
  {
    paramItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130842248);
    ArkAppView localArkAppView = paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    localArkAppView.setBorderType(3);
    localArkAppView.setClipRadiusTop(15.0F);
    localArkAppView.setClipRadius(0.0F);
    int i;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer = new ArkAioContainerWrapper();
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer.a(paramArkHorizontalListViewAdapter);
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer.a = new ArkAppMessage.Config();
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer.a.autoSize = Integer.valueOf(1);
      localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      ArkAppDataReport.d((QQAppInterface)localObject, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, ArkAppDataReport.f, 0);
      if (localObject != null)
      {
        localObject = (ArkAppHandler)((QQAppInterface)localObject).a(95);
        if (!this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.isFromArkServer) {
          break label446;
        }
        i = 2;
        String str1 = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.arkServerExtraInfo;
        String str2 = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.arkServerMsgId;
        String str3 = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName;
        String str4 = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView;
        String str5 = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.msg;
        if (!"1".equals(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.getExtInfoFromExtStr("ark_text_analysis_flag"))) {
          break label453;
        }
        j = 1;
        label231:
        ((ArkAppHandler)localObject).a(i, 4, 1, str1, str2, str3, str4, str5, j, 0);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer;
    if (this.c > 0) {
      ((ArkAioContainerWrapper)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appVer, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.meta, paramArkHorizontalListViewAdapter.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo, paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (;;)
    {
      ((ArkAioContainerWrapper)localObject).setFixSize(BaseChatItemLayout.d, BaseChatItemLayout.d);
      ((ArkAioContainerWrapper)localObject).setMaxSize(BaseChatItemLayout.d, BaseChatItemLayout.d);
      ((ArkAioContainerWrapper)localObject).setMinSize(BaseChatItemLayout.d * 7 / 10, BaseChatItemLayout.d);
      localObject = new aari(this, paramItemViewHolder, paramArkHorizontalListViewAdapter, (ArkAioContainerWrapper)localObject, paramInt);
      paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer, paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
      localArkAppView.setOnTouchListener(paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
      localArkAppView.setOnLongClickListener(paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
      localArkAppView.setLoadCallback((ArkViewImplement.LoadCallback)localObject);
      paramItemViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppRootLayout.setCallback(new aarj(this));
      return;
      label446:
      i = 100;
      break;
      label453:
      j = 0;
      break label231;
      ((ArkAioContainerWrapper)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appVer, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.meta, paramArkHorizontalListViewAdapter.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage, paramArkHorizontalListViewAdapter.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
  }
  
  public void clickTail(ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, Context paramContext) {}
  
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
      localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(120);
      ArkAdapterItemForTextMsg localArkAdapterItemForTextMsg = new ArkAdapterItemForTextMsg();
      localArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage;
      localArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo = new RecommendCommonMessage.ArkMsgAppInfo();
      localArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName = paramArkAppContainer.getAppName();
      localArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appPath = ((ArkAppCenter)localObject).a().a(localArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, null);
      localArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView = paramString1;
      localArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.meta = paramString2;
      localArkAdapterItemForTextMsg.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localArkAdapterItemForTextMsg.b = this.b;
      localArkAdapterItemForTextMsg.c = (this.b + 1);
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mOpenCardAppInfoList.add(0, localArkAdapterItemForTextMsg.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo);
      return localArkAdapterItemForTextMsg;
    }
    return null;
  }
  
  public String[] getArkAppNameAndPath()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName;
    arrayOfString[1] = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localQQAppInterface == null) {
      return arrayOfString;
    }
    arrayOfString[1] = ((ArkAppCenter)localQQAppInterface.getManager(120)).a().a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, null);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAdapterItemForTextMsg
 * JD-Core Version:    0.7.0.1
 */