package com.tencent.mobileqq.activity.history;

import aaha;
import ajra;
import ajto;
import ajtp;
import ajtq;
import ajtr;
import ajts;
import ajtu;
import ajtv;
import ajtw;
import ajwu;
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
import anvx;
import aubw;
import aufo;
import bdla;
import bfif;
import bfmh;
import bfmn;
import bfmp;
import bfms;
import bfmt;
import bgjc;
import bgjg;
import bgjh;
import bgke;
import bkzi;
import bkzz;
import bldp;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.widget.QFileListPullMoreLayout;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryTroopFileFragment
  extends ChatHistoryBaseFragment
  implements aaha, bfmh, bfmn
{
  private int jdField_a_of_type_Int = -1;
  public long a;
  protected ajtu a;
  protected ajtv a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ajtr(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aubw jdField_a_of_type_Aubw;
  private aufo jdField_a_of_type_Aufo = new ajtq(this);
  private bfms jdField_a_of_type_Bfms;
  private bfmt jdField_a_of_type_Bfmt;
  private bgjg jdField_a_of_type_Bgjg;
  private bgjh jdField_a_of_type_Bgjh;
  private bldp jdField_a_of_type_Bldp;
  private QFileListPullMoreLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private long jdField_b_of_type_Long;
  private Handler jdField_b_of_type_AndroidOsHandler = new ajtp(this);
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private long jdField_c_of_type_Long = -1L;
  private View jdField_c_of_type_AndroidViewView;
  private long jdField_d_of_type_Long = -1L;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private View e;
  private View f;
  
  public ChatHistoryTroopFileFragment()
  {
    this.jdField_a_of_type_Ajtu = new ajtu(this, this);
    this.jdField_a_of_type_Ajtv = new ajtv(this, this);
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bfms.a(paramBoolean);
    if (paramBoolean)
    {
      int i = this.jdField_a_of_type_Ajwu.a();
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
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setText(2131718995);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextLeftDrawable(2130839466);
        return;
      }
    } while (paramInt != 8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
  }
  
  private void g(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Ajra.a(this.jdField_d_of_type_Boolean);
      return;
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697293);
      this.jdField_d_of_type_Boolean = false;
      continue;
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719753);
      this.jdField_d_of_type_Boolean = false;
      continue;
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131701121));
      this.e.setVisibility(0);
      this.jdField_d_of_type_Boolean = false;
      continue;
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697105);
      this.jdField_d_of_type_Boolean = false;
      continue;
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.e.setVisibility(8);
      this.jdField_d_of_type_Boolean = true;
      continue;
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697295);
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  private void q()
  {
    if (this.jdField_b_of_type_Long != 0L)
    {
      this.jdField_a_of_type_Bgjh = bgjh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      if (!NetworkUtil.isNetworkAvailable(getActivity())) {
        bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_Bfms.a(0, 0);
      int i = this.jdField_a_of_type_Bgjh.a();
      if (this.jdField_a_of_type_Aubw == null) {
        this.jdField_a_of_type_Aubw = new aubw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_Long);
      }
      QLog.d("ChatHistoryTroopFileFragment<QFile>", 4, "initFileListData : uin[" + this.jdField_b_of_type_Long + "] fileSum[" + i + "]");
      return;
    }
    QLog.e("ChatHistoryTroopFileFragment<QFile>", 2, "troop uin is not legal.");
  }
  
  private void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(getActivity()).inflate(2131559689, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_Bldp = new ajto(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(getResources().getDrawable(2130839461));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_Bldp);
  }
  
  private void s()
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
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131379460));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379461));
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (this.jdField_d_of_type_Long >= this.jdField_c_of_type_Long)
    {
      localObject = FileUtils.getFileSize(this.jdField_c_of_type_Long);
      localObject = String.format(getString(2131697968), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), localObject });
      int i = ((String)localObject).indexOf(getString(2131697969));
      localObject = new SpannableString((CharSequence)localObject);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#FF596A")), i, i + 4, 33);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
    Object localObject = FileUtils.getFileSize(this.jdField_d_of_type_Long);
    String str = FileUtils.getFileSize(this.jdField_c_of_type_Long);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format(getString(2131697970), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), localObject, str }));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
  }
  
  public void a()
  {
    ThreadManagerV2.getUIHandlerV2().post(new ChatHistoryTroopFileFragment.7(this));
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt)
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {}
    while (!paramBoolean) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new ChatHistoryTroopFileFragment.8(this, paramLong1, paramLong2));
  }
  
  public void a(boolean paramBoolean, bfif parambfif)
  {
    parambfif = this.jdField_a_of_type_Bfms.a().iterator();
    do
    {
      if (!parambfif.hasNext()) {
        break;
      }
    } while (((bfif)parambfif.next()).jdField_a_of_type_Long <= 104857600L);
    for (paramBoolean = false;; paramBoolean = true)
    {
      this.jdField_a_of_type_Ajwu.a(5, paramBoolean);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {}
    while (!paramBoolean1) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new ChatHistoryTroopFileFragment.9(this, paramInt1));
    if (paramBoolean2)
    {
      ThreadManagerV2.getUIHandlerV2().postDelayed(new ChatHistoryTroopFileFragment.10(this), 1000L);
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new ChatHistoryTroopFileFragment.11(this), 1000L);
  }
  
  protected void b() {}
  
  void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean) {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BA", "0X800A0BA", 3, 0, "", "", "", "");
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
  
  protected void d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    localArrayList.add(Integer.valueOf(5));
    this.jdField_a_of_type_Ajwu.a(localArrayList);
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
    if (this.jdField_a_of_type_Bgjg == null)
    {
      ajtw localajtw = new ajtw(this, this.jdField_b_of_type_Long);
      this.jdField_a_of_type_Bgjg = new bgjg(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localajtw, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    bgjc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bgjg);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 4, 0, "", "", "", "");
    this.jdField_a_of_type_Ajra.a(this.jdField_d_of_type_Boolean);
    a();
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_Bgjg != null)
    {
      bgjc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bgjg);
      this.jdField_a_of_type_Bgjg = null;
    }
    c(false);
  }
  
  public void g()
  {
    super.g();
    QLog.i("ChatHistoryTroopFileFragment<QFile>", 1, "doOnDestroy");
    if ((this.jdField_a_of_type_Bgjh == null) || (this.jdField_a_of_type_Bgjg != null))
    {
      bgjc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bgjg);
      this.jdField_a_of_type_Bgjg = null;
    }
    this.jdField_a_of_type_Bfmt.b();
    this.jdField_a_of_type_Bfms.b();
    bfmp.a().a();
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_Aubw != null)
    {
      List localList = this.jdField_a_of_type_Bfms.a();
      this.jdField_a_of_type_Aubw.a(localList, 1, null);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BC", "0X800A0BC", 3, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Bfms.a(false);
    h();
  }
  
  protected void l()
  {
    if (this.jdField_a_of_type_Aubw != null)
    {
      List localList = this.jdField_a_of_type_Bfms.a();
      this.jdField_a_of_type_Aubw.a(localList, 4, null);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BD", "0X800A0BD", 3, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Bfms.a(false);
    h();
  }
  
  protected void m()
  {
    if (this.jdField_a_of_type_Aubw != null)
    {
      List localList = this.jdField_a_of_type_Bfms.a();
      this.jdField_a_of_type_Aubw.a(localList, 2, null);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BB", "0X800A0BB", 3, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Bfms.a(false);
    h();
  }
  
  protected void n()
  {
    super.n();
    Object localObject = this.jdField_a_of_type_Bfms.a();
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return;
    }
    localObject = (bkzi)bkzz.a(getActivity(), null);
    ((bkzi)localObject).a(2131695830);
    ((bkzi)localObject).a(getActivity().getString(2131692213), 3);
    ((bkzi)localObject).c(2131690697);
    ((bkzi)localObject).a(new ajts(this, (bkzi)localObject));
    ((bkzi)localObject).show();
  }
  
  protected void o()
  {
    if (this.jdField_a_of_type_Aubw != null)
    {
      List localList = this.jdField_a_of_type_Bfms.a();
      this.jdField_a_of_type_Aubw.a(localList, 5, null);
    }
    this.jdField_a_of_type_Bfms.a(false);
    h();
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
        this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560826, paramViewGroup, false);
        this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370232));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout = new QFileListPullMoreLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setBackgroundResource(2130838911);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextColor(getResources().getColor(2131167026));
        this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131560851, null);
        this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_d_of_type_AndroidViewView);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.e = this.jdField_b_of_type_AndroidViewView.findViewById(2131372042);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368524));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378672));
        this.jdField_a_of_type_Bfms = new bfms(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_Long, "/", 13);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bfms);
        this.jdField_a_of_type_Bfms.a(this);
        this.jdField_a_of_type_Bfms.a(this);
        this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_Bfms);
        this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131366772).findViewById(2131374100);
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Aufo);
        this.f = this.jdField_b_of_type_AndroidViewView.findViewById(2131379381);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131379380).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131379382).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        r();
      }
      paramLayoutInflater = (ViewGroup)this.jdField_b_of_type_AndroidViewView.getParent();
      if (paramLayoutInflater != null) {
        paramLayoutInflater.removeView(this.jdField_b_of_type_AndroidViewView);
      }
      g(5);
      if (this.jdField_a_of_type_Bfmt == null)
      {
        this.jdField_a_of_type_Bfmt = new bfmt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(this.jdField_b_of_type_Long), this.jdField_b_of_type_AndroidOsHandler);
        this.jdField_a_of_type_Bfmt.a();
      }
      this.jdField_a_of_type_Bfmt.a(false);
      q();
      paramLayoutInflater = this.jdField_b_of_type_AndroidViewView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment
 * JD-Core Version:    0.7.0.1
 */