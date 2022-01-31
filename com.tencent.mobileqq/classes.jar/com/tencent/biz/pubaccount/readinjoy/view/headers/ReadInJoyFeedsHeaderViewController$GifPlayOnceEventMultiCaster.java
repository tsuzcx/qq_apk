package com.tencent.biz.pubaccount.readinjoy.view.headers;

import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import mqi;
import mqq.util.WeakReference;

public class ReadInJoyFeedsHeaderViewController$GifPlayOnceEventMultiCaster
{
  private static Map a = new WeakHashMap();
  private static Map b = new WeakHashMap();
  
  public void a()
  {
    a.clear();
    b.clear();
  }
  
  public void a(ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster.GifStateListener paramGifStateListener, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable.getCurrDrawable() instanceof GifDrawable))
    {
      AbstractGifImage localAbstractGifImage = ((GifDrawable)paramURLDrawable.getCurrDrawable()).getImage();
      paramURLDrawable = new mqi(localAbstractGifImage);
      localAbstractGifImage.setGIFPlayOnceListener(paramURLDrawable);
      b.put(localAbstractGifImage, paramURLDrawable);
      List localList = (List)a.get(localAbstractGifImage);
      paramURLDrawable = localList;
      if (localList == null) {
        paramURLDrawable = new ArrayList();
      }
      paramURLDrawable.add(new WeakReference(paramGifStateListener));
      a.put(localAbstractGifImage, paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster
 * JD-Core Version:    0.7.0.1
 */