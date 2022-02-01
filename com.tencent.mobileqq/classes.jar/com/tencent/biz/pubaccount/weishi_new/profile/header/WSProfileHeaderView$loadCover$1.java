package com.tencent.biz.pubaccount.weishi_new.profile.header;

import android.widget.ImageView;
import com.tencent.biz.pubaccount.weishi_new.image.WSImageDownListenerAdapter;
import com.tencent.biz.pubaccount.weishi_new.profile.utils.WSCoverUtils;
import java.net.URL;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/profile/header/WSProfileHeaderView$loadCover$1", "Lcom/tencent/biz/pubaccount/weishi_new/image/WSImageDownListenerAdapter;", "onLoadSuccessed", "", "url", "Ljava/net/URL;", "closeableBitmap", "", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSProfileHeaderView$loadCover$1
  extends WSImageDownListenerAdapter
{
  public void a(@Nullable URL paramURL, @Nullable Object paramObject)
  {
    WSCoverUtils.a((ImageView)WSProfileHeaderView.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.header.WSProfileHeaderView.loadCover.1
 * JD-Core Version:    0.7.0.1
 */