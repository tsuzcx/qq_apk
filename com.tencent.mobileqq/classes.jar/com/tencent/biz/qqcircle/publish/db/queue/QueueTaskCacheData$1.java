package com.tencent.biz.qqcircle.publish.db.queue;

import android.database.Cursor;
import android.os.Parcel;
import com.tencent.biz.qqcircle.publish.task.IQueueTask;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.DbCreator;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.Structure;
import com.tencent.qphone.base.util.QLog;

final class QueueTaskCacheData$1
  implements IDBCacheDataWrapper.DbCreator<QueueTaskCacheData>
{
  public QueueTaskCacheData a(Cursor paramCursor)
  {
    int i = paramCursor.getInt(paramCursor.getColumnIndex("type"));
    Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("publish_data"));
    try
    {
      paramCursor = Parcel.obtain();
      paramCursor.unmarshall((byte[])localObject, 0, localObject.length);
      paramCursor.setDataPosition(0);
      localObject = QueueTaskCacheData.createQueueTask(i, paramCursor);
      ((IQueueTask)localObject).a(System.currentTimeMillis());
      paramCursor.recycle();
      paramCursor = new QueueTaskCacheData((IQueueTask)localObject);
      return paramCursor;
    }
    catch (Throwable paramCursor)
    {
      QLog.w("QueueTaskCacheData", 1, paramCursor.getMessage());
    }
    return null;
  }
  
  public String sortOrder()
  {
    return null;
  }
  
  public IDBCacheDataWrapper.Structure[] structure()
  {
    return new IDBCacheDataWrapper.Structure[] { new IDBCacheDataWrapper.Structure("client_key", "TEXT UNIQUE"), new IDBCacheDataWrapper.Structure("type", "INTEGER"), new IDBCacheDataWrapper.Structure("publish_data", "BLOB") };
  }
  
  public int version()
  {
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.db.queue.QueueTaskCacheData.1
 * JD-Core Version:    0.7.0.1
 */