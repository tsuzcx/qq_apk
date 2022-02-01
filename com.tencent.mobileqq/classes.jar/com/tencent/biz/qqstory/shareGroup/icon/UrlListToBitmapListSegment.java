package com.tencent.biz.qqstory.shareGroup.icon;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class UrlListToBitmapListSegment
  extends JobSegment<List<String>, List<Bitmap>>
{
  private String a = "story.icon.UrlListToBitmapListSegment";
  private String b;
  private int c;
  private final Bitmap d;
  private UrlBitmapDownloader e;
  
  public UrlListToBitmapListSegment(@Nullable Bitmap paramBitmap, String paramString, int paramInt, UrlBitmapDownloader paramUrlBitmapDownloader)
  {
    this.d = paramBitmap;
    paramBitmap = new StringBuilder();
    paramBitmap.append(this.a);
    paramBitmap.append("[");
    paramBitmap.append(paramString);
    paramBitmap.append("]");
    this.a = paramBitmap.toString();
    this.b = paramString;
    this.c = paramInt;
    this.e = paramUrlBitmapDownloader;
  }
  
  protected void a(JobContext paramJobContext, List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramJobContext = Collections.unmodifiableList(paramList);
      int i = paramJobContext.size();
      paramList = new Bitmap[i];
      Arrays.fill(paramList, this.d);
      IconLog.b(this.a, "bitmapListSize = %d, stubBitmap = %s", Integer.valueOf(i), this.d);
      Handler localHandler = new Handler(ThreadManager.getSubThreadLooper(), new UrlListToBitmapListSegment.InnerCallBack(this, null));
      localHandler.sendMessageDelayed(Message.obtain(localHandler, 0, paramList), 300L);
      i = this.c / 2;
      Iterator localIterator = paramJobContext.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!"stub_url".equals(str)) {
          this.e.a(str, i, i, new UrlListToBitmapListSegment.1(this, paramJobContext, paramList, localHandler));
        }
      }
      return;
    }
    notifyError(new ErrorMessage(-1, "url list is empty"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.UrlListToBitmapListSegment
 * JD-Core Version:    0.7.0.1
 */