package com.tencent.biz.qqcircle.bizparts.danmaku.model;

import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.DbCreator;
import com.tencent.mobileqq.qcircle.api.db.IDBCacheDataWrapper.Structure;

final class QzoneBarrageEffectData$1
  implements IDBCacheDataWrapper.DbCreator<QzoneBarrageEffectData>
{
  /* Error */
  public QzoneBarrageEffectData a(android.database.Cursor paramCursor)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_1
    //   2: ldc 20
    //   4: invokeinterface 26 2 0
    //   9: invokeinterface 30 2 0
    //   14: astore_1
    //   15: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   18: astore_3
    //   19: aload_3
    //   20: aload_1
    //   21: iconst_0
    //   22: aload_1
    //   23: arraylength
    //   24: invokevirtual 40	android/os/Parcel:unmarshall	([BII)V
    //   27: aload_3
    //   28: iconst_0
    //   29: invokevirtual 44	android/os/Parcel:setDataPosition	(I)V
    //   32: aload_3
    //   33: invokestatic 49	com/tencent/biz/qqcircle/publish/queue/util/ParcelableWrapper:a	(Landroid/os/Parcel;)Lcom/tencent/biz/qqcircle/publish/queue/util/SmartParcelable;
    //   36: checkcast 51	com/tencent/biz/qqcircle/bizparts/danmaku/model/QzoneBarrageEffectData
    //   39: astore_2
    //   40: aload_2
    //   41: astore_1
    //   42: aload_3
    //   43: ifnull +41 -> 84
    //   46: aload_3
    //   47: invokevirtual 54	android/os/Parcel:recycle	()V
    //   50: aload_2
    //   51: areturn
    //   52: astore_1
    //   53: goto +33 -> 86
    //   56: aload_3
    //   57: ifnull +25 -> 82
    //   60: aload_3
    //   61: invokevirtual 54	android/os/Parcel:recycle	()V
    //   64: goto +18 -> 82
    //   67: ldc 56
    //   69: iconst_1
    //   70: ldc 58
    //   72: invokestatic 64	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: aload_3
    //   76: ifnull +6 -> 82
    //   79: goto -19 -> 60
    //   82: aconst_null
    //   83: astore_1
    //   84: aload_1
    //   85: areturn
    //   86: aload_3
    //   87: ifnull +7 -> 94
    //   90: aload_3
    //   91: invokevirtual 54	android/os/Parcel:recycle	()V
    //   94: goto +5 -> 99
    //   97: aload_1
    //   98: athrow
    //   99: goto -2 -> 97
    //   102: astore_1
    //   103: goto -36 -> 67
    //   106: astore_1
    //   107: goto -51 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	1
    //   0	110	1	paramCursor	android.database.Cursor
    //   39	12	2	localQzoneBarrageEffectData	QzoneBarrageEffectData
    //   18	73	3	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   19	40	52	finally
    //   67	75	52	finally
    //   19	40	102	java/lang/OutOfMemoryError
    //   19	40	106	java/lang/Exception
  }
  
  public String sortOrder()
  {
    return null;
  }
  
  public IDBCacheDataWrapper.Structure[] structure()
  {
    return new IDBCacheDataWrapper.Structure[] { new IDBCacheDataWrapper.Structure("uin", "INTEGER UNIQUE"), new IDBCacheDataWrapper.Structure("barrage_effect_data", "BLOB") };
  }
  
  public int version()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.model.QzoneBarrageEffectData.1
 * JD-Core Version:    0.7.0.1
 */