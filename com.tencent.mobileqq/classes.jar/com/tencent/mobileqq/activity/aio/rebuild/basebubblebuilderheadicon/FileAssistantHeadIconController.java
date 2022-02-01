package com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconController;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;

public class FileAssistantHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  protected void b()
  {
    String str = this.a.getExtInfoFromExtStr("dataline_msg_device_type");
    int i;
    if (!TextUtils.isEmpty(str)) {
      i = QFileAssistantUtils.a(Integer.valueOf(str).intValue());
    } else {
      i = 2130845605;
    }
    b(this.c.getResources().getDrawable(i));
  }
  
  protected void c()
  {
    a(null);
  }
  
  protected void d()
  {
    a(null);
  }
  
  protected void g()
  {
    a(this.a);
  }
  
  public boolean h()
  {
    return (!this.a.isMultiMsg) && (QFileAssistantUtils.a(this.d.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.FileAssistantHeadIconController
 * JD-Core Version:    0.7.0.1
 */