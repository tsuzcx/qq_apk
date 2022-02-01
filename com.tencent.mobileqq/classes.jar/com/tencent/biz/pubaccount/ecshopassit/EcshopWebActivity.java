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
  ViewGroup a;
  public List<RecentShopParcel> b;
  public String c;
  public String d;
  public long e;
  boolean f = false;
  public long g;
  boolean h;
  long i;
  Map<Rect, Boolean> j = new HashMap();
  boolean k = false;
  private long l = 0L;
  
  public EcshopWebActivity()
  {
    this.mFragmentClass = ShopWebViewFragment.class;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.j.entrySet().iterator();
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
      if ((paramBoolean) && (this.j.containsKey(paramRect))) {
        this.j.remove(paramRect);
      }
      Iterator localIterator = this.j.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Rect localRect = (Rect)((Map.Entry)localIterator.next()).getKey();
        if ((localRect.left == paramRect.left) && (localRect.top == paramRect.top)) {
          this.j.remove(localRect);
        }
      }
      this.j.put(paramRect, Boolean.valueOf(paramBoolean));
    }
  }
  
  void a(Bundle paramBundle)
  {
    this.b = paramBundle.getParcelableArrayList("datas");
    this.c = paramBundle.getString("ad_logo");
    this.d = paramBundle.getString("ad_jump");
    this.e = paramBundle.getLong("ad_id", 0L);
    this.g = paramBundle.getLong("latest_time", 0L);
    this.f = paramBundle.getBoolean("is_tab_show", false);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        if (((List)localObject).isEmpty()) {
          return;
        }
        localObject = new Intent("action_shop_set_read");
        ((Intent)localObject).putExtra("uin", paramString);
        ((Intent)localObject).putExtra("needDelete", false);
        sendBroadcast((Intent)localObject);
        localObject = this.b.iterator();
        while (((Iterator)localObject).hasNext())
        {
          RecentShopParcel localRecentShopParcel = (RecentShopParcel)((Iterator)localObject).next();
          if (paramString.equals(localRecentShopParcel.a)) {
            localRecentShopParcel.g = 0;
          }
        }
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    int m = paramMotionEvent.getAction();
    boolean bool;
    if (this.a == null)
    {
      this.a = ((ViewGroup)findViewById(2131450099));
      if (this.a == null) {
        this.a = ((ViewGroup)findViewById(2131431345));
      }
      if (this.a == null)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        break label204;
      }
    }
    View localView = findViewById(2131444897);
    if (localView == null)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    else
    {
      if (m != 0)
      {
        if (m != 1) {
          if (m != 2)
          {
            if (m != 3) {
              break label198;
            }
          }
          else
          {
            if (!this.k) {
              break label198;
            }
            this.a.requestDisallowInterceptTouchEvent(true);
            break label198;
          }
        }
        this.k = false;
      }
      else if ((!this.f) && (!this.h))
      {
        this.k = false;
      }
      else if ((this.h) || (!a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY() - localView.getBottom())))
      {
        this.k = true;
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
    localIntent.putExtra("stay_time", System.currentTimeMillis() - this.i);
    sendBroadcast(localIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    Object localObject = new Intent("action_folder_set_read");
    if (!this.b.isEmpty()) {
      ((Intent)localObject).putExtra("uin", ((RecentShopParcel)this.b.get(0)).a);
    }
    sendBroadcast((Intent)localObject);
    localObject = null;
    if ((getAppRuntime() instanceof QQAppInterface)) {
      localObject = (QQAppInterface)getAppRuntime();
    }
    PublicAccountEventReport.a((QQAppInterface)localObject, "9970", 1, 4, System.currentTimeMillis() - this.l);
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
    this.l = System.currentTimeMillis();
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    paramBundle.putBundle("bundle", getIntent().getBundleExtra("bundle"));
  }
  
  public WebViewFragment getFragmentByTabBarData(WebViewTabBarData paramWebViewTabBarData)
  {
    if (this.f) {
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
    this.i = System.currentTimeMillis();
  }
  
  public void onRightIconMenuHide(View paramView)
  {
    this.h = false;
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    this.h = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity
 * JD-Core Version:    0.7.0.1
 */