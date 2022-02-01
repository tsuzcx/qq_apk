package com.tencent.ad.tangram.canvas.views.xijing;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;

@Keep
public class AdButtonView
  extends TextView
{
  private static final String TAG = "GdtButtonView";
  
  public AdButtonView(Context paramContext, a parama)
  {
    super(paramContext);
    init(paramContext, parama);
  }
  
  @TargetApi(16)
  private void init(Context paramContext, a parama)
  {
    if ((parama == null) || (!parama.isValid())) {
      AdLog.e("GdtButtonView", "init error");
    }
    do
    {
      return;
      setGravity(17);
      setText(parama.text.text);
      setSingleLine(true);
      setEllipsize(TextUtils.TruncateAt.END);
      int i = AdUIUtils.dp2px(2.0F, paramContext.getResources());
      setPadding(i, 0, i, 0);
      setTextSize(0, parama.text.size);
      setTextColor(parama.text.color);
      paramContext = new GradientDrawable();
      paramContext.setShape(0);
      paramContext.setCornerRadius(parama.borderCornerRadius);
      paramContext.setColor(parama.backgroundColor);
    } while (Build.VERSION.SDK_INT < 16);
    setBackground(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.xijing.AdButtonView
 * JD-Core Version:    0.7.0.1
 */