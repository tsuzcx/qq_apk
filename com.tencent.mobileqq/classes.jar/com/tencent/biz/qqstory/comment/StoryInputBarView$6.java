package com.tencent.biz.qqstory.comment;

import android.graphics.drawable.Drawable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.text.TextUtils;

class StoryInputBarView$6
  implements EmoticonCallback
{
  StoryInputBarView$6(StoryInputBarView paramStoryInputBarView) {}
  
  public void delete()
  {
    if (this.a.e != null) {
      TextUtils.backspace(this.a.e);
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
    if (((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) && (this.a.e != null)) {
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).send(QQStoryContext.j(), this.a.a, this.a.e, null);
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.StoryInputBarView.6
 * JD-Core Version:    0.7.0.1
 */