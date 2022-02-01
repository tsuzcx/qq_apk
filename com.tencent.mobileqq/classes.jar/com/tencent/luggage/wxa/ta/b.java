package com.tencent.luggage.wxa.ta;

import java.io.IOException;

public class b
  extends IOException
{
  public b(String paramString)
  {
    super(paramString);
  }
  
  static b a()
  {
    return new b("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static b b()
  {
    return new b("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static b c()
  {
    return new b("CodedInputStream encountered a malformed varint.");
  }
  
  static b d()
  {
    return new b("Protocol message contained an invalid tag (zero).");
  }
  
  static b e()
  {
    return new b("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ta.b
 * JD-Core Version:    0.7.0.1
 */