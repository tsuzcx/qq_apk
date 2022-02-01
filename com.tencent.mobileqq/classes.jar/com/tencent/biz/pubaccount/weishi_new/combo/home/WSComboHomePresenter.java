package com.tencent.biz.pubaccount.weishi_new.combo.home;

import UserGrowth.stSimpleMetaPerson;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.combo.IWSFragmentFactory;
import com.tencent.biz.pubaccount.weishi_new.combo.reddot.WSRedDotDataFetcher;
import com.tencent.biz.pubaccount.weishi_new.data.IFetcherRspListener;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSBasePresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/home/WSComboHomePresenter;", "Lcom/tencent/biz/pubaccount/weishi_new/presenter/WSBasePresenter;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/WSComboHomeContract$View;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/WSComboHomeContract$Presenter;", "()V", "redDotRequestFetcher", "Lcom/tencent/biz/pubaccount/weishi_new/combo/reddot/WSRedDotDataFetcher;", "createFragmentFactory", "Lcom/tencent/biz/pubaccount/weishi_new/combo/IWSFragmentFactory;", "getOffscreenPageLimit", "", "requestRedDotInfo", "", "saveUserInfo", "user", "LUserGrowth/stSimpleMetaPerson;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboHomePresenter
  extends WSBasePresenter<WSComboHomeContract.View>
  implements WSComboHomeContract.Presenter
{
  private final WSRedDotDataFetcher a = new WSRedDotDataFetcher();
  
  private final void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson != null)
    {
      if (!TextUtils.isEmpty((CharSequence)paramstSimpleMetaPerson.id)) {
        WeishiUtils.k(paramstSimpleMetaPerson.id);
      }
      if (!TextUtils.isEmpty((CharSequence)paramstSimpleMetaPerson.nick)) {
        WeishiUtils.l(paramstSimpleMetaPerson.nick);
      }
    }
  }
  
  @NotNull
  public IWSFragmentFactory a()
  {
    return (IWSFragmentFactory)new WSHomePagerFragmentFactory();
  }
  
  public int b()
  {
    return 2;
  }
  
  public void c()
  {
    this.a.a(null, (IFetcherRspListener)new WSComboHomePresenter.requestRedDotInfo.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.home.WSComboHomePresenter
 * JD-Core Version:    0.7.0.1
 */