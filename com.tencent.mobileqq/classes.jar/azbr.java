import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class azbr
  extends SimpleObserver<azaf>
{
  azbr(azbq paramazbq, azaf paramazaf) {}
  
  public void a(azaf paramazaf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem onNext. info position=", Integer.valueOf(paramazaf.c), ", old status=", Integer.valueOf(paramazaf.g), ", result=", paramazaf });
    }
    paramazaf.g = 3;
    paramazaf.e = 100;
    this.jdField_a_of_type_Azbq.jdField_a_of_type_JavaUtilMap.remove(paramazaf);
    if (this.jdField_a_of_type_Azbq.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Azbq.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(paramazaf.c);
      if ((localObject instanceof azbt))
      {
        localObject = (azbt)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "video onNext. info hash=", Integer.valueOf(paramazaf.hashCode()), ", result hash=", Integer.valueOf(paramazaf.hashCode()), ", info position=", Integer.valueOf(paramazaf.c), ", result position=", Integer.valueOf(paramazaf.c), ", vh position=", Integer.valueOf(((azbt)localObject).jdField_a_of_type_Azaa.c), ",vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        if (paramazaf.d.equals(((azbt)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((azbt)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
          ((azbt)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
          ((azbt)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramazaf.e, paramazaf.d);
        }
        this.jdField_a_of_type_Azbq.jdField_a_of_type_Azax.a((RecyclerView.ViewHolder)localObject, true);
      }
    }
    azld.a("hw_entry_upload", "upload_video", "1", "", String.valueOf(System.currentTimeMillis() - paramazaf.a), "");
    this.jdField_a_of_type_Azbq.a(0, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem onError. info position=", Integer.valueOf(this.jdField_a_of_type_Azaf.c), ", info old status=", Integer.valueOf(this.jdField_a_of_type_Azaf.g) });
    }
    this.jdField_a_of_type_Azaf.g = 2;
    this.jdField_a_of_type_Azbq.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_Azaf);
    QLog.d("VideoItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Azbq.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Azbq.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Azaf.c);
      if ((localObject instanceof azbt))
      {
        localObject = (azbt)localObject;
        if (this.jdField_a_of_type_Azaf.d.equals(((azbt)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((azbq)((ayzw)this.jdField_a_of_type_Azbq.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((azbg)localObject, this.jdField_a_of_type_Azaf, 0);
          if ("200".equals(paramError))
          {
            QLog.d("VideoItem", 1, "VideoItem onError. upload size exceed.");
            bbmy.a(this.jdField_a_of_type_Azbq.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext(), ajjy.a(2131650496), 0).a();
            this.jdField_a_of_type_Azbq.jdField_a_of_type_Azax.a((RecyclerView.ViewHolder)localObject);
          }
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      azld.a("hw_entry_upload", "upload_video", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Azaf.a), "");
    }
    if (this.jdField_a_of_type_Azaf.d.equals(this.jdField_a_of_type_Azbq.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Azbq.a(0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azbr
 * JD-Core Version:    0.7.0.1
 */