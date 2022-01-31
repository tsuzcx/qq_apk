import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import com.tencent.mobileqq.identification.ConvertRunnable;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectLiveReq;
import face.qqlogin.faceproto.App;
import face.qqlogin.faceproto.FaceInfo;
import face.qqlogin.faceproto.Media;
import face.qqlogin.faceproto.Request;
import face.qqlogin.faceproto.UserInfo;
import java.io.File;

@RequiresApi(api=18)
public class aqir
  implements aqib, vgr
{
  private static final String jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/.identification";
  private int jdField_a_of_type_Int;
  private aqit jdField_a_of_type_Aqit;
  private aqiu jdField_a_of_type_Aqiu;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  
  public aqir(Intent paramIntent, aqit paramaqit)
  {
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("platformAppId", 0);
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("srcAppId", 0);
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("srcOpenId");
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("idNum");
    this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("name");
    this.e = paramIntent.getStringExtra("key");
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("serviceType", -1);
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      paramIntent = "";
      this.jdField_b_of_type_JavaLangString = paramIntent;
      if (this.jdField_c_of_type_JavaLangString != null) {
        break label151;
      }
      paramIntent = "";
      label102:
      this.jdField_c_of_type_JavaLangString = paramIntent;
      if (this.jdField_d_of_type_JavaLangString != null) {
        break label159;
      }
      paramIntent = "";
      label117:
      this.jdField_d_of_type_JavaLangString = paramIntent;
      if (this.e != null) {
        break label167;
      }
    }
    label151:
    label159:
    label167:
    for (paramIntent = "";; paramIntent = this.e)
    {
      this.e = paramIntent;
      this.jdField_a_of_type_Aqit = paramaqit;
      return;
      paramIntent = this.jdField_b_of_type_JavaLangString;
      break;
      paramIntent = this.jdField_c_of_type_JavaLangString;
      break label102;
      paramIntent = this.jdField_d_of_type_JavaLangString;
      break label117;
    }
  }
  
  private faceproto.Request a(File paramFile, int paramInt)
  {
    faceproto.Request localRequest = new faceproto.Request();
    localRequest.AppID.set(this.jdField_a_of_type_Int);
    localRequest.TmpKey.set(this.e);
    Object localObject = new faceproto.App();
    ((faceproto.App)localObject).AppID.set(this.jdField_b_of_type_Int);
    ((faceproto.App)localObject).OpenID.set(this.jdField_b_of_type_JavaLangString);
    localRequest.SrcApp.set((MessageMicro)localObject);
    localObject = new faceproto.UserInfo();
    ((faceproto.UserInfo)localObject).IDCardNumber.set(this.jdField_c_of_type_JavaLangString);
    ((faceproto.UserInfo)localObject).Name.set(this.jdField_d_of_type_JavaLangString);
    localRequest.UserInfo.set((MessageMicro)localObject);
    localObject = new faceproto.FaceInfo();
    faceproto.Media localMedia = new faceproto.Media();
    localMedia.Type.set(1);
    localMedia.Size.set((int)paramFile.length());
    localMedia.Tag.set(0);
    paramFile = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      localMedia.Action.set(paramFile);
      ((faceproto.FaceInfo)localObject).Medias.add(localMedia);
      ((faceproto.FaceInfo)localObject).RecMode.set(3);
      localRequest.FaceInfo.set((MessageMicro)localObject);
      return localRequest;
      paramFile = "shake";
      continue;
      paramFile = "blink";
      continue;
      paramFile = "mouth";
      continue;
      paramFile = "node";
    }
  }
  
  /* Error */
  private String a(faceproto.Request paramRequest, File paramFile)
  {
    // Byte code:
    //   0: new 35	java/io/File
    //   3: dup
    //   4: getstatic 50	aqir:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: new 24	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   14: invokestatic 208	java/lang/System:currentTimeMillis	()J
    //   17: invokevirtual 211	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20: ldc 93
    //   22: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokespecial 214	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: astore 8
    //   33: new 216	java/io/BufferedOutputStream
    //   36: dup
    //   37: new 218	java/io/FileOutputStream
    //   40: dup
    //   41: aload 8
    //   43: invokespecial 221	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   46: invokespecial 224	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   49: astore 4
    //   51: new 226	java/io/BufferedInputStream
    //   54: dup
    //   55: new 228	java/io/FileInputStream
    //   58: dup
    //   59: aload_2
    //   60: invokespecial 229	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 232	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: astore 7
    //   68: aload 7
    //   70: astore 6
    //   72: aload 4
    //   74: astore 5
    //   76: aload 4
    //   78: bipush 40
    //   80: invokevirtual 235	java/io/BufferedOutputStream:write	(I)V
    //   83: aload 7
    //   85: astore 6
    //   87: aload 4
    //   89: astore 5
    //   91: aload_1
    //   92: invokevirtual 239	face/qqlogin/faceproto$Request:toByteArray	()[B
    //   95: astore_1
    //   96: aload 7
    //   98: astore 6
    //   100: aload 4
    //   102: astore 5
    //   104: aload 4
    //   106: aload_1
    //   107: arraylength
    //   108: invokestatic 244	azzz:a	(I)[B
    //   111: invokevirtual 247	java/io/BufferedOutputStream:write	([B)V
    //   114: aload 7
    //   116: astore 6
    //   118: aload 4
    //   120: astore 5
    //   122: aload 4
    //   124: aload_2
    //   125: invokevirtual 167	java/io/File:length	()J
    //   128: l2i
    //   129: invokestatic 244	azzz:a	(I)[B
    //   132: invokevirtual 247	java/io/BufferedOutputStream:write	([B)V
    //   135: aload 7
    //   137: astore 6
    //   139: aload 4
    //   141: astore 5
    //   143: aload 4
    //   145: aload_1
    //   146: invokevirtual 247	java/io/BufferedOutputStream:write	([B)V
    //   149: aload 7
    //   151: astore 6
    //   153: aload 4
    //   155: astore 5
    //   157: sipush 4096
    //   160: newarray byte
    //   162: astore_1
    //   163: aload 7
    //   165: astore 6
    //   167: aload 4
    //   169: astore 5
    //   171: aload 7
    //   173: aload_1
    //   174: invokevirtual 251	java/io/BufferedInputStream:read	([B)I
    //   177: istore_3
    //   178: iload_3
    //   179: ifle +56 -> 235
    //   182: aload 7
    //   184: astore 6
    //   186: aload 4
    //   188: astore 5
    //   190: aload 4
    //   192: aload_1
    //   193: iconst_0
    //   194: iload_3
    //   195: invokevirtual 254	java/io/BufferedOutputStream:write	([BII)V
    //   198: goto -35 -> 163
    //   201: astore_2
    //   202: aload 7
    //   204: astore_1
    //   205: aload_1
    //   206: astore 6
    //   208: aload 4
    //   210: astore 5
    //   212: ldc_w 256
    //   215: iconst_1
    //   216: aload_2
    //   217: iconst_0
    //   218: anewarray 4	java/lang/Object
    //   221: invokestatic 261	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   224: aload 4
    //   226: invokestatic 264	azzz:a	(Ljava/io/Closeable;)V
    //   229: aload_1
    //   230: invokestatic 264	azzz:a	(Ljava/io/Closeable;)V
    //   233: aconst_null
    //   234: areturn
    //   235: aload 7
    //   237: astore 6
    //   239: aload 4
    //   241: astore 5
    //   243: aload 4
    //   245: bipush 41
    //   247: invokevirtual 235	java/io/BufferedOutputStream:write	(I)V
    //   250: aload 7
    //   252: astore 6
    //   254: aload 4
    //   256: astore 5
    //   258: aload 4
    //   260: invokevirtual 267	java/io/BufferedOutputStream:flush	()V
    //   263: aload 4
    //   265: invokestatic 264	azzz:a	(Ljava/io/Closeable;)V
    //   268: aload 7
    //   270: invokestatic 264	azzz:a	(Ljava/io/Closeable;)V
    //   273: aload 8
    //   275: invokevirtual 39	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   278: areturn
    //   279: astore_2
    //   280: aconst_null
    //   281: astore_1
    //   282: aconst_null
    //   283: astore 4
    //   285: aload_1
    //   286: astore 6
    //   288: aload 4
    //   290: astore 5
    //   292: ldc_w 256
    //   295: iconst_1
    //   296: aload_2
    //   297: iconst_0
    //   298: anewarray 4	java/lang/Object
    //   301: invokestatic 261	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   304: aload 4
    //   306: invokestatic 264	azzz:a	(Ljava/io/Closeable;)V
    //   309: aload_1
    //   310: invokestatic 264	azzz:a	(Ljava/io/Closeable;)V
    //   313: aconst_null
    //   314: areturn
    //   315: astore_1
    //   316: aconst_null
    //   317: astore 6
    //   319: aconst_null
    //   320: astore 4
    //   322: aload 4
    //   324: invokestatic 264	azzz:a	(Ljava/io/Closeable;)V
    //   327: aload 6
    //   329: invokestatic 264	azzz:a	(Ljava/io/Closeable;)V
    //   332: aload_1
    //   333: athrow
    //   334: astore_1
    //   335: aconst_null
    //   336: astore 6
    //   338: goto -16 -> 322
    //   341: astore_1
    //   342: aload 5
    //   344: astore 4
    //   346: goto -24 -> 322
    //   349: astore_2
    //   350: aconst_null
    //   351: astore_1
    //   352: goto -67 -> 285
    //   355: astore_2
    //   356: aload 7
    //   358: astore_1
    //   359: goto -74 -> 285
    //   362: astore_2
    //   363: aconst_null
    //   364: astore_1
    //   365: aconst_null
    //   366: astore 4
    //   368: goto -163 -> 205
    //   371: astore_2
    //   372: aconst_null
    //   373: astore_1
    //   374: goto -169 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	this	aqir
    //   0	377	1	paramRequest	faceproto.Request
    //   0	377	2	paramFile	File
    //   177	18	3	i	int
    //   49	318	4	localObject1	Object
    //   74	269	5	localObject2	Object
    //   70	267	6	localObject3	Object
    //   66	291	7	localBufferedInputStream	java.io.BufferedInputStream
    //   31	243	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   76	83	201	java/io/FileNotFoundException
    //   91	96	201	java/io/FileNotFoundException
    //   104	114	201	java/io/FileNotFoundException
    //   122	135	201	java/io/FileNotFoundException
    //   143	149	201	java/io/FileNotFoundException
    //   157	163	201	java/io/FileNotFoundException
    //   171	178	201	java/io/FileNotFoundException
    //   190	198	201	java/io/FileNotFoundException
    //   243	250	201	java/io/FileNotFoundException
    //   258	263	201	java/io/FileNotFoundException
    //   33	51	279	java/io/IOException
    //   33	51	315	finally
    //   51	68	334	finally
    //   76	83	341	finally
    //   91	96	341	finally
    //   104	114	341	finally
    //   122	135	341	finally
    //   143	149	341	finally
    //   157	163	341	finally
    //   171	178	341	finally
    //   190	198	341	finally
    //   212	224	341	finally
    //   243	250	341	finally
    //   258	263	341	finally
    //   292	304	341	finally
    //   51	68	349	java/io/IOException
    //   76	83	355	java/io/IOException
    //   91	96	355	java/io/IOException
    //   104	114	355	java/io/IOException
    //   122	135	355	java/io/IOException
    //   143	149	355	java/io/IOException
    //   157	163	355	java/io/IOException
    //   171	178	355	java/io/IOException
    //   190	198	355	java/io/IOException
    //   243	250	355	java/io/IOException
    //   258	263	355	java/io/IOException
    //   33	51	362	java/io/FileNotFoundException
    //   51	68	371	java/io/FileNotFoundException
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aqiu != null) {
      this.jdField_a_of_type_Aqiu.a();
    }
  }
  
  public void a(ReflectLiveReq paramReflectLiveReq) {}
  
  public void a(vgv paramvgv)
  {
    if (paramvgv.jdField_a_of_type_Int == 0)
    {
      paramvgv = new File(paramvgv.jdField_b_of_type_JavaLangString);
      Object localObject = a(paramvgv, this.jdField_d_of_type_Int);
      if (localObject != null)
      {
        paramvgv = a((faceproto.Request)localObject, paramvgv);
        if (paramvgv == null)
        {
          this.jdField_a_of_type_Aqit.a(2, aqip.a(211, ajjy.a(2131647628), false));
          return;
        }
        localObject = MD5.getFileMd5(paramvgv);
        Bundle localBundle = new Bundle();
        localBundle.putString("filePath", paramvgv);
        localBundle.putByteArray("md5", (byte[])localObject);
        localBundle.putInt("srcAppId", this.jdField_b_of_type_Int);
        localBundle.putInt("serviceType", this.jdField_c_of_type_Int);
        localBundle.putInt("key_identification_type", 3);
        QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_upload", localBundle, new aqis(this));
        return;
      }
      this.jdField_a_of_type_Aqit.a(2, null);
      return;
    }
    this.jdField_a_of_type_Aqit.a(2, aqip.a(213, ajjy.a(2131647626), false));
    QLog.e("RequestHelper", 1, "encode video failed: " + paramvgv.jdField_a_of_type_Int);
  }
  
  public void a(byte[][] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_d_of_type_Int = paramInt3;
    paramInt3 = ConvertRunnable.a();
    if ((paramInt3 != 17) && (paramInt3 != 20))
    {
      this.jdField_a_of_type_Aqit.a(2, aqip.a(203, ajjy.a(2131647627), false));
      return;
    }
    Object localObject = new File(jdField_a_of_type_JavaLangString);
    if (((File)localObject).exists()) {
      apdh.a((File)localObject);
    }
    if (!((File)localObject).mkdirs())
    {
      this.jdField_a_of_type_Aqit.a(2, aqip.a(211, ajjy.a(2131647625), false));
      return;
    }
    localObject = jdField_a_of_type_JavaLangString + "/" + System.currentTimeMillis() + ".mp4";
    if (this.jdField_a_of_type_Aqiu == null) {
      this.jdField_a_of_type_Aqiu = new aqiu();
    }
    if (this.jdField_a_of_type_Aqiu.b())
    {
      QLog.i("RequestHelper", 1, "encoding thread is running");
      return;
    }
    this.jdField_a_of_type_Aqiu.a(paramArrayOfByte, paramInt1, paramInt2, (String)localObject, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqir
 * JD-Core Version:    0.7.0.1
 */