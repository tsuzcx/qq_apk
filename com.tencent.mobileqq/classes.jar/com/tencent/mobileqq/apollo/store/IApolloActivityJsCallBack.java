package com.tencent.mobileqq.apollo.store;

import android.app.Activity;
import java.util.ArrayList;

public abstract interface IApolloActivityJsCallBack
{
  public abstract String a(int paramInt, ApolloWebAvatarParam paramApolloWebAvatarParam);
  
  public abstract String a(ApolloStoreViewController.PlayActionData paramPlayActionData);
  
  public abstract String a(ArrayList<ApolloWebAvatarParam> paramArrayList);
  
  public abstract String a(int[] paramArrayOfInt);
  
  public abstract void a(int paramInt, int[] paramArrayOfInt);
  
  public abstract void a(Activity paramActivity, String paramString1, String paramString2);
  
  public abstract void a(boolean paramBoolean, float paramFloat1, float paramFloat2);
  
  public abstract String b();
  
  public abstract void b(ArrayList<String> paramArrayList);
  
  public abstract boolean b(String paramString);
  
  public abstract void c(int paramInt);
  
  public abstract boolean c(String paramString);
  
  public abstract void d(int paramInt);
  
  public abstract String e(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.IApolloActivityJsCallBack
 * JD-Core Version:    0.7.0.1
 */