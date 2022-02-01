package com.tencent.aladdin.config.parse;

import android.support.annotation.NonNull;
import android.util.Xml;
import com.tencent.aladdin.config.utils.Log;
import java.io.Reader;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class SimpleObjectParser
  implements AladdinConfigParser
{
  private static final String TAG = "SimpleObjectParser";
  private final Map<String, Class<?>> typeMap;
  
  public SimpleObjectParser(Map<String, Class<?>> paramMap)
  {
    this.typeMap = paramMap;
  }
  
  private static Map<String, ?> parse(Reader paramReader, Map<String, Class<?>> paramMap)
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        XmlPullParser localXmlPullParser = Xml.newPullParser();
        localXmlPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        localXmlPullParser.setInput(paramReader);
        int i = localXmlPullParser.getEventType();
        if (i != 1)
        {
          if (localXmlPullParser.getEventType() == 0)
          {
            Log.d("SimpleObjectParser", "parse: START_DOCUMENT");
            i = localXmlPullParser.next();
            continue;
          }
          if (localXmlPullParser.getEventType() != 2) {
            continue;
          }
          Log.d("SimpleObjectParser", "parse: START_TAG");
          paramReader = localXmlPullParser.getName();
          if ("configs".equals(paramReader))
          {
            readConfigs(localXmlPullParser, paramMap, localHashMap);
            continue;
          }
        }
        else
        {
          return localHashMap;
        }
      }
      catch (Exception paramReader)
      {
        Log.e("SimpleObjectParser", "parse: ", paramReader);
      }
      Log.e("SimpleObjectParser", "parse: unknown tag: " + paramReader);
    }
  }
  
  private static Collection<?> readCollection(@NonNull XmlPullParser paramXmlPullParser, @NonNull Map<String, Class<?>> paramMap, @NonNull Collection<Object> paramCollection, @NonNull String paramString)
  {
    paramXmlPullParser.require(2, null, paramString);
    int i = paramXmlPullParser.next();
    if ((i != 3) && (i != 1))
    {
      if (i == 2)
      {
        Object localObject = readObject(paramXmlPullParser, paramMap);
        if (localObject != null) {
          paramCollection.add(localObject);
        }
      }
      for (;;)
      {
        i = paramXmlPullParser.next();
        break;
        Log.d("SimpleObjectParser", "readConfigs: unexpected event type: " + i);
      }
    }
    paramXmlPullParser.require(3, null, paramString);
    return paramCollection;
  }
  
  private static void readConfigs(XmlPullParser paramXmlPullParser, Map<String, Class<?>> paramMap, Map<String, Object> paramMap1)
  {
    paramXmlPullParser.require(2, null, "configs");
    int i = paramXmlPullParser.next();
    if ((i != 3) && (i != 1))
    {
      if (i == 2) {
        paramMap1.put(paramXmlPullParser.getAttributeValue("", "name"), readObject(paramXmlPullParser, paramMap));
      }
      for (;;)
      {
        i = paramXmlPullParser.next();
        break;
        Log.d("SimpleObjectParser", "readConfigs: unexpected event type: " + i);
      }
    }
    paramXmlPullParser.require(3, null, "configs");
  }
  
  @Deprecated
  private static List<?> readList(@NonNull XmlPullParser paramXmlPullParser, @NonNull Map<String, Class<?>> paramMap)
  {
    paramXmlPullParser.require(2, null, "list");
    LinkedList localLinkedList = new LinkedList();
    int i = paramXmlPullParser.next();
    if ((i != 3) && (i != 1))
    {
      if (i == 2) {
        localLinkedList.add(readObject(paramXmlPullParser, paramMap));
      }
      for (;;)
      {
        i = paramXmlPullParser.next();
        break;
        Log.d("SimpleObjectParser", "readConfigs: unexpected event type: " + i);
      }
    }
    paramXmlPullParser.require(3, null, "list");
    return localLinkedList;
  }
  
  private static Map<String, ?> readMap(@NonNull XmlPullParser paramXmlPullParser, @NonNull Map<String, Class<?>> paramMap)
  {
    HashMap localHashMap = new HashMap();
    paramXmlPullParser.require(2, null, "map");
    int i = paramXmlPullParser.next();
    if ((i != 3) && (i != 1))
    {
      if (i == 2) {
        localHashMap.put(paramXmlPullParser.getAttributeValue("", "name"), readObject(paramXmlPullParser, paramMap));
      }
      for (;;)
      {
        i = paramXmlPullParser.next();
        break;
        Log.d("SimpleObjectParser", "readConfigs: unexpected event type: " + i);
      }
    }
    paramXmlPullParser.require(3, null, "map");
    return localHashMap;
  }
  
  /* Error */
  private static Object readObject(@NonNull XmlPullParser paramXmlPullParser, @NonNull Map<String, Class<?>> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 69 1 0
    //   6: astore 5
    //   8: aload_0
    //   9: iconst_2
    //   10: aconst_null
    //   11: aload 5
    //   13: invokeinterface 109 4 0
    //   18: aload 5
    //   20: ldc 166
    //   22: invokestatic 171	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   25: ifeq +23 -> 48
    //   28: aload_0
    //   29: invokestatic 175	com/tencent/aladdin/config/parse/SimpleObjectParser:readText	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    //   32: invokestatic 181	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   35: astore_3
    //   36: aload_0
    //   37: iconst_3
    //   38: aconst_null
    //   39: aload 5
    //   41: invokeinterface 109 4 0
    //   46: aload_3
    //   47: areturn
    //   48: aload 5
    //   50: ldc 183
    //   52: invokestatic 171	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   55: ifeq +14 -> 69
    //   58: aload_0
    //   59: invokestatic 175	com/tencent/aladdin/config/parse/SimpleObjectParser:readText	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    //   62: invokestatic 188	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   65: astore_3
    //   66: goto -30 -> 36
    //   69: aload 5
    //   71: ldc 190
    //   73: invokestatic 171	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   76: ifeq +14 -> 90
    //   79: aload_0
    //   80: invokestatic 175	com/tencent/aladdin/config/parse/SimpleObjectParser:readText	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    //   83: invokestatic 195	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   86: astore_3
    //   87: goto -51 -> 36
    //   90: aload 5
    //   92: ldc 197
    //   94: invokestatic 171	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   97: ifeq +11 -> 108
    //   100: aload_0
    //   101: invokestatic 175	com/tencent/aladdin/config/parse/SimpleObjectParser:readText	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    //   104: astore_3
    //   105: goto -69 -> 36
    //   108: aload 5
    //   110: ldc 145
    //   112: invokestatic 171	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   115: ifeq +23 -> 138
    //   118: new 199	java/util/ArrayList
    //   121: dup
    //   122: invokespecial 200	java/util/ArrayList:<init>	()V
    //   125: astore_3
    //   126: aload_0
    //   127: aload_1
    //   128: aload_3
    //   129: aload 5
    //   131: invokestatic 202	com/tencent/aladdin/config/parse/SimpleObjectParser:readCollection	(Lorg/xmlpull/v1/XmlPullParser;Ljava/util/Map;Ljava/util/Collection;Ljava/lang/String;)Ljava/util/Collection;
    //   134: pop
    //   135: goto -99 -> 36
    //   138: aload 5
    //   140: ldc 204
    //   142: invokestatic 171	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   145: ifeq +23 -> 168
    //   148: new 206	java/util/HashSet
    //   151: dup
    //   152: invokespecial 207	java/util/HashSet:<init>	()V
    //   155: astore_3
    //   156: aload_0
    //   157: aload_1
    //   158: aload_3
    //   159: aload 5
    //   161: invokestatic 202	com/tencent/aladdin/config/parse/SimpleObjectParser:readCollection	(Lorg/xmlpull/v1/XmlPullParser;Ljava/util/Map;Ljava/util/Collection;Ljava/lang/String;)Ljava/util/Collection;
    //   164: pop
    //   165: goto -129 -> 36
    //   168: aload 5
    //   170: ldc 157
    //   172: invokestatic 171	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   175: ifeq +12 -> 187
    //   178: aload_0
    //   179: aload_1
    //   180: invokestatic 209	com/tencent/aladdin/config/parse/SimpleObjectParser:readMap	(Lorg/xmlpull/v1/XmlPullParser;Ljava/util/Map;)Ljava/util/Map;
    //   183: astore_3
    //   184: goto -148 -> 36
    //   187: aload 5
    //   189: ldc 211
    //   191: invokestatic 171	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   194: ifeq +235 -> 429
    //   197: aload_0
    //   198: ldc 127
    //   200: ldc 213
    //   202: invokeinterface 133 3 0
    //   207: astore_3
    //   208: aload_1
    //   209: aload_3
    //   210: invokeinterface 217 2 0
    //   215: checkcast 219	java/lang/Class
    //   218: astore 4
    //   220: aload 4
    //   222: ifnull +174 -> 396
    //   225: aload 4
    //   227: invokevirtual 223	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   230: astore 4
    //   232: aload_0
    //   233: invokeinterface 63 1 0
    //   238: istore_2
    //   239: aload 4
    //   241: astore_3
    //   242: iload_2
    //   243: iconst_3
    //   244: if_icmpeq -208 -> 36
    //   247: aload 4
    //   249: astore_3
    //   250: iload_2
    //   251: iconst_1
    //   252: if_icmpeq -216 -> 36
    //   255: iload_2
    //   256: iconst_2
    //   257: if_icmpne +112 -> 369
    //   260: aload_0
    //   261: ldc 127
    //   263: ldc 129
    //   265: invokeinterface 133 3 0
    //   270: astore_3
    //   271: aload 4
    //   273: invokevirtual 227	java/lang/Object:getClass	()Ljava/lang/Class;
    //   276: aload_3
    //   277: invokevirtual 231	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   280: astore_3
    //   281: aload_3
    //   282: iconst_1
    //   283: invokevirtual 237	java/lang/reflect/Field:setAccessible	(Z)V
    //   286: aload_3
    //   287: aload 4
    //   289: aload_0
    //   290: aload_1
    //   291: invokestatic 113	com/tencent/aladdin/config/parse/SimpleObjectParser:readObject	(Lorg/xmlpull/v1/XmlPullParser;Ljava/util/Map;)Ljava/lang/Object;
    //   294: invokevirtual 240	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   297: aload_0
    //   298: invokeinterface 63 1 0
    //   303: istore_2
    //   304: goto -65 -> 239
    //   307: astore_3
    //   308: aload_0
    //   309: invokestatic 244	com/tencent/aladdin/config/parse/SimpleObjectParser:skip	(Lorg/xmlpull/v1/XmlPullParser;)V
    //   312: ldc 10
    //   314: ldc 246
    //   316: aload_3
    //   317: invokestatic 87	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   320: goto -23 -> 297
    //   323: astore_1
    //   324: aload 4
    //   326: astore_3
    //   327: ldc 10
    //   329: ldc 248
    //   331: aload_1
    //   332: invokestatic 87	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   335: goto -299 -> 36
    //   338: astore_3
    //   339: aload_0
    //   340: invokestatic 244	com/tencent/aladdin/config/parse/SimpleObjectParser:skip	(Lorg/xmlpull/v1/XmlPullParser;)V
    //   343: ldc 10
    //   345: ldc 246
    //   347: aload_3
    //   348: invokestatic 87	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   351: goto -54 -> 297
    //   354: astore_1
    //   355: aload 4
    //   357: astore_3
    //   358: ldc 10
    //   360: ldc 248
    //   362: aload_1
    //   363: invokestatic 87	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   366: goto -330 -> 36
    //   369: ldc 10
    //   371: new 89	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   378: ldc 250
    //   380: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: iload_2
    //   384: invokevirtual 123	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   387: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 101	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   393: goto -96 -> 297
    //   396: ldc 10
    //   398: new 89	java/lang/StringBuilder
    //   401: dup
    //   402: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   405: ldc 252
    //   407: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: aload_3
    //   411: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 101	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   420: aload_0
    //   421: invokestatic 244	com/tencent/aladdin/config/parse/SimpleObjectParser:skip	(Lorg/xmlpull/v1/XmlPullParser;)V
    //   424: aconst_null
    //   425: astore_3
    //   426: goto -390 -> 36
    //   429: ldc 10
    //   431: new 89	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   438: ldc 254
    //   440: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload 5
    //   445: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 101	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   454: aload_0
    //   455: invokestatic 244	com/tencent/aladdin/config/parse/SimpleObjectParser:skip	(Lorg/xmlpull/v1/XmlPullParser;)V
    //   458: goto -34 -> 424
    //   461: astore_1
    //   462: aconst_null
    //   463: astore_3
    //   464: goto -106 -> 358
    //   467: astore_1
    //   468: aconst_null
    //   469: astore_3
    //   470: goto -143 -> 327
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	473	0	paramXmlPullParser	XmlPullParser
    //   0	473	1	paramMap	Map<String, Class<?>>
    //   238	146	2	i	int
    //   35	252	3	localObject1	Object
    //   307	10	3	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   326	1	3	localObject2	Object
    //   338	10	3	localIllegalAccessException	java.lang.IllegalAccessException
    //   357	113	3	localObject3	Object
    //   218	138	4	localObject4	Object
    //   6	438	5	str	String
    // Exception table:
    //   from	to	target	type
    //   260	297	307	java/lang/NoSuchFieldException
    //   232	239	323	java/lang/InstantiationException
    //   260	297	323	java/lang/InstantiationException
    //   297	304	323	java/lang/InstantiationException
    //   308	320	323	java/lang/InstantiationException
    //   339	351	323	java/lang/InstantiationException
    //   369	393	323	java/lang/InstantiationException
    //   260	297	338	java/lang/IllegalAccessException
    //   232	239	354	java/lang/IllegalAccessException
    //   297	304	354	java/lang/IllegalAccessException
    //   308	320	354	java/lang/IllegalAccessException
    //   339	351	354	java/lang/IllegalAccessException
    //   369	393	354	java/lang/IllegalAccessException
    //   197	220	461	java/lang/IllegalAccessException
    //   225	232	461	java/lang/IllegalAccessException
    //   396	424	461	java/lang/IllegalAccessException
    //   197	220	467	java/lang/InstantiationException
    //   225	232	467	java/lang/InstantiationException
    //   396	424	467	java/lang/InstantiationException
  }
  
  private static String readText(@NonNull XmlPullParser paramXmlPullParser)
  {
    if (paramXmlPullParser.getEventType() != 2) {
      throw new IllegalStateException();
    }
    int i = paramXmlPullParser.next();
    Object localObject2 = "";
    if ((i != 3) && (i != 1))
    {
      Object localObject1;
      if (i == 4)
      {
        localObject2 = paramXmlPullParser.getText();
        localObject1 = localObject2;
        if (localObject2 != null) {
          localObject1 = ((String)localObject2).trim();
        }
      }
      for (;;)
      {
        i = paramXmlPullParser.next();
        localObject2 = localObject1;
        break;
        localObject1 = localObject2;
        if (i == 2)
        {
          Log.d("SimpleObjectParser", "readText: unexpected nested tag: " + paramXmlPullParser.getName() + ", skip.");
          skip(paramXmlPullParser);
          localObject1 = localObject2;
        }
      }
    }
    return localObject2;
  }
  
  private static void skip(XmlPullParser paramXmlPullParser)
  {
    if (paramXmlPullParser.getEventType() != 2) {
      throw new IllegalStateException();
    }
    int i = 1;
    while (i != 0) {
      switch (paramXmlPullParser.next())
      {
      default: 
        break;
      case 1: 
        throw new IllegalStateException();
      case 3: 
        i -= 1;
        break;
      case 2: 
        Log.d("SimpleObjectParser", "skip: " + paramXmlPullParser.getName());
        i += 1;
      }
    }
  }
  
  public Map<String, ?> parse(Reader paramReader)
  {
    return parse(paramReader, this.typeMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aladdin.config.parse.SimpleObjectParser
 * JD-Core Version:    0.7.0.1
 */