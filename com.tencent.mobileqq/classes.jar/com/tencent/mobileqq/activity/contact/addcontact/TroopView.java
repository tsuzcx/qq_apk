package com.tencent.mobileqq.activity.contact.addcontact;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.addContactTroopView.AddContactTroopHandler;
import com.tencent.biz.addContactTroopView.AddContactTroopHandler.IGetPopClassAndSearchCB;
import com.tencent.biz.addContactTroopView.AddContactTroopManage;
import com.tencent.biz.addContactTroopView.TroopCardBanner;
import com.tencent.biz.addContactTroopView.TroopCardPopClassfic;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import java.util.List;
import mqq.app.AppActivity;
import tencent.im.troop_search_popclassifc.popclassifc.BannerCard;
import tencent.im.troop_search_popclassifc.popclassifc.PopCard;
import tencent.im.troop_search_searchtab.searchtab.RspBody;
import tencent.im.troop_view.troopviewInfo.RspBody;
import wjf;
import wjg;
import wjh;
import wji;
import wjj;
import wjk;

public class TroopView
  extends ContactBaseView
{
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AddContactTroopHandler.IGetPopClassAndSearchCB jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB = new wjh(this);
  private TroopCardBanner jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner;
  private TroopCardPopClassfic jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardPopClassfic;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new wjg(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private wjj jdField_a_of_type_Wjj;
  private wjk jdField_a_of_type_Wjk;
  private boolean jdField_a_of_type_Boolean;
  private AddContactTroopHandler.IGetPopClassAndSearchCB jdField_b_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB = new wji(this);
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public TroopView(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext);
  }
  
  private TopGestureLayout a()
  {
    ViewGroup localViewGroup2 = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().getWindow().getDecorView();
    View localView = localViewGroup2.getChildAt(0);
    ViewGroup localViewGroup1 = localViewGroup2;
    if (localView != null)
    {
      localViewGroup1 = localViewGroup2;
      if ((localView instanceof ViewGroup)) {
        localViewGroup1 = (ViewGroup)localView;
      }
    }
    if ((localViewGroup1 instanceof TopGestureLayout)) {
      return (TopGestureLayout)localViewGroup1;
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (((AppActivity)this.jdField_a_of_type_AndroidAppActivity).isResume()) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, paramInt1, getResources().getString(paramInt2), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
    }
  }
  
  private void a(List paramList)
  {
    this.jdField_a_of_type_Wjj = new wjj(this, null);
    this.jdField_a_of_type_Wjj.a(paramList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Wjj);
  }
  
  private void a(popclassifc.BannerCard paramBannerCard)
  {
    this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner = new TroopCardBanner(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext);
    this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner.a();
    this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner.setData(paramBannerCard);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner);
  }
  
  private void a(popclassifc.PopCard paramPopCard)
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardPopClassfic = new TroopCardPopClassfic(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext);
      this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardPopClassfic.a();
      this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardPopClassfic.setData(paramPopCard);
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardPopClassfic);
      return;
    }
    catch (OutOfMemoryError paramPopCard)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TroopView", 2, "initAddPopClassfic error:" + paramPopCard.getMessage());
      return;
    }
    catch (InflateException paramPopCard)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TroopView", 2, "initAddPopClassfic error:" + paramPopCard.getMessage());
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.d = false;
    if (!NetworkUtil.g(getContext()))
    {
      r();
      return;
    }
    AddContactTroopHandler localAddContactTroopHandler = new AddContactTroopHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramBoolean)
    {
      if (!this.f) {
        this.jdField_a_of_type_Wjk.sendEmptyMessageDelayed(2, 5000L);
      }
      localAddContactTroopHandler.a(this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB, this.jdField_b_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB);
      return;
    }
    localAddContactTroopHandler.b(this.jdField_a_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB, this.jdField_b_of_type_ComTencentBizAddContactTroopViewAddContactTroopHandler$IGetPopClassAndSearchCB);
  }
  
  private boolean a()
  {
    AddContactTroopManage localAddContactTroopManage = (AddContactTroopManage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(79);
    return (this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner == null) && (this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardPopClassfic == null) && (localAddContactTroopManage.a().searchRsb.rpt_card.size() <= 0);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner != null) {
      this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner.e();
    }
    if (this.jdField_a_of_type_Wjj != null) {
      this.jdField_a_of_type_Wjj.a();
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_Wjk = new wjk(this);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131363049));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131366408));
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130838214);
    Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity);
    View localView = ((LayoutInflater)localObject).inflate(2130969412, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131366409));
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(getResources().getDimensionPixelSize(2131558912), 0, 0, 0);
    Drawable localDrawable = getResources().getDrawable(2130845992);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(localDrawable, null, null, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new wjf(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView, null, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)((LayoutInflater)localObject).inflate(2130969239, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    localObject = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a());
    ((LinearLayout)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), 20.0F)));
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView((View)localObject, null, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = a();
  }
  
  private void j()
  {
    this.e = true;
    this.jdField_a_of_type_Wjk.sendEmptyMessage(3);
  }
  
  private void k()
  {
    AddContactTroopManage localAddContactTroopManage = (AddContactTroopManage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(79);
    if ((localAddContactTroopManage.a() != null) && (localAddContactTroopManage.a() != null) && (localAddContactTroopManage.a().rpt_banner_items.size() > 0) && (this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner == null)) {
      a(localAddContactTroopManage.a());
    }
    if ((localAddContactTroopManage.a() != null) && (localAddContactTroopManage.a() != null) && (localAddContactTroopManage.a().rpt_pop_items.size() > 0) && (this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardPopClassfic == null)) {
      a(localAddContactTroopManage.a());
    }
  }
  
  private void l()
  {
    a(((AddContactTroopManage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(79)).a().searchRsb.rpt_card.get());
  }
  
  private void m()
  {
    if (a()) {
      s();
    }
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      p();
      q();
    }
  }
  
  private void o()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      q();
    }
  }
  
  private void p()
  {
    try
    {
      AddContactTroopManage localAddContactTroopManage = (AddContactTroopManage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(79);
      k();
      if (this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner != null) {
        this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner.setData(localAddContactTroopManage.a());
      }
      if (this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardPopClassfic != null) {
        this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardPopClassfic.setData(localAddContactTroopManage.a());
      }
      if ((this.jdField_a_of_type_Wjj != null) && (localAddContactTroopManage.a() != null))
      {
        this.jdField_a_of_type_Wjj.a(localAddContactTroopManage.a().searchRsb.rpt_card.get());
        this.jdField_a_of_type_Wjj.notifyDataSetChanged();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void q()
  {
    this.f = true;
    t();
    if ((this.d) || (this.c))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      this.jdField_a_of_type_Wjk.sendEmptyMessageDelayed(0, 800L);
    }
    do
    {
      return;
      this.jdField_a_of_type_Wjk.sendEmptyMessageDelayed(0, 800L);
    } while (this.e);
    a(1, 2131434349);
  }
  
  private void r()
  {
    t();
    if (!this.e)
    {
      a(1, 2131434811);
      this.jdField_a_of_type_Wjk.sendEmptyMessageDelayed(1, 800L);
    }
  }
  
  private void s()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  private void t()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  protected void a()
  {
    super.a();
    super.a(2130969411);
    setBackgroundResource(2130838590);
    h();
    i();
    k();
    l();
    m();
    j();
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
    }
    if (this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner != null) {
      this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner.b();
    }
  }
  
  protected void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(true);
    }
    if (this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner != null) {
      this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner.c();
    }
  }
  
  protected void d()
  {
    super.d();
    e();
  }
  
  protected void g()
  {
    super.g();
    if (this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner != null) {
      this.jdField_a_of_type_ComTencentBizAddContactTroopViewTroopCardBanner.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.TroopView
 * JD-Core Version:    0.7.0.1
 */