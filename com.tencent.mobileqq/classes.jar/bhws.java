import android.os.Looper;
import android.text.TextUtils;
import com.squareup.okhttp.OkHttpClient;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask.1;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask.2;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask.3;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask.4;
import java.io.File;
import java.security.InvalidParameterException;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class bhws
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  bhwr jdField_a_of_type_Bhwr;
  OkHttpClient jdField_a_of_type_ComSquareupOkhttpOkHttpClient;
  String jdField_a_of_type_JavaLangString;
  AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  boolean jdField_a_of_type_Boolean = false;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = true;
  String c;
  String d;
  
  public bhws(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.d = paramString2;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private String a(int paramInt, JSONArray paramJSONArray)
  {
    int i = 0;
    while (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      if (localJSONObject.optInt("position") == paramInt) {
        return localJSONObject.optString("authorization");
      }
      i += 1;
    }
    throw new InvalidParameterException("not found auth data");
  }
  
  private void d()
  {
    String str1 = apgp.a(apue.a(new String(this.c))).toLowerCase();
    int i = bbev.b(BaseApplicationImpl.getContext());
    File localFile = new File(this.c);
    JSONObject localJSONObject = bhwp.a(this.jdField_a_of_type_MqqAppAppRuntime, localFile.getName(), this.d, str1);
    Object localObject;
    if ((localJSONObject != null) && (localJSONObject.optInt("retcode") == 0))
    {
      localObject = localJSONObject.optJSONObject("data");
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, dataObject == null");
        }
        bamh.a("grp_hw", "upload_video", "-1", "", i + "", "");
        if (this.jdField_a_of_type_Bhwr != null) {
          this.jdField_a_of_type_Bhwr.b(2);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            String str2;
            int j;
            do
            {
              for (;;)
              {
                return;
                str2 = ((JSONObject)localObject).optString("file_url");
                if (TextUtils.isEmpty(str2))
                {
                  if (QLog.isColorLevel()) {
                    QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, TextUtils.isEmpty(putUrl)");
                  }
                  bamh.a("grp_hw", "upload_video", "-2", "", i + "", "");
                  if (this.jdField_a_of_type_Bhwr != null) {
                    this.jdField_a_of_type_Bhwr.b(2);
                  }
                }
                else
                {
                  localObject = ((JSONObject)localObject).optString("max_size", "0");
                  if (!TextUtils.isEmpty((CharSequence)localObject)) {
                    try
                    {
                      long l = Long.parseLong((String)localObject);
                      if ((l != 0L) && (localFile.length() > l))
                      {
                        if (QLog.isColorLevel()) {
                          QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, maxSize != 0 && file.length() > maxSize, maxSize:" + l + ", filesize:" + localFile.length());
                        }
                        bamh.a("grp_hw", "upload_video", "-3", "", i + "", "");
                        if (this.jdField_a_of_type_Bhwr == null) {
                          continue;
                        }
                        this.jdField_a_of_type_Bhwr.b(3);
                      }
                    }
                    catch (NumberFormatException localNumberFormatException)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.w("TroopHomeworkHelper", 2, "UploadVideoJob, get MaxSize exception:" + localNumberFormatException.getMessage());
                      }
                    }
                  }
                }
              }
              j = bhwp.a(localJSONObject, this.c, str1);
              if (j != 0) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.i("TroopHomeworkHelper", 2, "doPutCOSData success");
              }
              bamh.a("grp_hw", "upload_video", "0", "1", i + "", "");
            } while (this.jdField_a_of_type_Bhwr == null);
            this.jdField_a_of_type_Bhwr.a(str2);
            return;
            if (QLog.isColorLevel()) {
              QLog.w("TroopHomeworkHelper", 2, "doPutCOSData failed, putResult =" + j);
            }
            bamh.a("grp_hw", "upload_video", "-4", "", i + "", "");
          } while (this.jdField_a_of_type_Bhwr == null);
          this.jdField_a_of_type_Bhwr.b(5);
          return;
          if (localJSONObject == null) {
            break;
          }
          switch (localJSONObject.optInt("retcode"))
          {
          default: 
            if (QLog.isColorLevel()) {
              QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, ret:" + localJSONObject.toString());
            }
            bamh.a("grp_hw", "upload_video", "-6", "", i + "", "");
          }
        } while (this.jdField_a_of_type_Bhwr == null);
        this.jdField_a_of_type_Bhwr.b(2);
        return;
        if (QLog.isColorLevel()) {
          QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, 达到当日上传次数限制, ret:" + localJSONObject.toString());
        }
        bamh.a("grp_hw", "upload_video", "-5", "", i + "", "");
        if (this.jdField_b_of_type_Boolean) {
          ThreadManager.getUIHandler().post(new TroopHomeworkHelper.UploadFileTask.2(this));
        }
      } while (this.jdField_a_of_type_Bhwr == null);
      this.jdField_a_of_type_Bhwr.b(4);
      return;
      if (QLog.isColorLevel()) {
        QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, result == null");
      }
      bamh.a("grp_hw", "upload_video", "-7", "", i + "", "");
    } while (this.jdField_a_of_type_Bhwr == null);
    this.jdField_a_of_type_Bhwr.b(2);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Boolean = false;
    int i = bbev.b(BaseApplicationImpl.getContext());
    File localFile = new File(this.c);
    Object localObject = bhwp.c(this.c);
    localObject = bhwp.b(this.jdField_a_of_type_MqqAppAppRuntime, localFile.getName(), this.d, (String)localObject);
    if ((localObject != null) && (((JSONObject)localObject).optInt("retcode") == 0))
    {
      localObject = ((JSONObject)localObject).optJSONObject("data");
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TroopHomeworkHelper", 2, "getAppendUploadAuthSync failed, dataObject == null");
        }
        bamh.a("grp_hw", "upload_video", "-1", "", i + "", "");
        if (this.jdField_a_of_type_Bhwr != null) {
          this.jdField_a_of_type_Bhwr.b(2);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("file_url");
            if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
            {
              if (QLog.isColorLevel()) {
                QLog.w("TroopHomeworkHelper", 2, "getAppendUploadAuthSync failed, TextUtils.isEmpty(appendUrl)");
              }
              bamh.a("grp_hw", "upload_video", "-2", "", i + "", "");
              if (this.jdField_a_of_type_Bhwr != null) {
                this.jdField_a_of_type_Bhwr.b(2);
              }
            }
            else
            {
              String str = ((JSONObject)localObject).optString("max_size", "0");
              if (!TextUtils.isEmpty(str)) {
                try
                {
                  long l = Long.parseLong(str);
                  if ((l != 0L) && (localFile.length() > l))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.w("TroopHomeworkHelper", 2, "getAppendUploadAuthSync failed, maxSize != 0 && file.length() > maxSize, maxSize:" + l + ", filesize:" + localFile.length());
                    }
                    bamh.a("grp_hw", "upload_video", "-3", "", i + "", "");
                    if (this.jdField_a_of_type_Bhwr == null) {
                      continue;
                    }
                    this.jdField_a_of_type_Bhwr.b(3);
                  }
                }
                catch (NumberFormatException localNumberFormatException)
                {
                  if (QLog.isColorLevel()) {
                    QLog.w("TroopHomeworkHelper", 2, "UploadVideoJob, get MaxSize exception:" + localNumberFormatException.getMessage());
                  }
                }
              }
            }
          }
          this.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)localObject);
          f();
          return;
          if (localObject == null) {
            break;
          }
          switch (((JSONObject)localObject).optInt("retcode"))
          {
          default: 
            if (QLog.isColorLevel()) {
              QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, ret:" + ((JSONObject)localObject).toString());
            }
            bamh.a("grp_hw", "upload_video", "-6", "", i + "", "");
          }
        } while (this.jdField_a_of_type_Bhwr == null);
        this.jdField_a_of_type_Bhwr.b(2);
        return;
        if (QLog.isColorLevel()) {
          QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, 达到当日上传次数限制, ret:" + ((JSONObject)localObject).toString());
        }
        bamh.a("grp_hw", "upload_video", "-5", "", i + "", "");
        if (this.jdField_b_of_type_Boolean) {
          ThreadManager.getUIHandler().post(new TroopHomeworkHelper.UploadFileTask.3(this));
        }
      } while (this.jdField_a_of_type_Bhwr == null);
      this.jdField_a_of_type_Bhwr.b(4);
      return;
      if (QLog.isColorLevel()) {
        QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, result == null");
      }
      bamh.a("grp_hw", "upload_video", "-7", "", i + "", "");
    } while (this.jdField_a_of_type_Bhwr == null);
    this.jdField_a_of_type_Bhwr.b(2);
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 276	bhws:jdField_a_of_type_ComSquareupOkhttpOkHttpClient	Lcom/squareup/okhttp/OkHttpClient;
    //   4: ifnonnull +53 -> 57
    //   7: aload_0
    //   8: new 278	com/squareup/okhttp/OkHttpClient
    //   11: dup
    //   12: invokespecial 279	com/squareup/okhttp/OkHttpClient:<init>	()V
    //   15: putfield 276	bhws:jdField_a_of_type_ComSquareupOkhttpOkHttpClient	Lcom/squareup/okhttp/OkHttpClient;
    //   18: aload_0
    //   19: getfield 276	bhws:jdField_a_of_type_ComSquareupOkhttpOkHttpClient	Lcom/squareup/okhttp/OkHttpClient;
    //   22: ldc2_w 280
    //   25: getstatic 287	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   28: invokevirtual 291	com/squareup/okhttp/OkHttpClient:setConnectTimeout	(JLjava/util/concurrent/TimeUnit;)V
    //   31: aload_0
    //   32: getfield 276	bhws:jdField_a_of_type_ComSquareupOkhttpOkHttpClient	Lcom/squareup/okhttp/OkHttpClient;
    //   35: ldc2_w 280
    //   38: getstatic 287	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   41: invokevirtual 294	com/squareup/okhttp/OkHttpClient:setWriteTimeout	(JLjava/util/concurrent/TimeUnit;)V
    //   44: aload_0
    //   45: getfield 276	bhws:jdField_a_of_type_ComSquareupOkhttpOkHttpClient	Lcom/squareup/okhttp/OkHttpClient;
    //   48: ldc2_w 280
    //   51: getstatic 287	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   54: invokevirtual 297	com/squareup/okhttp/OkHttpClient:setReadTimeout	(JLjava/util/concurrent/TimeUnit;)V
    //   57: invokestatic 91	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   60: invokestatic 96	bbev:b	(Landroid/content/Context;)I
    //   63: istore_3
    //   64: aload_0
    //   65: aload_0
    //   66: getfield 264	bhws:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   69: ldc_w 299
    //   72: invokevirtual 59	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   75: putfield 301	bhws:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   78: aload_0
    //   79: aload_0
    //   80: getfield 264	bhws:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   83: ldc 163
    //   85: invokevirtual 59	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   88: putfield 258	bhws:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   91: aload_0
    //   92: getfield 264	bhws:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   95: ldc_w 303
    //   98: invokevirtual 307	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   101: astore 14
    //   103: aload_0
    //   104: iconst_3
    //   105: putfield 309	bhws:jdField_a_of_type_Int	I
    //   108: new 311	java/io/RandomAccessFile
    //   111: dup
    //   112: aload_0
    //   113: getfield 27	bhws:c	Ljava/lang/String;
    //   116: ldc_w 313
    //   119: invokespecial 316	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: astore 12
    //   124: aload 12
    //   126: astore 13
    //   128: aload 12
    //   130: invokevirtual 317	java/io/RandomAccessFile:length	()J
    //   133: lstore 9
    //   135: aload 12
    //   137: astore 13
    //   139: aload_0
    //   140: getfield 33	bhws:jdField_a_of_type_Long	J
    //   143: lstore 5
    //   145: aload 12
    //   147: astore 13
    //   149: aload_0
    //   150: getfield 33	bhws:jdField_a_of_type_Long	J
    //   153: lload 9
    //   155: lcmp
    //   156: ifge +663 -> 819
    //   159: aload 12
    //   161: astore 13
    //   163: aload_0
    //   164: getfield 23	bhws:jdField_a_of_type_Boolean	Z
    //   167: istore 11
    //   169: iload 11
    //   171: ifeq +22 -> 193
    //   174: aload 12
    //   176: ifnull +8 -> 184
    //   179: aload 12
    //   181: invokevirtual 320	java/io/RandomAccessFile:close	()V
    //   184: return
    //   185: astore 12
    //   187: aload 12
    //   189: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   192: return
    //   193: aload 12
    //   195: astore 13
    //   197: lload 9
    //   199: aload_0
    //   200: getfield 33	bhws:jdField_a_of_type_Long	J
    //   203: lsub
    //   204: ldc2_w 324
    //   207: lcmp
    //   208: ifle +121 -> 329
    //   211: aload 12
    //   213: astore 13
    //   215: aload_0
    //   216: aload_0
    //   217: getfield 33	bhws:jdField_a_of_type_Long	J
    //   220: ldc2_w 326
    //   223: ladd
    //   224: putfield 33	bhws:jdField_a_of_type_Long	J
    //   227: aload 12
    //   229: astore 13
    //   231: aload_0
    //   232: getfield 33	bhws:jdField_a_of_type_Long	J
    //   235: lload 5
    //   237: lsub
    //   238: lstore 7
    //   240: aload 12
    //   242: astore 13
    //   244: lload 7
    //   246: l2i
    //   247: newarray byte
    //   249: astore 15
    //   251: iconst_0
    //   252: istore_1
    //   253: aload 12
    //   255: astore 13
    //   257: aload 12
    //   259: lload 5
    //   261: invokevirtual 331	java/io/RandomAccessFile:seek	(J)V
    //   264: aload 12
    //   266: astore 13
    //   268: sipush 4096
    //   271: newarray byte
    //   273: astore 16
    //   275: aload 12
    //   277: astore 13
    //   279: aload 12
    //   281: aload 16
    //   283: invokevirtual 335	java/io/RandomAccessFile:read	([B)I
    //   286: istore 4
    //   288: iload_1
    //   289: istore_2
    //   290: iload 4
    //   292: ifle +152 -> 444
    //   295: iload_1
    //   296: iload 4
    //   298: iadd
    //   299: i2l
    //   300: lload 7
    //   302: lcmp
    //   303: ifgt +116 -> 419
    //   306: aload 12
    //   308: astore 13
    //   310: aload 16
    //   312: iconst_0
    //   313: aload 15
    //   315: iload_1
    //   316: iload 4
    //   318: invokestatic 341	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   321: iload_1
    //   322: iload 4
    //   324: iadd
    //   325: istore_1
    //   326: goto -51 -> 275
    //   329: aload 12
    //   331: astore 13
    //   333: aload_0
    //   334: lload 9
    //   336: putfield 33	bhws:jdField_a_of_type_Long	J
    //   339: goto -112 -> 227
    //   342: astore 13
    //   344: aload_0
    //   345: getfield 156	bhws:jdField_a_of_type_Bhwr	Lbhwr;
    //   348: ifnull +14 -> 362
    //   351: aload_0
    //   352: getfield 156	bhws:jdField_a_of_type_Bhwr	Lbhwr;
    //   355: bipush 6
    //   357: invokeinterface 161 2 0
    //   362: ldc 130
    //   364: ldc 132
    //   366: ldc_w 343
    //   369: ldc 136
    //   371: new 138	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   378: iload_3
    //   379: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   382: ldc 136
    //   384: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: ldc 136
    //   392: invokestatic 154	bamh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload_0
    //   396: lconst_0
    //   397: putfield 33	bhws:jdField_a_of_type_Long	J
    //   400: aload 12
    //   402: ifnull -218 -> 184
    //   405: aload 12
    //   407: invokevirtual 320	java/io/RandomAccessFile:close	()V
    //   410: return
    //   411: astore 12
    //   413: aload 12
    //   415: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   418: return
    //   419: lload 7
    //   421: iload_1
    //   422: i2l
    //   423: lsub
    //   424: l2i
    //   425: istore_2
    //   426: aload 12
    //   428: astore 13
    //   430: aload 16
    //   432: iconst_0
    //   433: aload 15
    //   435: iload_1
    //   436: iload_2
    //   437: invokestatic 341	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   440: lload 7
    //   442: l2i
    //   443: istore_2
    //   444: aload 12
    //   446: astore 13
    //   448: ldc_w 345
    //   451: invokestatic 351	com/squareup/okhttp/MediaType:parse	(Ljava/lang/String;)Lcom/squareup/okhttp/MediaType;
    //   454: aload 15
    //   456: iconst_0
    //   457: iload_2
    //   458: invokestatic 357	com/squareup/okhttp/RequestBody:create	(Lcom/squareup/okhttp/MediaType;[BII)Lcom/squareup/okhttp/RequestBody;
    //   461: astore 15
    //   463: aload 12
    //   465: astore 13
    //   467: new 359	com/squareup/okhttp/Request$Builder
    //   470: dup
    //   471: invokespecial 360	com/squareup/okhttp/Request$Builder:<init>	()V
    //   474: new 138	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   481: aload_0
    //   482: getfield 258	bhws:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   485: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: ldc_w 362
    //   491: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: lload 5
    //   496: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   499: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokevirtual 366	com/squareup/okhttp/Request$Builder:url	(Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   505: ldc_w 368
    //   508: aload_0
    //   509: getfield 301	bhws:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   512: invokevirtual 372	com/squareup/okhttp/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   515: ldc_w 374
    //   518: ldc_w 376
    //   521: invokevirtual 372	com/squareup/okhttp/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   524: ldc_w 378
    //   527: ldc_w 345
    //   530: invokevirtual 372	com/squareup/okhttp/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   533: ldc_w 380
    //   536: aload_0
    //   537: lload 5
    //   539: l2i
    //   540: aload 14
    //   542: invokespecial 382	bhws:a	(ILorg/json/JSONArray;)Ljava/lang/String;
    //   545: invokevirtual 372	com/squareup/okhttp/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/Request$Builder;
    //   548: aload 15
    //   550: invokevirtual 385	com/squareup/okhttp/Request$Builder:post	(Lcom/squareup/okhttp/RequestBody;)Lcom/squareup/okhttp/Request$Builder;
    //   553: invokevirtual 389	com/squareup/okhttp/Request$Builder:build	()Lcom/squareup/okhttp/Request;
    //   556: astore 15
    //   558: aload 12
    //   560: astore 13
    //   562: aload_0
    //   563: getfield 276	bhws:jdField_a_of_type_ComSquareupOkhttpOkHttpClient	Lcom/squareup/okhttp/OkHttpClient;
    //   566: aload 15
    //   568: invokevirtual 393	com/squareup/okhttp/OkHttpClient:newCall	(Lcom/squareup/okhttp/Request;)Lcom/squareup/okhttp/Call;
    //   571: invokevirtual 399	com/squareup/okhttp/Call:execute	()Lcom/squareup/okhttp/Response;
    //   574: astore 15
    //   576: aload 12
    //   578: astore 13
    //   580: aload 15
    //   582: invokevirtual 404	com/squareup/okhttp/Response:isSuccessful	()Z
    //   585: ifeq +134 -> 719
    //   588: aload 12
    //   590: astore 13
    //   592: aload_0
    //   593: getfield 156	bhws:jdField_a_of_type_Bhwr	Lbhwr;
    //   596: ifnull +97 -> 693
    //   599: aload 12
    //   601: astore 13
    //   603: aload_0
    //   604: getfield 156	bhws:jdField_a_of_type_Bhwr	Lbhwr;
    //   607: iload_2
    //   608: i2l
    //   609: lload 5
    //   611: ladd
    //   612: ldc2_w 405
    //   615: lmul
    //   616: lload 9
    //   618: ldiv
    //   619: l2i
    //   620: invokeinterface 408 2 0
    //   625: aload 12
    //   627: astore 13
    //   629: aload_0
    //   630: getfield 33	bhws:jdField_a_of_type_Long	J
    //   633: lload 9
    //   635: lcmp
    //   636: iflt +57 -> 693
    //   639: aload 12
    //   641: astore 13
    //   643: ldc 130
    //   645: ldc 132
    //   647: ldc 177
    //   649: ldc_w 410
    //   652: new 138	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   659: iload_3
    //   660: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   663: ldc 136
    //   665: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   671: ldc 136
    //   673: invokestatic 154	bamh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   676: aload 12
    //   678: astore 13
    //   680: aload_0
    //   681: getfield 156	bhws:jdField_a_of_type_Bhwr	Lbhwr;
    //   684: aload_0
    //   685: getfield 258	bhws:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   688: invokeinterface 215 2 0
    //   693: aload 12
    //   695: astore 13
    //   697: aload_0
    //   698: iconst_3
    //   699: putfield 309	bhws:jdField_a_of_type_Int	I
    //   702: aload 12
    //   704: astore 13
    //   706: aload_0
    //   707: getfield 33	bhws:jdField_a_of_type_Long	J
    //   710: lstore 7
    //   712: lload 7
    //   714: lstore 5
    //   716: goto +506 -> 1222
    //   719: aload 12
    //   721: astore 13
    //   723: aload_0
    //   724: getfield 309	bhws:jdField_a_of_type_Int	I
    //   727: iconst_1
    //   728: isub
    //   729: istore_1
    //   730: aload 12
    //   732: astore 13
    //   734: aload_0
    //   735: iload_1
    //   736: putfield 309	bhws:jdField_a_of_type_Int	I
    //   739: iload_1
    //   740: ifgt +98 -> 838
    //   743: aload 12
    //   745: astore 13
    //   747: ldc 130
    //   749: ldc 132
    //   751: ldc_w 412
    //   754: ldc 136
    //   756: new 138	java/lang/StringBuilder
    //   759: dup
    //   760: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   763: iload_3
    //   764: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   767: ldc 136
    //   769: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   775: ldc 136
    //   777: invokestatic 154	bamh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   780: aload 12
    //   782: astore 13
    //   784: aload_0
    //   785: getfield 156	bhws:jdField_a_of_type_Bhwr	Lbhwr;
    //   788: ifnull +434 -> 1222
    //   791: aload 12
    //   793: astore 13
    //   795: aload_0
    //   796: getfield 156	bhws:jdField_a_of_type_Bhwr	Lbhwr;
    //   799: aload 15
    //   801: invokevirtual 415	com/squareup/okhttp/Response:code	()I
    //   804: invokeinterface 161 2 0
    //   809: aload 12
    //   811: astore 13
    //   813: aload_0
    //   814: lload 5
    //   816: putfield 33	bhws:jdField_a_of_type_Long	J
    //   819: aload 12
    //   821: ifnull -637 -> 184
    //   824: aload 12
    //   826: invokevirtual 320	java/io/RandomAccessFile:close	()V
    //   829: return
    //   830: astore 12
    //   832: aload 12
    //   834: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   837: return
    //   838: aload 12
    //   840: astore 13
    //   842: aload_0
    //   843: lload 5
    //   845: putfield 33	bhws:jdField_a_of_type_Long	J
    //   848: goto -703 -> 145
    //   851: astore 13
    //   853: aload 12
    //   855: astore 13
    //   857: aload_0
    //   858: getfield 309	bhws:jdField_a_of_type_Int	I
    //   861: iconst_1
    //   862: isub
    //   863: istore_1
    //   864: aload 12
    //   866: astore 13
    //   868: aload_0
    //   869: iload_1
    //   870: putfield 309	bhws:jdField_a_of_type_Int	I
    //   873: iload_1
    //   874: ifgt +172 -> 1046
    //   877: aload 12
    //   879: astore 13
    //   881: ldc 130
    //   883: ldc 132
    //   885: ldc_w 417
    //   888: ldc 136
    //   890: new 138	java/lang/StringBuilder
    //   893: dup
    //   894: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   897: iload_3
    //   898: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   901: ldc 136
    //   903: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   909: ldc 136
    //   911: invokestatic 154	bamh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   914: aload 12
    //   916: astore 13
    //   918: aload_0
    //   919: getfield 156	bhws:jdField_a_of_type_Bhwr	Lbhwr;
    //   922: ifnull +300 -> 1222
    //   925: aload 12
    //   927: astore 13
    //   929: aload_0
    //   930: getfield 156	bhws:jdField_a_of_type_Bhwr	Lbhwr;
    //   933: bipush 6
    //   935: invokeinterface 161 2 0
    //   940: aload 12
    //   942: astore 13
    //   944: aload_0
    //   945: lload 5
    //   947: putfield 33	bhws:jdField_a_of_type_Long	J
    //   950: goto -131 -> 819
    //   953: astore 13
    //   955: aload 12
    //   957: astore 13
    //   959: aload_0
    //   960: getfield 156	bhws:jdField_a_of_type_Bhwr	Lbhwr;
    //   963: ifnull +18 -> 981
    //   966: aload 12
    //   968: astore 13
    //   970: aload_0
    //   971: getfield 156	bhws:jdField_a_of_type_Bhwr	Lbhwr;
    //   974: bipush 6
    //   976: invokeinterface 161 2 0
    //   981: aload 12
    //   983: astore 13
    //   985: ldc 130
    //   987: ldc 132
    //   989: ldc_w 419
    //   992: ldc 136
    //   994: new 138	java/lang/StringBuilder
    //   997: dup
    //   998: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   1001: iload_3
    //   1002: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1005: ldc 136
    //   1007: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1013: ldc 136
    //   1015: invokestatic 154	bamh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1018: aload 12
    //   1020: astore 13
    //   1022: aload_0
    //   1023: lconst_0
    //   1024: putfield 33	bhws:jdField_a_of_type_Long	J
    //   1027: aload 12
    //   1029: ifnull -845 -> 184
    //   1032: aload 12
    //   1034: invokevirtual 320	java/io/RandomAccessFile:close	()V
    //   1037: return
    //   1038: astore 12
    //   1040: aload 12
    //   1042: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   1045: return
    //   1046: aload 12
    //   1048: astore 13
    //   1050: aload_0
    //   1051: lload 5
    //   1053: putfield 33	bhws:jdField_a_of_type_Long	J
    //   1056: goto -911 -> 145
    //   1059: astore 13
    //   1061: aload 12
    //   1063: astore 13
    //   1065: aload_0
    //   1066: getfield 156	bhws:jdField_a_of_type_Bhwr	Lbhwr;
    //   1069: ifnull +18 -> 1087
    //   1072: aload 12
    //   1074: astore 13
    //   1076: aload_0
    //   1077: getfield 156	bhws:jdField_a_of_type_Bhwr	Lbhwr;
    //   1080: bipush 6
    //   1082: invokeinterface 161 2 0
    //   1087: aload 12
    //   1089: astore 13
    //   1091: ldc 130
    //   1093: ldc 132
    //   1095: ldc_w 421
    //   1098: ldc 136
    //   1100: new 138	java/lang/StringBuilder
    //   1103: dup
    //   1104: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   1107: iload_3
    //   1108: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1111: ldc 136
    //   1113: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1119: ldc 136
    //   1121: invokestatic 154	bamh:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1124: aload 12
    //   1126: astore 13
    //   1128: aload_0
    //   1129: lconst_0
    //   1130: putfield 33	bhws:jdField_a_of_type_Long	J
    //   1133: aload 12
    //   1135: ifnull -951 -> 184
    //   1138: aload 12
    //   1140: invokevirtual 320	java/io/RandomAccessFile:close	()V
    //   1143: return
    //   1144: astore 12
    //   1146: aload 12
    //   1148: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   1151: return
    //   1152: astore 12
    //   1154: aconst_null
    //   1155: astore 13
    //   1157: aload 13
    //   1159: ifnull +8 -> 1167
    //   1162: aload 13
    //   1164: invokevirtual 320	java/io/RandomAccessFile:close	()V
    //   1167: aload 12
    //   1169: athrow
    //   1170: astore 13
    //   1172: aload 13
    //   1174: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   1177: goto -10 -> 1167
    //   1180: astore 12
    //   1182: goto -25 -> 1157
    //   1185: astore 14
    //   1187: aload 12
    //   1189: astore 13
    //   1191: aload 14
    //   1193: astore 12
    //   1195: goto -38 -> 1157
    //   1198: astore 12
    //   1200: aconst_null
    //   1201: astore 12
    //   1203: goto -142 -> 1061
    //   1206: astore 12
    //   1208: aconst_null
    //   1209: astore 12
    //   1211: goto -256 -> 955
    //   1214: astore 12
    //   1216: aconst_null
    //   1217: astore 12
    //   1219: goto -875 -> 344
    //   1222: goto -1077 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1225	0	this	bhws
    //   252	622	1	i	int
    //   289	319	2	j	int
    //   63	1045	3	k	int
    //   286	39	4	m	int
    //   143	909	5	l1	long
    //   238	475	7	l2	long
    //   133	501	9	l3	long
    //   167	3	11	bool	boolean
    //   122	58	12	localRandomAccessFile	java.io.RandomAccessFile
    //   185	221	12	localIOException1	java.io.IOException
    //   411	414	12	localIOException2	java.io.IOException
    //   830	203	12	localIOException3	java.io.IOException
    //   1038	101	12	localIOException4	java.io.IOException
    //   1144	3	12	localIOException5	java.io.IOException
    //   1152	16	12	localObject1	Object
    //   1180	8	12	localObject2	Object
    //   1193	1	12	localObject3	Object
    //   1198	1	12	localInvalidParameterException1	InvalidParameterException
    //   1201	1	12	localObject4	Object
    //   1206	1	12	localIOException6	java.io.IOException
    //   1209	1	12	localObject5	Object
    //   1214	1	12	localFileNotFoundException1	java.io.FileNotFoundException
    //   1217	1	12	localObject6	Object
    //   126	206	13	localObject7	Object
    //   342	1	13	localFileNotFoundException2	java.io.FileNotFoundException
    //   428	413	13	localIOException7	java.io.IOException
    //   851	1	13	localIOException8	java.io.IOException
    //   855	88	13	localIOException9	java.io.IOException
    //   953	1	13	localIOException10	java.io.IOException
    //   957	92	13	localIOException11	java.io.IOException
    //   1059	1	13	localInvalidParameterException2	InvalidParameterException
    //   1063	100	13	localIOException12	java.io.IOException
    //   1170	3	13	localIOException13	java.io.IOException
    //   1189	1	13	localObject8	Object
    //   101	440	14	localJSONArray	JSONArray
    //   1185	7	14	localObject9	Object
    //   249	551	15	localObject10	Object
    //   273	158	16	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   179	184	185	java/io/IOException
    //   128	135	342	java/io/FileNotFoundException
    //   139	145	342	java/io/FileNotFoundException
    //   149	159	342	java/io/FileNotFoundException
    //   163	169	342	java/io/FileNotFoundException
    //   197	211	342	java/io/FileNotFoundException
    //   215	227	342	java/io/FileNotFoundException
    //   231	240	342	java/io/FileNotFoundException
    //   244	251	342	java/io/FileNotFoundException
    //   257	264	342	java/io/FileNotFoundException
    //   268	275	342	java/io/FileNotFoundException
    //   279	288	342	java/io/FileNotFoundException
    //   310	321	342	java/io/FileNotFoundException
    //   333	339	342	java/io/FileNotFoundException
    //   430	440	342	java/io/FileNotFoundException
    //   448	463	342	java/io/FileNotFoundException
    //   467	558	342	java/io/FileNotFoundException
    //   562	576	342	java/io/FileNotFoundException
    //   580	588	342	java/io/FileNotFoundException
    //   592	599	342	java/io/FileNotFoundException
    //   603	625	342	java/io/FileNotFoundException
    //   629	639	342	java/io/FileNotFoundException
    //   643	676	342	java/io/FileNotFoundException
    //   680	693	342	java/io/FileNotFoundException
    //   697	702	342	java/io/FileNotFoundException
    //   706	712	342	java/io/FileNotFoundException
    //   723	730	342	java/io/FileNotFoundException
    //   734	739	342	java/io/FileNotFoundException
    //   747	780	342	java/io/FileNotFoundException
    //   784	791	342	java/io/FileNotFoundException
    //   795	809	342	java/io/FileNotFoundException
    //   813	819	342	java/io/FileNotFoundException
    //   842	848	342	java/io/FileNotFoundException
    //   857	864	342	java/io/FileNotFoundException
    //   868	873	342	java/io/FileNotFoundException
    //   881	914	342	java/io/FileNotFoundException
    //   918	925	342	java/io/FileNotFoundException
    //   929	940	342	java/io/FileNotFoundException
    //   944	950	342	java/io/FileNotFoundException
    //   1050	1056	342	java/io/FileNotFoundException
    //   405	410	411	java/io/IOException
    //   824	829	830	java/io/IOException
    //   562	576	851	java/io/IOException
    //   580	588	851	java/io/IOException
    //   592	599	851	java/io/IOException
    //   603	625	851	java/io/IOException
    //   629	639	851	java/io/IOException
    //   643	676	851	java/io/IOException
    //   680	693	851	java/io/IOException
    //   697	702	851	java/io/IOException
    //   706	712	851	java/io/IOException
    //   723	730	851	java/io/IOException
    //   734	739	851	java/io/IOException
    //   747	780	851	java/io/IOException
    //   784	791	851	java/io/IOException
    //   795	809	851	java/io/IOException
    //   813	819	851	java/io/IOException
    //   842	848	851	java/io/IOException
    //   128	135	953	java/io/IOException
    //   139	145	953	java/io/IOException
    //   149	159	953	java/io/IOException
    //   163	169	953	java/io/IOException
    //   197	211	953	java/io/IOException
    //   215	227	953	java/io/IOException
    //   231	240	953	java/io/IOException
    //   244	251	953	java/io/IOException
    //   257	264	953	java/io/IOException
    //   268	275	953	java/io/IOException
    //   279	288	953	java/io/IOException
    //   310	321	953	java/io/IOException
    //   333	339	953	java/io/IOException
    //   430	440	953	java/io/IOException
    //   448	463	953	java/io/IOException
    //   467	558	953	java/io/IOException
    //   857	864	953	java/io/IOException
    //   868	873	953	java/io/IOException
    //   881	914	953	java/io/IOException
    //   918	925	953	java/io/IOException
    //   929	940	953	java/io/IOException
    //   944	950	953	java/io/IOException
    //   1050	1056	953	java/io/IOException
    //   1032	1037	1038	java/io/IOException
    //   128	135	1059	java/security/InvalidParameterException
    //   139	145	1059	java/security/InvalidParameterException
    //   149	159	1059	java/security/InvalidParameterException
    //   163	169	1059	java/security/InvalidParameterException
    //   197	211	1059	java/security/InvalidParameterException
    //   215	227	1059	java/security/InvalidParameterException
    //   231	240	1059	java/security/InvalidParameterException
    //   244	251	1059	java/security/InvalidParameterException
    //   257	264	1059	java/security/InvalidParameterException
    //   268	275	1059	java/security/InvalidParameterException
    //   279	288	1059	java/security/InvalidParameterException
    //   310	321	1059	java/security/InvalidParameterException
    //   333	339	1059	java/security/InvalidParameterException
    //   430	440	1059	java/security/InvalidParameterException
    //   448	463	1059	java/security/InvalidParameterException
    //   467	558	1059	java/security/InvalidParameterException
    //   562	576	1059	java/security/InvalidParameterException
    //   580	588	1059	java/security/InvalidParameterException
    //   592	599	1059	java/security/InvalidParameterException
    //   603	625	1059	java/security/InvalidParameterException
    //   629	639	1059	java/security/InvalidParameterException
    //   643	676	1059	java/security/InvalidParameterException
    //   680	693	1059	java/security/InvalidParameterException
    //   697	702	1059	java/security/InvalidParameterException
    //   706	712	1059	java/security/InvalidParameterException
    //   723	730	1059	java/security/InvalidParameterException
    //   734	739	1059	java/security/InvalidParameterException
    //   747	780	1059	java/security/InvalidParameterException
    //   784	791	1059	java/security/InvalidParameterException
    //   795	809	1059	java/security/InvalidParameterException
    //   813	819	1059	java/security/InvalidParameterException
    //   842	848	1059	java/security/InvalidParameterException
    //   857	864	1059	java/security/InvalidParameterException
    //   868	873	1059	java/security/InvalidParameterException
    //   881	914	1059	java/security/InvalidParameterException
    //   918	925	1059	java/security/InvalidParameterException
    //   929	940	1059	java/security/InvalidParameterException
    //   944	950	1059	java/security/InvalidParameterException
    //   1050	1056	1059	java/security/InvalidParameterException
    //   1138	1143	1144	java/io/IOException
    //   108	124	1152	finally
    //   1162	1167	1170	java/io/IOException
    //   128	135	1180	finally
    //   139	145	1180	finally
    //   149	159	1180	finally
    //   163	169	1180	finally
    //   197	211	1180	finally
    //   215	227	1180	finally
    //   231	240	1180	finally
    //   244	251	1180	finally
    //   257	264	1180	finally
    //   268	275	1180	finally
    //   279	288	1180	finally
    //   310	321	1180	finally
    //   333	339	1180	finally
    //   430	440	1180	finally
    //   448	463	1180	finally
    //   467	558	1180	finally
    //   562	576	1180	finally
    //   580	588	1180	finally
    //   592	599	1180	finally
    //   603	625	1180	finally
    //   629	639	1180	finally
    //   643	676	1180	finally
    //   680	693	1180	finally
    //   697	702	1180	finally
    //   706	712	1180	finally
    //   723	730	1180	finally
    //   734	739	1180	finally
    //   747	780	1180	finally
    //   784	791	1180	finally
    //   795	809	1180	finally
    //   813	819	1180	finally
    //   842	848	1180	finally
    //   857	864	1180	finally
    //   868	873	1180	finally
    //   881	914	1180	finally
    //   918	925	1180	finally
    //   929	940	1180	finally
    //   944	950	1180	finally
    //   959	966	1180	finally
    //   970	981	1180	finally
    //   985	1018	1180	finally
    //   1022	1027	1180	finally
    //   1050	1056	1180	finally
    //   1065	1072	1180	finally
    //   1076	1087	1180	finally
    //   1091	1124	1180	finally
    //   1128	1133	1180	finally
    //   344	362	1185	finally
    //   362	400	1185	finally
    //   108	124	1198	java/security/InvalidParameterException
    //   108	124	1206	java/io/IOException
    //   108	124	1214	java/io/FileNotFoundException
  }
  
  public void a()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new TroopHomeworkHelper.UploadFileTask.1(this), 8, null, true);
      return;
    }
    File localFile = new File(this.c);
    if (((!localFile.exists()) || (localFile.length() == 0L)) && (this.jdField_a_of_type_Bhwr != null))
    {
      this.jdField_a_of_type_Bhwr.b(-1);
      int i = bbev.b(BaseApplicationImpl.getContext());
      bamh.a("grp_hw", "upload_video", "-13", "", i + "", "");
      return;
    }
    if (localFile.length() > 4096L)
    {
      e();
      return;
    }
    d();
  }
  
  public void a(bhwr parambhwr)
  {
    this.jdField_a_of_type_Bhwr = parambhwr;
  }
  
  public void b()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      ThreadManager.post(new TroopHomeworkHelper.UploadFileTask.4(this), 8, null, true);
    }
    do
    {
      return;
      File localFile = new File(this.c);
      if (((!localFile.exists()) || (localFile.length() == 0L)) && (this.jdField_a_of_type_Bhwr != null))
      {
        this.jdField_a_of_type_Bhwr.b(-1);
        int i = bbev.b(BaseApplicationImpl.getContext());
        bamh.a("grp_hw", "upload_video", "-13", "", i + "", "");
        return;
      }
      if (localFile.length() <= 4096L) {
        break label172;
      }
      if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
        break label167;
      }
      if (this.jdField_a_of_type_Long < localFile.length()) {
        break;
      }
    } while (this.jdField_a_of_type_Bhwr == null);
    this.jdField_a_of_type_Bhwr.a(this.jdField_a_of_type_JavaLangString);
    return;
    f();
    return;
    label167:
    e();
    return;
    label172:
    d();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhws
 * JD-Core Version:    0.7.0.1
 */