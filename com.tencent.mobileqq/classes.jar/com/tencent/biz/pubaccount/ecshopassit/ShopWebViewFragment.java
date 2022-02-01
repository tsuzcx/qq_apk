package com.tencent.biz.pubaccount.ecshopassit;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewSurface;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ShopWebViewFragment
  extends WebViewFragment
  implements DragFrameLayout.OnDragModeChangedListener
{
  int jdField_a_of_type_Int;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ShopWebViewFragment.4(this);
  View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  EcshopCacheTool jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool;
  public ShopFolderAdapter a;
  DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  SosoInterfaceOnLocationListener jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener = new ShopWebViewFragment.5(this, 0, true, false, 600000L, false, false, "ecshop");
  RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  public List<RecentShopParcel> a;
  boolean jdField_a_of_type_Boolean;
  String[] jdField_a_of_type_ArrayOfJavaLangString = new String[4];
  int jdField_b_of_type_Int = 0;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public TextView b;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  public ImageView c;
  public TextView c;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int;
  public TextView d;
  boolean jdField_d_of_type_Boolean;
  
  void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = new FadeIconImageView(getQBaseActivity());
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getQBaseActivity());
    Object localObject2;
    int i;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713877));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setId(2131369563);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130851067);
      localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376755);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.b(10.0F, getResources());
      ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131379476);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167394));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130837943);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      i = AIOUtils.b(3.0F, getResources());
      int j = AIOUtils.b(4.0F, getResources());
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15);
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131369563);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = j;
      ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
    }
    else
    {
      i = AIOUtils.b(30.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetImageView = new FadeIconImageView(getQBaseActivity());
      this.jdField_b_of_type_AndroidWidgetImageView.setId(2131369221);
      this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
      localObject1 = new RelativeLayout.LayoutParams(i, i);
      ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131369216);
      ((RelativeLayout)this.jdField_c_of_type_AndroidWidgetImageView.getParent()).addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
    }
    Object localObject1 = new int[4][];
    localObject1[0] = { 16842919 };
    localObject1[1] = { 16842912 };
    localObject1[2] = { 16842913 };
    localObject1[3] = new int[0];
    if (this.jdField_c_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130850434);
        localObject2 = getResources().getColorStateList(2131167054);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject2);
        localObject2 = new ColorStateList((int[][])localObject1, new int[] { 2147483647, 2147483647, 2147483647, -1 });
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject2);
        getQBaseActivity().setStatusBarBlue();
      }
      if (Build.VERSION.SDK_INT >= 19) {
        break label745;
      }
    }
    try
    {
      localObject2 = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject2).topMargin = (ScreenUtil.dip2px(29.0F) - ImmersiveUtils.getStatusBarHeight(getQBaseActivity().getApplicationContext()));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Change mBackWrapper topMargin=");
        localStringBuilder.append(((ViewGroup.MarginLayoutParams)localObject2).topMargin);
        QLog.d("WebLog_WebViewFragment", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    catch (Throwable localThrowable)
    {
      label594:
      break label594;
    }
    break label745;
    if ((this.webViewSurface.b()) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      if (getWebTitleBarInterface().a() != null)
      {
        if ((getUIStyle() != null) && (getUIStyle().a != null))
        {
          getWebTitleBarInterface().a().setBackgroundColor(getUIStyle().a.jdField_b_of_type_Int);
          SimpleUIUtil.a(true, getUIStyle().a.jdField_b_of_type_Int, getHostActivity().getWindow());
        }
        else
        {
          getWebTitleBarInterface().a().setBackgroundColor(getResources().getColor(2131167114));
          SimpleUIUtil.a(false, getResources().getColor(2131167114), getHostActivity().getWindow());
        }
      }
      else {
        getWebTitleBarInterface().b(false);
      }
    }
    label745:
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-1);
      ImmersiveUtils.setStatusBarDarkMode(getActivity().getWindow(), true);
      if (getWebTitleBarInterface().a() != null) {
        getWebTitleBarInterface().a().setBackgroundResource(2130851328);
      }
      i = AIOUtils.b(3.0F, getResources());
      localObject1 = new ColorStateList((int[][])localObject1, new int[] { 2130706432, 2130706432, 2130706432, -16777216 });
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130849814);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setPadding(i, i, i, i);
      this.jdField_b_of_type_AndroidWidgetImageView.setPadding(i, i, i, i);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(ImageUtil.a(2130847344, getQBaseActivity()));
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(ImageUtil.a(2130847345, getQBaseActivity()));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      i = AIOUtils.b(4.0F, getResources());
      ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams()).rightMargin = i;
    }
    else
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131713878));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
    b();
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject == null) {
      return;
    }
    if ((paramInt == 1) && (localObject != null))
    {
      ((ImageView)localObject).setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(getQBaseActivity(), this.jdField_b_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.b(53);
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a();
      localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(0);
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject);
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(4);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((paramInt1 == 0) && (this.jdField_b_of_type_Int == 1))
    {
      this.jdField_b_of_type_Int = 0;
      localObject = this.jdField_a_of_type_ComTencentWidgetSwipListView;
      if (localObject != null) {
        ((SwipListView)localObject).setVisibility(8);
      }
    }
    else if ((paramInt1 == 1) && (this.jdField_b_of_type_Int == 0))
    {
      this.jdField_b_of_type_Int = 1;
      localObject = this.jdField_a_of_type_ComTencentWidgetSwipListView;
      if (localObject == null)
      {
        a(LayoutInflater.from(getQBaseActivity()));
        localObject = (RelativeLayout)this.webView.getParent();
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.topMargin = paramInt2;
        ((RelativeLayout)localObject).addView(this.jdField_a_of_type_ComTencentWidgetSwipListView, localLayoutParams);
      }
      else
      {
        ((RelativeLayout.LayoutParams)((SwipListView)localObject).getLayoutParams()).topMargin = paramInt2;
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopFolderAdapter.a(this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.requestLayout();
      }
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).bringToFront();
      }
    }
    else if (paramInt1 == 1)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetSwipListView;
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)((SwipListView)localObject).getLayoutParams()).topMargin = paramInt2;
        this.jdField_a_of_type_ComTencentWidgetSwipListView.requestLayout();
      }
    }
  }
  
  void a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)paramLayoutInflater.inflate(2131559975, null));
    paramLayoutInflater = paramLayoutInflater.inflate(2131561895, null);
    paramLayoutInflater.findViewById(2131363908).setOnClickListener(new ShopWebViewFragment.1(this));
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = paramLayoutInflater.findViewById(2131378999);
      View localView = paramLayoutInflater.findViewById(2131363908);
      if (localObject != null) {
        ((View)localObject).setBackgroundColor(Color.parseColor("#FFFFFFFF"));
      }
      if (localView != null) {
        localView.setBackgroundResource(2130847334);
      }
      localObject = (TextView)paramLayoutInflater.findViewById(2131364094);
      ((TextView)localObject).setTextColor(Color.parseColor("#FF000000"));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130838775, 0);
      paramLayoutInflater.findViewById(2131365759).setBackgroundColor(Color.parseColor("#FFF9F9FB"));
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166247);
    }
    this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView(paramLayoutInflater);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopFolderAdapter = new ShopFolderAdapter(getQBaseActivity(), this.jdField_a_of_type_ComTencentWidgetSwipListView, this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool, this.jdField_a_of_type_ArrayOfJavaLangString[0]);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopFolderAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopFolderAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopFolderAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    if ((getQBaseActivity() instanceof SwipListView.RightIconMenuListener)) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener((SwipListView.RightIconMenuListener)getQBaseActivity());
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    paramLayoutInflater = new JSONObject();
    Object localObject = new JSONObject();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnTouchListener(new ShopWebViewFragment.2(this, paramLayoutInflater, (JSONObject)localObject));
  }
  
  void b()
  {
    Object localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject1 != null)
    {
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localTextView != null)
      {
        if (localTextView == null) {
          return;
        }
        if ((this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
        {
          ((TextView)localObject1).setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
        }
        if (localTextView != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
          localObject1 = ((StringBuilder)localObject1).toString();
          if ((this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
          {
            if (this.jdField_a_of_type_Int > 99) {
              localObject1 = "99+";
            }
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(getString(2131719442));
            ((StringBuilder)localObject1).append("(");
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
            ((StringBuilder)localObject1).append(")");
            localObject1 = ((StringBuilder)localObject1).toString();
            if (this.jdField_a_of_type_Int > 99)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(getString(2131719442));
              ((StringBuilder)localObject1).append("(99+)");
              localObject1 = ((StringBuilder)localObject1).toString();
            }
          }
          Object localObject2 = localObject1;
          if (this.jdField_a_of_type_Int <= 0)
          {
            localObject2 = localObject1;
            if (!this.jdField_d_of_type_Boolean)
            {
              localObject1 = getString(2131719442);
              localObject2 = localObject1;
              if (this.jdField_c_of_type_Boolean)
              {
                localObject2 = localObject1;
                if (!this.jdField_a_of_type_Boolean)
                {
                  localTextView.setVisibility(8);
                  return;
                }
              }
            }
          }
          localObject1 = localTextView;
          if (this.jdField_d_of_type_Boolean)
          {
            if (this.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            }
            else
            {
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
              localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
              localTextView.setBackgroundResource(0);
            }
            localObject2 = getResources().getString(2131690706);
            localObject1 = localTextView;
          }
          ((TextView)localObject1).setText((CharSequence)localObject2);
        }
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      int i = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
      this.webViewSurface.a(new View(super.getActivity()));
      getWebTitleBarInterface().a().setId(2131377853);
      getWebTitleBarInterface().a().setBackgroundResource(2130850433);
      paramBundle = new RelativeLayout.LayoutParams(-1, i);
      paramBundle.addRule(10, -1);
      this.contentView.addView(getWebTitleBarInterface().a(), paramBundle);
      LayoutInflater.from(getQBaseActivity()).inflate(2131558726, this.contentView);
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.contentView.findViewById(2131376636));
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130850433);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams()).topMargin = i;
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369202));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369249));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369233));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369216));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      paramBundle = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371243);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      a();
      return true;
    }
    return super.doOnCreate(paramBundle);
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new ShopWebViewFragment.3(this, this.webViewSurface);
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131380207))
    {
      paramDragFrameLayout = (RecentShopParcel)paramDragFrameLayout.a().getTag(2131374762);
      if (paramDragFrameLayout != null)
      {
        paramDragFrameLayout.jdField_b_of_type_Int = 0;
        Intent localIntent = new Intent("action_shop_set_read");
        localIntent.putExtra("uin", paramDragFrameLayout.a);
        localIntent.putExtra("needDelete", false);
        getQBaseActivity().sendBroadcast(localIntent);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
      break;
    case 2131369221: 
    case 2131369233: 
      if (this.webView != null)
      {
        localObject = WebViewPlugin.toJsScript("onEnterUserInfo", new JSONObject(), new JSONObject());
        this.webView.callJs((String)localObject);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
      if (localObject != null) {
        ((RedTouch)localObject).d();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.b(getQBaseActivity(), this.jdField_a_of_type_ArrayOfJavaLangString[3]);
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopReportHandler.a(134248547, null, null, null, null, 0L, false);
    }
    catch (Exception localException)
    {
      label213:
      break label213;
    }
    if (this.webView != null)
    {
      localObject = WebViewPlugin.toJsScript("onSearchBtnClick", new JSONObject(), new JSONObject());
      this.webView.callJs((String)localObject);
      break label213;
      if (getQBaseActivity() != null) {
        getQBaseActivity().doOnBackPressed();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getAppRuntime() == null) {
      this.mApp = getQBaseActivity().getAppRuntime();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool = new EcshopCacheTool((AppInterface)getAppRuntime(), this);
    boolean bool1 = this.intent.hasExtra("bundle");
    int i = 0;
    long l1;
    if (bool1)
    {
      paramBundle = this.intent.getBundleExtra("bundle");
      paramBundle.setClassLoader(RecentShopParcel.class.getClassLoader());
      this.jdField_a_of_type_Boolean = paramBundle.getBoolean("is_tab_show", false);
      l1 = 0L;
      long l2 = paramBundle.getLong("click_time", 0L);
      bool1 = paramBundle.getBoolean("is_tool_exist", false);
      if (l2 != 0L) {
        l1 = System.currentTimeMillis() - l2;
      }
      this.jdField_a_of_type_ArrayOfJavaLangString = paramBundle.getStringArray("urls");
      this.jdField_a_of_type_JavaUtilList = paramBundle.getParcelableArrayList("datas");
      this.jdField_b_of_type_Boolean = paramBundle.getBoolean("hasUnread", false);
      this.jdField_a_of_type_Int = paramBundle.getInt("unReadNum", 0);
      this.jdField_c_of_type_Boolean = paramBundle.getBoolean("isDefaultTheme", true);
      this.jdField_d_of_type_Boolean = paramBundle.getBoolean("from_search", false);
      paramBundle = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool;
      boolean bool2 = this.jdField_a_of_type_Boolean;
      paramBundle.jdField_a_of_type_Boolean = bool2;
      if (!bool2) {}
    }
    for (;;)
    {
      try
      {
        paramBundle.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopReportHandler.a(134248544, null, null, null, null, 0L, false);
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopReportHandler;
        if (!bool1) {
          break label378;
        }
        paramBundle = "1";
        ((EcshopReportHandler)localObject).a(134248552, null, paramBundle, String.valueOf(l1), null, 0L, false);
      }
      catch (Exception paramBundle)
      {
        try
        {
          getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
          paramBundle = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool;
          Object localObject = getAppRuntime();
          if (this.jdField_a_of_type_JavaUtilList != null) {
            i = this.jdField_a_of_type_JavaUtilList.size();
          }
          paramBundle.a((AppRuntime)localObject, i);
          return;
        }
        catch (Exception paramBundle)
        {
          return;
        }
        paramBundle = paramBundle;
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(getQBaseActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
      paramBundle = new IntentFilter();
      paramBundle.addAction("action_decode_finish");
      paramBundle.addAction("action_on_shop_msg_receive");
      label378:
      paramBundle = "0";
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Int = 1;
      a(LayoutInflater.from(getQBaseActivity()));
      paramViewGroup = new RelativeLayout.LayoutParams(-1, -1);
      paramViewGroup.addRule(3, 2131376666);
      this.contentView.addView(this.jdField_a_of_type_ComTencentWidgetSwipListView, paramViewGroup);
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      getQBaseActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label15:
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopFolderAdapter;
      if (localObject != null)
      {
        ((ShopFolderAdapter)localObject).a();
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopFolderAdapter = null;
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopCacheTool;
      if (localObject != null) {
        ((EcshopCacheTool)localObject).a();
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
    super.onResume();
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      int k = Build.VERSION.SDK_INT;
      int j = 1;
      int i = 1;
      if (k >= 23)
      {
        if (getQBaseActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
          i = 0;
        }
        j = i;
        if (i == 0)
        {
          getQBaseActivity().requestPermissions("android.permission.ACCESS_FINE_LOCATION", 10, new String[0]);
          j = i;
        }
      }
      if (j != 0) {
        ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopFolderAdapter;
      if (localObject != null) {
        ((ShopFolderAdapter)localObject).notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment
 * JD-Core Version:    0.7.0.1
 */