package com.tencent.biz.pubaccount.readinjoy.comment;

import ains;
import aioa;
import aioj;
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
import anni;
import arxd;
import avbk;
import avdq;
import bbzj;
import bdzi;
import bdzm;
import bgku;
import bgnt;
import biau;
import bkfv;
import bkqk;
import bmqa;
import com.tencent.biz.pubaccount.readinjoy.biu.AtFriendsSpan;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuEditText;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuNicknameSpan;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SimpleCommentData;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import oat;
import och;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ova;
import oys;
import oyt;
import oyu;
import oyv;
import oyw;
import oyx;
import oyy;
import oyz;
import oza;
import ozb;
import paa;
import pbe;
import pfa;
import pgc;
import pha;
import pho;
import rgy;
import rhn;
import rlr;
import snh;
import stp;

public class ReadInJoyCommentComponentFragment
  extends PublicBaseFragment
  implements aioa, Handler.Callback, View.OnClickListener
{
  private static final Editable.Factory jdField_a_of_type_AndroidTextEditable$Factory = new oyw();
  protected int a;
  private aioj jdField_a_of_type_Aioj;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  protected TextWatcher a;
  public ViewGroup.LayoutParams a;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  protected Button a;
  public FrameLayout a;
  public ImageView a;
  protected LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  private arxd jdField_a_of_type_Arxd = new oyy(this);
  private avdq jdField_a_of_type_Avdq = new oyz(this);
  bdzm jdField_a_of_type_Bdzm = new oyv(this);
  protected biau a;
  private bkqk jdField_a_of_type_Bkqk = new oyx(this);
  public BiuEditText a;
  private SimpleCommentData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  public EmoticonMainPanel a;
  public HotPicData a;
  public PublicAccountHotPicPanel a;
  public XPanelContainer a;
  protected String a;
  public final MqqHandler a;
  protected boolean a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  protected int b;
  protected Button b;
  protected ImageView b;
  protected LinearLayout b;
  protected RelativeLayout b;
  protected TextView b;
  private String b;
  public boolean b;
  public int c;
  protected ImageView c;
  protected RelativeLayout c;
  public TextView c;
  private String c;
  protected boolean c;
  protected int d;
  protected ImageView d;
  protected RelativeLayout d;
  protected TextView d;
  private String d;
  public boolean d;
  protected int e;
  protected ImageView e;
  protected RelativeLayout e;
  private String e;
  public boolean e;
  public int f;
  public ImageView f;
  private String jdField_f_of_type_JavaLangString = "";
  private boolean jdField_f_of_type_Boolean;
  public int g;
  protected ImageView g;
  private boolean g;
  private int jdField_h_of_type_Int = -1;
  protected ImageView h;
  private boolean jdField_h_of_type_Boolean = true;
  private int jdField_i_of_type_Int = 1;
  protected ImageView i;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int = 1;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int;
  private boolean jdField_m_of_type_Boolean;
  private boolean n;
  private boolean o;
  private boolean p = true;
  
  public ReadInJoyCommentComponentFragment()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = pgc.jdField_b_of_type_Int;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_MqqOsMqqHandler = new bkfv(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_AndroidTextTextWatcher = new oys(this);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new oyt(this);
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  private ains a()
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
      } while (((localBundle != null) && (!localBundle.getBoolean("arg_comment_zhitu_switch", true))) || (bmqa.m((AppRuntime)localObject) != 0));
      localObject = ains.a((AppInterface)localObject);
    } while ((localObject == null) || (!((ains)localObject).e()));
    return localObject;
  }
  
  private Intent a()
  {
    int i1 = 1;
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    JSONObject localJSONObject1 = new JSONObject();
    label976:
    for (;;)
    {
      try
      {
        localJSONObject1.put("isAnonymous", this.jdField_c_of_type_Boolean);
        localJSONObject1.put("comment", new String(bgku.encode(a().getBytes(), 0)));
        Object localObject1;
        Object localObject3;
        Object localObject4;
        ozb localozb;
        JSONObject localJSONObject2;
        if ((this.jdField_a_of_type_Aioj != null) || (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null))
        {
          localJSONObject1.put("biuAfterComment", 0);
          if (this.jdField_l_of_type_Boolean)
          {
            if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
              continue;
            }
            localObject1 = "";
            localJSONObject1.put("replyUin", localObject1);
            localJSONObject1.put("isSecondReply", this.jdField_m_of_type_Boolean);
            localJSONObject1.put("commentId", this.jdField_c_of_type_JavaLangString);
            localJSONObject1.put("commentUin", this.jdField_d_of_type_JavaLangString);
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localObject1 = a();
            if (localObject1 != null) {
              localJSONObject1.put("biu_info", localObject1);
            }
          }
          if ((!this.jdField_g_of_type_Boolean) || (TextUtils.isEmpty(a()))) {
            continue;
          }
          localObject3 = new ArrayList();
          a((ArrayList)localObject3);
          if (((ArrayList)localObject3).size() <= 0) {
            continue;
          }
          localObject4 = new JSONArray();
          i1 = ((ArrayList)localObject3).size() - 1;
          if (i1 < 0) {
            continue;
          }
          localozb = (ozb)((ArrayList)localObject3).get(i1);
          localJSONObject2 = new JSONObject();
        }
        try
        {
          localJSONObject2.put("uin", Long.valueOf(localozb.jdField_a_of_type_JavaLangString));
          localObject1 = "";
          if (TextUtils.isEmpty(localozb.jdField_a_of_type_JavaLangCharSequence)) {
            localozb.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
          }
          if (localozb.jdField_a_of_type_JavaLangCharSequence != null) {
            localObject1 = localozb.jdField_a_of_type_JavaLangCharSequence.toString();
          }
          localJSONObject2.put("nick", new String(bgku.encode(((String)localObject1).getBytes(), 0)));
          localObject1 = "";
          if (localozb.b != null) {
            localObject1 = localozb.b.toString();
          }
          localJSONObject2.put("comment", new String(bgku.encode(((String)localObject1).getBytes(), 0)));
          localJSONObject2.put("op_type", localozb.jdField_a_of_type_Int);
          ((JSONArray)localObject4).put(localJSONObject2);
          i1 -= 1;
          continue;
          if (!this.jdField_a_of_type_Boolean) {
            break label976;
          }
          localJSONObject1.put("biuAfterComment", i1);
          continue;
          localObject1 = this.jdField_b_of_type_JavaLangString;
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
        if ((this.jdField_a_of_type_Aioj != null) && (this.jdField_a_of_type_Aioj.jdField_c_of_type_Boolean))
        {
          localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
          BitmapFactory.decodeFile(this.jdField_a_of_type_Aioj.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject2);
          localObject3 = new JSONArray();
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("picType", 3);
          ((JSONObject)localObject4).put("url", this.jdField_a_of_type_Aioj.jdField_f_of_type_JavaLangString);
          ((JSONObject)localObject4).put("md5", this.jdField_a_of_type_Aioj.g);
          ((JSONObject)localObject4).put("width", ((BitmapFactory.Options)localObject2).outWidth);
          ((JSONObject)localObject4).put("height", ((BitmapFactory.Options)localObject2).outHeight);
          ((JSONObject)localObject4).put("thumbnail_url", this.jdField_a_of_type_Aioj.jdField_f_of_type_JavaLangString);
          ((JSONObject)localObject4).put("thumbnail_md5", this.jdField_a_of_type_Aioj.g);
          ((JSONObject)localObject4).put("thumbnail_width", ((BitmapFactory.Options)localObject2).outWidth);
          ((JSONObject)localObject4).put("thumbnail_height", ((BitmapFactory.Options)localObject2).outHeight);
          ((JSONArray)localObject3).put(localObject4);
          localJSONObject1.put("picInfoList", localObject3);
        }
        Object localObject2 = localJSONObject1.toString();
        ReadInJoyUserInfoModule.a(Long.parseLong(pha.a()), null);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentComponentFragment", 2, "finish resultJson=" + (String)localObject2);
        }
        localIntent.putExtra("arg_result_json", (String)localObject2);
        localIntent.putExtra("comment_article_info", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        localIntent.putExtra("comment_gallery_channel", this.jdField_i_of_type_Boolean);
        localIntent.putExtra("comment_cmd", this.jdField_k_of_type_Int);
        if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
        {
          i1 = 2;
          localIntent.putExtra("click_comment_edit_src", i1);
          return localIntent;
        }
        i1 = 3;
        continue;
        i1 = 0;
      }
      catch (JSONException localJSONException)
      {
        return localIntent;
      }
    }
  }
  
  private String a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", pha.jdField_d_of_type_Int);
        if (paramBoolean)
        {
          if (!this.jdField_a_of_type_Boolean) {
            break label150;
          }
          localObject = "0";
          localJSONObject.put("biu_comment", localObject);
        }
        localJSONObject.put("os", 1);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData != null)
        {
          localJSONObject.put("entry", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData.d());
          localJSONObject.put("scene", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData.b());
          return localJSONObject.toString();
        }
        Object localObject = pbe.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        if (localObject != null)
        {
          localJSONObject.put("entry", ((pbe)localObject).a());
          localJSONObject.put("scene", 0);
          continue;
        }
        localJSONObject.put("entry", 0);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "";
      }
      continue;
      label150:
      String str = "1";
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("comment_is_show_pic", false))
    {
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_h_of_type_AndroidWidgetImageView.setOnClickListener(this);
      return;
    }
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getString("arg_comment_default_comment_at", "");
    if ((this.jdField_g_of_type_Boolean) && (!TextUtils.isEmpty((CharSequence)localObject1))) {}
    for (;;)
    {
      int i1;
      try
      {
        paramBundle = new JSONArray((String)localObject1);
        localObject1 = new SpannableStringBuilder();
        i1 = paramBundle.length() - 1;
        if (i1 >= 0)
        {
          Object localObject2 = paramBundle.getJSONObject(i1);
          long l1 = ((JSONObject)localObject2).optLong("uin");
          String str2 = new String(bgku.decode(((JSONObject)localObject2).optString("nick"), 0));
          String str1 = new String(bgku.decode(((JSONObject)localObject2).optString("comment"), 0));
          ((JSONObject)localObject2).optString("op_type");
          long l2 = ((JSONObject)localObject2).optLong("feedsId");
          if (i1 != paramBundle.length() - 1)
          {
            localObject2 = "@" + str2 + " ";
            int i2 = ((SpannableStringBuilder)localObject1).length();
            ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2).append(str1);
            ((SpannableStringBuilder)localObject1).setSpan(new AtFriendsSpan(String.valueOf(l1), l2, (CharSequence)localObject2, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaint(), this.jdField_l_of_type_Int), i2, ((String)localObject2).length() + i2, 33);
          }
          else
          {
            ((SpannableStringBuilder)localObject1).append(str1);
          }
        }
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
      }
      do
      {
        return;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setText((CharSequence)localObject1);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(((SpannableStringBuilder)localObject1).length());
        p();
        return;
        paramBundle = paramBundle.getString("arg_comment_default_txt", "");
        if (!TextUtils.isEmpty(paramBundle))
        {
          paramBundle = bbzj.b(paramBundle);
          if ("@".equals(paramBundle)) {
            this.jdField_f_of_type_Boolean = true;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setText(paramBundle);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(paramBundle.length());
          p();
          return;
        }
      } while (this.jdField_a_of_type_AndroidWidgetTextView == null);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
      return;
      i1 -= 1;
    }
  }
  
  private void a(View paramView)
  {
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363503));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363506));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363500));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363507));
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363502));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363501));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363504));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_i_of_type_AndroidWidgetImageView.setImageResource(2130842788);
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_i_of_type_AndroidWidgetImageView.setImageResource(2130842787);
    this.jdField_b_of_type_Boolean = false;
  }
  
  private boolean a()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "onDeliver overlong!");
      }
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, getString(2131716973), 0).a();
      return false;
    }
    if (!bgnt.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "onDeliver network error!");
      }
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, getString(2131716972), 0).a();
      return false;
    }
    return true;
  }
  
  /* Error */
  private Intent b()
  {
    // Byte code:
    //   0: new 211	java/lang/String
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 214	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:a	()Ljava/lang/String;
    //   8: invokevirtual 218	java/lang/String:getBytes	()[B
    //   11: iconst_0
    //   12: invokestatic 224	bgku:encode	([BI)[B
    //   15: invokespecial 227	java/lang/String:<init>	([B)V
    //   18: astore 5
    //   20: aload_0
    //   21: invokespecial 453	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:a	()Landroid/content/Intent;
    //   24: astore 4
    //   26: new 198	org/json/JSONObject
    //   29: dup
    //   30: invokespecial 199	org/json/JSONObject:<init>	()V
    //   33: astore_2
    //   34: aload 4
    //   36: ldc_w 421
    //   39: invokevirtual 690	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore_3
    //   43: aload_3
    //   44: invokestatic 247	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifne +203 -> 250
    //   50: new 198	org/json/JSONObject
    //   53: dup
    //   54: aload_3
    //   55: invokespecial 691	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   58: astore_3
    //   59: aload_3
    //   60: astore_2
    //   61: aload_0
    //   62: getfield 239	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_l_of_type_Boolean	Z
    //   65: ifeq +58 -> 123
    //   68: aload_0
    //   69: getfield 241	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   72: invokestatic 247	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   75: ifeq +150 -> 225
    //   78: ldc 82
    //   80: astore_3
    //   81: aload_2
    //   82: ldc 249
    //   84: aload_3
    //   85: invokevirtual 230	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   88: pop
    //   89: aload_2
    //   90: ldc 251
    //   92: aload_0
    //   93: getfield 253	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_m_of_type_Boolean	Z
    //   96: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   99: pop
    //   100: aload_2
    //   101: ldc 255
    //   103: aload_0
    //   104: getfield 84	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   107: invokevirtual 230	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   110: pop
    //   111: aload_2
    //   112: ldc_w 257
    //   115: aload_0
    //   116: getfield 86	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   119: invokevirtual 230	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   122: pop
    //   123: aload_2
    //   124: ldc 209
    //   126: aload 5
    //   128: invokevirtual 230	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   131: pop
    //   132: aload_2
    //   133: ldc_w 693
    //   136: aload_0
    //   137: getfield 656	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_b_of_type_Boolean	Z
    //   140: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   143: pop
    //   144: aload 4
    //   146: ldc_w 421
    //   149: aload_2
    //   150: invokevirtual 387	org/json/JSONObject:toString	()Ljava/lang/String;
    //   153: invokevirtual 427	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   156: pop
    //   157: aload_0
    //   158: getfield 143	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   161: invokestatic 247	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   164: ifeq +77 -> 241
    //   167: iconst_2
    //   168: istore_1
    //   169: aload 4
    //   171: ldc_w 450
    //   174: iload_1
    //   175: invokevirtual 448	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   178: pop
    //   179: aload 4
    //   181: ldc_w 429
    //   184: aload_0
    //   185: getfield 431	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   188: invokevirtual 434	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   191: pop
    //   192: ldc_w 406
    //   195: iconst_1
    //   196: new 408	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 409	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 695
    //   206: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_2
    //   210: invokevirtual 387	org/json/JSONObject:toString	()Ljava/lang/String;
    //   213: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 419	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: aload 4
    //   224: areturn
    //   225: aload_0
    //   226: getfield 241	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   229: astore_3
    //   230: goto -149 -> 81
    //   233: astore_3
    //   234: aload_3
    //   235: invokevirtual 492	org/json/JSONException:printStackTrace	()V
    //   238: goto -94 -> 144
    //   241: iconst_3
    //   242: istore_1
    //   243: goto -74 -> 169
    //   246: astore_3
    //   247: goto -13 -> 234
    //   250: goto -189 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	ReadInJoyCommentComponentFragment
    //   168	75	1	i1	int
    //   33	177	2	localObject1	Object
    //   42	188	3	localObject2	Object
    //   233	2	3	localJSONException1	JSONException
    //   246	1	3	localJSONException2	JSONException
    //   24	199	4	localIntent	Intent
    //   18	109	5	str	String
    // Exception table:
    //   from	to	target	type
    //   34	59	233	org/json/JSONException
    //   61	78	246	org/json/JSONException
    //   81	123	246	org/json/JSONException
    //   123	144	246	org/json/JSONException
    //   225	230	246	org/json/JSONException
  }
  
  private void b(int paramInt)
  {
    int i3 = 2130849369;
    this.jdField_a_of_type_Int = paramInt;
    int i2 = 2130842903;
    int i1;
    if (paramInt == 1)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1)) {
        break label204;
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      paramInt = 2130842901;
      i1 = i2;
    }
    for (;;)
    {
      if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(paramInt);
      }
      if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(i1);
      }
      return;
      if (paramInt == 2)
      {
        i1 = i2;
        paramInt = i3;
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
        {
          i1 = i2;
          paramInt = i3;
          if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 3)
          {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
            i1 = i2;
            paramInt = i3;
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
            i1 = 2130849369;
            paramInt = 2130842901;
          }
        }
        else
        {
          if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)) {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
          }
          label204:
          paramInt = 2130842901;
          i1 = i2;
          continue;
        }
        i1 = 2130849369;
        paramInt = 2130842901;
      }
    }
  }
  
  private void b(Bundle paramBundle)
  {
    if (!paramBundle.getBoolean("arg_comment_gif_switch", true)) {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    while (bmqa.l(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app) != 1) {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private boolean b()
  {
    return bmqa.u(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app) == 1;
  }
  
  private void c(int paramInt)
  {
    this.jdField_k_of_type_Int = paramInt;
  }
  
  private void c(@NotNull Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("arg_comment_placeholder", "");
    QLog.d("ReadInJoyCommentComponentFragment", 2, "initData | comment_placeholder : " + this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setHint(this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setHint(anni.a(2131711711));
  }
  
  private void d(@NotNull Bundle paramBundle)
  {
    int i1 = paramBundle.getInt("arg_comment_max_length", -1);
    if (i1 > 0) {
      this.jdField_c_of_type_Int = i1;
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Int > 1000) {
        this.jdField_c_of_type_Int = 1000;
      }
      return;
      i1 = bmqa.k(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
      if (i1 > 0) {
        this.jdField_c_of_type_Int = i1;
      }
    }
  }
  
  private void e(@NotNull Bundle paramBundle)
  {
    int i1 = 1;
    int i2 = paramBundle.getInt("arg_comment_open_at", 0);
    boolean bool;
    if ((bmqa.v(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app) == 0) && (i2 == 1))
    {
      bool = true;
      this.jdField_g_of_type_Boolean = bool;
      if ((this.jdField_g_of_type_Boolean) || (this.jdField_c_of_type_AndroidWidgetImageView == null)) {
        break label72;
      }
    }
    for (;;)
    {
      if (i1 != 0) {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return;
      bool = false;
      break;
      label72:
      i1 = 0;
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
    for (;;)
    {
      this.jdField_h_of_type_Boolean = localBundle.getBoolean("comment_can_biu", true);
      c(localBundle);
      d(localBundle);
      e(localBundle);
      h();
      a(localBundle);
      b(localBundle);
      if (localBundle.getBoolean("arg_comment_transparent_bg", false)) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
      }
      Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentAccountUin();
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + (String)localObject, 4);
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
      this.jdField_m_of_type_Boolean = ((Intent)localObject).getBooleanExtra("comment_reply_second", false);
      if (this.jdField_m_of_type_Boolean) {
        this.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("comment_reply_second_uin");
      }
      this.jdField_l_of_type_Boolean = ((Intent)localObject).getBooleanExtra("comment_native", false);
      if (this.jdField_l_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)((Intent)localObject).getParcelableExtra("comment_article_info"));
        this.jdField_e_of_type_JavaLangString = ((Intent)localObject).getStringExtra("comment_val");
        this.jdField_f_of_type_JavaLangString = ((Intent)localObject).getStringExtra("comment_author_uin");
        this.jdField_i_of_type_Int = ((Intent)localObject).getIntExtra("biu_src", 1);
        this.jdField_j_of_type_Int = ((Intent)localObject).getIntExtra("feedsType", 1);
        this.jdField_c_of_type_JavaLangString = ((Intent)localObject).getStringExtra("comment_id");
        this.jdField_d_of_type_JavaLangString = ((Intent)localObject).getStringExtra("first_comment_uin");
        this.jdField_i_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mIsGalleryChannel;
      }
      a((Intent)localObject);
      this.jdField_d_of_type_Int = localBundle.getInt("arg_comment_comment_type", 0);
      this.jdField_e_of_type_Int = localBundle.getInt("arg_comment_source_type", 0);
      this.jdField_h_of_type_Int = localBundle.getInt("click_comment_edit_src");
      this.n = localBundle.getBoolean("arg_ad_show_biu", true);
      this.p = localBundle.getBoolean("comment_type", true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData = ((SimpleCommentData)localBundle.getParcelable("comment_create_data"));
      i();
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void h()
  {
    if (this.jdField_l_of_type_Int <= 0)
    {
      this.jdField_l_of_type_Int = getResources().getDisplayMetrics().widthPixels;
      this.jdField_l_of_type_Int = (this.jdField_l_of_type_Int - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaddingLeft() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaddingRight());
    }
  }
  
  private void i()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains(getString(2131716933)))) {}
    for (int i1 = 2;; i1 = 1)
    {
      Object localObject1 = "";
      for (;;)
      {
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("folder_status", pha.jdField_d_of_type_Int);
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
            ((JSONObject)localObject2).put("consume_time", pho.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, false) / 1000L);
          }
          ((JSONObject)localObject2).put("os", 1);
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData == null) {
            continue;
          }
          ((JSONObject)localObject2).put("entry", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData.d());
          ((JSONObject)localObject2).put("scene", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData.b());
          localObject2 = ((JSONObject)localObject2).toString();
          localObject1 = localObject2;
        }
        catch (JSONException localJSONException)
        {
          Object localObject2;
          pbe localpbe;
          localJSONException.printStackTrace();
          continue;
          localJSONException.put("entry", 0);
          continue;
        }
        oat.a(null, "", "0X800844A", "0X800844A", 0, 0, String.valueOf(i1), String.valueOf(this.jdField_e_of_type_Int), "", (String)localObject1, false);
        return;
        localpbe = pbe.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        if (localpbe == null) {
          continue;
        }
        ((JSONObject)localObject2).put("entry", localpbe.a());
        ((JSONObject)localObject2).put("scene", 0);
      }
    }
  }
  
  private void j()
  {
    if (this.jdField_h_of_type_Int == -1) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ReadInJoyCommentComponentFragment.2(this));
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null) {
      oat.a(null, "", "0X800844D", "0X800844D", 0, 0, "", "", "", a(false), false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = null;
      this.jdField_a_of_type_Aioj = null;
      p();
      this.jdField_g_of_type_AndroidWidgetImageView.setClickable(true);
      if (this.jdField_k_of_type_Boolean)
      {
        this.jdField_k_of_type_Boolean = false;
        this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842788);
      }
      return;
      if (this.jdField_a_of_type_Aioj != null) {
        oat.a(null, "", "0X8008F5A", "0X8008F5A", 0, 0, "", "", "", a(false), false);
      }
    }
  }
  
  private void l()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842674);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842673);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Int == 2) {
      b(1);
    }
    for (;;)
    {
      ains localains = a();
      if ((localains != null) && (this.jdField_j_of_type_Boolean))
      {
        localains.c();
        this.jdField_j_of_type_Boolean = false;
        this.jdField_f_of_type_AndroidWidgetImageView.setSelected(false);
      }
      return;
      b(2);
      oat.a(null, "", "0X800844B", "0X800844B", 0, 0, "", "", "", a(false), false);
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_Int == 3) {
      b(1);
    }
    for (;;)
    {
      ains localains = a();
      if ((localains != null) && (this.jdField_j_of_type_Boolean))
      {
        localains.c();
        this.jdField_j_of_type_Boolean = false;
        this.jdField_f_of_type_AndroidWidgetImageView.setSelected(false);
      }
      return;
      b(3);
      oat.a(null, "", "0X800844C", "0X800844C", 0, 0, "", "", "", a(false), false);
    }
  }
  
  private void o()
  {
    if (!a()) {
      return;
    }
    if (!TextUtils.isEmpty(a())) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null) {
        i1 += 2;
      }
      for (;;)
      {
        String str = "0X800844E";
        if (this.jdField_h_of_type_Int == 1) {
          str = "0X80094A1";
        }
        oat.a(null, "", str, str, 0, 0, String.valueOf(this.jdField_d_of_type_Int), String.valueOf(i1), "", a(true), false);
        if (this.jdField_a_of_type_Aioj == null)
        {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1, a());
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
          return;
          if (this.jdField_a_of_type_Aioj != null) {
            i1 += 4;
          }
        }
        else
        {
          a(2131694623);
          a(this.jdField_a_of_type_Aioj.jdField_b_of_type_JavaLangString);
          return;
        }
      }
    }
  }
  
  private void p()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData == null)
    {
      if (this.jdField_a_of_type_Aioj == null) {
        break label44;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(bool1);
      if (this.jdField_b_of_type_AndroidWidgetButton != null) {
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(bool1);
      }
      return;
      label44:
      bool1 = bool2;
      if (TextUtils.isEmpty(a())) {
        bool1 = false;
      }
    }
  }
  
  private void q()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (((!snh.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (pfa.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.b()))) {
      this.jdField_h_of_type_Boolean = false;
    }
    if (!this.jdField_h_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void r()
  {
    if ((ova.a()) && (this.p)) {
      this.o = true;
    }
    if (!this.o)
    {
      QLog.d("ReadInJoyCommentComponentFragment", 1, "initBiuAndCommentMix isBiuAndCommentMixType is false");
      return;
    }
    s();
    u();
    x();
  }
  
  private void s()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    t();
  }
  
  private void t()
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = ova.b().split("\\|");
    if (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
      this.jdField_m_of_type_Int = new Random().nextInt(this.jdField_a_of_type_ArrayOfJavaLangString.length);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_m_of_type_Int])) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_m_of_type_Int]);
    }
    String str = ova.c();
    if (!TextUtils.isEmpty(str)) {
      this.jdField_b_of_type_AndroidWidgetButton.setText(str);
    }
    if (ova.d()) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      str = ova.d();
      if (!TextUtils.isEmpty(str)) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(str);
      }
      if (ova.b()) {
        a(true);
      }
    } while (!ova.c());
    if (((Boolean)bmqa.a("rij_sp_editor_last_check", Boolean.valueOf(false))).booleanValue())
    {
      a(true);
      return;
    }
    a(false);
  }
  
  private void u()
  {
    oyu localoyu = new oyu(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(localoyu);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(localoyu);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(localoyu);
  }
  
  private void v()
  {
    w();
    if (!a()) {
      return;
    }
    if (ova.c()) {
      bmqa.a("rij_sp_editor_last_check", Boolean.valueOf(this.jdField_b_of_type_Boolean));
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(1699, b());
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "reportMixCommentBiuBtnClick | mArticleInfo is null");
      return;
    }
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("feeds_type", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType);
      ((JSONObject)localObject2).put("feedsid", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId);
      ((JSONObject)localObject2).put("version", och.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject2).put("os", "1");
      ((JSONObject)localObject2).put("entry", 1);
      ((JSONObject)localObject2).put("place", 1);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.d("ReadInJoyCommentComponentFragment", 2, localJSONException.getMessage());
      }
    }
    oat.a(null, paa.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800AB7B", "0X800AB7B", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_e_of_type_Int), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject1, false);
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "reportMixCommentBiuBtnExposure | mArticleInfo is null");
      return;
    }
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("feeds_type", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType);
      ((JSONObject)localObject2).put("feedsid", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId);
      ((JSONObject)localObject2).put("version", och.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject2).put("os", "1");
      ((JSONObject)localObject2).put("entry", 1);
      ((JSONObject)localObject2).put("place", 1);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.d("ReadInJoyCommentComponentFragment", 2, localJSONException.getMessage());
      }
    }
    oat.a(null, paa.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800AB7A", "0X800AB7A", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_e_of_type_Int), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject1, false);
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
      localObject = rlr.a(localObject.toString(), str).trim();
      if (((String)localObject).length() <= 0) {
        str = "";
      } else {
        str = bbzj.a(rlr.b(((String)localObject).replaceAll("\n|\r\n", ""), str));
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
      new SocializeFeedsInfo().jdField_a_of_type_Rgy = new rgy();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy != null))
      {
        localJSONObject1.put("mOriFeedType", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.b);
        localJSONObject1.put("mOriFeedId", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_a_of_type_JavaLangLong);
      }
      localJSONObject1.put("biuSrc", this.jdField_i_of_type_Int);
      localJSONObject1.put("feedtype", this.jdField_j_of_type_Int);
      JSONArray localJSONArray = new JSONArray();
      int i1 = 0;
      while (i1 < localArrayList.size())
      {
        ozb localozb = (ozb)localArrayList.get(i1);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("biu_info_comment", localozb.b);
        localJSONObject2.put("biu_feedid", new Long(localozb.jdField_a_of_type_Long));
        localJSONObject2.put("biu_optype", localozb.jdField_a_of_type_Int);
        localJSONObject2.put("biu_uin", localozb.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("biu_nickname", localozb.jdField_a_of_type_JavaLangCharSequence);
        localJSONArray.put(localJSONObject2);
        i1 += 1;
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
    if (this.jdField_a_of_type_Biau != null)
    {
      this.jdField_a_of_type_Biau.c(paramInt);
      if (!this.jdField_a_of_type_Biau.isShowing()) {
        this.jdField_a_of_type_Biau.show();
      }
    }
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    if ((paramIntent == null) || (!this.jdField_g_of_type_Boolean)) {}
    do
    {
      do
      {
        return;
        localObject = paramIntent.getParcelableArrayListExtra("result_set");
      } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText == null) || (localObject == null));
      int i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getSelectionStart();
      paramIntent = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getEditableText();
      paramInt = i1;
      if (paramIntent != null)
      {
        paramInt = i1;
        if (!TextUtils.isEmpty(paramIntent.toString()))
        {
          paramInt = i1;
          if (i1 > 0)
          {
            paramInt = i1;
            if (paramIntent.toString().substring(i1 - 1, i1).equals("@"))
            {
              paramIntent.delete(i1 - 1, i1);
              paramInt = i1 - 1;
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(paramInt);
            }
          }
        }
      }
      h();
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
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramInt, paramCharSequence, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  public void a(aioj paramaioj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "onZhituSend:" + paramaioj);
    }
    this.jdField_a_of_type_Aioj = paramaioj;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = null;
    ThreadManager.getUIHandler().post(new ReadInJoyCommentComponentFragment.9(this, paramaioj));
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "startUploadPic path=" + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      f();
      a(1, getString(2131716990));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "startUploadPic empty path!");
      }
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyCommentComponentFragment.3(this, paramString));
  }
  
  protected boolean a(ArrayList<ozb> paramArrayList)
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
    int i2 = 0;
    int i1 = 0;
    if ((localEditable == null) || (TextUtils.isEmpty(localEditable.toString())))
    {
      paramArrayList.add(new ozb(this, str1, 0L, ""));
      return false;
    }
    String str3 = UUID.randomUUID().toString();
    Object localObject3 = rlr.a(localEditable.toString(), str3).trim();
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      paramArrayList.add(new ozb(this, str1, 0L, ""));
      return true;
    }
    localObject1 = (BiuNicknameSpan[])localEditable.getSpans(0, localEditable.length(), BiuNicknameSpan.class);
    if ((localObject1 == null) || (localObject1.length <= 0))
    {
      paramArrayList.add(new ozb(this, str1, 0L, bbzj.a(rlr.b(((String)localObject3).replaceAll("\n|\r\n", ""), str3))));
      return true;
    }
    localObject3 = new ArrayList();
    ((ArrayList)localObject3).addAll(Arrays.asList((Object[])localObject1));
    Collections.sort((List)localObject3, new oza(this, localEditable));
    long l1 = 0L;
    localObject3 = ((ArrayList)localObject3).iterator();
    BiuNicknameSpan localBiuNicknameSpan;
    int i4;
    int i3;
    if (((Iterator)localObject3).hasNext())
    {
      localBiuNicknameSpan = (BiuNicknameSpan)((Iterator)localObject3).next();
      i4 = localEditable.getSpanStart(localBiuNicknameSpan);
      i3 = localEditable.getSpanEnd(localBiuNicknameSpan);
    }
    label545:
    for (;;)
    {
      String str2;
      try
      {
        localObject1 = localEditable.subSequence(i2, i4).toString();
        if (localObject1 != null)
        {
          localObject1 = rlr.a((String)localObject1, str3).replaceAll("\n|\r\n", "");
          if (i2 != 0) {
            break label545;
          }
          localObject1 = ((String)localObject1).substring(((String)localObject1).indexOf(((String)localObject1).trim()));
          paramArrayList.add(new ozb(this, str1, l1, bbzj.a(rlr.b((String)localObject1, str3)), i1));
        }
        if ((localBiuNicknameSpan instanceof AtFriendsSpan))
        {
          i1 = 1;
          str1 = localBiuNicknameSpan.jdField_a_of_type_JavaLangString;
          l1 = localBiuNicknameSpan.jdField_a_of_type_Long;
          i2 = i3;
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        str2 = null;
        continue;
        i1 = 0;
        continue;
      }
      try
      {
        str2 = localEditable.subSequence(i2, localEditable.length()).toString();
        if (str2 != null)
        {
          str2 = rlr.a(str2, str3).replaceAll("\n|\r\n", "");
          paramArrayList.add(new ozb(this, str1, l1, bbzj.a(rlr.b(str2.substring(0, str2.indexOf(str2.trim()) + str2.trim().length()), str3)), i1));
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
    if (this.jdField_g_of_type_Boolean) {
      b("1");
    }
    ains localains = a();
    if ((localains != null) && (this.jdField_j_of_type_Boolean))
    {
      localains.c();
      this.jdField_j_of_type_Boolean = false;
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
    oat.a(null, "", "0X8008660", "0X8008660", 0, 0, paramString, "", "", a(false), false);
  }
  
  protected boolean b(ArrayList<ozb> paramArrayList)
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
    if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)) {}
    for (int i2 = 1;; i2 = 0)
    {
      if ((pha.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_h_of_type_Int == 1)) {}
      int i4;
      int i1;
      for (int i3 = 1;; i3 = 0)
      {
        i4 = 0;
        i1 = 0;
        if ((localEditable != null) && (!TextUtils.isEmpty(localEditable.toString()))) {
          break;
        }
        paramArrayList.add(new ozb(this, (String)localObject1, 0L, ""));
        return false;
      }
      String str2 = UUID.randomUUID().toString();
      Object localObject4 = rlr.a(localEditable.toString(), str2).trim();
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        paramArrayList.add(new ozb(this, (String)localObject1, 0L, ""));
      }
      for (boolean bool = true;; bool = true)
      {
        if (i2 != 0)
        {
          this.jdField_e_of_type_JavaLangString = (": " + this.jdField_e_of_type_JavaLangString);
          paramArrayList.add(new ozb(this, this.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId, this.jdField_e_of_type_JavaLangString, 0));
        }
        if ((i3 == 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_a_of_type_JavaUtilList == null)) {
          break label882;
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rgy.jdField_a_of_type_JavaUtilList;
        i2 = ((List)localObject1).size();
        i1 = 0;
        for (;;)
        {
          if (i1 >= i2) {
            break label882;
          }
          localObject2 = (SocializeFeedsInfo.BiuCommentInfo)((List)localObject1).get(i1);
          if (localObject2 != null) {
            break;
          }
          label357:
          i1 += 1;
        }
        localObject2 = (BiuNicknameSpan[])localEditable.getSpans(0, localEditable.length(), BiuNicknameSpan.class);
        if ((localObject2 != null) && (localObject2.length > 0)) {
          break;
        }
        str2 = bbzj.a(rlr.b(((String)localObject4).replaceAll("\n|\r\n", ""), str2));
        if (i2 == 0)
        {
          localObject2 = str2;
          if (i3 == 0) {}
        }
        else
        {
          localObject2 = str2 + "//";
        }
        paramArrayList.add(new ozb(this, (String)localObject1, 0L, "：" + (String)localObject2));
      }
      localObject4 = new ArrayList();
      ((ArrayList)localObject4).addAll(Arrays.asList((Object[])localObject2));
      Collections.sort((List)localObject4, new oza(this, localEditable));
      long l1 = 0L;
      localObject4 = ((ArrayList)localObject4).iterator();
      BiuNicknameSpan localBiuNicknameSpan;
      int i6;
      int i5;
      if (((Iterator)localObject4).hasNext())
      {
        localBiuNicknameSpan = (BiuNicknameSpan)((Iterator)localObject4).next();
        i6 = localEditable.getSpanStart(localBiuNicknameSpan);
        i5 = localEditable.getSpanEnd(localBiuNicknameSpan);
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
            localObject2 = localEditable.subSequence(i4, i6).toString();
            if (localObject2 != null)
            {
              localObject2 = rlr.a((String)localObject2, str2).replaceAll("\n|\r\n", "");
              if (i4 != 0) {
                break label885;
              }
              localObject2 = ((String)localObject2).substring(((String)localObject2).indexOf(((String)localObject2).trim()));
              paramArrayList.add(new ozb(this, (String)localObject1, l1, bbzj.a(rlr.b((String)localObject2, str2)), i1));
            }
            if ((localBiuNicknameSpan instanceof AtFriendsSpan))
            {
              i1 = 1;
              localObject1 = localBiuNicknameSpan.jdField_a_of_type_JavaLangString;
              l1 = localBiuNicknameSpan.jdField_a_of_type_Long;
              i4 = i5;
            }
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            str1 = null;
            continue;
            i1 = 0;
            continue;
          }
          try
          {
            str1 = localEditable.subSequence(i4, localEditable.length()).toString();
            if (str1 != null)
            {
              str1 = rlr.a(str1, str2).replaceAll("\n|\r\n", "");
              paramArrayList.add(new ozb(this, (String)localObject1, l1, bbzj.a(rlr.b(str1.substring(0, str1.indexOf(str1.trim()) + str1.trim().length()), str2)), i1));
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
        paramArrayList.add(new ozb(this, String.valueOf(localObject3.jdField_a_of_type_JavaLangLong), localObject3.b.longValue(), localObject3.jdField_a_of_type_JavaLangString, localObject3.jdField_c_of_type_Int));
        break label357;
        return bool;
      }
    }
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_Aioj != null) || (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null))
    {
      QQToast.a(this.jdField_g_of_type_AndroidWidgetImageView.getContext(), anni.a(2131711739), 0).a();
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842788);
      this.jdField_a_of_type_Boolean = true;
      if (!this.jdField_a_of_type_Boolean) {
        break label113;
      }
    }
    label113:
    for (String str = "0";; str = "1")
    {
      oat.a(null, "", "0X8008F58", "0X8008F58", 0, 0, str, "", "", a(false), false);
      return;
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842787);
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
    ains localains = a();
    if (localains != null)
    {
      if (!this.jdField_j_of_type_Boolean) {
        break label60;
      }
      localains.c();
      this.jdField_j_of_type_Boolean = false;
      this.jdField_f_of_type_AndroidWidgetImageView.setSelected(false);
    }
    for (;;)
    {
      oat.a(null, "", "0X8008F59", "0X8008F59", 0, 0, "", "", "", a(false), false);
      return;
      label60:
      Editable localEditable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getText();
      if (!localains.a(localEditable))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getContext(), anni.a(2131711513), 0).a();
        return;
      }
      if (localEditable.length() > 24)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getContext(), "24个字符以内才支持转为智图。", 0).a();
        return;
      }
      localains.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_c_of_type_AndroidWidgetRelativeLayout, null, null, false, this.jdField_a_of_type_MqqOsMqqHandler);
      if (localains.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 1) {
        localains.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(0);
      }
      localains.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, localEditable, null, 7220, false);
      localains.a(this);
      this.jdField_j_of_type_Boolean = true;
      this.jdField_f_of_type_AndroidWidgetImageView.setSelected(true);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(84);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(84, 10000L);
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_Biau.isShowing())) {
      this.jdField_a_of_type_Biau.dismiss();
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
      if ((paramMessage != null) && (this.jdField_j_of_type_Boolean))
      {
        paramMessage.c();
        this.jdField_j_of_type_Boolean = false;
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
    j();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.doOnBackPressed();
      continue;
      k();
      continue;
      l();
      continue;
      m();
      continue;
      n();
      continue;
      o();
      continue;
      b();
      continue;
      e();
      continue;
      c();
      continue;
      d();
    }
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    paramLayoutInflater = paramLayoutInflater.inflate(2131560082, paramViewGroup, false);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131363211));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131368316));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131368317));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramLayoutInflater.findViewById(2131368320).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131362684));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131365878));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131367482));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131368409));
    if (!avbk.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app).b()) {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131362979));
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131364328));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131365338));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText = ((BiuEditText)paramLayoutInflater.findViewById(2131368651));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.requestFocus();
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setEditableFactory(jdField_a_of_type_AndroidTextEditable$Factory);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)paramLayoutInflater.findViewById(2131376788));
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText, false);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this.jdField_a_of_type_Bkqk);
        this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131381404));
        this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131381407));
        a(paramLayoutInflater);
        g();
        this.jdField_g_of_type_Int = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          bool = true;
          this.jdField_e_of_type_Boolean = bool;
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131367058));
          this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
          if (ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getAppRuntime()))
          {
            paramViewGroup = paramLayoutInflater.findViewById(2131371727);
            if (paramViewGroup != null) {
              paramViewGroup.setVisibility(0);
            }
          }
          this.jdField_a_of_type_Biau = new biau(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          this.jdField_a_of_type_Biau.setCanceledOnTouchOutside(true);
          this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131364753));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131365339));
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131363510));
        }
      }
      catch (Exception paramViewGroup)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhn.jdField_a_of_type_Boolean) {
              this.n = false;
            }
            if (this.n) {
              break label674;
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            if (b())
            {
              this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842788);
              this.jdField_a_of_type_Boolean = true;
            }
            q();
            r();
            V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
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
            label674:
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
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.g();
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
    ains localains = a();
    if (localains != null) {
      localains.a(null);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a().b(this.jdField_a_of_type_Bdzm);
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
    stp.a(getActivity(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment
 * JD-Core Version:    0.7.0.1
 */