package com.google.protobuf;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

final class MessageLiteToString
{
  static String a(MessageLite paramMessageLite, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("# ");
    localStringBuilder.append(paramString);
    a(paramMessageLite, localStringBuilder, 0);
    return localStringBuilder.toString();
  }
  
  private static final String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (Character.isUpperCase(c)) {
        localStringBuilder.append("_");
      }
      localStringBuilder.append(Character.toLowerCase(c));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static void a(MessageLite paramMessageLite, StringBuilder paramStringBuilder, int paramInt)
  {
    Object localObject1 = new HashMap();
    Object localObject2 = new HashMap();
    Object localObject3 = new TreeSet();
    Object localObject4 = paramMessageLite.getClass().getDeclaredMethods();
    int j = localObject4.length;
    int i = 0;
    Object localObject5;
    while (i < j)
    {
      localObject5 = localObject4[i];
      ((Map)localObject2).put(((Method)localObject5).getName(), localObject5);
      if (((Method)localObject5).getParameterTypes().length == 0)
      {
        ((Map)localObject1).put(((Method)localObject5).getName(), localObject5);
        if (((Method)localObject5).getName().startsWith("get")) {
          ((Set)localObject3).add(((Method)localObject5).getName());
        }
      }
      i += 1;
    }
    localObject3 = ((Set)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject5 = (String)((Iterator)localObject3).next();
      localObject4 = ((String)localObject5).replaceFirst("get", "");
      Object localObject6;
      Object localObject7;
      if ((((String)localObject4).endsWith("List")) && (!((String)localObject4).endsWith("OrBuilderList")) && (!((String)localObject4).equals("List")))
      {
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append(((String)localObject4).substring(0, 1).toLowerCase());
        ((StringBuilder)localObject6).append(((String)localObject4).substring(1, ((String)localObject4).length() - 4));
        localObject6 = ((StringBuilder)localObject6).toString();
        localObject7 = (Method)((Map)localObject1).get(localObject5);
        if ((localObject7 != null) && (((Method)localObject7).getReturnType().equals(List.class)))
        {
          a(paramStringBuilder, paramInt, a((String)localObject6), GeneratedMessageLite.a((Method)localObject7, paramMessageLite, new Object[0]));
          continue;
        }
      }
      if ((((String)localObject4).endsWith("Map")) && (!((String)localObject4).equals("Map")))
      {
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append(((String)localObject4).substring(0, 1).toLowerCase());
        ((StringBuilder)localObject6).append(((String)localObject4).substring(1, ((String)localObject4).length() - 3));
        localObject6 = ((StringBuilder)localObject6).toString();
        localObject5 = (Method)((Map)localObject1).get(localObject5);
        if ((localObject5 != null) && (((Method)localObject5).getReturnType().equals(Map.class)) && (!((Method)localObject5).isAnnotationPresent(Deprecated.class)) && (Modifier.isPublic(((Method)localObject5).getModifiers())))
        {
          a(paramStringBuilder, paramInt, a((String)localObject6), GeneratedMessageLite.a((Method)localObject5, paramMessageLite, new Object[0]));
          continue;
        }
      }
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("set");
      ((StringBuilder)localObject5).append((String)localObject4);
      if ((Method)((Map)localObject2).get(((StringBuilder)localObject5).toString()) != null) {
        if (((String)localObject4).endsWith("Bytes"))
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("get");
          ((StringBuilder)localObject5).append(((String)localObject4).substring(0, ((String)localObject4).length() - 5));
          if (((Map)localObject1).containsKey(((StringBuilder)localObject5).toString())) {}
        }
        else
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(((String)localObject4).substring(0, 1).toLowerCase());
          ((StringBuilder)localObject5).append(((String)localObject4).substring(1));
          localObject5 = ((StringBuilder)localObject5).toString();
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("get");
          ((StringBuilder)localObject6).append((String)localObject4);
          localObject6 = (Method)((Map)localObject1).get(((StringBuilder)localObject6).toString());
          localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append("has");
          ((StringBuilder)localObject7).append((String)localObject4);
          localObject4 = (Method)((Map)localObject1).get(((StringBuilder)localObject7).toString());
          if (localObject6 != null)
          {
            localObject6 = GeneratedMessageLite.a((Method)localObject6, paramMessageLite, new Object[0]);
            boolean bool;
            if (localObject4 == null)
            {
              if (!a(localObject6)) {
                bool = true;
              } else {
                bool = false;
              }
            }
            else {
              bool = ((Boolean)GeneratedMessageLite.a((Method)localObject4, paramMessageLite, new Object[0])).booleanValue();
            }
            if (bool) {
              a(paramStringBuilder, paramInt, a((String)localObject5), localObject6);
            }
          }
        }
      }
    }
    if ((paramMessageLite instanceof GeneratedMessageLite.ExtendableMessage))
    {
      localObject1 = ((GeneratedMessageLite.ExtendableMessage)paramMessageLite).c.i();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[");
        ((StringBuilder)localObject3).append(((GeneratedMessageLite.ExtensionDescriptor)((Map.Entry)localObject2).getKey()).f());
        ((StringBuilder)localObject3).append("]");
        a(paramStringBuilder, paramInt, ((StringBuilder)localObject3).toString(), ((Map.Entry)localObject2).getValue());
      }
    }
    paramMessageLite = (GeneratedMessageLite)paramMessageLite;
    if (paramMessageLite.a != null) {
      paramMessageLite.a.a(paramStringBuilder, paramInt);
    }
  }
  
  static final void a(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    if ((paramObject instanceof List))
    {
      paramObject = ((List)paramObject).iterator();
      while (paramObject.hasNext()) {
        a(paramStringBuilder, paramInt, paramString, paramObject.next());
      }
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = ((Map)paramObject).entrySet().iterator();
      while (paramObject.hasNext()) {
        a(paramStringBuilder, paramInt, paramString, (Map.Entry)paramObject.next());
      }
      return;
    }
    paramStringBuilder.append('\n');
    int j = 0;
    int k = 0;
    int i = 0;
    while (i < paramInt)
    {
      paramStringBuilder.append(' ');
      i += 1;
    }
    paramStringBuilder.append(paramString);
    if ((paramObject instanceof String))
    {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(TextFormatEscaper.a((String)paramObject));
      paramStringBuilder.append('"');
      return;
    }
    if ((paramObject instanceof ByteString))
    {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(TextFormatEscaper.a((ByteString)paramObject));
      paramStringBuilder.append('"');
      return;
    }
    if ((paramObject instanceof GeneratedMessageLite))
    {
      paramStringBuilder.append(" {");
      a((GeneratedMessageLite)paramObject, paramStringBuilder, paramInt + 2);
      paramStringBuilder.append("\n");
      i = k;
      while (i < paramInt)
      {
        paramStringBuilder.append(' ');
        i += 1;
      }
      paramStringBuilder.append("}");
      return;
    }
    if ((paramObject instanceof Map.Entry))
    {
      paramStringBuilder.append(" {");
      paramString = (Map.Entry)paramObject;
      i = paramInt + 2;
      a(paramStringBuilder, i, "key", paramString.getKey());
      a(paramStringBuilder, i, "value", paramString.getValue());
      paramStringBuilder.append("\n");
      i = j;
      while (i < paramInt)
      {
        paramStringBuilder.append(' ');
        i += 1;
      }
      paramStringBuilder.append("}");
      return;
    }
    paramStringBuilder.append(": ");
    paramStringBuilder.append(paramObject.toString());
  }
  
  private static boolean a(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      return ((Boolean)paramObject).booleanValue() ^ true;
    }
    if ((paramObject instanceof Integer)) {
      return ((Integer)paramObject).intValue() == 0;
    }
    if ((paramObject instanceof Float)) {
      return ((Float)paramObject).floatValue() == 0.0F;
    }
    if ((paramObject instanceof Double)) {
      return ((Double)paramObject).doubleValue() == 0.0D;
    }
    if ((paramObject instanceof String)) {
      return paramObject.equals("");
    }
    if ((paramObject instanceof ByteString)) {
      return paramObject.equals(ByteString.EMPTY);
    }
    if ((paramObject instanceof MessageLite)) {
      return paramObject == ((MessageLite)paramObject).getDefaultInstanceForType();
    }
    if ((paramObject instanceof Enum)) {
      return ((Enum)paramObject).ordinal() == 0;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.MessageLiteToString
 * JD-Core Version:    0.7.0.1
 */