package com.tencent.biz.pubaccount.readinjoy.notecard;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Looper;
import psa;

public class SoundCheckRunnable
  implements Runnable
{
  private static String jdField_a_of_type_JavaLangString = "SoundCheckRunnable";
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = AudioRecord.getMinBufferSize(8000, 2, 2);
  private AudioRecord jdField_a_of_type_AndroidMediaAudioRecord = new AudioRecord(1, 8000, 2, 2, this.jdField_a_of_type_Int);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private psa jdField_a_of_type_Psa;
  private boolean jdField_a_of_type_Boolean = true;
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(psa parampsa)
  {
    this.jdField_a_of_type_Psa = parampsa;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   4: invokevirtual 71	android/media/AudioRecord:startRecording	()V
    //   7: aload_0
    //   8: getfield 49	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:jdField_a_of_type_Int	I
    //   11: newarray byte
    //   13: astore 8
    //   15: new 73	java/util/LinkedList
    //   18: dup
    //   19: invokespecial 74	java/util/LinkedList:<init>	()V
    //   22: astore 9
    //   24: lconst_0
    //   25: lstore 6
    //   27: aload_0
    //   28: getfield 41	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:jdField_a_of_type_Boolean	Z
    //   31: ifeq +254 -> 285
    //   34: ldc2_w 75
    //   37: invokestatic 82	java/lang/Thread:sleep	(J)V
    //   40: aload_0
    //   41: getfield 54	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   44: aload 8
    //   46: iconst_0
    //   47: aload_0
    //   48: getfield 49	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:jdField_a_of_type_Int	I
    //   51: invokevirtual 86	android/media/AudioRecord:read	([BII)I
    //   54: istore_3
    //   55: aload 8
    //   57: arraylength
    //   58: istore 4
    //   60: iconst_0
    //   61: istore_1
    //   62: iconst_0
    //   63: istore_2
    //   64: iload_1
    //   65: iload 4
    //   67: if_icmpge +55 -> 122
    //   70: aload 8
    //   72: iload_1
    //   73: baload
    //   74: istore 5
    //   76: iload_2
    //   77: iload 5
    //   79: iload 5
    //   81: imul
    //   82: iadd
    //   83: istore_2
    //   84: iload_1
    //   85: iconst_1
    //   86: iadd
    //   87: istore_1
    //   88: goto -24 -> 64
    //   91: astore 8
    //   93: invokestatic 91	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   96: ifeq +15 -> 111
    //   99: getstatic 20	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   102: iconst_1
    //   103: aload 8
    //   105: invokevirtual 95	java/lang/Exception:toString	()Ljava/lang/String;
    //   108: invokestatic 99	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: return
    //   112: astore 10
    //   114: aload 10
    //   116: invokevirtual 102	java/lang/InterruptedException:printStackTrace	()V
    //   119: goto -79 -> 40
    //   122: iload_2
    //   123: iload_3
    //   124: iconst_1
    //   125: iadd
    //   126: idiv
    //   127: istore_1
    //   128: aload 9
    //   130: iload_1
    //   131: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   134: invokevirtual 112	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   137: pop
    //   138: iload_1
    //   139: i2l
    //   140: lload 6
    //   142: ladd
    //   143: lstore 6
    //   145: aload 9
    //   147: invokevirtual 116	java/util/LinkedList:size	()I
    //   150: bipush 10
    //   152: if_icmple +151 -> 303
    //   155: lload 6
    //   157: aload 9
    //   159: invokevirtual 120	java/util/LinkedList:removeFirst	()Ljava/lang/Object;
    //   162: checkcast 104	java/lang/Integer
    //   165: invokevirtual 123	java/lang/Integer:intValue	()I
    //   168: i2l
    //   169: lsub
    //   170: lstore 6
    //   172: lload 6
    //   174: aload 9
    //   176: invokevirtual 116	java/util/LinkedList:size	()I
    //   179: i2l
    //   180: ldiv
    //   181: l2i
    //   182: istore_2
    //   183: getstatic 129	java/lang/System:out	Ljava/io/PrintStream;
    //   186: new 131	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   193: ldc 134
    //   195: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: iload_1
    //   199: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: ldc 143
    //   204: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: iload_2
    //   208: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: ldc 145
    //   213: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_0
    //   217: getfield 39	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:jdField_a_of_type_Float	F
    //   220: ldc 146
    //   222: fmul
    //   223: invokevirtual 149	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   226: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokevirtual 156	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   232: iload_2
    //   233: i2f
    //   234: aload_0
    //   235: getfield 39	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:jdField_a_of_type_Float	F
    //   238: ldc 146
    //   240: fmul
    //   241: fcmpl
    //   242: ifle -215 -> 27
    //   245: aload_0
    //   246: getfield 62	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:jdField_a_of_type_Psa	Lpsa;
    //   249: astore 10
    //   251: aload 10
    //   253: ifnull +21 -> 274
    //   256: aload_0
    //   257: getfield 37	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   260: new 158	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable$1
    //   263: dup
    //   264: aload_0
    //   265: aload 10
    //   267: invokespecial 161	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable$1:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable;Lpsa;)V
    //   270: invokevirtual 165	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   273: pop
    //   274: aload 9
    //   276: invokevirtual 168	java/util/LinkedList:clear	()V
    //   279: lconst_0
    //   280: lstore 6
    //   282: goto -255 -> 27
    //   285: aload_0
    //   286: getfield 54	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   289: invokevirtual 171	android/media/AudioRecord:stop	()V
    //   292: aload_0
    //   293: getfield 54	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   296: invokevirtual 174	android/media/AudioRecord:release	()V
    //   299: return
    //   300: astore 8
    //   302: return
    //   303: goto -131 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	SoundCheckRunnable
    //   61	138	1	i	int
    //   63	170	2	j	int
    //   54	72	3	k	int
    //   58	10	4	m	int
    //   74	8	5	n	int
    //   25	256	6	l	long
    //   13	58	8	arrayOfByte	byte[]
    //   91	13	8	localException1	java.lang.Exception
    //   300	1	8	localException2	java.lang.Exception
    //   22	253	9	localLinkedList	java.util.LinkedList
    //   112	3	10	localInterruptedException	java.lang.InterruptedException
    //   249	17	10	localpsa	psa
    // Exception table:
    //   from	to	target	type
    //   0	7	91	java/lang/Exception
    //   34	40	112	java/lang/InterruptedException
    //   285	299	300	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.notecard.SoundCheckRunnable
 * JD-Core Version:    0.7.0.1
 */