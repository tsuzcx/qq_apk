package com.huawei.agconnect;

import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Task;

public abstract interface CustomCredentialsProvider
{
  public abstract Task<Token> getTokens(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.agconnect.CustomCredentialsProvider
 * JD-Core Version:    0.7.0.1
 */