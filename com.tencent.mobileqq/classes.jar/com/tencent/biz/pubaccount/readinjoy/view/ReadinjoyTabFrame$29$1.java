package com.tencent.biz.pubaccount.readinjoy.view;

import aukm;
import aukn;
import auko;
import bbdj;
import bbev;
import bbjn;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import oaw;
import org.json.JSONObject;
import pyx;
import pzb;
import pzc;
import pzi;
import qaa;
import rhf;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

public class ReadinjoyTabFrame$29$1
  implements Runnable
{
  public ReadinjoyTabFrame$29$1(rhf paramrhf, oidb_0x5bd.GuideInfo paramGuideInfo1, int paramInt, oidb_0x5bd.RefreshInfo paramRefreshInfo, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo2) {}
  
  public void run()
  {
    int j = (int)(System.currentTimeMillis() / 1000L);
    Object localObject2 = (pzb)this.jdField_a_of_type_Rhf.a.a.getManager(271);
    Object localObject1;
    Object localObject4;
    int i;
    if (this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$GuideInfo.has())
    {
      localObject1 = new GuideData(this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$GuideInfo, this.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyTabFrame", 2, "guideData = " + localObject1);
      }
      localObject3 = this.jdField_a_of_type_Rhf.a.a.getEntityManagerFactory().createEntityManager();
      if (localObject1 == null) {
        break label336;
      }
      ((GuideData)localObject1).business = "operation_guide";
      localObject4 = (GuideData)((aukn)localObject3).a(GuideData.class, new String[] { ((GuideData)localObject1).id, ((GuideData)localObject1).uin, ((GuideData)localObject1).business });
      if ((localObject4 == null) || (((GuideData)localObject4).showTime == 0)) {
        ((aukn)localObject3).b((aukm)localObject1);
      }
      localObject1 = ((pzb)localObject2).a("operation_guide", ((GuideData)localObject1).id);
      if (localObject1 == null) {
        break label346;
      }
      localObject1 = ((List)localObject1).iterator();
      i = 0;
      label196:
      if (!((Iterator)localObject1).hasNext()) {
        break label346;
      }
      localObject3 = (GuideData)((Iterator)localObject1).next();
      if ((i != 0) || (((GuideData)localObject3).source != this.jdField_a_of_type_Int) || (j < ((GuideData)localObject3).beginTime) || (j > ((GuideData)localObject3).endTime)) {
        break label298;
      }
      this.jdField_a_of_type_Rhf.a.a(271, "operation_guide", (BaseResData)localObject3);
      ReadinjoyTabFrame.a(this.jdField_a_of_type_Rhf.a, true);
      oaw.a().a(4);
    }
    for (;;)
    {
      i += 1;
      break label196;
      localObject1 = null;
      break;
      label298:
      if ((j <= ((GuideData)localObject3).endTime) && (bbev.h(this.jdField_a_of_type_Rhf.a.a()))) {
        ((pzb)localObject2).c("operation_guide", (BaseResData)localObject3);
      }
    }
    label336:
    ((pzb)localObject2).a(this.jdField_a_of_type_Int);
    label346:
    Object localObject3 = (pzc)this.jdField_a_of_type_Rhf.a.a.getManager(270);
    if (this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$RefreshInfo.has())
    {
      localObject1 = new RefreshData(this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$RefreshInfo);
      localObject2 = ((pzc)localObject3).a(this.jdField_a_of_type_Rhf.a.a(), this.jdField_a_of_type_Int);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.readinjoy.4tab", 2, "onReqGuideInfo 5bd回包 ");
        if (localObject1 != null) {
          break label887;
        }
        QLog.d("Q.readinjoy.4tab", 2, "newRefreshData = " + localObject1);
        label453:
        if (localObject2 != null) {
          break label918;
        }
        QLog.d("Q.readinjoy.4tab", 2, "oldRefreshData = " + localObject2);
      }
      label484:
      if (localObject1 != null) {
        break label950;
      }
      if (localObject2 != null)
      {
        bbjn.f(this.jdField_a_of_type_Rhf.a.a(), this.jdField_a_of_type_Rhf.a.a.getCurrentAccountUin(), null, this.jdField_a_of_type_Int);
        bbdj.b(qaa.a());
        ((pzc)localObject3).a(0, "", -1L, this.jdField_a_of_type_Int);
      }
      label545:
      if (localObject1 != null)
      {
        ((RefreshData)localObject1).showInFeeds = true;
        if (localObject2 != null) {
          ((RefreshData)localObject1).isShown = ((RefreshData)localObject2).isShown;
        }
        bbjn.f(this.jdField_a_of_type_Rhf.a.a(), this.jdField_a_of_type_Rhf.a.a.getCurrentAccountUin(), ((RefreshData)localObject1).toJson().toString(), this.jdField_a_of_type_Int);
      }
      if (!this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$SkinInfo.has()) {
        break label1056;
      }
      localObject1 = new SkinData(this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$SkinInfo);
      label627:
      localObject4 = new GuideData(this.b, this.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "guideData = " + localObject4);
      }
      localObject3 = (pzi)this.jdField_a_of_type_Rhf.a.a.getManager(261);
      if ((ReadinjoyTabFrame.b(this.jdField_a_of_type_Rhf.a)) || (localObject4 == null) || (j < ((GuideData)localObject4).beginTime) || (j > ((GuideData)localObject4).endTime)) {
        break label1061;
      }
      this.jdField_a_of_type_Rhf.a.a(261, "", (BaseResData)localObject4);
      label750:
      localObject4 = ((pzi)localObject3).a(this.jdField_a_of_type_Rhf.a.a());
      if ((localObject1 != null) || (((pzi)localObject3).a() != 1)) {
        break label1113;
      }
      ReadinjoyTabFrame.a(this.jdField_a_of_type_Rhf.a, ((pzi)localObject3).a());
      bbjn.r(this.jdField_a_of_type_Rhf.a.a(), this.jdField_a_of_type_Rhf.a.a.getCurrentAccountUin(), null);
      if ((localObject2 != null) && (j <= ((RefreshData)localObject2).endTime))
      {
        ((RefreshData)localObject2).isShown = true;
        bbjn.f(this.jdField_a_of_type_Rhf.a.a(), this.jdField_a_of_type_Rhf.a.a.getCurrentAccountUin(), ((RefreshData)localObject2).toJson().toString(), this.jdField_a_of_type_Int);
      }
    }
    label887:
    while ((localObject1 == null) || (localObject4 == null) || (!((SkinData)localObject4).id.equals(((SkinData)localObject1).id)) || (((SkinData)localObject4).seq == ((SkinData)localObject1).seq))
    {
      return;
      localObject1 = null;
      break;
      QLog.d("Q.readinjoy.4tab", 2, "newRefreshData = " + ((RefreshData)localObject1).toString());
      break label453;
      QLog.d("Q.readinjoy.4tab", 2, "oldRefreshData = " + ((RefreshData)localObject2).toString());
      break label484;
      if (((localObject2 != null) && (((RefreshData)localObject1).id.equals(((RefreshData)localObject2).id)) && ((!((RefreshData)localObject1).id.equals(((RefreshData)localObject2).id)) || (((RefreshData)localObject1).seq <= ((RefreshData)localObject2).seq))) || (j > ((RefreshData)localObject1).endTime)) {
        break label545;
      }
      ((pzc)localObject3).a(0, "", -1L, this.jdField_a_of_type_Int);
      bbdj.b(qaa.a());
      ((pzc)localObject3).a((RefreshData)localObject1, this.jdField_a_of_type_Int);
      if (!QLog.isColorLevel()) {
        break label545;
      }
      QLog.d("Q.readinjoy.4tab", 2, "setRefreshType none and downloadRefreshRes");
      break label545;
      localObject1 = null;
      break label627;
      if ((localObject4 == null) || (j > ((GuideData)localObject4).endTime) || (!bbev.h(this.jdField_a_of_type_Rhf.a.a()))) {
        break label750;
      }
      ((pzi)localObject3).a((GuideData)localObject4);
      ((pzi)localObject3).a(((GuideData)localObject4).skinData);
      break label750;
    }
    label918:
    label950:
    label1113:
    bbjn.r(this.jdField_a_of_type_Rhf.a.a(), this.jdField_a_of_type_Rhf.a.a.getCurrentAccountUin(), ((SkinData)localObject1).toJson().toString());
    label1056:
    label1061:
    if (((SkinData)localObject1).id.equals(((pzi)localObject3).a()))
    {
      ReadinjoyTabFrame.a(this.jdField_a_of_type_Rhf.a, ((SkinData)localObject1).id);
      return;
    }
    bbdj.a(pyx.a(((SkinData)localObject1).id));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.29.1
 * JD-Core Version:    0.7.0.1
 */