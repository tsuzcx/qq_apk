import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class azbd
  extends SimpleObserver<azaf>
{
  azbd(azbc paramazbc, azaf paramazaf) {}
  
  public void a(azaf paramazaf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "ImageItem onNext. info position=", Integer.valueOf(paramazaf.c), ", old status=", Integer.valueOf(paramazaf.g), ", result=", paramazaf });
    }
    paramazaf.g = 3;
    paramazaf.e = 100;
    this.jdField_a_of_type_Azbc.jdField_a_of_type_JavaUtilMap.remove(paramazaf);
    if (this.jdField_a_of_type_Azbc.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Azbc.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Azaf.c);
      if ((localObject instanceof azbg))
      {
        localObject = (azbg)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, new Object[] { "ImageItem onNext. info hash=", Integer.valueOf(paramazaf.hashCode()), ", result hash=", Integer.valueOf(paramazaf.hashCode()), ", info position=", Integer.valueOf(paramazaf.c), ", result position=", Integer.valueOf(paramazaf.c), ", vh position=", Integer.valueOf(((azbg)localObject).jdField_a_of_type_Azaa.c), ",vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        if (paramazaf.d.equals(((azbg)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((azbg)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
          ((azbg)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
          ((azbg)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramazaf.e, paramazaf.d);
        }
        this.jdField_a_of_type_Azbc.jdField_a_of_type_Azax.a((RecyclerView.ViewHolder)localObject, true);
      }
    }
    azld.a("hw_entry_upload", "upload_image", "1", "", String.valueOf(System.currentTimeMillis() - paramazaf.a), "");
    this.jdField_a_of_type_Azbc.a(0, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "ImageItem onError: ", paramError.getMessage(), ", info position =", Integer.valueOf(this.jdField_a_of_type_Azaf.c), ", info hash=", Integer.valueOf(this.jdField_a_of_type_Azaf.hashCode()), ", info old status=", Integer.valueOf(this.jdField_a_of_type_Azaf.g) });
    }
    this.jdField_a_of_type_Azaf.g = 2;
    this.jdField_a_of_type_Azbc.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_Azaf);
    QLog.d("ImageItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Azbc.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Azbc.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Azaf.c);
      if ((localObject instanceof azbg))
      {
        localObject = (azbg)localObject;
        if (this.jdField_a_of_type_Azaf.d.equals(((azbg)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag())) {
          ((azbc)((ayzw)this.jdField_a_of_type_Azbc.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(1)).a((azbg)localObject, this.jdField_a_of_type_Azaf, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      azld.a("hw_entry_upload", "upload_image", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Azaf.a), "");
    }
    if (this.jdField_a_of_type_Azaf.d.equals(this.jdField_a_of_type_Azbc.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Azbc.a(0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azbd
 * JD-Core Version:    0.7.0.1
 */