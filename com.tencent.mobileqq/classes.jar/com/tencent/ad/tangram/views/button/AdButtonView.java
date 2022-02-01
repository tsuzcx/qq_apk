package com.tencent.ad.tangram.views.button;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Keep;
import android.view.View;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.views.canvas.components.appbutton.f;
import com.tencent.ad.tangram.views.canvas.components.appbutton.f.a;
import java.lang.ref.WeakReference;

@Keep
public final class AdButtonView
  implements IAdButtonView
{
  private static final String TAG = "AdButtonView";
  private WeakReference<IAdButtonView.a> listener;
  private f view;
  
  public AdButtonView(Context paramContext, int paramInt1, int paramInt2)
  {
    f.a locala = new f.a();
    double d = paramInt1;
    Double.isNaN(d);
    locala.textSize = Double.valueOf(0.0547945205479452D * d).intValue();
    locala.leftBackgroundColor = Color.parseColor("#00CAFC");
    locala.leftTextColor = -1;
    locala.rightBackgroundColor = Color.parseColor("#E5E5E5");
    locala.rightTextColor = Color.parseColor("#B5B8C2");
    Double.isNaN(d);
    locala.borderCornerRadius = Double.valueOf(d * 0.1712328767123288D).intValue();
    this.view = new f(paramContext, locala);
  }
  
  private void notifyListener()
  {
    AdThreadManager.INSTANCE.post(new AdButtonView.1(this), 0);
  }
  
  public View getButtonView()
  {
    return this.view;
  }
  
  public void registerListener(WeakReference<IAdButtonView.a> paramWeakReference)
  {
    this.listener = paramWeakReference;
    notifyListener();
  }
  
  public void update(int paramInt1, int paramInt2)
  {
    AdLog.i("AdButtonView", String.format("updateViews status:%d progress:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (paramInt1 != 2)
    {
      switch (paramInt1)
      {
      default: 
        this.view.setText("查看详情");
        this.view.setProgress(100);
        return;
      case 9: 
        this.view.setText("立即打开");
        this.view.setProgress(100);
        return;
      case 8: 
        this.view.setText("立即安装");
        this.view.setProgress(100);
        return;
      case 7: 
        this.view.setText("继续下载");
        this.view.setProgress(paramInt2);
        return;
      case 6: 
        f localf = this.view;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("已下载 ");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("%");
        localf.setText(localStringBuilder.toString());
        this.view.setProgress(paramInt2);
        return;
      }
      this.view.setText("准备下载");
      this.view.setProgress(paramInt2);
      return;
    }
    this.view.setText("立即下载");
    this.view.setProgress(100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.button.AdButtonView
 * JD-Core Version:    0.7.0.1
 */