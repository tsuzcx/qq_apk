package androidx.core.app;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.Window;
import android.view.Window.OnFrameMetricsAvailableListener;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@RequiresApi(24)
class FrameMetricsAggregator$FrameMetricsApi24Impl
  extends FrameMetricsAggregator.FrameMetricsBaseImpl
{
  private static final int NANOS_PER_MS = 1000000;
  private static final int NANOS_ROUNDING_VALUE = 500000;
  private static Handler sHandler = null;
  private static HandlerThread sHandlerThread = null;
  private ArrayList<WeakReference<Activity>> mActivities = new ArrayList();
  Window.OnFrameMetricsAvailableListener mListener = new FrameMetricsAggregator.FrameMetricsApi24Impl.1(this);
  SparseIntArray[] mMetrics = new SparseIntArray[9];
  int mTrackingFlags;
  
  FrameMetricsAggregator$FrameMetricsApi24Impl(int paramInt)
  {
    this.mTrackingFlags = paramInt;
  }
  
  public void add(Activity paramActivity)
  {
    if (sHandlerThread == null)
    {
      sHandlerThread = new HandlerThread("FrameMetricsAggregator");
      sHandlerThread.start();
      sHandler = new Handler(sHandlerThread.getLooper());
    }
    int i = 0;
    while (i <= 8)
    {
      if ((this.mMetrics[i] == null) && ((this.mTrackingFlags & 1 << i) != 0)) {
        this.mMetrics[i] = new SparseIntArray();
      }
      i += 1;
    }
    paramActivity.getWindow().addOnFrameMetricsAvailableListener(this.mListener, sHandler);
    this.mActivities.add(new WeakReference(paramActivity));
  }
  
  void addDurationItem(SparseIntArray paramSparseIntArray, long paramLong)
  {
    if (paramSparseIntArray != null)
    {
      int i = (int)((500000L + paramLong) / 1000000L);
      if (paramLong >= 0L) {
        paramSparseIntArray.put(i, paramSparseIntArray.get(i) + 1);
      }
    }
  }
  
  public SparseIntArray[] getMetrics()
  {
    return this.mMetrics;
  }
  
  public SparseIntArray[] remove(Activity paramActivity)
  {
    Iterator localIterator = this.mActivities.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() == paramActivity) {
        this.mActivities.remove(localWeakReference);
      }
    }
    paramActivity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
    return this.mMetrics;
  }
  
  public SparseIntArray[] reset()
  {
    SparseIntArray[] arrayOfSparseIntArray = this.mMetrics;
    this.mMetrics = new SparseIntArray[9];
    return arrayOfSparseIntArray;
  }
  
  public SparseIntArray[] stop()
  {
    int i = this.mActivities.size() - 1;
    while (i >= 0)
    {
      WeakReference localWeakReference = (WeakReference)this.mActivities.get(i);
      Activity localActivity = (Activity)localWeakReference.get();
      if (localWeakReference.get() != null)
      {
        localActivity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
        this.mActivities.remove(i);
      }
      i -= 1;
    }
    return this.mMetrics;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl
 * JD-Core Version:    0.7.0.1
 */