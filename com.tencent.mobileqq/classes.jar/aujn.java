import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import face.qqlogin.faceproto.App;
import face.qqlogin.faceproto.FaceInfo;
import face.qqlogin.faceproto.Media;
import face.qqlogin.faceproto.Request;
import face.qqlogin.faceproto.UserInfo;
import java.util.List;

public class aujn
  implements aujp
{
  private static final String j = BaseApplicationImpl.getApplication().getFilesDir() + "/identification/packFile";
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aukp jdField_a_of_type_Aukp;
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
  private String i;
  
  public aujn(Intent paramIntent, String paramString, aukp paramaukp)
  {
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("platformAppId", 0);
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("srcAppId", 0);
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("srcOpenId");
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("idNum");
    this.d = paramIntent.getStringExtra("name");
    this.e = paramIntent.getStringExtra("key");
    this.f = paramIntent.getStringExtra("method");
    this.g = paramIntent.getStringExtra("uin");
    this.h = paramIntent.getStringExtra("ticket");
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("serviceType", -1);
    paramIntent = (FaceDetectForThirdPartyManager.AppConf)paramIntent.getSerializableExtra("FaceRecognition.AppConf");
    if (paramIntent != null) {
      this.jdField_a_of_type_JavaLangString = paramIntent.session;
    }
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      paramIntent = "";
      this.jdField_b_of_type_JavaLangString = paramIntent;
      if (this.jdField_c_of_type_JavaLangString != null) {
        break label223;
      }
      paramIntent = "";
      label154:
      this.jdField_c_of_type_JavaLangString = paramIntent;
      if (this.d != null) {
        break label231;
      }
      paramIntent = "";
      label169:
      this.d = paramIntent;
      if (this.e != null) {
        break label239;
      }
      paramIntent = "";
      label184:
      this.e = paramIntent;
      if (this.jdField_a_of_type_JavaLangString != null) {
        break label247;
      }
    }
    label223:
    label231:
    label239:
    label247:
    for (paramIntent = "";; paramIntent = this.jdField_a_of_type_JavaLangString)
    {
      this.jdField_a_of_type_JavaLangString = paramIntent;
      this.jdField_a_of_type_Aukp = paramaukp;
      this.i = paramString;
      return;
      paramIntent = this.jdField_b_of_type_JavaLangString;
      break;
      paramIntent = this.jdField_c_of_type_JavaLangString;
      break label154;
      paramIntent = this.d;
      break label169;
      paramIntent = this.e;
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
  
  private faceproto.Request a(String paramString1, String paramString2)
  {
    faceproto.Request localRequest = new faceproto.Request();
    localRequest.AppID.set(this.jdField_a_of_type_Int);
    localRequest.TmpKey.set(this.e);
    Object localObject = new faceproto.App();
    ((faceproto.App)localObject).AppID.set(this.jdField_b_of_type_Int);
    ((faceproto.App)localObject).OpenID.set(this.jdField_b_of_type_JavaLangString);
    localRequest.SrcApp.set((MessageMicro)localObject);
    localObject = new faceproto.UserInfo();
    if ((this.f == null) || (aujs.e.contains(this.f)))
    {
      ((faceproto.UserInfo)localObject).IDCardNumber.set(this.jdField_c_of_type_JavaLangString);
      ((faceproto.UserInfo)localObject).Name.set(this.d);
    }
    localRequest.UserInfo.set((MessageMicro)localObject);
    localObject = new faceproto.FaceInfo();
    faceproto.Media localMedia = new faceproto.Media();
    localMedia.Size.set(paramString1.getBytes().length);
    localMedia.Type.set(3);
    ((faceproto.FaceInfo)localObject).RecMode.set(4);
    localRequest.FaceInfo.set((MessageMicro)localObject);
    localRequest.Session.set(paramString2);
    return localRequest;
  }
  
  /* Error */
  private String a(faceproto.Request paramRequest, String paramString)
  {
    // Byte code:
    //   0: new 252	java/io/File
    //   3: dup
    //   4: getstatic 52	aujn:j	Ljava/lang/String;
    //   7: new 24	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   14: invokestatic 258	java/lang/System:currentTimeMillis	()J
    //   17: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20: ldc 120
    //   22: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokespecial 263	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: astore 5
    //   33: new 252	java/io/File
    //   36: dup
    //   37: getstatic 52	aujn:j	Ljava/lang/String;
    //   40: invokespecial 265	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore_3
    //   44: aload_3
    //   45: invokevirtual 269	java/io/File:exists	()Z
    //   48: ifne +129 -> 177
    //   51: aload_3
    //   52: invokevirtual 272	java/io/File:mkdirs	()Z
    //   55: pop
    //   56: new 274	java/io/BufferedOutputStream
    //   59: dup
    //   60: new 276	java/io/FileOutputStream
    //   63: dup
    //   64: aload 5
    //   66: invokespecial 279	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   69: invokespecial 282	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   72: astore 4
    //   74: aload 4
    //   76: astore_3
    //   77: aload 4
    //   79: bipush 40
    //   81: invokevirtual 285	java/io/BufferedOutputStream:write	(I)V
    //   84: aload 4
    //   86: astore_3
    //   87: aload_1
    //   88: invokevirtual 288	face/qqlogin/faceproto$Request:toByteArray	()[B
    //   91: astore_1
    //   92: aload 4
    //   94: astore_3
    //   95: aload 4
    //   97: aload_1
    //   98: arraylength
    //   99: invokestatic 293	bftf:a	(I)[B
    //   102: invokevirtual 296	java/io/BufferedOutputStream:write	([B)V
    //   105: aload 4
    //   107: astore_3
    //   108: aload 4
    //   110: aload_2
    //   111: ldc_w 298
    //   114: invokevirtual 301	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   117: arraylength
    //   118: invokestatic 293	bftf:a	(I)[B
    //   121: invokevirtual 296	java/io/BufferedOutputStream:write	([B)V
    //   124: aload 4
    //   126: astore_3
    //   127: aload 4
    //   129: aload_1
    //   130: invokevirtual 296	java/io/BufferedOutputStream:write	([B)V
    //   133: aload 4
    //   135: astore_3
    //   136: aload 4
    //   138: aload_2
    //   139: ldc_w 298
    //   142: invokevirtual 301	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   145: invokevirtual 296	java/io/BufferedOutputStream:write	([B)V
    //   148: aload 4
    //   150: astore_3
    //   151: aload 4
    //   153: bipush 41
    //   155: invokevirtual 285	java/io/BufferedOutputStream:write	(I)V
    //   158: aload 4
    //   160: astore_3
    //   161: aload 4
    //   163: invokevirtual 304	java/io/BufferedOutputStream:flush	()V
    //   166: aload 4
    //   168: invokestatic 307	bftf:a	(Ljava/io/Closeable;)V
    //   171: aload 5
    //   173: invokevirtual 310	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   176: areturn
    //   177: aload_3
    //   178: invokevirtual 313	java/io/File:delete	()Z
    //   181: pop
    //   182: aload_3
    //   183: invokevirtual 272	java/io/File:mkdirs	()Z
    //   186: pop
    //   187: goto -131 -> 56
    //   190: astore_1
    //   191: aconst_null
    //   192: astore 4
    //   194: aload 4
    //   196: astore_3
    //   197: ldc_w 315
    //   200: iconst_1
    //   201: aload_1
    //   202: iconst_0
    //   203: anewarray 4	java/lang/Object
    //   206: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   209: aload 4
    //   211: invokestatic 307	bftf:a	(Ljava/io/Closeable;)V
    //   214: aconst_null
    //   215: areturn
    //   216: astore_1
    //   217: aconst_null
    //   218: astore 4
    //   220: aload 4
    //   222: astore_3
    //   223: ldc_w 315
    //   226: iconst_1
    //   227: aload_1
    //   228: iconst_0
    //   229: anewarray 4	java/lang/Object
    //   232: invokestatic 320	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   235: aload 4
    //   237: invokestatic 307	bftf:a	(Ljava/io/Closeable;)V
    //   240: aconst_null
    //   241: areturn
    //   242: astore_1
    //   243: aconst_null
    //   244: astore_3
    //   245: aload_3
    //   246: invokestatic 307	bftf:a	(Ljava/io/Closeable;)V
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
    //   0	263	0	this	aujn
    //   0	263	1	paramRequest	faceproto.Request
    //   0	263	2	paramString	String
    //   43	203	3	localObject	Object
    //   72	164	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   31	141	5	localFile	java.io.File
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
  
  public void a() {}
  
  public void a(String paramString)
  {
    this.i = paramString;
  }
  
  public void b()
  {
    Object localObject = a(this.i, this.jdField_a_of_type_JavaLangString);
    if (localObject == null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ActReflectRequestHelper", 1, new Object[] { "start pack request, request is null ? ", Boolean.valueOf(bool) });
      if (localObject == null) {
        break label237;
      }
      localObject = a((faceproto.Request)localObject, this.i);
      if (localObject != null) {
        break;
      }
      this.jdField_a_of_type_Aukp.a(2, a(211, amtj.a(2131705173), false));
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    byte[] arrayOfByte = MD5.getFileMd5((String)localObject);
    long l = FileUtils.getFileSizes((String)localObject) / 1024L;
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", (String)localObject);
    localBundle.putByteArray("md5", arrayOfByte);
    localBundle.putInt("srcAppId", this.jdField_b_of_type_Int);
    localBundle.putInt("serviceType", this.jdField_c_of_type_Int);
    localBundle.putString("method", this.f);
    localBundle.putString("uin", this.g);
    localBundle.putString("ticket", this.h);
    localBundle.putInt("key_identification_type", 4);
    QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_upload", localBundle, new aujo(this, l));
    return;
    label237:
    this.jdField_a_of_type_Aukp.a(2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujn
 * JD-Core Version:    0.7.0.1
 */