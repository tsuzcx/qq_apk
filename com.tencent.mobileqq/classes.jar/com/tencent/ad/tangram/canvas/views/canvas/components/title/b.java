package com.tencent.ad.tangram.canvas.views.canvas.components.title;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.canvas.views.AdViewStatus;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasViewListener;
import com.tencent.ad.tangram.canvas.views.xijing.AdTextData;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;
import java.lang.ref.WeakReference;

public class b
  extends AdCanvasComponentView
{
  private static final int DEFAULT_TEXT_PADDING = 10;
  private static final String TAG = "AdCanvasTitleComponentView";
  private a value;
  
  public b(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference, a parama)
  {
    super(paramContext, paramWeakReference);
    init(paramContext, parama);
  }
  
  private void init(Context paramContext, a parama)
  {
    if ((paramContext == null) || (parama == null) || (!parama.isValid())) {
      return;
    }
    this.value = parama;
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    Object localObject = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject).leftMargin = this.value.marginLeft;
    ((FrameLayout.LayoutParams)localObject).rightMargin = this.value.marginRight;
    ((FrameLayout.LayoutParams)localObject).topMargin = this.value.marginTop;
    ((FrameLayout.LayoutParams)localObject).bottomMargin = this.value.marginBottom;
    localRelativeLayout.setBackgroundColor(this.value.backgroundColor);
    addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setText(parama.adTextData.text);
    ((TextView)localObject).setTextSize(parama.adTextData.size);
    ((TextView)localObject).setTextColor(parama.adTextData.color);
    ((TextView)localObject).setGravity(parama.textAlignGravity);
    if (parama.adTextData.weight.equals("bold")) {
      ((TextView)localObject).getPaint().setFakeBoldText(true);
    }
    setDecorationType(paramContext, localRelativeLayout, this.value, (TextView)localObject);
  }
  
  private void setDecorationType(Context paramContext, RelativeLayout paramRelativeLayout, a parama, TextView paramTextView)
  {
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(parama.justifyContent);
    Object localObject2 = parama.titleDecorationType;
    label84:
    int i;
    switch (((String)localObject2).hashCode())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AdLog.e("AdCanvasTitleComponentView", "type error");
        return;
        if (!((String)localObject2).equals("title-normal")) {
          break label84;
        }
        i = 0;
        continue;
        if (!((String)localObject2).equals("title-underline")) {
          break label84;
        }
        i = 1;
        continue;
        if (!((String)localObject2).equals("left-underline")) {
          break label84;
        }
        i = 2;
        continue;
        if (!((String)localObject2).equals("left-bg")) {
          break label84;
        }
        i = 3;
        continue;
        if (!((String)localObject2).equals("left")) {
          break label84;
        }
        i = 4;
      }
    }
    setTextViewPadding(paramTextView, parama.textAlignGravity, null);
    paramRelativeLayout.addView(paramTextView, (ViewGroup.LayoutParams)localObject1);
    return;
    localObject2 = new LinearLayout(paramContext);
    ((LinearLayout)localObject2).setId(4660);
    ((LinearLayout)localObject2).setOrientation(1);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(parama.justifyContent);
    paramRelativeLayout.addView((View)localObject2, localLayoutParams);
    ((LinearLayout)localObject2).addView(paramTextView, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(paramContext);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, AdUIUtils.dp2px(2.0F, paramContext.getResources()));
    ((RelativeLayout)localObject1).setBackgroundColor(parama.decoration);
    setTextViewPadding(paramTextView, parama.textAlignGravity, localLayoutParams);
    ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
    paramTextView = new RelativeLayout(paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, AdUIUtils.dp2px(2.0F, paramContext.getResources()));
    paramContext.addRule(3, ((LinearLayout)localObject2).getId());
    if ("left-underline".equals(parama.titleDecorationType)) {
      paramTextView.setBackgroundColor(parama.backgroundColor);
    }
    for (;;)
    {
      paramRelativeLayout.addView(paramTextView, paramContext);
      return;
      paramTextView.setBackgroundColor(Color.parseColor("#eeeeee"));
    }
    localObject2 = new LinearLayout(paramContext);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(parama.justifyContent);
    paramRelativeLayout.addView((View)localObject2, localLayoutParams);
    paramRelativeLayout = new RelativeLayout(paramContext);
    paramContext = new RelativeLayout.LayoutParams(AdUIUtils.dp2px(4.0F, paramContext.getResources()), -1);
    paramRelativeLayout.setBackgroundColor(parama.decoration);
    ((LinearLayout)localObject2).addView(paramRelativeLayout, paramContext);
    setTextViewPadding(paramTextView, parama.textAlignGravity, null);
    ((LinearLayout)localObject2).addView(paramTextView, (ViewGroup.LayoutParams)localObject1);
  }
  
  private void setTextViewPadding(TextView paramTextView, int paramInt, RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (paramInt == 8388611)
    {
      paramTextView.setPadding(10, AdUIUtils.dp2px(4.0F, getContext().getResources()), 0, AdUIUtils.dp2px(4.0F, getContext().getResources()));
      if (paramLayoutParams != null) {
        paramLayoutParams.setMargins(10, 0, 0, 0);
      }
    }
    for (;;)
    {
      paramTextView.setIncludeFontPadding(false);
      return;
      if (paramInt == 8388613)
      {
        paramTextView.setPadding(0, AdUIUtils.dp2px(4.0F, getContext().getResources()), 10, AdUIUtils.dp2px(4.0F, getContext().getResources()));
        if (paramLayoutParams != null) {
          paramLayoutParams.setMargins(10, 0, 0, 0);
        }
      }
      else
      {
        paramTextView.setPadding(0, AdUIUtils.dp2px(4.0F, getContext().getResources()), 0, AdUIUtils.dp2px(4.0F, getContext().getResources()));
      }
    }
  }
  
  public a getData()
  {
    return this.value;
  }
  
  public AdViewStatus getStatus()
  {
    return this.status;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.title.b
 * JD-Core Version:    0.7.0.1
 */