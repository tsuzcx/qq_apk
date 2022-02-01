package com.tencent.livesdk.livesdkplayer.renderview;

import com.tencent.thumbplayer.utils.TPLogUtil;

class TPPlayerVideoView$1
  implements ITPViewBase.ViewCreateCallBack
{
  TPPlayerVideoView$1(TPPlayerVideoView paramTPPlayerVideoView) {}
  
  public void onViewChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    if ((TPPlayerVideoView.access$500(this.this$0) == paramInt1) && (TPPlayerVideoView.access$600(this.this$0) == paramInt2)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onViewChanged, NO: ");
    localStringBuilder.append(TPPlayerVideoView.access$200(this.this$0));
    localStringBuilder.append(", w: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", h: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", pw: ");
    localStringBuilder.append(this.this$0.getWidth());
    localStringBuilder.append(", ph: ");
    localStringBuilder.append(this.this$0.getHeight());
    TPLogUtil.i("TPPlayer[TPPlayerVideoView]", localStringBuilder.toString());
    TPPlayerVideoView.access$502(this.this$0, paramInt1);
    TPPlayerVideoView.access$602(this.this$0, paramInt2);
    TPPlayerVideoView.access$302(this.this$0, paramObject);
    TPPlayerVideoView.access$700(this.this$0, paramObject);
  }
  
  public void onViewCreated(Object paramObject, int paramInt1, int paramInt2)
  {
    TPPlayerVideoView.access$002(this.this$0, true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onViewCreated, is textrueview: ");
    localStringBuilder.append(TPPlayerVideoView.access$100(this.this$0));
    localStringBuilder.append("NO: ");
    localStringBuilder.append(TPPlayerVideoView.access$200(this.this$0));
    localStringBuilder.append(", w: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", h: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", pw: ");
    localStringBuilder.append(this.this$0.getWidth());
    localStringBuilder.append(", ph: ");
    localStringBuilder.append(this.this$0.getHeight());
    TPLogUtil.i("TPPlayer[TPPlayerVideoView]", localStringBuilder.toString());
    TPPlayerVideoView.access$302(this.this$0, paramObject);
    TPPlayerVideoView.access$400(this.this$0, paramObject);
  }
  
  public void onViewDestroyed(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("surfaceDestroyed, NO: ");
    localStringBuilder.append(TPPlayerVideoView.access$200(this.this$0));
    TPLogUtil.i("TPPlayer[TPPlayerVideoView]", localStringBuilder.toString());
    TPPlayerVideoView.access$002(this.this$0, false);
    TPPlayerVideoView.access$800(this.this$0, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.renderview.TPPlayerVideoView.1
 * JD-Core Version:    0.7.0.1
 */