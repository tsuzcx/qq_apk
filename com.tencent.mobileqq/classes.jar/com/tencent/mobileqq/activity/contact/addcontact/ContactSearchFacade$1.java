package com.tencent.mobileqq.activity.contact.addcontact;

import addcontacts.AccountSearchPb.record;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.business.addcontact.model.SearchResult;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ContactSearchFacade$1
  extends FriendListObserver
{
  ContactSearchFacade$1(ContactSearchFacade paramContactSearchFacade) {}
  
  private void a(ArrayList<SearchResult> paramArrayList)
  {
    int k = 0;
    int j = 0;
    if ((paramArrayList != null) && (ContactSearchFacade.c(this.a) != 80000005) && (paramArrayList.size() == 1)) {
      ContactSearchFacade.a(this.a, ((SearchResult)paramArrayList.get(0)).b);
    }
    if ((paramArrayList != null) && (paramArrayList.size() >= 1))
    {
      Object localObject = paramArrayList.iterator();
      do
      {
        i = k;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramArrayList = (SearchResult)((Iterator)localObject).next();
      } while (paramArrayList.a != 80000003);
      int i = j;
      while (i < paramArrayList.e.size())
      {
        localObject = ((AccountSearchPb.record)paramArrayList.e.get(i)).number;
        i += 1;
        ((PBUInt32Field)localObject).set(i);
      }
      i = 1;
      if (i != 0)
      {
        if (ContactSearchFacade.c(this.a) != 80000005)
        {
          paramArrayList = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
          localObject = ContactSearchFacade.d(this.a);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(ContactSearchFacade.e(this.a));
          localStringBuilder.append("");
          paramArrayList.publicAccountReportClickEventForMigrate((AppInterface)localObject, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D96", "0X8005D96", 0, 0, localStringBuilder.toString(), "", this.a.c, "", false);
          return;
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(ContactSearchFacade.d(this.a), "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D94", "0X8005D94", 0, 0, "", "", this.a.c, "", false);
      }
    }
  }
  
  protected void onSearchFriendResult(boolean paramBoolean1, int paramInt1, Object paramObject, int paramInt2, String paramString, boolean paramBoolean2, long paramLong, int paramInt3, List<ISearchResultGroupModel> paramList)
  {
    int i = paramInt1;
    Object localObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = ContactSearchFacade.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSearchFriendResult  searchType = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" isSuccess = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" subId = ");
      localStringBuilder.append(paramInt3);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    int j = 0;
    paramInt1 = 0;
    if (i == 85)
    {
      paramInt1 = 1;
      this.a.b();
    }
    for (;;)
    {
      break;
      if (i == 86)
      {
        if (paramLong != ContactSearchFacade.a(this.a)) {
          return;
        }
        this.a.b();
        if (!paramBoolean2)
        {
          if (ContactSearchFacade.b(this.a) != null) {
            ContactSearchFacade.b(this.a).a(ContactSearchFacade.c(this.a), paramBoolean1, new ArrayList(), paramInt2, paramString, paramInt3, paramList);
          }
          return;
        }
        if (paramBoolean1)
        {
          try
          {
            a((ArrayList)paramObject);
          }
          catch (Exception paramObject)
          {
            if (QLog.isColorLevel()) {
              QLog.e(ContactSearchFacade.a, 2, "", paramObject);
            }
            if (ContactSearchFacade.b(this.a) != null) {
              ContactSearchFacade.b(this.a).a(ContactSearchFacade.c(this.a), paramBoolean1, new ArrayList(), paramInt2, paramString, paramInt3, paramList);
            }
            return;
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject = ContactSearchFacade.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("search failed error msg = ");
          localStringBuilder.append(paramString);
          QLog.d((String)localObject, 2, localStringBuilder.toString());
          paramInt1 = j;
        }
      }
      else
      {
        this.a.b();
        paramInt1 = j;
      }
    }
    if (ContactSearchFacade.b(this.a) != null)
    {
      localObject = ContactSearchFacade.b(this.a);
      if (paramInt1 == 0) {
        i = ContactSearchFacade.c(this.a);
      }
      ((ContactSearchFacade.ISearchListener)localObject).a(i, paramBoolean1, paramObject, paramInt2, paramString, paramInt3, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade.1
 * JD-Core Version:    0.7.0.1
 */