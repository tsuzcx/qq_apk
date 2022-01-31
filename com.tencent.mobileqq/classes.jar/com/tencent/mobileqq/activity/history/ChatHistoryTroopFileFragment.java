package com.tencent.mobileqq.activity.history;

import afmu;
import afmv;
import afmw;
import afmx;
import afmz;
import afps;
import ajjy;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import apae;
import apfd;
import awqx;
import aysd;
import aysl;
import ayso;
import aysp;
import azic;
import azig;
import azih;
import azjg;
import badq;
import begr;
import behe;
import belq;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.widget.QFileListPullMoreLayout;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryTroopFileFragment
  extends ChatHistoryBaseFragment
  implements aysd
{
  public long a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private apae jdField_a_of_type_Apae;
  private apfd jdField_a_of_type_Apfd = new afmw(this);
  private ayso jdField_a_of_type_Ayso;
  private aysp jdField_a_of_type_Aysp;
  private azig jdField_a_of_type_Azig;
  private azih jdField_a_of_type_Azih;
  private belq jdField_a_of_type_Belq;
  private QFileListPullMoreLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private long jdField_b_of_type_Long;
  private Handler jdField_b_of_type_AndroidOsHandler = new afmv(this);
  private View jdField_b_of_type_AndroidViewView;
  private View c;
  private View d;
  private View e;
  
  private void a()
  {
    if (this.jdField_b_of_type_Long != 0L)
    {
      this.jdField_a_of_type_Azih = azih.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      if (!badq.g(getActivity())) {
        azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_Ayso.a(0, 0);
      int i = this.jdField_a_of_type_Azih.a();
      if (this.jdField_a_of_type_Apae == null) {
        this.jdField_a_of_type_Apae = new apae(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_Long);
      }
      QLog.d("ChatHistoryTroopFileFragment<QFile>", 4, "initFileListData : uin[" + this.jdField_b_of_type_Long + "] fileSum[" + i + "]");
      return;
    }
    QLog.e("ChatHistoryTroopFileFragment<QFile>", 2, "troop uin is not legal.");
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ayso.a(paramBoolean);
    if (paramBoolean)
    {
      int i = this.jdField_a_of_type_Afps.a();
      this.d.setPadding(0, i, 0, 0);
      this.d.setVisibility(0);
      return;
    }
    this.d.setPadding(0, 0, 0, 0);
    this.d.setVisibility(8);
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
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setText(2131653906);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextLeftDrawable(2130839113);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131632074);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131654695);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131635828));
      this.e.setVisibility(0);
      return;
    case 6: 
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131631913);
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.e.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.e.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131632076);
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(getActivity()).inflate(2131493891, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_Belq = new afmu(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(getResources().getDrawable(2130839107));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_Belq);
  }
  
  protected void b() {}
  
  void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean) {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BA", "0X800A0BA", 3, 0, "", "", "", "");
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
    if (this.jdField_a_of_type_Azig == null)
    {
      afmz localafmz = new afmz(this, this.jdField_b_of_type_Long);
      this.jdField_a_of_type_Azig = new azig(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localafmz, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    azic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azig);
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 4, 0, "", "", "", "");
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_Azig != null)
    {
      azic.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azig);
      this.jdField_a_of_type_Azig = null;
    }
    c(false);
  }
  
  public void g()
  {
    super.g();
    QLog.i("ChatHistoryTroopFileFragment<QFile>", 1, "doOnDestroy");
    if ((this.jdField_a_of_type_Azih == null) || (this.jdField_a_of_type_Azig != null))
    {
      azic.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azig);
      this.jdField_a_of_type_Azig = null;
    }
    this.jdField_a_of_type_Aysp.b();
    this.jdField_a_of_type_Ayso.b();
    aysl.a().a();
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_Apae != null)
    {
      List localList = this.jdField_a_of_type_Ayso.a();
      this.jdField_a_of_type_Apae.a(localList, 1, null);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BC", "0X800A0BC", 3, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Ayso.a(false);
    h();
  }
  
  protected void l()
  {
    if (this.jdField_a_of_type_Apae != null)
    {
      List localList = this.jdField_a_of_type_Ayso.a();
      this.jdField_a_of_type_Apae.a(localList, 4, null);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BD", "0X800A0BD", 3, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Ayso.a(false);
    h();
  }
  
  protected void m()
  {
    if (this.jdField_a_of_type_Apae != null)
    {
      List localList = this.jdField_a_of_type_Ayso.a();
      this.jdField_a_of_type_Apae.a(localList, 2, null);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BB", "0X800A0BB", 3, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Ayso.a(false);
    h();
  }
  
  protected void n()
  {
    super.n();
    Object localObject = this.jdField_a_of_type_Ayso.a();
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return;
    }
    localObject = (begr)behe.a(getActivity(), null);
    ((begr)localObject).a(2131630692);
    ((begr)localObject).a(getActivity().getString(2131626808), 3);
    ((begr)localObject).c(2131625035);
    ((begr)localObject).a(new afmx(this, (begr)localObject));
    ((begr)localObject).show();
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
        this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131494891, paramViewGroup, false);
        this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131303648));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout = new QFileListPullMoreLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setBackgroundResource(2130838503);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextColor(getResources().getColor(2131101260));
        this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
        this.d = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131494914, null);
        this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.d);
        this.d.setVisibility(8);
        this.e = this.jdField_b_of_type_AndroidViewView.findViewById(2131305214);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302181));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131311233));
        this.jdField_a_of_type_Ayso = new ayso(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_Long, "/", 5000);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ayso);
        this.jdField_a_of_type_Ayso.a(this);
        this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_Ayso);
        this.c = this.jdField_b_of_type_AndroidViewView.findViewById(2131300639).findViewById(2131307084);
        this.c.setOnClickListener(this.jdField_a_of_type_Apfd);
        p();
      }
      paramLayoutInflater = (ViewGroup)this.jdField_b_of_type_AndroidViewView.getParent();
      if (paramLayoutInflater != null) {
        paramLayoutInflater.removeView(this.jdField_b_of_type_AndroidViewView);
      }
      g(5);
      if (this.jdField_a_of_type_Aysp == null)
      {
        this.jdField_a_of_type_Aysp = new aysp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(this.jdField_b_of_type_Long), this.jdField_b_of_type_AndroidOsHandler);
        this.jdField_a_of_type_Aysp.a();
      }
      this.jdField_a_of_type_Aysp.a(false);
      a();
      return this.jdField_b_of_type_AndroidViewView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment
 * JD-Core Version:    0.7.0.1
 */