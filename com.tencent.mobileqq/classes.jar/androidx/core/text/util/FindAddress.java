package androidx.core.text.util;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.Locale;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class FindAddress
{
  private static final String HOUSE_COMPONENT = "(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)";
  private static final String HOUSE_END = "(?=[,\"'\t                　\n\013\f\r  ]|$)";
  private static final String HOUSE_POST_DELIM = ",\"'\t                　\n\013\f\r  ";
  private static final String HOUSE_PRE_DELIM = ":,\"'\t                　\n\013\f\r  ";
  private static final int MAX_ADDRESS_LINES = 5;
  private static final int MAX_ADDRESS_WORDS = 14;
  private static final int MAX_LOCATION_NAME_DISTANCE = 5;
  private static final int MIN_ADDRESS_WORDS = 4;
  private static final String NL = "\n\013\f\r  ";
  private static final String SP = "\t                　";
  private static final String WORD_DELIM = ",*•\t                　\n\013\f\r  ";
  private static final String WORD_END = "(?=[,*•\t                　\n\013\f\r  ]|$)";
  private static final String WS = "\t                　\n\013\f\r  ";
  private static final int kMaxAddressNameWordLength = 25;
  private static final Pattern sHouseNumberRe;
  private static final Pattern sLocationNameRe = Pattern.compile("(?:alley|annex|arcade|ave[.]?|avenue|alameda|bayou|beach|bend|bluffs?|bottom|boulevard|branch|bridge|brooks?|burgs?|bypass|broadway|camino|camp|canyon|cape|causeway|centers?|circles?|cliffs?|club|common|corners?|course|courts?|coves?|creek|crescent|crest|crossing|crossroad|curve|circulo|dale|dam|divide|drives?|estates?|expressway|extensions?|falls?|ferry|fields?|flats?|fords?|forest|forges?|forks?|fort|freeway|gardens?|gateway|glens?|greens?|groves?|harbors?|haven|heights|highway|hills?|hollow|inlet|islands?|isle|junctions?|keys?|knolls?|lakes?|land|landing|lane|lights?|loaf|locks?|lodge|loop|mall|manors?|meadows?|mews|mills?|mission|motorway|mount|mountains?|neck|orchard|oval|overpass|parks?|parkways?|pass|passage|path|pike|pines?|plains?|plaza|points?|ports?|prairie|privada|radial|ramp|ranch|rapids?|rd[.]?|rest|ridges?|river|roads?|route|row|rue|run|shoals?|shores?|skyway|springs?|spurs?|squares?|station|stravenue|stream|st[.]?|streets?|summit|speedway|terrace|throughway|trace|track|trafficway|trail|tunnel|turnpike|underpass|unions?|valleys?|viaduct|views?|villages?|ville|vista|walks?|wall|ways?|wells?|xing|xrd)(?=[,*•\t                　\n\013\f\r  ]|$)", 2);
  private static final Pattern sStateRe;
  private static final FindAddress.ZipRange[] sStateZipCodeRanges = { new FindAddress.ZipRange(99, 99, -1, -1), new FindAddress.ZipRange(35, 36, -1, -1), new FindAddress.ZipRange(71, 72, -1, -1), new FindAddress.ZipRange(96, 96, -1, -1), new FindAddress.ZipRange(85, 86, -1, -1), new FindAddress.ZipRange(90, 96, -1, -1), new FindAddress.ZipRange(80, 81, -1, -1), new FindAddress.ZipRange(6, 6, -1, -1), new FindAddress.ZipRange(20, 20, -1, -1), new FindAddress.ZipRange(19, 19, -1, -1), new FindAddress.ZipRange(32, 34, -1, -1), new FindAddress.ZipRange(96, 96, -1, -1), new FindAddress.ZipRange(30, 31, -1, -1), new FindAddress.ZipRange(96, 96, -1, -1), new FindAddress.ZipRange(96, 96, -1, -1), new FindAddress.ZipRange(50, 52, -1, -1), new FindAddress.ZipRange(83, 83, -1, -1), new FindAddress.ZipRange(60, 62, -1, -1), new FindAddress.ZipRange(46, 47, -1, -1), new FindAddress.ZipRange(66, 67, 73, -1), new FindAddress.ZipRange(40, 42, -1, -1), new FindAddress.ZipRange(70, 71, -1, -1), new FindAddress.ZipRange(1, 2, -1, -1), new FindAddress.ZipRange(20, 21, -1, -1), new FindAddress.ZipRange(3, 4, -1, -1), new FindAddress.ZipRange(96, 96, -1, -1), new FindAddress.ZipRange(48, 49, -1, -1), new FindAddress.ZipRange(55, 56, -1, -1), new FindAddress.ZipRange(63, 65, -1, -1), new FindAddress.ZipRange(96, 96, -1, -1), new FindAddress.ZipRange(38, 39, -1, -1), new FindAddress.ZipRange(55, 56, -1, -1), new FindAddress.ZipRange(27, 28, -1, -1), new FindAddress.ZipRange(58, 58, -1, -1), new FindAddress.ZipRange(68, 69, -1, -1), new FindAddress.ZipRange(3, 4, -1, -1), new FindAddress.ZipRange(7, 8, -1, -1), new FindAddress.ZipRange(87, 88, 86, -1), new FindAddress.ZipRange(88, 89, 96, -1), new FindAddress.ZipRange(10, 14, 0, 6), new FindAddress.ZipRange(43, 45, -1, -1), new FindAddress.ZipRange(73, 74, -1, -1), new FindAddress.ZipRange(97, 97, -1, -1), new FindAddress.ZipRange(15, 19, -1, -1), new FindAddress.ZipRange(6, 6, 0, 9), new FindAddress.ZipRange(96, 96, -1, -1), new FindAddress.ZipRange(2, 2, -1, -1), new FindAddress.ZipRange(29, 29, -1, -1), new FindAddress.ZipRange(57, 57, -1, -1), new FindAddress.ZipRange(37, 38, -1, -1), new FindAddress.ZipRange(75, 79, 87, 88), new FindAddress.ZipRange(84, 84, -1, -1), new FindAddress.ZipRange(22, 24, 20, -1), new FindAddress.ZipRange(6, 9, -1, -1), new FindAddress.ZipRange(5, 5, -1, -1), new FindAddress.ZipRange(98, 99, -1, -1), new FindAddress.ZipRange(53, 54, -1, -1), new FindAddress.ZipRange(24, 26, -1, -1), new FindAddress.ZipRange(82, 83, -1, -1) };
  private static final Pattern sSuffixedNumberRe = Pattern.compile("([0-9]+)(st|nd|rd|th)", 2);
  private static final Pattern sWordRe = Pattern.compile("[^,*•\t                　\n\013\f\r  ]+(?=[,*•\t                　\n\013\f\r  ]|$)", 2);
  private static final Pattern sZipCodeRe = Pattern.compile("(?:[0-9]{5}(?:-[0-9]{4})?)(?=[,*•\t                　\n\013\f\r  ]|$)", 2);
  
  static
  {
    sHouseNumberRe = Pattern.compile("(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)(?:-(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?))*(?=[,\"'\t                　\n\013\f\r  ]|$)", 2);
    sStateRe = Pattern.compile("(?:(ak|alaska)|(al|alabama)|(ar|arkansas)|(as|american[\t                　]+samoa)|(az|arizona)|(ca|california)|(co|colorado)|(ct|connecticut)|(dc|district[\t                　]+of[\t                　]+columbia)|(de|delaware)|(fl|florida)|(fm|federated[\t                　]+states[\t                　]+of[\t                　]+micronesia)|(ga|georgia)|(gu|guam)|(hi|hawaii)|(ia|iowa)|(id|idaho)|(il|illinois)|(in|indiana)|(ks|kansas)|(ky|kentucky)|(la|louisiana)|(ma|massachusetts)|(md|maryland)|(me|maine)|(mh|marshall[\t                　]+islands)|(mi|michigan)|(mn|minnesota)|(mo|missouri)|(mp|northern[\t                　]+mariana[\t                　]+islands)|(ms|mississippi)|(mt|montana)|(nc|north[\t                　]+carolina)|(nd|north[\t                　]+dakota)|(ne|nebraska)|(nh|new[\t                　]+hampshire)|(nj|new[\t                　]+jersey)|(nm|new[\t                　]+mexico)|(nv|nevada)|(ny|new[\t                　]+york)|(oh|ohio)|(ok|oklahoma)|(or|oregon)|(pa|pennsylvania)|(pr|puerto[\t                　]+rico)|(pw|palau)|(ri|rhode[\t                　]+island)|(sc|south[\t                　]+carolina)|(sd|south[\t                　]+dakota)|(tn|tennessee)|(tx|texas)|(ut|utah)|(va|virginia)|(vi|virgin[\t                　]+islands)|(vt|vermont)|(wa|washington)|(wi|wisconsin)|(wv|west[\t                　]+virginia)|(wy|wyoming))(?=[,*•\t                　\n\013\f\r  ]|$)", 2);
  }
  
  private static int attemptMatch(String paramString, MatchResult paramMatchResult)
  {
    int j = paramMatchResult.end();
    Matcher localMatcher = sWordRe.matcher(paramString);
    paramMatchResult = "";
    int i2 = 1;
    int i3 = 1;
    int i1 = 1;
    int n = 0;
    int k = -1;
    int m = -1;
    int i;
    for (;;)
    {
      i = j;
      if (j >= paramString.length()) {
        break;
      }
      if (!localMatcher.find(j)) {}
      for (i = paramString.length();; i = localMatcher.end())
      {
        return -i;
        i = j;
        if (localMatcher.end() - localMatcher.start() <= 25) {
          break;
        }
      }
      while (i < localMatcher.start())
      {
        j = i2;
        if ("\n\013\f\r  ".indexOf(paramString.charAt(i)) != -1) {
          j = i2 + 1;
        }
        i += 1;
        i2 = j;
      }
      if (i2 > 5) {
        break;
      }
      i3 += 1;
      if (i3 > 14) {
        break;
      }
      int i4;
      int i5;
      int i6;
      if (matchHouseNumber(paramString, i) != null)
      {
        if ((i1 != 0) && (i2 > 1)) {
          return -i;
        }
        j = i1;
        i4 = n;
        i5 = k;
        i6 = m;
        if (k == -1)
        {
          j = i1;
          i4 = n;
          i5 = i;
          i6 = m;
        }
      }
      else if (isValidLocationName(localMatcher.group(0)))
      {
        j = 0;
        i4 = 1;
        i5 = k;
        i6 = m;
      }
      else
      {
        if ((i3 == 5) && (n == 0))
        {
          i = localMatcher.end();
          break;
        }
        j = m;
        if (n != 0)
        {
          j = m;
          if (i3 > 4)
          {
            MatchResult localMatchResult = matchState(paramString, i);
            j = m;
            if (localMatchResult != null)
            {
              if ((paramMatchResult.equals("et")) && (localMatchResult.group(0).equals("al")))
              {
                i = localMatchResult.end();
                break;
              }
              paramMatchResult = sWordRe.matcher(paramString);
              if (paramMatchResult.find(localMatchResult.end()))
              {
                j = m;
                if (isValidZipCode(paramMatchResult.group(0), localMatchResult)) {
                  return paramMatchResult.end();
                }
              }
              else
              {
                j = localMatchResult.end();
              }
            }
          }
        }
        i = 0;
        i6 = j;
        i5 = k;
        i4 = n;
        j = i;
      }
      paramMatchResult = localMatcher.group(0);
      i = localMatcher.end();
      i1 = j;
      n = i4;
      k = i5;
      m = i6;
      j = i;
    }
    if (m > 0) {
      return m;
    }
    if (k > 0) {
      i = k;
    }
    return -i;
  }
  
  private static boolean checkHouseNumber(String paramString)
  {
    int i = 0;
    int k;
    for (int j = 0; i < paramString.length(); j = k)
    {
      k = j;
      if (Character.isDigit(paramString.charAt(i))) {
        k = j + 1;
      }
      i += 1;
    }
    if (j > 5) {
      return false;
    }
    paramString = sSuffixedNumberRe.matcher(paramString);
    if (paramString.find())
    {
      i = Integer.parseInt(paramString.group(1));
      if (i == 0) {
        return false;
      }
      String str = paramString.group(2).toLowerCase(Locale.getDefault());
      j = i % 10;
      paramString = "th";
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3) {
            return str.equals("th");
          }
          if (i % 100 != 13) {
            paramString = "rd";
          }
          return str.equals(paramString);
        }
        if (i % 100 != 12) {
          paramString = "nd";
        }
        return str.equals(paramString);
      }
      if (i % 100 != 11) {
        paramString = "st";
      }
      return str.equals(paramString);
    }
    return true;
  }
  
  static String findAddress(String paramString)
  {
    Matcher localMatcher = sHouseNumberRe.matcher(paramString);
    int i = 0;
    while (localMatcher.find(i)) {
      if (checkHouseNumber(localMatcher.group(0)))
      {
        i = localMatcher.start();
        int j = attemptMatch(paramString, localMatcher);
        if (j > 0) {
          return paramString.substring(i, j);
        }
        i = -j;
      }
      else
      {
        i = localMatcher.end();
      }
    }
    return null;
  }
  
  @VisibleForTesting
  public static boolean isValidLocationName(String paramString)
  {
    return sLocationNameRe.matcher(paramString).matches();
  }
  
  @VisibleForTesting
  public static boolean isValidZipCode(String paramString)
  {
    return sZipCodeRe.matcher(paramString).matches();
  }
  
  @VisibleForTesting
  public static boolean isValidZipCode(String paramString1, String paramString2)
  {
    return isValidZipCode(paramString1, matchState(paramString2, 0));
  }
  
  private static boolean isValidZipCode(String paramString, MatchResult paramMatchResult)
  {
    boolean bool2 = false;
    if (paramMatchResult == null) {
      return false;
    }
    int j;
    for (int i = paramMatchResult.groupCount();; i = j)
    {
      j = i;
      if (i <= 0) {
        break;
      }
      j = i - 1;
      if (paramMatchResult.group(i) != null) {
        break;
      }
    }
    boolean bool1 = bool2;
    if (sZipCodeRe.matcher(paramString).matches())
    {
      bool1 = bool2;
      if (sStateZipCodeRanges[j].matches(paramString)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @VisibleForTesting
  public static MatchResult matchHouseNumber(String paramString, int paramInt)
  {
    if ((paramInt > 0) && (":,\"'\t                　\n\013\f\r  ".indexOf(paramString.charAt(paramInt - 1)) == -1)) {
      return null;
    }
    paramString = sHouseNumberRe.matcher(paramString).region(paramInt, paramString.length());
    if (paramString.lookingAt())
    {
      paramString = paramString.toMatchResult();
      if (checkHouseNumber(paramString.group(0))) {
        return paramString;
      }
    }
    return null;
  }
  
  @VisibleForTesting
  public static MatchResult matchState(String paramString, int paramInt)
  {
    Object localObject = null;
    if ((paramInt > 0) && (",*•\t                　\n\013\f\r  ".indexOf(paramString.charAt(paramInt - 1)) == -1)) {
      return null;
    }
    Matcher localMatcher = sStateRe.matcher(paramString).region(paramInt, paramString.length());
    paramString = localObject;
    if (localMatcher.lookingAt()) {
      paramString = localMatcher.toMatchResult();
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.text.util.FindAddress
 * JD-Core Version:    0.7.0.1
 */