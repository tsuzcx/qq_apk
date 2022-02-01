package com.tencent.biz.pubaccount.weishi_new.combo.main;

import com.tencent.biz.pubaccount.weishi_new.combo.IWSFragmentFactory;
import com.tencent.biz.pubaccount.weishi_new.combo.WSComboExpHelper;
import com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.WSBottomBarInfo;
import com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.WSBottomBarInfoHelper;
import com.tencent.biz.pubaccount.weishi_new.combo.msg.WSMsgDataFetcher;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.IFetchDataListener;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSBasePresenter;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/main/WSComboMainPresenter;", "Lcom/tencent/biz/pubaccount/weishi_new/presenter/WSBasePresenter;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/main/WSComboMainContract$View;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/main/WSComboMainContract$Presenter;", "()V", "checkIfNeedClearAioListRedDot", "", "createBottomBarInfoList", "", "Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarInfo;", "createFragmentFactory", "Lcom/tencent/biz/pubaccount/weishi_new/combo/IWSFragmentFactory;", "bottomBarInfoList", "getMsgRedDot", "getOffscreenPageLimit", "", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboMainPresenter
  extends WSBasePresenter<WSComboMainContract.View>
  implements WSComboMainContract.Presenter
{
  public static final WSComboMainPresenter.Companion a = new WSComboMainPresenter.Companion(null);
  
  @NotNull
  public IWSFragmentFactory a(@NotNull List<WSBottomBarInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "bottomBarInfoList");
    return (IWSFragmentFactory)new WSMainPagerFragmentFactory(paramList);
  }
  
  @NotNull
  public List<WSBottomBarInfo> a()
  {
    return WSBottomBarInfoHelper.a.a();
  }
  
  public int b()
  {
    return 4;
  }
  
  public void c()
  {
    new WSMsgDataFetcher().a((IFetchDataListener)new WSComboMainPresenter.getMsgRedDot.1(this));
  }
  
  public void d()
  {
    if (!WSComboExpHelper.a.e())
    {
      if (WSComboExpHelper.a.d()) {
        return;
      }
      Object localObject = WeishiUtils.g();
      if (localObject != null)
      {
        localObject = ((WSRedDotPushMsg)localObject).mStrategyInfo;
        if (localObject != null)
        {
          localObject = Integer.valueOf(((IWSPushBaseStrategy)localObject).getType());
          break label51;
        }
      }
      localObject = null;
      label51:
      if ((localObject == null) || (((Integer)localObject).intValue() != 1))
      {
        if (localObject == null) {
          return;
        }
        if (((Integer)localObject).intValue() != 3) {
          return;
        }
      }
      WSLog.e("WSComboMainPresenter", "set red push msg read.");
      WeishiUtils.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.main.WSComboMainPresenter
 * JD-Core Version:    0.7.0.1
 */