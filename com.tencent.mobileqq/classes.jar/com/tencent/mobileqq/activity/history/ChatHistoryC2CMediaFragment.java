package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

public class ChatHistoryC2CMediaFragment
  extends ChatHistoryMediaBaseFragment
{
  private FMObserver y = new ChatHistoryC2CMediaFragment.1(this);
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1)) {
      AIOImageListScene.a(this.d, paramIntent);
    }
  }
  
  public void i()
  {
    super.i();
    if (this.y != null) {
      this.a.getFileManagerNotifyCenter().addObserver(this.y);
    }
    ReportController.b(this.a, "dc00898", "", "", "0X800A0B0", "0X800A0B0", 2, 0, "", "", "", "");
  }
  
  public void j()
  {
    super.j();
    if (this.y != null) {
      this.a.getFileManagerNotifyCenter().deleteObserver(this.y);
    }
  }
  
  public void k()
  {
    super.k();
    if (this.y != null) {
      this.a.getFileManagerNotifyCenter().deleteObserver(this.y);
    }
  }
  
  protected void v()
  {
    if ((this.t != null) && (this.t.size() > 0) && (this.s != null))
    {
      this.s.l();
      ReportController.b(this.a, "dc00898", "", "", "0X800A0B2", "0X800A0B2", 1, 0, "", "", "", "");
    }
  }
  
  void w()
  {
    ReportController.b(this.a, "dc00898", "", "", "0X800A0B5", "0X800A0B5", 1, 0, "", "", "", "");
  }
  
  void x()
  {
    ReportController.b(this.a, "dc00898", "", "", "0X800A0B3", "0X800A0B3", 1, 0, "", "", "", "");
  }
  
  void y()
  {
    ReportController.b(this.a, "dc00898", "", "", "0X800A0B1", "0X800A0B1", 1, 0, "", "", "", "");
  }
  
  void z()
  {
    ReportController.b(this.a, "dc00898", "", "", "0X800A0B4", "0X800A0B4", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CMediaFragment
 * JD-Core Version:    0.7.0.1
 */