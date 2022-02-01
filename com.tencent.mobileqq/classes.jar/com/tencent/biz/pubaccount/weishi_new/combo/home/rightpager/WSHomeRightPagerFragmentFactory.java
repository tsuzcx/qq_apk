package com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager;

import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.biz.pubaccount.weishi_new.combo.IWSFragmentFactory;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.main.WSVideoPageChangeObserver;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/home/rightpager/WSHomeRightPagerFragmentFactory;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/IWSFragmentFactory;", "()V", "createFragments", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "Lkotlin/collections/ArrayList;", "bundle", "Landroid/os/Bundle;", "createGridPageFragment", "createRecommendFragment", "createVerticalPageFragment", "createWaterfallPageFragment", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSHomeRightPagerFragmentFactory
  implements IWSFragmentFactory
{
  private final QBaseFragment b(Bundle paramBundle)
  {
    WSExpABTestManager localWSExpABTestManager = WSExpABTestManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localWSExpABTestManager, "WSExpABTestManager.getInstance()");
    if (localWSExpABTestManager.m()) {
      return d(paramBundle);
    }
    return c(paramBundle);
  }
  
  private final QBaseFragment c(Bundle paramBundle)
  {
    String str;
    if (paramBundle != null) {
      str = paramBundle.getString("key_home_to_context_feed_id");
    } else {
      str = null;
    }
    boolean bool;
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("key_context_feed_show_musk");
    } else {
      bool = false;
    }
    paramBundle = WSGridPageFragment.a("", false, true, str, bool);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "WSGridPageFragment.creat…d, isContextFeedShowMusk)");
    return (QBaseFragment)paramBundle;
  }
  
  private final QBaseFragment d(Bundle paramBundle)
  {
    String str;
    if (paramBundle != null) {
      str = paramBundle.getString("key_home_to_context_feed_id");
    } else {
      str = null;
    }
    boolean bool;
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("key_context_feed_show_musk");
    } else {
      bool = false;
    }
    paramBundle = WSRecommendFragment.a(str, bool);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "WSRecommendFragment.crea…d, isContextFeedShowMusk)");
    return (QBaseFragment)paramBundle;
  }
  
  private final QBaseFragment e(Bundle paramBundle)
  {
    Object localObject = new WSVerticalPageOpenParams("essence_tab", "feeds");
    if (paramBundle != null) {
      ((WSVerticalPageOpenParams)localObject).a(new Bundle(paramBundle));
    }
    localObject = WSVerticalPageFragment.a((WSVerticalPageOpenParams)localObject);
    if (paramBundle != null) {
      paramBundle = paramBundle.getSerializable("page_change_observer");
    } else {
      paramBundle = null;
    }
    if (paramBundle != null)
    {
      paramBundle = (WSVideoPageChangeObserver)paramBundle;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "verticalFragment");
      ((WSVerticalPageFragment)localObject).a(paramBundle);
      return (QBaseFragment)localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi_new.main.WSVideoPageChangeObserver");
  }
  
  @NotNull
  public ArrayList<QBaseFragment> a(@Nullable Bundle paramBundle)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(b(paramBundle));
    localArrayList.add(e(paramBundle));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.WSHomeRightPagerFragmentFactory
 * JD-Core Version:    0.7.0.1
 */