import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class bepf
  extends SimpleObserver<bent>
{
  bepf(bepe parambepe, bent parambent) {}
  
  public void a(bent parambent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem onNext. info position=", Integer.valueOf(parambent.c), ", old status=", Integer.valueOf(parambent.g), ", result=", parambent });
    }
    parambent.g = 3;
    parambent.e = 100;
    this.jdField_a_of_type_Bepe.jdField_a_of_type_JavaUtilMap.remove(parambent);
    if (this.jdField_a_of_type_Bepe.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bepe.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(parambent.c);
      if ((localObject instanceof beph))
      {
        localObject = (beph)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "video onNext. info hash=", Integer.valueOf(parambent.hashCode()), ", result hash=", Integer.valueOf(parambent.hashCode()), ", info position=", Integer.valueOf(parambent.c), ", result position=", Integer.valueOf(parambent.c), ", vh position=", Integer.valueOf(((beph)localObject).jdField_a_of_type_Beno.c), ",vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        if (parambent.d.equals(((beph)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((beph)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
          ((beph)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
          ((beph)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(parambent.e, parambent.d);
        }
        this.jdField_a_of_type_Bepe.jdField_a_of_type_Beol.a((RecyclerView.ViewHolder)localObject, true);
      }
    }
    bfdx.a("hw_entry_upload", "upload_video", "1", "", String.valueOf(System.currentTimeMillis() - parambent.a), "");
    this.jdField_a_of_type_Bepe.a(0, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem onError. info position=", Integer.valueOf(this.jdField_a_of_type_Bent.c), ", info old status=", Integer.valueOf(this.jdField_a_of_type_Bent.g) });
    }
    this.jdField_a_of_type_Bent.g = 2;
    this.jdField_a_of_type_Bepe.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_Bent);
    QLog.d("VideoItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Bepe.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bepe.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bent.c);
      if ((localObject instanceof beph))
      {
        localObject = (beph)localObject;
        if (this.jdField_a_of_type_Bent.d.equals(((beph)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((bepe)((benk)this.jdField_a_of_type_Bepe.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((beou)localObject, this.jdField_a_of_type_Bent, 0);
          if ("200".equals(paramError))
          {
            QLog.d("VideoItem", 1, "VideoItem onError. upload size exceed.");
            QQToast.a(this.jdField_a_of_type_Bepe.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext(), amtj.a(2131715302), 0).a();
            this.jdField_a_of_type_Bepe.jdField_a_of_type_Beol.a((RecyclerView.ViewHolder)localObject);
          }
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      bfdx.a("hw_entry_upload", "upload_video", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Bent.a), "");
    }
    if (this.jdField_a_of_type_Bent.d.equals(this.jdField_a_of_type_Bepe.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bepe.a(0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bepf
 * JD-Core Version:    0.7.0.1
 */