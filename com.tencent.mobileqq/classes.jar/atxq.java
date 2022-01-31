import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.4;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class atxq
  extends bead
{
  public atxq(PngFrameManager.4 param4, String paramString) {}
  
  public void onDone(beae parambeae)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameManager", 2, "func onDone.【pngZip】");
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.this$0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.this$0.a != null)
        {
          if (parambeae.a() != 3) {
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.this$0.a.obtainMessage(226, this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.a).sendToTarget();
          }
        }
        else {
          return;
        }
      }
      try
      {
        bdhb.a(this.jdField_a_of_type_JavaLangString, apvx.z.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.a.jdField_a_of_type_JavaLangString), false);
        new File(this.jdField_a_of_type_JavaLangString).delete();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.this$0.b(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.a.jdField_a_of_type_Afvu.a.a.epId);
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.this$0.a.obtainMessage(225, this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.a).sendToTarget();
        continue;
        parambeae = finally;
        throw parambeae;
      }
      catch (IOException parambeae)
      {
        for (;;)
        {
          parambeae.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atxq
 * JD-Core Version:    0.7.0.1
 */