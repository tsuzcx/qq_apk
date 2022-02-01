package com.tencent.av.ui;

class VoiceChangeAdapter$1
  implements VoiceChangeItemView1.ICallback
{
  public void a(VoiceChangeItemView1 paramVoiceChangeItemView1, int paramInt)
  {
    VoiceChangeData.VoiceInfo localVoiceInfo = (VoiceChangeData.VoiceInfo)this.a.getItem(paramInt);
    if (localVoiceInfo != null)
    {
      if (localVoiceInfo.d == VoiceChangeAdapter.a(this.a)) {
        return;
      }
      if (VoiceChangeAdapter.b(this.a) != null) {
        VoiceChangeAdapter.b(this.a).setHighlight(false);
      }
      VoiceChangeAdapter.a(this.a, localVoiceInfo.d);
      VoiceChangeAdapter.a(this.a, paramVoiceChangeItemView1);
      VoiceChangeAdapter.b(this.a).setHighlight(true);
      if (VoiceChangeAdapter.c(this.a) != null) {
        VoiceChangeAdapter.c(this.a).a(VoiceChangeAdapter.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeAdapter.1
 * JD-Core Version:    0.7.0.1
 */