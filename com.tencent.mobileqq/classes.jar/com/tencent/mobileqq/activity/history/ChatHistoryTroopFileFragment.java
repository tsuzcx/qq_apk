package com.tencent.mobileqq.activity.history;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
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
import com.tencent.biz.troop.file.protocol.ITroopFileInfoUpdate;
import com.tencent.mobileqq.activity.history.widget.ChatHistorySelectBottomBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.multioperate.TroopFileMultiOperate;
import com.tencent.mobileqq.filemanager.widget.CustomFastOnClickListener;
import com.tencent.mobileqq.filemanager.widget.QFileListPullMoreLayout;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.filemanager.data.ITroopFileViewBinder;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileItem.OnItemSelectedListener;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchManager;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileShowAdapter;
import com.tencent.mobileqq.troop.filemanager.data.TroopMemberListRefresher;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorObserver;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryTroopFileFragment
  extends ChatHistoryBaseFragment
  implements ITroopFileInfoUpdate, ITroopFileViewBinder, TroopFileItem.OnItemSelectedListener
{
  private View A;
  private View B;
  private ImageView C;
  private TextView D;
  private TroopFileShowAdapter E;
  private PullRefreshHeader F;
  private OverScrollViewListener G;
  private TroopFileError.TroopFileErrorObserver H;
  private TroopMemberListRefresher I;
  private TroopFileManager J;
  private TroopFileMultiOperate K;
  private int L = -1;
  private long M = -1L;
  private long N = -1L;
  private LinearLayout O;
  private TextView P;
  private View Q;
  private boolean R = false;
  private Handler S = new ChatHistoryTroopFileFragment.3(this);
  private CustomFastOnClickListener T = new ChatHistoryTroopFileFragment.4(this);
  private View.OnClickListener U = new ChatHistoryTroopFileFragment.5(this);
  public long s = 0L;
  protected ChatHistoryTroopFileFragment.FileFileCountObserver t = new ChatHistoryTroopFileFragment.FileFileCountObserver(this, this);
  protected ChatHistoryTroopFileFragment.FileFileSpaceObserver u = new ChatHistoryTroopFileFragment.FileFileSpaceObserver(this, this);
  private long v;
  private View w;
  private XListView x;
  private View y;
  private QFileListPullMoreLayout z;
  
  private void c(boolean paramBoolean)
  {
    this.E.a(paramBoolean);
    if (paramBoolean)
    {
      int i = this.h.d();
      this.A.setPadding(0, i, 0, 0);
      this.A.setVisibility(0);
      return;
    }
    this.A.setPadding(0, 0, 0, 0);
    this.A.setVisibility(8);
  }
  
  private void e(int paramInt)
  {
    if (this.F != null)
    {
      ThreadManager.getUIHandler().postDelayed(new ChatHistoryTroopFileFragment.2(this), 800L);
      if (paramInt == 4)
      {
        this.s = System.currentTimeMillis();
        this.F.a(0);
      }
      if (paramInt == 3) {
        this.F.a(1);
      }
    }
  }
  
  private void f(int paramInt)
  {
    if (this.x.getFirstVisiblePosition() == 0)
    {
      this.z.setVisibility(8);
      return;
    }
    if ((paramInt != 5) && (paramInt != 6) && (paramInt != 7))
    {
      if (paramInt == 8) {
        this.z.setVisibility(8);
      }
    }
    else
    {
      this.z.setVisibility(0);
      this.z.setText(2131916801);
      this.z.setTextLeftDrawable(2130839585);
    }
  }
  
  private void g(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      break;
    case 6: 
      this.x.setVisibility(8);
      this.B.setVisibility(0);
      this.D.setText(2131895151);
      this.R = false;
      break;
    case 4: 
      this.x.setVisibility(0);
      this.B.setVisibility(8);
      this.R = true;
      break;
    case 3: 
      this.x.setVisibility(8);
      this.D.setText(HardCodeUtil.a(2131899853));
      this.B.setVisibility(0);
      this.R = false;
      break;
    case 2: 
      this.x.setVisibility(0);
      this.B.setVisibility(0);
      this.D.setText(2131917692);
      this.R = false;
      break;
    case 1: 
      this.x.setVisibility(0);
      this.B.setVisibility(0);
      this.D.setText(2131895328);
      this.R = false;
      break;
    case 0: 
    case 5: 
      this.x.setVisibility(8);
      this.B.setVisibility(0);
      this.D.setText(2131895326);
      this.R = false;
    }
    this.g.a(this, this.R);
  }
  
  private void w()
  {
    if (this.v != 0L)
    {
      this.J = TroopFileManager.a(this.a, this.v);
      if (!NetworkUtil.isNetworkAvailable(getBaseActivity())) {
        TroopFileUtils.b(this.a, this.v);
      }
      this.E.a(0, 0);
      int i = this.J.b();
      if (this.K == null) {
        this.K = new TroopFileMultiOperate(this.a, this.d, this.v);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initFileListData : uin[");
      localStringBuilder.append(this.v);
      localStringBuilder.append("] fileSum[");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      QLog.d("ChatHistoryTroopFileFragment<QFile>", 4, localStringBuilder.toString());
      return;
    }
    QLog.e("ChatHistoryTroopFileFragment<QFile>", 2, "troop uin is not legal.");
  }
  
  private void x()
  {
    this.F = ((PullRefreshHeader)LayoutInflater.from(getBaseActivity()).inflate(2131625671, this.x, false));
    this.G = new ChatHistoryTroopFileFragment.1(this);
    this.x.setOverScrollHeader(this.F);
    this.x.setOverscrollHeader(getResources().getDrawable(2130839580));
    this.x.setOverScrollListener(this.G);
  }
  
  private void y()
  {
    if ((this.L != -1) && (this.M != -1L) && (this.N != -1L))
    {
      if (this.O == null)
      {
        this.O = ((LinearLayout)this.w.findViewById(2131447949));
        this.P = ((TextView)this.w.findViewById(2131447950));
      }
      this.O.setVisibility(0);
      long l1 = this.N;
      long l2 = this.M;
      if (l1 >= l2)
      {
        localObject = FileUtils.getFileSize(l2);
        localObject = String.format(getString(2131896208), new Object[] { Integer.valueOf(this.L), localObject });
        int i = ((String)localObject).indexOf(getString(2131896209));
        localObject = new SpannableString((CharSequence)localObject);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#FF596A")), i, i + 4, 33);
        this.P.setText((CharSequence)localObject);
        return;
      }
      localObject = FileUtils.getFileSize(l1);
      String str = FileUtils.getFileSize(this.M);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.format(getString(2131896210), new Object[] { Integer.valueOf(this.L), localObject, str }));
      this.P.setText(localStringBuilder.toString());
      return;
    }
    Object localObject = this.O;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(8);
    }
  }
  
  public int a()
  {
    XListView localXListView = this.x;
    if (localXListView != null) {
      return localXListView.getFirstVisiblePosition();
    }
    return 0;
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt)
  {
    if (getBaseActivity() != null)
    {
      if (getBaseActivity().isFinishing()) {
        return;
      }
      if (paramBoolean) {
        ThreadManagerV2.getUIHandlerV2().post(new ChatHistoryTroopFileFragment.8(this, paramLong1, paramLong2));
      }
    }
  }
  
  public void a(boolean paramBoolean, TroopFileInfo paramTroopFileInfo)
  {
    paramTroopFileInfo = this.E.b().iterator();
    while (paramTroopFileInfo.hasNext()) {
      if (((TroopFileInfo)paramTroopFileInfo.next()).e > 104857600L)
      {
        paramBoolean = false;
        break label48;
      }
    }
    paramBoolean = true;
    label48:
    this.h.a(5, paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    if (getBaseActivity() != null)
    {
      if (getBaseActivity().isFinishing()) {
        return;
      }
      if (paramBoolean1)
      {
        ThreadManagerV2.getUIHandlerV2().post(new ChatHistoryTroopFileFragment.9(this, paramInt1));
        if (paramBoolean2)
        {
          ThreadManagerV2.getUIHandlerV2().postDelayed(new ChatHistoryTroopFileFragment.10(this), 1000L);
          return;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new ChatHistoryTroopFileFragment.11(this), 1000L);
      }
    }
  }
  
  public int b()
  {
    XListView localXListView = this.x;
    if (localXListView != null) {
      return localXListView.getLastVisiblePosition();
    }
    return 0;
  }
  
  void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean) {
      ReportController.b(this.a, "dc00898", "", "", "0X800A0BA", "0X800A0BA", 3, 0, "", "", "", "");
    }
    c(paramBoolean);
  }
  
  protected void c() {}
  
  public void c(int paramInt)
  {
    g(paramInt);
    v();
  }
  
  protected void d() {}
  
  public void d(int paramInt)
  {
    e(paramInt);
    f(paramInt);
  }
  
  protected void h()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    localArrayList.add(Integer.valueOf(5));
    this.h.a(localArrayList);
  }
  
  public void i()
  {
    super.i();
    if (this.H == null)
    {
      ChatHistoryTroopFileFragment.TroopFileErrorFilter localTroopFileErrorFilter = new ChatHistoryTroopFileFragment.TroopFileErrorFilter(this, this.v);
      this.H = new TroopFileError.TroopFileErrorObserver(this.d, localTroopFileErrorFilter, this.a);
    }
    TroopFileError.a(this.a, this.H);
    ReportController.b(this.a, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 4, 0, "", "", "", "");
    this.g.a(this, this.R);
    v();
  }
  
  public void j()
  {
    super.j();
    if (this.H != null)
    {
      TroopFileError.b(this.a, this.H);
      this.H = null;
    }
    c(false);
  }
  
  public void k()
  {
    super.k();
    QLog.i("ChatHistoryTroopFileFragment<QFile>", 1, "doOnDestroy");
    TroopFileManager localTroopFileManager = this.J;
    if (this.H != null)
    {
      TroopFileError.b(this.a, this.H);
      this.H = null;
    }
    this.I.b();
    this.E.c();
    TroopFileSearchManager.a().b();
  }
  
  protected int l()
  {
    return 1602;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(g()))
    {
      QLog.i("ChatHistoryTroopFileFragment<QFile>", 1, "get uin is empty.");
      this.v = 0L;
    }
    else
    {
      this.v = Long.valueOf(g()).longValue();
    }
    if (this.w == null)
    {
      this.w = paramLayoutInflater.inflate(2131627049, paramViewGroup, false);
      this.x = ((XListView)this.w.findViewById(2131437330));
      this.z = new QFileListPullMoreLayout(this.d);
      this.z.setBackgroundResource(2130838958);
      this.z.setTextColor(getResources().getColor(2131167993));
      this.x.addFooterView(this.z);
      this.z.setVisibility(8);
      this.A = View.inflate(this.d, 2131627076, null);
      this.x.addFooterView(this.A);
      this.A.setVisibility(8);
      this.B = this.w.findViewById(2131439376);
      this.C = ((ImageView)this.w.findViewById(2131435388));
      this.D = ((TextView)this.w.findViewById(2131447089));
      this.E = new TroopFileShowAdapter(this.a, this.d, this.v, "/", 13);
      this.x.setAdapter(this.E);
      this.E.a(this);
      this.E.a(this);
      this.x.setOnScrollListener(this.E);
      this.y = this.w.findViewById(2131433134).findViewById(2131441950);
      this.y.setOnClickListener(this.T);
      this.Q = this.w.findViewById(2131447869);
      this.w.findViewById(2131447868).setOnClickListener(this.U);
      this.w.findViewById(2131447870).setOnClickListener(this.U);
      x();
    }
    paramLayoutInflater = (ViewGroup)this.w.getParent();
    if (paramLayoutInflater != null) {
      paramLayoutInflater.removeView(this.w);
    }
    g(5);
    if (this.I == null)
    {
      this.I = new TroopMemberListRefresher(this.a, this.d, String.valueOf(this.v), this.S);
      this.I.a();
    }
    this.I.a(false);
    w();
    paramLayoutInflater = this.w;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  protected void p()
  {
    if (this.K != null)
    {
      List localList = this.E.b();
      this.K.a(localList, 1, null);
      ReportController.b(this.a, "dc00898", "", "", "0X800A0BC", "0X800A0BC", 3, 0, "", "", "", "");
    }
    this.E.a(false);
    m();
  }
  
  protected void q()
  {
    if (this.K != null)
    {
      List localList = this.E.b();
      this.K.a(localList, 4, null);
      ReportController.b(this.a, "dc00898", "", "", "0X800A0BD", "0X800A0BD", 3, 0, "", "", "", "");
    }
    this.E.a(false);
    m();
  }
  
  protected void r()
  {
    if (this.K != null)
    {
      List localList = this.E.b();
      this.K.a(localList, 2, null);
      ReportController.b(this.a, "dc00898", "", "", "0X800A0BB", "0X800A0BB", 3, 0, "", "", "", "");
    }
    this.E.a(false);
    m();
  }
  
  protected void s()
  {
    super.s();
    Object localObject = this.E.b();
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return;
      }
      localObject = (ActionSheet)ActionSheetHelper.b(getBaseActivity(), null);
      ((ActionSheet)localObject).setMainTitle(2131893858);
      ((ActionSheet)localObject).addButton(getBaseActivity().getString(2131889261), 3);
      ((ActionSheet)localObject).addCancelButton(2131887648);
      ((ActionSheet)localObject).setOnButtonClickListener(new ChatHistoryTroopFileFragment.6(this, (ActionSheet)localObject));
      ((ActionSheet)localObject).show();
    }
  }
  
  protected void t()
  {
    if (this.K != null)
    {
      List localList = this.E.b();
      this.K.a(localList, 5, null);
    }
    this.E.a(false);
    m();
  }
  
  public void v()
  {
    ThreadManagerV2.getUIHandlerV2().post(new ChatHistoryTroopFileFragment.7(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment
 * JD-Core Version:    0.7.0.1
 */