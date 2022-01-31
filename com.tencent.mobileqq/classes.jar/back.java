import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class back
  extends SimpleObserver<babd>
{
  back(baci parambaci, babd parambabd) {}
  
  public void a(babd parambabd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onNext. info position=", Integer.valueOf(parambabd.c), ", old status=", Integer.valueOf(parambabd.g) });
    }
    this.jdField_a_of_type_Baci.b.remove(parambabd);
    this.jdField_a_of_type_Baci.a(1, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onError. info position=", Integer.valueOf(this.jdField_a_of_type_Babd.c), ", old status=", Integer.valueOf(this.jdField_a_of_type_Babd.g) });
    }
    this.jdField_a_of_type_Babd.g = 2;
    this.jdField_a_of_type_Baci.b.remove(this.jdField_a_of_type_Babd);
    QLog.d("VideoItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Baci.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Baci.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Babd.c);
      if ((localObject instanceof bacl))
      {
        localObject = (bacl)localObject;
        if (this.jdField_a_of_type_Babd.d.equals(((bacl)localObject).a.getTag())) {
          ((baci)((baao)this.jdField_a_of_type_Baci.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((baby)localObject, this.jdField_a_of_type_Babd, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      bamh.a("hw_entry_upload", "upload_video", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Babd.a), "");
    }
    if (this.jdField_a_of_type_Babd.d.equals(this.jdField_a_of_type_Baci.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Baci.a(1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     back
 * JD-Core Version:    0.7.0.1
 */