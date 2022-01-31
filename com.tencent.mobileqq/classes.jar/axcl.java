import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build.VERSION;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.Texture.1;
import com.tencent.mobileqq.surfaceviewaction.gl.Texture.2;
import com.tencent.mobileqq.surfaceviewaction.gl.Texture.3;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class axcl
{
  public int a;
  public Bitmap a;
  private SpriteGLView jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte;
  public boolean b;
  
  public axcl(Context paramContext, SpriteGLView paramSpriteGLView, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      this.jdField_a_of_type_ArrayOfByte = a(paramString);
      return;
    }
    catch (IOException paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Texture", 2, QLog.getStackTraceString(paramContext));
    }
  }
  
  public axcl(SpriteGLView paramSpriteGLView, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = paramSpriteGLView;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Boolean = true;
    paramSpriteGLView.b(new Texture.1(this));
  }
  
  /* Error */
  private byte[] a(String paramString)
  {
    // Byte code:
    //   0: new 65	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 7
    //   10: aload 7
    //   12: invokevirtual 72	java/io/File:length	()J
    //   15: lstore 4
    //   17: lload 4
    //   19: ldc2_w 73
    //   22: lcmp
    //   23: ifle +7 -> 30
    //   26: aconst_null
    //   27: astore_1
    //   28: aload_1
    //   29: areturn
    //   30: new 76	java/io/FileInputStream
    //   33: dup
    //   34: aload 7
    //   36: invokespecial 79	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   39: astore_1
    //   40: lload 4
    //   42: l2i
    //   43: istore_2
    //   44: iload_2
    //   45: newarray byte
    //   47: astore 6
    //   49: iconst_0
    //   50: istore_2
    //   51: iload_2
    //   52: aload 6
    //   54: arraylength
    //   55: if_icmpge +98 -> 153
    //   58: aload_1
    //   59: aload 6
    //   61: iload_2
    //   62: aload 6
    //   64: arraylength
    //   65: iload_2
    //   66: isub
    //   67: invokevirtual 83	java/io/FileInputStream:read	([BII)I
    //   70: istore_3
    //   71: iload_3
    //   72: iflt +81 -> 153
    //   75: iload_2
    //   76: iload_3
    //   77: iadd
    //   78: istore_2
    //   79: goto -28 -> 51
    //   82: astore 6
    //   84: aload_1
    //   85: invokevirtual 86	java/io/FileInputStream:close	()V
    //   88: new 16	java/io/IOException
    //   91: dup
    //   92: new 88	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   99: ldc 91
    //   101: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: lload 4
    //   106: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   109: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokespecial 103	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   115: athrow
    //   116: astore 6
    //   118: aload_1
    //   119: invokevirtual 86	java/io/FileInputStream:close	()V
    //   122: new 16	java/io/IOException
    //   125: dup
    //   126: new 88	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   133: ldc 105
    //   135: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 7
    //   140: invokevirtual 108	java/io/File:getName	()Ljava/lang/String;
    //   143: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokespecial 103	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   152: athrow
    //   153: iload_2
    //   154: aload 6
    //   156: arraylength
    //   157: if_icmpeq +38 -> 195
    //   160: aload_1
    //   161: invokevirtual 86	java/io/FileInputStream:close	()V
    //   164: new 16	java/io/IOException
    //   167: dup
    //   168: new 88	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   175: ldc 105
    //   177: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload 7
    //   182: invokevirtual 108	java/io/File:getName	()Ljava/lang/String;
    //   185: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokespecial 103	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   194: athrow
    //   195: aload_1
    //   196: invokevirtual 86	java/io/FileInputStream:close	()V
    //   199: aload 6
    //   201: astore_1
    //   202: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq -177 -> 28
    //   208: ldc 38
    //   210: iconst_2
    //   211: new 88	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   218: ldc 110
    //   220: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_0
    //   224: getfield 25	axcl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   227: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 46	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload 6
    //   238: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	axcl
    //   0	239	1	paramString	String
    //   43	115	2	i	int
    //   70	8	3	j	int
    //   15	90	4	l	long
    //   47	16	6	arrayOfByte	byte[]
    //   82	1	6	localOutOfMemoryError	OutOfMemoryError
    //   116	121	6	localIOException	IOException
    //   8	173	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   44	49	82	java/lang/OutOfMemoryError
    //   51	71	116	java/io/IOException
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        long l = System.currentTimeMillis();
        localOptions = new BitmapFactory.Options();
        if (Build.VERSION.SDK_INT <= 19) {
          continue;
        }
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeByteArray(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length, localOptions);
        int i = (int)(System.currentTimeMillis() - l);
        if (QLog.isColorLevel()) {
          QLog.d("Texture", 2, "new Texture: decode time = " + i);
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b(new Texture.2(this));
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        BitmapFactory.Options localOptions;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Texture", 2, "Texture: cannot decode (" + this.jdField_a_of_type_JavaLangString + "): " + QLog.getStackTraceString(localOutOfMemoryError));
        continue;
      }
      this.jdField_a_of_type_ArrayOfByte = null;
      return;
      localOptions.inPreferredConfig = Bitmap.Config.ARGB_4444;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Texture.3 local3 = new Texture.3(this);
    if (paramBoolean)
    {
      local3.run();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b(local3);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) || (this.b)) {}
    do
    {
      return;
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = arrayOfInt[0];
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b(this.jdField_a_of_type_Int);
      GLES20.glBindTexture(3553, this.jdField_a_of_type_Int);
      GLUtils.texImage2D(3553, 0, this.jdField_a_of_type_AndroidGraphicsBitmap, 0);
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10240, 9728.0F);
      GLES20.glBindTexture(3553, 0);
      if (!this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.c) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.b = true;
    } while (!QLog.isColorLevel());
    QLog.d("Texture", 2, "Texture->load: textureId = " + this.jdField_a_of_type_Int + ", filePath = " + this.jdField_a_of_type_JavaLangString);
  }
  
  public void c()
  {
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axcl
 * JD-Core Version:    0.7.0.1
 */