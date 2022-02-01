package com.tencent.ad.tangram.views.canvas.components.title;

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
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.AdViewStatus;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener;
import com.tencent.ad.tangram.views.xijing.AdTextData;
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
    if ((paramContext != null) && (parama != null))
    {
      if (!parama.isValid()) {
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
  }
  
  private void setDecorationType(Context paramContext, RelativeLayout paramRelativeLayout, a parama, TextView paramTextView)
  {
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(parama.justifyContent);
    Object localObject2 = parama.titleDecorationType;
    switch (((String)localObject2).hashCode())
    {
    default: 
      break;
    case 530693527: 
      if (((String)localObject2).equals("title-underline")) {
        i = 1;
      }
      break;
    case 55395275: 
      if (((String)localObject2).equals("left-bg")) {
        i = 3;
      }
      break;
    case 3317767: 
      if (((String)localObject2).equals("left")) {
        i = 4;
      }
      break;
    case -691523076: 
      if (((String)localObject2).equals("title-normal")) {
        i = 0;
      }
      break;
    case -1621218170: 
      if (((String)localObject2).equals("left-underline")) {
        i = 2;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if ((i != 1) && (i != 2))
      {
        if ((i != 3) && (i != 4))
        {
          AdLog.e("AdCanvasTitleComponentView", "type error");
          return;
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
        return;
      }
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
      } else {
        paramTextView.setBackgroundColor(Color.parseColor("#eeeeee"));
      }
      paramRelativeLayout.addView(paramTextView, paramContext);
      return;
    }
    setTextViewPadding(paramTextView, parama.textAlignGravity, null);
    paramRelativeLayout.addView(paramTextView, (ViewGroup.LayoutParams)localObject1);
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
    else if (paramInt == 8388613)
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
    paramTextView.setIncludeFontPadding(false);
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
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.title.b
 * JD-Core Version:    0.7.0.1
 */