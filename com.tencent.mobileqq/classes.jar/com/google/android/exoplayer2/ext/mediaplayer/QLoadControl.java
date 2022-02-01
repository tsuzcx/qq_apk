package com.google.android.exoplayer2.ext.mediaplayer;

import android.util.Log;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DefaultAllocator;

class QLoadControl
  extends DefaultLoadControl
{
  public static final String LOG_TAG = "QLoadControl";
  private static int sBufferForPlaybackMs = 2500;
  private static int sBufferForPlaybackRebufferMs = 5000;
  private static int sBufferSegmentSize = 65536;
  private static int sMaxBufferMs = 30000;
  private static int sMinBufferMs = 15000;
  
  public QLoadControl()
  {
    super(new DefaultAllocator(true, sBufferSegmentSize), sMinBufferMs, sMaxBufferMs, sBufferForPlaybackMs, sBufferForPlaybackRebufferMs, -1, true);
  }
  
  static void updateConfig(QLoadControl.Config paramConfig)
  {
    if (paramConfig == null)
    {
      Log.v("QLoadControl", "updateConfig config null");
      return;
    }
    sBufferSegmentSize = QLoadControl.Config.access$000(paramConfig);
    sMinBufferMs = QLoadControl.Config.access$100(paramConfig);
    sMaxBufferMs = QLoadControl.Config.access$200(paramConfig);
    sBufferForPlaybackMs = QLoadControl.Config.access$300(paramConfig);
    sBufferForPlaybackRebufferMs = QLoadControl.Config.access$400(paramConfig);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateConfig with config ");
    localStringBuilder.append(paramConfig);
    Log.v("QLoadControl", localStringBuilder.toString());
  }
  
  static void updateConfig(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateConfig configStr=");
    ((StringBuilder)localObject).append(paramString);
    Log.v("QLoadControl", ((StringBuilder)localObject).toString());
    localObject = paramString.split(",");
    QLoadControl.Config localConfig = new QLoadControl.Config();
    try
    {
      if (localObject.length > 0) {
        QLoadControl.Config.access$002(localConfig, Integer.parseInt(localObject[0]));
      }
      if (localObject.length > 1) {
        QLoadControl.Config.access$102(localConfig, Integer.parseInt(localObject[1]));
      }
      if (localObject.length > 2) {
        QLoadControl.Config.access$202(localConfig, Integer.parseInt(localObject[2]));
      }
      if (localObject.length > 3) {
        QLoadControl.Config.access$302(localConfig, Integer.parseInt(localObject[3]));
      }
      if (localObject.length > 4) {
        QLoadControl.Config.access$402(localConfig, Integer.parseInt(localObject[4]));
      }
      updateConfig(localConfig);
      return;
    }
    catch (Exception localException)
    {
      label135:
      break label135;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("invalid qloadcontrol configStr=");
    ((StringBuilder)localObject).append(paramString);
    Log.v("QLoadControl", ((StringBuilder)localObject).toString());
  }
  
  protected int calculateTargetBufferSize(Renderer[] paramArrayOfRenderer, TrackSelectionArray paramTrackSelectionArray)
  {
    return super.calculateTargetBufferSize(paramArrayOfRenderer, paramTrackSelectionArray);
  }
  
  public boolean shouldContinueLoading(long paramLong, float paramFloat)
  {
    return super.shouldContinueLoading(paramLong, paramFloat);
  }
  
  public boolean shouldStartPlayback(long paramLong, float paramFloat, boolean paramBoolean)
  {
    return super.shouldStartPlayback(paramLong, paramFloat, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.QLoadControl
 * JD-Core Version:    0.7.0.1
 */