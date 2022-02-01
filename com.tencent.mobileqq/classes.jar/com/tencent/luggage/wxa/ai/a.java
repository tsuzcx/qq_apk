package com.tencent.luggage.wxa.ai;

import android.text.Layout.Alignment;
import android.util.Log;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.ao.y;
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

public final class a
  extends com.tencent.luggage.wxa.ad.b
{
  private static final Pattern a = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
  private static final Pattern b = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
  private static final Pattern c = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
  private static final Pattern d = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
  private static final a.a e = new a.a(30.0F, 1, 1);
  private final XmlPullParserFactory f;
  
  public a()
  {
    super("TtmlDecoder");
    try
    {
      this.f = XmlPullParserFactory.newInstance();
      this.f.setNamespaceAware(true);
      return;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      throw new RuntimeException("Couldn't create XmlPullParserFactory instance", localXmlPullParserException);
    }
  }
  
  private static long a(String paramString, a.a parama)
  {
    Matcher localMatcher = a.matcher(paramString);
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
        d2 = (float)Long.parseLong(paramString) / parama.a;
      } else {
        d2 = 0.0D;
      }
      paramString = localMatcher.group(6);
      if (paramString != null)
      {
        d3 = Long.parseLong(paramString);
        double d7 = parama.b;
        Double.isNaN(d3);
        Double.isNaN(d7);
        d3 /= d7;
        d7 = parama.a;
        Double.isNaN(d7);
        d3 /= d7;
      }
      return ((d4 + d5 + d6 + d1 + d2 + d3) * 1000000.0D);
    }
    localMatcher = b.matcher(paramString);
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
                  break label400;
                }
              }
              else if (paramString.equals("s"))
              {
                i = 2;
                break label400;
              }
            }
            else if (paramString.equals("ms"))
            {
              i = 3;
              break label400;
            }
          }
          else if (paramString.equals("m"))
          {
            i = 1;
            break label400;
          }
        }
        else if (paramString.equals("h"))
        {
          i = 0;
          break label400;
        }
      }
      else if (paramString.equals("f"))
      {
        i = 4;
        break label400;
      }
      i = -1;
      label400:
      if (i != 0)
      {
        if (i != 1)
        {
          d1 = d2;
          if (i == 2) {
            break label500;
          }
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5)
              {
                d1 = d2;
                break label500;
              }
              d1 = parama.c;
              Double.isNaN(d1);
            }
            else
            {
              d1 = parama.a;
              Double.isNaN(d1);
            }
          }
          else {
            d1 = 1000.0D;
          }
          d1 = d2 / d1;
          break label500;
        }
        d1 = 60.0D;
      }
      else
      {
        d1 = 3600.0D;
      }
      d1 = d2 * d1;
      label500:
      return (d1 * 1000000.0D);
    }
    parama = new StringBuilder();
    parama.append("Malformed time expression: ");
    parama.append(paramString);
    throw new com.tencent.luggage.wxa.ad.f(parama.toString());
  }
  
  private a.a a(XmlPullParser paramXmlPullParser)
  {
    Object localObject = paramXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
    int i;
    if (localObject != null) {
      i = Integer.parseInt((String)localObject);
    } else {
      i = 30;
    }
    float f1 = 1.0F;
    localObject = paramXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
    if (localObject != null)
    {
      localObject = ((String)localObject).split(" ");
      if (localObject.length == 2) {
        f1 = Integer.parseInt(localObject[0]) / Integer.parseInt(localObject[1]);
      } else {
        throw new com.tencent.luggage.wxa.ad.f("frameRateMultiplier doesn't have 2 parts");
      }
    }
    int j = e.b;
    localObject = paramXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
    if (localObject != null) {
      j = Integer.parseInt((String)localObject);
    }
    int k = e.c;
    paramXmlPullParser = paramXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
    if (paramXmlPullParser != null) {
      k = Integer.parseInt(paramXmlPullParser);
    }
    return new a.a(i * f1, j, k);
  }
  
  private b a(XmlPullParser paramXmlPullParser, b paramb, Map<String, c> paramMap, a.a parama)
  {
    int k = paramXmlPullParser.getAttributeCount();
    e locale = a(paramXmlPullParser, null);
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
              localObject5 = a((String)localObject5);
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
            l6 = a((String)localObject5, parama);
            l3 = l1;
            l4 = l2;
            localObject3 = localObject2;
            localObject4 = localObject1;
          }
        }
        else
        {
          l4 = a((String)localObject5, parama);
          l3 = l1;
          l6 = l5;
          localObject3 = localObject2;
          localObject4 = localObject1;
        }
      }
      else
      {
        l3 = a((String)localObject5, parama);
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
    if (paramb != null)
    {
      l6 = l1;
      l4 = l2;
      if (paramb.d != -9223372036854775807L)
      {
        l3 = l1;
        if (l1 != -9223372036854775807L) {
          l3 = l1 + paramb.d;
        }
        l6 = l3;
        l4 = l2;
        if (l2 != -9223372036854775807L)
        {
          l4 = l2 + paramb.d;
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
      if ((paramb != null) && (paramb.e != -9223372036854775807L))
      {
        l1 = paramb.e;
        break label625;
      }
    }
    l1 = l4;
    label625:
    return b.a(paramXmlPullParser.getName(), l6, l1, locale, localObject1, (String)localObject2);
  }
  
  private e a(e parame)
  {
    e locale = parame;
    if (parame == null) {
      locale = new e();
    }
    return locale;
  }
  
  private e a(XmlPullParser paramXmlPullParser, e parame)
  {
    int m = paramXmlPullParser.getAttributeCount();
    int j = 0;
    for (Object localObject = parame; j < m; localObject = parame)
    {
      String str = paramXmlPullParser.getAttributeValue(j);
      parame = paramXmlPullParser.getAttributeName(j);
      int i = parame.hashCode();
      int k = -1;
      switch (i)
      {
      default: 
        break;
      case 1287124693: 
        if (parame.equals("backgroundColor")) {
          i = 1;
        }
        break;
      case 365601008: 
        if (parame.equals("fontSize")) {
          i = 4;
        }
        break;
      case 94842723: 
        if (parame.equals("color")) {
          i = 2;
        }
        break;
      case 3355: 
        if (parame.equals("id")) {
          i = 0;
        }
        break;
      case -734428249: 
        if (parame.equals("fontWeight")) {
          i = 5;
        }
        break;
      case -879295043: 
        if (parame.equals("textDecoration")) {
          i = 8;
        }
        break;
      case -1065511464: 
        if (parame.equals("textAlign")) {
          i = 7;
        }
        break;
      case -1224696685: 
        if (parame.equals("fontFamily")) {
          i = 3;
        }
        break;
      case -1550943582: 
        if (parame.equals("fontStyle")) {
          i = 6;
        }
        break;
      }
      i = -1;
      switch (i)
      {
      default: 
        parame = (e)localObject;
        break;
      case 8: 
        parame = x.d(str);
        switch (parame.hashCode())
        {
        default: 
          i = k;
          break;
        case 1679736913: 
          i = k;
          if (parame.equals("linethrough")) {
            i = 0;
          }
          break;
        case 913457136: 
          i = k;
          if (parame.equals("nolinethrough")) {
            i = 1;
          }
          break;
        case -1026963764: 
          i = k;
          if (parame.equals("underline")) {
            i = 2;
          }
          break;
        case -1461280213: 
          i = k;
          if (parame.equals("nounderline")) {
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
                parame = (e)localObject;
              } else {
                parame = a((e)localObject).b(false);
              }
            }
            else {
              parame = a((e)localObject).b(true);
            }
          }
          else {
            parame = a((e)localObject).a(false);
          }
        }
        else {
          parame = a((e)localObject).a(true);
        }
        break;
      case 7: 
        parame = x.d(str);
        switch (parame.hashCode())
        {
        default: 
          i = k;
          break;
        case 109757538: 
          i = k;
          if (parame.equals("start")) {
            i = 1;
          }
          break;
        case 108511772: 
          i = k;
          if (parame.equals("right")) {
            i = 2;
          }
          break;
        case 3317767: 
          i = k;
          if (parame.equals("left")) {
            i = 0;
          }
          break;
        case 100571: 
          i = k;
          if (parame.equals("end")) {
            i = 3;
          }
          break;
        case -1364013995: 
          i = k;
          if (parame.equals("center")) {
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
                  parame = (e)localObject;
                } else {
                  parame = a((e)localObject).a(Layout.Alignment.ALIGN_CENTER);
                }
              }
              else {
                parame = a((e)localObject).a(Layout.Alignment.ALIGN_OPPOSITE);
              }
            }
            else {
              parame = a((e)localObject).a(Layout.Alignment.ALIGN_OPPOSITE);
            }
          }
          else {
            parame = a((e)localObject).a(Layout.Alignment.ALIGN_NORMAL);
          }
        }
        else {
          parame = a((e)localObject).a(Layout.Alignment.ALIGN_NORMAL);
        }
        break;
      case 6: 
        parame = a((e)localObject).d("italic".equalsIgnoreCase(str));
        break;
      case 5: 
        parame = a((e)localObject).c("bold".equalsIgnoreCase(str));
        break;
      case 4: 
        parame = (e)localObject;
      }
      try
      {
        localObject = a((e)localObject);
        parame = (e)localObject;
        a(str, (e)localObject);
        parame = (e)localObject;
      }
      catch (com.tencent.luggage.wxa.ad.f localf)
      {
        label871:
        break label871;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed parsing fontSize value: ");
      ((StringBuilder)localObject).append(str);
      Log.w("TtmlDecoder", ((StringBuilder)localObject).toString());
      break label1075;
      parame = a((e)localObject).a(str);
      break label1075;
      parame = a((e)localObject);
      try
      {
        parame.a(com.tencent.luggage.wxa.ao.e.a(str));
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        label946:
        break label946;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed parsing color value: ");
      ((StringBuilder)localObject).append(str);
      Log.w("TtmlDecoder", ((StringBuilder)localObject).toString());
      break label1075;
      parame = a((e)localObject);
      label1075:
      try
      {
        parame.b(com.tencent.luggage.wxa.ao.e.a(str));
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        label1006:
        break label1006;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed parsing background value: ");
      ((StringBuilder)localObject).append(str);
      Log.w("TtmlDecoder", ((StringBuilder)localObject).toString());
      break label1075;
      parame = (e)localObject;
      if ("style".equals(paramXmlPullParser.getName())) {
        parame = a((e)localObject).b(str);
      }
      j += 1;
    }
    return localObject;
  }
  
  private Map<String, e> a(XmlPullParser paramXmlPullParser, Map<String, e> paramMap, Map<String, c> paramMap1)
  {
    do
    {
      paramXmlPullParser.next();
      Object localObject1;
      if (y.b(paramXmlPullParser, "style"))
      {
        Object localObject2 = y.c(paramXmlPullParser, "style");
        localObject1 = a(paramXmlPullParser, new e());
        if (localObject2 != null)
        {
          localObject2 = a((String)localObject2);
          int j = localObject2.length;
          int i = 0;
          while (i < j)
          {
            ((e)localObject1).a((e)paramMap.get(localObject2[i]));
            i += 1;
          }
        }
        if (((e)localObject1).i() != null) {
          paramMap.put(((e)localObject1).i(), localObject1);
        }
      }
      else if (y.b(paramXmlPullParser, "region"))
      {
        localObject1 = b(paramXmlPullParser);
        if (localObject1 != null) {
          paramMap1.put(((c)localObject1).a, localObject1);
        }
      }
    } while (!y.a(paramXmlPullParser, "head"));
    return paramMap;
  }
  
  private static void a(String paramString, e parame)
  {
    Object localObject = paramString.split("\\s+");
    if (localObject.length == 1)
    {
      localObject = c.matcher(paramString);
    }
    else
    {
      if (localObject.length != 2) {
        break label283;
      }
      localObject = c.matcher(localObject[1]);
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
            parame.c(3);
          }
          else
          {
            parame = new StringBuilder();
            parame.append("Invalid unit for fontSize: '");
            parame.append(paramString);
            parame.append("'.");
            throw new com.tencent.luggage.wxa.ad.f(parame.toString());
          }
        }
        else {
          parame.c(2);
        }
      }
      else {
        parame.c(1);
      }
      parame.a(Float.valueOf(((Matcher)localObject).group(1)).floatValue());
      return;
    }
    parame = new StringBuilder();
    parame.append("Invalid expression for fontSize: '");
    parame.append(paramString);
    parame.append("'.");
    throw new com.tencent.luggage.wxa.ad.f(parame.toString());
    label283:
    paramString = new StringBuilder();
    paramString.append("Invalid number of entries for fontSize: ");
    paramString.append(localObject.length);
    paramString.append(".");
    throw new com.tencent.luggage.wxa.ad.f(paramString.toString());
  }
  
  private String[] a(String paramString)
  {
    return paramString.split("\\s+");
  }
  
  private c b(XmlPullParser paramXmlPullParser)
  {
    String str2 = y.c(paramXmlPullParser, "id");
    if (str2 == null) {
      return null;
    }
    String str1 = y.c(paramXmlPullParser, "origin");
    Object localObject;
    if (str1 != null)
    {
      localObject = d.matcher(str1);
      if (!((Matcher)localObject).matches()) {}
    }
    try
    {
      f2 = Float.parseFloat(((Matcher)localObject).group(1)) / 100.0F;
      j = 2;
      f1 = Float.parseFloat(((Matcher)localObject).group(2));
      f1 /= 100.0F;
      localObject = y.c(paramXmlPullParser, "extent");
      if (localObject != null)
      {
        localObject = d.matcher((CharSequence)localObject);
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
      paramXmlPullParser = y.c(paramXmlPullParser, "displayAlign");
      if (paramXmlPullParser != null)
      {
        paramXmlPullParser = x.d(paramXmlPullParser);
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
      return new c(str2, f2, f1, 0, i, f3);
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
  
  private static boolean b(String paramString)
  {
    return (paramString.equals("tt")) || (paramString.equals("head")) || (paramString.equals("body")) || (paramString.equals("div")) || (paramString.equals("p")) || (paramString.equals("span")) || (paramString.equals("br")) || (paramString.equals("style")) || (paramString.equals("styling")) || (paramString.equals("layout")) || (paramString.equals("region")) || (paramString.equals("metadata")) || (paramString.equals("smpte:image")) || (paramString.equals("smpte:data")) || (paramString.equals("smpte:information"));
  }
  
  protected f b(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        localXmlPullParser = this.f.newPullParser();
        HashMap localHashMap1 = new HashMap();
        HashMap localHashMap2 = new HashMap();
        localObject1 = null;
        localHashMap2.put("", new c(null));
        i = 0;
        localXmlPullParser.setInput(new ByteArrayInputStream(paramArrayOfByte, 0, paramInt), null);
        LinkedList localLinkedList = new LinkedList();
        j = localXmlPullParser.getEventType();
        paramArrayOfByte = e;
        if (j == 1) {
          continue;
        }
        b localb1 = (b)localLinkedList.peekLast();
        if (i != 0) {
          continue;
        }
        Object localObject2 = localXmlPullParser.getName();
        if (j == 2)
        {
          if ("tt".equals(localObject2)) {
            paramArrayOfByte = a(localXmlPullParser);
          }
          paramBoolean = b((String)localObject2);
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
            a(localXmlPullParser, localHashMap1, localHashMap2);
            localObject2 = paramArrayOfByte;
            paramInt = i;
            localObject3 = localObject1;
          }
          else
          {
            try
            {
              b localb2 = a(localXmlPullParser, localb1, localHashMap2, paramArrayOfByte);
              localLinkedList.addLast(localb2);
              localObject2 = paramArrayOfByte;
              paramInt = i;
              localObject3 = localObject1;
              if (localb1 == null) {
                continue;
              }
              localb1.a(localb2);
              localObject2 = paramArrayOfByte;
              paramInt = i;
              localObject3 = localObject1;
            }
            catch (com.tencent.luggage.wxa.ad.f localf)
            {
              Log.w("TtmlDecoder", "Suppressing parser error", localf);
              continue;
            }
          }
        }
        else if (j == 4)
        {
          localb1.a(b.a(localXmlPullParser.getText()));
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
              localObject1 = new f((b)localLinkedList.getLast(), localHashMap1, localHashMap2);
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
        paramArrayOfByte = new com.tencent.luggage.wxa.ad.f("Unable to decode source", paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ai.a
 * JD-Core Version:    0.7.0.1
 */