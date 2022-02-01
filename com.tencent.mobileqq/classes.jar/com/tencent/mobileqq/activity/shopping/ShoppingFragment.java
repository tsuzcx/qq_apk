package com.tencent.mobileqq.activity.shopping;

import VAC_ADV_GET_ACCESS.VacAdvGetAccess.OrderStateInfo;
import VAC_ADV_GET_ACCESS.VacAdvGetAccess.VacMemberGetOrderCntReq;
import VAC_ADV_GET_ACCESS.VacAdvGetAccess.VacMemberGetOrderCntRsp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter;
import com.tencent.biz.subscribe.network.GetSubscribeFeedListRequest;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.PbProtocol;
import com.tencent.util.MqqWeakReferenceHandler;
import common.config.service.QzoneConfig;
import cooperation.ilive.manager.IliveRedManager;
import cooperation.ilive.share.IliveShareHelper;
import cooperation.ilive.util.IlivePreloadHelper;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ShoppingFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback
{
  public static String a = "ShoppingFragment";
  protected View b;
  private Activity c;
  private BlockContainer d;
  private ShoppingHeadView e;
  private final MqqHandler f = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private QQAppInterface g;
  private boolean h;
  private RelativeFeedsAdapter i;
  
  private void a(int paramInt1, int paramInt2)
  {
    String str = QzoneConfig.getInstance().getConfig("K_QQ_VAS", "SK_QQ_VAS_LiveDrawerShoppingOrderJumpUrl");
    if (TextUtils.isEmpty(str)) {
      str = String.format("https://h5.qzone.qq.com/v2/vip/live/order?flag=%d&_wv=2&state=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    } else {
      str = str.replace("{flag}", String.valueOf(paramInt1)).replace("{state}", String.valueOf(paramInt2));
    }
    VasWebviewUtil.a(getBaseActivity(), str, 256L, null, false, -1);
  }
  
  private void a(VacAdvGetAccess.VacMemberGetOrderCntRsp paramVacMemberGetOrderCntRsp)
  {
    if (paramVacMemberGetOrderCntRsp == null) {
      return;
    }
    if (!paramVacMemberGetOrderCntRsp.order_states.has())
    {
      this.e.a();
      return;
    }
    paramVacMemberGetOrderCntRsp = paramVacMemberGetOrderCntRsp.order_states.get().iterator();
    while (paramVacMemberGetOrderCntRsp.hasNext())
    {
      VacAdvGetAccess.OrderStateInfo localOrderStateInfo = (VacAdvGetAccess.OrderStateInfo)paramVacMemberGetOrderCntRsp.next();
      if ((localOrderStateInfo.state.has()) && (localOrderStateInfo.state.has()) && (localOrderStateInfo.total_num.has()))
      {
        int j = localOrderStateInfo.total_num.get();
        int k = localOrderStateInfo.state.get();
        if (k != 0)
        {
          if (k != 1)
          {
            if (k != 2)
            {
              if (k == 4) {
                this.e.setAfterSaleViewCount(j);
              }
            }
            else {
              this.e.setAfterSendViewCount(j);
            }
          }
          else {
            this.e.setToSendViewCount(j);
          }
        }
        else {
          this.e.setToPayViewCount(j);
        }
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("KEY_TITLE_NAME", paramString);
    if ((paramContext instanceof Activity))
    {
      PublicFragmentActivity.a(paramContext, localIntent, ShoppingFragment.class);
      return;
    }
    PublicFragmentActivity.Launcher.a(localIntent, PublicFragmentActivity.class, ShoppingFragment.class);
  }
  
  private void a(RelativeFeedsAdapter paramRelativeFeedsAdapter)
  {
    e();
    b(paramRelativeFeedsAdapter);
  }
  
  private void b()
  {
    String str = getString(2131891371);
    Object localObject = getBaseActivity();
    if ((localObject != null) && (((Activity)localObject).getIntent() != null)) {
      localObject = ((Activity)localObject).getIntent().getStringExtra("KEY_TITLE_NAME");
    } else {
      localObject = "";
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = str;
    }
    setTitle((CharSequence)localObject);
  }
  
  private void b(RelativeFeedsAdapter paramRelativeFeedsAdapter)
  {
    GetSubscribeFeedListRequest localGetSubscribeFeedListRequest = new GetSubscribeFeedListRequest(2, null, null);
    localGetSubscribeFeedListRequest.setEnableCache(true);
    VSNetworkHelper.getInstance().sendRequest(localGetSubscribeFeedListRequest, new ShoppingFragment.5(this, paramRelativeFeedsAdapter));
  }
  
  private void c()
  {
    IliveShareHelper.reportAction("qq_live", "shopcart_page", "", "", "", 100, IliveShareHelper.getFollowInfo("", IliveRedManager.sRedShoppingStr2, "", "", ""));
    IliveRedManager.sRedShoppingStr2 = "3";
    MobileReportManager.getInstance().reportActionLive("", "", "qq_live", "shopcart_page", "my_order", 100, 1, System.currentTimeMillis(), "");
  }
  
  private void c(RelativeFeedsAdapter paramRelativeFeedsAdapter)
  {
    GetSubscribeFeedListRequest localGetSubscribeFeedListRequest = new GetSubscribeFeedListRequest(2, null, paramRelativeFeedsAdapter.D().h(), paramRelativeFeedsAdapter.D().i());
    VSNetworkHelper.getInstance().sendRequest(localGetSubscribeFeedListRequest, new ShoppingFragment.6(this, paramRelativeFeedsAdapter));
  }
  
  private void d()
  {
    this.e.setOnClickEventListener(new ShoppingFragment.1(this));
  }
  
  private void e()
  {
    if (this.g == null) {
      return;
    }
    VacAdvGetAccess.VacMemberGetOrderCntReq localVacMemberGetOrderCntReq = new VacAdvGetAccess.VacMemberGetOrderCntReq();
    localVacMemberGetOrderCntReq.ware_house_id.set(102);
    localVacMemberGetOrderCntReq.media_type.set(4);
    localVacMemberGetOrderCntReq.buyer_id.set(this.g.getCurrentUin());
    PbProtocol.a("QQLive.MemberGetOrderCnt", localVacMemberGetOrderCntReq, VacAdvGetAccess.VacMemberGetOrderCntRsp.class, new ShoppingFragment.2(this));
  }
  
  private void f()
  {
    this.d = ((BlockContainer)this.b.findViewById(2131437376));
    this.d.setParentFragment(this);
    this.d.setLayoutManagerType(3, 2);
    this.d.setEnableLoadMore(true);
    this.e = new ShoppingHeadView(getBaseActivity());
    this.i = new RelativeFeedsAdapter(null);
    this.i.c(2);
    this.i.c(this.h);
    this.i.b(false);
    this.i.a(new ShoppingFragment.3(this));
    this.d.a(new ShoppingFragment.4(this, null));
    this.d.a(this.i);
    this.d.setEnableRefresh(true);
    this.d.e();
  }
  
  protected void a()
  {
    if (this.b == null) {
      this.b = LayoutInflater.from(getBaseActivity()).inflate(2131625260, null, false);
    }
    this.g = getBaseActivity().app;
    QQAppInterface localQQAppInterface = this.g;
    if (localQQAppInterface != null) {
      localQQAppInterface.setHandler(ShoppingFragment.class, this.f);
    }
    this.c = getBaseActivity();
    f();
    d();
  }
  
  protected int getContentLayoutId()
  {
    return 2131625260;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1001) {
      a((VacAdvGetAccess.VacMemberGetOrderCntRsp)paramMessage.obj);
    }
    return true;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.d;
    if (localObject != null) {
      ((BlockContainer)localObject).c();
    }
    localObject = this.g;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeHandler(ShoppingFragment.class);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.b = paramView;
    this.h = SubscribeUtils.a();
    if (this.h) {
      this.b.setBackgroundColor(-16777216);
    } else {
      this.b.setBackgroundColor(-657670);
    }
    b();
    a();
    c();
    IlivePreloadHelper.a(getBaseActivity(), 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shopping.ShoppingFragment
 * JD-Core Version:    0.7.0.1
 */