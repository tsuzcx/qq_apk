package com.tencent.biz.qqstory.takevideo;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import vts;
import xyj;
import xzd;

public class EditVideoFilterNeo$3
  implements Runnable
{
  public EditVideoFilterNeo$3(xyj paramxyj, vts paramvts) {}
  
  public void run()
  {
    this.this$0.a.a(Message.obtain(null, 5, 0, 0, this.a));
    String str;
    if (TextUtils.isEmpty(this.a.c)) {
      if (TextUtils.isEmpty(this.a.b)) {
        str = this.a.a;
      }
    }
    for (;;)
    {
      this.this$0.a.a.mExtra.putString("extra_local_address_city_name", str);
      return;
      str = this.a.b;
      continue;
      str = this.a.c;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoFilterNeo.3
 * JD-Core Version:    0.7.0.1
 */