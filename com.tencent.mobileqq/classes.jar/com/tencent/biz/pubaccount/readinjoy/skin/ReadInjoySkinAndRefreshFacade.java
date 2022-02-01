package com.tencent.biz.pubaccount.readinjoy.skin;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

public class ReadInjoySkinAndRefreshFacade
{
  private int jdField_a_of_type_Int;
  private ReadInJoySkinHandler.ReadInJoySkinObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoySkinHandler$ReadInJoySkinObserver = new ReadInjoySkinAndRefreshFacade.2(this);
  ReadInjoySkinAndRefreshFacade.SkinAndRefreshCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInjoySkinAndRefreshFacade$SkinAndRefreshCallback;
  protected AppInterface a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public ReadInjoySkinAndRefreshFacade(AppInterface paramAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  @Nullable
  private RefreshData a(int paramInt1, oidb_0x5bd.RefreshInfo paramRefreshInfo, int paramInt2)
  {
    ReadInJoyRefreshManager localReadInJoyRefreshManager = (ReadInJoyRefreshManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
    RefreshData localRefreshData;
    if (paramRefreshInfo.has())
    {
      paramRefreshInfo = new RefreshData(paramRefreshInfo);
      localRefreshData = localReadInJoyRefreshManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), paramInt2);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.readinjoy.4tab", 2, "onReqGuideInfo 5bd回包 ");
        if (paramRefreshInfo != null) {
          break label226;
        }
        QLog.d("Q.readinjoy.4tab", 2, "newRefreshData = " + paramRefreshInfo);
        label89:
        if (localRefreshData != null) {
          break label257;
        }
        QLog.d("Q.readinjoy.4tab", 2, "oldRefreshData = " + localRefreshData);
      }
      label120:
      if (paramRefreshInfo != null) {
        break label289;
      }
      if (localRefreshData != null)
      {
        SharedPreUtils.f(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), null, paramInt2);
        FileUtils.b(RefreshRes.a());
        localReadInJoyRefreshManager.a(0, "", -1L, paramInt2);
      }
    }
    for (;;)
    {
      if (paramRefreshInfo != null)
      {
        paramRefreshInfo.setShowInSource(true, this.jdField_a_of_type_Int);
        if (localRefreshData != null) {
          paramRefreshInfo.isShown = localRefreshData.isShown;
        }
        SharedPreUtils.f(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramRefreshInfo.toJson().toString(), paramInt2);
      }
      return localRefreshData;
      paramRefreshInfo = null;
      break;
      label226:
      QLog.d("Q.readinjoy.4tab", 2, "newRefreshData = " + paramRefreshInfo.toString());
      break label89;
      label257:
      QLog.d("Q.readinjoy.4tab", 2, "oldRefreshData = " + localRefreshData.toString());
      break label120;
      label289:
      if (((localRefreshData == null) || (!paramRefreshInfo.id.equals(localRefreshData.id)) || (paramRefreshInfo.seq > localRefreshData.seq)) && (paramInt1 <= paramRefreshInfo.endTime))
      {
        FileUtils.b(RefreshRes.a());
        localReadInJoyRefreshManager.a(paramRefreshInfo, this.jdField_a_of_type_Int);
      }
    }
  }
  
  private void a(int paramInt1, RefreshData paramRefreshData, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo, int paramInt2)
  {
    Object localObject;
    if (paramSkinInfo.has())
    {
      paramSkinInfo = new SkinData(paramSkinInfo);
      localObject = new GuideData(paramGuideInfo, paramInt2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.4tab", 2, "guideData = " + localObject);
      }
      paramGuideInfo = (ReadInJoySkinManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
      if ((this.jdField_a_of_type_Boolean) || (paramInt1 < ((GuideData)localObject).beginTime) || (paramInt1 > ((GuideData)localObject).endTime)) {
        break label215;
      }
      a(QQManagerFactory.READ_INJOY_SKIN_MANAGER, "", (BaseResData)localObject);
      label112:
      localObject = paramGuideInfo.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication());
      if ((paramSkinInfo != null) || (paramGuideInfo.a() != 1)) {
        break label259;
      }
      this.jdField_a_of_type_JavaLangString = paramGuideInfo.a();
      SharedPreUtils.s(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), null);
      if ((paramRefreshData != null) && (paramInt1 <= paramRefreshData.endTime))
      {
        paramRefreshData.isShown = true;
        SharedPreUtils.f(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramRefreshData.toJson().toString(), paramInt2);
      }
    }
    label215:
    while ((paramSkinInfo == null) || (localObject == null) || (!((SkinData)localObject).id.equals(paramSkinInfo.id)) || (((SkinData)localObject).seq == paramSkinInfo.seq))
    {
      return;
      paramSkinInfo = null;
      break;
      if ((paramInt1 > ((GuideData)localObject).endTime) || (!NetworkUtil.h(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication()))) {
        break label112;
      }
      paramGuideInfo.a((GuideData)localObject);
      paramGuideInfo.a(((GuideData)localObject).skinData);
      break label112;
    }
    label259:
    SharedPreUtils.s(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramSkinInfo.toJson().toString());
    if (paramSkinInfo.id.equals(paramGuideInfo.a()))
    {
      this.jdField_a_of_type_JavaLangString = paramSkinInfo.id;
      return;
    }
    FileUtils.a(CommonSkinRes.a(paramSkinInfo.id));
  }
  
  private void a(int paramInt, String paramString, BaseResData paramBaseResData)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInjoySkinAndRefreshFacade$SkinAndRefreshCallback != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInjoySkinAndRefreshFacade$SkinAndRefreshCallback.a(paramInt, paramString, paramBaseResData);
    }
  }
  
  private void a(int paramInt1, oidb_0x5bd.GuideInfo paramGuideInfo, int paramInt2)
  {
    ReadInJoyOperationManager localReadInJoyOperationManager = (ReadInJoyOperationManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.READ_IN_JOY_OPERATION_MANAGER);
    Object localObject;
    int i;
    if (paramGuideInfo.has())
    {
      paramGuideInfo = new GuideData(paramGuideInfo, paramInt2);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoySkinAndRefreshFacadeManager", 2, "guideData = " + paramGuideInfo);
      }
      localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
      if (paramGuideInfo == null) {
        break label284;
      }
      paramGuideInfo.business = "operation_guide";
      GuideData localGuideData = (GuideData)((EntityManager)localObject).find(GuideData.class, new String[] { paramGuideInfo.id, paramGuideInfo.uin, paramGuideInfo.business });
      if ((localGuideData == null) || (localGuideData.showTime == 0)) {
        ((EntityManager)localObject).persistOrReplace(paramGuideInfo);
      }
      paramGuideInfo = localReadInJoyOperationManager.a("operation_guide", paramGuideInfo.id);
      if (paramGuideInfo == null) {
        return;
      }
      paramGuideInfo = paramGuideInfo.iterator();
      i = 0;
      label167:
      if (!paramGuideInfo.hasNext()) {
        return;
      }
      localObject = (GuideData)paramGuideInfo.next();
      if ((i != 0) || (((GuideData)localObject).source != paramInt2) || (paramInt1 < ((GuideData)localObject).beginTime) || (paramInt1 > ((GuideData)localObject).endTime)) {
        break label249;
      }
      a(QQManagerFactory.READ_IN_JOY_OPERATION_MANAGER, "operation_guide", (BaseResData)localObject);
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      i += 1;
      break label167;
      paramGuideInfo = null;
      break;
      label249:
      if ((paramInt1 <= ((GuideData)localObject).endTime) && (NetworkUtil.h(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication()))) {
        localReadInJoyOperationManager.a("operation_guide", (BaseResData)localObject);
      }
    }
    label284:
    localReadInJoyOperationManager.a(paramInt2);
  }
  
  public void a()
  {
    ThreadManager.post(new ReadInjoySkinAndRefreshFacade.1(this), 5, null, true);
  }
  
  public void a(ReadInjoySkinAndRefreshFacade.SkinAndRefreshCallback paramSkinAndRefreshCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInjoySkinAndRefreshFacade$SkinAndRefreshCallback = paramSkinAndRefreshCallback;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInjoySkinAndRefreshFacade$SkinAndRefreshCallback = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoySkinHandler$ReadInJoySkinObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade
 * JD-Core Version:    0.7.0.1
 */