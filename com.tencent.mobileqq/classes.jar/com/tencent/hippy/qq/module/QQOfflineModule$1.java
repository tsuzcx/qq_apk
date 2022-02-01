package com.tencent.hippy.qq.module;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.mtt.hippy.modules.Promise;
import org.json.JSONObject;

class QQOfflineModule$1
  implements AsyncBack
{
  QQOfflineModule$1(QQOfflineModule paramQQOfflineModule, JSONObject paramJSONObject, Promise paramPromise) {}
  
  /* Error */
  public void loaded(java.lang.String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +75 -> 79
    //   7: aload_0
    //   8: getfield 18	com/tencent/hippy/qq/module/QQOfflineModule$1:val$resultJSON	Lorg/json/JSONObject;
    //   11: ldc 38
    //   13: iconst_m1
    //   14: invokevirtual 44	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   17: pop
    //   18: aload_0
    //   19: getfield 18	com/tencent/hippy/qq/module/QQOfflineModule$1:val$resultJSON	Lorg/json/JSONObject;
    //   22: ldc 46
    //   24: ldc 48
    //   26: invokevirtual 51	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload_0
    //   31: getfield 16	com/tencent/hippy/qq/module/QQOfflineModule$1:this$0	Lcom/tencent/hippy/qq/module/QQOfflineModule;
    //   34: aload_0
    //   35: getfield 20	com/tencent/hippy/qq/module/QQOfflineModule$1:val$promise	Lcom/tencent/mtt/hippy/modules/Promise;
    //   38: aload_0
    //   39: getfield 18	com/tencent/hippy/qq/module/QQOfflineModule$1:val$resultJSON	Lorg/json/JSONObject;
    //   42: invokestatic 57	com/tencent/hippy/qq/module/QQOfflineModule:access$000	(Lcom/tencent/hippy/qq/module/QQOfflineModule;Lcom/tencent/mtt/hippy/modules/Promise;Lorg/json/JSONObject;)V
    //   45: return
    //   46: astore_1
    //   47: new 59	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   54: astore_3
    //   55: aload_3
    //   56: ldc 62
    //   58: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_3
    //   63: aload_1
    //   64: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: ldc 71
    //   70: iconst_1
    //   71: aload_3
    //   72: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: return
    //   79: aload_0
    //   80: getfield 18	com/tencent/hippy/qq/module/QQOfflineModule$1:val$resultJSON	Lorg/json/JSONObject;
    //   83: ldc 38
    //   85: iconst_0
    //   86: invokevirtual 44	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   89: pop
    //   90: aload_0
    //   91: getfield 18	com/tencent/hippy/qq/module/QQOfflineModule$1:val$resultJSON	Lorg/json/JSONObject;
    //   94: ldc 83
    //   96: aload_1
    //   97: invokestatic 89	com/tencent/biz/common/util/Util:a	(Ljava/lang/String;)Ljava/lang/String;
    //   100: invokevirtual 51	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   103: pop
    //   104: aload_0
    //   105: getfield 16	com/tencent/hippy/qq/module/QQOfflineModule$1:this$0	Lcom/tencent/hippy/qq/module/QQOfflineModule;
    //   108: aload_0
    //   109: getfield 20	com/tencent/hippy/qq/module/QQOfflineModule$1:val$promise	Lcom/tencent/mtt/hippy/modules/Promise;
    //   112: aload_0
    //   113: getfield 18	com/tencent/hippy/qq/module/QQOfflineModule$1:val$resultJSON	Lorg/json/JSONObject;
    //   116: invokestatic 57	com/tencent/hippy/qq/module/QQOfflineModule:access$000	(Lcom/tencent/hippy/qq/module/QQOfflineModule;Lcom/tencent/mtt/hippy/modules/Promise;Lorg/json/JSONObject;)V
    //   119: return
    //   120: astore_1
    //   121: goto +76 -> 197
    //   124: astore_1
    //   125: new 59	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   132: astore_3
    //   133: aload_3
    //   134: ldc 91
    //   136: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload_3
    //   141: aload_1
    //   142: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: ldc 71
    //   148: iconst_1
    //   149: aload_3
    //   150: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 94	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload_0
    //   157: getfield 18	com/tencent/hippy/qq/module/QQOfflineModule$1:val$resultJSON	Lorg/json/JSONObject;
    //   160: ldc 38
    //   162: iconst_m1
    //   163: invokevirtual 44	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   166: pop
    //   167: aload_0
    //   168: getfield 18	com/tencent/hippy/qq/module/QQOfflineModule$1:val$resultJSON	Lorg/json/JSONObject;
    //   171: ldc 46
    //   173: ldc 48
    //   175: invokevirtual 51	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   178: pop
    //   179: goto -75 -> 104
    //   182: astore_1
    //   183: ldc 71
    //   185: iconst_1
    //   186: aload_1
    //   187: iconst_0
    //   188: anewarray 4	java/lang/Object
    //   191: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   194: goto -90 -> 104
    //   197: aload_0
    //   198: getfield 16	com/tencent/hippy/qq/module/QQOfflineModule$1:this$0	Lcom/tencent/hippy/qq/module/QQOfflineModule;
    //   201: aload_0
    //   202: getfield 20	com/tencent/hippy/qq/module/QQOfflineModule$1:val$promise	Lcom/tencent/mtt/hippy/modules/Promise;
    //   205: aload_0
    //   206: getfield 18	com/tencent/hippy/qq/module/QQOfflineModule$1:val$resultJSON	Lorg/json/JSONObject;
    //   209: invokestatic 57	com/tencent/hippy/qq/module/QQOfflineModule:access$000	(Lcom/tencent/hippy/qq/module/QQOfflineModule;Lcom/tencent/mtt/hippy/modules/Promise;Lorg/json/JSONObject;)V
    //   212: goto +5 -> 217
    //   215: aload_1
    //   216: athrow
    //   217: goto -2 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	1
    //   0	220	1	paramString	java.lang.String
    //   0	220	2	paramInt	int
    //   54	96	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   7	45	46	org/json/JSONException
    //   79	104	120	finally
    //   125	156	120	finally
    //   156	179	120	finally
    //   183	194	120	finally
    //   79	104	124	java/lang/Throwable
    //   156	179	182	org/json/JSONException
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQOfflineModule.1
 * JD-Core Version:    0.7.0.1
 */