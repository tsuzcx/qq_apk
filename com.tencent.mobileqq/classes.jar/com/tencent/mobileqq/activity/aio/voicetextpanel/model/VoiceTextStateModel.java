package com.tencent.mobileqq.activity.aio.voicetextpanel.model;

public class VoiceTextStateModel
{
  private VoiceTextSttState a = new VoiceTextSttState();
  private VoiceTextInfoState b = new VoiceTextInfoState();
  private VoiceTextUIState c = new VoiceTextUIState();
  
  public String a()
  {
    if (!this.c.b) {
      return this.b.b();
    }
    if (this.a.f()) {
      return this.b.a();
    }
    return "";
  }
  
  public void b()
  {
    d().b("");
    this.a.a(0);
    this.c.b(false);
  }
  
  public VoiceTextSttState c()
  {
    return this.a;
  }
  
  public VoiceTextInfoState d()
  {
    return this.b;
  }
  
  public VoiceTextUIState e()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextStateModel
 * JD-Core Version:    0.7.0.1
 */