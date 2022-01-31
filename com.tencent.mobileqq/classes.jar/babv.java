import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class babv
  extends SimpleObserver<baax>
{
  babv(babu parambabu, baax parambaax) {}
  
  public void a(baax parambaax)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "ImageItem onNext. info position=", Integer.valueOf(parambaax.c), ", old status=", Integer.valueOf(parambaax.g), ", result=", parambaax });
    }
    parambaax.g = 3;
    parambaax.e = 100;
    this.jdField_a_of_type_Babu.jdField_a_of_type_JavaUtilMap.remove(parambaax);
    if (this.jdField_a_of_type_Babu.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Babu.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Baax.c);
      if ((localObject instanceof baby))
      {
        localObject = (baby)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, new Object[] { "ImageItem onNext. info hash=", Integer.valueOf(parambaax.hashCode()), ", result hash=", Integer.valueOf(parambaax.hashCode()), ", info position=", Integer.valueOf(parambaax.c), ", result position=", Integer.valueOf(parambaax.c), ", vh position=", Integer.valueOf(((baby)localObject).jdField_a_of_type_Baas.c), ",vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        if (parambaax.d.equals(((baby)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((baby)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
          ((baby)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
          ((baby)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(parambaax.e, parambaax.d);
        }
        this.jdField_a_of_type_Babu.jdField_a_of_type_Babp.a((RecyclerView.ViewHolder)localObject, true);
      }
    }
    bamh.a("hw_entry_upload", "upload_image", "1", "", String.valueOf(System.currentTimeMillis() - parambaax.a), "");
    this.jdField_a_of_type_Babu.a(0, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "ImageItem onError: ", paramError.getMessage(), ", info position =", Integer.valueOf(this.jdField_a_of_type_Baax.c), ", info hash=", Integer.valueOf(this.jdField_a_of_type_Baax.hashCode()), ", info old status=", Integer.valueOf(this.jdField_a_of_type_Baax.g) });
    }
    this.jdField_a_of_type_Baax.g = 2;
    this.jdField_a_of_type_Babu.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_Baax);
    QLog.d("ImageItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Babu.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Babu.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Baax.c);
      if ((localObject instanceof baby))
      {
        localObject = (baby)localObject;
        if (this.jdField_a_of_type_Baax.d.equals(((baby)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag())) {
          ((babu)((baao)this.jdField_a_of_type_Babu.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(1)).a((baby)localObject, this.jdField_a_of_type_Baax, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      bamh.a("hw_entry_upload", "upload_image", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Baax.a), "");
    }
    if (this.jdField_a_of_type_Baax.d.equals(this.jdField_a_of_type_Babu.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Babu.a(0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     babv
 * JD-Core Version:    0.7.0.1
 */