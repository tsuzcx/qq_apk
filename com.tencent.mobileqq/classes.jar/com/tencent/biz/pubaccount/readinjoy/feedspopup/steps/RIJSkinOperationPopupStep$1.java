package com.tencent.biz.pubaccount.readinjoy.feedspopup.steps;

import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import pgw;
import qtp;
import qtq;
import qtt;
import qtw;
import quo;

public class RIJSkinOperationPopupStep$1
  implements Runnable
{
  public RIJSkinOperationPopupStep$1(pgw parampgw) {}
  
  public void run()
  {
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    qtt localqtt = (qtt)((QQAppInterface)localObject2).a(121);
    qtw localqtw = (qtw)((QQAppInterface)localObject2).getManager(261);
    Object localObject1 = (qtp)((QQAppInterface)localObject2).getManager(271);
    qtq localqtq = (qtq)((QQAppInterface)localObject2).getManager(270);
    localObject2 = localqtq.a(pgw.a(this.this$0), 0);
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
      bool1 = quo.a(((RefreshData)localObject2).id);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh dataMatch = true, timeMatch = true, resValid =" + bool1);
      }
      if (!bool1) {
        break label340;
      }
      if (!((RefreshData)localObject2).isShown) {
        break label325;
      }
      localqtq.a(1, ((RefreshData)localObject2).id, ((RefreshData)localObject2).seq, 0);
      localqtq.a(true);
    }
    for (;;)
    {
      localObject1 = (GuideData)((qtp)localObject1).a("operation_guide");
      localqtt.a(localqtw.a(pgw.a(this.this$0)), null, (RefreshData)localObject2, (GuideData)localObject1, 0);
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
      localqtq.a(0, "", -1L, 0);
      continue;
      label340:
      localqtq.a(0, "", -1L, 0);
      localqtq.a((RefreshData)localObject2, 0);
      continue;
      label364:
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh dataMatch =" + bool1 + ",timeMatch = " + bool2);
      }
      localqtq.a(0, "", -1L, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJSkinOperationPopupStep.1
 * JD-Core Version:    0.7.0.1
 */