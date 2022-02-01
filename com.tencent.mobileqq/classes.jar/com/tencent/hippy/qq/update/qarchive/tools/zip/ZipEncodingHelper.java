package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class ZipEncodingHelper
{
  private static final byte[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  static final String UTF8 = "UTF8";
  static final ZipEncoding UTF8_ZIP_ENCODING = new FallbackZipEncoding("UTF8");
  private static final String UTF_DASH_8 = "utf-8";
  private static final Map<String, ZipEncodingHelper.SimpleEncodingHolder> simpleEncodings;
  
  static
  {
    HashMap localHashMap = new HashMap();
    ZipEncodingHelper.SimpleEncodingHolder localSimpleEncodingHolder = new ZipEncodingHelper.SimpleEncodingHolder(new char[] { 199, 252, 233, 226, 228, 224, 229, 231, 234, 235, 232, 239, 238, 236, 196, 197, 201, 230, 198, 244, 246, 242, 251, 249, 255, 214, 220, 162, 163, 165, 8359, 402, 225, 237, 243, 250, 241, 209, 170, 186, 191, 8976, 172, 189, 188, 161, 171, 187, 9617, 9618, 9619, 9474, 9508, 9569, 9570, 9558, 9557, 9571, 9553, 9559, 9565, 9564, 9563, 9488, 9492, 9524, 9516, 9500, 9472, 9532, 9566, 9567, 9562, 9556, 9577, 9574, 9568, 9552, 9580, 9575, 9576, 9572, 9573, 9561, 9560, 9554, 9555, 9579, 9578, 9496, 9484, 9608, 9604, 9612, 9616, 9600, 945, 223, 915, 960, 931, 963, 181, 964, 934, 920, 937, 948, 8734, 966, 949, 8745, 8801, 177, 8805, 8804, 8992, 8993, 247, 8776, 176, 8729, 183, 8730, 8319, 178, 9632, 160 });
    localHashMap.put("CP437", localSimpleEncodingHolder);
    localHashMap.put("Cp437", localSimpleEncodingHolder);
    localHashMap.put("cp437", localSimpleEncodingHolder);
    localHashMap.put("IBM437", localSimpleEncodingHolder);
    localHashMap.put("ibm437", localSimpleEncodingHolder);
    localSimpleEncodingHolder = new ZipEncodingHelper.SimpleEncodingHolder(new char[] { 199, 252, 233, 226, 228, 224, 229, 231, 234, 235, 232, 239, 238, 236, 196, 197, 201, 230, 198, 244, 246, 242, 251, 249, 255, 214, 220, 248, 163, 216, 215, 402, 225, 237, 243, 250, 241, 209, 170, 186, 191, 174, 172, 189, 188, 161, 171, 187, 9617, 9618, 9619, 9474, 9508, 193, 194, 192, 169, 9571, 9553, 9559, 9565, 162, 165, 9488, 9492, 9524, 9516, 9500, 9472, 9532, 227, 195, 9562, 9556, 9577, 9574, 9568, 9552, 9580, 164, 240, 208, 202, 203, 200, 305, 205, 206, 207, 9496, 9484, 9608, 9604, 166, 204, 9600, 211, 223, 212, 210, 245, 213, 181, 254, 222, 218, 219, 217, 253, 221, 175, 180, 173, 177, 8215, 190, 182, 167, 247, 184, 176, 168, 183, 185, 179, 178, 9632, 160 });
    localHashMap.put("CP850", localSimpleEncodingHolder);
    localHashMap.put("Cp850", localSimpleEncodingHolder);
    localHashMap.put("cp850", localSimpleEncodingHolder);
    localHashMap.put("IBM850", localSimpleEncodingHolder);
    localHashMap.put("ibm850", localSimpleEncodingHolder);
    simpleEncodings = Collections.unmodifiableMap(localHashMap);
  }
  
  static void appendSurrogate(ByteBuffer paramByteBuffer, char paramChar)
  {
    paramByteBuffer.put((byte)37);
    paramByteBuffer.put((byte)85);
    paramByteBuffer.put(HEX_DIGITS[(paramChar >> '\f' & 0xF)]);
    paramByteBuffer.put(HEX_DIGITS[(paramChar >> '\b' & 0xF)]);
    paramByteBuffer.put(HEX_DIGITS[(paramChar >> '\004' & 0xF)]);
    paramByteBuffer.put(HEX_DIGITS[(paramChar & 0xF)]);
  }
  
  public static ZipEncoding getZipEncoding(String paramString)
  {
    if (isUTF8(paramString)) {
      return UTF8_ZIP_ENCODING;
    }
    if (paramString == null) {
      return new FallbackZipEncoding();
    }
    Object localObject = (ZipEncodingHelper.SimpleEncodingHolder)simpleEncodings.get(paramString);
    if (localObject != null) {
      return ((ZipEncodingHelper.SimpleEncodingHolder)localObject).getEncoding();
    }
    try
    {
      localObject = new NioZipEncoding(Charset.forName(paramString));
      return localObject;
    }
    catch (UnsupportedCharsetException localUnsupportedCharsetException)
    {
      label59:
      break label59;
    }
    return new FallbackZipEncoding(paramString);
  }
  
  static ByteBuffer growBuffer(ByteBuffer paramByteBuffer, int paramInt)
  {
    paramByteBuffer.limit(paramByteBuffer.position());
    paramByteBuffer.rewind();
    int i = paramByteBuffer.capacity() * 2;
    if (i >= paramInt) {
      paramInt = i;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt);
    localByteBuffer.put(paramByteBuffer);
    return localByteBuffer;
  }
  
  static boolean isUTF8(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = System.getProperty("file.encoding");
    }
    return ("UTF8".equalsIgnoreCase(str)) || ("utf-8".equalsIgnoreCase(str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.ZipEncodingHelper
 * JD-Core Version:    0.7.0.1
 */