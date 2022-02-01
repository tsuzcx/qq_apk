package com.tencent.mobileqq.activity.photo.album.queryMedia;

import android.content.Context;
import android.database.StaleDataException;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class MediaQueryHelper
{
  public static final int DEFAULT_EACH_COUNT = 300;
  private static final String[] PERMS_STORAGE = { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE" };
  public static final String TAG = "MediaQuery";
  private static boolean sHasStorageReadAndWritePermission;
  public int cursorsCount = -1;
  public int cursorsVideoCount = -1;
  public volatile AtomicBoolean isQuerying = new AtomicBoolean(false);
  List<ICursor> mCursors;
  public int mEachCount = 300;
  private int mLimit = -1;
  ICursor.FilterListener mListener;
  private PriorityQueue<MediaQueryHelper.MergeSlot> mQueue;
  public boolean mTraversalDone = false;
  public List<LocalMediaInfo> mediaList;
  
  private void init(List<ICursor> paramList, int paramInt1, int paramInt2)
  {
    this.mCursors = paramList;
    if (this.mCursors != null)
    {
      paramList = this.mCursors.iterator();
      while (paramList.hasNext()) {
        ((ICursor)paramList.next()).setListener(this.mListener);
      }
    }
    this.mLimit = paramInt1;
    if (paramInt2 > 300) {
      this.mEachCount = paramInt2;
    }
    this.mediaList = new CopyOnWriteArrayList();
    this.mQueue = new PriorityQueue(4, new MediaQueryHelper.DataComparator(null));
    paramList = this.mCursors.iterator();
    while (paramList.hasNext())
    {
      MediaQueryHelper.MergeSlot localMergeSlot = new MediaQueryHelper.MergeSlot((ICursor)paramList.next());
      if (localMergeSlot.next()) {
        this.mQueue.add(localMergeSlot);
      }
    }
  }
  
  public static boolean isHasStorageReadAndWritePermission(Context paramContext)
  {
    boolean bool2 = sHasStorageReadAndWritePermission;
    boolean bool1 = bool2;
    if (!bool2)
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label62;
      }
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.checkSelfPermission(PERMS_STORAGE[0]) == 0)
        {
          bool1 = bool2;
          if (paramContext.checkSelfPermission(PERMS_STORAGE[1]) == 0)
          {
            sHasStorageReadAndWritePermission = true;
            bool1 = sHasStorageReadAndWritePermission;
          }
        }
      }
    }
    return bool1;
    label62:
    sHasStorageReadAndWritePermission = true;
    return sHasStorageReadAndWritePermission;
  }
  
  public void close()
  {
    Iterator localIterator = this.mCursors.iterator();
    while (localIterator.hasNext()) {
      ((ICursor)localIterator.next()).close();
    }
  }
  
  public LocalMediaInfo getFirstInfo()
  {
    if ((this.mediaList != null) && (!this.mediaList.isEmpty())) {
      return (LocalMediaInfo)this.mediaList.get(0);
    }
    return null;
  }
  
  public void queryAll()
  {
    while (!this.mTraversalDone) {
      queryNext();
    }
  }
  
  public boolean queryNext()
  {
    return queryNext(this.mEachCount);
  }
  
  public boolean queryNext(int paramInt)
  {
    if (this.isQuerying.compareAndSet(false, true)) {}
    try
    {
      if (this.mTraversalDone) {
        break label77;
      }
      i = 0;
      j = 0;
    }
    catch (StaleDataException localStaleDataException)
    {
      for (;;)
      {
        label77:
        label90:
        int m;
        if (QLog.isColorLevel()) {
          QLog.w("MediaQuery", 2, "queryNext():" + localStaleDataException.getMessage());
        }
        this.mTraversalDone = true;
        continue;
        int k = j;
        if (localStaleDataException.need)
        {
          k = j + 1;
          this.mediaList.add(localStaleDataException.mImage);
        }
        int j = k;
        int i = m;
        if (localStaleDataException.next())
        {
          this.mQueue.add(localStaleDataException);
          j = k;
          i = m;
        }
      }
    }
    if ((!this.mTraversalDone) && (j < paramInt) && ((i < paramInt * 2) || (j < 150))) {
      if ((this.mLimit <= 0) || (this.mediaList.size() < this.mLimit)) {
        break label90;
      }
    }
    for (this.mTraversalDone = true;; this.mTraversalDone = true)
    {
      this.isQuerying.set(false);
      return this.mTraversalDone;
      MediaQueryHelper.MergeSlot localMergeSlot = (MediaQueryHelper.MergeSlot)this.mQueue.poll();
      m = i + 1;
      if (localMergeSlot != null) {
        break;
      }
    }
  }
  
  public void setListener(ICursor.FilterListener paramFilterListener)
  {
    this.mListener = paramFilterListener;
    if (this.mCursors != null)
    {
      Iterator localIterator = this.mCursors.iterator();
      while (localIterator.hasNext()) {
        ((ICursor)localIterator.next()).setListener(paramFilterListener);
      }
    }
  }
  
  public void upDateCount()
  {
    if ((this.cursorsCount == -1) || (this.cursorsVideoCount == -1))
    {
      this.cursorsCount = 0;
      this.cursorsVideoCount = 0;
      Iterator localIterator = this.mCursors.iterator();
      while (localIterator.hasNext())
      {
        ICursor localICursor = (ICursor)localIterator.next();
        int i = localICursor.getCount();
        this.cursorsCount += i;
        if ((localICursor instanceof VideoCursor)) {
          this.cursorsVideoCount += i;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.queryMedia.MediaQueryHelper
 * JD-Core Version:    0.7.0.1
 */