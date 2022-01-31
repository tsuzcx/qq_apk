import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class azbs
  extends SimpleObserver<azal>
{
  azbs(azbq paramazbq, azal paramazal) {}
  
  public void a(azal paramazal)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onNext. info position=", Integer.valueOf(paramazal.c), ", old status=", Integer.valueOf(paramazal.g) });
    }
    this.jdField_a_of_type_Azbq.b.remove(paramazal);
    this.jdField_a_of_type_Azbq.a(1, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onError. info position=", Integer.valueOf(this.jdField_a_of_type_Azal.c), ", old status=", Integer.valueOf(this.jdField_a_of_type_Azal.g) });
    }
    this.jdField_a_of_type_Azal.g = 2;
    this.jdField_a_of_type_Azbq.b.remove(this.jdField_a_of_type_Azal);
    QLog.d("VideoItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Azbq.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Azbq.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Azal.c);
      if ((localObject instanceof azbt))
      {
        localObject = (azbt)localObject;
        if (this.jdField_a_of_type_Azal.d.equals(((azbt)localObject).a.getTag())) {
          ((azbq)((ayzw)this.jdField_a_of_type_Azbq.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((azbg)localObject, this.jdField_a_of_type_Azal, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      azld.a("hw_entry_upload", "upload_video", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Azal.a), "");
    }
    if (this.jdField_a_of_type_Azal.d.equals(this.jdField_a_of_type_Azbq.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Azbq.a(1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azbs
 * JD-Core Version:    0.7.0.1
 */