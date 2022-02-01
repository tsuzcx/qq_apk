package com.tencent.av.wtogether.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.wtogether.adapter.QVideoGroupFileExpandableListAdapter.UIEvent;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.av.wtogether.view.GroupFileSearchDialog;
import com.tencent.av.wtogether.view.GroupFileSearchDialog.ClickListener;
import com.tencent.av.wtogether.view.QBaseContentView;
import com.tencent.av.wtogether.view.QGroupAVFileListContentView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ListView;

public class AVGroupFileSelectFragment
  extends PublicBaseFragment
  implements View.OnClickListener, QVideoGroupFileExpandableListAdapter.UIEvent, GroupFileSearchDialog.ClickListener
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog = null;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ChooseFileInfo jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = new ChooseFileInfo(1);
  private QBaseContentView jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  
  private static Intent a(int paramInt1, int paramInt2, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_type", paramInt1);
    localIntent.putExtra("watch_together_uinType", paramInt2);
    localIntent.putExtra("watch_together_uin", paramString);
    return localIntent;
  }
  
  public static void a(Activity paramActivity, long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    QLog.d("AVGroupFileSelectFragment", 2, "startFragment");
    paramString2 = a(paramInt1, paramInt2, paramString2);
    paramString2.putExtra("public_fragment_window_feature", 1);
    paramString2.putExtra("key_troop_uin", paramLong);
    paramString2.putExtra("key_troop_name", paramString1);
    PublicFragmentActivity.Launcher.a(paramActivity, paramString2, PublicFragmentActivity.class, AVGroupFileSelectFragment.class, paramInt3);
  }
  
  private void a(ListView paramListView)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    localRelativeLayout.addView(new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity), new RelativeLayout.LayoutParams(-1, AIOUtils.a(50.0F, getResources())));
    paramListView.addFooterView(localRelativeLayout);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381097));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(paramListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c(-1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
    paramListView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (Build.VERSION.SDK_INT >= 24) {}
    for (boolean bool = true;; bool = false)
    {
      paramListView.setEnableBlur(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDisableBlurDrawableRes(2130850501);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
      return;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      return;
    }
    b();
    ReportController.b(null, "dc00898", "", "", "0X800B626", "0X800B626", 0, 0, "", "", "", "");
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363406));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369534));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378916));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370464));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131381801));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView = new QGroupAVFileListContentView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView.a();
    a(this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView.a());
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.superFinish();
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(2130772236, 2130772239);
      QLog.d("AVGroupFileSelectFragment", 2, "finish");
    }
  }
  
  public void a(ChooseFileInfo paramChooseFileInfo)
  {
    paramChooseFileInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    paramChooseFileInfo.jdField_a_of_type_Long = AVUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    paramChooseFileInfo.jdField_c_of_type_Long = AVUtil.a(this.jdField_b_of_type_JavaLangString);
    if (!AppNetConnInfo.isWifiConn())
    {
      PopupDialog.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, null, getString(2131695967), 2131690800, 2131691684, new AVGroupFileSelectFragment.1(this, paramChooseFileInfo), new AVGroupFileSelectFragment.2(this));
      return;
    }
    QLog.d("AVGroupFileSelectFragment", 1, "enter video " + paramChooseFileInfo);
    Intent localIntent = new Intent();
    localIntent.putExtra("watch_together_uinType", this.jdField_b_of_type_Int);
    localIntent.putExtra("watch_together_uin", this.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("ChooseFileInfo", paramChooseFileInfo);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.superFinish();
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity != null)
    {
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_b_of_type_Long = paramFileManagerEntity.TroopUin;
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_c_of_type_Int = paramFileManagerEntity.busId;
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_a_of_type_JavaLangString = "/";
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_b_of_type_JavaLangString = paramFileManagerEntity.Uuid;
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_c_of_type_JavaLangString = paramFileManagerEntity.strFileMd5;
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_d_of_type_Long = paramFileManagerEntity.fileSize;
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_d_of_type_JavaLangString = paramFileManagerEntity.fileName;
    }
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if (paramFileManagerEntity != null) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView.d();
    this.jdField_a_of_type_AndroidAppDialog = new GroupFileSearchDialog(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, this);
    this.jdField_a_of_type_AndroidAppDialog.setTitle(HardCodeUtil.a(2131715195));
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    int i = this.jdField_b_of_type_AndroidWidgetTextView.getHeight();
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
    localTranslateAnimation1.setDuration(200L);
    localTranslateAnimation1.setFillAfter(true);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
    localTranslateAnimation2.setDuration(200L);
    localTranslateAnimation1.setAnimationListener(new AVGroupFileSelectFragment.3(this));
    localTranslateAnimation2.setAnimationListener(new AVGroupFileSelectFragment.4(this, i));
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new AVGroupFileSelectFragment.5(this, i, localTranslateAnimation2));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localTranslateAnimation1);
  }
  
  public void b(ChooseFileInfo paramChooseFileInfo)
  {
    a(paramChooseFileInfo);
    ReportController.b(null, "dc00898", "", "", "0X800B629", "0X800B629", 0, 0, "", "", "", "");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 9999) && (paramIntent != null))
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1, paramIntent);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.superFinish();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a();
      continue;
      c();
      continue;
      a(this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo);
      ReportController.b(null, "dc00898", "", "", "0X800B628", "0X800B628", 0, 0, "", "", "", "");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    paramBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (paramBundle == null)
    {
      QLog.e("AVGroupFileSelectFragment", 2, "intent is null");
      a();
      return;
    }
    this.jdField_a_of_type_Long = paramBundle.getLongExtra("key_troop_uin", 0L);
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("key_troop_name");
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("key_from_type", 0);
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("watch_together_uinType", -1);
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("watch_together_uin");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getAppInterface());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559920, null);
    d();
    e();
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    QLog.i("AVGroupFileSelectFragment", 2, "onDestroy");
    this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView.b();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView);
    super.onDestroy();
  }
  
  public void onPause()
  {
    QLog.i("AVGroupFileSelectFragment", 2, "onPause");
    this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView.d();
    super.onPause();
  }
  
  public void onResume()
  {
    QLog.i("AVGroupFileSelectFragment", 2, "onResume");
    this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView.c();
    super.onResume();
  }
  
  public void onStart()
  {
    QLog.i("AVGroupFileSelectFragment", 2, "onStart");
    super.onStart();
  }
  
  public void onStop()
  {
    QLog.i("AVGroupFileSelectFragment", 2, "onStop");
    super.onStop();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.fragment.AVGroupFileSelectFragment
 * JD-Core Version:    0.7.0.1
 */