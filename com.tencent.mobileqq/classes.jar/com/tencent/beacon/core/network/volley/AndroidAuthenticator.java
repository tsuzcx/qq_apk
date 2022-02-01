package com.tencent.beacon.core.network.volley;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

@SuppressLint({"MissingPermission"})
public class AndroidAuthenticator
  implements Authenticator
{
  private final Account mAccount;
  private final AccountManager mAccountManager;
  private final String mAuthTokenType;
  private final boolean mNotifyAuthFailure;
  
  AndroidAuthenticator(AccountManager paramAccountManager, Account paramAccount, String paramString, boolean paramBoolean)
  {
    this.mAccountManager = paramAccountManager;
    this.mAccount = paramAccount;
    this.mAuthTokenType = paramString;
    this.mNotifyAuthFailure = paramBoolean;
  }
  
  public AndroidAuthenticator(Context paramContext, Account paramAccount, String paramString)
  {
    this(paramContext, paramAccount, paramString, false);
  }
  
  public AndroidAuthenticator(Context paramContext, Account paramAccount, String paramString, boolean paramBoolean)
  {
    this(AccountManager.get(paramContext), paramAccount, paramString, paramBoolean);
  }
  
  public Account getAccount()
  {
    return this.mAccount;
  }
  
  public String getAuthToken()
  {
    Object localObject2 = null;
    AccountManagerFuture localAccountManagerFuture = this.mAccountManager.getAuthToken(this.mAccount, this.mAuthTokenType, this.mNotifyAuthFailure, null, null);
    try
    {
      Bundle localBundle = (Bundle)localAccountManagerFuture.getResult();
      Object localObject1 = localObject2;
      if (localAccountManagerFuture.isDone())
      {
        localObject1 = localObject2;
        if (!localAccountManagerFuture.isCancelled())
        {
          if (localBundle.containsKey("intent")) {
            break label81;
          }
          localObject1 = localBundle.getString("authtoken");
        }
      }
      if (localObject1 != null)
      {
        return localObject1;
        label81:
        throw new AuthFailureError((Intent)localBundle.getParcelable("intent"));
      }
      throw new AuthFailureError("Got null auth token for type: " + this.mAuthTokenType);
    }
    catch (Exception localException)
    {
      throw new AuthFailureError("Error while retrieving auth token", localException);
    }
  }
  
  public String getAuthTokenType()
  {
    return this.mAuthTokenType;
  }
  
  public void invalidateAuthToken(String paramString)
  {
    this.mAccountManager.invalidateAuthToken(this.mAccount.type, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.AndroidAuthenticator
 * JD-Core Version:    0.7.0.1
 */