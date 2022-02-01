package com.tencent.biz.pubaccount.weishi_new.combo;

import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi_new.combo.main.WSComboMainFragment;
import com.tencent.biz.pubaccount.weishi_new.combo.main.WSComboMainFragment.Companion;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileFragment;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/WSMainContainerPagerFragmentFactory;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/IWSFragmentFactory;", "()V", "createFragments", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "Lkotlin/collections/ArrayList;", "bundle", "Landroid/os/Bundle;", "getProfileBundle", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSMainContainerPagerFragmentFactory
  implements IWSFragmentFactory
{
  public static final WSMainContainerPagerFragmentFactory.Companion a = new WSMainContainerPagerFragmentFactory.Companion(null);
  
  private final Bundle b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    paramBundle.putInt("page_type", 3);
    paramBundle.putString("from", "main");
    return paramBundle;
  }
  
  @NotNull
  public ArrayList<QBaseFragment> a(@Nullable Bundle paramBundle)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSComboMainFragment.f.a(paramBundle));
    localArrayList.add(WSProfileFragment.a(b(paramBundle)));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.WSMainContainerPagerFragmentFactory
 * JD-Core Version:    0.7.0.1
 */