package com.tencent.biz.qqcircle.richframework.outbox;

import android.content.ContentValues;
import android.os.Parcel;
import com.tencent.biz.qqcircle.publish.queue.util.ParcelableWrapper;
import com.tencent.mobileqq.qcircle.api.db.DbCacheData;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.DbCreator;

public class QCircleOutboxCacheData
  extends DbCacheData
{
  public static final IDBCacheDataWrapper.DbCreator<QCircleOutboxCacheData> DB_CREATOR = new QCircleOutboxCacheData.1();
  private static final int VERSION = 1;
  private QCircleOutboxTask mTask;
  
  public QCircleOutboxCacheData(QCircleOutboxTask paramQCircleOutboxTask)
  {
    this.mTask = paramQCircleOutboxTask;
  }
  
  public static QCircleOutboxTask createQueueTask(Parcel paramParcel)
  {
    return (QCircleOutboxTask)ParcelableWrapper.a(paramParcel);
  }
  
  public QCircleOutboxTask getQueueTask()
  {
    return this.mTask;
  }
  
  public void writeTo(ContentValues paramContentValues)
  {
    Object localObject = this.mTask;
    if (localObject != null)
    {
      paramContentValues.put("cache_key", ((QCircleOutboxTask)localObject).g());
      localObject = Parcel.obtain();
      ((Parcel)localObject).setDataPosition(0);
      ParcelableWrapper.a((Parcel)localObject, 0, this.mTask);
      byte[] arrayOfByte = ((Parcel)localObject).marshall();
      ((Parcel)localObject).recycle();
      paramContentValues.put("save_data", arrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxCacheData
 * JD-Core Version:    0.7.0.1
 */