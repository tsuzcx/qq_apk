package com.tencent.biz.pubaccount.readinjoy.comment.base;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.CustomDialogClickListener;
import com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl.QQLifecycleBridgeImpl;
import com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl.QQLogBridgeImpl;
import com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl.QQPublishCommentBridgeImpl;
import com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl.QQReportBridgeImpl;
import com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl.QQSharedPreferencesImpl;
import com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl.QQUrlImageBridgeImpl;
import com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl.QQViewBridgeImpl;
import com.tencent.biz.pubaccount.readinjoy.comment.base.listener.OnDeliverListener;
import com.tencent.biz.pubaccount.readinjoy.comment.base.model.CommentArgumentModel;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment;
import com.tencent.tkd.comment.publisher.qq.QQPublishCommentManager;
import com.tencent.tkd.comment.publisher.qq.bridge.QQLifecycleBridge;
import java.lang.ref.WeakReference;

public class ReadInJoyCommentEntrance
  implements OnDeliverListener, QQLifecycleBridge
{
  private static final ReadInJoyCommentEntrance.SaveState jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseReadInJoyCommentEntrance$SaveState = new ReadInJoyCommentEntrance.SaveState();
  private final Intent jdField_a_of_type_AndroidContentIntent;
  private final CommentArgumentModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseModelCommentArgumentModel;
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private final QQPublishCommentFragment jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment;
  
  public ReadInJoyCommentEntrance(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseModelCommentArgumentModel = new CommentArgumentModel(paramIntent);
    paramBaseActivity = new QQViewBridgeImpl(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseModelCommentArgumentModel);
    paramIntent = new QQLifecycleBridgeImpl();
    paramIntent.a(paramBaseActivity);
    paramIntent.a(this);
    paramBaseActivity.a(this);
    QQPublishCommentManager localQQPublishCommentManager = QQPublishCommentManager.getInstance();
    localQQPublishCommentManager.setLogBridge(new QQLogBridgeImpl());
    localQQPublishCommentManager.setPublisherBridge(new QQPublishCommentBridgeImpl(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseModelCommentArgumentModel));
    localQQPublishCommentManager.setReportBridge(new QQReportBridgeImpl(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseModelCommentArgumentModel));
    localQQPublishCommentManager.setSpBridge(new QQSharedPreferencesImpl());
    localQQPublishCommentManager.setViewBridge(paramBaseActivity);
    localQQPublishCommentManager.setLifecycleBridge(paramIntent);
    localQQPublishCommentManager.setUrlImageBridge(new QQUrlImageBridgeImpl());
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment = new QQPublishCommentFragment();
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment.getActivity();
    if (localActivity == null)
    {
      QLog.d("ReadInJoyCommentEntrance", 2, "onActivityResult, activity == null;commentFragment isShowing=" + this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment.isShowing());
      if (paramInt != 0) {
        QQToast.a(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131718579), 0).a();
      }
      return;
    }
    localActivity.setResult(paramInt, paramIntent);
    if (this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment.isShowing())
    {
      this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment.setDismissListener(new ReadInJoyCommentEntrance.2(this, localActivity));
      return;
    }
    localActivity.finish();
    localActivity.overridePendingTransition(0, 0);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if (WeishiUtils.c()) {
      return;
    }
    d(paramActivity, paramIntent, paramInt);
    if (paramIntent.getBooleanExtra("need_intercept", true))
    {
      RIJUserLevelModule.a().a(paramActivity, 1, new ReadInJoyCommentEntrance.1(paramActivity, paramIntent, paramInt));
      return;
    }
    c(paramActivity, paramIntent, paramInt);
  }
  
  public static void a(ReadInJoyCommentUtils.CustomDialogClickListener paramCustomDialogClickListener)
  {
    if (a()) {
      ReadInJoyCommentUtils.a((Activity)jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_JavaLangRefWeakReference.get(), paramCustomDialogClickListener);
    }
  }
  
  public static void a(String paramString)
  {
    if (a())
    {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_AndroidContentIntent.putExtra("comment_recreate_draft", paramString);
      a((Activity)jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_JavaLangRefWeakReference.get(), jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_AndroidContentIntent, jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_Int);
    }
  }
  
  public static boolean a()
  {
    return (jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_JavaLangRefWeakReference != null) && (jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_AndroidContentIntent != null);
  }
  
  private static void c(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    PublicFragmentActivity.Launcher.a(paramActivity, paramIntent, PublicTransFragmentActivity.class, ReadInJoyCommentBridgeFragment.class, paramInt);
  }
  
  private static void d(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_AndroidContentIntent = ((Intent)paramIntent.clone());
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseReadInJoyCommentEntrance$SaveState.jdField_a_of_type_Int = paramInt;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment.isShowing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqQQPublishCommentFragment.show(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getFragmentManager(), "QQPublishCommentFragment");
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("arg_result_json", paramString);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("comment_article_info", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseModelCommentArgumentModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    this.jdField_a_of_type_AndroidContentIntent.putExtra("comment_gallery_channel", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseModelCommentArgumentModel.jdField_a_of_type_Boolean);
    paramString = this.jdField_a_of_type_AndroidContentIntent;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseModelCommentArgumentModel.f)) {}
    for (int i = 2;; i = 3)
    {
      paramString.putExtra("click_comment_edit_src", i);
      a(-1, this.jdField_a_of_type_AndroidContentIntent);
      return;
    }
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_AndroidContentIntent.putExtra("arg_result_json", paramString);
    paramString = this.jdField_a_of_type_AndroidContentIntent;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseModelCommentArgumentModel.f)) {}
    for (int i = 2;; i = 3)
    {
      paramString.putExtra("click_comment_edit_src", i);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("comment_article_info", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseModelCommentArgumentModel.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      a(1699, this.jdField_a_of_type_AndroidContentIntent);
      return;
    }
  }
  
  public void onDestroy(boolean paramBoolean)
  {
    if (paramBoolean) {
      a(0, new Intent());
    }
  }
  
  public void onPause() {}
  
  public void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.base.ReadInJoyCommentEntrance
 * JD-Core Version:    0.7.0.1
 */