package com.tencent.biz.qqstory.storyHome.detail.model.cmment;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.text.TextUtils;

class KeyboardAndEmojiManager$3
  implements EmoticonCallback
{
  KeyboardAndEmojiManager$3(KeyboardAndEmojiManager paramKeyboardAndEmojiManager) {}
  
  public void delete()
  {
    if (KeyboardAndEmojiManager.d(this.a) != null) {
      TextUtils.backspace(KeyboardAndEmojiManager.d(this.a));
    }
  }
  
  public void emoticonMall() {}
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void send() {}
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    if (((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) && (KeyboardAndEmojiManager.d(this.a) != null)) {
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).send(KeyboardAndEmojiManager.d(), KeyboardAndEmojiManager.e(this.a), KeyboardAndEmojiManager.d(this.a), null);
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.KeyboardAndEmojiManager.3
 * JD-Core Version:    0.7.0.1
 */