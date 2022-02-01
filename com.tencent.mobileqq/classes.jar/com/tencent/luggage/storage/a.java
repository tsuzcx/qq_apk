package com.tencent.luggage.storage;

import android.content.ContentValues;
import com.tencent.luggage.wxa.rb.c;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.SQLException;
import com.tencent.wcdb.database.SQLiteDatabase;

public class a
  implements c
{
  private final SQLiteDatabase a;
  
  public a(SQLiteDatabase paramSQLiteDatabase)
  {
    this.a = paramSQLiteDatabase;
  }
  
  public int a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    return this.a.a(paramString1, paramContentValues, paramString2, paramArrayOfString);
  }
  
  public int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return this.a.a(paramString1, paramString2, paramArrayOfString);
  }
  
  public long a(long paramLong)
  {
    try
    {
      this.a.e();
      return paramLong;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long a(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    return this.a.a(paramString1, paramString2, paramContentValues);
  }
  
  public Cursor a(String paramString, String[] paramArrayOfString)
  {
    return this.a.a(paramString, paramArrayOfString);
  }
  
  public Cursor a(String paramString, String[] paramArrayOfString, int paramInt)
  {
    return this.a.a(paramString, paramArrayOfString);
  }
  
  public Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    return this.a.a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5);
  }
  
  public Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    return this.a.a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5);
  }
  
  public void a()
  {
    this.a.close();
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    try
    {
      this.a.b(paramString2);
      return true;
    }
    catch (SQLException paramString1)
    {
      label10:
      break label10;
    }
    return false;
  }
  
  /* Error */
  public int b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	com/tencent/luggage/storage/a:a	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   6: invokevirtual 57	com/tencent/wcdb/database/SQLiteDatabase:j	()V
    //   9: aload_0
    //   10: getfield 15	com/tencent/luggage/storage/a:a	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   13: invokevirtual 60	com/tencent/wcdb/database/SQLiteDatabase:f	()V
    //   16: aload_0
    //   17: monitorexit
    //   18: iconst_0
    //   19: ireturn
    //   20: astore_3
    //   21: goto +28 -> 49
    //   24: astore_3
    //   25: ldc 62
    //   27: aload_3
    //   28: ldc 64
    //   30: iconst_1
    //   31: anewarray 4	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: lload_1
    //   37: invokestatic 70	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   40: aastore
    //   41: invokestatic 75	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   44: aload_0
    //   45: monitorexit
    //   46: bipush 253
    //   48: ireturn
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_3
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	a
    //   0	53	1	paramLong	long
    //   20	1	3	localObject	Object
    //   24	28	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	16	20	finally
    //   25	44	20	finally
    //   2	16	24	java/lang/Exception
  }
  
  public long b(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    return this.a.b(paramString1, paramString2, paramContentValues);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.storage.a
 * JD-Core Version:    0.7.0.1
 */