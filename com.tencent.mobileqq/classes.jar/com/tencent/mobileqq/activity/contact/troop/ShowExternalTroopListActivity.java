package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.ui.MultiLineLayout;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter.OnTroopListClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import mqq.app.AppRuntime;

public class ShowExternalTroopListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, ShowExternalTroopListAdapter.OnTroopListClickListener, OverScrollViewListener
{
  protected int a;
  Activity jdField_a_of_type_AndroidAppActivity;
  protected Handler a;
  public View.OnClickListener a;
  protected View a;
  protected Button a;
  protected RelativeLayout a;
  protected TextView a;
  protected ShowExternalTroopListAdapter a;
  protected TroopBusinessObserver a;
  protected TroopManager a;
  protected PullRefreshHeader a;
  protected RedDotTextView a;
  protected XListView a;
  String jdField_a_of_type_JavaLangString = null;
  protected boolean a;
  protected TextView b;
  String b;
  protected boolean b;
  protected TextView c;
  protected boolean c;
  
  public ShowExternalTroopListActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new ShowExternalTroopListActivity.1(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ShowExternalTroopListActivity.5(this);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new ShowExternalTroopListActivity.6(this);
  }
  
  private long a()
  {
    return getActivity().getSharedPreferences("rec_last_ext_show_troop_list_refresh_time", 0).getLong("rec_last_ext_show_troop_list_refresh_time", 0L);
  }
  
  private boolean a()
  {
    if (NetworkUtil.g(getActivity()))
    {
      ((TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.jdField_a_of_type_JavaLangString, 0, 0);
      this.jdField_b_of_type_Boolean = true;
      return true;
    }
    QQToast.a(this, 2130839732, getString(2131697610), 0).b(getResources().getDimensionPixelSize(2131299166));
    return false;
  }
  
  private void b()
  {
    setContentViewNoTitle(2131560830);
    Object localObject1 = (LinearLayout)findViewById(2131377356);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ((LinearLayout)localObject1).setFitsSystemWindows(true);
    }
    setTitle(2131696147);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369487));
    Intent localIntent = getIntent();
    this.jdField_a_of_type_Boolean = localIntent.getExtras().getBoolean("isHost");
    Object localObject2 = localIntent.getExtras().getString("leftViewText");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = getString(2131690778);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)findViewById(2131369518));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setContentDescription(getString(2131696150));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setText(2131696149);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setOnClickListener(this);
    String str;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setVisibility(8);
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131374319));
      localObject1 = LayoutInflater.from(this).inflate(2131560829, null);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131380035));
      this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131696196));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372320));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131377873));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131374202));
      this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130851193);
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131560753, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject1);
      }
      this.jdField_a_of_type_JavaLangString = localIntent.getExtras().getString("dest_uin_str");
      this.jdField_b_of_type_JavaLangString = localIntent.getExtras().getString("from_troop_uin");
      this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter = new ShowExternalTroopListAdapter(getActivity(), this.app, this, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter);
      this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131559765, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130838980);
      localObject2 = this.app;
      str = this.jdField_a_of_type_JavaLangString;
      if (!this.jdField_a_of_type_Boolean) {
        break label555;
      }
    }
    label555:
    for (localObject1 = "0";; localObject1 = "1")
    {
      ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_join", "", "person_data", "exp_grp", 0, 0, str, (String)localObject1, "" + localIntent.getIntExtra("from", 0), "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setVisibility(0);
      break;
    }
  }
  
  private void c()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368865);
    Object localObject = ImageUtil.d();
    localImageView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, 1, this.jdField_a_of_type_JavaLangString, 3, (Drawable)localObject, (Drawable)localObject));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131365294).bringToFront();
    ThreadManager.post(new ShowExternalTroopListActivity.2(this), 8, null, true);
    localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370040);
    ThreadManager.post(new ShowExternalTroopListActivity.3(this, (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372265), (TextView)localObject), 8, null, true);
    localImageView.setOnClickListener(new ShowExternalTroopListActivity.4(this, localImageView));
  }
  
  private void d()
  {
    long l = System.currentTimeMillis();
    getActivity().getSharedPreferences("rec_last_ext_show_troop_list_refresh_time", 0).edit().putLong("rec_last_ext_show_troop_list_refresh_time", l).commit();
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = null;
    int k = 0;
    if (paramBitmap == null) {
      paramBitmap = localBitmap;
    }
    label161:
    do
    {
      return paramBitmap;
      int m = getResources().getDisplayMetrics().widthPixels;
      int n = (int)(120.0F * this.mDensity);
      int i = paramBitmap.getHeight();
      int j = paramBitmap.getWidth();
      if (j * n > i * m)
      {
        n = m * i / n;
        m = (j - n) / 2;
        j = n;
      }
      for (;;)
      {
        if ((i != 0) && (j != 0)) {
          break label161;
        }
        paramBitmap = localBitmap;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("IphoneTitleBarActivity", 2, "getMidBitmap error! height = " + i + " ;width = " + j);
        return null;
        m = n * j / m;
        k = (i - m) / 2;
        i = m;
        m = 0;
      }
      localBitmap = Bitmap.createBitmap(paramBitmap, m, k, j, i);
      paramBitmap = localBitmap;
    } while (localBitmap.isMutable());
    paramBitmap = Bitmap.createScaledBitmap(localBitmap, localBitmap.getWidth() / 2, localBitmap.getHeight() / 2, true);
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      localBitmap.recycle();
    }
    return paramBitmap;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130844102, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131696156);
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "exp_blank", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130843990, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131696159);
      QQToast.a(this, 1, getString(2131696158), 0).b(getTitleBarHeight());
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Bundle localBundle = TroopInfoActivity.a(paramString, 18);
    Activity localActivity = getActivity();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      TroopUtils.a(localActivity, localBundle, i);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_data", 0, 0, paramString, "1", "", "");
      return;
    }
    ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_data", 0, 0, paramString, "0", "", "");
  }
  
  protected void a(List<String> paramList, boolean paramBoolean)
  {
    MultiLineLayout localMultiLineLayout = (MultiLineLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378888);
    localMultiLineLayout.setShowLine(2);
    localMultiLineLayout.removeAllViews();
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        TextView localTextView = new TextView(this);
        localTextView.setBackgroundResource(2130844147);
        localTextView.setTextSize(2, 14.0F);
        if (paramBoolean) {
          localTextView.setMaxWidth((int)(77.0F * this.mDensity));
        }
        localTextView.setSingleLine();
        localTextView.setTextColor(-1);
        localTextView.setShadowLayer(0.0F, 0.0F, 2.0F, Color.parseColor("#000000"));
        localTextView.setGravity(17);
        localTextView.setText((CharSequence)paramList.get(i));
        localTextView.setEllipsize(TextUtils.TruncateAt.END);
        localMultiLineLayout.addView(localTextView, new ViewGroup.LayoutParams(-2, -2));
        localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        i += 1;
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1) && (paramIntent != null)) {
      this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("isDataChanged", false);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidAppActivity = this;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    b();
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter.c();
    }
    super.doOnDestroy();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("isDataChanged", this.jdField_c_of_type_Boolean);
      setResult(-1, localIntent);
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnPause()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b().size() == 0))
      {
        a();
        return;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter);
    }
    a();
    c();
    super.doOnResume();
  }
  
  public void doOnStart()
  {
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    super.doOnStart();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    switch (i)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("onlyOneSegement", true);
      localIntent.putExtra("_key_mode", 0);
      localIntent.putExtra("key_tab_mode", 1);
      localIntent.putExtra("is_from_show_ext_troop_list", true);
      localIntent.setClass(this, TroopActivity.class);
      startActivityForResult(localIntent, 1);
      if (i == 2131369518)
      {
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_mana", 0, 0, "", "", "", "");
      }
      else if (i == 2131377873)
      {
        ReportController.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_set", 0, 0, "", "", "", "");
        continue;
        localIntent = new Intent();
        localIntent.putExtra("isDataChanged", this.jdField_c_of_type_Boolean);
        setResult(-1, localIntent);
        onBackPressed();
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(a());
    if ((!a()) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 1000L);
    }
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity
 * JD-Core Version:    0.7.0.1
 */