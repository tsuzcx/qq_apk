package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.PlayerMessage.Target;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DynamicConcatenatingMediaSource
  extends CompositeMediaSource<DynamicConcatenatingMediaSource.MediaSourceHolder>
  implements PlayerMessage.Target
{
  private static final int MSG_ADD = 0;
  private static final int MSG_ADD_MULTIPLE = 1;
  private static final int MSG_MOVE = 3;
  private static final int MSG_ON_COMPLETION = 4;
  private static final int MSG_REMOVE = 2;
  private final List<DeferredMediaPeriod> deferredMediaPeriods;
  private final boolean isAtomic;
  private MediaSource.Listener listener;
  private final Map<MediaPeriod, DynamicConcatenatingMediaSource.MediaSourceHolder> mediaSourceByMediaPeriod;
  private final List<DynamicConcatenatingMediaSource.MediaSourceHolder> mediaSourceHolders;
  private final List<MediaSource> mediaSourcesPublic;
  private int periodCount;
  private ExoPlayer player;
  private boolean preventListenerNotification;
  private final DynamicConcatenatingMediaSource.MediaSourceHolder query;
  private ShuffleOrder shuffleOrder;
  private int windowCount;
  
  public DynamicConcatenatingMediaSource()
  {
    this(false, new ShuffleOrder.DefaultShuffleOrder(0));
  }
  
  public DynamicConcatenatingMediaSource(boolean paramBoolean)
  {
    this(paramBoolean, new ShuffleOrder.DefaultShuffleOrder(0));
  }
  
  public DynamicConcatenatingMediaSource(boolean paramBoolean, ShuffleOrder paramShuffleOrder)
  {
    this.shuffleOrder = paramShuffleOrder;
    this.mediaSourceByMediaPeriod = new IdentityHashMap();
    this.mediaSourcesPublic = new ArrayList();
    this.mediaSourceHolders = new ArrayList();
    this.deferredMediaPeriods = new ArrayList(1);
    this.query = new DynamicConcatenatingMediaSource.MediaSourceHolder(null, null, -1, -1, -1);
    this.isAtomic = paramBoolean;
  }
  
  private void addMediaSourceInternal(int paramInt, MediaSource paramMediaSource)
  {
    DynamicConcatenatingMediaSource.DeferredTimeline localDeferredTimeline = new DynamicConcatenatingMediaSource.DeferredTimeline();
    DynamicConcatenatingMediaSource.MediaSourceHolder localMediaSourceHolder;
    int i;
    if (paramInt > 0)
    {
      localMediaSourceHolder = (DynamicConcatenatingMediaSource.MediaSourceHolder)this.mediaSourceHolders.get(paramInt - 1);
      i = localMediaSourceHolder.firstWindowIndexInChild;
    }
    for (paramMediaSource = new DynamicConcatenatingMediaSource.MediaSourceHolder(paramMediaSource, localDeferredTimeline, paramInt, localMediaSourceHolder.timeline.getWindowCount() + i, localMediaSourceHolder.firstPeriodIndexInChild + localMediaSourceHolder.timeline.getPeriodCount());; paramMediaSource = new DynamicConcatenatingMediaSource.MediaSourceHolder(paramMediaSource, localDeferredTimeline, 0, 0, 0))
    {
      correctOffsets(paramInt, 1, localDeferredTimeline.getWindowCount(), localDeferredTimeline.getPeriodCount());
      this.mediaSourceHolders.add(paramInt, paramMediaSource);
      prepareChildSource(paramMediaSource, paramMediaSource.mediaSource);
      return;
    }
  }
  
  private void addMediaSourcesInternal(int paramInt, Collection<MediaSource> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      addMediaSourceInternal(paramInt, (MediaSource)paramCollection.next());
      paramInt += 1;
    }
  }
  
  private void correctOffsets(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.windowCount += paramInt3;
    this.periodCount += paramInt4;
    while (paramInt1 < this.mediaSourceHolders.size())
    {
      DynamicConcatenatingMediaSource.MediaSourceHolder localMediaSourceHolder = (DynamicConcatenatingMediaSource.MediaSourceHolder)this.mediaSourceHolders.get(paramInt1);
      localMediaSourceHolder.childIndex += paramInt2;
      localMediaSourceHolder = (DynamicConcatenatingMediaSource.MediaSourceHolder)this.mediaSourceHolders.get(paramInt1);
      localMediaSourceHolder.firstWindowIndexInChild += paramInt3;
      localMediaSourceHolder = (DynamicConcatenatingMediaSource.MediaSourceHolder)this.mediaSourceHolders.get(paramInt1);
      localMediaSourceHolder.firstPeriodIndexInChild += paramInt4;
      paramInt1 += 1;
    }
  }
  
  private int findMediaSourceHolderByPeriodIndex(int paramInt)
  {
    this.query.firstPeriodIndexInChild = paramInt;
    int i = Collections.binarySearch(this.mediaSourceHolders, this.query);
    int j;
    if (i < 0)
    {
      j = -i - 2;
      return j;
    }
    for (;;)
    {
      j = i;
      if (i >= this.mediaSourceHolders.size() - 1) {
        break;
      }
      j = i;
      if (((DynamicConcatenatingMediaSource.MediaSourceHolder)this.mediaSourceHolders.get(i + 1)).firstPeriodIndexInChild != paramInt) {
        break;
      }
      i += 1;
    }
  }
  
  private void maybeNotifyListener(@Nullable DynamicConcatenatingMediaSource.EventDispatcher paramEventDispatcher)
  {
    if (!this.preventListenerNotification)
    {
      this.listener.onSourceInfoRefreshed(this, new DynamicConcatenatingMediaSource.ConcatenatedTimeline(this.mediaSourceHolders, this.windowCount, this.periodCount, this.shuffleOrder, this.isAtomic), null);
      if (paramEventDispatcher != null) {
        this.player.createMessage(this).setType(4).setPayload(paramEventDispatcher).send();
      }
    }
  }
  
  private void moveMediaSourceInternal(int paramInt1, int paramInt2)
  {
    int j = Math.min(paramInt1, paramInt2);
    int m = Math.max(paramInt1, paramInt2);
    int i = ((DynamicConcatenatingMediaSource.MediaSourceHolder)this.mediaSourceHolders.get(j)).firstWindowIndexInChild;
    int k = ((DynamicConcatenatingMediaSource.MediaSourceHolder)this.mediaSourceHolders.get(j)).firstPeriodIndexInChild;
    this.mediaSourceHolders.add(paramInt2, this.mediaSourceHolders.remove(paramInt1));
    paramInt2 = k;
    paramInt1 = j;
    while (paramInt1 <= m)
    {
      DynamicConcatenatingMediaSource.MediaSourceHolder localMediaSourceHolder = (DynamicConcatenatingMediaSource.MediaSourceHolder)this.mediaSourceHolders.get(paramInt1);
      localMediaSourceHolder.firstWindowIndexInChild = i;
      localMediaSourceHolder.firstPeriodIndexInChild = paramInt2;
      i += localMediaSourceHolder.timeline.getWindowCount();
      paramInt2 += localMediaSourceHolder.timeline.getPeriodCount();
      paramInt1 += 1;
    }
  }
  
  private void removeMediaSourceInternal(int paramInt)
  {
    DynamicConcatenatingMediaSource.MediaSourceHolder localMediaSourceHolder = (DynamicConcatenatingMediaSource.MediaSourceHolder)this.mediaSourceHolders.get(paramInt);
    this.mediaSourceHolders.remove(paramInt);
    DynamicConcatenatingMediaSource.DeferredTimeline localDeferredTimeline = localMediaSourceHolder.timeline;
    correctOffsets(paramInt, -1, -localDeferredTimeline.getWindowCount(), -localDeferredTimeline.getPeriodCount());
    localMediaSourceHolder.isRemoved = true;
    if (localMediaSourceHolder.activeMediaPeriods == 0) {
      releaseChildSource(localMediaSourceHolder);
    }
  }
  
  private void updateMediaSourceInternal(DynamicConcatenatingMediaSource.MediaSourceHolder paramMediaSourceHolder, Timeline paramTimeline)
  {
    if (paramMediaSourceHolder == null) {
      throw new IllegalArgumentException();
    }
    DynamicConcatenatingMediaSource.DeferredTimeline localDeferredTimeline = paramMediaSourceHolder.timeline;
    if (localDeferredTimeline.getTimeline() == paramTimeline) {
      return;
    }
    int i = paramTimeline.getWindowCount() - localDeferredTimeline.getWindowCount();
    int j = paramTimeline.getPeriodCount() - localDeferredTimeline.getPeriodCount();
    if ((i != 0) || (j != 0)) {
      correctOffsets(paramMediaSourceHolder.childIndex + 1, 0, i, j);
    }
    paramMediaSourceHolder.timeline = localDeferredTimeline.cloneWithNewTimeline(paramTimeline);
    if (!paramMediaSourceHolder.isPrepared)
    {
      i = this.deferredMediaPeriods.size() - 1;
      while (i >= 0)
      {
        if (((DeferredMediaPeriod)this.deferredMediaPeriods.get(i)).mediaSource == paramMediaSourceHolder.mediaSource)
        {
          ((DeferredMediaPeriod)this.deferredMediaPeriods.get(i)).createPeriod();
          this.deferredMediaPeriods.remove(i);
        }
        i -= 1;
      }
    }
    paramMediaSourceHolder.isPrepared = true;
    maybeNotifyListener(null);
  }
  
  public void addMediaSource(int paramInt, MediaSource paramMediaSource)
  {
    try
    {
      addMediaSource(paramInt, paramMediaSource, null);
      return;
    }
    finally
    {
      paramMediaSource = finally;
      throw paramMediaSource;
    }
  }
  
  /* Error */
  public void addMediaSource(int paramInt, MediaSource paramMediaSource, @Nullable Runnable paramRunnable)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_2
    //   6: invokestatic 271	com/google/android/exoplayer2/util/Assertions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   9: pop
    //   10: aload_0
    //   11: getfield 67	com/google/android/exoplayer2/source/DynamicConcatenatingMediaSource:mediaSourcesPublic	Ljava/util/List;
    //   14: aload_2
    //   15: invokeinterface 275 2 0
    //   20: ifne +6 -> 26
    //   23: iconst_1
    //   24: istore 4
    //   26: iload 4
    //   28: invokestatic 278	com/google/android/exoplayer2/util/Assertions:checkArgument	(Z)V
    //   31: aload_0
    //   32: getfield 67	com/google/android/exoplayer2/source/DynamicConcatenatingMediaSource:mediaSourcesPublic	Ljava/util/List;
    //   35: iload_1
    //   36: aload_2
    //   37: invokeinterface 117 3 0
    //   42: aload_0
    //   43: getfield 187	com/google/android/exoplayer2/source/DynamicConcatenatingMediaSource:player	Lcom/google/android/exoplayer2/ExoPlayer;
    //   46: ifnull +37 -> 83
    //   49: aload_0
    //   50: getfield 187	com/google/android/exoplayer2/source/DynamicConcatenatingMediaSource:player	Lcom/google/android/exoplayer2/ExoPlayer;
    //   53: aload_0
    //   54: invokeinterface 193 2 0
    //   59: iconst_0
    //   60: invokevirtual 199	com/google/android/exoplayer2/PlayerMessage:setType	(I)Lcom/google/android/exoplayer2/PlayerMessage;
    //   63: new 280	com/google/android/exoplayer2/source/DynamicConcatenatingMediaSource$MessageData
    //   66: dup
    //   67: iload_1
    //   68: aload_2
    //   69: aload_3
    //   70: invokespecial 283	com/google/android/exoplayer2/source/DynamicConcatenatingMediaSource$MessageData:<init>	(ILjava/lang/Object;Ljava/lang/Runnable;)V
    //   73: invokevirtual 203	com/google/android/exoplayer2/PlayerMessage:setPayload	(Ljava/lang/Object;)Lcom/google/android/exoplayer2/PlayerMessage;
    //   76: invokevirtual 207	com/google/android/exoplayer2/PlayerMessage:send	()Lcom/google/android/exoplayer2/PlayerMessage;
    //   79: pop
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: aload_3
    //   84: ifnull -4 -> 80
    //   87: aload_3
    //   88: invokeinterface 288 1 0
    //   93: goto -13 -> 80
    //   96: astore_2
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_2
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	DynamicConcatenatingMediaSource
    //   0	101	1	paramInt	int
    //   0	101	2	paramMediaSource	MediaSource
    //   0	101	3	paramRunnable	Runnable
    //   1	26	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	10	96	finally
    //   10	23	96	finally
    //   26	80	96	finally
    //   87	93	96	finally
  }
  
  public void addMediaSource(MediaSource paramMediaSource)
  {
    try
    {
      addMediaSource(this.mediaSourcesPublic.size(), paramMediaSource, null);
      return;
    }
    finally
    {
      paramMediaSource = finally;
      throw paramMediaSource;
    }
  }
  
  public void addMediaSource(MediaSource paramMediaSource, @Nullable Runnable paramRunnable)
  {
    try
    {
      addMediaSource(this.mediaSourcesPublic.size(), paramMediaSource, paramRunnable);
      return;
    }
    finally
    {
      paramMediaSource = finally;
      throw paramMediaSource;
    }
  }
  
  public void addMediaSources(int paramInt, Collection<MediaSource> paramCollection)
  {
    try
    {
      addMediaSources(paramInt, paramCollection, null);
      return;
    }
    finally
    {
      paramCollection = finally;
      throw paramCollection;
    }
  }
  
  public void addMediaSources(int paramInt, Collection<MediaSource> paramCollection, @Nullable Runnable paramRunnable)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = paramCollection.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        MediaSource localMediaSource = (MediaSource)localIterator.next();
        Assertions.checkNotNull(localMediaSource);
        boolean bool;
        if (!this.mediaSourcesPublic.contains(localMediaSource))
        {
          bool = true;
          Assertions.checkArgument(bool);
        }
        else
        {
          bool = false;
        }
      }
      finally {}
    }
    this.mediaSourcesPublic.addAll(paramInt, paramCollection);
    if ((this.player != null) && (!paramCollection.isEmpty())) {
      this.player.createMessage(this).setType(1).setPayload(new DynamicConcatenatingMediaSource.MessageData(paramInt, paramCollection, paramRunnable)).send();
    }
    for (;;)
    {
      return;
      if (paramRunnable != null) {
        paramRunnable.run();
      }
    }
  }
  
  public void addMediaSources(Collection<MediaSource> paramCollection)
  {
    try
    {
      addMediaSources(this.mediaSourcesPublic.size(), paramCollection, null);
      return;
    }
    finally
    {
      paramCollection = finally;
      throw paramCollection;
    }
  }
  
  public void addMediaSources(Collection<MediaSource> paramCollection, @Nullable Runnable paramRunnable)
  {
    try
    {
      addMediaSources(this.mediaSourcesPublic.size(), paramCollection, paramRunnable);
      return;
    }
    finally
    {
      paramCollection = finally;
      throw paramCollection;
    }
  }
  
  public MediaPeriod createPeriod(MediaSource.MediaPeriodId paramMediaPeriodId, Allocator paramAllocator)
  {
    int i = findMediaSourceHolderByPeriodIndex(paramMediaPeriodId.periodIndex);
    DynamicConcatenatingMediaSource.MediaSourceHolder localMediaSourceHolder = (DynamicConcatenatingMediaSource.MediaSourceHolder)this.mediaSourceHolders.get(i);
    paramMediaPeriodId = paramMediaPeriodId.copyWithPeriodIndex(paramMediaPeriodId.periodIndex - localMediaSourceHolder.firstPeriodIndexInChild);
    if (!localMediaSourceHolder.isPrepared)
    {
      paramMediaPeriodId = new DeferredMediaPeriod(localMediaSourceHolder.mediaSource, paramMediaPeriodId, paramAllocator);
      this.deferredMediaPeriods.add((DeferredMediaPeriod)paramMediaPeriodId);
    }
    for (;;)
    {
      this.mediaSourceByMediaPeriod.put(paramMediaPeriodId, localMediaSourceHolder);
      localMediaSourceHolder.activeMediaPeriods += 1;
      return paramMediaPeriodId;
      paramMediaPeriodId = localMediaSourceHolder.mediaSource.createPeriod(paramMediaPeriodId, paramAllocator);
    }
  }
  
  public MediaSource getMediaSource(int paramInt)
  {
    try
    {
      MediaSource localMediaSource = (MediaSource)this.mediaSourcesPublic.get(paramInt);
      return localMediaSource;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getSize()
  {
    try
    {
      int i = this.mediaSourcesPublic.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void handleMessage(int paramInt, Object paramObject)
  {
    if (paramInt == 4)
    {
      ((DynamicConcatenatingMediaSource.EventDispatcher)paramObject).dispatchEvent();
      return;
    }
    this.preventListenerNotification = true;
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException();
    case 0: 
      paramObject = (DynamicConcatenatingMediaSource.MessageData)paramObject;
      this.shuffleOrder = this.shuffleOrder.cloneAndInsert(paramObject.index, 1);
      addMediaSourceInternal(paramObject.index, (MediaSource)paramObject.customData);
      paramObject = paramObject.actionOnCompletion;
    }
    for (;;)
    {
      this.preventListenerNotification = false;
      maybeNotifyListener(paramObject);
      return;
      paramObject = (DynamicConcatenatingMediaSource.MessageData)paramObject;
      this.shuffleOrder = this.shuffleOrder.cloneAndInsert(paramObject.index, ((Collection)paramObject.customData).size());
      addMediaSourcesInternal(paramObject.index, (Collection)paramObject.customData);
      paramObject = paramObject.actionOnCompletion;
      continue;
      paramObject = (DynamicConcatenatingMediaSource.MessageData)paramObject;
      this.shuffleOrder = this.shuffleOrder.cloneAndRemove(paramObject.index);
      removeMediaSourceInternal(paramObject.index);
      paramObject = paramObject.actionOnCompletion;
      continue;
      paramObject = (DynamicConcatenatingMediaSource.MessageData)paramObject;
      this.shuffleOrder = this.shuffleOrder.cloneAndRemove(paramObject.index);
      this.shuffleOrder = this.shuffleOrder.cloneAndInsert(((Integer)paramObject.customData).intValue(), 1);
      moveMediaSourceInternal(paramObject.index, ((Integer)paramObject.customData).intValue());
      paramObject = paramObject.actionOnCompletion;
    }
  }
  
  public void moveMediaSource(int paramInt1, int paramInt2)
  {
    try
    {
      moveMediaSource(paramInt1, paramInt2, null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void moveMediaSource(int paramInt1, int paramInt2, @Nullable Runnable paramRunnable)
  {
    if (paramInt1 == paramInt2) {}
    for (;;)
    {
      return;
      try
      {
        this.mediaSourcesPublic.add(paramInt2, this.mediaSourcesPublic.remove(paramInt1));
        if (this.player != null)
        {
          this.player.createMessage(this).setType(3).setPayload(new DynamicConcatenatingMediaSource.MessageData(paramInt1, Integer.valueOf(paramInt2), paramRunnable)).send();
          continue;
        }
      }
      finally {}
      if (paramRunnable != null) {
        paramRunnable.run();
      }
    }
  }
  
  protected void onChildSourceInfoRefreshed(DynamicConcatenatingMediaSource.MediaSourceHolder paramMediaSourceHolder, MediaSource paramMediaSource, Timeline paramTimeline, @Nullable Object paramObject)
  {
    updateMediaSourceInternal(paramMediaSourceHolder, paramTimeline);
  }
  
  public void prepareSource(ExoPlayer paramExoPlayer, boolean paramBoolean, MediaSource.Listener paramListener)
  {
    try
    {
      super.prepareSource(paramExoPlayer, paramBoolean, paramListener);
      this.player = paramExoPlayer;
      this.listener = paramListener;
      this.preventListenerNotification = true;
      this.shuffleOrder = this.shuffleOrder.cloneAndInsert(0, this.mediaSourcesPublic.size());
      addMediaSourcesInternal(0, this.mediaSourcesPublic);
      this.preventListenerNotification = false;
      maybeNotifyListener(null);
      return;
    }
    finally
    {
      paramExoPlayer = finally;
      throw paramExoPlayer;
    }
  }
  
  public void releasePeriod(MediaPeriod paramMediaPeriod)
  {
    DynamicConcatenatingMediaSource.MediaSourceHolder localMediaSourceHolder = (DynamicConcatenatingMediaSource.MediaSourceHolder)this.mediaSourceByMediaPeriod.remove(paramMediaPeriod);
    if ((paramMediaPeriod instanceof DeferredMediaPeriod))
    {
      this.deferredMediaPeriods.remove(paramMediaPeriod);
      ((DeferredMediaPeriod)paramMediaPeriod).releasePeriod();
    }
    for (;;)
    {
      localMediaSourceHolder.activeMediaPeriods -= 1;
      if ((localMediaSourceHolder.activeMediaPeriods == 0) && (localMediaSourceHolder.isRemoved)) {
        releaseChildSource(localMediaSourceHolder);
      }
      return;
      localMediaSourceHolder.mediaSource.releasePeriod(paramMediaPeriod);
    }
  }
  
  public void releaseSource()
  {
    super.releaseSource();
    this.mediaSourceHolders.clear();
    this.player = null;
    this.listener = null;
    this.shuffleOrder = this.shuffleOrder.cloneAndClear();
    this.windowCount = 0;
    this.periodCount = 0;
  }
  
  public void removeMediaSource(int paramInt)
  {
    try
    {
      removeMediaSource(paramInt, null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void removeMediaSource(int paramInt, @Nullable Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 67	com/google/android/exoplayer2/source/DynamicConcatenatingMediaSource:mediaSourcesPublic	Ljava/util/List;
    //   6: iload_1
    //   7: invokeinterface 222 2 0
    //   12: pop
    //   13: aload_0
    //   14: getfield 187	com/google/android/exoplayer2/source/DynamicConcatenatingMediaSource:player	Lcom/google/android/exoplayer2/ExoPlayer;
    //   17: ifnull +37 -> 54
    //   20: aload_0
    //   21: getfield 187	com/google/android/exoplayer2/source/DynamicConcatenatingMediaSource:player	Lcom/google/android/exoplayer2/ExoPlayer;
    //   24: aload_0
    //   25: invokeinterface 193 2 0
    //   30: iconst_2
    //   31: invokevirtual 199	com/google/android/exoplayer2/PlayerMessage:setType	(I)Lcom/google/android/exoplayer2/PlayerMessage;
    //   34: new 280	com/google/android/exoplayer2/source/DynamicConcatenatingMediaSource$MessageData
    //   37: dup
    //   38: iload_1
    //   39: aconst_null
    //   40: aload_2
    //   41: invokespecial 283	com/google/android/exoplayer2/source/DynamicConcatenatingMediaSource$MessageData:<init>	(ILjava/lang/Object;Ljava/lang/Runnable;)V
    //   44: invokevirtual 203	com/google/android/exoplayer2/PlayerMessage:setPayload	(Ljava/lang/Object;)Lcom/google/android/exoplayer2/PlayerMessage;
    //   47: invokevirtual 207	com/google/android/exoplayer2/PlayerMessage:send	()Lcom/google/android/exoplayer2/PlayerMessage;
    //   50: pop
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: aload_2
    //   55: ifnull -4 -> 51
    //   58: aload_2
    //   59: invokeinterface 288 1 0
    //   64: goto -13 -> 51
    //   67: astore_2
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_2
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	DynamicConcatenatingMediaSource
    //   0	72	1	paramInt	int
    //   0	72	2	paramRunnable	Runnable
    // Exception table:
    //   from	to	target	type
    //   2	51	67	finally
    //   58	64	67	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.DynamicConcatenatingMediaSource
 * JD-Core Version:    0.7.0.1
 */