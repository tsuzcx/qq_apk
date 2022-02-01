import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class beor
  extends SimpleObserver<bent>
{
  beor(beoq parambeoq, bent parambent) {}
  
  public void a(bent parambent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "ImageItem onNext. info position=", Integer.valueOf(parambent.c), ", old status=", Integer.valueOf(parambent.g), ", result=", parambent });
    }
    parambent.g = 3;
    parambent.e = 100;
    this.jdField_a_of_type_Beoq.jdField_a_of_type_JavaUtilMap.remove(parambent);
    if (this.jdField_a_of_type_Beoq.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Beoq.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bent.c);
      if ((localObject instanceof beou))
      {
        localObject = (beou)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, new Object[] { "ImageItem onNext. info hash=", Integer.valueOf(parambent.hashCode()), ", result hash=", Integer.valueOf(parambent.hashCode()), ", info position=", Integer.valueOf(parambent.c), ", result position=", Integer.valueOf(parambent.c), ", vh position=", Integer.valueOf(((beou)localObject).jdField_a_of_type_Beno.c), ",vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        if (parambent.d.equals(((beou)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((beou)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
          ((beou)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
          ((beou)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(parambent.e, parambent.d);
        }
        this.jdField_a_of_type_Beoq.jdField_a_of_type_Beol.a((RecyclerView.ViewHolder)localObject, true);
      }
    }
    bfdx.a("hw_entry_upload", "upload_image", "1", "", String.valueOf(System.currentTimeMillis() - parambent.a), "");
    this.jdField_a_of_type_Beoq.a(0, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "ImageItem onError: ", paramError.getMessage(), ", info position =", Integer.valueOf(this.jdField_a_of_type_Bent.c), ", info hash=", Integer.valueOf(this.jdField_a_of_type_Bent.hashCode()), ", info old status=", Integer.valueOf(this.jdField_a_of_type_Bent.g) });
    }
    this.jdField_a_of_type_Bent.g = 2;
    this.jdField_a_of_type_Beoq.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_Bent);
    QLog.d("ImageItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Beoq.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Beoq.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bent.c);
      if ((localObject instanceof beou))
      {
        localObject = (beou)localObject;
        if (this.jdField_a_of_type_Bent.d.equals(((beou)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag())) {
          ((beoq)((benk)this.jdField_a_of_type_Beoq.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(1)).a((beou)localObject, this.jdField_a_of_type_Bent, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      bfdx.a("hw_entry_upload", "upload_image", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Bent.a), "");
    }
    if (this.jdField_a_of_type_Bent.d.equals(this.jdField_a_of_type_Beoq.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Beoq.a(0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beor
 * JD-Core Version:    0.7.0.1
 */