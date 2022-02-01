import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.tencent.qphone.base.util.QLog;

class awcq
  implements WbShareCallback
{
  awcq(awcp paramawcp) {}
  
  public void onCancel()
  {
    QLog.d("LoginPlugin_demo", 1, "onCancel");
    auud.a(awcp.a(this.a), "分享取消");
  }
  
  public void onComplete()
  {
    QLog.d("LoginPlugin_demo", 1, "onComplete");
    auud.a(awcp.a(this.a), "分享成功");
  }
  
  public void onError(UiError paramUiError)
  {
    QLog.d("LoginPlugin_demo", 1, new Object[] { "onError errorMessage=", paramUiError.errorMessage, ", errorCode=", Integer.valueOf(paramUiError.errorCode) });
    auud.a(awcp.a(this.a), "分享失败 message=" + paramUiError.errorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awcq
 * JD-Core Version:    0.7.0.1
 */