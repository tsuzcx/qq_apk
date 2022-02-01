package com.tencent.mobileqq.ark;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkViewExtraInterface;
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
  public RecommendCommonMessage a;
  public RecommendCommonMessage.ArkMsgAppInfo b;
  public int c;
  public int d;
  public int e;
  
  private void a(Context paramContext)
  {
    new QQToastNotifier(paramContext).notifyUser(2131916242, paramContext.getResources().getDimensionPixelSize(2131299920), 1, 0);
  }
  
  private void a(ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder)
  {
    paramArkHorizontalListViewAdapter = new ArkAdapterItemForTextMsg.2(this, paramArkHorizontalListViewAdapter);
    paramItemViewHolder.g.setOnClickListener(paramArkHorizontalListViewAdapter);
  }
  
  public void attachArkView(ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, int paramInt)
  {
    paramItemViewHolder.d.setBackgroundResource(2130846328);
    ArkAppView localArkAppView = paramItemViewHolder.e;
    localArkAppView.setBorderType(3);
    localArkAppView.setClipRadiusTop(16.0F);
    localArkAppView.setClipRadius(0.0F);
    if (this.b.mArkContainer == null)
    {
      this.b.mArkContainer = new ArkAioContainerWrapper();
      this.b.mArkContainer.a(paramArkHorizontalListViewAdapter);
      this.b.mArkContainer.d = new ArkAppMessage.Config();
      this.b.mArkContainer.d.autoSize = Integer.valueOf(1);
      ArkAppDataReport.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "ShowView", this.b.appName, null, ArkAppDataReport.f, 0, 0);
    }
    Object localObject = this.b.mArkContainer;
    if (this.e > 0) {
      ((ArkAioContainerWrapper)localObject).a(this.b.appName, this.b.appView, this.b.appVer, this.b.meta, ArkAppCenterUtil.d(), this.b, paramArkHorizontalListViewAdapter.b);
    } else {
      ((ArkAioContainerWrapper)localObject).a(this.b.appName, this.b.appView, this.b.appVer, this.b.meta, ArkAppCenterUtil.d(), this.a, paramArkHorizontalListViewAdapter.b);
    }
    ((ArkAioContainerWrapper)localObject).setFixSize(ArkAppCenterUtil.a, ArkAppCenterUtil.a);
    ((ArkAioContainerWrapper)localObject).setMaxSize(ArkAppCenterUtil.a, ArkAppCenterUtil.a);
    ((ArkAioContainerWrapper)localObject).setMinSize(ArkAppCenterUtil.a * 7 / 10, ArkAppCenterUtil.a);
    QLog.d("ArkAdapterItemForTextMsg", 1, new Object[] { "ArkFold.attachArkView appName:", this.b.appName, ", getChatbubbleMaxWidth=", Integer.valueOf(ArkAppCenterUtil.a) });
    localObject = new ArkAdapterItemForTextMsg.1(this, paramItemViewHolder, paramArkHorizontalListViewAdapter, paramInt, (ArkAioContainerWrapper)localObject);
    paramItemViewHolder.e.a(this.b.mArkContainer, paramItemViewHolder.c);
    localArkAppView.setOnTouchListener(paramArkHorizontalListViewAdapter.e);
    localArkAppView.setOnLongClickListener(paramArkHorizontalListViewAdapter.e);
    localArkAppView.setLoadCallback((ArkViewImplement.LoadCallback)localObject);
  }
  
  public void clickTail(ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder, LinearLayout paramLinearLayout, Context paramContext) {}
  
  public void destroyContainerByRemove()
  {
    this.b.doOnEvent(2);
  }
  
  public ArkAdapterItemInterface extendArkCardByOpen(ArkAppContainer paramArkAppContainer, String paramString1, String paramString2)
  {
    if (this.b.mArkContainer == paramArkAppContainer)
    {
      Object localObject = this.a.mContextList;
      int i = this.b.mOpenCardAppInfoList.size();
      if (((ArrayList)localObject).size() == 1)
      {
        localObject = ((RecommendCommonMessage.ArkContextInfo)((ArrayList)localObject).get(0)).contextAppInfoList;
        if ((((LinkedList)localObject).size() == 1) && (i >= ArkRecommendController.a - 1)) {
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
      ((ArkAdapterItemForTextMsg)localObject).a = this.a;
      ((ArkAdapterItemForTextMsg)localObject).b = new RecommendCommonMessage.ArkMsgAppInfo();
      ((ArkAdapterItemForTextMsg)localObject).b.appName = paramArkAppContainer.getAppName();
      ((ArkAdapterItemForTextMsg)localObject).b.appPath = ArkAppMgr.getInstance().getAppPathFromLocal(((ArkAdapterItemForTextMsg)localObject).b.appName);
      paramArkAppContainer = ((ArkAdapterItemForTextMsg)localObject).b;
      paramArkAppContainer.appView = paramString1;
      paramArkAppContainer.meta = paramString2;
      ((ArkAdapterItemForTextMsg)localObject).c = this.c;
      ((ArkAdapterItemForTextMsg)localObject).d = this.d;
      ((ArkAdapterItemForTextMsg)localObject).e = (this.d + 1);
      this.b.mOpenCardAppInfoList.add(0, ((ArkAdapterItemForTextMsg)localObject).b);
      return localObject;
    }
    return null;
  }
  
  public String[] getArkAppNameAndPath()
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = this.b.appName;
    arrayOfString[1] = null;
    arrayOfString[2] = null;
    if ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null) {
      return arrayOfString;
    }
    arrayOfString[1] = ArkAppMgr.getInstance().getAppPathFromLocal(this.b.appName);
    arrayOfString[2] = this.b.appView;
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAdapterItemForTextMsg
 * JD-Core Version:    0.7.0.1
 */