package com.tencent.luggage.wxa.rt;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ry.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;

public class f
  extends a
{
  public static final Parcelable.Creator<f> CREATOR = new f.2();
  private final String a;
  private final boolean b;
  private volatile String c;
  private boolean d;
  
  protected f(Parcel paramParcel)
  {
    o.a(paramParcel, f.class, 2);
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {
      paramParcel = "";
    } else {
      paramParcel = o.a(paramParcel, true, false);
    }
    this.a = paramParcel;
    if (this.a.isEmpty())
    {
      this.c = this.a;
      this.b = true;
      this.d = true;
      return;
    }
    paramParcel = o.a(this.a, e.a().b());
    if (paramParcel != null)
    {
      g(paramParcel);
      this.b = true;
    }
    else
    {
      this.c = null;
      this.b = false;
    }
    this.d = false;
  }
  
  public f(String paramString)
  {
    this.a = o.a(paramString, true, false);
    if (this.a.isEmpty())
    {
      this.c = this.a;
      this.b = true;
      this.d = true;
      return;
    }
    paramString = o.a(this.a, e.a().b());
    if (paramString != null)
    {
      g(paramString);
      this.b = true;
    }
    else
    {
      this.c = null;
      this.b = false;
    }
    this.d = false;
  }
  
  private d.a a(File paramFile)
  {
    String str = this.c;
    if (!paramFile.getPath().startsWith(str))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Illegal file: ");
      ((StringBuilder)localObject).append(paramFile);
      ((StringBuilder)localObject).append(" (base: ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("). Probably caused by concurrent configuration that changes basePath.");
      b.b("VFS.NativeFileSystem", ((StringBuilder)localObject).toString());
      return null;
    }
    if (paramFile.getPath().length() == str.length())
    {
      str = "";
    }
    else
    {
      int i = str.length();
      str = paramFile.getPath().substring(i + 1);
    }
    Object localObject = paramFile.getName();
    if (Build.VERSION.SDK_INT >= 21) {
      return f.a.a(paramFile, this, str, (String)localObject);
    }
    if (!paramFile.exists()) {
      return null;
    }
    boolean bool = paramFile.isDirectory();
    long l = paramFile.length();
    return new d.a(this, str, (String)localObject, l, 4096L + l - 1L & 0xFFFFF000, paramFile.lastModified(), bool);
  }
  
  private static boolean a(File paramFile, boolean paramBoolean)
  {
    File[] arrayOfFile = paramFile.listFiles();
    boolean bool1 = true;
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      bool1 = true;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile.isDirectory()) {
          bool2 = a(localFile, false);
        } else {
          bool2 = localFile.delete();
        }
        bool1 &= bool2;
        i += 1;
      }
    }
    boolean bool2 = bool1;
    if (!paramBoolean) {
      bool2 = bool1 & paramFile.delete();
    }
    return bool2;
  }
  
  /* Error */
  private static long e(String paramString1, d paramd, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: invokeinterface 169 2 0
    //   7: astore_2
    //   8: new 171	java/io/FileOutputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 173	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   16: invokevirtual 177	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   19: astore_0
    //   20: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   23: bipush 23
    //   25: if_icmple +23 -> 48
    //   28: aload_0
    //   29: aload_2
    //   30: lconst_0
    //   31: ldc2_w 178
    //   34: invokevirtual 185	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   37: lstore_3
    //   38: aload_0
    //   39: invokestatic 188	com/tencent/luggage/wxa/rt/o:a	(Ljava/io/Closeable;)V
    //   42: aload_2
    //   43: invokestatic 188	com/tencent/luggage/wxa/rt/o:a	(Ljava/io/Closeable;)V
    //   46: lload_3
    //   47: lreturn
    //   48: lconst_0
    //   49: lstore_3
    //   50: sipush 8192
    //   53: invokestatic 194	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   56: astore_1
    //   57: aload_2
    //   58: aload_1
    //   59: invokeinterface 200 2 0
    //   64: ifge +6 -> 70
    //   67: goto -29 -> 38
    //   70: aload_1
    //   71: invokevirtual 204	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   74: pop
    //   75: lload_3
    //   76: aload_0
    //   77: aload_1
    //   78: invokevirtual 207	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   81: i2l
    //   82: ladd
    //   83: lstore_3
    //   84: aload_1
    //   85: invokevirtual 210	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   88: pop
    //   89: goto -32 -> 57
    //   92: astore_1
    //   93: goto +14 -> 107
    //   96: astore_1
    //   97: aconst_null
    //   98: astore_0
    //   99: goto +8 -> 107
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: astore_2
    //   107: aload_0
    //   108: invokestatic 188	com/tencent/luggage/wxa/rt/o:a	(Ljava/io/Closeable;)V
    //   111: aload_2
    //   112: invokestatic 188	com/tencent/luggage/wxa/rt/o:a	(Ljava/io/Closeable;)V
    //   115: goto +5 -> 120
    //   118: aload_1
    //   119: athrow
    //   120: goto -2 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramString1	String
    //   0	123	1	paramd	d
    //   0	123	2	paramString2	String
    //   37	47	3	l	long
    // Exception table:
    //   from	to	target	type
    //   20	38	92	finally
    //   50	57	92	finally
    //   57	67	92	finally
    //   70	89	92	finally
    //   8	20	96	finally
    //   0	8	102	finally
  }
  
  private void g(String paramString)
  {
    Object localObject = new File(paramString);
    try
    {
      paramString = ((File)localObject).getCanonicalFile();
    }
    catch (IOException paramString)
    {
      label17:
      break label17;
    }
    paramString = ((File)localObject).getAbsoluteFile();
    if ((!paramString.isDirectory()) && (paramString.exists()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Base directory exists but is not a directory, delete and proceed.Base path: ");
      ((StringBuilder)localObject).append(paramString.getPath());
      b.a("VFS.NativeFileSystem", ((StringBuilder)localObject).toString());
      paramString.delete();
    }
    this.c = paramString.getPath();
    paramString = new StringBuilder();
    paramString.append("Real path resolved: ");
    paramString.append(this.a);
    paramString.append(" => ");
    paramString.append(this.c);
    b.c("VFS.NativeFileSystem", paramString.toString());
  }
  
  private static int h(String paramString)
  {
    if ("r".equals(paramString)) {
      return 268435456;
    }
    if ((!"w".equals(paramString)) && (!"wt".equals(paramString)))
    {
      if ("wa".equals(paramString)) {
        return 704643072;
      }
      if ("rw".equals(paramString)) {
        return 939524096;
      }
      if ("rwt".equals(paramString)) {
        return 1006632960;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid mode: ");
      localStringBuilder.append(paramString);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return 738197504;
  }
  
  public ParcelFileDescriptor a(String paramString1, String paramString2)
  {
    String str = d(paramString1, true);
    if (str != null) {
      return ParcelFileDescriptor.open(new File(str), h(paramString2));
    }
    paramString2 = new StringBuilder();
    paramString2.append("Invalid path: ");
    paramString2.append(paramString1);
    throw new FileNotFoundException(paramString2.toString());
  }
  
  public OutputStream a(String paramString, boolean paramBoolean)
  {
    Object localObject = d(paramString, true);
    if (localObject != null) {
      return new FileOutputStream((String)localObject, paramBoolean);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid path: ");
    ((StringBuilder)localObject).append(paramString);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
  }
  
  public ReadableByteChannel a(String paramString)
  {
    Object localObject = d(paramString, false);
    if (localObject != null) {
      return new FileInputStream((String)localObject).getChannel();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid path: ");
    ((StringBuilder)localObject).append(paramString);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
  }
  
  public void a(Map<String, String> paramMap)
  {
    if (!this.b)
    {
      String str = this.c;
      paramMap = o.a(this.a, paramMap);
      if ((paramMap != null) && (!paramMap.equals(str)))
      {
        g(paramMap);
        this.d = false;
        return;
      }
      if (paramMap == null)
      {
        this.c = null;
        this.d = false;
      }
    }
  }
  
  public int b()
  {
    return 31;
  }
  
  public InputStream b(String paramString)
  {
    Object localObject = d(paramString, false);
    if (localObject != null) {
      return new f.c((String)localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid path: ");
    ((StringBuilder)localObject).append(paramString);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
  }
  
  public Iterable<d.a> b(String paramString, boolean paramBoolean)
  {
    paramString = new File(d(paramString, false));
    if (!paramString.isDirectory()) {
      return null;
    }
    return new f.1(this, paramString, paramBoolean);
  }
  
  protected boolean b(String paramString1, d paramd, String paramString2)
  {
    if ((paramd.b() & 0x2) != 0)
    {
      paramd = paramd.d(paramString2, false);
      paramString1 = d(paramString1, true);
      if ((paramd != null) && (paramString1 != null))
      {
        if (Build.VERSION.SDK_INT >= 21) {
          return f.a.a(paramd, paramString1);
        }
        return new File(paramd).renameTo(new File(paramString1));
      }
    }
    return false;
  }
  
  public boolean c(String paramString)
  {
    boolean bool2 = false;
    paramString = d(paramString, false);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (new File(paramString).exists()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean c(String paramString, boolean paramBoolean)
  {
    boolean bool;
    if ((!paramString.isEmpty()) && (!paramString.equals("/"))) {
      bool = false;
    } else {
      bool = true;
    }
    paramString = new File(d(paramString, false));
    if (!paramString.isDirectory()) {
      return false;
    }
    if (paramBoolean) {
      return a(paramString, bool);
    }
    return paramString.delete();
  }
  
  protected long d(String paramString1, d paramd, String paramString2)
  {
    String str = d(paramString1, true);
    if (str != null) {
      return e(str, paramd, paramString2);
    }
    paramd = new StringBuilder();
    paramd.append("Invalid path: ");
    paramd.append(paramString1);
    throw new IOException(paramd.toString());
  }
  
  public d.a d(String paramString)
  {
    return a(new File(d(paramString, false)));
  }
  
  public String d(String paramString, boolean paramBoolean)
  {
    String str = this.c;
    if (str != null)
    {
      if ((paramBoolean) && (!this.d))
      {
        new File(this.c).mkdirs();
        this.d = true;
      }
      if (paramString.isEmpty()) {
        return str;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append('/');
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    paramString = new StringBuilder();
    paramString.append("Base path cannot be resolved: ");
    paramString.append(this.a);
    throw new IllegalStateException(paramString.toString());
  }
  
  public boolean e(String paramString)
  {
    paramString = d(paramString, false);
    if (paramString == null) {
      return false;
    }
    return new File(paramString).delete();
  }
  
  public boolean f(String paramString)
  {
    paramString = d(paramString, true);
    if (paramString == null) {
      return false;
    }
    return new File(paramString).mkdirs();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Native [");
    String str;
    if (this.c == null) {
      str = this.a;
    } else {
      str = this.c;
    }
    localStringBuilder.append(str);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    o.b(paramParcel, f.class, 2);
    paramParcel.writeString(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rt.f
 * JD-Core Version:    0.7.0.1
 */