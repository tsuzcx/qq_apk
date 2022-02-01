import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class bffp
  extends SimpleObserver<bfer>
{
  bffp(bffo parambffo, bfer parambfer) {}
  
  public void a(bfer parambfer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "ImageItem onNext. info position=", Integer.valueOf(parambfer.c), ", old status=", Integer.valueOf(parambfer.g), ", result=", parambfer });
    }
    parambfer.g = 3;
    parambfer.e = 100;
    this.jdField_a_of_type_Bffo.jdField_a_of_type_JavaUtilMap.remove(parambfer);
    if (this.jdField_a_of_type_Bffo.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bffo.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bfer.c);
      if ((localObject instanceof bffs))
      {
        localObject = (bffs)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, new Object[] { "ImageItem onNext. info hash=", Integer.valueOf(parambfer.hashCode()), ", result hash=", Integer.valueOf(parambfer.hashCode()), ", info position=", Integer.valueOf(parambfer.c), ", result position=", Integer.valueOf(parambfer.c), ", vh position=", Integer.valueOf(((bffs)localObject).jdField_a_of_type_Bfem.c), ",vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        if (parambfer.d.equals(((bffs)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((bffs)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
          ((bffs)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
          ((bffs)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(parambfer.e, parambfer.d);
        }
        this.jdField_a_of_type_Bffo.jdField_a_of_type_Bffj.a((RecyclerView.ViewHolder)localObject, true);
      }
    }
    bfui.a("hw_entry_upload", "upload_image", "1", "", String.valueOf(System.currentTimeMillis() - parambfer.a), "");
    this.jdField_a_of_type_Bffo.a(0, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "ImageItem onError: ", paramError.getMessage(), ", info position =", Integer.valueOf(this.jdField_a_of_type_Bfer.c), ", info hash=", Integer.valueOf(this.jdField_a_of_type_Bfer.hashCode()), ", info old status=", Integer.valueOf(this.jdField_a_of_type_Bfer.g) });
    }
    this.jdField_a_of_type_Bfer.g = 2;
    this.jdField_a_of_type_Bffo.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_Bfer);
    QLog.d("ImageItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Bffo.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bffo.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bfer.c);
      if ((localObject instanceof bffs))
      {
        localObject = (bffs)localObject;
        if (this.jdField_a_of_type_Bfer.d.equals(((bffs)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag())) {
          ((bffo)((bfei)this.jdField_a_of_type_Bffo.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(1)).a((bffs)localObject, this.jdField_a_of_type_Bfer, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      bfui.a("hw_entry_upload", "upload_image", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Bfer.a), "");
    }
    if (this.jdField_a_of_type_Bfer.d.equals(this.jdField_a_of_type_Bffo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bffo.a(0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bffp
 * JD-Core Version:    0.7.0.1
 */