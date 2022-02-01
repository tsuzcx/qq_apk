package com.tencent.aelight.camera.aioeditor.shortvideo.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

class HwVideoMerge$LogStream
{
  public Process a = null;
  private InputStream b = null;
  private InputStreamReader c = null;
  private BufferedReader d = null;
  
  public void a()
  {
    Process localProcess = this.a;
    if (localProcess != null)
    {
      this.b = localProcess.getInputStream();
      this.c = new InputStreamReader(this.b);
      this.d = new BufferedReader(this.c);
    }
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/tencent/aelight/camera/aioeditor/shortvideo/util/HwVideoMerge$LogStream:a	Ljava/lang/Process;
    //   4: ifnull +175 -> 179
    //   7: aload_0
    //   8: getfield 22	com/tencent/aelight/camera/aioeditor/shortvideo/util/HwVideoMerge$LogStream:d	Ljava/io/BufferedReader;
    //   11: invokevirtual 49	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull +35 -> 51
    //   19: new 51	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   26: astore_2
    //   27: aload_2
    //   28: ldc 54
    //   30: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_2
    //   35: aload_1
    //   36: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_2
    //   41: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: aconst_null
    //   45: invokestatic 66	com/tencent/aelight/camera/aioeditor/shortvideo/util/HwVideoMerge:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   48: goto -41 -> 7
    //   51: aload_0
    //   52: getfield 18	com/tencent/aelight/camera/aioeditor/shortvideo/util/HwVideoMerge$LogStream:b	Ljava/io/InputStream;
    //   55: ifnull +10 -> 65
    //   58: aload_0
    //   59: getfield 18	com/tencent/aelight/camera/aioeditor/shortvideo/util/HwVideoMerge$LogStream:b	Ljava/io/InputStream;
    //   62: invokevirtual 71	java/io/InputStream:close	()V
    //   65: aload_0
    //   66: getfield 20	com/tencent/aelight/camera/aioeditor/shortvideo/util/HwVideoMerge$LogStream:c	Ljava/io/InputStreamReader;
    //   69: ifnull +10 -> 79
    //   72: aload_0
    //   73: getfield 20	com/tencent/aelight/camera/aioeditor/shortvideo/util/HwVideoMerge$LogStream:c	Ljava/io/InputStreamReader;
    //   76: invokevirtual 72	java/io/InputStreamReader:close	()V
    //   79: aload_0
    //   80: getfield 22	com/tencent/aelight/camera/aioeditor/shortvideo/util/HwVideoMerge$LogStream:d	Ljava/io/BufferedReader;
    //   83: ifnull +96 -> 179
    //   86: aload_0
    //   87: getfield 22	com/tencent/aelight/camera/aioeditor/shortvideo/util/HwVideoMerge$LogStream:d	Ljava/io/BufferedReader;
    //   90: invokevirtual 73	java/io/BufferedReader:close	()V
    //   93: return
    //   94: astore_1
    //   95: aload_0
    //   96: getfield 18	com/tencent/aelight/camera/aioeditor/shortvideo/util/HwVideoMerge$LogStream:b	Ljava/io/InputStream;
    //   99: ifnull +10 -> 109
    //   102: aload_0
    //   103: getfield 18	com/tencent/aelight/camera/aioeditor/shortvideo/util/HwVideoMerge$LogStream:b	Ljava/io/InputStream;
    //   106: invokevirtual 71	java/io/InputStream:close	()V
    //   109: aload_0
    //   110: getfield 20	com/tencent/aelight/camera/aioeditor/shortvideo/util/HwVideoMerge$LogStream:c	Ljava/io/InputStreamReader;
    //   113: ifnull +10 -> 123
    //   116: aload_0
    //   117: getfield 20	com/tencent/aelight/camera/aioeditor/shortvideo/util/HwVideoMerge$LogStream:c	Ljava/io/InputStreamReader;
    //   120: invokevirtual 72	java/io/InputStreamReader:close	()V
    //   123: aload_0
    //   124: getfield 22	com/tencent/aelight/camera/aioeditor/shortvideo/util/HwVideoMerge$LogStream:d	Ljava/io/BufferedReader;
    //   127: ifnull +10 -> 137
    //   130: aload_0
    //   131: getfield 22	com/tencent/aelight/camera/aioeditor/shortvideo/util/HwVideoMerge$LogStream:d	Ljava/io/BufferedReader;
    //   134: invokevirtual 73	java/io/BufferedReader:close	()V
    //   137: aload_1
    //   138: athrow
    //   139: aload_0
    //   140: getfield 18	com/tencent/aelight/camera/aioeditor/shortvideo/util/HwVideoMerge$LogStream:b	Ljava/io/InputStream;
    //   143: ifnull +10 -> 153
    //   146: aload_0
    //   147: getfield 18	com/tencent/aelight/camera/aioeditor/shortvideo/util/HwVideoMerge$LogStream:b	Ljava/io/InputStream;
    //   150: invokevirtual 71	java/io/InputStream:close	()V
    //   153: aload_0
    //   154: getfield 20	com/tencent/aelight/camera/aioeditor/shortvideo/util/HwVideoMerge$LogStream:c	Ljava/io/InputStreamReader;
    //   157: ifnull +10 -> 167
    //   160: aload_0
    //   161: getfield 20	com/tencent/aelight/camera/aioeditor/shortvideo/util/HwVideoMerge$LogStream:c	Ljava/io/InputStreamReader;
    //   164: invokevirtual 72	java/io/InputStreamReader:close	()V
    //   167: aload_0
    //   168: getfield 22	com/tencent/aelight/camera/aioeditor/shortvideo/util/HwVideoMerge$LogStream:d	Ljava/io/BufferedReader;
    //   171: astore_1
    //   172: aload_1
    //   173: ifnull +6 -> 179
    //   176: goto -90 -> 86
    //   179: return
    //   180: astore_1
    //   181: goto -42 -> 139
    //   184: astore_1
    //   185: return
    //   186: astore_2
    //   187: goto -50 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	LogStream
    //   14	22	1	str	java.lang.String
    //   94	44	1	localObject	Object
    //   171	2	1	localBufferedReader	BufferedReader
    //   180	1	1	localIOException1	java.io.IOException
    //   184	1	1	localIOException2	java.io.IOException
    //   26	15	2	localStringBuilder	java.lang.StringBuilder
    //   186	1	2	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   7	15	94	finally
    //   19	48	94	finally
    //   7	15	180	java/io/IOException
    //   19	48	180	java/io/IOException
    //   51	65	184	java/io/IOException
    //   65	79	184	java/io/IOException
    //   79	86	184	java/io/IOException
    //   86	93	184	java/io/IOException
    //   139	153	184	java/io/IOException
    //   153	167	184	java/io/IOException
    //   167	172	184	java/io/IOException
    //   95	109	186	java/io/IOException
    //   109	123	186	java/io/IOException
    //   123	137	186	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.util.HwVideoMerge.LogStream
 * JD-Core Version:    0.7.0.1
 */