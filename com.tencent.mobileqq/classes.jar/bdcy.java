import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class bdcy
{
  protected static bdcy a;
  protected long a;
  protected Bundle a;
  protected bdda a;
  protected bdjd a;
  protected bdkn a;
  public String a;
  protected String b;
  protected String c;
  public String d;
  
  public static bdcy a()
  {
    try
    {
      if (jdField_a_of_type_Bdcy == null) {
        jdField_a_of_type_Bdcy = new bdcy();
      }
      bdcy localbdcy = jdField_a_of_type_Bdcy;
      return localbdcy;
    }
    finally {}
  }
  
  public ArrayList<bdel> a()
  {
    int i = 0;
    if (this.jdField_a_of_type_Bdkn == null) {
      return new ArrayList(0);
    }
    int j = this.jdField_a_of_type_Bdkn.a();
    ArrayList localArrayList = new ArrayList(j);
    while (i < j)
    {
      localArrayList.add((bdel)this.jdField_a_of_type_Bdkn.a(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bdda = null;
    if (this.jdField_a_of_type_Bdjd != null) {
      this.jdField_a_of_type_Bdjd.a();
    }
  }
  
  public void a(Bundle paramBundle, bddb parambddb, String paramString)
  {
    if ((paramBundle == null) || (parambddb == null))
    {
      bdii.e("OpenSdkFriendService", "getFriendListAsync params error. params=" + paramBundle + "; listener=" + parambddb);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.d = paramString;
    if ("action_invite".equals(paramString))
    {
      paramString = bdoc.a().a("http://fusion.qq.com/cgi-bin/qzapps/mappinvite_getqqlist.cgi");
      paramBundle.putString("md5str", bdob.a(bcyb.a().a(), "invite_friend_list_md5").getString(this.b, ""));
    }
    for (;;)
    {
      this.c = paramString;
      this.jdField_a_of_type_Bdjd = new bdjd(paramString, "GET", new bddc(this, parambddb));
      this.jdField_a_of_type_Bdjd.a(paramBundle);
      return;
      if ("action_story".equals(paramString))
      {
        paramString = bdoc.a().a("http://fusion.qq.com/cgi-bin/appstage/mapp_getqqlist.cgi");
        paramBundle.putString("needhttpcache", "nothing");
      }
      else if ("action_voice".equals(paramString))
      {
        paramString = bdoc.a().a("http://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else if ("action_reactive".equals(paramString))
      {
        paramString = bdoc.a().a("http://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else
      {
        paramString = bdoc.a().a("http://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
    }
  }
  
  public void a(String paramString)
  {
    if ("action_invite".equals(this.d))
    {
      SharedPreferences.Editor localEditor = bdob.a(bcyb.a().a(), "invite_friend_list_md5").edit();
      localEditor.putString(this.b, paramString);
      localEditor.commit();
    }
  }
  
  public void a(String paramString, Bundle paramBundle, bdda parambdda)
  {
    this.jdField_a_of_type_Bdda = parambdda;
    paramBundle.putString("time", bdob.a(bcyb.a().a(), "prefer_last_avatar_update_time").getString(this.b, "0"));
    new bdjd(paramString, "GET", new bdcz(this)).a(paramBundle);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    for (;;)
    {
      try
      {
        bdii.e("OpenSdkFriendService", "initData error. appid=" + paramString1 + "; openid=" + paramString2);
        return;
      }
      finally {}
      this.jdField_a_of_type_Long = Long.parseLong(bdob.a(bcyb.a().a(), "uin_openid_store").getString(paramString2, ""));
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.b = paramString2;
      try
      {
        this.jdField_a_of_type_Bdkn = bdki.a().a(bdel.class, this.jdField_a_of_type_Long, "invite_friend_list_" + this.b);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void a(List<bdel> paramList)
  {
    if (this.jdField_a_of_type_Bdkn == null) {
      return;
    }
    bdel[] arrayOfbdel = new bdel[paramList.size()];
    paramList.toArray(arrayOfbdel);
    this.jdField_a_of_type_Bdkn.a(arrayOfbdel, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdcy
 * JD-Core Version:    0.7.0.1
 */