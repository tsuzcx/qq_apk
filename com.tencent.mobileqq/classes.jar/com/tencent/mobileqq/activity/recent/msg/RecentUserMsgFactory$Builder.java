package com.tencent.mobileqq.activity.recent.msg;

import android.util.SparseArray;
import com.tencent.mobileqq.data.entitymanager.Provider;

public final class RecentUserMsgFactory$Builder
{
  private Provider<SparseArray<MsgDeserialize>> a;
  private Provider<SparseArray<MsgSerialize>> b;
  private Provider<SparseArray<Provider<RecentMsgProxy>>> c;
  private Provider<MsgSerialize> d;
  
  public Builder a(Provider<SparseArray<MsgDeserialize>> paramProvider)
  {
    this.a = paramProvider;
    return this;
  }
  
  public RecentUserMsgFactory a()
  {
    return new RecentUserMsgFactory(this, null);
  }
  
  public Builder b(Provider<SparseArray<MsgSerialize>> paramProvider)
  {
    this.b = paramProvider;
    return this;
  }
  
  public Builder c(Provider<SparseArray<Provider<RecentMsgProxy>>> paramProvider)
  {
    this.c = paramProvider;
    return this;
  }
  
  public Builder d(Provider<MsgSerialize> paramProvider)
  {
    this.d = paramProvider;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.RecentUserMsgFactory.Builder
 * JD-Core Version:    0.7.0.1
 */