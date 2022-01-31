import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class bacx
  extends SimpleObserver<babl>
{
  bacx(bacw parambacw, babl parambabl) {}
  
  public void a(babl parambabl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem onNext. info position=", Integer.valueOf(parambabl.c), ", old status=", Integer.valueOf(parambabl.g), ", result=", parambabl });
    }
    parambabl.g = 3;
    parambabl.e = 100;
    this.jdField_a_of_type_Bacw.jdField_a_of_type_JavaUtilMap.remove(parambabl);
    if (this.jdField_a_of_type_Bacw.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bacw.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(parambabl.c);
      if ((localObject instanceof bacz))
      {
        localObject = (bacz)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "video onNext. info hash=", Integer.valueOf(parambabl.hashCode()), ", result hash=", Integer.valueOf(parambabl.hashCode()), ", info position=", Integer.valueOf(parambabl.c), ", result position=", Integer.valueOf(parambabl.c), ", vh position=", Integer.valueOf(((bacz)localObject).jdField_a_of_type_Babg.c), ",vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        if (parambabl.d.equals(((bacz)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((bacz)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
          ((bacz)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
          ((bacz)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(parambabl.e, parambabl.d);
        }
        this.jdField_a_of_type_Bacw.jdField_a_of_type_Bacd.a((RecyclerView.ViewHolder)localObject, true);
      }
    }
    bamv.a("hw_entry_upload", "upload_video", "1", "", String.valueOf(System.currentTimeMillis() - parambabl.a), "");
    this.jdField_a_of_type_Bacw.a(0, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem onError. info position=", Integer.valueOf(this.jdField_a_of_type_Babl.c), ", info old status=", Integer.valueOf(this.jdField_a_of_type_Babl.g) });
    }
    this.jdField_a_of_type_Babl.g = 2;
    this.jdField_a_of_type_Bacw.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_Babl);
    QLog.d("VideoItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Bacw.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bacw.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Babl.c);
      if ((localObject instanceof bacz))
      {
        localObject = (bacz)localObject;
        if (this.jdField_a_of_type_Babl.d.equals(((bacz)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((bacw)((babc)this.jdField_a_of_type_Bacw.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((bacm)localObject, this.jdField_a_of_type_Babl, 0);
          if ("200".equals(paramError))
          {
            QLog.d("VideoItem", 1, "VideoItem onError. upload size exceed.");
            bcql.a(this.jdField_a_of_type_Bacw.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext(), ajya.a(2131716298), 0).a();
            this.jdField_a_of_type_Bacw.jdField_a_of_type_Bacd.a((RecyclerView.ViewHolder)localObject);
          }
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      bamv.a("hw_entry_upload", "upload_video", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Babl.a), "");
    }
    if (this.jdField_a_of_type_Babl.d.equals(this.jdField_a_of_type_Bacw.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bacw.a(0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bacx
 * JD-Core Version:    0.7.0.1
 */