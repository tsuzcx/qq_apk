import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class bbyj
{
  protected static bbyj a;
  protected long a;
  protected Bundle a;
  protected bbyl a;
  protected bcen a;
  protected bcfx a;
  public String a;
  protected String b;
  protected String c;
  public String d;
  
  public static bbyj a()
  {
    try
    {
      if (jdField_a_of_type_Bbyj == null) {
        jdField_a_of_type_Bbyj = new bbyj();
      }
      bbyj localbbyj = jdField_a_of_type_Bbyj;
      return localbbyj;
    }
    finally {}
  }
  
  public ArrayList<bbzw> a()
  {
    int i = 0;
    if (this.jdField_a_of_type_Bcfx == null) {
      return new ArrayList(0);
    }
    int j = this.jdField_a_of_type_Bcfx.a();
    ArrayList localArrayList = new ArrayList(j);
    while (i < j)
    {
      localArrayList.add((bbzw)this.jdField_a_of_type_Bcfx.a(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bbyl = null;
    if (this.jdField_a_of_type_Bcen != null) {
      this.jdField_a_of_type_Bcen.a();
    }
  }
  
  public void a(Bundle paramBundle, bbym parambbym, String paramString)
  {
    if ((paramBundle == null) || (parambbym == null))
    {
      bcds.e("OpenSdkFriendService", "getFriendListAsync params error. params=" + paramBundle + "; listener=" + parambbym);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.d = paramString;
    if ("action_invite".equals(paramString))
    {
      paramString = bcjm.a().a("http://fusion.qq.com/cgi-bin/qzapps/mappinvite_getqqlist.cgi");
      paramBundle.putString("md5str", bcjl.a(bbtm.a().a(), "invite_friend_list_md5").getString(this.b, ""));
    }
    for (;;)
    {
      this.c = paramString;
      this.jdField_a_of_type_Bcen = new bcen(paramString, "GET", new bbyn(this, parambbym));
      this.jdField_a_of_type_Bcen.a(paramBundle);
      return;
      if ("action_story".equals(paramString))
      {
        paramString = bcjm.a().a("http://fusion.qq.com/cgi-bin/appstage/mapp_getqqlist.cgi");
        paramBundle.putString("needhttpcache", "nothing");
      }
      else if ("action_voice".equals(paramString))
      {
        paramString = bcjm.a().a("http://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else if ("action_reactive".equals(paramString))
      {
        paramString = bcjm.a().a("http://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else
      {
        paramString = bcjm.a().a("http://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
    }
  }
  
  public void a(String paramString)
  {
    if ("action_invite".equals(this.d))
    {
      SharedPreferences.Editor localEditor = bcjl.a(bbtm.a().a(), "invite_friend_list_md5").edit();
      localEditor.putString(this.b, paramString);
      localEditor.commit();
    }
  }
  
  public void a(String paramString, Bundle paramBundle, bbyl parambbyl)
  {
    this.jdField_a_of_type_Bbyl = parambbyl;
    paramBundle.putString("time", bcjl.a(bbtm.a().a(), "prefer_last_avatar_update_time").getString(this.b, "0"));
    new bcen(paramString, "GET", new bbyk(this)).a(paramBundle);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    for (;;)
    {
      try
      {
        bcds.e("OpenSdkFriendService", "initData error. appid=" + paramString1 + "; openid=" + paramString2);
        return;
      }
      finally {}
      this.jdField_a_of_type_Long = Long.parseLong(bcjl.a(bbtm.a().a(), "uin_openid_store").getString(paramString2, ""));
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.b = paramString2;
      try
      {
        this.jdField_a_of_type_Bcfx = bcfs.a().a(bbzw.class, this.jdField_a_of_type_Long, "invite_friend_list_" + this.b);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void a(List<bbzw> paramList)
  {
    if (this.jdField_a_of_type_Bcfx == null) {
      return;
    }
    bbzw[] arrayOfbbzw = new bbzw[paramList.size()];
    paramList.toArray(arrayOfbbzw);
    this.jdField_a_of_type_Bcfx.a(arrayOfbbzw, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbyj
 * JD-Core Version:    0.7.0.1
 */