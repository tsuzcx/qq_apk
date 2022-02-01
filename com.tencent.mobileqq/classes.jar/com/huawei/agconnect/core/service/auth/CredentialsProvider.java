package com.huawei.agconnect.core.service.auth;

import com.huawei.hmf.tasks.Task;

public abstract interface CredentialsProvider
{
  public abstract Task<Token> getTokens();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.core.service.auth.CredentialsProvider
 * JD-Core Version:    0.7.0.1
 */