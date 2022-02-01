package com.tencent.mobileqq.activity.photo.album.querymedia;

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
  public static final String TAG = "QQAlbum";
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
  
  private boolean checkQueryCondition(int paramInt1, int paramInt2, int paramInt3)
  {
    return (!this.mTraversalDone) && (paramInt2 < paramInt1) && ((paramInt3 < paramInt1 * 2) || (paramInt2 < 150));
  }
  
  private void init(List<ICursor> paramList, int paramInt1, int paramInt2)
  {
    this.mCursors = paramList;
    paramList = this.mCursors;
    if (paramList != null)
    {
      paramList = paramList.iterator();
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
    if (!bool2) {
      if (Build.VERSION.SDK_INT >= 23)
      {
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
              return sHasStorageReadAndWritePermission;
            }
          }
        }
      }
      else
      {
        sHasStorageReadAndWritePermission = true;
        bool1 = sHasStorageReadAndWritePermission;
      }
    }
    return bool1;
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
    List localList = this.mediaList;
    if ((localList != null) && (!localList.isEmpty())) {
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
    if (this.isQuerying.compareAndSet(false, true)) {
      try
      {
        if (!this.mTraversalDone)
        {
          int j = 0;
          int i = 0;
          while (checkQueryCondition(paramInt, j, i))
          {
            if ((this.mLimit > 0) && (this.mediaList.size() >= this.mLimit))
            {
              this.mTraversalDone = true;
              break;
            }
            MediaQueryHelper.MergeSlot localMergeSlot = (MediaQueryHelper.MergeSlot)this.mQueue.poll();
            int m = i + 1;
            if (localMergeSlot == null)
            {
              this.mTraversalDone = true;
              break;
            }
            int k = j;
            if (localMergeSlot.need)
            {
              k = j + 1;
              this.mediaList.add(localMergeSlot.mImage);
            }
            j = k;
            i = m;
            if (localMergeSlot.next())
            {
              this.mQueue.add(localMergeSlot);
              j = k;
              i = m;
            }
          }
        }
        StringBuilder localStringBuilder;
        return this.mTraversalDone;
      }
      catch (StaleDataException localStaleDataException)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("queryNext():");
          localStringBuilder.append(localStaleDataException.getMessage());
          QLog.w("QQAlbum", 2, localStringBuilder.toString());
        }
        this.mTraversalDone = true;
        this.isQuerying.set(false);
      }
    }
  }
  
  public void setListener(ICursor.FilterListener paramFilterListener)
  {
    this.mListener = paramFilterListener;
    Object localObject = this.mCursors;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ICursor)((Iterator)localObject).next()).setListener(paramFilterListener);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper
 * JD-Core Version:    0.7.0.1
 */