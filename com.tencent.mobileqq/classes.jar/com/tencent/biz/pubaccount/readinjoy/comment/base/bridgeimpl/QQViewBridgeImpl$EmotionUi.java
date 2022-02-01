package com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;

class QQViewBridgeImpl$EmotionUi
{
  private final EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = new QQViewBridgeImpl.EmotionUi.1(this);
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  
  private QQViewBridgeImpl$EmotionUi(QQViewBridgeImpl paramQQViewBridgeImpl) {}
  
  View a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)View.inflate(paramContext, 2131559200, null));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onlySysAndEmoji = true;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.init(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentBaseBridgeimplQQViewBridgeImpl.a(), 1008, paramContext, ((BaseActivity)paramContext).getTitleBarHeight(), null, null);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.hideAllTabs();
    }
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onDestory();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl.QQViewBridgeImpl.EmotionUi
 * JD-Core Version:    0.7.0.1
 */