import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class bdcj
{
  protected static bdcj a;
  protected long a;
  protected Bundle a;
  protected bdcl a;
  protected bdio a;
  protected bdjy a;
  public String a;
  protected String b;
  protected String c;
  public String d;
  
  public static bdcj a()
  {
    try
    {
      if (jdField_a_of_type_Bdcj == null) {
        jdField_a_of_type_Bdcj = new bdcj();
      }
      bdcj localbdcj = jdField_a_of_type_Bdcj;
      return localbdcj;
    }
    finally {}
  }
  
  public ArrayList<bddw> a()
  {
    int i = 0;
    if (this.jdField_a_of_type_Bdjy == null) {
      return new ArrayList(0);
    }
    int j = this.jdField_a_of_type_Bdjy.a();
    ArrayList localArrayList = new ArrayList(j);
    while (i < j)
    {
      localArrayList.add((bddw)this.jdField_a_of_type_Bdjy.a(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bdcl = null;
    if (this.jdField_a_of_type_Bdio != null) {
      this.jdField_a_of_type_Bdio.a();
    }
  }
  
  public void a(Bundle paramBundle, bdcm parambdcm, String paramString)
  {
    if ((paramBundle == null) || (parambdcm == null))
    {
      bdht.e("OpenSdkFriendService", "getFriendListAsync params error. params=" + paramBundle + "; listener=" + parambdcm);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.d = paramString;
    if ("action_invite".equals(paramString))
    {
      paramString = bdnn.a().a("http://fusion.qq.com/cgi-bin/qzapps/mappinvite_getqqlist.cgi");
      paramBundle.putString("md5str", bdnm.a(bcxm.a().a(), "invite_friend_list_md5").getString(this.b, ""));
    }
    for (;;)
    {
      this.c = paramString;
      this.jdField_a_of_type_Bdio = new bdio(paramString, "GET", new bdcn(this, parambdcm));
      this.jdField_a_of_type_Bdio.a(paramBundle);
      return;
      if ("action_story".equals(paramString))
      {
        paramString = bdnn.a().a("http://fusion.qq.com/cgi-bin/appstage/mapp_getqqlist.cgi");
        paramBundle.putString("needhttpcache", "nothing");
      }
      else if ("action_voice".equals(paramString))
      {
        paramString = bdnn.a().a("http://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else if ("action_reactive".equals(paramString))
      {
        paramString = bdnn.a().a("http://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else
      {
        paramString = bdnn.a().a("http://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
    }
  }
  
  public void a(String paramString)
  {
    if ("action_invite".equals(this.d))
    {
      SharedPreferences.Editor localEditor = bdnm.a(bcxm.a().a(), "invite_friend_list_md5").edit();
      localEditor.putString(this.b, paramString);
      localEditor.commit();
    }
  }
  
  public void a(String paramString, Bundle paramBundle, bdcl parambdcl)
  {
    this.jdField_a_of_type_Bdcl = parambdcl;
    paramBundle.putString("time", bdnm.a(bcxm.a().a(), "prefer_last_avatar_update_time").getString(this.b, "0"));
    new bdio(paramString, "GET", new bdck(this)).a(paramBundle);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    for (;;)
    {
      try
      {
        bdht.e("OpenSdkFriendService", "initData error. appid=" + paramString1 + "; openid=" + paramString2);
        return;
      }
      finally {}
      this.jdField_a_of_type_Long = Long.parseLong(bdnm.a(bcxm.a().a(), "uin_openid_store").getString(paramString2, ""));
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.b = paramString2;
      try
      {
        this.jdField_a_of_type_Bdjy = bdjt.a().a(bddw.class, this.jdField_a_of_type_Long, "invite_friend_list_" + this.b);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void a(List<bddw> paramList)
  {
    if (this.jdField_a_of_type_Bdjy == null) {
      return;
    }
    bddw[] arrayOfbddw = new bddw[paramList.size()];
    paramList.toArray(arrayOfbddw);
    this.jdField_a_of_type_Bdjy.a(arrayOfbddw, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdcj
 * JD-Core Version:    0.7.0.1
 */