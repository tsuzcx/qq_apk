package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stCollection;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

public class WSVerticalItemBottomSimpleCollectionController
  extends AbsWSVerticalItemBottomSubCollectionController
{
  private stCollection a;
  
  public WSVerticalItemBottomSimpleCollectionController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext, paramWSVerticalVideoHolder);
  }
  
  protected String a()
  {
    return this.a.barText;
  }
  
  protected void a()
  {
    super.a();
    if (a() != null) {
      this.a = ((WSVerticalItemData)a()).a();
    }
  }
  
  protected boolean a()
  {
    stCollection localstCollection = this.a;
    return (localstCollection != null) && (!TextUtils.isEmpty(localstCollection.barText));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomSimpleCollectionController
 * JD-Core Version:    0.7.0.1
 */