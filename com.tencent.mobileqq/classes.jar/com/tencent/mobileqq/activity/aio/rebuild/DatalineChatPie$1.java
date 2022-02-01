package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.BottomBtnClickListener;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineDeviceChooseModel;
import java.util.ArrayList;
import java.util.LinkedList;

class DatalineChatPie$1
  implements PhotoListPanel.BottomBtnClickListener
{
  DatalineChatPie$1(DatalineChatPie paramDatalineChatPie) {}
  
  public boolean a(PhotoListPanel paramPhotoListPanel)
  {
    ArrayList localArrayList;
    if (!paramPhotoListPanel.a.isEmpty()) {
      localArrayList = new ArrayList(paramPhotoListPanel.a);
    } else {
      localArrayList = null;
    }
    DatalineChatPie.a(this.a, paramPhotoListPanel, localArrayList);
    return true;
  }
  
  public boolean b(PhotoListPanel paramPhotoListPanel)
  {
    DatalineDeviceChooseModel.a(new ArrayList(paramPhotoListPanel.a)).a(this.a.a(), this.a.a, new DatalineChatPie.1.1(this, paramPhotoListPanel, paramPhotoListPanel));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DatalineChatPie.1
 * JD-Core Version:    0.7.0.1
 */