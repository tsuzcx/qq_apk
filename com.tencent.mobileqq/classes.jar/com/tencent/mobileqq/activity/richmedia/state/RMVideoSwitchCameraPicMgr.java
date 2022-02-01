package com.tencent.mobileqq.activity.richmedia.state;

import alxt;
import alyb;
import alyc;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import bczp;
import bhsp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import yuk;
import zoc;

public class RMVideoSwitchCameraPicMgr
{
  private alyb jdField_a_of_type_Alyb = new alyb(this, null);
  alyc jdField_a_of_type_Alyc = null;
  
  private Bitmap a(int paramInt1, int paramInt2, alxt paramalxt)
  {
    Bitmap localBitmap = null;
    if (this.jdField_a_of_type_Alyc != null) {
      localBitmap = this.jdField_a_of_type_Alyc.a(paramInt1, paramInt2);
    }
    if ((paramalxt == null) || (localBitmap == null)) {
      return localBitmap;
    }
    for (;;)
    {
      try
      {
        paramalxt = Bitmap.createBitmap(localBitmap, paramalxt.jdField_b_of_type_Int, paramalxt.jdField_a_of_type_Int, paramalxt.c, paramalxt.d);
        if (paramalxt != null) {
          return paramalxt;
        }
      }
      catch (IllegalArgumentException paramalxt)
      {
        paramalxt.printStackTrace();
        return localBitmap;
      }
      catch (OutOfMemoryError paramalxt)
      {
        paramalxt.printStackTrace();
        return localBitmap;
      }
      paramalxt = localBitmap;
    }
  }
  
  private Bitmap a(alxt paramalxt)
  {
    int[] arrayOfInt;
    if (paramalxt != null)
    {
      arrayOfInt = new int[6];
      arrayOfInt[0] = paramalxt.jdField_a_of_type_Int;
      arrayOfInt[1] = paramalxt.jdField_b_of_type_Int;
      arrayOfInt[2] = paramalxt.c;
      arrayOfInt[3] = paramalxt.d;
      arrayOfInt[4] = paramalxt.e;
      arrayOfInt[5] = paramalxt.f;
    }
    for (paramalxt = arrayOfInt;; paramalxt = null) {
      try
      {
        paramalxt = getPreprocessBitmap(paramalxt);
        return paramalxt;
      }
      catch (UnsatisfiedLinkError paramalxt)
      {
        paramalxt.printStackTrace();
        return null;
      }
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return null;
    }
    bhsp.a(paramBitmap, paramInt);
    return paramBitmap;
  }
  
  private String a()
  {
    String str = "shortvideo_cover_pic";
    if (this.jdField_a_of_type_Alyb.jdField_b_of_type_Boolean) {
      str = "ptv_cover_pic";
    }
    return bczp.a + File.separator + str + ".jpg";
  }
  
  private String b()
  {
    return bczp.a + File.separator + "player_cover_pic" + ".jpg";
  }
  
  private native Bitmap getPreprocessBitmap(int[] paramArrayOfInt);
  
  public Bitmap a()
  {
    Object localObject = null;
    String str = b();
    if (new File(str).exists())
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      ((BitmapFactory.Options)localObject).inSampleSize = 4;
    }
    try
    {
      localObject = BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
  
  public Bitmap a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, alxt paramalxt)
  {
    this.jdField_a_of_type_Alyb.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Alyb.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Alyb.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Alyb.jdField_b_of_type_Boolean = paramBoolean2;
    if ((this.jdField_a_of_type_Alyb.jdField_a_of_type_Int <= 0) || (this.jdField_a_of_type_Alyb.jdField_b_of_type_Int <= 0)) {
      this.jdField_a_of_type_Alyb.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_Alyc == null) {
      this.jdField_a_of_type_Alyb.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_Alyb.jdField_a_of_type_Boolean) {
      return a(paramalxt);
    }
    return a(this.jdField_a_of_type_Alyb.jdField_b_of_type_Int, this.jdField_a_of_type_Alyb.jdField_a_of_type_Int, paramalxt);
  }
  
  public Bitmap a(boolean paramBoolean)
  {
    Object localObject = null;
    this.jdField_a_of_type_Alyb.jdField_b_of_type_Boolean = paramBoolean;
    String str = a();
    if (new File(str).exists())
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      ((BitmapFactory.Options)localObject).inSampleSize = 2;
    }
    try
    {
      localObject = BitmapFactory.decodeFile(str);
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, alxt paramalxt)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: iload_3
    //   4: iload 4
    //   6: aload 5
    //   8: invokevirtual 160	com/tencent/mobileqq/activity/richmedia/state/RMVideoSwitchCameraPicMgr:a	(IIZZLalxt;)Landroid/graphics/Bitmap;
    //   11: astore 8
    //   13: aload_0
    //   14: invokespecial 150	com/tencent/mobileqq/activity/richmedia/state/RMVideoSwitchCameraPicMgr:a	()Ljava/lang/String;
    //   17: astore 5
    //   19: aload 8
    //   21: ifnull +71 -> 92
    //   24: aload 5
    //   26: ifnull +66 -> 92
    //   29: new 97	java/io/File
    //   32: dup
    //   33: aload 5
    //   35: invokespecial 113	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore 5
    //   40: aconst_null
    //   41: astore 7
    //   43: aconst_null
    //   44: astore 6
    //   46: new 162	java/io/BufferedOutputStream
    //   49: dup
    //   50: new 164	java/io/FileOutputStream
    //   53: dup
    //   54: aload 5
    //   56: invokespecial 167	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   59: invokespecial 170	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   62: astore 5
    //   64: aload 8
    //   66: getstatic 176	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   69: bipush 80
    //   71: aload 5
    //   73: invokevirtual 180	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   76: pop
    //   77: aload 5
    //   79: invokevirtual 183	java/io/BufferedOutputStream:flush	()V
    //   82: aload 5
    //   84: ifnull +8 -> 92
    //   87: aload 5
    //   89: invokevirtual 186	java/io/BufferedOutputStream:close	()V
    //   92: return
    //   93: astore 5
    //   95: aconst_null
    //   96: astore 5
    //   98: aload 5
    //   100: ifnull -8 -> 92
    //   103: aload 5
    //   105: invokevirtual 186	java/io/BufferedOutputStream:close	()V
    //   108: return
    //   109: astore 5
    //   111: return
    //   112: astore 5
    //   114: aload 6
    //   116: astore 5
    //   118: aload 5
    //   120: ifnull -28 -> 92
    //   123: aload 5
    //   125: invokevirtual 186	java/io/BufferedOutputStream:close	()V
    //   128: return
    //   129: astore 5
    //   131: return
    //   132: astore 5
    //   134: aload 7
    //   136: astore 6
    //   138: aload 6
    //   140: ifnull +8 -> 148
    //   143: aload 6
    //   145: invokevirtual 186	java/io/BufferedOutputStream:close	()V
    //   148: aload 5
    //   150: athrow
    //   151: astore 5
    //   153: return
    //   154: astore 6
    //   156: goto -8 -> 148
    //   159: astore 7
    //   161: aload 5
    //   163: astore 6
    //   165: aload 7
    //   167: astore 5
    //   169: goto -31 -> 138
    //   172: astore 6
    //   174: goto -56 -> 118
    //   177: astore 6
    //   179: goto -81 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	RMVideoSwitchCameraPicMgr
    //   0	182	1	paramInt1	int
    //   0	182	2	paramInt2	int
    //   0	182	3	paramBoolean1	boolean
    //   0	182	4	paramBoolean2	boolean
    //   0	182	5	paramalxt	alxt
    //   44	100	6	localObject1	Object
    //   154	1	6	localIOException1	java.io.IOException
    //   163	1	6	localalxt	alxt
    //   172	1	6	localIOException2	java.io.IOException
    //   177	1	6	localFileNotFoundException	java.io.FileNotFoundException
    //   41	94	7	localObject2	Object
    //   159	7	7	localObject3	Object
    //   11	54	8	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   46	64	93	java/io/FileNotFoundException
    //   103	108	109	java/io/IOException
    //   46	64	112	java/io/IOException
    //   123	128	129	java/io/IOException
    //   46	64	132	finally
    //   87	92	151	java/io/IOException
    //   143	148	154	java/io/IOException
    //   64	82	159	finally
    //   64	82	172	java/io/IOException
    //   64	82	177	java/io/FileNotFoundException
  }
  
  public void a(Bitmap paramBitmap)
  {
    boolean bool2 = false;
    try
    {
      long l = System.currentTimeMillis();
      boolean bool1 = bool2;
      if (paramBitmap != null)
      {
        paramBitmap = a(zoc.a(paramBitmap, 0.6F, false), 40, false);
        bool1 = bool2;
        if (paramBitmap != null) {
          bool1 = zoc.a(paramBitmap, a());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("RMVideoSwitchCameraPicMgr", 2, "generateBlurCoverPic result:" + bool1 + ", cost:" + (System.currentTimeMillis() - l) / 1000.0D);
      }
      return;
    }
    catch (Exception paramBitmap)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("RMVideoSwitchCameraPicMgr", 2, "generateBlurCoverPic exception:" + paramBitmap);
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("RMVideoSwitchCameraPicMgr", 2, "generateBlurCoverPic OutOfMemoryError:" + paramBitmap);
    }
  }
  
  public void b(Bitmap paramBitmap)
  {
    paramBitmap = zoc.a(paramBitmap, 0.6F, false);
    if (paramBitmap == null)
    {
      yuk.e("RMVideoSwitchCameraPicMgr", "resize bitmap failed!");
      return;
    }
    if (zoc.a(paramBitmap, b()))
    {
      yuk.c("RMVideoSwitchCameraPicMgr", "save cover bitmap to file success.");
      return;
    }
    yuk.e("RMVideoSwitchCameraPicMgr", "save cover bitmap to file error.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr
 * JD-Core Version:    0.7.0.1
 */