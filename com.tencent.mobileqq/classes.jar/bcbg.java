import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class bcbg
  extends SimpleObserver<bbzu>
{
  bcbg(bcbf parambcbf, bbzu parambbzu) {}
  
  public void a(bbzu parambbzu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem onNext. info position=", Integer.valueOf(parambbzu.c), ", old status=", Integer.valueOf(parambbzu.g), ", result=", parambbzu });
    }
    parambbzu.g = 3;
    parambbzu.e = 100;
    this.jdField_a_of_type_Bcbf.jdField_a_of_type_JavaUtilMap.remove(parambbzu);
    if (this.jdField_a_of_type_Bcbf.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bcbf.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(parambbzu.c);
      if ((localObject instanceof bcbi))
      {
        localObject = (bcbi)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "video onNext. info hash=", Integer.valueOf(parambbzu.hashCode()), ", result hash=", Integer.valueOf(parambbzu.hashCode()), ", info position=", Integer.valueOf(parambbzu.c), ", result position=", Integer.valueOf(parambbzu.c), ", vh position=", Integer.valueOf(((bcbi)localObject).jdField_a_of_type_Bbzp.c), ",vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        if (parambbzu.d.equals(((bcbi)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((bcbi)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
          ((bcbi)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
          ((bcbi)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(parambbzu.e, parambbzu.d);
        }
        this.jdField_a_of_type_Bcbf.jdField_a_of_type_Bcam.a((RecyclerView.ViewHolder)localObject, true);
      }
    }
    bcli.a("hw_entry_upload", "upload_video", "1", "", String.valueOf(System.currentTimeMillis() - parambbzu.a), "");
    this.jdField_a_of_type_Bcbf.a(0, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem onError. info position=", Integer.valueOf(this.jdField_a_of_type_Bbzu.c), ", info old status=", Integer.valueOf(this.jdField_a_of_type_Bbzu.g) });
    }
    this.jdField_a_of_type_Bbzu.g = 2;
    this.jdField_a_of_type_Bcbf.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_Bbzu);
    QLog.d("VideoItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Bcbf.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bcbf.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bbzu.c);
      if ((localObject instanceof bcbi))
      {
        localObject = (bcbi)localObject;
        if (this.jdField_a_of_type_Bbzu.d.equals(((bcbi)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((bcbf)((bbzl)this.jdField_a_of_type_Bcbf.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((bcav)localObject, this.jdField_a_of_type_Bbzu, 0);
          if ("200".equals(paramError))
          {
            QLog.d("VideoItem", 1, "VideoItem onError. upload size exceed.");
            QQToast.a(this.jdField_a_of_type_Bcbf.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext(), alpo.a(2131716670), 0).a();
            this.jdField_a_of_type_Bcbf.jdField_a_of_type_Bcam.a((RecyclerView.ViewHolder)localObject);
          }
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      bcli.a("hw_entry_upload", "upload_video", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Bbzu.a), "");
    }
    if (this.jdField_a_of_type_Bbzu.d.equals(this.jdField_a_of_type_Bcbf.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bcbf.a(0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbg
 * JD-Core Version:    0.7.0.1
 */