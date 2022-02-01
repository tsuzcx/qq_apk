package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stCollection;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

public class WSVerticalItemBottomSimpleCollectionController
  extends AbsWSVerticalItemBottomSubCollectionController
{
  private stCollection j;
  
  public WSVerticalItemBottomSimpleCollectionController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext, paramWSVerticalVideoHolder);
  }
  
  protected void a()
  {
    super.a();
    if (c() != null) {
      this.j = ((WSVerticalItemData)c()).h();
    }
  }
  
  protected boolean l()
  {
    stCollection localstCollection = this.j;
    return (localstCollection != null) && (!TextUtils.isEmpty(localstCollection.barText));
  }
  
  protected String m()
  {
    return this.j.barText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomSimpleCollectionController
 * JD-Core Version:    0.7.0.1
 */