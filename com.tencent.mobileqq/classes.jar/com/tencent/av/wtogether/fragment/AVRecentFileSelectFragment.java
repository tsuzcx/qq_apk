package com.tencent.av.wtogether.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.wtogether.adapter.QGroupExpandableListAdapter.UIEvent;
import com.tencent.av.wtogether.adapter.QVideoC2CFileExpandableListAdapter.UIEvent;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.av.wtogether.view.QBaseContentView;
import com.tencent.av.wtogether.view.QGroupListContentView;
import com.tencent.av.wtogether.view.QRecentC2CAVFileListContentView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ListView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class AVRecentFileSelectFragment
  extends PublicBaseFragment
  implements View.OnClickListener, QGroupExpandableListAdapter.UIEvent, QVideoC2CFileExpandableListAdapter.UIEvent
{
  private int jdField_a_of_type_Int = 0;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ChooseFileInfo jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = new ChooseFileInfo(0);
  private QBaseContentView jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<Integer, QBaseContentView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int jdField_b_of_type_Int;
  private RadioButton jdField_b_of_type_AndroidWidgetRadioButton;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  
  private static Intent a(int paramInt1, int paramInt2, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_type", paramInt1);
    localIntent.putExtra("watch_together_uinType", paramInt2);
    localIntent.putExtra("watch_together_uin", paramString);
    return localIntent;
  }
  
  private QBaseContentView a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      localObject = new QRecentC2CAVFileListContentView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this);
      ((QBaseContentView)localObject).a();
      return localObject;
    }
    Object localObject = new QGroupListContentView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this);
    ((QBaseContentView)localObject).a();
    return localObject;
  }
  
  private void a(int paramInt)
  {
    QBaseContentView localQBaseContentView = b(paramInt);
    if (localQBaseContentView == null) {
      QLog.e("AVRecentFileSelectFragment", 1, "show view with invalid type(" + paramInt + ")");
    }
    while (this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView == localQBaseContentView) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    if (this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView != null)
    {
      this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView.d();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView);
    }
    this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView = localQBaseContentView;
    this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView.c();
    a(this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView.a());
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    paramString = a(paramInt1, paramInt2, paramString);
    paramString.putExtra("public_fragment_window_feature", 1);
    PublicFragmentActivity.Launcher.a(paramActivity, paramString, PublicFragmentActivity.class, AVRecentFileSelectFragment.class, paramInt3);
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
  
  private QBaseContentView b(int paramInt)
  {
    Object localObject = (QBaseContentView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localObject != null) {}
    QBaseContentView localQBaseContentView;
    do
    {
      return localObject;
      localQBaseContentView = a(paramInt);
      localObject = localQBaseContentView;
    } while (localQBaseContentView == null);
    localQBaseContentView.setFocusable(false);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localQBaseContentView);
    return localQBaseContentView;
  }
  
  private void b()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ContactSearchActivity.class);
    localIntent.putExtra("fromType", 2);
    localIntent.putExtra("contactSearchSource", 197437);
    localIntent.putExtra("ContactCombineType", 2);
    localIntent.putExtra("key_from_type", this.jdField_a_of_type_Int);
    localIntent.putExtra("watch_together_uinType", this.jdField_b_of_type_Int);
    localIntent.putExtra("watch_together_uin", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 2020);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131376669));
    this.jdField_b_of_type_AndroidWidgetRadioButton = ((RadioButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131368096));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377713));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378917));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378916));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370464));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131381801));
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetRadioButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRadioButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void e()
  {
    if (FontSettingManager.getFontLevel() > 17.0F)
    {
      float f = getResources().getDisplayMetrics().density;
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(55.0F * f), (int)(f * 30.0F));
      this.jdField_a_of_type_AndroidWidgetRadioButton.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetRadioButton.setTextSize(14.0F);
      this.jdField_b_of_type_AndroidWidgetRadioButton.setLayoutParams(localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetRadioButton.setTextSize(14.0F);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.superFinish();
      QLog.d("AVRecentFileSelectFragment", 2, "finish");
    }
  }
  
  public void a(ChooseFileInfo paramChooseFileInfo)
  {
    paramChooseFileInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    if (!AppNetConnInfo.isWifiConn())
    {
      PopupDialog.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, null, getString(2131695967), 2131690800, 2131691684, new AVRecentFileSelectFragment.1(this, paramChooseFileInfo), new AVRecentFileSelectFragment.2(this));
      return;
    }
    QLog.d("AVRecentFileSelectFragment", 1, "enter video[" + paramChooseFileInfo + "]");
    Intent localIntent = new Intent();
    localIntent.putExtra("watch_together_uinType", this.jdField_b_of_type_Int);
    localIntent.putExtra("watch_together_uin", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("ChooseFileInfo", paramChooseFileInfo);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.superFinish();
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity != null)
    {
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_a_of_type_Long = AVUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_b_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_c_of_type_Int = 3;
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_a_of_type_JavaLangString = "/";
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_b_of_type_JavaLangString = paramFileManagerEntity.Uuid;
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_c_of_type_JavaLangString = paramFileManagerEntity.strFileMd5;
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_c_of_type_Long = AVUtil.a(this.jdField_a_of_type_JavaLangString);
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
  
  public void a(String paramString1, String paramString2)
  {
    AVGroupFileSelectFragment.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, AVUtil.a(paramString1), paramString2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, 2020);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 2020) && (paramIntent != null))
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
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      a(1);
      continue;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      a(2);
      continue;
      a();
      continue;
      b();
      continue;
      a(this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo);
      ReportController.b(null, "dc00898", "", "", "0X800B627", "0X800B627", 0, 0, "", "", "", "");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    paramBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (paramBundle == null)
    {
      QLog.e("AVRecentFileSelectFragment", 1, "intent is null");
      a();
    }
    do
    {
      return;
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("key_from_type", 0);
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("watch_together_uinType", -1);
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("watch_together_uin");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getAppInterface());
    } while (this.jdField_a_of_type_Int == 0);
    ReportController.b(null, "dc00898", "", "", "0X800B622", "0X800B622", this.jdField_a_of_type_Int, 0, "", "", "", "");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559919, null);
    c();
    d();
    e();
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    QLog.i("AVRecentFileSelectFragment", 2, "onDestroy");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      QBaseContentView localQBaseContentView = (QBaseContentView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
      if (localQBaseContentView != null) {
        localQBaseContentView.b();
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView);
    super.onDestroy();
  }
  
  public void onPause()
  {
    QLog.i("AVRecentFileSelectFragment", 2, "onPause");
    super.onPause();
  }
  
  public void onResume()
  {
    QLog.i("AVRecentFileSelectFragment", 2, "onResume");
    super.onResume();
  }
  
  public void onStart()
  {
    QLog.i("AVRecentFileSelectFragment", 2, "onStart");
    super.onStart();
  }
  
  public void onStop()
  {
    QLog.i("AVRecentFileSelectFragment", 2, "onStop");
    super.onStop();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_AndroidWidgetRadioButton.performClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.fragment.AVRecentFileSelectFragment
 * JD-Core Version:    0.7.0.1
 */