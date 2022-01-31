package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ColorParser
{
  private static final Map<String, Integer> COLOR_MAP;
  private static final String RGB = "rgb";
  private static final String RGBA = "rgba";
  private static final Pattern RGBA_PATTERN_FLOAT_ALPHA;
  private static final Pattern RGBA_PATTERN_INT_ALPHA;
  private static final Pattern RGB_PATTERN = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
  
  static
  {
    RGBA_PATTERN_INT_ALPHA = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    RGBA_PATTERN_FLOAT_ALPHA = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    COLOR_MAP = new HashMap();
    COLOR_MAP.put("aliceblue", Integer.valueOf(-984833));
    COLOR_MAP.put("antiquewhite", Integer.valueOf(-332841));
    COLOR_MAP.put("aqua", Integer.valueOf(-16711681));
    COLOR_MAP.put("aquamarine", Integer.valueOf(-8388652));
    COLOR_MAP.put("azure", Integer.valueOf(-983041));
    COLOR_MAP.put("beige", Integer.valueOf(-657956));
    COLOR_MAP.put("bisque", Integer.valueOf(-6972));
    COLOR_MAP.put("black", Integer.valueOf(-16777216));
    COLOR_MAP.put("blanchedalmond", Integer.valueOf(-5171));
    COLOR_MAP.put("blue", Integer.valueOf(-16776961));
    COLOR_MAP.put("blueviolet", Integer.valueOf(-7722014));
    COLOR_MAP.put("brown", Integer.valueOf(-5952982));
    COLOR_MAP.put("burlywood", Integer.valueOf(-2180985));
    COLOR_MAP.put("cadetblue", Integer.valueOf(-10510688));
    COLOR_MAP.put("chartreuse", Integer.valueOf(-8388864));
    COLOR_MAP.put("chocolate", Integer.valueOf(-2987746));
    COLOR_MAP.put("coral", Integer.valueOf(-32944));
    COLOR_MAP.put("cornflowerblue", Integer.valueOf(-10185235));
    COLOR_MAP.put("cornsilk", Integer.valueOf(-1828));
    COLOR_MAP.put("crimson", Integer.valueOf(-2354116));
    COLOR_MAP.put("cyan", Integer.valueOf(-16711681));
    COLOR_MAP.put("darkblue", Integer.valueOf(-16777077));
    COLOR_MAP.put("darkcyan", Integer.valueOf(-16741493));
    COLOR_MAP.put("darkgoldenrod", Integer.valueOf(-4684277));
    COLOR_MAP.put("darkgray", Integer.valueOf(-5658199));
    COLOR_MAP.put("darkgreen", Integer.valueOf(-16751616));
    COLOR_MAP.put("darkgrey", Integer.valueOf(-5658199));
    COLOR_MAP.put("darkkhaki", Integer.valueOf(-4343957));
    COLOR_MAP.put("darkmagenta", Integer.valueOf(-7667573));
    COLOR_MAP.put("darkolivegreen", Integer.valueOf(-11179217));
    COLOR_MAP.put("darkorange", Integer.valueOf(-29696));
    COLOR_MAP.put("darkorchid", Integer.valueOf(-6737204));
    COLOR_MAP.put("darkred", Integer.valueOf(-7667712));
    COLOR_MAP.put("darksalmon", Integer.valueOf(-1468806));
    COLOR_MAP.put("darkseagreen", Integer.valueOf(-7357297));
    COLOR_MAP.put("darkslateblue", Integer.valueOf(-12042869));
    COLOR_MAP.put("darkslategray", Integer.valueOf(-13676721));
    COLOR_MAP.put("darkslategrey", Integer.valueOf(-13676721));
    COLOR_MAP.put("darkturquoise", Integer.valueOf(-16724271));
    COLOR_MAP.put("darkviolet", Integer.valueOf(-7077677));
    COLOR_MAP.put("deeppink", Integer.valueOf(-60269));
    COLOR_MAP.put("deepskyblue", Integer.valueOf(-16728065));
    COLOR_MAP.put("dimgray", Integer.valueOf(-9868951));
    COLOR_MAP.put("dimgrey", Integer.valueOf(-9868951));
    COLOR_MAP.put("dodgerblue", Integer.valueOf(-14774017));
    COLOR_MAP.put("firebrick", Integer.valueOf(-5103070));
    COLOR_MAP.put("floralwhite", Integer.valueOf(-1296));
    COLOR_MAP.put("forestgreen", Integer.valueOf(-14513374));
    COLOR_MAP.put("fuchsia", Integer.valueOf(-65281));
    COLOR_MAP.put("gainsboro", Integer.valueOf(-2302756));
    COLOR_MAP.put("ghostwhite", Integer.valueOf(-460545));
    COLOR_MAP.put("gold", Integer.valueOf(-10496));
    COLOR_MAP.put("goldenrod", Integer.valueOf(-2448096));
    COLOR_MAP.put("gray", Integer.valueOf(-8355712));
    COLOR_MAP.put("green", Integer.valueOf(-16744448));
    COLOR_MAP.put("greenyellow", Integer.valueOf(-5374161));
    COLOR_MAP.put("grey", Integer.valueOf(-8355712));
    COLOR_MAP.put("honeydew", Integer.valueOf(-983056));
    COLOR_MAP.put("hotpink", Integer.valueOf(-38476));
    COLOR_MAP.put("indianred", Integer.valueOf(-3318692));
    COLOR_MAP.put("indigo", Integer.valueOf(-11861886));
    COLOR_MAP.put("ivory", Integer.valueOf(-16));
    COLOR_MAP.put("khaki", Integer.valueOf(-989556));
    COLOR_MAP.put("lavender", Integer.valueOf(-1644806));
    COLOR_MAP.put("lavenderblush", Integer.valueOf(-3851));
    COLOR_MAP.put("lawngreen", Integer.valueOf(-8586240));
    COLOR_MAP.put("lemonchiffon", Integer.valueOf(-1331));
    COLOR_MAP.put("lightblue", Integer.valueOf(-5383962));
    COLOR_MAP.put("lightcoral", Integer.valueOf(-1015680));
    COLOR_MAP.put("lightcyan", Integer.valueOf(-2031617));
    COLOR_MAP.put("lightgoldenrodyellow", Integer.valueOf(-329006));
    COLOR_MAP.put("lightgray", Integer.valueOf(-2894893));
    COLOR_MAP.put("lightgreen", Integer.valueOf(-7278960));
    COLOR_MAP.put("lightgrey", Integer.valueOf(-2894893));
    COLOR_MAP.put("lightpink", Integer.valueOf(-18751));
    COLOR_MAP.put("lightsalmon", Integer.valueOf(-24454));
    COLOR_MAP.put("lightseagreen", Integer.valueOf(-14634326));
    COLOR_MAP.put("lightskyblue", Integer.valueOf(-7876870));
    COLOR_MAP.put("lightslategray", Integer.valueOf(-8943463));
    COLOR_MAP.put("lightslategrey", Integer.valueOf(-8943463));
    COLOR_MAP.put("lightsteelblue", Integer.valueOf(-5192482));
    COLOR_MAP.put("lightyellow", Integer.valueOf(-32));
    COLOR_MAP.put("lime", Integer.valueOf(-16711936));
    COLOR_MAP.put("limegreen", Integer.valueOf(-13447886));
    COLOR_MAP.put("linen", Integer.valueOf(-331546));
    COLOR_MAP.put("magenta", Integer.valueOf(-65281));
    COLOR_MAP.put("maroon", Integer.valueOf(-8388608));
    COLOR_MAP.put("mediumaquamarine", Integer.valueOf(-10039894));
    COLOR_MAP.put("mediumblue", Integer.valueOf(-16777011));
    COLOR_MAP.put("mediumorchid", Integer.valueOf(-4565549));
    COLOR_MAP.put("mediumpurple", Integer.valueOf(-7114533));
    COLOR_MAP.put("mediumseagreen", Integer.valueOf(-12799119));
    COLOR_MAP.put("mediumslateblue", Integer.valueOf(-8689426));
    COLOR_MAP.put("mediumspringgreen", Integer.valueOf(-16713062));
    COLOR_MAP.put("mediumturquoise", Integer.valueOf(-12004916));
    COLOR_MAP.put("mediumvioletred", Integer.valueOf(-3730043));
    COLOR_MAP.put("midnightblue", Integer.valueOf(-15132304));
    COLOR_MAP.put("mintcream", Integer.valueOf(-655366));
    COLOR_MAP.put("mistyrose", Integer.valueOf(-6943));
    COLOR_MAP.put("moccasin", Integer.valueOf(-6987));
    COLOR_MAP.put("navajowhite", Integer.valueOf(-8531));
    COLOR_MAP.put("navy", Integer.valueOf(-16777088));
    COLOR_MAP.put("oldlace", Integer.valueOf(-133658));
    COLOR_MAP.put("olive", Integer.valueOf(-8355840));
    COLOR_MAP.put("olivedrab", Integer.valueOf(-9728477));
    COLOR_MAP.put("orange", Integer.valueOf(-23296));
    COLOR_MAP.put("orangered", Integer.valueOf(-47872));
    COLOR_MAP.put("orchid", Integer.valueOf(-2461482));
    COLOR_MAP.put("palegoldenrod", Integer.valueOf(-1120086));
    COLOR_MAP.put("palegreen", Integer.valueOf(-6751336));
    COLOR_MAP.put("paleturquoise", Integer.valueOf(-5247250));
    COLOR_MAP.put("palevioletred", Integer.valueOf(-2396013));
    COLOR_MAP.put("papayawhip", Integer.valueOf(-4139));
    COLOR_MAP.put("peachpuff", Integer.valueOf(-9543));
    COLOR_MAP.put("peru", Integer.valueOf(-3308225));
    COLOR_MAP.put("pink", Integer.valueOf(-16181));
    COLOR_MAP.put("plum", Integer.valueOf(-2252579));
    COLOR_MAP.put("powderblue", Integer.valueOf(-5185306));
    COLOR_MAP.put("purple", Integer.valueOf(-8388480));
    COLOR_MAP.put("rebeccapurple", Integer.valueOf(-10079335));
    COLOR_MAP.put("red", Integer.valueOf(-65536));
    COLOR_MAP.put("rosybrown", Integer.valueOf(-4419697));
    COLOR_MAP.put("royalblue", Integer.valueOf(-12490271));
    COLOR_MAP.put("saddlebrown", Integer.valueOf(-7650029));
    COLOR_MAP.put("salmon", Integer.valueOf(-360334));
    COLOR_MAP.put("sandybrown", Integer.valueOf(-744352));
    COLOR_MAP.put("seagreen", Integer.valueOf(-13726889));
    COLOR_MAP.put("seashell", Integer.valueOf(-2578));
    COLOR_MAP.put("sienna", Integer.valueOf(-6270419));
    COLOR_MAP.put("silver", Integer.valueOf(-4144960));
    COLOR_MAP.put("skyblue", Integer.valueOf(-7876885));
    COLOR_MAP.put("slateblue", Integer.valueOf(-9807155));
    COLOR_MAP.put("slategray", Integer.valueOf(-9404272));
    COLOR_MAP.put("slategrey", Integer.valueOf(-9404272));
    COLOR_MAP.put("snow", Integer.valueOf(-1286));
    COLOR_MAP.put("springgreen", Integer.valueOf(-16711809));
    COLOR_MAP.put("steelblue", Integer.valueOf(-12156236));
    COLOR_MAP.put("tan", Integer.valueOf(-2968436));
    COLOR_MAP.put("teal", Integer.valueOf(-16744320));
    COLOR_MAP.put("thistle", Integer.valueOf(-2572328));
    COLOR_MAP.put("tomato", Integer.valueOf(-40121));
    COLOR_MAP.put("transparent", Integer.valueOf(0));
    COLOR_MAP.put("turquoise", Integer.valueOf(-12525360));
    COLOR_MAP.put("violet", Integer.valueOf(-1146130));
    COLOR_MAP.put("wheat", Integer.valueOf(-663885));
    COLOR_MAP.put("white", Integer.valueOf(-1));
    COLOR_MAP.put("whitesmoke", Integer.valueOf(-657931));
    COLOR_MAP.put("yellow", Integer.valueOf(-256));
    COLOR_MAP.put("yellowgreen", Integer.valueOf(-6632142));
  }
  
  private static int argb(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 << 24 | paramInt2 << 16 | paramInt3 << 8 | paramInt4;
  }
  
  private static int parseColorInternal(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    String str;
    int i;
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      str = paramString.replace(" ", "");
      if (str.charAt(0) != '#') {
        break label101;
      }
      i = (int)Long.parseLong(str.substring(1), 16);
      if (str.length() != 7) {
        break;
      }
      return i | 0xFF000000;
    }
    if (str.length() == 9) {
      return i >>> 8 | (i & 0xFF) << 24;
    }
    throw new IllegalArgumentException();
    label101:
    if (str.startsWith("rgba"))
    {
      if (paramBoolean)
      {
        paramString = RGBA_PATTERN_FLOAT_ALPHA;
        paramString = paramString.matcher(str);
        if (!paramString.matches()) {
          break label293;
        }
        if (!paramBoolean) {
          break label193;
        }
      }
      for (i = (int)(255.0F * Float.parseFloat(paramString.group(4)));; i = Integer.parseInt(paramString.group(4), 10))
      {
        return argb(i, Integer.parseInt(paramString.group(1), 10), Integer.parseInt(paramString.group(2), 10), Integer.parseInt(paramString.group(3), 10));
        paramString = RGBA_PATTERN_INT_ALPHA;
        break;
      }
    }
    else if (str.startsWith("rgb"))
    {
      paramString = RGB_PATTERN.matcher(str);
      if (paramString.matches()) {
        return rgb(Integer.parseInt(paramString.group(1), 10), Integer.parseInt(paramString.group(2), 10), Integer.parseInt(paramString.group(3), 10));
      }
    }
    else
    {
      paramString = (Integer)COLOR_MAP.get(Util.toLowerInvariant(str));
      if (paramString != null) {
        return paramString.intValue();
      }
    }
    label193:
    throw new IllegalArgumentException();
  }
  
  public static int parseCssColor(String paramString)
  {
    return parseColorInternal(paramString, true);
  }
  
  public static int parseTtmlColor(String paramString)
  {
    return parseColorInternal(paramString, false);
  }
  
  private static int rgb(int paramInt1, int paramInt2, int paramInt3)
  {
    return argb(255, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.util.ColorParser
 * JD-Core Version:    0.7.0.1
 */