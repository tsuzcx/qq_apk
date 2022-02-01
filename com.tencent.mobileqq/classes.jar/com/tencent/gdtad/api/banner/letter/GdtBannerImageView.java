package com.tencent.gdtad.api.banner.letter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.image.GdtDrawableLoader;
import com.tencent.gdtad.views.image.GdtDrawableLoader.Listener;
import com.tencent.image.URLImageView;
import java.lang.ref.WeakReference;

class GdtBannerImageView
  extends LinearLayout
{
  private GdtDrawableLoader.Listener jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader$Listener = new GdtBannerImageView.1(this);
  private GdtDrawableLoader jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader;
  
  public GdtBannerImageView(Context paramContext, String paramString)
  {
    super(paramContext);
    setGravity(17);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setStroke(1, Color.parseColor("#EFEFEF"));
    if (Build.VERSION.SDK_INT >= 16) {
      setBackground(localGradientDrawable);
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
    {
      GdtLog.d("GdtBannerImageView", "constructor");
      return;
    }
    paramContext = new URLImageView(paramContext);
    addView(paramContext);
    this.jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader = new GdtDrawableLoader(paramString, new WeakReference(this.jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader$Listener));
    this.jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader.a();
    paramContext.setImageDrawable(this.jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.letter.GdtBannerImageView
 * JD-Core Version:    0.7.0.1
 */