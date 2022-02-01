package com.tencent.mobileqq.activity.aio.anim;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.anim.egg.EggKeyword;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ListUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;

public class AioAnimationConfigHelper
{
  private static volatile AioAnimationConfigHelper jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationConfigHelper;
  public static final String a;
  public static final String b;
  public static final String c;
  private ArrayList<AioAnimationRule> jdField_a_of_type_JavaUtilArrayList;
  
  static
  {
    Object localObject = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((Context)localObject).getFilesDir().getAbsoluteFile());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("animConfig/");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("eggs.xml");
    jdField_b_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("eggs_wrapper.xml");
    jdField_c_of_type_JavaLangString = ((StringBuilder)localObject).toString();
  }
  
  private long a(String paramString)
  {
    try
    {
      long l = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(paramString, new ParsePosition(0)).getTime();
      return l;
    }
    catch (Throwable paramString)
    {
      QLog.e("AioAnimationConfigHelper", 1, paramString, new Object[0]);
    }
    return 0L;
  }
  
  public static AioAnimationConfigHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationConfigHelper == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationConfigHelper == null) {
          jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationConfigHelper = new AioAnimationConfigHelper();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationConfigHelper;
  }
  
  @Nullable
  private AioAnimationRule a(ArrayList<AioAnimationRule> paramArrayList, int paramInt)
  {
    if (paramInt >= 0)
    {
      if (ListUtils.a(paramArrayList)) {
        return null;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        AioAnimationRule localAioAnimationRule = (AioAnimationRule)paramArrayList.next();
        if (localAioAnimationRule.jdField_b_of_type_Int == paramInt) {
          return localAioAnimationRule;
        }
      }
    }
    return null;
  }
  
  private ArrayList<AioAnimationRule> a(XmlPullParser paramXmlPullParser)
  {
    if (paramXmlPullParser == null) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    int i = paramXmlPullParser.getEventType();
    Object localObject2 = null;
    Object localObject1;
    for (Object localObject4 = localObject2;; localObject4 = localObject1)
    {
      boolean bool = true;
      if (i == 1) {
        break;
      }
      Object localObject5;
      Object localObject3;
      if (i == 2)
      {
        localObject5 = paramXmlPullParser.getName();
        if (((String)localObject5).equalsIgnoreCase("Item"))
        {
          localObject3 = paramXmlPullParser.getAttributeValue(null, "id");
          localObject1 = new AioAnimationRule();
          ((AioAnimationRule)localObject1).jdField_b_of_type_Int = Integer.parseInt((String)localObject3);
          localObject3 = localObject2;
        }
        else if (((String)localObject5).equalsIgnoreCase("BusinessItem"))
        {
          localObject3 = paramXmlPullParser.getAttributeValue(null, "id");
          localObject1 = new AioAnimationRule();
          ((AioAnimationRule)localObject1).jdField_b_of_type_Int = Integer.parseInt((String)localObject3);
          ((AioAnimationRule)localObject1).jdField_a_of_type_Int = 8;
          localObject3 = localObject2;
        }
        else if (((String)localObject5).equalsIgnoreCase("Keywords"))
        {
          localObject1 = paramXmlPullParser.getAttributeValue(null, "type");
          localObject5 = new EggKeyword(paramXmlPullParser.nextText(), EggKeyword.a((String)localObject1));
          localObject3 = localObject2;
          localObject1 = localObject4;
          if (localObject4 != null)
          {
            localObject3 = localObject2;
            localObject1 = localObject4;
            if (!TextUtils.isEmpty(((EggKeyword)localObject5).a()))
            {
              if (localObject4.jdField_a_of_type_JavaUtilArrayList == null) {
                localObject4.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
              }
              localObject4.jdField_a_of_type_JavaUtilArrayList.add(localObject5);
              localObject3 = localObject2;
              localObject1 = localObject4;
            }
          }
        }
        else if (((String)localObject5).equalsIgnoreCase("FloorLimit"))
        {
          localObject5 = paramXmlPullParser.nextText();
          localObject3 = localObject2;
          localObject1 = localObject4;
          if (localObject4 != null)
          {
            localObject4.d = Integer.parseInt((String)localObject5);
            localObject3 = localObject2;
            localObject1 = localObject4;
          }
        }
        else if (((String)localObject5).equalsIgnoreCase("JumpLimit"))
        {
          localObject5 = paramXmlPullParser.nextText();
          localObject3 = localObject2;
          localObject1 = localObject4;
          if (localObject4 != null)
          {
            localObject4.e = Integer.parseInt((String)localObject5);
            localObject3 = localObject2;
            localObject1 = localObject4;
          }
        }
        else if (((String)localObject5).equalsIgnoreCase("IsCrazyMode"))
        {
          localObject5 = paramXmlPullParser.nextText();
          localObject3 = localObject2;
          localObject1 = localObject4;
          if (localObject4 != null) {
            if (((String)localObject5).equalsIgnoreCase("true"))
            {
              localObject4.jdField_a_of_type_Boolean = true;
              localObject3 = localObject2;
              localObject1 = localObject4;
            }
            else
            {
              localObject3 = localObject2;
              localObject1 = localObject4;
              if (((String)localObject5).equalsIgnoreCase("false"))
              {
                localObject4.jdField_a_of_type_Boolean = false;
                localObject3 = localObject2;
                localObject1 = localObject4;
              }
            }
          }
        }
        else if (((String)localObject5).equalsIgnoreCase("JumpImage"))
        {
          a(paramXmlPullParser, localObject4);
          localObject3 = localObject2;
          localObject1 = localObject4;
        }
        else if (((String)localObject5).equalsIgnoreCase("businessData"))
        {
          localObject3 = localObject2;
          localObject1 = localObject4;
          if (localObject4 != null)
          {
            localObject4.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData = new AioAnimationRule.BussinessData();
            localObject1 = paramXmlPullParser.getAttributeValue(null, "bid");
            localObject3 = paramXmlPullParser.getAttributeValue(null, "startTs");
            localObject5 = paramXmlPullParser.getAttributeValue(null, "endTs");
            String str1 = paramXmlPullParser.getAttributeValue(null, "actId");
            String str2 = paramXmlPullParser.getAttributeValue(null, "timeDelay");
            localObject4.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData.jdField_a_of_type_Int = Integer.parseInt((String)localObject1);
            localObject4.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData.jdField_b_of_type_Int = Integer.parseInt((String)localObject3);
            localObject4.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData.jdField_c_of_type_Int = Integer.parseInt((String)localObject5);
            localObject4.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData.e = Integer.parseInt(str2);
            localObject4.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData.d = Integer.parseInt(str1);
            localObject3 = localObject2;
            localObject1 = localObject4;
          }
        }
        else if (((String)localObject5).equalsIgnoreCase("type"))
        {
          localObject3 = localObject2;
          localObject1 = localObject4;
          if (localObject4 != null)
          {
            localObject5 = paramXmlPullParser.nextText();
            localObject3 = localObject2;
            localObject1 = localObject4;
            if (!TextUtils.isEmpty((CharSequence)localObject5)) {
              if (((String)localObject5).equalsIgnoreCase("DigitEgg"))
              {
                localObject4.jdField_a_of_type_Int = 9;
                localObject3 = localObject2;
                localObject1 = localObject4;
              }
              else
              {
                localObject3 = localObject2;
                localObject1 = localObject4;
                if (((String)localObject5).equalsIgnoreCase("LongWang"))
                {
                  localObject4.jdField_a_of_type_Int = 7;
                  localObject3 = localObject2;
                  localObject1 = localObject4;
                }
              }
            }
          }
        }
        else if (((String)localObject5).equalsIgnoreCase("StartTime"))
        {
          localObject3 = localObject2;
          localObject1 = localObject4;
          if (localObject4 != null)
          {
            localObject4.jdField_a_of_type_Long = a(paramXmlPullParser.nextText());
            localObject3 = localObject2;
            localObject1 = localObject4;
          }
        }
        else
        {
          localObject3 = localObject2;
          localObject1 = localObject4;
          if (((String)localObject5).equalsIgnoreCase("EndTime"))
          {
            localObject3 = localObject2;
            localObject1 = localObject4;
            if (localObject4 != null)
            {
              localObject4.jdField_b_of_type_Long = a(paramXmlPullParser.nextText());
              localObject3 = localObject2;
              localObject1 = localObject4;
            }
          }
        }
      }
      else
      {
        localObject3 = localObject2;
        localObject1 = localObject4;
        if (i == 3)
        {
          localObject5 = paramXmlPullParser.getName();
          if (!((String)localObject5).equalsIgnoreCase("Item"))
          {
            localObject3 = localObject2;
            localObject1 = localObject4;
            if (!((String)localObject5).equalsIgnoreCase("BusinessItem")) {}
          }
          else
          {
            localObject3 = localObject2;
            if (localObject2 == null) {
              localObject3 = new ArrayList();
            }
            if (localObject4 != null)
            {
              if (((localObject4.d != 0) || (localObject4.e != 0)) && (localObject4.e <= localObject4.d)) {
                bool = false;
              }
              if (bool) {
                ((ArrayList)localObject3).add(localObject4);
              }
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("<== Item, id = ");
                ((StringBuilder)localObject1).append(localObject4.jdField_b_of_type_Int);
                ((StringBuilder)localObject1).append(",isValid = ");
                ((StringBuilder)localObject1).append(bool);
                ((StringBuilder)localObject1).append("keywords:");
                ((StringBuilder)localObject1).append(localObject4.jdField_a_of_type_JavaUtilArrayList.toString());
                QLog.d("AioAnimationConfigHelper", 2, ((StringBuilder)localObject1).toString());
              }
            }
            localObject1 = null;
          }
        }
      }
      i = paramXmlPullParser.next();
      localObject2 = localObject3;
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      paramXmlPullParser = new StringBuilder();
      paramXmlPullParser.append("doParseRules :  cost time:");
      paramXmlPullParser.append(l2 - l1);
      paramXmlPullParser.append("ms");
      QLog.d("AioAnimationConfigHelper", 2, paramXmlPullParser.toString());
    }
    return localObject2;
  }
  
  private void a(XmlPullParser paramXmlPullParser, AioAnimationRule paramAioAnimationRule)
  {
    String str1 = paramXmlPullParser.getAttributeValue(null, "type");
    Object localObject = paramXmlPullParser.getAttributeValue(null, "count");
    String str2 = paramXmlPullParser.getAttributeValue(null, "frequent");
    String str3 = paramXmlPullParser.getAttributeValue(null, "position");
    String str4 = paramXmlPullParser.getAttributeValue(null, "background");
    String str5 = paramXmlPullParser.getAttributeValue(null, "duration");
    paramXmlPullParser = paramXmlPullParser.nextText();
    int i;
    if (localObject != null) {
      i = Integer.parseInt((String)localObject);
    } else {
      i = 1;
    }
    while (i > 0)
    {
      localObject = new AioAnimationRule.JumpImage();
      if (str1 != null) {
        ((AioAnimationRule.JumpImage)localObject).jdField_c_of_type_Int = AioAnimationRule.JumpImage.a(str1);
      }
      ((AioAnimationRule.JumpImage)localObject).e = paramXmlPullParser;
      ((AioAnimationRule.JumpImage)localObject).jdField_a_of_type_JavaLangString = str2;
      ((AioAnimationRule.JumpImage)localObject).jdField_b_of_type_JavaLangString = str3;
      ((AioAnimationRule.JumpImage)localObject).jdField_c_of_type_JavaLangString = str4;
      ((AioAnimationRule.JumpImage)localObject).d = str5;
      if (paramAioAnimationRule != null)
      {
        if (paramAioAnimationRule.jdField_b_of_type_JavaUtilArrayList == null) {
          paramAioAnimationRule.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
        }
        paramAioAnimationRule.jdField_b_of_type_JavaUtilArrayList.add(localObject);
      }
      i -= 1;
    }
  }
  
  private void a(XmlPullParser paramXmlPullParser, ArrayList<AioAnimationRule> paramArrayList)
  {
    if (paramXmlPullParser == null) {
      return;
    }
    long l1 = SystemClock.elapsedRealtime();
    int n = paramXmlPullParser.getEventType();
    int k = -1;
    Object localObject4 = "";
    Object localObject3 = localObject4;
    int m = 0;
    while (n != 1)
    {
      Object localObject5;
      int j;
      Object localObject1;
      Object localObject2;
      int i;
      if (n == 2)
      {
        localObject5 = paramXmlPullParser.getName();
        if (((String)localObject5).equalsIgnoreCase("Item"))
        {
          j = Integer.valueOf(paramXmlPullParser.getAttributeValue(null, "id")).intValue();
          localObject1 = "";
          localObject2 = localObject1;
          i = 0;
        }
        else if (((String)localObject5).equalsIgnoreCase("JumpUrl"))
        {
          localObject1 = paramXmlPullParser.nextText();
          j = k;
          i = m;
          localObject2 = localObject3;
        }
        else if (((String)localObject5).equalsIgnoreCase("LargeCount"))
        {
          i = Integer.valueOf(paramXmlPullParser.nextText()).intValue();
          j = k;
          localObject1 = localObject4;
          localObject2 = localObject3;
        }
        else
        {
          j = k;
          localObject1 = localObject4;
          i = m;
          localObject2 = localObject3;
          if (((String)localObject5).equalsIgnoreCase("JumpType"))
          {
            localObject2 = paramXmlPullParser.nextText();
            j = k;
            localObject1 = localObject4;
            i = m;
          }
        }
      }
      else
      {
        j = k;
        localObject1 = localObject4;
        i = m;
        localObject2 = localObject3;
        if (n == 3)
        {
          j = k;
          localObject1 = localObject4;
          i = m;
          localObject2 = localObject3;
          if (paramXmlPullParser.getName().equalsIgnoreCase("Item"))
          {
            localObject5 = a(paramArrayList, k);
            j = k;
            localObject1 = localObject4;
            i = m;
            localObject2 = localObject3;
            if (localObject5 != null)
            {
              ((AioAnimationRule)localObject5).jdField_a_of_type_JavaLangString = ((String)localObject4);
              ((AioAnimationRule)localObject5).a(m);
              ((AioAnimationRule)localObject5).jdField_b_of_type_JavaLangString = localObject3;
              localObject2 = localObject3;
              i = m;
              localObject1 = localObject4;
              j = k;
            }
          }
        }
      }
      n = paramXmlPullParser.next();
      k = j;
      localObject4 = localObject1;
      m = i;
      localObject3 = localObject2;
    }
    long l2 = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel())
    {
      paramXmlPullParser = new StringBuilder();
      paramXmlPullParser.append("doParseRulesWrapper :  cost time:");
      paramXmlPullParser.append(l2 - l1);
      paramXmlPullParser.append("ms");
      QLog.d("AioAnimationConfigHelper", 2, paramXmlPullParser.toString());
    }
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aload_3
    //   9: astore_2
    //   10: new 32	java/io/File
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 360	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore_1
    //   19: aload_3
    //   20: astore_2
    //   21: aload_1
    //   22: invokevirtual 363	java/io/File:exists	()Z
    //   25: ifeq +147 -> 172
    //   28: aload_3
    //   29: astore_2
    //   30: aload_1
    //   31: invokevirtual 366	java/io/File:isFile	()Z
    //   34: ifne +6 -> 40
    //   37: goto +135 -> 172
    //   40: aload_3
    //   41: astore_2
    //   42: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +50 -> 95
    //   48: aload_3
    //   49: astore_2
    //   50: new 21	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   57: astore 6
    //   59: aload_3
    //   60: astore_2
    //   61: aload 6
    //   63: ldc_w 368
    //   66: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_3
    //   71: astore_2
    //   72: aload 6
    //   74: aload_1
    //   75: invokevirtual 371	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   78: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_3
    //   83: astore_2
    //   84: ldc 96
    //   86: iconst_2
    //   87: aload 6
    //   89: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aload_3
    //   96: astore_2
    //   97: new 373	java/io/FileInputStream
    //   100: dup
    //   101: aload_1
    //   102: invokespecial 376	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   105: astore_1
    //   106: invokestatic 382	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   109: invokevirtual 386	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   112: astore_2
    //   113: aload_2
    //   114: aload_1
    //   115: ldc_w 388
    //   118: invokeinterface 392 3 0
    //   123: aload_0
    //   124: aload_2
    //   125: invokespecial 394	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:a	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/util/ArrayList;
    //   128: astore_2
    //   129: aload_1
    //   130: invokevirtual 397	java/io/FileInputStream:close	()V
    //   133: aload_2
    //   134: ifnull +22 -> 156
    //   137: aload_0
    //   138: aload_2
    //   139: putfield 398	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   142: aload_0
    //   143: getstatic 61	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   146: aload_0
    //   147: getfield 398	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   150: invokespecial 401	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:a	(Ljava/lang/String;Ljava/util/ArrayList;)Z
    //   153: pop
    //   154: iconst_1
    //   155: ireturn
    //   156: iconst_0
    //   157: ireturn
    //   158: astore_3
    //   159: aload_1
    //   160: astore_2
    //   161: goto +140 -> 301
    //   164: astore_3
    //   165: goto +72 -> 237
    //   168: astore_3
    //   169: goto +102 -> 271
    //   172: aload_3
    //   173: astore_2
    //   174: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +50 -> 227
    //   180: aload_3
    //   181: astore_2
    //   182: new 21	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   189: astore 6
    //   191: aload_3
    //   192: astore_2
    //   193: aload 6
    //   195: ldc_w 403
    //   198: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload_3
    //   203: astore_2
    //   204: aload 6
    //   206: aload_1
    //   207: invokevirtual 371	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   210: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload_3
    //   215: astore_2
    //   216: ldc 96
    //   218: iconst_2
    //   219: aload 6
    //   221: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: iconst_0
    //   228: ireturn
    //   229: astore_3
    //   230: goto +71 -> 301
    //   233: astore_3
    //   234: aload 4
    //   236: astore_1
    //   237: aload_1
    //   238: astore_2
    //   239: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq +15 -> 257
    //   245: aload_1
    //   246: astore_2
    //   247: ldc 96
    //   249: iconst_2
    //   250: ldc_w 407
    //   253: aload_3
    //   254: invokestatic 410	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   257: aload_1
    //   258: ifnull +7 -> 265
    //   261: aload_1
    //   262: invokevirtual 397	java/io/FileInputStream:close	()V
    //   265: iconst_0
    //   266: ireturn
    //   267: astore_3
    //   268: aload 5
    //   270: astore_1
    //   271: aload_1
    //   272: astore_2
    //   273: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq +15 -> 291
    //   279: aload_1
    //   280: astore_2
    //   281: ldc 96
    //   283: iconst_2
    //   284: ldc_w 407
    //   287: aload_3
    //   288: invokestatic 410	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   291: aload_1
    //   292: ifnull +7 -> 299
    //   295: aload_1
    //   296: invokevirtual 397	java/io/FileInputStream:close	()V
    //   299: iconst_0
    //   300: ireturn
    //   301: aload_2
    //   302: ifnull +7 -> 309
    //   305: aload_2
    //   306: invokevirtual 397	java/io/FileInputStream:close	()V
    //   309: aload_3
    //   310: athrow
    //   311: astore_1
    //   312: goto -179 -> 133
    //   315: astore_1
    //   316: iconst_0
    //   317: ireturn
    //   318: astore_1
    //   319: iconst_0
    //   320: ireturn
    //   321: astore_1
    //   322: goto -13 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	this	AioAnimationConfigHelper
    //   0	325	1	paramString	String
    //   9	297	2	localObject1	Object
    //   7	89	3	localObject2	Object
    //   158	1	3	localObject3	Object
    //   164	1	3	localOutOfMemoryError1	OutOfMemoryError
    //   168	47	3	localException1	Exception
    //   229	1	3	localObject4	Object
    //   233	21	3	localOutOfMemoryError2	OutOfMemoryError
    //   267	43	3	localException2	Exception
    //   1	234	4	localObject5	Object
    //   4	265	5	localObject6	Object
    //   57	163	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   106	129	158	finally
    //   106	129	164	java/lang/OutOfMemoryError
    //   106	129	168	java/lang/Exception
    //   10	19	229	finally
    //   21	28	229	finally
    //   30	37	229	finally
    //   42	48	229	finally
    //   50	59	229	finally
    //   61	70	229	finally
    //   72	82	229	finally
    //   84	95	229	finally
    //   97	106	229	finally
    //   174	180	229	finally
    //   182	191	229	finally
    //   193	202	229	finally
    //   204	214	229	finally
    //   216	227	229	finally
    //   239	245	229	finally
    //   247	257	229	finally
    //   273	279	229	finally
    //   281	291	229	finally
    //   10	19	233	java/lang/OutOfMemoryError
    //   21	28	233	java/lang/OutOfMemoryError
    //   30	37	233	java/lang/OutOfMemoryError
    //   42	48	233	java/lang/OutOfMemoryError
    //   50	59	233	java/lang/OutOfMemoryError
    //   61	70	233	java/lang/OutOfMemoryError
    //   72	82	233	java/lang/OutOfMemoryError
    //   84	95	233	java/lang/OutOfMemoryError
    //   97	106	233	java/lang/OutOfMemoryError
    //   174	180	233	java/lang/OutOfMemoryError
    //   182	191	233	java/lang/OutOfMemoryError
    //   193	202	233	java/lang/OutOfMemoryError
    //   204	214	233	java/lang/OutOfMemoryError
    //   216	227	233	java/lang/OutOfMemoryError
    //   10	19	267	java/lang/Exception
    //   21	28	267	java/lang/Exception
    //   30	37	267	java/lang/Exception
    //   42	48	267	java/lang/Exception
    //   50	59	267	java/lang/Exception
    //   61	70	267	java/lang/Exception
    //   72	82	267	java/lang/Exception
    //   84	95	267	java/lang/Exception
    //   97	106	267	java/lang/Exception
    //   174	180	267	java/lang/Exception
    //   182	191	267	java/lang/Exception
    //   193	202	267	java/lang/Exception
    //   204	214	267	java/lang/Exception
    //   216	227	267	java/lang/Exception
    //   129	133	311	java/io/IOException
    //   261	265	315	java/io/IOException
    //   295	299	318	java/io/IOException
    //   305	309	321	java/io/IOException
  }
  
  /* Error */
  private boolean a(String paramString, ArrayList<AioAnimationRule> paramArrayList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: aload 6
    //   11: astore_3
    //   12: new 32	java/io/File
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 360	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_1
    //   21: aload 6
    //   23: astore_3
    //   24: aload_1
    //   25: invokevirtual 363	java/io/File:exists	()Z
    //   28: ifeq +131 -> 159
    //   31: aload 6
    //   33: astore_3
    //   34: aload_1
    //   35: invokevirtual 366	java/io/File:isFile	()Z
    //   38: ifne +6 -> 44
    //   41: goto +118 -> 159
    //   44: aload 6
    //   46: astore_3
    //   47: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq +54 -> 104
    //   53: aload 6
    //   55: astore_3
    //   56: new 21	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   63: astore 7
    //   65: aload 6
    //   67: astore_3
    //   68: aload 7
    //   70: ldc_w 412
    //   73: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 6
    //   79: astore_3
    //   80: aload 7
    //   82: aload_1
    //   83: invokevirtual 371	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   86: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 6
    //   92: astore_3
    //   93: ldc 96
    //   95: iconst_2
    //   96: aload 7
    //   98: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: aload 6
    //   106: astore_3
    //   107: new 373	java/io/FileInputStream
    //   110: dup
    //   111: aload_1
    //   112: invokespecial 376	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   115: astore_1
    //   116: invokestatic 382	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   119: invokevirtual 386	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   122: astore_3
    //   123: aload_3
    //   124: aload_1
    //   125: ldc_w 388
    //   128: invokeinterface 392 3 0
    //   133: aload_0
    //   134: aload_3
    //   135: aload_2
    //   136: invokespecial 414	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:a	(Lorg/xmlpull/v1/XmlPullParser;Ljava/util/ArrayList;)V
    //   139: aload_1
    //   140: invokestatic 419	com/tencent/mobileqq/utils/FileUtils:close	(Ljava/io/Closeable;)V
    //   143: iconst_1
    //   144: ireturn
    //   145: astore_2
    //   146: aload_1
    //   147: astore_3
    //   148: goto +137 -> 285
    //   151: astore_2
    //   152: goto +77 -> 229
    //   155: astore_2
    //   156: goto +103 -> 259
    //   159: aload 6
    //   161: astore_3
    //   162: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq +50 -> 215
    //   168: aload 6
    //   170: astore_3
    //   171: new 21	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   178: astore_2
    //   179: aload 6
    //   181: astore_3
    //   182: aload_2
    //   183: ldc_w 421
    //   186: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 6
    //   192: astore_3
    //   193: aload_2
    //   194: aload_1
    //   195: invokevirtual 371	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   198: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload 6
    //   204: astore_3
    //   205: ldc 96
    //   207: iconst_2
    //   208: aload_2
    //   209: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 405	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: aconst_null
    //   216: invokestatic 419	com/tencent/mobileqq/utils/FileUtils:close	(Ljava/io/Closeable;)V
    //   219: iconst_0
    //   220: ireturn
    //   221: astore_2
    //   222: goto +63 -> 285
    //   225: astore_2
    //   226: aload 4
    //   228: astore_1
    //   229: aload_1
    //   230: astore_3
    //   231: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   234: ifeq +15 -> 249
    //   237: aload_1
    //   238: astore_3
    //   239: ldc 96
    //   241: iconst_2
    //   242: ldc_w 423
    //   245: aload_2
    //   246: invokestatic 410	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   249: aload_1
    //   250: invokestatic 419	com/tencent/mobileqq/utils/FileUtils:close	(Ljava/io/Closeable;)V
    //   253: iconst_0
    //   254: ireturn
    //   255: astore_2
    //   256: aload 5
    //   258: astore_1
    //   259: aload_1
    //   260: astore_3
    //   261: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq +15 -> 279
    //   267: aload_1
    //   268: astore_3
    //   269: ldc 96
    //   271: iconst_2
    //   272: ldc_w 423
    //   275: aload_2
    //   276: invokestatic 410	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   279: aload_1
    //   280: invokestatic 419	com/tencent/mobileqq/utils/FileUtils:close	(Ljava/io/Closeable;)V
    //   283: iconst_0
    //   284: ireturn
    //   285: aload_3
    //   286: invokestatic 419	com/tencent/mobileqq/utils/FileUtils:close	(Ljava/io/Closeable;)V
    //   289: aload_2
    //   290: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	AioAnimationConfigHelper
    //   0	291	1	paramString	String
    //   0	291	2	paramArrayList	ArrayList<AioAnimationRule>
    //   11	275	3	localObject1	Object
    //   1	226	4	localObject2	Object
    //   4	253	5	localObject3	Object
    //   7	196	6	localObject4	Object
    //   63	34	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   116	139	145	finally
    //   116	139	151	java/lang/OutOfMemoryError
    //   116	139	155	java/lang/Exception
    //   12	21	221	finally
    //   24	31	221	finally
    //   34	41	221	finally
    //   47	53	221	finally
    //   56	65	221	finally
    //   68	77	221	finally
    //   80	90	221	finally
    //   93	104	221	finally
    //   107	116	221	finally
    //   162	168	221	finally
    //   171	179	221	finally
    //   182	190	221	finally
    //   193	202	221	finally
    //   205	215	221	finally
    //   231	237	221	finally
    //   239	249	221	finally
    //   261	267	221	finally
    //   269	279	221	finally
    //   12	21	225	java/lang/OutOfMemoryError
    //   24	31	225	java/lang/OutOfMemoryError
    //   34	41	225	java/lang/OutOfMemoryError
    //   47	53	225	java/lang/OutOfMemoryError
    //   56	65	225	java/lang/OutOfMemoryError
    //   68	77	225	java/lang/OutOfMemoryError
    //   80	90	225	java/lang/OutOfMemoryError
    //   93	104	225	java/lang/OutOfMemoryError
    //   107	116	225	java/lang/OutOfMemoryError
    //   162	168	225	java/lang/OutOfMemoryError
    //   171	179	225	java/lang/OutOfMemoryError
    //   182	190	225	java/lang/OutOfMemoryError
    //   193	202	225	java/lang/OutOfMemoryError
    //   205	215	225	java/lang/OutOfMemoryError
    //   12	21	255	java/lang/Exception
    //   24	31	255	java/lang/Exception
    //   34	41	255	java/lang/Exception
    //   47	53	255	java/lang/Exception
    //   56	65	255	java/lang/Exception
    //   68	77	255	java/lang/Exception
    //   80	90	255	java/lang/Exception
    //   93	104	255	java/lang/Exception
    //   107	116	255	java/lang/Exception
    //   162	168	255	java/lang/Exception
    //   171	179	255	java/lang/Exception
    //   182	190	255	java/lang/Exception
    //   193	202	255	java/lang/Exception
    //   205	215	255	java/lang/Exception
  }
  
  /* Error */
  private void b(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 96
    //   8: iconst_2
    //   9: ldc_w 427
    //   12: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_1
    //   16: invokevirtual 431	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   19: ldc_w 432
    //   22: invokevirtual 438	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   25: astore_3
    //   26: aconst_null
    //   27: astore_2
    //   28: aload_0
    //   29: aload_3
    //   30: invokespecial 394	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:a	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/util/ArrayList;
    //   33: astore_1
    //   34: aload_3
    //   35: invokeinterface 441 1 0
    //   40: goto +33 -> 73
    //   43: astore_1
    //   44: goto +39 -> 83
    //   47: astore 4
    //   49: aload_2
    //   50: astore_1
    //   51: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq -20 -> 34
    //   57: ldc 96
    //   59: iconst_2
    //   60: ldc_w 443
    //   63: aload 4
    //   65: invokestatic 410	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   68: aload_2
    //   69: astore_1
    //   70: goto -36 -> 34
    //   73: aload_1
    //   74: ifnull +8 -> 82
    //   77: aload_0
    //   78: aload_1
    //   79: putfield 398	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   82: return
    //   83: aload_3
    //   84: invokeinterface 441 1 0
    //   89: goto +5 -> 94
    //   92: aload_1
    //   93: athrow
    //   94: goto -2 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	AioAnimationConfigHelper
    //   0	97	1	paramContext	Context
    //   27	42	2	localObject	Object
    //   25	59	3	localXmlResourceParser	android.content.res.XmlResourceParser
    //   47	17	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   28	34	43	finally
    //   51	68	43	finally
    //   28	34	47	java/lang/Exception
  }
  
  public ArrayList<AioAnimationRule> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(Context paramContext)
  {
    if (FileUtils.fileExistsAndNotEmpty(jdField_b_of_type_JavaLangString))
    {
      boolean bool = a(jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseXmlFromOutside: success = ");
        localStringBuilder.append(bool);
        QLog.d("AioAnimationConfigHelper", 2, localStringBuilder.toString());
      }
      if (!bool) {
        b(paramContext);
      }
    }
    else
    {
      b(paramContext);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    int j = 0;
    int i;
    try
    {
      FileUtils.delete(jdField_a_of_type_JavaLangString, false);
      FileUtils.uncompressZip(paramString, jdField_a_of_type_JavaLangString, false);
      i = 1;
    }
    catch (OutOfMemoryError paramString)
    {
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.e("AioAnimationConfigHelper", 2, "pareseRulesFromZip :  uncompress OOM Error =>", paramString);
        i = j;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.e("AioAnimationConfigHelper", 2, "pareseRulesFromZip : delete and uncompress Exception=>", paramString);
        i = j;
      }
    }
    if (i != 0)
    {
      boolean bool = a(jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("pareseRulesFromZip : delete and uncompressZip success, parse from outside result = ");
        paramString.append(bool);
        QLog.d("AioAnimationConfigHelper", 2, paramString.toString());
      }
      if (bool)
      {
        paramQQAppInterface.getPreferences().edit().putLong("k_eggs_file_version", paramLong).commit();
        return;
      }
      b(paramQQAppInterface.getApplication());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AioAnimationConfigHelper", 2, "pareseRulesFromZip : delete and uncompressZip failure, parse from Res");
    }
    b(paramQQAppInterface.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AioAnimationConfigHelper
 * JD-Core Version:    0.7.0.1
 */