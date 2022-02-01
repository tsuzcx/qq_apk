package com.tencent.av.ui;

class VideoControlUI$SubControlUIObserver
  extends ControlUIObserver
{
  VideoControlUI$SubControlUIObserver(VideoControlUI paramVideoControlUI) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (this.a.V()) {
      return;
    }
    if (!this.a.ab()) {
      if (paramBoolean) {
        this.a.ao.update(null, new Object[] { Integer.valueOf(110), Long.valueOf(paramLong) });
      } else {
        return;
      }
    }
    this.a.aA.a(paramLong, paramInt);
  }
  
  protected void g(long paramLong)
  {
    if (this.a.V()) {
      return;
    }
    if ((this.a.ab()) && (this.a.aA.i(0))) {
      this.a.aA.a(paramLong, 0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.SubControlUIObserver
 * JD-Core Version:    0.7.0.1
 */