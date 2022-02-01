import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class bjoi
{
  protected static bjoi a;
  protected long a;
  protected Bundle a;
  protected bjok a;
  protected bjus a;
  protected bjwa a;
  public String a;
  protected String b;
  protected String c;
  public String d;
  
  public static bjoi a()
  {
    try
    {
      if (jdField_a_of_type_Bjoi == null) {
        jdField_a_of_type_Bjoi = new bjoi();
      }
      bjoi localbjoi = jdField_a_of_type_Bjoi;
      return localbjoi;
    }
    finally {}
  }
  
  public ArrayList<bjqa> a()
  {
    int i = 0;
    if (this.jdField_a_of_type_Bjwa == null) {
      return new ArrayList(0);
    }
    int j = this.jdField_a_of_type_Bjwa.a();
    ArrayList localArrayList = new ArrayList(j);
    while (i < j)
    {
      localArrayList.add((bjqa)this.jdField_a_of_type_Bjwa.a(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bjok = null;
    if (this.jdField_a_of_type_Bjus != null) {
      this.jdField_a_of_type_Bjus.a();
    }
  }
  
  public void a(Bundle paramBundle, bjol parambjol, String paramString)
  {
    if ((paramBundle == null) || (parambjol == null))
    {
      bjtx.e("OpenSdkFriendService", "getFriendListAsync params error. params=" + paramBundle + "; listener=" + parambjol);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.d = paramString;
    if ("action_invite".equals(paramString))
    {
      paramString = bjzn.a().a("https://fusion.qq.com/cgi-bin/qzapps/mappinvite_getqqlist.cgi");
      paramBundle.putString("md5str", bjzm.a(bjjo.a().a(), "invite_friend_list_md5").getString(this.b, ""));
    }
    for (;;)
    {
      this.c = paramString;
      this.jdField_a_of_type_Bjus = new bjus(paramString, "GET", new bjom(this, parambjol));
      this.jdField_a_of_type_Bjus.a(paramBundle);
      return;
      if ("action_story".equals(paramString))
      {
        paramString = bjzn.a().a("https://fusion.qq.com/cgi-bin/appstage/mapp_getqqlist.cgi");
        paramBundle.putString("needhttpcache", "nothing");
      }
      else if ("action_voice".equals(paramString))
      {
        paramString = bjzn.a().a("https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else if ("action_reactive".equals(paramString))
      {
        paramString = bjzn.a().a("https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else
      {
        paramString = bjzn.a().a("https://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
    }
  }
  
  public void a(String paramString)
  {
    if ("action_invite".equals(this.d))
    {
      SharedPreferences.Editor localEditor = bjzm.a(bjjo.a().a(), "invite_friend_list_md5").edit();
      localEditor.putString(this.b, paramString);
      localEditor.commit();
    }
  }
  
  public void a(String paramString, Bundle paramBundle, bjok parambjok)
  {
    this.jdField_a_of_type_Bjok = parambjok;
    paramBundle.putString("time", bjzm.a(bjjo.a().a(), "prefer_last_avatar_update_time").getString(this.b, "0"));
    new bjus(paramString, "GET", new bjoj(this)).a(paramBundle);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    for (;;)
    {
      try
      {
        bjtx.e("OpenSdkFriendService", "initData error. appid=" + paramString1 + "; openid=" + paramString2);
        return;
      }
      finally {}
      this.jdField_a_of_type_Long = Long.parseLong(bjzm.a(bjjo.a().a(), "uin_openid_store").getString(paramString2, ""));
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.b = paramString2;
      try
      {
        this.jdField_a_of_type_Bjwa = bjvv.a().a(bjqa.class, this.jdField_a_of_type_Long, "invite_friend_list_" + this.b);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void a(List<bjqa> paramList)
  {
    if (this.jdField_a_of_type_Bjwa == null) {
      return;
    }
    bjqa[] arrayOfbjqa = new bjqa[paramList.size()];
    paramList.toArray(arrayOfbjqa);
    this.jdField_a_of_type_Bjwa.a(arrayOfbjqa, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjoi
 * JD-Core Version:    0.7.0.1
 */