public class bghr
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
  public static final String i;
  public static final String j;
  
  static
  {
    jdField_a_of_type_JavaLangString = "JsFamousShare";
    b = "famousShareToQQFriend";
    c = "famousShareToQzone";
    d = "famousShareToWxFriend";
    e = "famousShareToWxPengyouquan";
    f = "famousJubao";
    g = "setUserHomePageMsgBoardGate";
    h = "writeMood";
    i = ajjy.a(2131646135);
    j = ajjy.a(2131646134);
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "SetPersonalizeFinished", "setAvatar", "SetNaviDeco", "setFloat", "updateCustomPraise", "setcardfinish", "updatePloymorphicPraise", "setResponsiveLike", "OpenCustomVipSucc", "SetFacade", "setFriendNaviDeco", "SetPlayerDeco", "setDefaultFont", "refreshFeeds", "setCustomTrack" };
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int m = arrayOfString.length;
    int k = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (k < m)
      {
        if (arrayOfString[k].equalsIgnoreCase(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      k += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bghr
 * JD-Core Version:    0.7.0.1
 */