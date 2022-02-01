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
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.AtFriendsSpan;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuEditText;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuNicknameSpan;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentLinkData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.event.AddCommentLinkEvent;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SimpleCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.comment.topic.RIJCommentTopicUi;
import com.tencent.biz.pubaccount.readinjoy.comment.topic.RIJCommentTopicUtil;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.CommentLinkView;
import com.tencent.biz.pubaccount.readinjoy.comment.ui.CommentLinkView.OnLinkDeleteListener;
import com.tencent.biz.pubaccount.readinjoy.common.ArticleInfoHelper;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.TimeSliceHelper;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtReportHelper;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyUserProtocolWidget;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager.ZhituSendListener;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPicData;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.hotpic.PublicAccountGifListener;
import com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.PanelCallback;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyCommentComponentFragment
  extends PublicBaseFragment
  implements Handler.Callback, View.OnClickListener, CommentLinkView.OnLinkDeleteListener, SimpleEventReceiver, ZhituManager.ZhituSendListener
{
  private static final Editable.Factory jdField_a_of_type_AndroidTextEditable$Factory = new ReadInJoyCommentComponentFragment.5();
  private static HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  protected int a;
  private long jdField_a_of_type_Long = 0L;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
  protected TextWatcher a;
  private View jdField_a_of_type_AndroidViewView;
  protected ViewGroup.LayoutParams a;
  protected ViewTreeObserver.OnGlobalLayoutListener a;
  protected Button a;
  protected FrameLayout a;
  protected ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected BiuEditText a;
  private SimpleCommentData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData = null;
  private RIJCommentTopicUi jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentTopicRIJCommentTopicUi;
  private CommentLinkView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiCommentLinkView;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
  private ZhituPicData jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData = null;
  private EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = new ReadInJoyCommentComponentFragment.7(this);
  protected EmoticonMainPanel a;
  protected HotPicData a;
  private PublicAccountGifListener jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountGifListener = new ReadInJoyCommentComponentFragment.8(this);
  protected PublicAccountHotPicPanel a;
  TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new ReadInJoyCommentComponentFragment.4(this);
  protected QQProgressDialog a;
  private XPanelContainer.PanelCallback jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback = new ReadInJoyCommentComponentFragment.6(this);
  protected XPanelContainer a;
  protected String a;
  private List<BaseCommentData.CommentLinkData> jdField_a_of_type_JavaUtilList;
  protected final MqqHandler a;
  protected boolean a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  protected int b;
  protected Button b;
  protected ImageView b;
  protected LinearLayout b;
  protected RelativeLayout b;
  protected TextView b;
  private String b;
  protected boolean b;
  protected int c;
  protected ImageView c;
  protected RelativeLayout c;
  protected TextView c;
  private String c;
  protected boolean c;
  protected int d;
  protected ImageView d;
  protected RelativeLayout d;
  protected TextView d;
  private String d;
  protected boolean d;
  protected int e;
  protected ImageView e;
  protected RelativeLayout e;
  private String e;
  protected boolean e;
  protected int f;
  protected ImageView f;
  private String jdField_f_of_type_JavaLangString = "";
  private boolean jdField_f_of_type_Boolean;
  protected int g;
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
  private int jdField_k_of_type_Int = 0;
  private ImageView jdField_k_of_type_AndroidWidgetImageView;
  private boolean jdField_k_of_type_Boolean = false;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean = false;
  private int jdField_m_of_type_Int = 0;
  private boolean jdField_m_of_type_Boolean = false;
  private int jdField_n_of_type_Int = 0;
  private boolean jdField_n_of_type_Boolean = false;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private boolean r = true;
  private boolean s;
  
  public ReadInJoyCommentComponentFragment()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 140;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = null;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = null;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_AndroidTextTextWatcher = new ReadInJoyCommentComponentFragment.10(this);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new ReadInJoyCommentComponentFragment.11(this);
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  private void A()
  {
    ReadInJoyCommentComponentFragment.12 local12 = new ReadInJoyCommentComponentFragment.12(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(local12);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(local12);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(local12);
  }
  
  private void B()
  {
    C();
    if (!b()) {
      return;
    }
    if (RIJBiuAndCommentAladdinUtils.c()) {
      ReadInJoyHelper.a("rij_sp_editor_last_check", Boolean.valueOf(this.jdField_b_of_type_Boolean));
    }
    l();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(1699, b());
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
  
  private void C()
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
      ((JSONObject)localObject2).put("version", VideoReporter.jdField_a_of_type_JavaLangString);
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
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800AB7B", "0X800AB7B", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_e_of_type_Int), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject1, false);
  }
  
  private void D()
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
      ((JSONObject)localObject2).put("version", VideoReporter.jdField_a_of_type_JavaLangString);
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
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800AB7A", "0X800AB7A", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_e_of_type_Int), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject1, false);
  }
  
  private Intent a()
  {
    int i1 = 1;
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    JSONObject localJSONObject1 = new JSONObject();
    label1045:
    for (;;)
    {
      try
      {
        localJSONObject1.put("isAnonymous", this.jdField_c_of_type_Boolean);
        localJSONObject1.put("comment", new String(Base64Util.encode(a().getBytes(), 0)));
        RIJCommentTopicUtil.a(localJSONObject1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getText());
        Object localObject1;
        Object localObject3;
        Object localObject4;
        ReadInJoyCommentComponentFragment.UserBiuInfo localUserBiuInfo;
        JSONObject localJSONObject2;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData != null) || (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null))
        {
          localJSONObject1.put("biuAfterComment", 0);
          if (this.jdField_n_of_type_Boolean)
          {
            if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
              continue;
            }
            localObject1 = "";
            localJSONObject1.put("replyUin", localObject1);
            localJSONObject1.put("isSecondReply", this.o);
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
          localUserBiuInfo = (ReadInJoyCommentComponentFragment.UserBiuInfo)((ArrayList)localObject3).get(i1);
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
          i1 -= 1;
          continue;
          if (!this.jdField_a_of_type_Boolean) {
            break label1045;
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
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.jdField_c_of_type_Boolean))
        {
          localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
          BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject2);
          localObject3 = new JSONArray();
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("picType", 3);
          ((JSONObject)localObject4).put("url", this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.jdField_f_of_type_JavaLangString);
          ((JSONObject)localObject4).put("md5", this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.g);
          ((JSONObject)localObject4).put("width", ((BitmapFactory.Options)localObject2).outWidth);
          ((JSONObject)localObject4).put("height", ((BitmapFactory.Options)localObject2).outHeight);
          ((JSONObject)localObject4).put("thumbnail_url", this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.jdField_f_of_type_JavaLangString);
          ((JSONObject)localObject4).put("thumbnail_md5", this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.g);
          ((JSONObject)localObject4).put("thumbnail_width", ((BitmapFactory.Options)localObject2).outWidth);
          ((JSONObject)localObject4).put("thumbnail_height", ((BitmapFactory.Options)localObject2).outHeight);
          ((JSONArray)localObject3).put(localObject4);
          localJSONObject1.put("picInfoList", localObject3);
        }
        Object localObject2 = localJSONObject1.toString();
        ReadInJoyUserInfoModule.a(Long.parseLong(ReadInJoyUtils.a()), null);
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
      } while (((localBundle != null) && (!localBundle.getBoolean("arg_comment_zhitu_switch", true))) || (ReadInJoyHelper.i((AppRuntime)localObject) != 0));
      localObject = ZhituManager.a((AppInterface)localObject);
    } while ((localObject == null) || (!((ZhituManager)localObject).e()));
    return localObject;
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
        localJSONObject.put("folder_status", RIJKanDianFolderStatus.jdField_a_of_type_Int);
        if (paramBoolean)
        {
          if (!this.jdField_a_of_type_Boolean) {
            break label145;
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
        Object localObject = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        if (localObject != null)
        {
          localJSONObject.put("entry", ((ReadInJoyCommentDataManager)localObject).a());
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
      label145:
      String str = "1";
    }
  }
  
  private void a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("comment_recreate_draft");
    paramIntent = str;
    if (TextUtils.isEmpty(str))
    {
      paramIntent = b();
      paramIntent = (String)jdField_a_of_type_JavaUtilHashMap.get(paramIntent);
    }
    c(paramIntent);
  }
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle.containsKey("comment_is_pgc_author"))
    {
      this.s = paramBundle.getBoolean("comment_is_pgc_author");
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID))) {}
    for (boolean bool = true;; bool = false)
    {
      this.s = bool;
      return;
    }
  }
  
  private void a(View paramView)
  {
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363715));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363718));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363712));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363719));
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363714));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363713));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363716));
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
  
  private void a(String paramString1, String paramString2, @NotNull Editable paramEditable, @NotNull ArrayList<ReadInJoyCommentComponentFragment.UserBiuInfo> paramArrayList, @NotNull BiuNicknameSpan[] paramArrayOfBiuNicknameSpan)
  {
    int i1 = 0;
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(Arrays.asList(paramArrayOfBiuNicknameSpan));
    Collections.sort((List)localObject, new ReadInJoyCommentComponentFragment.BiuSpanComparator(this, paramEditable));
    long l1 = 0L;
    localObject = ((ArrayList)localObject).iterator();
    int i2 = 0;
    BiuNicknameSpan localBiuNicknameSpan;
    int i4;
    int i3;
    if (((Iterator)localObject).hasNext())
    {
      localBiuNicknameSpan = (BiuNicknameSpan)((Iterator)localObject).next();
      i4 = paramEditable.getSpanStart(localBiuNicknameSpan);
      i3 = paramEditable.getSpanEnd(localBiuNicknameSpan);
    }
    label326:
    for (;;)
    {
      try
      {
        paramArrayOfBiuNicknameSpan = paramEditable.subSequence(i2, i4).toString();
        if (paramArrayOfBiuNicknameSpan != null)
        {
          paramArrayOfBiuNicknameSpan = Utils.a(paramArrayOfBiuNicknameSpan, paramString1).replaceAll("\n|\r\n", "");
          if (i2 != 0) {
            break label326;
          }
          paramArrayOfBiuNicknameSpan = paramArrayOfBiuNicknameSpan.substring(paramArrayOfBiuNicknameSpan.indexOf(paramArrayOfBiuNicknameSpan.trim()));
          paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, paramString2, l1, EmotionCodecUtils.a(Utils.b(paramArrayOfBiuNicknameSpan, paramString1)), i1));
        }
        if ((localBiuNicknameSpan instanceof AtFriendsSpan))
        {
          i1 = 1;
          paramString2 = localBiuNicknameSpan.jdField_a_of_type_JavaLangString;
          l1 = localBiuNicknameSpan.jdField_a_of_type_Long;
          i2 = i3;
        }
      }
      catch (Exception paramArrayOfBiuNicknameSpan)
      {
        paramArrayOfBiuNicknameSpan.printStackTrace();
        paramArrayOfBiuNicknameSpan = null;
        continue;
        i1 = 0;
        continue;
      }
      try
      {
        paramEditable = paramEditable.subSequence(i2, paramEditable.length()).toString();
        if (paramEditable != null)
        {
          paramEditable = Utils.a(paramEditable, paramString1).replaceAll("\n|\r\n", "");
          paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, paramString2, l1, EmotionCodecUtils.a(Utils.b(paramEditable.substring(0, paramEditable.indexOf(paramEditable.trim()) + paramEditable.trim().length()), paramString1)), i1));
        }
        return;
      }
      catch (Exception paramEditable)
      {
        for (;;)
        {
          paramEditable.printStackTrace();
          paramEditable = null;
        }
      }
    }
  }
  
  private void a(@NotNull ArrayList<ReadInJoyCommentComponentFragment.UserBiuInfo> paramArrayList)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList != null))
    {
      List localList = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList;
      int i2 = localList.size();
      int i1 = 0;
      if (i1 < i2)
      {
        SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localList.get(i1);
        if (localBiuCommentInfo == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, String.valueOf(localBiuCommentInfo.mUin), localBiuCommentInfo.mFeedId.longValue(), localBiuCommentInfo.mBiuComment, localBiuCommentInfo.mOpType));
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_i_of_type_AndroidWidgetImageView.setImageResource(2130843042);
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_i_of_type_AndroidWidgetImageView.setImageResource(2130843041);
    this.jdField_b_of_type_Boolean = false;
  }
  
  private boolean a()
  {
    return TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString);
  }
  
  private boolean a(String paramString, @NotNull Editable paramEditable, @NotNull ArrayList<ReadInJoyCommentComponentFragment.UserBiuInfo> paramArrayList)
  {
    if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2;
      String str1;
      String str2;
      if ((RIJFeedsType.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_h_of_type_Int == 1))
      {
        bool2 = true;
        str1 = UUID.randomUUID().toString();
        str2 = Utils.a(paramEditable.toString(), str1).trim();
        if (!TextUtils.isEmpty(str2)) {
          break label181;
        }
        paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, paramString, 0L, ""));
      }
      label181:
      for (boolean bool3 = true;; bool3 = a(paramArrayList, paramString, paramEditable, str2, str1, bool1, bool2))
      {
        if (bool1)
        {
          this.jdField_e_of_type_JavaLangString = (": " + this.jdField_e_of_type_JavaLangString);
          paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, this.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId, this.jdField_e_of_type_JavaLangString, 0));
        }
        if (bool2) {
          a(paramArrayList);
        }
        return bool3;
        bool2 = false;
        break;
      }
    }
  }
  
  private boolean a(@NotNull ArrayList<ReadInJoyCommentComponentFragment.UserBiuInfo> paramArrayList, String paramString1, @NotNull Editable paramEditable, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    BiuNicknameSpan[] arrayOfBiuNicknameSpan = (BiuNicknameSpan[])paramEditable.getSpans(0, paramEditable.length(), BiuNicknameSpan.class);
    if ((arrayOfBiuNicknameSpan == null) || (arrayOfBiuNicknameSpan.length <= 0))
    {
      paramString2 = EmotionCodecUtils.a(Utils.b(paramString2.replaceAll("\n|\r\n", ""), paramString3));
      if (!paramBoolean1)
      {
        paramEditable = paramString2;
        if (!paramBoolean2) {}
      }
      else
      {
        paramEditable = paramString2 + "//";
      }
      paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, paramString1, 0L, "：" + paramEditable));
      return true;
    }
    a(paramString3, paramString1, paramEditable, paramArrayList, arrayOfBiuNicknameSpan);
    return false;
  }
  
  /* Error */
  private Intent b()
  {
    // Byte code:
    //   0: new 356	java/lang/String
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 393	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:a	()Ljava/lang/String;
    //   8: invokevirtual 397	java/lang/String:getBytes	()[B
    //   11: iconst_0
    //   12: invokestatic 403	com/tencent/mobileqq/utils/Base64Util:encode	([BI)[B
    //   15: invokespecial 406	java/lang/String:<init>	([B)V
    //   18: astore 5
    //   20: aload_0
    //   21: invokespecial 632	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:a	()Landroid/content/Intent;
    //   24: astore 4
    //   26: new 295	org/json/JSONObject
    //   29: dup
    //   30: invokespecial 296	org/json/JSONObject:<init>	()V
    //   33: astore_2
    //   34: aload 4
    //   36: ldc_w 604
    //   39: invokevirtual 708	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore_3
    //   43: aload_3
    //   44: invokestatic 427	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   47: ifne +207 -> 254
    //   50: new 295	org/json/JSONObject
    //   53: dup
    //   54: aload_3
    //   55: invokespecial 964	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   58: astore_3
    //   59: aload_3
    //   60: astore_2
    //   61: aload_0
    //   62: getfield 137	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_n_of_type_Boolean	Z
    //   65: ifeq +61 -> 126
    //   68: aload_0
    //   69: getfield 141	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   72: invokestatic 427	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   75: ifeq +154 -> 229
    //   78: ldc 143
    //   80: astore_3
    //   81: aload_2
    //   82: ldc_w 429
    //   85: aload_3
    //   86: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   89: pop
    //   90: aload_2
    //   91: ldc_w 431
    //   94: aload_0
    //   95: getfield 139	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:o	Z
    //   98: invokevirtual 389	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   101: pop
    //   102: aload_2
    //   103: ldc_w 433
    //   106: aload_0
    //   107: getfield 145	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   110: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   113: pop
    //   114: aload_2
    //   115: ldc_w 435
    //   118: aload_0
    //   119: getfield 147	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   122: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   125: pop
    //   126: aload_2
    //   127: ldc_w 391
    //   130: aload 5
    //   132: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   135: pop
    //   136: aload_2
    //   137: ldc_w 966
    //   140: aload_0
    //   141: getfield 95	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_b_of_type_Boolean	Z
    //   144: invokevirtual 389	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   147: pop
    //   148: aload 4
    //   150: ldc_w 604
    //   153: aload_2
    //   154: invokevirtual 336	org/json/JSONObject:toString	()Ljava/lang/String;
    //   157: invokevirtual 610	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   160: pop
    //   161: aload_0
    //   162: getfield 218	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   165: invokestatic 427	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   168: ifeq +77 -> 245
    //   171: iconst_2
    //   172: istore_1
    //   173: aload 4
    //   175: ldc_w 629
    //   178: iload_1
    //   179: invokevirtual 627	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   182: pop
    //   183: aload 4
    //   185: ldc_w 612
    //   188: aload_0
    //   189: getfield 212	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;
    //   192: invokevirtual 615	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   195: pop
    //   196: ldc_w 286
    //   199: iconst_1
    //   200: new 594	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 595	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 968
    //   210: invokevirtual 601	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_2
    //   214: invokevirtual 336	org/json/JSONObject:toString	()Ljava/lang/String;
    //   217: invokevirtual 601	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 602	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 293	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: aload 4
    //   228: areturn
    //   229: aload_0
    //   230: getfield 141	com/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentComponentFragment:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   233: astore_3
    //   234: goto -153 -> 81
    //   237: astore_3
    //   238: aload_3
    //   239: invokevirtual 701	org/json/JSONException:printStackTrace	()V
    //   242: goto -94 -> 148
    //   245: iconst_3
    //   246: istore_1
    //   247: goto -74 -> 173
    //   250: astore_3
    //   251: goto -13 -> 238
    //   254: goto -193 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	ReadInJoyCommentComponentFragment
    //   172	75	1	i1	int
    //   33	181	2	localObject1	Object
    //   42	192	3	localObject2	Object
    //   237	2	3	localJSONException1	JSONException
    //   250	1	3	localJSONException2	JSONException
    //   24	203	4	localIntent	Intent
    //   18	113	5	str	String
    // Exception table:
    //   from	to	target	type
    //   34	59	237	org/json/JSONException
    //   61	78	250	org/json/JSONException
    //   81	126	250	org/json/JSONException
    //   126	148	250	org/json/JSONException
    //   229	234	250	org/json/JSONException
  }
  
  private String b()
  {
    String str1 = c();
    String str2 = d();
    String str3 = e();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (!TextUtils.isEmpty(str1)) {
        localJSONObject.put("innerUniqueID", str1);
      }
      if (!TextUtils.isEmpty(str2)) {
        localJSONObject.put("commentId", str2);
      }
      if (!TextUtils.isEmpty(str3)) {
        localJSONObject.put("firstCommentId", str3);
      }
      str1 = localJSONObject.toString();
      return str1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  private void b(int paramInt)
  {
    int i3 = 2130849775;
    this.jdField_a_of_type_Int = paramInt;
    int i2 = 2130843162;
    int i1;
    if (paramInt == 1)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1)) {
        break label204;
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      paramInt = 2130843160;
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
            i1 = 2130849775;
            paramInt = 2130843160;
          }
        }
        else
        {
          if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)) {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
          }
          label204:
          paramInt = 2130843160;
          i1 = i2;
          continue;
        }
        i1 = 2130849775;
        paramInt = 2130843160;
      }
    }
  }
  
  private void b(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("comment_is_show_pic", false))
    {
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_h_of_type_AndroidWidgetImageView.setOnClickListener(this);
      return;
    }
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
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
          String str2 = new String(Base64Util.decode(((JSONObject)localObject2).optString("nick"), 0));
          String str1 = new String(Base64Util.decode(((JSONObject)localObject2).optString("comment"), 0));
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
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setText((CharSequence)localObject1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(((SpannableStringBuilder)localObject1).length());
      s();
      return;
      c(paramBundle.getString("arg_comment_default_txt", ""));
      return;
      i1 -= 1;
    }
  }
  
  private boolean b()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "onDeliver overlong!");
      }
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, getString(2131718194), 0).a();
      return false;
    }
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "onDeliver network error!");
      }
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, getString(2131718193), 0).a();
      return false;
    }
    return true;
  }
  
  private String c()
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData == null) {
      return str;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData.c();
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
    while (ReadInJoyHelper.h(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app) != 1) {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = EmotionCodecUtils.b(paramString);
      if ("@".equals(paramString)) {
        this.jdField_f_of_type_Boolean = true;
      }
      QLog.d("ReadInJoyCommentComponentFragment", 2, "initData | default_comment : " + paramString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setText(paramString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setSelection(paramString.length());
      s();
    }
    while (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_c_of_type_Int));
  }
  
  private boolean c()
  {
    return ReadInJoyHelper.p(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app) == 1;
  }
  
  private String d()
  {
    String str2 = "";
    String str1;
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      str1 = this.jdField_c_of_type_JavaLangString;
    }
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData == null);
      str1 = str2;
    } while (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData instanceof SubCommentCreateData));
    return ((SubCommentCreateData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData).a();
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setHint(HardCodeUtil.a(2131712905));
  }
  
  private String e()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData instanceof SubCommentCreateData))) {
      return ((SubCommentCreateData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData).f();
    }
    Object localObject = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (localObject != null)
    {
      localObject = ((ReadInJoyCommentDataManager)localObject).a(this.jdField_c_of_type_JavaLangString);
      if ((localObject instanceof SubCommentData)) {
        return ((SubCommentData)localObject).parentCommentId;
      }
    }
    return "";
  }
  
  private void e(@NotNull Bundle paramBundle)
  {
    int i1 = paramBundle.getInt("arg_comment_max_length", -1);
    if (i1 > 0) {
      this.jdField_c_of_type_Int = ReadInJoyHelper.a(i1);
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
      this.jdField_c_of_type_Int = ReadInJoyHelper.a();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "initData | comment_mMaxCharCount : " + this.jdField_c_of_type_Int);
      }
    }
  }
  
  private String f()
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
        if (this.o) {
          break label146;
        }
        if (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData instanceof SubCommentCreateData)) {
          break label122;
        }
        break label146;
        localJSONObject.put("comment_level", i1);
        return localJSONObject.toString();
        ReadInJoyCommentDataManager localReadInJoyCommentDataManager = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        if (localReadInJoyCommentDataManager == null) {
          break;
        }
        localJSONObject.put("entry", localReadInJoyCommentDataManager.a());
      }
    }
    catch (JSONException localJSONException)
    {
      label146:
      for (;;)
      {
        localJSONException.printStackTrace();
        continue;
        localJSONObject.put("entry", 0);
        continue;
        label122:
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
  
  private void f(@NotNull Bundle paramBundle)
  {
    int i1 = 1;
    int i2 = paramBundle.getInt("arg_comment_open_at", 0);
    boolean bool;
    if ((ReadInJoyHelper.q(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app) == 0) && (i2 == 1))
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
    boolean bool2 = true;
    boolean bool3 = ReadInJoyHelper.f();
    int i1;
    if ((this.s) && (bool3))
    {
      bool1 = true;
      this.jdField_h_of_type_Boolean = bool1;
      this.jdField_l_of_type_Int = ReadInJoyHelper.b();
      paramBundle = this.jdField_j_of_type_AndroidWidgetImageView;
      if ((!this.jdField_h_of_type_Boolean) || (this.jdField_l_of_type_Int <= 0)) {
        break label196;
      }
      i1 = 0;
      label55:
      paramBundle.setVisibility(i1);
      QLog.d("ReadInJoyCommentComponentFragment", 2, "linkSwitch = " + bool3);
      QLog.d("ReadInJoyCommentComponentFragment", 2, "insertLinkLimit = " + this.jdField_l_of_type_Int);
      QLog.d("ReadInJoyCommentComponentFragment", 2, "isPgcAuthor = " + this.s);
      paramBundle = new StringBuilder().append("link button visible = ");
      if (this.jdField_j_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        break label202;
      }
    }
    label196:
    label202:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.d("ReadInJoyCommentComponentFragment", 2, bool1);
      return;
      bool1 = false;
      break;
      i1 = 8;
      break label55;
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
      this.jdField_d_of_type_Int = localBundle.getInt("arg_comment_comment_type", 0);
      this.jdField_e_of_type_Int = localBundle.getInt("arg_comment_source_type", 0);
      this.jdField_h_of_type_Int = localBundle.getInt("click_comment_edit_src");
      this.p = localBundle.getBoolean("arg_ad_show_biu", true);
      this.r = localBundle.getBoolean("comment_type", true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanSimpleCommentData = ((SimpleCommentData)localBundle.getParcelable("comment_create_data"));
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
      this.o = ((Intent)localObject).getBooleanExtra("comment_reply_second", false);
      if (this.o) {
        this.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("comment_reply_second_uin");
      }
      this.jdField_n_of_type_Boolean = ((Intent)localObject).getBooleanExtra("comment_native", false);
      if (this.jdField_n_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)((Intent)localObject).getParcelableExtra("comment_article_info"));
        this.jdField_e_of_type_JavaLangString = ((Intent)localObject).getStringExtra("comment_val");
        this.jdField_f_of_type_JavaLangString = ((Intent)localObject).getStringExtra("comment_author_uin");
        this.jdField_i_of_type_Int = ((Intent)localObject).getIntExtra("biu_src", 1);
        this.jdField_j_of_type_Int = ((Intent)localObject).getIntExtra("feedsType", 1);
        this.jdField_c_of_type_JavaLangString = ((Intent)localObject).getStringExtra("comment_id");
        this.jdField_d_of_type_JavaLangString = ((Intent)localObject).getStringExtra("first_comment_uin");
        this.jdField_j_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mIsGalleryChannel;
        j();
      }
      a((Intent)localObject);
      a(localBundle);
      g(localBundle);
      b((Intent)localObject);
      h(localBundle);
      return;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void h(Bundle paramBundle)
  {
    int i3 = 1;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.contains(getString(2131718150)))) {}
    String str;
    for (int i1 = 2;; i1 = 1)
    {
      str = "";
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("folder_status", RIJKanDianFolderStatus.jdField_a_of_type_Int);
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
            localJSONObject.put("consume_time", TimeSliceHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, false) / 1000L);
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
          i2 = 1;
        }
        catch (JSONException paramBundle)
        {
          JSONObject localJSONObject;
          paramBundle.printStackTrace();
          paramBundle = str;
          continue;
          localJSONObject.put("entry", 0);
          continue;
          int i2 = 0;
          continue;
          i2 = 0;
          continue;
        }
        localJSONObject.put("link_entry", i2);
        if (this.jdField_k_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          continue;
        }
        i2 = i3;
        localJSONObject.put("subject", i2);
        paramBundle = localJSONObject.toString();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800844A", "0X800844A", 0, 0, String.valueOf(i1), String.valueOf(this.jdField_e_of_type_Int), "", paramBundle, false);
        return;
        paramBundle = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
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
    if (a())
    {
      Object localObject = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      if (localObject != null)
      {
        localObject = ((ReadInJoyCommentDataManager)localObject).a();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          QLog.d("ReadInJoyCommentComponentFragment", 2, "initData | comment_default_input : " + (String)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setHint((CharSequence)localObject);
        }
      }
    }
  }
  
  private void k()
  {
    String str1 = b();
    String str2 = a();
    if (str2 != null) {
      jdField_a_of_type_JavaUtilHashMap.put(str1, str2);
    }
  }
  
  private void l()
  {
    String str = b();
    jdField_a_of_type_JavaUtilHashMap.remove(str);
  }
  
  private void m()
  {
    if (this.jdField_h_of_type_Int == -1) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new ReadInJoyCommentComponentFragment.2(this));
  }
  
  private void n()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800844D", "0X800844D", 0, 0, "", "", "", a(false), false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData = null;
      s();
      this.jdField_g_of_type_AndroidWidgetImageView.setClickable(true);
      if (this.jdField_m_of_type_Boolean)
      {
        this.jdField_m_of_type_Boolean = false;
        this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130843042);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData != null) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008F5A", "0X8008F5A", 0, 0, "", "", "", a(false), false);
      }
    }
  }
  
  private void o()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842919);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130842918);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Int == 2) {
      b(1);
    }
    for (;;)
    {
      t();
      return;
      b(2);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800844B", "0X800844B", 0, 0, "", "", "", a(false), false);
    }
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_Int == 3) {
      b(1);
    }
    for (;;)
    {
      t();
      return;
      b(3);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800844C", "0X800844C", 0, 0, "", "", "", a(false), false);
    }
  }
  
  private void r()
  {
    int i3 = 1;
    if (!b()) {
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
          break label309;
        }
        if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
          break label250;
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
          break label255;
        }
        localStringBuilder.append(((BaseCommentData.CommentLinkData)localIterator.next()).type).append(',');
        continue;
      }
      for (;;)
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), str, str, 0, 0, String.valueOf(this.jdField_d_of_type_Int), String.valueOf(i1), "", localJSONObject.toString(), false);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData != null) {
          break label282;
        }
        l();
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1, a());
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData == null) {
          break label301;
        }
        i1 += 4;
        break;
        label250:
        i2 = 0;
        break label311;
        label255:
        localJSONObject.put("link_type", localException.deleteCharAt(localException.length() - 1).toString());
      }
      label282:
      a(2131695228);
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData.jdField_b_of_type_JavaLangString);
      return;
      label301:
      break label33;
      i1 = 0;
      break;
      label309:
      int i2 = 1;
      label311:
      if (i2 != 0) {
        i3 = 0;
      }
    }
  }
  
  private void s()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData == null) {
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
  
  private void t()
  {
    ZhituManager localZhituManager = a();
    if ((localZhituManager != null) && (this.jdField_k_of_type_Boolean))
    {
      localZhituManager.c();
      this.jdField_k_of_type_Boolean = false;
      this.jdField_f_of_type_AndroidWidgetImageView.setSelected(false);
    }
  }
  
  private void u()
  {
    v();
    t();
  }
  
  private void v()
  {
    SimpleEventBus.getInstance().registerReceiver(this);
    Bundle localBundle = new Bundle();
    int i2 = this.jdField_l_of_type_Int;
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i1 = 0;; i1 = this.jdField_a_of_type_JavaUtilList.size())
    {
      RIJJumpUtils.a(getActivity(), "https://viola.qq.com/js/commLinkSelector.js?_rij_violaUrl=1&v_tid=6&v_bundleName=commLinkSelector&hideNav=1&v_nav_immer=1&v_bid=3740&remainLinkCount=" + (i2 - i1), localBundle);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800B085", "0X800B085", 0, 0, "", "", "", f(), false);
      return;
    }
  }
  
  private void w()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (((!RIJItemViewType.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (ArticleInfoHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.b()))) {
      this.jdField_i_of_type_Boolean = false;
    }
    if (!this.jdField_i_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void x()
  {
    if ((RIJBiuAndCommentAladdinUtils.a()) && (this.r)) {
      this.q = true;
    }
    if (!this.q)
    {
      QLog.d("ReadInJoyCommentComponentFragment", 1, "initBiuAndCommentMix isBiuAndCommentMixType is false");
      return;
    }
    y();
    A();
    D();
  }
  
  private void y()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    z();
  }
  
  private void z()
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = RIJBiuAndCommentAladdinUtils.b().split("\\|");
    if (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
      this.jdField_n_of_type_Int = new Random().nextInt(this.jdField_a_of_type_ArrayOfJavaLangString.length);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_n_of_type_Int])) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_n_of_type_Int]);
    }
    String str = RIJBiuAndCommentAladdinUtils.c();
    if (!TextUtils.isEmpty(str)) {
      this.jdField_b_of_type_AndroidWidgetButton.setText(str);
    }
    if (RIJBiuAndCommentAladdinUtils.d()) {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      str = RIJBiuAndCommentAladdinUtils.d();
      if (!TextUtils.isEmpty(str)) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(str);
      }
      if (RIJBiuAndCommentAladdinUtils.b()) {
        a(true);
      }
    } while (!RIJBiuAndCommentAladdinUtils.c());
    if (((Boolean)ReadInJoyHelper.a("rij_sp_editor_last_check", Boolean.valueOf(false))).booleanValue())
    {
      a(true);
      return;
    }
    a(false);
  }
  
  protected String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getEditableText();
    if ((localObject == null) || (((Editable)localObject).length() <= 0)) {}
    for (localObject = "";; localObject = ReadInJoyCommentUtils.a(localObject.toString(), true))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "getCommentString result=" + (String)localObject);
      }
      return localObject;
    }
  }
  
  public JSONObject a()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      b(localArrayList);
      JSONObject localJSONObject1 = new JSONObject();
      new SocializeFeedsInfo().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo = new SocializeFeedsInfo.BiuInfo();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null))
      {
        localJSONObject1.put("mOriFeedType", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b);
        localJSONObject1.put("mOriFeedId", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaLangLong);
      }
      localJSONObject1.put("biuSrc", this.jdField_i_of_type_Int);
      localJSONObject1.put("feedtype", this.jdField_j_of_type_Int);
      JSONArray localJSONArray = new JSONArray();
      int i1 = 0;
      while (i1 < localArrayList.size())
      {
        ReadInJoyCommentComponentFragment.UserBiuInfo localUserBiuInfo = (ReadInJoyCommentComponentFragment.UserBiuInfo)localArrayList.get(i1);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("biu_info_comment", localUserBiuInfo.b);
        localJSONObject2.put("biu_feedid", new Long(localUserBiuInfo.jdField_a_of_type_Long));
        localJSONObject2.put("biu_optype", localUserBiuInfo.jdField_a_of_type_Int);
        localJSONObject2.put("biu_uin", localUserBiuInfo.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("biu_nickname", localUserBiuInfo.jdField_a_of_type_JavaLangCharSequence);
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
  
  protected void a(int paramInt, CharSequence paramCharSequence)
  {
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramInt, paramCharSequence, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  public void a(ZhituPicData paramZhituPicData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "onZhituSend:" + paramZhituPicData);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData = paramZhituPicData;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = null;
    ThreadManager.getUIHandler().post(new ReadInJoyCommentComponentFragment.9(this, paramZhituPicData));
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentComponentFragment", 2, "startUploadPic path=" + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      g();
      a(1, getString(2131718211));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "startUploadPic empty path!");
      }
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyCommentComponentFragment.3(this, paramString));
  }
  
  protected boolean a(ArrayList<ReadInJoyCommentComponentFragment.UserBiuInfo> paramArrayList)
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
      paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, str1, 0L, ""));
      return false;
    }
    String str3 = UUID.randomUUID().toString();
    Object localObject3 = Utils.a(localEditable.toString(), str3).trim();
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, str1, 0L, ""));
      return true;
    }
    localObject1 = (BiuNicknameSpan[])localEditable.getSpans(0, localEditable.length(), BiuNicknameSpan.class);
    if ((localObject1 == null) || (localObject1.length <= 0))
    {
      paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, str1, 0L, EmotionCodecUtils.a(Utils.b(((String)localObject3).replaceAll("\n|\r\n", ""), str3))));
      return true;
    }
    localObject3 = new ArrayList();
    ((ArrayList)localObject3).addAll(Arrays.asList((Object[])localObject1));
    Collections.sort((List)localObject3, new ReadInJoyCommentComponentFragment.BiuSpanComparator(this, localEditable));
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
          localObject1 = Utils.a((String)localObject1, str3).replaceAll("\n|\r\n", "");
          if (i2 != 0) {
            break label545;
          }
          localObject1 = ((String)localObject1).substring(((String)localObject1).indexOf(((String)localObject1).trim()));
          paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, str1, l1, EmotionCodecUtils.a(Utils.b((String)localObject1, str3)), i1));
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
          str2 = Utils.a(str2, str3).replaceAll("\n|\r\n", "");
          paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, str1, l1, EmotionCodecUtils.a(Utils.b(str2.substring(0, str2.indexOf(str2.trim()) + str2.trim().length()), str3)), i1));
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
    t();
  }
  
  protected void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_min", 1);
    localIntent.putExtra("param_max", 10);
    startActivityForResult(localIntent, 10000);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008660", "0X8008660", 0, 0, paramString, "", "", a(false), false);
  }
  
  protected boolean b(ArrayList<ReadInJoyCommentComponentFragment.UserBiuInfo> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText == null) {
      return true;
    }
    Editable localEditable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getText();
    String str = "0";
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      str = ((QQAppInterface)localAppRuntime).getCurrentAccountUin();
    }
    if ((localEditable == null) || (TextUtils.isEmpty(localEditable.toString())))
    {
      paramArrayList.add(new ReadInJoyCommentComponentFragment.UserBiuInfo(this, str, 0L, ""));
      return false;
    }
    return a(str, localEditable, paramArrayList);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiCommentLinkView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800B086", "0X800B086", 0, 0, "", "", "", f(), false);
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPicData != null) || (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData != null))
    {
      QQToast.a(this.jdField_g_of_type_AndroidWidgetImageView.getContext(), HardCodeUtil.a(2131712932), 0).a();
      return;
    }
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130843042);
      this.jdField_a_of_type_Boolean = true;
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      if (!this.jdField_a_of_type_Boolean) {
        break label126;
      }
    }
    label126:
    for (String str = "0";; str = "1")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X8008F58", "0X8008F58", 0, 0, str, "", "", a(false), false);
      return;
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130843041);
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
    ZhituManager localZhituManager = a();
    if (localZhituManager != null)
    {
      if (!this.jdField_k_of_type_Boolean) {
        break label58;
      }
      t();
    }
    for (;;)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008F59", "0X8008F59", 0, 0, "", "", "", a(false), false);
      return;
      label58:
      Editable localEditable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getText();
      if (!localZhituManager.a(localEditable))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getContext(), HardCodeUtil.a(2131712714), 0).a();
        return;
      }
      if (localEditable.length() > 24)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getContext(), "24个字符以内才支持转为智图。", 0).a();
        return;
      }
      localZhituManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_c_of_type_AndroidWidgetRelativeLayout, null, null, false, this.jdField_a_of_type_MqqOsMqqHandler);
      if (localZhituManager.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 1) {
        localZhituManager.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(0);
      }
      localZhituManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, localEditable, null, 7220, false);
      localZhituManager.a(this);
      this.jdField_k_of_type_Boolean = true;
      this.jdField_f_of_type_AndroidWidgetImageView.setSelected(true);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(84);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(84, 10000L);
    }
  }
  
  protected void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
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
      t();
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
    m();
    k();
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
      n();
      continue;
      o();
      continue;
      p();
      continue;
      q();
      continue;
      r();
      continue;
      b();
      continue;
      u();
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131560225, paramViewGroup, false);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131363410));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131368801));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131368802));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramLayoutInflater.findViewById(2131368805).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131362747));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131366225));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131367913));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131368897));
    if (!HotPicManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app).b()) {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131363073));
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      }
      this.jdField_j_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131370432));
      this.jdField_j_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiCommentLinkView = ((CommentLinkView)paramLayoutInflater.findViewById(2131370441));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentUiCommentLinkView.setOnLinkEmptyListener(this);
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131370438);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131364581));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131365668));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText = ((BiuEditText)paramLayoutInflater.findViewById(2131369141));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.requestFocus();
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.setEditableFactory(jdField_a_of_type_AndroidTextEditable$Factory);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)paramLayoutInflater.findViewById(2131377356));
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText, false);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this.jdField_a_of_type_ComTencentWidgetXPanelContainer$PanelCallback);
        this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131382138));
        this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131382141));
        this.jdField_k_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131379696));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentTopicRIJCommentTopicUi = new RIJCommentTopicUi(this.jdField_k_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText, new ReadInJoyCommentComponentFragment.TopicReportRunnable(this, null));
        a(paramLayoutInflater);
        h();
        this.jdField_g_of_type_Int = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          bool = true;
          this.jdField_e_of_type_Boolean = bool;
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131367430));
          this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
          if (ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getAppRuntime()))
          {
            paramViewGroup = paramLayoutInflater.findViewById(2131372297);
            if (paramViewGroup != null) {
              paramViewGroup.setVisibility(0);
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
          this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131365055));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131365669));
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131363722));
        }
      }
      catch (Exception paramViewGroup)
      {
        try
        {
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.jdField_a_of_type_Boolean) {
              this.p = false;
            }
            if (this.p) {
              break label781;
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            if (c())
            {
              this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130843042);
              this.jdField_a_of_type_Boolean = true;
            }
            w();
            x();
            RIJDtReportHelper.a.a(getActivity());
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
            label781:
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
    ZhituManager localZhituManager = a();
    if (localZhituManager != null) {
      localZhituManager.a(null);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      ((ITransFileController)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getRuntimeService(ITransFileController.class)).removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    }
    a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuBiuEditText.a();
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentTopicRIJCommentTopicUi.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentTopicRIJCommentTopicUi = null;
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
    ReadInjoyUserProtocolWidget.a(getActivity(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment
 * JD-Core Version:    0.7.0.1
 */