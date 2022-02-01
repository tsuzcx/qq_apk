package com.qflutter.vistaimage;

import rx.functions.Action1;

class VistaImageProcessor$1
  implements Action1<TextureRecord>
{
  VistaImageProcessor$1(VistaImageProcessor paramVistaImageProcessor) {}
  
  /* Error */
  public void a(TextureRecord paramTextureRecord)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: getfield 13	com/qflutter/vistaimage/VistaImageProcessor$1:a	Lcom/qflutter/vistaimage/VistaImageProcessor;
    //   5: invokestatic 26	com/qflutter/vistaimage/VistaImageProcessor:access$000	(Lcom/qflutter/vistaimage/VistaImageProcessor;)Lio/flutter/view/TextureRegistry;
    //   8: invokevirtual 32	com/qflutter/vistaimage/TextureRecord:make	(Lio/flutter/view/TextureRegistry;)J
    //   11: pop2
    //   12: aload_0
    //   13: getfield 13	com/qflutter/vistaimage/VistaImageProcessor$1:a	Lcom/qflutter/vistaimage/VistaImageProcessor;
    //   16: invokestatic 36	com/qflutter/vistaimage/VistaImageProcessor:access$100	(Lcom/qflutter/vistaimage/VistaImageProcessor;)Lcom/qflutter/vistaimage/IVistaImage;
    //   19: aload_1
    //   20: invokevirtual 40	com/qflutter/vistaimage/TextureRecord:getImageUri	()Ljava/lang/String;
    //   23: invokeinterface 46 2 0
    //   28: aload_1
    //   29: invokevirtual 49	com/qflutter/vistaimage/TextureRecord:render	()V
    //   32: aload_0
    //   33: getfield 13	com/qflutter/vistaimage/VistaImageProcessor$1:a	Lcom/qflutter/vistaimage/VistaImageProcessor;
    //   36: invokestatic 53	com/qflutter/vistaimage/VistaImageProcessor:access$200	(Lcom/qflutter/vistaimage/VistaImageProcessor;)Ljava/util/Map;
    //   39: aload_1
    //   40: invokevirtual 57	com/qflutter/vistaimage/TextureRecord:getTextureId	()J
    //   43: invokestatic 63	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   46: aload_1
    //   47: invokeinterface 69 3 0
    //   52: pop
    //   53: goto +28 -> 81
    //   56: astore_2
    //   57: goto +29 -> 86
    //   60: astore_2
    //   61: ldc 71
    //   63: ldc 73
    //   65: aload_2
    //   66: invokestatic 79	com/qflutter/vistaimage/VistaImageLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   69: aload_1
    //   70: invokevirtual 82	com/qflutter/vistaimage/TextureRecord:release	()V
    //   73: aload_1
    //   74: ldc 84
    //   76: ldc 86
    //   78: invokevirtual 90	com/qflutter/vistaimage/TextureRecord:setError	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload_1
    //   82: invokevirtual 93	com/qflutter/vistaimage/TextureRecord:notifyDart	()V
    //   85: return
    //   86: aload_1
    //   87: invokevirtual 93	com/qflutter/vistaimage/TextureRecord:notifyDart	()V
    //   90: aload_2
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	1
    //   0	92	1	paramTextureRecord	TextureRecord
    //   56	1	2	localObject	Object
    //   60	31	2	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   0	53	56	finally
    //   61	81	56	finally
    //   0	53	60	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.vistaimage.VistaImageProcessor.1
 * JD-Core Version:    0.7.0.1
 */