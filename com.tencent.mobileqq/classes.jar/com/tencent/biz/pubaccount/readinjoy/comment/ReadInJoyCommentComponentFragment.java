package com.tencent.biz.pubaccount.readinjoy.comment;

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
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.biu.AtFriendsSpan;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuEditText;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuNicknameSpan;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.ZhituSendListener;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPicData;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.hotpic.PublicAccountGifListener;
import com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.PanelCallback;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import ljd;
import lje;
import ljf;
import ljg;
import ljh;
import lji;
import ljj;
import ljk;
import ljm;
import ljn;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyCommentComponentFragment
  extends PublicBaseFragment
  implements Handler.Callback, View.OnClickListener, ZhituManager.ZhituSendListener
{
  protected int a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private Editable.Factory jdField_a_of_type_AndroidTextEditable$Factory = new ljh(this);
  protected TextWatcher a;
  public ViewGroup.LayoutParams a;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  protected Button a;
  public FrameLayout a;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  public BiuEditText a;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private ZhituPicData jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData;
  private EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = new ljj(this);
  public EmoticonMainPanel a;
  public HotPicData a;
  private PublicAccountGifListener jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountGifListener = new ljk(this);
  public PublicAccountHotPicPanel a;
  public TransProcessorHandler a;
  protected QQProgressDialog a;
  private XPanelContainer.PanelCallback jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback = new lji(this);
  public XPanelContainer a;
  private String jdField_a_of_type_JavaLangString;
  public final MqqHandler a;
  public boolean a;
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
  protected RelativeLayout d;
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
  public ImageView g;
  private boolean g;
  private int jdField_h_of_type_Int = 1;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = 1;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private boolean k;
  
  public ReadInJoyCommentComponentFragment()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = ReadInJoyConstants.jdField_b_of_type_Int;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new ljg(this);
    this.jdField_a_of_type_AndroidTextTextWatcher = new ljn(this);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new lje(this);
    this.jdField_d_of_type_JavaLangString = "";
  }
  
  private Intent a()
  {
    int m = 1;
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject1.put("isAnonymous", this.jdField_b_of_type_Boolean);
        localJSONObject1.put("comment", new String(Base64Util.encode(a().getBytes(), 0)));
        Object localObject1;
        Object localObject3;
        Object localObject4;
        ReadInJoyCommentComponentFragment.UserBiuInfo localUserBiuInfo;
        JSONObject localJSONObject2;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData != null) || (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null))
        {
          localJSONObject1.put("biuAfterComment", 0);
          if (this.jdField_j_of_type_Boolean)
          {
            if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
              continue;
            }
            localObject1 = "";
            localJSONObject1.put("replyUin", localObject1);
            localJSONObject1.put("isSecondReply", this.k);
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
          m = ((ArrayList)localObject3).size() - 1;
          if (m < 0) {
            continue;
          }
          localUserBiuInfo = (ReadInJoyCommentComponentFragment.UserBiuInfo)((ArrayList)localObject3).get(m);
          localJSONObject2 = new JSONObject();
        }
        try
        {
          localJSONObject2.put("uin", Long.valueOf(localUserBiuInfo.jdField_a_of_type_JavaLangString));
          localObject1 = "";
          if (TextUtils.isEmpty(localUserBiuInfo.jdField_a_of_type_JavaLangCharSequence)) {
            localUserBiuInfo.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
          }
          if (localUserBiuInfo.jdField_a_of_type_JavaLangCharSequence != null) {
            localObject1 = localUserBiuInfo.jdField_a_of_type_JavaLangCharSequence.toString();
          }
          localJSONObject2.put("nick", new String(Base64Util.encode(((String)localObject1).getBytes(), 0)));
          localObject1 = "";
          if (localUserBiuInfo.b != null) {
            localObject1 = localUserBiuInfo.b.toString();
          }
          localJSONObject2.put("comment", new String(Base64Util.encode(((String)localObject1).getBytes(), 0)));
          localJSONObject2.put("op_type", localUserBiuInfo.jdField_a_of_type_Int);
          ((JSONArray)localObject4).put(localJSONObject2);
          m -= 1;
          continue;
          if (!this.jdField_a_of_type_Boolean) {
            break label898;
          }
          localJSONObject1.put("biuAfterComment", m);
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
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.jdField_c_of_type_Boolean))
        {
          localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
          BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject2);
          localObject3 = new JSONArray();
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("picType", 3);
          ((JSONObject)localObject4).put("url", this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.f);
          ((JSONObject)localObject4).put("md5", this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.g);
          ((JSONObject)localObject4).put("width", ((BitmapFactory.Options)localObject2).outWidth);
          ((JSONObject)localObject4).put("height", ((BitmapFactory.Options)localObject2).outHeight);
          ((JSONObject)localObject4).put("thumbnail_url", this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.f);
          ((JSONObject)localObject4).put("thumbnail_md5", this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.g);
          ((JSONObject)localObject4).put("thumbnail_width", ((BitmapFactory.Options)localObject2).outWidth);
          ((JSONObject)localObject4).put("thumbnail_height", ((BitmapFactory.Options)localObject2).outHeight);
          ((JSONArray)localObject3).put(localObject4);
          localJSONObject1.put("picInfoList", localObject3);
        }
        Object localObject2 = localJSONObject1.toString();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentComponentFragment", 2, "finish resultJson=" + (String)localObject2);
        }
        localIntent.putExtra("arg_result_json", (String)localObject2);
        return localIntent;
      }
      catch (JSONException localJSONException)
      {
        return localIntent;
      }
      label898:
      m = 0;
    }
  }
  
  private ZhituManager a()
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
      } while (((localBundle != null) && (!localBundle.getBoolean("arg_comment_zhitu_switch", true))) || (ReadInJoyHelper.n((AppRuntime)localObject) != 0));
      localObject = ZhituManager.a((AppInterface)localObject);
    } while ((localObject == null) || (!((ZhituManager)localObject).c()));
    return localObject;
  }
  
  private String a(boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", ReadInJoyUtils.jdField_d_of_type_Int);
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
  
  private void b(int paramInt)
  {
    int i1 = 2130845285;
    this.jdField_a_of_type_Int = paramInt;
    int n = 2130840786;
    int m;
    if (paramInt == 1)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1)) {
        break label204;
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      paramInt = 2130840785;
      m = n;
    }
    for (;;)
    {
      if (this.jdField_d_of_type_AndroidWidgetImageView != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(paramInt);
      }
      if (this.jdField_e_of_type_AndroidWidgetImageView != null) {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(m);
      }
      return;
      if (paramInt == 2)
      {
        m = n;
        paramInt = i1;
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
        {
          m = n;
          paramInt = i1;
          if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 3)
          {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
            m = n;
            paramInt = i1;
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
            m = 2130845285;
            paramInt = 2130840785;
          }
        }
        else
        {
          if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)) {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
          }
          label204:
          paramInt = 2130840785;
          m = n;
          continue;
        }
        m = 2130845285;
        paramInt = 2130840785;
      }
    }
  }
  
  private boolean e()
  {
    boolean bool2 = true;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {}
    for (boolean bool1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("readinjoy_comment_biu_switch_user_operation", false);; bool1 = false)
    {
      if (bool1) {
        bool1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("readinjoy_comment_biu_switch", false);
      }
      do
      {
        return bool1;
        bool1 = bool2;
      } while (ReadInJoyHelper.u(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app) == 1);
      return false;
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
    Object localObject1 = localBundle.getString("arg_comment_placeholder", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setHint((CharSequence)localObject1);
    }
    int m = localBundle.getInt("arg_comment_max_length", -1);
    if (m > 0) {
      this.jdField_c_of_type_Int = m;
    }
    label127:
    SpannableStringBuilder localSpannableStringBuilder;
    for (;;)
    {
      if (this.jdField_c_of_type_Int > 1000) {
        this.jdField_c_of_type_Int = 1000;
      }
      m = localBundle.getInt("arg_comment_open_at", 0);
      boolean bool;
      if ((ReadInJoyHelper.w(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app) == 0) && (m == 1))
      {
        bool = true;
        this.jdField_f_of_type_Boolean = bool;
        if ((!this.jdField_f_of_type_Boolean) && (this.jdField_c_of_type_AndroidWidgetImageView != null)) {
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if (this.jdField_j_of_type_Int <= 0)
        {
          this.jdField_j_of_type_Int = getResources().getDisplayMetrics().widthPixels;
          this.jdField_j_of_type_Int = (this.jdField_j_of_type_Int - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaddingLeft() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaddingRight());
        }
        localObject1 = localBundle.getString("arg_comment_default_comment_at", "");
        if ((!this.jdField_f_of_type_Boolean) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label877;
        }
      }
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        localSpannableStringBuilder = new SpannableStringBuilder();
        m = ((JSONArray)localObject1).length() - 1;
        label255:
        if (m < 0) {
          break label849;
        }
        Object localObject2 = ((JSONArray)localObject1).getJSONObject(m);
        long l1 = ((JSONObject)localObject2).optLong("uin");
        String str3 = new String(Base64Util.decode(((JSONObject)localObject2).optString("nick"), 0));
        String str2 = new String(Base64Util.decode(((JSONObject)localObject2).optString("comment"), 0));
        ((JSONObject)localObject2).optString("op_type");
        long l2 = ((JSONObject)localObject2).optLong("feedsId");
        if (m != ((JSONArray)localObject1).length() - 1)
        {
          localObject2 = "@" + str3 + " ";
          int n = localSpannableStringBuilder.length();
          localSpannableStringBuilder.append((CharSequence)localObject2).append(str2);
          localSpannableStringBuilder.setSpan(new AtFriendsSpan(String.valueOf(l1), l2, (CharSequence)localObject2, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaint(), this.jdField_j_of_type_Int), n, ((String)localObject2).length() + n, 33);
        }
        for (;;)
        {
          m -= 1;
          break label255;
          m = ReadInJoyHelper.l(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
          if (m <= 0) {
            break;
          }
          this.jdField_c_of_type_Int = m;
          break;
          bool = false;
          break label127;
          localSpannableStringBuilder.append(str2);
        }
        if (localBundle.getBoolean("arg_comment_gif_switch", true)) {
          break label972;
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
      String str1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentAccountUin();
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + str1, 4);
      this.jdField_j_of_type_Boolean = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("comment_native", false);
      this.k = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("comment_reply_second", false);
      if (this.k) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("comment_reply_second_uin");
      }
      if (this.jdField_j_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getParcelableExtra("comment_articleid"));
        this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("comment_val");
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("comment_author_uin");
        this.jdField_h_of_type_Int = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("biu_src", 1);
        this.jdField_i_of_type_Int = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("feedsType", 1);
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("comment_id");
        this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("first_comment_uin");
      }
      this.jdField_d_of_type_Int = localBundle.getInt("arg_comment_comment_type", 0);
      this.jdField_e_of_type_Int = localBundle.getInt("arg_comment_source_type", 0);
      PublicAccountReportUtils.a(null, "", "0X800844A", "0X800844A", 0, 0, String.valueOf(this.jdField_d_of_type_Int), String.valueOf(this.jdField_e_of_type_Int), "", a(false), false);
      return;
      label849:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setText(localSpannableStringBuilder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(localSpannableStringBuilder.length());
      p();
      break;
      label877:
      str1 = localBundle.getString("arg_comment_default_txt", "");
      if (!TextUtils.isEmpty(str1))
      {
        str1 = MessageUtils.b(str1);
        if ("@".equals(str1)) {
          this.jdField_e_of_type_Boolean = true;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setText(str1);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(str1.length());
        p();
        break;
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
      break;
      label972:
      if (ReadInJoyHelper.m(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app) == 1) {
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null) {
      PublicAccountReportUtils.a(null, "", "0X800844D", "0X800844D", 0, 0, "", "", "", a(false), false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData = null;
      p();
      this.jdField_g_of_type_AndroidWidgetImageView.setClickable(true);
      if (this.jdField_i_of_type_Boolean)
      {
        this.jdField_i_of_type_Boolean = false;
        this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130840738);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData != null) {
        PublicAccountReportUtils.a(null, "", "0X8008F5A", "0X8008F5A", 0, 0, "", "", "", a(false), false);
      }
    }
  }
  
  private void i()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840678);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840677);
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Int == 2) {
      b(1);
    }
    for (;;)
    {
      ZhituManager localZhituManager = a();
      if ((localZhituManager != null) && (this.jdField_g_of_type_Boolean))
      {
        localZhituManager.c();
        this.jdField_g_of_type_Boolean = false;
        this.jdField_f_of_type_AndroidWidgetImageView.setSelected(false);
      }
      return;
      b(2);
      PublicAccountReportUtils.a(null, "", "0X800844B", "0X800844B", 0, 0, "", "", "", a(false), false);
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_Int == 3) {
      b(1);
    }
    for (;;)
    {
      ZhituManager localZhituManager = a();
      if ((localZhituManager != null) && (this.jdField_g_of_type_Boolean))
      {
        localZhituManager.c();
        this.jdField_g_of_type_Boolean = false;
        this.jdField_f_of_type_AndroidWidgetImageView.setSelected(false);
      }
      return;
      b(3);
      PublicAccountReportUtils.a(null, "", "0X800844C", "0X800844C", 0, 0, "", "", "", a(false), false);
    }
  }
  
  private void o()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "onDeliver overlong!");
      }
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, getString(2131438847), 0).a();
      return;
    }
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "onDeliver network error!");
      }
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, getString(2131438848), 0).a();
      return;
    }
    if (!TextUtils.isEmpty(a())) {}
    for (int m = 1;; m = 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null) {
        m += 2;
      }
      for (;;)
      {
        PublicAccountReportUtils.a(null, "", "0X800844E", "0X800844E", 0, 0, String.valueOf(this.jdField_d_of_type_Int), String.valueOf(m), "", a(true), false);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData == null)
        {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1, a());
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData != null) {
            m += 4;
          }
        }
        else
        {
          a(2131430090);
          a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.jdField_b_of_type_JavaLangString);
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
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData == null) {
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
      localObject = ReadInJoyBaseDeliverActivity.a(localObject.toString(), str).trim();
      if (((String)localObject).length() <= 0) {
        str = "";
      } else {
        str = MessageUtils.a(ReadInJoyBaseDeliverActivity.b(((String)localObject).replaceAll("\n|\r\n", ""), str));
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
      Object localObject = new SocializeFeedsInfo();
      localObject.getClass();
      ((SocializeFeedsInfo)localObject).a = new SocializeFeedsInfo.BiuInfo((SocializeFeedsInfo)localObject);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a != null))
      {
        localJSONObject1.put("mOriFeedType", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.b);
        localJSONObject1.put("mOriFeedId", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.a);
      }
      localJSONObject1.put("biuSrc", this.jdField_h_of_type_Int);
      localJSONObject1.put("feedtype", this.jdField_i_of_type_Int);
      localObject = new JSONArray();
      int m = 0;
      while (m < localArrayList.size())
      {
        ReadInJoyCommentComponentFragment.UserBiuInfo localUserBiuInfo = (ReadInJoyCommentComponentFragment.UserBiuInfo)localArrayList.get(m);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("biu_info_comment", localUserBiuInfo.b);
        localJSONObject2.put("biu_feedid", localUserBiuInfo.jdField_a_of_type_Long);
        localJSONObject2.put("biu_optype", localUserBiuInfo.jdField_a_of_type_Int);
        localJSONObject2.put("biu_uin", localUserBiuInfo.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("biu_nickname", localUserBiuInfo.jdField_a_of_type_JavaLangCharSequence);
        ((JSONArray)localObject).put(localJSONObject2);
        m += 1;
      }
      localJSONObject1.put("biuinfo", localObject);
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
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
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
      int m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getSelectionStart();
      paramIntent = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getEditableText();
      paramInt = m;
      if (paramIntent != null)
      {
        paramInt = m;
        if (!TextUtils.isEmpty(paramIntent.toString()))
        {
          paramInt = m;
          if (m > 0)
          {
            paramInt = m;
            if (paramIntent.toString().substring(m - 1, m).equals("@"))
            {
              paramIntent.delete(m - 1, m);
              paramInt = m - 1;
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(paramInt);
            }
          }
        }
      }
      if (this.jdField_j_of_type_Int <= 0)
      {
        this.jdField_j_of_type_Int = getResources().getDisplayMetrics().widthPixels;
        this.jdField_j_of_type_Int = (this.jdField_j_of_type_Int - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaddingLeft() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaddingRight());
      }
    } while (paramIntent == null);
    Object localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
      String str = "@" + BiuNicknameSpan.a(localResultRecord.jdField_b_of_type_JavaLangString) + " ";
      paramIntent.insert(paramInt, str);
      paramIntent.setSpan(new AtFriendsSpan(localResultRecord.jdField_a_of_type_JavaLangString, 0L, str, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaint(), this.jdField_j_of_type_Int), paramInt, str.length() + paramInt, 33);
      paramInt = str.length() + paramInt;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(paramInt);
  }
  
  public void a(int paramInt, CharSequence paramCharSequence)
  {
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramInt, paramCharSequence, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  public void a(Activity paramActivity)
  {
    paramActivity.getWindow().setSoftInputMode(17);
  }
  
  public void a(ZhituPicData paramZhituPicData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "onZhituSend:" + paramZhituPicData);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData = paramZhituPicData;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = null;
    ThreadManager.getUIHandler().post(new ljm(this, paramZhituPicData));
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "startUploadPic path=" + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      f();
      a(1, getString(2131438866));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "startUploadPic empty path!");
      }
      return;
    }
    ThreadManager.executeOnSubThread(new ljf(this, paramString));
  }
  
  protected boolean a(ArrayList paramArrayList)
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
    int n = 0;
    int m = 0;
    if ((localEditable == null) || (TextUtils.isEmpty(localEditable.toString())))
    {
      paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, str1, 0L, ""));
      return false;
    }
    String str3 = UUID.randomUUID().toString();
    Object localObject3 = ReadInJoyBaseDeliverActivity.a(localEditable.toString(), str3).trim();
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, str1, 0L, ""));
      return true;
    }
    localObject1 = (BiuNicknameSpan[])localEditable.getSpans(0, localEditable.length(), BiuNicknameSpan.class);
    if ((localObject1 == null) || (localObject1.length <= 0))
    {
      paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, str1, 0L, MessageUtils.a(ReadInJoyBaseDeliverActivity.b(((String)localObject3).replaceAll("\n|\r\n", ""), str3))));
      return true;
    }
    localObject3 = new ArrayList();
    ((ArrayList)localObject3).addAll(Arrays.asList((Object[])localObject1));
    Collections.sort((List)localObject3, new ReadInJoyCommentComponentFragment.BiuSpanComparator(this, localEditable));
    long l = 0L;
    localObject3 = ((ArrayList)localObject3).iterator();
    BiuNicknameSpan localBiuNicknameSpan;
    int i2;
    int i1;
    if (((Iterator)localObject3).hasNext())
    {
      localBiuNicknameSpan = (BiuNicknameSpan)((Iterator)localObject3).next();
      i2 = localEditable.getSpanStart(localBiuNicknameSpan);
      i1 = localEditable.getSpanEnd(localBiuNicknameSpan);
    }
    label545:
    for (;;)
    {
      String str2;
      try
      {
        localObject1 = localEditable.subSequence(n, i2).toString();
        if (localObject1 != null)
        {
          localObject1 = ReadInJoyBaseDeliverActivity.a((String)localObject1, str3).replaceAll("\n|\r\n", "");
          if (n != 0) {
            break label545;
          }
          localObject1 = ((String)localObject1).substring(((String)localObject1).indexOf(((String)localObject1).trim()));
          paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, str1, l, MessageUtils.a(ReadInJoyBaseDeliverActivity.b((String)localObject1, str3)), m));
        }
        if ((localBiuNicknameSpan instanceof AtFriendsSpan))
        {
          m = 1;
          str1 = localBiuNicknameSpan.jdField_a_of_type_JavaLangString;
          l = localBiuNicknameSpan.jdField_a_of_type_Long;
          n = i1;
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        str2 = null;
        continue;
        m = 0;
        continue;
      }
      try
      {
        str2 = localEditable.subSequence(n, localEditable.length()).toString();
        if (str2 != null)
        {
          str2 = ReadInJoyBaseDeliverActivity.a(str2, str3).replaceAll("\n|\r\n", "");
          paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, str1, l, MessageUtils.a(ReadInJoyBaseDeliverActivity.b(str2.substring(0, str2.indexOf(str2.trim()) + str2.trim().length()), str3)), m));
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
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText != null)
    {
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getWindowToken(), 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.clearFocus();
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
    PublicAccountReportUtils.a(null, "", "0X8008660", "0X8008660", 0, 0, paramString, "", "", a(false), false);
  }
  
  public boolean b()
  {
    return false;
  }
  
  protected boolean b(ArrayList paramArrayList)
  {
    boolean bool2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText == null)
    {
      bool2 = true;
      return bool2;
    }
    Editable localEditable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getText();
    String str1 = "0";
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {
      str1 = ((QQAppInterface)localObject1).getCurrentAccountUin();
    }
    if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)) {}
    for (int n = 1;; n = 0)
    {
      int i1 = 0;
      int m = 0;
      if ((localEditable == null) || (TextUtils.isEmpty(localEditable.toString())))
      {
        paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, str1, 0L, ""));
        return false;
      }
      String str3 = UUID.randomUUID().toString();
      Object localObject3 = ReadInJoyBaseDeliverActivity.a(localEditable.toString(), str3).trim();
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, str1, 0L, ""));
      }
      for (boolean bool1 = true;; bool1 = true)
      {
        bool2 = bool1;
        if (n == 0) {
          break;
        }
        this.jdField_d_of_type_JavaLangString = (": " + this.jdField_d_of_type_JavaLangString);
        paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId, this.jdField_d_of_type_JavaLangString, 0));
        return bool1;
        localObject1 = (BiuNicknameSpan[])localEditable.getSpans(0, localEditable.length(), BiuNicknameSpan.class);
        if ((localObject1 != null) && (localObject1.length > 0)) {
          break label370;
        }
        str3 = MessageUtils.a(ReadInJoyBaseDeliverActivity.b(((String)localObject3).replaceAll("\n|\r\n", ""), str3));
        localObject1 = str3;
        if (n != 0) {
          localObject1 = str3 + "//";
        }
        paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, str1, 0L, "：" + (String)localObject1));
      }
      label370:
      localObject3 = new ArrayList();
      ((ArrayList)localObject3).addAll(Arrays.asList((Object[])localObject1));
      Collections.sort((List)localObject3, new ReadInJoyCommentComponentFragment.BiuSpanComparator(this, localEditable));
      long l = 0L;
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
      label713:
      for (;;)
      {
        for (;;)
        {
          String str2;
          try
          {
            localObject1 = localEditable.subSequence(i1, i3).toString();
            if (localObject1 != null)
            {
              localObject1 = ReadInJoyBaseDeliverActivity.a((String)localObject1, str3).replaceAll("\n|\r\n", "");
              if (i1 != 0) {
                break label713;
              }
              localObject1 = ((String)localObject1).substring(((String)localObject1).indexOf(((String)localObject1).trim()));
              paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, str1, l, MessageUtils.a(ReadInJoyBaseDeliverActivity.b((String)localObject1, str3)), m));
            }
            if ((localBiuNicknameSpan instanceof AtFriendsSpan))
            {
              m = 1;
              str1 = localBiuNicknameSpan.jdField_a_of_type_JavaLangString;
              l = localBiuNicknameSpan.jdField_a_of_type_Long;
              i1 = i2;
            }
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            str2 = null;
            continue;
            m = 0;
            continue;
          }
          try
          {
            str2 = localEditable.subSequence(i1, localEditable.length()).toString();
            if (str2 != null)
            {
              str2 = ReadInJoyBaseDeliverActivity.a(str2, str3).replaceAll("\n|\r\n", "");
              paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, str1, l, MessageUtils.a(ReadInJoyBaseDeliverActivity.b(str2.substring(0, str2.indexOf(str2.trim()) + str2.trim().length()), str3)), m));
            }
            bool1 = false;
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
    }
  }
  
  protected void c()
  {
    if (this.jdField_f_of_type_Boolean) {
      b("1");
    }
    ZhituManager localZhituManager = a();
    if ((localZhituManager != null) && (this.jdField_g_of_type_Boolean))
    {
      localZhituManager.c();
      this.jdField_g_of_type_Boolean = false;
      this.jdField_f_of_type_AndroidWidgetImageView.setSelected(false);
    }
  }
  
  public boolean c()
  {
    return false;
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData != null) || (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null))
    {
      QQToast.a(this.jdField_g_of_type_AndroidWidgetImageView.getContext(), "暂不支持将图片biu到点点", 0).a();
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130840738);
      this.jdField_a_of_type_Boolean = true;
      if (!this.jdField_h_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("readinjoy_comment_biu_switch_user_operation", true);
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().commit();
        this.jdField_h_of_type_Boolean = true;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label156;
      }
    }
    label156:
    for (String str = "0";; str = "1")
    {
      PublicAccountReportUtils.a(null, "", "0X8008F58", "0X8008F58", 0, 0, str, "", "", a(false), false);
      return;
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130840737);
      this.jdField_a_of_type_Boolean = false;
      break;
    }
  }
  
  public boolean d()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(0, a());
    return super.d();
  }
  
  protected void e()
  {
    ZhituManager localZhituManager = a();
    if (localZhituManager != null)
    {
      if (!this.jdField_g_of_type_Boolean) {
        break label60;
      }
      localZhituManager.c();
      this.jdField_g_of_type_Boolean = false;
      this.jdField_f_of_type_AndroidWidgetImageView.setSelected(false);
    }
    for (;;)
    {
      PublicAccountReportUtils.a(null, "", "0X8008F59", "0X8008F59", 0, 0, "", "", "", a(false), false);
      return;
      label60:
      Editable localEditable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getText();
      if (!localZhituManager.a(localEditable))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getContext(), "含有非常规字符，不支持转智图。", 0).a();
        return;
      }
      if (localEditable.length() > 24)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getContext(), "24个字符以内才支持转为智图。", 0).a();
        return;
      }
      localZhituManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_c_of_type_AndroidWidgetRelativeLayout, null, null, false, this.jdField_a_of_type_MqqOsMqqHandler);
      if (localZhituManager.a.getChildCount() > 1) {
        localZhituManager.a.removeViewAt(0);
      }
      localZhituManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, localEditable, null, 7220, false);
      localZhituManager.a(this);
      this.jdField_g_of_type_Boolean = true;
      this.jdField_f_of_type_AndroidWidgetImageView.setSelected(true);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(85);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(85, 10000L);
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
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
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(85);
      paramMessage = a();
      if ((paramMessage != null) && (this.jdField_g_of_type_Boolean))
      {
        paramMessage.c();
        this.jdField_g_of_type_Boolean = false;
        this.jdField_f_of_type_AndroidWidgetImageView.setSelected(false);
      }
    }
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
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131366929: 
    default: 
      return;
    case 2131366927: 
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.doOnBackPressed();
      return;
    case 2131366930: 
      h();
      return;
    case 2131366931: 
      i();
      return;
    case 2131364051: 
      j();
      return;
    case 2131366935: 
      n();
      return;
    case 2131366937: 
      o();
      return;
    case 2131366936: 
      c();
      return;
    case 2131366934: 
      e();
      return;
    }
    d();
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    paramLayoutInflater = paramLayoutInflater.inflate(2130969554, paramViewGroup, false);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131366927));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131366928));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131366929));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramLayoutInflater.findViewById(2131366930).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131366931));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131364051));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131366935));
    if (!HotPicManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app).b()) {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131366936));
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131366933));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131366937));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText = ((BiuEditText)paramLayoutInflater.findViewById(2131363479));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.requestFocus();
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setEditableFactory(this.jdField_a_of_type_AndroidTextEditable$Factory);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)paramLayoutInflater.findViewById(2131362822));
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText, false);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback);
        this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131366934));
        this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131366932));
        g();
        this.jdField_g_of_type_Int = ImmersiveUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          bool = true;
          this.jdField_d_of_type_Boolean = bool;
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131362843));
          this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
          if (ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getAppRuntime()))
          {
            paramViewGroup = paramLayoutInflater.findViewById(2131366941);
            if (paramViewGroup != null) {
              paramViewGroup.setVisibility(0);
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
          this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131366940));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131366939));
          this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131366938));
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
          if (e())
          {
            this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130840738);
            this.jdField_a_of_type_Boolean = true;
          }
          return paramLayoutInflater;
          this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
        }
      }
      catch (Exception paramViewGroup)
      {
        for (;;)
        {
          QLog.e("ReadInJoyCommentComponentFragment", 1, "input set error", paramViewGroup);
          continue;
          boolean bool = false;
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
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.setPublicAccountGifListener(null);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setReadyToShow(false);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.b();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(null);
      if (Build.VERSION.SDK_INT >= 16) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
      }
    }
    ZhituManager localZhituManager = a();
    if (localZhituManager != null) {
      localZhituManager.a(null);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    }
    b();
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
      ThreadManager.getUIHandler().postDelayed(new ljd(this), 300L);
    }
  }
  
  public void u_()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment
 * JD-Core Version:    0.7.0.1
 */