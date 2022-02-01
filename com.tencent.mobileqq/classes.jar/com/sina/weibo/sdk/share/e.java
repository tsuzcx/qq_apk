package com.sina.weibo.sdk.share;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.StoryObject;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.lang.ref.WeakReference;

public final class e
  extends AsyncTask<StoryMessage, Void, c>
{
  private WeakReference<Context> I;
  private b J;
  
  public e(Context paramContext, b paramb)
  {
    this.I = new WeakReference(paramContext);
    this.J = paramb;
  }
  
  private c a(StoryMessage... paramVarArgs)
  {
    Context localContext = (Context)this.I.get();
    if (localContext == null) {
      return null;
    }
    Object localObject = paramVarArgs[0];
    if (localObject == null) {
      return null;
    }
    paramVarArgs = new c();
    try
    {
      Uri localUri = ((StoryMessage)localObject).getImageUri();
      if ((localUri != null) && (com.sina.weibo.sdk.c.b.a(localContext, localUri)))
      {
        paramVarArgs.H = b(localContext, localUri, 1);
        paramVarArgs.F = true;
      }
      localObject = ((StoryMessage)localObject).getVideoUri();
      if ((localObject != null) && (com.sina.weibo.sdk.c.b.b(localContext, (Uri)localObject)))
      {
        paramVarArgs.H = b(localContext, (Uri)localObject, 0);
        paramVarArgs.F = true;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        paramVarArgs.F = false;
        paramVarArgs.errorMessage = localThrowable.getMessage();
      }
    }
    return paramVarArgs;
  }
  
  private static StoryObject b(Context paramContext, Uri paramUri, int paramInt)
  {
    paramUri = a.a(paramContext, paramUri, paramInt);
    if (TextUtils.isEmpty(paramUri)) {
      return null;
    }
    StoryObject localStoryObject = new StoryObject();
    localStoryObject.sourcePath = paramUri;
    localStoryObject.sourceType = paramInt;
    localStoryObject.appId = com.sina.weibo.sdk.a.a().getAppKey();
    localStoryObject.appPackage = paramContext.getPackageName();
    localStoryObject.callbackAction = "com.sina.weibo.sdk.action.ACTION_SDK_REQ_STORY";
    return localStoryObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.share.e
 * JD-Core Version:    0.7.0.1
 */