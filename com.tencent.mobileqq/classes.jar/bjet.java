import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class bjet
{
  protected static bjet a;
  protected long a;
  protected Bundle a;
  protected bjev a;
  protected bjlg a;
  protected bjmk a;
  public String a;
  protected String b;
  protected String c;
  public String d;
  
  public static bjet a()
  {
    try
    {
      if (jdField_a_of_type_Bjet == null) {
        jdField_a_of_type_Bjet = new bjet();
      }
      bjet localbjet = jdField_a_of_type_Bjet;
      return localbjet;
    }
    finally {}
  }
  
  public ArrayList<bjgq> a()
  {
    int i = 0;
    if (this.jdField_a_of_type_Bjmk == null) {
      return new ArrayList(0);
    }
    int j = this.jdField_a_of_type_Bjmk.a();
    ArrayList localArrayList = new ArrayList(j);
    while (i < j)
    {
      localArrayList.add((bjgq)this.jdField_a_of_type_Bjmk.a(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bjev = null;
    if (this.jdField_a_of_type_Bjlg != null) {
      this.jdField_a_of_type_Bjlg.a();
    }
  }
  
  public void a(Bundle paramBundle, bjew parambjew, String paramString)
  {
    if ((paramBundle == null) || (parambjew == null))
    {
      bjko.e("OpenSdkFriendService", "getFriendListAsync params error. params=" + paramBundle + "; listener=" + parambjew);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.d = paramString;
    if ("action_invite".equals(paramString))
    {
      paramString = bjpz.a().a("https://fusion.qq.com/cgi-bin/qzapps/mappinvite_getqqlist.cgi");
      paramBundle.putString("md5str", bjpy.a(bizw.a().a(), "invite_friend_list_md5").getString(this.b, ""));
    }
    for (;;)
    {
      this.c = paramString;
      this.jdField_a_of_type_Bjlg = new bjlg(paramString, "GET", new bjex(this, parambjew), true);
      this.jdField_a_of_type_Bjlg.a(paramBundle);
      return;
      if ("action_story".equals(paramString))
      {
        paramString = bjpz.a().a("https://fusion.qq.com/cgi-bin/appstage/mapp_getqqlist.cgi");
        paramBundle.putString("needhttpcache", "nothing");
      }
      else if ("action_voice".equals(paramString))
      {
        paramString = bjpz.a().a("https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else if ("action_reactive".equals(paramString))
      {
        paramString = bjpz.a().a("https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else
      {
        paramString = bjpz.a().a("https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
    }
  }
  
  public void a(String paramString)
  {
    if ("action_invite".equals(this.d))
    {
      SharedPreferences.Editor localEditor = bjpy.a(bizw.a().a(), "invite_friend_list_md5").edit();
      localEditor.putString(this.b, paramString);
      localEditor.commit();
    }
  }
  
  public void a(String paramString, Bundle paramBundle, bjev parambjev)
  {
    this.jdField_a_of_type_Bjev = parambjev;
    paramBundle.putString("time", bjpy.a(bizw.a().a(), "prefer_last_avatar_update_time").getString(this.b, "0"));
    new bjlg(paramString, "GET", new bjeu(this), true).a(paramBundle);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    for (;;)
    {
      try
      {
        bjko.e("OpenSdkFriendService", "initData error. appid=" + paramString1 + "; openid=" + paramString2);
        return;
      }
      finally {}
      this.jdField_a_of_type_Long = Long.parseLong(bjpy.a(bizw.a().a(), "uin_openid_store").getString(paramString2, ""));
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.b = paramString2;
      try
      {
        this.jdField_a_of_type_Bjmk = bjmj.a().a(bjgq.class, this.jdField_a_of_type_Long, "invite_friend_list_" + this.b);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void a(List<bjgq> paramList)
  {
    if (this.jdField_a_of_type_Bjmk == null) {
      return;
    }
    bjgq[] arrayOfbjgq = new bjgq[paramList.size()];
    paramList.toArray(arrayOfbjgq);
    this.jdField_a_of_type_Bjmk.a(arrayOfbjgq, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjet
 * JD-Core Version:    0.7.0.1
 */