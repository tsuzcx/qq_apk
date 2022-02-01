package com.tencent.mobileqq.activity.contact.addcontact;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
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
    if ((paramArrayList != null) && (ContactSearchFacade.a(this.a) != 80000005) && (paramArrayList.size() == 1)) {
      ContactSearchFacade.a(this.a, ((SearchResult)paramArrayList.get(0)).jdField_b_of_type_Int);
    }
    if ((paramArrayList != null) && (paramArrayList.size() >= 1))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        SearchResult localSearchResult = (SearchResult)paramArrayList.next();
        if (localSearchResult.a == 80000003)
        {
          i = 0;
          while (i < localSearchResult.jdField_b_of_type_JavaUtilList.size())
          {
            ((AccountSearchPb.record)localSearchResult.jdField_b_of_type_JavaUtilList.get(i)).number.set(i + 1);
            i += 1;
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (ContactSearchFacade.a(this.a) != 80000005) {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(ContactSearchFacade.a(this.a), "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D96", "0X8005D96", 0, 0, ContactSearchFacade.b(this.a) + "", "", this.a.b, "", false);
        }
      }
      else {
        return;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(ContactSearchFacade.a(this.a), "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D94", "0X8005D94", 0, 0, "", "", this.a.b, "", false);
      return;
    }
  }
  
  public void onSearchFriendResult(boolean paramBoolean1, int paramInt1, Object paramObject, int paramInt2, String paramString, boolean paramBoolean2, long paramLong, int paramInt3, List<ISearchResultGroupModel> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ContactSearchFacade.a, 2, "onSearchFriendResult  searchType = " + paramInt1 + " isSuccess = " + paramBoolean1 + " subId = " + paramInt3);
    }
    int j = 0;
    int i;
    ContactSearchFacade.ISearchListener localISearchListener;
    if (paramInt1 == 87)
    {
      this.a.b();
      i = 1;
      if (ContactSearchFacade.a(this.a) != null)
      {
        localISearchListener = ContactSearchFacade.a(this.a);
        if (i == 0) {
          break label330;
        }
      }
    }
    for (;;)
    {
      localISearchListener.a(paramInt1, paramBoolean1, paramObject, paramInt2, paramString, paramInt3, paramList);
      do
      {
        for (;;)
        {
          return;
          if (paramInt1 != 88) {
            break label316;
          }
          if (paramLong == ContactSearchFacade.a(this.a))
          {
            this.a.b();
            if (!paramBoolean2)
            {
              if (ContactSearchFacade.a(this.a) != null) {
                ContactSearchFacade.a(this.a).a(ContactSearchFacade.a(this.a), paramBoolean1, new ArrayList(), paramInt2, paramString, paramInt3, paramList);
              }
            }
            else
            {
              if (!paramBoolean1) {
                break label272;
              }
              try
              {
                a((ArrayList)paramObject);
                i = j;
              }
              catch (Exception paramObject)
              {
                if (QLog.isColorLevel()) {
                  QLog.e(ContactSearchFacade.a, 2, "", paramObject);
                }
              }
            }
          }
        }
      } while (ContactSearchFacade.a(this.a) == null);
      ContactSearchFacade.a(this.a).a(ContactSearchFacade.a(this.a), paramBoolean1, new ArrayList(), paramInt2, paramString, paramInt3, paramList);
      return;
      label272:
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(ContactSearchFacade.a, 2, "search failed error msg = " + paramString);
      i = j;
      break;
      label316:
      this.a.b();
      i = j;
      break;
      label330:
      paramInt1 = ContactSearchFacade.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade.1
 * JD-Core Version:    0.7.0.1
 */