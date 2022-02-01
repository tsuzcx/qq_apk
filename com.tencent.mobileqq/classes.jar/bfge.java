import android.support.annotation.NonNull;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class bfge
  extends SimpleObserver<bfex>
{
  bfge(bfgc parambfgc, bfex parambfex) {}
  
  public void a(bfex parambfex)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onNext. info position=", Integer.valueOf(parambfex.c), ", old status=", Integer.valueOf(parambfex.g) });
    }
    this.jdField_a_of_type_Bfgc.b.remove(parambfex);
    this.jdField_a_of_type_Bfgc.a(1, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem GeneratePoster onError. info position=", Integer.valueOf(this.jdField_a_of_type_Bfex.c), ", old status=", Integer.valueOf(this.jdField_a_of_type_Bfex.g) });
    }
    this.jdField_a_of_type_Bfex.g = 2;
    this.jdField_a_of_type_Bfgc.b.remove(this.jdField_a_of_type_Bfex);
    QLog.d("VideoItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Bfgc.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bfgc.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bfex.c);
      if ((localObject instanceof bfgf))
      {
        localObject = (bfgf)localObject;
        if (this.jdField_a_of_type_Bfex.d.equals(((bfgf)localObject).a.getTag())) {
          ((bfgc)((bfei)this.jdField_a_of_type_Bfgc.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((bffs)localObject, this.jdField_a_of_type_Bfex, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      bfui.a("hw_entry_upload", "upload_video", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Bfex.a), "");
    }
    if (this.jdField_a_of_type_Bfex.d.equals(this.jdField_a_of_type_Bfgc.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bfgc.a(1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfge
 * JD-Core Version:    0.7.0.1
 */