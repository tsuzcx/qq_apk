package com.tencent.mobileqq.beancurd;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.mobileqq.data.MessageForBeancurd;
import com.tencent.mobileqq.gamecenter.ui.CornerImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ImageBeancurdView
  extends TextBeancurdView
{
  private CornerImageView j;
  private CornerImageView k;
  private String l = "#80000000";
  private String m = "#00000000";
  
  public ImageBeancurdView(Context paramContext, View paramView)
  {
    super(paramContext, paramView);
    a();
  }
  
  private void c(MessageForBeancurd paramMessageForBeancurd)
  {
    Object localObject = paramMessageForBeancurd.getBackground();
    if (!URLUtil.isHttpsUrl((String)localObject))
    {
      if (QLog.isColorLevel())
      {
        paramMessageForBeancurd = new StringBuilder();
        paramMessageForBeancurd.append("background is not web url : ");
        paramMessageForBeancurd.append((String)localObject);
        QLog.i("ImageBeancurdView", 2, paramMessageForBeancurd.toString());
      }
      return;
    }
    int i = Color.parseColor(this.l);
    int n = Color.parseColor(this.m);
    localObject = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, n });
    ((GradientDrawable)localObject).setCornerRadii(new float[] { this.c, this.c, this.c, this.c, 0.0F, 0.0F, 0.0F, 0.0F });
    this.j.setBackgroundDrawable((Drawable)localObject);
    this.j.setVisibility(0);
    if (paramMessageForBeancurd.getContentList() != null)
    {
      if (paramMessageForBeancurd.getContentList().isEmpty()) {
        return;
      }
      paramMessageForBeancurd = new GradientDrawable();
      paramMessageForBeancurd.setColor(i);
      paramMessageForBeancurd.setCornerRadius(this.c);
      this.k.setBackgroundDrawable(paramMessageForBeancurd);
      this.k.setVisibility(0);
    }
  }
  
  protected void a()
  {
    super.a();
    this.j = ((CornerImageView)this.a.findViewById(2131436452));
    this.k = ((CornerImageView)this.a.findViewById(2131436453));
  }
  
  protected void b(MessageForBeancurd paramMessageForBeancurd)
  {
    super.b(paramMessageForBeancurd);
    c(paramMessageForBeancurd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.beancurd.ImageBeancurdView
 * JD-Core Version:    0.7.0.1
 */