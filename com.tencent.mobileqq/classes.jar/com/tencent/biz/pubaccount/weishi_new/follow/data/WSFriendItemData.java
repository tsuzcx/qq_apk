package com.tencent.biz.pubaccount.weishi_new.follow.data;

import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import java.util.ArrayList;

public class WSFriendItemData
  extends WSAbsSubItem<ArrayList<stSimpleMetaFeed>>
  implements Foldable<stSimpleMetaFeed>
{
  protected int c = 0;
  private boolean d;
  private String e;
  
  public WSFriendItemData()
  {
    this.a = new ArrayList();
    this.b = new StringBuilder();
  }
  
  private boolean b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    return ((TextUtils.isEmpty(this.e)) && (d() == 0)) || (TextUtils.equals(this.e, paramstSimpleMetaFeed.poster_id));
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (this.d) {
      WeiShiCacheManager.a().a(a());
    }
  }
  
  public boolean a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (b(paramstSimpleMetaFeed)))
    {
      this.e = paramstSimpleMetaFeed.poster_id;
      this.b.append(paramstSimpleMetaFeed.id);
      ((ArrayList)this.a).add(paramstSimpleMetaFeed);
      return true;
    }
    return false;
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public int d()
  {
    return ((ArrayList)this.a).size();
  }
  
  public int e()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.data.WSFriendItemData
 * JD-Core Version:    0.7.0.1
 */