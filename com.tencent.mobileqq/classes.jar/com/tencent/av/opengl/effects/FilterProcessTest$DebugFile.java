package com.tencent.av.opengl.effects;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;

class FilterProcessTest$DebugFile
{
  private String a;
  private String b;
  private FileOutputStream c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public FilterProcessTest$DebugFile(String paramString)
  {
    this.a = paramString;
    this.b = null;
    this.d = 0;
    this.e = 0;
    this.g = 0;
    this.f = 0;
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/tencent/av/opengl/effects/FilterProcessTest$DebugFile:c	Ljava/io/FileOutputStream;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +198 -> 204
    //   9: aload_1
    //   10: invokevirtual 41	java/io/FileOutputStream:flush	()V
    //   13: aload_0
    //   14: getfield 36	com/tencent/av/opengl/effects/FilterProcessTest$DebugFile:c	Ljava/io/FileOutputStream;
    //   17: invokevirtual 44	java/io/FileOutputStream:close	()V
    //   20: goto +45 -> 65
    //   23: astore_1
    //   24: invokestatic 50	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   27: ifeq +38 -> 65
    //   30: new 52	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   37: astore_2
    //   38: aload_2
    //   39: ldc 55
    //   41: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_2
    //   46: aload_0
    //   47: getfield 23	com/tencent/av/opengl/effects/FilterProcessTest$DebugFile:b	Ljava/lang/String;
    //   50: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: ldc 61
    //   56: iconst_4
    //   57: aload_2
    //   58: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: aload_1
    //   62: invokestatic 69	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   65: aload_0
    //   66: aconst_null
    //   67: putfield 36	com/tencent/av/opengl/effects/FilterProcessTest$DebugFile:c	Ljava/io/FileOutputStream;
    //   70: return
    //   71: astore_1
    //   72: goto +73 -> 145
    //   75: astore_1
    //   76: invokestatic 50	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   79: ifeq +38 -> 117
    //   82: new 52	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   89: astore_2
    //   90: aload_2
    //   91: ldc 71
    //   93: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_2
    //   98: aload_0
    //   99: getfield 23	com/tencent/av/opengl/effects/FilterProcessTest$DebugFile:b	Ljava/lang/String;
    //   102: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: ldc 61
    //   108: iconst_4
    //   109: aload_2
    //   110: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: aload_1
    //   114: invokestatic 69	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   117: aload_0
    //   118: getfield 36	com/tencent/av/opengl/effects/FilterProcessTest$DebugFile:c	Ljava/io/FileOutputStream;
    //   121: invokevirtual 44	java/io/FileOutputStream:close	()V
    //   124: goto -59 -> 65
    //   127: astore_1
    //   128: invokestatic 50	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   131: ifeq -66 -> 65
    //   134: new 52	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   141: astore_2
    //   142: goto -104 -> 38
    //   145: aload_0
    //   146: getfield 36	com/tencent/av/opengl/effects/FilterProcessTest$DebugFile:c	Ljava/io/FileOutputStream;
    //   149: invokevirtual 44	java/io/FileOutputStream:close	()V
    //   152: goto +45 -> 197
    //   155: astore_2
    //   156: invokestatic 50	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   159: ifeq +38 -> 197
    //   162: new 52	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   169: astore_3
    //   170: aload_3
    //   171: ldc 55
    //   173: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_3
    //   178: aload_0
    //   179: getfield 23	com/tencent/av/opengl/effects/FilterProcessTest$DebugFile:b	Ljava/lang/String;
    //   182: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: ldc 61
    //   188: iconst_4
    //   189: aload_3
    //   190: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: aload_2
    //   194: invokestatic 69	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   197: aload_0
    //   198: aconst_null
    //   199: putfield 36	com/tencent/av/opengl/effects/FilterProcessTest$DebugFile:c	Ljava/io/FileOutputStream;
    //   202: aload_1
    //   203: athrow
    //   204: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	DebugFile
    //   4	6	1	localFileOutputStream	FileOutputStream
    //   23	39	1	localThrowable1	Throwable
    //   71	1	1	localObject	Object
    //   75	39	1	localThrowable2	Throwable
    //   127	76	1	localThrowable3	Throwable
    //   37	105	2	localStringBuilder1	StringBuilder
    //   155	39	2	localThrowable4	Throwable
    //   169	21	3	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   13	20	23	java/lang/Throwable
    //   9	13	71	finally
    //   76	117	71	finally
    //   9	13	75	java/lang/Throwable
    //   117	124	127	java/lang/Throwable
    //   145	152	155	java/lang/Throwable
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FilterProcessTest", 4, String.format("DebugFile-end size[%s, %s], fmt[%s], frame[%s], path[%s]", new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), this.b }));
    }
    b();
    this.d = 0;
    this.e = 0;
    this.g = 0;
    this.f = 0;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if ((paramArrayOfByte != null) && (paramInt2 != 0))
    {
      if (paramInt3 == 0) {
        return;
      }
      if ((this.c == null) || (this.d != paramInt2) || (this.e != paramInt3) || (this.f != paramInt1))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("FilterProcessTest", 4, String.format("DebugFile-save pre_size[%s,%s], cur_size[%s,%s], pre_fmt[%s], cur_fmt[%s], count[%s]", new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.f), Integer.valueOf(paramInt1), Integer.valueOf(this.g) }));
        }
        b();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(FilterProcessTest.a(paramInt2, paramInt3, paramInt1));
        ((StringBuilder)localObject).append(".yuv");
        this.b = ((StringBuilder)localObject).toString();
        localObject = new File(this.b);
        if ((((File)localObject).exists()) && (((File)localObject).isFile()) && (!((File)localObject).delete()) && (QLog.isDevelopLevel()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("DebugFile-save del fail path: ");
          ((StringBuilder)localObject).append(this.b);
          QLog.i("FilterProcessTest", 4, ((StringBuilder)localObject).toString());
        }
      }
    }
    try
    {
      this.c = new FileOutputStream(this.b);
    }
    catch (Throwable localThrowable)
    {
      label291:
      break label291;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DebugFile-save create FileOutputStream fail path: ");
      ((StringBuilder)localObject).append(this.b);
      QLog.i("FilterProcessTest", 4, ((StringBuilder)localObject).toString());
    }
    this.d = paramInt2;
    this.e = paramInt3;
    this.g = 0;
    this.f = paramInt1;
    this.g += 1;
    FilterProcessTest.a(this.c, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.FilterProcessTest.DebugFile
 * JD-Core Version:    0.7.0.1
 */