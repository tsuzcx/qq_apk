package com.tencent.biz.pubaccount.readinjoy.proteus.listeners;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuBehaviour;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoStructMsgHelper;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyFeedbackPopupWindow.FeedbackCallback;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.QShareUtils;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2.BaseSheetItemClickProcessor;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class OnShareClickListener$ItemSheetClickProcessor
  extends ReadInJoyShareHelperV2.BaseSheetItemClickProcessor
{
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private ReadInJoyFeedbackPopupWindow.FeedbackCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyFeedbackPopupWindow$FeedbackCallback = new OnShareClickListener.ItemSheetClickProcessor.1(this);
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  
  OnShareClickListener$ItemSheetClickProcessor(ArticleInfo paramArticleInfo, WeakReference<Activity> paramWeakReference)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramWeakReference;
    Object localObject;
    this.jdField_a_of_type_JavaLangRefWeakReference = localObject;
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 0;
    case 3: 
      return 1;
    case 9: 
      return 2;
    case 10: 
      return 3;
    }
    return 4;
  }
  
  private String a()
  {
    String str = "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_big_v3.png";
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFirstPagePicUrl;
    }
    QLog.d("OnShareClickListener", 2, "getImageUrl | shareImgUrl : " + str);
    return str;
  }
  
  private void a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    Object localObject;
    JSONObject localJSONObject;
    for (;;)
    {
      try
      {
        localObject = new JSONArray();
        localJSONObject = new JSONObject();
        localJSONObject.put("name", "qq_friend");
        localJSONObject.put("webHandle", 0);
        ((JSONArray)localObject).put(localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("name", "qzone");
        localJSONObject.put("webHandle", 0);
        ((JSONArray)localObject).put(localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("name", "we_chat");
        localJSONObject.put("webHandle", 0);
        ((JSONArray)localObject).put(localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("name", "we_chat_circle");
        localJSONObject.put("webHandle", 0);
        ((JSONArray)localObject).put(localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("upline", localObject);
        localJSONObject.put("belowline", new JSONArray());
        localJSONObject.put("shareCallBack", "");
        localJSONObject.put("title", b());
        localJSONObject.put("back", true);
        localJSONObject.put("sourceName", HardCodeUtil.a(2131702751));
        localJSONObject.put("WXShareFromQQKandian", 1);
        localJSONObject.put("src_iconUrl", "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_v4.png");
        localJSONObject.put("srcIconUrl", "https://sqimg.qq.com/qq_product_operations/kan/images/viola/shortPGC/kd_icon_v4.png");
        localJSONObject.put("src_action", "plugin");
        localJSONObject.put("src_webActionUrl", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
        localJSONObject.put("src_actionData", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
        localJSONObject.put("desc", ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131718377));
        localJSONObject.put("menu_title", HardCodeUtil.a(2131713537));
        if (RIJItemViewType.o(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))
        {
          localJSONObject.put("share_url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mOriginalUrl);
          localJSONObject.put("keepShareUrl", 1);
          localJSONObject.put("image_url", a());
          localJSONObject.put("weibo_title", HardCodeUtil.a(2131712989));
          localJSONObject.put("uin", "");
          localJSONObject.put("puin", 0);
          if (RIJFeedsType.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
            localJSONObject.put("shareVideoMsgForArk", VideoStructMsgHelper.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
          }
          if (OnShareClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusListenersOnShareClickListener) == null) {
            OnShareClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusListenersOnShareClickListener, new QShareUtils());
          }
          localObject = null;
          if (paramActionSheetItem.action == 72) {
            localObject = paramActionSheetItem.uin;
          }
          if (!((Boolean)ReadInJoyHelper.a("is_share_strike", Boolean.valueOf(false))).booleanValue()) {
            break;
          }
          QRUtils.a(1, 2131719291);
          QLog.d("OnShareClickListener", 1, "sharing is stroked!");
          return;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
        {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.getShareUrl();
          localJSONObject.put("share_url", localObject);
        }
        else
        {
          localObject = "";
        }
      }
      catch (JSONException paramActionSheetItem)
      {
        QLog.d("OnShareClickListener", 2, paramActionSheetItem.getMessage());
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      switch (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.shareCalcuPermission)
      {
      }
    }
    for (;;)
    {
      OnShareClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusListenersOnShareClickListener).a(localJSONObject, paramInt, (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (String)localObject, paramActionSheetItem.uinType, paramActionSheetItem.label);
      return;
      if (QLog.isColorLevel())
      {
        QLog.d("OnShareClickListener", 2, "allow share but don't calculate!");
        continue;
        ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 2);
      }
    }
  }
  
  private void a(@NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (!a()) {
      return;
    }
    if (paramActionSheetItem.action == 72) {
      OnShareClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusListenersOnShareClickListener, paramActionSheetItem.uin);
    }
    OnShareClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusListenersOnShareClickListener, paramActionSheetItem.uinType);
    OnShareClickListener.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusListenersOnShareClickListener, paramActionSheetItem.label);
    OnShareClickListener.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusListenersOnShareClickListener, paramActionSheetItem.action);
    ((ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, a(OnShareClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusListenersOnShareClickListener)), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyFeedbackPopupWindow$FeedbackCallback);
  }
  
  private boolean a()
  {
    if (!NetworkUtil.g(OnShareClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusListenersOnShareClickListener)))
    {
      QQToast.a(OnShareClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusListenersOnShareClickListener), 1, 2131718193, 0).a();
      return false;
    }
    return true;
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 2;
    case 1: 
      return 3;
    case 2: 
      return 9;
    case 3: 
      return 10;
    }
    return 13;
  }
  
  private String b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle;
    }
    return "";
  }
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    boolean bool = true;
    if (paramActionSheetItem.action == 13)
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      Intent localIntent;
      if (localActivity != null)
      {
        localIntent = OnBiuClickListener.a(localActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        if (BiuBehaviour.a() != 1) {
          break label77;
        }
      }
      for (;;)
      {
        localIntent.putExtra("fast_biu_type", bool);
        localActivity.startActivity(localIntent);
        localActivity.overridePendingTransition(0, 0);
        return super.a(paramInt, paramActionSheetItem);
        label77:
        bool = false;
      }
    }
    if ((RIJItemViewType.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (RIJItemViewType.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
      a(paramActionSheetItem);
    }
    for (;;)
    {
      return super.a(paramInt, paramActionSheetItem);
      a(paramInt, paramActionSheetItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnShareClickListener.ItemSheetClickProcessor
 * JD-Core Version:    0.7.0.1
 */