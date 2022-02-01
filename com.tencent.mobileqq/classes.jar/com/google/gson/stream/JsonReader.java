package com.google.gson.stream;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class JsonReader
  implements Closeable
{
  private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
  private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
  private static final int NUMBER_CHAR_DECIMAL = 3;
  private static final int NUMBER_CHAR_DIGIT = 2;
  private static final int NUMBER_CHAR_EXP_DIGIT = 7;
  private static final int NUMBER_CHAR_EXP_E = 5;
  private static final int NUMBER_CHAR_EXP_SIGN = 6;
  private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
  private static final int NUMBER_CHAR_NONE = 0;
  private static final int NUMBER_CHAR_SIGN = 1;
  private static final int PEEKED_BEGIN_ARRAY = 3;
  private static final int PEEKED_BEGIN_OBJECT = 1;
  private static final int PEEKED_BUFFERED = 11;
  private static final int PEEKED_DOUBLE_QUOTED = 9;
  private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
  private static final int PEEKED_END_ARRAY = 4;
  private static final int PEEKED_END_OBJECT = 2;
  private static final int PEEKED_EOF = 17;
  private static final int PEEKED_FALSE = 6;
  private static final int PEEKED_LONG = 15;
  private static final int PEEKED_NONE = 0;
  private static final int PEEKED_NULL = 7;
  private static final int PEEKED_NUMBER = 16;
  private static final int PEEKED_SINGLE_QUOTED = 8;
  private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
  private static final int PEEKED_TRUE = 5;
  private static final int PEEKED_UNQUOTED = 10;
  private static final int PEEKED_UNQUOTED_NAME = 14;
  private final char[] buffer = new char[1024];
  private final Reader in;
  private boolean lenient = false;
  private int limit = 0;
  private int lineNumber = 0;
  private int lineStart = 0;
  private int[] pathIndices;
  private String[] pathNames;
  int peeked = 0;
  private long peekedLong;
  private int peekedNumberLength;
  private String peekedString;
  private int pos = 0;
  private int[] stack = new int[32];
  private int stackSize = 0;
  
  static
  {
    com.google.gson.internal.JsonReaderInternalAccess.INSTANCE = new JsonReader.1();
  }
  
  public JsonReader(Reader paramReader)
  {
    int[] arrayOfInt = this.stack;
    int i = this.stackSize;
    this.stackSize = (i + 1);
    arrayOfInt[i] = 6;
    this.pathNames = new String[32];
    this.pathIndices = new int[32];
    if (paramReader != null)
    {
      this.in = paramReader;
      return;
    }
    throw new NullPointerException("in == null");
  }
  
  private void checkLenient()
  {
    if (this.lenient) {
      return;
    }
    throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
  }
  
  private void consumeNonExecutePrefix()
  {
    nextNonWhitespace(true);
    this.pos -= 1;
    int i = this.pos;
    char[] arrayOfChar = NON_EXECUTE_PREFIX;
    if ((i + arrayOfChar.length > this.limit) && (!fillBuffer(arrayOfChar.length))) {
      return;
    }
    i = 0;
    for (;;)
    {
      arrayOfChar = NON_EXECUTE_PREFIX;
      if (i >= arrayOfChar.length) {
        break;
      }
      if (this.buffer[(this.pos + i)] != arrayOfChar[i]) {
        return;
      }
      i += 1;
    }
    this.pos += arrayOfChar.length;
  }
  
  private boolean fillBuffer(int paramInt)
  {
    char[] arrayOfChar = this.buffer;
    int j = this.lineStart;
    int i = this.pos;
    this.lineStart = (j - i);
    j = this.limit;
    if (j != i)
    {
      this.limit = (j - i);
      System.arraycopy(arrayOfChar, i, arrayOfChar, 0, this.limit);
    }
    else
    {
      this.limit = 0;
    }
    this.pos = 0;
    do
    {
      Reader localReader = this.in;
      i = this.limit;
      i = localReader.read(arrayOfChar, i, arrayOfChar.length - i);
      if (i == -1) {
        break;
      }
      this.limit += i;
      i = paramInt;
      if (this.lineNumber == 0)
      {
        j = this.lineStart;
        i = paramInt;
        if (j == 0)
        {
          i = paramInt;
          if (this.limit > 0)
          {
            i = paramInt;
            if (arrayOfChar[0] == 65279)
            {
              this.pos += 1;
              this.lineStart = (j + 1);
              i = paramInt + 1;
            }
          }
        }
      }
      paramInt = i;
    } while (this.limit < i);
    return true;
    return false;
  }
  
  private boolean isLiteral(char paramChar)
  {
    if ((paramChar != '\t') && (paramChar != '\n') && (paramChar != '\f') && (paramChar != '\r') && (paramChar != ' '))
    {
      if (paramChar != '#')
      {
        if (paramChar == ',') {
          break label110;
        }
        if ((paramChar != '/') && (paramChar != '='))
        {
          if ((paramChar == '{') || (paramChar == '}') || (paramChar == ':')) {
            break label110;
          }
          if (paramChar == ';') {}
        }
      }
      switch (paramChar)
      {
      default: 
        return true;
      case '\\': 
        checkLenient();
      }
    }
    label110:
    return false;
  }
  
  private int nextNonWhitespace(boolean paramBoolean)
  {
    Object localObject = this.buffer;
    int i = this.pos;
    int j = this.limit;
    for (;;)
    {
      int m = i;
      int k = j;
      if (i == j)
      {
        this.pos = i;
        if (!fillBuffer(1))
        {
          if (!paramBoolean) {
            return -1;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("End of input");
          ((StringBuilder)localObject).append(locationString());
          throw new EOFException(((StringBuilder)localObject).toString());
        }
        m = this.pos;
        k = this.limit;
      }
      i = m + 1;
      j = localObject[m];
      if (j == 10)
      {
        this.lineNumber += 1;
        this.lineStart = i;
      }
      else if ((j != 32) && (j != 13) && (j != 9))
      {
        if (j == 47)
        {
          this.pos = i;
          if (i == k)
          {
            this.pos -= 1;
            boolean bool = fillBuffer(2);
            this.pos += 1;
            if (!bool) {
              return j;
            }
          }
          checkLenient();
          i = this.pos;
          k = localObject[i];
          if (k != 42)
          {
            if (k != 47) {
              return j;
            }
            this.pos = (i + 1);
            skipToEndOfLine();
            i = this.pos;
            j = this.limit;
            continue;
          }
          this.pos = (i + 1);
          if (skipTo("*/"))
          {
            i = this.pos + 2;
            j = this.limit;
            continue;
          }
          throw syntaxError("Unterminated comment");
        }
        if (j == 35)
        {
          this.pos = i;
          checkLenient();
          skipToEndOfLine();
          i = this.pos;
          j = this.limit;
          continue;
        }
        this.pos = i;
        return j;
      }
      j = k;
    }
  }
  
  private String nextQuotedValue(char paramChar)
  {
    char[] arrayOfChar = this.buffer;
    Object localObject2;
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      char c1 = this.pos;
      int i = this.limit;
      char c2 = c1;
      char c3;
      for (;;)
      {
        c3 = c2;
        if (c3 >= i) {
          break label203;
        }
        c2 = c3 + '\001';
        c3 = arrayOfChar[c3];
        if (c3 == paramChar)
        {
          this.pos = c2;
          paramChar = c2 - c1 - 1;
          if (localObject1 == null) {
            return new String(arrayOfChar, c1, paramChar);
          }
          ((StringBuilder)localObject1).append(arrayOfChar, c1, paramChar);
          return ((StringBuilder)localObject1).toString();
        }
        if (c3 == '\\')
        {
          this.pos = c2;
          c2 = c2 - c1 - 1;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new StringBuilder(Math.max((c2 + '\001') * 2, 16));
          }
          ((StringBuilder)localObject2).append(arrayOfChar, c1, c2);
          ((StringBuilder)localObject2).append(readEscapeCharacter());
          c1 = this.pos;
          i = this.limit;
          localObject1 = localObject2;
          break;
        }
        if (c3 == '\n')
        {
          this.lineNumber += 1;
          this.lineStart = c2;
        }
      }
      label203:
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder(Math.max((c3 - c1) * 2, 16));
      }
      ((StringBuilder)localObject2).append(arrayOfChar, c1, c3 - c1);
      this.pos = c3;
      if (!fillBuffer(1)) {
        break;
      }
    }
    localObject1 = syntaxError("Unterminated string");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  private String nextUnquotedValue()
  {
    int j = 0;
    Object localObject1 = null;
    label150:
    label172:
    label175:
    Object localObject2;
    do
    {
      i = 0;
      do
      {
        for (;;)
        {
          int k = this.pos;
          if (k + i >= this.limit) {
            break label150;
          }
          k = this.buffer[(k + i)];
          if ((k == 9) || (k == 10) || (k == 12) || (k == 13) || (k == 32)) {
            break label172;
          }
          if (k == 35) {
            break;
          }
          if (k == 44) {
            break label172;
          }
          if ((k == 47) || (k == 61)) {
            break;
          }
          if ((k == 123) || (k == 125) || (k == 58)) {
            break label172;
          }
          if (k == 59) {
            break;
          }
          switch (k)
          {
          default: 
            i += 1;
          }
        }
        checkLenient();
        break;
        if (i >= this.buffer.length) {
          break label175;
        }
      } while (fillBuffer(i + 1));
      break;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder(Math.max(i, 16));
      }
      ((StringBuilder)localObject2).append(this.buffer, this.pos, i);
      this.pos += i;
      localObject1 = localObject2;
    } while (fillBuffer(1));
    localObject1 = localObject2;
    int i = j;
    if (localObject1 == null)
    {
      localObject1 = new String(this.buffer, this.pos, i);
    }
    else
    {
      ((StringBuilder)localObject1).append(this.buffer, this.pos, i);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    this.pos += i;
    return localObject1;
  }
  
  private int peekKeyword()
  {
    int i = this.buffer[this.pos];
    String str1;
    String str2;
    if ((i != 116) && (i != 84))
    {
      if ((i != 102) && (i != 70))
      {
        if ((i != 110) && (i != 78)) {
          return 0;
        }
        i = 7;
        str1 = "null";
        str2 = "NULL";
      }
      else
      {
        i = 6;
        str1 = "false";
        str2 = "FALSE";
      }
    }
    else
    {
      i = 5;
      str1 = "true";
      str2 = "TRUE";
    }
    int k = str1.length();
    int j = 1;
    while (j < k)
    {
      if ((this.pos + j >= this.limit) && (!fillBuffer(j + 1))) {
        return 0;
      }
      int m = this.buffer[(this.pos + j)];
      if ((m != str1.charAt(j)) && (m != str2.charAt(j))) {
        return 0;
      }
      j += 1;
    }
    if (((this.pos + k < this.limit) || (fillBuffer(k + 1))) && (isLiteral(this.buffer[(this.pos + k)]))) {
      return 0;
    }
    this.pos += k;
    this.peeked = i;
    return i;
  }
  
  private int peekNumber()
  {
    char[] arrayOfChar = this.buffer;
    int i3 = this.pos;
    int k = this.limit;
    int n = 0;
    int i = 0;
    int j = 1;
    long l1 = 0L;
    int m = 0;
    for (;;)
    {
      int i2 = i3;
      int i1 = k;
      if (i3 + n == k)
      {
        if (n == arrayOfChar.length) {
          return 0;
        }
        if (fillBuffer(n + 1))
        {
          i2 = this.pos;
          i1 = this.limit;
        }
      }
      else
      {
        char c = arrayOfChar[(i2 + n)];
        if (c == '+') {
          break label460;
        }
        if ((c == 'E') || (c == 'e')) {
          break label440;
        }
        if (c == '-') {
          break label418;
        }
        if (c == '.') {
          break label406;
        }
        if ((c >= '0') && (c <= '9'))
        {
          if ((i != 1) && (i != 0))
          {
            long l2;
            if (i == 2)
            {
              if (l1 == 0L) {
                return 0;
              }
              l2 = 10L * l1 - (c - '0');
              if ((l1 <= -922337203685477580L) && ((l1 != -922337203685477580L) || (l2 >= l1))) {
                k = 0;
              } else {
                k = 1;
              }
              k &= j;
            }
            else
            {
              if (i == 3)
              {
                i = 4;
                break label283;
              }
              if (i == 5) {
                break label267;
              }
              k = j;
              l2 = l1;
              if (i == 6) {
                break label267;
              }
            }
            j = k;
            l1 = l2;
            break label283;
            label267:
            i = 7;
          }
          else
          {
            l1 = -(c - '0');
            i = 2;
          }
          label283:
          break label468;
        }
        if (isLiteral(c)) {
          break label404;
        }
      }
      if ((i == 2) && (j != 0) && ((l1 != -9223372036854775808L) || (m != 0)) && ((l1 != 0L) || (m == 0)))
      {
        if (m == 0) {
          l1 = -l1;
        }
        this.peekedLong = l1;
        this.pos += n;
        this.peeked = 15;
        return 15;
      }
      if ((i != 2) && (i != 4) && (i != 7)) {
        return 0;
      }
      this.peekedNumberLength = n;
      this.peeked = 16;
      return 16;
      label404:
      return 0;
      label406:
      if (i == 2)
      {
        i = 3;
      }
      else
      {
        return 0;
        label418:
        if (i == 0)
        {
          i = 1;
          m = 1;
        }
        else if (i != 5)
        {
          return 0;
          label440:
          if ((i != 2) && (i != 4)) {
            return 0;
          }
          i = 5;
          break label468;
          label460:
          if (i != 5) {
            break;
          }
        }
        else
        {
          i = 6;
        }
      }
      label468:
      n += 1;
      i3 = i2;
      k = i1;
    }
    return 0;
  }
  
  private void push(int paramInt)
  {
    int i = this.stackSize;
    int[] arrayOfInt1 = this.stack;
    if (i == arrayOfInt1.length)
    {
      int[] arrayOfInt2 = new int[i * 2];
      int[] arrayOfInt3 = new int[i * 2];
      String[] arrayOfString = new String[i * 2];
      System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, i);
      System.arraycopy(this.pathIndices, 0, arrayOfInt3, 0, this.stackSize);
      System.arraycopy(this.pathNames, 0, arrayOfString, 0, this.stackSize);
      this.stack = arrayOfInt2;
      this.pathIndices = arrayOfInt3;
      this.pathNames = arrayOfString;
    }
    arrayOfInt1 = this.stack;
    i = this.stackSize;
    this.stackSize = (i + 1);
    arrayOfInt1[i] = paramInt;
  }
  
  private char readEscapeCharacter()
  {
    if ((this.pos == this.limit) && (!fillBuffer(1))) {
      throw syntaxError("Unterminated escape sequence");
    }
    Object localObject = this.buffer;
    int i = this.pos;
    this.pos = (i + 1);
    char c = localObject[i];
    if (c != '\n')
    {
      if ((c != '"') && (c != '\'') && (c != '/') && (c != '\\'))
      {
        if (c != 'b')
        {
          if (c != 'f')
          {
            if (c != 'n')
            {
              if (c != 'r')
              {
                if (c != 't')
                {
                  if (c == 'u')
                  {
                    if ((this.pos + 4 > this.limit) && (!fillBuffer(4))) {
                      throw syntaxError("Unterminated escape sequence");
                    }
                    c = '\000';
                    int j = this.pos;
                    int k;
                    for (i = j;; i = k + 1)
                    {
                      k = i;
                      if (k >= j + 4) {
                        break label317;
                      }
                      i = this.buffer[k];
                      int m = (char)(c << '\004');
                      if ((i >= 48) && (i <= 57))
                      {
                        i -= 48;
                        c = (char)(m + i);
                      }
                      else
                      {
                        if ((i >= 97) && (i <= 102)) {
                          i -= 97;
                        }
                        for (;;)
                        {
                          i += 10;
                          break;
                          if ((i < 65) || (i > 70)) {
                            break label264;
                          }
                          i -= 65;
                        }
                      }
                    }
                    label264:
                    localObject = new StringBuilder();
                    ((StringBuilder)localObject).append("\\u");
                    ((StringBuilder)localObject).append(new String(this.buffer, this.pos, 4));
                    throw new NumberFormatException(((StringBuilder)localObject).toString());
                    label317:
                    this.pos += 4;
                    return c;
                  }
                  throw syntaxError("Invalid escape sequence");
                }
                return '\t';
              }
              return '\r';
            }
            return '\n';
          }
          return '\f';
        }
        return '\b';
      }
    }
    else
    {
      this.lineNumber += 1;
      this.lineStart = this.pos;
    }
    return c;
  }
  
  private void skipQuotedValue(char paramChar)
  {
    Object localObject = this.buffer;
    do
    {
      char c1 = this.pos;
      char c2 = this.limit;
      while (c1 < c2)
      {
        char c3 = c1 + '\001';
        c1 = localObject[c1];
        if (c1 == paramChar)
        {
          this.pos = c3;
          return;
        }
        if (c1 == '\\')
        {
          this.pos = c3;
          readEscapeCharacter();
          c1 = this.pos;
          c2 = this.limit;
        }
        else
        {
          if (c1 == '\n')
          {
            this.lineNumber += 1;
            this.lineStart = c3;
          }
          c1 = c3;
        }
      }
      this.pos = c1;
    } while (fillBuffer(1));
    localObject = syntaxError("Unterminated string");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private boolean skipTo(String paramString)
  {
    int j = paramString.length();
    int k = this.pos;
    int m = this.limit;
    int i = 0;
    if ((k + j > m) && (!fillBuffer(j))) {
      return false;
    }
    char[] arrayOfChar = this.buffer;
    k = this.pos;
    if (arrayOfChar[k] == '\n')
    {
      this.lineNumber += 1;
      this.lineStart = (k + 1);
    }
    for (;;)
    {
      if (i >= j) {
        break label128;
      }
      if (this.buffer[(this.pos + i)] != paramString.charAt(i))
      {
        this.pos += 1;
        break;
      }
      i += 1;
    }
    label128:
    return true;
  }
  
  private void skipToEndOfLine()
  {
    int i;
    do
    {
      if ((this.pos >= this.limit) && (!fillBuffer(1))) {
        break;
      }
      char[] arrayOfChar = this.buffer;
      i = this.pos;
      this.pos = (i + 1);
      i = arrayOfChar[i];
      if (i == 10)
      {
        this.lineNumber += 1;
        this.lineStart = this.pos;
        return;
      }
    } while (i != 13);
  }
  
  private void skipUnquotedValue()
  {
    label143:
    label154:
    do
    {
      int i = 0;
      int j;
      for (;;)
      {
        j = this.pos;
        if (j + i >= this.limit) {
          break label154;
        }
        j = this.buffer[(j + i)];
        if ((j == 9) || (j == 10) || (j == 12) || (j == 13) || (j == 32)) {
          break label143;
        }
        if (j == 35) {
          break;
        }
        if (j == 44) {
          break label143;
        }
        if ((j == 47) || (j == 61)) {
          break;
        }
        if ((j == 123) || (j == 125) || (j == 58)) {
          break label143;
        }
        if (j == 59) {
          break;
        }
        switch (j)
        {
        default: 
          i += 1;
        }
      }
      checkLenient();
      this.pos += i;
      return;
      this.pos = (j + i);
    } while (fillBuffer(1));
  }
  
  private IOException syntaxError(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(locationString());
    throw new MalformedJsonException(localStringBuilder.toString());
  }
  
  public void beginArray()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 3)
    {
      push(1);
      this.pathIndices[(this.stackSize - 1)] = 0;
      this.peeked = 0;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected BEGIN_ARRAY but was ");
    localStringBuilder.append(peek());
    localStringBuilder.append(locationString());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void beginObject()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 1)
    {
      push(3);
      this.peeked = 0;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected BEGIN_OBJECT but was ");
    localStringBuilder.append(peek());
    localStringBuilder.append(locationString());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void close()
  {
    this.peeked = 0;
    this.stack[0] = 8;
    this.stackSize = 1;
    this.in.close();
  }
  
  int doPeek()
  {
    Object localObject = this.stack;
    int j = this.stackSize;
    int i = localObject[(j - 1)];
    if (i == 1)
    {
      localObject[(j - 1)] = 2;
    }
    else if (i == 2)
    {
      j = nextNonWhitespace(true);
      if (j != 44)
      {
        if (j != 59)
        {
          if (j == 93)
          {
            this.peeked = 4;
            return 4;
          }
          throw syntaxError("Unterminated array");
        }
        checkLenient();
      }
    }
    else
    {
      if ((i == 3) || (i == 5)) {
        break label482;
      }
      if (i == 4)
      {
        localObject[(j - 1)] = 5;
        j = nextNonWhitespace(true);
        if (j != 58) {
          if (j == 61)
          {
            checkLenient();
            if ((this.pos < this.limit) || (fillBuffer(1)))
            {
              localObject = this.buffer;
              j = this.pos;
              if (localObject[j] == '>') {
                this.pos = (j + 1);
              }
            }
          }
          else
          {
            throw syntaxError("Expected ':'");
          }
        }
      }
      else if (i == 6)
      {
        if (this.lenient) {
          consumeNonExecutePrefix();
        }
        this.stack[(this.stackSize - 1)] = 7;
      }
      else if (i == 7)
      {
        if (nextNonWhitespace(false) == -1)
        {
          this.peeked = 17;
          return 17;
        }
        checkLenient();
        this.pos -= 1;
      }
      else
      {
        if (i == 8) {
          break label471;
        }
      }
    }
    j = nextNonWhitespace(true);
    if (j != 34)
    {
      if (j != 39)
      {
        if ((j != 44) && (j != 59)) {
          if (j != 91)
          {
            if (j != 93)
            {
              if (j != 123)
              {
                this.pos -= 1;
                i = peekKeyword();
                if (i != 0) {
                  return i;
                }
                i = peekNumber();
                if (i != 0) {
                  return i;
                }
                if (isLiteral(this.buffer[this.pos]))
                {
                  checkLenient();
                  this.peeked = 10;
                  return 10;
                }
                throw syntaxError("Expected value");
              }
              this.peeked = 1;
              return 1;
            }
            if (i == 1)
            {
              this.peeked = 4;
              return 4;
            }
          }
          else
          {
            this.peeked = 3;
            return 3;
          }
        }
        if ((i != 1) && (i != 2)) {
          throw syntaxError("Unexpected value");
        }
        checkLenient();
        this.pos -= 1;
        this.peeked = 7;
        return 7;
      }
      checkLenient();
      this.peeked = 8;
      return 8;
    }
    this.peeked = 9;
    return 9;
    label471:
    throw new IllegalStateException("JsonReader is closed");
    label482:
    this.stack[(this.stackSize - 1)] = 4;
    if (i == 5)
    {
      j = nextNonWhitespace(true);
      if (j != 44)
      {
        if (j != 59)
        {
          if (j == 125)
          {
            this.peeked = 2;
            return 2;
          }
          throw syntaxError("Unterminated object");
        }
        checkLenient();
      }
    }
    j = nextNonWhitespace(true);
    if (j != 34)
    {
      if (j != 39)
      {
        if (j != 125)
        {
          checkLenient();
          this.pos -= 1;
          if (isLiteral((char)j))
          {
            this.peeked = 14;
            return 14;
          }
          throw syntaxError("Expected name");
        }
        if (i != 5)
        {
          this.peeked = 2;
          return 2;
        }
        throw syntaxError("Expected name");
      }
      checkLenient();
      this.peeked = 12;
      return 12;
    }
    this.peeked = 13;
    return 13;
  }
  
  public void endArray()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 4)
    {
      this.stackSize -= 1;
      localObject = this.pathIndices;
      i = this.stackSize - 1;
      localObject[i] += 1;
      this.peeked = 0;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected END_ARRAY but was ");
    ((StringBuilder)localObject).append(peek());
    ((StringBuilder)localObject).append(locationString());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void endObject()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 2)
    {
      this.stackSize -= 1;
      localObject = this.pathNames;
      i = this.stackSize;
      localObject[i] = null;
      localObject = this.pathIndices;
      i -= 1;
      localObject[i] += 1;
      this.peeked = 0;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected END_OBJECT but was ");
    ((StringBuilder)localObject).append(peek());
    ((StringBuilder)localObject).append(locationString());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public String getPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('$');
    int j = this.stackSize;
    int i = 0;
    while (i < j)
    {
      int k = this.stack[i];
      if ((k != 1) && (k != 2))
      {
        if ((k == 3) || (k == 4) || (k == 5))
        {
          localStringBuilder.append('.');
          String[] arrayOfString = this.pathNames;
          if (arrayOfString[i] != null) {
            localStringBuilder.append(arrayOfString[i]);
          }
        }
      }
      else
      {
        localStringBuilder.append('[');
        localStringBuilder.append(this.pathIndices[i]);
        localStringBuilder.append(']');
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public boolean hasNext()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    return (i != 2) && (i != 4);
  }
  
  public final boolean isLenient()
  {
    return this.lenient;
  }
  
  String locationString()
  {
    int i = this.lineNumber;
    int j = this.pos;
    int k = this.lineStart;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" at line ");
    localStringBuilder.append(i + 1);
    localStringBuilder.append(" column ");
    localStringBuilder.append(j - k + 1);
    localStringBuilder.append(" path ");
    localStringBuilder.append(getPath());
    return localStringBuilder.toString();
  }
  
  public boolean nextBoolean()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 5)
    {
      this.peeked = 0;
      localObject = this.pathIndices;
      i = this.stackSize - 1;
      localObject[i] += 1;
      return true;
    }
    if (i == 6)
    {
      this.peeked = 0;
      localObject = this.pathIndices;
      i = this.stackSize - 1;
      localObject[i] += 1;
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected a boolean but was ");
    ((StringBuilder)localObject).append(peek());
    ((StringBuilder)localObject).append(locationString());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public double nextDouble()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 15)
    {
      this.peeked = 0;
      localObject = this.pathIndices;
      i = this.stackSize - 1;
      localObject[i] += 1;
      return this.peekedLong;
    }
    if (i == 16)
    {
      this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
      this.pos += this.peekedNumberLength;
    }
    else if ((i != 8) && (i != 9))
    {
      if (i == 10)
      {
        this.peekedString = nextUnquotedValue();
      }
      else if (i != 11)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Expected a double but was ");
        ((StringBuilder)localObject).append(peek());
        ((StringBuilder)localObject).append(locationString());
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
    }
    else
    {
      char c;
      if (i == 8) {
        c = '\'';
      } else {
        c = '"';
      }
      this.peekedString = nextQuotedValue(c);
    }
    this.peeked = 11;
    double d = Double.parseDouble(this.peekedString);
    if ((!this.lenient) && ((Double.isNaN(d)) || (Double.isInfinite(d))))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("JSON forbids NaN and infinities: ");
      ((StringBuilder)localObject).append(d);
      ((StringBuilder)localObject).append(locationString());
      throw new MalformedJsonException(((StringBuilder)localObject).toString());
    }
    this.peekedString = null;
    this.peeked = 0;
    Object localObject = this.pathIndices;
    i = this.stackSize - 1;
    localObject[i] += 1;
    return d;
  }
  
  public int nextInt()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 15)
    {
      long l = this.peekedLong;
      i = (int)l;
      if (l == i)
      {
        this.peeked = 0;
        localObject = this.pathIndices;
        j = this.stackSize - 1;
        localObject[j] += 1;
        return i;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Expected an int but was ");
      ((StringBuilder)localObject).append(this.peekedLong);
      ((StringBuilder)localObject).append(locationString());
      throw new NumberFormatException(((StringBuilder)localObject).toString());
    }
    if (i == 16)
    {
      this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
      this.pos += this.peekedNumberLength;
    }
    else
    {
      if ((i != 8) && (i != 9) && (i != 10))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Expected an int but was ");
        ((StringBuilder)localObject).append(peek());
        ((StringBuilder)localObject).append(locationString());
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
      if (i == 10)
      {
        this.peekedString = nextUnquotedValue();
      }
      else
      {
        char c;
        if (i == 8) {
          c = '\'';
        } else {
          c = '"';
        }
        this.peekedString = nextQuotedValue(c);
      }
    }
    try
    {
      i = Integer.parseInt(this.peekedString);
      this.peeked = 0;
      localObject = this.pathIndices;
      j = this.stackSize - 1;
      localObject[j] += 1;
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label340:
      double d;
      break label340;
    }
    this.peeked = 11;
    d = Double.parseDouble(this.peekedString);
    i = (int)d;
    if (i == d)
    {
      this.peekedString = null;
      this.peeked = 0;
      localObject = this.pathIndices;
      j = this.stackSize - 1;
      localObject[j] += 1;
      return i;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected an int but was ");
    ((StringBuilder)localObject).append(this.peekedString);
    ((StringBuilder)localObject).append(locationString());
    throw new NumberFormatException(((StringBuilder)localObject).toString());
  }
  
  public long nextLong()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 15)
    {
      this.peeked = 0;
      localObject = this.pathIndices;
      i = this.stackSize - 1;
      localObject[i] += 1;
      return this.peekedLong;
    }
    if (i == 16)
    {
      this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
      this.pos += this.peekedNumberLength;
    }
    else
    {
      if ((i != 8) && (i != 9) && (i != 10))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Expected a long but was ");
        ((StringBuilder)localObject).append(peek());
        ((StringBuilder)localObject).append(locationString());
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
      if (i == 10)
      {
        this.peekedString = nextUnquotedValue();
      }
      else
      {
        char c;
        if (i == 8) {
          c = '\'';
        } else {
          c = '"';
        }
        this.peekedString = nextQuotedValue(c);
      }
    }
    try
    {
      l = Long.parseLong(this.peekedString);
      this.peeked = 0;
      localObject = this.pathIndices;
      i = this.stackSize - 1;
      localObject[i] += 1;
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l;
      label271:
      double d;
      break label271;
    }
    this.peeked = 11;
    d = Double.parseDouble(this.peekedString);
    l = d;
    if (l == d)
    {
      this.peekedString = null;
      this.peeked = 0;
      localObject = this.pathIndices;
      i = this.stackSize - 1;
      localObject[i] += 1;
      return l;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected a long but was ");
    ((StringBuilder)localObject).append(this.peekedString);
    ((StringBuilder)localObject).append(locationString());
    throw new NumberFormatException(((StringBuilder)localObject).toString());
  }
  
  public String nextName()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 14)
    {
      localObject = nextUnquotedValue();
    }
    else if (i == 12)
    {
      localObject = nextQuotedValue('\'');
    }
    else
    {
      if (i != 13) {
        break label78;
      }
      localObject = nextQuotedValue('"');
    }
    this.peeked = 0;
    this.pathNames[(this.stackSize - 1)] = localObject;
    return localObject;
    label78:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected a name but was ");
    ((StringBuilder)localObject).append(peek());
    ((StringBuilder)localObject).append(locationString());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void nextNull()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 7)
    {
      this.peeked = 0;
      localObject = this.pathIndices;
      i = this.stackSize - 1;
      localObject[i] += 1;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected null but was ");
    ((StringBuilder)localObject).append(peek());
    ((StringBuilder)localObject).append(locationString());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public String nextString()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    if (i == 10)
    {
      localObject = nextUnquotedValue();
    }
    else if (i == 8)
    {
      localObject = nextQuotedValue('\'');
    }
    else if (i == 9)
    {
      localObject = nextQuotedValue('"');
    }
    else if (i == 11)
    {
      localObject = this.peekedString;
      this.peekedString = null;
    }
    else if (i == 15)
    {
      localObject = Long.toString(this.peekedLong);
    }
    else
    {
      if (i != 16) {
        break label167;
      }
      localObject = new String(this.buffer, this.pos, this.peekedNumberLength);
      this.pos += this.peekedNumberLength;
    }
    this.peeked = 0;
    int[] arrayOfInt = this.pathIndices;
    i = this.stackSize - 1;
    arrayOfInt[i] += 1;
    return localObject;
    label167:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected a string but was ");
    ((StringBuilder)localObject).append(peek());
    ((StringBuilder)localObject).append(locationString());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public JsonToken peek()
  {
    int j = this.peeked;
    int i = j;
    if (j == 0) {
      i = doPeek();
    }
    switch (i)
    {
    default: 
      throw new AssertionError();
    case 17: 
      return JsonToken.END_DOCUMENT;
    case 15: 
    case 16: 
      return JsonToken.NUMBER;
    case 12: 
    case 13: 
    case 14: 
      return JsonToken.NAME;
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      return JsonToken.STRING;
    case 7: 
      return JsonToken.NULL;
    case 5: 
    case 6: 
      return JsonToken.BOOLEAN;
    case 4: 
      return JsonToken.END_ARRAY;
    case 3: 
      return JsonToken.BEGIN_ARRAY;
    case 2: 
      return JsonToken.END_OBJECT;
    }
    return JsonToken.BEGIN_OBJECT;
  }
  
  public final void setLenient(boolean paramBoolean)
  {
    this.lenient = paramBoolean;
  }
  
  public void skipValue()
  {
    int j = 0;
    label187:
    do
    {
      i = this.peeked;
      int k = i;
      if (i == 0) {
        k = doPeek();
      }
      if (k == 3) {
        push(1);
      }
      for (;;)
      {
        i = j + 1;
        break label187;
        if (k != 1) {
          break;
        }
        push(3);
      }
      if (k == 4) {}
      for (this.stackSize -= 1;; this.stackSize -= 1)
      {
        i = j - 1;
        break label187;
        if (k != 2) {
          break;
        }
      }
      if ((k != 14) && (k != 10))
      {
        if ((k != 8) && (k != 12))
        {
          if ((k != 9) && (k != 13))
          {
            i = j;
            if (k == 16)
            {
              this.pos += this.peekedNumberLength;
              i = j;
            }
          }
          else
          {
            skipQuotedValue('"');
            i = j;
          }
        }
        else
        {
          skipQuotedValue('\'');
          i = j;
        }
      }
      else
      {
        skipUnquotedValue();
        i = j;
      }
      this.peeked = 0;
      j = i;
    } while (i != 0);
    int[] arrayOfInt = this.pathIndices;
    int i = this.stackSize;
    j = i - 1;
    arrayOfInt[j] += 1;
    this.pathNames[(i - 1)] = "null";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(locationString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.stream.JsonReader
 * JD-Core Version:    0.7.0.1
 */