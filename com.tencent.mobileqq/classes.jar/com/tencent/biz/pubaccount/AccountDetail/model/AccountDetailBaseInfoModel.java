package com.tencent.biz.pubaccount.accountdetail.model;

import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagRequset;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class AccountDetailBaseInfoModel
{
  public static void a(QQAppInterface paramQQAppInterface, PublicAccountDetailImpl paramPublicAccountDetailImpl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseInfoModel", 2, "saveAccountDetailToDBAndCache");
    }
    EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    if ((paramPublicAccountDetailImpl != null) && (paramPublicAccountDetailImpl.getId() != -1L))
    {
      if (!localEntityManager.update(paramPublicAccountDetailImpl)) {
        localEntityManager.drop(PublicAccountDetailImpl.class);
      }
    }
    else {
      localEntityManager.persist(paramPublicAccountDetailImpl);
    }
    localEntityManager.close();
    paramQQAppInterface = (IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
    if ((paramQQAppInterface != null) && (paramPublicAccountDetailImpl != null))
    {
      paramQQAppInterface.saveAccountDetailInfoCache(paramPublicAccountDetailImpl);
      if (paramPublicAccountDetailImpl.followType == 1) {
        paramQQAppInterface.savePublicAccountInfo(PublicAccountInfo.createPublicAccount(paramPublicAccountDetailImpl, 0L));
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), PublicAccountServletImpl.class);
    localNewIntent.putExtra("cmd", "set_function_flag");
    mobileqq_mp.SetFunctionFlagRequset localSetFunctionFlagRequset = new mobileqq_mp.SetFunctionFlagRequset();
    localSetFunctionFlagRequset.version.set(1);
    localSetFunctionFlagRequset.uin.set((int)Long.parseLong(paramString));
    localSetFunctionFlagRequset.type.set(paramPaConfigInfo.g);
    localSetFunctionFlagRequset.value.set(paramInt);
    localSetFunctionFlagRequset.account_type.set(1);
    localNewIntent.putExtra("data", localSetFunctionFlagRequset.toByteArray());
    localNewIntent.setObserver(new AccountDetailBaseInfoModel.1(paramQQAppInterface, paramPaConfigInfo, paramInt, paramString));
    paramQQAppInterface.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.model.AccountDetailBaseInfoModel
 * JD-Core Version:    0.7.0.1
 */