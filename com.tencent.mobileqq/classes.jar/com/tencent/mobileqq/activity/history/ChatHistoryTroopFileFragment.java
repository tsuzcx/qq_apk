package com.tencent.mobileqq.activity.history;

import afyp;
import afyq;
import afyr;
import afys;
import afyt;
import afyv;
import afyw;
import afyx;
import agbq;
import ajya;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import apsc;
import apwz;
import axqy;
import azsv;
import aztd;
import aztg;
import azth;
import bajt;
import bajx;
import bajy;
import bakx;
import bbdx;
import bbfj;
import bfpc;
import bfpp;
import bfub;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.widget.QFileListPullMoreLayout;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;
import mqq.os.MqqHandler;
import xar;
import xau;

public class ChatHistoryTroopFileFragment
  extends ChatHistoryBaseFragment
  implements azsv
{
  private int jdField_a_of_type_Int = -1;
  public long a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afys(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private apsc jdField_a_of_type_Apsc;
  private apwz jdField_a_of_type_Apwz = new afyr(this);
  private aztg jdField_a_of_type_Aztg;
  private azth jdField_a_of_type_Azth;
  private bajx jdField_a_of_type_Bajx;
  private bajy jdField_a_of_type_Bajy;
  private bfub jdField_a_of_type_Bfub;
  private QFileListPullMoreLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected xar a;
  protected xau a;
  private long jdField_b_of_type_Long;
  private Handler jdField_b_of_type_AndroidOsHandler = new afyq(this);
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private long jdField_c_of_type_Long = -1L;
  private View jdField_c_of_type_AndroidViewView;
  private long jdField_d_of_type_Long = -1L;
  private View jdField_d_of_type_AndroidViewView;
  private View e;
  private View f;
  
  public ChatHistoryTroopFileFragment()
  {
    this.jdField_a_of_type_Xar = new afyv(this);
    this.jdField_a_of_type_Xau = new afyw(this);
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Aztg.a(paramBoolean);
    if (paramBoolean)
    {
      int i = this.jdField_a_of_type_Agbq.a();
      this.jdField_d_of_type_AndroidViewView.setPadding(0, i, 0, 0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_d_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void e(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
    {
      ThreadManager.getUIHandler().postDelayed(new ChatHistoryTroopFileFragment.2(this), 800L);
      if (paramInt == 4)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      }
      if (paramInt == 3) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(1);
      }
    }
  }
  
  private void f(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
    }
    do
    {
      return;
      if ((paramInt == 5) || (paramInt == 6) || (paramInt == 7))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setText(2131719801);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextLeftDrawable(2130839140);
        return;
      }
    } while (paramInt != 8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
  }
  
  private void g(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
    case 5: 
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697804);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131720604);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131701623));
      this.e.setVisibility(0);
      return;
    case 6: 
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697628);
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.e.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.e.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697806);
  }
  
  private void p()
  {
    if (this.jdField_b_of_type_Long != 0L)
    {
      this.jdField_a_of_type_Bajy = bajy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      if (!bbfj.g(getActivity())) {
        bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_Aztg.a(0, 0);
      int i = this.jdField_a_of_type_Bajy.a();
      if (this.jdField_a_of_type_Apsc == null) {
        this.jdField_a_of_type_Apsc = new apsc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_Long);
      }
      QLog.d("ChatHistoryTroopFileFragment<QFile>", 4, "initFileListData : uin[" + this.jdField_b_of_type_Long + "] fileSum[" + i + "]");
      return;
    }
    QLog.e("ChatHistoryTroopFileFragment<QFile>", 2, "troop uin is not legal.");
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(getActivity()).inflate(2131559459, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_Bfub = new afyp(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(getResources().getDrawable(2130839135));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_Bfub);
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_Int == -1) || (this.jdField_c_of_type_Long == -1L) || (this.jdField_d_of_type_Long == -1L))
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131377780));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377781));
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (this.jdField_d_of_type_Long >= this.jdField_c_of_type_Long)
    {
      localObject = bbdx.a(this.jdField_c_of_type_Long);
      localObject = String.format(getString(2131698241), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), localObject });
      int i = ((String)localObject).indexOf(getString(2131698242));
      localObject = new SpannableString((CharSequence)localObject);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#FF596A")), i, i + 4, 33);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
    Object localObject = bbdx.a(this.jdField_d_of_type_Long);
    String str = bbdx.a(this.jdField_c_of_type_Long);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format(getString(2131698243), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), localObject, str }));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
  }
  
  public void a()
  {
    ThreadManagerV2.getUIHandlerV2().post(new ChatHistoryTroopFileFragment.7(this));
  }
  
  protected void b() {}
  
  void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean) {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BA", "0X800A0BA", 3, 0, "", "", "", "");
    }
    c(paramBoolean);
  }
  
  protected int c()
  {
    return 1602;
  }
  
  protected void c() {}
  
  public void c(int paramInt)
  {
    g(paramInt);
    a();
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      return this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
    }
    return 0;
  }
  
  public void d(int paramInt)
  {
    e(paramInt);
    f(paramInt);
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      return this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition();
    }
    return 0;
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Bajx == null)
    {
      afyx localafyx = new afyx(this, this.jdField_b_of_type_Long);
      this.jdField_a_of_type_Bajx = new bajx(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localafyx, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    bajt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bajx);
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 4, 0, "", "", "", "");
    a();
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_Bajx != null)
    {
      bajt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bajx);
      this.jdField_a_of_type_Bajx = null;
    }
    c(false);
  }
  
  public void g()
  {
    super.g();
    QLog.i("ChatHistoryTroopFileFragment<QFile>", 1, "doOnDestroy");
    if ((this.jdField_a_of_type_Bajy == null) || (this.jdField_a_of_type_Bajx != null))
    {
      bajt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bajx);
      this.jdField_a_of_type_Bajx = null;
    }
    this.jdField_a_of_type_Azth.b();
    this.jdField_a_of_type_Aztg.b();
    aztd.a().a();
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_Apsc != null)
    {
      List localList = this.jdField_a_of_type_Aztg.a();
      this.jdField_a_of_type_Apsc.a(localList, 1, null);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BC", "0X800A0BC", 3, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Aztg.a(false);
    h();
  }
  
  protected void l()
  {
    if (this.jdField_a_of_type_Apsc != null)
    {
      List localList = this.jdField_a_of_type_Aztg.a();
      this.jdField_a_of_type_Apsc.a(localList, 4, null);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BD", "0X800A0BD", 3, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Aztg.a(false);
    h();
  }
  
  protected void m()
  {
    if (this.jdField_a_of_type_Apsc != null)
    {
      List localList = this.jdField_a_of_type_Aztg.a();
      this.jdField_a_of_type_Apsc.a(localList, 2, null);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BB", "0X800A0BB", 3, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Aztg.a(false);
    h();
  }
  
  protected void n()
  {
    super.n();
    Object localObject = this.jdField_a_of_type_Aztg.a();
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return;
    }
    localObject = (bfpc)bfpp.a(getActivity(), null);
    ((bfpc)localObject).a(2131696396);
    ((bfpc)localObject).a(getActivity().getString(2131692409), 3);
    ((bfpc)localObject).c(2131690596);
    ((bfpc)localObject).a(new afyt(this, (bfpc)localObject));
    ((bfpc)localObject).show();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(a())) {
      QLog.i("ChatHistoryTroopFileFragment<QFile>", 1, "get uin is empty.");
    }
    for (this.jdField_b_of_type_Long = 0L;; this.jdField_b_of_type_Long = Long.valueOf(a()).longValue())
    {
      if (this.jdField_b_of_type_AndroidViewView == null)
      {
        this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560462, paramViewGroup, false);
        this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369318));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout = new QFileListPullMoreLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setBackgroundResource(2130838514);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextColor(getResources().getColor(2131166854));
        this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131560484, null);
        this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_d_of_type_AndroidViewView);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.e = this.jdField_b_of_type_AndroidViewView.findViewById(2131370886);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131367799));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377045));
        this.jdField_a_of_type_Aztg = new aztg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_Long, "/", 5000);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aztg);
        this.jdField_a_of_type_Aztg.a(this);
        this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_Aztg);
        this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131366241).findViewById(2131372798);
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Apwz);
        this.f = this.jdField_b_of_type_AndroidViewView.findViewById(2131377701);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131377700).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131377702).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        q();
      }
      paramLayoutInflater = (ViewGroup)this.jdField_b_of_type_AndroidViewView.getParent();
      if (paramLayoutInflater != null) {
        paramLayoutInflater.removeView(this.jdField_b_of_type_AndroidViewView);
      }
      g(5);
      if (this.jdField_a_of_type_Azth == null)
      {
        this.jdField_a_of_type_Azth = new azth(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(this.jdField_b_of_type_Long), this.jdField_b_of_type_AndroidOsHandler);
        this.jdField_a_of_type_Azth.a();
      }
      this.jdField_a_of_type_Azth.a(false);
      p();
      return this.jdField_b_of_type_AndroidViewView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment
 * JD-Core Version:    0.7.0.1
 */