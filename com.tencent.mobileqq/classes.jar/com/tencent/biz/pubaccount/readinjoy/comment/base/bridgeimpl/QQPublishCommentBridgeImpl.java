package com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl;

import android.text.Editable;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.base.model.CommentArgumentModel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.comment.publisher.qq.bridge.QQPublishCommentBridge;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArgument;
import org.json.JSONObject;

public class QQPublishCommentBridgeImpl
  implements QQPublishCommentBridge
{
  private final CommentArgumentModel a;
  
  public QQPublishCommentBridgeImpl(CommentArgumentModel paramCommentArgumentModel)
  {
    this.a = paramCommentArgumentModel;
  }
  
  public JSONObject buildArticleBiuCommentInfo(Editable paramEditable)
  {
    return new QQPublishCommentBridgeImpl.BiuCommentHelper(this, null).a(paramEditable);
  }
  
  public TkdQQArgument getArgument()
  {
    return this.a.a;
  }
  
  public String getCommentString(Editable paramEditable)
  {
    if ((paramEditable == null) || (paramEditable.length() <= 0)) {}
    for (paramEditable = "";; paramEditable = ReadInJoyCommentUtils.a(paramEditable.toString(), true))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQPublishBridgeImpl", 2, "getCommentString result=" + paramEditable);
      }
      return paramEditable;
    }
  }
  
  public boolean isNetworkAvailable()
  {
    return NetworkUtil.g(BaseApplicationImpl.getApplication());
  }
  
  public void showToast(String paramString, int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplicationImpl.getApplication(), paramInt2, paramString, paramInt1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl.QQPublishCommentBridgeImpl
 * JD-Core Version:    0.7.0.1
 */