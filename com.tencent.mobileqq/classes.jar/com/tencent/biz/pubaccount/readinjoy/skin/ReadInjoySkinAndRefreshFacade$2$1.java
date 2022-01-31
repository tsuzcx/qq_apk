package com.tencent.biz.pubaccount.readinjoy.skin;

import auko;
import aukp;
import aukq;
import bbdx;
import bbfj;
import bbkb;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import pyu;
import pyy;
import pyz;
import pzf;
import pzt;
import pzu;
import pzx;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

public class ReadInjoySkinAndRefreshFacade$2$1
  implements Runnable
{
  public ReadInjoySkinAndRefreshFacade$2$1(pzu parampzu, oidb_0x5bd.GuideInfo paramGuideInfo1, int paramInt, oidb_0x5bd.RefreshInfo paramRefreshInfo, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo2) {}
  
  public void run()
  {
    int j = (int)(System.currentTimeMillis() / 1000L);
    Object localObject2 = (pyy)this.jdField_a_of_type_Pzu.a.a.getManager(271);
    Object localObject1;
    Object localObject4;
    int i;
    if (this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$GuideInfo.has())
    {
      localObject1 = new GuideData(this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$GuideInfo, this.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoySkinAndRefreshFacadeManager", 2, "guideData = " + localObject1);
      }
      localObject3 = this.jdField_a_of_type_Pzu.a.a.getEntityManagerFactory().createEntityManager();
      if (localObject1 == null) {
        break label332;
      }
      ((GuideData)localObject1).business = "operation_guide";
      localObject4 = (GuideData)((aukp)localObject3).a(GuideData.class, new String[] { ((GuideData)localObject1).id, ((GuideData)localObject1).uin, ((GuideData)localObject1).business });
      if ((localObject4 == null) || (((GuideData)localObject4).showTime == 0)) {
        ((aukp)localObject3).b((auko)localObject1);
      }
      localObject1 = ((pyy)localObject2).a("operation_guide", ((GuideData)localObject1).id);
      if (localObject1 == null) {
        break label342;
      }
      localObject1 = ((List)localObject1).iterator();
      i = 0;
      label196:
      if (!((Iterator)localObject1).hasNext()) {
        break label342;
      }
      localObject3 = (GuideData)((Iterator)localObject1).next();
      if ((i != 0) || (((GuideData)localObject3).source != this.jdField_a_of_type_Int) || (j < ((GuideData)localObject3).beginTime) || (j > ((GuideData)localObject3).endTime)) {
        break label291;
      }
      pzt.a(this.jdField_a_of_type_Pzu.a, 271, "operation_guide", (BaseResData)localObject3);
      pzt.a(this.jdField_a_of_type_Pzu.a, true);
    }
    for (;;)
    {
      i += 1;
      break label196;
      localObject1 = null;
      break;
      label291:
      if ((j <= ((GuideData)localObject3).endTime) && (bbfj.h(this.jdField_a_of_type_Pzu.a.a.getApplication()))) {
        ((pyy)localObject2).c("operation_guide", (BaseResData)localObject3);
      }
    }
    label332:
    ((pyy)localObject2).a(this.jdField_a_of_type_Int);
    label342:
    Object localObject3 = (pyz)this.jdField_a_of_type_Pzu.a.a.getManager(270);
    if (this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$RefreshInfo.has())
    {
      localObject1 = new RefreshData(this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$RefreshInfo);
      localObject2 = ((pyz)localObject3).a(this.jdField_a_of_type_Pzu.a.a.getApplication(), this.jdField_a_of_type_Int);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.readinjoy.4tab", 2, "onReqGuideInfo 5bd回包 ");
        if (localObject1 != null) {
          break label911;
        }
        QLog.d("Q.readinjoy.4tab", 2, "newRefreshData = " + localObject1);
        label452:
        if (localObject2 != null) {
          break label942;
        }
        QLog.d("Q.readinjoy.4tab", 2, "oldRefreshData = " + localObject2);
      }
      label483:
      if (localObject1 != null) {
        break label974;
      }
      if (localObject2 != null)
      {
        bbkb.f(this.jdField_a_of_type_Pzu.a.a.getApplication(), this.jdField_a_of_type_Pzu.a.a.getCurrentAccountUin(), null, this.jdField_a_of_type_Int);
        bbdx.b(pzx.a());
        ((pyz)localObject3).a(0, "", -1L, this.jdField_a_of_type_Int);
      }
      label547:
      if (localObject1 != null)
      {
        ((RefreshData)localObject1).setShowInSource(true, pzt.a(this.jdField_a_of_type_Pzu.a));
        if (localObject2 != null) {
          ((RefreshData)localObject1).isShown = ((RefreshData)localObject2).isShown;
        }
        bbkb.f(this.jdField_a_of_type_Pzu.a.a.getApplication(), this.jdField_a_of_type_Pzu.a.a.getCurrentAccountUin(), ((RefreshData)localObject1).toJson().toString(), this.jdField_a_of_type_Int);
      }
      if (!this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$SkinInfo.has()) {
        break label1056;
      }
      localObject1 = new SkinData(this.jdField_a_of_type_TencentImOidbCmd0x5bdOidb_0x5bd$SkinInfo);
      label642:
      localObject4 = new GuideData(this.b, this.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "guideData = " + localObject4);
      }
      localObject3 = (pzf)this.jdField_a_of_type_Pzu.a.a.getManager(261);
      if ((pzt.a(this.jdField_a_of_type_Pzu.a)) || (localObject4 == null) || (j < ((GuideData)localObject4).beginTime) || (j > ((GuideData)localObject4).endTime)) {
        break label1061;
      }
      pzt.a(this.jdField_a_of_type_Pzu.a, 261, "", (BaseResData)localObject4);
      label765:
      localObject4 = ((pzf)localObject3).a(this.jdField_a_of_type_Pzu.a.a.getApplication());
      if ((localObject1 != null) || (((pzf)localObject3).a() != 1)) {
        break label1116;
      }
      pzt.a(this.jdField_a_of_type_Pzu.a, ((pzf)localObject3).a());
      bbkb.r(this.jdField_a_of_type_Pzu.a.a.getApplication(), this.jdField_a_of_type_Pzu.a.a.getCurrentAccountUin(), null);
      if ((localObject2 != null) && (j <= ((RefreshData)localObject2).endTime))
      {
        ((RefreshData)localObject2).isShown = true;
        bbkb.f(this.jdField_a_of_type_Pzu.a.a.getApplication(), this.jdField_a_of_type_Pzu.a.a.getCurrentAccountUin(), ((RefreshData)localObject2).toJson().toString(), this.jdField_a_of_type_Int);
      }
    }
    label911:
    label942:
    label974:
    label1116:
    while ((localObject1 == null) || (localObject4 == null) || (!((SkinData)localObject4).id.equals(((SkinData)localObject1).id)) || (((SkinData)localObject4).seq == ((SkinData)localObject1).seq))
    {
      return;
      localObject1 = null;
      break;
      QLog.d("Q.readinjoy.4tab", 2, "newRefreshData = " + ((RefreshData)localObject1).toString());
      break label452;
      QLog.d("Q.readinjoy.4tab", 2, "oldRefreshData = " + ((RefreshData)localObject2).toString());
      break label483;
      if (((localObject2 != null) && (((RefreshData)localObject1).id.equals(((RefreshData)localObject2).id)) && ((!((RefreshData)localObject1).id.equals(((RefreshData)localObject2).id)) || (((RefreshData)localObject1).seq <= ((RefreshData)localObject2).seq))) || (j > ((RefreshData)localObject1).endTime)) {
        break label547;
      }
      bbdx.b(pzx.a());
      ((pyz)localObject3).a((RefreshData)localObject1, pzt.a(this.jdField_a_of_type_Pzu.a));
      break label547;
      localObject1 = null;
      break label642;
      if ((localObject4 == null) || (j > ((GuideData)localObject4).endTime) || (!bbfj.h(this.jdField_a_of_type_Pzu.a.a.getApplication()))) {
        break label765;
      }
      ((pzf)localObject3).a((GuideData)localObject4);
      ((pzf)localObject3).a(((GuideData)localObject4).skinData);
      break label765;
    }
    label1056:
    label1061:
    bbkb.r(this.jdField_a_of_type_Pzu.a.a.getApplication(), this.jdField_a_of_type_Pzu.a.a.getCurrentAccountUin(), ((SkinData)localObject1).toJson().toString());
    if (((SkinData)localObject1).id.equals(((pzf)localObject3).a()))
    {
      pzt.a(this.jdField_a_of_type_Pzu.a, ((SkinData)localObject1).id);
      return;
    }
    bbdx.a(pyu.a(((SkinData)localObject1).id));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade.2.1
 * JD-Core Version:    0.7.0.1
 */