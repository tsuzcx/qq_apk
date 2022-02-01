package com.tencent.mobileqq.activity.contact.addcontact;

import android.os.Handler;
import com.tencent.mobileqq.search.business.addcontact.model.SearchResult;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class SearchBaseFragment$1
  implements ContactSearchFacade.ISearchListener
{
  SearchBaseFragment$1(SearchBaseFragment paramSearchBaseFragment) {}
  
  public void a(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2, String paramString, int paramInt3, List<ISearchResultGroupModel> paramList)
  {
    this.a.m();
    if (paramBoolean)
    {
      if (paramInt3 == 1)
      {
        if (this.a.v != null) {
          this.a.v.sendMessage(this.a.v.obtainMessage(4, paramList));
        }
        return;
      }
      paramInt1 = 2;
      if (paramInt3 == 2)
      {
        if (this.a.v != null) {
          this.a.v.sendEmptyMessage(5);
        }
        return;
      }
      if ((paramObject != null) && ((paramObject instanceof ArrayList)))
      {
        paramObject = (ArrayList)paramObject;
        paramInt3 = paramObject.size();
        paramInt2 = 3;
        if (paramInt3 == 0)
        {
          if (this.a.v != null)
          {
            paramObject = this.a.v;
            if (this.a.g) {
              paramInt1 = paramInt2;
            } else {
              paramInt1 = 2;
            }
            paramObject.sendEmptyMessage(paramInt1);
          }
          if (QLog.isColorLevel()) {
            QLog.d(SearchBaseFragment.r(), 2, "error! SearchResult is null!");
          }
          return;
        }
        if (paramObject.size() > 0) {
          try
          {
            paramString = (SearchResult)paramObject.get(0);
          }
          catch (Exception paramObject)
          {
            if (QLog.isColorLevel()) {
              QLog.d(SearchBaseFragment.r(), 2, "", paramObject);
            }
            paramObject = this.a.v;
            if (this.a.g) {
              paramInt1 = 3;
            }
            paramObject.sendEmptyMessage(paramInt1);
            return;
          }
        }
        if ((this.a.a(paramObject)) && (this.a.v != null)) {
          this.a.v.sendEmptyMessage(0);
        }
      }
    }
    else
    {
      this.a.a(paramInt1, paramObject, paramInt2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */