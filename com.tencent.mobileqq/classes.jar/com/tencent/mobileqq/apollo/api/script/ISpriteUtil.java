package com.tencent.mobileqq.apollo.api.script;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ISpriteUtil
  extends QRouteApi
{
  public abstract void canInitCmShow(QQAppInterface paramQQAppInterface);
  
  public abstract boolean canUseCmShow(QQAppInterface paramQQAppInterface, int paramInt, String paramString);
  
  public abstract int getAIOSurfaceInitHeight();
  
  public abstract int getAIOSurfaceInitWidth();
  
  public abstract ISpriteActionScript getActionScript(QQAppInterface paramQQAppInterface);
  
  public abstract ISpriteContext getSpriteContext(QQAppInterface paramQQAppInterface);
  
  public abstract int getWaitingMargin(Context paramContext);
  
  public abstract boolean isCmShowKeywordAssociationActive(QQAppInterface paramQQAppInterface);
  
  public abstract boolean isProperAIO(QQAppInterface paramQQAppInterface, int paramInt, String paramString);
  
  public abstract boolean isSpriteHidden(QQAppInterface paramQQAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.script.ISpriteUtil
 * JD-Core Version:    0.7.0.1
 */