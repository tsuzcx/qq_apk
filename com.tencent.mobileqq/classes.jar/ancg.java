import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;

public class ancg
  extends anae<CustomEmotionData>
{
  private boolean a;
  
  public ancg(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private CustomEmotionData a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    CustomEmotionData localCustomEmotionData = null;
    Object localObject = localCustomEmotionData;
    if (paramString1 != null)
    {
      localObject = localCustomEmotionData;
      if (!TextUtils.isEmpty(paramString2))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          break label36;
        }
        localObject = localCustomEmotionData;
      }
    }
    label36:
    String str1;
    anco localanco;
    String str2;
    do
    {
      do
      {
        do
        {
          return localObject;
          str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          localanco = new anco(paramString1);
          localObject = localCustomEmotionData;
        } while (TextUtils.isEmpty(localanco.jdField_a_of_type_JavaLangString));
        str2 = localanco.jdField_c_of_type_JavaLangString;
        localObject = localCustomEmotionData;
      } while (str2 == null);
      localObject = localCustomEmotionData;
    } while ("".equals(str2));
    localCustomEmotionData = new CustomEmotionData();
    if (str2.equals("1"))
    {
      localCustomEmotionData.isMarkFace = true;
      localCustomEmotionData.uin = str1;
      localCustomEmotionData.emoPath = localanco.e;
      localCustomEmotionData.eId = localanco.f;
      localCustomEmotionData.resid = paramString1;
      localCustomEmotionData.RomaingType = paramString3;
      localCustomEmotionData.url = ance.a(paramString1, paramString2, str1);
      localCustomEmotionData.emoId = paramInt;
      localCustomEmotionData.isAPNG = paramBoolean;
      localCustomEmotionData.checkMarketFace("createCustomEmotionDataByResId");
    }
    while (!str2.equals("0"))
    {
      localObject = localCustomEmotionData;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FavroamingDBManager", 2, "createCustomEmotionDataByResIdList : emotionData = " + localCustomEmotionData + ", emotion name:" + paramString1);
      return localCustomEmotionData;
    }
    localObject = localanco.f;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (!((String)localObject).contains("qto@")) {
        break label397;
      }
      localObject = ((String)localObject).replace("qto@", "qto_");
      localCustomEmotionData.eId = ((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 2, "download funnyPic name.original->" + (String)localObject);
      }
    }
    for (;;)
    {
      localCustomEmotionData.isMarkFace = false;
      localCustomEmotionData.uin = str1;
      localCustomEmotionData.emoPath = ance.a(paramString1);
      localCustomEmotionData.resid = paramString1;
      localCustomEmotionData.md5 = localanco.jdField_d_of_type_JavaLangString;
      localCustomEmotionData.url = ance.a(paramString1, paramString2, str1);
      localCustomEmotionData.RomaingType = paramString3;
      localCustomEmotionData.emoId = paramInt;
      break;
      label397:
      if (((String)localObject).contains("diydoutu@"))
      {
        localCustomEmotionData.eId = localanco.e;
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingDBManager", 2, "download diyemoji name.original->" + paramString1);
        }
      }
    }
  }
  
  public anag<CustomEmotionData> a()
  {
    return (anch)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(103);
  }
  
  public anht a(CustomEmotionData paramCustomEmotionData)
  {
    if (paramCustomEmotionData.isMarkFace)
    {
      localObject1 = new anla(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((anla)localObject1).jdField_c_of_type_Int = 6;
      localObject2 = paramCustomEmotionData.eId;
      String str = paramCustomEmotionData.emoPath;
      ((anla)localObject1).jdField_c_of_type_Boolean = paramCustomEmotionData.isAPNG;
      ((anla)localObject1).jdField_a_of_type_ComTencentMobileqqDataEmoticon = ((arnz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(str, (String)localObject2);
      ((anla)localObject1).jdField_d_of_type_Int = 2;
      ((anla)localObject1).jdField_a_of_type_JavaLangString = paramCustomEmotionData.RomaingType;
      ((anla)localObject1).jdField_g_of_type_Int = paramCustomEmotionData.emoId;
      return localObject1;
    }
    Object localObject1 = ((andn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(141)).a();
    Object localObject2 = new ankl();
    ((ankl)localObject2).jdField_c_of_type_Int = 4;
    ((ankl)localObject2).jdField_d_of_type_JavaLangString = a(paramCustomEmotionData);
    ((ankl)localObject2).jdField_d_of_type_Int = 2;
    ((ankl)localObject2).jdField_c_of_type_JavaLangString = paramCustomEmotionData.eId;
    ((ankl)localObject2).e = paramCustomEmotionData.url;
    if (localObject1 != null) {
      ((ankl)localObject2).jdField_a_of_type_JavaLangString = ankl.a((Map)localObject1, paramCustomEmotionData.md5);
    }
    ((ankl)localObject2).jdField_g_of_type_JavaLangString = paramCustomEmotionData.RomaingType;
    ((ankl)localObject2).jdField_g_of_type_Int = paramCustomEmotionData.emoId;
    ((ankl)localObject2).f = paramCustomEmotionData.resid;
    return localObject2;
  }
  
  public CustomEmotionData a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateUpload.");
    }
    CustomEmotionData localCustomEmotionData = a(a(), paramString);
    if (localCustomEmotionData != null)
    {
      localCustomEmotionData.resid = paramString;
      localCustomEmotionData.RomaingType = "isUpdate";
      b(localCustomEmotionData);
    }
    return localCustomEmotionData;
  }
  
  public CustomEmotionData a(List<CustomEmotionData> paramList, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramList == null) || (paramList.size() < 1)) {
      return null;
    }
    int j = paramList.size();
    int i = 0;
    CustomEmotionData localCustomEmotionData;
    for (;;)
    {
      if (i < j)
      {
        localCustomEmotionData = (CustomEmotionData)paramList.get(i);
        if ((localCustomEmotionData == null) || ((localCustomEmotionData.RomaingType != null) && (localCustomEmotionData.RomaingType.equals("needUpload"))) || ((localCustomEmotionData.RomaingType != null) && (localCustomEmotionData.RomaingType.equals("failed")))) {
          label98:
          i += 1;
        } else if ((!TextUtils.isEmpty(localCustomEmotionData.resid)) && (localCustomEmotionData.resid.equals(paramString))) {
          paramList = localCustomEmotionData;
        }
      }
    }
    for (;;)
    {
      label131:
      return paramList;
      Object localObject = new anco(paramString);
      if (!((anco)localObject).a())
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("FavroamingDBManager", 2, "res id is not valid:" + paramString);
        return null;
      }
      if (localCustomEmotionData.isMarkFace)
      {
        str = ((anco)localObject).e;
        localObject = ((anco)localObject).f;
        if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject)) || (!str.equals(localCustomEmotionData.emoPath)) || (!((String)localObject).equals(localCustomEmotionData.eId))) {
          break label98;
        }
        localCustomEmotionData.resid = paramString;
        paramList = localCustomEmotionData;
        continue;
      }
      localObject = ((anco)localObject).jdField_d_of_type_JavaLangString;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label98;
      }
      if (!TextUtils.isEmpty(localCustomEmotionData.md5)) {}
      for (String str = localCustomEmotionData.md5;; str = HexUtil.bytes2HexStr(MD5.getFileMd5(localCustomEmotionData.emoPath)))
      {
        localCustomEmotionData.md5 = str;
        if (!((String)localObject).equals(str)) {
          break;
        }
        localCustomEmotionData.resid = paramString;
        paramList = localCustomEmotionData;
        break label131;
      }
      paramList = null;
    }
  }
  
  public Class a()
  {
    return CustomEmotionData.class;
  }
  
  public String a(CustomEmotionData paramCustomEmotionData)
  {
    Object localObject1;
    if (paramCustomEmotionData == null) {
      localObject1 = "";
    }
    Object localObject2;
    do
    {
      return localObject1;
      if (!TextUtils.isEmpty(paramCustomEmotionData.emoPath)) {
        return paramCustomEmotionData.emoPath;
      }
      localObject1 = ajed.bf;
      localObject2 = (andn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(141);
      if ((localObject2 != null) && (((andn)localObject2).a(paramCustomEmotionData)))
      {
        if ((!TextUtils.isEmpty(paramCustomEmotionData.emoPath)) && (paramCustomEmotionData.emoPath.startsWith(ajed.bf))) {
          return paramCustomEmotionData.emoPath;
        }
        if (!TextUtils.isEmpty(paramCustomEmotionData.md5)) {
          return ((andn)localObject2).a(paramCustomEmotionData.md5);
        }
        if (!TextUtils.isEmpty(paramCustomEmotionData.resid)) {
          return (String)localObject1 + akhi.a(paramCustomEmotionData.resid);
        }
        return (String)localObject1 + paramCustomEmotionData.url.substring(paramCustomEmotionData.url.lastIndexOf("/") + 1);
      }
      if ((paramCustomEmotionData.url != null) && (paramCustomEmotionData.url.contains("qto_"))) {
        return (String)localObject1 + ajjm.a(paramCustomEmotionData.url);
      }
      if (TextUtils.isEmpty(ajjm.a(paramCustomEmotionData.eId))) {
        break;
      }
      localObject2 = (String)localObject1 + paramCustomEmotionData.eId;
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("FavroamingDBManager", 2, "emotion is FunnyPic path download from server->" + paramCustomEmotionData.eId);
    return localObject2;
    return (String)localObject1 + paramCustomEmotionData.resid;
  }
  
  /* Error */
  public List<CustomEmotionData> a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 6
    //   6: aload_0
    //   7: monitorenter
    //   8: new 297	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 298	java/util/ArrayList:<init>	()V
    //   15: astore 8
    //   17: aload_0
    //   18: getfield 301	ancg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   21: invokeinterface 237 1 0
    //   26: ifle +104 -> 130
    //   29: aload_0
    //   30: getfield 301	ancg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   33: invokeinterface 305 1 0
    //   38: astore 9
    //   40: aload 9
    //   42: invokeinterface 310 1 0
    //   47: ifeq +40 -> 87
    //   50: aload 9
    //   52: invokeinterface 314 1 0
    //   57: checkcast 49	com/tencent/mobileqq/data/CustomEmotionData
    //   60: astore 10
    //   62: aload 10
    //   64: ifnull -24 -> 40
    //   67: aload 8
    //   69: aload 10
    //   71: invokeinterface 317 2 0
    //   76: pop
    //   77: goto -37 -> 40
    //   80: astore 8
    //   82: aload_0
    //   83: monitorexit
    //   84: aload 8
    //   86: athrow
    //   87: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +35 -> 125
    //   93: ldc 107
    //   95: iconst_2
    //   96: new 109	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   103: ldc_w 319
    //   106: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 8
    //   111: invokeinterface 237 1 0
    //   116: invokevirtual 322	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aload_0
    //   126: monitorexit
    //   127: aload 8
    //   129: areturn
    //   130: aload_0
    //   131: getfield 22	ancg:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   134: ifnonnull +6 -> 140
    //   137: goto -12 -> 125
    //   140: aload_0
    //   141: getfield 22	ancg:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   144: invokevirtual 326	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Latmq;
    //   147: invokevirtual 332	atmq:createEntityManager	()Latmp;
    //   150: astore 11
    //   152: aload 11
    //   154: ifnull +379 -> 533
    //   157: aload 11
    //   159: aload_0
    //   160: invokevirtual 334	ancg:a	()Ljava/lang/Class;
    //   163: iconst_0
    //   164: aconst_null
    //   165: aconst_null
    //   166: aconst_null
    //   167: aconst_null
    //   168: aconst_null
    //   169: aconst_null
    //   170: invokevirtual 339	atmp:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   173: astore 9
    //   175: ldc_w 341
    //   178: aload_0
    //   179: getfield 22	ancg:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   182: invokevirtual 343	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   185: invokestatic 346	akhi:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   188: iconst_1
    //   189: if_icmpge +335 -> 524
    //   192: aload 11
    //   194: invokevirtual 349	atmp:a	()Latmr;
    //   197: astore 10
    //   199: aload 9
    //   201: ifnonnull +156 -> 357
    //   204: iconst_0
    //   205: istore_1
    //   206: iload_1
    //   207: iconst_1
    //   208: isub
    //   209: istore 5
    //   211: iconst_0
    //   212: istore_1
    //   213: iload 5
    //   215: iconst_m1
    //   216: if_icmple +271 -> 487
    //   219: iload_1
    //   220: istore_2
    //   221: iload_1
    //   222: istore 4
    //   224: aload 9
    //   226: iload 5
    //   228: invokeinterface 241 2 0
    //   233: checkcast 49	com/tencent/mobileqq/data/CustomEmotionData
    //   236: astore 8
    //   238: iload_1
    //   239: istore_2
    //   240: iload_1
    //   241: istore 4
    //   243: aload 8
    //   245: getfield 66	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   248: new 109	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   255: getstatic 268	ajed:bf	Ljava/lang/String;
    //   258: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload 8
    //   263: getfield 75	com/tencent/mobileqq/data/CustomEmotionData:resid	Ljava/lang/String;
    //   266: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokevirtual 47	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   275: ifeq +93 -> 368
    //   278: iload_1
    //   279: istore_2
    //   280: iload_1
    //   281: istore 4
    //   283: aload 8
    //   285: new 109	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   292: getstatic 268	ajed:bf	Ljava/lang/String;
    //   295: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload 8
    //   300: getfield 75	com/tencent/mobileqq/data/CustomEmotionData:resid	Ljava/lang/String;
    //   303: invokestatic 278	akhi:a	(Ljava/lang/String;)Ljava/lang/String;
    //   306: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: putfield 66	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   315: iload_1
    //   316: istore_3
    //   317: iload_1
    //   318: ifne +15 -> 333
    //   321: iload_1
    //   322: istore_2
    //   323: iload_1
    //   324: istore 4
    //   326: aload 10
    //   328: invokevirtual 353	atmr:a	()V
    //   331: iconst_1
    //   332: istore_3
    //   333: iload_3
    //   334: istore_2
    //   335: iload_3
    //   336: istore 4
    //   338: aload 11
    //   340: aload 8
    //   342: invokevirtual 356	atmp:a	(Latmo;)Z
    //   345: pop
    //   346: iload_3
    //   347: istore_1
    //   348: iload 5
    //   350: iconst_1
    //   351: isub
    //   352: istore 5
    //   354: goto -141 -> 213
    //   357: aload 9
    //   359: invokeinterface 237 1 0
    //   364: istore_1
    //   365: goto -159 -> 206
    //   368: iload_1
    //   369: istore_2
    //   370: iload_1
    //   371: istore 4
    //   373: aload 8
    //   375: getfield 66	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   378: new 109	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   385: getstatic 268	ajed:bf	Ljava/lang/String;
    //   388: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload 8
    //   393: getfield 60	com/tencent/mobileqq/data/CustomEmotionData:uin	Ljava/lang/String;
    //   396: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: ldc_w 358
    //   402: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokevirtual 361	java/lang/String:matches	(Ljava/lang/String;)Z
    //   411: ifeq +404 -> 815
    //   414: iload_1
    //   415: istore_2
    //   416: iload_1
    //   417: istore 4
    //   419: aload 8
    //   421: getfield 60	com/tencent/mobileqq/data/CustomEmotionData:uin	Ljava/lang/String;
    //   424: astore 12
    //   426: iload_1
    //   427: istore_2
    //   428: iload_1
    //   429: istore 4
    //   431: aload 8
    //   433: aload 8
    //   435: getfield 66	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   438: aload 12
    //   440: aload 12
    //   442: invokestatic 278	akhi:a	(Ljava/lang/String;)Ljava/lang/String;
    //   445: invokevirtual 141	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   448: putfield 66	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   451: iload_1
    //   452: istore_3
    //   453: iload_1
    //   454: ifne +15 -> 469
    //   457: iload_1
    //   458: istore_2
    //   459: iload_1
    //   460: istore 4
    //   462: aload 10
    //   464: invokevirtual 353	atmr:a	()V
    //   467: iconst_1
    //   468: istore_3
    //   469: iload_3
    //   470: istore_2
    //   471: iload_3
    //   472: istore 4
    //   474: aload 11
    //   476: aload 8
    //   478: invokevirtual 356	atmp:a	(Latmo;)Z
    //   481: pop
    //   482: iload_3
    //   483: istore_1
    //   484: goto -136 -> 348
    //   487: iload_1
    //   488: ifeq +13 -> 501
    //   491: iload_1
    //   492: istore_2
    //   493: iload_1
    //   494: istore 4
    //   496: aload 10
    //   498: invokevirtual 363	atmr:c	()V
    //   501: iload_1
    //   502: ifeq +8 -> 510
    //   505: aload 10
    //   507: invokevirtual 365	atmr:b	()V
    //   510: ldc_w 341
    //   513: aload_0
    //   514: getfield 22	ancg:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   517: invokevirtual 343	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   520: iconst_1
    //   521: invokestatic 368	akhi:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   524: aload 11
    //   526: invokevirtual 369	atmp:a	()V
    //   529: aload 9
    //   531: astore 8
    //   533: iload 7
    //   535: istore_2
    //   536: aload 8
    //   538: ifnull +179 -> 717
    //   541: iload 7
    //   543: istore_2
    //   544: aload 8
    //   546: invokeinterface 237 1 0
    //   551: ifle +166 -> 717
    //   554: new 297	java/util/ArrayList
    //   557: dup
    //   558: invokespecial 298	java/util/ArrayList:<init>	()V
    //   561: astore 9
    //   563: aload 8
    //   565: invokeinterface 305 1 0
    //   570: astore 10
    //   572: iload 6
    //   574: istore_1
    //   575: iload_1
    //   576: istore_2
    //   577: aload 10
    //   579: invokeinterface 310 1 0
    //   584: ifeq +133 -> 717
    //   587: aload 10
    //   589: invokeinterface 314 1 0
    //   594: checkcast 49	com/tencent/mobileqq/data/CustomEmotionData
    //   597: astore 11
    //   599: aload 11
    //   601: getfield 78	com/tencent/mobileqq/data/CustomEmotionData:RomaingType	Ljava/lang/String;
    //   604: invokestatic 19	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   607: ifeq +71 -> 678
    //   610: aload 11
    //   612: ldc_w 371
    //   615: putfield 78	com/tencent/mobileqq/data/CustomEmotionData:RomaingType	Ljava/lang/String;
    //   618: aload 9
    //   620: aload 11
    //   622: invokeinterface 317 2 0
    //   627: pop
    //   628: iconst_1
    //   629: istore_1
    //   630: aload_0
    //   631: aload 11
    //   633: iconst_1
    //   634: invokevirtual 374	ancg:b	(Lcom/tencent/mobileqq/data/CustomEmotionBase;I)V
    //   637: goto -62 -> 575
    //   640: astore 8
    //   642: iconst_0
    //   643: istore 4
    //   645: iload 4
    //   647: istore_2
    //   648: aload 8
    //   650: invokevirtual 377	java/lang/Exception:printStackTrace	()V
    //   653: iload 4
    //   655: ifeq -145 -> 510
    //   658: aload 10
    //   660: invokevirtual 365	atmr:b	()V
    //   663: goto -153 -> 510
    //   666: iload_2
    //   667: ifeq +8 -> 675
    //   670: aload 10
    //   672: invokevirtual 365	atmr:b	()V
    //   675: aload 8
    //   677: athrow
    //   678: aload 11
    //   680: getfield 78	com/tencent/mobileqq/data/CustomEmotionData:RomaingType	Ljava/lang/String;
    //   683: ldc 243
    //   685: invokevirtual 47	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   688: ifeq -58 -> 630
    //   691: aload 11
    //   693: ldc 245
    //   695: putfield 78	com/tencent/mobileqq/data/CustomEmotionData:RomaingType	Ljava/lang/String;
    //   698: aload 9
    //   700: aload 11
    //   702: invokeinterface 317 2 0
    //   707: pop
    //   708: aload_0
    //   709: invokevirtual 378	ancg:b	()V
    //   712: iconst_1
    //   713: istore_1
    //   714: goto -84 -> 630
    //   717: aload_0
    //   718: invokevirtual 379	ancg:a	()V
    //   721: iload_2
    //   722: ifeq +10 -> 732
    //   725: aload_0
    //   726: aload 8
    //   728: iconst_2
    //   729: invokevirtual 382	ancg:a	(Ljava/util/List;I)V
    //   732: aload 8
    //   734: ifnonnull +71 -> 805
    //   737: new 297	java/util/ArrayList
    //   740: dup
    //   741: invokespecial 298	java/util/ArrayList:<init>	()V
    //   744: astore 9
    //   746: aload 9
    //   748: astore 8
    //   750: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   753: ifeq -628 -> 125
    //   756: ldc 107
    //   758: iconst_2
    //   759: new 109	java/lang/StringBuilder
    //   762: dup
    //   763: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   766: ldc_w 384
    //   769: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: aload 9
    //   774: invokeinterface 237 1 0
    //   779: invokevirtual 322	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   782: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   785: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   788: aload 9
    //   790: astore 8
    //   792: goto -667 -> 125
    //   795: astore 8
    //   797: goto -131 -> 666
    //   800: astore 8
    //   802: goto -157 -> 645
    //   805: aload 8
    //   807: astore 9
    //   809: goto -63 -> 746
    //   812: goto -464 -> 348
    //   815: iload 5
    //   817: ifne -5 -> 812
    //   820: goto -333 -> 487
    //   823: astore 8
    //   825: iconst_0
    //   826: istore_2
    //   827: goto -161 -> 666
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	830	0	this	ancg
    //   205	509	1	i	int
    //   220	607	2	j	int
    //   316	167	3	k	int
    //   222	432	4	m	int
    //   209	607	5	n	int
    //   4	569	6	i1	int
    //   1	541	7	i2	int
    //   15	53	8	localArrayList	ArrayList
    //   80	48	8	localList	List<CustomEmotionData>
    //   236	328	8	localObject1	Object
    //   640	93	8	localException1	java.lang.Exception
    //   748	43	8	localObject2	Object
    //   795	1	8	localObject3	Object
    //   800	6	8	localException2	java.lang.Exception
    //   823	1	8	localObject4	Object
    //   38	770	9	localObject5	Object
    //   60	611	10	localObject6	Object
    //   150	551	11	localObject7	Object
    //   424	17	12	str	String
    // Exception table:
    //   from	to	target	type
    //   8	40	80	finally
    //   40	62	80	finally
    //   67	77	80	finally
    //   87	125	80	finally
    //   130	137	80	finally
    //   140	152	80	finally
    //   157	199	80	finally
    //   505	510	80	finally
    //   510	524	80	finally
    //   524	529	80	finally
    //   544	572	80	finally
    //   577	628	80	finally
    //   630	637	80	finally
    //   658	663	80	finally
    //   670	675	80	finally
    //   675	678	80	finally
    //   678	712	80	finally
    //   717	721	80	finally
    //   725	732	80	finally
    //   737	746	80	finally
    //   750	788	80	finally
    //   357	365	640	java/lang/Exception
    //   224	238	795	finally
    //   243	278	795	finally
    //   283	315	795	finally
    //   326	331	795	finally
    //   338	346	795	finally
    //   373	414	795	finally
    //   419	426	795	finally
    //   431	451	795	finally
    //   462	467	795	finally
    //   474	482	795	finally
    //   496	501	795	finally
    //   648	653	795	finally
    //   224	238	800	java/lang/Exception
    //   243	278	800	java/lang/Exception
    //   283	315	800	java/lang/Exception
    //   326	331	800	java/lang/Exception
    //   338	346	800	java/lang/Exception
    //   373	414	800	java/lang/Exception
    //   419	426	800	java/lang/Exception
    //   431	451	800	java/lang/Exception
    //   462	467	800	java/lang/Exception
    //   474	482	800	java/lang/Exception
    //   496	501	800	java/lang/Exception
    //   357	365	823	finally
  }
  
  public List<String> a(List<String> paramList1, List<String> paramList2)
  {
    if ((paramList1 == null) && (paramList2 == null)) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return null;
      } while ((paramList1 != null) && (paramList1.size() < 1));
      localArrayList = new ArrayList();
      if (paramList1 != null) {
        localArrayList.addAll(paramList1);
      }
      if (paramList2 != null) {
        localArrayList.addAll(paramList2);
      }
      paramList2 = a("isUpdate");
    } while (paramList2 == null);
    paramList1 = new ArrayList();
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      String str = (String)paramList2.next();
      if (!localArrayList.contains(str)) {
        paramList1.add(str);
      }
    }
    return paramList1;
  }
  
  public List<CustomEmotionData> a(List<String> paramList1, List<String> paramList2, String paramString, List<Integer> paramList)
  {
    Object localObject1 = new ArrayList();
    List localList = a(paramList1, paramList2);
    if ((localList != null) && (localList.size() > 0))
    {
      ((List)localObject1).addAll(localList);
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 1, "localUpdatedNotInServerList=" + localList.size());
      }
    }
    if ((paramList1 != null) && (paramList1.size() > 0)) {
      ((List)localObject1).addAll(paramList1);
    }
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-1.");
    }
    Object localObject2;
    if (((List)localObject1).size() > 0)
    {
      paramList1 = new ArrayList();
      localList = a();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = a(localList, (String)((Iterator)localObject1).next());
        if (localObject2 != null) {
          paramList1.add(localObject2);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 1, "deleDatas=" + paramList1.size());
      }
      a(paramList1);
    }
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-2.");
    }
    localList = a();
    int i;
    int j;
    if (localList != null)
    {
      paramList1 = localList.iterator();
      i = 1;
      j = i;
      if (!paramList1.hasNext()) {
        break label321;
      }
      localObject1 = (CustomEmotionData)paramList1.next();
      if (i >= ((CustomEmotionData)localObject1).emoId) {
        break label1282;
      }
      i = ((CustomEmotionData)localObject1).emoId;
    }
    label1282:
    for (;;)
    {
      break;
      j = 1;
      label321:
      if (QLog.isColorLevel()) {
        QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-3.");
      }
      localObject1 = new ArrayList();
      if (paramList2 != null)
      {
        localObject2 = a();
        int k = 0;
        i = j;
        j = k;
        if (j < paramList2.size())
        {
          String str = (String)paramList2.get(j);
          paramList1 = a((List)localObject2, str);
          boolean bool1;
          if (paramList1 == null)
          {
            boolean bool2 = false;
            bool1 = bool2;
            if (paramList != null)
            {
              bool1 = bool2;
              if (j <= paramList.size())
              {
                if (((Integer)paramList.get(j)).intValue() != 2) {
                  break label492;
                }
                bool1 = true;
              }
            }
            label453:
            i += 1;
            paramList1 = a(str, paramString, "needDownload", i, bool1);
          }
          for (;;)
          {
            ((List)localObject1).add(paramList1);
            j += 1;
            break;
            label492:
            bool1 = false;
            break label453;
            if (localList != null)
            {
              if ("init".equals(paramList1.RomaingType)) {
                paramList1.RomaingType = "isUpdate";
              }
              if ((TextUtils.isEmpty(paramList1.url)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FavroamingDBManager", 2, "url is null because of old db data exception, fix it");
                }
                paramList1.url = ance.a(str, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
              }
              localList.remove(paramList1);
            }
          }
        }
      }
      if ((localList != null) && (localList.size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingDBManager", 1, "localNew=" + localList.size());
        }
        ((List)localObject1).addAll(localList);
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 1, "mergeSize=" + ((List)localObject1).size());
      }
      if (((List)localObject1).size() > ance.b) {}
      for (paramList1 = ((List)localObject1).subList(0, ance.b);; paramList1 = (List<String>)localObject1)
      {
        i = 0;
        if (i < paramList1.size())
        {
          paramList2 = (CustomEmotionData)paramList1.get(i);
          if (QLog.isColorLevel()) {
            QLog.d("FavroamingDBManager", 2, "local emo: " + paramList2);
          }
          if (i <= ance.a) {
            if (paramList2.RomaingType != null) {
              if (paramList2.RomaingType.equals("overflow_downloaded")) {
                paramList2.RomaingType = "isUpdate";
              }
            }
          }
          for (;;)
          {
            if ((!TextUtils.isEmpty(paramList2.url)) && (paramList2.url.startsWith("http://"))) {
              paramList2.url = paramList2.url.replace("http://", "https://");
            }
            i += 1;
            break;
            if ((!paramList2.RomaingType.equals("isUpdate")) && (!paramList2.RomaingType.equals("init")) && (!paramList2.RomaingType.equals("needUpload")) && (!paramList2.RomaingType.equals("failed")))
            {
              paramList2.RomaingType = "needDownload";
              continue;
              paramList2.RomaingType = "needDownload";
              continue;
              if (i <= ance.b) {
                if (paramList2.RomaingType != null)
                {
                  if (paramList2.RomaingType.equals("isUpdate")) {
                    paramList2.RomaingType = "overflow_downloaded";
                  } else if ((!paramList2.RomaingType.equals("overflow_downloaded")) && (!paramList2.RomaingType.equals("init")) && (!paramList2.RomaingType.equals("needUpload")) && (!paramList2.RomaingType.equals("failed"))) {
                    paramList2.RomaingType = "overflow";
                  }
                }
                else {
                  paramList2.RomaingType = "overflow";
                }
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-4.");
        }
        paramList2 = a();
        i = 0;
        if (paramList2 != null)
        {
          i = paramList2.size();
          a(paramList2);
        }
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramList1);
        a(paramList1, 1);
        if (QLog.isColorLevel()) {
          QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-4.");
        }
        paramList2 = (ajhx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(72);
        if (paramList1.size() > 0) {
          paramList2.a(paramList1, 2);
        }
        j = 0;
        if (localList != null)
        {
          j = localList.size() - 1;
          while (j >= 0)
          {
            paramList2 = (CustomEmotionData)localList.get(j);
            if ((paramList2 != null) && (!paramList1.contains(paramList2))) {
              localList.remove(j);
            }
            j -= 1;
          }
          j = localList.size();
        }
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingDBManager", 2, "updateFavEmotionsInLocalEx final cache size: " + paramList1.size() + ",delete size:" + i + ",upload size:" + j);
        }
        return localList;
      }
    }
  }
  
  public boolean a(CustomEmotionData paramCustomEmotionData, int paramInt)
  {
    if (paramCustomEmotionData == null) {}
    while (!"needDel".equals(paramCustomEmotionData.RomaingType)) {
      return false;
    }
    if (paramInt <= ance.a) {}
    for (Object localObject = "isUpdate";; localObject = "overflow_downloaded")
    {
      paramCustomEmotionData.RomaingType = ((String)localObject);
      b(paramCustomEmotionData);
      localObject = (anch)a();
      if (localObject != null) {
        ((anch)localObject).d(paramCustomEmotionData);
      }
      return true;
    }
  }
  
  public List<anht> b()
  {
    baio.a("AIO_EmoticonPanel_Refresh", null);
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from getFavEmotionInfoShowedInPanel.");
    }
    List localList = a();
    ArrayList localArrayList = new ArrayList();
    if (localList != null) {}
    for (;;)
    {
      int i;
      Object localObject1;
      Object localObject2;
      try
      {
        i = localList.size() - 1;
        if (i >= 0)
        {
          localObject1 = (CustomEmotionData)localList.get(i);
          if ("needDel".equals(((CustomEmotionData)localObject1).RomaingType))
          {
            QLog.d("FavroamingDBManager", 1, "data need delete, do not need display -> resId:" + ((CustomEmotionData)localObject1).resid);
          }
          else
          {
            localObject2 = a((CustomEmotionData)localObject1);
            if ((localObject2 instanceof anla))
            {
              localObject2 = (anla)localObject2;
              if (((anla)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) {
                localArrayList.add(localObject2);
              }
            }
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("FavroamingDBManager", 1, "syncGetCustomEmotionInfoShowedInPanel oom");
        baio.a(null, "AIO_EmoticonPanel_Refresh");
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 2, "getFavEmotionInfoShowedInPanel, display size:" + localArrayList.size());
      }
      return localArrayList;
      QLog.e("FavroamingDBManager", 1, "PicEmoticonInfo.emoticon is null, " + ((CustomEmotionData)localObject1).toString());
      break label322;
      if ((localObject2 instanceof ankl))
      {
        localObject1 = (ankl)localObject2;
        if ((TextUtils.isEmpty(((ankl)localObject1).jdField_d_of_type_JavaLangString)) && (TextUtils.isEmpty(((ankl)localObject1).e))) {
          QLog.e("FavroamingDBManager", 1, "path and url is null! " + ((ankl)localObject1).toString());
        } else {
          localArrayList.add(localObject1);
        }
      }
      label322:
      i -= 1;
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      ancf.a(false, 8, 0);
    }
  }
  
  public void b(List<CustomEmotionData> paramList)
  {
    if (paramList == null) {
      return;
    }
    a(paramList);
  }
  
  protected List<anht> c()
  {
    Map localMap = ((andn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(141)).a();
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from syncGetCustomEmotionInfoShowedInPreview.");
    }
    List localList = a();
    ArrayList localArrayList = new ArrayList();
    if (localList != null) {}
    for (;;)
    {
      int i;
      CustomEmotionData localCustomEmotionData;
      try
      {
        i = localList.size() - 1;
        if (i >= 0)
        {
          localCustomEmotionData = (CustomEmotionData)localList.get(i);
          if (!"isUpdate".equals(localCustomEmotionData.RomaingType))
          {
            QLog.d("FavroamingDBManager", 1, "data need hidden, do not need display -> resId:" + localCustomEmotionData.resid);
          }
          else if (localCustomEmotionData.isMarkFace)
          {
            localObject = new anla(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            ((anla)localObject).jdField_c_of_type_Int = 6;
            String str1 = localCustomEmotionData.eId;
            String str2 = localCustomEmotionData.emoPath;
            ((anla)localObject).jdField_c_of_type_Boolean = localCustomEmotionData.isAPNG;
            ((anla)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticon = ((arnz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(str2, str1);
            ((anla)localObject).jdField_d_of_type_Int = 2;
            if (((anla)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) {
              localArrayList.add(localObject);
            }
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("FavroamingDBManager", 1, "syncGetCustomEmotionInfoShowedInPreview oom");
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 2, "syncGetCustomEmotionInfoShowedInPreview, display size:" + localArrayList.size());
      }
      return localArrayList;
      QLog.e("FavroamingDBManager", 1, "PicEmoticonInfo.emoticon is null, " + localCustomEmotionData.toString());
      break label471;
      Object localObject = new ankl();
      ((ankl)localObject).jdField_c_of_type_Int = 4;
      ((ankl)localObject).jdField_d_of_type_JavaLangString = a(localCustomEmotionData);
      ((ankl)localObject).jdField_d_of_type_Int = 2;
      ((ankl)localObject).jdField_c_of_type_JavaLangString = localCustomEmotionData.eId;
      ((ankl)localObject).e = localCustomEmotionData.url;
      ((ankl)localObject).jdField_a_of_type_JavaLangString = ankl.a(localOutOfMemoryError, localCustomEmotionData.md5);
      ((ankl)localObject).jdField_g_of_type_JavaLangString = localCustomEmotionData.RomaingType;
      ((ankl)localObject).jdField_g_of_type_Int = localCustomEmotionData.emoId;
      ((ankl)localObject).f = localCustomEmotionData.resid;
      if ((TextUtils.isEmpty(((ankl)localObject).jdField_d_of_type_JavaLangString)) && (TextUtils.isEmpty(((ankl)localObject).e))) {
        QLog.e("FavroamingDBManager", 1, "path and url is null! " + ((ankl)localObject).toString());
      } else {
        localArrayList.add(localObject);
      }
      label471:
      i -= 1;
    }
  }
  
  public void c(List<String> paramList)
  {
    if (paramList == null) {}
    List localList;
    do
    {
      return;
      localList = b("needDel");
    } while (localList == null);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      String str = (String)paramList.get(i);
      int j = 0;
      while (j < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(j);
        if ((localCustomEmotionData.resid != null) && (!"".equals(localCustomEmotionData.resid)) && (localCustomEmotionData.resid.equals(str)))
        {
          b(localCustomEmotionData, 4);
          localArrayList.add(localCustomEmotionData);
        }
        j += 1;
      }
      i += 1;
    }
    a(localArrayList, 4);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ancf.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ancg
 * JD-Core Version:    0.7.0.1
 */