package com.tencent.luggage.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.webkit.URLUtil;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.luggage.widget.a;
import com.tencent.luggage.widget.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.ui.base.d;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/ui/WxaPreviewImageUI;", "Lcom/tencent/mm/ui/base/BaseLuggageFullScreenActivity;", "()V", "activityScope", "Lkotlinx/coroutines/CoroutineScope;", "mCurrentIndex", "", "mIndexTv", "Landroid/widget/TextView;", "mUrls", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mViewPager", "Landroidx/viewpager/widget/ViewPager;", "mViews", "Landroid/view/View;", "getLayoutId", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "requestSaveToDisk", "uri", "Landroid/net/Uri;", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class WxaPreviewImageUI
  extends d
{
  public static final WxaPreviewImageUI.a a = new WxaPreviewImageUI.a(null);
  private int b;
  private ArrayList<String> c;
  private ArrayList<View> d = new ArrayList();
  private ViewPager e;
  private TextView f;
  private final CoroutineScope g = CoroutineScopeKt.MainScope();
  
  private final void a(Uri paramUri)
  {
    if (paramUri == null) {
      return;
    }
    if (ContextCompat.checkSelfPermission((Context)this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0)
    {
      BuildersKt.launch$default(this.g, null, null, (Function2)new WxaPreviewImageUI.g(this, paramUri, null), 3, null);
      return;
    }
    Toast.makeText(getApplicationContext(), 2131889073, 0).show();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected int getLayoutId()
  {
    return 2131624036;
  }
  
  public void onBackPressed()
  {
    setResult(-1);
    finish();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  @SuppressLint({"SetTextI18n"})
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringArrayListExtra("KEY_URLS");
    if (paramBundle == null) {
      paramBundle = new ArrayList();
    }
    this.c = paramBundle;
    this.b = getIntent().getIntExtra("KEY_CURRENT_INDEX", 0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("url.size: ");
    paramBundle = this.c;
    Object localObject1 = null;
    if (paramBundle != null) {
      paramBundle = Integer.valueOf(paramBundle.size());
    } else {
      paramBundle = null;
    }
    ((StringBuilder)localObject2).append(paramBundle);
    o.d("Luggage.WxaPreviewImageUI", ((StringBuilder)localObject2).toString());
    paramBundle = this.c;
    Object localObject3;
    Object localObject4;
    if (paramBundle != null)
    {
      paramBundle = ((Iterable)paramBundle).iterator();
      while (paramBundle.hasNext())
      {
        localObject2 = (String)paramBundle.next();
        localObject3 = this.d;
        localObject4 = new c((Context)this);
        if (URLUtil.isNetworkUrl((String)localObject2)) {
          BuildersKt.launch$default(this.g, null, null, (Function2)new WxaPreviewImageUI.b((c)localObject4, null, (String)localObject2, this), 3, null);
        } else {
          ((c)localObject4).setImage(a.a((String)localObject2));
        }
        ((c)localObject4).setOnClickListener((View.OnClickListener)new WxaPreviewImageUI.c((String)localObject2, this));
        ((c)localObject4).setOnLongClickListener((View.OnLongClickListener)new WxaPreviewImageUI.d((c)localObject4, (c)localObject4, (String)localObject2, this));
        ((ArrayList)localObject3).add(localObject4);
      }
    }
    this.e = ((ViewPager)findViewById(2131449829));
    this.f = ((TextView)findViewById(2131448535));
    localObject2 = this.f;
    if (localObject2 != null)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.b + 1);
      ((StringBuilder)localObject3).append('/');
      localObject4 = this.c;
      paramBundle = localObject1;
      if (localObject4 != null) {
        paramBundle = Integer.valueOf(((ArrayList)localObject4).size());
      }
      ((StringBuilder)localObject3).append(paramBundle);
      ((TextView)localObject2).setText((CharSequence)((StringBuilder)localObject3).toString());
    }
    paramBundle = this.e;
    if (paramBundle != null) {
      paramBundle.setAdapter((PagerAdapter)new WxaPreviewImageUI.e(this));
    }
    paramBundle = this.e;
    if (paramBundle != null) {
      paramBundle.addOnPageChangeListener((ViewPager.OnPageChangeListener)new WxaPreviewImageUI.f(this));
    }
    paramBundle = this.e;
    if (paramBundle != null) {
      paramBundle.setCurrentItem(this.b, false);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ArrayList localArrayList = this.c;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    this.d.clear();
    try
    {
      CoroutineScopeKt.cancel$default(this.g, null, 1, null);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaPreviewImageUI
 * JD-Core Version:    0.7.0.1
 */