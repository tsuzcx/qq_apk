package com.android.multidex;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

class Path
{
  private final ByteArrayOutputStream baos = new ByteArrayOutputStream(40960);
  private final String definition;
  List<ClassPathElement> elements = new ArrayList();
  private final byte[] readBuffer = new byte[20480];
  
  static
  {
    if (!Path.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  Path(String paramString)
  {
    this.definition = paramString;
    paramString = paramString.split(Pattern.quote(File.pathSeparator));
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      try
      {
        addElement(getClassPathElement(new File(str)));
        i += 1;
      }
      catch (IOException paramString)
      {
        throw new IOException("Wrong classpath: " + paramString.getMessage(), paramString);
      }
    }
  }
  
  private void addElement(ClassPathElement paramClassPathElement)
  {
    assert (paramClassPathElement != null);
    this.elements.add(paramClassPathElement);
  }
  
  static ClassPathElement getClassPathElement(File paramFile)
  {
    if (paramFile.isDirectory()) {
      return new FolderPathElement(paramFile);
    }
    if (paramFile.isFile()) {
      return new ArchivePathElement(new ZipFile(paramFile));
    }
    if (paramFile.exists()) {
      throw new IOException("\"" + paramFile.getPath() + "\" is not a directory neither a zip file");
    }
    throw new FileNotFoundException("File \"" + paramFile.getPath() + "\" not found");
  }
  
  /* Error */
  private static byte[] readStream(java.io.InputStream paramInputStream, ByteArrayOutputStream paramByteArrayOutputStream, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokevirtual 149	java/io/InputStream:read	([B)I
    //   5: istore_3
    //   6: iload_3
    //   7: ifge +12 -> 19
    //   10: aload_0
    //   11: invokevirtual 152	java/io/InputStream:close	()V
    //   14: aload_1
    //   15: invokevirtual 156	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   18: areturn
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: iload_3
    //   23: invokevirtual 160	java/io/ByteArrayOutputStream:write	([BII)V
    //   26: goto -26 -> 0
    //   29: astore_1
    //   30: aload_0
    //   31: invokevirtual 152	java/io/InputStream:close	()V
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	paramInputStream	java.io.InputStream
    //   0	36	1	paramByteArrayOutputStream	ByteArrayOutputStream
    //   0	36	2	paramArrayOfByte	byte[]
    //   5	18	3	i	int
    // Exception table:
    //   from	to	target	type
    //   0	6	29	finally
    //   19	26	29	finally
  }
  
  /* Error */
  com.android.dx.cf.direct.DirectClassFile getClass(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: getfield 37	com/android/multidex/Path:elements	Ljava/util/List;
    //   8: invokeinterface 166 1 0
    //   13: astore 5
    //   15: aload 5
    //   17: invokeinterface 171 1 0
    //   22: ifeq +143 -> 165
    //   25: aload 5
    //   27: invokeinterface 175 1 0
    //   32: checkcast 177	com/android/multidex/ClassPathElement
    //   35: astore_3
    //   36: aload_3
    //   37: aload_1
    //   38: invokeinterface 181 2 0
    //   43: astore 6
    //   45: aload 6
    //   47: aload_0
    //   48: getfield 45	com/android/multidex/Path:baos	Ljava/io/ByteArrayOutputStream;
    //   51: aload_0
    //   52: getfield 47	com/android/multidex/Path:readBuffer	[B
    //   55: invokestatic 183	com/android/multidex/Path:readStream	(Ljava/io/InputStream;Ljava/io/ByteArrayOutputStream;[B)[B
    //   58: astore_3
    //   59: aload_0
    //   60: getfield 45	com/android/multidex/Path:baos	Ljava/io/ByteArrayOutputStream;
    //   63: invokevirtual 186	java/io/ByteArrayOutputStream:reset	()V
    //   66: new 188	com/android/dx/cf/direct/DirectClassFile
    //   69: dup
    //   70: aload_3
    //   71: aload_1
    //   72: iconst_0
    //   73: invokespecial 191	com/android/dx/cf/direct/DirectClassFile:<init>	([BLjava/lang/String;Z)V
    //   76: astore_3
    //   77: aload_3
    //   78: getstatic 197	com/android/dx/cf/direct/StdAttributeFactory:THE_ONE	Lcom/android/dx/cf/direct/StdAttributeFactory;
    //   81: invokevirtual 201	com/android/dx/cf/direct/DirectClassFile:setAttributeFactory	(Lcom/android/dx/cf/direct/AttributeFactory;)V
    //   84: aload_3
    //   85: astore_2
    //   86: aload 6
    //   88: invokevirtual 152	java/io/InputStream:close	()V
    //   91: aload_3
    //   92: ifnonnull +58 -> 150
    //   95: new 136	java/io/FileNotFoundException
    //   98: dup
    //   99: new 78	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   106: ldc 138
    //   108: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_1
    //   112: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc 140
    //   117: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokespecial 141	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   126: athrow
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    //   132: astore 4
    //   134: aload_3
    //   135: astore_2
    //   136: aload 6
    //   138: invokevirtual 152	java/io/InputStream:close	()V
    //   141: aload_3
    //   142: astore_2
    //   143: aload 4
    //   145: athrow
    //   146: astore_3
    //   147: goto -132 -> 15
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_3
    //   153: areturn
    //   154: astore_3
    //   155: goto -8 -> 147
    //   158: astore 4
    //   160: aload_2
    //   161: astore_3
    //   162: goto -28 -> 134
    //   165: aload_2
    //   166: astore_3
    //   167: goto -76 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	Path
    //   0	170	1	paramString	String
    //   3	163	2	localObject1	Object
    //   35	107	3	localObject2	Object
    //   146	7	3	localIOException1	IOException
    //   154	1	3	localIOException2	IOException
    //   161	6	3	localObject3	Object
    //   132	12	4	localObject4	Object
    //   158	1	4	localObject5	Object
    //   13	13	5	localIterator	java.util.Iterator
    //   43	94	6	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   4	15	127	finally
    //   15	36	127	finally
    //   36	45	127	finally
    //   86	91	127	finally
    //   95	127	127	finally
    //   136	141	127	finally
    //   143	146	127	finally
    //   77	84	132	finally
    //   86	91	146	java/io/IOException
    //   136	141	146	java/io/IOException
    //   143	146	146	java/io/IOException
    //   36	45	154	java/io/IOException
    //   45	77	158	finally
  }
  
  Iterable<ClassPathElement> getElements()
  {
    return this.elements;
  }
  
  public String toString()
  {
    return this.definition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.multidex.Path
 * JD-Core Version:    0.7.0.1
 */