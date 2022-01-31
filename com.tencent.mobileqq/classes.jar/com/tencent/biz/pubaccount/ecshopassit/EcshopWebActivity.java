package com.tencent.biz.pubaccount.ecshopassit;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewFragmentBuilder;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
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
  public List a;
  Map jdField_a_of_type_JavaUtilMap = new HashMap();
  boolean jdField_a_of_type_Boolean = false;
  public long b;
  public String b;
  boolean b;
  long jdField_c_of_type_Long;
  boolean jdField_c_of_type_Boolean = false;
  
  public EcshopWebActivity()
  {
    this.jdField_a_of_type_JavaLangClass = ShopWebViewFragment.class;
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
  
  public WebViewFragment a(WebViewTabBarData paramWebViewTabBarData)
  {
    if (this.jdField_a_of_type_Boolean) {
      return super.a(paramWebViewTabBarData);
    }
    return WebViewFragmentBuilder.a(this, paramWebViewTabBarData, super.getIntent());
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
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {}
    for (;;)
    {
      return;
      Object localObject = new Intent("action_shop_set_read");
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
  
  public void b(View paramView)
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (this.jdField_a_of_type_AndroidViewViewGroup == null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131366769));
      if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
        this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131362369));
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
    }
    View localView = findViewById(2131363244);
    if (localView == null) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    switch (i)
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_c_of_type_Boolean = false;
      }
      else if ((this.jdField_b_of_type_Boolean) || (!a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY() - localView.getBottom())))
      {
        this.jdField_c_of_type_Boolean = true;
        continue;
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidViewViewGroup.requestDisallowInterceptTouchEvent(true);
          continue;
          this.jdField_c_of_type_Boolean = false;
        }
      }
    }
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
    Intent localIntent = new Intent("action_folder_set_read");
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      localIntent.putExtra("uin", ((RecentShopParcel)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
    }
    sendBroadcast(localIntent);
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    paramBundle = paramBundle.getBundle("bundle");
    a(paramBundle);
    getIntent().putExtra("bundle", paramBundle);
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    paramBundle.putBundle("bundle", getIntent().getBundleExtra("bundle"));
  }
  
  public boolean isWrapContent()
  {
    return true;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity
 * JD-Core Version:    0.7.0.1
 */