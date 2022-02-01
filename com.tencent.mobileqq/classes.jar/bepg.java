import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class bepg
  extends SimpleObserver<benz>
{
  bepg(bepe parambepe, benz parambenz) {}
  
  public void a(benz parambenz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onNext. info position=", Integer.valueOf(parambenz.c), ", old status=", Integer.valueOf(parambenz.g) });
    }
    this.jdField_a_of_type_Bepe.b.remove(parambenz);
    this.jdField_a_of_type_Bepe.a(1, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onError. info position=", Integer.valueOf(this.jdField_a_of_type_Benz.c), ", old status=", Integer.valueOf(this.jdField_a_of_type_Benz.g) });
    }
    this.jdField_a_of_type_Benz.g = 2;
    this.jdField_a_of_type_Bepe.b.remove(this.jdField_a_of_type_Benz);
    QLog.d("VideoItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Bepe.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bepe.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Benz.c);
      if ((localObject instanceof beph))
      {
        localObject = (beph)localObject;
        if (this.jdField_a_of_type_Benz.d.equals(((beph)localObject).a.getTag())) {
          ((bepe)((benk)this.jdField_a_of_type_Bepe.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((beou)localObject, this.jdField_a_of_type_Benz, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      bfdx.a("hw_entry_upload", "upload_video", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Benz.a), "");
    }
    if (this.jdField_a_of_type_Benz.d.equals(this.jdField_a_of_type_Bepe.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bepe.a(1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepg
 * JD-Core Version:    0.7.0.1
 */