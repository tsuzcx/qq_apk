import android.text.TextUtils;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class azal
  extends azaf
{
  public String e;
  public String f;
  public String g;
  
  public azal(String paramString)
  {
    this.f = paramString;
    b();
    this.jdField_d_of_type_JavaLangString = String.valueOf(hashCode());
  }
  
  public azal(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
    this.jdField_d_of_type_JavaLangString = String.valueOf(hashCode());
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: invokestatic 46	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: aload_0
    //   5: getfield 15	azal:f	Ljava/lang/String;
    //   8: invokestatic 51	apdh:b	(Ljava/lang/String;)Z
    //   11: ifeq +386 -> 397
    //   14: aconst_null
    //   15: astore 4
    //   17: new 53	android/media/MediaMetadataRetriever
    //   20: dup
    //   21: invokespecial 54	android/media/MediaMetadataRetriever:<init>	()V
    //   24: astore 5
    //   26: aload 5
    //   28: astore 4
    //   30: aload 5
    //   32: aload_0
    //   33: getfield 15	azal:f	Ljava/lang/String;
    //   36: invokevirtual 57	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   39: aload 5
    //   41: astore 4
    //   43: aload_0
    //   44: aload 5
    //   46: bipush 18
    //   48: invokevirtual 60	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   51: invokestatic 65	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   54: invokevirtual 68	java/lang/Integer:intValue	()I
    //   57: putfield 71	azal:jdField_a_of_type_Int	I
    //   60: aload 5
    //   62: astore 4
    //   64: aload_0
    //   65: aload 5
    //   67: bipush 19
    //   69: invokevirtual 60	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   72: invokestatic 65	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   75: invokevirtual 68	java/lang/Integer:intValue	()I
    //   78: putfield 73	azal:jdField_b_of_type_Int	I
    //   81: aload 5
    //   83: astore 4
    //   85: getstatic 78	android/os/Build$VERSION:SDK_INT	I
    //   88: bipush 17
    //   90: if_icmplt +104 -> 194
    //   93: aload 5
    //   95: astore 4
    //   97: aload 5
    //   99: bipush 24
    //   101: invokevirtual 60	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   104: invokestatic 65	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   107: invokevirtual 68	java/lang/Integer:intValue	()I
    //   110: istore_1
    //   111: aload 5
    //   113: astore 4
    //   115: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +347 -> 465
    //   121: aload 5
    //   123: astore 4
    //   125: ldc 86
    //   127: iconst_2
    //   128: iconst_4
    //   129: anewarray 20	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: ldc 88
    //   136: aastore
    //   137: dup
    //   138: iconst_1
    //   139: getstatic 78	android/os/Build$VERSION:SDK_INT	I
    //   142: invokestatic 91	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   145: aastore
    //   146: dup
    //   147: iconst_2
    //   148: ldc 93
    //   150: aastore
    //   151: dup
    //   152: iconst_3
    //   153: iload_1
    //   154: invokestatic 91	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   157: aastore
    //   158: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   161: goto +304 -> 465
    //   164: aload 5
    //   166: astore 4
    //   168: aload_0
    //   169: getfield 71	azal:jdField_a_of_type_Int	I
    //   172: istore_1
    //   173: aload 5
    //   175: astore 4
    //   177: aload_0
    //   178: aload_0
    //   179: getfield 73	azal:jdField_b_of_type_Int	I
    //   182: putfield 71	azal:jdField_a_of_type_Int	I
    //   185: aload 5
    //   187: astore 4
    //   189: aload_0
    //   190: iload_1
    //   191: putfield 73	azal:jdField_b_of_type_Int	I
    //   194: aload 5
    //   196: astore 4
    //   198: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +78 -> 279
    //   204: aload 5
    //   206: astore 4
    //   208: ldc 86
    //   210: iconst_2
    //   211: bipush 8
    //   213: anewarray 20	java/lang/Object
    //   216: dup
    //   217: iconst_0
    //   218: ldc 98
    //   220: aastore
    //   221: dup
    //   222: iconst_1
    //   223: aload_0
    //   224: getfield 15	azal:f	Ljava/lang/String;
    //   227: aastore
    //   228: dup
    //   229: iconst_2
    //   230: ldc 100
    //   232: aastore
    //   233: dup
    //   234: iconst_3
    //   235: aload_0
    //   236: getfield 71	azal:jdField_a_of_type_Int	I
    //   239: invokestatic 91	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   242: aastore
    //   243: dup
    //   244: iconst_4
    //   245: ldc 102
    //   247: aastore
    //   248: dup
    //   249: iconst_5
    //   250: aload_0
    //   251: getfield 73	azal:jdField_b_of_type_Int	I
    //   254: invokestatic 91	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: dup
    //   259: bipush 6
    //   261: ldc 104
    //   263: aastore
    //   264: dup
    //   265: bipush 7
    //   267: invokestatic 46	java/lang/System:currentTimeMillis	()J
    //   270: lload_2
    //   271: lsub
    //   272: invokestatic 109	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   275: aastore
    //   276: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   279: aload 5
    //   281: astore 4
    //   283: aload_0
    //   284: getfield 71	azal:jdField_a_of_type_Int	I
    //   287: ifle +14 -> 301
    //   290: aload 5
    //   292: astore 4
    //   294: aload_0
    //   295: getfield 73	azal:jdField_b_of_type_Int	I
    //   298: ifgt +89 -> 387
    //   301: aload 5
    //   303: astore 4
    //   305: aload_0
    //   306: aload_0
    //   307: getfield 111	azal:jdField_d_of_type_Int	I
    //   310: putfield 71	azal:jdField_a_of_type_Int	I
    //   313: aload 5
    //   315: astore 4
    //   317: aload_0
    //   318: aload_0
    //   319: getfield 111	azal:jdField_d_of_type_Int	I
    //   322: bipush 9
    //   324: imul
    //   325: i2f
    //   326: ldc 112
    //   328: fdiv
    //   329: f2i
    //   330: putfield 73	azal:jdField_b_of_type_Int	I
    //   333: aload 5
    //   335: astore 4
    //   337: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   340: ifeq +47 -> 387
    //   343: aload 5
    //   345: astore 4
    //   347: ldc 86
    //   349: iconst_2
    //   350: iconst_4
    //   351: anewarray 20	java/lang/Object
    //   354: dup
    //   355: iconst_0
    //   356: ldc 114
    //   358: aastore
    //   359: dup
    //   360: iconst_1
    //   361: aload_0
    //   362: getfield 71	azal:jdField_a_of_type_Int	I
    //   365: invokestatic 91	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   368: aastore
    //   369: dup
    //   370: iconst_2
    //   371: ldc 102
    //   373: aastore
    //   374: dup
    //   375: iconst_3
    //   376: aload_0
    //   377: getfield 73	azal:jdField_b_of_type_Int	I
    //   380: invokestatic 91	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   383: aastore
    //   384: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   387: aload 5
    //   389: ifnull +8 -> 397
    //   392: aload 5
    //   394: invokevirtual 117	android/media/MediaMetadataRetriever:release	()V
    //   397: return
    //   398: astore 4
    //   400: aconst_null
    //   401: astore 5
    //   403: aload 5
    //   405: astore 4
    //   407: ldc 86
    //   409: iconst_1
    //   410: iconst_2
    //   411: anewarray 20	java/lang/Object
    //   414: dup
    //   415: iconst_0
    //   416: ldc 119
    //   418: aastore
    //   419: dup
    //   420: iconst_1
    //   421: aload_0
    //   422: getfield 15	azal:f	Ljava/lang/String;
    //   425: aastore
    //   426: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   429: aload 5
    //   431: ifnull -34 -> 397
    //   434: aload 5
    //   436: invokevirtual 117	android/media/MediaMetadataRetriever:release	()V
    //   439: return
    //   440: astore 5
    //   442: aload 4
    //   444: ifnull +8 -> 452
    //   447: aload 4
    //   449: invokevirtual 117	android/media/MediaMetadataRetriever:release	()V
    //   452: aload 5
    //   454: athrow
    //   455: astore 5
    //   457: goto -15 -> 442
    //   460: astore 4
    //   462: goto -59 -> 403
    //   465: iload_1
    //   466: bipush 90
    //   468: if_icmpeq -304 -> 164
    //   471: iload_1
    //   472: sipush 270
    //   475: if_icmpne -281 -> 194
    //   478: goto -314 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	481	0	this	azal
    //   110	366	1	i	int
    //   3	268	2	l	long
    //   15	331	4	localObject1	Object
    //   398	1	4	localException1	java.lang.Exception
    //   405	43	4	localObject2	Object
    //   460	1	4	localException2	java.lang.Exception
    //   24	411	5	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   440	13	5	localObject3	Object
    //   455	1	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   17	26	398	java/lang/Exception
    //   17	26	440	finally
    //   30	39	455	finally
    //   43	60	455	finally
    //   64	81	455	finally
    //   85	93	455	finally
    //   97	111	455	finally
    //   115	121	455	finally
    //   125	161	455	finally
    //   168	173	455	finally
    //   177	185	455	finally
    //   189	194	455	finally
    //   198	204	455	finally
    //   208	279	455	finally
    //   283	290	455	finally
    //   294	301	455	finally
    //   305	313	455	finally
    //   317	333	455	finally
    //   337	343	455	finally
    //   347	387	455	finally
    //   407	429	455	finally
    //   30	39	460	java/lang/Exception
    //   43	60	460	java/lang/Exception
    //   64	81	460	java/lang/Exception
    //   85	93	460	java/lang/Exception
    //   97	111	460	java/lang/Exception
    //   115	121	460	java/lang/Exception
    //   125	161	460	java/lang/Exception
    //   168	173	460	java/lang/Exception
    //   177	185	460	java/lang/Exception
    //   189	194	460	java/lang/Exception
    //   198	204	460	java/lang/Exception
    //   208	279	460	java/lang/Exception
    //   283	290	460	java/lang/Exception
    //   294	301	460	java/lang/Exception
    //   305	313	460	java/lang/Exception
    //   317	333	460	java/lang/Exception
    //   337	343	460	java/lang/Exception
    //   347	387	460	java/lang/Exception
  }
  
  public Stream<azaf> a(XMediaEditor paramXMediaEditor)
  {
    Object localObject2 = Stream.of(this).map(new ThreadOffFunction("VideoInfo", 2));
    Object localObject1 = localObject2;
    if (!apdh.b(this.jdField_g_of_type_JavaLangString))
    {
      if (this.jdField_g_of_type_Int >= 0) {
        this.jdField_g_of_type_Int = -2147483646;
      }
      localObject1 = ((Stream)localObject2).map(new azam(paramXMediaEditor));
    }
    String str = paramXMediaEditor.a("troopuin");
    localObject2 = localObject1;
    if (TextUtils.isEmpty(this.e))
    {
      if (this.jdField_g_of_type_Int >= 0) {
        this.jdField_g_of_type_Int = -2147483647;
      }
      localObject2 = ((Stream)localObject1).map(new azah(1, paramXMediaEditor, str));
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      if (this.jdField_g_of_type_Int >= 0) {
        this.jdField_g_of_type_Int = -2147483648;
      }
    }
    for (localObject1 = ((Stream)localObject2).map(new azah(2, paramXMediaEditor, str));; localObject1 = localObject2)
    {
      localObject2 = paramXMediaEditor.findViewHolderForLayoutPosition(this.c);
      if ((localObject2 instanceof azbt))
      {
        localObject2 = (azbt)localObject2;
        if (this.jdField_d_of_type_JavaLangString.equals(((azbt)localObject2).a.getTag())) {
          ((azbq)((ayzw)paramXMediaEditor.getAdapter()).a.a(2)).a((azbg)localObject2, this, 0);
        }
      }
      return ((Stream)localObject1).map(new UIThreadOffFunction(null));
    }
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.f)) {
      return this.e;
    }
    return this.f;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", "video");
      localJSONObject.put("url", this.e);
      localJSONObject.put("width", this.jdField_a_of_type_Int);
      localJSONObject.put("height", this.jdField_b_of_type_Int);
      localJSONObject.put("poster", this.jdField_b_of_type_JavaLangString);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoInfo", 2, "VideoInfo getContent exception.");
    }
    return localJSONObject;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInfo", 2, new Object[] { "VideoInfo createFrom json: ", paramJSONObject });
    }
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    c(paramJSONObject.optString("poster"));
    this.jdField_a_of_type_Int = paramJSONObject.optInt("width");
    this.jdField_b_of_type_Int = paramJSONObject.optInt("height");
    this.e = paramJSONObject.optString("url");
    if (!TextUtils.isEmpty(this.e)) {
      this.e = this.e.replace("https://", "http://");
    }
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.e);
  }
  
  public int b()
  {
    return 2;
  }
  
  public Stream<azal> b(XMediaEditor paramXMediaEditor)
  {
    this.jdField_g_of_type_Int = 1;
    Object localObject;
    if (apdh.b(this.c)) {
      localObject = null;
    }
    Stream localStream;
    do
    {
      return localObject;
      localStream = Stream.of(this).map(new ThreadOffFunction("VideoInfo", 2));
      localObject = localStream;
    } while (apdh.b(this.c));
    this.jdField_g_of_type_Int = -2147483645;
    return localStream.map(new azan(paramXMediaEditor, this.jdField_d_of_type_Int)).map(new UIThreadOffFunction(null));
  }
  
  public boolean b()
  {
    return (TextUtils.isEmpty(this.e)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
  }
  
  public String c()
  {
    if (TextUtils.isEmpty(this.f)) {
      return this.e;
    }
    return this.f;
  }
  
  public void c(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaNetURL = new URL(paramString);
      this.jdField_b_of_type_JavaLangString = paramString;
      return;
    }
    catch (MalformedURLException paramString)
    {
      QLog.e("VideoInfo", 1, "Video setURLFromContentUrl exception.");
    }
  }
  
  public int e()
  {
    switch (this.jdField_g_of_type_Int)
    {
    default: 
      return this.jdField_g_of_type_Int;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azal
 * JD-Core Version:    0.7.0.1
 */