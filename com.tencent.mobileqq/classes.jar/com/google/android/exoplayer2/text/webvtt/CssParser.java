package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class CssParser
{
  private static final String BLOCK_END = "}";
  private static final String BLOCK_START = "{";
  private static final String PROPERTY_BGCOLOR = "background-color";
  private static final String PROPERTY_FONT_FAMILY = "font-family";
  private static final String PROPERTY_FONT_STYLE = "font-style";
  private static final String PROPERTY_FONT_WEIGHT = "font-weight";
  private static final String PROPERTY_TEXT_DECORATION = "text-decoration";
  private static final String VALUE_BOLD = "bold";
  private static final String VALUE_ITALIC = "italic";
  private static final String VALUE_UNDERLINE = "underline";
  private static final Pattern VOICE_NAME_PATTERN = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
  private final StringBuilder stringBuilder = new StringBuilder();
  private final ParsableByteArray styleInput = new ParsableByteArray();
  
  private void applySelectorToStyle(WebvttCssStyle paramWebvttCssStyle, String paramString)
  {
    if ("".equals(paramString)) {}
    for (;;)
    {
      return;
      int i = paramString.indexOf('[');
      Object localObject = paramString;
      if (i != -1)
      {
        localObject = VOICE_NAME_PATTERN.matcher(paramString.substring(i));
        if (((Matcher)localObject).matches()) {
          paramWebvttCssStyle.setTargetVoice(((Matcher)localObject).group(1));
        }
        localObject = paramString.substring(0, i);
      }
      paramString = ((String)localObject).split("\\.");
      localObject = paramString[0];
      i = ((String)localObject).indexOf('#');
      if (i != -1)
      {
        paramWebvttCssStyle.setTargetTagName(((String)localObject).substring(0, i));
        paramWebvttCssStyle.setTargetId(((String)localObject).substring(i + 1));
      }
      while (paramString.length > 1)
      {
        paramWebvttCssStyle.setTargetClasses((String[])Arrays.copyOfRange(paramString, 1, paramString.length));
        return;
        paramWebvttCssStyle.setTargetTagName((String)localObject);
      }
    }
  }
  
  private static boolean maybeSkipComment(ParsableByteArray paramParsableByteArray)
  {
    int i = paramParsableByteArray.getPosition();
    int j = paramParsableByteArray.limit();
    byte[] arrayOfByte = paramParsableByteArray.data;
    if (i + 2 <= j)
    {
      int k = i + 1;
      if ((arrayOfByte[i] == 47) && (arrayOfByte[k] == 42))
      {
        k += 1;
        while (k + 1 < j)
        {
          int n = k + 1;
          int m = j;
          i = n;
          if ((char)arrayOfByte[k] == '*')
          {
            m = j;
            i = n;
            if ((char)arrayOfByte[n] == '/')
            {
              m = n + 1;
              i = m;
            }
          }
          j = m;
          k = i;
        }
        paramParsableByteArray.skipBytes(j - paramParsableByteArray.getPosition());
        return true;
      }
    }
    return false;
  }
  
  private static boolean maybeSkipWhitespace(ParsableByteArray paramParsableByteArray)
  {
    switch (peekCharAtPosition(paramParsableByteArray, paramParsableByteArray.getPosition()))
    {
    default: 
      return false;
    }
    paramParsableByteArray.skipBytes(1);
    return true;
  }
  
  private static String parseIdentifier(ParsableByteArray paramParsableByteArray, StringBuilder paramStringBuilder)
  {
    int j = 0;
    paramStringBuilder.setLength(0);
    int i = paramParsableByteArray.getPosition();
    int k = paramParsableByteArray.limit();
    while ((i < k) && (j == 0))
    {
      char c = (char)paramParsableByteArray.data[i];
      if (((c >= 'A') && (c <= 'Z')) || ((c >= 'a') && (c <= 'z')) || ((c >= '0') && (c <= '9')) || (c == '#') || (c == '-') || (c == '.') || (c == '_'))
      {
        i += 1;
        paramStringBuilder.append(c);
      }
      else
      {
        j = 1;
      }
    }
    paramParsableByteArray.skipBytes(i - paramParsableByteArray.getPosition());
    return paramStringBuilder.toString();
  }
  
  static String parseNextToken(ParsableByteArray paramParsableByteArray, StringBuilder paramStringBuilder)
  {
    skipWhitespaceAndComments(paramParsableByteArray);
    if (paramParsableByteArray.bytesLeft() == 0) {
      paramStringBuilder = null;
    }
    String str;
    do
    {
      return paramStringBuilder;
      str = parseIdentifier(paramParsableByteArray, paramStringBuilder);
      paramStringBuilder = str;
    } while (!"".equals(str));
    return "" + (char)paramParsableByteArray.readUnsignedByte();
  }
  
  private static String parsePropertyValue(ParsableByteArray paramParsableByteArray, StringBuilder paramStringBuilder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i == 0)
    {
      int j = paramParsableByteArray.getPosition();
      String str = parseNextToken(paramParsableByteArray, paramStringBuilder);
      if (str == null) {
        return null;
      }
      if (("}".equals(str)) || (";".equals(str)))
      {
        paramParsableByteArray.setPosition(j);
        i = 1;
      }
      else
      {
        localStringBuilder.append(str);
      }
    }
    return localStringBuilder.toString();
  }
  
  private static String parseSelector(ParsableByteArray paramParsableByteArray, StringBuilder paramStringBuilder)
  {
    skipWhitespaceAndComments(paramParsableByteArray);
    if (paramParsableByteArray.bytesLeft() < 5) {}
    int i;
    do
    {
      do
      {
        return null;
      } while (!"::cue".equals(paramParsableByteArray.readString(5)));
      i = paramParsableByteArray.getPosition();
      str = parseNextToken(paramParsableByteArray, paramStringBuilder);
    } while (str == null);
    if ("{".equals(str))
    {
      paramParsableByteArray.setPosition(i);
      return "";
    }
    if ("(".equals(str)) {}
    for (String str = readCueTarget(paramParsableByteArray);; str = null)
    {
      paramParsableByteArray = parseNextToken(paramParsableByteArray, paramStringBuilder);
      if ((!")".equals(paramParsableByteArray)) || (paramParsableByteArray == null)) {
        break;
      }
      return str;
    }
  }
  
  private static void parseStyleDeclaration(ParsableByteArray paramParsableByteArray, WebvttCssStyle paramWebvttCssStyle, StringBuilder paramStringBuilder)
  {
    skipWhitespaceAndComments(paramParsableByteArray);
    String str1 = parseIdentifier(paramParsableByteArray, paramStringBuilder);
    if ("".equals(str1)) {}
    label21:
    String str2;
    label119:
    do
    {
      do
      {
        do
        {
          do
          {
            break label21;
            break label21;
            break label21;
            do
            {
              return;
            } while (!":".equals(parseNextToken(paramParsableByteArray, paramStringBuilder)));
            skipWhitespaceAndComments(paramParsableByteArray);
            str2 = parsePropertyValue(paramParsableByteArray, paramStringBuilder);
          } while ((str2 == null) || ("".equals(str2)));
          int i = paramParsableByteArray.getPosition();
          paramStringBuilder = parseNextToken(paramParsableByteArray, paramStringBuilder);
          if (";".equals(paramStringBuilder)) {}
          for (;;)
          {
            if (!"color".equals(str1)) {
              break label119;
            }
            paramWebvttCssStyle.setFontColor(ColorParser.parseCssColor(str2));
            return;
            if (!"}".equals(paramStringBuilder)) {
              break;
            }
            paramParsableByteArray.setPosition(i);
          }
          if ("background-color".equals(str1))
          {
            paramWebvttCssStyle.setBackgroundColor(ColorParser.parseCssColor(str2));
            return;
          }
          if (!"text-decoration".equals(str1)) {
            break;
          }
        } while (!"underline".equals(str2));
        paramWebvttCssStyle.setUnderline(true);
        return;
        if ("font-family".equals(str1))
        {
          paramWebvttCssStyle.setFontFamily(str2);
          return;
        }
        if (!"font-weight".equals(str1)) {
          break;
        }
      } while (!"bold".equals(str2));
      paramWebvttCssStyle.setBold(true);
      return;
    } while ((!"font-style".equals(str1)) || (!"italic".equals(str2)));
    paramWebvttCssStyle.setItalic(true);
  }
  
  private static char peekCharAtPosition(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    return (char)paramParsableByteArray.data[paramInt];
  }
  
  private static String readCueTarget(ParsableByteArray paramParsableByteArray)
  {
    int j = paramParsableByteArray.getPosition();
    int k = paramParsableByteArray.limit();
    int i = 0;
    if ((j < k) && (i == 0))
    {
      if ((char)paramParsableByteArray.data[j] == ')') {}
      for (i = 1;; i = 0)
      {
        j += 1;
        break;
      }
    }
    return paramParsableByteArray.readString(j - 1 - paramParsableByteArray.getPosition()).trim();
  }
  
  static void skipStyleBlock(ParsableByteArray paramParsableByteArray)
  {
    while (!TextUtils.isEmpty(paramParsableByteArray.readLine())) {}
  }
  
  static void skipWhitespaceAndComments(ParsableByteArray paramParsableByteArray)
  {
    int i = 1;
    while ((paramParsableByteArray.bytesLeft() > 0) && (i != 0)) {
      if ((maybeSkipWhitespace(paramParsableByteArray)) || (maybeSkipComment(paramParsableByteArray))) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public WebvttCssStyle parseBlock(ParsableByteArray paramParsableByteArray)
  {
    this.stringBuilder.setLength(0);
    int i = paramParsableByteArray.getPosition();
    skipStyleBlock(paramParsableByteArray);
    this.styleInput.reset(paramParsableByteArray.data, paramParsableByteArray.getPosition());
    this.styleInput.setPosition(i);
    paramParsableByteArray = parseSelector(this.styleInput, this.stringBuilder);
    WebvttCssStyle localWebvttCssStyle;
    if ((paramParsableByteArray == null) || (!"{".equals(parseNextToken(this.styleInput, this.stringBuilder)))) {
      localWebvttCssStyle = null;
    }
    do
    {
      return localWebvttCssStyle;
      localWebvttCssStyle = new WebvttCssStyle();
      applySelectorToStyle(localWebvttCssStyle, paramParsableByteArray);
      int j = 0;
      paramParsableByteArray = null;
      if (j == 0)
      {
        int k = this.styleInput.getPosition();
        String str = parseNextToken(this.styleInput, this.stringBuilder);
        if ((str == null) || ("}".equals(str))) {}
        for (i = 1;; i = 0)
        {
          j = i;
          paramParsableByteArray = str;
          if (i != 0) {
            break;
          }
          this.styleInput.setPosition(k);
          parseStyleDeclaration(this.styleInput, localWebvttCssStyle, this.stringBuilder);
          j = i;
          paramParsableByteArray = str;
          break;
        }
      }
    } while ("}".equals(paramParsableByteArray));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.text.webvtt.CssParser
 * JD-Core Version:    0.7.0.1
 */