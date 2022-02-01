package com.tencent.ad.tangram.views.floattips;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.image.AdImageViewAdapter.Callback;
import com.tencent.ad.tangram.image.AdImageViewAdapter.Params;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;
import java.lang.ref.WeakReference;

public final class a
  extends LinearLayout
  implements AdImageViewAdapter.Callback
{
  public static final String TAG = "a";
  
  protected a(Context paramContext, AdFloatTipsViewContainer.Params paramParams)
  {
    super(paramContext);
    init(paramParams);
  }
  
  private void init(AdFloatTipsViewContainer.Params paramParams)
  {
    AdLog.i(TAG, "[init]");
    setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    setBackgroundColor(paramParams.backgroundColor);
    setGravity(16);
    initChildViews(paramParams);
  }
  
  private void initChildViews(AdFloatTipsViewContainer.Params paramParams)
  {
    AdLog.i(TAG, "[initChildViews]");
    if (TextUtils.isEmpty(paramParams.iconUrl))
    {
      localObject = new View(getContext());
    }
    else
    {
      localObject = new AdImageViewAdapter.Params();
      ((AdImageViewAdapter.Params)localObject).callback = new WeakReference(this);
      ((AdImageViewAdapter.Params)localObject).context = new WeakReference(getContext());
      ((AdImageViewAdapter.Params)localObject).url = paramParams.iconUrl;
      View localView = AdImageViewBuilder.buildImageView((AdImageViewAdapter.Params)localObject);
      localObject = localView;
      if ((localView instanceof ImageView))
      {
        ((ImageView)localView).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localObject = localView;
      }
    }
    int i = paramParams.iconSize;
    ((View)localObject).setLayoutParams(new LinearLayout.LayoutParams(i, i));
    addView((View)localObject);
    Object localObject = new View(getContext());
    ((View)localObject).setLayoutParams(new LinearLayout.LayoutParams(AdUIUtils.dp2px(1.5F, getResources()), -1));
    addView((View)localObject);
    localObject = new TextView(getContext());
    ((TextView)localObject).setTextColor(paramParams.textColor);
    ((TextView)localObject).setText(paramParams.text);
    ((TextView)localObject).setTextSize(0, paramParams.textSize);
    ((TextView)localObject).setIncludeFontPadding(false);
    ((TextView)localObject).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    addView((View)localObject);
  }
  
  public void onStopLoad(boolean paramBoolean)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onStopLoad] isSuccess=");
    localStringBuilder.append(paramBoolean);
    AdLog.i(str, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.floattips.a
 * JD-Core Version:    0.7.0.1
 */