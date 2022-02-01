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
    if ("".equals(paramString)) {
      return;
    }
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
    else
    {
      paramWebvttCssStyle.setTargetTagName((String)localObject);
    }
    if (paramString.length > 1) {
      paramWebvttCssStyle.setTargetClasses((String[])Arrays.copyOfRange(paramString, 1, paramString.length));
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
      if (arrayOfByte[i] == 47)
      {
        i = k + 1;
        if (arrayOfByte[k] == 42)
        {
          for (;;)
          {
            k = i + 1;
            if (k >= j) {
              break;
            }
            if (((char)arrayOfByte[i] == '*') && ((char)arrayOfByte[k] == '/'))
            {
              i = k + 1;
              j = i;
            }
            else
            {
              i = k;
            }
          }
          paramParsableByteArray.skipBytes(j - paramParsableByteArray.getPosition());
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean maybeSkipWhitespace(ParsableByteArray paramParsableByteArray)
  {
    int i = peekCharAtPosition(paramParsableByteArray, paramParsableByteArray.getPosition());
    if ((i != 9) && (i != 10) && (i != 12) && (i != 13) && (i != 32)) {
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
      if (((c < 'A') || (c > 'Z')) && ((c < 'a') || (c > 'z')) && ((c < '0') || (c > '9')) && (c != '#') && (c != '-') && (c != '.') && (c != '_'))
      {
        j = 1;
      }
      else
      {
        i += 1;
        paramStringBuilder.append(c);
      }
    }
    paramParsableByteArray.skipBytes(i - paramParsableByteArray.getPosition());
    return paramStringBuilder.toString();
  }
  
  static String parseNextToken(ParsableByteArray paramParsableByteArray, StringBuilder paramStringBuilder)
  {
    skipWhitespaceAndComments(paramParsableByteArray);
    if (paramParsableByteArray.bytesLeft() == 0) {
      return null;
    }
    paramStringBuilder = parseIdentifier(paramParsableByteArray, paramStringBuilder);
    if (!"".equals(paramStringBuilder)) {
      return paramStringBuilder;
    }
    paramStringBuilder = new StringBuilder();
    paramStringBuilder.append("");
    paramStringBuilder.append((char)paramParsableByteArray.readUnsignedByte());
    return paramStringBuilder.toString();
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
      if ((!"}".equals(str)) && (!";".equals(str)))
      {
        localStringBuilder.append(str);
      }
      else
      {
        paramParsableByteArray.setPosition(j);
        i = 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  private static String parseSelector(ParsableByteArray paramParsableByteArray, StringBuilder paramStringBuilder)
  {
    skipWhitespaceAndComments(paramParsableByteArray);
    if (paramParsableByteArray.bytesLeft() < 5) {
      return null;
    }
    if (!"::cue".equals(paramParsableByteArray.readString(5))) {
      return null;
    }
    int i = paramParsableByteArray.getPosition();
    String str = parseNextToken(paramParsableByteArray, paramStringBuilder);
    if (str == null) {
      return null;
    }
    if ("{".equals(str))
    {
      paramParsableByteArray.setPosition(i);
      return "";
    }
    if ("(".equals(str)) {
      str = readCueTarget(paramParsableByteArray);
    } else {
      str = null;
    }
    paramParsableByteArray = parseNextToken(paramParsableByteArray, paramStringBuilder);
    if (")".equals(paramParsableByteArray))
    {
      if (paramParsableByteArray == null) {
        return null;
      }
      return str;
    }
    return null;
  }
  
  private static void parseStyleDeclaration(ParsableByteArray paramParsableByteArray, WebvttCssStyle paramWebvttCssStyle, StringBuilder paramStringBuilder)
  {
    skipWhitespaceAndComments(paramParsableByteArray);
    String str1 = parseIdentifier(paramParsableByteArray, paramStringBuilder);
    if ("".equals(str1)) {
      return;
    }
    if (!":".equals(parseNextToken(paramParsableByteArray, paramStringBuilder))) {
      return;
    }
    skipWhitespaceAndComments(paramParsableByteArray);
    String str2 = parsePropertyValue(paramParsableByteArray, paramStringBuilder);
    if (str2 != null)
    {
      if ("".equals(str2)) {
        return;
      }
      int i = paramParsableByteArray.getPosition();
      paramStringBuilder = parseNextToken(paramParsableByteArray, paramStringBuilder);
      if (!";".equals(paramStringBuilder))
      {
        if ("}".equals(paramStringBuilder)) {
          paramParsableByteArray.setPosition(i);
        }
      }
      else
      {
        if ("color".equals(str1))
        {
          paramWebvttCssStyle.setFontColor(ColorParser.parseCssColor(str2));
          return;
        }
        if ("background-color".equals(str1))
        {
          paramWebvttCssStyle.setBackgroundColor(ColorParser.parseCssColor(str2));
          return;
        }
        if ("text-decoration".equals(str1))
        {
          if ("underline".equals(str2)) {
            paramWebvttCssStyle.setUnderline(true);
          }
        }
        else
        {
          if ("font-family".equals(str1))
          {
            paramWebvttCssStyle.setFontFamily(str2);
            return;
          }
          if ("font-weight".equals(str1))
          {
            if ("bold".equals(str2)) {
              paramWebvttCssStyle.setBold(true);
            }
          }
          else if (("font-style".equals(str1)) && ("italic".equals(str2))) {
            paramWebvttCssStyle.setItalic(true);
          }
        }
      }
    }
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
    while ((j < k) && (i == 0))
    {
      if ((char)paramParsableByteArray.data[j] == ')') {
        i = 1;
      } else {
        i = 0;
      }
      j += 1;
    }
    return paramParsableByteArray.readString(j - 1 - paramParsableByteArray.getPosition()).trim();
  }
  
  static void skipStyleBlock(ParsableByteArray paramParsableByteArray)
  {
    while (!TextUtils.isEmpty(paramParsableByteArray.readLine())) {}
  }
  
  static void skipWhitespaceAndComments(ParsableByteArray paramParsableByteArray)
  {
    for (int i = 1;; i = 0)
    {
      if ((paramParsableByteArray.bytesLeft() <= 0) || (i == 0)) {
        return;
      }
      if ((maybeSkipWhitespace(paramParsableByteArray)) || (maybeSkipComment(paramParsableByteArray))) {
        break;
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
    String str = parseSelector(this.styleInput, this.stringBuilder);
    Object localObject = null;
    paramParsableByteArray = localObject;
    if (str != null)
    {
      if (!"{".equals(parseNextToken(this.styleInput, this.stringBuilder))) {
        return null;
      }
      WebvttCssStyle localWebvttCssStyle = new WebvttCssStyle();
      applySelectorToStyle(localWebvttCssStyle, str);
      str = null;
      i = 0;
      while (i == 0)
      {
        int j = this.styleInput.getPosition();
        str = parseNextToken(this.styleInput, this.stringBuilder);
        if ((str != null) && (!"}".equals(str))) {
          i = 0;
        } else {
          i = 1;
        }
        if (i == 0)
        {
          this.styleInput.setPosition(j);
          parseStyleDeclaration(this.styleInput, localWebvttCssStyle, this.stringBuilder);
        }
      }
      paramParsableByteArray = localObject;
      if ("}".equals(str)) {
        paramParsableByteArray = localWebvttCssStyle;
      }
    }
    return paramParsableByteArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.text.webvtt.CssParser
 * JD-Core Version:    0.7.0.1
 */