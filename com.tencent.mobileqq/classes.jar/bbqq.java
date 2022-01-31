import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class bbqq
{
  public static bbqs a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject = ajsd.bV + paramInt + File.separator + "config.json";
    paramQQAppInterface = VasQuickUpdateManager.getFileFromLocal(paramQQAppInterface, 1000L, "signature.item." + paramInt + ".json", (String)localObject, true, null);
    try
    {
      paramQQAppInterface = bbdx.a(paramQQAppInterface, -1);
      if (paramQQAppInterface == null)
      {
        QLog.e("SignatureTemplateConfig", 1, "read config fail result = null");
        return null;
      }
    }
    catch (OutOfMemoryError paramQQAppInterface)
    {
      QLog.e("SignatureTemplateConfig", 1, "read config fail", paramQQAppInterface);
      return null;
    }
    localObject = new bbqs(Integer.toString(paramInt));
    a(paramQQAppInterface, (bbqs)localObject);
    return localObject;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(ajsd.bV);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static void a(String paramString, bbqs parambbqs)
  {
    Object localObject;
    try
    {
      paramString = new JSONObject(paramString);
      localObject = paramString.optJSONArray("data");
      if ((localObject == null) || (((JSONArray)localObject).length() != 1)) {
        break label883;
      }
      localObject = ((JSONArray)localObject).getJSONObject(0);
      if (((JSONObject)localObject).optInt("platId") == 1)
      {
        parambbqs.a();
        return;
      }
      parambbqs.jdField_f_of_type_JavaLangString = ((JSONObject)localObject).optString("qqVer", "0.0.0");
      if (AppSetting.a(parambbqs.jdField_f_of_type_JavaLangString) < 0)
      {
        parambbqs.a();
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("SignatureTemplateConfig", 1, "getSignatureTemplateInfoFromFile error: " + paramString.getMessage());
      return;
    }
    parambbqs.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("name", ajya.a(2131714135));
    parambbqs.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("type", -1);
    parambbqs.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("feeType", 1);
    parambbqs.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("actUrl", null);
    parambbqs.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("newOrHot", 0);
    parambbqs.jdField_d_of_type_Int = ((JSONObject)localObject).optInt("platId");
    parambbqs.jdField_e_of_type_JavaLangString = ((JSONObject)localObject).optString("fontColor", "");
    parambbqs.jdField_g_of_type_Int = ((JSONObject)localObject).optInt("signType", 0);
    for (;;)
    {
      int j;
      int i;
      try
      {
        Color.parseColor(parambbqs.jdField_e_of_type_JavaLangString);
        parambbqs.n = ((JSONObject)localObject).optString("defText", "");
        parambbqs.o = ((JSONObject)localObject).optString("defTextColor", "");
      }
      catch (Exception localException2)
      {
        try
        {
          Color.parseColor(parambbqs.o);
          parambbqs.p = ((JSONObject)localObject).optString("timeAndLocation", "");
        }
        catch (Exception localException2)
        {
          try
          {
            Color.parseColor(parambbqs.p);
            parambbqs.jdField_e_of_type_Int = ((JSONObject)localObject).optInt("isLimited", 1);
            parambbqs.q = ((JSONObject)localObject).optString("startTime");
            parambbqs.r = ((JSONObject)localObject).optString("endTime");
            parambbqs.s = ((JSONObject)localObject).optString("dot9png");
            parambbqs.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("cover");
            parambbqs.jdField_g_of_type_JavaLangString = ((JSONObject)localObject).optString("aio_2");
            parambbqs.h = ((JSONObject)localObject).optString("aio_3");
            parambbqs.i = ((JSONObject)localObject).optString("aio_4");
            parambbqs.j = ((JSONObject)localObject).optString("icon");
            parambbqs.k = ((JSONObject)localObject).optString("view");
            parambbqs.l = ((JSONObject)localObject).optString("action_off");
            parambbqs.m = ((JSONObject)localObject).optString("action_on");
            parambbqs.t = ((JSONObject)localObject).optString("backgroundColor");
            parambbqs.u = ((JSONObject)localObject).optString("shadowColor");
            parambbqs.jdField_f_of_type_Int = ((JSONObject)localObject).optInt("materialVersion");
            if (paramString.has("dynamicItem"))
            {
              localObject = paramString.getJSONArray("dynamicItem");
              j = 0;
              if (j < ((JSONArray)localObject).length())
              {
                JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
                i = localJSONObject.optInt("aio_rows", -1);
                if ((i != 0) && ((i <= 1) || (i >= 6))) {
                  break label884;
                }
                bbqt[] arrayOfbbqt = parambbqs.jdField_a_of_type_ArrayOfBbqt;
                if (i != 0) {
                  break label891;
                }
                k = i;
                arrayOfbbqt[k].jdField_a_of_type_Int = i;
                arrayOfbbqt = parambbqs.jdField_a_of_type_ArrayOfBbqt;
                if (i != 0) {
                  break label899;
                }
                k = i;
                arrayOfbbqt[k].jdField_a_of_type_JavaLangString = localJSONObject.optString("pngZip");
                arrayOfbbqt = parambbqs.jdField_a_of_type_ArrayOfBbqt;
                if (i != 0) {
                  break label907;
                }
                k = i;
                arrayOfbbqt[k].jdField_a_of_type_Float = ((float)localJSONObject.optDouble("posX", 0.0D));
                arrayOfbbqt = parambbqs.jdField_a_of_type_ArrayOfBbqt;
                if (i != 0) {
                  break label915;
                }
                k = i;
                arrayOfbbqt[k].jdField_b_of_type_Float = ((float)localJSONObject.optDouble("posY", 0.0D));
                arrayOfbbqt = parambbqs.jdField_a_of_type_ArrayOfBbqt;
                if (i != 0) {
                  break label923;
                }
                k = i;
                arrayOfbbqt[k].jdField_c_of_type_Float = ((float)localJSONObject.optDouble("width", 0.0D));
                arrayOfbbqt = parambbqs.jdField_a_of_type_ArrayOfBbqt;
                if (i != 0) {
                  break label931;
                }
                k = i;
                arrayOfbbqt[k].d = ((float)localJSONObject.optDouble("height", 0.0D));
                arrayOfbbqt = parambbqs.jdField_a_of_type_ArrayOfBbqt;
                if (i != 0) {
                  break label939;
                }
                k = i;
                arrayOfbbqt[k].jdField_b_of_type_Int = localJSONObject.optInt("repeatTimes", 0);
                arrayOfbbqt = parambbqs.jdField_a_of_type_ArrayOfBbqt;
                if (i != 0) {
                  break label947;
                }
                arrayOfbbqt[i].jdField_c_of_type_Int = localJSONObject.optInt("interval", 0);
                break label884;
                localException1 = localException1;
                parambbqs.jdField_e_of_type_JavaLangString = "";
                continue;
                localException2 = localException2;
                parambbqs.o = "";
              }
            }
          }
          catch (Exception localException3)
          {
            parambbqs.p = "";
            continue;
            paramString = paramString.optJSONArray("imgItem");
            if ((paramString != null) && (paramString.length() > 0))
            {
              paramString = paramString.getJSONObject(0);
              parambbqs.getClass();
              localObject = new bbqu(parambbqs);
              ((bbqu)localObject).jdField_b_of_type_JavaLangString = paramString.optString("content");
              ((bbqu)localObject).jdField_a_of_type_JavaLangString = paramString.optString("img");
              ((bbqu)localObject).jdField_a_of_type_Int = paramString.optInt("imgWidth");
              ((bbqu)localObject).jdField_b_of_type_Int = paramString.optInt("imgHeight");
              ((bbqu)localObject).jdField_c_of_type_JavaLangString = paramString.optString("imgCover");
              parambbqs.jdField_a_of_type_Bbqu = ((bbqu)localObject);
            }
          }
        }
      }
      label883:
      return;
      label884:
      j += 1;
      continue;
      label891:
      int k = i - 1;
      continue;
      label899:
      k = i - 1;
      continue;
      label907:
      k = i - 1;
      continue;
      label915:
      k = i - 1;
      continue;
      label923:
      k = i - 1;
      continue;
      label931:
      k = i - 1;
      continue;
      label939:
      k = i - 1;
      continue;
      label947:
      i -= 1;
    }
  }
  
  /* Error */
  public static bbqr[] a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: new 361	java/util/LinkedHashMap
    //   3: dup
    //   4: invokespecial 362	java/util/LinkedHashMap:<init>	()V
    //   7: astore 7
    //   9: new 29	java/io/File
    //   12: dup
    //   13: getstatic 365	com/tencent/mobileqq/app/SignatureManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokespecial 366	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore_0
    //   20: aload_0
    //   21: iconst_m1
    //   22: invokestatic 55	bbdx:a	(Ljava/io/File;I)Ljava/lang/String;
    //   25: astore_0
    //   26: aload_0
    //   27: ifnonnull +24 -> 51
    //   30: aconst_null
    //   31: areturn
    //   32: astore_0
    //   33: invokestatic 370	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +1594 -> 1630
    //   39: ldc 57
    //   41: iconst_2
    //   42: ldc 67
    //   44: aload_0
    //   45: invokestatic 70	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   48: goto +1582 -> 1630
    //   51: new 98	org/json/JSONObject
    //   54: dup
    //   55: aload_0
    //   56: aload_0
    //   57: ldc_w 372
    //   60: invokevirtual 377	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   63: aload_0
    //   64: invokevirtual 378	java/lang/String:length	()I
    //   67: invokevirtual 382	java/lang/String:subSequence	(II)Ljava/lang/CharSequence;
    //   70: checkcast 374	java/lang/String
    //   73: invokespecial 99	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   76: ldc 101
    //   78: invokevirtual 385	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   81: astore_0
    //   82: aload_0
    //   83: ldc_w 387
    //   86: invokevirtual 290	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   89: astore 8
    //   91: iconst_0
    //   92: istore_3
    //   93: iload_3
    //   94: aload 8
    //   96: invokevirtual 111	org/json/JSONArray:length	()I
    //   99: if_icmpge +71 -> 170
    //   102: aload 8
    //   104: iload_3
    //   105: invokevirtual 115	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   108: astore 9
    //   110: new 389	bbqr
    //   113: dup
    //   114: invokespecial 390	bbqr:<init>	()V
    //   117: astore 10
    //   119: aload 10
    //   121: aload 9
    //   123: ldc_w 392
    //   126: invokevirtual 395	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   129: putfield 396	bbqr:jdField_a_of_type_Int	I
    //   132: aload 10
    //   134: aload 9
    //   136: ldc_w 398
    //   139: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   142: putfield 402	bbqr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   145: aload 7
    //   147: aload 10
    //   149: getfield 396	bbqr:jdField_a_of_type_Int	I
    //   152: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   155: aload 10
    //   157: invokeinterface 412 3 0
    //   162: pop
    //   163: iload_3
    //   164: iconst_1
    //   165: iadd
    //   166: istore_3
    //   167: goto -74 -> 93
    //   170: aload_0
    //   171: ldc_w 414
    //   174: invokevirtual 385	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   177: astore 8
    //   179: aload 8
    //   181: invokevirtual 418	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   184: astore 9
    //   186: aload 9
    //   188: invokeinterface 423 1 0
    //   193: ifeq +1348 -> 1541
    //   196: aload 8
    //   198: aload 9
    //   200: invokeinterface 427 1 0
    //   205: checkcast 374	java/lang/String
    //   208: invokevirtual 290	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   211: astore 10
    //   213: iconst_0
    //   214: istore 4
    //   216: iload 4
    //   218: aload 10
    //   220: invokevirtual 111	org/json/JSONArray:length	()I
    //   223: if_icmpge -37 -> 186
    //   226: aload 10
    //   228: iload 4
    //   230: invokevirtual 115	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   233: astore 12
    //   235: new 72	bbqs
    //   238: dup
    //   239: aload 12
    //   241: ldc_w 429
    //   244: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   247: invokespecial 80	bbqs:<init>	(Ljava/lang/String;)V
    //   250: astore 11
    //   252: aload 12
    //   254: ldc 101
    //   256: invokevirtual 290	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   259: astore 13
    //   261: iconst_0
    //   262: istore_3
    //   263: iload_3
    //   264: aload 13
    //   266: invokevirtual 111	org/json/JSONArray:length	()I
    //   269: if_icmpge +731 -> 1000
    //   272: aload 13
    //   274: iload_3
    //   275: invokevirtual 115	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   278: astore 14
    //   280: aload 14
    //   282: ldc 117
    //   284: invokevirtual 395	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   287: iconst_1
    //   288: if_icmpne +6 -> 294
    //   291: goto +1341 -> 1632
    //   294: aload 11
    //   296: aload 14
    //   298: ldc 125
    //   300: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   303: putfield 133	bbqs:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   306: aload 11
    //   308: getfield 133	bbqs:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   311: invokestatic 137	com/tencent/common/config/AppSetting:a	(Ljava/lang/String;)I
    //   314: iflt +1318 -> 1632
    //   317: aload 14
    //   319: ldc 144
    //   321: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   324: ifeq +633 -> 957
    //   327: aload 14
    //   329: ldc 144
    //   331: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   334: astore_0
    //   335: aload 11
    //   337: aload_0
    //   338: putfield 152	bbqs:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   341: aload 14
    //   343: ldc 154
    //   345: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   348: ifeq +1291 -> 1639
    //   351: aload 14
    //   353: ldc 154
    //   355: invokevirtual 395	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   358: istore 5
    //   360: aload 11
    //   362: iload 5
    //   364: putfield 160	bbqs:jdField_b_of_type_Int	I
    //   367: aload 14
    //   369: ldc 162
    //   371: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   374: ifeq +1271 -> 1645
    //   377: aload 14
    //   379: ldc 162
    //   381: invokevirtual 395	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   384: istore 5
    //   386: aload 11
    //   388: iload 5
    //   390: putfield 164	bbqs:jdField_a_of_type_Int	I
    //   393: aload 14
    //   395: ldc 166
    //   397: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   400: ifeq +1251 -> 1651
    //   403: aload 14
    //   405: ldc 166
    //   407: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   410: astore_0
    //   411: aload 11
    //   413: aload_0
    //   414: putfield 169	bbqs:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   417: aload 14
    //   419: ldc 171
    //   421: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   424: ifeq +1232 -> 1656
    //   427: aload 14
    //   429: ldc 171
    //   431: invokevirtual 395	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   434: istore 5
    //   436: aload 11
    //   438: iload 5
    //   440: putfield 173	bbqs:jdField_c_of_type_Int	I
    //   443: aload 11
    //   445: aload 14
    //   447: ldc 117
    //   449: invokevirtual 395	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   452: putfield 176	bbqs:jdField_d_of_type_Int	I
    //   455: aload 14
    //   457: ldc 178
    //   459: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   462: ifeq +1200 -> 1662
    //   465: aload 14
    //   467: ldc 178
    //   469: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   472: astore_0
    //   473: aload 11
    //   475: aload_0
    //   476: putfield 182	bbqs:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   479: aload 11
    //   481: getfield 182	bbqs:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   484: invokestatic 192	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   487: pop
    //   488: aload 14
    //   490: ldc 194
    //   492: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   495: ifeq +1173 -> 1668
    //   498: aload 14
    //   500: ldc 194
    //   502: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   505: astore_0
    //   506: aload 11
    //   508: aload_0
    //   509: putfield 197	bbqs:n	Ljava/lang/String;
    //   512: aload 14
    //   514: ldc 199
    //   516: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   519: ifeq +1155 -> 1674
    //   522: aload 14
    //   524: ldc 199
    //   526: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   529: astore_0
    //   530: aload 11
    //   532: aload_0
    //   533: putfield 202	bbqs:o	Ljava/lang/String;
    //   536: aload 11
    //   538: getfield 202	bbqs:o	Ljava/lang/String;
    //   541: invokestatic 192	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   544: pop
    //   545: aload 14
    //   547: ldc 204
    //   549: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   552: ifeq +1128 -> 1680
    //   555: aload 14
    //   557: ldc 204
    //   559: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   562: astore_0
    //   563: aload 11
    //   565: aload_0
    //   566: putfield 207	bbqs:p	Ljava/lang/String;
    //   569: aload 11
    //   571: getfield 207	bbqs:p	Ljava/lang/String;
    //   574: invokestatic 192	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   577: pop
    //   578: aload 14
    //   580: ldc 209
    //   582: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   585: ifeq +1101 -> 1686
    //   588: aload 14
    //   590: ldc 209
    //   592: invokevirtual 395	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   595: istore 5
    //   597: aload 11
    //   599: iload 5
    //   601: putfield 211	bbqs:jdField_e_of_type_Int	I
    //   604: aload 14
    //   606: ldc 213
    //   608: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   611: ifeq +1081 -> 1692
    //   614: aload 14
    //   616: ldc 213
    //   618: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   621: astore_0
    //   622: aload 11
    //   624: aload_0
    //   625: putfield 219	bbqs:q	Ljava/lang/String;
    //   628: aload 14
    //   630: ldc 221
    //   632: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   635: ifeq +1063 -> 1698
    //   638: aload 14
    //   640: ldc 221
    //   642: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   645: astore_0
    //   646: aload 11
    //   648: aload_0
    //   649: putfield 224	bbqs:r	Ljava/lang/String;
    //   652: aload 14
    //   654: ldc 226
    //   656: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   659: ifeq +1045 -> 1704
    //   662: aload 14
    //   664: ldc 226
    //   666: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   669: astore_0
    //   670: aload 11
    //   672: aload_0
    //   673: putfield 229	bbqs:s	Ljava/lang/String;
    //   676: aload 14
    //   678: ldc_w 269
    //   681: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   684: ifeq +1026 -> 1710
    //   687: aload 14
    //   689: ldc_w 269
    //   692: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   695: astore_0
    //   696: aload 11
    //   698: aload_0
    //   699: putfield 272	bbqs:t	Ljava/lang/String;
    //   702: aload 14
    //   704: ldc 231
    //   706: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   709: ifeq +15 -> 724
    //   712: aload 11
    //   714: aload 14
    //   716: ldc 231
    //   718: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   721: putfield 233	bbqs:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   724: aload 14
    //   726: ldc 235
    //   728: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   731: ifeq +15 -> 746
    //   734: aload 11
    //   736: aload 14
    //   738: ldc 235
    //   740: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   743: putfield 237	bbqs:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   746: aload 14
    //   748: ldc 239
    //   750: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   753: ifeq +15 -> 768
    //   756: aload 11
    //   758: aload 14
    //   760: ldc 239
    //   762: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   765: putfield 242	bbqs:h	Ljava/lang/String;
    //   768: aload 14
    //   770: ldc 244
    //   772: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   775: ifeq +15 -> 790
    //   778: aload 11
    //   780: aload 14
    //   782: ldc 244
    //   784: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   787: putfield 247	bbqs:i	Ljava/lang/String;
    //   790: aload 14
    //   792: ldc 249
    //   794: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   797: ifeq +15 -> 812
    //   800: aload 11
    //   802: aload 14
    //   804: ldc 249
    //   806: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   809: putfield 252	bbqs:j	Ljava/lang/String;
    //   812: aload 14
    //   814: ldc 254
    //   816: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   819: ifeq +15 -> 834
    //   822: aload 11
    //   824: aload 14
    //   826: ldc 254
    //   828: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   831: putfield 257	bbqs:k	Ljava/lang/String;
    //   834: aload 14
    //   836: ldc_w 259
    //   839: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   842: ifeq +16 -> 858
    //   845: aload 11
    //   847: aload 14
    //   849: ldc_w 259
    //   852: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   855: putfield 262	bbqs:l	Ljava/lang/String;
    //   858: aload 14
    //   860: ldc_w 264
    //   863: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   866: ifeq +766 -> 1632
    //   869: aload 11
    //   871: aload 14
    //   873: ldc_w 264
    //   876: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   879: putfield 267	bbqs:m	Ljava/lang/String;
    //   882: goto +750 -> 1632
    //   885: astore_0
    //   886: new 29	java/io/File
    //   889: dup
    //   890: getstatic 365	com/tencent/mobileqq/app/SignatureManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   893: invokespecial 366	java/io/File:<init>	(Ljava/lang/String;)V
    //   896: astore 7
    //   898: aload 7
    //   900: invokevirtual 432	java/io/File:exists	()Z
    //   903: ifeq +17 -> 920
    //   906: aload 7
    //   908: invokevirtual 435	java/io/File:isFile	()Z
    //   911: ifeq +9 -> 920
    //   914: aload 7
    //   916: invokevirtual 438	java/io/File:delete	()Z
    //   919: pop
    //   920: invokestatic 370	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   923: ifeq +32 -> 955
    //   926: ldc 57
    //   928: iconst_2
    //   929: new 10	java/lang/StringBuilder
    //   932: dup
    //   933: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   936: ldc_w 440
    //   939: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: aload_0
    //   943: invokevirtual 441	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   946: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   952: invokestatic 443	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   955: aconst_null
    //   956: areturn
    //   957: ldc_w 444
    //   960: invokestatic 149	ajya:a	(I)Ljava/lang/String;
    //   963: astore_0
    //   964: goto -629 -> 335
    //   967: astore_0
    //   968: aload 11
    //   970: ldc 180
    //   972: putfield 182	bbqs:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   975: goto -487 -> 488
    //   978: astore_0
    //   979: aload 11
    //   981: ldc 180
    //   983: putfield 202	bbqs:o	Ljava/lang/String;
    //   986: goto -441 -> 545
    //   989: astore_0
    //   990: aload 11
    //   992: ldc 180
    //   994: putfield 207	bbqs:p	Ljava/lang/String;
    //   997: goto -419 -> 578
    //   1000: aload 12
    //   1002: ldc_w 283
    //   1005: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1008: ifeq +387 -> 1395
    //   1011: aload 12
    //   1013: ldc_w 283
    //   1016: invokevirtual 290	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1019: astore 13
    //   1021: iconst_0
    //   1022: istore 5
    //   1024: iload 5
    //   1026: aload 13
    //   1028: invokevirtual 111	org/json/JSONArray:length	()I
    //   1031: if_icmpge +364 -> 1395
    //   1034: aload 13
    //   1036: iload 5
    //   1038: invokevirtual 115	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1041: astore 14
    //   1043: aload 14
    //   1045: ldc_w 292
    //   1048: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1051: ifeq +692 -> 1743
    //   1054: aload 14
    //   1056: ldc_w 292
    //   1059: invokevirtual 395	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1062: istore_3
    //   1063: goto +653 -> 1716
    //   1066: aload 11
    //   1068: getfield 295	bbqs:jdField_a_of_type_ArrayOfBbqt	[Lbbqt;
    //   1071: astore_0
    //   1072: iload_3
    //   1073: ifne +675 -> 1748
    //   1076: iload_3
    //   1077: istore 6
    //   1079: aload_0
    //   1080: iload 6
    //   1082: aaload
    //   1083: iload_3
    //   1084: putfield 298	bbqt:jdField_a_of_type_Int	I
    //   1087: aload 11
    //   1089: getfield 295	bbqs:jdField_a_of_type_ArrayOfBbqt	[Lbbqt;
    //   1092: astore_0
    //   1093: iload_3
    //   1094: ifne +662 -> 1756
    //   1097: iload_3
    //   1098: istore 6
    //   1100: aload_0
    //   1101: iload 6
    //   1103: aaload
    //   1104: astore 15
    //   1106: aload 14
    //   1108: ldc_w 300
    //   1111: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1114: ifeq +650 -> 1764
    //   1117: aload 14
    //   1119: ldc_w 300
    //   1122: invokevirtual 401	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1125: astore_0
    //   1126: aload 15
    //   1128: aload_0
    //   1129: putfield 302	bbqt:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1132: aload 11
    //   1134: getfield 295	bbqs:jdField_a_of_type_ArrayOfBbqt	[Lbbqt;
    //   1137: astore_0
    //   1138: iload_3
    //   1139: ifne +631 -> 1770
    //   1142: iload_3
    //   1143: istore 6
    //   1145: aload_0
    //   1146: iload 6
    //   1148: aaload
    //   1149: astore_0
    //   1150: aload 14
    //   1152: ldc_w 304
    //   1155: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1158: ifeq +620 -> 1778
    //   1161: aload 14
    //   1163: ldc_w 304
    //   1166: invokevirtual 448	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   1169: dstore_1
    //   1170: aload_0
    //   1171: dload_1
    //   1172: d2f
    //   1173: putfield 311	bbqt:jdField_a_of_type_Float	F
    //   1176: aload 11
    //   1178: getfield 295	bbqs:jdField_a_of_type_ArrayOfBbqt	[Lbbqt;
    //   1181: astore_0
    //   1182: iload_3
    //   1183: ifne +600 -> 1783
    //   1186: iload_3
    //   1187: istore 6
    //   1189: aload_0
    //   1190: iload 6
    //   1192: aaload
    //   1193: astore_0
    //   1194: aload 14
    //   1196: ldc_w 313
    //   1199: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1202: ifeq +589 -> 1791
    //   1205: aload 14
    //   1207: ldc_w 313
    //   1210: invokevirtual 448	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   1213: dstore_1
    //   1214: aload_0
    //   1215: dload_1
    //   1216: d2f
    //   1217: putfield 315	bbqt:jdField_b_of_type_Float	F
    //   1220: aload 11
    //   1222: getfield 295	bbqs:jdField_a_of_type_ArrayOfBbqt	[Lbbqt;
    //   1225: astore_0
    //   1226: iload_3
    //   1227: ifne +569 -> 1796
    //   1230: iload_3
    //   1231: istore 6
    //   1233: aload_0
    //   1234: iload 6
    //   1236: aaload
    //   1237: astore_0
    //   1238: aload 14
    //   1240: ldc_w 317
    //   1243: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1246: ifeq +558 -> 1804
    //   1249: aload 14
    //   1251: ldc_w 317
    //   1254: invokevirtual 448	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   1257: dstore_1
    //   1258: aload_0
    //   1259: dload_1
    //   1260: d2f
    //   1261: putfield 319	bbqt:jdField_c_of_type_Float	F
    //   1264: aload 11
    //   1266: getfield 295	bbqs:jdField_a_of_type_ArrayOfBbqt	[Lbbqt;
    //   1269: astore_0
    //   1270: iload_3
    //   1271: ifne +538 -> 1809
    //   1274: iload_3
    //   1275: istore 6
    //   1277: aload_0
    //   1278: iload 6
    //   1280: aaload
    //   1281: astore_0
    //   1282: aload 14
    //   1284: ldc_w 321
    //   1287: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1290: ifeq +527 -> 1817
    //   1293: aload 14
    //   1295: ldc_w 321
    //   1298: invokevirtual 448	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   1301: dstore_1
    //   1302: aload_0
    //   1303: dload_1
    //   1304: d2f
    //   1305: putfield 323	bbqt:d	F
    //   1308: aload 11
    //   1310: getfield 295	bbqs:jdField_a_of_type_ArrayOfBbqt	[Lbbqt;
    //   1313: astore_0
    //   1314: iload_3
    //   1315: ifne +507 -> 1822
    //   1318: iload_3
    //   1319: istore 6
    //   1321: aload_0
    //   1322: iload 6
    //   1324: aaload
    //   1325: astore_0
    //   1326: aload 14
    //   1328: ldc_w 325
    //   1331: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1334: ifeq +496 -> 1830
    //   1337: aload 14
    //   1339: ldc_w 325
    //   1342: invokevirtual 395	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1345: istore 6
    //   1347: aload_0
    //   1348: iload 6
    //   1350: putfield 326	bbqt:jdField_b_of_type_Int	I
    //   1353: aload 11
    //   1355: getfield 295	bbqs:jdField_a_of_type_ArrayOfBbqt	[Lbbqt;
    //   1358: astore_0
    //   1359: iload_3
    //   1360: ifne +476 -> 1836
    //   1363: aload_0
    //   1364: iload_3
    //   1365: aaload
    //   1366: astore_0
    //   1367: aload 14
    //   1369: ldc_w 328
    //   1372: invokevirtual 287	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1375: ifeq +468 -> 1843
    //   1378: aload 14
    //   1380: ldc_w 328
    //   1383: invokevirtual 395	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1386: istore_3
    //   1387: aload_0
    //   1388: iload_3
    //   1389: putfield 329	bbqt:jdField_c_of_type_Int	I
    //   1392: goto +342 -> 1734
    //   1395: aload 12
    //   1397: ldc_w 331
    //   1400: invokevirtual 105	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1403: astore_0
    //   1404: aload_0
    //   1405: ifnull +100 -> 1505
    //   1408: aload_0
    //   1409: invokevirtual 111	org/json/JSONArray:length	()I
    //   1412: ifle +93 -> 1505
    //   1415: aload_0
    //   1416: iconst_0
    //   1417: invokevirtual 115	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1420: astore_0
    //   1421: aload 11
    //   1423: invokevirtual 335	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1426: pop
    //   1427: new 337	bbqu
    //   1430: dup
    //   1431: aload 11
    //   1433: invokespecial 340	bbqu:<init>	(Lbbqs;)V
    //   1436: astore 12
    //   1438: aload 12
    //   1440: aload_0
    //   1441: ldc_w 342
    //   1444: invokevirtual 216	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1447: putfield 343	bbqu:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1450: aload 12
    //   1452: aload_0
    //   1453: ldc_w 345
    //   1456: invokevirtual 216	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1459: putfield 346	bbqu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1462: aload 12
    //   1464: aload_0
    //   1465: ldc_w 348
    //   1468: invokevirtual 121	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1471: putfield 349	bbqu:jdField_a_of_type_Int	I
    //   1474: aload 12
    //   1476: aload_0
    //   1477: ldc_w 351
    //   1480: invokevirtual 121	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1483: putfield 352	bbqu:jdField_b_of_type_Int	I
    //   1486: aload 12
    //   1488: aload_0
    //   1489: ldc_w 354
    //   1492: invokevirtual 216	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1495: putfield 355	bbqu:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1498: aload 11
    //   1500: aload 12
    //   1502: putfield 358	bbqs:jdField_a_of_type_Bbqu	Lbbqu;
    //   1505: aload 7
    //   1507: aload 11
    //   1509: getfield 160	bbqs:jdField_b_of_type_Int	I
    //   1512: invokestatic 406	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1515: invokeinterface 452 2 0
    //   1520: checkcast 389	bbqr
    //   1523: astore_0
    //   1524: aload_0
    //   1525: ifnull +323 -> 1848
    //   1528: aload_0
    //   1529: getfield 455	bbqr:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1532: aload 11
    //   1534: invokevirtual 461	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1537: pop
    //   1538: goto +310 -> 1848
    //   1541: aload 7
    //   1543: invokeinterface 465 1 0
    //   1548: invokeinterface 470 1 0
    //   1553: astore_0
    //   1554: aload_0
    //   1555: invokeinterface 423 1 0
    //   1560: ifeq +38 -> 1598
    //   1563: aload_0
    //   1564: invokeinterface 427 1 0
    //   1569: checkcast 472	java/util/Map$Entry
    //   1572: invokeinterface 475 1 0
    //   1577: checkcast 389	bbqr
    //   1580: getfield 455	bbqr:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1583: invokevirtual 478	java/util/ArrayList:size	()I
    //   1586: ifne -32 -> 1554
    //   1589: aload_0
    //   1590: invokeinterface 481 1 0
    //   1595: goto -41 -> 1554
    //   1598: aload 7
    //   1600: invokeinterface 485 1 0
    //   1605: invokeinterface 488 1 0
    //   1610: anewarray 389	bbqr
    //   1613: astore_0
    //   1614: aload 7
    //   1616: invokeinterface 485 1 0
    //   1621: aload_0
    //   1622: invokeinterface 492 2 0
    //   1627: pop
    //   1628: aload_0
    //   1629: areturn
    //   1630: aconst_null
    //   1631: areturn
    //   1632: iload_3
    //   1633: iconst_1
    //   1634: iadd
    //   1635: istore_3
    //   1636: goto -1373 -> 263
    //   1639: iconst_m1
    //   1640: istore 5
    //   1642: goto -1282 -> 360
    //   1645: iconst_1
    //   1646: istore 5
    //   1648: goto -1262 -> 386
    //   1651: aconst_null
    //   1652: astore_0
    //   1653: goto -1242 -> 411
    //   1656: iconst_0
    //   1657: istore 5
    //   1659: goto -1223 -> 436
    //   1662: ldc 180
    //   1664: astore_0
    //   1665: goto -1192 -> 473
    //   1668: ldc 180
    //   1670: astore_0
    //   1671: goto -1165 -> 506
    //   1674: ldc 180
    //   1676: astore_0
    //   1677: goto -1147 -> 530
    //   1680: ldc 180
    //   1682: astore_0
    //   1683: goto -1120 -> 563
    //   1686: iconst_1
    //   1687: istore 5
    //   1689: goto -1092 -> 597
    //   1692: ldc 180
    //   1694: astore_0
    //   1695: goto -1073 -> 622
    //   1698: ldc 180
    //   1700: astore_0
    //   1701: goto -1055 -> 646
    //   1704: ldc 180
    //   1706: astore_0
    //   1707: goto -1037 -> 670
    //   1710: ldc 180
    //   1712: astore_0
    //   1713: goto -1017 -> 696
    //   1716: iload_3
    //   1717: ifeq -651 -> 1066
    //   1720: iload_3
    //   1721: iconst_1
    //   1722: if_icmple +12 -> 1734
    //   1725: iload_3
    //   1726: bipush 6
    //   1728: if_icmpge +6 -> 1734
    //   1731: goto -665 -> 1066
    //   1734: iload 5
    //   1736: iconst_1
    //   1737: iadd
    //   1738: istore 5
    //   1740: goto -716 -> 1024
    //   1743: iconst_m1
    //   1744: istore_3
    //   1745: goto -29 -> 1716
    //   1748: iload_3
    //   1749: iconst_1
    //   1750: isub
    //   1751: istore 6
    //   1753: goto -674 -> 1079
    //   1756: iload_3
    //   1757: iconst_1
    //   1758: isub
    //   1759: istore 6
    //   1761: goto -661 -> 1100
    //   1764: ldc 180
    //   1766: astore_0
    //   1767: goto -641 -> 1126
    //   1770: iload_3
    //   1771: iconst_1
    //   1772: isub
    //   1773: istore 6
    //   1775: goto -630 -> 1145
    //   1778: dconst_0
    //   1779: dstore_1
    //   1780: goto -610 -> 1170
    //   1783: iload_3
    //   1784: iconst_1
    //   1785: isub
    //   1786: istore 6
    //   1788: goto -599 -> 1189
    //   1791: dconst_0
    //   1792: dstore_1
    //   1793: goto -579 -> 1214
    //   1796: iload_3
    //   1797: iconst_1
    //   1798: isub
    //   1799: istore 6
    //   1801: goto -568 -> 1233
    //   1804: dconst_0
    //   1805: dstore_1
    //   1806: goto -548 -> 1258
    //   1809: iload_3
    //   1810: iconst_1
    //   1811: isub
    //   1812: istore 6
    //   1814: goto -537 -> 1277
    //   1817: dconst_0
    //   1818: dstore_1
    //   1819: goto -517 -> 1302
    //   1822: iload_3
    //   1823: iconst_1
    //   1824: isub
    //   1825: istore 6
    //   1827: goto -506 -> 1321
    //   1830: iconst_0
    //   1831: istore 6
    //   1833: goto -486 -> 1347
    //   1836: iload_3
    //   1837: iconst_1
    //   1838: isub
    //   1839: istore_3
    //   1840: goto -477 -> 1363
    //   1843: iconst_0
    //   1844: istore_3
    //   1845: goto -458 -> 1387
    //   1848: iload 4
    //   1850: iconst_1
    //   1851: iadd
    //   1852: istore 4
    //   1854: goto -1638 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1857	0	paramQQAppInterface	QQAppInterface
    //   1169	650	1	d	double
    //   92	1753	3	i	int
    //   214	1639	4	j	int
    //   358	1381	5	k	int
    //   1077	755	6	m	int
    //   7	1608	7	localObject1	Object
    //   89	108	8	localObject2	Object
    //   108	91	9	localObject3	Object
    //   117	110	10	localObject4	Object
    //   250	1283	11	localbbqs	bbqs
    //   233	1268	12	localObject5	Object
    //   259	776	13	localJSONArray	JSONArray
    //   278	1101	14	localJSONObject	JSONObject
    //   1104	23	15	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   20	26	32	java/lang/OutOfMemoryError
    //   0	20	885	java/lang/Exception
    //   20	26	885	java/lang/Exception
    //   33	48	885	java/lang/Exception
    //   51	91	885	java/lang/Exception
    //   93	163	885	java/lang/Exception
    //   170	186	885	java/lang/Exception
    //   186	213	885	java/lang/Exception
    //   216	261	885	java/lang/Exception
    //   263	291	885	java/lang/Exception
    //   294	335	885	java/lang/Exception
    //   335	360	885	java/lang/Exception
    //   360	386	885	java/lang/Exception
    //   386	411	885	java/lang/Exception
    //   411	436	885	java/lang/Exception
    //   436	473	885	java/lang/Exception
    //   473	479	885	java/lang/Exception
    //   488	506	885	java/lang/Exception
    //   506	530	885	java/lang/Exception
    //   530	536	885	java/lang/Exception
    //   545	563	885	java/lang/Exception
    //   563	569	885	java/lang/Exception
    //   578	597	885	java/lang/Exception
    //   597	622	885	java/lang/Exception
    //   622	646	885	java/lang/Exception
    //   646	670	885	java/lang/Exception
    //   670	696	885	java/lang/Exception
    //   696	724	885	java/lang/Exception
    //   724	746	885	java/lang/Exception
    //   746	768	885	java/lang/Exception
    //   768	790	885	java/lang/Exception
    //   790	812	885	java/lang/Exception
    //   812	834	885	java/lang/Exception
    //   834	858	885	java/lang/Exception
    //   858	882	885	java/lang/Exception
    //   957	964	885	java/lang/Exception
    //   968	975	885	java/lang/Exception
    //   979	986	885	java/lang/Exception
    //   990	997	885	java/lang/Exception
    //   1000	1021	885	java/lang/Exception
    //   1024	1063	885	java/lang/Exception
    //   1066	1072	885	java/lang/Exception
    //   1079	1093	885	java/lang/Exception
    //   1106	1126	885	java/lang/Exception
    //   1126	1138	885	java/lang/Exception
    //   1150	1170	885	java/lang/Exception
    //   1170	1182	885	java/lang/Exception
    //   1194	1214	885	java/lang/Exception
    //   1214	1226	885	java/lang/Exception
    //   1238	1258	885	java/lang/Exception
    //   1258	1270	885	java/lang/Exception
    //   1282	1302	885	java/lang/Exception
    //   1302	1314	885	java/lang/Exception
    //   1326	1347	885	java/lang/Exception
    //   1347	1359	885	java/lang/Exception
    //   1367	1387	885	java/lang/Exception
    //   1387	1392	885	java/lang/Exception
    //   1395	1404	885	java/lang/Exception
    //   1408	1505	885	java/lang/Exception
    //   1505	1524	885	java/lang/Exception
    //   1528	1538	885	java/lang/Exception
    //   1541	1554	885	java/lang/Exception
    //   1554	1595	885	java/lang/Exception
    //   1598	1628	885	java/lang/Exception
    //   479	488	967	java/lang/Exception
    //   536	545	978	java/lang/Exception
    //   569	578	989	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbqq
 * JD-Core Version:    0.7.0.1
 */