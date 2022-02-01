package com.tencent.aelight.camera.ae.camera.autotest;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.ae.camera.autotest.beans.AutoTestConfigBeans.AutoTestNode;
import com.tencent.qphone.base.util.QLog;
import com.tencent.view.RendererUtils;
import java.util.List;

public class AutoImageTestManager
{
  private ImageNode a = null;
  private List<AutoTestConfigBeans.AutoTestNode> b;
  private int c = 0;
  private AutoImageTestManager.IParamsListener d;
  
  protected AutoImageTestManager(List<AutoTestConfigBeans.AutoTestNode> paramList)
  {
    this.b = paramList;
  }
  
  /* Error */
  public static com.tencent.ttpic.baseutils.bitmap.BitmapUtils.SAVE_STATUS a(Bitmap paramBitmap, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 4
    //   9: aload 4
    //   11: astore_3
    //   12: new 34	java/io/File
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 7
    //   22: aload 4
    //   24: astore_3
    //   25: aload 7
    //   27: invokevirtual 41	java/io/File:getParentFile	()Ljava/io/File;
    //   30: astore 8
    //   32: aload 4
    //   34: astore_3
    //   35: aload 8
    //   37: invokevirtual 45	java/io/File:exists	()Z
    //   40: ifne +12 -> 52
    //   43: aload 4
    //   45: astore_3
    //   46: aload 8
    //   48: invokevirtual 48	java/io/File:mkdirs	()Z
    //   51: pop
    //   52: aload 4
    //   54: astore_3
    //   55: aload 7
    //   57: invokevirtual 45	java/io/File:exists	()Z
    //   60: ifne +12 -> 72
    //   63: aload 4
    //   65: astore_3
    //   66: aload 7
    //   68: invokevirtual 51	java/io/File:createNewFile	()Z
    //   71: pop
    //   72: aload 4
    //   74: astore_3
    //   75: new 53	java/io/FileOutputStream
    //   78: dup
    //   79: aload_1
    //   80: invokespecial 54	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   83: astore 4
    //   85: aload_0
    //   86: ifnull +19 -> 105
    //   89: aload_0
    //   90: getstatic 60	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   93: iload_2
    //   94: aload 4
    //   96: invokevirtual 66	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   99: pop
    //   100: aload 4
    //   102: invokevirtual 69	java/io/FileOutputStream:flush	()V
    //   105: aload 4
    //   107: invokevirtual 72	java/io/FileOutputStream:close	()V
    //   110: getstatic 78	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_SUCCESS	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   113: astore_3
    //   114: aload 4
    //   116: invokestatic 84	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   119: aload_3
    //   120: areturn
    //   121: astore_0
    //   122: aload 4
    //   124: astore_3
    //   125: goto +108 -> 233
    //   128: astore 5
    //   130: goto +20 -> 150
    //   133: astore_1
    //   134: aload 4
    //   136: astore_0
    //   137: goto +78 -> 215
    //   140: astore_0
    //   141: goto +92 -> 233
    //   144: astore 5
    //   146: aload 6
    //   148: astore 4
    //   150: aload 4
    //   152: astore_3
    //   153: aload 5
    //   155: invokestatic 90	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   158: aload 4
    //   160: astore_3
    //   161: ldc 92
    //   163: iconst_3
    //   164: anewarray 4	java/lang/Object
    //   167: dup
    //   168: iconst_0
    //   169: aload_1
    //   170: aastore
    //   171: dup
    //   172: iconst_1
    //   173: aload_0
    //   174: invokevirtual 96	android/graphics/Bitmap:getWidth	()I
    //   177: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   180: aastore
    //   181: dup
    //   182: iconst_2
    //   183: aload_0
    //   184: invokevirtual 105	android/graphics/Bitmap:getHeight	()I
    //   187: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   190: aastore
    //   191: invokestatic 111	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   194: invokestatic 116	com/tencent/ttpic/baseutils/report/ReportUtil:report	(Ljava/lang/String;)V
    //   197: aload 4
    //   199: astore_3
    //   200: getstatic 119	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_OOM	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   203: astore_0
    //   204: aload 4
    //   206: invokestatic 84	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   209: aload_0
    //   210: areturn
    //   211: astore_1
    //   212: aload 5
    //   214: astore_0
    //   215: aload_0
    //   216: astore_3
    //   217: aload_1
    //   218: invokestatic 90	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   221: aload_0
    //   222: astore_3
    //   223: getstatic 122	com/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS:SAVE_FAILED	Lcom/tencent/ttpic/baseutils/bitmap/BitmapUtils$SAVE_STATUS;
    //   226: astore_1
    //   227: aload_0
    //   228: invokestatic 84	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   231: aload_1
    //   232: areturn
    //   233: aload_3
    //   234: invokestatic 84	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   237: aload_0
    //   238: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	paramBitmap	Bitmap
    //   0	239	1	paramString	String
    //   0	239	2	paramInt	int
    //   11	223	3	localObject1	Object
    //   7	198	4	localObject2	Object
    //   4	1	5	localObject3	Object
    //   128	1	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   144	69	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1	146	6	localObject4	Object
    //   20	47	7	localFile1	java.io.File
    //   30	17	8	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   89	105	121	finally
    //   105	114	121	finally
    //   89	105	128	java/lang/OutOfMemoryError
    //   105	114	128	java/lang/OutOfMemoryError
    //   89	105	133	java/lang/Exception
    //   105	114	133	java/lang/Exception
    //   12	22	140	finally
    //   25	32	140	finally
    //   35	43	140	finally
    //   46	52	140	finally
    //   55	63	140	finally
    //   66	72	140	finally
    //   75	85	140	finally
    //   153	158	140	finally
    //   161	197	140	finally
    //   200	204	140	finally
    //   217	221	140	finally
    //   223	227	140	finally
    //   12	22	144	java/lang/OutOfMemoryError
    //   25	32	144	java/lang/OutOfMemoryError
    //   35	43	144	java/lang/OutOfMemoryError
    //   46	52	144	java/lang/OutOfMemoryError
    //   55	63	144	java/lang/OutOfMemoryError
    //   66	72	144	java/lang/OutOfMemoryError
    //   75	85	144	java/lang/OutOfMemoryError
    //   12	22	211	java/lang/Exception
    //   25	32	211	java/lang/Exception
    //   35	43	211	java/lang/Exception
    //   46	52	211	java/lang/Exception
    //   55	63	211	java/lang/Exception
    //   66	72	211	java/lang/Exception
    //   75	85	211	java/lang/Exception
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Object localObject = RendererUtils.saveTexture(paramInt1, paramInt2, paramInt3);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveTextureID2File|failed!bitmap is null ,path:");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("AutoImageTestManager", 4, ((StringBuilder)localObject).toString());
      return;
    }
    a((Bitmap)localObject, paramString, 100);
    ((Bitmap)localObject).recycle();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saveTextureID2File|successful!path:");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("AutoImageTestManager", 4, ((StringBuilder)localObject).toString());
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    ImageNode localImageNode = this.a;
    if (localImageNode == null) {
      return;
    }
    if (localImageNode.e())
    {
      this.a.a(null);
      this.a = null;
      this.c += 1;
      return;
    }
    this.a.d();
    if ((this.a.f()) && (this.a.b() != null)) {
      a(paramInt1, paramInt2, paramInt3, this.a.b());
    }
  }
  
  public void a(AutoImageTestManager.IParamsListener paramIParamsListener)
  {
    this.d = paramIParamsListener;
  }
  
  public boolean a()
  {
    return this.a == null;
  }
  
  public String b()
  {
    if (this.a == null)
    {
      List localList = this.b;
      if (localList != null)
      {
        int i = localList.size();
        int j = this.c;
        if ((i > j) && (this.b.get(j) != null))
        {
          this.a = new ImageNode((AutoTestConfigBeans.AutoTestNode)this.b.get(this.c));
          this.a.a(this.d);
          break label92;
        }
      }
      return null;
    }
    label92:
    return this.a.a();
  }
  
  public boolean c()
  {
    ImageNode localImageNode = this.a;
    return (localImageNode != null) && (localImageNode.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.autotest.AutoImageTestManager
 * JD-Core Version:    0.7.0.1
 */