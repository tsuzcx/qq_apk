import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import face.qqlogin.faceproto.App;
import face.qqlogin.faceproto.FaceInfo;
import face.qqlogin.faceproto.Media;
import face.qqlogin.faceproto.Request;
import face.qqlogin.faceproto.UserInfo;
import java.io.File;

@RequiresApi(api=18)
public class arcv
  implements arcf, vtn
{
  private static final String jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/.identification";
  private int jdField_a_of_type_Int;
  private arcx jdField_a_of_type_Arcx;
  private arcy jdField_a_of_type_Arcy;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  
  public static Bundle a(int paramInt, String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("ret", paramInt);
    localBundle.putString("errMsg", paramString);
    localBundle.putBoolean("needRetry", paramBoolean);
    return localBundle;
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
    }
  }
  
  /* Error */
  private String a(faceproto.Request paramRequest, File paramFile)
  {
    // Byte code:
    //   0: new 35	java/io/File
    //   3: dup
    //   4: getstatic 50	arcv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: new 24	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   14: invokestatic 196	java/lang/System:currentTimeMillis	()J
    //   17: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20: ldc 201
    //   22: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokespecial 203	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: astore 8
    //   33: new 205	java/io/BufferedOutputStream
    //   36: dup
    //   37: new 207	java/io/FileOutputStream
    //   40: dup
    //   41: aload 8
    //   43: invokespecial 210	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   46: invokespecial 213	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   49: astore 4
    //   51: new 215	java/io/BufferedInputStream
    //   54: dup
    //   55: new 217	java/io/FileInputStream
    //   58: dup
    //   59: aload_2
    //   60: invokespecial 218	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 221	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: astore 7
    //   68: aload 7
    //   70: astore 6
    //   72: aload 4
    //   74: astore 5
    //   76: aload 4
    //   78: bipush 40
    //   80: invokevirtual 224	java/io/BufferedOutputStream:write	(I)V
    //   83: aload 7
    //   85: astore 6
    //   87: aload 4
    //   89: astore 5
    //   91: aload_1
    //   92: invokevirtual 228	face/qqlogin/faceproto$Request:toByteArray	()[B
    //   95: astore_1
    //   96: aload 7
    //   98: astore 6
    //   100: aload 4
    //   102: astore 5
    //   104: aload 4
    //   106: aload_1
    //   107: arraylength
    //   108: invokestatic 233	bbbd:a	(I)[B
    //   111: invokevirtual 236	java/io/BufferedOutputStream:write	([B)V
    //   114: aload 7
    //   116: astore 6
    //   118: aload 4
    //   120: astore 5
    //   122: aload 4
    //   124: aload_2
    //   125: invokevirtual 159	java/io/File:length	()J
    //   128: l2i
    //   129: invokestatic 233	bbbd:a	(I)[B
    //   132: invokevirtual 236	java/io/BufferedOutputStream:write	([B)V
    //   135: aload 7
    //   137: astore 6
    //   139: aload 4
    //   141: astore 5
    //   143: aload 4
    //   145: aload_1
    //   146: invokevirtual 236	java/io/BufferedOutputStream:write	([B)V
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
    //   174: invokevirtual 240	java/io/BufferedInputStream:read	([B)I
    //   177: istore_3
    //   178: iload_3
    //   179: ifle +55 -> 234
    //   182: aload 7
    //   184: astore 6
    //   186: aload 4
    //   188: astore 5
    //   190: aload 4
    //   192: aload_1
    //   193: iconst_0
    //   194: iload_3
    //   195: invokevirtual 243	java/io/BufferedOutputStream:write	([BII)V
    //   198: goto -35 -> 163
    //   201: astore_2
    //   202: aload 7
    //   204: astore_1
    //   205: aload_1
    //   206: astore 6
    //   208: aload 4
    //   210: astore 5
    //   212: ldc 245
    //   214: iconst_1
    //   215: aload_2
    //   216: iconst_0
    //   217: anewarray 4	java/lang/Object
    //   220: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   223: aload 4
    //   225: invokestatic 253	bbbd:a	(Ljava/io/Closeable;)V
    //   228: aload_1
    //   229: invokestatic 253	bbbd:a	(Ljava/io/Closeable;)V
    //   232: aconst_null
    //   233: areturn
    //   234: aload 7
    //   236: astore 6
    //   238: aload 4
    //   240: astore 5
    //   242: aload 4
    //   244: bipush 41
    //   246: invokevirtual 224	java/io/BufferedOutputStream:write	(I)V
    //   249: aload 7
    //   251: astore 6
    //   253: aload 4
    //   255: astore 5
    //   257: aload 4
    //   259: invokevirtual 256	java/io/BufferedOutputStream:flush	()V
    //   262: aload 4
    //   264: invokestatic 253	bbbd:a	(Ljava/io/Closeable;)V
    //   267: aload 7
    //   269: invokestatic 253	bbbd:a	(Ljava/io/Closeable;)V
    //   272: aload 8
    //   274: invokevirtual 39	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   277: areturn
    //   278: astore_2
    //   279: aconst_null
    //   280: astore_1
    //   281: aconst_null
    //   282: astore 4
    //   284: aload_1
    //   285: astore 6
    //   287: aload 4
    //   289: astore 5
    //   291: ldc 245
    //   293: iconst_1
    //   294: aload_2
    //   295: iconst_0
    //   296: anewarray 4	java/lang/Object
    //   299: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   302: aload 4
    //   304: invokestatic 253	bbbd:a	(Ljava/io/Closeable;)V
    //   307: aload_1
    //   308: invokestatic 253	bbbd:a	(Ljava/io/Closeable;)V
    //   311: aconst_null
    //   312: areturn
    //   313: astore_1
    //   314: aconst_null
    //   315: astore 6
    //   317: aconst_null
    //   318: astore 4
    //   320: aload 4
    //   322: invokestatic 253	bbbd:a	(Ljava/io/Closeable;)V
    //   325: aload 6
    //   327: invokestatic 253	bbbd:a	(Ljava/io/Closeable;)V
    //   330: aload_1
    //   331: athrow
    //   332: astore_1
    //   333: aconst_null
    //   334: astore 6
    //   336: goto -16 -> 320
    //   339: astore_1
    //   340: aload 5
    //   342: astore 4
    //   344: goto -24 -> 320
    //   347: astore_2
    //   348: aconst_null
    //   349: astore_1
    //   350: goto -66 -> 284
    //   353: astore_2
    //   354: aload 7
    //   356: astore_1
    //   357: goto -73 -> 284
    //   360: astore_2
    //   361: aconst_null
    //   362: astore_1
    //   363: aconst_null
    //   364: astore 4
    //   366: goto -161 -> 205
    //   369: astore_2
    //   370: aconst_null
    //   371: astore_1
    //   372: goto -167 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	this	arcv
    //   0	375	1	paramRequest	faceproto.Request
    //   0	375	2	paramFile	File
    //   177	18	3	i	int
    //   49	316	4	localObject1	Object
    //   74	267	5	localObject2	Object
    //   70	265	6	localObject3	Object
    //   66	289	7	localBufferedInputStream	java.io.BufferedInputStream
    //   31	242	8	localFile	File
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
    //   242	249	201	java/io/FileNotFoundException
    //   257	262	201	java/io/FileNotFoundException
    //   33	51	278	java/io/IOException
    //   33	51	313	finally
    //   51	68	332	finally
    //   76	83	339	finally
    //   91	96	339	finally
    //   104	114	339	finally
    //   122	135	339	finally
    //   143	149	339	finally
    //   157	163	339	finally
    //   171	178	339	finally
    //   190	198	339	finally
    //   212	223	339	finally
    //   242	249	339	finally
    //   257	262	339	finally
    //   291	302	339	finally
    //   51	68	347	java/io/IOException
    //   76	83	353	java/io/IOException
    //   91	96	353	java/io/IOException
    //   104	114	353	java/io/IOException
    //   122	135	353	java/io/IOException
    //   143	149	353	java/io/IOException
    //   157	163	353	java/io/IOException
    //   171	178	353	java/io/IOException
    //   190	198	353	java/io/IOException
    //   242	249	353	java/io/IOException
    //   257	262	353	java/io/IOException
    //   33	51	360	java/io/FileNotFoundException
    //   51	68	369	java/io/FileNotFoundException
  }
  
  public static void a(EIPCResult paramEIPCResult, String paramString)
  {
    Bundle localBundle = paramEIPCResult.data;
    if ((localBundle != null) && (localBundle.getBoolean("reset_null"))) {
      paramEIPCResult.data = null;
    }
    if (QLog.isColorLevel())
    {
      paramEIPCResult = new StringBuilder(" onCallback epiResult=").append(paramEIPCResult.code).append(" epic_bundle").append(localBundle).append(" from=").append(paramString);
      if (localBundle != null) {
        paramEIPCResult.append(" sub_error:").append(localBundle.getString("subError", ""));
      }
      QLog.d("RequestHelper", 2, paramEIPCResult.toString());
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Arcy != null) {
      this.jdField_a_of_type_Arcy.a();
    }
  }
  
  public void a(vtr paramvtr)
  {
    if (paramvtr.jdField_a_of_type_Int == 0)
    {
      paramvtr = new File(paramvtr.jdField_b_of_type_JavaLangString);
      Object localObject = a(paramvtr, this.jdField_d_of_type_Int);
      if (localObject != null)
      {
        paramvtr = a((faceproto.Request)localObject, paramvtr);
        if (paramvtr == null)
        {
          this.jdField_a_of_type_Arcx.a(2, a(211, ajyc.a(2131713416), false));
          return;
        }
        localObject = MD5.getFileMd5(paramvtr);
        Bundle localBundle = new Bundle();
        localBundle.putString("filePath", paramvtr);
        localBundle.putByteArray("md5", (byte[])localObject);
        localBundle.putInt("srcAppId", this.jdField_b_of_type_Int);
        localBundle.putInt("serviceType", this.jdField_c_of_type_Int);
        localBundle.putInt("key_identification_type", 3);
        QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_upload", localBundle, new arcw(this));
        return;
      }
      this.jdField_a_of_type_Arcx.a(2, null);
      return;
    }
    this.jdField_a_of_type_Arcx.a(2, a(213, ajyc.a(2131713414), false));
    QLog.e("RequestHelper", 1, "encode video failed: " + paramvtr.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arcv
 * JD-Core Version:    0.7.0.1
 */