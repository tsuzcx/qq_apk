package com.tencent.biz.pubaccount.weishi_new.follow.joinGroup;

import com.tencent.biz.pubaccount.weishi_new.view.WSLoadingDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.widget.QQToast;

class GroupAdapter$2
  implements WSJoinGroupDataProcessor.DataCallback
{
  GroupAdapter$2(GroupAdapter paramGroupAdapter) {}
  
  public void a()
  {
    QQToast.makeText(BaseApplicationImpl.getContext(), 1, 2131918120, 0).show();
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = TroopInfoUIUtil.a(paramString1, paramString2, 60006);
    TroopUtils.a(GroupAdapter.a(this.a), paramString1, 2);
  }
  
  public void b()
  {
    GroupAdapter.b(this.a);
  }
  
  public void c()
  {
    GroupAdapter.c(this.a);
  }
  
  public boolean d()
  {
    return (GroupAdapter.d(this.a) != null) && (GroupAdapter.d(this.a).isShowing());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.GroupAdapter.2
 * JD-Core Version:    0.7.0.1
 */