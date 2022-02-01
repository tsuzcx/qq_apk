package com.tencent.mm.plugin.appbrand.appcache;

import android.content.ContentValues;
import android.database.MatrixCursor;
import com.tencent.luggage.wxa.ha.c;
import com.tencent.luggage.wxa.rb.a.a;
import java.util.Set;

public final class ab
  extends c
{
  static final String[] l;
  static final a.a m;
  
  static
  {
    int i = 0;
    l = new String[] { "appId", "version", "debugType" };
    m = c.a(ab.class);
    Object localObject1 = l;
    int j = localObject1.length;
    String str = " PRIMARY KEY (";
    while (i < j)
    {
      localObject2 = localObject1[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(", ");
      localStringBuilder.append((String)localObject2);
      str = localStringBuilder.toString();
      i += 1;
    }
    str = str.replaceFirst(",", "");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(str);
    ((StringBuilder)localObject1).append(" )");
    str = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    Object localObject2 = m;
    ((StringBuilder)localObject1).append(((a.a)localObject2).e);
    ((StringBuilder)localObject1).append(",");
    ((StringBuilder)localObject1).append(str);
    ((a.a)localObject2).e = ((StringBuilder)localObject1).toString();
  }
  
  static MatrixCursor b(ContentValues paramContentValues)
  {
    Object localObject = paramContentValues.keySet();
    int j = 0;
    String[] arrayOfString = (String[])((Set)localObject).toArray(new String[0]);
    localObject = new Object[arrayOfString.length];
    int k = arrayOfString.length;
    int i = 0;
    while (j < k)
    {
      localObject[i] = paramContentValues.get(arrayOfString[j]);
      j += 1;
      i += 1;
    }
    paramContentValues = new MatrixCursor(arrayOfString);
    paramContentValues.addRow((Object[])localObject);
    return paramContentValues;
  }
  
  protected a.a a()
  {
    return m;
  }
  
  /* Error */
  public void a(ContentValues paramContentValues)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 97	com/tencent/mm/plugin/appbrand/appcache/ab:b	(Landroid/content/ContentValues;)Landroid/database/MatrixCursor;
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_2
    //   8: astore_1
    //   9: aload_3
    //   10: invokeinterface 103 1 0
    //   15: pop
    //   16: aload_2
    //   17: astore_1
    //   18: aload_0
    //   19: aload_3
    //   20: invokevirtual 106	com/tencent/mm/plugin/appbrand/appcache/ab:a	(Landroid/database/Cursor;)V
    //   23: aload_3
    //   24: ifnull +9 -> 33
    //   27: aload_3
    //   28: invokeinterface 109 1 0
    //   33: return
    //   34: astore_2
    //   35: goto +8 -> 43
    //   38: astore_2
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: athrow
    //   43: aload_3
    //   44: ifnull +22 -> 66
    //   47: aload_1
    //   48: ifnull +12 -> 60
    //   51: aload_3
    //   52: invokeinterface 109 1 0
    //   57: goto +9 -> 66
    //   60: aload_3
    //   61: invokeinterface 109 1 0
    //   66: aload_2
    //   67: athrow
    //   68: astore_1
    //   69: goto -3 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	ab
    //   0	72	1	paramContentValues	ContentValues
    //   6	11	2	localObject1	Object
    //   34	1	2	localObject2	Object
    //   38	29	2	localThrowable	java.lang.Throwable
    //   4	57	3	localMatrixCursor	MatrixCursor
    // Exception table:
    //   from	to	target	type
    //   9	16	34	finally
    //   18	23	34	finally
    //   41	43	34	finally
    //   9	16	38	java/lang/Throwable
    //   18	23	38	java/lang/Throwable
    //   51	57	68	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ab
 * JD-Core Version:    0.7.0.1
 */