import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class bcfq
  extends SimpleObserver<bcej>
{
  bcfq(bcfo parambcfo, bcej parambcej) {}
  
  public void a(bcej parambcej)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onNext. info position=", Integer.valueOf(parambcej.c), ", old status=", Integer.valueOf(parambcej.g) });
    }
    this.jdField_a_of_type_Bcfo.b.remove(parambcej);
    this.jdField_a_of_type_Bcfo.a(1, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onError. info position=", Integer.valueOf(this.jdField_a_of_type_Bcej.c), ", old status=", Integer.valueOf(this.jdField_a_of_type_Bcej.g) });
    }
    this.jdField_a_of_type_Bcej.g = 2;
    this.jdField_a_of_type_Bcfo.b.remove(this.jdField_a_of_type_Bcej);
    QLog.d("VideoItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Bcfo.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bcfo.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bcej.c);
      if ((localObject instanceof bcfr))
      {
        localObject = (bcfr)localObject;
        if (this.jdField_a_of_type_Bcej.d.equals(((bcfr)localObject).a.getTag())) {
          ((bcfo)((bcdu)this.jdField_a_of_type_Bcfo.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((bcfe)localObject, this.jdField_a_of_type_Bcej, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      bcpr.a("hw_entry_upload", "upload_video", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Bcej.a), "");
    }
    if (this.jdField_a_of_type_Bcej.d.equals(this.jdField_a_of_type_Bcfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bcfo.a(1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfq
 * JD-Core Version:    0.7.0.1
 */