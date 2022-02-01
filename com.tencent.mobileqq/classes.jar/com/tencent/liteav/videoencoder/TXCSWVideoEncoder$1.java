package com.tencent.liteav.videoencoder;

import com.tencent.liteav.basic.opengl.j.a;

class TXCSWVideoEncoder$1
  implements j.a
{
  TXCSWVideoEncoder$1(TXCSWVideoEncoder paramTXCSWVideoEncoder, boolean paramBoolean, int paramInt) {}
  
  public void a(int paramInt)
  {
    synchronized (this.c)
    {
      if (this.c.mListener != null) {
        this.c.mListener.m(this.c.mStreamType);
      }
      if (this.a) {
        TXCSWVideoEncoder.access$200(this.c, TXCSWVideoEncoder.access$000(this.c), this.b, this.c.mOutputWidth, this.c.mOutputHeight, TXCSWVideoEncoder.access$100(this.c));
      } else {
        TXCSWVideoEncoder.access$300(this.c, TXCSWVideoEncoder.access$000(this.c), this.b, this.c.mOutputWidth, this.c.mOutputHeight, TXCSWVideoEncoder.access$100(this.c));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.TXCSWVideoEncoder.1
 * JD-Core Version:    0.7.0.1
 */