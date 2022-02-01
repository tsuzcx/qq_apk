package com.tencent.biz.pubaccount.readinjoy.feedspopup.steps;

import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyOperationManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinHandler;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshRes;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

class RIJSkinOperationPopupStep$1
  implements Runnable
{
  RIJSkinOperationPopupStep$1(RIJSkinOperationPopupStep paramRIJSkinOperationPopupStep) {}
  
  public void run()
  {
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ReadInJoySkinHandler localReadInJoySkinHandler = (ReadInJoySkinHandler)((QQAppInterface)localObject2).getBusinessHandler(BusinessHandlerFactory.READ_INJOY_SKIN_HANDLER);
    ReadInJoySkinManager localReadInJoySkinManager = (ReadInJoySkinManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    Object localObject1 = (ReadInJoyOperationManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.READ_IN_JOY_OPERATION_MANAGER);
    ReadInJoyRefreshManager localReadInJoyRefreshManager = (ReadInJoyRefreshManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
    localObject2 = localReadInJoyRefreshManager.a(RIJSkinOperationPopupStep.a(this.this$0), 0);
    boolean bool1;
    label140:
    boolean bool2;
    if (QLog.isColorLevel())
    {
      if (localObject2 == null) {
        QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh refreshData = " + localObject2);
      }
    }
    else
    {
      int i = (int)(System.currentTimeMillis() / 1000L);
      if ((localObject2 == null) || (!((RefreshData)localObject2).isShowInSource(0))) {
        break label316;
      }
      bool1 = true;
      if ((localObject2 == null) || (i < ((RefreshData)localObject2).beginTime) || (i > ((RefreshData)localObject2).endTime)) {
        break label321;
      }
      bool2 = true;
      label165:
      if ((!bool1) || (!bool2)) {
        break label365;
      }
      bool1 = RefreshRes.a(((RefreshData)localObject2).id);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh dataMatch = true, timeMatch = true, resValid =" + bool1);
      }
      if (!bool1) {
        break label341;
      }
      if (!((RefreshData)localObject2).isShown) {
        break label326;
      }
      localReadInJoyRefreshManager.a(1, ((RefreshData)localObject2).id, ((RefreshData)localObject2).seq, 0);
      localReadInJoyRefreshManager.a(true);
    }
    for (;;)
    {
      localObject1 = (GuideData)((ReadInJoyOperationManager)localObject1).a("operation_guide");
      localReadInJoySkinHandler.a(localReadInJoySkinManager.a(RIJSkinOperationPopupStep.a(this.this$0)), null, (RefreshData)localObject2, (GuideData)localObject1, 0);
      return;
      QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh refreshData = " + ((RefreshData)localObject2).toString());
      break;
      label316:
      bool1 = false;
      break label140;
      label321:
      bool2 = false;
      break label165;
      label326:
      localReadInJoyRefreshManager.a(0, "", -1L, 0);
      continue;
      label341:
      localReadInJoyRefreshManager.a(0, "", -1L, 0);
      localReadInJoyRefreshManager.a((RefreshData)localObject2, 0);
      continue;
      label365:
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh dataMatch =" + bool1 + ",timeMatch = " + bool2);
      }
      localReadInJoyRefreshManager.a(0, "", -1L, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJSkinOperationPopupStep.1
 * JD-Core Version:    0.7.0.1
 */