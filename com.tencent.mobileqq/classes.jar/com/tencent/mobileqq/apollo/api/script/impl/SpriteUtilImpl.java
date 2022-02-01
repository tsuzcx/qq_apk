package com.tencent.mobileqq.apollo.api.script.impl;

import android.content.Context;
import com.tencent.mobileqq.apollo.api.script.ISpriteActionScript;
import com.tencent.mobileqq.apollo.api.script.ISpriteContext;
import com.tencent.mobileqq.apollo.api.script.ISpriteUtil;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.app.QQAppInterface;

public class SpriteUtilImpl
  implements ISpriteUtil
{
  public void canInitCmShow(QQAppInterface paramQQAppInterface)
  {
    SpriteUtil.a(paramQQAppInterface);
  }
  
  public boolean canUseCmShow(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    return SpriteUtil.b(paramQQAppInterface, paramInt, paramString);
  }
  
  public int getAIOSurfaceInitHeight()
  {
    return SpriteUtil.a();
  }
  
  public int getAIOSurfaceInitWidth()
  {
    return SpriteUtil.b();
  }
  
  public ISpriteActionScript getActionScript(QQAppInterface paramQQAppInterface)
  {
    return SpriteUtil.a(paramQQAppInterface);
  }
  
  public ISpriteContext getSpriteContext(QQAppInterface paramQQAppInterface)
  {
    return SpriteUtil.a(paramQQAppInterface);
  }
  
  public int getWaitingMargin(Context paramContext)
  {
    return SpriteUtil.a(paramContext);
  }
  
  public boolean isCmShowKeywordAssociationActive(QQAppInterface paramQQAppInterface)
  {
    return SpriteUtil.c(paramQQAppInterface);
  }
  
  public boolean isProperAIO(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    return SpriteUtil.a(paramQQAppInterface, paramInt, paramString);
  }
  
  public boolean isSpriteHidden(QQAppInterface paramQQAppInterface)
  {
    return SpriteUtil.a(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.script.impl.SpriteUtilImpl
 * JD-Core Version:    0.7.0.1
 */