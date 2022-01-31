import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class bcfp
  extends SimpleObserver<bced>
{
  bcfp(bcfo parambcfo, bced parambced) {}
  
  public void a(bced parambced)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem onNext. info position=", Integer.valueOf(parambced.c), ", old status=", Integer.valueOf(parambced.g), ", result=", parambced });
    }
    parambced.g = 3;
    parambced.e = 100;
    this.jdField_a_of_type_Bcfo.jdField_a_of_type_JavaUtilMap.remove(parambced);
    if (this.jdField_a_of_type_Bcfo.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bcfo.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(parambced.c);
      if ((localObject instanceof bcfr))
      {
        localObject = (bcfr)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "video onNext. info hash=", Integer.valueOf(parambced.hashCode()), ", result hash=", Integer.valueOf(parambced.hashCode()), ", info position=", Integer.valueOf(parambced.c), ", result position=", Integer.valueOf(parambced.c), ", vh position=", Integer.valueOf(((bcfr)localObject).jdField_a_of_type_Bcdy.c), ",vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        if (parambced.d.equals(((bcfr)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((bcfr)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
          ((bcfr)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
          ((bcfr)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(parambced.e, parambced.d);
        }
        this.jdField_a_of_type_Bcfo.jdField_a_of_type_Bcev.a((RecyclerView.ViewHolder)localObject, true);
      }
    }
    bcpr.a("hw_entry_upload", "upload_video", "1", "", String.valueOf(System.currentTimeMillis() - parambced.a), "");
    this.jdField_a_of_type_Bcfo.a(0, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem onError. info position=", Integer.valueOf(this.jdField_a_of_type_Bced.c), ", info old status=", Integer.valueOf(this.jdField_a_of_type_Bced.g) });
    }
    this.jdField_a_of_type_Bced.g = 2;
    this.jdField_a_of_type_Bcfo.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_Bced);
    QLog.d("VideoItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Bcfo.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bcfo.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bced.c);
      if ((localObject instanceof bcfr))
      {
        localObject = (bcfr)localObject;
        if (this.jdField_a_of_type_Bced.d.equals(((bcfr)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((bcfo)((bcdu)this.jdField_a_of_type_Bcfo.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((bcfe)localObject, this.jdField_a_of_type_Bced, 0);
          if ("200".equals(paramError))
          {
            QLog.d("VideoItem", 1, "VideoItem onError. upload size exceed.");
            QQToast.a(this.jdField_a_of_type_Bcfo.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext(), alud.a(2131716682), 0).a();
            this.jdField_a_of_type_Bcfo.jdField_a_of_type_Bcev.a((RecyclerView.ViewHolder)localObject);
          }
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      bcpr.a("hw_entry_upload", "upload_video", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Bced.a), "");
    }
    if (this.jdField_a_of_type_Bced.d.equals(this.jdField_a_of_type_Bcfo.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bcfo.a(0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfp
 * JD-Core Version:    0.7.0.1
 */