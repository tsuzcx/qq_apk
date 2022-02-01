package com.tencent.biz.pubaccount.readinjoy.feedspopup.steps;

import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import pmj;
import ran;
import rao;
import rar;
import rau;
import rbm;

public class RIJSkinOperationPopupStep$1
  implements Runnable
{
  public RIJSkinOperationPopupStep$1(pmj parampmj) {}
  
  public void run()
  {
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    rar localrar = (rar)((QQAppInterface)localObject2).getBusinessHandler(121);
    rau localrau = (rau)((QQAppInterface)localObject2).getManager(261);
    Object localObject1 = (ran)((QQAppInterface)localObject2).getManager(271);
    rao localrao = (rao)((QQAppInterface)localObject2).getManager(270);
    localObject2 = localrao.a(pmj.a(this.this$0), 0);
    boolean bool1;
    label139:
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
        break label315;
      }
      bool1 = true;
      if ((localObject2 == null) || (i < ((RefreshData)localObject2).beginTime) || (i > ((RefreshData)localObject2).endTime)) {
        break label320;
      }
      bool2 = true;
      label164:
      if ((!bool1) || (!bool2)) {
        break label364;
      }
      bool1 = rbm.a(((RefreshData)localObject2).id);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh dataMatch = true, timeMatch = true, resValid =" + bool1);
      }
      if (!bool1) {
        break label340;
      }
      if (!((RefreshData)localObject2).isShown) {
        break label325;
      }
      localrao.a(1, ((RefreshData)localObject2).id, ((RefreshData)localObject2).seq, 0);
      localrao.a(true);
    }
    for (;;)
    {
      localObject1 = (GuideData)((ran)localObject1).a("operation_guide");
      localrar.a(localrau.a(pmj.a(this.this$0)), null, (RefreshData)localObject2, (GuideData)localObject1, 0);
      return;
      QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh refreshData = " + ((RefreshData)localObject2).toString());
      break;
      label315:
      bool1 = false;
      break label139;
      label320:
      bool2 = false;
      break label164;
      label325:
      localrao.a(0, "", -1L, 0);
      continue;
      label340:
      localrao.a(0, "", -1L, 0);
      localrao.a((RefreshData)localObject2, 0);
      continue;
      label364:
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh dataMatch =" + bool1 + ",timeMatch = " + bool2);
      }
      localrao.a(0, "", -1L, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJSkinOperationPopupStep.1
 * JD-Core Version:    0.7.0.1
 */