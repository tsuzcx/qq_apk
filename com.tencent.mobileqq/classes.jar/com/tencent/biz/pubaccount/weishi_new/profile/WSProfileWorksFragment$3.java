package com.tencent.biz.pubaccount.weishi_new.profile;

import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.main.WSLauncher.VerticalPageLauncher;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView.BaseAdapter.OnItemClickListener;

class WSProfileWorksFragment$3
  implements BaseAdapter.OnItemClickListener
{
  WSProfileWorksFragment$3(WSProfileWorksFragment paramWSProfileWorksFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    String str1;
    if (WSProfileWorksFragment.a(this.a)) {
      str1 = "personal_main";
    } else {
      str1 = "personal_guest";
    }
    String str2;
    if (WSProfileWorksFragment.a(this.a)) {
      str2 = "homepage_main";
    } else {
      str2 = "homepage_guest";
    }
    WSLauncher.VerticalPageLauncher.a(new WSVerticalPageOpenParams(this.a.getContext(), str1, str2).a(paramInt).b(4097).d(WSProfileWorksFragment.c(this.a)).g(((WSProfileWorksPresenter)this.a.aO_()).a()).f(WSProfileWorksFragment.b(this.a)).a(paramView).a(WSProfileWorksFragment.a(this.a, paramInt)));
    WSProfileWorksFragment.a(this.a, paramInt, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.WSProfileWorksFragment.3
 * JD-Core Version:    0.7.0.1
 */