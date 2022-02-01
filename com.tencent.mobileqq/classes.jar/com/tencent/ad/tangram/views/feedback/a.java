package com.tencent.ad.tangram.views.feedback;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.image.AdImageViewAdapter.Callback;
import com.tencent.ad.tangram.image.AdImageViewAdapter.Params;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.ad.tangram.util.AdUIUtils;
import java.lang.ref.WeakReference;

class a
  extends LinearLayout
  implements AdImageViewAdapter.Callback
{
  private static final int DARK_TEXT_COLOR = Color.parseColor("#FFFFFF");
  private static final int LIGHT_TEXT_COLOR = Color.parseColor("#2B2B2B");
  public static final String TAG = "a";
  protected int index = 0;
  
  public a(Context paramContext)
  {
    this(paramContext, new a.a());
  }
  
  public a(Context paramContext, a.a parama)
  {
    super(paramContext);
    if (parama != null)
    {
      if (!parama.isValid()) {
        return;
      }
      this.index = parama.index;
      initView(parama);
      initChildView(parama);
    }
  }
  
  private void initChildView(a.a parama)
  {
    if (parama.isLandscape) {
      f = 20.0F;
    } else {
      f = 25.0F;
    }
    int j = AdUIUtils.dp2px(f, getResources());
    Object localObject1 = new AdImageViewAdapter.Params();
    ((AdImageViewAdapter.Params)localObject1).callback = new WeakReference(this);
    ((AdImageViewAdapter.Params)localObject1).context = new WeakReference(getContext());
    ((AdImageViewAdapter.Params)localObject1).url = parama.iconUrl;
    localObject1 = AdImageViewBuilder.buildImageView((AdImageViewAdapter.Params)localObject1);
    if ((localObject1 instanceof ImageView)) {
      ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
    ((View)localObject1).setLayoutParams(new LinearLayout.LayoutParams(j, j));
    addView((View)localObject1);
    localObject1 = new TextView(getContext());
    Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
    Resources localResources = getResources();
    float f = 15.0F;
    ((LinearLayout.LayoutParams)localObject2).setMargins(AdUIUtils.dp2px(15.0F, localResources), 0, 0, 0);
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    int i;
    if (parama.isDarkMode) {
      i = DARK_TEXT_COLOR;
    } else {
      i = LIGHT_TEXT_COLOR;
    }
    ((TextView)localObject1).setTextColor(i);
    ((TextView)localObject1).setText(parama.text);
    if (parama.isLandscape) {
      f = 12.0F;
    }
    ((TextView)localObject1).setTextSize(1, f);
    addView((View)localObject1);
    localObject1 = new View(getContext());
    ((View)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0F));
    addView((View)localObject1);
    if (!TextUtils.isEmpty(parama.jumpIconUrl))
    {
      localObject1 = new AdImageViewAdapter.Params();
      ((AdImageViewAdapter.Params)localObject1).callback = new WeakReference(this);
      ((AdImageViewAdapter.Params)localObject1).context = new WeakReference(getContext());
      ((AdImageViewAdapter.Params)localObject1).url = parama.jumpIconUrl;
      localObject1 = AdImageViewBuilder.buildImageView((AdImageViewAdapter.Params)localObject1);
      if ((localObject1 instanceof ImageView)) {
        ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      localObject2 = new RelativeLayout.LayoutParams(j, j);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      addView((View)localObject1);
    }
    setOnClickListener((View.OnClickListener)parama.listener.get());
  }
  
  private void initView(a.a parama)
  {
    setOrientation(0);
    setGravity(16);
    if (parama.isLandscape) {
      i = AdUIUtils.dp2px(260.0F, getResources());
    } else {
      i = -2;
    }
    setLayoutParams(new LinearLayout.LayoutParams(i, -2));
    boolean bool = parama.isLandscape;
    float f2 = 15.0F;
    if (bool) {
      f1 = 15.0F;
    } else {
      f1 = 19.0F;
    }
    int i = AdUIUtils.dp2px(f1, getResources());
    float f1 = f2;
    if (parama.isLandscape) {
      f1 = 12.0F;
    }
    int j = AdUIUtils.dp2px(f1, getResources());
    setPadding(j, i, j, i);
  }
  
  public void onStopLoad(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.feedback.a
 * JD-Core Version:    0.7.0.1
 */