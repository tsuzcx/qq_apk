import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class avxv
{
  public static alrb a;
  public static avxv a;
  private static final String b;
  public int a;
  public String a;
  public int b;
  public int c = 800;
  public int d = 1080;
  public int e = 1920;
  public int f = 100;
  public int g = 6;
  public int h = 140;
  public int i = 100;
  
  static
  {
    jdField_b_of_type_JavaLangString = DeviceProfileManager.DpcNames.ocrCfg.name();
    jdField_a_of_type_Alrb = new avxw();
  }
  
  public avxv()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 70;
    DeviceProfileManager.a(jdField_a_of_type_Alrb);
  }
  
  public static avxv a()
  {
    if (jdField_a_of_type_Avxv != null) {
      return jdField_a_of_type_Avxv;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.dpc", 2, "get ocrDpc is null");
    }
    a();
    return jdField_a_of_type_Avxv;
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 86	com/tencent/mobileqq/app/DeviceProfileManager:b	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   6: getstatic 31	avxv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9: invokevirtual 89	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   12: astore_1
    //   13: new 2	avxv
    //   16: dup
    //   17: invokespecial 90	avxv:<init>	()V
    //   20: putstatic 66	avxv:jdField_a_of_type_Avxv	Lavxv;
    //   23: getstatic 66	avxv:jdField_a_of_type_Avxv	Lavxv;
    //   26: aload_1
    //   27: putfield 92	avxv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   30: aload_1
    //   31: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   34: ifne +157 -> 191
    //   37: aload_1
    //   38: ldc 100
    //   40: invokevirtual 106	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   43: astore_1
    //   44: aload_1
    //   45: arraylength
    //   46: istore_0
    //   47: iload_0
    //   48: bipush 9
    //   50: if_icmplt +141 -> 191
    //   53: getstatic 66	avxv:jdField_a_of_type_Avxv	Lavxv;
    //   56: aload_1
    //   57: iconst_0
    //   58: aaload
    //   59: invokestatic 112	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   62: invokevirtual 116	java/lang/Integer:intValue	()I
    //   65: putfield 42	avxv:jdField_a_of_type_Int	I
    //   68: getstatic 66	avxv:jdField_a_of_type_Avxv	Lavxv;
    //   71: aload_1
    //   72: iconst_1
    //   73: aaload
    //   74: invokestatic 112	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   77: invokevirtual 116	java/lang/Integer:intValue	()I
    //   80: putfield 44	avxv:jdField_b_of_type_Int	I
    //   83: getstatic 66	avxv:jdField_a_of_type_Avxv	Lavxv;
    //   86: aload_1
    //   87: iconst_2
    //   88: aaload
    //   89: invokestatic 112	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   92: invokevirtual 116	java/lang/Integer:intValue	()I
    //   95: putfield 46	avxv:c	I
    //   98: getstatic 66	avxv:jdField_a_of_type_Avxv	Lavxv;
    //   101: aload_1
    //   102: iconst_3
    //   103: aaload
    //   104: invokestatic 112	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   107: invokevirtual 116	java/lang/Integer:intValue	()I
    //   110: putfield 48	avxv:d	I
    //   113: getstatic 66	avxv:jdField_a_of_type_Avxv	Lavxv;
    //   116: aload_1
    //   117: iconst_4
    //   118: aaload
    //   119: invokestatic 112	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   122: invokevirtual 116	java/lang/Integer:intValue	()I
    //   125: putfield 50	avxv:e	I
    //   128: getstatic 66	avxv:jdField_a_of_type_Avxv	Lavxv;
    //   131: aload_1
    //   132: iconst_5
    //   133: aaload
    //   134: invokestatic 112	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   137: invokevirtual 116	java/lang/Integer:intValue	()I
    //   140: putfield 52	avxv:f	I
    //   143: getstatic 66	avxv:jdField_a_of_type_Avxv	Lavxv;
    //   146: aload_1
    //   147: bipush 6
    //   149: aaload
    //   150: invokestatic 112	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   153: invokevirtual 116	java/lang/Integer:intValue	()I
    //   156: putfield 54	avxv:g	I
    //   159: getstatic 66	avxv:jdField_a_of_type_Avxv	Lavxv;
    //   162: aload_1
    //   163: bipush 7
    //   165: aaload
    //   166: invokestatic 112	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   169: invokevirtual 116	java/lang/Integer:intValue	()I
    //   172: putfield 56	avxv:h	I
    //   175: getstatic 66	avxv:jdField_a_of_type_Avxv	Lavxv;
    //   178: aload_1
    //   179: bipush 8
    //   181: aaload
    //   182: invokestatic 112	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   185: invokevirtual 116	java/lang/Integer:intValue	()I
    //   188: putfield 58	avxv:i	I
    //   191: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +30 -> 224
    //   197: ldc 74
    //   199: iconst_2
    //   200: new 118	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   207: ldc 121
    //   209: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: getstatic 66	avxv:jdField_a_of_type_Avxv	Lavxv;
    //   215: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: ldc 2
    //   226: monitorexit
    //   227: return
    //   228: astore_1
    //   229: ldc 74
    //   231: iconst_1
    //   232: new 118	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   239: ldc 133
    //   241: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_1
    //   245: invokevirtual 136	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   248: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: getstatic 66	avxv:jdField_a_of_type_Avxv	Lavxv;
    //   260: bipush 70
    //   262: putfield 44	avxv:jdField_b_of_type_Int	I
    //   265: getstatic 66	avxv:jdField_a_of_type_Avxv	Lavxv;
    //   268: sipush 800
    //   271: putfield 46	avxv:c	I
    //   274: getstatic 66	avxv:jdField_a_of_type_Avxv	Lavxv;
    //   277: sipush 1080
    //   280: putfield 48	avxv:d	I
    //   283: getstatic 66	avxv:jdField_a_of_type_Avxv	Lavxv;
    //   286: sipush 1920
    //   289: putfield 50	avxv:e	I
    //   292: getstatic 66	avxv:jdField_a_of_type_Avxv	Lavxv;
    //   295: bipush 100
    //   297: putfield 52	avxv:f	I
    //   300: getstatic 66	avxv:jdField_a_of_type_Avxv	Lavxv;
    //   303: bipush 6
    //   305: putfield 54	avxv:g	I
    //   308: getstatic 66	avxv:jdField_a_of_type_Avxv	Lavxv;
    //   311: sipush 140
    //   314: putfield 56	avxv:h	I
    //   317: getstatic 66	avxv:jdField_a_of_type_Avxv	Lavxv;
    //   320: bipush 100
    //   322: putfield 58	avxv:i	I
    //   325: goto -134 -> 191
    //   328: astore_1
    //   329: ldc 2
    //   331: monitorexit
    //   332: aload_1
    //   333: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   46	5	0	j	int
    //   12	167	1	localObject1	Object
    //   228	17	1	localException	java.lang.Exception
    //   328	5	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   53	191	228	java/lang/Exception
    //   3	47	328	finally
    //   53	191	328	finally
    //   191	224	328	finally
    //   229	325	328	finally
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ocrSwitch:").append(this.jdField_a_of_type_Int).append(",picQuality:").append(this.jdField_b_of_type_Int).append(",picShortestSide:").append(this.c).append(",maxPreviewWidth:").append(this.d).append(",maxPreviewHeight:").append(this.e).append(",").append(this.f).append(",").append(this.g).append(",").append(this.h).append(",").append(this.i);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avxv
 * JD-Core Version:    0.7.0.1
 */