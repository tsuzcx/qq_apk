package com.tencent.biz.pubaccount.readinjoy.feedspopup.steps;

import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import oym;
import qip;
import qit;
import qiu;
import qix;
import qja;
import qjs;

public class RIJSkinOperationPopupStep$1
  implements Runnable
{
  public RIJSkinOperationPopupStep$1(oym paramoym) {}
  
  public void run()
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    qix localqix = (qix)((QQAppInterface)localObject1).a(121);
    qja localqja = (qja)((QQAppInterface)localObject1).getManager(261);
    Object localObject2 = (qit)((QQAppInterface)localObject1).getManager(271);
    Object localObject3 = (qiu)((QQAppInterface)localObject1).getManager(270);
    localObject1 = ((qiu)localObject3).a(oym.a(this.this$0), 0);
    boolean bool1;
    label139:
    boolean bool2;
    label164:
    boolean bool3;
    if (QLog.isColorLevel())
    {
      if (localObject1 == null) {
        QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh refreshData = " + localObject1);
      }
    }
    else
    {
      int i = (int)(System.currentTimeMillis() / 1000L);
      if ((localObject1 == null) || (!((RefreshData)localObject1).isShowInSource(0))) {
        break label370;
      }
      bool1 = true;
      if ((localObject1 == null) || (i < ((RefreshData)localObject1).beginTime) || (i > ((RefreshData)localObject1).endTime)) {
        break label375;
      }
      bool2 = true;
      bool3 = false;
      if ((!bool1) || (!bool2)) {
        break label423;
      }
      bool1 = qjs.a(((RefreshData)localObject1).id);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh dataMatch = true, timeMatch = true, resValid =" + bool1);
      }
      if (!bool1) {
        break label397;
      }
      if (!((RefreshData)localObject1).isShown) {
        break label380;
      }
      ((qiu)localObject3).a(1, ((RefreshData)localObject1).id, ((RefreshData)localObject1).seq, 0);
      ((qiu)localObject3).a(true);
      bool1 = true;
      label252:
      localObject2 = (GuideData)((qit)localObject2).a("operation_guide");
      localObject3 = localqja.a(oym.a(this.this$0));
      if ((localObject3 == null) || (i < ((SkinData)localObject3).beginTime) || (i > ((SkinData)localObject3).endTime)) {
        break label501;
      }
      if (!qip.a(((SkinData)localObject3).id)) {
        break label481;
      }
      localqja.a(1, ((SkinData)localObject3).id, bool1);
    }
    for (;;)
    {
      localqix.a((SkinData)localObject3, null, (RefreshData)localObject1, (GuideData)localObject2, 0);
      return;
      QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh refreshData = " + ((RefreshData)localObject1).toString());
      break;
      label370:
      bool1 = false;
      break label139;
      label375:
      bool2 = false;
      break label164;
      label380:
      ((qiu)localObject3).a(0, "", -1L, 0);
      bool1 = false;
      break label252;
      label397:
      ((qiu)localObject3).a(0, "", -1L, 0);
      ((qiu)localObject3).a((RefreshData)localObject1, 0);
      bool1 = false;
      break label252;
      label423:
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh dataMatch =" + bool1 + ",timeMatch = " + bool2);
      }
      ((qiu)localObject3).a(0, "", -1L, 0);
      bool1 = bool3;
      break label252;
      label481:
      localqja.a(0, "", bool1);
      localqja.a((SkinData)localObject3);
      continue;
      label501:
      localqja.a(0, "", bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJSkinOperationPopupStep.1
 * JD-Core Version:    0.7.0.1
 */