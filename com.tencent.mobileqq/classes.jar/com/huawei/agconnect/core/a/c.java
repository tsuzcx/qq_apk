package com.huawei.agconnect.core.a;

import com.huawei.agconnect.CustomAuthProvider;
import com.huawei.agconnect.core.service.auth.AuthProvider;
import com.huawei.agconnect.core.service.auth.OnTokenListener;
import com.huawei.agconnect.core.service.auth.Token;
import com.huawei.hmf.tasks.Task;

class c
  implements AuthProvider
{
  c(d paramd, CustomAuthProvider paramCustomAuthProvider) {}
  
  public void addTokenListener(OnTokenListener paramOnTokenListener) {}
  
  public Task<Token> getTokens()
  {
    return this.a.getTokens(false);
  }
  
  public Task<Token> getTokens(boolean paramBoolean)
  {
    return this.a.getTokens(paramBoolean);
  }
  
  public String getUid()
  {
    return "";
  }
  
  public void removeTokenListener(OnTokenListener paramOnTokenListener) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.agconnect.core.a.c
 * JD-Core Version:    0.7.0.1
 */