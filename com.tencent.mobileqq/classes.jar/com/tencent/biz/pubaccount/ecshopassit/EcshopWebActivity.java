package com.tencent.biz.pubaccount.ecshopassit;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewFragmentBuilder;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EcshopWebActivity
  extends QQBrowserActivity
  implements SwipListView.RightIconMenuListener
{
  public long a;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public String a;
  public List<RecentShopParcel> a;
  Map<Rect, Boolean> jdField_a_of_type_JavaUtilMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  public long b;
  public String b;
  boolean b;
  long jdField_c_of_type_Long;
  boolean jdField_c_of_type_Boolean = false;
  private long d = 0L;
  
  public EcshopWebActivity()
  {
    this.mFragmentClass = ShopWebViewFragment.class;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      boolean bool = ((Boolean)localEntry.getValue()).booleanValue();
      if (((Rect)localEntry.getKey()).contains(paramInt1, paramInt2)) {
        return bool;
      }
    }
    return false;
  }
  
  public void a(Rect paramRect, boolean paramBoolean)
  {
    if (paramRect != null)
    {
      if ((paramBoolean) && (this.jdField_a_of_type_JavaUtilMap.containsKey(paramRect))) {
        this.jdField_a_of_type_JavaUtilMap.remove(paramRect);
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Rect localRect = (Rect)((Map.Entry)localIterator.next()).getKey();
        if ((localRect.left == paramRect.left) && (localRect.top == paramRect.top)) {
          this.jdField_a_of_type_JavaUtilMap.remove(localRect);
        }
      }
      this.jdField_a_of_type_JavaUtilMap.put(paramRect, Boolean.valueOf(paramBoolean));
    }
  }
  
  void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaUtilList = paramBundle.getParcelableArrayList("datas");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("ad_logo");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("ad_jump");
    this.jdField_a_of_type_Long = paramBundle.getLong("ad_id", 0L);
    this.jdField_b_of_type_Long = paramBundle.getLong("latest_time", 0L);
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("is_tab_show", false);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      if (localObject != null)
      {
        if (((List)localObject).isEmpty()) {
          return;
        }
        localObject = new Intent("action_shop_set_read");
        ((Intent)localObject).putExtra("uin", paramString);
        ((Intent)localObject).putExtra("needDelete", false);
        sendBroadcast((Intent)localObject);
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          RecentShopParcel localRecentShopParcel = (RecentShopParcel)((Iterator)localObject).next();
          if (paramString.equals(localRecentShopParcel.jdField_a_of_type_JavaLangString)) {
            localRecentShopParcel.b = 0;
          }
        }
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    int i = paramMotionEvent.getAction();
    boolean bool;
    if (this.jdField_a_of_type_AndroidViewViewGroup == null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131381085));
      if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
        this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131365183));
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup == null)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        break label204;
      }
    }
    View localView = findViewById(2131376636);
    if (localView == null)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    else
    {
      if (i != 0)
      {
        if (i != 1) {
          if (i != 2)
          {
            if (i != 3) {
              break label198;
            }
          }
          else
          {
            if (!this.jdField_c_of_type_Boolean) {
              break label198;
            }
            this.jdField_a_of_type_AndroidViewViewGroup.requestDisallowInterceptTouchEvent(true);
            break label198;
          }
        }
        this.jdField_c_of_type_Boolean = false;
      }
      else if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_c_of_type_Boolean = false;
      }
      else if ((this.jdField_b_of_type_Boolean) || (!a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY() - localView.getBottom())))
      {
        this.jdField_c_of_type_Boolean = true;
      }
      label198:
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    label204:
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Intent localIntent = new Intent("action_folder_destroy");
    localIntent.putExtra("stay_time", System.currentTimeMillis() - this.jdField_c_of_type_Long);
    sendBroadcast(localIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    Object localObject = new Intent("action_folder_set_read");
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      ((Intent)localObject).putExtra("uin", ((RecentShopParcel)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
    }
    sendBroadcast((Intent)localObject);
    localObject = null;
    if ((getAppRuntime() instanceof QQAppInterface)) {
      localObject = (QQAppInterface)getAppRuntime();
    }
    PublicAccountEventReport.a((QQAppInterface)localObject, "9970", 1, 4, System.currentTimeMillis() - this.d);
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    paramBundle = paramBundle.getBundle("bundle");
    a(paramBundle);
    getIntent().putExtra("bundle", paramBundle);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.d = System.currentTimeMillis();
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    paramBundle.putBundle("bundle", getIntent().getBundleExtra("bundle"));
  }
  
  public WebViewFragment getFragmentByTabBarData(WebViewTabBarData paramWebViewTabBarData)
  {
    if (this.jdField_a_of_type_Boolean) {
      return super.getFragmentByTabBarData(paramWebViewTabBarData);
    }
    return WebViewFragmentBuilder.a(this, paramWebViewTabBarData, super.getIntent());
  }
  
  public boolean isWrapContent()
  {
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (paramBundle != null) {
      getIntent().putExtras(paramBundle);
    }
    super.onCreate(paramBundle);
    a(getIntent().getBundleExtra("bundle"));
    this.jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  public void onRightIconMenuHide(View paramView)
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    this.jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity
 * JD-Core Version:    0.7.0.1
 */