package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import pyx;
import pzb;
import pzc;
import pzf;
import pzi;
import qaa;

class ReadInJoyRecommendFeedsFragment$1
  implements Runnable
{
  ReadInJoyRecommendFeedsFragment$1(ReadInJoyRecommendFeedsFragment paramReadInJoyRecommendFeedsFragment) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.a;
    if (localObject1 == null) {
      return;
    }
    pzf localpzf = (pzf)((QQAppInterface)localObject1).a(121);
    pzi localpzi = (pzi)((QQAppInterface)localObject1).getManager(261);
    Object localObject2 = (pzb)((QQAppInterface)localObject1).getManager(271);
    Object localObject3 = (pzc)((QQAppInterface)localObject1).getManager(270);
    localObject1 = ((pzc)localObject3).a(this.this$0.getActivity(), 0);
    boolean bool1;
    label143:
    boolean bool2;
    label168:
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
        break label395;
      }
      bool1 = true;
      if ((localObject1 == null) || (i < ((RefreshData)localObject1).beginTime) || (i > ((RefreshData)localObject1).endTime)) {
        break label400;
      }
      bool2 = true;
      bool3 = false;
      if ((!bool1) || (!bool2)) {
        break label448;
      }
      bool3 = qaa.a(((RefreshData)localObject1).id);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh dataMatch =" + bool1 + ",timeMatch = " + bool2 + ", resValid =" + bool3);
      }
      if (!bool3) {
        break label422;
      }
      if (!((RefreshData)localObject1).isShown) {
        break label405;
      }
      ((pzc)localObject3).a(1, ((RefreshData)localObject1).id, ((RefreshData)localObject1).seq, 0);
      ((pzc)localObject3).a(true);
      bool1 = true;
      label277:
      localObject2 = (GuideData)((pzb)localObject2).a("operation_guide");
      localObject3 = localpzi.a(this.this$0.getActivity());
      if ((localObject3 == null) || (i < ((SkinData)localObject3).beginTime) || (i > ((SkinData)localObject3).endTime)) {
        break label526;
      }
      if (!pyx.a(((SkinData)localObject3).id)) {
        break label506;
      }
      localpzi.a(1, ((SkinData)localObject3).id, bool1);
    }
    for (;;)
    {
      localpzf.a((SkinData)localObject3, null, (RefreshData)localObject1, (GuideData)localObject2, 0);
      return;
      QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh refreshData = " + ((RefreshData)localObject1).toString());
      break;
      label395:
      bool1 = false;
      break label143;
      label400:
      bool2 = false;
      break label168;
      label405:
      ((pzc)localObject3).a(0, "", -1L, 0);
      bool1 = false;
      break label277;
      label422:
      ((pzc)localObject3).a(0, "", -1L, 0);
      ((pzc)localObject3).a((RefreshData)localObject1, 0);
      bool1 = false;
      break label277;
      label448:
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "checkSkinAndRefresh dataMatch =" + bool1 + ",timeMatch = " + bool2);
      }
      ((pzc)localObject3).a(0, "", -1L, 0);
      bool1 = bool3;
      break label277;
      label506:
      localpzi.a(0, "", bool1);
      localpzi.a((SkinData)localObject3);
      continue;
      label526:
      localpzi.a(0, "", bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment.1
 * JD-Core Version:    0.7.0.1
 */