package com.tencent.mobileqq.activity.history;

import ahwn;
import ahwo;
import ahwp;
import ahwq;
import ahwr;
import ahwt;
import ahwu;
import ahwv;
import ahzt;
import alpo;
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
import arle;
import arqb;
import azmj;
import bbre;
import bbrm;
import bbrp;
import bbrq;
import bcig;
import bcik;
import bcil;
import bcjk;
import bdcs;
import bdee;
import bhpy;
import bhql;
import bhuy;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.widget.QFileListPullMoreLayout;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;
import mqq.os.MqqHandler;
import ypk;
import ypn;

public class ChatHistoryTroopFileFragment
  extends ChatHistoryBaseFragment
  implements bbre
{
  private int jdField_a_of_type_Int = -1;
  public long a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ahwq(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private arle jdField_a_of_type_Arle;
  private arqb jdField_a_of_type_Arqb = new ahwp(this);
  private bbrp jdField_a_of_type_Bbrp;
  private bbrq jdField_a_of_type_Bbrq;
  private bcik jdField_a_of_type_Bcik;
  private bcil jdField_a_of_type_Bcil;
  private bhuy jdField_a_of_type_Bhuy;
  private QFileListPullMoreLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected ypk a;
  protected ypn a;
  private long jdField_b_of_type_Long;
  private Handler jdField_b_of_type_AndroidOsHandler = new ahwo(this);
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
    this.jdField_a_of_type_Ypk = new ahwt(this);
    this.jdField_a_of_type_Ypn = new ahwu(this);
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bbrp.a(paramBoolean);
    if (paramBoolean)
    {
      int i = this.jdField_a_of_type_Ahzt.a();
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
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setText(2131720327);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextLeftDrawable(2130839224);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697981);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131721144);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131701996));
      this.e.setVisibility(0);
      return;
    case 6: 
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697803);
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.e.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.e.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697983);
  }
  
  private void p()
  {
    if (this.jdField_b_of_type_Long != 0L)
    {
      this.jdField_a_of_type_Bcil = bcil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      if (!bdee.g(getActivity())) {
        bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_Bbrp.a(0, 0);
      int i = this.jdField_a_of_type_Bcil.a();
      if (this.jdField_a_of_type_Arle == null) {
        this.jdField_a_of_type_Arle = new arle(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_Long);
      }
      QLog.d("ChatHistoryTroopFileFragment<QFile>", 4, "initFileListData : uin[" + this.jdField_b_of_type_Long + "] fileSum[" + i + "]");
      return;
    }
    QLog.e("ChatHistoryTroopFileFragment<QFile>", 2, "troop uin is not legal.");
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(getActivity()).inflate(2131559511, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_Bhuy = new ahwn(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(getResources().getDrawable(2130839219));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_Bhuy);
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
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131378324));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378325));
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (this.jdField_d_of_type_Long >= this.jdField_c_of_type_Long)
    {
      localObject = bdcs.a(this.jdField_c_of_type_Long);
      localObject = String.format(getString(2131698531), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), localObject });
      int i = ((String)localObject).indexOf(getString(2131698532));
      localObject = new SpannableString((CharSequence)localObject);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#FF596A")), i, i + 4, 33);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
    Object localObject = bdcs.a(this.jdField_d_of_type_Long);
    String str = bdcs.a(this.jdField_c_of_type_Long);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format(getString(2131698533), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), localObject, str }));
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
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BA", "0X800A0BA", 3, 0, "", "", "", "");
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
    if (this.jdField_a_of_type_Bcik == null)
    {
      ahwv localahwv = new ahwv(this, this.jdField_b_of_type_Long);
      this.jdField_a_of_type_Bcik = new bcik(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localahwv, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    bcig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bcik);
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 4, 0, "", "", "", "");
    a();
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_Bcik != null)
    {
      bcig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bcik);
      this.jdField_a_of_type_Bcik = null;
    }
    c(false);
  }
  
  public void g()
  {
    super.g();
    QLog.i("ChatHistoryTroopFileFragment<QFile>", 1, "doOnDestroy");
    if ((this.jdField_a_of_type_Bcil == null) || (this.jdField_a_of_type_Bcik != null))
    {
      bcig.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bcik);
      this.jdField_a_of_type_Bcik = null;
    }
    this.jdField_a_of_type_Bbrq.b();
    this.jdField_a_of_type_Bbrp.b();
    bbrm.a().a();
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_Arle != null)
    {
      List localList = this.jdField_a_of_type_Bbrp.a();
      this.jdField_a_of_type_Arle.a(localList, 1, null);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BC", "0X800A0BC", 3, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Bbrp.a(false);
    h();
  }
  
  protected void l()
  {
    if (this.jdField_a_of_type_Arle != null)
    {
      List localList = this.jdField_a_of_type_Bbrp.a();
      this.jdField_a_of_type_Arle.a(localList, 4, null);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BD", "0X800A0BD", 3, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Bbrp.a(false);
    h();
  }
  
  protected void m()
  {
    if (this.jdField_a_of_type_Arle != null)
    {
      List localList = this.jdField_a_of_type_Bbrp.a();
      this.jdField_a_of_type_Arle.a(localList, 2, null);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BB", "0X800A0BB", 3, 0, "", "", "", "");
    }
    this.jdField_a_of_type_Bbrp.a(false);
    h();
  }
  
  protected void n()
  {
    super.n();
    Object localObject = this.jdField_a_of_type_Bbrp.a();
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      return;
    }
    localObject = (bhpy)bhql.a(getActivity(), null);
    ((bhpy)localObject).a(2131696568);
    ((bhpy)localObject).a(getActivity().getString(2131692485), 3);
    ((bhpy)localObject).c(2131690648);
    ((bhpy)localObject).a(new ahwr(this, (bhpy)localObject));
    ((bhpy)localObject).show();
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
        this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560637, paramViewGroup, false);
        this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369552));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout = new QFileListPullMoreLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setBackgroundResource(2130838591);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextColor(getResources().getColor(2131166901));
        this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131560660, null);
        this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_d_of_type_AndroidViewView);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.e = this.jdField_b_of_type_AndroidViewView.findViewById(2131371196);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131367933));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377566));
        this.jdField_a_of_type_Bbrp = new bbrp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_Long, "/", 13);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bbrp);
        this.jdField_a_of_type_Bbrp.a(this);
        this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_Bbrp);
        this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131366329).findViewById(2131373235);
        this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_Arqb);
        this.f = this.jdField_b_of_type_AndroidViewView.findViewById(2131378242);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131378241).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131378243).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        q();
      }
      paramLayoutInflater = (ViewGroup)this.jdField_b_of_type_AndroidViewView.getParent();
      if (paramLayoutInflater != null) {
        paramLayoutInflater.removeView(this.jdField_b_of_type_AndroidViewView);
      }
      g(5);
      if (this.jdField_a_of_type_Bbrq == null)
      {
        this.jdField_a_of_type_Bbrq = new bbrq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(this.jdField_b_of_type_Long), this.jdField_b_of_type_AndroidOsHandler);
        this.jdField_a_of_type_Bbrq.a();
      }
      this.jdField_a_of_type_Bbrq.a(false);
      p();
      return this.jdField_b_of_type_AndroidViewView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment
 * JD-Core Version:    0.7.0.1
 */