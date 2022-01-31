import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class bfgf
{
  protected static bfgf a;
  protected long a;
  protected Bundle a;
  protected bfgh a;
  protected bfmk a;
  protected bfnt a;
  public String a;
  protected String b;
  protected String c;
  public String d;
  
  public static bfgf a()
  {
    try
    {
      if (jdField_a_of_type_Bfgf == null) {
        jdField_a_of_type_Bfgf = new bfgf();
      }
      bfgf localbfgf = jdField_a_of_type_Bfgf;
      return localbfgf;
    }
    finally {}
  }
  
  public ArrayList<bfhs> a()
  {
    int i = 0;
    if (this.jdField_a_of_type_Bfnt == null) {
      return new ArrayList(0);
    }
    int j = this.jdField_a_of_type_Bfnt.a();
    ArrayList localArrayList = new ArrayList(j);
    while (i < j)
    {
      localArrayList.add((bfhs)this.jdField_a_of_type_Bfnt.a(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bfgh = null;
    if (this.jdField_a_of_type_Bfmk != null) {
      this.jdField_a_of_type_Bfmk.a();
    }
  }
  
  public void a(Bundle paramBundle, bfgi parambfgi, String paramString)
  {
    if ((paramBundle == null) || (parambfgi == null))
    {
      bflp.e("OpenSdkFriendService", "getFriendListAsync params error. params=" + paramBundle + "; listener=" + parambfgi);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.d = paramString;
    if ("action_invite".equals(paramString))
    {
      paramString = bfri.a().a("http://fusion.qq.com/cgi-bin/qzapps/mappinvite_getqqlist.cgi");
      paramBundle.putString("md5str", bfrh.a(bfbm.a().a(), "invite_friend_list_md5").getString(this.b, ""));
    }
    for (;;)
    {
      this.c = paramString;
      this.jdField_a_of_type_Bfmk = new bfmk(paramString, "GET", new bfgj(this, parambfgi));
      this.jdField_a_of_type_Bfmk.a(paramBundle);
      return;
      if ("action_story".equals(paramString))
      {
        paramString = bfri.a().a("http://fusion.qq.com/cgi-bin/appstage/mapp_getqqlist.cgi");
        paramBundle.putString("needhttpcache", "nothing");
      }
      else if ("action_voice".equals(paramString))
      {
        paramString = bfri.a().a("http://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else if ("action_reactive".equals(paramString))
      {
        paramString = bfri.a().a("http://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else
      {
        paramString = bfri.a().a("http://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
    }
  }
  
  public void a(String paramString)
  {
    if ("action_invite".equals(this.d))
    {
      SharedPreferences.Editor localEditor = bfrh.a(bfbm.a().a(), "invite_friend_list_md5").edit();
      localEditor.putString(this.b, paramString);
      localEditor.commit();
    }
  }
  
  public void a(String paramString, Bundle paramBundle, bfgh parambfgh)
  {
    this.jdField_a_of_type_Bfgh = parambfgh;
    paramBundle.putString("time", bfrh.a(bfbm.a().a(), "prefer_last_avatar_update_time").getString(this.b, "0"));
    new bfmk(paramString, "GET", new bfgg(this)).a(paramBundle);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    for (;;)
    {
      try
      {
        bflp.e("OpenSdkFriendService", "initData error. appid=" + paramString1 + "; openid=" + paramString2);
        return;
      }
      finally {}
      this.jdField_a_of_type_Long = Long.parseLong(bfrh.a(bfbm.a().a(), "uin_openid_store").getString(paramString2, ""));
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.b = paramString2;
      try
      {
        this.jdField_a_of_type_Bfnt = bfno.a().a(bfhs.class, this.jdField_a_of_type_Long, "invite_friend_list_" + this.b);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void a(List<bfhs> paramList)
  {
    if (this.jdField_a_of_type_Bfnt == null) {
      return;
    }
    bfhs[] arrayOfbfhs = new bfhs[paramList.size()];
    paramList.toArray(arrayOfbfhs);
    this.jdField_a_of_type_Bfnt.a(arrayOfbfhs, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfgf
 * JD-Core Version:    0.7.0.1
 */