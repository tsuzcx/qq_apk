package com.huawei.agconnect.core.service.auth;

import com.huawei.hmf.tasks.Task;

public abstract interface AuthProvider
{
  public abstract void addTokenListener(OnTokenListener paramOnTokenListener);
  
  public abstract Task<Token> getTokens();
  
  public abstract Task<Token> getTokens(boolean paramBoolean);
  
  public abstract String getUid();
  
  public abstract void removeTokenListener(OnTokenListener paramOnTokenListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.agconnect.core.service.auth.AuthProvider
 * JD-Core Version:    0.7.0.1
 */