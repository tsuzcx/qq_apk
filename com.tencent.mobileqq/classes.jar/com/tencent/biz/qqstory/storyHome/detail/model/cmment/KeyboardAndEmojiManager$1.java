package com.tencent.biz.qqstory.storyHome.detail.model.cmment;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class KeyboardAndEmojiManager$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_a_of_type_Boolean;
  
  KeyboardAndEmojiManager$1(KeyboardAndEmojiManager paramKeyboardAndEmojiManager) {}
  
  public void onGlobalLayout()
  {
    KeyboardAndEmojiManager.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager).getWindowVisibleDisplayFrame(this.jdField_a_of_type_AndroidGraphicsRect);
    int i = this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top;
    if (i != this.jdField_a_of_type_Int)
    {
      int j = KeyboardAndEmojiManager.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager).getRootView().getHeight();
      if (j - i > j / 4)
      {
        this.jdField_a_of_type_Boolean = true;
        KeyboardAndEmojiManager.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager);
      }
      else if (this.jdField_a_of_type_Boolean)
      {
        KeyboardAndEmojiManager.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentKeyboardAndEmojiManager);
      }
      this.jdField_a_of_type_Int = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.KeyboardAndEmojiManager.1
 * JD-Core Version:    0.7.0.1
 */