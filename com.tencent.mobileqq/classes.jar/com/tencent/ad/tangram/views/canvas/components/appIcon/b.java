package com.tencent.ad.tangram.views.canvas.components.appIcon;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
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
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.views.canvas.components.appbutton.c;
import com.tencent.ad.tangram.views.canvas.components.appbutton.d;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener;
import java.lang.ref.WeakReference;

public class b
  extends AdCanvasComponentView
  implements AdImageViewAdapter.Callback
{
  private static final int DOWNLOAD_BUTTON_TOP_MARGIN = 14;
  private static final String TAG = "GdtCanvasAppIconComponentView";
  private d adCanvasAppBtnComponentView;
  private View imageView;
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
      Object localObject1 = new FrameLayout.LayoutParams(-1, -2);
      addView(localRelativeLayout);
      ((FrameLayout.LayoutParams)localObject1).leftMargin = this.value.marginLeft;
      ((FrameLayout.LayoutParams)localObject1).topMargin = this.value.marginTop;
      ((FrameLayout.LayoutParams)localObject1).rightMargin = this.value.marginRight;
      ((FrameLayout.LayoutParams)localObject1).bottomMargin = this.value.marginBottom;
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localRelativeLayout.setGravity(15);
      localObject1 = new AdImageViewAdapter.Params();
      ((AdImageViewAdapter.Params)localObject1).context = new WeakReference(paramContext);
      ((AdImageViewAdapter.Params)localObject1).url = this.value.logoUrl;
      ((AdImageViewAdapter.Params)localObject1).callback = new WeakReference(this);
      this.imageView = AdImageViewBuilder.buildImageView((AdImageViewAdapter.Params)localObject1);
      localObject1 = this.imageView;
      if (localObject1 == null)
      {
        AdLog.e("GdtCanvasAppIconComponentView", "buildImageView Failed");
        stopLoad(false);
        return;
      }
      ((View)localObject1).setId(4369);
      localRelativeLayout.addView(this.imageView);
      localObject1 = this.imageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = this.value.logoWidth;
      ((ViewGroup.LayoutParams)localObject1).height = this.value.logoHeight;
      this.imageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new TextView(paramContext);
      ((TextView)localObject1).setId(8738);
      ((TextView)localObject1).setText(parama.name);
      ((TextView)localObject1).setTextSize(20.0F);
      ((TextView)localObject1).setMaxLines(1);
      ((TextView)localObject1).setTextColor(Color.parseColor("#000000"));
      ((TextView)localObject1).setMaxWidth(AdUIUtils.dp2px(170.0F, paramContext.getResources()));
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject1).getPaint().setFakeBoldText(true);
      localRelativeLayout.addView((View)localObject1);
      Object localObject2 = (RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, this.imageView.getId());
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = AdUIUtils.dp2px(15.0F, paramContext.getResources());
      ((RelativeLayout.LayoutParams)localObject2).topMargin = AdUIUtils.dp2px(10.0F, paramContext.getResources());
      localObject2 = new TextView(paramContext);
      String str = AdUIUtils.formatNumberToChineseUnit(parama.downloadCount);
      ((TextView)localObject2).setId(13107);
      ((TextView)localObject2).setTextColor(Color.parseColor("#8C8C8C"));
      ((TextView)localObject2).setMaxLines(1);
      ((TextView)localObject2).setMaxWidth(AdUIUtils.dp2px(170.0F, paramContext.getResources()));
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(parama.starCount);
      localStringBuilder.append("分 ");
      localStringBuilder.append(str);
      localStringBuilder.append(" ");
      localStringBuilder.append(AdUIUtils.getFileSizeDesc(parama.fileSize));
      ((TextView)localObject2).setText(localStringBuilder.toString());
      ((TextView)localObject2).setTextSize(12.0F);
      localRelativeLayout.addView((View)localObject2);
      localObject2 = (RelativeLayout.LayoutParams)((TextView)localObject2).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, this.imageView.getId());
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((TextView)localObject1).getId());
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = AdUIUtils.dp2px(15.0F, paramContext.getResources());
      ((RelativeLayout.LayoutParams)localObject2).topMargin = AdUIUtils.dp2px(5.0F, paramContext.getResources());
      localObject1 = new RelativeLayout(paramContext);
      ((RelativeLayout)localObject1).setId(17476);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = AdUIUtils.dp2px(14.0F, paramContext.getResources());
      ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15, -1);
      parama.adCanvasAppBtnComponentData.canShowProgress = true;
      this.adCanvasAppBtnComponentView = new d(paramContext, this.canvasViewListener, parama.adCanvasAppBtnComponentData, true);
      paramContext = new RelativeLayout.LayoutParams(this.value.adCanvasAppBtnComponentData.width, this.value.adCanvasAppBtnComponentData.height);
      ((RelativeLayout)localObject1).addView(this.adCanvasAppBtnComponentView, paramContext);
      localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
  }
  
  public AdCanvasComponentData getData()
  {
    return this.value;
  }
  
  public AdViewStatus getStatus()
  {
    return this.status;
  }
  
  public void onStopLoad(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.appIcon.b
 * JD-Core Version:    0.7.0.1
 */