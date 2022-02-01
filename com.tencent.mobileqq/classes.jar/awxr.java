import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager.4;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class awxr
  extends biht
{
  public awxr(PngFrameManager.4 param4, String paramString) {}
  
  public void onDone(bihu parambihu)
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
          if (parambihu.a() != 3) {
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.this$0.a.obtainMessage(226, this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.a).sendToTarget();
          }
        }
        else {
          return;
        }
      }
      try
      {
        bhmi.a(this.jdField_a_of_type_JavaLangString, asos.z.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.a.jdField_a_of_type_JavaLangString), false);
        new File(this.jdField_a_of_type_JavaLangString).delete();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.this$0.b(this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.a.jdField_a_of_type_Ahmg.a.a.epId);
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.this$0.a.obtainMessage(225, this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$4.a).sendToTarget();
        continue;
        parambihu = finally;
        throw parambihu;
      }
      catch (IOException parambihu)
      {
        for (;;)
        {
          parambihu.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxr
 * JD-Core Version:    0.7.0.1
 */