package com.google.android.exoplayer2.ext.mediaplayer;

import android.util.Log;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DefaultAllocator;

public class QLoadControl
  extends DefaultLoadControl
{
  public static final String LOG_TAG = "QLoadControl";
  private static int sBufferForPlaybackMs = 2500;
  private static int sBufferForPlaybackRebufferMs = 5000;
  private static int sBufferSegmentSize = 65536;
  private static int sMaxBufferMs;
  private static int sMinBufferMs = 15000;
  
  static
  {
    sMaxBufferMs = 30000;
  }
  
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
    Log.v("QLoadControl", "updateConfig with config " + paramConfig);
  }
  
  static void updateConfig(String paramString)
  {
    Log.v("QLoadControl", "updateConfig configStr=" + paramString);
    String[] arrayOfString = paramString.split(",");
    QLoadControl.Config localConfig = new QLoadControl.Config();
    try
    {
      if (arrayOfString.length > 0) {
        QLoadControl.Config.access$002(localConfig, Integer.parseInt(arrayOfString[0]));
      }
      if (arrayOfString.length > 1) {
        QLoadControl.Config.access$102(localConfig, Integer.parseInt(arrayOfString[1]));
      }
      if (arrayOfString.length > 2) {
        QLoadControl.Config.access$202(localConfig, Integer.parseInt(arrayOfString[2]));
      }
      if (arrayOfString.length > 3) {
        QLoadControl.Config.access$302(localConfig, Integer.parseInt(arrayOfString[3]));
      }
      if (arrayOfString.length > 4) {
        QLoadControl.Config.access$402(localConfig, Integer.parseInt(arrayOfString[4]));
      }
      updateConfig(localConfig);
      return;
    }
    catch (Exception localException)
    {
      Log.v("QLoadControl", "invalid qloadcontrol configStr=" + paramString);
    }
  }
  
  public int calculateTargetBufferSize(Renderer[] paramArrayOfRenderer, TrackSelectionArray paramTrackSelectionArray)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.QLoadControl
 * JD-Core Version:    0.7.0.1
 */