import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class bgfj
  extends SimpleObserver<bgel>
{
  bgfj(bgfi parambgfi, bgel parambgel) {}
  
  public void a(bgel parambgel)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "ImageItem onNext. info position=", Integer.valueOf(parambgel.c), ", old status=", Integer.valueOf(parambgel.g), ", result=", parambgel });
    }
    parambgel.g = 3;
    parambgel.e = 100;
    this.jdField_a_of_type_Bgfi.jdField_a_of_type_JavaUtilMap.remove(parambgel);
    if (this.jdField_a_of_type_Bgfi.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bgfi.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bgel.c);
      if ((localObject instanceof bgfm))
      {
        localObject = (bgfm)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, new Object[] { "ImageItem onNext. info hash=", Integer.valueOf(parambgel.hashCode()), ", result hash=", Integer.valueOf(parambgel.hashCode()), ", info position=", Integer.valueOf(parambgel.c), ", result position=", Integer.valueOf(parambgel.c), ", vh position=", Integer.valueOf(((bgfm)localObject).jdField_a_of_type_Bgeg.c), ",vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        if (parambgel.d.equals(((bgfm)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((bgfm)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
          ((bgfm)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
          ((bgfm)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(parambgel.e, parambgel.d);
        }
        this.jdField_a_of_type_Bgfi.jdField_a_of_type_Bgfd.a((RecyclerView.ViewHolder)localObject, true);
      }
    }
    bguj.a("hw_entry_upload", "upload_image", "1", "", String.valueOf(System.currentTimeMillis() - parambgel.a), "");
    this.jdField_a_of_type_Bgfi.a(0, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "ImageItem onError: ", paramError.getMessage(), ", info position =", Integer.valueOf(this.jdField_a_of_type_Bgel.c), ", info hash=", Integer.valueOf(this.jdField_a_of_type_Bgel.hashCode()), ", info old status=", Integer.valueOf(this.jdField_a_of_type_Bgel.g) });
    }
    this.jdField_a_of_type_Bgel.g = 2;
    this.jdField_a_of_type_Bgfi.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_Bgel);
    QLog.d("ImageItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Bgfi.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bgfi.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bgel.c);
      if ((localObject instanceof bgfm))
      {
        localObject = (bgfm)localObject;
        if (this.jdField_a_of_type_Bgel.d.equals(((bgfm)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag())) {
          ((bgfi)((bgec)this.jdField_a_of_type_Bgfi.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(1)).a((bgfm)localObject, this.jdField_a_of_type_Bgel, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      bguj.a("hw_entry_upload", "upload_image", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Bgel.a), "");
    }
    if (this.jdField_a_of_type_Bgel.d.equals(this.jdField_a_of_type_Bgfi.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bgfi.a(0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgfj
 * JD-Core Version:    0.7.0.1
 */