package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.SlidingPercentile;

public final class DefaultBandwidthMeter
  implements BandwidthMeter, TransferListener<Object>
{
  private static final int BYTES_TRANSFERRED_FOR_ESTIMATE = 524288;
  public static final int DEFAULT_MAX_WEIGHT = 2000;
  private static final int ELAPSED_MILLIS_FOR_ESTIMATE = 2000;
  private long bitrateEstimate;
  private final Clock clock;
  private final Handler eventHandler;
  private final BandwidthMeter.EventListener eventListener;
  private long sampleBytesTransferred;
  private long sampleStartTimeMs;
  private final SlidingPercentile slidingPercentile;
  private int streamCount;
  private long totalBytesTransferred;
  private long totalElapsedTimeMs;
  
  public DefaultBandwidthMeter()
  {
    this(null, null);
  }
  
  public DefaultBandwidthMeter(Handler paramHandler, BandwidthMeter.EventListener paramEventListener)
  {
    this(paramHandler, paramEventListener, 2000);
  }
  
  public DefaultBandwidthMeter(Handler paramHandler, BandwidthMeter.EventListener paramEventListener, int paramInt)
  {
    this(paramHandler, paramEventListener, paramInt, Clock.DEFAULT);
  }
  
  public DefaultBandwidthMeter(Handler paramHandler, BandwidthMeter.EventListener paramEventListener, int paramInt, Clock paramClock)
  {
    this.eventHandler = paramHandler;
    this.eventListener = paramEventListener;
    this.slidingPercentile = new SlidingPercentile(paramInt);
    this.clock = paramClock;
    this.bitrateEstimate = -1L;
  }
  
  private void notifyBandwidthSample(int paramInt, long paramLong1, long paramLong2)
  {
    if ((this.eventHandler != null) && (this.eventListener != null)) {
      this.eventHandler.post(new DefaultBandwidthMeter.1(this, paramInt, paramLong1, paramLong2));
    }
  }
  
  public long getBitrateEstimate()
  {
    try
    {
      long l = this.bitrateEstimate;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onBytesTransferred(Object paramObject, int paramInt)
  {
    try
    {
      this.sampleBytesTransferred += paramInt;
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  /* Error */
  public void onTransferEnd(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 91	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:streamCount	I
    //   6: ifle +182 -> 188
    //   9: iconst_1
    //   10: istore 4
    //   12: iload 4
    //   14: invokestatic 97	com/google/android/exoplayer2/util/Assertions:checkState	(Z)V
    //   17: aload_0
    //   18: getfield 62	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:clock	Lcom/google/android/exoplayer2/util/Clock;
    //   21: invokeinterface 100 1 0
    //   26: lstore 7
    //   28: lload 7
    //   30: aload_0
    //   31: getfield 102	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:sampleStartTimeMs	J
    //   34: lsub
    //   35: l2i
    //   36: istore_3
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 104	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:totalElapsedTimeMs	J
    //   42: iload_3
    //   43: i2l
    //   44: ladd
    //   45: putfield 104	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:totalElapsedTimeMs	J
    //   48: aload_0
    //   49: aload_0
    //   50: getfield 106	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:totalBytesTransferred	J
    //   53: aload_0
    //   54: getfield 87	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:sampleBytesTransferred	J
    //   57: ladd
    //   58: putfield 106	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:totalBytesTransferred	J
    //   61: iload_3
    //   62: ifle +83 -> 145
    //   65: aload_0
    //   66: getfield 87	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:sampleBytesTransferred	J
    //   69: ldc2_w 107
    //   72: lmul
    //   73: iload_3
    //   74: i2l
    //   75: ldiv
    //   76: l2f
    //   77: fstore_2
    //   78: aload_0
    //   79: getfield 60	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:slidingPercentile	Lcom/google/android/exoplayer2/util/SlidingPercentile;
    //   82: aload_0
    //   83: getfield 87	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:sampleBytesTransferred	J
    //   86: l2d
    //   87: invokestatic 114	java/lang/Math:sqrt	(D)D
    //   90: d2i
    //   91: fload_2
    //   92: invokevirtual 118	com/google/android/exoplayer2/util/SlidingPercentile:addSample	(IF)V
    //   95: aload_0
    //   96: getfield 104	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:totalElapsedTimeMs	J
    //   99: ldc2_w 119
    //   102: lcmp
    //   103: ifge +14 -> 117
    //   106: aload_0
    //   107: getfield 106	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:totalBytesTransferred	J
    //   110: ldc2_w 121
    //   113: lcmp
    //   114: iflt +31 -> 145
    //   117: aload_0
    //   118: getfield 60	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:slidingPercentile	Lcom/google/android/exoplayer2/util/SlidingPercentile;
    //   121: ldc 123
    //   123: invokevirtual 127	com/google/android/exoplayer2/util/SlidingPercentile:getPercentile	(F)F
    //   126: fstore_2
    //   127: fload_2
    //   128: invokestatic 133	java/lang/Float:isNaN	(F)Z
    //   131: ifeq +63 -> 194
    //   134: ldc2_w 63
    //   137: lstore 5
    //   139: aload_0
    //   140: lload 5
    //   142: putfield 66	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:bitrateEstimate	J
    //   145: aload_0
    //   146: iload_3
    //   147: aload_0
    //   148: getfield 87	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:sampleBytesTransferred	J
    //   151: aload_0
    //   152: getfield 66	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:bitrateEstimate	J
    //   155: invokespecial 135	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:notifyBandwidthSample	(IJJ)V
    //   158: aload_0
    //   159: getfield 91	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:streamCount	I
    //   162: iconst_1
    //   163: isub
    //   164: istore_3
    //   165: aload_0
    //   166: iload_3
    //   167: putfield 91	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:streamCount	I
    //   170: iload_3
    //   171: ifle +9 -> 180
    //   174: aload_0
    //   175: lload 7
    //   177: putfield 102	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:sampleStartTimeMs	J
    //   180: aload_0
    //   181: lconst_0
    //   182: putfield 87	com/google/android/exoplayer2/upstream/DefaultBandwidthMeter:sampleBytesTransferred	J
    //   185: aload_0
    //   186: monitorexit
    //   187: return
    //   188: iconst_0
    //   189: istore 4
    //   191: goto -179 -> 12
    //   194: fload_2
    //   195: f2l
    //   196: lstore 5
    //   198: goto -59 -> 139
    //   201: astore_1
    //   202: aload_0
    //   203: monitorexit
    //   204: aload_1
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	DefaultBandwidthMeter
    //   0	206	1	paramObject	Object
    //   77	118	2	f	float
    //   36	135	3	i	int
    //   10	180	4	bool	boolean
    //   137	60	5	l1	long
    //   26	150	7	l2	long
    // Exception table:
    //   from	to	target	type
    //   2	9	201	finally
    //   12	61	201	finally
    //   65	117	201	finally
    //   117	134	201	finally
    //   139	145	201	finally
    //   145	170	201	finally
    //   174	180	201	finally
    //   180	185	201	finally
  }
  
  public void onTransferStart(Object paramObject, DataSpec paramDataSpec)
  {
    try
    {
      if (this.streamCount == 0) {
        this.sampleStartTimeMs = this.clock.elapsedRealtime();
      }
      this.streamCount += 1;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
 * JD-Core Version:    0.7.0.1
 */