package com.tencent.biz.qqstory.takevideo;

import android.widget.EditText;
import com.tencent.util.InputMethodUtil;

class EditVideoPoiSearch$1
  implements Runnable
{
  EditVideoPoiSearch$1(EditVideoPoiSearch paramEditVideoPoiSearch) {}
  
  public void run()
  {
    this.this$0.a.setFocusableInTouchMode(true);
    this.this$0.a.requestFocus();
    InputMethodUtil.a(this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPoiSearch.1
 * JD-Core Version:    0.7.0.1
 */