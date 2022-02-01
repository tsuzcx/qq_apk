package com.tencent.biz.qqcircle.widgets.comment;

import java.util.HashMap;
import java.util.regex.Pattern;

public class Patterns
{
  public static final Pattern a = Pattern.compile("<uin:.*?,nickname:.*?>");
  public static final Pattern b = Pattern.compile("\\b[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b", 2);
  public static boolean c = true;
  public static final String[] d = { "[em]e113[/em]", "[em]e112[/em]", "[em]e127[/em]", "[em]e120[/em]", "[em]e139[/em]", "[em]e138[/em]", "[em]e140[/em]", "[em]e162[/em]", "[em]e163[/em]", "[em]e105[/em]", "[em]e109[/em]", "[em]e133[/em]", "[em]e116[/em]", "[em]e118[/em]", "[em]e149[/em]", "[em]e174[/em]", "[em]e170[/em]", "[em]e155[/em]", "[em]e121[/em]", "[em]e102[/em]", "[em]e106[/em]", "[em]e104[/em]", "[em]e119[/em]", "[em]e100[/em]", "[em]e111[/em]", "[em]e110[/em]", "[em]e126[/em]", "[em]e117[/em]", "[em]e166[/em]", "[em]e165[/em]", "[em]e122[/em]", "[em]e123[/em]", "[em]e115[/em]", "[em]e114[/em]", "[em]e132[/em]", "[em]e108[/em]", "[em]e152[/em]", "[em]e128[/em]", "[em]e190[/em]", "[em]e136[/em]", "[em]e101[/em]", "[em]e151[/em]", "[em]e130[/em]", "[em]e103[/em]", "[em]e146[/em]", "[em]e178[/em]", "[em]e144[/em]", "[em]e191[/em]", "[em]e148[/em]", "[em]e134[/em]", "[em]e129[/em]", "[em]e154[/em]", "[em]e179[/em]", "[em]e180[/em]", "[em]e181[/em]", "[em]e182[/em]", "[em]e183[/em]", "[em]e164[/em]", "[em]e161[/em]", "[em]e168[/em]", "[em]e156[/em]", "[em]e157[/em]", "[em]e173[/em]", "[em]e184[/em]", "[em]e189[/em]", "[em]e187[/em]", "[em]e160[/em]", "[em]e175[/em]", "[em]e171[/em]", "[em]e193[/em]", "[em]e186[/em]", "[em]e185[/em]", "[em]e167[/em]", "[em]e176[/em]", "[em]e177[/em]", "[em]e172[/em]", "[em]e137[/em]", "[em]e199[/em]", "[em]e169[/em]", "[em]e124[/em]", "[em]e125[/em]", "[em]e131[/em]", "[em]e135[/em]", "[em]e141[/em]", "[em]e142[/em]", "[em]e143[/em]", "[em]e145[/em]", "[em]e147[/em]", "[em]e150[/em]", "[em]e153[/em]", "[em]e158[/em]", "[em]e159[/em]", "[em]e188[/em]", "[em]e192[/em]", "[em]e194[/em]", "[em]e195[/em]", "[em]e196[/em]", "[em]e197[/em]", "[em]e198[/em]", "[em]e200[/em]", "[em]e201[/em]", "[em]e202[/em]", "[em]e203[/em]", "[em]e204[/em]", "[em]e107[/em]" };
  public static final String[] e = { "[em]e113[/em]", "[em]e112[/em]", "[em]e127[/em]", "[em]e120[/em]", "[em]e139[/em]", "[em]e138[/em]", "[em]e140[/em]", "[em]e162[/em]", "[em]e163[/em]", "[em]e105[/em]", "[em]e109[/em]", "[em]e133[/em]", "[em]e116[/em]", "[em]e118[/em]", "[em]e149[/em]", "[em]e174[/em]", "[em]e170[/em]", "[em]e155[/em]", "[em]e121[/em]", "[em]e102[/em]", "[em]e106[/em]", "[em]e104[/em]", "[em]e119[/em]", "[em]e100[/em]", "[em]e111[/em]", "[em]e110[/em]", "[em]e126[/em]", "[em]e117[/em]", "[em]e166[/em]", "[em]e165[/em]", "[em]e122[/em]", "[em]e123[/em]", "[em]e115[/em]", "[em]e114[/em]", "[em]e132[/em]", "[em]e108[/em]", "[em]e152[/em]", "[em]e128[/em]", "[em]e190[/em]", "[em]e136[/em]", "[em]e101[/em]", "[em]e151[/em]", "[em]e130[/em]", "[em]e103[/em]", "[em]e146[/em]", "[em]e178[/em]", "[em]e144[/em]", "[em]e191[/em]", "[em]e148[/em]", "[em]e134[/em]", "[em]e129[/em]", "[em]e154[/em]", "[em]e179[/em]", "[em]e180[/em]", "[em]e181[/em]", "[em]e182[/em]", "[em]e183[/em]", "[em]e164[/em]", "[em]e161[/em]", "[em]e168[/em]", "[em]e156[/em]", "[em]e157[/em]", "[em]e173[/em]", "[em]e184[/em]", "[em]e189[/em]", "[em]e187[/em]", "[em]e160[/em]", "[/钱]", "[em]e175[/em]", "[/美女]", "[em]e171[/em]", "[em]e193[/em]", "[em]e186[/em]", "[em]e185[/em]", "[em]e167[/em]", "[em]e176[/em]", "[em]e177[/em]", "[em]e172[/em]", "[em]e137[/em]", "[em]e199[/em]", "[em]e169[/em]", "[em]e124[/em]", "[em]e125[/em]", "[em]e131[/em]", "[em]e135[/em]", "[em]e141[/em]", "[em]e142[/em]", "[em]e143[/em]", "[em]e145[/em]", "[em]e147[/em]", "[em]e150[/em]", "[em]e153[/em]", "[em]e158[/em]", "[em]e159[/em]", "[em]e188[/em]", "[em]e192[/em]", "[em]e194[/em]", "[em]e195[/em]", "[em]e196[/em]", "[em]e197[/em]", "[em]e198[/em]", "[em]e200[/em]", "[em]e201[/em]", "[em]e202[/em]", "[em]e203[/em]", "[em]e204[/em]", "[em]e107[/em]", "[em]e121001[/em]", "[em]e121002[/em]", "[em]e121003[/em]", "[em]e121005[/em]", "[em]e121009[/em]", "[em]e121010[/em]", "[em]e121011[/em]", "[em]e121012[/em]", "[em]e121013[/em]", "[em]e121016[/em]", "[em]e121023[/em]", "[em]e121033[/em]", "[em]e121034[/em]", "[em]e241[/em]", "[em]e242[/em]", "[em]e243[/em]", "[em]e244[/em]", "[em]e245[/em]", "[em]e246[/em]", "[em]e247[/em]", "[em]e248[/em]", "[em]e249[/em]", "[em]e250[/em]", "[em]e251[/em]", "[em]e252[/em]", "[em]e253[/em]", "[em]e254[/em]", "[em]e255[/em]", "[em]e256[/em]", "[em]e257[/em]", "[em]e258[/em]", "[em]e259[/em]", "[em]e260[/em]", "[em]e261[/em]", "[em]e262[/em]", "[em]e263[/em]", "[em]e264[/em]", "[em]e265[/em]", "[em]e266[/em]", "[em]e267[/em]", "[em]e268[/em]", "[em]e269[/em]", "[em]e270[/em]", "[em]e271[/em]", "[em]e272[/em]", "[em]e273[/em]", "[em]e274[/em]", "[em]e275[/em]", "[em]e276[/em]", "[em]e277[/em]", "[em]e278[/em]", "[em]e279[/em]", "[em]e280[/em]", "[em]e281[/em]", "[em]e282[/em]", "[em]e283[/em]", "[em]e284[/em]", "[em]e285[/em]", "[em]e286[/em]", "[em]e287[/em]", "[em]e288[/em]", "[em]e289[/em]", "[em]e290[/em]", "[em]e291[/em]", "[em]e292[/em]", "[em]e293[/em]", "[em]e295[/em]", "[em]e296[/em]", "[em]e297[/em]", "[em]e294[/em]", "[em]e298[/em]" };
  public static final String[] f = { "[em]e252[/em]", "[em]e249[/em]", "[em]e243[/em]", "[em]e244[/em]", "[em]e282[/em]", "[em]e245[/em]", "[em]e248[/em]", "[em]e247[/em]", "[em]e250[/em]", "[em]e246[/em]", "[em]e241[/em]", "[em]e205[/em]", "[em]e206[/em]", "[em]e207[/em]", "[em]e209[/em]", "[em]e213[/em]", "[em]e215[/em]", "[em]e216[/em]", "[em]e217[/em]", "[em]e220[/em]", "[em]e227[/em]", "[em]e237[/em]", "[em]e238[/em]", "[em]e258[/em]", "[em]e262[/em]", "[em]e254[/em]", "[em]e255[/em]", "[em]e260[/em]", "[em]e257[/em]", "[em]e263[/em]", "[em]e264[/em]", "[em]e267[/em]", "[em]e268[/em]", "[em]e269[/em]", "[em]e270[/em]", "[em]e271[/em]", "[em]e272[/em]", "[em]e273[/em]", "[em]e274[/em]", "[em]e275[/em]", "[em]e276[/em]", "[em]e277[/em]", "[em]e278[/em]", "[em]e280[/em]", "[em]e281[/em]" };
  public static final Pattern g = Pattern.compile("@?\\{uid:.*?\\}");
  public static final Pattern h = Pattern.compile("#?\\{id:.*?,title:.*?\\}#");
  public static final Pattern i = Pattern.compile("\\{url:.*?,text:.*?\\}");
  public static final Pattern j = Pattern.compile("\\[/(.+?)\\]", 2);
  public static final Pattern k = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);
  public static final Pattern l = Pattern.compile("\\[em2\\]e\\d{1,},\\d{1,},\\d{1,}\\[/em2\\]", 2);
  public static final Pattern m = Pattern.compile("\\{text:.*?,color:.*?\\}");
  public static String n = ".gif";
  private static HashMap<String, Integer> o;
  private static HashMap<String, Integer> p;
  
  static
  {
    a();
    b();
  }
  
  private static void a()
  {
    o = new HashMap();
    int i1 = 0;
    for (;;)
    {
      String[] arrayOfString = e;
      if (i1 >= arrayOfString.length) {
        break;
      }
      o.put(arrayOfString[i1], Integer.valueOf(i1));
      i1 += 1;
    }
  }
  
  private static void b()
  {
    if (p == null)
    {
      p = new HashMap();
      int i1 = 0;
      for (;;)
      {
        String[] arrayOfString = f;
        if (i1 >= arrayOfString.length) {
          break;
        }
        p.put(arrayOfString[i1], Integer.valueOf(i1));
        i1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.comment.Patterns
 * JD-Core Version:    0.7.0.1
 */