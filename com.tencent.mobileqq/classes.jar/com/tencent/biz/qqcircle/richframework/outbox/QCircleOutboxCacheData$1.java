package com.tencent.biz.qqcircle.richframework.outbox;

import android.database.Cursor;
import android.os.Parcel;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.DbCreator;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.Structure;
import com.tencent.qphone.base.util.QLog;

final class QCircleOutboxCacheData$1
  implements IDBCacheDataWrapper.DbCreator<QCircleOutboxCacheData>
{
  public QCircleOutboxCacheData a(Cursor paramCursor)
  {
    Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("save_data"));
    try
    {
      paramCursor = Parcel.obtain();
      paramCursor.unmarshall((byte[])localObject, 0, localObject.length);
      paramCursor.setDataPosition(0);
      localObject = QCircleOutboxCacheData.createQueueTask(paramCursor);
      ((QCircleOutboxTask)localObject).a(System.currentTimeMillis());
      paramCursor.recycle();
      paramCursor = new QCircleOutboxCacheData((QCircleOutboxTask)localObject);
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
    return new IDBCacheDataWrapper.Structure[] { new IDBCacheDataWrapper.Structure("cache_key", "TEXT UNIQUE"), new IDBCacheDataWrapper.Structure("save_data", "BLOB") };
  }
  
  public int version()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxCacheData.1
 * JD-Core Version:    0.7.0.1
 */