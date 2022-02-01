public class bnmg
{
  public static String a;
  public static String[] a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static final String j;
  public static final String k;
  
  static
  {
    jdField_a_of_type_JavaLangString = "JsFamousShare";
    b = "famousShareToQQFriend";
    c = "famousShareToQzone";
    d = "famousShareToWxFriend";
    e = "famousShareToWxPengyouquan";
    f = "famousJubao";
    g = "setUserHomePageMsgBoardGate";
    h = "SetHostMessage";
    i = "writeMood";
    j = anzj.a(2131710806);
    k = anzj.a(2131710805);
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "SetPersonalizeFinished", "setAvatar", "SetNaviDeco", "setFloat", "updateCustomPraise", "setcardfinish", "updatePloymorphicPraise", "setResponsiveLike", "OpenCustomVipSucc", "SetFacade", "setFriendNaviDeco", "SetPlayerDeco", "setDefaultFont", "refreshFeeds", "setCustomTrack" };
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int n = arrayOfString.length;
    int m = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (m < n)
      {
        if (arrayOfString[m].equalsIgnoreCase(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      m += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnmg
 * JD-Core Version:    0.7.0.1
 */