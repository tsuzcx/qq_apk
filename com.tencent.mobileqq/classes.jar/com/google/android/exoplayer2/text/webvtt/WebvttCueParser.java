package com.google.android.exoplayer2.text.webvtt;

import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WebvttCueParser
{
  private static final char CHAR_AMPERSAND = '&';
  private static final char CHAR_GREATER_THAN = '>';
  private static final char CHAR_LESS_THAN = '<';
  private static final char CHAR_SEMI_COLON = ';';
  private static final char CHAR_SLASH = '/';
  private static final char CHAR_SPACE = ' ';
  public static final Pattern CUE_HEADER_PATTERN = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
  private static final Pattern CUE_SETTING_PATTERN = Pattern.compile("(\\S+?):(\\S+)");
  private static final String ENTITY_AMPERSAND = "amp";
  private static final String ENTITY_GREATER_THAN = "gt";
  private static final String ENTITY_LESS_THAN = "lt";
  private static final String ENTITY_NON_BREAK_SPACE = "nbsp";
  private static final int STYLE_BOLD = 1;
  private static final int STYLE_ITALIC = 2;
  private static final String TAG = "WebvttCueParser";
  private static final String TAG_BOLD = "b";
  private static final String TAG_CLASS = "c";
  private static final String TAG_ITALIC = "i";
  private static final String TAG_LANG = "lang";
  private static final String TAG_UNDERLINE = "u";
  private static final String TAG_VOICE = "v";
  private final StringBuilder textBuilder = new StringBuilder();
  
  private static void applyEntity(String paramString, SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = paramString.hashCode();
    if (i != 3309)
    {
      if (i != 3464)
      {
        if (i != 96708)
        {
          if ((i == 3374865) && (paramString.equals("nbsp")))
          {
            i = 2;
            break label92;
          }
        }
        else if (paramString.equals("amp"))
        {
          i = 3;
          break label92;
        }
      }
      else if (paramString.equals("lt"))
      {
        i = 0;
        break label92;
      }
    }
    else if (paramString.equals("gt"))
    {
      i = 1;
      break label92;
    }
    i = -1;
    label92:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            paramSpannableStringBuilder = new StringBuilder();
            paramSpannableStringBuilder.append("ignoring unsupported entity: '&");
            paramSpannableStringBuilder.append(paramString);
            paramSpannableStringBuilder.append(";'");
            Log.w("WebvttCueParser", paramSpannableStringBuilder.toString());
            return;
          }
          paramSpannableStringBuilder.append('&');
          return;
        }
        paramSpannableStringBuilder.append(' ');
        return;
      }
      paramSpannableStringBuilder.append('>');
      return;
    }
    paramSpannableStringBuilder.append('<');
  }
  
  private static void applySpansForTag(String paramString, WebvttCueParser.StartTag paramStartTag, SpannableStringBuilder paramSpannableStringBuilder, List<WebvttCssStyle> paramList, List<WebvttCueParser.StyleMatch> paramList1)
  {
    int k = paramStartTag.position;
    int m = paramSpannableStringBuilder.length();
    String str = paramStartTag.name;
    int i = str.hashCode();
    int j = 0;
    if (i != 0)
    {
      if (i != 105)
      {
        if (i != 3314158)
        {
          if (i != 98)
          {
            if (i != 99)
            {
              if (i != 117)
              {
                if ((i == 118) && (str.equals("v")))
                {
                  i = 5;
                  break label194;
                }
              }
              else if (str.equals("u"))
              {
                i = 2;
                break label194;
              }
            }
            else if (str.equals("c"))
            {
              i = 3;
              break label194;
            }
          }
          else if (str.equals("b"))
          {
            i = 0;
            break label194;
          }
        }
        else if (str.equals("lang"))
        {
          i = 4;
          break label194;
        }
      }
      else if (str.equals("i"))
      {
        i = 1;
        break label194;
      }
    }
    else if (str.equals(""))
    {
      i = 6;
      break label194;
    }
    i = -1;
    switch (i)
    {
    default: 
      return;
    case 2: 
      paramSpannableStringBuilder.setSpan(new UnderlineSpan(), k, m, 33);
      break;
    case 1: 
      paramSpannableStringBuilder.setSpan(new StyleSpan(2), k, m, 33);
      break;
    case 0: 
      label194:
      paramSpannableStringBuilder.setSpan(new StyleSpan(1), k, m, 33);
    }
    paramList1.clear();
    getApplicableStyles(paramList, paramString, paramStartTag, paramList1);
    int n = paramList1.size();
    i = j;
    while (i < n)
    {
      applyStyleToText(paramSpannableStringBuilder, ((WebvttCueParser.StyleMatch)paramList1.get(i)).style, k, m);
      i += 1;
    }
  }
  
  private static void applyStyleToText(SpannableStringBuilder paramSpannableStringBuilder, WebvttCssStyle paramWebvttCssStyle, int paramInt1, int paramInt2)
  {
    if (paramWebvttCssStyle == null) {
      return;
    }
    if (paramWebvttCssStyle.getStyle() != -1) {
      paramSpannableStringBuilder.setSpan(new StyleSpan(paramWebvttCssStyle.getStyle()), paramInt1, paramInt2, 33);
    }
    if (paramWebvttCssStyle.isLinethrough()) {
      paramSpannableStringBuilder.setSpan(new StrikethroughSpan(), paramInt1, paramInt2, 33);
    }
    if (paramWebvttCssStyle.isUnderline()) {
      paramSpannableStringBuilder.setSpan(new UnderlineSpan(), paramInt1, paramInt2, 33);
    }
    if (paramWebvttCssStyle.hasFontColor()) {
      paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramWebvttCssStyle.getFontColor()), paramInt1, paramInt2, 33);
    }
    if (paramWebvttCssStyle.hasBackgroundColor()) {
      paramSpannableStringBuilder.setSpan(new BackgroundColorSpan(paramWebvttCssStyle.getBackgroundColor()), paramInt1, paramInt2, 33);
    }
    if (paramWebvttCssStyle.getFontFamily() != null) {
      paramSpannableStringBuilder.setSpan(new TypefaceSpan(paramWebvttCssStyle.getFontFamily()), paramInt1, paramInt2, 33);
    }
    if (paramWebvttCssStyle.getTextAlign() != null) {
      paramSpannableStringBuilder.setSpan(new AlignmentSpan.Standard(paramWebvttCssStyle.getTextAlign()), paramInt1, paramInt2, 33);
    }
    int i = paramWebvttCssStyle.getFontSizeUnit();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        paramSpannableStringBuilder.setSpan(new RelativeSizeSpan(paramWebvttCssStyle.getFontSize() / 100.0F), paramInt1, paramInt2, 33);
        return;
      }
      paramSpannableStringBuilder.setSpan(new RelativeSizeSpan(paramWebvttCssStyle.getFontSize()), paramInt1, paramInt2, 33);
      return;
    }
    paramSpannableStringBuilder.setSpan(new AbsoluteSizeSpan((int)paramWebvttCssStyle.getFontSize(), true), paramInt1, paramInt2, 33);
  }
  
  private static int findEndOfTag(String paramString, int paramInt)
  {
    paramInt = paramString.indexOf('>', paramInt);
    if (paramInt == -1) {
      return paramString.length();
    }
    return paramInt + 1;
  }
  
  private static void getApplicableStyles(List<WebvttCssStyle> paramList, String paramString, WebvttCueParser.StartTag paramStartTag, List<WebvttCueParser.StyleMatch> paramList1)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      WebvttCssStyle localWebvttCssStyle = (WebvttCssStyle)paramList.get(i);
      int k = localWebvttCssStyle.getSpecificityScore(paramString, paramStartTag.name, paramStartTag.classes, paramStartTag.voice);
      if (k > 0) {
        paramList1.add(new WebvttCueParser.StyleMatch(k, localWebvttCssStyle));
      }
      i += 1;
    }
    Collections.sort(paramList1);
  }
  
  private static String getTagName(String paramString)
  {
    paramString = paramString.trim();
    if (paramString.isEmpty()) {
      return null;
    }
    return paramString.split("[ \\.]")[0];
  }
  
  private static boolean isSupportedTag(String paramString)
  {
    int i = paramString.hashCode();
    if (i != 98)
    {
      if (i != 99)
      {
        if (i != 105)
        {
          if (i != 3314158)
          {
            if (i != 117)
            {
              if ((i == 118) && (paramString.equals("v")))
              {
                i = 5;
                break label130;
              }
            }
            else if (paramString.equals("u"))
            {
              i = 4;
              break label130;
            }
          }
          else if (paramString.equals("lang"))
          {
            i = 3;
            break label130;
          }
        }
        else if (paramString.equals("i"))
        {
          i = 2;
          break label130;
        }
      }
      else if (paramString.equals("c"))
      {
        i = 1;
        break label130;
      }
    }
    else if (paramString.equals("b"))
    {
      i = 0;
      break label130;
    }
    i = -1;
    label130:
    return (i == 0) || (i == 1) || (i == 2) || (i == 3) || (i == 4) || (i == 5);
  }
  
  private static boolean parseCue(String paramString, Matcher paramMatcher, ParsableByteArray paramParsableByteArray, WebvttCue.Builder paramBuilder, StringBuilder paramStringBuilder, List<WebvttCssStyle> paramList)
  {
    try
    {
      paramBuilder.setStartTime(WebvttParserUtil.parseTimestampUs(paramMatcher.group(1))).setEndTime(WebvttParserUtil.parseTimestampUs(paramMatcher.group(2)));
      parseCueSettingsList(paramMatcher.group(3), paramBuilder);
      paramStringBuilder.setLength(0);
      for (;;)
      {
        paramMatcher = paramParsableByteArray.readLine();
        if (TextUtils.isEmpty(paramMatcher)) {
          break;
        }
        if (paramStringBuilder.length() > 0) {
          paramStringBuilder.append("\n");
        }
        paramStringBuilder.append(paramMatcher.trim());
      }
      parseCueText(paramString, paramStringBuilder.toString(), paramBuilder, paramList);
      return true;
    }
    catch (NumberFormatException paramString)
    {
      label95:
      break label95;
    }
    paramString = new StringBuilder();
    paramString.append("Skipping cue with bad header: ");
    paramString.append(paramMatcher.group());
    Log.w("WebvttCueParser", paramString.toString());
    return false;
  }
  
  static void parseCueSettingsList(String paramString, WebvttCue.Builder paramBuilder)
  {
    paramString = CUE_SETTING_PATTERN.matcher(paramString);
    while (paramString.find())
    {
      Object localObject = paramString.group(1);
      String str = paramString.group(2);
      try
      {
        if ("line".equals(localObject))
        {
          parseLineAttribute(str, paramBuilder);
          continue;
        }
        if ("align".equals(localObject))
        {
          paramBuilder.setTextAlignment(parseTextAlignment(str));
          continue;
        }
        if ("position".equals(localObject))
        {
          parsePositionAttribute(str, paramBuilder);
          continue;
        }
        if ("size".equals(localObject))
        {
          paramBuilder.setWidth(WebvttParserUtil.parsePercentage(str));
          continue;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unknown cue setting ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(":");
        localStringBuilder.append(str);
        Log.w("WebvttCueParser", localStringBuilder.toString());
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label162:
        break label162;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Skipping bad cue setting: ");
      ((StringBuilder)localObject).append(paramString.group());
      Log.w("WebvttCueParser", ((StringBuilder)localObject).toString());
    }
  }
  
  static void parseCueText(String paramString1, String paramString2, WebvttCue.Builder paramBuilder, List<WebvttCssStyle> paramList)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Stack localStack = new Stack();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString2.length())
    {
      char c = paramString2.charAt(i);
      int k;
      int j;
      if (c != '&')
      {
        if (c != '<')
        {
          localSpannableStringBuilder.append(c);
          i += 1;
        }
        else
        {
          k = i + 1;
          if (k >= paramString2.length())
          {
            i = k;
          }
          else
          {
            j = paramString2.charAt(k);
            int m = 1;
            if (j == 47) {
              j = 1;
            } else {
              j = 0;
            }
            int i1 = findEndOfTag(paramString2, k);
            int n = i1 - 2;
            if (paramString2.charAt(n) == '/') {
              k = 1;
            } else {
              k = 0;
            }
            if (j != 0) {
              m = 2;
            }
            if (k == 0) {
              n = i1 - 1;
            }
            Object localObject = paramString2.substring(i + m, n);
            String str = getTagName((String)localObject);
            i = i1;
            if (str != null) {
              if (!isSupportedTag(str))
              {
                i = i1;
              }
              else if (j != 0)
              {
                do
                {
                  if (localStack.isEmpty())
                  {
                    i = i1;
                    break;
                  }
                  localObject = (WebvttCueParser.StartTag)localStack.pop();
                  applySpansForTag(paramString1, (WebvttCueParser.StartTag)localObject, localSpannableStringBuilder, paramList, localArrayList);
                } while (!((WebvttCueParser.StartTag)localObject).name.equals(str));
                i = i1;
              }
              else
              {
                i = i1;
                if (k == 0)
                {
                  localStack.push(WebvttCueParser.StartTag.buildStartTag((String)localObject, localSpannableStringBuilder.length()));
                  i = i1;
                }
              }
            }
          }
        }
      }
      else
      {
        j = i + 1;
        i = paramString2.indexOf(';', j);
        k = paramString2.indexOf(' ', j);
        if (i == -1) {
          i = k;
        } else if (k != -1) {
          i = Math.min(i, k);
        }
        if (i != -1)
        {
          applyEntity(paramString2.substring(j, i), localSpannableStringBuilder);
          if (i == k) {
            localSpannableStringBuilder.append(" ");
          }
          i += 1;
        }
        else
        {
          localSpannableStringBuilder.append(c);
          i = j;
        }
      }
    }
    while (!localStack.isEmpty()) {
      applySpansForTag(paramString1, (WebvttCueParser.StartTag)localStack.pop(), localSpannableStringBuilder, paramList, localArrayList);
    }
    applySpansForTag(paramString1, WebvttCueParser.StartTag.buildWholeCueVirtualTag(), localSpannableStringBuilder, paramList, localArrayList);
    paramBuilder.setText(localSpannableStringBuilder);
  }
  
  private static void parseLineAttribute(String paramString, WebvttCue.Builder paramBuilder)
  {
    int i = paramString.indexOf(',');
    if (i != -1)
    {
      paramBuilder.setLineAnchor(parsePositionAnchor(paramString.substring(i + 1)));
      paramString = paramString.substring(0, i);
    }
    else
    {
      paramBuilder.setLineAnchor(-2147483648);
    }
    if (paramString.endsWith("%"))
    {
      paramBuilder.setLine(WebvttParserUtil.parsePercentage(paramString)).setLineType(0);
      return;
    }
    int j = Integer.parseInt(paramString);
    i = j;
    if (j < 0) {
      i = j - 1;
    }
    paramBuilder.setLine(i).setLineType(1);
  }
  
  private static int parsePositionAnchor(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 109757538: 
      if (paramString.equals("start")) {
        i = 0;
      }
      break;
    case 100571: 
      if (paramString.equals("end")) {
        i = 3;
      }
      break;
    case -1074341483: 
      if (paramString.equals("middle")) {
        i = 2;
      }
      break;
    case -1364013995: 
      if (paramString.equals("center")) {
        i = 1;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if ((i != 1) && (i != 2))
      {
        if (i != 3)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Invalid anchor value: ");
          localStringBuilder.append(paramString);
          Log.w("WebvttCueParser", localStringBuilder.toString());
          return -2147483648;
        }
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  private static void parsePositionAttribute(String paramString, WebvttCue.Builder paramBuilder)
  {
    int i = paramString.indexOf(',');
    if (i != -1)
    {
      paramBuilder.setPositionAnchor(parsePositionAnchor(paramString.substring(i + 1)));
      paramString = paramString.substring(0, i);
    }
    else
    {
      paramBuilder.setPositionAnchor(-2147483648);
    }
    paramBuilder.setPosition(WebvttParserUtil.parsePercentage(paramString));
  }
  
  private static Layout.Alignment parseTextAlignment(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 109757538: 
      if (paramString.equals("start")) {
        i = 0;
      }
      break;
    case 108511772: 
      if (paramString.equals("right")) {
        i = 5;
      }
      break;
    case 3317767: 
      if (paramString.equals("left")) {
        i = 1;
      }
      break;
    case 100571: 
      if (paramString.equals("end")) {
        i = 4;
      }
      break;
    case -1074341483: 
      if (paramString.equals("middle")) {
        i = 3;
      }
      break;
    case -1364013995: 
      if (paramString.equals("center")) {
        i = 2;
      }
      break;
    }
    int i = -1;
    if ((i != 0) && (i != 1))
    {
      if ((i != 2) && (i != 3))
      {
        if ((i != 4) && (i != 5))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Invalid alignment value: ");
          localStringBuilder.append(paramString);
          Log.w("WebvttCueParser", localStringBuilder.toString());
          return null;
        }
        return Layout.Alignment.ALIGN_OPPOSITE;
      }
      return Layout.Alignment.ALIGN_CENTER;
    }
    return Layout.Alignment.ALIGN_NORMAL;
  }
  
  public boolean parseCue(ParsableByteArray paramParsableByteArray, WebvttCue.Builder paramBuilder, List<WebvttCssStyle> paramList)
  {
    String str = paramParsableByteArray.readLine();
    if (str == null) {
      return false;
    }
    Object localObject = CUE_HEADER_PATTERN.matcher(str);
    if (((Matcher)localObject).matches()) {
      return parseCue(null, (Matcher)localObject, paramParsableByteArray, paramBuilder, this.textBuilder, paramList);
    }
    localObject = paramParsableByteArray.readLine();
    if (localObject == null) {
      return false;
    }
    localObject = CUE_HEADER_PATTERN.matcher((CharSequence)localObject);
    if (((Matcher)localObject).matches()) {
      return parseCue(str.trim(), (Matcher)localObject, paramParsableByteArray, paramBuilder, this.textBuilder, paramList);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.text.webvtt.WebvttCueParser
 * JD-Core Version:    0.7.0.1
 */