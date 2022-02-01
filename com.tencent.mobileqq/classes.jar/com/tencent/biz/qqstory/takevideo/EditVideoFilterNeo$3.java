package com.tencent.biz.qqstory.takevideo;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.AddressDataProvider.AddressInfo;

class EditVideoFilterNeo$3
  implements Runnable
{
  EditVideoFilterNeo$3(EditVideoFilterNeo paramEditVideoFilterNeo, AddressDataProvider.AddressInfo paramAddressInfo) {}
  
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
      this.this$0.a.a.a.putString("extra_local_address_city_name", str);
      return;
      str = this.a.b;
      continue;
      str = this.a.c;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoFilterNeo.3
 * JD-Core Version:    0.7.0.1
 */