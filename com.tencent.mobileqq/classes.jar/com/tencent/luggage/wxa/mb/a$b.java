package com.tencent.luggage.wxa.mb;

import com.tencent.luggage.wxa.qz.o;

class a$b
  implements com.tencent.luggage.wxa.hg.a.a
{
  private a$b(a parama) {}
  
  public void a(int paramInt)
  {
    if (paramInt != -3)
    {
      if (paramInt != -2)
      {
        if (paramInt != -1)
        {
          if (paramInt != 1)
          {
            o.f("MicroMsg.AudioHelperTool", "jacks UNKNOW_AUDIOFOCUS_LOSS DEFAULT");
            return;
          }
          o.f("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_GAIN");
          if (a.a(this.a) != null) {
            a.a(this.a).a();
          }
        }
        else
        {
          o.f("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS");
          if (a.a(this.a) != null) {
            a.a(this.a).b();
          }
        }
      }
      else
      {
        o.f("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT");
        if (a.a(this.a) != null) {
          a.a(this.a).c();
        }
      }
    }
    else
    {
      o.f("MicroMsg.AudioHelperTool", "jacks AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
      if (a.a(this.a) != null) {
        a.a(this.a).d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mb.a.b
 * JD-Core Version:    0.7.0.1
 */