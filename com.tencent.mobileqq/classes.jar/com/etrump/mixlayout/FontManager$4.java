package com.etrump.mixlayout;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;

class FontManager$4
  implements Runnable
{
  FontManager$4(FontManager paramFontManager, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((FriendsManager)FontManager.a(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER)).x(this.a);
    FontManager.a(FontManager.a(this.this$0), this.a, localExtensionInfo, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.4
 * JD-Core Version:    0.7.0.1
 */