import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class binj
{
  protected static binj a;
  protected long a;
  protected Bundle a;
  protected binl a;
  protected bitt a;
  protected bivb a;
  public String a;
  protected String b;
  protected String c;
  public String d;
  
  public static binj a()
  {
    try
    {
      if (jdField_a_of_type_Binj == null) {
        jdField_a_of_type_Binj = new binj();
      }
      binj localbinj = jdField_a_of_type_Binj;
      return localbinj;
    }
    finally {}
  }
  
  public ArrayList<bipb> a()
  {
    int i = 0;
    if (this.jdField_a_of_type_Bivb == null) {
      return new ArrayList(0);
    }
    int j = this.jdField_a_of_type_Bivb.a();
    ArrayList localArrayList = new ArrayList(j);
    while (i < j)
    {
      localArrayList.add((bipb)this.jdField_a_of_type_Bivb.a(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Binl = null;
    if (this.jdField_a_of_type_Bitt != null) {
      this.jdField_a_of_type_Bitt.a();
    }
  }
  
  public void a(Bundle paramBundle, binm parambinm, String paramString)
  {
    if ((paramBundle == null) || (parambinm == null))
    {
      bisy.e("OpenSdkFriendService", "getFriendListAsync params error. params=" + paramBundle + "; listener=" + parambinm);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.d = paramString;
    if ("action_invite".equals(paramString))
    {
      paramString = biyo.a().a("https://fusion.qq.com/cgi-bin/qzapps/mappinvite_getqqlist.cgi");
      paramBundle.putString("md5str", biyn.a(biip.a().a(), "invite_friend_list_md5").getString(this.b, ""));
    }
    for (;;)
    {
      this.c = paramString;
      this.jdField_a_of_type_Bitt = new bitt(paramString, "GET", new binn(this, parambinm));
      this.jdField_a_of_type_Bitt.a(paramBundle);
      return;
      if ("action_story".equals(paramString))
      {
        paramString = biyo.a().a("https://fusion.qq.com/cgi-bin/appstage/mapp_getqqlist.cgi");
        paramBundle.putString("needhttpcache", "nothing");
      }
      else if ("action_voice".equals(paramString))
      {
        paramString = biyo.a().a("https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else if ("action_reactive".equals(paramString))
      {
        paramString = biyo.a().a("https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else
      {
        paramString = biyo.a().a("https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
    }
  }
  
  public void a(String paramString)
  {
    if ("action_invite".equals(this.d))
    {
      SharedPreferences.Editor localEditor = biyn.a(biip.a().a(), "invite_friend_list_md5").edit();
      localEditor.putString(this.b, paramString);
      localEditor.commit();
    }
  }
  
  public void a(String paramString, Bundle paramBundle, binl parambinl)
  {
    this.jdField_a_of_type_Binl = parambinl;
    paramBundle.putString("time", biyn.a(biip.a().a(), "prefer_last_avatar_update_time").getString(this.b, "0"));
    new bitt(paramString, "GET", new bink(this)).a(paramBundle);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    for (;;)
    {
      try
      {
        bisy.e("OpenSdkFriendService", "initData error. appid=" + paramString1 + "; openid=" + paramString2);
        return;
      }
      finally {}
      this.jdField_a_of_type_Long = Long.parseLong(biyn.a(biip.a().a(), "uin_openid_store").getString(paramString2, ""));
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.b = paramString2;
      try
      {
        this.jdField_a_of_type_Bivb = biuw.a().a(bipb.class, this.jdField_a_of_type_Long, "invite_friend_list_" + this.b);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void a(List<bipb> paramList)
  {
    if (this.jdField_a_of_type_Bivb == null) {
      return;
    }
    bipb[] arrayOfbipb = new bipb[paramList.size()];
    paramList.toArray(arrayOfbipb);
    this.jdField_a_of_type_Bivb.a(arrayOfbipb, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     binj
 * JD-Core Version:    0.7.0.1
 */