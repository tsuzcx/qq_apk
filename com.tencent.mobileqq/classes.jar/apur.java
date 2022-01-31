import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.qphone.base.util.QLog;

class apur
  extends alpj
{
  apur(apuo paramapuo) {}
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "CameraEmo, onCameraEmoInsert");
    }
    this.a.k();
    if ((this.a.a.a != null) && (((apnv)this.a.a.a.getManager(333)).a() > 0)) {
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
      if ((this.a.a.a != null) && (((apnv)this.a.a.a.getManager(333)).a() > 0)) {
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
    apuo.a(this.a, paramInt);
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
 * Qualified Name:     apur
 * JD-Core Version:    0.7.0.1
 */