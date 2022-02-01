package com.tencent.biz.pubaccount.weishi_new.combo;

import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/IWSFragmentFactory;", "", "createFragments", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "Lkotlin/collections/ArrayList;", "bundle", "Landroid/os/Bundle;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IWSFragmentFactory
{
  @NotNull
  public abstract ArrayList<QBaseFragment> a(@Nullable Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.IWSFragmentFactory
 * JD-Core Version:    0.7.0.1
 */