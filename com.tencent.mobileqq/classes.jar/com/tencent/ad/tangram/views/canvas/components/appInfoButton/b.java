package com.tencent.ad.tangram.views.canvas.components.appInfoButton;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.image.AdImageViewAdapter.Callback;
import com.tencent.ad.tangram.image.AdImageViewAdapter.Params;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.AdViewStatus;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.views.canvas.components.appbutton.d;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener;
import java.lang.ref.WeakReference;

public class b
  extends AdCanvasComponentView
  implements AdImageViewAdapter.Callback
{
  private static final String TAG = "GdtCanvasAppInfoButtonComponentView";
  private a data;
  private d gdtCanvasAppBtnComponentView;
  private View imageView;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public b(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public b(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference, a parama, boolean paramBoolean)
  {
    super(paramContext, paramWeakReference);
    init(paramContext, paramWeakReference, parama, paramBoolean);
  }
  
  private void init(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference, a parama, boolean paramBoolean)
  {
    startLoad();
    if ((parama != null) && (getResources() != null))
    {
      this.data = parama;
      setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
      setPadding(getData().paddingLeft, getData().paddingTop, getData().paddingRight, getData().paddingBottom);
      Object localObject2 = new RelativeLayout(paramContext);
      addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -2));
      Object localObject1 = new RelativeLayout(paramContext);
      Object localObject3 = new FrameLayout.LayoutParams(-1, -2);
      ((RelativeLayout)localObject1).setBackgroundColor(parama.backgroundColor);
      int i = AdUIUtils.dp2px(12.0F, paramContext.getResources());
      ((FrameLayout.LayoutParams)localObject3).rightMargin = i;
      ((FrameLayout.LayoutParams)localObject3).leftMargin = i;
      ((FrameLayout.LayoutParams)localObject3).bottomMargin = i;
      ((FrameLayout.LayoutParams)localObject3).topMargin = AdUIUtils.dp2px(40.0F, paramContext.getResources());
      ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      parama = new RelativeLayout(paramContext);
      parama.setId(1365);
      localObject3 = new RelativeLayout.LayoutParams(AdUIUtils.dp2px(82.0F, paramContext.getResources()), AdUIUtils.dp2px(82.0F, paramContext.getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AdUIUtils.dp2px(10.0F, paramContext.getResources());
      ((RelativeLayout)localObject2).addView(parama, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new AdImageViewAdapter.Params();
      ((AdImageViewAdapter.Params)localObject2).context = new WeakReference(getContext());
      ((AdImageViewAdapter.Params)localObject2).url = this.data.logoUrl;
      ((AdImageViewAdapter.Params)localObject2).callback = new WeakReference(this);
      this.imageView = AdImageViewBuilder.buildImageView((AdImageViewAdapter.Params)localObject2);
      localObject2 = this.imageView;
      if (localObject2 == null)
      {
        AdLog.e("GdtCanvasAppInfoButtonComponentView", "build image failed");
        stopLoad(false);
        return;
      }
      parama.addView((View)localObject2);
      Object localObject4 = new TextView(paramContext);
      ((TextView)localObject4).setId(2457);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = AdUIUtils.dp2px(60.0F, paramContext.getResources());
      ((RelativeLayout.LayoutParams)localObject2).addRule(14);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, parama.getId());
      ((TextView)localObject4).setMaxWidth(AdUIUtils.dp2px(310.0F, paramContext.getResources()));
      ((TextView)localObject4).setText(this.data.appName);
      ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject4).setTextColor(-16777216);
      ((TextView)localObject4).setTextSize(16.0F);
      ((TextView)localObject4).setTypeface(Typeface.DEFAULT_BOLD);
      ((RelativeLayout)localObject1).addView((View)localObject4, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new TextView(paramContext);
      ((TextView)localObject2).setId(1910);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      ((RelativeLayout.LayoutParams)localObject3).addRule(3, ((TextView)localObject4).getId());
      ((TextView)localObject2).setMaxWidth(AdUIUtils.dp2px(120.0F, paramContext.getResources()));
      localObject4 = AdUIUtils.formatNumberToChineseUnit(this.data.downloadCount);
      parama = AdUIUtils.getFileSizeDesc(this.data.fileSize);
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject4);
        localStringBuilder.append(" ");
        localStringBuilder.append(parama);
        parama = localStringBuilder.toString();
      }
      ((TextView)localObject2).setText(parama);
      ((TextView)localObject2).setMaxLines(1);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject2).setTextColor(Color.parseColor("#cccccc"));
      ((TextView)localObject2).setTextSize(12.0F);
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      parama = new TextView(paramContext);
      parama.setId(1911);
      localObject3 = new RelativeLayout.LayoutParams(-1, -2);
      i = AdUIUtils.dp2px(20.0F, paramContext.getResources());
      ((RelativeLayout.LayoutParams)localObject3).rightMargin = i;
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = i;
      i = AdUIUtils.dp2px(5.0F, paramContext.getResources());
      ((RelativeLayout.LayoutParams)localObject3).topMargin = i;
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = i;
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      ((RelativeLayout.LayoutParams)localObject3).addRule(3, ((TextView)localObject2).getId());
      parama.setMaxWidth(AdUIUtils.dp2px(310.0F, paramContext.getResources()));
      parama.setMaxLines(3);
      parama.setTextColor(-16777216);
      parama.setTextSize(14.0F);
      parama.setText(this.data.desc);
      parama.setEllipsize(TextUtils.TruncateAt.END);
      ((RelativeLayout)localObject1).addView(parama, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new RelativeLayout(paramContext);
      localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(3, parama.getId());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      parama = new RelativeLayout(paramContext);
      parama.setId(1638);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = AdUIUtils.dp2px(10.0F, paramContext.getResources());
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = AdUIUtils.dp2px(10.0F, paramContext.getResources());
      ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
      ((RelativeLayout)localObject2).addView(parama, (ViewGroup.LayoutParams)localObject1);
      this.gdtCanvasAppBtnComponentView = new d(paramContext, paramWeakReference, this.data, true);
      paramContext = new RelativeLayout.LayoutParams(this.data.width, this.data.height);
      parama.addView(this.gdtCanvasAppBtnComponentView, paramContext);
      return;
    }
    AdLog.e("GdtCanvasAppInfoButtonComponentView", "init error");
    stopLoad(false);
  }
  
  public a getData()
  {
    return this.data;
  }
  
  public AdViewStatus getStatus()
  {
    return this.status;
  }
  
  public void onStopLoad(boolean paramBoolean)
  {
    stopLoad(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.appInfoButton.b
 * JD-Core Version:    0.7.0.1
 */