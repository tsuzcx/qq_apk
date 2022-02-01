package com.tencent.biz.pubaccount.AccountDetail.model;

import com.tencent.biz.pubaccount.AccountDetail.bean.AccountDetailDynamicInfo;
import com.tencent.biz.pubaccount.AccountDetail.model.api.IPublicAccountDetailDynamicDataManagerService;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.api.impl.PublicAccountReportUtilsImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.account_detail_dynamic_list.AccountDetailDynamicListRequest;
import com.tencent.mobileqq.mp.account_detail_dynamic_list.AccountDetailDynamicListResponse;
import com.tencent.mobileqq.mp.account_detail_dynamic_list.RetInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;

public class AccountDetailDynamicListModel
{
  static long a = -1L;
  
  public static int a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2)
  {
    int j = 0;
    Object localObject;
    label246:
    try
    {
      localObject = new account_detail_dynamic_list.AccountDetailDynamicListResponse();
      try
      {
        ((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).mergeFrom(paramArrayOfByte);
        i = j;
        if (((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).ret_info.has())
        {
          i = j;
          if (((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).ret_info.ret_code.get() == 0)
          {
            if ((!((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).puin.has()) || (!((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).last_msg_id.has()) || (!((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).msg_cnt.has())) {
              break label406;
            }
            l1 = ((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).puin.get();
            l2 = ((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).last_msg_id.get();
            l3 = ((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).msg_cnt.get();
            if (QLog.isColorLevel()) {
              QLog.d("AccountDetailDynamicListModel", 2, "updateAccountDetailDynamicInfo puin:" + l1 + " last_msg_id:" + l2 + " msg_cnt:" + l3 + " isFirstEnter:" + paramBoolean1 + " isFromDB:" + paramBoolean2);
            }
            paramQQAppInterface = (IPublicAccountDetailDynamicDataManagerService)paramQQAppInterface.getRuntimeService(IPublicAccountDetailDynamicDataManagerService.class, "all");
            localArrayList = paramQQAppInterface.getDynamicListFromCache(l1);
            if ((!paramBoolean1) || (!paramBoolean2) || (localArrayList == null)) {
              break label246;
            }
            boolean bool = localArrayList.isEmpty();
            if (bool) {
              break label246;
            }
            i = 6;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;)
        {
          long l1;
          long l2;
          long l3;
          ArrayList localArrayList;
          int i = 2;
        }
      }
      return i;
    }
    finally {}
    localArrayList = new ArrayList();
    if (((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).msg_infos.has())
    {
      localObject = ((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).msg_infos.get();
      if (localObject == null)
      {
        i = 0;
        break label425;
      }
    }
    for (;;)
    {
      if (j < i)
      {
        String str = ((ByteStringMicro)((List)localObject).get(j)).toStringUtf8();
        localArrayList.add(str);
        if (!QLog.isColorLevel()) {
          break label431;
        }
        QLog.d("AccountDetailDynamicListModel", 2, "updateAccountDetailDynamicInfo jsonBody" + str);
        break label431;
        i = ((List)localObject).size();
      }
      else
      {
        if (l3 == localArrayList.size())
        {
          i = paramQQAppInterface.updateAccountDetailDynamicInfo(paramArrayOfByte, paramBoolean1, l1, l2, l3, localArrayList, paramBoolean2);
          break;
        }
        i = 5;
        break;
        label406:
        i = 4;
        break;
      }
      label425:
      j = 0;
      continue;
      label431:
      j += 1;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, int paramInt, PublicAccountObserver paramPublicAccountObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailDynamicListModel", 2, "getAccountDetailDynamicList last_msg_id:" + paramLong2 + "  msg_cnt:" + paramInt + "  mLastMSgID: " + a);
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), PublicAccountServletImpl.class);
    localNewIntent.putExtra("cmd", "pull_account_detail_dynamic_list");
    Object localObject = new account_detail_dynamic_list.AccountDetailDynamicListRequest();
    ((account_detail_dynamic_list.AccountDetailDynamicListRequest)localObject).versionInfo.set("8.5.5,3,5105");
    ((account_detail_dynamic_list.AccountDetailDynamicListRequest)localObject).puin.set(paramLong1);
    ((account_detail_dynamic_list.AccountDetailDynamicListRequest)localObject).last_msg_id.set(paramLong2);
    ((account_detail_dynamic_list.AccountDetailDynamicListRequest)localObject).msg_cnt.set(paramInt);
    localNewIntent.putExtra("data", ((account_detail_dynamic_list.AccountDetailDynamicListRequest)localObject).toByteArray());
    boolean bool;
    label205:
    int i;
    if (paramLong2 == 0L)
    {
      bool = true;
      localNewIntent.putExtra("isFirstEnter", bool);
      a = paramLong2;
      localObject = (PublicAccountDataManager)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (localObject == null) {
        break label372;
      }
      localObject = ((PublicAccountDataManager)localObject).a(String.valueOf(paramLong1));
      if (localObject == null) {
        break label372;
      }
      if (((AccountDetail)localObject).followType != 1) {
        break label366;
      }
      paramInt = 1;
      i = PublicAccountReportUtilsImpl.getReportAccountType(paramQQAppInterface, String.valueOf(paramLong1), (AccountDetail)localObject);
    }
    for (;;)
    {
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      String str1 = paramLong1 + "";
      String str2 = paramLong2 + "";
      if (paramInt != 0) {}
      for (localObject = "02";; localObject = "01")
      {
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str1, "0X80077FF", "0X80077FF", 0, 0, "1", str2, (String)localObject, String.valueOf(i), false);
        localNewIntent.setObserver(new AccountDetailDynamicListModel.1(paramQQAppInterface, bool, paramPublicAccountObserver));
        paramQQAppInterface.startServlet(localNewIntent);
        if (QLog.isColorLevel()) {
          QLog.d("AccountDetailDynamicListModel", 2, "getAccountDetailDynamicList exit");
        }
        return;
        bool = false;
        break;
      }
      label366:
      paramInt = 0;
      break label205;
      label372:
      i = 1;
      paramInt = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, PublicAccountObserver paramPublicAccountObserver)
  {
    ((IPublicAccountDetailDynamicDataManagerService)paramQQAppInterface.getRuntimeService(IPublicAccountDetailDynamicDataManagerService.class, "all")).getDynamicListForFirstEnterFromDB(paramQQAppInterface, paramLong, paramPublicAccountObserver);
    a(paramQQAppInterface, paramLong, 0L, 25, paramPublicAccountObserver);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, long paramLong, PublicAccountObserver paramPublicAccountObserver)
  {
    AccountDetailDynamicInfo localAccountDetailDynamicInfo = ((IPublicAccountDetailDynamicDataManagerService)paramQQAppInterface.getRuntimeService(IPublicAccountDetailDynamicDataManagerService.class, "all")).getAccountDetailDynamicInfoFromCache(paramLong);
    if ((localAccountDetailDynamicInfo != null) && (localAccountDetailDynamicInfo.b > 0L))
    {
      if (a != localAccountDetailDynamicInfo.b) {
        a(paramQQAppInterface, paramLong, localAccountDetailDynamicInfo.b, 25, paramPublicAccountObserver);
      }
      return;
    }
    a(paramQQAppInterface, paramLong, paramPublicAccountObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicListModel
 * JD-Core Version:    0.7.0.1
 */