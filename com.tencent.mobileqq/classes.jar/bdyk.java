import android.graphics.Color;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.StringTokenizer;

public class bdyk
{
  private static final HashMap<String, Integer> a = new HashMap();
  
  static
  {
    a.put("transparent", Integer.valueOf(0));
    a.put("none", Integer.valueOf(0));
    a.put("aliceblue", Integer.valueOf(-984833));
    a.put("antiquewhite", Integer.valueOf(-332841));
    a.put("aqua", Integer.valueOf(-16711681));
    a.put("aquamarine", Integer.valueOf(-8388652));
    a.put("azure", Integer.valueOf(-983041));
    a.put("beige", Integer.valueOf(-657956));
    a.put("bisque", Integer.valueOf(-6972));
    a.put("black", Integer.valueOf(-16777216));
    a.put("blanchedalmond", Integer.valueOf(-5171));
    a.put("blue", Integer.valueOf(-16776961));
    a.put("blueViolet", Integer.valueOf(-7722014));
    a.put("brown", Integer.valueOf(-5952982));
    a.put("burlywood", Integer.valueOf(-2180985));
    a.put("cadetblue", Integer.valueOf(-10510688));
    a.put("chartreuse", Integer.valueOf(-8388864));
    a.put("chocolate", Integer.valueOf(-2987746));
    a.put("coral", Integer.valueOf(-32944));
    a.put("cornflowerblue", Integer.valueOf(-10185235));
    a.put("cornsilk", Integer.valueOf(-1828));
    a.put("crimson", Integer.valueOf(-2354116));
    a.put("cyan", Integer.valueOf(-16711681));
    a.put("darkblue", Integer.valueOf(-16777077));
    a.put("darkcyan", Integer.valueOf(-16741493));
    a.put("darkgoldenrod", Integer.valueOf(-4684277));
    a.put("darkgray", Integer.valueOf(-5658199));
    a.put("darkgreen", Integer.valueOf(-16751616));
    a.put("darkkhaki", Integer.valueOf(-4343957));
    a.put("darkmagenta", Integer.valueOf(-7667573));
    a.put("darkolivegreen", Integer.valueOf(-11179217));
    a.put("darkorange", Integer.valueOf(-29696));
    a.put("darkorchid", Integer.valueOf(-6737204));
    a.put("darkred", Integer.valueOf(-7667712));
    a.put("darksalmon", Integer.valueOf(-1468806));
    a.put("darkseagreen", Integer.valueOf(-7357297));
    a.put("darkslateblue", Integer.valueOf(-12042869));
    a.put("darkslategray", Integer.valueOf(-13676721));
    a.put("darkturquoise", Integer.valueOf(-16724271));
    a.put("darkviolet", Integer.valueOf(-7077677));
    a.put("deeppink", Integer.valueOf(-60269));
    a.put("deepskyblue", Integer.valueOf(-16728065));
    a.put("dimgray", Integer.valueOf(-9868951));
    a.put("dimgrey", Integer.valueOf(-9868951));
    a.put("dodgerblue", Integer.valueOf(-14774017));
    a.put("firebrick", Integer.valueOf(-5103070));
    a.put("floralwhite", Integer.valueOf(-1296));
    a.put("forestgreen", Integer.valueOf(-14513374));
    a.put("fuchsia", Integer.valueOf(-65281));
    a.put("gainsboro", Integer.valueOf(-2302756));
    a.put("ghostwhite", Integer.valueOf(-460545));
    a.put("gold", Integer.valueOf(-10496));
    a.put("goldenrod", Integer.valueOf(-2448096));
    a.put("gray", Integer.valueOf(-7829368));
    a.put("grey", Integer.valueOf(-8355712));
    a.put("green", Integer.valueOf(-16711936));
    a.put("greenyellow", Integer.valueOf(-5374161));
    a.put("honeydew", Integer.valueOf(-983056));
    a.put("hotpink", Integer.valueOf(-38476));
    a.put("indianred", Integer.valueOf(-3318692));
    a.put("indigo", Integer.valueOf(-11861886));
    a.put("ivory", Integer.valueOf(-16));
    a.put("khaki", Integer.valueOf(-989556));
    a.put("lavender", Integer.valueOf(-1644806));
    a.put("lavenderblush", Integer.valueOf(-3851));
    a.put("lawngreen", Integer.valueOf(-8586240));
    a.put("lemonchiffon", Integer.valueOf(-1331));
    a.put("lightblue", Integer.valueOf(-5383962));
    a.put("lightcoral", Integer.valueOf(-1015680));
    a.put("lightcyan", Integer.valueOf(-2031617));
    a.put("lightgoldenrodyellow", Integer.valueOf(-329006));
    a.put("lightgray", Integer.valueOf(-2894893));
    a.put("lightgrey", Integer.valueOf(-2894893));
    a.put("lightgreen", Integer.valueOf(-7278960));
    a.put("lightpink", Integer.valueOf(-18751));
    a.put("lightsalmon", Integer.valueOf(-24454));
    a.put("lightseagreen", Integer.valueOf(-14634326));
    a.put("lightskyblue", Integer.valueOf(-7876870));
    a.put("lightslategray", Integer.valueOf(-8943463));
    a.put("lightslategrey", Integer.valueOf(-8943463));
    a.put("lightsteelblue", Integer.valueOf(-5192482));
    a.put("lightyellow", Integer.valueOf(-32));
    a.put("lime", Integer.valueOf(-16711936));
    a.put("limegreen", Integer.valueOf(-13447886));
    a.put("linen", Integer.valueOf(-331546));
    a.put("magenta", Integer.valueOf(-65281));
    a.put("maroon", Integer.valueOf(-8388608));
    a.put("mediumaquamarine", Integer.valueOf(-10039894));
    a.put("mediumblue", Integer.valueOf(-16777011));
    a.put("mediumorchid", Integer.valueOf(-4565549));
    a.put("mediumpurple", Integer.valueOf(-7114533));
    a.put("mediumseagreen", Integer.valueOf(-12799119));
    a.put("mediumslateblue", Integer.valueOf(-8689426));
    a.put("mediumspringgreen", Integer.valueOf(-16713062));
    a.put("mediumturquoise", Integer.valueOf(-12004916));
    a.put("mediumvioletred", Integer.valueOf(-3730043));
    a.put("midnightblue", Integer.valueOf(-15132304));
    a.put("mintcream", Integer.valueOf(-655366));
    a.put("mistyrose", Integer.valueOf(-6943));
    a.put("moccasin", Integer.valueOf(-6987));
    a.put("navajowhite", Integer.valueOf(-8531));
    a.put("navy", Integer.valueOf(-16777088));
    a.put("oldlace", Integer.valueOf(-133658));
    a.put("olive", Integer.valueOf(-8355840));
    a.put("olivedrab", Integer.valueOf(-9728477));
    a.put("orange", Integer.valueOf(-23296));
    a.put("orangered", Integer.valueOf(-47872));
    a.put("orchid", Integer.valueOf(-2461482));
    a.put("palegoldenrod", Integer.valueOf(-1120086));
    a.put("palegreen", Integer.valueOf(-6751336));
    a.put("paleturquoise", Integer.valueOf(-5247250));
    a.put("palevioletred", Integer.valueOf(-2396013));
    a.put("papayawhip", Integer.valueOf(-4139));
    a.put("peachpuff", Integer.valueOf(-9543));
    a.put("peru", Integer.valueOf(-3308225));
    a.put("pink", Integer.valueOf(-16181));
    a.put("plum", Integer.valueOf(-2252579));
    a.put("powderblue", Integer.valueOf(-5185306));
    a.put("purple", Integer.valueOf(-8388480));
    a.put("rebeccapurple", Integer.valueOf(-10079335));
    a.put("red", Integer.valueOf(-65536));
    a.put("rosybrown", Integer.valueOf(-4419697));
    a.put("royalblue", Integer.valueOf(-12490271));
    a.put("saddlebrown", Integer.valueOf(-7650029));
    a.put("salmon", Integer.valueOf(-360334));
    a.put("sandybrown", Integer.valueOf(-744352));
    a.put("seagreen", Integer.valueOf(-13726889));
    a.put("seashell", Integer.valueOf(-2578));
    a.put("sienna", Integer.valueOf(-6270419));
    a.put("silver", Integer.valueOf(-4144960));
    a.put("skyblue", Integer.valueOf(-7876885));
    a.put("slateblue", Integer.valueOf(-9807155));
    a.put("slategray", Integer.valueOf(-9404272));
    a.put("slategrey", Integer.valueOf(-9404272));
    a.put("snow", Integer.valueOf(-1286));
    a.put("springgreen", Integer.valueOf(-16711809));
    a.put("steelblue", Integer.valueOf(-12156236));
    a.put("tan", Integer.valueOf(-2968436));
    a.put("teal", Integer.valueOf(-16744320));
    a.put("thistle", Integer.valueOf(-2572328));
    a.put("tomato", Integer.valueOf(-40121));
    a.put("turquoise", Integer.valueOf(-12525360));
    a.put("violet", Integer.valueOf(-1146130));
    a.put("wheat", Integer.valueOf(-663885));
    a.put("white", Integer.valueOf(-1));
    a.put("whitesmoke", Integer.valueOf(-657931));
    a.put("yellow", Integer.valueOf(-256));
    a.put("yellowgreen", Integer.valueOf(-6632142));
  }
  
  public static int a(String paramString)
  {
    long l1;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0;
      }
      StringTokenizer localStringTokenizer;
      if ((paramString.startsWith("rgba")) || (paramString.startsWith("rgb")))
      {
        localStringTokenizer = null;
        if (paramString.startsWith("rgba")) {
          localStringTokenizer = new StringTokenizer(paramString, "rgba()");
        }
      }
      while ((localStringTokenizer != null) && (localStringTokenizer.hasMoreElements()))
      {
        paramString = localStringTokenizer.nextToken();
        if (paramString != null)
        {
          paramString = paramString.split(",");
          if (paramString.length == 4)
          {
            return Color.argb((int)(Float.valueOf(paramString[3].trim()).floatValue() * 255.0F), Integer.valueOf(paramString[0].trim()).intValue(), Integer.valueOf(paramString[1].trim()).intValue(), Integer.valueOf(paramString[2].trim()).intValue());
            if (paramString.startsWith("rgb")) {
              localStringTokenizer = new StringTokenizer(paramString, "rgb()");
            }
          }
          else if (paramString.length == 3)
          {
            return Color.rgb(Integer.valueOf(paramString[0].trim()).intValue(), Integer.valueOf(paramString[1].trim()).intValue(), Integer.valueOf(paramString[2].trim()).intValue());
            int i;
            if (paramString.charAt(0) == '#')
            {
              long l2 = Long.parseLong(paramString.substring(1), 16);
              int k;
              int j;
              if (paramString.length() == 4)
              {
                k = Integer.parseInt(paramString.substring(1, 4), 16);
                i = k & 0xF00;
                j = k & 0xF0;
                k &= 0xF;
                l1 = Color.rgb(i >> 8 | i >> 4, j | j >> 4, k | k << 4);
                break label474;
              }
              if (paramString.length() == 5)
              {
                int m = Integer.parseInt(paramString.substring(1, 5), 16);
                i = m & 0xF;
                j = m & 0xF;
                k = m & 0xF;
                m &= 0xF;
                l1 = Color.argb(m | m << 4, i | i << 4, j | j << 4, k | k << 4);
                break label474;
              }
              if (paramString.length() == 7)
              {
                l1 = l2 | 0xFF000000;
                break label474;
              }
              l1 = l2;
              if (paramString.length() != 9) {
                break label474;
              }
              l1 = (l2 & 0xFFFFFF00) >> 8 | (0xFF & l2) << 24;
              break label474;
            }
            paramString = (Integer)a.get(paramString.toLowerCase(Locale.ROOT));
            if (paramString != null)
            {
              i = paramString.intValue();
              return i;
            }
          }
        }
      }
      return 0;
    }
    catch (Exception paramString)
    {
      return 0;
    }
    label474:
    return (int)l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdyk
 * JD-Core Version:    0.7.0.1
 */