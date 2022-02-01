package com.tencent.biz.qqstory.channel;

import android.text.TextUtils;

public class QQStoryCmdHandler$CmdDumpInfo
{
  public final long a;
  public final String b;
  public final String c;
  public int d;
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof CmdDumpInfo)) {
      return TextUtils.equals(((CmdDumpInfo)paramObject).b, this.b);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(this.b));
    localStringBuilder.append("\n");
    localStringBuilder.append("-t ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("  -dt ");
    localStringBuilder.append(String.valueOf(this.a));
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.QQStoryCmdHandler.CmdDumpInfo
 * JD-Core Version:    0.7.0.1
 */