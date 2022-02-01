package com.tencent.mobileqq.activity.shopping;

import aabu;
import aaek;
import aagu;
import afez;
import amgq;
import amgr;
import amgs;
import amgt;
import amgu;
import amgv;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import biij;
import blha;
import bmfs;
import bmfy;
import bmzn;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.network.GetSubscribeFeedListRequest;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import common.config.service.QzoneConfig;
import cooperation.ilive.share.IliveShareHelper;
import cooperation.vip.pb.VacAdvGetAccess.OrderStateInfo;
import cooperation.vip.pb.VacAdvGetAccess.VacMemberGetOrderCntReq;
import cooperation.vip.pb.VacAdvGetAccess.VacMemberGetOrderCntRsp;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ShoppingFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback
{
  public static String a;
  private aagu jdField_a_of_type_Aagu;
  private Activity jdField_a_of_type_AndroidAppActivity;
  protected View a;
  private BlockContainer jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer;
  private ShoppingHeadView jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new blha(Looper.getMainLooper(), this, true);
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "ShoppingFragment";
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    String str = QzoneConfig.getInstance().getConfig("K_QQ_VAS", "SK_QQ_VAS_LiveDrawerShoppingOrderJumpUrl");
    if (TextUtils.isEmpty(str)) {}
    for (str = String.format("https://h5.qzone.qq.com/v2/vip/live/order?flag=%d&_wv=2&state=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });; str = str.replace("{flag}", String.valueOf(paramInt1)).replace("{state}", String.valueOf(paramInt2)))
    {
      VasWebviewUtil.openQQBrowserActivity(getActivity(), str, 256L, null, false, -1);
      return;
    }
  }
  
  private void a(aagu paramaagu)
  {
    e();
    b(paramaagu);
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
    afez.a(localIntent, PublicFragmentActivity.class, ShoppingFragment.class);
  }
  
  private void a(VacAdvGetAccess.VacMemberGetOrderCntRsp paramVacMemberGetOrderCntRsp)
  {
    if (paramVacMemberGetOrderCntRsp == null) {}
    for (;;)
    {
      return;
      if (!paramVacMemberGetOrderCntRsp.order_states.has())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView.a();
        return;
      }
      paramVacMemberGetOrderCntRsp = paramVacMemberGetOrderCntRsp.order_states.get().iterator();
      while (paramVacMemberGetOrderCntRsp.hasNext())
      {
        VacAdvGetAccess.OrderStateInfo localOrderStateInfo = (VacAdvGetAccess.OrderStateInfo)paramVacMemberGetOrderCntRsp.next();
        if ((localOrderStateInfo.state.has()) && (localOrderStateInfo.state.has()) && (localOrderStateInfo.total_num.has()))
        {
          int i = localOrderStateInfo.total_num.get();
          switch (localOrderStateInfo.state.get())
          {
          case 3: 
          default: 
            break;
          case 0: 
            this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView.setToPayViewCount(i);
            break;
          case 1: 
            this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView.setToSendViewCount(i);
            break;
          case 2: 
            this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView.setAfterSendViewCount(i);
            break;
          case 4: 
            this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView.setAfterSaleViewCount(i);
          }
        }
      }
    }
  }
  
  private void b()
  {
    String str = getString(2131693400);
    Object localObject2 = "";
    FragmentActivity localFragmentActivity = getActivity();
    Object localObject1 = localObject2;
    if (localFragmentActivity != null)
    {
      localObject1 = localObject2;
      if (localFragmentActivity.getIntent() != null) {
        localObject1 = localFragmentActivity.getIntent().getStringExtra("KEY_TITLE_NAME");
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = str;
    }
    setTitle((CharSequence)localObject2);
  }
  
  private void b(aagu paramaagu)
  {
    GetSubscribeFeedListRequest localGetSubscribeFeedListRequest = new GetSubscribeFeedListRequest(2, null, null);
    localGetSubscribeFeedListRequest.setEnableCache(true);
    VSNetworkHelper.a().a(localGetSubscribeFeedListRequest, new amgu(this, localGetSubscribeFeedListRequest, paramaagu));
  }
  
  private void c()
  {
    IliveShareHelper.reportAction("qq_live", "shopcart_page", "", "", "", 100, IliveShareHelper.getFollowInfo("", bmfs.jdField_a_of_type_JavaLangString, "", "", ""));
    bmfs.jdField_a_of_type_JavaLangString = "3";
    bmzn.a().a("", "", "qq_live", "shopcart_page", "my_order", 100, 1, System.currentTimeMillis(), "");
  }
  
  private void c(aagu paramaagu)
  {
    GetSubscribeFeedListRequest localGetSubscribeFeedListRequest = new GetSubscribeFeedListRequest(2, null, paramaagu.getLoadInfo().c(), paramaagu.getLoadInfo().d());
    VSNetworkHelper.a().a(localGetSubscribeFeedListRequest, new amgv(this, paramaagu));
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView.setOnClickEventListener(new amgq(this));
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    VacAdvGetAccess.VacMemberGetOrderCntReq localVacMemberGetOrderCntReq = new VacAdvGetAccess.VacMemberGetOrderCntReq();
    localVacMemberGetOrderCntReq.ware_house_id.set(102);
    localVacMemberGetOrderCntReq.media_type.set(4);
    localVacMemberGetOrderCntReq.buyer_id.set(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    biij.a("QQLive.MemberGetOrderCnt", localVacMemberGetOrderCntReq, VacAdvGetAccess.VacMemberGetOrderCntRsp.class, new amgr(this));
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = ((BlockContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131370098));
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setLayoutManagerType(3, 2);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingHeadView = new ShoppingHeadView(getActivity());
    this.jdField_a_of_type_Aagu = new aagu(null);
    this.jdField_a_of_type_Aagu.b(2);
    this.jdField_a_of_type_Aagu.c(this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Aagu.b(false);
    this.jdField_a_of_type_Aagu.setOnLoadDataDelegate(new amgs(this));
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(new amgt(this, null));
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Aagu);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setEnableRefresh(true);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.c();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getActivity()).inflate(2131559319, null, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(ShoppingFragment.class, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    this.jdField_a_of_type_AndroidAppActivity = getActivity();
    f();
    d();
  }
  
  public int getContentLayoutId()
  {
    return 2131559319;
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
    if (this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer != null) {
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(ShoppingFragment.class);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Boolean = aaek.a();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    }
    for (;;)
    {
      b();
      a();
      c();
      bmfy.a(getActivity(), 3);
      return;
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-657670);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shopping.ShoppingFragment
 * JD-Core Version:    0.7.0.1
 */