package com.tencent.av.wtogether.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import com.tencent.av.wtogether.callback.C2CFileClickListener;
import com.tencent.av.wtogether.callback.GroupClickListener;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.av.wtogether.util.WTBusinessForWebPlugin;
import com.tencent.av.wtogether.view.QBaseContentView;
import com.tencent.av.wtogether.view.QGroupListContentView;
import com.tencent.av.wtogether.view.QRecentC2CAVFileListContentView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class AVRecentFileSelectFragment
  extends PublicBaseFragment
  implements View.OnClickListener, C2CFileClickListener, GroupClickListener
{
  private int jdField_a_of_type_Int = 0;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new AVRecentFileSelectFragment.3(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ChooseFileInfo jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = new ChooseFileInfo(0);
  private QBaseContentView jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
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
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return null;
      }
      localObject = new QGroupListContentView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this);
      ((QBaseContentView)localObject).a();
      return localObject;
    }
    Object localObject = new QRecentC2CAVFileListContentView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this);
    ((QBaseContentView)localObject).a();
    return localObject;
  }
  
  private void a(int paramInt)
  {
    Object localObject = b(paramInt);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("show view with invalid type(");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(")");
      QLog.e("AVRecentFileSelectFragment", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView != localObject)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      QBaseContentView localQBaseContentView = this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView;
      if (localQBaseContentView != null)
      {
        localQBaseContentView.d();
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView);
      }
      this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView = ((QBaseContentView)localObject);
      this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView.c();
      a(this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView.a());
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentAvWtogetherViewQBaseContentView);
    }
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    paramString = a(paramInt1, paramInt2, paramString);
    paramString.putExtra("public_fragment_window_feature", 1);
    PublicFragmentActivity.Launcher.a(paramActivity, paramString, PublicFragmentActivity.class, AVRecentFileSelectFragment.class, paramInt3);
  }
  
  private void a(ListView paramListView)
  {
    Object localObject = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    ((RelativeLayout)localObject).addView(new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity), new RelativeLayout.LayoutParams(-1, AIOUtils.b(50.0F, getResources())));
    paramListView.addFooterView((View)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (localObject != null)
    {
      ((QQBlurView)localObject).c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380356));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(paramListView);
    paramListView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    paramListView.b(paramListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c(-1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
    paramListView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = true;
    } else {
      bool = false;
    }
    paramListView.setEnableBlur(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDisableBlurDrawableRes(2130850581);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
  }
  
  private QBaseContentView b(int paramInt)
  {
    QBaseContentView localQBaseContentView = (QBaseContentView)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localQBaseContentView != null) {
      return localQBaseContentView;
    }
    localQBaseContentView = a(paramInt);
    if (localQBaseContentView != null)
    {
      localQBaseContentView.setFocusable(false);
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localQBaseContentView);
    }
    return localQBaseContentView;
  }
  
  private void b()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ContactSearchActivity.class);
    localIntent.putExtra("fromType", 2);
    localIntent.putExtra("contactSearchSource", 197437);
    localIntent.putExtra("ContactCombineType", 2);
    localIntent.putExtra("key_from_type", this.jdField_a_of_type_Int);
    localIntent.putExtra("watch_together_uinType", this.jdField_b_of_type_Int);
    localIntent.putExtra("watch_together_uin", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 2020);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131376173));
    this.jdField_b_of_type_AndroidWidgetRadioButton = ((RadioButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131367849));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377141));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378305));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378304));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370123));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131381023));
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
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if (localBaseActivity != null)
    {
      localBaseActivity.superFinish();
      QLog.d("AVRecentFileSelectFragment", 2, "finish");
    }
  }
  
  public void a(ChooseFileInfo paramChooseFileInfo)
  {
    paramChooseFileInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    if (!AppNetConnInfo.isWifiConn())
    {
      PopupDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, null, getString(2131695982), 2131690728, 2131691606, new AVRecentFileSelectFragment.1(this, paramChooseFileInfo), new AVRecentFileSelectFragment.2(this));
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enter video[");
    ((StringBuilder)localObject).append(paramChooseFileInfo);
    ((StringBuilder)localObject).append("]");
    QLog.d("AVRecentFileSelectFragment", 1, ((StringBuilder)localObject).toString());
    localObject = new Intent();
    ((Intent)localObject).putExtra("watch_together_uinType", this.jdField_b_of_type_Int);
    ((Intent)localObject).putExtra("watch_together_uin", this.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("ChooseFileInfo", paramChooseFileInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1, (Intent)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.superFinish();
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity != null)
    {
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_a_of_type_Long = AVUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject = this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo;
      ((ChooseFileInfo)localObject).jdField_b_of_type_Long = 0L;
      ((ChooseFileInfo)localObject).jdField_c_of_type_Int = 3;
      ((ChooseFileInfo)localObject).jdField_a_of_type_JavaLangString = "/";
      ((ChooseFileInfo)localObject).jdField_b_of_type_JavaLangString = paramFileManagerEntity.Uuid;
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_c_of_type_JavaLangString = paramFileManagerEntity.strFileMd5;
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_c_of_type_Long = AVUtil.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_d_of_type_Long = paramFileManagerEntity.fileSize;
      this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_d_of_type_JavaLangString = paramFileManagerEntity.fileName;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetButton;
    boolean bool;
    if (paramFileManagerEntity != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((Button)localObject).setEnabled(bool);
  }
  
  public void a(String paramString1, String paramString2)
  {
    AVGroupFileSelectFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AVUtil.a(paramString1), paramString2, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, 2020);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 2020) && (paramIntent != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1, paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.superFinish();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131381023: 
      a(this.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo);
      ReportController.b(null, "dc00898", "", "", "0X800B627", "0X800B627", 0, 0, "", "", "", "");
      return;
    case 2131378304: 
      b();
      return;
    case 2131377141: 
      a();
      return;
    case 2131376173: 
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      a(1);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    a(2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getBaseActivity();
    WTBusinessForWebPlugin.a.push(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("tencent.av.v2q.StopVideoChat"));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    if (paramBundle == null)
    {
      QLog.e("AVRecentFileSelectFragment", 1, "intent is null");
      a();
      return;
    }
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("key_from_type", 0);
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("watch_together_uinType", -1);
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("watch_together_uin");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface());
    int i = this.jdField_a_of_type_Int;
    if (i != 0) {
      ReportController.b(null, "dc00898", "", "", "0X800B622", "0X800B622", i, 0, "", "", "", "");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559789, null);
    c();
    d();
    e();
    return this.jdField_a_of_type_AndroidViewView;
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
    WTBusinessForWebPlugin.a.pop();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.fragment.AVRecentFileSelectFragment
 * JD-Core Version:    0.7.0.1
 */