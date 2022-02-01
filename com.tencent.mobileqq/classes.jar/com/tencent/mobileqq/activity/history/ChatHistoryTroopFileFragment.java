package com.tencent.mobileqq.activity.history;

import aavf;
import aavi;
import akal;
import akcz;
import akda;
import akdb;
import akdc;
import akdd;
import akdf;
import akdg;
import akdh;
import akgf;
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
import anzj;
import aulf;
import auoz;
import bdll;
import bfrs;
import bfvt;
import bfvz;
import bfwb;
import bfwe;
import bfwf;
import bgri;
import bgrm;
import bgrn;
import bgsk;
import bhmi;
import bhnv;
import blir;
import blji;
import blnt;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.widget.QFileListPullMoreLayout;
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
  implements bfvt, bfvz
{
  private int jdField_a_of_type_Int = -1;
  public long a;
  protected aavf a;
  protected aavi a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new akdc(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aulf jdField_a_of_type_Aulf;
  private auoz jdField_a_of_type_Auoz = new akdb(this);
  private bfwe jdField_a_of_type_Bfwe;
  private bfwf jdField_a_of_type_Bfwf;
  private bgrm jdField_a_of_type_Bgrm;
  private bgrn jdField_a_of_type_Bgrn;
  private blnt jdField_a_of_type_Blnt;
  private QFileListPullMoreLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private long jdField_b_of_type_Long;
  private Handler jdField_b_of_type_AndroidOsHandler = new akda(this);
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
    this.jdField_a_of_type_Aavf = new akdf(this);
    this.jdField_a_of_type_Aavi = new akdg(this);
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bfwe.a(paramBoolean);
    if (paramBoolean)
    {
      int i = this.jdField_a_of_type_Akgf.a();
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
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setText(2131718364);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextLeftDrawable(2130839410);
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
      this.jdField_a_of_type_Akal.a(this.jdField_d_of_type_Boolean);
      return;
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131696878);
      this.jdField_d_of_type_Boolean = false;
      continue;
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719045);
      this.jdField_d_of_type_Boolean = false;
      continue;
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131700535));
      this.e.setVisibility(0);
      this.jdField_d_of_type_Boolean = false;
      continue;
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131696696);
      this.jdField_d_of_type_Boolean = false;
      continue;
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.e.setVisibility(8);
      this.jdField_d_of_type_Boolean = true;
      continue;
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131696880);
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  private void q()
  {
    if (this.jdField_b_of_type_Long != 0L)
    {
      this.jdField_a_of_type_Bgrn = bgrn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      if (!bhnv.g(getActivity())) {
        bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_Bfwe.a(0, 0);
      int i = this.jdField_a_of_type_Bgrn.a();
      if (this.jdField_a_of_type_Aulf == null) {
        this.jdField_a_of_type_Aulf = new aulf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_Long);
      }
      QLog.d("ChatHistoryTroopFileFragment<QFile>", 4, "initFileListData : uin[" + this.jdField_b_of_type_Long + "] fileSum[" + i + "]");
      return;
    }
    QLog.e("ChatHistoryTroopFileFragment<QFile>", 2, "troop uin is not legal.");
  }
  
  private void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(getActivity()).inflate(2131559652, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_Blnt = new akcz(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(getResources().getDrawable(2130839405));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_Blnt);
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
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131379395));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379396));
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (this.jdField_d_of_type_Long >= this.jdField_c_of_type_Long)
    {
      localObject = bhmi.a(this.jdField_c_of_type_Long);
      localObject = String.format(getString(2131697540), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), localObject });
      int i = ((String)localObject).indexOf(getString(2131697541));
      localObject = new SpannableString((CharSequence)localObject);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#FF596A")), i, i + 4, 33);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
    Object localObject = bhmi.a(this.jdField_d_of_type_Long);
    String str = bhmi.a(this.jdField_c_of_type_Long);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format(getString(2131697542), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), localObject, str }));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
  }
  
  public void a()
  {
    ThreadManagerV2.getUIHandlerV2().post(new ChatHistoryTroopFileFragment.7(this));
  }
  
  public void a(int paramInt)
  {
    g(paramInt);
    a();
  }
  
  public void a(boolean paramBoolean, bfrs parambfrs)
  {
    parambfrs = this.jdField_a_of_type_Bfwe.a().iterator();
    do
    {
      if (!parambfrs.hasNext()) {
        break;
      }
    } while (((bfrs)parambfrs.next()).jdField_a_of_type_Long <= 104857600L);
    for (paramBoolean = false;; paramBoolean = true)
    {
      this.jdField_a_of_type_Akgf.a(5, paramBoolean);
      return;
    }
  }
  
  protected void b() {}
  
  void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean) {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BA", "0X800A0BA", 3, 0, "", "", "", "");
    }
    c(paramBoolean);
  }
  
  protected int c()
  {
    return 1602;
  }
  
  protected void c() {}
  
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
    this.jdField_a_of_type_Akgf.a(localArrayList);
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
    if (this.jdField_a_of_type_Bgrm == null)
    {
      akdh localakdh = new akdh(this, this.jdField_b_of_type_Long);
      this.jdField_a_of_type_Bgrm = new bgrm(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localakdh, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    bgri.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bgrm);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 4, 0, "", "", "", "");
    this.jdField_a_of_type_Akal.a(this.jdField_d_of_type_Boolean);
    a();
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_Bgrm != null)
    {
      bgri.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bgrm);
      this.jdField_a_of_type_Bgrm = null;
    }
    c(false);
  }
  
  public void g()
  {
    super.g();
    QLog.i("ChatHistoryTroopFileFragment<QFile>", 1, "doOnDestroy");
    if ((this.jdField_a_of_type_Bgrn == null) || (this.jdField_a_of_type_Bgrm != null))
    {
      bgri.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bgrm);
      this.jdField_a_of_type_Bgrm = null;
    }
    this.jdField_a_of_type_Bfwf.b();
    this.jdField_a_of_type_Bfwe.b();
    bfwb.a().a();
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_Aulf != null)
    {
      List localList = this.jdField_a_of_type_Bfwe.a();
      this.jdField_a_of_type_Aulf.a(localList, 1, null);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BC", "0X800A0BC", 3, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Bfwe.a(false);
    h();
  }
  
  protected void l()
  {
    if (this.jdField_a_of_type_Aulf != null)
    {
      List localList = this.jdField_a_of_type_Bfwe.a();
      this.jdField_a_of_type_Aulf.a(localList, 4, null);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BD", "0X800A0BD", 3, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Bfwe.a(false);
    h();
  }
  
  protected void m()
  {
    if (this.jdField_a_of_type_Aulf != null)
    {
      List localList = this.jdField_a_of_type_Bfwe.a();
      this.jdField_a_of_type_Aulf.a(localList, 2, null);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BB", "0X800A0BB", 3, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Bfwe.a(false);
    h();
  }
  
  protected void n()
  {
    super.n();
    Object localObject = this.jdField_a_of_type_Bfwe.a();
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return;
    }
    localObject = (blir)blji.a(getActivity(), null);
    ((blir)localObject).a(2131695439);
    ((blir)localObject).a(getActivity().getString(2131692075), 3);
    ((blir)localObject).c(2131690580);
    ((blir)localObject).a(new akdd(this, (blir)localObject));
    ((blir)localObject).show();
  }
  
  protected void o()
  {
    if (this.jdField_a_of_type_Aulf != null)
    {
      List localList = this.jdField_a_of_type_Bfwe.a();
      this.jdField_a_of_type_Aulf.a(localList, 5, null);
    }
    this.jdField_a_of_type_Bfwe.a(false);
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
        this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560886, paramViewGroup, false);
        this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370063));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout = new QFileListPullMoreLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setBackgroundResource(2130838778);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextColor(getResources().getColor(2131166990));
        this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131560911, null);
        this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_d_of_type_AndroidViewView);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.e = this.jdField_b_of_type_AndroidViewView.findViewById(2131371886);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368343));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378617));
        this.jdField_a_of_type_Bfwe = new bfwe(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_Long, "/", 13);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bfwe);
        this.jdField_a_of_type_Bfwe.a(this);
        this.jdField_a_of_type_Bfwe.a(this);
        this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_Bfwe);
        this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131366633).findViewById(2131374125);
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Auoz);
        this.f = this.jdField_b_of_type_AndroidViewView.findViewById(2131379315);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131379314).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131379316).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        r();
      }
      paramLayoutInflater = (ViewGroup)this.jdField_b_of_type_AndroidViewView.getParent();
      if (paramLayoutInflater != null) {
        paramLayoutInflater.removeView(this.jdField_b_of_type_AndroidViewView);
      }
      g(5);
      if (this.jdField_a_of_type_Bfwf == null)
      {
        this.jdField_a_of_type_Bfwf = new bfwf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(this.jdField_b_of_type_Long), this.jdField_b_of_type_AndroidOsHandler);
        this.jdField_a_of_type_Bfwf.a();
      }
      this.jdField_a_of_type_Bfwf.a(false);
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