package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class RefreshMessageContext
{
  public Object a = null;
  public List<MessageRecord> b = null;
  public boolean c = false;
  public boolean d = true;
  public boolean e = false;
  public boolean f = true;
  public boolean g = false;
  public boolean h = true;
  public boolean i = true;
  public boolean j = false;
  public boolean k = false;
  public int l = 0;
  public int m = 0;
  public int n = 0;
  public int o = 0;
  public String p;
  public int q;
  public int r;
  public volatile boolean s;
  public boolean t = false;
  long u = 9223372036854775807L;
  long v = 0L;
  public int w;
  public IRoamMsgFetcher x;
  public IMessageRefresher y;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[isComplete = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isJoined = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", isLocalOnly = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.RefreshMessageContext
 * JD-Core Version:    0.7.0.1
 */