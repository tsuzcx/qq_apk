package com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl;

import android.app.Activity;
import android.text.Editable;
import android.text.Editable.Factory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuTextBuilder;
import com.tencent.biz.pubaccount.readinjoy.comment.base.listener.OnDeliverListener;
import com.tencent.biz.pubaccount.readinjoy.comment.base.model.CommentArgumentModel;
import com.tencent.biz.pubaccount.readinjoy.comment.topic.RIJCommentTopicUi;
import com.tencent.biz.pubaccount.readinjoy.comment.topic.RIJCommentTopicUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.tkd.comment.publisher.qq.bridge.QQLifecycleBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQViewBridge;
import com.tencent.tkd.comment.publisher.qq.util.QQViewCallback;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class QQViewBridgeImpl
  implements QQLifecycleBridge, QQViewBridge
{
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private final QQViewBridgeImpl.EmotionUi jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseBridgeimplQQViewBridgeImpl$EmotionUi;
  private final QQViewBridgeImpl.GifUi jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseBridgeimplQQViewBridgeImpl$GifUi;
  private final QQViewBridgeImpl.LinkUi jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseBridgeimplQQViewBridgeImpl$LinkUi;
  private OnDeliverListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseListenerOnDeliverListener;
  private final CommentArgumentModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseModelCommentArgumentModel;
  private RIJCommentTopicUi jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentTopicRIJCommentTopicUi;
  private QQViewCallback jdField_a_of_type_ComTencentTkdCommentPublisherQqUtilQQViewCallback;
  
  public QQViewBridgeImpl(CommentArgumentModel paramCommentArgumentModel)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseModelCommentArgumentModel = paramCommentArgumentModel;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseBridgeimplQQViewBridgeImpl$LinkUi = new QQViewBridgeImpl.LinkUi(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseBridgeimplQQViewBridgeImpl$EmotionUi = new QQViewBridgeImpl.EmotionUi(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseBridgeimplQQViewBridgeImpl$GifUi = new QQViewBridgeImpl.GifUi(this, null);
  }
  
  private String a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseBridgeimplQQViewBridgeImpl$GifUi.a(paramString);
      RIJCommentTopicUtil.a(paramString, this.jdField_a_of_type_AndroidWidgetEditText.getText());
      paramString = paramString.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void a(OnDeliverListener paramOnDeliverListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseListenerOnDeliverListener = paramOnDeliverListener;
  }
  
  public void bindCallback(QQViewCallback paramQQViewCallback)
  {
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqUtilQQViewCallback = paramQQViewCallback;
  }
  
  public void bindInput(EditText paramEditText)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
  }
  
  public void bindTopic(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentTopicRIJCommentTopicUi = new RIJCommentTopicUi(paramView, this.jdField_a_of_type_AndroidWidgetEditText, new QQViewBridgeImpl.2(this));
  }
  
  public void deleteGif()
  {
    QQViewBridgeImpl.GifUi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseBridgeimplQQViewBridgeImpl$GifUi);
  }
  
  public Editable.Factory getEditFactory()
  {
    return new QQViewBridgeImpl.1(this);
  }
  
  public View getEmotionPanel(Activity paramActivity)
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseBridgeimplQQViewBridgeImpl$EmotionUi.a(paramActivity);
  }
  
  public String getEmotionText(String paramString)
  {
    return EmotionCodecUtils.b(paramString);
  }
  
  public View getGifPanel(Activity paramActivity)
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseBridgeimplQQViewBridgeImpl$GifUi.a(paramActivity);
  }
  
  public int getTextLength(Editable paramEditable)
  {
    if ((paramEditable instanceof BiuTextBuilder)) {
      return ((BiuTextBuilder)paramEditable).a();
    }
    return paramEditable.length();
  }
  
  public boolean hasGif()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseBridgeimplQQViewBridgeImpl$GifUi.a != null;
  }
  
  public boolean isNightMode()
  {
    return ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public void onDeleteLink()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseBridgeimplQQViewBridgeImpl$LinkUi.b();
  }
  
  public void onDeliever(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseListenerOnDeliverListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseListenerOnDeliverListener.b(a(paramString));
    }
  }
  
  public void onDelieverBiu(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseListenerOnDeliverListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseListenerOnDeliverListener.c(a(paramString));
    }
  }
  
  public void onDestroy(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseBridgeimplQQViewBridgeImpl$LinkUi.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseBridgeimplQQViewBridgeImpl$EmotionUi.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseBridgeimplQQViewBridgeImpl$GifUi.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentTopicRIJCommentTopicUi != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentTopicRIJCommentTopicUi.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentTopicRIJCommentTopicUi = null;
    }
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void openLink(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseBridgeimplQQViewBridgeImpl$LinkUi.a(paramViewGroup);
    QQViewBridgeImpl.LinkUi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseBridgeimplQQViewBridgeImpl$LinkUi, paramViewGroup.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl.QQViewBridgeImpl
 * JD-Core Version:    0.7.0.1
 */