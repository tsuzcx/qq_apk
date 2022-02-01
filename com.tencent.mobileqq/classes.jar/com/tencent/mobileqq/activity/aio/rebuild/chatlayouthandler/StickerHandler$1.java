package com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler;

import android.content.Intent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerDoubleClickListener;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;

class StickerHandler$1
  implements EmojiStickerManager.StickerDoubleClickListener
{
  StickerHandler$1(StickerHandler paramStickerHandler) {}
  
  public void a(View paramView)
  {
    String str = IndividuationUrlHelper.a("aioEmojiStickerDetail");
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent instanceof ChatXListView)) {
      EmojiStickerManager.w = ((ChatXListView)localViewParent).getPositionForView(paramView);
    }
    paramView = new Intent(StickerHandler.a(this.a).getApp(), QQBrowserActivity.class);
    paramView.setFlags(268435456);
    int i = 1;
    paramView.putExtra("vasUsePreWebview", true);
    VasWebviewUtil.b(StickerHandler.b(this.a).getApp(), str, -1L, paramView, false, -1);
    if (EmojiStickerManager.a().h != 0) {
      if (EmojiStickerManager.a().h == 1) {
        i = 2;
      } else if (EmojiStickerManager.a().h == 3000) {
        i = 3;
      } else {
        i = -1;
      }
    }
    VasWebviewUtil.a(StickerHandler.c(this.a).getCurrentUin(), "Stick", "ClickDetail", String.valueOf(i), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.StickerHandler.1
 * JD-Core Version:    0.7.0.1
 */