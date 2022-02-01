package com.tencent.ad.tangram.views.canvas.components;

import android.content.Context;
import android.support.annotation.Keep;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.canvas.AdTimeStatistics;
import com.tencent.ad.tangram.views.AdViewStatus;
import com.tencent.ad.tangram.views.AdViewStatus.Listener;
import com.tencent.ad.tangram.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasViewListener;
import java.lang.ref.WeakReference;

@Keep
public abstract class AdCanvasComponentView
  extends FrameLayout
  implements AdViewStatus.Listener
{
  private static final String TAG = "GdtCanvasComponentView";
  protected WeakReference<AdCanvasViewListener> canvasViewListener;
  protected AdTimeStatistics loadTimeStatistics = new AdTimeStatistics();
  protected AdViewStatus status;
  
  public AdCanvasComponentView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdCanvasComponentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AdCanvasComponentView(Context paramContext, WeakReference<AdCanvasViewListener> paramWeakReference)
  {
    super(paramContext);
    this.canvasViewListener = paramWeakReference;
  }
  
  private void notifyLoaded(boolean paramBoolean)
  {
    Object localObject = this.canvasViewListener;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = this.loadTimeStatistics;
      if (localObject != null)
      {
        long l = ((AdTimeStatistics)localObject).getTime();
        if (l < 0L) {
          return;
        }
        ((AdCanvasViewListener)this.canvasViewListener.get()).onLoaded(getData(), l, paramBoolean);
        return;
      }
    }
    AdLog.e("GdtCanvasComponentView", "notifyLoaded error");
  }
  
  public boolean back()
  {
    return false;
  }
  
  public AdCanvasData getCanvasData()
  {
    WeakReference localWeakReference = this.canvasViewListener;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return ((AdCanvasViewListener)this.canvasViewListener.get()).getData();
    }
    return null;
  }
  
  public abstract AdCanvasComponentData getData();
  
  public abstract AdViewStatus getStatus();
  
  public void onActivityDestroy()
  {
    if (getStatus() != null) {
      getStatus().onActivityDestroy();
    }
  }
  
  public void onActivityPause()
  {
    if (getStatus() != null) {
      getStatus().onActivityPaused();
    }
  }
  
  public void onActivityResume()
  {
    if (getStatus() != null) {
      getStatus().onActivityResumed();
    }
  }
  
  public void onLocationChanged()
  {
    if (getStatus() != null) {
      getStatus().onLocationChanged();
    }
  }
  
  public void onViewPause()
  {
    if (getData() == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getData().id);
    localStringBuilder.append(": onViewPause");
    AdLog.i("GdtCanvasComponentView", localStringBuilder.toString());
  }
  
  public void onViewResume()
  {
    if (getData() == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getData().id);
    localStringBuilder.append(": onViewResume");
    AdLog.i("GdtCanvasComponentView", localStringBuilder.toString());
  }
  
  protected void startLoad()
  {
    AdTimeStatistics localAdTimeStatistics = this.loadTimeStatistics;
    if (localAdTimeStatistics != null) {
      localAdTimeStatistics.start();
    }
  }
  
  protected void stopLoad(boolean paramBoolean)
  {
    AdTimeStatistics localAdTimeStatistics = this.loadTimeStatistics;
    if (localAdTimeStatistics != null) {
      localAdTimeStatistics.stop();
    }
    notifyLoaded(paramBoolean);
    this.loadTimeStatistics = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentView
 * JD-Core Version:    0.7.0.1
 */