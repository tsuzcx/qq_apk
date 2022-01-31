import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.qzonevip.gift.particle.ParticleTextureView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class auor
  extends Handler
{
  private Bitmap[] jdField_a_of_type_ArrayOfAndroidGraphicsBitmap;
  
  public auor(ParticleTextureView paramParticleTextureView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      QLog.i("ParticleTextureView", 1, "handleMessage: MSG_INIT_DATA");
      this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView.a();
      ParticleTextureView.a(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView, 2);
      return;
      this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView.c = 0;
      QLog.i("ParticleTextureView", 1, "handleMessage: MSG_ADD_DATA");
      this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView.a(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap);
      ParticleTextureView.a(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView, 4);
      return;
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView;
      paramMessage.c += 1;
      this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView.a();
      if (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView.a())
      {
        ParticleTextureView.a(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView, 2);
        return;
      }
      ParticleTextureView.a(this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView, 4);
      return;
      QLog.i("ParticleTextureView", 1, "handleMessage: MSG_REFRESH_VIEW size = " + this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView.jdField_a_of_type_JavaUtilArrayList.size());
    } while ((this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView.jdField_a_of_type_JavaUtilArrayList.size() <= 0) && (this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_ComTencentMobileqqQzonevipGiftParticleParticleTextureView.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auor
 * JD-Core Version:    0.7.0.1
 */