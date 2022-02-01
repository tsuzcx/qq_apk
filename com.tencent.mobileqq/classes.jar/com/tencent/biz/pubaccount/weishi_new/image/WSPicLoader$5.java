package com.tencent.biz.pubaccount.weishi_new.image;

import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.List;

class WSPicLoader$5
  implements Runnable
{
  WSPicLoader$5(WSPicLoader paramWSPicLoader, List paramList, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.a.size())
    {
      Object localObject = (stSimpleMetaFeed)this.a.get(i);
      String str = WeishiUtils.a((stSimpleMetaFeed)localObject, this.b);
      if (!TextUtils.isEmpty(str))
      {
        localObject = WeishiUIUtil.a((stSimpleMetaFeed)localObject);
        this.this$0.a(str, ((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue(), this.c);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader.5
 * JD-Core Version:    0.7.0.1
 */