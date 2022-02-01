package com.tencent.hippy.qq.module;

import android.support.v4.util.ArraySet;
import com.tencent.mobileqq.bigbrother.TeleScreen;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import java.util.Iterator;

@HippyNativeModule(name="QQGdtModule")
public class QQGdtModule
  extends QQBaseModule
{
  static final String TAG = "QQGdtModule";
  private ArraySet<Integer> jumpCallbackIds = new ArraySet();
  
  public QQGdtModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  public void destroy()
  {
    super.destroy();
    if ((this.jumpCallbackIds != null) && (this.jumpCallbackIds.size() > 0))
    {
      Iterator localIterator = this.jumpCallbackIds.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        TeleScreen.a().a(i);
      }
      this.jumpCallbackIds.clear();
    }
  }
  
  /* Error */
  @com.tencent.mtt.hippy.annotation.HippyMethod(name="Openlink")
  public void openLink(com.tencent.mtt.hippy.common.HippyMap paramHippyMap, com.tencent.mtt.hippy.modules.Promise paramPromise)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +84 -> 85
    //   4: aload_1
    //   5: invokevirtual 79	com/tencent/mtt/hippy/common/HippyMap:toJSONObject	()Lorg/json/JSONObject;
    //   8: astore_1
    //   9: aload_1
    //   10: ldc 81
    //   12: invokevirtual 87	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore 4
    //   17: aload_1
    //   18: ldc 89
    //   20: invokevirtual 87	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore 5
    //   25: aload_1
    //   26: ldc 91
    //   28: invokevirtual 87	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   31: astore_1
    //   32: new 93	com/tencent/hippy/qq/module/QQGdtModule$1
    //   35: dup
    //   36: aload_0
    //   37: aload_2
    //   38: invokespecial 96	com/tencent/hippy/qq/module/QQGdtModule$1:<init>	(Lcom/tencent/hippy/qq/module/QQGdtModule;Lcom/tencent/mtt/hippy/modules/Promise;)V
    //   41: astore 6
    //   43: invokestatic 59	com/tencent/mobileqq/bigbrother/TeleScreen:a	()Lcom/tencent/mobileqq/bigbrother/TeleScreen;
    //   46: aload 6
    //   48: invokevirtual 99	com/tencent/mobileqq/bigbrother/TeleScreen:a	(Lcom/tencent/mobileqq/bigbrother/JumpCallback;)I
    //   51: istore_3
    //   52: aload_0
    //   53: getfield 24	com/tencent/hippy/qq/module/QQGdtModule:jumpCallbackIds	Landroid/support/v4/util/ArraySet;
    //   56: iload_3
    //   57: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: invokevirtual 107	android/support/v4/util/ArraySet:add	(Ljava/lang/Object;)Z
    //   63: pop
    //   64: aload 5
    //   66: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   69: ifne +40 -> 109
    //   72: aload_0
    //   73: invokevirtual 117	com/tencent/hippy/qq/module/QQGdtModule:getActivity	()Landroid/app/Activity;
    //   76: aload 5
    //   78: aload 4
    //   80: iload_3
    //   81: invokestatic 122	com/tencent/mobileqq/bigbrother/Utils:a	(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;I)V
    //   84: return
    //   85: new 83	org/json/JSONObject
    //   88: dup
    //   89: invokespecial 123	org/json/JSONObject:<init>	()V
    //   92: astore_1
    //   93: goto -84 -> 9
    //   96: astore_1
    //   97: ldc 10
    //   99: iconst_1
    //   100: aload_1
    //   101: iconst_0
    //   102: anewarray 125	java/lang/Object
    //   105: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   108: return
    //   109: aload_1
    //   110: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifne -29 -> 84
    //   116: aload_0
    //   117: invokevirtual 117	com/tencent/hippy/qq/module/QQGdtModule:getActivity	()Landroid/app/Activity;
    //   120: aload_1
    //   121: aconst_null
    //   122: aload 4
    //   124: iload_3
    //   125: invokestatic 136	com/tencent/mobileqq/utils/PackageUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z
    //   128: pop
    //   129: return
    //   130: astore_1
    //   131: aload_2
    //   132: ldc 138
    //   134: invokeinterface 144 2 0
    //   139: invokestatic 59	com/tencent/mobileqq/bigbrother/TeleScreen:a	()Lcom/tencent/mobileqq/bigbrother/TeleScreen;
    //   142: iload_3
    //   143: invokevirtual 62	com/tencent/mobileqq/bigbrother/TeleScreen:a	(I)V
    //   146: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	QQGdtModule
    //   0	147	1	paramHippyMap	com.tencent.mtt.hippy.common.HippyMap
    //   0	147	2	paramPromise	com.tencent.mtt.hippy.modules.Promise
    //   51	92	3	i	int
    //   15	108	4	str1	String
    //   23	54	5	str2	String
    //   41	6	6	local1	QQGdtModule.1
    // Exception table:
    //   from	to	target	type
    //   4	9	96	java/lang/Exception
    //   9	64	96	java/lang/Exception
    //   64	84	96	java/lang/Exception
    //   85	93	96	java/lang/Exception
    //   109	129	96	java/lang/Exception
    //   131	146	96	java/lang/Exception
    //   64	84	130	android/content/ActivityNotFoundException
    //   109	129	130	android/content/ActivityNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQGdtModule
 * JD-Core Version:    0.7.0.1
 */