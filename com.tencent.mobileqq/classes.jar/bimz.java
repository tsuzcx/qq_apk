import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.webview.WebViewAioShareMusicHelper.1;
import com.tencent.mobileqq.webview.WebViewAioShareMusicHelper.2;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bimz
{
  private int jdField_a_of_type_Int;
  private WebViewFragment jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  
  public bimz(WebViewFragment paramWebViewFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = paramWebViewFragment;
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
      QQToast.a(BaseApplicationImpl.getApplication(), paramString, 1).a();
    }
  }
  
  private boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mApp.getAccount().equals(this.jdField_d_of_type_JavaLangString));
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mApp.getEntityManagerFactory(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mApp.getAccount()).createEntityManager();
    paramString = (TroopInfo)localEntityManager.find(TroopInfo.class, paramString);
    localEntityManager.close();
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, " isTroopAdminOrOwner() troopInfo = " + paramString.isAdmin());
      }
      if ((paramString.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mApp.getAccount())) || (paramString.isAdmin())) {
        return true;
      }
    }
    return false;
  }
  
  private void b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getActivity() != null)) {
      bhlq.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getActivity(), 230).setMessage(paramString).setPositiveButton(2131693426, new bina(this)).show();
    }
  }
  
  private void c(Intent paramIntent)
  {
    int i = 2;
    Object localObject1 = paramIntent.getStringExtra("forward_ark_app_meta");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1).getJSONObject("music");
        Object localObject3 = paramIntent.getExtras();
        if (this.jdField_a_of_type_Int == 0)
        {
          paramIntent = "friend_uin";
          Object localObject2 = ((Bundle)localObject3).getString(paramIntent, "");
          if (this.jdField_a_of_type_Int == 0)
          {
            paramIntent = "h5_ark_url_web_sender_uin";
            paramIntent = ((Bundle)localObject3).getString(paramIntent);
            int j = ((JSONObject)localObject1).getInt("appid");
            Object localObject4 = ((JSONObject)localObject1).getString("title");
            localObject3 = ((JSONObject)localObject1).getString("musicUrl");
            localObject1 = ((JSONObject)localObject1).getString("desc");
            JSONObject localJSONObject = new JSONObject();
            if (this.jdField_a_of_type_Int == 0)
            {
              localJSONObject.put("enum_aio_type", i);
              localJSONObject.put("uint64_id", localObject2);
              localJSONObject.put("uint32_share_appid", j);
              localJSONObject.put("bytes_song_name", localObject4);
              localObject2 = new JSONArray();
              localObject4 = new JSONObject();
              ((JSONObject)localObject4).put("singer", localObject1);
              ((JSONArray)localObject2).put(localObject4);
              localJSONObject.put("rpt_bytes_singer", localObject2);
              localJSONObject.put("bytes_song_url", localObject3);
              localJSONObject.put("bool_cut_song", this.jdField_a_of_type_Boolean);
              localJSONObject.put("str_song_id", this.jdField_c_of_type_JavaLangString);
              localJSONObject.put("uint32_duration", this.jdField_b_of_type_Int);
              localJSONObject.put("uint64_sharer_uin", paramIntent);
              localJSONObject.put("bytes_cover", this.jdField_b_of_type_JavaLangString);
              if (QLog.isColorLevel()) {
                QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, "realStartAioShareMusic() jsonObject = " + localJSONObject.toString());
              }
              lbe.a(localJSONObject, "startListenAioShareMusic", null);
            }
          }
          else
          {
            paramIntent = "friendUin";
            continue;
          }
          i = 1;
          continue;
          return;
        }
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
      }
      paramIntent = "groupUin";
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = null;
  }
  
  public void a(Intent paramIntent)
  {
    int i = 2;
    if (paramIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, " checkAndShowAioShareMusic inten is null ");
      }
    }
    String str;
    do
    {
      do
      {
        return;
        str = paramIntent.getStringExtra("forward_ark_app_view");
        this.jdField_a_of_type_Int = paramIntent.getIntExtra("uinType", 0);
        if (("music".equalsIgnoreCase(str)) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, " type is not music just return, ShareType = " + str + " mAioType = " + this.jdField_a_of_type_Int);
      return;
      str = paramIntent.getStringExtra("forward_ark_app_meta");
    } while (TextUtils.isEmpty(str));
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(str).getJSONObject("music");
        if (this.jdField_a_of_type_Int == 0)
        {
          str = "friend_uin";
          Object localObject1 = paramIntent.getStringExtra(str);
          int j = localJSONObject.getInt("appid");
          Object localObject2 = localJSONObject.getString("title");
          paramIntent = localJSONObject.getString("musicUrl");
          str = localJSONObject.getString("desc");
          this.jdField_b_of_type_JavaLangString = localJSONObject.getString("preview");
          localJSONObject = new JSONObject();
          if (this.jdField_a_of_type_Int != 0) {
            break label390;
          }
          localJSONObject.put("enum_aio_type", i);
          localJSONObject.put("uint64_id", localObject1);
          localJSONObject.put("uint32_share_appid", j);
          localJSONObject.put("bytes_song_name", localObject2);
          localJSONObject.put("uint32_duration", 0);
          localObject1 = new JSONArray();
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("singer", str);
          ((JSONArray)localObject1).put(localObject2);
          localJSONObject.put("rpt_bytes_singer", localObject1);
          localJSONObject.put("bytes_song_url", paramIntent);
          if (QLog.isColorLevel()) {
            QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, " type is music jsonObject = " + localJSONObject.toString());
          }
          lbe.a(localJSONObject, "checkAioShareMusic", null);
          return;
        }
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
      str = "groupUin";
      continue;
      label390:
      i = 1;
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = paramJSONObject.getBoolean("isSuccess");
      if (QLog.isColorLevel()) {
        QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, "handleCheckAioShareMusic() isSuccess = " + bool + " data = " + paramJSONObject.toString());
      }
      if (bool)
      {
        bool = paramJSONObject.getBoolean("bool_show_icon");
        this.jdField_c_of_type_Int = paramJSONObject.getInt("enum_aio_state");
        this.jdField_d_of_type_Int = paramJSONObject.getInt("enum_media_type");
        this.jdField_c_of_type_JavaLangString = paramJSONObject.getString("str_song_id");
        this.jdField_b_of_type_Int = paramJSONObject.getInt("uint32_duration");
        this.jdField_d_of_type_JavaLangString = String.valueOf(paramJSONObject.getLong("uint64_create_uin"));
        this.jdField_b_of_type_Boolean = paramJSONObject.getBoolean("bool_song_existed");
        this.jdField_c_of_type_Boolean = paramJSONObject.getBoolean("bool_allow_member_start");
        this.jdField_d_of_type_Boolean = paramJSONObject.getBoolean("bool_allow_member_add");
        this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("current_song_id");
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getActivity() != null)) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getActivity().runOnUiThread(new WebViewAioShareMusicHelper.1(this, bool));
        }
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public void b(Intent paramIntent)
  {
    if ((paramIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, " checkAndShowAioShareMusic inten is null ");
      }
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    String str4 = paramIntent.getStringExtra("groupUin");
    String str1;
    String str2;
    label64:
    String str3;
    if (this.jdField_a_of_type_Int == 0)
    {
      str1 = "c2c_AIO";
      if (this.jdField_a_of_type_Int != 0) {
        break label168;
      }
      str2 = "clk_share_c2c";
      if (this.jdField_a_of_type_Int != 0) {
        break label176;
      }
      str3 = "";
      label75:
      bdll.b(null, "dc00899", str1, "", "music_tab", str2, 0, 0, str3, "", "", "");
      if ((this.jdField_d_of_type_Int == 1) || (this.jdField_c_of_type_Int == 3)) {
        break label197;
      }
      if (this.jdField_d_of_type_Int != 2) {
        break label183;
      }
    }
    label168:
    label176:
    label183:
    for (paramIntent = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131697848);; paramIntent = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131697824))
    {
      a(String.format(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131693292), new Object[] { paramIntent }));
      return;
      str1 = "Grp_AIO";
      break;
      str2 = "clk_share_grp";
      break label64;
      str3 = str4;
      break label75;
    }
    label197:
    if ((this.jdField_c_of_type_Int != 3) && (this.jdField_a_of_type_JavaLangString.equals(this.jdField_c_of_type_JavaLangString)))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131693290));
      return;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      boolean bool = a(str4);
      if ((this.jdField_c_of_type_Int == 3) && (!bool) && (!this.jdField_c_of_type_Boolean))
      {
        b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131693288));
        return;
      }
      if ((this.jdField_c_of_type_Int == 3) && (!bool) && (this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
      {
        b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131693289));
        return;
      }
      if ((this.jdField_c_of_type_Int != 3) && (!bool) && (!this.jdField_d_of_type_Boolean))
      {
        b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131693287));
        return;
      }
      if ((this.jdField_c_of_type_Int != 3) && (!a()) && (!bool) && (this.jdField_d_of_type_Boolean))
      {
        if (this.jdField_b_of_type_Boolean)
        {
          a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131693291));
          return;
        }
        this.jdField_a_of_type_Boolean = false;
      }
    }
    c(paramIntent);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    for (;;)
    {
      String str;
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment == null) || (paramJSONObject == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getActivity() == null))
        {
          if (!QLog.isColorLevel()) {
            break label339;
          }
          QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, "handleCheckAioShareMusic()  data  = " + paramJSONObject + " mWebViewFragment = " + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment);
          return;
        }
        boolean bool = paramJSONObject.getBoolean("isSuccess");
        if (bool) {
          break label304;
        }
        int i = paramJSONObject.getInt("uint32_result");
        str = paramJSONObject.getString("bytes_errmsg");
        if (!TextUtils.isEmpty(str)) {}
        switch (i)
        {
        case 0: 
          if (!QLog.isColorLevel()) {
            break label339;
          }
          QLog.d("AioShareMusic.WebViewAioShareMusicHelper", 2, "handleCheckAioShareMusic() isSuccess = " + bool + " data = " + paramJSONObject.toString());
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131694175));
      continue;
      a(String.format(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131693292), new Object[] { str }));
      continue;
      a(str);
      continue;
      b(str);
      continue;
      label304:
      a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getString(2131693291));
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getActivity().runOnUiThread(new WebViewAioShareMusicHelper.2(this));
      continue;
      label339:
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bimz
 * JD-Core Version:    0.7.0.1
 */