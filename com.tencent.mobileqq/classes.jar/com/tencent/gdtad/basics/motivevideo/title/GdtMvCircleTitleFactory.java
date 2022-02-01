package com.tencent.gdtad.basics.motivevideo.title;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.gdtad.views.video.circle.DonutProgress;
import com.tencent.qphone.base.util.QLog;

public class GdtMvCircleTitleFactory
  implements IGdtMvTitleFactory
{
  private final String a = "GdtMvCircleTitleFactory";
  private final int b = 100;
  private final int c = 0;
  private DonutProgress d;
  private DonutProgress e;
  private ImageView f;
  private boolean g = true;
  private float h;
  private float i;
  private float j;
  private boolean k;
  private int l = 0;
  
  public GdtMvCircleTitleFactory(int paramInt)
  {
    this.l = paramInt;
  }
  
  private void a(int paramInt)
  {
    if (this.e == null)
    {
      QLog.i("GdtMvCircleTitleFactory", 1, "refreshTimeView view is null");
      return;
    }
    int i1 = (int)(this.j / this.h * 100.0F);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshTimeView mVideoPlayedMs:");
      ((StringBuilder)localObject).append(this.j);
      ((StringBuilder)localObject).append(";;;progress:");
      ((StringBuilder)localObject).append(i1);
      QLog.i("GdtMvCircleTitleFactory", 2, ((StringBuilder)localObject).toString());
    }
    int n = 0;
    int m = i1;
    if (i1 >= 100)
    {
      paramInt = 0;
      m = 100;
    }
    if (this.l == 3) {
      m = 100;
    }
    this.e.setProgress(m);
    this.e.setText(String.valueOf(paramInt));
    Object localObject = this.e;
    paramInt = n;
    if (this.l == 4) {
      paramInt = 8;
    }
    ((DonutProgress)localObject).setVisibility(paramInt);
  }
  
  private void b()
  {
    if (this.d == null)
    {
      QLog.i("GdtMvCircleTitleFactory", 1, "refreshCloseView view is null");
      return;
    }
    int m = (int)(this.j / this.i * 100.0F);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshCloseView mVideoPlayedMs:");
      localStringBuilder.append(this.j);
      localStringBuilder.append(";;;progress:");
      localStringBuilder.append(m);
      QLog.i("GdtMvCircleTitleFactory", 2, localStringBuilder.toString());
    }
    this.d.setProgress(Math.min(m, 100));
  }
  
  public void a()
  {
    this.e.setVisibility(8);
    this.d.setProgress(100.0F);
    this.f.setVisibility(8);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.g)
    {
      this.g = false;
      this.h = ((float)paramLong1);
      this.i = Math.min((float)paramLong2, this.h);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.k) {
      return;
    }
    if ((paramLong1 == 0L) && (paramLong2 == 0L) && (paramLong3 == 0L))
    {
      this.k = true;
      a();
      return;
    }
    this.j = ((float)paramLong3);
    a((int)((this.h - this.j) / 1000.0F));
    b();
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (this.f == null)
    {
      QLog.i("GdtMvCircleTitleFactory", 1, "refreshVoiceIconDrawableInner return");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshVoiceIconDrawableInner ");
    localStringBuilder.append(paramBoolean);
    QLog.i("GdtMvCircleTitleFactory", 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      paramContext = paramContext.getResources().getDrawable(2130840583);
      GdtMvTitleUtil.a(this.f, paramContext, 2131889980);
      return;
    }
    paramContext = paramContext.getResources().getDrawable(2130840584);
    GdtMvTitleUtil.a(this.f, paramContext, 2131889979);
  }
  
  public void a(ViewGroup paramViewGroup, GdtMvTitleHelper paramGdtMvTitleHelper)
  {
    paramViewGroup.addView(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624947, paramViewGroup, false));
    this.e = ((DonutProgress)paramViewGroup.findViewById(2131430732));
    this.d = ((DonutProgress)paramViewGroup.findViewById(2131430731));
    this.e.setClockWise(true);
    this.d.setClockWise(true);
    paramGdtMvTitleHelper.b = this.d;
    this.f = ((ImageView)paramViewGroup.findViewById(2131430733));
    paramGdtMvTitleHelper.a = this.f;
    paramGdtMvTitleHelper.a.setOnClickListener(paramGdtMvTitleHelper);
    paramGdtMvTitleHelper.b.setOnClickListener(paramGdtMvTitleHelper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.title.GdtMvCircleTitleFactory
 * JD-Core Version:    0.7.0.1
 */