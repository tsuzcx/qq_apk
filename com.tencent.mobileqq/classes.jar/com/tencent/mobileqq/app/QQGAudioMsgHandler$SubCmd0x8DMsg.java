package com.tencent.mobileqq.app;

class QQGAudioMsgHandler$SubCmd0x8DMsg
{
  int a;
  long b;
  int c;
  long d;
  long e;
  long f;
  int g;
  int h;
  int i;
  long j;
  int k;
  long l;
  int m;
  int n;
  long o;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("{");
    localStringBuilder.append("wSubCmd: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", llAccount: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", cKeyLen: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", dwRoomNum: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", dwClientSeq: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", llFromAccount: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", dwFlag: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", cRelationBufLen: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", dwRelationId: ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", wCount: ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", dwSendTime: ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", wReverseLen: ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", cOriginalType: ");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", dwMsgSeq: ");
    localStringBuilder.append(this.o);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQGAudioMsgHandler.SubCmd0x8DMsg
 * JD-Core Version:    0.7.0.1
 */