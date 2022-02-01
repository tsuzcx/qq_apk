package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationFileAssistant;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationFileAssistant;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;

class DatalineChatPie$3
  implements Runnable
{
  DatalineChatPie$3(DatalineChatPie paramDatalineChatPie) {}
  
  public void run()
  {
    this.this$0.d.getDataLineMsgProxy(0).a(true);
    this.this$0.d.getDataLineMsgProxy(1).a(true);
    if (QFileAssistantUtils.a(this.this$0.ah.b))
    {
      this.this$0.f.getIntent().putExtra("qq_sub_business_id", 110);
      this.this$0.f.getIntent().putExtra("enter_from", 51);
      this.this$0.f.getIntent().putExtra("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationFileAssistant.a);
      this.this$0.f.getIntent().putExtra("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationFileAssistant.a);
    }
    DatalineChatPie.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DatalineChatPie.3
 * JD-Core Version:    0.7.0.1
 */