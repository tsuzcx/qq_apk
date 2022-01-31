import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.qphone.base.util.QLog;

public class anyr
  extends ajth
{
  public anyr(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "CameraEmo, onCameraEmoInsert");
    }
    this.a.o();
    if ((this.a.a != null) && (((anse)this.a.a.getManager(333)).a() > 0)) {
      EmoticonMainPanel.c(this.a);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "CameraEmo, doOnGetEmoListResult");
    }
    if (paramInt == 0)
    {
      if ((this.a.a != null) && (((anse)this.a.a.getManager(333)).a() > 0)) {
        EmoticonMainPanel.c(this.a);
      }
      this.a.o();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "CameraEmo, onCameraEmoSend");
    }
    this.a.o();
    EmoticonMainPanel.a(this.a, paramInt);
  }
  
  protected void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "CameraEmo, doOnDeleteEmoResult");
    }
    if (paramInt == 0) {
      this.a.o();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anyr
 * JD-Core Version:    0.7.0.1
 */