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
  public static final String a;
  public static final String b;
  public static final String c;
  private static volatile AioAnimationConfigHelper e;
  private ArrayList<AioAnimationRule> d;
  
  static
  {
    Object localObject = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((Context)localObject).getFilesDir().getAbsoluteFile());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("animConfig/");
    a = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a);
    ((StringBuilder)localObject).append("eggs.xml");
    b = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a);
    ((StringBuilder)localObject).append("eggs_wrapper.xml");
    c = ((StringBuilder)localObject).toString();
  }
  
  public static AioAnimationConfigHelper a()
  {
    if (e == null) {
      try
      {
        if (e == null) {
          e = new AioAnimationConfigHelper();
        }
      }
      finally {}
    }
    return e;
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
        if (localAioAnimationRule.b == paramInt) {
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
          ((AioAnimationRule)localObject1).b = Integer.parseInt((String)localObject3);
          localObject3 = localObject2;
        }
        else if (((String)localObject5).equalsIgnoreCase("BusinessItem"))
        {
          localObject3 = paramXmlPullParser.getAttributeValue(null, "id");
          localObject1 = new AioAnimationRule();
          ((AioAnimationRule)localObject1).b = Integer.parseInt((String)localObject3);
          ((AioAnimationRule)localObject1).a = 8;
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
              if (localObject4.c == null) {
                localObject4.c = new ArrayList();
              }
              localObject4.c.add(localObject5);
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
            localObject4.g = Integer.parseInt((String)localObject5);
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
            localObject4.h = Integer.parseInt((String)localObject5);
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
              localObject4.i = true;
              localObject3 = localObject2;
              localObject1 = localObject4;
            }
            else
            {
              localObject3 = localObject2;
              localObject1 = localObject4;
              if (((String)localObject5).equalsIgnoreCase("false"))
              {
                localObject4.i = false;
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
            localObject4.k = new AioAnimationRule.BussinessData();
            localObject1 = paramXmlPullParser.getAttributeValue(null, "bid");
            localObject3 = paramXmlPullParser.getAttributeValue(null, "startTs");
            localObject5 = paramXmlPullParser.getAttributeValue(null, "endTs");
            String str1 = paramXmlPullParser.getAttributeValue(null, "actId");
            String str2 = paramXmlPullParser.getAttributeValue(null, "timeDelay");
            localObject4.k.a = Integer.parseInt((String)localObject1);
            localObject4.k.b = Integer.parseInt((String)localObject3);
            localObject4.k.c = Integer.parseInt((String)localObject5);
            localObject4.k.e = Integer.parseInt(str2);
            localObject4.k.d = Integer.parseInt(str1);
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
                localObject4.a = 9;
                localObject3 = localObject2;
                localObject1 = localObject4;
              }
              else
              {
                localObject3 = localObject2;
                localObject1 = localObject4;
                if (((String)localObject5).equalsIgnoreCase("LongWang"))
                {
                  localObject4.a = 7;
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
            localObject4.d = b(paramXmlPullParser.nextText());
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
              localObject4.e = b(paramXmlPullParser.nextText());
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
              if (((localObject4.g != 0) || (localObject4.h != 0)) && (localObject4.h <= localObject4.g)) {
                bool = false;
              }
              if (bool) {
                ((ArrayList)localObject3).add(localObject4);
              }
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("<== Item, id = ");
                ((StringBuilder)localObject1).append(localObject4.b);
                ((StringBuilder)localObject1).append(",isValid = ");
                ((StringBuilder)localObject1).append(bool);
                ((StringBuilder)localObject1).append("keywords:");
                ((StringBuilder)localObject1).append(localObject4.c.toString());
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
        ((AioAnimationRule.JumpImage)localObject).g = AioAnimationRule.JumpImage.b(str1);
      }
      ((AioAnimationRule.JumpImage)localObject).h = paramXmlPullParser;
      ((AioAnimationRule.JumpImage)localObject).c = str2;
      ((AioAnimationRule.JumpImage)localObject).d = str3;
      ((AioAnimationRule.JumpImage)localObject).e = str4;
      ((AioAnimationRule.JumpImage)localObject).f = str5;
      if (paramAioAnimationRule != null)
      {
        if (paramAioAnimationRule.j == null) {
          paramAioAnimationRule.j = new ArrayList();
        }
        paramAioAnimationRule.j.add(localObject);
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
              ((AioAnimationRule)localObject5).l = ((String)localObject4);
              ((AioAnimationRule)localObject5).a(m);
              ((AioAnimationRule)localObject5).m = localObject3;
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
    //   10: new 34	java/io/File
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 344	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore_1
    //   19: aload_3
    //   20: astore_2
    //   21: aload_1
    //   22: invokevirtual 347	java/io/File:exists	()Z
    //   25: ifeq +148 -> 173
    //   28: aload_3
    //   29: astore_2
    //   30: aload_1
    //   31: invokevirtual 350	java/io/File:isFile	()Z
    //   34: ifne +6 -> 40
    //   37: goto +136 -> 173
    //   40: aload_3
    //   41: astore_2
    //   42: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +51 -> 96
    //   48: aload_3
    //   49: astore_2
    //   50: new 23	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   57: astore 6
    //   59: aload_3
    //   60: astore_2
    //   61: aload 6
    //   63: ldc_w 352
    //   66: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_3
    //   71: astore_2
    //   72: aload 6
    //   74: aload_1
    //   75: invokevirtual 355	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   78: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_3
    //   83: astore_2
    //   84: ldc_w 258
    //   87: iconst_2
    //   88: aload 6
    //   90: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: aload_3
    //   97: astore_2
    //   98: new 357	java/io/FileInputStream
    //   101: dup
    //   102: aload_1
    //   103: invokespecial 360	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   106: astore_1
    //   107: invokestatic 366	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   110: invokevirtual 370	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   113: astore_2
    //   114: aload_2
    //   115: aload_1
    //   116: ldc_w 372
    //   119: invokeinterface 376 3 0
    //   124: aload_0
    //   125: aload_2
    //   126: invokespecial 378	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:a	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/util/ArrayList;
    //   129: astore_2
    //   130: aload_1
    //   131: invokevirtual 381	java/io/FileInputStream:close	()V
    //   134: aload_2
    //   135: ifnull +22 -> 157
    //   138: aload_0
    //   139: aload_2
    //   140: putfield 383	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:d	Ljava/util/ArrayList;
    //   143: aload_0
    //   144: getstatic 63	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:c	Ljava/lang/String;
    //   147: aload_0
    //   148: getfield 383	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:d	Ljava/util/ArrayList;
    //   151: invokespecial 386	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:a	(Ljava/lang/String;Ljava/util/ArrayList;)Z
    //   154: pop
    //   155: iconst_1
    //   156: ireturn
    //   157: iconst_0
    //   158: ireturn
    //   159: astore_3
    //   160: aload_1
    //   161: astore_2
    //   162: goto +143 -> 305
    //   165: astore_3
    //   166: goto +73 -> 239
    //   169: astore_3
    //   170: goto +104 -> 274
    //   173: aload_3
    //   174: astore_2
    //   175: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq +51 -> 229
    //   181: aload_3
    //   182: astore_2
    //   183: new 23	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   190: astore 6
    //   192: aload_3
    //   193: astore_2
    //   194: aload 6
    //   196: ldc_w 388
    //   199: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload_3
    //   204: astore_2
    //   205: aload 6
    //   207: aload_1
    //   208: invokevirtual 355	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   211: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload_3
    //   216: astore_2
    //   217: ldc_w 258
    //   220: iconst_2
    //   221: aload 6
    //   223: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 390	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: iconst_0
    //   230: ireturn
    //   231: astore_3
    //   232: goto +73 -> 305
    //   235: astore_3
    //   236: aload 4
    //   238: astore_1
    //   239: aload_1
    //   240: astore_2
    //   241: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +16 -> 260
    //   247: aload_1
    //   248: astore_2
    //   249: ldc_w 258
    //   252: iconst_2
    //   253: ldc_w 392
    //   256: aload_3
    //   257: invokestatic 395	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   260: aload_1
    //   261: ifnull +7 -> 268
    //   264: aload_1
    //   265: invokevirtual 381	java/io/FileInputStream:close	()V
    //   268: iconst_0
    //   269: ireturn
    //   270: astore_3
    //   271: aload 5
    //   273: astore_1
    //   274: aload_1
    //   275: astore_2
    //   276: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq +16 -> 295
    //   282: aload_1
    //   283: astore_2
    //   284: ldc_w 258
    //   287: iconst_2
    //   288: ldc_w 392
    //   291: aload_3
    //   292: invokestatic 395	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   295: aload_1
    //   296: ifnull +7 -> 303
    //   299: aload_1
    //   300: invokevirtual 381	java/io/FileInputStream:close	()V
    //   303: iconst_0
    //   304: ireturn
    //   305: aload_2
    //   306: ifnull +7 -> 313
    //   309: aload_2
    //   310: invokevirtual 381	java/io/FileInputStream:close	()V
    //   313: aload_3
    //   314: athrow
    //   315: astore_1
    //   316: goto -182 -> 134
    //   319: astore_1
    //   320: iconst_0
    //   321: ireturn
    //   322: astore_1
    //   323: iconst_0
    //   324: ireturn
    //   325: astore_1
    //   326: goto -13 -> 313
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	AioAnimationConfigHelper
    //   0	329	1	paramString	String
    //   9	301	2	localObject1	Object
    //   7	90	3	localObject2	Object
    //   159	1	3	localObject3	Object
    //   165	1	3	localOutOfMemoryError1	OutOfMemoryError
    //   169	47	3	localException1	Exception
    //   231	1	3	localObject4	Object
    //   235	22	3	localOutOfMemoryError2	OutOfMemoryError
    //   270	44	3	localException2	Exception
    //   1	236	4	localObject5	Object
    //   4	268	5	localObject6	Object
    //   57	165	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   107	130	159	finally
    //   107	130	165	java/lang/OutOfMemoryError
    //   107	130	169	java/lang/Exception
    //   10	19	231	finally
    //   21	28	231	finally
    //   30	37	231	finally
    //   42	48	231	finally
    //   50	59	231	finally
    //   61	70	231	finally
    //   72	82	231	finally
    //   84	96	231	finally
    //   98	107	231	finally
    //   175	181	231	finally
    //   183	192	231	finally
    //   194	203	231	finally
    //   205	215	231	finally
    //   217	229	231	finally
    //   241	247	231	finally
    //   249	260	231	finally
    //   276	282	231	finally
    //   284	295	231	finally
    //   10	19	235	java/lang/OutOfMemoryError
    //   21	28	235	java/lang/OutOfMemoryError
    //   30	37	235	java/lang/OutOfMemoryError
    //   42	48	235	java/lang/OutOfMemoryError
    //   50	59	235	java/lang/OutOfMemoryError
    //   61	70	235	java/lang/OutOfMemoryError
    //   72	82	235	java/lang/OutOfMemoryError
    //   84	96	235	java/lang/OutOfMemoryError
    //   98	107	235	java/lang/OutOfMemoryError
    //   175	181	235	java/lang/OutOfMemoryError
    //   183	192	235	java/lang/OutOfMemoryError
    //   194	203	235	java/lang/OutOfMemoryError
    //   205	215	235	java/lang/OutOfMemoryError
    //   217	229	235	java/lang/OutOfMemoryError
    //   10	19	270	java/lang/Exception
    //   21	28	270	java/lang/Exception
    //   30	37	270	java/lang/Exception
    //   42	48	270	java/lang/Exception
    //   50	59	270	java/lang/Exception
    //   61	70	270	java/lang/Exception
    //   72	82	270	java/lang/Exception
    //   84	96	270	java/lang/Exception
    //   98	107	270	java/lang/Exception
    //   175	181	270	java/lang/Exception
    //   183	192	270	java/lang/Exception
    //   194	203	270	java/lang/Exception
    //   205	215	270	java/lang/Exception
    //   217	229	270	java/lang/Exception
    //   130	134	315	java/io/IOException
    //   264	268	319	java/io/IOException
    //   299	303	322	java/io/IOException
    //   309	313	325	java/io/IOException
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
    //   12: new 34	java/io/File
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 344	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_1
    //   21: aload 6
    //   23: astore_3
    //   24: aload_1
    //   25: invokevirtual 347	java/io/File:exists	()Z
    //   28: ifeq +132 -> 160
    //   31: aload 6
    //   33: astore_3
    //   34: aload_1
    //   35: invokevirtual 350	java/io/File:isFile	()Z
    //   38: ifne +6 -> 44
    //   41: goto +119 -> 160
    //   44: aload 6
    //   46: astore_3
    //   47: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq +55 -> 105
    //   53: aload 6
    //   55: astore_3
    //   56: new 23	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   63: astore 7
    //   65: aload 6
    //   67: astore_3
    //   68: aload 7
    //   70: ldc_w 397
    //   73: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 6
    //   79: astore_3
    //   80: aload 7
    //   82: aload_1
    //   83: invokevirtual 355	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   86: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 6
    //   92: astore_3
    //   93: ldc_w 258
    //   96: iconst_2
    //   97: aload 7
    //   99: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload 6
    //   107: astore_3
    //   108: new 357	java/io/FileInputStream
    //   111: dup
    //   112: aload_1
    //   113: invokespecial 360	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   116: astore_1
    //   117: invokestatic 366	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   120: invokevirtual 370	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   123: astore_3
    //   124: aload_3
    //   125: aload_1
    //   126: ldc_w 372
    //   129: invokeinterface 376 3 0
    //   134: aload_0
    //   135: aload_3
    //   136: aload_2
    //   137: invokespecial 399	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:a	(Lorg/xmlpull/v1/XmlPullParser;Ljava/util/ArrayList;)V
    //   140: aload_1
    //   141: invokestatic 404	com/tencent/mobileqq/utils/FileUtils:close	(Ljava/io/Closeable;)V
    //   144: iconst_1
    //   145: ireturn
    //   146: astore_2
    //   147: aload_1
    //   148: astore_3
    //   149: goto +140 -> 289
    //   152: astore_2
    //   153: goto +78 -> 231
    //   156: astore_2
    //   157: goto +105 -> 262
    //   160: aload 6
    //   162: astore_3
    //   163: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +51 -> 217
    //   169: aload 6
    //   171: astore_3
    //   172: new 23	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   179: astore_2
    //   180: aload 6
    //   182: astore_3
    //   183: aload_2
    //   184: ldc_w 406
    //   187: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 6
    //   193: astore_3
    //   194: aload_2
    //   195: aload_1
    //   196: invokevirtual 355	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   199: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 6
    //   205: astore_3
    //   206: ldc_w 258
    //   209: iconst_2
    //   210: aload_2
    //   211: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 390	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aconst_null
    //   218: invokestatic 404	com/tencent/mobileqq/utils/FileUtils:close	(Ljava/io/Closeable;)V
    //   221: iconst_0
    //   222: ireturn
    //   223: astore_2
    //   224: goto +65 -> 289
    //   227: astore_2
    //   228: aload 4
    //   230: astore_1
    //   231: aload_1
    //   232: astore_3
    //   233: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   236: ifeq +16 -> 252
    //   239: aload_1
    //   240: astore_3
    //   241: ldc_w 258
    //   244: iconst_2
    //   245: ldc_w 408
    //   248: aload_2
    //   249: invokestatic 395	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   252: aload_1
    //   253: invokestatic 404	com/tencent/mobileqq/utils/FileUtils:close	(Ljava/io/Closeable;)V
    //   256: iconst_0
    //   257: ireturn
    //   258: astore_2
    //   259: aload 5
    //   261: astore_1
    //   262: aload_1
    //   263: astore_3
    //   264: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq +16 -> 283
    //   270: aload_1
    //   271: astore_3
    //   272: ldc_w 258
    //   275: iconst_2
    //   276: ldc_w 408
    //   279: aload_2
    //   280: invokestatic 395	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   283: aload_1
    //   284: invokestatic 404	com/tencent/mobileqq/utils/FileUtils:close	(Ljava/io/Closeable;)V
    //   287: iconst_0
    //   288: ireturn
    //   289: aload_3
    //   290: invokestatic 404	com/tencent/mobileqq/utils/FileUtils:close	(Ljava/io/Closeable;)V
    //   293: aload_2
    //   294: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	AioAnimationConfigHelper
    //   0	295	1	paramString	String
    //   0	295	2	paramArrayList	ArrayList<AioAnimationRule>
    //   11	279	3	localObject1	Object
    //   1	228	4	localObject2	Object
    //   4	256	5	localObject3	Object
    //   7	197	6	localObject4	Object
    //   63	35	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   117	140	146	finally
    //   117	140	152	java/lang/OutOfMemoryError
    //   117	140	156	java/lang/Exception
    //   12	21	223	finally
    //   24	31	223	finally
    //   34	41	223	finally
    //   47	53	223	finally
    //   56	65	223	finally
    //   68	77	223	finally
    //   80	90	223	finally
    //   93	105	223	finally
    //   108	117	223	finally
    //   163	169	223	finally
    //   172	180	223	finally
    //   183	191	223	finally
    //   194	203	223	finally
    //   206	217	223	finally
    //   233	239	223	finally
    //   241	252	223	finally
    //   264	270	223	finally
    //   272	283	223	finally
    //   12	21	227	java/lang/OutOfMemoryError
    //   24	31	227	java/lang/OutOfMemoryError
    //   34	41	227	java/lang/OutOfMemoryError
    //   47	53	227	java/lang/OutOfMemoryError
    //   56	65	227	java/lang/OutOfMemoryError
    //   68	77	227	java/lang/OutOfMemoryError
    //   80	90	227	java/lang/OutOfMemoryError
    //   93	105	227	java/lang/OutOfMemoryError
    //   108	117	227	java/lang/OutOfMemoryError
    //   163	169	227	java/lang/OutOfMemoryError
    //   172	180	227	java/lang/OutOfMemoryError
    //   183	191	227	java/lang/OutOfMemoryError
    //   194	203	227	java/lang/OutOfMemoryError
    //   206	217	227	java/lang/OutOfMemoryError
    //   12	21	258	java/lang/Exception
    //   24	31	258	java/lang/Exception
    //   34	41	258	java/lang/Exception
    //   47	53	258	java/lang/Exception
    //   56	65	258	java/lang/Exception
    //   68	77	258	java/lang/Exception
    //   80	90	258	java/lang/Exception
    //   93	105	258	java/lang/Exception
    //   108	117	258	java/lang/Exception
    //   163	169	258	java/lang/Exception
    //   172	180	258	java/lang/Exception
    //   183	191	258	java/lang/Exception
    //   194	203	258	java/lang/Exception
    //   206	217	258	java/lang/Exception
  }
  
  private long b(String paramString)
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
  
  /* Error */
  private void b(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 258
    //   9: iconst_2
    //   10: ldc_w 443
    //   13: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_1
    //   17: invokevirtual 447	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   20: ldc_w 448
    //   23: invokevirtual 454	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   26: astore_3
    //   27: aconst_null
    //   28: astore_2
    //   29: aload_0
    //   30: aload_3
    //   31: invokespecial 378	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:a	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/util/ArrayList;
    //   34: astore_1
    //   35: aload_3
    //   36: invokeinterface 457 1 0
    //   41: goto +34 -> 75
    //   44: astore_1
    //   45: goto +40 -> 85
    //   48: astore 4
    //   50: aload_2
    //   51: astore_1
    //   52: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq -20 -> 35
    //   58: ldc_w 258
    //   61: iconst_2
    //   62: ldc_w 459
    //   65: aload 4
    //   67: invokestatic 395	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   70: aload_2
    //   71: astore_1
    //   72: goto -37 -> 35
    //   75: aload_1
    //   76: ifnull +8 -> 84
    //   79: aload_0
    //   80: aload_1
    //   81: putfield 383	com/tencent/mobileqq/activity/aio/anim/AioAnimationConfigHelper:d	Ljava/util/ArrayList;
    //   84: return
    //   85: aload_3
    //   86: invokeinterface 457 1 0
    //   91: goto +5 -> 96
    //   94: aload_1
    //   95: athrow
    //   96: goto -2 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	AioAnimationConfigHelper
    //   0	99	1	paramContext	Context
    //   28	43	2	localObject	Object
    //   26	60	3	localXmlResourceParser	android.content.res.XmlResourceParser
    //   48	18	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   29	35	44	finally
    //   52	70	44	finally
    //   29	35	48	java/lang/Exception
  }
  
  public void a(Context paramContext)
  {
    if (FileUtils.fileExistsAndNotEmpty(b))
    {
      boolean bool = a(b);
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
      FileUtils.delete(a, false);
      FileUtils.uncompressZip(paramString, a, false);
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
      boolean bool = a(b);
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
  
  public ArrayList<AioAnimationRule> b()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AioAnimationConfigHelper
 * JD-Core Version:    0.7.0.1
 */