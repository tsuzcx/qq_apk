package com.tencent.biz.pubaccount.readinjoy.feedspopup.steps;

import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import pny;
import rcs;
import rcw;
import rcx;
import rda;
import rdd;
import rdv;

public class RIJSkinOperationPopupStep$1
  implements Runnable
{
  public RIJSkinOperationPopupStep$1(pny parampny) {}
  
  public void run()
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    rda localrda = (rda)((QQAppInterface)localObject1).a(121);
    rdd localrdd = (rdd)((QQAppInterface)localObject1).getManager(261);
    Object localObject2 = (rcw)((QQAppInterface)localObject1).getManager(271);
    Object localObject3 = (rcx)((QQAppInterface)localObject1).getManager(270);
    localObject1 = ((rcx)localObject3).a(pny.a(this.this$0), 0);
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
      bool1 = rdv.a(((RefreshData)localObject1).id);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh dataMatch = true, timeMatch = true, resValid =" + bool1);
      }
      if (!bool1) {
        break label397;
      }
      if (!((RefreshData)localObject1).isShown) {
        break label380;
      }
      ((rcx)localObject3).a(1, ((RefreshData)localObject1).id, ((RefreshData)localObject1).seq, 0);
      ((rcx)localObject3).a(true);
      bool1 = true;
      label252:
      localObject2 = (GuideData)((rcw)localObject2).a("operation_guide");
      localObject3 = localrdd.a(pny.a(this.this$0));
      if ((localObject3 == null) || (i < ((SkinData)localObject3).beginTime) || (i > ((SkinData)localObject3).endTime)) {
        break label501;
      }
      if (!rcs.a(((SkinData)localObject3).id)) {
        break label481;
      }
      localrdd.a(1, ((SkinData)localObject3).id, bool1);
    }
    for (;;)
    {
      localrda.a((SkinData)localObject3, null, (RefreshData)localObject1, (GuideData)localObject2, 0);
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
      ((rcx)localObject3).a(0, "", -1L, 0);
      bool1 = false;
      break label252;
      label397:
      ((rcx)localObject3).a(0, "", -1L, 0);
      ((rcx)localObject3).a((RefreshData)localObject1, 0);
      bool1 = false;
      break label252;
      label423:
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh dataMatch =" + bool1 + ",timeMatch = " + bool2);
      }
      ((rcx)localObject3).a(0, "", -1L, 0);
      bool1 = bool3;
      break label252;
      label481:
      localrdd.a(0, "", bool1);
      localrdd.a((SkinData)localObject3);
      continue;
      label501:
      localrdd.a(0, "", bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJSkinOperationPopupStep.1
 * JD-Core Version:    0.7.0.1
 */