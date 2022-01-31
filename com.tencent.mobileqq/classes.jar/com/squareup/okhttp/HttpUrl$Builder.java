package com.squareup.okhttp;

import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import okio.Buffer;

public final class HttpUrl$Builder
{
  String encodedFragment;
  String encodedPassword = "";
  final List<String> encodedPathSegments = new ArrayList();
  List<String> encodedQueryNamesAndValues;
  String encodedUsername = "";
  String host;
  int port = -1;
  String scheme;
  
  public HttpUrl$Builder()
  {
    this.encodedPathSegments.add("");
  }
  
  private static String canonicalizeHost(String paramString, int paramInt1, int paramInt2)
  {
    paramString = HttpUrl.percentDecode(paramString, paramInt1, paramInt2, false);
    if ((paramString.startsWith("[")) && (paramString.endsWith("]")))
    {
      paramString = decodeIpv6(paramString, 1, paramString.length() - 1);
      if (paramString == null) {
        return null;
      }
      paramString = paramString.getAddress();
      if (paramString.length == 16) {
        return inet6AddressToAscii(paramString);
      }
      throw new AssertionError();
    }
    return domainToAscii(paramString);
  }
  
  private static boolean containsInvalidHostnameAsciiCodes(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      int j;
      if (i < paramString.length())
      {
        j = paramString.charAt(i);
        if ((j <= 31) || (j >= 127)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      if (" #%/:?@[\\]".indexOf(j) != -1) {
        return true;
      }
      i += 1;
    }
  }
  
  private static boolean decodeIpv4Suffix(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
  {
    int j = paramInt3;
    int i = paramInt1;
    while (i < paramInt2)
    {
      if (j == paramArrayOfByte.length) {
        return false;
      }
      paramInt1 = i;
      if (j != paramInt3)
      {
        if (paramString.charAt(i) != '.') {
          return false;
        }
        paramInt1 = i + 1;
      }
      int k = 0;
      i = paramInt1;
      for (;;)
      {
        int m;
        if (i < paramInt2)
        {
          m = paramString.charAt(i);
          if ((m >= 48) && (m <= 57)) {}
        }
        else
        {
          if (i - paramInt1 != 0) {
            break;
          }
          return false;
        }
        if ((k == 0) && (paramInt1 != i)) {
          return false;
        }
        k = k * 10 + m - 48;
        if (k > 255) {
          return false;
        }
        i += 1;
      }
      paramArrayOfByte[j] = ((byte)k);
      j += 1;
    }
    return j == paramInt3 + 4;
  }
  
  private static InetAddress decodeIpv6(String paramString, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[16];
    int i1 = -1;
    int j = -1;
    int i = 0;
    int k = paramInt1;
    int m = j;
    paramInt1 = i;
    if (k < paramInt2)
    {
      if (i == arrayOfByte.length) {
        return null;
      }
      if ((k + 2 <= paramInt2) && (paramString.regionMatches(k, "::", 0, 2)))
      {
        if (j != -1) {
          return null;
        }
        paramInt1 = k + 2;
        i += 2;
        if (paramInt1 != paramInt2) {
          break label352;
        }
        paramInt1 = i;
        m = i;
      }
    }
    else
    {
      if (paramInt1 == arrayOfByte.length) {
        break label335;
      }
      if (m != -1) {
        break label298;
      }
      return null;
    }
    paramInt1 = k;
    m = j;
    int n = i;
    if (i != 0)
    {
      if (!paramString.regionMatches(k, ":", 0, 1)) {
        break label184;
      }
      paramInt1 = k + 1;
      n = i;
    }
    for (m = j;; m = i)
    {
      j = 0;
      i = paramInt1;
      for (;;)
      {
        if (i < paramInt2)
        {
          k = HttpUrl.decodeHexDigit(paramString.charAt(i));
          if (k != -1) {}
        }
        else
        {
          k = i - paramInt1;
          if ((k != 0) && (k <= 4)) {
            break label243;
          }
          return null;
          label184:
          if (paramString.regionMatches(k, ".", 0, 1))
          {
            if (!decodeIpv4Suffix(paramString, i1, paramInt2, arrayOfByte, i - 2)) {
              return null;
            }
            paramInt1 = i + 2;
            m = j;
            break;
          }
          return null;
        }
        j = (j << 4) + k;
        i += 1;
      }
      label243:
      k = n + 1;
      arrayOfByte[n] = ((byte)(j >>> 8 & 0xFF));
      n = k + 1;
      arrayOfByte[k] = ((byte)(j & 0xFF));
      k = i;
      j = m;
      i = n;
      i1 = paramInt1;
      break;
      label298:
      System.arraycopy(arrayOfByte, m, arrayOfByte, arrayOfByte.length - (paramInt1 - m), paramInt1 - m);
      Arrays.fill(arrayOfByte, m, arrayOfByte.length - paramInt1 + m, (byte)0);
      try
      {
        label335:
        paramString = InetAddress.getByAddress(arrayOfByte);
        return paramString;
      }
      catch (UnknownHostException paramString)
      {
        throw new AssertionError();
      }
      label352:
      n = i;
    }
  }
  
  private static String domainToAscii(String paramString)
  {
    try
    {
      paramString = IDN.toASCII(paramString).toLowerCase(Locale.US);
      if (paramString.isEmpty()) {
        return null;
      }
      boolean bool = containsInvalidHostnameAsciiCodes(paramString);
      if (!bool) {
        return paramString;
      }
    }
    catch (IllegalArgumentException paramString) {}
    return null;
  }
  
  private static String inet6AddressToAscii(byte[] paramArrayOfByte)
  {
    int i1 = 0;
    int j = 0;
    int k = -1;
    int i = 0;
    int m;
    while (i < paramArrayOfByte.length)
    {
      m = i;
      while ((m < 16) && (paramArrayOfByte[m] == 0) && (paramArrayOfByte[(m + 1)] == 0)) {
        m += 2;
      }
      int i2 = m - i;
      int n = j;
      if (i2 > j)
      {
        n = i2;
        k = i;
      }
      i = m + 2;
      j = n;
    }
    Buffer localBuffer = new Buffer();
    i = i1;
    while (i < paramArrayOfByte.length) {
      if (i == k)
      {
        localBuffer.writeByte(58);
        m = i + j;
        i = m;
        if (m == 16)
        {
          localBuffer.writeByte(58);
          i = m;
        }
      }
      else
      {
        if (i > 0) {
          localBuffer.writeByte(58);
        }
        localBuffer.writeHexadecimalUnsignedLong((paramArrayOfByte[i] & 0xFF) << 8 | paramArrayOfByte[(i + 1)] & 0xFF);
        i += 2;
      }
    }
    return localBuffer.readUtf8();
  }
  
  private boolean isDot(String paramString)
  {
    return (paramString.equals(".")) || (paramString.equalsIgnoreCase("%2e"));
  }
  
  private boolean isDotDot(String paramString)
  {
    return (paramString.equals("..")) || (paramString.equalsIgnoreCase("%2e.")) || (paramString.equalsIgnoreCase(".%2e")) || (paramString.equalsIgnoreCase("%2e%2e"));
  }
  
  private static int parsePort(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = Integer.parseInt(HttpUrl.canonicalize(paramString, paramInt1, paramInt2, "", false, false, true));
      if ((paramInt1 > 0) && (paramInt1 <= 65535)) {
        return paramInt1;
      }
      return -1;
    }
    catch (NumberFormatException paramString) {}
    return -1;
  }
  
  private void pop()
  {
    if ((((String)this.encodedPathSegments.remove(this.encodedPathSegments.size() - 1)).isEmpty()) && (!this.encodedPathSegments.isEmpty()))
    {
      this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, "");
      return;
    }
    this.encodedPathSegments.add("");
  }
  
  private static int portColonOffset(String paramString, int paramInt1, int paramInt2)
  {
    int i;
    int j;
    if (paramInt1 < paramInt2)
    {
      i = paramInt1;
      j = paramInt1;
    }
    switch (paramString.charAt(paramInt1))
    {
    default: 
      i = paramInt1;
    case '[': 
      for (;;)
      {
        paramInt1 = i + 1;
        break;
        do
        {
          paramInt1 = i + 1;
          i = paramInt1;
          if (paramInt1 >= paramInt2) {
            break;
          }
          i = paramInt1;
        } while (paramString.charAt(paramInt1) != ']');
        i = paramInt1;
      }
      j = paramInt2;
    }
    return j;
  }
  
  private void push(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = HttpUrl.canonicalize(paramString, paramInt1, paramInt2, " \"<>^`{}|/\\?#", paramBoolean2, false, true);
    if (isDot(paramString)) {}
    for (;;)
    {
      return;
      if (isDotDot(paramString))
      {
        pop();
        return;
      }
      if (((String)this.encodedPathSegments.get(this.encodedPathSegments.size() - 1)).isEmpty()) {
        this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, paramString);
      }
      while (paramBoolean1)
      {
        this.encodedPathSegments.add("");
        return;
        this.encodedPathSegments.add(paramString);
      }
    }
  }
  
  private void removeAllCanonicalQueryParameters(String paramString)
  {
    int i = this.encodedQueryNamesAndValues.size() - 2;
    for (;;)
    {
      if (i >= 0)
      {
        if (paramString.equals(this.encodedQueryNamesAndValues.get(i)))
        {
          this.encodedQueryNamesAndValues.remove(i + 1);
          this.encodedQueryNamesAndValues.remove(i);
          if (this.encodedQueryNamesAndValues.isEmpty()) {
            this.encodedQueryNamesAndValues = null;
          }
        }
      }
      else {
        return;
      }
      i -= 2;
    }
  }
  
  private void resolvePath(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    int i = paramString.charAt(paramInt1);
    if ((i == 47) || (i == 92))
    {
      this.encodedPathSegments.clear();
      this.encodedPathSegments.add("");
      paramInt1 += 1;
      label52:
      if (paramInt1 >= paramInt2) {
        break label127;
      }
      i = HttpUrl.access$200(paramString, paramInt1, paramInt2, "/\\");
      if (i >= paramInt2) {
        break label129;
      }
    }
    label129:
    for (boolean bool = true;; bool = false)
    {
      push(paramString, paramInt1, i, bool, true);
      paramInt1 = i;
      if (bool) {
        paramInt1 = i + 1;
      }
      break label52;
      this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, "");
      break label52;
      label127:
      break;
    }
  }
  
  private static int schemeDelimiterOffset(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 - paramInt1 < 2) {}
    int i;
    label115:
    do
    {
      for (;;)
      {
        return -1;
        i = paramString.charAt(paramInt1);
        if (((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)))
        {
          paramInt1 += 1;
          while (paramInt1 < paramInt2)
          {
            i = paramString.charAt(paramInt1);
            if (((i < 97) || (i > 122)) && ((i < 65) || (i > 90)) && ((i < 48) || (i > 57)) && (i != 43) && (i != 45) && (i != 46)) {
              break label115;
            }
            paramInt1 += 1;
          }
        }
      }
    } while (i != 58);
    return paramInt1;
  }
  
  private int skipLeadingAsciiWhitespace(String paramString, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i = paramInt2;
      if (paramInt1 < paramInt2) {}
      switch (paramString.charAt(paramInt1))
      {
      default: 
        i = paramInt1;
        return i;
      }
      paramInt1 += 1;
    }
  }
  
  private int skipTrailingAsciiWhitespace(String paramString, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    for (;;)
    {
      int i = paramInt1;
      if (paramInt2 >= paramInt1) {}
      switch (paramString.charAt(paramInt2))
      {
      default: 
        i = paramInt2 + 1;
        return i;
      }
      paramInt2 -= 1;
    }
  }
  
  private static int slashCount(String paramString, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (paramInt1 < paramInt2)
    {
      int j = paramString.charAt(paramInt1);
      if ((j != 92) && (j != 47)) {
        break;
      }
      i += 1;
      paramInt1 += 1;
    }
    return i;
  }
  
  public Builder addEncodedPathSegment(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("encodedPathSegment == null");
    }
    push(paramString, 0, paramString.length(), false, true);
    return this;
  }
  
  public Builder addEncodedQueryParameter(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("encodedName == null");
    }
    if (this.encodedQueryNamesAndValues == null) {
      this.encodedQueryNamesAndValues = new ArrayList();
    }
    this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(paramString1, " \"'<>#&=", true, true, true));
    List localList = this.encodedQueryNamesAndValues;
    if (paramString2 != null) {}
    for (paramString1 = HttpUrl.canonicalize(paramString2, " \"'<>#&=", true, true, true);; paramString1 = null)
    {
      localList.add(paramString1);
      return this;
    }
  }
  
  public Builder addPathSegment(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("pathSegment == null");
    }
    push(paramString, 0, paramString.length(), false, false);
    return this;
  }
  
  public Builder addQueryParameter(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("name == null");
    }
    if (this.encodedQueryNamesAndValues == null) {
      this.encodedQueryNamesAndValues = new ArrayList();
    }
    this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(paramString1, " \"'<>#&=", false, true, true));
    List localList = this.encodedQueryNamesAndValues;
    if (paramString2 != null) {}
    for (paramString1 = HttpUrl.canonicalize(paramString2, " \"'<>#&=", false, true, true);; paramString1 = null)
    {
      localList.add(paramString1);
      return this;
    }
  }
  
  public HttpUrl build()
  {
    if (this.scheme == null) {
      throw new IllegalStateException("scheme == null");
    }
    if (this.host == null) {
      throw new IllegalStateException("host == null");
    }
    return new HttpUrl(this, null);
  }
  
  int effectivePort()
  {
    if (this.port != -1) {
      return this.port;
    }
    return HttpUrl.defaultPort(this.scheme);
  }
  
  public Builder encodedFragment(String paramString)
  {
    if (paramString != null) {}
    for (paramString = HttpUrl.canonicalize(paramString, "", true, false, false);; paramString = null)
    {
      this.encodedFragment = paramString;
      return this;
    }
  }
  
  public Builder encodedPassword(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("encodedPassword == null");
    }
    this.encodedPassword = HttpUrl.canonicalize(paramString, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
    return this;
  }
  
  public Builder encodedPath(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("encodedPath == null");
    }
    if (!paramString.startsWith("/")) {
      throw new IllegalArgumentException("unexpected encodedPath: " + paramString);
    }
    resolvePath(paramString, 0, paramString.length());
    return this;
  }
  
  public Builder encodedQuery(String paramString)
  {
    if (paramString != null) {}
    for (paramString = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(paramString, " \"'<>#", true, true, true));; paramString = null)
    {
      this.encodedQueryNamesAndValues = paramString;
      return this;
    }
  }
  
  public Builder encodedUsername(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("encodedUsername == null");
    }
    this.encodedUsername = HttpUrl.canonicalize(paramString, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
    return this;
  }
  
  public Builder fragment(String paramString)
  {
    if (paramString != null) {}
    for (paramString = HttpUrl.canonicalize(paramString, "", false, false, false);; paramString = null)
    {
      this.encodedFragment = paramString;
      return this;
    }
  }
  
  public Builder host(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("host == null");
    }
    String str = canonicalizeHost(paramString, 0, paramString.length());
    if (str == null) {
      throw new IllegalArgumentException("unexpected host: " + paramString);
    }
    this.host = str;
    return this;
  }
  
  HttpUrl.Builder.ParseResult parse(HttpUrl paramHttpUrl, String paramString)
  {
    int i = skipLeadingAsciiWhitespace(paramString, 0, paramString.length());
    int i1 = skipTrailingAsciiWhitespace(paramString, i, paramString.length());
    label65:
    int k;
    label117:
    int n;
    if (schemeDelimiterOffset(paramString, i, i1) != -1) {
      if (paramString.regionMatches(true, i, "https:", 0, 6))
      {
        this.scheme = "https";
        i += "https:".length();
        m = slashCount(paramString, i, i1);
        if ((m < 2) && (paramHttpUrl != null) && (HttpUrl.access$100(paramHttpUrl).equals(this.scheme))) {
          break label658;
        }
        k = 0;
        j = 0;
        m = i + m;
        i = k;
        k = m;
        n = HttpUrl.access$200(paramString, k, i1, "@/\\?#");
        if (n == i1) {
          break label283;
        }
      }
    }
    label283:
    for (int m = paramString.charAt(n);; m = -1) {
      switch (m)
      {
      default: 
        m = i;
        i = k;
        k = m;
        m = k;
        k = i;
        i = m;
        break label117;
        if (paramString.regionMatches(true, i, "http:", 0, 5))
        {
          this.scheme = "http";
          i += "http:".length();
          break label65;
        }
        return HttpUrl.Builder.ParseResult.UNSUPPORTED_SCHEME;
        if (paramHttpUrl != null)
        {
          this.scheme = HttpUrl.access$100(paramHttpUrl);
          break label65;
        }
        return HttpUrl.Builder.ParseResult.MISSING_SCHEME;
      }
    }
    if (i == 0)
    {
      m = HttpUrl.access$200(paramString, k, n, ":");
      String str = HttpUrl.canonicalize(paramString, k, m, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
      paramHttpUrl = str;
      if (j != 0) {
        paramHttpUrl = this.encodedUsername + "%40" + str;
      }
      this.encodedUsername = paramHttpUrl;
      if (m != n)
      {
        i = 1;
        this.encodedPassword = HttpUrl.canonicalize(paramString, m + 1, n, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
      }
      j = 1;
    }
    for (;;)
    {
      m = n + 1;
      k = i;
      i = m;
      break;
      this.encodedPassword = (this.encodedPassword + "%40" + HttpUrl.canonicalize(paramString, k, n, " \"':;<=>@[]^`{}|/\\?#", true, false, true));
    }
    i = portColonOffset(paramString, k, n);
    if (i + 1 < n)
    {
      this.host = canonicalizeHost(paramString, k, i);
      this.port = parsePort(paramString, i + 1, n);
      if (this.port == -1) {
        return HttpUrl.Builder.ParseResult.INVALID_PORT;
      }
    }
    else
    {
      this.host = canonicalizeHost(paramString, k, i);
      this.port = HttpUrl.defaultPort(this.scheme);
    }
    if (this.host == null) {
      return HttpUrl.Builder.ParseResult.INVALID_HOST;
    }
    int j = n;
    i = HttpUrl.access$200(paramString, j, i1, "?#");
    resolvePath(paramString, j, i);
    if ((i < i1) && (paramString.charAt(i) == '?'))
    {
      j = HttpUrl.access$200(paramString, i, i1, "#");
      this.encodedQueryNamesAndValues = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(paramString, i + 1, j, " \"'<>#", true, true, true));
      i = j;
    }
    for (;;)
    {
      if ((i < i1) && (paramString.charAt(i) == '#')) {
        this.encodedFragment = HttpUrl.canonicalize(paramString, i + 1, i1, "", true, false, false);
      }
      return HttpUrl.Builder.ParseResult.SUCCESS;
      label658:
      this.encodedUsername = paramHttpUrl.encodedUsername();
      this.encodedPassword = paramHttpUrl.encodedPassword();
      this.host = HttpUrl.access$300(paramHttpUrl);
      this.port = HttpUrl.access$400(paramHttpUrl);
      this.encodedPathSegments.clear();
      this.encodedPathSegments.addAll(paramHttpUrl.encodedPathSegments());
      if (i != i1)
      {
        j = i;
        if (paramString.charAt(i) != '#') {
          break;
        }
      }
      encodedQuery(paramHttpUrl.encodedQuery());
      j = i;
      break;
    }
  }
  
  public Builder password(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("password == null");
    }
    this.encodedPassword = HttpUrl.canonicalize(paramString, " \"':;<=>@[]^`{}|/\\?#", false, false, true);
    return this;
  }
  
  public Builder port(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > 65535)) {
      throw new IllegalArgumentException("unexpected port: " + paramInt);
    }
    this.port = paramInt;
    return this;
  }
  
  public Builder query(String paramString)
  {
    if (paramString != null) {}
    for (paramString = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(paramString, " \"'<>#", false, true, true));; paramString = null)
    {
      this.encodedQueryNamesAndValues = paramString;
      return this;
    }
  }
  
  Builder reencodeForUri()
  {
    int j = this.encodedPathSegments.size();
    int i = 0;
    String str;
    while (i < j)
    {
      str = (String)this.encodedPathSegments.get(i);
      this.encodedPathSegments.set(i, HttpUrl.canonicalize(str, "[]", true, false, true));
      i += 1;
    }
    if (this.encodedQueryNamesAndValues != null)
    {
      j = this.encodedQueryNamesAndValues.size();
      i = 0;
      while (i < j)
      {
        str = (String)this.encodedQueryNamesAndValues.get(i);
        if (str != null) {
          this.encodedQueryNamesAndValues.set(i, HttpUrl.canonicalize(str, "\\^`{|}", true, true, true));
        }
        i += 1;
      }
    }
    if (this.encodedFragment != null) {
      this.encodedFragment = HttpUrl.canonicalize(this.encodedFragment, " \"#<>\\^`{|}", true, false, false);
    }
    return this;
  }
  
  public Builder removeAllEncodedQueryParameters(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("encodedName == null");
    }
    if (this.encodedQueryNamesAndValues == null) {
      return this;
    }
    removeAllCanonicalQueryParameters(HttpUrl.canonicalize(paramString, " \"'<>#&=", true, true, true));
    return this;
  }
  
  public Builder removeAllQueryParameters(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("name == null");
    }
    if (this.encodedQueryNamesAndValues == null) {
      return this;
    }
    removeAllCanonicalQueryParameters(HttpUrl.canonicalize(paramString, " \"'<>#&=", false, true, true));
    return this;
  }
  
  public Builder removePathSegment(int paramInt)
  {
    this.encodedPathSegments.remove(paramInt);
    if (this.encodedPathSegments.isEmpty()) {
      this.encodedPathSegments.add("");
    }
    return this;
  }
  
  public Builder scheme(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("scheme == null");
    }
    if (paramString.equalsIgnoreCase("http"))
    {
      this.scheme = "http";
      return this;
    }
    if (paramString.equalsIgnoreCase("https"))
    {
      this.scheme = "https";
      return this;
    }
    throw new IllegalArgumentException("unexpected scheme: " + paramString);
  }
  
  public Builder setEncodedPathSegment(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("encodedPathSegment == null");
    }
    String str = HttpUrl.canonicalize(paramString, 0, paramString.length(), " \"<>^`{}|/\\?#", true, false, true);
    this.encodedPathSegments.set(paramInt, str);
    if ((isDot(str)) || (isDotDot(str))) {
      throw new IllegalArgumentException("unexpected path segment: " + paramString);
    }
    return this;
  }
  
  public Builder setEncodedQueryParameter(String paramString1, String paramString2)
  {
    removeAllEncodedQueryParameters(paramString1);
    addEncodedQueryParameter(paramString1, paramString2);
    return this;
  }
  
  public Builder setPathSegment(int paramInt, String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("pathSegment == null");
    }
    String str = HttpUrl.canonicalize(paramString, 0, paramString.length(), " \"<>^`{}|/\\?#", false, false, true);
    if ((isDot(str)) || (isDotDot(str))) {
      throw new IllegalArgumentException("unexpected path segment: " + paramString);
    }
    this.encodedPathSegments.set(paramInt, str);
    return this;
  }
  
  public Builder setQueryParameter(String paramString1, String paramString2)
  {
    removeAllQueryParameters(paramString1);
    addQueryParameter(paramString1, paramString2);
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.scheme);
    localStringBuilder.append("://");
    if ((!this.encodedUsername.isEmpty()) || (!this.encodedPassword.isEmpty()))
    {
      localStringBuilder.append(this.encodedUsername);
      if (!this.encodedPassword.isEmpty())
      {
        localStringBuilder.append(':');
        localStringBuilder.append(this.encodedPassword);
      }
      localStringBuilder.append('@');
    }
    if (this.host.indexOf(':') != -1)
    {
      localStringBuilder.append('[');
      localStringBuilder.append(this.host);
      localStringBuilder.append(']');
    }
    for (;;)
    {
      int i = effectivePort();
      if (i != HttpUrl.defaultPort(this.scheme))
      {
        localStringBuilder.append(':');
        localStringBuilder.append(i);
      }
      HttpUrl.pathSegmentsToString(localStringBuilder, this.encodedPathSegments);
      if (this.encodedQueryNamesAndValues != null)
      {
        localStringBuilder.append('?');
        HttpUrl.namesAndValuesToQueryString(localStringBuilder, this.encodedQueryNamesAndValues);
      }
      if (this.encodedFragment != null)
      {
        localStringBuilder.append('#');
        localStringBuilder.append(this.encodedFragment);
      }
      return localStringBuilder.toString();
      localStringBuilder.append(this.host);
    }
  }
  
  public Builder username(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("username == null");
    }
    this.encodedUsername = HttpUrl.canonicalize(paramString, " \"':;<=>@[]^`{}|/\\?#", false, false, true);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.HttpUrl.Builder
 * JD-Core Version:    0.7.0.1
 */