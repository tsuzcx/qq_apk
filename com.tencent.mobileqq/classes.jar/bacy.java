import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class bacy
  extends SimpleObserver<babr>
{
  bacy(bacw parambacw, babr parambabr) {}
  
  public void a(babr parambabr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onNext. info position=", Integer.valueOf(parambabr.c), ", old status=", Integer.valueOf(parambabr.g) });
    }
    this.jdField_a_of_type_Bacw.b.remove(parambabr);
    this.jdField_a_of_type_Bacw.a(1, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onError. info position=", Integer.valueOf(this.jdField_a_of_type_Babr.c), ", old status=", Integer.valueOf(this.jdField_a_of_type_Babr.g) });
    }
    this.jdField_a_of_type_Babr.g = 2;
    this.jdField_a_of_type_Bacw.b.remove(this.jdField_a_of_type_Babr);
    QLog.d("VideoItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Bacw.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bacw.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Babr.c);
      if ((localObject instanceof bacz))
      {
        localObject = (bacz)localObject;
        if (this.jdField_a_of_type_Babr.d.equals(((bacz)localObject).a.getTag())) {
          ((bacw)((babc)this.jdField_a_of_type_Bacw.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((bacm)localObject, this.jdField_a_of_type_Babr, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      bamv.a("hw_entry_upload", "upload_video", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Babr.a), "");
    }
    if (this.jdField_a_of_type_Babr.d.equals(this.jdField_a_of_type_Bacw.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bacw.a(1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bacy
 * JD-Core Version:    0.7.0.1
 */