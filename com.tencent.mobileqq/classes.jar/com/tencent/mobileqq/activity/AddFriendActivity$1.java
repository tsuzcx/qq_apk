package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade.ISearchListener;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import java.util.List;

class AddFriendActivity$1
  implements ContactSearchFacade.ISearchListener
{
  AddFriendActivity$1(AddFriendActivity paramAddFriendActivity) {}
  
  public void a(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2, String paramString, int paramInt3, List<ISearchResultGroupModel> paramList)
  {
    if (AddFriendActivity.a(this.a))
    {
      AddFriendActivity.a(this.a, paramInt1, paramBoolean, paramObject, paramInt2, paramString);
      return;
    }
    AddFriendActivity.b(this.a, paramInt1, paramBoolean, paramObject, paramInt2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendActivity.1
 * JD-Core Version:    0.7.0.1
 */