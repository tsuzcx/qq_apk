import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class bcbh
  extends SimpleObserver<bcaa>
{
  bcbh(bcbf parambcbf, bcaa parambcaa) {}
  
  public void a(bcaa parambcaa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onNext. info position=", Integer.valueOf(parambcaa.c), ", old status=", Integer.valueOf(parambcaa.g) });
    }
    this.jdField_a_of_type_Bcbf.b.remove(parambcaa);
    this.jdField_a_of_type_Bcbf.a(1, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onError. info position=", Integer.valueOf(this.jdField_a_of_type_Bcaa.c), ", old status=", Integer.valueOf(this.jdField_a_of_type_Bcaa.g) });
    }
    this.jdField_a_of_type_Bcaa.g = 2;
    this.jdField_a_of_type_Bcbf.b.remove(this.jdField_a_of_type_Bcaa);
    QLog.d("VideoItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Bcbf.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bcbf.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bcaa.c);
      if ((localObject instanceof bcbi))
      {
        localObject = (bcbi)localObject;
        if (this.jdField_a_of_type_Bcaa.d.equals(((bcbi)localObject).a.getTag())) {
          ((bcbf)((bbzl)this.jdField_a_of_type_Bcbf.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((bcav)localObject, this.jdField_a_of_type_Bcaa, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      bcli.a("hw_entry_upload", "upload_video", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Bcaa.a), "");
    }
    if (this.jdField_a_of_type_Bcaa.d.equals(this.jdField_a_of_type_Bcbf.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bcbf.a(1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbh
 * JD-Core Version:    0.7.0.1
 */