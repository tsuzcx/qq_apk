import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class bfgd
  extends SimpleObserver<bfer>
{
  bfgd(bfgc parambfgc, bfer parambfer) {}
  
  public void a(bfer parambfer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem onNext. info position=", Integer.valueOf(parambfer.c), ", old status=", Integer.valueOf(parambfer.g), ", result=", parambfer });
    }
    parambfer.g = 3;
    parambfer.e = 100;
    this.jdField_a_of_type_Bfgc.jdField_a_of_type_JavaUtilMap.remove(parambfer);
    if (this.jdField_a_of_type_Bfgc.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bfgc.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(parambfer.c);
      if ((localObject instanceof bfgf))
      {
        localObject = (bfgf)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "video onNext. info hash=", Integer.valueOf(parambfer.hashCode()), ", result hash=", Integer.valueOf(parambfer.hashCode()), ", info position=", Integer.valueOf(parambfer.c), ", result position=", Integer.valueOf(parambfer.c), ", vh position=", Integer.valueOf(((bfgf)localObject).jdField_a_of_type_Bfem.c), ",vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        if (parambfer.d.equals(((bfgf)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((bfgf)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
          ((bfgf)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
          ((bfgf)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(parambfer.e, parambfer.d);
        }
        this.jdField_a_of_type_Bfgc.jdField_a_of_type_Bffj.a((RecyclerView.ViewHolder)localObject, true);
      }
    }
    bfui.a("hw_entry_upload", "upload_video", "1", "", String.valueOf(System.currentTimeMillis() - parambfer.a), "");
    this.jdField_a_of_type_Bfgc.a(0, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "VideoItem onError. info position=", Integer.valueOf(this.jdField_a_of_type_Bfer.c), ", info old status=", Integer.valueOf(this.jdField_a_of_type_Bfer.g) });
    }
    this.jdField_a_of_type_Bfer.g = 2;
    this.jdField_a_of_type_Bfgc.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_Bfer);
    QLog.d("VideoItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Bfgc.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bfgc.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bfer.c);
      if ((localObject instanceof bfgf))
      {
        localObject = (bfgf)localObject;
        if (this.jdField_a_of_type_Bfer.d.equals(((bfgf)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((bfgc)((bfei)this.jdField_a_of_type_Bfgc.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(2)).a((bffs)localObject, this.jdField_a_of_type_Bfer, 0);
          if ("200".equals(paramError))
          {
            QLog.d("VideoItem", 1, "VideoItem onError. upload size exceed.");
            QQToast.a(this.jdField_a_of_type_Bfgc.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext(), anni.a(2131714959), 0).a();
            this.jdField_a_of_type_Bfgc.jdField_a_of_type_Bffj.a((RecyclerView.ViewHolder)localObject);
          }
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      bfui.a("hw_entry_upload", "upload_video", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Bfer.a), "");
    }
    if (this.jdField_a_of_type_Bfer.d.equals(this.jdField_a_of_type_Bfgc.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bfgc.a(0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfgd
 * JD-Core Version:    0.7.0.1
 */