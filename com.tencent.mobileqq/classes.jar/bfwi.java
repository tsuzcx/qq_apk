import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class bfwi
  extends SimpleObserver<bfuw>
{
  bfwi(bfwh parambfwh, bfuw parambfuw) {}
  
  public void a(bfuw parambfuw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem onNext. info position=", Integer.valueOf(parambfuw.c), ", old status=", Integer.valueOf(parambfuw.g), ", result=", parambfuw });
    }
    parambfuw.g = 3;
    parambfuw.e = 100;
    this.jdField_a_of_type_Bfwh.jdField_a_of_type_JavaUtilMap.remove(parambfuw);
    if (this.jdField_a_of_type_Bfwh.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bfwh.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(parambfuw.c);
      if ((localObject instanceof bfwk))
      {
        localObject = (bfwk)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "video onNext. info hash=", Integer.valueOf(parambfuw.hashCode()), ", result hash=", Integer.valueOf(parambfuw.hashCode()), ", info position=", Integer.valueOf(parambfuw.c), ", result position=", Integer.valueOf(parambfuw.c), ", vh position=", Integer.valueOf(((bfwk)localObject).jdField_a_of_type_Bfur.c), ",vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        if (parambfuw.d.equals(((bfwk)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((bfwk)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
          ((bfwk)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
          ((bfwk)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(parambfuw.e, parambfuw.d);
        }
        this.jdField_a_of_type_Bfwh.jdField_a_of_type_Bfvo.a((RecyclerView.ViewHolder)localObject, true);
      }
    }
    bgmd.a("hw_entry_upload", "upload_video", "1", "", String.valueOf(System.currentTimeMillis() - parambfuw.a), "");
    this.jdField_a_of_type_Bfwh.a(0, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem onError. info position=", Integer.valueOf(this.jdField_a_of_type_Bfuw.c), ", info old status=", Integer.valueOf(this.jdField_a_of_type_Bfuw.g) });
    }
    this.jdField_a_of_type_Bfuw.g = 2;
    this.jdField_a_of_type_Bfwh.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_Bfuw);
    QLog.d("VideoItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Bfwh.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bfwh.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bfuw.c);
      if ((localObject instanceof bfwk))
      {
        localObject = (bfwk)localObject;
        if (this.jdField_a_of_type_Bfuw.d.equals(((bfwk)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((bfwh)((bfun)this.jdField_a_of_type_Bfwh.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((bfvx)localObject, this.jdField_a_of_type_Bfuw, 0);
          if ("200".equals(paramError))
          {
            QLog.d("VideoItem", 1, "VideoItem onError. upload size exceed.");
            QQToast.a(this.jdField_a_of_type_Bfwh.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext(), anvx.a(2131715650), 0).a();
            this.jdField_a_of_type_Bfwh.jdField_a_of_type_Bfvo.a((RecyclerView.ViewHolder)localObject);
          }
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      bgmd.a("hw_entry_upload", "upload_video", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Bfuw.a), "");
    }
    if (this.jdField_a_of_type_Bfuw.d.equals(this.jdField_a_of_type_Bfwh.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bfwh.a(0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfwi
 * JD-Core Version:    0.7.0.1
 */