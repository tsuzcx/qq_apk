import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class bfwj
  extends SimpleObserver<bfvc>
{
  bfwj(bfwh parambfwh, bfvc parambfvc) {}
  
  public void a(bfvc parambfvc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onNext. info position=", Integer.valueOf(parambfvc.c), ", old status=", Integer.valueOf(parambfvc.g) });
    }
    this.jdField_a_of_type_Bfwh.b.remove(parambfvc);
    this.jdField_a_of_type_Bfwh.a(1, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onError. info position=", Integer.valueOf(this.jdField_a_of_type_Bfvc.c), ", old status=", Integer.valueOf(this.jdField_a_of_type_Bfvc.g) });
    }
    this.jdField_a_of_type_Bfvc.g = 2;
    this.jdField_a_of_type_Bfwh.b.remove(this.jdField_a_of_type_Bfvc);
    QLog.d("VideoItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Bfwh.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bfwh.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bfvc.c);
      if ((localObject instanceof bfwk))
      {
        localObject = (bfwk)localObject;
        if (this.jdField_a_of_type_Bfvc.d.equals(((bfwk)localObject).a.getTag())) {
          ((bfwh)((bfun)this.jdField_a_of_type_Bfwh.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((bfvx)localObject, this.jdField_a_of_type_Bfvc, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      bgmd.a("hw_entry_upload", "upload_video", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Bfvc.a), "");
    }
    if (this.jdField_a_of_type_Bfvc.d.equals(this.jdField_a_of_type_Bfwh.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bfwh.a(1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfwj
 * JD-Core Version:    0.7.0.1
 */