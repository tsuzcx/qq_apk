package com.qflutter.vistaimage;

import rx.functions.Action1;

class VistaImageProcessor$1
  implements Action1<TextureRecord>
{
  VistaImageProcessor$1(VistaImageProcessor paramVistaImageProcessor, IVistaImage paramIVistaImage) {}
  
  /* Error */
  public void a(TextureRecord paramTextureRecord)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: getfield 15	com/qflutter/vistaimage/VistaImageProcessor$1:a	Lcom/qflutter/vistaimage/VistaImageProcessor;
    //   5: invokestatic 30	com/qflutter/vistaimage/VistaImageProcessor:access$000	(Lcom/qflutter/vistaimage/VistaImageProcessor;)Lio/flutter/view/TextureRegistry;
    //   8: invokevirtual 36	com/qflutter/vistaimage/TextureRecord:make	(Lio/flutter/view/TextureRegistry;)J
    //   11: pop2
    //   12: aload_0
    //   13: getfield 17	com/qflutter/vistaimage/VistaImageProcessor$1:b	Lcom/qflutter/vistaimage/IVistaImage;
    //   16: aload_1
    //   17: invokevirtual 40	com/qflutter/vistaimage/TextureRecord:getImageUri	()Ljava/lang/String;
    //   20: invokeinterface 46 2 0
    //   25: aload_1
    //   26: invokevirtual 49	com/qflutter/vistaimage/TextureRecord:render	()V
    //   29: aload_0
    //   30: getfield 15	com/qflutter/vistaimage/VistaImageProcessor$1:a	Lcom/qflutter/vistaimage/VistaImageProcessor;
    //   33: invokestatic 53	com/qflutter/vistaimage/VistaImageProcessor:access$100	(Lcom/qflutter/vistaimage/VistaImageProcessor;)Ljava/util/Map;
    //   36: aload_1
    //   37: invokevirtual 57	com/qflutter/vistaimage/TextureRecord:getTextureId	()J
    //   40: invokestatic 63	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   43: aload_1
    //   44: invokeinterface 69 3 0
    //   49: pop
    //   50: goto +28 -> 78
    //   53: astore_2
    //   54: goto +29 -> 83
    //   57: astore_2
    //   58: ldc 71
    //   60: ldc 73
    //   62: aload_2
    //   63: invokestatic 79	com/qflutter/vistaimage/VistaImageLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   66: aload_1
    //   67: invokevirtual 82	com/qflutter/vistaimage/TextureRecord:release	()V
    //   70: aload_1
    //   71: ldc 84
    //   73: ldc 86
    //   75: invokevirtual 90	com/qflutter/vistaimage/TextureRecord:setError	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload_1
    //   79: invokevirtual 93	com/qflutter/vistaimage/TextureRecord:notifyDart	()V
    //   82: return
    //   83: aload_1
    //   84: invokevirtual 93	com/qflutter/vistaimage/TextureRecord:notifyDart	()V
    //   87: aload_2
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	1
    //   0	89	1	paramTextureRecord	TextureRecord
    //   53	1	2	localObject	Object
    //   57	31	2	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	50	53	finally
    //   58	78	53	finally
    //   0	50	57	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaimage.VistaImageProcessor.1
 * JD-Core Version:    0.7.0.1
 */