package com.tencent.mobileqq.activity.contact.addcontact;

import android.os.Handler;
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
    int i = 3;
    this.a.j();
    if (paramBoolean)
    {
      if (paramInt3 == 1) {
        if (this.a.a != null) {
          this.a.a.sendMessage(this.a.a.obtainMessage(4, paramList));
        }
      }
      for (;;)
      {
        return;
        if (paramInt3 == 2)
        {
          if (this.a.a != null) {
            this.a.a.sendEmptyMessage(5);
          }
        }
        else if ((paramObject != null) && ((paramObject instanceof ArrayList)))
        {
          paramObject = (ArrayList)paramObject;
          if (paramObject.size() == 0)
          {
            if (this.a.a != null)
            {
              paramObject = this.a.a;
              if (!this.a.b) {
                break label159;
              }
            }
            label159:
            for (paramInt1 = 3;; paramInt1 = 2)
            {
              paramObject.sendEmptyMessage(paramInt1);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d(SearchBaseFragment.a(), 2, "error! SearchResult is null!");
              return;
            }
          }
          if (paramObject.size() > 0) {}
          try
          {
            paramString = (SearchResult)paramObject.get(0);
            if ((this.a.a(paramObject)) && (this.a.a != null))
            {
              this.a.a.sendEmptyMessage(0);
              return;
            }
          }
          catch (Exception paramObject)
          {
            if (QLog.isColorLevel()) {
              QLog.d(SearchBaseFragment.a(), 2, "", paramObject);
            }
            paramObject = this.a.a;
            if (!this.a.b) {}
          }
        }
      }
      for (paramInt1 = i;; paramInt1 = 2)
      {
        paramObject.sendEmptyMessage(paramInt1);
        return;
      }
    }
    this.a.a(paramInt1, paramObject, paramInt2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */