package com.google.protobuf;

final class TextFormatEscaper
{
  static String a(ByteString paramByteString)
  {
    return a(new TextFormatEscaper.1(paramByteString));
  }
  
  static String a(TextFormatEscaper.ByteSequence paramByteSequence)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramByteSequence.a());
    int i = 0;
    while (i < paramByteSequence.a())
    {
      int j = paramByteSequence.a(i);
      if (j != 34)
      {
        if (j != 39)
        {
          if (j != 92) {
            switch (j)
            {
            default: 
              if ((j >= 32) && (j <= 126))
              {
                localStringBuilder.append((char)j);
              }
              else
              {
                localStringBuilder.append('\\');
                localStringBuilder.append((char)((j >>> 6 & 0x3) + 48));
                localStringBuilder.append((char)((j >>> 3 & 0x7) + 48));
                localStringBuilder.append((char)((j & 0x7) + 48));
              }
              break;
            case 13: 
              localStringBuilder.append("\\r");
              break;
            case 12: 
              localStringBuilder.append("\\f");
              break;
            case 11: 
              localStringBuilder.append("\\v");
              break;
            case 10: 
              localStringBuilder.append("\\n");
              break;
            case 9: 
              localStringBuilder.append("\\t");
              break;
            case 8: 
              localStringBuilder.append("\\b");
              break;
            case 7: 
              localStringBuilder.append("\\a");
              break;
            }
          } else {
            localStringBuilder.append("\\\\");
          }
        }
        else {
          localStringBuilder.append("\\'");
        }
      }
      else {
        localStringBuilder.append("\\\"");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  static String a(String paramString)
  {
    return a(ByteString.copyFromUtf8(paramString));
  }
  
  static String a(byte[] paramArrayOfByte)
  {
    return a(new TextFormatEscaper.2(paramArrayOfByte));
  }
  
  static String b(String paramString)
  {
    return paramString.replace("\\", "\\\\").replace("\"", "\\\"");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.TextFormatEscaper
 * JD-Core Version:    0.7.0.1
 */