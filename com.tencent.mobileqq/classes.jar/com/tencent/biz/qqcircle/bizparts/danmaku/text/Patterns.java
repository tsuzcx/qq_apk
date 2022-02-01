package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import java.util.HashMap;
import java.util.regex.Pattern;

public class Patterns
{
  public static final Pattern a = Pattern.compile("<uin:.*?,nick(name):.*?>(?#NICK_PATTERN)|@?\\{uin:.*?\\}(?#AT_PATTERN)|\\{url:.*?,text:.*?\\}(?#CUSTOM_URL_PATTERN)|\\[em\\]e\\d{1,}\\[/em\\](?#SMILEY_PATTERN)|\\[em2\\]e\\d{1,},\\d{1,},\\d{1,}\\[/em2\\](?#QUICK_SMILEY_PATTERN)|\\{text:.*?,color:.*?\\}(?#COLOR_PATTERN)|\\[hlt\\].*?\\[/hlt\\](?#HIGHLIGHT_PATTERN)");
  public static final Pattern b = Pattern.compile("<uin:.*?,nick(name):.*?>(?#NICK_PATTERN)|@?\\{uin:.*?\\}(?#AT_PATTERN)|\\{url:.*?,text:.*?\\}(?#CUSTOM_URL_PATTERN)|\\[em\\]e\\d{1,}\\[/em\\](?#SMILEY_PATTERN)|\\[em2\\]e\\d{1,},\\d{1,},\\d{1,}\\[/em2\\](?#QUICK_SMILEY_PATTERN)|\\{text:.*?,color:.*?\\}(?#COLOR_PATTERN)|\\{url:.*?,text:.*?\\}(?#CUSTOM_URL_PATTERN)|\\[hlt\\].*?\\[/hlt\\](?#HIGHLIGHT_PATTERN)");
  public static final Pattern c = Pattern.compile("<uin:.*?,nick(name):.*?>");
  public static final Pattern d = Pattern.compile("\\b[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b", 2);
  public static boolean e = true;
  public static final String[] f = { "[em]e113[/em]", "[em]e112[/em]", "[em]e127[/em]", "[em]e120[/em]", "[em]e139[/em]", "[em]e138[/em]", "[em]e140[/em]", "[em]e162[/em]", "[em]e163[/em]", "[em]e105[/em]", "[em]e109[/em]", "[em]e133[/em]", "[em]e116[/em]", "[em]e118[/em]", "[em]e149[/em]", "[em]e174[/em]", "[em]e170[/em]", "[em]e155[/em]", "[em]e121[/em]", "[em]e102[/em]", "[em]e106[/em]", "[em]e104[/em]", "[em]e119[/em]", "[em]e100[/em]", "[em]e111[/em]", "[em]e110[/em]", "[em]e126[/em]", "[em]e117[/em]", "[em]e166[/em]", "[em]e165[/em]", "[em]e122[/em]", "[em]e123[/em]", "[em]e115[/em]", "[em]e114[/em]", "[em]e132[/em]", "[em]e108[/em]", "[em]e152[/em]", "[em]e128[/em]", "[em]e190[/em]", "[em]e136[/em]", "[em]e101[/em]", "[em]e151[/em]", "[em]e130[/em]", "[em]e103[/em]", "[em]e146[/em]", "[em]e178[/em]", "[em]e144[/em]", "[em]e191[/em]", "[em]e148[/em]", "[em]e134[/em]", "[em]e129[/em]", "[em]e154[/em]", "[em]e179[/em]", "[em]e180[/em]", "[em]e181[/em]", "[em]e182[/em]", "[em]e183[/em]", "[em]e164[/em]", "[em]e161[/em]", "[em]e168[/em]", "[em]e156[/em]", "[em]e157[/em]", "[em]e173[/em]", "[em]e184[/em]", "[em]e189[/em]", "[em]e187[/em]", "[em]e160[/em]", "[em]e175[/em]", "[em]e171[/em]", "[em]e193[/em]", "[em]e186[/em]", "[em]e185[/em]", "[em]e167[/em]", "[em]e176[/em]", "[em]e177[/em]", "[em]e172[/em]", "[em]e137[/em]", "[em]e199[/em]", "[em]e169[/em]", "[em]e124[/em]", "[em]e125[/em]", "[em]e131[/em]", "[em]e135[/em]", "[em]e141[/em]", "[em]e142[/em]", "[em]e143[/em]", "[em]e145[/em]", "[em]e147[/em]", "[em]e150[/em]", "[em]e153[/em]", "[em]e158[/em]", "[em]e159[/em]", "[em]e188[/em]", "[em]e192[/em]", "[em]e194[/em]", "[em]e195[/em]", "[em]e196[/em]", "[em]e197[/em]", "[em]e198[/em]", "[em]e200[/em]", "[em]e201[/em]", "[em]e202[/em]", "[em]e203[/em]", "[em]e204[/em]", "[em]e107[/em]" };
  public static final String[] g = { ":-)", ":-(", ";-)", ":-P", "=-O", ":-*", ":O", "B-)", ":-$", ":-!", ":-[", "O:-)", ":'(", ":-X", ":-D", "o_O" };
  public static final String[] h = { "😁", "😔", "😊", "😜", "😳", "👄", "😱", "😌", "😍", "😣", "😓", "😏", "😭", "😒", "😄", "😖" };
  public static final Pattern i = Pattern.compile("@?\\{uin:.*?\\}");
  public static final Pattern j = Pattern.compile("\\{url:.*?,text:.*?\\}");
  public static final Pattern k = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);
  public static final Pattern l = Pattern.compile("\\[em2\\]e\\d{1,},\\d{1,},\\d{1,}\\[/em2\\]", 2);
  public static final Pattern m = Pattern.compile("\\{text:.*?,color:.*?\\}");
  public static final Pattern n = Pattern.compile("\\[hlt\\].*?\\[/hlt\\]", 2);
  public static final Pattern o = Pattern.compile("[🀀-🏿]|[🐀-🟿]|[☀-⟿]", 66);
  public static final Pattern p = Pattern.compile("\\[dra\\].*?\\[/dra\\]", 2);
  private static HashMap<String, Integer> q;
  private static HashMap<String, String> r;
  
  static
  {
    b();
    a();
  }
  
  private static void a()
  {
    r = new HashMap();
    int i1 = 0;
    for (;;)
    {
      String[] arrayOfString = g;
      if (i1 >= arrayOfString.length) {
        break;
      }
      r.put(arrayOfString[i1], h[i1]);
      i1 += 1;
    }
  }
  
  private static void b()
  {
    q = new HashMap();
    int i1 = 0;
    for (;;)
    {
      String[] arrayOfString = f;
      if (i1 >= arrayOfString.length) {
        break;
      }
      q.put(arrayOfString[i1], Integer.valueOf(i1));
      i1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.Patterns
 * JD-Core Version:    0.7.0.1
 */