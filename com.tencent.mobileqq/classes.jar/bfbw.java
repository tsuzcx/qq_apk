import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class bfbw
{
  protected static bfbw a;
  protected long a;
  protected Bundle a;
  protected bfby a;
  protected bfib a;
  protected bfjk a;
  public String a;
  protected String b;
  protected String c;
  public String d;
  
  public static bfbw a()
  {
    try
    {
      if (jdField_a_of_type_Bfbw == null) {
        jdField_a_of_type_Bfbw = new bfbw();
      }
      bfbw localbfbw = jdField_a_of_type_Bfbw;
      return localbfbw;
    }
    finally {}
  }
  
  public ArrayList<bfdj> a()
  {
    int i = 0;
    if (this.jdField_a_of_type_Bfjk == null) {
      return new ArrayList(0);
    }
    int j = this.jdField_a_of_type_Bfjk.a();
    ArrayList localArrayList = new ArrayList(j);
    while (i < j)
    {
      localArrayList.add((bfdj)this.jdField_a_of_type_Bfjk.a(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bfby = null;
    if (this.jdField_a_of_type_Bfib != null) {
      this.jdField_a_of_type_Bfib.a();
    }
  }
  
  public void a(Bundle paramBundle, bfbz parambfbz, String paramString)
  {
    if ((paramBundle == null) || (parambfbz == null))
    {
      bfhg.e("OpenSdkFriendService", "getFriendListAsync params error. params=" + paramBundle + "; listener=" + parambfbz);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.d = paramString;
    if ("action_invite".equals(paramString))
    {
      paramString = bfmz.a().a("http://fusion.qq.com/cgi-bin/qzapps/mappinvite_getqqlist.cgi");
      paramBundle.putString("md5str", bfmy.a(bexd.a().a(), "invite_friend_list_md5").getString(this.b, ""));
    }
    for (;;)
    {
      this.c = paramString;
      this.jdField_a_of_type_Bfib = new bfib(paramString, "GET", new bfca(this, parambfbz));
      this.jdField_a_of_type_Bfib.a(paramBundle);
      return;
      if ("action_story".equals(paramString))
      {
        paramString = bfmz.a().a("http://fusion.qq.com/cgi-bin/appstage/mapp_getqqlist.cgi");
        paramBundle.putString("needhttpcache", "nothing");
      }
      else if ("action_voice".equals(paramString))
      {
        paramString = bfmz.a().a("http://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else if ("action_reactive".equals(paramString))
      {
        paramString = bfmz.a().a("http://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else
      {
        paramString = bfmz.a().a("http://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
    }
  }
  
  public void a(String paramString)
  {
    if ("action_invite".equals(this.d))
    {
      SharedPreferences.Editor localEditor = bfmy.a(bexd.a().a(), "invite_friend_list_md5").edit();
      localEditor.putString(this.b, paramString);
      localEditor.commit();
    }
  }
  
  public void a(String paramString, Bundle paramBundle, bfby parambfby)
  {
    this.jdField_a_of_type_Bfby = parambfby;
    paramBundle.putString("time", bfmy.a(bexd.a().a(), "prefer_last_avatar_update_time").getString(this.b, "0"));
    new bfib(paramString, "GET", new bfbx(this)).a(paramBundle);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    for (;;)
    {
      try
      {
        bfhg.e("OpenSdkFriendService", "initData error. appid=" + paramString1 + "; openid=" + paramString2);
        return;
      }
      finally {}
      this.jdField_a_of_type_Long = Long.parseLong(bfmy.a(bexd.a().a(), "uin_openid_store").getString(paramString2, ""));
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.b = paramString2;
      try
      {
        this.jdField_a_of_type_Bfjk = bfjf.a().a(bfdj.class, this.jdField_a_of_type_Long, "invite_friend_list_" + this.b);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void a(List<bfdj> paramList)
  {
    if (this.jdField_a_of_type_Bfjk == null) {
      return;
    }
    bfdj[] arrayOfbfdj = new bfdj[paramList.size()];
    paramList.toArray(arrayOfbfdj);
    this.jdField_a_of_type_Bfjk.a(arrayOfbfdj, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfbw
 * JD-Core Version:    0.7.0.1
 */