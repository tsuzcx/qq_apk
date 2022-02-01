package com.tencent.aladdin.config.parse;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.aladdin.config.utils.Log;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.lang.Class<*>;>;
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
    localHashMap = new HashMap();
    try
    {
      XmlPullParser localXmlPullParser = Xml.newPullParser();
      localXmlPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
      localXmlPullParser.setInput(paramReader);
      for (int i = localXmlPullParser.getEventType(); i != 1; i = localXmlPullParser.next()) {
        if (localXmlPullParser.getEventType() == 0)
        {
          Log.d("SimpleObjectParser", "parse: START_DOCUMENT");
        }
        else if (localXmlPullParser.getEventType() == 2)
        {
          Log.d("SimpleObjectParser", "parse: START_TAG");
          paramReader = localXmlPullParser.getName();
          if ("configs".equals(paramReader))
          {
            readConfigs(localXmlPullParser, paramMap, localHashMap);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("parse: unknown tag: ");
            localStringBuilder.append(paramReader);
            Log.e("SimpleObjectParser", localStringBuilder.toString());
          }
        }
      }
      return localHashMap;
    }
    catch (Exception paramReader)
    {
      Log.e("SimpleObjectParser", "parse: ", paramReader);
    }
  }
  
  private static Collection<?> readCollection(@NonNull XmlPullParser paramXmlPullParser, @NonNull Map<String, Class<?>> paramMap, @NonNull Collection<Object> paramCollection, @NonNull String paramString)
  {
    paramXmlPullParser.require(2, null, paramString);
    for (int i = paramXmlPullParser.next(); (i != 3) && (i != 1); i = paramXmlPullParser.next())
    {
      Object localObject;
      if (i == 2)
      {
        localObject = readObject(paramXmlPullParser, paramMap);
        if (localObject != null) {
          paramCollection.add(localObject);
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("readConfigs: unexpected event type: ");
        ((StringBuilder)localObject).append(i);
        Log.d("SimpleObjectParser", ((StringBuilder)localObject).toString());
      }
    }
    paramXmlPullParser.require(3, null, paramString);
    return paramCollection;
  }
  
  private static void readConfigs(XmlPullParser paramXmlPullParser, Map<String, Class<?>> paramMap, Map<String, Object> paramMap1)
  {
    paramXmlPullParser.require(2, null, "configs");
    for (int i = paramXmlPullParser.next(); (i != 3) && (i != 1); i = paramXmlPullParser.next()) {
      if (i == 2)
      {
        paramMap1.put(paramXmlPullParser.getAttributeValue("", "name"), readObject(paramXmlPullParser, paramMap));
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("readConfigs: unexpected event type: ");
        localStringBuilder.append(i);
        Log.d("SimpleObjectParser", localStringBuilder.toString());
      }
    }
    paramXmlPullParser.require(3, null, "configs");
  }
  
  @Deprecated
  private static List<?> readList(@NonNull XmlPullParser paramXmlPullParser, @NonNull Map<String, Class<?>> paramMap)
  {
    paramXmlPullParser.require(2, null, "list");
    LinkedList localLinkedList = new LinkedList();
    for (int i = paramXmlPullParser.next(); (i != 3) && (i != 1); i = paramXmlPullParser.next()) {
      if (i == 2)
      {
        localLinkedList.add(readObject(paramXmlPullParser, paramMap));
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("readConfigs: unexpected event type: ");
        localStringBuilder.append(i);
        Log.d("SimpleObjectParser", localStringBuilder.toString());
      }
    }
    paramXmlPullParser.require(3, null, "list");
    return localLinkedList;
  }
  
  private static Map<String, ?> readMap(@NonNull XmlPullParser paramXmlPullParser, @NonNull Map<String, Class<?>> paramMap)
  {
    HashMap localHashMap = new HashMap();
    paramXmlPullParser.require(2, null, "map");
    for (int i = paramXmlPullParser.next(); (i != 3) && (i != 1); i = paramXmlPullParser.next()) {
      if (i == 2)
      {
        localHashMap.put(paramXmlPullParser.getAttributeValue("", "name"), readObject(paramXmlPullParser, paramMap));
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("readConfigs: unexpected event type: ");
        localStringBuilder.append(i);
        Log.d("SimpleObjectParser", localStringBuilder.toString());
      }
    }
    paramXmlPullParser.require(3, null, "map");
    return localHashMap;
  }
  
  private static Object readObject(@NonNull XmlPullParser paramXmlPullParser, @NonNull Map<String, Class<?>> paramMap)
  {
    String str = paramXmlPullParser.getName();
    paramXmlPullParser.require(2, null, str);
    if (TextUtils.equals(str, "boolean"))
    {
      paramMap = Boolean.valueOf(readText(paramXmlPullParser));
    }
    else if (TextUtils.equals(str, "int"))
    {
      paramMap = Integer.valueOf(readText(paramXmlPullParser));
    }
    else if (TextUtils.equals(str, "float"))
    {
      paramMap = Float.valueOf(readText(paramXmlPullParser));
    }
    else if (TextUtils.equals(str, "string"))
    {
      paramMap = readText(paramXmlPullParser);
    }
    else
    {
      Object localObject1;
      if (TextUtils.equals(str, "list"))
      {
        localObject1 = new ArrayList();
        readCollection(paramXmlPullParser, paramMap, (Collection)localObject1, str);
        paramMap = (Map<String, Class<?>>)localObject1;
      }
      for (;;)
      {
        break;
        if (TextUtils.equals(str, "set"))
        {
          localObject1 = new HashSet();
          readCollection(paramXmlPullParser, paramMap, (Collection)localObject1, str);
          paramMap = (Map<String, Class<?>>)localObject1;
        }
        else if (TextUtils.equals(str, "map"))
        {
          paramMap = readMap(paramXmlPullParser, paramMap);
        }
        else if (TextUtils.equals(str, "item"))
        {
          label318:
          Object localObject2;
          try
          {
            localObject1 = paramXmlPullParser.getAttributeValue("", "type");
            Object localObject3 = (Class)paramMap.get(localObject1);
            if (localObject3 != null)
            {
              localObject3 = ((Class)localObject3).newInstance();
              try
              {
                for (int i = paramXmlPullParser.next();; i = paramXmlPullParser.next())
                {
                  localObject1 = localObject3;
                  if (i == 3) {
                    break;
                  }
                  localObject1 = localObject3;
                  if (i == 1) {
                    break;
                  }
                  if (i == 2)
                  {
                    try
                    {
                      localObject1 = paramXmlPullParser.getAttributeValue("", "name");
                      localObject1 = localObject3.getClass().getDeclaredField((String)localObject1);
                      ((Field)localObject1).setAccessible(true);
                      ((Field)localObject1).set(localObject3, readObject(paramXmlPullParser, paramMap));
                    }
                    catch (IllegalAccessException localIllegalAccessException) {}catch (NoSuchFieldException localNoSuchFieldException)
                    {
                      break label318;
                    }
                    skip(paramXmlPullParser);
                    Log.e("SimpleObjectParser", "readObjectFields: ", localNoSuchFieldException);
                    continue;
                    skip(paramXmlPullParser);
                    Log.e("SimpleObjectParser", "readObjectFields: ", localNoSuchFieldException);
                  }
                  else
                  {
                    localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append("readObject: unexpected event type: ");
                    ((StringBuilder)localObject2).append(i);
                    Log.e("SimpleObjectParser", ((StringBuilder)localObject2).toString());
                  }
                }
                paramMap = new StringBuilder();
              }
              catch (IllegalAccessException paramMap)
              {
                localObject2 = localObject3;
              }
              catch (InstantiationException paramMap)
              {
                localObject2 = localObject3;
                break label449;
              }
            }
            else
            {
              paramMap.append("readObject: unrecognized type: ");
              paramMap.append((String)localObject2);
              Log.e("SimpleObjectParser", paramMap.toString());
              skip(paramXmlPullParser);
              localObject2 = null;
            }
          }
          catch (IllegalAccessException paramMap)
          {
            localObject2 = null;
          }
          catch (InstantiationException paramMap)
          {
            localObject2 = null;
            break label449;
          }
          Log.e("SimpleObjectParser", "readObject: ", paramMap);
          break label457;
          label449:
          Log.e("SimpleObjectParser", "readObject: ", paramMap);
          label457:
          paramMap = (Map<String, Class<?>>)localObject2;
        }
        else
        {
          paramMap = new StringBuilder();
          paramMap.append("readObject: unrecognized tag: ");
          paramMap.append(str);
          Log.e("SimpleObjectParser", paramMap.toString());
          skip(paramXmlPullParser);
          paramMap = null;
        }
      }
    }
    paramXmlPullParser.require(3, null, str);
    return paramMap;
  }
  
  private static String readText(@NonNull XmlPullParser paramXmlPullParser)
  {
    if (paramXmlPullParser.getEventType() == 2)
    {
      int i = paramXmlPullParser.next();
      Object localObject2;
      for (Object localObject1 = ""; (i != 3) && (i != 1); localObject1 = localObject2)
      {
        if (i == 4)
        {
          localObject2 = paramXmlPullParser.getText();
          localObject1 = localObject2;
          if (localObject2 != null) {
            localObject1 = ((String)localObject2).trim();
          }
          localObject2 = localObject1;
        }
        else
        {
          localObject2 = localObject1;
          if (i == 2)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("readText: unexpected nested tag: ");
            ((StringBuilder)localObject2).append(paramXmlPullParser.getName());
            ((StringBuilder)localObject2).append(", skip.");
            Log.d("SimpleObjectParser", ((StringBuilder)localObject2).toString());
            skip(paramXmlPullParser);
            localObject2 = localObject1;
          }
        }
        i = paramXmlPullParser.next();
      }
      return localObject1;
    }
    paramXmlPullParser = new IllegalStateException();
    for (;;)
    {
      throw paramXmlPullParser;
    }
  }
  
  private static void skip(XmlPullParser paramXmlPullParser)
  {
    if (paramXmlPullParser.getEventType() == 2)
    {
      int i = 1;
      while (i != 0)
      {
        int j = paramXmlPullParser.next();
        if (j != 1)
        {
          if (j != 2)
          {
            if (j == 3) {
              i -= 1;
            }
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("skip: ");
            localStringBuilder.append(paramXmlPullParser.getName());
            Log.d("SimpleObjectParser", localStringBuilder.toString());
            i += 1;
          }
        }
        else {
          throw new IllegalStateException();
        }
      }
      return;
    }
    paramXmlPullParser = new IllegalStateException();
    for (;;)
    {
      throw paramXmlPullParser;
    }
  }
  
  public Map<String, ?> parse(Reader paramReader)
  {
    return parse(paramReader, this.typeMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aladdin.config.parse.SimpleObjectParser
 * JD-Core Version:    0.7.0.1
 */