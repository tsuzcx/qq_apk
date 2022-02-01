package com.google.android.exoplayer2.text.ttml;

import android.text.Layout.Alignment;
import android.util.Log;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class TtmlDecoder
  extends SimpleSubtitleDecoder
{
  private static final String ATTR_BEGIN = "begin";
  private static final String ATTR_DURATION = "dur";
  private static final String ATTR_END = "end";
  private static final String ATTR_REGION = "region";
  private static final String ATTR_STYLE = "style";
  private static final Pattern CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
  private static final TtmlDecoder.FrameAndTickRate DEFAULT_FRAME_AND_TICK_RATE = new TtmlDecoder.FrameAndTickRate(30.0F, 1, 1);
  private static final int DEFAULT_FRAME_RATE = 30;
  private static final Pattern FONT_SIZE;
  private static final Pattern OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
  private static final Pattern PERCENTAGE_COORDINATES;
  private static final String TAG = "TtmlDecoder";
  private static final String TTP = "http://www.w3.org/ns/ttml#parameter";
  private final XmlPullParserFactory xmlParserFactory;
  
  static
  {
    FONT_SIZE = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    PERCENTAGE_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
  }
  
  public TtmlDecoder()
  {
    super("TtmlDecoder");
    try
    {
      this.xmlParserFactory = XmlPullParserFactory.newInstance();
      this.xmlParserFactory.setNamespaceAware(true);
      return;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      throw new RuntimeException("Couldn't create XmlPullParserFactory instance", localXmlPullParserException);
    }
  }
  
  private TtmlStyle createIfNull(TtmlStyle paramTtmlStyle)
  {
    TtmlStyle localTtmlStyle = paramTtmlStyle;
    if (paramTtmlStyle == null) {
      localTtmlStyle = new TtmlStyle();
    }
    return localTtmlStyle;
  }
  
  private static boolean isSupportedTag(String paramString)
  {
    return (paramString.equals("tt")) || (paramString.equals("head")) || (paramString.equals("body")) || (paramString.equals("div")) || (paramString.equals("p")) || (paramString.equals("span")) || (paramString.equals("br")) || (paramString.equals("style")) || (paramString.equals("styling")) || (paramString.equals("layout")) || (paramString.equals("region")) || (paramString.equals("metadata")) || (paramString.equals("smpte:image")) || (paramString.equals("smpte:data")) || (paramString.equals("smpte:information"));
  }
  
  private static void parseFontSize(String paramString, TtmlStyle paramTtmlStyle)
  {
    Object localObject = paramString.split("\\s+");
    if (localObject.length == 1)
    {
      localObject = FONT_SIZE.matcher(paramString);
    }
    else
    {
      if (localObject.length != 2) {
        break label274;
      }
      localObject = FONT_SIZE.matcher(localObject[1]);
      Log.w("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
    }
    if (((Matcher)localObject).matches())
    {
      paramString = ((Matcher)localObject).group(3);
      int i = -1;
      int j = paramString.hashCode();
      if (j != 37)
      {
        if (j != 3240)
        {
          if ((j == 3592) && (paramString.equals("px"))) {
            i = 0;
          }
        }
        else if (paramString.equals("em")) {
          i = 1;
        }
      }
      else if (paramString.equals("%")) {
        i = 2;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            paramTtmlStyle.setFontSizeUnit(3);
          }
          else
          {
            paramTtmlStyle = new StringBuilder();
            paramTtmlStyle.append("Invalid unit for fontSize: '");
            paramTtmlStyle.append(paramString);
            paramTtmlStyle.append("'.");
            throw new SubtitleDecoderException(paramTtmlStyle.toString());
          }
        }
        else {
          paramTtmlStyle.setFontSizeUnit(2);
        }
      }
      else {
        paramTtmlStyle.setFontSizeUnit(1);
      }
      paramTtmlStyle.setFontSize(Float.valueOf(((Matcher)localObject).group(1)).floatValue());
      return;
    }
    paramTtmlStyle = new StringBuilder();
    paramTtmlStyle.append("Invalid expression for fontSize: '");
    paramTtmlStyle.append(paramString);
    paramTtmlStyle.append("'.");
    throw new SubtitleDecoderException(paramTtmlStyle.toString());
    label274:
    paramString = new StringBuilder();
    paramString.append("Invalid number of entries for fontSize: ");
    paramString.append(localObject.length);
    paramString.append(".");
    throw new SubtitleDecoderException(paramString.toString());
  }
  
  private TtmlDecoder.FrameAndTickRate parseFrameAndTickRates(XmlPullParser paramXmlPullParser)
  {
    Object localObject = paramXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
    int i;
    if (localObject != null) {
      i = Integer.parseInt((String)localObject);
    } else {
      i = 30;
    }
    float f = 1.0F;
    localObject = paramXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
    if (localObject != null)
    {
      localObject = ((String)localObject).split(" ");
      if (localObject.length == 2) {
        f = Integer.parseInt(localObject[0]) / Integer.parseInt(localObject[1]);
      } else {
        throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
      }
    }
    int j = DEFAULT_FRAME_AND_TICK_RATE.subFrameRate;
    localObject = paramXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
    if (localObject != null) {
      j = Integer.parseInt((String)localObject);
    }
    int k = DEFAULT_FRAME_AND_TICK_RATE.tickRate;
    paramXmlPullParser = paramXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
    if (paramXmlPullParser != null) {
      k = Integer.parseInt(paramXmlPullParser);
    }
    return new TtmlDecoder.FrameAndTickRate(i * f, j, k);
  }
  
  private Map<String, TtmlStyle> parseHeader(XmlPullParser paramXmlPullParser, Map<String, TtmlStyle> paramMap, Map<String, TtmlRegion> paramMap1)
  {
    do
    {
      paramXmlPullParser.next();
      Object localObject1;
      if (XmlPullParserUtil.isStartTag(paramXmlPullParser, "style"))
      {
        Object localObject2 = XmlPullParserUtil.getAttributeValue(paramXmlPullParser, "style");
        localObject1 = parseStyleAttributes(paramXmlPullParser, new TtmlStyle());
        if (localObject2 != null)
        {
          localObject2 = parseStyleIds((String)localObject2);
          int j = localObject2.length;
          int i = 0;
          while (i < j)
          {
            ((TtmlStyle)localObject1).chain((TtmlStyle)paramMap.get(localObject2[i]));
            i += 1;
          }
        }
        if (((TtmlStyle)localObject1).getId() != null) {
          paramMap.put(((TtmlStyle)localObject1).getId(), localObject1);
        }
      }
      else if (XmlPullParserUtil.isStartTag(paramXmlPullParser, "region"))
      {
        localObject1 = parseRegionAttributes(paramXmlPullParser);
        if (localObject1 != null) {
          paramMap1.put(((TtmlRegion)localObject1).id, localObject1);
        }
      }
    } while (!XmlPullParserUtil.isEndTag(paramXmlPullParser, "head"));
    return paramMap;
  }
  
  private TtmlNode parseNode(XmlPullParser paramXmlPullParser, TtmlNode paramTtmlNode, Map<String, TtmlRegion> paramMap, TtmlDecoder.FrameAndTickRate paramFrameAndTickRate)
  {
    int k = paramXmlPullParser.getAttributeCount();
    TtmlStyle localTtmlStyle = parseStyleAttributes(paramXmlPullParser, null);
    Object localObject1 = null;
    Object localObject2 = "";
    int j = 0;
    long l1 = -9223372036854775807L;
    long l2 = -9223372036854775807L;
    long l5 = -9223372036854775807L;
    long l3;
    long l4;
    long l6;
    while (j < k)
    {
      Object localObject3 = paramXmlPullParser.getAttributeName(j);
      Object localObject5 = paramXmlPullParser.getAttributeValue(j);
      switch (((String)localObject3).hashCode())
      {
      default: 
        break;
      case 109780401: 
        if (((String)localObject3).equals("style")) {
          i = 3;
        }
        break;
      case 93616297: 
        if (((String)localObject3).equals("begin")) {
          i = 0;
        }
        break;
      case 100571: 
        if (((String)localObject3).equals("end")) {
          i = 1;
        }
        break;
      case 99841: 
        if (((String)localObject3).equals("dur")) {
          i = 2;
        }
        break;
      case -934795532: 
        if (((String)localObject3).equals("region")) {
          i = 4;
        }
        break;
      }
      int i = -1;
      Object localObject4;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                l3 = l1;
                l4 = l2;
                l6 = l5;
                localObject3 = localObject2;
                localObject4 = localObject1;
              }
              else
              {
                l3 = l1;
                l4 = l2;
                l6 = l5;
                localObject3 = localObject2;
                localObject4 = localObject1;
                if (paramMap.containsKey(localObject5))
                {
                  localObject3 = localObject5;
                  l3 = l1;
                  l4 = l2;
                  l6 = l5;
                  localObject4 = localObject1;
                }
              }
            }
            else
            {
              localObject5 = parseStyleIds((String)localObject5);
              l3 = l1;
              l4 = l2;
              l6 = l5;
              localObject3 = localObject2;
              localObject4 = localObject1;
              if (localObject5.length > 0)
              {
                localObject4 = localObject5;
                l3 = l1;
                l4 = l2;
                l6 = l5;
                localObject3 = localObject2;
              }
            }
          }
          else
          {
            l6 = parseTimeExpression((String)localObject5, paramFrameAndTickRate);
            l3 = l1;
            l4 = l2;
            localObject3 = localObject2;
            localObject4 = localObject1;
          }
        }
        else
        {
          l4 = parseTimeExpression((String)localObject5, paramFrameAndTickRate);
          l3 = l1;
          l6 = l5;
          localObject3 = localObject2;
          localObject4 = localObject1;
        }
      }
      else
      {
        l3 = parseTimeExpression((String)localObject5, paramFrameAndTickRate);
        localObject4 = localObject1;
        localObject3 = localObject2;
        l6 = l5;
        l4 = l2;
      }
      j += 1;
      l1 = l3;
      l2 = l4;
      l5 = l6;
      localObject2 = localObject3;
      localObject1 = localObject4;
    }
    if (paramTtmlNode != null)
    {
      l6 = l1;
      l4 = l2;
      if (paramTtmlNode.startTimeUs != -9223372036854775807L)
      {
        l3 = l1;
        if (l1 != -9223372036854775807L) {
          l3 = l1 + paramTtmlNode.startTimeUs;
        }
        l6 = l3;
        l4 = l2;
        if (l2 != -9223372036854775807L)
        {
          l4 = l2 + paramTtmlNode.startTimeUs;
          l6 = l3;
        }
      }
    }
    else
    {
      l4 = l2;
      l6 = l1;
    }
    if (l4 == -9223372036854775807L)
    {
      if (l5 != -9223372036854775807L)
      {
        l1 = l5 + l6;
        break label625;
      }
      if ((paramTtmlNode != null) && (paramTtmlNode.endTimeUs != -9223372036854775807L))
      {
        l1 = paramTtmlNode.endTimeUs;
        break label625;
      }
    }
    l1 = l4;
    label625:
    return TtmlNode.buildNode(paramXmlPullParser.getName(), l6, l1, localTtmlStyle, localObject1, (String)localObject2);
  }
  
  private TtmlRegion parseRegionAttributes(XmlPullParser paramXmlPullParser)
  {
    String str2 = XmlPullParserUtil.getAttributeValue(paramXmlPullParser, "id");
    if (str2 == null) {
      return null;
    }
    String str1 = XmlPullParserUtil.getAttributeValue(paramXmlPullParser, "origin");
    Object localObject;
    if (str1 != null)
    {
      localObject = PERCENTAGE_COORDINATES.matcher(str1);
      if (!((Matcher)localObject).matches()) {}
    }
    try
    {
      f2 = Float.parseFloat(((Matcher)localObject).group(1)) / 100.0F;
      j = 2;
      f1 = Float.parseFloat(((Matcher)localObject).group(2));
      f1 /= 100.0F;
      localObject = XmlPullParserUtil.getAttributeValue(paramXmlPullParser, "extent");
      if (localObject != null)
      {
        localObject = PERCENTAGE_COORDINATES.matcher((CharSequence)localObject);
        if (!((Matcher)localObject).matches()) {}
      }
    }
    catch (NumberFormatException paramXmlPullParser)
    {
      float f2;
      int j;
      float f1;
      float f3;
      float f4;
      int i;
      label263:
      label280:
      break label361;
    }
    try
    {
      f3 = Float.parseFloat(((Matcher)localObject).group(1)) / 100.0F;
      f4 = Float.parseFloat(((Matcher)localObject).group(2));
      f4 /= 100.0F;
      paramXmlPullParser = XmlPullParserUtil.getAttributeValue(paramXmlPullParser, "displayAlign");
      if (paramXmlPullParser != null)
      {
        paramXmlPullParser = Util.toLowerInvariant(paramXmlPullParser);
        i = -1;
        int k = paramXmlPullParser.hashCode();
        if (k != -1364013995)
        {
          if ((k == 92734940) && (paramXmlPullParser.equals("after"))) {
            i = 1;
          }
        }
        else if (paramXmlPullParser.equals("center")) {
          i = 0;
        }
        if (i != 0)
        {
          if (i == 1)
          {
            f1 += f4;
            i = j;
            break label263;
          }
        }
        else
        {
          f1 += f4 / 2.0F;
          i = 1;
          break label263;
        }
      }
      i = 0;
      return new TtmlRegion(str2, f2, f1, 0, i, f3);
    }
    catch (NumberFormatException paramXmlPullParser)
    {
      break label280;
    }
    paramXmlPullParser = new StringBuilder();
    paramXmlPullParser.append("Ignoring region with malformed extent: ");
    paramXmlPullParser.append(str1);
    Log.w("TtmlDecoder", paramXmlPullParser.toString());
    return null;
    paramXmlPullParser = new StringBuilder();
    paramXmlPullParser.append("Ignoring region with unsupported extent: ");
    paramXmlPullParser.append(str1);
    Log.w("TtmlDecoder", paramXmlPullParser.toString());
    return null;
    Log.w("TtmlDecoder", "Ignoring region without an extent");
    return null;
    label361:
    paramXmlPullParser = new StringBuilder();
    paramXmlPullParser.append("Ignoring region with malformed origin: ");
    paramXmlPullParser.append(str1);
    Log.w("TtmlDecoder", paramXmlPullParser.toString());
    return null;
    paramXmlPullParser = new StringBuilder();
    paramXmlPullParser.append("Ignoring region with unsupported origin: ");
    paramXmlPullParser.append(str1);
    Log.w("TtmlDecoder", paramXmlPullParser.toString());
    return null;
    Log.w("TtmlDecoder", "Ignoring region without an origin");
    return null;
  }
  
  private TtmlStyle parseStyleAttributes(XmlPullParser paramXmlPullParser, TtmlStyle paramTtmlStyle)
  {
    int m = paramXmlPullParser.getAttributeCount();
    int j = 0;
    for (Object localObject = paramTtmlStyle; j < m; localObject = paramTtmlStyle)
    {
      String str = paramXmlPullParser.getAttributeValue(j);
      paramTtmlStyle = paramXmlPullParser.getAttributeName(j);
      int i = paramTtmlStyle.hashCode();
      int k = -1;
      switch (i)
      {
      default: 
        break;
      case 1287124693: 
        if (paramTtmlStyle.equals("backgroundColor")) {
          i = 1;
        }
        break;
      case 365601008: 
        if (paramTtmlStyle.equals("fontSize")) {
          i = 4;
        }
        break;
      case 94842723: 
        if (paramTtmlStyle.equals("color")) {
          i = 2;
        }
        break;
      case 3355: 
        if (paramTtmlStyle.equals("id")) {
          i = 0;
        }
        break;
      case -734428249: 
        if (paramTtmlStyle.equals("fontWeight")) {
          i = 5;
        }
        break;
      case -879295043: 
        if (paramTtmlStyle.equals("textDecoration")) {
          i = 8;
        }
        break;
      case -1065511464: 
        if (paramTtmlStyle.equals("textAlign")) {
          i = 7;
        }
        break;
      case -1224696685: 
        if (paramTtmlStyle.equals("fontFamily")) {
          i = 3;
        }
        break;
      case -1550943582: 
        if (paramTtmlStyle.equals("fontStyle")) {
          i = 6;
        }
        break;
      }
      i = -1;
      switch (i)
      {
      default: 
        paramTtmlStyle = (TtmlStyle)localObject;
        break;
      case 8: 
        paramTtmlStyle = Util.toLowerInvariant(str);
        switch (paramTtmlStyle.hashCode())
        {
        default: 
          i = k;
          break;
        case 1679736913: 
          i = k;
          if (paramTtmlStyle.equals("linethrough")) {
            i = 0;
          }
          break;
        case 913457136: 
          i = k;
          if (paramTtmlStyle.equals("nolinethrough")) {
            i = 1;
          }
          break;
        case -1026963764: 
          i = k;
          if (paramTtmlStyle.equals("underline")) {
            i = 2;
          }
          break;
        case -1461280213: 
          i = k;
          if (paramTtmlStyle.equals("nounderline")) {
            i = 3;
          }
          break;
        }
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3) {
                paramTtmlStyle = (TtmlStyle)localObject;
              } else {
                paramTtmlStyle = createIfNull((TtmlStyle)localObject).setUnderline(false);
              }
            }
            else {
              paramTtmlStyle = createIfNull((TtmlStyle)localObject).setUnderline(true);
            }
          }
          else {
            paramTtmlStyle = createIfNull((TtmlStyle)localObject).setLinethrough(false);
          }
        }
        else {
          paramTtmlStyle = createIfNull((TtmlStyle)localObject).setLinethrough(true);
        }
        break;
      case 7: 
        paramTtmlStyle = Util.toLowerInvariant(str);
        switch (paramTtmlStyle.hashCode())
        {
        default: 
          i = k;
          break;
        case 109757538: 
          i = k;
          if (paramTtmlStyle.equals("start")) {
            i = 1;
          }
          break;
        case 108511772: 
          i = k;
          if (paramTtmlStyle.equals("right")) {
            i = 2;
          }
          break;
        case 3317767: 
          i = k;
          if (paramTtmlStyle.equals("left")) {
            i = 0;
          }
          break;
        case 100571: 
          i = k;
          if (paramTtmlStyle.equals("end")) {
            i = 3;
          }
          break;
        case -1364013995: 
          i = k;
          if (paramTtmlStyle.equals("center")) {
            i = 4;
          }
          break;
        }
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i != 4) {
                  paramTtmlStyle = (TtmlStyle)localObject;
                } else {
                  paramTtmlStyle = createIfNull((TtmlStyle)localObject).setTextAlign(Layout.Alignment.ALIGN_CENTER);
                }
              }
              else {
                paramTtmlStyle = createIfNull((TtmlStyle)localObject).setTextAlign(Layout.Alignment.ALIGN_OPPOSITE);
              }
            }
            else {
              paramTtmlStyle = createIfNull((TtmlStyle)localObject).setTextAlign(Layout.Alignment.ALIGN_OPPOSITE);
            }
          }
          else {
            paramTtmlStyle = createIfNull((TtmlStyle)localObject).setTextAlign(Layout.Alignment.ALIGN_NORMAL);
          }
        }
        else {
          paramTtmlStyle = createIfNull((TtmlStyle)localObject).setTextAlign(Layout.Alignment.ALIGN_NORMAL);
        }
        break;
      case 6: 
        paramTtmlStyle = createIfNull((TtmlStyle)localObject).setItalic("italic".equalsIgnoreCase(str));
        break;
      case 5: 
        paramTtmlStyle = createIfNull((TtmlStyle)localObject).setBold("bold".equalsIgnoreCase(str));
        break;
      case 4: 
        paramTtmlStyle = (TtmlStyle)localObject;
      }
      try
      {
        localObject = createIfNull((TtmlStyle)localObject);
        paramTtmlStyle = (TtmlStyle)localObject;
        parseFontSize(str, (TtmlStyle)localObject);
        paramTtmlStyle = (TtmlStyle)localObject;
      }
      catch (SubtitleDecoderException localSubtitleDecoderException)
      {
        label875:
        break label875;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed parsing fontSize value: ");
      ((StringBuilder)localObject).append(str);
      Log.w("TtmlDecoder", ((StringBuilder)localObject).toString());
      break label1079;
      paramTtmlStyle = createIfNull((TtmlStyle)localObject).setFontFamily(str);
      break label1079;
      paramTtmlStyle = createIfNull((TtmlStyle)localObject);
      try
      {
        paramTtmlStyle.setFontColor(ColorParser.parseTtmlColor(str));
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        label950:
        break label950;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed parsing color value: ");
      ((StringBuilder)localObject).append(str);
      Log.w("TtmlDecoder", ((StringBuilder)localObject).toString());
      break label1079;
      paramTtmlStyle = createIfNull((TtmlStyle)localObject);
      label1079:
      try
      {
        paramTtmlStyle.setBackgroundColor(ColorParser.parseTtmlColor(str));
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        label1010:
        break label1010;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed parsing background value: ");
      ((StringBuilder)localObject).append(str);
      Log.w("TtmlDecoder", ((StringBuilder)localObject).toString());
      break label1079;
      paramTtmlStyle = (TtmlStyle)localObject;
      if ("style".equals(paramXmlPullParser.getName())) {
        paramTtmlStyle = createIfNull((TtmlStyle)localObject).setId(str);
      }
      j += 1;
    }
    return localObject;
  }
  
  private String[] parseStyleIds(String paramString)
  {
    return paramString.split("\\s+");
  }
  
  private static long parseTimeExpression(String paramString, TtmlDecoder.FrameAndTickRate paramFrameAndTickRate)
  {
    Matcher localMatcher = CLOCK_TIME.matcher(paramString);
    double d1;
    double d2;
    if (localMatcher.matches())
    {
      double d4 = Long.parseLong(localMatcher.group(1)) * 3600L;
      double d5 = Long.parseLong(localMatcher.group(2)) * 60L;
      Double.isNaN(d4);
      Double.isNaN(d5);
      double d6 = Long.parseLong(localMatcher.group(3));
      Double.isNaN(d6);
      paramString = localMatcher.group(4);
      double d3 = 0.0D;
      if (paramString != null) {
        d1 = Double.parseDouble(paramString);
      } else {
        d1 = 0.0D;
      }
      paramString = localMatcher.group(5);
      if (paramString != null) {
        d2 = (float)Long.parseLong(paramString) / paramFrameAndTickRate.effectiveFrameRate;
      } else {
        d2 = 0.0D;
      }
      paramString = localMatcher.group(6);
      if (paramString != null)
      {
        d3 = Long.parseLong(paramString);
        double d7 = paramFrameAndTickRate.subFrameRate;
        Double.isNaN(d3);
        Double.isNaN(d7);
        d3 /= d7;
        d7 = paramFrameAndTickRate.effectiveFrameRate;
        Double.isNaN(d7);
        d3 /= d7;
      }
      return ((d4 + d5 + d6 + d1 + d2 + d3) * 1000000.0D);
    }
    localMatcher = OFFSET_TIME.matcher(paramString);
    if (localMatcher.matches())
    {
      d2 = Double.parseDouble(localMatcher.group(1));
      paramString = localMatcher.group(2);
      int i = paramString.hashCode();
      if (i != 102)
      {
        if (i != 104)
        {
          if (i != 109)
          {
            if (i != 3494)
            {
              if (i != 115)
              {
                if ((i == 116) && (paramString.equals("t")))
                {
                  i = 5;
                  break label406;
                }
              }
              else if (paramString.equals("s"))
              {
                i = 2;
                break label406;
              }
            }
            else if (paramString.equals("ms"))
            {
              i = 3;
              break label406;
            }
          }
          else if (paramString.equals("m"))
          {
            i = 1;
            break label406;
          }
        }
        else if (paramString.equals("h"))
        {
          i = 0;
          break label406;
        }
      }
      else if (paramString.equals("f"))
      {
        i = 4;
        break label406;
      }
      i = -1;
      label406:
      if (i != 0)
      {
        if (i != 1)
        {
          d1 = d2;
          if (i == 2) {
            break label506;
          }
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5)
              {
                d1 = d2;
                break label506;
              }
              d1 = paramFrameAndTickRate.tickRate;
              Double.isNaN(d1);
            }
            else
            {
              d1 = paramFrameAndTickRate.effectiveFrameRate;
              Double.isNaN(d1);
            }
          }
          else {
            d1 = 1000.0D;
          }
          d1 = d2 / d1;
          break label506;
        }
        d1 = 60.0D;
      }
      else
      {
        d1 = 3600.0D;
      }
      d1 = d2 * d1;
      label506:
      return (d1 * 1000000.0D);
    }
    paramFrameAndTickRate = new StringBuilder();
    paramFrameAndTickRate.append("Malformed time expression: ");
    paramFrameAndTickRate.append(paramString);
    throw new SubtitleDecoderException(paramFrameAndTickRate.toString());
  }
  
  protected TtmlSubtitle decode(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        localXmlPullParser = this.xmlParserFactory.newPullParser();
        HashMap localHashMap1 = new HashMap();
        HashMap localHashMap2 = new HashMap();
        localObject1 = null;
        localHashMap2.put("", new TtmlRegion(null));
        i = 0;
        localXmlPullParser.setInput(new ByteArrayInputStream(paramArrayOfByte, 0, paramInt), null);
        LinkedList localLinkedList = new LinkedList();
        j = localXmlPullParser.getEventType();
        paramArrayOfByte = DEFAULT_FRAME_AND_TICK_RATE;
        if (j == 1) {
          continue;
        }
        TtmlNode localTtmlNode1 = (TtmlNode)localLinkedList.peekLast();
        if (i != 0) {
          continue;
        }
        Object localObject2 = localXmlPullParser.getName();
        if (j == 2)
        {
          if ("tt".equals(localObject2)) {
            paramArrayOfByte = parseFrameAndTickRates(localXmlPullParser);
          }
          paramBoolean = isSupportedTag((String)localObject2);
          if (!paramBoolean)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Ignoring unsupported tag: ");
            ((StringBuilder)localObject2).append(localXmlPullParser.getName());
            Log.i("TtmlDecoder", ((StringBuilder)localObject2).toString());
            continue;
          }
          if ("head".equals(localObject2))
          {
            parseHeader(localXmlPullParser, localHashMap1, localHashMap2);
            localObject2 = paramArrayOfByte;
            paramInt = i;
            localObject3 = localObject1;
          }
          else
          {
            try
            {
              TtmlNode localTtmlNode2 = parseNode(localXmlPullParser, localTtmlNode1, localHashMap2, paramArrayOfByte);
              localLinkedList.addLast(localTtmlNode2);
              localObject2 = paramArrayOfByte;
              paramInt = i;
              localObject3 = localObject1;
              if (localTtmlNode1 == null) {
                continue;
              }
              localTtmlNode1.addChild(localTtmlNode2);
              localObject2 = paramArrayOfByte;
              paramInt = i;
              localObject3 = localObject1;
            }
            catch (SubtitleDecoderException localSubtitleDecoderException)
            {
              Log.w("TtmlDecoder", "Suppressing parser error", localSubtitleDecoderException);
              continue;
            }
          }
        }
        else if (j == 4)
        {
          localTtmlNode1.addChild(TtmlNode.buildTextNode(localXmlPullParser.getText()));
          arrayOfByte = paramArrayOfByte;
          paramInt = i;
          localObject3 = localObject1;
        }
        else
        {
          arrayOfByte = paramArrayOfByte;
          paramInt = i;
          localObject3 = localObject1;
          if (j == 3)
          {
            if (localXmlPullParser.getName().equals("tt")) {
              localObject1 = new TtmlSubtitle((TtmlNode)localLinkedList.getLast(), localHashMap1, localHashMap2);
            }
            localLinkedList.removeLast();
            arrayOfByte = paramArrayOfByte;
            paramInt = i;
            localObject3 = localObject1;
          }
        }
      }
      catch (IOException paramArrayOfByte)
      {
        XmlPullParser localXmlPullParser;
        throw new IllegalStateException("Unexpected error when reading input.", paramArrayOfByte);
      }
      catch (XmlPullParserException paramArrayOfByte)
      {
        Object localObject1;
        int i;
        int j;
        paramArrayOfByte = new SubtitleDecoderException("Unable to decode source", paramArrayOfByte);
        continue;
        throw paramArrayOfByte;
        continue;
        if (j != 2) {
          continue;
        }
        paramInt = i + 1;
        byte[] arrayOfByte = paramArrayOfByte;
        Object localObject3 = localObject1;
        continue;
        arrayOfByte = paramArrayOfByte;
        paramInt = i;
        localObject3 = localObject1;
        if (j != 3) {
          continue;
        }
        paramInt = i - 1;
        arrayOfByte = paramArrayOfByte;
        localObject3 = localObject1;
        continue;
      }
      localXmlPullParser.next();
      j = localXmlPullParser.getEventType();
      paramArrayOfByte = arrayOfByte;
      i = paramInt;
      localObject1 = localObject3;
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.text.ttml.TtmlDecoder
 * JD-Core Version:    0.7.0.1
 */