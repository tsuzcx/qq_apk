package com.google.protobuf;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Locale;
import java.util.logging.Logger;

public final class TextFormat
{
  private static final Logger a = Logger.getLogger(TextFormat.class.getName());
  private static final TextFormat.Parser b = TextFormat.Parser.a().a();
  
  private static long a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    boolean bool = paramString.startsWith("-", 0);
    int k = 1;
    if (bool)
    {
      if (paramBoolean1)
      {
        i = 1;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Number must be positive: ");
        ((StringBuilder)localObject).append(paramString);
        throw new NumberFormatException(((StringBuilder)localObject).toString());
      }
    }
    else {
      k = 0;
    }
    int j = 10;
    int m;
    if (paramString.startsWith("0x", i))
    {
      m = i + 2;
      j = 16;
    }
    else
    {
      m = i;
      if (paramString.startsWith("0", i))
      {
        j = 8;
        m = i;
      }
    }
    Object localObject = paramString.substring(m);
    long l2;
    if (((String)localObject).length() < 16)
    {
      l2 = Long.parseLong((String)localObject, j);
      long l1 = l2;
      if (k != 0) {
        l1 = -l2;
      }
      l2 = l1;
      if (!paramBoolean2)
      {
        if (paramBoolean1)
        {
          if ((l1 <= 2147483647L) && (l1 >= -2147483648L)) {
            return l1;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Number out of range for 32-bit signed integer: ");
          ((StringBuilder)localObject).append(paramString);
          throw new NumberFormatException(((StringBuilder)localObject).toString());
        }
        if ((l1 < 4294967296L) && (l1 >= 0L)) {
          return l1;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Number out of range for 32-bit unsigned integer: ");
        ((StringBuilder)localObject).append(paramString);
        throw new NumberFormatException(((StringBuilder)localObject).toString());
      }
    }
    else
    {
      BigInteger localBigInteger = new BigInteger((String)localObject, j);
      localObject = localBigInteger;
      if (k != 0) {
        localObject = localBigInteger.negate();
      }
      if (!paramBoolean2)
      {
        if (paramBoolean1)
        {
          if (((BigInteger)localObject).bitLength() > 31)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Number out of range for 32-bit signed integer: ");
            ((StringBuilder)localObject).append(paramString);
            throw new NumberFormatException(((StringBuilder)localObject).toString());
          }
        }
        else if (((BigInteger)localObject).bitLength() > 32)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Number out of range for 32-bit unsigned integer: ");
          ((StringBuilder)localObject).append(paramString);
          throw new NumberFormatException(((StringBuilder)localObject).toString());
        }
      }
      else if (paramBoolean1)
      {
        if (((BigInteger)localObject).bitLength() > 63)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Number out of range for 64-bit signed integer: ");
          ((StringBuilder)localObject).append(paramString);
          throw new NumberFormatException(((StringBuilder)localObject).toString());
        }
      }
      else {
        if (((BigInteger)localObject).bitLength() > 64) {
          break label492;
        }
      }
      l2 = ((BigInteger)localObject).longValue();
    }
    return l2;
    label492:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Number out of range for 64-bit unsigned integer: ");
    ((StringBuilder)localObject).append(paramString);
    throw new NumberFormatException(((StringBuilder)localObject).toString());
  }
  
  public static ByteString a(CharSequence paramCharSequence)
  {
    paramCharSequence = ByteString.copyFromUtf8(paramCharSequence.toString());
    byte[] arrayOfByte = new byte[paramCharSequence.size()];
    int i = 0;
    int j;
    for (int m = 0; i < paramCharSequence.size(); m = j)
    {
      byte b1 = paramCharSequence.byteAt(i);
      if (b1 == 92)
      {
        k = i + 1;
        if (k < paramCharSequence.size())
        {
          b1 = paramCharSequence.byteAt(k);
          int i1;
          int n;
          if (a(b1))
          {
            i1 = c(b1);
            n = k + 1;
            j = k;
            i = i1;
            if (n < paramCharSequence.size())
            {
              j = k;
              i = i1;
              if (a(paramCharSequence.byteAt(n)))
              {
                i = i1 * 8 + c(paramCharSequence.byteAt(n));
                j = n;
              }
            }
            i1 = j + 1;
            k = j;
            n = i;
            if (i1 < paramCharSequence.size())
            {
              k = j;
              n = i;
              if (a(paramCharSequence.byteAt(i1)))
              {
                n = i * 8 + c(paramCharSequence.byteAt(i1));
                k = i1;
              }
            }
            j = m + 1;
            arrayOfByte[m] = ((byte)n);
            i = k;
          }
          else
          {
            if (b1 != 34)
            {
              if (b1 != 39)
              {
                if (b1 != 92)
                {
                  if (b1 != 102)
                  {
                    if (b1 != 110)
                    {
                      if (b1 != 114)
                      {
                        if (b1 != 116)
                        {
                          if (b1 != 118)
                          {
                            if (b1 != 120)
                            {
                              if (b1 != 97)
                              {
                                if (b1 == 98)
                                {
                                  i = m + 1;
                                  arrayOfByte[m] = 8;
                                }
                                else
                                {
                                  paramCharSequence = new StringBuilder();
                                  paramCharSequence.append("Invalid escape sequence: '\\");
                                  paramCharSequence.append((char)b1);
                                  paramCharSequence.append('\'');
                                  throw new TextFormat.InvalidEscapeSequenceException(paramCharSequence.toString());
                                }
                              }
                              else
                              {
                                i = m + 1;
                                arrayOfByte[m] = 7;
                              }
                            }
                            else
                            {
                              n = k + 1;
                              if ((n < paramCharSequence.size()) && (b(paramCharSequence.byteAt(n))))
                              {
                                i1 = c(paramCharSequence.byteAt(n));
                                k = n + 1;
                                i = n;
                                j = i1;
                                if (k < paramCharSequence.size())
                                {
                                  i = n;
                                  j = i1;
                                  if (b(paramCharSequence.byteAt(k)))
                                  {
                                    j = i1 * 16 + c(paramCharSequence.byteAt(k));
                                    i = k;
                                  }
                                }
                                k = m + 1;
                                arrayOfByte[m] = ((byte)j);
                                j = k;
                                break label617;
                              }
                              throw new TextFormat.InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
                            }
                          }
                          else
                          {
                            i = m + 1;
                            arrayOfByte[m] = 11;
                          }
                        }
                        else
                        {
                          i = m + 1;
                          arrayOfByte[m] = 9;
                        }
                      }
                      else
                      {
                        i = m + 1;
                        arrayOfByte[m] = 13;
                      }
                    }
                    else
                    {
                      i = m + 1;
                      arrayOfByte[m] = 10;
                    }
                  }
                  else
                  {
                    i = m + 1;
                    arrayOfByte[m] = 12;
                  }
                }
                else
                {
                  i = m + 1;
                  arrayOfByte[m] = 92;
                }
              }
              else
              {
                i = m + 1;
                arrayOfByte[m] = 39;
              }
            }
            else
            {
              i = m + 1;
              arrayOfByte[m] = 34;
            }
            j = i;
            break label620;
          }
        }
        else
        {
          throw new TextFormat.InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
        }
      }
      else
      {
        j = m + 1;
        arrayOfByte[m] = b1;
      }
      label617:
      int k = i;
      label620:
      i = k + 1;
    }
    if (arrayOfByte.length == m) {
      return ByteString.wrap(arrayOfByte);
    }
    return ByteString.copyFrom(arrayOfByte, 0, m);
  }
  
  private static TextFormat.TextGenerator a(Appendable paramAppendable)
  {
    return new TextFormat.TextGenerator(paramAppendable, false, null);
  }
  
  public static String a(int paramInt)
  {
    if (paramInt >= 0) {
      return Integer.toString(paramInt);
    }
    return Long.toString(paramInt & 0xFFFFFFFF);
  }
  
  public static String a(long paramLong)
  {
    if (paramLong >= 0L) {
      return Long.toString(paramLong);
    }
    return BigInteger.valueOf(paramLong & 0xFFFFFFFF).setBit(63).toString();
  }
  
  public static String a(ByteString paramByteString)
  {
    return TextFormatEscaper.a(paramByteString);
  }
  
  public static String a(MessageOrBuilder paramMessageOrBuilder)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      a(paramMessageOrBuilder, localStringBuilder);
      paramMessageOrBuilder = localStringBuilder.toString();
      return paramMessageOrBuilder;
    }
    catch (IOException paramMessageOrBuilder)
    {
      throw new IllegalStateException(paramMessageOrBuilder);
    }
  }
  
  public static String a(UnknownFieldSet paramUnknownFieldSet)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      a(paramUnknownFieldSet, localStringBuilder);
      paramUnknownFieldSet = localStringBuilder.toString();
      return paramUnknownFieldSet;
    }
    catch (IOException paramUnknownFieldSet)
    {
      throw new IllegalStateException(paramUnknownFieldSet);
    }
  }
  
  public static String a(String paramString)
  {
    return TextFormatEscaper.b(paramString);
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return TextFormatEscaper.a(paramArrayOfByte);
  }
  
  public static void a(MessageOrBuilder paramMessageOrBuilder, Appendable paramAppendable)
  {
    TextFormat.Printer.a(TextFormat.Printer.a, paramMessageOrBuilder, a(paramAppendable));
  }
  
  public static void a(UnknownFieldSet paramUnknownFieldSet, Appendable paramAppendable)
  {
    TextFormat.Printer.a(TextFormat.Printer.a, paramUnknownFieldSet, a(paramAppendable));
  }
  
  private static boolean a(byte paramByte)
  {
    return (48 <= paramByte) && (paramByte <= 55);
  }
  
  static int b(String paramString)
  {
    return (int)a(paramString, true, false);
  }
  
  private static void b(int paramInt, Object paramObject, TextFormat.TextGenerator paramTextGenerator)
  {
    int i = WireFormat.a(paramInt);
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 5)
            {
              paramTextGenerator.a(String.format((Locale)null, "0x%08x", new Object[] { (Integer)paramObject }));
              return;
            }
            paramObject = new StringBuilder();
            paramObject.append("Bad tag: ");
            paramObject.append(paramInt);
            throw new IllegalArgumentException(paramObject.toString());
          }
          TextFormat.Printer.a(TextFormat.Printer.a, (UnknownFieldSet)paramObject, paramTextGenerator);
          return;
        }
      }
    }
    try
    {
      UnknownFieldSet localUnknownFieldSet = UnknownFieldSet.a((ByteString)paramObject);
      paramTextGenerator.a("{");
      paramTextGenerator.c();
      paramTextGenerator.a();
      TextFormat.Printer.a(TextFormat.Printer.a, localUnknownFieldSet, paramTextGenerator);
      paramTextGenerator.b();
      paramTextGenerator.a("}");
      return;
    }
    catch (InvalidProtocolBufferException localInvalidProtocolBufferException)
    {
      label144:
      break label144;
    }
    paramTextGenerator.a("\"");
    paramTextGenerator.a(a((ByteString)paramObject));
    paramTextGenerator.a("\"");
    return;
    paramTextGenerator.a(String.format((Locale)null, "0x%016x", new Object[] { (Long)paramObject }));
    return;
    paramTextGenerator.a(a(((Long)paramObject).longValue()));
  }
  
  private static boolean b(byte paramByte)
  {
    return ((48 <= paramByte) && (paramByte <= 57)) || ((97 <= paramByte) && (paramByte <= 102)) || ((65 <= paramByte) && (paramByte <= 70));
  }
  
  private static int c(byte paramByte)
  {
    if ((48 <= paramByte) && (paramByte <= 57)) {
      return paramByte - 48;
    }
    if ((97 <= paramByte) && (paramByte <= 122)) {
      paramByte -= 97;
    }
    for (;;)
    {
      return paramByte + 10;
      paramByte -= 65;
    }
  }
  
  static int c(String paramString)
  {
    return (int)a(paramString, false, false);
  }
  
  static long d(String paramString)
  {
    return a(paramString, true, true);
  }
  
  static long e(String paramString)
  {
    return a(paramString, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.TextFormat
 * JD-Core Version:    0.7.0.1
 */