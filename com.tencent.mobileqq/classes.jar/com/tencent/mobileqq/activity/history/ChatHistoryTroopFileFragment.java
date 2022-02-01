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
  private int jdField_a_of_type_Int = -1;
  public long a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ChatHistoryTroopFileFragment.5(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected ChatHistoryTroopFileFragment.FileFileCountObserver a;
  protected ChatHistoryTroopFileFragment.FileFileSpaceObserver a;
  private TroopFileMultiOperate jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateTroopFileMultiOperate;
  private CustomFastOnClickListener jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetCustomFastOnClickListener = new ChatHistoryTroopFileFragment.4(this);
  private QFileListPullMoreLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout;
  private TroopFileShowAdapter jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileShowAdapter;
  private TroopMemberListRefresher jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopMemberListRefresher;
  private TroopFileError.TroopFileErrorObserver jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver;
  private TroopFileManager jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private long jdField_b_of_type_Long;
  private Handler jdField_b_of_type_AndroidOsHandler = new ChatHistoryTroopFileFragment.3(this);
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private long jdField_c_of_type_Long = -1L;
  private View jdField_c_of_type_AndroidViewView;
  private long jdField_d_of_type_Long = -1L;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean = false;
  private View e;
  private View f;
  
  public ChatHistoryTroopFileFragment()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopFileFragment$FileFileCountObserver = new ChatHistoryTroopFileFragment.FileFileCountObserver(this, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopFileFragment$FileFileSpaceObserver = new ChatHistoryTroopFileFragment.FileFileSpaceObserver(this, this);
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileShowAdapter.a(paramBoolean);
    if (paramBoolean)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar.a();
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
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
      return;
    }
    if ((paramInt != 5) && (paramInt != 6) && (paramInt != 7))
    {
      if (paramInt == 8) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setText(2131719249);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextLeftDrawable(2130839401);
    }
  }
  
  private void g(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      break;
    case 6: 
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697378);
      this.jdField_d_of_type_Boolean = false;
      break;
    case 4: 
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.e.setVisibility(8);
      this.jdField_d_of_type_Boolean = true;
      break;
    case 3: 
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701836));
      this.e.setVisibility(0);
      this.jdField_d_of_type_Boolean = false;
      break;
    case 2: 
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131720070);
      this.jdField_d_of_type_Boolean = false;
      break;
    case 1: 
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697555);
      this.jdField_d_of_type_Boolean = false;
      break;
    case 0: 
    case 5: 
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.e.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697553);
      this.jdField_d_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController.a(this.jdField_d_of_type_Boolean);
  }
  
  private void q()
  {
    if (this.jdField_b_of_type_Long != 0L)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager = TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      if (!NetworkUtil.isNetworkAvailable(getBaseActivity())) {
        TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileShowAdapter.a(0, 0);
      int i = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.a();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateTroopFileMultiOperate == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateTroopFileMultiOperate = new TroopFileMultiOperate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_Long);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initFileListData : uin[");
      localStringBuilder.append(this.jdField_b_of_type_Long);
      localStringBuilder.append("] fileSum[");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      QLog.d("ChatHistoryTroopFileFragment<QFile>", 4, localStringBuilder.toString());
      return;
    }
    QLog.e("ChatHistoryTroopFileFragment<QFile>", 2, "troop uin is not legal.");
  }
  
  private void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(getBaseActivity()).inflate(2131559642, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new ChatHistoryTroopFileFragment.1(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(getResources().getDrawable(2130839396));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_Int != -1) && (this.jdField_c_of_type_Long != -1L) && (this.jdField_d_of_type_Long != -1L))
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131379212));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379213));
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      long l1 = this.jdField_d_of_type_Long;
      long l2 = this.jdField_c_of_type_Long;
      if (l1 >= l2)
      {
        localObject = FileUtils.getFileSize(l2);
        localObject = String.format(getString(2131698307), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), localObject });
        int i = ((String)localObject).indexOf(getString(2131698308));
        localObject = new SpannableString((CharSequence)localObject);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#FF596A")), i, i + 4, 33);
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        return;
      }
      localObject = FileUtils.getFileSize(l1);
      String str = FileUtils.getFileSize(this.jdField_c_of_type_Long);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.format(getString(2131698309), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), localObject, str }));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(8);
    }
  }
  
  public void a()
  {
    ThreadManagerV2.getUIHandlerV2().post(new ChatHistoryTroopFileFragment.7(this));
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
    paramTroopFileInfo = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileShowAdapter.a().iterator();
    while (paramTroopFileInfo.hasNext()) {
      if (((TroopFileInfo)paramTroopFileInfo.next()).jdField_a_of_type_Long > 104857600L)
      {
        paramBoolean = false;
        break label48;
      }
    }
    paramBoolean = true;
    label48:
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar.a(5, paramBoolean);
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
  
  protected void b() {}
  
  void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BA", "0X800A0BA", 3, 0, "", "", "", "");
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
    XListView localXListView = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (localXListView != null) {
      return localXListView.getFirstVisiblePosition();
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
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar.a(localArrayList);
  }
  
  public void d(int paramInt)
  {
    e(paramInt);
    f(paramInt);
  }
  
  public int e()
  {
    XListView localXListView = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (localXListView != null) {
      return localXListView.getLastVisiblePosition();
    }
    return 0;
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver == null)
    {
      ChatHistoryTroopFileFragment.TroopFileErrorFilter localTroopFileErrorFilter = new ChatHistoryTroopFileFragment.TroopFileErrorFilter(this, this.jdField_b_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = new TroopFileError.TroopFileErrorObserver(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTroopFileErrorFilter, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    TroopFileError.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 4, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController.a(this.jdField_d_of_type_Boolean);
    a();
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null)
    {
      TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = null;
    }
    c(false);
  }
  
  public void g()
  {
    super.g();
    QLog.i("ChatHistoryTroopFileFragment<QFile>", 1, "doOnDestroy");
    TroopFileManager localTroopFileManager = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null)
    {
      TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopMemberListRefresher.b();
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileShowAdapter.b();
    TroopFileSearchManager.a().a();
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateTroopFileMultiOperate != null)
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileShowAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateTroopFileMultiOperate.a(localList, 1, null);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BC", "0X800A0BC", 3, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileShowAdapter.a(false);
    h();
  }
  
  protected void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateTroopFileMultiOperate != null)
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileShowAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateTroopFileMultiOperate.a(localList, 4, null);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BD", "0X800A0BD", 3, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileShowAdapter.a(false);
    h();
  }
  
  protected void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateTroopFileMultiOperate != null)
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileShowAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateTroopFileMultiOperate.a(localList, 2, null);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0BB", "0X800A0BB", 3, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileShowAdapter.a(false);
    h();
  }
  
  protected void n()
  {
    super.n();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileShowAdapter.a();
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return;
      }
      localObject = (ActionSheet)ActionSheetHelper.a(getBaseActivity(), null);
      ((ActionSheet)localObject).setMainTitle(2131696093);
      ((ActionSheet)localObject).addButton(getBaseActivity().getString(2131692273), 3);
      ((ActionSheet)localObject).addCancelButton(2131690728);
      ((ActionSheet)localObject).setOnButtonClickListener(new ChatHistoryTroopFileFragment.6(this, (ActionSheet)localObject));
      ((ActionSheet)localObject).show();
    }
  }
  
  protected void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateTroopFileMultiOperate != null)
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileShowAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultioperateTroopFileMultiOperate.a(localList, 5, null);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileShowAdapter.a(false);
    h();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(a()))
    {
      QLog.i("ChatHistoryTroopFileFragment<QFile>", 1, "get uin is empty.");
      this.jdField_b_of_type_Long = 0L;
    }
    else
    {
      this.jdField_b_of_type_Long = Long.valueOf(a()).longValue();
    }
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560791, paramViewGroup, false);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370164));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout = new QFileListPullMoreLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setBackgroundResource(2130838739);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setTextColor(getResources().getColor(2131167056));
      this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQFileListPullMoreLayout.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131560818, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_d_of_type_AndroidViewView);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.e = this.jdField_b_of_type_AndroidViewView.findViewById(2131371931);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368486));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378475));
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileShowAdapter = new TroopFileShowAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_b_of_type_Long, "/", 13);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileShowAdapter);
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileShowAdapter.a(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileShowAdapter.a(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileShowAdapter);
      this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131366812).findViewById(2131373966);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetCustomFastOnClickListener);
      this.f = this.jdField_b_of_type_AndroidViewView.findViewById(2131379133);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131379132).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131379134).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      r();
    }
    paramLayoutInflater = (ViewGroup)this.jdField_b_of_type_AndroidViewView.getParent();
    if (paramLayoutInflater != null) {
      paramLayoutInflater.removeView(this.jdField_b_of_type_AndroidViewView);
    }
    g(5);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopMemberListRefresher == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopMemberListRefresher = new TroopMemberListRefresher(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, String.valueOf(this.jdField_b_of_type_Long), this.jdField_b_of_type_AndroidOsHandler);
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopMemberListRefresher.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopMemberListRefresher.a(false);
    q();
    paramLayoutInflater = this.jdField_b_of_type_AndroidViewView;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment
 * JD-Core Version:    0.7.0.1
 */