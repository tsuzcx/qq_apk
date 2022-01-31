import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.qphone.base.util.QLog;

class apqi
  extends alku
{
  apqi(apqf paramapqf) {}
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "CameraEmo, onCameraEmoInsert");
    }
    this.a.k();
    if ((this.a.a.a != null) && (((apjm)this.a.a.a.getManager(333)).a() > 0)) {
      this.a.j();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "CameraEmo, doOnGetEmoListResult");
    }
    if (paramInt == 0)
    {
      if ((this.a.a.a != null) && (((apjm)this.a.a.a.getManager(333)).a() > 0)) {
        this.a.j();
      }
      this.a.k();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "CameraEmo, onCameraEmoSend");
    }
    this.a.k();
    apqf.a(this.a, paramInt);
  }
  
  protected void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "CameraEmo, doOnDeleteEmoResult");
    }
    if (paramInt == 0) {
      this.a.k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqi
 * JD-Core Version:    0.7.0.1
 */