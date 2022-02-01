package com.tencent.biz.pubaccount.ecshopassit;

import afur;
import aled;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anni;
import aopa;
import bclx;
import bcnj;
import bgmo;
import bhmv;
import bhqo;
import bkom;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import odq;
import odu;
import ody;
import oeb;
import oec;
import oed;
import oee;
import org.json.JSONObject;

public class ShopWebViewFragment
  extends WebViewFragment
  implements aled
{
  int jdField_a_of_type_Int;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new oed(this);
  View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  aopa jdField_a_of_type_Aopa = new oee(this, 0, true, false, 600000L, false, false, "ecshop");
  DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  public List<RecentShopParcel> a;
  public odq a;
  public ody a;
  boolean jdField_a_of_type_Boolean;
  public String[] a;
  public int b;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public TextView b;
  boolean jdField_b_of_type_Boolean;
  public int c;
  public ImageView c;
  public TextView c;
  boolean c;
  public int d;
  public TextView d;
  boolean d;
  
  public ShopWebViewFragment()
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[4];
    this.jdField_b_of_type_Int = 0;
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = new FadeIconImageView(getActivity());
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getActivity());
    Object localObject1;
    Object localObject2;
    int i;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(anni.a(2131712762));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setId(2131369362);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850653);
      localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376738);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = afur.a(10.0F, getResources());
      ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131379468);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167279));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130837976);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      i = afur.a(3.0F, getResources());
      int j = afur.a(4.0F, getResources());
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15);
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131369362);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = j;
      ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
      localObject1 = new int[4][];
      localObject1[0] = { 16842919 };
      localObject1[1] = { 16842912 };
      localObject1[2] = { 16842913 };
      localObject1[3] = new int[0];
      if (!this.jdField_c_of_type_Boolean) {
        break label823;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130850088);
        localObject2 = getResources().getColorStateList(2131166984);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject2);
        localObject2 = new ColorStateList((int[][])localObject1, new int[] { 2147483647, 2147483647, 2147483647, -1 });
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject2);
        getActivity().setStatusBarBlue();
      }
      if (Build.VERSION.SDK_INT >= 19) {}
    }
    label823:
    try
    {
      localObject2 = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = (bclx.a(29.0F) - ImmersiveUtils.getStatusBarHeight(getActivity().getApplicationContext()));
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "Change mBackWrapper topMargin=" + ((ViewGroup.MarginLayoutParams)localObject2).topMargin);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    catch (Throwable localThrowable)
    {
      label497:
      break label497;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-1);
      ImmersiveUtils.a(getActivity().getWindow(), true);
      if (this.mSystemBarComp != null) {
        this.mSystemBarComp.setBackgroundResource(2130850868);
      }
      i = afur.a(3.0F, getResources());
      localObject1 = new ColorStateList((int[][])localObject1, new int[] { 2130706432, 2130706432, 2130706432, -16777216 });
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130849526);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setPadding(i, i, i, i);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(i, i, i, i);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(bgmo.a(2130847094, getActivity()));
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(bgmo.a(2130847095, getActivity()));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      i = afur.a(4.0F, getResources());
      ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams()).rightMargin = i;
    }
    for (;;)
    {
      b();
      return;
      i = afur.a(30.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetImageView = new FadeIconImageView(getActivity());
      this.jdField_b_of_type_AndroidWidgetImageView.setId(2131368967);
      this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
      localObject1 = new RelativeLayout.LayoutParams(i, i);
      ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131368961);
      ((RelativeLayout)this.jdField_c_of_type_AndroidWidgetImageView.getParent()).addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
      break;
      if ((!this.mNeedStatusTrans) || (ImmersiveUtils.isSupporImmersive() != 1)) {
        break label497;
      }
      if (this.mSystemBarComp != null)
      {
        if ((this.mUIStyle != null) && (this.mUIStyle.a != null))
        {
          this.mSystemBarComp.setBackgroundColor(this.mUIStyle.a.jdField_b_of_type_Int);
          bcnj.a(true, this.mUIStyle.a.jdField_b_of_type_Int, getHostActivity().getWindow());
          break label497;
        }
        this.mSystemBarComp.setBackgroundColor(getResources().getColor(2131167042));
        bcnj.a(false, getResources().getColor(2131167042), getHostActivity().getWindow());
        break label497;
      }
      setImmersiveStatus();
      break label497;
      this.jdField_d_of_type_AndroidWidgetTextView.setText(anni.a(2131712763));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if ((paramInt == 1) && (this.jdField_b_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getActivity(), this.jdField_b_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(53);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a();
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localRedTypeInfo);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(4);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (this.jdField_b_of_type_Int == 1))
    {
      this.jdField_b_of_type_Int = 0;
      if (this.jdField_a_of_type_ComTencentWidgetSwipListView != null) {
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(8);
      }
    }
    do
    {
      for (;;)
      {
        return;
        if ((paramInt1 != 1) || (this.jdField_b_of_type_Int != 0)) {
          break;
        }
        this.jdField_b_of_type_Int = 1;
        if (this.jdField_a_of_type_ComTencentWidgetSwipListView == null)
        {
          a(LayoutInflater.from(getActivity()));
          RelativeLayout localRelativeLayout = (RelativeLayout)this.webView.getParent();
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
          localLayoutParams.topMargin = paramInt2;
          localRelativeLayout.addView(this.jdField_a_of_type_ComTencentWidgetSwipListView, localLayoutParams);
        }
        while (this.jdField_a_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_AndroidViewView.bringToFront();
          return;
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetSwipListView.getLayoutParams()).topMargin = paramInt2;
          this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(0);
          this.jdField_a_of_type_Ody.a(this.jdField_a_of_type_JavaUtilList);
          this.jdField_a_of_type_ComTencentWidgetSwipListView.requestLayout();
        }
      }
    } while ((paramInt1 != 1) || (this.jdField_a_of_type_ComTencentWidgetSwipListView == null));
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetSwipListView.getLayoutParams()).topMargin = paramInt2;
    this.jdField_a_of_type_ComTencentWidgetSwipListView.requestLayout();
  }
  
  void a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)paramLayoutInflater.inflate(2131559973, null));
    paramLayoutInflater = paramLayoutInflater.inflate(2131561938, null);
    paramLayoutInflater.findViewById(2131363758).setOnClickListener(new oeb(this));
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = paramLayoutInflater.findViewById(2131378994);
      View localView = paramLayoutInflater.findViewById(2131363758);
      if (localObject != null) {
        ((View)localObject).setBackgroundColor(Color.parseColor("#FFFFFFFF"));
      }
      if (localView != null) {
        localView.setBackgroundResource(2130847087);
      }
      localObject = (TextView)paramLayoutInflater.findViewById(2131363946);
      ((TextView)localObject).setTextColor(Color.parseColor("#FF000000"));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838861, 0);
      paramLayoutInflater.findViewById(2131365590).setBackgroundColor(Color.parseColor("#FFF9F9FB"));
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166201);
    }
    this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView(paramLayoutInflater);
    this.jdField_a_of_type_Ody = new ody(getActivity(), this.jdField_a_of_type_ComTencentWidgetSwipListView, this.jdField_a_of_type_Odq, this.jdField_a_of_type_ArrayOfJavaLangString[0]);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Ody);
    this.jdField_a_of_type_Ody.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Ody.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    if ((getActivity() instanceof bkom)) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener((bkom)getActivity());
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    paramLayoutInflater = new JSONObject();
    Object localObject = new JSONObject();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnTouchListener(new oec(this, paramLayoutInflater, (JSONObject)localObject));
  }
  
  void b()
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    Object localObject2;
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      label66:
      if (localObject2 == null) {
        break label267;
      }
      localObject1 = "" + this.jdField_a_of_type_Int;
      if ((this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        break label269;
      }
      localObject1 = getString(2131718387) + "(" + this.jdField_a_of_type_Int + ")";
      if (this.jdField_a_of_type_Int > 99) {
        localObject1 = getString(2131718387) + "(99+)";
      }
    }
    Object localObject3;
    for (;;)
    {
      localObject3 = localObject1;
      if (this.jdField_a_of_type_Int > 0) {
        break label285;
      }
      localObject3 = localObject1;
      if (this.jdField_d_of_type_Boolean) {
        break label285;
      }
      localObject1 = getString(2131718387);
      localObject3 = localObject1;
      if (!this.jdField_c_of_type_Boolean) {
        break label285;
      }
      localObject3 = localObject1;
      if (this.jdField_a_of_type_Boolean) {
        break label285;
      }
      ((TextView)localObject2).setVisibility(8);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject2 = this.jdField_b_of_type_AndroidWidgetTextView;
      break label66;
      label267:
      break;
      label269:
      if (this.jdField_a_of_type_Int > 99) {
        localObject1 = "99+";
      }
    }
    label285:
    Object localObject1 = localObject2;
    if (this.jdField_d_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label331;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = getResources().getString(2131690563);
      localObject3 = localObject2;
      ((TextView)localObject1).setText(localObject3);
      return;
      label331:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
      ((TextView)localObject1).setBackgroundResource(0);
    }
  }
  
  public int doCreateLoopStep_InitTitleBar(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_InitTitleBar(paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup;
    this.jdField_b_of_type_AndroidWidgetTextView = this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView;
    this.jdField_c_of_type_AndroidWidgetTextView = this.mSwiftTitleUI.jdField_b_of_type_AndroidWidgetTextView;
    this.jdField_d_of_type_AndroidWidgetTextView = this.mSwiftTitleUI.jdField_c_of_type_AndroidWidgetTextView;
    this.jdField_c_of_type_AndroidWidgetImageView = this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView;
    a();
    if (this.mNightMode)
    {
      if (this.webView != null) {
        this.webView.setMask(false);
      }
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = new View(getActivity());
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(1996488704);
        paramBundle = new RelativeLayout.LayoutParams(-1, -1);
        this.contentView.addView(this.jdField_a_of_type_AndroidViewView, paramBundle);
      }
      this.jdField_a_of_type_AndroidViewView.bringToFront();
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.refreshDrawableState();
      this.jdField_c_of_type_AndroidWidgetImageView.refreshDrawableState();
    }
    return i;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      int i = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
      this.mSystemBarComp = new View(super.getActivity());
      this.mSystemBarComp.setId(2131377815);
      this.mSystemBarComp.setBackgroundResource(2130850087);
      paramBundle = new RelativeLayout.LayoutParams(-1, i);
      paramBundle.addRule(10, -1);
      this.contentView.addView(this.mSystemBarComp, paramBundle);
      LayoutInflater.from(getActivity()).inflate(2131558759, this.contentView);
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.contentView.findViewById(2131376599));
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130850087);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams()).topMargin = i;
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368947));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368994));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368979));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368961));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      a();
      return true;
    }
    return super.doOnCreate(paramBundle);
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131380253))
    {
      paramDragFrameLayout = (RecentShopParcel)paramDragFrameLayout.a().getTag(2131374727);
      if (paramDragFrameLayout != null)
      {
        paramDragFrameLayout.jdField_b_of_type_Int = 0;
        Intent localIntent = new Intent("action_shop_set_read");
        localIntent.putExtra("uin", paramDragFrameLayout.a);
        localIntent.putExtra("needDelete", false);
        getActivity().sendBroadcast(localIntent);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (getActivity() != null)
      {
        getActivity().doOnBackPressed();
        continue;
        if (this.webView != null)
        {
          String str1 = WebViewPlugin.toJsScript("onEnterUserInfo", new JSONObject(), new JSONObject());
          this.webView.callJs(str1);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
          this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.d();
        }
        this.jdField_a_of_type_Odq.b(getActivity(), this.jdField_a_of_type_ArrayOfJavaLangString[3]);
        try
        {
          this.jdField_a_of_type_Odq.jdField_a_of_type_Odu.a(134248547, null, null, null, null, 0L, false);
        }
        catch (Exception localException) {}
        continue;
        if (this.webView != null)
        {
          String str2 = WebViewPlugin.toJsScript("onSearchBtnClick", new JSONObject(), new JSONObject());
          this.webView.callJs(str2);
        }
      }
    }
  }
  
  /* Error */
  public void onCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 678	com/tencent/mobileqq/webview/swift/WebViewFragment:onCreate	(Landroid/os/Bundle;)V
    //   5: aload_0
    //   6: getfield 682	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:mApp	Lcom/tencent/common/app/AppInterface;
    //   9: ifnonnull +14 -> 23
    //   12: aload_0
    //   13: aload_0
    //   14: invokevirtual 63	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   17: invokevirtual 686	android/support/v4/app/FragmentActivity:getAppInterface	()Lcom/tencent/common/app/AppInterface;
    //   20: putfield 682	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:mApp	Lcom/tencent/common/app/AppInterface;
    //   23: aload_0
    //   24: new 660	odq
    //   27: dup
    //   28: aload_0
    //   29: getfield 682	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:mApp	Lcom/tencent/common/app/AppInterface;
    //   32: aload_0
    //   33: invokespecial 689	odq:<init>	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment;)V
    //   36: putfield 473	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_Odq	Lodq;
    //   39: aload_0
    //   40: getfield 693	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:intent	Landroid/content/Intent;
    //   43: ldc_w 695
    //   46: invokevirtual 699	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   49: ifeq +205 -> 254
    //   52: aload_0
    //   53: getfield 693	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:intent	Landroid/content/Intent;
    //   56: ldc_w 695
    //   59: invokevirtual 703	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   62: astore_1
    //   63: aload_1
    //   64: ldc_w 602
    //   67: invokevirtual 709	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   70: invokevirtual 715	android/os/Bundle:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   73: aload_0
    //   74: aload_1
    //   75: ldc_w 717
    //   78: iconst_0
    //   79: invokevirtual 721	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   82: putfield 75	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_Boolean	Z
    //   85: aload_1
    //   86: ldc_w 723
    //   89: lconst_0
    //   90: invokevirtual 727	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   93: lstore_3
    //   94: aload_1
    //   95: ldc_w 729
    //   98: iconst_0
    //   99: invokevirtual 721	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   102: istore 5
    //   104: lload_3
    //   105: lconst_0
    //   106: lcmp
    //   107: ifne +230 -> 337
    //   110: lconst_0
    //   111: lstore_3
    //   112: aload_0
    //   113: aload_1
    //   114: ldc_w 731
    //   117: invokevirtual 735	android/os/Bundle:getStringArray	(Ljava/lang/String;)[Ljava/lang/String;
    //   120: putfield 34	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   123: aload_0
    //   124: aload_1
    //   125: ldc_w 737
    //   128: invokevirtual 741	android/os/Bundle:getParcelableArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   131: putfield 425	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   134: aload_0
    //   135: aload_1
    //   136: ldc_w 743
    //   139: iconst_0
    //   140: invokevirtual 721	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   143: putfield 745	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_b_of_type_Boolean	Z
    //   146: aload_0
    //   147: aload_1
    //   148: ldc_w 747
    //   151: iconst_0
    //   152: invokevirtual 751	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   155: putfield 511	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_Int	I
    //   158: aload_0
    //   159: aload_1
    //   160: ldc_w 753
    //   163: iconst_1
    //   164: invokevirtual 721	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   167: putfield 183	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_c_of_type_Boolean	Z
    //   170: aload_0
    //   171: aload_1
    //   172: ldc_w 755
    //   175: iconst_0
    //   176: invokevirtual 721	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   179: putfield 523	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_d_of_type_Boolean	Z
    //   182: aload_0
    //   183: getfield 473	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_Odq	Lodq;
    //   186: aload_0
    //   187: getfield 75	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_Boolean	Z
    //   190: putfield 756	odq:jdField_a_of_type_Boolean	Z
    //   193: aload_0
    //   194: getfield 75	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_Boolean	Z
    //   197: ifeq +22 -> 219
    //   200: aload_0
    //   201: getfield 473	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_Odq	Lodq;
    //   204: getfield 666	odq:jdField_a_of_type_Odu	Lodu;
    //   207: ldc_w 757
    //   210: aconst_null
    //   211: aconst_null
    //   212: aconst_null
    //   213: aconst_null
    //   214: lconst_0
    //   215: iconst_0
    //   216: invokevirtual 672	odu:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V
    //   219: aload_0
    //   220: getfield 473	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_Odq	Lodq;
    //   223: getfield 666	odq:jdField_a_of_type_Odu	Lodu;
    //   226: astore 6
    //   228: iload 5
    //   230: ifeq +116 -> 346
    //   233: ldc_w 759
    //   236: astore_1
    //   237: aload 6
    //   239: ldc_w 760
    //   242: aconst_null
    //   243: aload_1
    //   244: lload_3
    //   245: invokestatic 764	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   248: aconst_null
    //   249: lconst_0
    //   250: iconst_0
    //   251: invokevirtual 672	odu:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V
    //   254: aload_0
    //   255: aload_0
    //   256: invokevirtual 63	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   259: invokestatic 767	com/tencent/mobileqq/activity/recent/cur/DragFrameLayout:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;
    //   262: putfield 482	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout	Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;
    //   265: aload_0
    //   266: getfield 482	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout	Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;
    //   269: aload_0
    //   270: iconst_0
    //   271: invokevirtual 770	com/tencent/mobileqq/activity/recent/cur/DragFrameLayout:a	(Laled;Z)V
    //   274: new 772	android/content/IntentFilter
    //   277: dup
    //   278: invokespecial 773	android/content/IntentFilter:<init>	()V
    //   281: astore_1
    //   282: aload_1
    //   283: ldc_w 775
    //   286: invokevirtual 778	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   289: aload_1
    //   290: ldc_w 780
    //   293: invokevirtual 778	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   296: aload_0
    //   297: invokevirtual 63	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   300: aload_0
    //   301: getfield 43	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   304: aload_1
    //   305: invokevirtual 784	android/support/v4/app/FragmentActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   308: pop
    //   309: aload_0
    //   310: getfield 473	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_Odq	Lodq;
    //   313: astore_1
    //   314: aload_0
    //   315: getfield 682	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:mApp	Lcom/tencent/common/app/AppInterface;
    //   318: astore 6
    //   320: aload_0
    //   321: getfield 425	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   324: ifnonnull +29 -> 353
    //   327: iconst_0
    //   328: istore_2
    //   329: aload_1
    //   330: aload 6
    //   332: iload_2
    //   333: invokevirtual 787	odq:a	(Lmqq/app/AppRuntime;I)V
    //   336: return
    //   337: invokestatic 793	java/lang/System:currentTimeMillis	()J
    //   340: lload_3
    //   341: lsub
    //   342: lstore_3
    //   343: goto -231 -> 112
    //   346: ldc_w 795
    //   349: astore_1
    //   350: goto -113 -> 237
    //   353: aload_0
    //   354: getfield 425	com/tencent/biz/pubaccount/ecshopassit/ShopWebViewFragment:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   357: invokeinterface 800 1 0
    //   362: istore_2
    //   363: goto -34 -> 329
    //   366: astore_1
    //   367: return
    //   368: astore_1
    //   369: goto -115 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	this	ShopWebViewFragment
    //   0	372	1	paramBundle	Bundle
    //   328	35	2	i	int
    //   93	250	3	l	long
    //   102	127	5	bool	boolean
    //   226	105	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   296	327	366	java/lang/Exception
    //   329	336	366	java/lang/Exception
    //   353	363	366	java/lang/Exception
    //   193	219	368	java/lang/Exception
    //   219	228	368	java/lang/Exception
    //   237	254	368	java/lang/Exception
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.jdField_b_of_type_Int = 1;
      a(LayoutInflater.from(getActivity()));
      paramViewGroup = new RelativeLayout.LayoutParams(-1, -1);
      paramViewGroup.addRule(3, 2131376640);
      this.contentView.addView(this.jdField_a_of_type_ComTencentWidgetSwipListView, paramViewGroup);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label15:
      if (this.jdField_a_of_type_Ody != null)
      {
        this.jdField_a_of_type_Ody.a();
        this.jdField_a_of_type_Ody = null;
      }
      if (this.jdField_a_of_type_Odq != null) {
        this.jdField_a_of_type_Odq.a();
      }
      return;
    }
    catch (Exception localException)
    {
      break label15;
    }
  }
  
  public void onResume()
  {
    int j = 1;
    int i = 1;
    super.onResume();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      if (Build.VERSION.SDK_INT >= 23) {
        if (getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
          break label98;
        }
      }
    }
    for (;;)
    {
      j = i;
      if (i == 0)
      {
        getActivity().requestPermissions("android.permission.ACCESS_FINE_LOCATION", 10, new String[0]);
        j = i;
      }
      if (j != 0) {
        SosoInterface.a(this.jdField_a_of_type_Aopa);
      }
      if (this.jdField_a_of_type_Ody != null) {
        this.jdField_a_of_type_Ody.notifyDataSetChanged();
      }
      return;
      label98:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment
 * JD-Core Version:    0.7.0.1
 */