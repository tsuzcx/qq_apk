package com.qq.im.poi;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anh;
import ani;
import anj;
import ank;
import anl;
import anm;
import ann;
import anp;
import anq;
import anr;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class LbsPackPoiListActivity
  extends LbsPackActivity
  implements View.OnClickListener, OverScrollViewListener
{
  private Dialog jdField_a_of_type_AndroidAppDialog;
  protected Handler.Callback a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public View a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private LbsPackManager jdField_a_of_type_ComQqImPoiLbsPackManager;
  private LbsPackObserver jdField_a_of_type_ComQqImPoiLbsPackObserver = new anp(this);
  private LbsPackPoiListAdapter.onClickListener jdField_a_of_type_ComQqImPoiLbsPackPoiListAdapter$onClickListener = new anq(this);
  private LbsPackPoiListAdapter jdField_a_of_type_ComQqImPoiLbsPackPoiListAdapter;
  private PoiInfo jdField_a_of_type_ComQqImPoiPoiInfo;
  public PullRefreshHeader a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  public MqqHandler a;
  public boolean a;
  View jdField_b_of_type_AndroidViewView;
  public RelativeLayout b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private LbsPackPoiListAdapter jdField_b_of_type_ComQqImPoiLbsPackPoiListAdapter;
  private XListView jdField_b_of_type_ComTencentWidgetXListView;
  List jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  private View d;
  private View e;
  
  public LbsPackPoiListActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler$Callback = new ann(this);
  }
  
  private anr a(PoiInfo paramPoiInfo)
  {
    anr localanr = new anr(paramPoiInfo);
    localanr.a(ChnToSpell.a(paramPoiInfo.jdField_a_of_type_JavaLangString, 2));
    localanr.b(ChnToSpell.a(paramPoiInfo.jdField_a_of_type_JavaLangString, 1));
    return localanr;
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(100, paramLong);
    }
  }
  
  public static void a(Activity paramActivity, PoiInfo paramPoiInfo, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, LbsPackPoiListActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extra_select_poi", paramPoiInfo);
    localIntent.putExtras(localBundle);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  private void a(PoiInfo paramPoiInfo)
  {
    if (paramPoiInfo != null)
    {
      if (this.jdField_b_of_type_Boolean) {
        break label103;
      }
      this.jdField_a_of_type_ComQqImPoiLbsPackPoiListAdapter.jdField_a_of_type_Long = paramPoiInfo.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComQqImPoiLbsPackPoiListAdapter.notifyDataSetChanged();
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("select_poi_location", paramPoiInfo);
      localIntent.putExtras(localBundle);
      setResult(-1, localIntent);
      finish();
      if (QLog.isColorLevel()) {
        QLog.i("LbsPack", 2, "select poiInfo:" + paramPoiInfo.toString());
      }
      return;
      label103:
      this.jdField_b_of_type_ComQqImPoiLbsPackPoiListAdapter.jdField_a_of_type_Long = paramPoiInfo.jdField_a_of_type_Long;
      this.jdField_b_of_type_ComQqImPoiLbsPackPoiListAdapter.notifyDataSetChanged();
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.e.getLayoutParams().height = -1;
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_ComQqImPoiLbsPackPoiListAdapter.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(0);
    Object localObject2 = paramString.toLowerCase();
    Object localObject3 = new ArrayList();
    Object localObject1 = new ArrayList();
    paramString = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      anr localanr = (anr)localIterator.next();
      String str1 = localanr.jdField_a_of_type_ComQqImPoiPoiInfo.jdField_a_of_type_JavaLangString.toLowerCase();
      String str2 = localanr.jdField_a_of_type_ComQqImPoiPoiInfo.b.toLowerCase();
      if ((str1.equals(localObject2)) || (localanr.b.equals(localObject2)) || (localanr.jdField_a_of_type_JavaLangString.equals(localObject2)) || (str2.equals(localObject2))) {
        ((List)localObject3).add(localanr);
      } else if ((str1.indexOf((String)localObject2) == 0) || (localanr.b.indexOf((String)localObject2) == 0) || (localanr.jdField_a_of_type_JavaLangString.indexOf((String)localObject2) == 0) || (str2.indexOf((String)localObject2) == 0)) {
        ((List)localObject1).add(localanr);
      } else if ((str1.indexOf((String)localObject2) > 0) || (localanr.b.indexOf((String)localObject2) > 0) || (localanr.jdField_a_of_type_JavaLangString.indexOf((String)localObject2) > 0) || (str2.indexOf((String)localObject2) > 0)) {
        paramString.add(localanr);
      }
    }
    localObject2 = ((List)localObject3).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (anr)((Iterator)localObject2).next();
      this.jdField_a_of_type_JavaUtilList.add(((anr)localObject3).jdField_a_of_type_ComQqImPoiPoiInfo);
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (anr)((Iterator)localObject1).next();
      this.jdField_a_of_type_JavaUtilList.add(((anr)localObject2).jdField_a_of_type_ComQqImPoiPoiInfo);
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      localObject1 = (anr)paramString.next();
      this.jdField_a_of_type_JavaUtilList.add(((anr)localObject1).jdField_a_of_type_ComQqImPoiPoiInfo);
    }
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComQqImPoiLbsPackPoiListAdapter.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_b_of_type_ComQqImPoiLbsPackPoiListAdapter.notifyDataSetChanged();
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(0);
    }
  }
  
  private boolean a()
  {
    if (NetworkUtil.g(this))
    {
      if (this.jdField_a_of_type_ComQqImPoiLbsPackManager != null) {
        this.jdField_a_of_type_ComQqImPoiLbsPackManager.a();
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(101, 10000L);
      return true;
    }
    return false;
  }
  
  @TargetApi(14)
  private void c()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362711));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362594);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362594);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363381));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363245));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363428));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131438777);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(2131436702);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131370280));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969239, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComQqImPoiLbsPackPoiListAdapter = new LbsPackPoiListAdapter(this, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComQqImPoiLbsPackPoiListAdapter.a(this.jdField_a_of_type_ComQqImPoiLbsPackPoiListAdapter$onClickListener);
    if (this.jdField_a_of_type_ComQqImPoiPoiInfo != null) {
      this.jdField_a_of_type_ComQqImPoiLbsPackPoiListAdapter.a(this.jdField_a_of_type_ComQqImPoiPoiInfo);
    }
    this.jdField_c_of_type_AndroidViewView = findViewById(2131363116);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    e();
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComQqImPoiLbsPackPoiListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130838215);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(getResources().getDrawable(2130838590));
    this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.jdField_c_of_type_AndroidViewView);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this);
    f();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComQqImPoiLbsPackManager = ((LbsPackManager)this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getManager(214));
    this.jdField_a_of_type_ComQqImPoiPoiInfo = ((PoiInfo)super.getIntent().getExtras().getParcelable("extra_select_poi"));
    if (this.jdField_a_of_type_ComQqImPoiLbsPackObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.registObserver(this.jdField_a_of_type_ComQqImPoiLbsPackObserver);
    }
    ArrayList localArrayList = this.jdField_a_of_type_ComQqImPoiLbsPackManager.a();
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
      return;
    }
    this.jdField_a_of_type_ComQqImPoiLbsPackManager.a();
  }
  
  private void e()
  {
    this.d = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130971517, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.d.findViewById(2131368321).setVisibility(8);
    EditText localEditText = (EditText)this.d.findViewById(2131368322);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setOnClickListener(this);
    localEditText.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.d);
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
    this.jdField_a_of_type_AndroidAppDialog.getWindow().setSoftInputMode(36);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130970375);
    Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = 0;
    ((WindowManager.LayoutParams)localObject).y = 0;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject).gravity = 51;
    this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject = (InputMethodManager)super.getSystemService("input_method");
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365669));
    this.jdField_b_of_type_ComTencentWidgetXListView.setBackgroundDrawable(getResources().getDrawable(2130838214));
    this.jdField_b_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_ComQqImPoiLbsPackPoiListAdapter = new LbsPackPoiListAdapter(this, this.jdField_a_of_type_JavaUtilList);
    this.jdField_b_of_type_ComQqImPoiLbsPackPoiListAdapter.a(this.jdField_a_of_type_ComQqImPoiLbsPackPoiListAdapter$onClickListener);
    this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_b_of_type_ComQqImPoiLbsPackPoiListAdapter);
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(new anh(this, (InputMethodManager)localObject));
    this.e = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131362840);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131368322));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new LbsPackPoiListActivity.SearchTextWatcher(this));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131368323));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new ani(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363923));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new anj(this));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131370281);
  }
  
  protected void a()
  {
    Object localObject = (InputMethodManager)super.getSystemService("input_method");
    int i = this.jdField_a_of_type_AndroidViewView.getHeight();
    TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
    localTranslateAnimation1.setDuration(300L);
    localTranslateAnimation1.setFillAfter(true);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(localTranslateAnimation1);
    TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
    localTranslateAnimation2.setDuration(300L);
    localTranslateAnimation1.setAnimationListener(new ank(this, localTranslateAnimation1, localTranslateAnimation2, i));
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new anl(this, i, localTranslateAnimation2, (InputMethodManager)localObject));
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    localObject = (Button)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131368321);
    ((Button)localObject).setVisibility(0);
    ((Button)localObject).setOnClickListener(new anm(this));
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_ComQqImPoiLbsPackPoiListAdapter.notifyDataSetChanged();
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.Y_();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    if (!a())
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(101, 500L);
    }
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  void b()
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      PoiInfo localPoiInfo = (PoiInfo)localIterator.next();
      this.jdField_b_of_type_JavaUtilList.add(a(localPoiInfo));
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131624738);
    super.doOnCreate(paramBundle);
    setContentView(2130970376);
    d();
    c();
    b();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComQqImPoiLbsPackObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.unRegistObserver(this.jdField_a_of_type_ComQqImPoiLbsPackObserver);
    }
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2131034121, 2131034122);
  }
  
  protected boolean onBackEvent()
  {
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368322: 
      a();
      return;
    }
    finish();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsPackPoiListActivity
 * JD-Core Version:    0.7.0.1
 */