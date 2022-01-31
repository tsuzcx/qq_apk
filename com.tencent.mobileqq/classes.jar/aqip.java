import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectLiveReq;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;
import eipc.EIPCResult;
import face.qqlogin.faceproto.App;
import face.qqlogin.faceproto.FaceInfo;
import face.qqlogin.faceproto.Media;
import face.qqlogin.faceproto.Request;
import face.qqlogin.faceproto.UserInfo;
import java.io.File;

public class aqip
  implements aqib
{
  private static final String i = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/lightRecognition";
  private int jdField_a_of_type_Int;
  private aqit jdField_a_of_type_Aqit;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  
  public aqip(Intent paramIntent, aqit paramaqit)
  {
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("platformAppId", 0);
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("srcAppId", 0);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("srcOpenId");
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("idNum");
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("name");
    this.d = paramIntent.getStringExtra("key");
    this.f = paramIntent.getStringExtra("method");
    this.g = paramIntent.getStringExtra("uin");
    this.h = paramIntent.getStringExtra("ticket");
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("serviceType", -1);
    paramIntent = (FaceDetectForThirdPartyManager.AppConf)paramIntent.getSerializableExtra("FaceRecognition.AppConf");
    if (paramIntent != null) {
      this.e = paramIntent.session;
    }
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      paramIntent = "";
      this.jdField_a_of_type_JavaLangString = paramIntent;
      if (this.jdField_b_of_type_JavaLangString != null) {
        break label218;
      }
      paramIntent = "";
      label154:
      this.jdField_b_of_type_JavaLangString = paramIntent;
      if (this.jdField_c_of_type_JavaLangString != null) {
        break label226;
      }
      paramIntent = "";
      label169:
      this.jdField_c_of_type_JavaLangString = paramIntent;
      if (this.d != null) {
        break label234;
      }
      paramIntent = "";
      label184:
      this.d = paramIntent;
      if (this.e != null) {
        break label242;
      }
    }
    label218:
    label226:
    label234:
    label242:
    for (paramIntent = "";; paramIntent = this.e)
    {
      this.e = paramIntent;
      this.jdField_a_of_type_Aqit = paramaqit;
      return;
      paramIntent = this.jdField_a_of_type_JavaLangString;
      break;
      paramIntent = this.jdField_b_of_type_JavaLangString;
      break label154;
      paramIntent = this.jdField_c_of_type_JavaLangString;
      break label169;
      paramIntent = this.d;
      break label184;
    }
  }
  
  public static Bundle a(int paramInt, String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("ret", paramInt);
    localBundle.putString("errMsg", paramString);
    localBundle.putBoolean("needRetry", paramBoolean);
    return localBundle;
  }
  
  private faceproto.Request a(String paramString1, String paramString2, String paramString3)
  {
    faceproto.Request localRequest = new faceproto.Request();
    localRequest.AppID.set(this.jdField_a_of_type_Int);
    localRequest.TmpKey.set(this.d);
    Object localObject = new faceproto.App();
    ((faceproto.App)localObject).AppID.set(this.jdField_b_of_type_Int);
    ((faceproto.App)localObject).OpenID.set(this.jdField_a_of_type_JavaLangString);
    localRequest.SrcApp.set((MessageMicro)localObject);
    localObject = new faceproto.UserInfo();
    if ((this.f == null) || ("identify".equals(this.f)))
    {
      ((faceproto.UserInfo)localObject).IDCardNumber.set(this.jdField_b_of_type_JavaLangString);
      ((faceproto.UserInfo)localObject).Name.set(this.jdField_c_of_type_JavaLangString);
    }
    localRequest.UserInfo.set((MessageMicro)localObject);
    localObject = new faceproto.FaceInfo();
    faceproto.Media localMedia = new faceproto.Media();
    localMedia.Type.set(2);
    localMedia.Size.set(paramString1.getBytes().length);
    localMedia.Tag.set(0);
    localMedia.ColorSeq.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    ((faceproto.FaceInfo)localObject).Medias.add(localMedia);
    ((faceproto.FaceInfo)localObject).RecMode.set(2);
    localRequest.FaceInfo.set((MessageMicro)localObject);
    localRequest.Session.set(paramString3);
    return localRequest;
  }
  
  /* Error */
  private String a(faceproto.Request paramRequest, String paramString)
  {
    // Byte code:
    //   0: new 33	java/io/File
    //   3: dup
    //   4: getstatic 48	aqip:i	Ljava/lang/String;
    //   7: new 22	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   14: invokestatic 269	java/lang/System:currentTimeMillis	()J
    //   17: invokevirtual 272	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20: ldc 116
    //   22: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokespecial 274	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: astore 5
    //   33: new 33	java/io/File
    //   36: dup
    //   37: getstatic 48	aqip:i	Ljava/lang/String;
    //   40: invokespecial 276	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore_3
    //   44: aload_3
    //   45: invokevirtual 280	java/io/File:exists	()Z
    //   48: ifne +129 -> 177
    //   51: aload_3
    //   52: invokevirtual 283	java/io/File:mkdir	()Z
    //   55: pop
    //   56: new 285	java/io/BufferedOutputStream
    //   59: dup
    //   60: new 287	java/io/FileOutputStream
    //   63: dup
    //   64: aload 5
    //   66: invokespecial 290	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   69: invokespecial 293	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   72: astore 4
    //   74: aload 4
    //   76: astore_3
    //   77: aload 4
    //   79: bipush 40
    //   81: invokevirtual 296	java/io/BufferedOutputStream:write	(I)V
    //   84: aload 4
    //   86: astore_3
    //   87: aload_1
    //   88: invokevirtual 299	face/qqlogin/faceproto$Request:toByteArray	()[B
    //   91: astore_1
    //   92: aload 4
    //   94: astore_3
    //   95: aload 4
    //   97: aload_1
    //   98: arraylength
    //   99: invokestatic 304	azzz:a	(I)[B
    //   102: invokevirtual 307	java/io/BufferedOutputStream:write	([B)V
    //   105: aload 4
    //   107: astore_3
    //   108: aload 4
    //   110: aload_2
    //   111: ldc_w 309
    //   114: invokevirtual 312	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   117: arraylength
    //   118: invokestatic 304	azzz:a	(I)[B
    //   121: invokevirtual 307	java/io/BufferedOutputStream:write	([B)V
    //   124: aload 4
    //   126: astore_3
    //   127: aload 4
    //   129: aload_1
    //   130: invokevirtual 307	java/io/BufferedOutputStream:write	([B)V
    //   133: aload 4
    //   135: astore_3
    //   136: aload 4
    //   138: aload_2
    //   139: ldc_w 309
    //   142: invokevirtual 312	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   145: invokevirtual 307	java/io/BufferedOutputStream:write	([B)V
    //   148: aload 4
    //   150: astore_3
    //   151: aload 4
    //   153: bipush 41
    //   155: invokevirtual 296	java/io/BufferedOutputStream:write	(I)V
    //   158: aload 4
    //   160: astore_3
    //   161: aload 4
    //   163: invokevirtual 315	java/io/BufferedOutputStream:flush	()V
    //   166: aload 4
    //   168: invokestatic 318	azzz:a	(Ljava/io/Closeable;)V
    //   171: aload 5
    //   173: invokevirtual 37	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   176: areturn
    //   177: aload_3
    //   178: invokevirtual 321	java/io/File:delete	()Z
    //   181: pop
    //   182: aload_3
    //   183: invokevirtual 283	java/io/File:mkdir	()Z
    //   186: pop
    //   187: goto -131 -> 56
    //   190: astore_1
    //   191: aconst_null
    //   192: astore 4
    //   194: aload 4
    //   196: astore_3
    //   197: ldc_w 323
    //   200: iconst_1
    //   201: aload_1
    //   202: iconst_0
    //   203: anewarray 4	java/lang/Object
    //   206: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   209: aload 4
    //   211: invokestatic 318	azzz:a	(Ljava/io/Closeable;)V
    //   214: aconst_null
    //   215: areturn
    //   216: astore_1
    //   217: aconst_null
    //   218: astore 4
    //   220: aload 4
    //   222: astore_3
    //   223: ldc_w 323
    //   226: iconst_1
    //   227: aload_1
    //   228: iconst_0
    //   229: anewarray 4	java/lang/Object
    //   232: invokestatic 328	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   235: aload 4
    //   237: invokestatic 318	azzz:a	(Ljava/io/Closeable;)V
    //   240: aconst_null
    //   241: areturn
    //   242: astore_1
    //   243: aconst_null
    //   244: astore_3
    //   245: aload_3
    //   246: invokestatic 318	azzz:a	(Ljava/io/Closeable;)V
    //   249: aload_1
    //   250: athrow
    //   251: astore_1
    //   252: goto -7 -> 245
    //   255: astore_1
    //   256: goto -36 -> 220
    //   259: astore_1
    //   260: goto -66 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	aqip
    //   0	263	1	paramRequest	faceproto.Request
    //   0	263	2	paramString	String
    //   43	203	3	localObject	Object
    //   72	164	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   31	141	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   56	74	190	java/io/FileNotFoundException
    //   56	74	216	java/io/IOException
    //   56	74	242	finally
    //   77	84	251	finally
    //   87	92	251	finally
    //   95	105	251	finally
    //   108	124	251	finally
    //   127	133	251	finally
    //   136	148	251	finally
    //   151	158	251	finally
    //   161	166	251	finally
    //   197	209	251	finally
    //   223	235	251	finally
    //   77	84	255	java/io/IOException
    //   87	92	255	java/io/IOException
    //   95	105	255	java/io/IOException
    //   108	124	255	java/io/IOException
    //   127	133	255	java/io/IOException
    //   136	148	255	java/io/IOException
    //   151	158	255	java/io/IOException
    //   161	166	255	java/io/IOException
    //   77	84	259	java/io/FileNotFoundException
    //   87	92	259	java/io/FileNotFoundException
    //   95	105	259	java/io/FileNotFoundException
    //   108	124	259	java/io/FileNotFoundException
    //   127	133	259	java/io/FileNotFoundException
    //   136	148	259	java/io/FileNotFoundException
    //   151	158	259	java/io/FileNotFoundException
    //   161	166	259	java/io/FileNotFoundException
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
      QLog.d("LightRequestHelper", 2, paramEIPCResult.toString());
    }
  }
  
  public void a() {}
  
  public void a(ReflectLiveReq paramReflectLiveReq)
  {
    Object localObject = new WeJson().toJson(paramReflectLiveReq);
    paramReflectLiveReq = a((String)localObject, paramReflectLiveReq.color_data, this.e);
    if (paramReflectLiveReq != null)
    {
      paramReflectLiveReq = a(paramReflectLiveReq, (String)localObject);
      if (paramReflectLiveReq == null)
      {
        this.jdField_a_of_type_Aqit.a(2, a(211, ajjy.a(2131640245), false));
        return;
      }
      localObject = MD5.getFileMd5(paramReflectLiveReq);
      Bundle localBundle = new Bundle();
      localBundle.putString("filePath", paramReflectLiveReq);
      localBundle.putByteArray("md5", (byte[])localObject);
      localBundle.putInt("srcAppId", this.jdField_b_of_type_Int);
      localBundle.putInt("serviceType", this.jdField_c_of_type_Int);
      localBundle.putString("method", this.f);
      localBundle.putString("uin", this.g);
      localBundle.putString("ticket", this.h);
      localBundle.putInt("key_identification_type", 2);
      QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_upload", localBundle, new aqiq(this));
      return;
    }
    this.jdField_a_of_type_Aqit.a(2, null);
  }
  
  public void a(byte[][] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqip
 * JD-Core Version:    0.7.0.1
 */