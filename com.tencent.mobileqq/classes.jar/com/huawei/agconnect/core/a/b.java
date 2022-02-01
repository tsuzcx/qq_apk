package com.huawei.agconnect.core.a;

import com.huawei.agconnect.CustomCredentialsProvider;
import com.huawei.agconnect.core.service.auth.CredentialsProvider;
import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Task;

class b
  implements CredentialsProvider
{
  b(d paramd, CustomCredentialsProvider paramCustomCredentialsProvider) {}
  
  public Task<Token> getTokens()
  {
    return this.a.getTokens(false);
  }
  
  public Task<Token> getTokens(boolean paramBoolean)
  {
    return this.a.getTokens(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.core.a.b
 * JD-Core Version:    0.7.0.1
 */