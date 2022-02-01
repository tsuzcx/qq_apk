package com.sina.weibo.sdk.share;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.MultiImageObject;
import com.sina.weibo.sdk.api.VideoSourceObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class d
  extends AsyncTask<WeiboMultiMessage, Void, c>
{
  private WeakReference<Context> I;
  private b J;
  
  public d(Context paramContext, b paramb)
  {
    this.I = new WeakReference(paramContext);
    this.J = paramb;
  }
  
  private c a(WeiboMultiMessage... paramVarArgs)
  {
    Object localObject1 = (Context)this.I.get();
    if (localObject1 == null) {
      return null;
    }
    paramVarArgs = paramVarArgs[0];
    if (paramVarArgs == null) {
      return null;
    }
    c localc = new c();
    Object localObject3;
    for (;;)
    {
      Object localObject4;
      try
      {
        if ((paramVarArgs.imageObject != null) && (paramVarArgs.multiImageObject != null)) {
          paramVarArgs.imageObject = null;
        }
        if ((paramVarArgs.videoSourceObject != null) && ((paramVarArgs.imageObject != null) || (paramVarArgs.multiImageObject != null)))
        {
          paramVarArgs.imageObject = null;
          paramVarArgs.multiImageObject = null;
        }
        if (paramVarArgs.multiImageObject == null) {
          break label273;
        }
        ArrayList localArrayList = new ArrayList();
        localObject3 = paramVarArgs.multiImageObject.getImageList().iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (Uri)((Iterator)localObject3).next();
        if ((localObject4 == null) || (!com.sina.weibo.sdk.c.b.a((Context)localObject1, (Uri)localObject4))) {
          continue;
        }
        localObject4 = a.a((Context)localObject1, (Uri)localObject4, 1);
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          break label243;
        }
        throw new IllegalArgumentException("image's path is null");
      }
      catch (Throwable localThrowable)
      {
        localc.F = false;
        localObject1 = localThrowable.getMessage();
        paramVarArgs = (WeiboMultiMessage[])localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramVarArgs = localThrowable.toString();
        }
        localc.errorMessage = paramVarArgs;
        com.sina.weibo.sdk.c.c.b("WBShareTag", "prepare resource error is :" + paramVarArgs);
      }
      return localc;
      label243:
      localThrowable.add(Uri.fromFile(new File((String)localObject4)));
    }
    paramVarArgs.multiImageObject.imageList = localThrowable;
    label273:
    Object localObject2;
    long l;
    if (paramVarArgs.videoSourceObject != null)
    {
      localObject2 = paramVarArgs.videoSourceObject.videoPath;
      if ((localObject2 != null) && (com.sina.weibo.sdk.c.b.b((Context)localObject1, (Uri)localObject2)))
      {
        localObject1 = a.a((Context)localObject1, (Uri)localObject2, 0);
        com.sina.weibo.sdk.c.c.a("WBShareTag", "prepare video resource and video'path is" + (String)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          throw new IllegalArgumentException("video's path is null");
        }
        paramVarArgs.videoSourceObject.videoPath = Uri.fromFile(new File((String)localObject1));
        localObject2 = paramVarArgs.videoSourceObject;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label410;
        }
        l = 0L;
      }
    }
    for (;;)
    {
      ((VideoSourceObject)localObject2).during = l;
      localc.G = paramVarArgs;
      localc.F = true;
      break;
      label410:
      if (!new File((String)localObject1).exists())
      {
        l = 0L;
      }
      else
      {
        localObject3 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject3).setDataSource((String)localObject1);
        l = Long.parseLong(((MediaMetadataRetriever)localObject3).extractMetadata(9));
      }
    }
  }
  
  protected final void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.share.d
 * JD-Core Version:    0.7.0.1
 */