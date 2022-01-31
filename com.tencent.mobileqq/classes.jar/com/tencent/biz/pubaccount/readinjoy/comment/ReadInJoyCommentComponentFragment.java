package com.tencent.biz.pubaccount.readinjoy.comment;

import aezn;
import aezv;
import afae;
import ajyc;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anyb;
import aqzc;
import arbi;
import axas;
import ayvv;
import ayvz;
import bbca;
import bbev;
import bcpq;
import bcpw;
import bfmt;
import bfxd;
import bhvh;
import com.tencent.biz.pubaccount.readinjoy.biu.AtFriendsSpan;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuEditText;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuNicknameSpan;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import noo;
import ogc;
import ogd;
import oge;
import ogf;
import ogg;
import ogh;
import ogi;
import ogj;
import ogk;
import olc;
import omm;
import onk;
import ooc;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qcj;
import qcy;
import qgr;
import rap;
import rgc;

public class ReadInJoyCommentComponentFragment
  extends PublicBaseFragment
  implements aezv, Handler.Callback, View.OnClickListener
{
  protected int a;
  private afae jdField_a_of_type_Afae;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private Editable.Factory jdField_a_of_type_AndroidTextEditable$Factory = new ogf(this);
  protected TextWatcher a;
  public ViewGroup.LayoutParams a;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  protected Button a;
  public FrameLayout a;
  public ImageView a;
  protected LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  private anyb jdField_a_of_type_Anyb = new ogh(this);
  private arbi jdField_a_of_type_Arbi = new ogi(this);
  ayvz jdField_a_of_type_Ayvz = new oge(this);
  protected bcpq a;
  private bfxd jdField_a_of_type_Bfxd = new ogg(this);
  public BiuEditText a;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  public EmoticonMainPanel a;
  public HotPicData a;
  public PublicAccountHotPicPanel a;
  public XPanelContainer a;
  private String jdField_a_of_type_JavaLangString;
  public final MqqHandler a;
  protected boolean a;
  protected int b;
  protected ImageView b;
  protected RelativeLayout b;
  protected TextView b;
  private String b;
  protected boolean b;
  public int c;
  protected ImageView c;
  protected RelativeLayout c;
  private String c;
  public boolean c;
  protected int d;
  protected ImageView d;
  private String d;
  public boolean d;
  protected int e;
  protected ImageView e;
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean;
  public int f;
  public ImageView f;
  private boolean f;
  public int g;
  protected ImageView g;
  private boolean g;
  private int jdField_h_of_type_Int = -1;
  protected ImageView h;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = 1;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int = 1;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean;
  private boolean m;
  
  public ReadInJoyCommentComponentFragment()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = omm.jdField_b_of_type_Int;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_MqqOsMqqHandler = new bfmt(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_AndroidTextTextWatcher = new ogc(this);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new ogd(this);
    this.jdField_d_of_type_JavaLangString = "";
  }
  
  private aezn a()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app == null)) {}
    Object localObject;
    do
    {
      Bundle localBundle;
      do
      {
        return null;
        localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
        localBundle = getArguments();
      } while (((localBundle != null) && (!localBundle.getBoolean("arg_comment_zhitu_switch", true))) || (bhvh.m((AppRuntime)localObject) != 0));
      localObject = aezn.a((AppInterface)localObject);
    } while ((localObject == null) || (!((aezn)localObject).e()));
    return localObject;
  }
  
  private Intent a()
  {
    int n = 1;
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    JSONObject localJSONObject1 = new JSONObject();
    label974:
    for (;;)
    {
      try
      {
        localJSONObject1.put("isAnonymous", this.jdField_b_of_type_Boolean);
        localJSONObject1.put("comment", new String(bbca.encode(a().getBytes(), 0)));
        Object localObject1;
        Object localObject3;
        Object localObject4;
        ogk localogk;
        JSONObject localJSONObject2;
        if ((this.jdField_a_of_type_Afae != null) || (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null))
        {
          localJSONObject1.put("biuAfterComment", 0);
          if (this.jdField_k_of_type_Boolean)
          {
            if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
              continue;
            }
            localObject1 = "";
            localJSONObject1.put("replyUin", localObject1);
            localJSONObject1.put("isSecondReply", this.jdField_l_of_type_Boolean);
            localJSONObject1.put("commentId", this.jdField_b_of_type_JavaLangString);
            localJSONObject1.put("commentUin", this.jdField_c_of_type_JavaLangString);
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localObject1 = a();
            if (localObject1 != null) {
              localJSONObject1.put("biu_info", localObject1);
            }
          }
          if ((!this.jdField_f_of_type_Boolean) || (TextUtils.isEmpty(a()))) {
            continue;
          }
          localObject3 = new ArrayList();
          a((ArrayList)localObject3);
          if (((ArrayList)localObject3).size() <= 0) {
            continue;
          }
          localObject4 = new JSONArray();
          n = ((ArrayList)localObject3).size() - 1;
          if (n < 0) {
            continue;
          }
          localogk = (ogk)((ArrayList)localObject3).get(n);
          localJSONObject2 = new JSONObject();
        }
        try
        {
          localJSONObject2.put("uin", Long.valueOf(localogk.jdField_a_of_type_JavaLangString));
          localObject1 = "";
          if (TextUtils.isEmpty(localogk.jdField_a_of_type_JavaLangCharSequence)) {
            localogk.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
          }
          if (localogk.jdField_a_of_type_JavaLangCharSequence != null) {
            localObject1 = localogk.jdField_a_of_type_JavaLangCharSequence.toString();
          }
          localJSONObject2.put("nick", new String(bbca.encode(((String)localObject1).getBytes(), 0)));
          localObject1 = "";
          if (localogk.b != null) {
            localObject1 = localogk.b.toString();
          }
          localJSONObject2.put("comment", new String(bbca.encode(((String)localObject1).getBytes(), 0)));
          localJSONObject2.put("op_type", localogk.jdField_a_of_type_Int);
          ((JSONArray)localObject4).put(localJSONObject2);
          n -= 1;
          continue;
          if (!this.jdField_a_of_type_Boolean) {
            break label974;
          }
          localJSONObject1.put("biuAfterComment", n);
          continue;
          localObject1 = this.jdField_a_of_type_JavaLangString;
        }
        catch (Exception localException)
        {
          localJSONObject2.put("uin", 0L);
          continue;
        }
        localJSONObject1.put("commentAtLevel", localObject4);
        if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null)
        {
          localObject2 = new JSONArray();
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("picType", 3);
          ((JSONObject)localObject3).put("url", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.originalUrl);
          ((JSONObject)localObject3).put("md5", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.originalMD5);
          ((JSONObject)localObject3).put("width", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.originalWidth);
          ((JSONObject)localObject3).put("height", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.originalHeight);
          ((JSONObject)localObject3).put("thumbnail_url", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.url);
          ((JSONObject)localObject3).put("thumbnail_md5", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.md5);
          ((JSONObject)localObject3).put("thumbnail_width", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.width);
          ((JSONObject)localObject3).put("thumbnail_height", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData.height);
          ((JSONArray)localObject2).put(localObject3);
          localJSONObject1.put("picInfoList", localObject2);
        }
        if ((this.jdField_a_of_type_Afae != null) && (this.jdField_a_of_type_Afae.jdField_c_of_type_Boolean))
        {
          localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
          BitmapFactory.decodeFile(this.jdField_a_of_type_Afae.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject2);
          localObject3 = new JSONArray();
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("picType", 3);
          ((JSONObject)localObject4).put("url", this.jdField_a_of_type_Afae.f);
          ((JSONObject)localObject4).put("md5", this.jdField_a_of_type_Afae.g);
          ((JSONObject)localObject4).put("width", ((BitmapFactory.Options)localObject2).outWidth);
          ((JSONObject)localObject4).put("height", ((BitmapFactory.Options)localObject2).outHeight);
          ((JSONObject)localObject4).put("thumbnail_url", this.jdField_a_of_type_Afae.f);
          ((JSONObject)localObject4).put("thumbnail_md5", this.jdField_a_of_type_Afae.g);
          ((JSONObject)localObject4).put("thumbnail_width", ((BitmapFactory.Options)localObject2).outWidth);
          ((JSONObject)localObject4).put("thumbnail_height", ((BitmapFactory.Options)localObject2).outHeight);
          ((JSONArray)localObject3).put(localObject4);
          localJSONObject1.put("picInfoList", localObject3);
        }
        Object localObject2 = localJSONObject1.toString();
        ReadInJoyUserInfoModule.a(Long.parseLong(onk.a()), null);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentComponentFragment", 2, "finish resultJson=" + (String)localObject2);
        }
        localIntent.putExtra("arg_result_json", (String)localObject2);
        localIntent.putExtra("comment_articleid", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        localIntent.putExtra("comment_gallery_channel", this.jdField_h_of_type_Boolean);
        localIntent.putExtra("comment_cmd", this.jdField_k_of_type_Int);
        if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
        {
          n = 2;
          localIntent.putExtra("click_comment_edit_src", n);
          return localIntent;
        }
        n = 3;
        continue;
        n = 0;
      }
      catch (JSONException localJSONException)
      {
        return localIntent;
      }
    }
  }
  
  private String a(boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", onk.jdField_d_of_type_Int);
      if (paramBoolean) {
        if (!this.jdField_a_of_type_Boolean) {
          break label48;
        }
      }
      label48:
      for (String str = "0";; str = "1")
      {
        localJSONObject.put("biu_comment", str);
        return localJSONObject.toString();
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private boolean a()
  {
    return bhvh.u(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app) == 1;
  }
  
  private void b(int paramInt)
  {
    int i2 = 2130848393;
    this.jdField_a_of_type_Int = paramInt;
    int i1 = 2130842393;
    int n;
    if (paramInt == 1)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1)) {
        break label204;
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      paramInt = 2130842391;
      n = i1;
    }
    for (;;)
    {
      if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(paramInt);
      }
      if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(n);
      }
      return;
      if (paramInt == 2)
      {
        n = i1;
        paramInt = i2;
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
        {
          n = i1;
          paramInt = i2;
          if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 3)
          {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
            n = i1;
            paramInt = i2;
          }
        }
      }
      else
      {
        if (paramInt == 3)
        {
          if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 24))
          {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(24);
            n = 2130848393;
            paramInt = 2130842391;
          }
        }
        else
        {
          if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)) {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
          }
          label204:
          paramInt = 2130842391;
          n = i1;
          continue;
        }
        n = 2130848393;
        paramInt = 2130842391;
      }
    }
  }
  
  private void c(int paramInt)
  {
    this.jdField_k_of_type_Int = paramInt;
  }
  
  private void c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains(getString(2131718359)))) {}
    for (int n = 2;; n = 1)
    {
      paramString = "";
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("folder_status", onk.jdField_d_of_type_Int);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
          ((JSONObject)localObject).put("consume_time", ooc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, false) / 1000L);
        }
        localObject = ((JSONObject)localObject).toString();
        paramString = (String)localObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      noo.a(null, "", "0X800844A", "0X800844A", 0, 0, String.valueOf(n), String.valueOf(this.jdField_e_of_type_Int), "", paramString, false);
      return;
    }
  }
  
  private void g()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null) {
      return;
    }
    if (localBundle.getBoolean("arg_comment_enable_anonymous", false)) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_g_of_type_Boolean = localBundle.getBoolean("comment_can_biu", true);
    String str1 = localBundle.getString("arg_comment_placeholder", "");
    if (!TextUtils.isEmpty(str1)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setHint(str1);
    }
    label93:
    SpannableStringBuilder localSpannableStringBuilder;
    for (;;)
    {
      int n = localBundle.getInt("arg_comment_max_length", -1);
      boolean bool;
      label140:
      Object localObject1;
      if (n > 0)
      {
        this.jdField_c_of_type_Int = n;
        if (this.jdField_c_of_type_Int > 1000) {
          this.jdField_c_of_type_Int = 1000;
        }
        n = localBundle.getInt("arg_comment_open_at", 0);
        if ((bhvh.v(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app) != 0) || (n != 1)) {
          break label504;
        }
        bool = true;
        this.jdField_f_of_type_Boolean = bool;
        if ((!this.jdField_f_of_type_Boolean) && (this.jdField_c_of_type_AndroidWidgetImageView != null)) {
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if (this.jdField_l_of_type_Int <= 0)
        {
          this.jdField_l_of_type_Int = getResources().getDisplayMetrics().widthPixels;
          this.jdField_l_of_type_Int = (this.jdField_l_of_type_Int - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaddingLeft() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaddingRight());
        }
        localObject1 = localBundle.getString("arg_comment_default_comment_at", "");
        if ((!this.jdField_f_of_type_Boolean) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label947;
        }
      }
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localSpannableStringBuilder = new SpannableStringBuilder();
        n = ((JSONArray)localObject1).length() - 1;
        label268:
        if (n < 0) {
          break label919;
        }
        Object localObject2 = ((JSONArray)localObject1).getJSONObject(n);
        long l1 = ((JSONObject)localObject2).optLong("uin");
        String str4 = new String(bbca.decode(((JSONObject)localObject2).optString("nick"), 0));
        String str3 = new String(bbca.decode(((JSONObject)localObject2).optString("comment"), 0));
        ((JSONObject)localObject2).optString("op_type");
        long l2 = ((JSONObject)localObject2).optLong("feedsId");
        if (n != ((JSONArray)localObject1).length() - 1)
        {
          localObject2 = "@" + str4 + " ";
          int i1 = localSpannableStringBuilder.length();
          localSpannableStringBuilder.append((CharSequence)localObject2).append(str3);
          localSpannableStringBuilder.setSpan(new AtFriendsSpan(String.valueOf(l1), l2, (CharSequence)localObject2, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaint(), this.jdField_l_of_type_Int), i1, ((String)localObject2).length() + i1, 33);
        }
        for (;;)
        {
          n -= 1;
          break label268;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setHint(ajyc.a(2131712937));
          break;
          n = bhvh.k(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
          if (n <= 0) {
            break label93;
          }
          this.jdField_c_of_type_Int = n;
          break label93;
          label504:
          bool = false;
          break label140;
          localSpannableStringBuilder.append(str3);
        }
        if (localBundle.getBoolean("arg_comment_gif_switch", true)) {
          break label1042;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
      }
    }
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    for (;;)
    {
      if (localBundle.getBoolean("arg_comment_transparent_bg", false)) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
      }
      String str2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentAccountUin();
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + str2, 4);
      this.jdField_k_of_type_Boolean = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("comment_native", false);
      this.jdField_l_of_type_Boolean = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("comment_reply_second", false);
      if (this.jdField_l_of_type_Boolean) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("comment_reply_second_uin");
      }
      if (this.jdField_k_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getParcelableExtra("comment_articleid"));
        this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("comment_val");
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("comment_author_uin");
        this.jdField_i_of_type_Int = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("biu_src", 1);
        this.jdField_j_of_type_Int = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("feedsType", 1);
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("comment_id");
        this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("first_comment_uin");
        this.jdField_h_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mIsGalleryChannel;
      }
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("comment_is_show_pic", false))
      {
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_h_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
      this.jdField_d_of_type_Int = localBundle.getInt("arg_comment_comment_type", 0);
      this.jdField_e_of_type_Int = localBundle.getInt("arg_comment_source_type", 0);
      this.jdField_h_of_type_Int = localBundle.getInt("click_comment_edit_src");
      c(str1);
      this.m = localBundle.getBoolean("arg_ad_show_biu", true);
      return;
      label919:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setText(localSpannableStringBuilder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(localSpannableStringBuilder.length());
      n();
      break;
      label947:
      str2 = localBundle.getString("arg_comment_default_txt", "");
      if (!TextUtils.isEmpty(str2))
      {
        str2 = axas.b(str2);
        if ("@".equals(str2)) {
          this.jdField_e_of_type_Boolean = true;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setText(str2);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(str2.length());
        n();
        break;
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
      break;
      label1042:
      if (bhvh.l(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app) == 1) {
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  private void h()
  {
    if (this.jdField_h_of_type_Int == -1) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ReadInJoyCommentComponentFragment.2(this));
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null) {
      noo.a(null, "", "0X800844D", "0X800844D", 0, 0, "", "", "", a(false), false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = null;
      this.jdField_a_of_type_Afae = null;
      n();
      this.jdField_g_of_type_AndroidWidgetImageView.setClickable(true);
      if (this.jdField_j_of_type_Boolean)
      {
        this.jdField_j_of_type_Boolean = false;
        this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842282);
      }
      return;
      if (this.jdField_a_of_type_Afae != null) {
        noo.a(null, "", "0X8008F5A", "0X8008F5A", 0, 0, "", "", "", a(false), false);
      }
    }
  }
  
  private void j()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842178);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842177);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Int == 2) {
      b(1);
    }
    for (;;)
    {
      aezn localaezn = a();
      if ((localaezn != null) && (this.jdField_i_of_type_Boolean))
      {
        localaezn.c();
        this.jdField_i_of_type_Boolean = false;
        this.jdField_f_of_type_AndroidWidgetImageView.setSelected(false);
      }
      return;
      b(2);
      noo.a(null, "", "0X800844B", "0X800844B", 0, 0, "", "", "", a(false), false);
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_Int == 3) {
      b(1);
    }
    for (;;)
    {
      aezn localaezn = a();
      if ((localaezn != null) && (this.jdField_i_of_type_Boolean))
      {
        localaezn.c();
        this.jdField_i_of_type_Boolean = false;
        this.jdField_f_of_type_AndroidWidgetImageView.setSelected(false);
      }
      return;
      b(3);
      noo.a(null, "", "0X800844C", "0X800844C", 0, 0, "", "", "", a(false), false);
    }
  }
  
  private void m()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "onDeliver overlong!");
      }
      bcpw.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, getString(2131718392), 0).a();
      return;
    }
    if (!bbev.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "onDeliver network error!");
      }
      bcpw.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, getString(2131718391), 0).a();
      return;
    }
    if (!TextUtils.isEmpty(a())) {}
    for (int n = 1;; n = 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null) {
        n += 2;
      }
      for (;;)
      {
        String str = "0X800844E";
        if (this.jdField_h_of_type_Int == 1) {
          str = "0X80094A1";
        }
        noo.a(null, "", str, str, 0, 0, String.valueOf(this.jdField_d_of_type_Int), String.valueOf(n), "", a(true), false);
        if (this.jdField_a_of_type_Afae == null)
        {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1, a());
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
          return;
          if (this.jdField_a_of_type_Afae != null) {
            n += 4;
          }
        }
        else
        {
          a(2131695574);
          a(this.jdField_a_of_type_Afae.jdField_b_of_type_JavaLangString);
          return;
        }
      }
    }
  }
  
  private void n()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData == null)
    {
      if (this.jdField_a_of_type_Afae == null) {
        break label29;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(bool1);
      return;
      label29:
      bool1 = bool2;
      if (TextUtils.isEmpty(a())) {
        bool1 = false;
      }
    }
  }
  
  private void o()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (((!rap.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (olc.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.b()))) {
      this.jdField_g_of_type_Boolean = false;
    }
    if (!this.jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  protected String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getEditableText();
    String str;
    if ((localObject == null) || (((Editable)localObject).length() <= 0)) {
      str = "";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "getCommentString result=" + str);
      }
      return str;
      str = UUID.randomUUID().toString();
      localObject = qgr.a(localObject.toString(), str).trim();
      if (((String)localObject).length() <= 0) {
        str = "";
      } else {
        str = axas.a(qgr.b(((String)localObject).replaceAll("\n|\r\n", ""), str));
      }
    }
  }
  
  public JSONObject a()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      b(localArrayList);
      JSONObject localJSONObject1 = new JSONObject();
      new SocializeFeedsInfo().jdField_a_of_type_Qcj = new qcj();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcj != null))
      {
        localJSONObject1.put("mOriFeedType", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcj.b);
        localJSONObject1.put("mOriFeedId", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcj.jdField_a_of_type_JavaLangLong);
      }
      localJSONObject1.put("biuSrc", this.jdField_i_of_type_Int);
      localJSONObject1.put("feedtype", this.jdField_j_of_type_Int);
      JSONArray localJSONArray = new JSONArray();
      int n = 0;
      while (n < localArrayList.size())
      {
        ogk localogk = (ogk)localArrayList.get(n);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("biu_info_comment", localogk.b);
        localJSONObject2.put("biu_feedid", new Long(localogk.jdField_a_of_type_Long));
        localJSONObject2.put("biu_optype", localogk.jdField_a_of_type_Int);
        localJSONObject2.put("biu_uin", localogk.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("biu_nickname", localogk.jdField_a_of_type_JavaLangCharSequence);
        localJSONArray.put(localJSONObject2);
        n += 1;
      }
      localJSONObject1.put("biuinfo", localJSONArray);
      return localJSONObject1;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "build article info error!");
      }
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText != null)
    {
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getWindowToken(), 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.clearFocus();
    }
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bcpq != null)
    {
      this.jdField_a_of_type_Bcpq.c(paramInt);
      if (!this.jdField_a_of_type_Bcpq.isShowing()) {
        this.jdField_a_of_type_Bcpq.show();
      }
    }
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    if ((paramIntent == null) || (!this.jdField_f_of_type_Boolean)) {}
    do
    {
      do
      {
        return;
        localObject = paramIntent.getParcelableArrayListExtra("result_set");
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText == null) || (localObject == null));
      int n = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getSelectionStart();
      paramIntent = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getEditableText();
      paramInt = n;
      if (paramIntent != null)
      {
        paramInt = n;
        if (!TextUtils.isEmpty(paramIntent.toString()))
        {
          paramInt = n;
          if (n > 0)
          {
            paramInt = n;
            if (paramIntent.toString().substring(n - 1, n).equals("@"))
            {
              paramIntent.delete(n - 1, n);
              paramInt = n - 1;
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(paramInt);
            }
          }
        }
      }
      if (this.jdField_l_of_type_Int <= 0)
      {
        this.jdField_l_of_type_Int = getResources().getDisplayMetrics().widthPixels;
        this.jdField_l_of_type_Int = (this.jdField_l_of_type_Int - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaddingLeft() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaddingRight());
      }
    } while (paramIntent == null);
    Object localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
      String str = "@" + BiuNicknameSpan.a(localResultRecord.jdField_b_of_type_JavaLangString) + " ";
      paramIntent.insert(paramInt, str);
      paramIntent.setSpan(new AtFriendsSpan(localResultRecord.jdField_a_of_type_JavaLangString, 0L, str, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaint(), this.jdField_l_of_type_Int), paramInt, str.length() + paramInt, 33);
      paramInt = str.length() + paramInt;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(paramInt);
  }
  
  public void a(int paramInt, CharSequence paramCharSequence)
  {
    bcpw.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramInt, paramCharSequence, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  public void a(afae paramafae)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "onZhituSend:" + paramafae);
    }
    this.jdField_a_of_type_Afae = paramafae;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = null;
    ThreadManager.getUIHandler().post(new ReadInJoyCommentComponentFragment.9(this, paramafae));
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "startUploadPic path=" + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      f();
      a(1, getString(2131718414));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "startUploadPic empty path!");
      }
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyCommentComponentFragment.3(this, paramString));
  }
  
  protected boolean a(ArrayList<ogk> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText == null) {
      return true;
    }
    Editable localEditable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getText();
    String str1 = "0";
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {
      str1 = ((QQAppInterface)localObject1).getCurrentAccountUin();
    }
    int i1 = 0;
    int n = 0;
    if ((localEditable == null) || (TextUtils.isEmpty(localEditable.toString())))
    {
      paramArrayList.add(new ogk(this, str1, 0L, ""));
      return false;
    }
    String str3 = UUID.randomUUID().toString();
    Object localObject3 = qgr.a(localEditable.toString(), str3).trim();
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      paramArrayList.add(new ogk(this, str1, 0L, ""));
      return true;
    }
    localObject1 = (BiuNicknameSpan[])localEditable.getSpans(0, localEditable.length(), BiuNicknameSpan.class);
    if ((localObject1 == null) || (localObject1.length <= 0))
    {
      paramArrayList.add(new ogk(this, str1, 0L, axas.a(qgr.b(((String)localObject3).replaceAll("\n|\r\n", ""), str3))));
      return true;
    }
    localObject3 = new ArrayList();
    ((ArrayList)localObject3).addAll(Arrays.asList((Object[])localObject1));
    Collections.sort((List)localObject3, new ogj(this, localEditable));
    long l1 = 0L;
    localObject3 = ((ArrayList)localObject3).iterator();
    BiuNicknameSpan localBiuNicknameSpan;
    int i3;
    int i2;
    if (((Iterator)localObject3).hasNext())
    {
      localBiuNicknameSpan = (BiuNicknameSpan)((Iterator)localObject3).next();
      i3 = localEditable.getSpanStart(localBiuNicknameSpan);
      i2 = localEditable.getSpanEnd(localBiuNicknameSpan);
    }
    label545:
    for (;;)
    {
      String str2;
      try
      {
        localObject1 = localEditable.subSequence(i1, i3).toString();
        if (localObject1 != null)
        {
          localObject1 = qgr.a((String)localObject1, str3).replaceAll("\n|\r\n", "");
          if (i1 != 0) {
            break label545;
          }
          localObject1 = ((String)localObject1).substring(((String)localObject1).indexOf(((String)localObject1).trim()));
          paramArrayList.add(new ogk(this, str1, l1, axas.a(qgr.b((String)localObject1, str3)), n));
        }
        if ((localBiuNicknameSpan instanceof AtFriendsSpan))
        {
          n = 1;
          str1 = localBiuNicknameSpan.jdField_a_of_type_JavaLangString;
          l1 = localBiuNicknameSpan.jdField_a_of_type_Long;
          i1 = i2;
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        str2 = null;
        continue;
        n = 0;
        continue;
      }
      try
      {
        str2 = localEditable.subSequence(i1, localEditable.length()).toString();
        if (str2 != null)
        {
          str2 = qgr.a(str2, str3).replaceAll("\n|\r\n", "");
          paramArrayList.add(new ogk(this, str1, l1, axas.a(qgr.b(str2.substring(0, str2.indexOf(str2.trim()) + str2.trim().length()), str3)), n));
        }
        return false;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
          Object localObject2 = null;
        }
      }
    }
  }
  
  protected void b()
  {
    if (this.jdField_f_of_type_Boolean) {
      b("1");
    }
    aezn localaezn = a();
    if ((localaezn != null) && (this.jdField_i_of_type_Boolean))
    {
      localaezn.c();
      this.jdField_i_of_type_Boolean = false;
      this.jdField_f_of_type_AndroidWidgetImageView.setSelected(false);
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_min", 1);
    localIntent.putExtra("param_max", 10);
    startActivityForResult(localIntent, 10000);
    noo.a(null, "", "0X8008660", "0X8008660", 0, 0, paramString, "", "", a(false), false);
  }
  
  protected boolean b(ArrayList<ogk> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText == null) {
      return true;
    }
    Editable localEditable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getText();
    Object localObject1 = "0";
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject2 instanceof QQAppInterface)) {
      localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
    }
    if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((onk.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_h_of_type_Int == 1)) {}
      int i3;
      int n;
      for (int i2 = 1;; i2 = 0)
      {
        i3 = 0;
        n = 0;
        if ((localEditable != null) && (!TextUtils.isEmpty(localEditable.toString()))) {
          break;
        }
        paramArrayList.add(new ogk(this, (String)localObject1, 0L, ""));
        return false;
      }
      String str2 = UUID.randomUUID().toString();
      Object localObject4 = qgr.a(localEditable.toString(), str2).trim();
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        paramArrayList.add(new ogk(this, (String)localObject1, 0L, ""));
      }
      for (boolean bool = true;; bool = true)
      {
        if (i1 != 0)
        {
          this.jdField_d_of_type_JavaLangString = (": " + this.jdField_d_of_type_JavaLangString);
          paramArrayList.add(new ogk(this, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId, this.jdField_d_of_type_JavaLangString, 0));
        }
        if ((i2 == 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcj == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcj.jdField_a_of_type_JavaUtilList == null)) {
          break label882;
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcj.jdField_a_of_type_JavaUtilList;
        i1 = ((List)localObject1).size();
        n = 0;
        for (;;)
        {
          if (n >= i1) {
            break label882;
          }
          localObject2 = (SocializeFeedsInfo.BiuCommentInfo)((List)localObject1).get(n);
          if (localObject2 != null) {
            break;
          }
          label357:
          n += 1;
        }
        localObject2 = (BiuNicknameSpan[])localEditable.getSpans(0, localEditable.length(), BiuNicknameSpan.class);
        if ((localObject2 != null) && (localObject2.length > 0)) {
          break;
        }
        str2 = axas.a(qgr.b(((String)localObject4).replaceAll("\n|\r\n", ""), str2));
        if (i1 == 0)
        {
          localObject2 = str2;
          if (i2 == 0) {}
        }
        else
        {
          localObject2 = str2 + "//";
        }
        paramArrayList.add(new ogk(this, (String)localObject1, 0L, "：" + (String)localObject2));
      }
      localObject4 = new ArrayList();
      ((ArrayList)localObject4).addAll(Arrays.asList((Object[])localObject2));
      Collections.sort((List)localObject4, new ogj(this, localEditable));
      long l1 = 0L;
      localObject4 = ((ArrayList)localObject4).iterator();
      BiuNicknameSpan localBiuNicknameSpan;
      int i5;
      int i4;
      if (((Iterator)localObject4).hasNext())
      {
        localBiuNicknameSpan = (BiuNicknameSpan)((Iterator)localObject4).next();
        i5 = localEditable.getSpanStart(localBiuNicknameSpan);
        i4 = localEditable.getSpanEnd(localBiuNicknameSpan);
      }
      label882:
      label885:
      for (;;)
      {
        Object localObject3;
        for (;;)
        {
          String str1;
          try
          {
            localObject2 = localEditable.subSequence(i3, i5).toString();
            if (localObject2 != null)
            {
              localObject2 = qgr.a((String)localObject2, str2).replaceAll("\n|\r\n", "");
              if (i3 != 0) {
                break label885;
              }
              localObject2 = ((String)localObject2).substring(((String)localObject2).indexOf(((String)localObject2).trim()));
              paramArrayList.add(new ogk(this, (String)localObject1, l1, axas.a(qgr.b((String)localObject2, str2)), n));
            }
            if ((localBiuNicknameSpan instanceof AtFriendsSpan))
            {
              n = 1;
              localObject1 = localBiuNicknameSpan.jdField_a_of_type_JavaLangString;
              l1 = localBiuNicknameSpan.jdField_a_of_type_Long;
              i3 = i4;
            }
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            str1 = null;
            continue;
            n = 0;
            continue;
          }
          try
          {
            str1 = localEditable.subSequence(i3, localEditable.length()).toString();
            if (str1 != null)
            {
              str1 = qgr.a(str1, str2).replaceAll("\n|\r\n", "");
              paramArrayList.add(new ogk(this, (String)localObject1, l1, axas.a(qgr.b(str1.substring(0, str1.indexOf(str1.trim()) + str1.trim().length()), str2)), n));
            }
            bool = false;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              localException2.printStackTrace();
              localObject3 = null;
            }
          }
        }
        paramArrayList.add(new ogk(this, String.valueOf(localObject3.jdField_a_of_type_JavaLangLong), localObject3.b.longValue(), localObject3.jdField_a_of_type_JavaLangString, localObject3.jdField_c_of_type_Int));
        break label357;
        return bool;
      }
    }
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_Afae != null) || (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null))
    {
      bcpw.a(this.jdField_g_of_type_AndroidWidgetImageView.getContext(), ajyc.a(2131712965), 0).a();
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842282);
      this.jdField_a_of_type_Boolean = true;
      if (!this.jdField_a_of_type_Boolean) {
        break label113;
      }
    }
    label113:
    for (String str = "0";; str = "1")
    {
      noo.a(null, "", "0X8008F58", "0X8008F58", 0, 0, str, "", "", a(false), false);
      return;
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842281);
      this.jdField_a_of_type_Boolean = false;
      break;
    }
  }
  
  protected void d()
  {
    c(1);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1, a());
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
  
  protected void e()
  {
    aezn localaezn = a();
    if (localaezn != null)
    {
      if (!this.jdField_i_of_type_Boolean) {
        break label60;
      }
      localaezn.c();
      this.jdField_i_of_type_Boolean = false;
      this.jdField_f_of_type_AndroidWidgetImageView.setSelected(false);
    }
    for (;;)
    {
      noo.a(null, "", "0X8008F59", "0X8008F59", 0, 0, "", "", "", a(false), false);
      return;
      label60:
      Editable localEditable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getText();
      if (!localaezn.a(localEditable))
      {
        bcpw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getContext(), ajyc.a(2131712739), 0).a();
        return;
      }
      if (localEditable.length() > 24)
      {
        bcpw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getContext(), "24个字符以内才支持转为智图。", 0).a();
        return;
      }
      localaezn.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_c_of_type_AndroidWidgetRelativeLayout, null, null, false, this.jdField_a_of_type_MqqOsMqqHandler);
      if (localaezn.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 1) {
        localaezn.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(0);
      }
      localaezn.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, localEditable, null, 7220, false);
      localaezn.a(this);
      this.jdField_i_of_type_Boolean = true;
      this.jdField_f_of_type_AndroidWidgetImageView.setSelected(true);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(84);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(84, 10000L);
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {
      this.jdField_a_of_type_Bcpq.dismiss();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(84);
      paramMessage = a();
      if ((paramMessage != null) && (this.jdField_i_of_type_Boolean))
      {
        paramMessage.c();
        this.jdField_i_of_type_Boolean = false;
        this.jdField_f_of_type_AndroidWidgetImageView.setSelected(false);
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setSoftInputMode(17);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      return;
    }
    a(paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(0, a());
    h();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131367846: 
    default: 
      return;
    case 2131362991: 
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.doOnBackPressed();
      return;
    case 2131367849: 
      i();
      return;
    case 2131362555: 
      j();
      return;
    case 2131365561: 
      k();
      return;
    case 2131367053: 
      l();
      return;
    case 2131365014: 
      m();
      return;
    case 2131362833: 
      b();
      return;
    case 2131379590: 
      e();
      return;
    case 2131363276: 
      c();
      return;
    }
    d();
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    paramLayoutInflater = paramLayoutInflater.inflate(2131559841, paramViewGroup, false);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131362991));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131367845));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131367846));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramLayoutInflater.findViewById(2131367849).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131362555));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131365561));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131367053));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131367937));
    if (!aqzc.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app).b()) {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131362833));
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131364057));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131365014));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText = ((BiuEditText)paramLayoutInflater.findViewById(2131368186));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.requestFocus();
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setEditableFactory(this.jdField_a_of_type_AndroidTextEditable$Factory);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)paramLayoutInflater.findViewById(2131375491));
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText, false);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this.jdField_a_of_type_Bfxd);
        this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131379590));
        this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131379593));
        g();
        this.jdField_g_of_type_Int = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          bool = true;
          this.jdField_d_of_type_Boolean = bool;
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131366662));
          this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
          if (ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getAppRuntime()))
          {
            paramViewGroup = paramLayoutInflater.findViewById(2131370839);
            if (paramViewGroup != null) {
              paramViewGroup.setVisibility(0);
            }
          }
          this.jdField_a_of_type_Bcpq = new bcpq(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          this.jdField_a_of_type_Bcpq.setCanceledOnTouchOutside(true);
          this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131364465));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131365015));
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131363276));
        }
      }
      catch (Exception paramViewGroup)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_Boolean) {
              this.m = false;
            }
            if (this.m) {
              break label661;
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            if (a())
            {
              this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842282);
              this.jdField_a_of_type_Boolean = true;
            }
            o();
            return paramLayoutInflater;
            this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
            break;
            paramViewGroup = paramViewGroup;
            QLog.e("ReadInJoyCommentComponentFragment", 1, "input set error", paramViewGroup);
          }
          boolean bool = false;
        }
        catch (NullPointerException paramViewGroup)
        {
          for (;;)
          {
            paramViewGroup.printStackTrace();
            continue;
            label661:
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
          }
        }
      }
    }
  }
  
  @TargetApi(16)
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("readinjoy_comment_biu_switch", this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().commit();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.setPublicAccountGifListener(null);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setReadyToShow(false);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.d();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(null);
      if (Build.VERSION.SDK_INT >= 16) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
    }
    aezn localaezn = a();
    if (localaezn != null) {
      localaezn.a(null);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a().b(this.jdField_a_of_type_Ayvz);
    }
    a();
  }
  
  public void onDetach()
  {
    super.onDetach();
    try
    {
      Field localField = Fragment.class.getDeclaredField("mChildFragmentManager");
      localField.setAccessible(true);
      localField.set(this, null);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new RuntimeException(localNoSuchFieldException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
  }
  
  public void onFinish()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 0);
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
  }
  
  public void onResume()
  {
    super.onResume();
    AbstractGifImage.resumeAll();
    if (this.jdField_b_of_type_Int == 1) {
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyCommentComponentFragment.1(this), 300L);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    rgc.a(getActivity(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment
 * JD-Core Version:    0.7.0.1
 */