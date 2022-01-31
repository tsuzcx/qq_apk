import android.os.Looper;
import android.text.TextUtils;
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
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class bjyu
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  bjyt jdField_a_of_type_Bjyt;
  String jdField_a_of_type_JavaLangString;
  AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  OkHttpClient jdField_a_of_type_Okhttp3OkHttpClient;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  boolean jdField_a_of_type_Boolean = false;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = true;
  String c;
  String d;
  
  public bjyu(AppRuntime paramAppRuntime, String paramString1, String paramString2)
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
    String str1 = aqzr.a(arni.a(new String(this.c))).toLowerCase();
    int i = bdee.b(BaseApplicationImpl.getContext());
    File localFile = new File(this.c);
    JSONObject localJSONObject = bjyr.a(this.jdField_a_of_type_MqqAppAppRuntime, localFile.getName(), this.d, str1);
    Object localObject;
    if ((localJSONObject != null) && (localJSONObject.optInt("retcode") == 0))
    {
      localObject = localJSONObject.optJSONObject("data");
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, dataObject == null");
        }
        bcli.a("grp_hw", "upload_video", "-1", "", i + "", "");
        if (this.jdField_a_of_type_Bjyt != null) {
          this.jdField_a_of_type_Bjyt.b(2);
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
                  bcli.a("grp_hw", "upload_video", "-2", "", i + "", "");
                  if (this.jdField_a_of_type_Bjyt != null) {
                    this.jdField_a_of_type_Bjyt.b(2);
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
                        bcli.a("grp_hw", "upload_video", "-3", "", i + "", "");
                        if (this.jdField_a_of_type_Bjyt == null) {
                          continue;
                        }
                        this.jdField_a_of_type_Bjyt.b(3);
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
              j = bjyr.a(localJSONObject, this.c, str1);
              if (j != 0) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.i("TroopHomeworkHelper", 2, "doPutCOSData success");
              }
              bcli.a("grp_hw", "upload_video", "0", "1", i + "", "");
            } while (this.jdField_a_of_type_Bjyt == null);
            this.jdField_a_of_type_Bjyt.a(str2);
            return;
            if (QLog.isColorLevel()) {
              QLog.w("TroopHomeworkHelper", 2, "doPutCOSData failed, putResult =" + j);
            }
            bcli.a("grp_hw", "upload_video", "-4", "", i + "", "");
          } while (this.jdField_a_of_type_Bjyt == null);
          this.jdField_a_of_type_Bjyt.b(5);
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
            bcli.a("grp_hw", "upload_video", "-6", "", i + "", "");
          }
        } while (this.jdField_a_of_type_Bjyt == null);
        this.jdField_a_of_type_Bjyt.b(2);
        return;
        if (QLog.isColorLevel()) {
          QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, 达到当日上传次数限制, ret:" + localJSONObject.toString());
        }
        bcli.a("grp_hw", "upload_video", "-5", "", i + "", "");
        if (this.jdField_b_of_type_Boolean) {
          ThreadManager.getUIHandler().post(new TroopHomeworkHelper.UploadFileTask.2(this));
        }
      } while (this.jdField_a_of_type_Bjyt == null);
      this.jdField_a_of_type_Bjyt.b(4);
      return;
      if (QLog.isColorLevel()) {
        QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, result == null");
      }
      bcli.a("grp_hw", "upload_video", "-7", "", i + "", "");
    } while (this.jdField_a_of_type_Bjyt == null);
    this.jdField_a_of_type_Bjyt.b(2);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Boolean = false;
    int i = bdee.b(BaseApplicationImpl.getContext());
    File localFile = new File(this.c);
    Object localObject = bjyr.c(this.c);
    localObject = bjyr.b(this.jdField_a_of_type_MqqAppAppRuntime, localFile.getName(), this.d, (String)localObject);
    if ((localObject != null) && (((JSONObject)localObject).optInt("retcode") == 0))
    {
      localObject = ((JSONObject)localObject).optJSONObject("data");
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TroopHomeworkHelper", 2, "getAppendUploadAuthSync failed, dataObject == null");
        }
        bcli.a("grp_hw", "upload_video", "-1", "", i + "", "");
        if (this.jdField_a_of_type_Bjyt != null) {
          this.jdField_a_of_type_Bjyt.b(2);
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
              bcli.a("grp_hw", "upload_video", "-2", "", i + "", "");
              if (this.jdField_a_of_type_Bjyt != null) {
                this.jdField_a_of_type_Bjyt.b(2);
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
                    bcli.a("grp_hw", "upload_video", "-3", "", i + "", "");
                    if (this.jdField_a_of_type_Bjyt == null) {
                      continue;
                    }
                    this.jdField_a_of_type_Bjyt.b(3);
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
            bcli.a("grp_hw", "upload_video", "-6", "", i + "", "");
          }
        } while (this.jdField_a_of_type_Bjyt == null);
        this.jdField_a_of_type_Bjyt.b(2);
        return;
        if (QLog.isColorLevel()) {
          QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, 达到当日上传次数限制, ret:" + ((JSONObject)localObject).toString());
        }
        bcli.a("grp_hw", "upload_video", "-5", "", i + "", "");
        if (this.jdField_b_of_type_Boolean) {
          ThreadManager.getUIHandler().post(new TroopHomeworkHelper.UploadFileTask.3(this));
        }
      } while (this.jdField_a_of_type_Bjyt == null);
      this.jdField_a_of_type_Bjyt.b(4);
      return;
      if (QLog.isColorLevel()) {
        QLog.w("TroopHomeworkHelper", 2, "getCosUploadAuthSync failed, result == null");
      }
      bcli.a("grp_hw", "upload_video", "-7", "", i + "", "");
    } while (this.jdField_a_of_type_Bjyt == null);
    this.jdField_a_of_type_Bjyt.b(2);
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 276	bjyu:jdField_a_of_type_Okhttp3OkHttpClient	Lokhttp3/OkHttpClient;
    //   4: ifnonnull +47 -> 51
    //   7: aload_0
    //   8: new 278	okhttp3/OkHttpClient
    //   11: dup
    //   12: invokespecial 279	okhttp3/OkHttpClient:<init>	()V
    //   15: invokevirtual 283	okhttp3/OkHttpClient:newBuilder	()Lokhttp3/OkHttpClient$Builder;
    //   18: ldc2_w 284
    //   21: getstatic 291	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   24: invokevirtual 297	okhttp3/OkHttpClient$Builder:connectTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   27: ldc2_w 284
    //   30: getstatic 291	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   33: invokevirtual 300	okhttp3/OkHttpClient$Builder:writeTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   36: ldc2_w 284
    //   39: getstatic 291	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   42: invokevirtual 303	okhttp3/OkHttpClient$Builder:readTimeout	(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;
    //   45: invokevirtual 307	okhttp3/OkHttpClient$Builder:build	()Lokhttp3/OkHttpClient;
    //   48: putfield 276	bjyu:jdField_a_of_type_Okhttp3OkHttpClient	Lokhttp3/OkHttpClient;
    //   51: invokestatic 91	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   54: invokestatic 96	bdee:b	(Landroid/content/Context;)I
    //   57: istore_3
    //   58: aload_0
    //   59: aload_0
    //   60: getfield 264	bjyu:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   63: ldc_w 309
    //   66: invokevirtual 59	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   69: putfield 311	bjyu:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 264	bjyu:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   77: ldc 163
    //   79: invokevirtual 59	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   82: putfield 258	bjyu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   85: aload_0
    //   86: getfield 264	bjyu:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   89: ldc_w 313
    //   92: invokevirtual 317	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   95: astore 14
    //   97: aload_0
    //   98: iconst_3
    //   99: putfield 319	bjyu:jdField_a_of_type_Int	I
    //   102: new 321	java/io/RandomAccessFile
    //   105: dup
    //   106: aload_0
    //   107: getfield 27	bjyu:c	Ljava/lang/String;
    //   110: ldc_w 323
    //   113: invokespecial 326	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: astore 13
    //   118: aload 13
    //   120: astore 12
    //   122: aload 13
    //   124: invokevirtual 327	java/io/RandomAccessFile:length	()J
    //   127: lstore 9
    //   129: aload 13
    //   131: astore 12
    //   133: aload_0
    //   134: getfield 33	bjyu:jdField_a_of_type_Long	J
    //   137: lstore 5
    //   139: aload 13
    //   141: astore 12
    //   143: aload_0
    //   144: getfield 33	bjyu:jdField_a_of_type_Long	J
    //   147: lload 9
    //   149: lcmp
    //   150: ifge +705 -> 855
    //   153: aload 13
    //   155: astore 12
    //   157: aload_0
    //   158: getfield 23	bjyu:jdField_a_of_type_Boolean	Z
    //   161: istore 11
    //   163: iload 11
    //   165: ifeq +22 -> 187
    //   168: aload 13
    //   170: ifnull +8 -> 178
    //   173: aload 13
    //   175: invokevirtual 330	java/io/RandomAccessFile:close	()V
    //   178: return
    //   179: astore 12
    //   181: aload 12
    //   183: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   186: return
    //   187: aload 13
    //   189: astore 12
    //   191: lload 9
    //   193: aload_0
    //   194: getfield 33	bjyu:jdField_a_of_type_Long	J
    //   197: lsub
    //   198: ldc2_w 334
    //   201: lcmp
    //   202: ifle +121 -> 323
    //   205: aload 13
    //   207: astore 12
    //   209: aload_0
    //   210: aload_0
    //   211: getfield 33	bjyu:jdField_a_of_type_Long	J
    //   214: ldc2_w 336
    //   217: ladd
    //   218: putfield 33	bjyu:jdField_a_of_type_Long	J
    //   221: aload 13
    //   223: astore 12
    //   225: aload_0
    //   226: getfield 33	bjyu:jdField_a_of_type_Long	J
    //   229: lload 5
    //   231: lsub
    //   232: lstore 7
    //   234: aload 13
    //   236: astore 12
    //   238: lload 7
    //   240: l2i
    //   241: newarray byte
    //   243: astore 15
    //   245: iconst_0
    //   246: istore_1
    //   247: aload 13
    //   249: astore 12
    //   251: aload 13
    //   253: lload 5
    //   255: invokevirtual 341	java/io/RandomAccessFile:seek	(J)V
    //   258: aload 13
    //   260: astore 12
    //   262: sipush 4096
    //   265: newarray byte
    //   267: astore 16
    //   269: aload 13
    //   271: astore 12
    //   273: aload 13
    //   275: aload 16
    //   277: invokevirtual 345	java/io/RandomAccessFile:read	([B)I
    //   280: istore 4
    //   282: iload_1
    //   283: istore_2
    //   284: iload 4
    //   286: ifle +192 -> 478
    //   289: iload_1
    //   290: iload 4
    //   292: iadd
    //   293: i2l
    //   294: lload 7
    //   296: lcmp
    //   297: ifgt +156 -> 453
    //   300: aload 13
    //   302: astore 12
    //   304: aload 16
    //   306: iconst_0
    //   307: aload 15
    //   309: iload_1
    //   310: iload 4
    //   312: invokestatic 351	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   315: iload_1
    //   316: iload 4
    //   318: iadd
    //   319: istore_1
    //   320: goto -51 -> 269
    //   323: aload 13
    //   325: astore 12
    //   327: aload_0
    //   328: lload 9
    //   330: putfield 33	bjyu:jdField_a_of_type_Long	J
    //   333: goto -112 -> 221
    //   336: astore 14
    //   338: aload 13
    //   340: astore 12
    //   342: aload 14
    //   344: astore 13
    //   346: ldc 122
    //   348: iconst_2
    //   349: new 138	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   356: ldc_w 353
    //   359: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload 13
    //   364: invokevirtual 354	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   367: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: aload 13
    //   375: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   378: aload_0
    //   379: getfield 156	bjyu:jdField_a_of_type_Bjyt	Lbjyt;
    //   382: ifnull +14 -> 396
    //   385: aload_0
    //   386: getfield 156	bjyu:jdField_a_of_type_Bjyt	Lbjyt;
    //   389: bipush 6
    //   391: invokeinterface 161 2 0
    //   396: ldc 130
    //   398: ldc 132
    //   400: ldc_w 359
    //   403: ldc 136
    //   405: new 138	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   412: iload_3
    //   413: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   416: ldc 136
    //   418: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: ldc 136
    //   426: invokestatic 154	bcli:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   429: aload_0
    //   430: lconst_0
    //   431: putfield 33	bjyu:jdField_a_of_type_Long	J
    //   434: aload 12
    //   436: ifnull -258 -> 178
    //   439: aload 12
    //   441: invokevirtual 330	java/io/RandomAccessFile:close	()V
    //   444: return
    //   445: astore 12
    //   447: aload 12
    //   449: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   452: return
    //   453: lload 7
    //   455: iload_1
    //   456: i2l
    //   457: lsub
    //   458: l2i
    //   459: istore_2
    //   460: aload 13
    //   462: astore 12
    //   464: aload 16
    //   466: iconst_0
    //   467: aload 15
    //   469: iload_1
    //   470: iload_2
    //   471: invokestatic 351	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   474: lload 7
    //   476: l2i
    //   477: istore_2
    //   478: aload 13
    //   480: astore 12
    //   482: ldc_w 361
    //   485: invokestatic 367	okhttp3/MediaType:parse	(Ljava/lang/String;)Lokhttp3/MediaType;
    //   488: aload 15
    //   490: iconst_0
    //   491: iload_2
    //   492: invokestatic 373	okhttp3/RequestBody:create	(Lokhttp3/MediaType;[BII)Lokhttp3/RequestBody;
    //   495: astore 15
    //   497: aload 13
    //   499: astore 12
    //   501: new 375	okhttp3/Request$Builder
    //   504: dup
    //   505: invokespecial 376	okhttp3/Request$Builder:<init>	()V
    //   508: new 138	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   515: aload_0
    //   516: getfield 258	bjyu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   519: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: ldc_w 378
    //   525: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: lload 5
    //   530: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   533: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokevirtual 382	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   539: ldc_w 384
    //   542: aload_0
    //   543: getfield 311	bjyu:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   546: invokevirtual 388	okhttp3/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   549: ldc_w 390
    //   552: ldc_w 392
    //   555: invokevirtual 388	okhttp3/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   558: ldc_w 394
    //   561: ldc_w 361
    //   564: invokevirtual 388	okhttp3/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   567: ldc_w 396
    //   570: aload_0
    //   571: lload 5
    //   573: l2i
    //   574: aload 14
    //   576: invokespecial 398	bjyu:a	(ILorg/json/JSONArray;)Ljava/lang/String;
    //   579: invokevirtual 388	okhttp3/Request$Builder:addHeader	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   582: aload 15
    //   584: invokevirtual 401	okhttp3/Request$Builder:post	(Lokhttp3/RequestBody;)Lokhttp3/Request$Builder;
    //   587: invokevirtual 404	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   590: astore 15
    //   592: aload 13
    //   594: astore 12
    //   596: aload_0
    //   597: getfield 276	bjyu:jdField_a_of_type_Okhttp3OkHttpClient	Lokhttp3/OkHttpClient;
    //   600: aload 15
    //   602: invokevirtual 408	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   605: invokeinterface 414 1 0
    //   610: astore 15
    //   612: aload 13
    //   614: astore 12
    //   616: aload 15
    //   618: invokevirtual 419	okhttp3/Response:isSuccessful	()Z
    //   621: ifeq +134 -> 755
    //   624: aload 13
    //   626: astore 12
    //   628: aload_0
    //   629: getfield 156	bjyu:jdField_a_of_type_Bjyt	Lbjyt;
    //   632: ifnull +97 -> 729
    //   635: aload 13
    //   637: astore 12
    //   639: aload_0
    //   640: getfield 156	bjyu:jdField_a_of_type_Bjyt	Lbjyt;
    //   643: iload_2
    //   644: i2l
    //   645: lload 5
    //   647: ladd
    //   648: ldc2_w 420
    //   651: lmul
    //   652: lload 9
    //   654: ldiv
    //   655: l2i
    //   656: invokeinterface 423 2 0
    //   661: aload 13
    //   663: astore 12
    //   665: aload_0
    //   666: getfield 33	bjyu:jdField_a_of_type_Long	J
    //   669: lload 9
    //   671: lcmp
    //   672: iflt +57 -> 729
    //   675: aload 13
    //   677: astore 12
    //   679: ldc 130
    //   681: ldc 132
    //   683: ldc 177
    //   685: ldc_w 425
    //   688: new 138	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   695: iload_3
    //   696: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   699: ldc 136
    //   701: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: ldc 136
    //   709: invokestatic 154	bcli:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   712: aload 13
    //   714: astore 12
    //   716: aload_0
    //   717: getfield 156	bjyu:jdField_a_of_type_Bjyt	Lbjyt;
    //   720: aload_0
    //   721: getfield 258	bjyu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   724: invokeinterface 215 2 0
    //   729: aload 13
    //   731: astore 12
    //   733: aload_0
    //   734: iconst_3
    //   735: putfield 319	bjyu:jdField_a_of_type_Int	I
    //   738: aload 13
    //   740: astore 12
    //   742: aload_0
    //   743: getfield 33	bjyu:jdField_a_of_type_Long	J
    //   746: lstore 7
    //   748: lload 7
    //   750: lstore 5
    //   752: goto +606 -> 1358
    //   755: aload 13
    //   757: astore 12
    //   759: aload_0
    //   760: getfield 319	bjyu:jdField_a_of_type_Int	I
    //   763: iconst_1
    //   764: isub
    //   765: istore_1
    //   766: aload 13
    //   768: astore 12
    //   770: aload_0
    //   771: iload_1
    //   772: putfield 319	bjyu:jdField_a_of_type_Int	I
    //   775: iload_1
    //   776: ifgt +98 -> 874
    //   779: aload 13
    //   781: astore 12
    //   783: ldc 130
    //   785: ldc 132
    //   787: ldc_w 427
    //   790: ldc 136
    //   792: new 138	java/lang/StringBuilder
    //   795: dup
    //   796: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   799: iload_3
    //   800: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   803: ldc 136
    //   805: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: ldc 136
    //   813: invokestatic 154	bcli:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   816: aload 13
    //   818: astore 12
    //   820: aload_0
    //   821: getfield 156	bjyu:jdField_a_of_type_Bjyt	Lbjyt;
    //   824: ifnull +534 -> 1358
    //   827: aload 13
    //   829: astore 12
    //   831: aload_0
    //   832: getfield 156	bjyu:jdField_a_of_type_Bjyt	Lbjyt;
    //   835: aload 15
    //   837: invokevirtual 430	okhttp3/Response:code	()I
    //   840: invokeinterface 161 2 0
    //   845: aload 13
    //   847: astore 12
    //   849: aload_0
    //   850: lload 5
    //   852: putfield 33	bjyu:jdField_a_of_type_Long	J
    //   855: aload 13
    //   857: ifnull -679 -> 178
    //   860: aload 13
    //   862: invokevirtual 330	java/io/RandomAccessFile:close	()V
    //   865: return
    //   866: astore 12
    //   868: aload 12
    //   870: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   873: return
    //   874: aload 13
    //   876: astore 12
    //   878: aload_0
    //   879: lload 5
    //   881: putfield 33	bjyu:jdField_a_of_type_Long	J
    //   884: goto -745 -> 139
    //   887: astore 15
    //   889: aload 13
    //   891: astore 12
    //   893: ldc 122
    //   895: iconst_2
    //   896: new 138	java/lang/StringBuilder
    //   899: dup
    //   900: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   903: ldc_w 353
    //   906: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: aload 15
    //   911: invokevirtual 431	java/io/IOException:getMessage	()Ljava/lang/String;
    //   914: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   920: aload 15
    //   922: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   925: aload 13
    //   927: astore 12
    //   929: aload_0
    //   930: getfield 319	bjyu:jdField_a_of_type_Int	I
    //   933: iconst_1
    //   934: isub
    //   935: istore_1
    //   936: aload 13
    //   938: astore 12
    //   940: aload_0
    //   941: iload_1
    //   942: putfield 319	bjyu:jdField_a_of_type_Int	I
    //   945: iload_1
    //   946: ifgt +208 -> 1154
    //   949: aload 13
    //   951: astore 12
    //   953: ldc 130
    //   955: ldc 132
    //   957: ldc_w 433
    //   960: ldc 136
    //   962: new 138	java/lang/StringBuilder
    //   965: dup
    //   966: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   969: iload_3
    //   970: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   973: ldc 136
    //   975: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   981: ldc 136
    //   983: invokestatic 154	bcli:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   986: aload 13
    //   988: astore 12
    //   990: aload_0
    //   991: getfield 156	bjyu:jdField_a_of_type_Bjyt	Lbjyt;
    //   994: ifnull +364 -> 1358
    //   997: aload 13
    //   999: astore 12
    //   1001: aload_0
    //   1002: getfield 156	bjyu:jdField_a_of_type_Bjyt	Lbjyt;
    //   1005: bipush 6
    //   1007: invokeinterface 161 2 0
    //   1012: aload 13
    //   1014: astore 12
    //   1016: aload_0
    //   1017: lload 5
    //   1019: putfield 33	bjyu:jdField_a_of_type_Long	J
    //   1022: goto -167 -> 855
    //   1025: astore 14
    //   1027: aload 13
    //   1029: astore 12
    //   1031: ldc 122
    //   1033: iconst_2
    //   1034: new 138	java/lang/StringBuilder
    //   1037: dup
    //   1038: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   1041: ldc_w 353
    //   1044: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: aload 14
    //   1049: invokevirtual 431	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1052: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1058: aload 14
    //   1060: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1063: aload 13
    //   1065: astore 12
    //   1067: aload_0
    //   1068: getfield 156	bjyu:jdField_a_of_type_Bjyt	Lbjyt;
    //   1071: ifnull +18 -> 1089
    //   1074: aload 13
    //   1076: astore 12
    //   1078: aload_0
    //   1079: getfield 156	bjyu:jdField_a_of_type_Bjyt	Lbjyt;
    //   1082: bipush 6
    //   1084: invokeinterface 161 2 0
    //   1089: aload 13
    //   1091: astore 12
    //   1093: ldc 130
    //   1095: ldc 132
    //   1097: ldc_w 435
    //   1100: ldc 136
    //   1102: new 138	java/lang/StringBuilder
    //   1105: dup
    //   1106: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   1109: iload_3
    //   1110: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1113: ldc 136
    //   1115: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1121: ldc 136
    //   1123: invokestatic 154	bcli:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1126: aload 13
    //   1128: astore 12
    //   1130: aload_0
    //   1131: lconst_0
    //   1132: putfield 33	bjyu:jdField_a_of_type_Long	J
    //   1135: aload 13
    //   1137: ifnull -959 -> 178
    //   1140: aload 13
    //   1142: invokevirtual 330	java/io/RandomAccessFile:close	()V
    //   1145: return
    //   1146: astore 12
    //   1148: aload 12
    //   1150: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   1153: return
    //   1154: aload 13
    //   1156: astore 12
    //   1158: aload_0
    //   1159: lload 5
    //   1161: putfield 33	bjyu:jdField_a_of_type_Long	J
    //   1164: goto -1025 -> 139
    //   1167: astore 14
    //   1169: aload 13
    //   1171: astore 12
    //   1173: ldc 122
    //   1175: iconst_2
    //   1176: new 138	java/lang/StringBuilder
    //   1179: dup
    //   1180: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   1183: ldc_w 353
    //   1186: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: aload 14
    //   1191: invokevirtual 436	java/security/InvalidParameterException:getMessage	()Ljava/lang/String;
    //   1194: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1197: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1200: aload 14
    //   1202: invokestatic 357	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1205: aload 13
    //   1207: astore 12
    //   1209: aload_0
    //   1210: getfield 156	bjyu:jdField_a_of_type_Bjyt	Lbjyt;
    //   1213: ifnull +18 -> 1231
    //   1216: aload 13
    //   1218: astore 12
    //   1220: aload_0
    //   1221: getfield 156	bjyu:jdField_a_of_type_Bjyt	Lbjyt;
    //   1224: bipush 6
    //   1226: invokeinterface 161 2 0
    //   1231: aload 13
    //   1233: astore 12
    //   1235: ldc 130
    //   1237: ldc 132
    //   1239: ldc_w 438
    //   1242: ldc 136
    //   1244: new 138	java/lang/StringBuilder
    //   1247: dup
    //   1248: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   1251: iload_3
    //   1252: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1255: ldc 136
    //   1257: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1260: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1263: ldc 136
    //   1265: invokestatic 154	bcli:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1268: aload 13
    //   1270: astore 12
    //   1272: aload_0
    //   1273: lconst_0
    //   1274: putfield 33	bjyu:jdField_a_of_type_Long	J
    //   1277: aload 13
    //   1279: ifnull -1101 -> 178
    //   1282: aload 13
    //   1284: invokevirtual 330	java/io/RandomAccessFile:close	()V
    //   1287: return
    //   1288: astore 12
    //   1290: aload 12
    //   1292: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   1295: return
    //   1296: astore 13
    //   1298: aconst_null
    //   1299: astore 12
    //   1301: aload 12
    //   1303: ifnull +8 -> 1311
    //   1306: aload 12
    //   1308: invokevirtual 330	java/io/RandomAccessFile:close	()V
    //   1311: aload 13
    //   1313: athrow
    //   1314: astore 12
    //   1316: aload 12
    //   1318: invokevirtual 333	java/io/IOException:printStackTrace	()V
    //   1321: goto -10 -> 1311
    //   1324: astore 13
    //   1326: goto -25 -> 1301
    //   1329: astore 13
    //   1331: goto -30 -> 1301
    //   1334: astore 14
    //   1336: aconst_null
    //   1337: astore 13
    //   1339: goto -170 -> 1169
    //   1342: astore 14
    //   1344: aconst_null
    //   1345: astore 13
    //   1347: goto -320 -> 1027
    //   1350: astore 13
    //   1352: aconst_null
    //   1353: astore 12
    //   1355: goto -1009 -> 346
    //   1358: goto -1219 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1361	0	this	bjyu
    //   246	700	1	i	int
    //   283	361	2	j	int
    //   57	1195	3	k	int
    //   280	39	4	m	int
    //   137	1023	5	l1	long
    //   232	517	7	l2	long
    //   127	543	9	l3	long
    //   161	3	11	bool	boolean
    //   120	36	12	localObject1	Object
    //   179	3	12	localIOException1	java.io.IOException
    //   189	251	12	localObject2	Object
    //   445	3	12	localIOException2	java.io.IOException
    //   462	386	12	localObject3	Object
    //   866	3	12	localIOException3	java.io.IOException
    //   876	253	12	localObject4	Object
    //   1146	3	12	localIOException4	java.io.IOException
    //   1156	115	12	localObject5	Object
    //   1288	3	12	localIOException5	java.io.IOException
    //   1299	8	12	localObject6	Object
    //   1314	3	12	localIOException6	java.io.IOException
    //   1353	1	12	localObject7	Object
    //   116	1167	13	localObject8	Object
    //   1296	16	13	localObject9	Object
    //   1324	1	13	localObject10	Object
    //   1329	1	13	localObject11	Object
    //   1337	9	13	localObject12	Object
    //   1350	1	13	localFileNotFoundException1	java.io.FileNotFoundException
    //   95	1	14	localJSONArray	JSONArray
    //   336	239	14	localFileNotFoundException2	java.io.FileNotFoundException
    //   1025	34	14	localIOException7	java.io.IOException
    //   1167	34	14	localInvalidParameterException1	InvalidParameterException
    //   1334	1	14	localInvalidParameterException2	InvalidParameterException
    //   1342	1	14	localIOException8	java.io.IOException
    //   243	593	15	localObject13	Object
    //   887	34	15	localIOException9	java.io.IOException
    //   267	198	16	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   173	178	179	java/io/IOException
    //   122	129	336	java/io/FileNotFoundException
    //   133	139	336	java/io/FileNotFoundException
    //   143	153	336	java/io/FileNotFoundException
    //   157	163	336	java/io/FileNotFoundException
    //   191	205	336	java/io/FileNotFoundException
    //   209	221	336	java/io/FileNotFoundException
    //   225	234	336	java/io/FileNotFoundException
    //   238	245	336	java/io/FileNotFoundException
    //   251	258	336	java/io/FileNotFoundException
    //   262	269	336	java/io/FileNotFoundException
    //   273	282	336	java/io/FileNotFoundException
    //   304	315	336	java/io/FileNotFoundException
    //   327	333	336	java/io/FileNotFoundException
    //   464	474	336	java/io/FileNotFoundException
    //   482	497	336	java/io/FileNotFoundException
    //   501	592	336	java/io/FileNotFoundException
    //   596	612	336	java/io/FileNotFoundException
    //   616	624	336	java/io/FileNotFoundException
    //   628	635	336	java/io/FileNotFoundException
    //   639	661	336	java/io/FileNotFoundException
    //   665	675	336	java/io/FileNotFoundException
    //   679	712	336	java/io/FileNotFoundException
    //   716	729	336	java/io/FileNotFoundException
    //   733	738	336	java/io/FileNotFoundException
    //   742	748	336	java/io/FileNotFoundException
    //   759	766	336	java/io/FileNotFoundException
    //   770	775	336	java/io/FileNotFoundException
    //   783	816	336	java/io/FileNotFoundException
    //   820	827	336	java/io/FileNotFoundException
    //   831	845	336	java/io/FileNotFoundException
    //   849	855	336	java/io/FileNotFoundException
    //   878	884	336	java/io/FileNotFoundException
    //   893	925	336	java/io/FileNotFoundException
    //   929	936	336	java/io/FileNotFoundException
    //   940	945	336	java/io/FileNotFoundException
    //   953	986	336	java/io/FileNotFoundException
    //   990	997	336	java/io/FileNotFoundException
    //   1001	1012	336	java/io/FileNotFoundException
    //   1016	1022	336	java/io/FileNotFoundException
    //   1158	1164	336	java/io/FileNotFoundException
    //   439	444	445	java/io/IOException
    //   860	865	866	java/io/IOException
    //   596	612	887	java/io/IOException
    //   616	624	887	java/io/IOException
    //   628	635	887	java/io/IOException
    //   639	661	887	java/io/IOException
    //   665	675	887	java/io/IOException
    //   679	712	887	java/io/IOException
    //   716	729	887	java/io/IOException
    //   733	738	887	java/io/IOException
    //   742	748	887	java/io/IOException
    //   759	766	887	java/io/IOException
    //   770	775	887	java/io/IOException
    //   783	816	887	java/io/IOException
    //   820	827	887	java/io/IOException
    //   831	845	887	java/io/IOException
    //   849	855	887	java/io/IOException
    //   878	884	887	java/io/IOException
    //   122	129	1025	java/io/IOException
    //   133	139	1025	java/io/IOException
    //   143	153	1025	java/io/IOException
    //   157	163	1025	java/io/IOException
    //   191	205	1025	java/io/IOException
    //   209	221	1025	java/io/IOException
    //   225	234	1025	java/io/IOException
    //   238	245	1025	java/io/IOException
    //   251	258	1025	java/io/IOException
    //   262	269	1025	java/io/IOException
    //   273	282	1025	java/io/IOException
    //   304	315	1025	java/io/IOException
    //   327	333	1025	java/io/IOException
    //   464	474	1025	java/io/IOException
    //   482	497	1025	java/io/IOException
    //   501	592	1025	java/io/IOException
    //   893	925	1025	java/io/IOException
    //   929	936	1025	java/io/IOException
    //   940	945	1025	java/io/IOException
    //   953	986	1025	java/io/IOException
    //   990	997	1025	java/io/IOException
    //   1001	1012	1025	java/io/IOException
    //   1016	1022	1025	java/io/IOException
    //   1158	1164	1025	java/io/IOException
    //   1140	1145	1146	java/io/IOException
    //   122	129	1167	java/security/InvalidParameterException
    //   133	139	1167	java/security/InvalidParameterException
    //   143	153	1167	java/security/InvalidParameterException
    //   157	163	1167	java/security/InvalidParameterException
    //   191	205	1167	java/security/InvalidParameterException
    //   209	221	1167	java/security/InvalidParameterException
    //   225	234	1167	java/security/InvalidParameterException
    //   238	245	1167	java/security/InvalidParameterException
    //   251	258	1167	java/security/InvalidParameterException
    //   262	269	1167	java/security/InvalidParameterException
    //   273	282	1167	java/security/InvalidParameterException
    //   304	315	1167	java/security/InvalidParameterException
    //   327	333	1167	java/security/InvalidParameterException
    //   464	474	1167	java/security/InvalidParameterException
    //   482	497	1167	java/security/InvalidParameterException
    //   501	592	1167	java/security/InvalidParameterException
    //   596	612	1167	java/security/InvalidParameterException
    //   616	624	1167	java/security/InvalidParameterException
    //   628	635	1167	java/security/InvalidParameterException
    //   639	661	1167	java/security/InvalidParameterException
    //   665	675	1167	java/security/InvalidParameterException
    //   679	712	1167	java/security/InvalidParameterException
    //   716	729	1167	java/security/InvalidParameterException
    //   733	738	1167	java/security/InvalidParameterException
    //   742	748	1167	java/security/InvalidParameterException
    //   759	766	1167	java/security/InvalidParameterException
    //   770	775	1167	java/security/InvalidParameterException
    //   783	816	1167	java/security/InvalidParameterException
    //   820	827	1167	java/security/InvalidParameterException
    //   831	845	1167	java/security/InvalidParameterException
    //   849	855	1167	java/security/InvalidParameterException
    //   878	884	1167	java/security/InvalidParameterException
    //   893	925	1167	java/security/InvalidParameterException
    //   929	936	1167	java/security/InvalidParameterException
    //   940	945	1167	java/security/InvalidParameterException
    //   953	986	1167	java/security/InvalidParameterException
    //   990	997	1167	java/security/InvalidParameterException
    //   1001	1012	1167	java/security/InvalidParameterException
    //   1016	1022	1167	java/security/InvalidParameterException
    //   1158	1164	1167	java/security/InvalidParameterException
    //   1282	1287	1288	java/io/IOException
    //   102	118	1296	finally
    //   1306	1311	1314	java/io/IOException
    //   122	129	1324	finally
    //   133	139	1324	finally
    //   143	153	1324	finally
    //   157	163	1324	finally
    //   191	205	1324	finally
    //   209	221	1324	finally
    //   225	234	1324	finally
    //   238	245	1324	finally
    //   251	258	1324	finally
    //   262	269	1324	finally
    //   273	282	1324	finally
    //   304	315	1324	finally
    //   327	333	1324	finally
    //   464	474	1324	finally
    //   482	497	1324	finally
    //   501	592	1324	finally
    //   596	612	1324	finally
    //   616	624	1324	finally
    //   628	635	1324	finally
    //   639	661	1324	finally
    //   665	675	1324	finally
    //   679	712	1324	finally
    //   716	729	1324	finally
    //   733	738	1324	finally
    //   742	748	1324	finally
    //   759	766	1324	finally
    //   770	775	1324	finally
    //   783	816	1324	finally
    //   820	827	1324	finally
    //   831	845	1324	finally
    //   849	855	1324	finally
    //   878	884	1324	finally
    //   893	925	1324	finally
    //   929	936	1324	finally
    //   940	945	1324	finally
    //   953	986	1324	finally
    //   990	997	1324	finally
    //   1001	1012	1324	finally
    //   1016	1022	1324	finally
    //   1031	1063	1324	finally
    //   1067	1074	1324	finally
    //   1078	1089	1324	finally
    //   1093	1126	1324	finally
    //   1130	1135	1324	finally
    //   1158	1164	1324	finally
    //   1173	1205	1324	finally
    //   1209	1216	1324	finally
    //   1220	1231	1324	finally
    //   1235	1268	1324	finally
    //   1272	1277	1324	finally
    //   346	396	1329	finally
    //   396	434	1329	finally
    //   102	118	1334	java/security/InvalidParameterException
    //   102	118	1342	java/io/IOException
    //   102	118	1350	java/io/FileNotFoundException
  }
  
  public void a()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new TroopHomeworkHelper.UploadFileTask.1(this), 8, null, true);
      return;
    }
    File localFile = new File(this.c);
    if (((!localFile.exists()) || (localFile.length() == 0L)) && (this.jdField_a_of_type_Bjyt != null))
    {
      this.jdField_a_of_type_Bjyt.b(-1);
      int i = bdee.b(BaseApplicationImpl.getContext());
      bcli.a("grp_hw", "upload_video", "-13", "", i + "", "");
      return;
    }
    if (localFile.length() > 4096L)
    {
      e();
      return;
    }
    d();
  }
  
  public void a(bjyt parambjyt)
  {
    this.jdField_a_of_type_Bjyt = parambjyt;
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
      if (((!localFile.exists()) || (localFile.length() == 0L)) && (this.jdField_a_of_type_Bjyt != null))
      {
        this.jdField_a_of_type_Bjyt.b(-1);
        int i = bdee.b(BaseApplicationImpl.getContext());
        bcli.a("grp_hw", "upload_video", "-13", "", i + "", "");
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
    } while (this.jdField_a_of_type_Bjyt == null);
    this.jdField_a_of_type_Bjyt.a(this.jdField_a_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjyu
 * JD-Core Version:    0.7.0.1
 */