package androidx.core.app;

import android.app.Activity;
import android.os.Build.VERSION;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FrameMetricsAggregator
{
  public static final int ANIMATION_DURATION = 256;
  public static final int ANIMATION_INDEX = 8;
  public static final int COMMAND_DURATION = 32;
  public static final int COMMAND_INDEX = 5;
  public static final int DELAY_DURATION = 128;
  public static final int DELAY_INDEX = 7;
  public static final int DRAW_DURATION = 8;
  public static final int DRAW_INDEX = 3;
  public static final int EVERY_DURATION = 511;
  public static final int INPUT_DURATION = 2;
  public static final int INPUT_INDEX = 1;
  private static final int LAST_INDEX = 8;
  public static final int LAYOUT_MEASURE_DURATION = 4;
  public static final int LAYOUT_MEASURE_INDEX = 2;
  public static final int SWAP_DURATION = 64;
  public static final int SWAP_INDEX = 6;
  public static final int SYNC_DURATION = 16;
  public static final int SYNC_INDEX = 4;
  public static final int TOTAL_DURATION = 1;
  public static final int TOTAL_INDEX = 0;
  private FrameMetricsAggregator.FrameMetricsBaseImpl mInstance;
  
  public FrameMetricsAggregator()
  {
    this(1);
  }
  
  public FrameMetricsAggregator(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.mInstance = new FrameMetricsAggregator.FrameMetricsApi24Impl(paramInt);
      return;
    }
    this.mInstance = new FrameMetricsAggregator.FrameMetricsBaseImpl();
  }
  
  public void add(@NonNull Activity paramActivity)
  {
    this.mInstance.add(paramActivity);
  }
  
  @Nullable
  public SparseIntArray[] getMetrics()
  {
    return this.mInstance.getMetrics();
  }
  
  @Nullable
  public SparseIntArray[] remove(@NonNull Activity paramActivity)
  {
    return this.mInstance.remove(paramActivity);
  }
  
  @Nullable
  public SparseIntArray[] reset()
  {
    return this.mInstance.reset();
  }
  
  @Nullable
  public SparseIntArray[] stop()
  {
    return this.mInstance.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.FrameMetricsAggregator
 * JD-Core Version:    0.7.0.1
 */