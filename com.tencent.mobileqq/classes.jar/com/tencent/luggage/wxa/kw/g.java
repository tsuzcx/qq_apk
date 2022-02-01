package com.tencent.luggage.wxa.kw;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.a;

public final class g
  extends a<h>
{
  private static final int CTRL_INDEX = 77;
  private static final String NAME = "setKeyboardValue";
  
  /* Error */
  public void a(h paramh, org.json.JSONObject paramJSONObject, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 27	com/tencent/luggage/wxa/iu/h:v	()Lcom/tencent/mm/plugin/appbrand/page/u;
    //   4: astore 5
    //   6: aload 5
    //   8: ifnull +67 -> 75
    //   11: aload 5
    //   13: invokevirtual 33	com/tencent/mm/plugin/appbrand/page/u:d	()Z
    //   16: ifne +6 -> 22
    //   19: goto +56 -> 75
    //   22: aload_2
    //   23: ldc 35
    //   25: invokevirtual 41	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 4
    //   33: aload_2
    //   34: ldc 43
    //   36: invokevirtual 47	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   39: invokestatic 53	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   42: astore_2
    //   43: aload 5
    //   45: aload 6
    //   47: aload_2
    //   48: invokestatic 58	com/tencent/luggage/wxa/pp/o:a	(Lcom/tencent/mm/plugin/appbrand/page/u;Ljava/lang/String;Ljava/lang/Integer;)V
    //   51: aload_1
    //   52: iload_3
    //   53: aload_0
    //   54: ldc 60
    //   56: invokevirtual 63	com/tencent/luggage/wxa/kw/g:b	(Ljava/lang/String;)Ljava/lang/String;
    //   59: invokevirtual 66	com/tencent/luggage/wxa/iu/h:a	(ILjava/lang/String;)V
    //   62: return
    //   63: aload_1
    //   64: iload_3
    //   65: aload_0
    //   66: ldc 68
    //   68: invokevirtual 63	com/tencent/luggage/wxa/kw/g:b	(Ljava/lang/String;)Ljava/lang/String;
    //   71: invokevirtual 66	com/tencent/luggage/wxa/iu/h:a	(ILjava/lang/String;)V
    //   74: return
    //   75: aload_1
    //   76: iload_3
    //   77: aload_0
    //   78: ldc 70
    //   80: invokevirtual 63	com/tencent/luggage/wxa/kw/g:b	(Ljava/lang/String;)Ljava/lang/String;
    //   83: invokevirtual 66	com/tencent/luggage/wxa/iu/h:a	(ILjava/lang/String;)V
    //   86: return
    //   87: astore_2
    //   88: goto -25 -> 63
    //   91: astore_2
    //   92: aload 4
    //   94: astore_2
    //   95: goto -52 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	g
    //   0	98	1	paramh	h
    //   0	98	2	paramJSONObject	org.json.JSONObject
    //   0	98	3	paramInt	int
    //   31	62	4	localObject	java.lang.Object
    //   4	40	5	localu	com.tencent.mm.plugin.appbrand.page.u
    //   28	18	6	str	String
    // Exception table:
    //   from	to	target	type
    //   22	30	87	java/lang/Exception
    //   33	43	91	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kw.g
 * JD-Core Version:    0.7.0.1
 */