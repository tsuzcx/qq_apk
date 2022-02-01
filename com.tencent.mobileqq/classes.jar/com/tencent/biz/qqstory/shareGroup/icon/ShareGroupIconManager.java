package com.tencent.biz.qqstory.shareGroup.icon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.LruCache;
import com.tencent.biz.qqstory.model.IManager;
import com.tencent.biz.qqstory.model.ITrimmable;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TrimmableManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.Collections;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;

public class ShareGroupIconManager
  implements IManager, ITrimmable
{
  private Context a = BaseApplicationImpl.getContext();
  private AtomicReference<Drawable> b = new AtomicReference();
  private AtomicReference<Bitmap> c = new AtomicReference();
  private int d = Math.min(UIUtils.a(this.a, 50.0F), 200);
  private UrlBitmapDownloader e = new ShareGroupIconManager.UrlBitmapDownloaderImp();
  private final LruCache<String, ShareGroupDrawableState> f = new ShareGroupIconManager.1(this, 40);
  
  private Stream<Bitmap> b(List<String> paramList, String paramString)
  {
    return Stream.of(paramList).map(new ThreadOffFunction("story.icon.ShareGroupIconManager", 2)).map(new UidListToUrlListSegment(paramString)).map(new UrlListToBitmapListSegment(e(), paramString, this.d, this.e)).map(new BitmapListToIconSegment(this.a, paramString, this.d)).map(new UIThreadOffFunction(null));
  }
  
  private Stream<Bitmap> c(List<String> paramList, String paramString)
  {
    return Stream.of(paramList).map(new ThreadOffFunction("story.icon.ShareGroupIconManager", 2)).map(new UinListToUidListSegment(paramString)).map(new UidListToUrlListSegment(paramString)).map(new UrlListToBitmapListSegment(e(), paramString, this.d, this.e)).map(new BitmapListToIconSegment(this.a, paramString, this.d)).map(new UIThreadOffFunction(null));
  }
  
  @NonNull
  public static String c(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      List localList = Collections.unmodifiableList(paramList);
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while ((i < 5) && (i < localList.size()))
      {
        localStringBuilder.append((String)paramList.get(i));
        localStringBuilder.append('.');
        i += 1;
      }
      return localStringBuilder.toString();
    }
    paramList = new IllegalArgumentException("unionIdList should not be null");
    for (;;)
    {
      throw paramList;
    }
  }
  
  private List<String> d(List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 5) {
        return Collections.unmodifiableList(paramList);
      }
      return Collections.unmodifiableList(paramList.subList(0, 5));
    }
    throw new IllegalArgumentException("unionIdList should not be null");
  }
  
  private Bitmap e()
  {
    this.c.compareAndSet(null, Bitmap.createBitmap(ImageUtil.n()));
    return (Bitmap)this.c.get();
  }
  
  public Drawable a(List<String> paramList, String paramString)
  {
    List localList = d(paramList);
    if (localList.isEmpty())
    {
      IconLog.c("story.icon.ShareGroupIconManager", "getIconDrawable unionIdList is empty");
      return d();
    }
    String str = c(localList);
    Object localObject = (ShareGroupDrawableState)this.f.get(str);
    paramList = (List<String>)localObject;
    if (localObject == null) {
      synchronized (this.f)
      {
        localObject = (ShareGroupDrawableState)this.f.get(str);
        paramList = (List<String>)localObject;
        if (localObject == null)
        {
          paramList = new ShareGroupDrawableState(str, this.a, d());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(String.valueOf(System.identityHashCode(paramList)));
          ((StringBuilder)localObject).append(".");
          ((StringBuilder)localObject).append(paramString);
          paramList.a(new ShareGroupIconManager.4(this, localList, ((StringBuilder)localObject).toString()));
          this.f.put(str, paramList);
          IconLog.c("story.icon.ShareGroupIconManager", "create share group state for uid list, state=%s, uid=%s", Integer.valueOf(System.identityHashCode(paramList)), new JSONArray(localList));
        }
      }
    }
    return paramList.newDrawable();
  }
  
  @Nullable
  public RestrictedBitmap a(List<String> paramList)
  {
    paramList = d(paramList);
    if (paramList.isEmpty())
    {
      IconLog.c("story.icon.ShareGroupIconManager", "getBitmap unionIdList is empty");
      return new RestrictedBitmap(e());
    }
    paramList = c(paramList);
    paramList = (ShareGroupDrawableState)this.f.get(paramList);
    if (paramList != null)
    {
      paramList = paramList.a();
      if (paramList != null) {
        return new RestrictedBitmap(paramList);
      }
    }
    return null;
  }
  
  public void a()
  {
    IconLog.a("story.icon.ShareGroupIconManager", "onInit");
    ((TrimmableManager)SuperManager.a(26)).a(this);
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        SLog.d("story.icon.ShareGroupIconManager", "clearAllMemory");
        c();
        return;
      }
      SLog.d("story.icon.ShareGroupIconManager", "trimMemory to be 5");
      if (Build.VERSION.SDK_INT >= 17) {
        this.f.trimToSize(5);
      }
    }
  }
  
  public void a(List<String> paramList, @NonNull ShareGroupIconManager.LoadBitmapCallBack paramLoadBitmapCallBack)
  {
    List localList = d(paramList);
    if (localList.isEmpty())
    {
      IconLog.c("story.icon.ShareGroupIconManager", "addLoadBitmapCallBack unionIdList is empty");
      paramLoadBitmapCallBack.a(new RestrictedBitmap(e()));
      return;
    }
    String str = c(d(paramList));
    ShareGroupDrawableState localShareGroupDrawableState = (ShareGroupDrawableState)this.f.get(str);
    paramList = localShareGroupDrawableState;
    if (localShareGroupDrawableState == null) {
      synchronized (this.f)
      {
        localShareGroupDrawableState = (ShareGroupDrawableState)this.f.get(str);
        paramList = localShareGroupDrawableState;
        if (localShareGroupDrawableState == null)
        {
          paramList = new ShareGroupDrawableState(str, this.a, d());
          paramList.a(new ShareGroupIconManager.2(this, localList, String.valueOf(System.identityHashCode(paramList))));
          this.f.put(str, paramList);
          IconLog.c("story.icon.ShareGroupIconManager", "create share group state for uin list for callback, state=%s, uin=%s", Integer.valueOf(System.identityHashCode(paramList)), new JSONArray(localList));
        }
      }
    }
    paramList.a(paramLoadBitmapCallBack);
    paramList.d();
  }
  
  public Drawable b(List<String> paramList)
  {
    return a(paramList, null);
  }
  
  public void b()
  {
    IconLog.a("story.icon.ShareGroupIconManager", "onDestroy");
    c();
    ((TrimmableManager)SuperManager.a(26)).b(this);
  }
  
  public void c()
  {
    this.b.set(null);
    this.c.set(null);
    this.f.evictAll();
  }
  
  public Drawable d()
  {
    this.b.compareAndSet(null, new BitmapDrawable(this.a.getResources(), e()));
    return (Drawable)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager
 * JD-Core Version:    0.7.0.1
 */