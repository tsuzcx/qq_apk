package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.text.TextUtils;
import com.tencent.biz.subscribe.utils.SubscribeFollowUserUtil.ResultListener;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;

class RelativeFeedsAdapter$2
  implements SubscribeFollowUserUtil.ResultListener
{
  RelativeFeedsAdapter$2(RelativeFeedsAdapter paramRelativeFeedsAdapter, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      VSReporter.b(this.a.poster.id.get(), "auth_follow", "clk_unfollow", 0, 0, new String[0]);
      paramString = this.b.N().iterator();
      while (paramString.hasNext()) {
        if (TextUtils.equals(((CertifiedAccountMeta.StFeed)paramString.next()).poster.id.get(), this.a.poster.id.get())) {
          paramString.remove();
        }
      }
      this.b.notifyDataSetChanged();
      QQToast.makeText(RelativeFeedsAdapter.f(this.b), 2, HardCodeUtil.a(2131887701), 0).show();
      if (this.b.N().size() < 5) {
        this.b.y();
      }
    }
    if (paramBoolean2) {
      VSReporter.b(this.a.poster.id.get(), "auth_follow", "clk_cancel", 0, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter.2
 * JD-Core Version:    0.7.0.1
 */