package com.tencent.biz.pubaccount.weishi_new.follow.joinGroup;

import com.tencent.biz.pubaccount.weishi_new.view.WSLoadingDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.widget.QQToast;

class GroupAdapter$2
  implements WSJoinGroupDataProcessor.DataCallback
{
  GroupAdapter$2(GroupAdapter paramGroupAdapter) {}
  
  public void a()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, 2131720720, 0).a();
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = TroopInfoActivity.a(paramString1, paramString2, 60006);
    TroopUtils.a(GroupAdapter.a(this.a), paramString1, 2);
  }
  
  public boolean a()
  {
    return (GroupAdapter.a(this.a) != null) && (GroupAdapter.a(this.a).isShowing());
  }
  
  public void b()
  {
    GroupAdapter.a(this.a);
  }
  
  public void c()
  {
    GroupAdapter.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.GroupAdapter.2
 * JD-Core Version:    0.7.0.1
 */