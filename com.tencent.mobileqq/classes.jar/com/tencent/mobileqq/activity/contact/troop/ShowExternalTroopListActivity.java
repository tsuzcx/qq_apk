package com.tencent.mobileqq.activity.contact.troop;

import ahoz;
import ahpa;
import ahpb;
import ahpc;
import akld;
import aklg;
import amdu;
import ameq;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import azqs;
import bcpx;
import bdbk;
import bdhj;
import bdin;
import bhzf;
import com.tencent.biz.ui.MultiLineLayout;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class ShowExternalTroopListActivity
  extends IphoneTitleBarActivity
  implements aklg, View.OnClickListener, bhzf
{
  public int a;
  public akld a;
  protected ameq a;
  public Activity a;
  public Handler a;
  public View.OnClickListener a;
  protected View a;
  protected Button a;
  protected RelativeLayout a;
  protected TextView a;
  protected TroopManager a;
  public PullRefreshHeader a;
  protected RedDotTextView a;
  public XListView a;
  public String a;
  public boolean a;
  protected TextView b;
  String b;
  public boolean b;
  public TextView c;
  protected boolean c;
  
  public ShowExternalTroopListActivity()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Ameq = new ahoz(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahpb(this);
    this.jdField_a_of_type_AndroidOsHandler = new ahpc(this);
  }
  
  private long a()
  {
    return getActivity().getSharedPreferences("rec_last_ext_show_troop_list_refresh_time", 0).getLong("rec_last_ext_show_troop_list_refresh_time", 0L);
  }
  
  private boolean a()
  {
    if (bdin.g(getActivity()))
    {
      ((amdu)this.app.a(20)).a(this.jdField_a_of_type_JavaLangString, 0, 0);
      this.jdField_b_of_type_Boolean = true;
      return true;
    }
    QQToast.a(this, 2130839407, getString(2131698042), 0).b(getResources().getDimensionPixelSize(2131298914));
    return false;
  }
  
  private void b()
  {
    setContentViewNoTitle(2131560508);
    Object localObject1 = (LinearLayout)findViewById(2131376034);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ((LinearLayout)localObject1).setFitsSystemWindows(true);
    }
    setTitle(2131696640);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368624));
    Intent localIntent = getIntent();
    this.jdField_a_of_type_Boolean = localIntent.getExtras().getBoolean("isHost");
    Object localObject2 = localIntent.getExtras().getString("leftViewText");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = getString(2131690623);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)findViewById(2131368655));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setContentDescription(getString(2131696643));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setText(2131696642);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setOnClickListener(this);
    String str;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setVisibility(8);
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131373120));
      localObject1 = LayoutInflater.from(this).inflate(2131560507, null);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131378502));
      this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131696689));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371189));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131376489));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131373004));
      this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130850096);
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131560431, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject1);
      }
      this.jdField_a_of_type_JavaLangString = localIntent.getExtras().getString("dest_uin_str");
      this.jdField_b_of_type_JavaLangString = localIntent.getExtras().getString("from_troop_uin");
      this.jdField_a_of_type_Akld = new akld(getActivity(), this.app, this, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Akld);
      this.jdField_a_of_type_Akld.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131559510, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130838593);
      localObject2 = this.app;
      str = this.jdField_a_of_type_JavaLangString;
      if (!this.jdField_a_of_type_Boolean) {
        break label553;
      }
    }
    label553:
    for (localObject1 = "0";; localObject1 = "1")
    {
      azqs.b((QQAppInterface)localObject2, "P_CliOper", "Grp_join", "", "person_data", "exp_grp", 0, 0, str, (String)localObject1, "" + localIntent.getIntExtra("from", 0), "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setVisibility(0);
      break;
    }
  }
  
  private void c()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368053);
    Object localObject = bdhj.a();
    localImageView.setImageDrawable(bdbk.a(this.app, 1, this.jdField_a_of_type_JavaLangString, 3, (Drawable)localObject, (Drawable)localObject));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131364771).bringToFront();
    ThreadManager.post(new ShowExternalTroopListActivity.2(this), 8, null, true);
    localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369131);
    ThreadManager.post(new ShowExternalTroopListActivity.3(this, (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371139), (TextView)localObject), 8, null, true);
    localImageView.setOnClickListener(new ahpa(this, localImageView));
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
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130843450, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131696649);
      azqs.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "exp_blank", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130843340, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131696652);
      QQToast.a(this, 1, getString(2131696651), 0).b(getTitleBarHeight());
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
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
      bcpx.a(localActivity, localBundle, i);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      azqs.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_data", 0, 0, paramString, "1", "", "");
      return;
    }
    azqs.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_data", 0, 0, paramString, "0", "", "");
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    MultiLineLayout localMultiLineLayout = (MultiLineLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377416);
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
        localTextView.setBackgroundResource(2130843494);
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
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(a());
    if ((!a()) && (this.jdField_a_of_type_AndroidOsHandler != null)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 1000L);
    }
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
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
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.app.getManager(52));
    addObserver(this.jdField_a_of_type_Ameq);
    b();
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_Ameq);
    if (this.jdField_a_of_type_Akld != null) {
      this.jdField_a_of_type_Akld.c();
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
    removeObserver(this.jdField_a_of_type_Ameq);
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
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Akld);
    }
    a();
    c();
    super.doOnResume();
  }
  
  public void doOnStart()
  {
    addObserver(this.jdField_a_of_type_Ameq);
    super.doOnStart();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    switch (i)
    {
    default: 
    case 2131368655: 
    case 2131376489: 
      do
      {
        return;
        paramView = new Intent();
        paramView.putExtra("onlyOneSegement", true);
        paramView.putExtra("_key_mode", 0);
        paramView.putExtra("key_tab_mode", 1);
        paramView.putExtra("is_from_show_ext_troop_list", true);
        paramView.setClass(this, TroopActivity.class);
        startActivityForResult(paramView, 1);
        if (i == 2131368655)
        {
          azqs.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_mana", 0, 0, "", "", "", "");
          return;
        }
      } while (i != 2131376489);
      azqs.b(this.app, "P_CliOper", "Grp_join", "", "join_page", "Clk_set", 0, 0, "", "", "", "");
      return;
    }
    paramView = new Intent();
    paramView.putExtra("isDataChanged", this.jdField_c_of_type_Boolean);
    setResult(-1, paramView);
    onBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity
 * JD-Core Version:    0.7.0.1
 */