package com.tencent.biz.qqcircle.publish.db.queue;

import android.content.ContentValues;
import android.os.Parcel;
import com.tencent.biz.qqcircle.publish.queue.util.ParcelableWrapper;
import com.tencent.biz.qqcircle.publish.task.IQueueTask;
import com.tencent.mobileqq.qcircle.api.db.DbCacheData;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.DbCreator;

public class QueueTaskCacheData
  extends DbCacheData
{
  public static final IDBCacheDataWrapper.DbCreator<QueueTaskCacheData> DB_CREATOR = new QueueTaskCacheData.1();
  private static final int VERSION = 8;
  private IQueueTask mTask;
  
  public QueueTaskCacheData() {}
  
  public QueueTaskCacheData(IQueueTask paramIQueueTask)
  {
    this.mTask = paramIQueueTask;
  }
  
  public static IQueueTask createQueueTask(int paramInt, Parcel paramParcel)
  {
    return (IQueueTask)ParcelableWrapper.a(paramParcel);
  }
  
  public IQueueTask getQueueTask()
  {
    return this.mTask;
  }
  
  public void writeTo(ContentValues paramContentValues)
  {
    Object localObject = this.mTask;
    if (localObject != null)
    {
      paramContentValues.put("client_key", ((IQueueTask)localObject).i());
      paramContentValues.put("type", Integer.valueOf(this.mTask.k()));
      localObject = Parcel.obtain();
      ((Parcel)localObject).setDataPosition(0);
      ParcelableWrapper.a((Parcel)localObject, 0, this.mTask);
      byte[] arrayOfByte = ((Parcel)localObject).marshall();
      ((Parcel)localObject).recycle();
      paramContentValues.put("publish_data", arrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.db.queue.QueueTaskCacheData
 * JD-Core Version:    0.7.0.1
 */