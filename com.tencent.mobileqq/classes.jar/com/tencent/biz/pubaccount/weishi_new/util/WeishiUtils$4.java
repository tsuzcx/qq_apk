package com.tencent.biz.pubaccount.weishi_new.util;

import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import UserGrowth.stImgReplacement;
import UserGrowth.stSimpleMetaFeed;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import rpj;
import rpk;
import sne;
import sni;
import snm;

public final class WeishiUtils$4
  implements Runnable
{
  public WeishiUtils$4(List paramList) {}
  
  public void run()
  {
    int i = 0;
    stSimpleMetaFeed localstSimpleMetaFeed;
    while (i < this.a.size())
    {
      localstSimpleMetaFeed = (stSimpleMetaFeed)this.a.get(i);
      if ((localstSimpleMetaFeed == null) || (localstSimpleMetaFeed.images == null) || (localstSimpleMetaFeed.images.size() < 1) || (TextUtils.isEmpty(((stMetaUgcImage)localstSimpleMetaFeed.images.get(0)).url))) {
        i += 1;
      } else {
        if ((localstSimpleMetaFeed.imgReplacements == null) || (localstSimpleMetaFeed.imgReplacements.size() <= 0) || (localstSimpleMetaFeed.imgReplacements.get(0) == null) || (!TextUtils.isEmpty(((stImgReplacement)localstSimpleMetaFeed.imgReplacements.get(0)).img)) || (Build.VERSION.SDK_INT <= 17)) {
          break label279;
        }
      }
    }
    label279:
    for (Object localObject1 = ((stImgReplacement)localstSimpleMetaFeed.imgReplacements.get(0)).img;; localObject1 = "")
    {
      Object localObject2 = sni.a((String)localObject1);
      if (localObject2 == null)
      {
        localObject2 = ((stMetaUgcImage)localstSimpleMetaFeed.images.get(0)).url;
        localObject1 = sni.a((String)localObject2);
        sne.b("PreloadCoverImgLog", "预加载默认的图片格式： " + (String)localObject2);
      }
      for (;;)
      {
        localObject2 = new rpk();
        ((rpk)localObject2).a = ((URL)localObject1);
        ((rpk)localObject2).b = true;
        rpj.a().a((rpk)localObject2, new snm(this));
        break;
        sne.b("PreloadCoverImgLog", "预加载图片webp： " + (String)localObject1);
        localObject1 = localObject2;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils.4
 * JD-Core Version:    0.7.0.1
 */