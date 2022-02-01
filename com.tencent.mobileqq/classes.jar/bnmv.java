import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialProviderView;

public class bnmv
  extends bomu
{
  public bnmv(AEMaterialProviderView paramAEMaterialProviderView) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialProviderView", 2, "material list updated!");
    }
    if (AEMaterialProviderView.a(this.a)) {
      return;
    }
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnmv
 * JD-Core Version:    0.7.0.1
 */