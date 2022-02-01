package com.google.protobuf.nano;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class MessageNanoPrinter
{
  private static final String INDENT = "  ";
  private static final int MAX_STRING_LEN = 200;
  
  private static void appendQuotedBytes(byte[] paramArrayOfByte, StringBuffer paramStringBuffer)
  {
    if (paramArrayOfByte == null)
    {
      paramStringBuffer.append("\"\"");
      return;
    }
    paramStringBuffer.append('"');
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      if ((j != 92) && (j != 34))
      {
        if ((j >= 32) && (j < 127)) {
          paramStringBuffer.append((char)j);
        } else {
          paramStringBuffer.append(String.format("\\%03o", new Object[] { Integer.valueOf(j) }));
        }
      }
      else
      {
        paramStringBuffer.append('\\');
        paramStringBuffer.append((char)j);
      }
      i += 1;
    }
    paramStringBuffer.append('"');
  }
  
  private static String deCamelCaseify(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (i == 0)
      {
        localStringBuffer.append(Character.toLowerCase(c));
      }
      else if (Character.isUpperCase(c))
      {
        localStringBuffer.append('_');
        localStringBuffer.append(Character.toLowerCase(c));
      }
      else
      {
        localStringBuffer.append(c);
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static String escapeString(String paramString)
  {
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    while (i < j)
    {
      char c = paramString.charAt(i);
      if ((c >= ' ') && (c <= '~') && (c != '"') && (c != '\'')) {
        localStringBuilder.append(c);
      } else {
        localStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static <T extends MessageNano> String print(T paramT)
  {
    if (paramT == null) {
      return "";
    }
    Object localObject = new StringBuffer();
    try
    {
      print(null, paramT, new StringBuffer(), (StringBuffer)localObject);
      return ((StringBuffer)localObject).toString();
    }
    catch (InvocationTargetException paramT)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Error printing proto: ");
      ((StringBuilder)localObject).append(paramT.getMessage());
      return ((StringBuilder)localObject).toString();
    }
    catch (IllegalAccessException paramT)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Error printing proto: ");
      ((StringBuilder)localObject).append(paramT.getMessage());
    }
    return ((StringBuilder)localObject).toString();
  }
  
  private static void print(String paramString, Object paramObject, StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2)
  {
    if (paramObject == null) {
      return;
    }
    Object localObject1;
    int i;
    if ((paramObject instanceof MessageNano))
    {
      int m = paramStringBuffer1.length();
      if (paramString != null)
      {
        paramStringBuffer2.append(paramStringBuffer1);
        paramStringBuffer2.append(deCamelCaseify(paramString));
        paramStringBuffer2.append(" <\n");
        paramStringBuffer1.append("  ");
      }
      localObject1 = paramObject.getClass();
      Object localObject2 = ((Class)localObject1).getFields();
      int n = localObject2.length;
      i = 0;
      String str;
      Object localObject3;
      while (i < n)
      {
        Object localObject4 = localObject2[i];
        j = localObject4.getModifiers();
        str = localObject4.getName();
        if ((!"cachedSize".equals(str)) && ((j & 0x1) == 1) && ((j & 0x8) != 8) && (!str.startsWith("_")) && (!str.endsWith("_")))
        {
          localObject3 = localObject4.getType();
          localObject4 = localObject4.get(paramObject);
          if (((Class)localObject3).isArray())
          {
            if (((Class)localObject3).getComponentType() == Byte.TYPE)
            {
              print(str, localObject4, paramStringBuffer1, paramStringBuffer2);
            }
            else
            {
              if (localObject4 == null) {
                j = 0;
              } else {
                j = Array.getLength(localObject4);
              }
              int k = 0;
              while (k < j)
              {
                print(str, Array.get(localObject4, k), paramStringBuffer1, paramStringBuffer2);
                k += 1;
              }
            }
          }
          else {
            print(str, localObject4, paramStringBuffer1, paramStringBuffer2);
          }
        }
        i += 1;
      }
      localObject2 = ((Class)localObject1).getMethods();
      int j = localObject2.length;
      i = 0;
      while (i < j)
      {
        str = localObject2[i].getName();
        if (str.startsWith("set")) {
          str = str.substring(3);
        }
        try
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("has");
          ((StringBuilder)localObject3).append(str);
          localObject3 = ((Class)localObject1).getMethod(((StringBuilder)localObject3).toString(), new Class[0]);
          if (((Boolean)((Method)localObject3).invoke(paramObject, new Object[0])).booleanValue())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("get");
            ((StringBuilder)localObject3).append(str);
            localObject3 = ((Class)localObject1).getMethod(((StringBuilder)localObject3).toString(), new Class[0]);
            print(str, ((Method)localObject3).invoke(paramObject, new Object[0]), paramStringBuffer1, paramStringBuffer2);
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          label437:
          break label437;
        }
        i += 1;
      }
      if (paramString != null)
      {
        paramStringBuffer1.setLength(m);
        paramStringBuffer2.append(paramStringBuffer1);
        paramStringBuffer2.append(">\n");
      }
    }
    else
    {
      if ((paramObject instanceof Map))
      {
        paramObject = (Map)paramObject;
        paramString = deCamelCaseify(paramString);
        paramObject = paramObject.entrySet().iterator();
        while (paramObject.hasNext())
        {
          localObject1 = (Map.Entry)paramObject.next();
          paramStringBuffer2.append(paramStringBuffer1);
          paramStringBuffer2.append(paramString);
          paramStringBuffer2.append(" <\n");
          i = paramStringBuffer1.length();
          paramStringBuffer1.append("  ");
          print("key", ((Map.Entry)localObject1).getKey(), paramStringBuffer1, paramStringBuffer2);
          print("value", ((Map.Entry)localObject1).getValue(), paramStringBuffer1, paramStringBuffer2);
          paramStringBuffer1.setLength(i);
          paramStringBuffer2.append(paramStringBuffer1);
          paramStringBuffer2.append(">\n");
        }
      }
      paramString = deCamelCaseify(paramString);
      paramStringBuffer2.append(paramStringBuffer1);
      paramStringBuffer2.append(paramString);
      paramStringBuffer2.append(": ");
      if ((paramObject instanceof String))
      {
        paramString = sanitizeString((String)paramObject);
        paramStringBuffer2.append("\"");
        paramStringBuffer2.append(paramString);
        paramStringBuffer2.append("\"");
      }
      else if ((paramObject instanceof byte[]))
      {
        appendQuotedBytes((byte[])paramObject, paramStringBuffer2);
      }
      else
      {
        paramStringBuffer2.append(paramObject);
      }
      paramStringBuffer2.append("\n");
    }
  }
  
  private static String sanitizeString(String paramString)
  {
    Object localObject = paramString;
    if (!paramString.startsWith("http"))
    {
      localObject = paramString;
      if (paramString.length() > 200)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, 200));
        ((StringBuilder)localObject).append("[...]");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return escapeString((String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.MessageNanoPrinter
 * JD-Core Version:    0.7.0.1
 */