import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class bacj
  extends SimpleObserver<babl>
{
  bacj(baci parambaci, babl parambabl) {}
  
  public void a(babl parambabl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "ImageItem onNext. info position=", Integer.valueOf(parambabl.c), ", old status=", Integer.valueOf(parambabl.g), ", result=", parambabl });
    }
    parambabl.g = 3;
    parambabl.e = 100;
    this.jdField_a_of_type_Baci.jdField_a_of_type_JavaUtilMap.remove(parambabl);
    if (this.jdField_a_of_type_Baci.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Baci.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Babl.c);
      if ((localObject instanceof bacm))
      {
        localObject = (bacm)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, new Object[] { "ImageItem onNext. info hash=", Integer.valueOf(parambabl.hashCode()), ", result hash=", Integer.valueOf(parambabl.hashCode()), ", info position=", Integer.valueOf(parambabl.c), ", result position=", Integer.valueOf(parambabl.c), ", vh position=", Integer.valueOf(((bacm)localObject).jdField_a_of_type_Babg.c), ",vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        if (parambabl.d.equals(((bacm)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((bacm)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
          ((bacm)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
          ((bacm)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(parambabl.e, parambabl.d);
        }
        this.jdField_a_of_type_Baci.jdField_a_of_type_Bacd.a((RecyclerView.ViewHolder)localObject, true);
      }
    }
    bamv.a("hw_entry_upload", "upload_image", "1", "", String.valueOf(System.currentTimeMillis() - parambabl.a), "");
    this.jdField_a_of_type_Baci.a(0, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "ImageItem onError: ", paramError.getMessage(), ", info position =", Integer.valueOf(this.jdField_a_of_type_Babl.c), ", info hash=", Integer.valueOf(this.jdField_a_of_type_Babl.hashCode()), ", info old status=", Integer.valueOf(this.jdField_a_of_type_Babl.g) });
    }
    this.jdField_a_of_type_Babl.g = 2;
    this.jdField_a_of_type_Baci.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_Babl);
    QLog.d("ImageItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Baci.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Baci.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Babl.c);
      if ((localObject instanceof bacm))
      {
        localObject = (bacm)localObject;
        if (this.jdField_a_of_type_Babl.d.equals(((bacm)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag())) {
          ((baci)((babc)this.jdField_a_of_type_Baci.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(1)).a((bacm)localObject, this.jdField_a_of_type_Babl, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      bamv.a("hw_entry_upload", "upload_image", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Babl.a), "");
    }
    if (this.jdField_a_of_type_Babl.d.equals(this.jdField_a_of_type_Baci.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Baci.a(0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bacj
 * JD-Core Version:    0.7.0.1
 */