import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class bhtw
{
  protected static bhtw a;
  protected long a;
  protected Bundle a;
  protected bhty a;
  protected biae a;
  protected bibi a;
  public String a;
  protected String b;
  protected String c;
  public String d;
  
  public static bhtw a()
  {
    try
    {
      if (jdField_a_of_type_Bhtw == null) {
        jdField_a_of_type_Bhtw = new bhtw();
      }
      bhtw localbhtw = jdField_a_of_type_Bhtw;
      return localbhtw;
    }
    finally {}
  }
  
  public ArrayList<bhvp> a()
  {
    int i = 0;
    if (this.jdField_a_of_type_Bibi == null) {
      return new ArrayList(0);
    }
    int j = this.jdField_a_of_type_Bibi.a();
    ArrayList localArrayList = new ArrayList(j);
    while (i < j)
    {
      localArrayList.add((bhvp)this.jdField_a_of_type_Bibi.a(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bhty = null;
    if (this.jdField_a_of_type_Biae != null) {
      this.jdField_a_of_type_Biae.a();
    }
  }
  
  public void a(Bundle paramBundle, bhtz parambhtz, String paramString)
  {
    if ((paramBundle == null) || (parambhtz == null))
    {
      bhzm.e("OpenSdkFriendService", "getFriendListAsync params error. params=" + paramBundle + "; listener=" + parambhtz);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.d = paramString;
    if ("action_invite".equals(paramString))
    {
      paramString = biex.a().a("https://fusion.qq.com/cgi-bin/qzapps/mappinvite_getqqlist.cgi");
      paramBundle.putString("md5str", biew.a(bhpc.a().a(), "invite_friend_list_md5").getString(this.b, ""));
    }
    for (;;)
    {
      this.c = paramString;
      this.jdField_a_of_type_Biae = new biae(paramString, "GET", new bhua(this, parambhtz));
      this.jdField_a_of_type_Biae.a(paramBundle);
      return;
      if ("action_story".equals(paramString))
      {
        paramString = biex.a().a("https://fusion.qq.com/cgi-bin/appstage/mapp_getqqlist.cgi");
        paramBundle.putString("needhttpcache", "nothing");
      }
      else if ("action_voice".equals(paramString))
      {
        paramString = biex.a().a("https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else if ("action_reactive".equals(paramString))
      {
        paramString = biex.a().a("https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else
      {
        paramString = biex.a().a("https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
    }
  }
  
  public void a(String paramString)
  {
    if ("action_invite".equals(this.d))
    {
      SharedPreferences.Editor localEditor = biew.a(bhpc.a().a(), "invite_friend_list_md5").edit();
      localEditor.putString(this.b, paramString);
      localEditor.commit();
    }
  }
  
  public void a(String paramString, Bundle paramBundle, bhty parambhty)
  {
    this.jdField_a_of_type_Bhty = parambhty;
    paramBundle.putString("time", biew.a(bhpc.a().a(), "prefer_last_avatar_update_time").getString(this.b, "0"));
    new biae(paramString, "GET", new bhtx(this)).a(paramBundle);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    for (;;)
    {
      try
      {
        bhzm.e("OpenSdkFriendService", "initData error. appid=" + paramString1 + "; openid=" + paramString2);
        return;
      }
      finally {}
      this.jdField_a_of_type_Long = Long.parseLong(biew.a(bhpc.a().a(), "uin_openid_store").getString(paramString2, ""));
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.b = paramString2;
      try
      {
        this.jdField_a_of_type_Bibi = bibh.a().a(bhvp.class, this.jdField_a_of_type_Long, "invite_friend_list_" + this.b);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void a(List<bhvp> paramList)
  {
    if (this.jdField_a_of_type_Bibi == null) {
      return;
    }
    bhvp[] arrayOfbhvp = new bhvp[paramList.size()];
    paramList.toArray(arrayOfbhvp);
    this.jdField_a_of_type_Bibi.a(arrayOfbhvp, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhtw
 * JD-Core Version:    0.7.0.1
 */