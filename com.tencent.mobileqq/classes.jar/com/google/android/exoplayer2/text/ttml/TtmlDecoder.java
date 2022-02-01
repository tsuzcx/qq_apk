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
    label21:
    int i;
    if (localObject.length == 1)
    {
      localObject = FONT_SIZE.matcher(paramString);
      if (!((Matcher)localObject).matches()) {
        break label279;
      }
      paramString = ((Matcher)localObject).group(3);
      i = -1;
      switch (paramString.hashCode())
      {
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new SubtitleDecoderException("Invalid unit for fontSize: '" + paramString + "'.");
        if (localObject.length == 2)
        {
          localObject = FONT_SIZE.matcher(localObject[1]);
          Log.w("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
          break label21;
        }
        throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + localObject.length + ".");
        if (paramString.equals("px"))
        {
          i = 0;
          continue;
          if (paramString.equals("em"))
          {
            i = 1;
            continue;
            if (paramString.equals("%")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    paramTtmlStyle.setFontSizeUnit(1);
    for (;;)
    {
      paramTtmlStyle.setFontSize(Float.valueOf(((Matcher)localObject).group(1)).floatValue());
      return;
      paramTtmlStyle.setFontSizeUnit(2);
      continue;
      paramTtmlStyle.setFontSizeUnit(3);
    }
    label279:
    throw new SubtitleDecoderException("Invalid expression for fontSize: '" + paramString + "'.");
  }
  
  private TtmlDecoder.FrameAndTickRate parseFrameAndTickRates(XmlPullParser paramXmlPullParser)
  {
    int i = 30;
    Object localObject = paramXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
    if (localObject != null) {
      i = Integer.parseInt((String)localObject);
    }
    float f = 1.0F;
    localObject = paramXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
    if (localObject != null)
    {
      localObject = ((String)localObject).split(" ");
      if (localObject.length != 2) {
        throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
      }
      f = Integer.parseInt(localObject[0]) / Integer.parseInt(localObject[1]);
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
    while (XmlPullParserUtil.isEndTag(paramXmlPullParser, "head"))
    {
      return paramMap;
      if (XmlPullParserUtil.isStartTag(paramXmlPullParser, "region"))
      {
        localObject1 = parseRegionAttributes(paramXmlPullParser);
        if (localObject1 != null) {
          paramMap1.put(((TtmlRegion)localObject1).id, localObject1);
        }
      }
    }
  }
  
  private TtmlNode parseNode(XmlPullParser paramXmlPullParser, TtmlNode paramTtmlNode, Map<String, TtmlRegion> paramMap, TtmlDecoder.FrameAndTickRate paramFrameAndTickRate)
  {
    long l3 = -9223372036854775807L;
    long l1 = -9223372036854775807L;
    long l2 = -9223372036854775807L;
    Object localObject1 = "";
    Object localObject2 = null;
    int k = paramXmlPullParser.getAttributeCount();
    TtmlStyle localTtmlStyle = parseStyleAttributes(paramXmlPullParser, null);
    int j = 0;
    label128:
    label164:
    long l4;
    if (j < k)
    {
      String str = paramXmlPullParser.getAttributeName(j);
      Object localObject3 = paramXmlPullParser.getAttributeValue(j);
      int i = -1;
      switch (str.hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          l4 = l2;
          l2 = l1;
          l1 = l4;
        }
        break;
      }
      for (;;)
      {
        j += 1;
        l4 = l2;
        l2 = l1;
        l1 = l4;
        break;
        if (!str.equals("begin")) {
          break label128;
        }
        i = 0;
        break label128;
        if (!str.equals("end")) {
          break label128;
        }
        i = 1;
        break label128;
        if (!str.equals("dur")) {
          break label128;
        }
        i = 2;
        break label128;
        if (!str.equals("style")) {
          break label128;
        }
        i = 3;
        break label128;
        if (!str.equals("region")) {
          break label128;
        }
        i = 4;
        break label128;
        l4 = parseTimeExpression((String)localObject3, paramFrameAndTickRate);
        l1 = l2;
        l2 = l4;
        continue;
        l4 = parseTimeExpression((String)localObject3, paramFrameAndTickRate);
        l2 = l1;
        l1 = l4;
        continue;
        l4 = parseTimeExpression((String)localObject3, paramFrameAndTickRate);
        l3 = l1;
        l1 = l2;
        l2 = l3;
        l3 = l4;
        continue;
        localObject3 = parseStyleIds((String)localObject3);
        if (localObject3.length <= 0) {
          break label164;
        }
        localObject2 = localObject3;
        l4 = l1;
        l1 = l2;
        l2 = l4;
        continue;
        if (!paramMap.containsKey(localObject3)) {
          break label164;
        }
        localObject1 = localObject3;
        l4 = l1;
        l1 = l2;
        l2 = l4;
      }
    }
    long l5 = l1;
    if (paramTtmlNode != null)
    {
      l5 = l1;
      if (paramTtmlNode.startTimeUs != -9223372036854775807L)
      {
        l4 = l1;
        if (l1 != -9223372036854775807L) {
          l4 = l1 + paramTtmlNode.startTimeUs;
        }
        l5 = l4;
        if (l2 != -9223372036854775807L) {
          l1 = paramTtmlNode.startTimeUs;
        }
      }
    }
    for (l1 = l2 + l1;; l1 = l2)
    {
      l2 = l1;
      if (l1 == -9223372036854775807L)
      {
        if (l3 == -9223372036854775807L) {
          break label528;
        }
        l2 = l4 + l3;
      }
      for (;;)
      {
        return TtmlNode.buildNode(paramXmlPullParser.getName(), l4, l2, localTtmlStyle, localObject2, (String)localObject1);
        label528:
        l2 = l1;
        if (paramTtmlNode != null)
        {
          l2 = l1;
          if (paramTtmlNode.endTimeUs != -9223372036854775807L) {
            l2 = paramTtmlNode.endTimeUs;
          }
        }
      }
      l4 = l5;
    }
  }
  
  private TtmlRegion parseRegionAttributes(XmlPullParser paramXmlPullParser)
  {
    int j = 1;
    String str1 = XmlPullParserUtil.getAttributeValue(paramXmlPullParser, "id");
    if (str1 == null) {
      return null;
    }
    String str2 = XmlPullParserUtil.getAttributeValue(paramXmlPullParser, "origin");
    Object localObject;
    if (str2 != null)
    {
      localObject = PERCENTAGE_COORDINATES.matcher(str2);
      if (!((Matcher)localObject).matches()) {}
    }
    for (;;)
    {
      float f1;
      float f4;
      int i;
      try
      {
        float f2 = Float.parseFloat(((Matcher)localObject).group(1)) / 100.0F;
        f1 = Float.parseFloat(((Matcher)localObject).group(2));
        f1 /= 100.0F;
        localObject = XmlPullParserUtil.getAttributeValue(paramXmlPullParser, "extent");
        if (localObject == null) {
          break label369;
        }
        localObject = PERCENTAGE_COORDINATES.matcher((CharSequence)localObject);
        if (!((Matcher)localObject).matches()) {
          break label340;
        }
        float f3;
        Log.w("TtmlDecoder", "Ignoring region with unsupported origin: " + str2);
      }
      catch (NumberFormatException paramXmlPullParser)
      {
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
          }
          switch (paramXmlPullParser.hashCode())
          {
          default: 
            switch (i)
            {
            default: 
              i = 0;
              return new TtmlRegion(str1, f2, f1, 0, i, f3);
            }
            break;
          }
        }
        catch (NumberFormatException paramXmlPullParser)
        {
          Log.w("TtmlDecoder", "Ignoring region with malformed extent: " + str2);
          return null;
        }
        paramXmlPullParser = paramXmlPullParser;
        Log.w("TtmlDecoder", "Ignoring region with malformed origin: " + str2);
        return null;
      }
      return null;
      Log.w("TtmlDecoder", "Ignoring region without an origin");
      return null;
      label340:
      Log.w("TtmlDecoder", "Ignoring region with unsupported extent: " + str2);
      return null;
      label369:
      Log.w("TtmlDecoder", "Ignoring region without an extent");
      return null;
      if (paramXmlPullParser.equals("center"))
      {
        i = 0;
        continue;
        if (paramXmlPullParser.equals("after"))
        {
          i = 1;
          continue;
          f1 += f4 / 2.0F;
          i = j;
          continue;
          f1 += f4;
          i = 2;
        }
      }
    }
  }
  
  private TtmlStyle parseStyleAttributes(XmlPullParser paramXmlPullParser, TtmlStyle paramTtmlStyle)
  {
    int k = paramXmlPullParser.getAttributeCount();
    int j = 0;
    TtmlStyle localTtmlStyle1 = paramTtmlStyle;
    if (j < k)
    {
      String str = paramXmlPullParser.getAttributeValue(j);
      paramTtmlStyle = paramXmlPullParser.getAttributeName(j);
      label128:
      int i;
      switch (paramTtmlStyle.hashCode())
      {
      default: 
        i = -1;
        switch (i)
        {
        default: 
          label130:
          paramTtmlStyle = localTtmlStyle1;
        }
        break;
      }
      for (;;)
      {
        j += 1;
        localTtmlStyle1 = paramTtmlStyle;
        break;
        if (!paramTtmlStyle.equals("id")) {
          break label128;
        }
        i = 0;
        break label130;
        if (!paramTtmlStyle.equals("backgroundColor")) {
          break label128;
        }
        i = 1;
        break label130;
        if (!paramTtmlStyle.equals("color")) {
          break label128;
        }
        i = 2;
        break label130;
        if (!paramTtmlStyle.equals("fontFamily")) {
          break label128;
        }
        i = 3;
        break label130;
        if (!paramTtmlStyle.equals("fontSize")) {
          break label128;
        }
        i = 4;
        break label130;
        if (!paramTtmlStyle.equals("fontWeight")) {
          break label128;
        }
        i = 5;
        break label130;
        if (!paramTtmlStyle.equals("fontStyle")) {
          break label128;
        }
        i = 6;
        break label130;
        if (!paramTtmlStyle.equals("textAlign")) {
          break label128;
        }
        i = 7;
        break label130;
        if (!paramTtmlStyle.equals("textDecoration")) {
          break label128;
        }
        i = 8;
        break label130;
        paramTtmlStyle = localTtmlStyle1;
        if ("style".equals(paramXmlPullParser.getName()))
        {
          paramTtmlStyle = createIfNull(localTtmlStyle1).setId(str);
          continue;
          paramTtmlStyle = createIfNull(localTtmlStyle1);
          try
          {
            paramTtmlStyle.setBackgroundColor(ColorParser.parseTtmlColor(str));
          }
          catch (IllegalArgumentException localIllegalArgumentException1)
          {
            Log.w("TtmlDecoder", "Failed parsing background value: " + str);
          }
          continue;
          paramTtmlStyle = createIfNull(localIllegalArgumentException1);
          try
          {
            paramTtmlStyle.setFontColor(ColorParser.parseTtmlColor(str));
          }
          catch (IllegalArgumentException localIllegalArgumentException2)
          {
            Log.w("TtmlDecoder", "Failed parsing color value: " + str);
          }
          continue;
          paramTtmlStyle = createIfNull(localIllegalArgumentException2).setFontFamily(str);
          continue;
          paramTtmlStyle = localIllegalArgumentException2;
          try
          {
            TtmlStyle localTtmlStyle2 = createIfNull(localIllegalArgumentException2);
            paramTtmlStyle = localTtmlStyle2;
            parseFontSize(str, localTtmlStyle2);
            paramTtmlStyle = localTtmlStyle2;
          }
          catch (SubtitleDecoderException localSubtitleDecoderException)
          {
            Log.w("TtmlDecoder", "Failed parsing fontSize value: " + str);
          }
          continue;
          paramTtmlStyle = createIfNull(localSubtitleDecoderException).setBold("bold".equalsIgnoreCase(str));
          continue;
          paramTtmlStyle = createIfNull(localSubtitleDecoderException).setItalic("italic".equalsIgnoreCase(str));
          continue;
          paramTtmlStyle = Util.toLowerInvariant(str);
          switch (paramTtmlStyle.hashCode())
          {
          default: 
            label644:
            i = -1;
          }
          for (;;)
          {
            switch (i)
            {
            default: 
              paramTtmlStyle = localSubtitleDecoderException;
              break;
            case 0: 
              paramTtmlStyle = createIfNull(localSubtitleDecoderException).setTextAlign(Layout.Alignment.ALIGN_NORMAL);
              break;
              if (!paramTtmlStyle.equals("left")) {
                break label644;
              }
              i = 0;
              continue;
              if (!paramTtmlStyle.equals("start")) {
                break label644;
              }
              i = 1;
              continue;
              if (!paramTtmlStyle.equals("right")) {
                break label644;
              }
              i = 2;
              continue;
              if (!paramTtmlStyle.equals("end")) {
                break label644;
              }
              i = 3;
              continue;
              if (!paramTtmlStyle.equals("center")) {
                break label644;
              }
              i = 4;
            }
          }
          paramTtmlStyle = createIfNull(localSubtitleDecoderException).setTextAlign(Layout.Alignment.ALIGN_NORMAL);
          continue;
          paramTtmlStyle = createIfNull(localSubtitleDecoderException).setTextAlign(Layout.Alignment.ALIGN_OPPOSITE);
          continue;
          paramTtmlStyle = createIfNull(localSubtitleDecoderException).setTextAlign(Layout.Alignment.ALIGN_OPPOSITE);
          continue;
          paramTtmlStyle = createIfNull(localSubtitleDecoderException).setTextAlign(Layout.Alignment.ALIGN_CENTER);
          continue;
          paramTtmlStyle = Util.toLowerInvariant(str);
          switch (paramTtmlStyle.hashCode())
          {
          default: 
            label892:
            i = -1;
          }
          for (;;)
          {
            switch (i)
            {
            default: 
              paramTtmlStyle = localSubtitleDecoderException;
              break;
            case 0: 
              paramTtmlStyle = createIfNull(localSubtitleDecoderException).setLinethrough(true);
              break;
              if (!paramTtmlStyle.equals("linethrough")) {
                break label892;
              }
              i = 0;
              continue;
              if (!paramTtmlStyle.equals("nolinethrough")) {
                break label892;
              }
              i = 1;
              continue;
              if (!paramTtmlStyle.equals("underline")) {
                break label892;
              }
              i = 2;
              continue;
              if (!paramTtmlStyle.equals("nounderline")) {
                break label892;
              }
              i = 3;
            }
          }
          paramTtmlStyle = createIfNull(localSubtitleDecoderException).setLinethrough(false);
          continue;
          paramTtmlStyle = createIfNull(localSubtitleDecoderException).setUnderline(true);
          continue;
          paramTtmlStyle = createIfNull(localSubtitleDecoderException).setUnderline(false);
        }
      }
    }
    return localSubtitleDecoderException;
  }
  
  private String[] parseStyleIds(String paramString)
  {
    return paramString.split("\\s+");
  }
  
  private static long parseTimeExpression(String paramString, TtmlDecoder.FrameAndTickRate paramFrameAndTickRate)
  {
    double d3 = 0.0D;
    Matcher localMatcher = CLOCK_TIME.matcher(paramString);
    double d1;
    double d2;
    if (localMatcher.matches())
    {
      double d4 = Long.parseLong(localMatcher.group(1)) * 3600L;
      double d5 = Long.parseLong(localMatcher.group(2)) * 60L;
      double d6 = Long.parseLong(localMatcher.group(3));
      paramString = localMatcher.group(4);
      if (paramString != null)
      {
        d1 = Double.parseDouble(paramString);
        paramString = localMatcher.group(5);
        if (paramString == null) {
          break label162;
        }
      }
      label162:
      for (d2 = (float)Long.parseLong(paramString) / paramFrameAndTickRate.effectiveFrameRate;; d2 = 0.0D)
      {
        paramString = localMatcher.group(6);
        if (paramString != null) {
          d3 = Long.parseLong(paramString) / paramFrameAndTickRate.subFrameRate / paramFrameAndTickRate.effectiveFrameRate;
        }
        return ((d2 + (d6 + (d4 + d5) + d1) + d3) * 1000000.0D);
        d1 = 0.0D;
        break;
      }
    }
    localMatcher = OFFSET_TIME.matcher(paramString);
    if (localMatcher.matches())
    {
      d2 = Double.parseDouble(localMatcher.group(1));
      paramString = localMatcher.group(2);
      int i = -1;
      switch (paramString.hashCode())
      {
      default: 
        d1 = d2;
        switch (i)
        {
        default: 
          d1 = d2;
        }
        break;
      }
      for (;;)
      {
        return (d1 * 1000000.0D);
        if (!paramString.equals("h")) {
          break;
        }
        i = 0;
        break;
        if (!paramString.equals("m")) {
          break;
        }
        i = 1;
        break;
        if (!paramString.equals("s")) {
          break;
        }
        i = 2;
        break;
        if (!paramString.equals("ms")) {
          break;
        }
        i = 3;
        break;
        if (!paramString.equals("f")) {
          break;
        }
        i = 4;
        break;
        if (!paramString.equals("t")) {
          break;
        }
        i = 5;
        break;
        d1 = d2 * 3600.0D;
        continue;
        d1 = d2 * 60.0D;
        continue;
        d1 = d2 / 1000.0D;
        continue;
        d1 = d2 / paramFrameAndTickRate.effectiveFrameRate;
        continue;
        d1 = d2 / paramFrameAndTickRate.tickRate;
      }
    }
    throw new SubtitleDecoderException("Malformed time expression: " + paramString);
  }
  
  protected TtmlSubtitle decode(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        XmlPullParser localXmlPullParser = this.xmlParserFactory.newPullParser();
        HashMap localHashMap1 = new HashMap();
        HashMap localHashMap2 = new HashMap();
        localHashMap2.put("", new TtmlRegion(null));
        localXmlPullParser.setInput(new ByteArrayInputStream(paramArrayOfByte, 0, paramInt), null);
        paramArrayOfByte = null;
        LinkedList localLinkedList = new LinkedList();
        paramInt = 0;
        int j = localXmlPullParser.getEventType();
        localObject1 = DEFAULT_FRAME_AND_TICK_RATE;
        if (j != 1)
        {
          Object localObject2 = (TtmlNode)localLinkedList.peekLast();
          if (paramInt == 0)
          {
            localObject4 = localXmlPullParser.getName();
            if (j == 2)
            {
              if ("tt".equals(localObject4)) {
                localObject1 = parseFrameAndTickRates(localXmlPullParser);
              }
              if (!isSupportedTag((String)localObject4))
              {
                Log.i("TtmlDecoder", "Ignoring unsupported tag: " + localXmlPullParser.getName());
                localObject2 = paramArrayOfByte;
                paramArrayOfByte = (byte[])localObject1;
                paramInt += 1;
                localObject1 = localObject2;
                break label528;
                localXmlPullParser.next();
                j = localXmlPullParser.getEventType();
                localObject1 = localObject2;
                paramInt = i;
                paramArrayOfByte = (byte[])localObject4;
                continue;
              }
              if ("head".equals(localObject4))
              {
                parseHeader(localXmlPullParser, localHashMap1, localHashMap2);
                localObject2 = paramArrayOfByte;
                paramArrayOfByte = (byte[])localObject1;
                localObject1 = localObject2;
                break label528;
              }
              try
              {
                localObject4 = parseNode(localXmlPullParser, (TtmlNode)localObject2, localHashMap2, (TtmlDecoder.FrameAndTickRate)localObject1);
                localLinkedList.addLast(localObject4);
                if (localObject2 != null) {
                  ((TtmlNode)localObject2).addChild((TtmlNode)localObject4);
                }
                localObject2 = paramArrayOfByte;
                paramArrayOfByte = (byte[])localObject1;
                localObject1 = localObject2;
              }
              catch (SubtitleDecoderException localSubtitleDecoderException)
              {
                Log.w("TtmlDecoder", "Suppressing parser error", localSubtitleDecoderException);
                localObject3 = paramArrayOfByte;
                paramArrayOfByte = (byte[])localObject1;
                paramInt += 1;
                localObject1 = localObject3;
              }
            }
            if (j == 4)
            {
              ((TtmlNode)localObject3).addChild(TtmlNode.buildTextNode(localXmlPullParser.getText()));
              localObject3 = paramArrayOfByte;
              paramArrayOfByte = (byte[])localObject1;
              localObject1 = localObject3;
              break label528;
            }
            if (j != 3) {
              break label518;
            }
            if (localXmlPullParser.getName().equals("tt"))
            {
              paramArrayOfByte = new TtmlSubtitle((TtmlNode)localLinkedList.getLast(), localHashMap1, localHashMap2);
              localLinkedList.removeLast();
              localObject3 = paramArrayOfByte;
              paramArrayOfByte = (byte[])localObject1;
              localObject1 = localObject3;
              break label528;
            }
          }
          else
          {
            if (j == 2)
            {
              i = paramInt + 1;
              localObject3 = localObject1;
              localObject4 = paramArrayOfByte;
              continue;
            }
            localObject3 = localObject1;
            i = paramInt;
            localObject4 = paramArrayOfByte;
            if (j != 3) {
              continue;
            }
            i = paramInt - 1;
            localObject3 = localObject1;
            localObject4 = paramArrayOfByte;
            continue;
          }
        }
        else
        {
          return paramArrayOfByte;
        }
      }
      catch (XmlPullParserException paramArrayOfByte)
      {
        throw new SubtitleDecoderException("Unable to decode source", paramArrayOfByte);
      }
      catch (IOException paramArrayOfByte)
      {
        throw new IllegalStateException("Unexpected error when reading input.", paramArrayOfByte);
      }
      continue;
      label518:
      Object localObject3 = localObject1;
      Object localObject1 = paramArrayOfByte;
      paramArrayOfByte = (byte[])localObject3;
      label528:
      localObject3 = paramArrayOfByte;
      int i = paramInt;
      Object localObject4 = localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.text.ttml.TtmlDecoder
 * JD-Core Version:    0.7.0.1
 */