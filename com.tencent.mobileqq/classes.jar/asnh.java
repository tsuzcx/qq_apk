import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.qphone.base.util.QLog;

class asnh
  extends anul
{
  asnh(asnf paramasnf) {}
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "CameraEmo, onCameraEmoInsert");
    }
    this.a.c();
    if ((this.a.a.a != null) && (((asgf)this.a.a.a.getManager(333)).a() > 0)) {
      this.a.b();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "CameraEmo, doOnGetEmoListResult");
    }
    if (paramInt == 0)
    {
      if ((this.a.a.a != null) && (((asgf)this.a.a.a.getManager(333)).a() > 0)) {
        this.a.b();
      }
      this.a.c();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "CameraEmo, onCameraEmoSend");
    }
    this.a.c();
    asnf.a(this.a, paramInt);
  }
  
  protected void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "CameraEmo, doOnDeleteEmoResult");
    }
    if (paramInt == 0) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnh
 * JD-Core Version:    0.7.0.1
 */