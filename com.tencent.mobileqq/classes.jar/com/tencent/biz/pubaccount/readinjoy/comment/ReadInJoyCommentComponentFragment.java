package com.tencent.biz.pubaccount.readinjoy.comment;

import ahtj;
import ahtr;
import ahua;
import amtj;
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
import augn;
import auis;
import bblk;
import bfuc;
import bhht;
import bjmp;
import bjvm;
import bkwm;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.readinjoy.biu.AtFriendsSpan;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuEditText;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuNicknameSpan;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentLinkData;
import com.tencent.biz.pubaccount.readinjoy.comment.event.AddCommentLinkEvent;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SimpleCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.CommentLinkView;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
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
import odq;
import ofe;
import ooy;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import osf;
import osg;
import osh;
import osi;
import osj;
import osk;
import osl;
import osm;
import osn;
import oso;
import oto;
import ouu;
import oyb;
import oyx;
import pay;
import pbm;
import pgb;
import pim;
import rep;
import rfe;
import rjl;
import sou;

public class ReadInJoyCommentComponentFragment
  extends PublicBaseFragment
  implements ahtr, Handler.Callback, View.OnClickListener, SimpleEventReceiver, oyb
{
  private static final Editable.Factory jdField_a_of_type_AndroidTextEditable$Factory = new osj();
  protected int a;
  private ahua jdField_a_of_type_Ahua;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  protected TextWatcher a;
  private View jdField_a_of_type_AndroidViewView;
  public ViewGroup.LayoutParams a;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  protected Button a;
  public FrameLayout a;
  public ImageView a;
  protected LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  private auis jdField_a_of_type_Auis = new osm(this);
  protected bhht a;
  private bjvm jdField_a_of_type_Bjvm = new osk(this);
  public BiuEditText a;
  private SimpleCommentData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData;
  private CommentLinkView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiCommentLinkView;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = new osl(this);
  public EmoticonMainPanel a;
  public HotPicData a;
  public PublicAccountHotPicPanel a;
  TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new osi(this);
  public XPanelContainer a;
  protected String a;
  private List<BaseCommentData.CommentLinkData> jdField_a_of_type_JavaUtilList;
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
  private boolean jdField_i_of_type_Boolean = true;
  private int jdField_j_of_type_Int = 1;
  private ImageView jdField_j_of_type_AndroidWidgetImageView;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int;
  private boolean jdField_m_of_type_Boolean;
  private int jdField_n_of_type_Int;
  private boolean jdField_n_of_type_Boolean;
  private boolean o;
  private boolean p;
  private boolean q = true;
  private boolean r;
  
  public ReadInJoyCommentComponentFragment()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 140;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_MqqOsMqqHandler = new bjmp(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_AndroidTextTextWatcher = new osf(this);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new osg(this);
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  private void A()
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
      ((JSONObject)localObject2).put("version", ofe.jdField_a_of_type_JavaLangString);
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
    odq.a(null, oto.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800AB7A", "0X800AB7A", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_e_of_type_Int), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject1, false);
  }
  
  private ahtj a()
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
      } while (((localBundle != null) && (!localBundle.getBoolean("arg_comment_zhitu_switch", true))) || (bkwm.i((AppRuntime)localObject) != 0));
      localObject = ahtj.a((AppInterface)localObject);
    } while ((localObject == null) || (!((ahtj)localObject).e()));
    return localObject;
  }
  
  private Intent a()
  {
    int i1 = 1;
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    JSONObject localJSONObject1 = new JSONObject();
    label1032:
    for (;;)
    {
      try
      {
        localJSONObject1.put("isAnonymous", this.jdField_c_of_type_Boolean);
        localJSONObject1.put("comment", new String(bfuc.encode(a().getBytes(), 0)));
        Object localObject1;
        Object localObject3;
        Object localObject4;
        oso localoso;
        JSONObject localJSONObject2;
        if ((this.jdField_a_of_type_Ahua != null) || (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null))
        {
          localJSONObject1.put("biuAfterComment", 0);
          if (this.jdField_m_of_type_Boolean)
          {
            if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
              continue;
            }
            localObject1 = "";
            localJSONObject1.put("replyUin", localObject1);
            localJSONObject1.put("isSecondReply", this.jdField_n_of_type_Boolean);
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
          localoso = (oso)((ArrayList)localObject3).get(i1);
          localJSONObject2 = new JSONObject();
        }
        try
        {
          localJSONObject2.put("uin", Long.valueOf(localoso.jdField_a_of_type_JavaLangString));
          localObject1 = "";
          if (TextUtils.isEmpty(localoso.jdField_a_of_type_JavaLangCharSequence)) {
            localoso.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
          }
          if (localoso.jdField_a_of_type_JavaLangCharSequence != null) {
            localObject1 = localoso.jdField_a_of_type_JavaLangCharSequence.toString();
          }
          localJSONObject2.put("nick", new String(bfuc.encode(((String)localObject1).getBytes(), 0)));
          localObject1 = "";
          if (localoso.b != null) {
            localObject1 = localoso.b.toString();
          }
          localJSONObject2.put("comment", new String(bfuc.encode(((String)localObject1).getBytes(), 0)));
          localJSONObject2.put("op_type", localoso.jdField_a_of_type_Int);
          ((JSONArray)localObject4).put(localJSONObject2);
          i1 -= 1;
          continue;
          if (!this.jdField_a_of_type_Boolean) {
            break label1032;
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
        if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
          localJSONObject1.put("linkList", new JSONArray(new Gson().toJson(this.jdField_a_of_type_JavaUtilList)));
        }
        if ((this.jdField_a_of_type_Ahua != null) && (this.jdField_a_of_type_Ahua.jdField_c_of_type_Boolean))
        {
          localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
          BitmapFactory.decodeFile(this.jdField_a_of_type_Ahua.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject2);
          localObject3 = new JSONArray();
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("picType", 3);
          ((JSONObject)localObject4).put("url", this.jdField_a_of_type_Ahua.jdField_f_of_type_JavaLangString);
          ((JSONObject)localObject4).put("md5", this.jdField_a_of_type_Ahua.g);
          ((JSONObject)localObject4).put("width", ((BitmapFactory.Options)localObject2).outWidth);
          ((JSONObject)localObject4).put("height", ((BitmapFactory.Options)localObject2).outHeight);
          ((JSONObject)localObject4).put("thumbnail_url", this.jdField_a_of_type_Ahua.jdField_f_of_type_JavaLangString);
          ((JSONObject)localObject4).put("thumbnail_md5", this.jdField_a_of_type_Ahua.g);
          ((JSONObject)localObject4).put("thumbnail_width", ((BitmapFactory.Options)localObject2).outWidth);
          ((JSONObject)localObject4).put("thumbnail_height", ((BitmapFactory.Options)localObject2).outHeight);
          ((JSONArray)localObject3).put(localObject4);
          localJSONObject1.put("picInfoList", localObject3);
        }
        Object localObject2 = localJSONObject1.toString();
        ReadInJoyUserInfoModule.a(Long.parseLong(pay.a()), null);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentComponentFragment", 2, "finish resultJson=" + (String)localObject2);
        }
        localIntent.putExtra("arg_result_json", (String)localObject2);
        localIntent.putExtra("comment_article_info", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        localIntent.putExtra("comment_gallery_channel", this.jdField_j_of_type_Boolean);
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
    return a(paramBoolean).toString();
  }
  
  private JSONObject a(boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("folder_status", pay.jdField_d_of_type_Int);
        if (paramBoolean)
        {
          if (!this.jdField_a_of_type_Boolean) {
            break label141;
          }
          localObject = "0";
          localJSONObject.put("biu_comment", localObject);
        }
        localJSONObject.put("os", 1);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData != null)
        {
          localJSONObject.put("entry", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData.d());
          localJSONObject.put("scene", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData.b());
          return localJSONObject;
        }
        Object localObject = ouu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        if (localObject != null)
        {
          localJSONObject.put("entry", ((ouu)localObject).a());
          localJSONObject.put("scene", 0);
          return localJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return localJSONObject;
      }
      localJSONObject.put("entry", 0);
      continue;
      label141:
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
    if (paramBundle.containsKey("comment_is_pgc_author"))
    {
      this.r = paramBundle.getBoolean("comment_is_pgc_author");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (ouu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID))) {}
    for (boolean bool = true;; bool = false)
    {
      this.r = bool;
      return;
    }
  }
  
  private void a(View paramView)
  {
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363555));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363558));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363552));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363559));
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363554));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363553));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363556));
  }
  
  private void a(BaseCommentData.CommentLinkData paramCommentLinkData)
  {
    if (paramCommentLinkData != null)
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilList.add(paramCommentLinkData);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiCommentLinkView.setData(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiCommentLinkView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_i_of_type_AndroidWidgetImageView.setImageResource(2130842855);
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_i_of_type_AndroidWidgetImageView.setImageResource(2130842854);
    this.jdField_b_of_type_Boolean = false;
  }
  
  private boolean a()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "onDeliver overlong!");
      }
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, getString(2131717326), 0).a();
      return false;
    }
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "onDeliver network error!");
      }
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, getString(2131717325), 0).a();
      return false;
    }
    return true;
  }
  
  /* Error */
  private Intent b()
  {
    // Byte code:
    //   0: new 222	java/lang/String
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 304	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:a	()Ljava/lang/String;
    //   8: invokevirtual 308	java/lang/String:getBytes	()[B
    //   11: iconst_0
    //   12: invokestatic 314	bfuc:encode	([BI)[B
    //   15: invokespecial 317	java/lang/String:<init>	([B)V
    //   18: astore 5
    //   20: aload_0
    //   21: invokespecial 538	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:a	()Landroid/content/Intent;
    //   24: astore 4
    //   26: new 168	org/json/JSONObject
    //   29: dup
    //   30: invokespecial 169	org/json/JSONObject:<init>	()V
    //   33: astore_2
    //   34: aload 4
    //   36: ldc_w 508
    //   39: invokevirtual 714	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore_3
    //   43: aload_3
    //   44: invokestatic 331	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifne +206 -> 253
    //   50: new 168	org/json/JSONObject
    //   53: dup
    //   54: aload_3
    //   55: invokespecial 715	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   58: astore_3
    //   59: aload_3
    //   60: astore_2
    //   61: aload_0
    //   62: getfield 323	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_m_of_type_Boolean	Z
    //   65: ifeq +61 -> 126
    //   68: aload_0
    //   69: getfield 325	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   72: invokestatic 331	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   75: ifeq +153 -> 228
    //   78: ldc 91
    //   80: astore_3
    //   81: aload_2
    //   82: ldc_w 333
    //   85: aload_3
    //   86: invokevirtual 198	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   89: pop
    //   90: aload_2
    //   91: ldc_w 335
    //   94: aload_0
    //   95: getfield 337	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_n_of_type_Boolean	Z
    //   98: invokevirtual 300	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   101: pop
    //   102: aload_2
    //   103: ldc_w 339
    //   106: aload_0
    //   107: getfield 93	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   110: invokevirtual 198	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   113: pop
    //   114: aload_2
    //   115: ldc_w 341
    //   118: aload_0
    //   119: getfield 95	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   122: invokevirtual 198	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   125: pop
    //   126: aload_2
    //   127: ldc_w 302
    //   130: aload 5
    //   132: invokevirtual 198	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   135: pop
    //   136: aload_2
    //   137: ldc_w 717
    //   140: aload_0
    //   141: getfield 675	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_b_of_type_Boolean	Z
    //   144: invokevirtual 300	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   147: pop
    //   148: aload 4
    //   150: ldc_w 508
    //   153: aload_2
    //   154: invokevirtual 210	org/json/JSONObject:toString	()Ljava/lang/String;
    //   157: invokevirtual 514	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   160: pop
    //   161: aload_0
    //   162: getfield 152	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   165: invokestatic 331	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   168: ifeq +76 -> 244
    //   171: iconst_2
    //   172: istore_1
    //   173: aload 4
    //   175: ldc_w 535
    //   178: iload_1
    //   179: invokevirtual 533	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   182: pop
    //   183: aload 4
    //   185: ldc_w 516
    //   188: aload_0
    //   189: getfield 157	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   192: invokevirtual 519	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   195: pop
    //   196: ldc 159
    //   198: iconst_1
    //   199: new 498	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 499	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 719
    //   209: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_2
    //   213: invokevirtual 210	org/json/JSONObject:toString	()Ljava/lang/String;
    //   216: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 506	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aload 4
    //   227: areturn
    //   228: aload_0
    //   229: getfield 325	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   232: astore_3
    //   233: goto -152 -> 81
    //   236: astore_3
    //   237: aload_3
    //   238: invokevirtual 576	org/json/JSONException:printStackTrace	()V
    //   241: goto -93 -> 148
    //   244: iconst_3
    //   245: istore_1
    //   246: goto -73 -> 173
    //   249: astore_3
    //   250: goto -13 -> 237
    //   253: goto -192 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	ReadInJoyCommentComponentFragment
    //   172	74	1	i1	int
    //   33	180	2	localObject1	Object
    //   42	191	3	localObject2	Object
    //   236	2	3	localJSONException1	JSONException
    //   249	1	3	localJSONException2	JSONException
    //   24	202	4	localIntent	Intent
    //   18	113	5	str	String
    // Exception table:
    //   from	to	target	type
    //   34	59	236	org/json/JSONException
    //   61	78	249	org/json/JSONException
    //   81	126	249	org/json/JSONException
    //   126	148	249	org/json/JSONException
    //   228	233	249	org/json/JSONException
  }
  
  private String b()
  {
    int i1 = 0;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("os", 1);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData != null) {
        localJSONObject.put("entry", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData.d());
      }
      for (;;)
      {
        if (this.jdField_n_of_type_Boolean) {
          break label142;
        }
        if (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData instanceof SubCommentCreateData)) {
          break label118;
        }
        break label142;
        localJSONObject.put("comment_level", i1);
        return localJSONObject.toString();
        ouu localouu = ouu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        if (localouu == null) {
          break;
        }
        localJSONObject.put("entry", localouu.a());
      }
    }
    catch (JSONException localJSONException)
    {
      label142:
      for (;;)
      {
        localJSONException.printStackTrace();
        continue;
        localJSONObject.put("entry", 0);
        continue;
        label118:
        if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
        {
          SimpleCommentData localSimpleCommentData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData;
          if (localSimpleCommentData == null) {}
        }
        else
        {
          i1 = 1;
          continue;
          i1 = 2;
        }
      }
    }
  }
  
  private void b(int paramInt)
  {
    int i3 = 2130849300;
    this.jdField_a_of_type_Int = paramInt;
    int i2 = 2130842975;
    int i1;
    if (paramInt == 1)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1)) {
        break label204;
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      paramInt = 2130842973;
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
            i1 = 2130849300;
            paramInt = 2130842973;
          }
        }
        else
        {
          if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)) {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
          }
          label204:
          paramInt = 2130842973;
          i1 = i2;
          continue;
        }
        i1 = 2130849300;
        paramInt = 2130842973;
      }
    }
  }
  
  private void b(Bundle paramBundle)
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
          String str2 = new String(bfuc.decode(((JSONObject)localObject2).optString("nick"), 0));
          String str1 = new String(bfuc.decode(((JSONObject)localObject2).optString("comment"), 0));
          ((JSONObject)localObject2).optString("op_type");
          long l2 = ((JSONObject)localObject2).optLong("feedsId");
          if (i1 != paramBundle.length() - 1)
          {
            localObject2 = "@" + str2 + " ";
            int i2 = ((SpannableStringBuilder)localObject1).length();
            ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2).append(str1);
            ((SpannableStringBuilder)localObject1).setSpan(new AtFriendsSpan(String.valueOf(l1), l2, (CharSequence)localObject2, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaint(), this.jdField_m_of_type_Int), i2, ((String)localObject2).length() + i2, 33);
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
          paramBundle = bblk.b(paramBundle);
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
  
  private boolean b()
  {
    return bkwm.p(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app) == 1;
  }
  
  private void c(int paramInt)
  {
    this.jdField_k_of_type_Int = paramInt;
  }
  
  private void c(Bundle paramBundle)
  {
    if (!paramBundle.getBoolean("arg_comment_gif_switch", true)) {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    while (bkwm.h(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app) != 1) {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void d(@NotNull Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("arg_comment_placeholder", "");
    QLog.d("ReadInJoyCommentComponentFragment", 2, "initData | comment_placeholder : " + this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setHint(this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setHint(amtj.a(2131712052));
  }
  
  private void e(@NotNull Bundle paramBundle)
  {
    int i1 = paramBundle.getInt("arg_comment_max_length", -1);
    if (i1 > 0) {
      this.jdField_c_of_type_Int = i1;
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Int > 5000) {
        this.jdField_c_of_type_Int = 5000;
      }
      if (this.jdField_c_of_type_Int < 100) {
        this.jdField_c_of_type_Int = 100;
      }
      return;
      this.jdField_c_of_type_Int = bkwm.a();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "initData | comment_mMaxCharCount : " + this.jdField_c_of_type_Int);
      }
    }
  }
  
  private void f(@NotNull Bundle paramBundle)
  {
    int i1 = 1;
    int i2 = paramBundle.getInt("arg_comment_open_at", 0);
    boolean bool;
    if ((bkwm.q(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app) == 0) && (i2 == 1))
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
  
  private void g(@NotNull Bundle paramBundle)
  {
    int i1 = 0;
    boolean bool;
    if ((this.r) && (bkwm.f()))
    {
      bool = true;
      this.jdField_h_of_type_Boolean = bool;
      this.jdField_l_of_type_Int = bkwm.b();
      paramBundle = this.jdField_j_of_type_AndroidWidgetImageView;
      if ((!this.jdField_h_of_type_Boolean) || (this.jdField_l_of_type_Int <= 0)) {
        break label59;
      }
    }
    for (;;)
    {
      paramBundle.setVisibility(i1);
      return;
      bool = false;
      break;
      label59:
      i1 = 8;
    }
  }
  
  private void h()
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
      this.jdField_i_of_type_Boolean = localBundle.getBoolean("comment_can_biu", true);
      d(localBundle);
      e(localBundle);
      f(localBundle);
      i();
      b(localBundle);
      c(localBundle);
      if (localBundle.getBoolean("arg_comment_transparent_bg", false)) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
      }
      Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentAccountUin();
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + (String)localObject, 4);
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
      this.jdField_n_of_type_Boolean = ((Intent)localObject).getBooleanExtra("comment_reply_second", false);
      if (this.jdField_n_of_type_Boolean) {
        this.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("comment_reply_second_uin");
      }
      this.jdField_m_of_type_Boolean = ((Intent)localObject).getBooleanExtra("comment_native", false);
      if (this.jdField_m_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)((Intent)localObject).getParcelableExtra("comment_article_info"));
        this.jdField_e_of_type_JavaLangString = ((Intent)localObject).getStringExtra("comment_val");
        this.jdField_f_of_type_JavaLangString = ((Intent)localObject).getStringExtra("comment_author_uin");
        this.jdField_i_of_type_Int = ((Intent)localObject).getIntExtra("biu_src", 1);
        this.jdField_j_of_type_Int = ((Intent)localObject).getIntExtra("feedsType", 1);
        this.jdField_c_of_type_JavaLangString = ((Intent)localObject).getStringExtra("comment_id");
        this.jdField_d_of_type_JavaLangString = ((Intent)localObject).getStringExtra("first_comment_uin");
        this.jdField_j_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mIsGalleryChannel;
      }
      a(localBundle);
      g(localBundle);
      a((Intent)localObject);
      this.jdField_d_of_type_Int = localBundle.getInt("arg_comment_comment_type", 0);
      this.jdField_e_of_type_Int = localBundle.getInt("arg_comment_source_type", 0);
      this.jdField_h_of_type_Int = localBundle.getInt("click_comment_edit_src");
      this.o = localBundle.getBoolean("arg_ad_show_biu", true);
      this.q = localBundle.getBoolean("comment_type", true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData = ((SimpleCommentData)localBundle.getParcelable("comment_create_data"));
      h(localBundle);
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void h(Bundle paramBundle)
  {
    int i2 = 1;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains(getString(2131717286)))) {}
    String str;
    for (int i1 = 2;; i1 = 1)
    {
      str = "";
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("folder_status", pay.jdField_d_of_type_Int);
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
            localJSONObject.put("consume_time", pbm.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, false) / 1000L);
          }
          localJSONObject.put("os", 1);
          localJSONObject.put("link_reply", paramBundle.getInt("comment_to_reply_contain_link", 2));
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData == null) {
            continue;
          }
          localJSONObject.put("entry", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData.d());
          localJSONObject.put("scene", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData.b());
          if (!this.jdField_h_of_type_Boolean) {
            continue;
          }
        }
        catch (JSONException paramBundle)
        {
          JSONObject localJSONObject;
          paramBundle.printStackTrace();
          paramBundle = str;
          continue;
          localJSONObject.put("entry", 0);
          continue;
          i2 = 0;
          continue;
        }
        localJSONObject.put("link_entry", i2);
        paramBundle = localJSONObject.toString();
        odq.a(null, oto.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800844A", "0X800844A", 0, 0, String.valueOf(i1), String.valueOf(this.jdField_e_of_type_Int), "", paramBundle, false);
        return;
        paramBundle = ouu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        if (paramBundle == null) {
          continue;
        }
        localJSONObject.put("entry", paramBundle.a());
        localJSONObject.put("scene", 0);
      }
    }
  }
  
  private void i()
  {
    if (this.jdField_m_of_type_Int <= 0)
    {
      this.jdField_m_of_type_Int = getResources().getDisplayMetrics().widthPixels;
      this.jdField_m_of_type_Int = (this.jdField_m_of_type_Int - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaddingLeft() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaddingRight());
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
      odq.a(null, "", "0X800844D", "0X800844D", 0, 0, "", "", "", a(false), false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = null;
      this.jdField_a_of_type_Ahua = null;
      p();
      this.jdField_g_of_type_AndroidWidgetImageView.setClickable(true);
      if (this.jdField_l_of_type_Boolean)
      {
        this.jdField_l_of_type_Boolean = false;
        this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842855);
      }
      return;
      if (this.jdField_a_of_type_Ahua != null) {
        odq.a(null, "", "0X8008F5A", "0X8008F5A", 0, 0, "", "", "", a(false), false);
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
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842734);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842733);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Int == 2) {
      b(1);
    }
    for (;;)
    {
      q();
      return;
      b(2);
      odq.a(null, "", "0X800844B", "0X800844B", 0, 0, "", "", "", a(false), false);
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_Int == 3) {
      b(1);
    }
    for (;;)
    {
      q();
      return;
      b(3);
      odq.a(null, "", "0X800844C", "0X800844C", 0, 0, "", "", "", a(false), false);
    }
  }
  
  private void o()
  {
    int i3 = 1;
    if (!a()) {
      return;
    }
    int i1;
    label33:
    String str;
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(a()))
    {
      i1 = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null)
      {
        i1 += 2;
        str = "0X800844E";
        if (this.jdField_h_of_type_Int == 1) {
          str = "0X80094A1";
        }
        localJSONObject = a(true);
      }
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label294;
        }
        if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
          break label235;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder;
        Iterator localIterator;
        localException.printStackTrace();
      }
      localJSONObject.put("link", i3);
      if (i2 == 0)
      {
        localStringBuilder = new StringBuilder();
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break label240;
        }
        localStringBuilder.append(((BaseCommentData.CommentLinkData)localIterator.next()).type).append(',');
        continue;
      }
      for (;;)
      {
        odq.a(null, oto.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), str, str, 0, 0, String.valueOf(this.jdField_d_of_type_Int), String.valueOf(i1), "", localJSONObject.toString(), false);
        if (this.jdField_a_of_type_Ahua != null) {
          break label267;
        }
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1, a());
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
        return;
        if (this.jdField_a_of_type_Ahua == null) {
          break label286;
        }
        i1 += 4;
        break;
        label235:
        i2 = 0;
        break label296;
        label240:
        localJSONObject.put("link_type", localException.deleteCharAt(localException.length() - 1).toString());
      }
      label267:
      a(2131694781);
      a(this.jdField_a_of_type_Ahua.jdField_b_of_type_JavaLangString);
      return;
      label286:
      break label33;
      i1 = 0;
      break;
      label294:
      int i2 = 1;
      label296:
      if (i2 != 0) {
        i3 = 0;
      }
    }
  }
  
  private void p()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData == null)
    {
      if (this.jdField_a_of_type_Ahua == null) {
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
    ahtj localahtj = a();
    if ((localahtj != null) && (this.jdField_k_of_type_Boolean))
    {
      localahtj.c();
      this.jdField_k_of_type_Boolean = false;
      this.jdField_f_of_type_AndroidWidgetImageView.setSelected(false);
    }
  }
  
  private void r()
  {
    s();
    q();
  }
  
  private void s()
  {
    SimpleEventBus.getInstance().registerReceiver(this);
    Bundle localBundle = new Bundle();
    int i2 = this.jdField_l_of_type_Int;
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i1 = 0;; i1 = this.jdField_a_of_type_JavaUtilList.size())
    {
      pay.a(getActivity(), "https://viola.qq.com/js/commLinkSelector.js?_rij_violaUrl=1&v_tid=6&v_bundleName=commLinkSelector&hideNav=1&v_nav_immer=1&v_bid=3740&remainLinkCount=" + (i2 - i1), localBundle);
      odq.a(null, oto.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800B085", "0X800B085", 0, 0, "", "", "", b(), false);
      return;
    }
  }
  
  private void t()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (((!pgb.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (oyx.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.b()))) {
      this.jdField_i_of_type_Boolean = false;
    }
    if (!this.jdField_i_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void u()
  {
    if ((ooy.a()) && (this.q)) {
      this.p = true;
    }
    if (!this.p)
    {
      QLog.d("ReadInJoyCommentComponentFragment", 1, "initBiuAndCommentMix isBiuAndCommentMixType is false");
      return;
    }
    v();
    x();
    A();
  }
  
  private void v()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    w();
  }
  
  private void w()
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = ooy.b().split("\\|");
    if (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
      this.jdField_n_of_type_Int = new Random().nextInt(this.jdField_a_of_type_ArrayOfJavaLangString.length);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_n_of_type_Int])) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_n_of_type_Int]);
    }
    String str = ooy.c();
    if (!TextUtils.isEmpty(str)) {
      this.jdField_b_of_type_AndroidWidgetButton.setText(str);
    }
    if (ooy.d()) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      str = ooy.d();
      if (!TextUtils.isEmpty(str)) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(str);
      }
      if (ooy.b()) {
        a(true);
      }
    } while (!ooy.c());
    if (((Boolean)bkwm.a("rij_sp_editor_last_check", Boolean.valueOf(false))).booleanValue())
    {
      a(true);
      return;
    }
    a(false);
  }
  
  private void x()
  {
    osh localosh = new osh(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(localosh);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(localosh);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(localosh);
  }
  
  private void y()
  {
    z();
    if (!a()) {
      return;
    }
    if (ooy.c()) {
      bkwm.a("rij_sp_editor_last_check", Boolean.valueOf(this.jdField_b_of_type_Boolean));
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(1699, b());
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
  
  private void z()
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
      ((JSONObject)localObject2).put("version", ofe.jdField_a_of_type_JavaLangString);
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
    odq.a(null, oto.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800AB7B", "0X800AB7B", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_e_of_type_Int), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject1, false);
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
      localObject = rjl.a(localObject.toString(), str).trim();
      if (((String)localObject).length() <= 0) {
        str = "";
      } else {
        str = bblk.a(rjl.b(((String)localObject).replaceAll("\n|\r\n", ""), str));
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
      new SocializeFeedsInfo().jdField_a_of_type_Rep = new rep();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep != null))
      {
        localJSONObject1.put("mOriFeedType", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.b);
        localJSONObject1.put("mOriFeedId", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_a_of_type_JavaLangLong);
      }
      localJSONObject1.put("biuSrc", this.jdField_i_of_type_Int);
      localJSONObject1.put("feedtype", this.jdField_j_of_type_Int);
      JSONArray localJSONArray = new JSONArray();
      int i1 = 0;
      while (i1 < localArrayList.size())
      {
        oso localoso = (oso)localArrayList.get(i1);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("biu_info_comment", localoso.b);
        localJSONObject2.put("biu_feedid", new Long(localoso.jdField_a_of_type_Long));
        localJSONObject2.put("biu_optype", localoso.jdField_a_of_type_Int);
        localJSONObject2.put("biu_uin", localoso.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("biu_nickname", localoso.jdField_a_of_type_JavaLangCharSequence);
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
    if (this.jdField_a_of_type_Bhht != null)
    {
      this.jdField_a_of_type_Bhht.c(paramInt);
      if (!this.jdField_a_of_type_Bhht.isShowing()) {
        this.jdField_a_of_type_Bhht.show();
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
      i();
    } while (paramIntent == null);
    Object localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
      String str = "@" + BiuNicknameSpan.a(localResultRecord.name) + " ";
      paramIntent.insert(paramInt, str);
      paramIntent.setSpan(new AtFriendsSpan(localResultRecord.uin, 0L, str, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getPaint(), this.jdField_m_of_type_Int), paramInt, str.length() + paramInt, 33);
      paramInt = str.length() + paramInt;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(paramInt);
  }
  
  public void a(int paramInt, CharSequence paramCharSequence)
  {
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramInt, paramCharSequence, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  public void a(ahua paramahua)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "onZhituSend:" + paramahua);
    }
    this.jdField_a_of_type_Ahua = paramahua;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = null;
    ThreadManager.getUIHandler().post(new ReadInJoyCommentComponentFragment.9(this, paramahua));
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "startUploadPic path=" + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      g();
      a(1, getString(2131717343));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "startUploadPic empty path!");
      }
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyCommentComponentFragment.3(this, paramString));
  }
  
  protected boolean a(ArrayList<oso> paramArrayList)
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
      paramArrayList.add(new oso(this, str1, 0L, ""));
      return false;
    }
    String str3 = UUID.randomUUID().toString();
    Object localObject3 = rjl.a(localEditable.toString(), str3).trim();
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      paramArrayList.add(new oso(this, str1, 0L, ""));
      return true;
    }
    localObject1 = (BiuNicknameSpan[])localEditable.getSpans(0, localEditable.length(), BiuNicknameSpan.class);
    if ((localObject1 == null) || (localObject1.length <= 0))
    {
      paramArrayList.add(new oso(this, str1, 0L, bblk.a(rjl.b(((String)localObject3).replaceAll("\n|\r\n", ""), str3))));
      return true;
    }
    localObject3 = new ArrayList();
    ((ArrayList)localObject3).addAll(Arrays.asList((Object[])localObject1));
    Collections.sort((List)localObject3, new osn(this, localEditable));
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
          localObject1 = rjl.a((String)localObject1, str3).replaceAll("\n|\r\n", "");
          if (i2 != 0) {
            break label545;
          }
          localObject1 = ((String)localObject1).substring(((String)localObject1).indexOf(((String)localObject1).trim()));
          paramArrayList.add(new oso(this, str1, l1, bblk.a(rjl.b((String)localObject1, str3)), i1));
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
          str2 = rjl.a(str2, str3).replaceAll("\n|\r\n", "");
          paramArrayList.add(new oso(this, str1, l1, bblk.a(rjl.b(str2.substring(0, str2.indexOf(str2.trim()) + str2.trim().length()), str3)), i1));
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
    q();
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_min", 1);
    localIntent.putExtra("param_max", 10);
    startActivityForResult(localIntent, 10000);
    odq.a(null, "", "0X8008660", "0X8008660", 0, 0, paramString, "", "", a(false), false);
  }
  
  protected boolean b(ArrayList<oso> paramArrayList)
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
      if ((pay.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_h_of_type_Int == 1)) {}
      int i4;
      int i1;
      for (int i3 = 1;; i3 = 0)
      {
        i4 = 0;
        i1 = 0;
        if ((localEditable != null) && (!TextUtils.isEmpty(localEditable.toString()))) {
          break;
        }
        paramArrayList.add(new oso(this, (String)localObject1, 0L, ""));
        return false;
      }
      String str2 = UUID.randomUUID().toString();
      Object localObject4 = rjl.a(localEditable.toString(), str2).trim();
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        paramArrayList.add(new oso(this, (String)localObject1, 0L, ""));
      }
      for (boolean bool = true;; bool = true)
      {
        if (i2 != 0)
        {
          this.jdField_e_of_type_JavaLangString = (": " + this.jdField_e_of_type_JavaLangString);
          paramArrayList.add(new oso(this, this.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId, this.jdField_e_of_type_JavaLangString, 0));
        }
        if ((i3 == 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_a_of_type_JavaUtilList == null)) {
          break label882;
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_a_of_type_JavaUtilList;
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
        str2 = bblk.a(rjl.b(((String)localObject4).replaceAll("\n|\r\n", ""), str2));
        if (i2 == 0)
        {
          localObject2 = str2;
          if (i3 == 0) {}
        }
        else
        {
          localObject2 = str2 + "//";
        }
        paramArrayList.add(new oso(this, (String)localObject1, 0L, "：" + (String)localObject2));
      }
      localObject4 = new ArrayList();
      ((ArrayList)localObject4).addAll(Arrays.asList((Object[])localObject2));
      Collections.sort((List)localObject4, new osn(this, localEditable));
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
              localObject2 = rjl.a((String)localObject2, str2).replaceAll("\n|\r\n", "");
              if (i4 != 0) {
                break label885;
              }
              localObject2 = ((String)localObject2).substring(((String)localObject2).indexOf(((String)localObject2).trim()));
              paramArrayList.add(new oso(this, (String)localObject1, l1, bblk.a(rjl.b((String)localObject2, str2)), i1));
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
              str1 = rjl.a(str1, str2).replaceAll("\n|\r\n", "");
              paramArrayList.add(new oso(this, (String)localObject1, l1, bblk.a(rjl.b(str1.substring(0, str1.indexOf(str1.trim()) + str1.trim().length()), str2)), i1));
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
        paramArrayList.add(new oso(this, String.valueOf(localObject3.jdField_a_of_type_JavaLangLong), localObject3.b.longValue(), localObject3.jdField_a_of_type_JavaLangString, localObject3.jdField_c_of_type_Int));
        break label357;
        return bool;
      }
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiCommentLinkView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    odq.a(null, oto.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800B086", "0X800B086", 0, 0, "", "", "", b(), false);
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_Ahua != null) || (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null))
    {
      QQToast.a(this.jdField_g_of_type_AndroidWidgetImageView.getContext(), amtj.a(2131712080), 0).a();
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842855);
      this.jdField_a_of_type_Boolean = true;
      if (!this.jdField_a_of_type_Boolean) {
        break label113;
      }
    }
    label113:
    for (String str = "0";; str = "1")
    {
      odq.a(null, "", "0X8008F58", "0X8008F58", 0, 0, str, "", "", a(false), false);
      return;
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842854);
      this.jdField_a_of_type_Boolean = false;
      break;
    }
  }
  
  protected void e()
  {
    c(1);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1, a());
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
  
  protected void f()
  {
    ahtj localahtj = a();
    if (localahtj != null)
    {
      if (!this.jdField_k_of_type_Boolean) {
        break label47;
      }
      q();
    }
    for (;;)
    {
      odq.a(null, "", "0X8008F59", "0X8008F59", 0, 0, "", "", "", a(false), false);
      return;
      label47:
      Editable localEditable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getText();
      if (!localahtj.a(localEditable))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getContext(), amtj.a(2131711854), 0).a();
        return;
      }
      if (localEditable.length() > 24)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getContext(), "24个字符以内才支持转为智图。", 0).a();
        return;
      }
      localahtj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_c_of_type_AndroidWidgetRelativeLayout, null, null, false, this.jdField_a_of_type_MqqOsMqqHandler);
      if (localahtj.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 1) {
        localahtj.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(0);
      }
      localahtj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, localEditable, null, 7220, false);
      localahtj.a(this);
      this.jdField_k_of_type_Boolean = true;
      this.jdField_f_of_type_AndroidWidgetImageView.setSelected(true);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(84);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(84, 10000L);
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing())) {
      this.jdField_a_of_type_Bhht.dismiss();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AddCommentLinkEvent.class);
    return localArrayList;
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
      q();
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
      r();
      continue;
      f();
      continue;
      d();
      continue;
      e();
    }
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    paramLayoutInflater = paramLayoutInflater.inflate(2131560100, paramViewGroup, false);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131363266));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131368414));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131368415));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramLayoutInflater.findViewById(2131368418).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131362705));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131365953));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131367573));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131368507));
    if (!augn.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app).b()) {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131363014));
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
      this.jdField_j_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131369991));
      this.jdField_j_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiCommentLinkView = ((CommentLinkView)paramLayoutInflater.findViewById(2131370000));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiCommentLinkView.setOnLinkEmptyListener(this);
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131369997);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131364390));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131365414));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText = ((BiuEditText)paramLayoutInflater.findViewById(2131368750));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.requestFocus();
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setEditableFactory(jdField_a_of_type_AndroidTextEditable$Factory);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)paramLayoutInflater.findViewById(2131376679));
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText, false);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this.jdField_a_of_type_Bjvm);
        this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131381310));
        this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131381313));
        a(paramLayoutInflater);
        h();
        this.jdField_g_of_type_Int = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          bool = true;
          this.jdField_e_of_type_Boolean = bool;
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131367125));
          this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
          if (ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getAppRuntime()))
          {
            paramViewGroup = paramLayoutInflater.findViewById(2131371800);
            if (paramViewGroup != null) {
              paramViewGroup.setVisibility(0);
            }
          }
          this.jdField_a_of_type_Bhht = new bhht(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          this.jdField_a_of_type_Bhht.setCanceledOnTouchOutside(true);
          this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131364831));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131365415));
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131363562));
        }
      }
      catch (Exception paramViewGroup)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfe.jdField_a_of_type_Boolean) {
              this.o = false;
            }
            if (this.o) {
              break label738;
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            if (b())
            {
              this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842855);
              this.jdField_a_of_type_Boolean = true;
            }
            t();
            u();
            pim.a.a(getActivity());
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
            label738:
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
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onDestory();
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
    ahtj localahtj = a();
    if (localahtj != null) {
      localahtj.a(null);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getTransFileController().removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    }
    a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.a();
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
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
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AddCommentLinkEvent)) {
      a(((AddCommentLinkEvent)paramSimpleBaseEvent).linkData);
    }
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
    sou.a(getActivity(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment
 * JD-Core Version:    0.7.0.1
 */