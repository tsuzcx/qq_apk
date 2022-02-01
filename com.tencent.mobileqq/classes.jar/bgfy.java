import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class bgfy
  extends SimpleObserver<bger>
{
  bgfy(bgfw parambgfw, bger parambger) {}
  
  public void a(bger parambger)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onNext. info position=", Integer.valueOf(parambger.c), ", old status=", Integer.valueOf(parambger.g) });
    }
    this.jdField_a_of_type_Bgfw.b.remove(parambger);
    this.jdField_a_of_type_Bgfw.a(1, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onError. info position=", Integer.valueOf(this.jdField_a_of_type_Bger.c), ", old status=", Integer.valueOf(this.jdField_a_of_type_Bger.g) });
    }
    this.jdField_a_of_type_Bger.g = 2;
    this.jdField_a_of_type_Bgfw.b.remove(this.jdField_a_of_type_Bger);
    QLog.d("VideoItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Bgfw.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bgfw.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bger.c);
      if ((localObject instanceof bgfz))
      {
        localObject = (bgfz)localObject;
        if (this.jdField_a_of_type_Bger.d.equals(((bgfz)localObject).a.getTag())) {
          ((bgfw)((bgec)this.jdField_a_of_type_Bgfw.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((bgfm)localObject, this.jdField_a_of_type_Bger, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      bguj.a("hw_entry_upload", "upload_video", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Bger.a), "");
    }
    if (this.jdField_a_of_type_Bger.d.equals(this.jdField_a_of_type_Bgfw.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bgfw.a(1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgfy
 * JD-Core Version:    0.7.0.1
 */