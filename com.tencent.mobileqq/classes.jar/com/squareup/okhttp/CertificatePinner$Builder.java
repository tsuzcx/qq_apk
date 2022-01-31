package com.squareup.okhttp;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import okio.ByteString;

public final class CertificatePinner$Builder
{
  private final Map<String, Set<ByteString>> hostnameToPins = new LinkedHashMap();
  
  public Builder add(String paramString, String... paramVarArgs)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("hostname == null");
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    paramString = (Set)this.hostnameToPins.put(paramString, Collections.unmodifiableSet(localLinkedHashSet));
    if (paramString != null) {
      localLinkedHashSet.addAll(paramString);
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramVarArgs[i];
      if (!paramString.startsWith("sha1/")) {
        throw new IllegalArgumentException("pins must start with 'sha1/': " + paramString);
      }
      ByteString localByteString = ByteString.decodeBase64(paramString.substring("sha1/".length()));
      if (localByteString == null) {
        throw new IllegalArgumentException("pins must be base64: " + paramString);
      }
      localLinkedHashSet.add(localByteString);
      i += 1;
    }
    return this;
  }
  
  public CertificatePinner build()
  {
    return new CertificatePinner(this, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.CertificatePinner.Builder
 * JD-Core Version:    0.7.0.1
 */