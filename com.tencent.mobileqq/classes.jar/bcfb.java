import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

class bcfb
  extends SimpleObserver<bced>
{
  bcfb(bcfa parambcfa, bced parambced) {}
  
  public void a(bced parambced)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "ImageItem onNext. info position=", Integer.valueOf(parambced.c), ", old status=", Integer.valueOf(parambced.g), ", result=", parambced });
    }
    parambced.g = 3;
    parambced.e = 100;
    this.jdField_a_of_type_Bcfa.jdField_a_of_type_JavaUtilMap.remove(parambced);
    if (this.jdField_a_of_type_Bcfa.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bcfa.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bced.c);
      if ((localObject instanceof bcfe))
      {
        localObject = (bcfe)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, new Object[] { "ImageItem onNext. info hash=", Integer.valueOf(parambced.hashCode()), ", result hash=", Integer.valueOf(parambced.hashCode()), ", info position=", Integer.valueOf(parambced.c), ", result position=", Integer.valueOf(parambced.c), ", vh position=", Integer.valueOf(((bcfe)localObject).jdField_a_of_type_Bcdy.c), ",vh hash=", Integer.valueOf(localObject.hashCode()) });
        }
        if (parambced.d.equals(((bcfe)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag()))
        {
          ((bcfe)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
          ((bcfe)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
          ((bcfe)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(parambced.e, parambced.d);
        }
        this.jdField_a_of_type_Bcfa.jdField_a_of_type_Bcev.a((RecyclerView.ViewHolder)localObject, true);
      }
    }
    bcpr.a("hw_entry_upload", "upload_image", "1", "", String.valueOf(System.currentTimeMillis() - parambced.a), "");
    this.jdField_a_of_type_Bcfa.a(0, false);
  }
  
  public void onError(@NonNull Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "ImageItem onError: ", paramError.getMessage(), ", info position =", Integer.valueOf(this.jdField_a_of_type_Bced.c), ", info hash=", Integer.valueOf(this.jdField_a_of_type_Bced.hashCode()), ", info old status=", Integer.valueOf(this.jdField_a_of_type_Bced.g) });
    }
    this.jdField_a_of_type_Bced.g = 2;
    this.jdField_a_of_type_Bcfa.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_Bced);
    QLog.d("ImageItem", 1, paramError, new Object[0]);
    paramError = paramError.getMessage();
    if (this.jdField_a_of_type_Bcfa.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor != null)
    {
      Object localObject = this.jdField_a_of_type_Bcfa.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_Bced.c);
      if ((localObject instanceof bcfe))
      {
        localObject = (bcfe)localObject;
        if (this.jdField_a_of_type_Bced.d.equals(((bcfe)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag())) {
          ((bcfa)((bcdu)this.jdField_a_of_type_Bcfa.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter()).a.a(1)).a((bcfe)localObject, this.jdField_a_of_type_Bced, 0);
        }
      }
    }
    if (!paramError.startsWith("c_")) {
      bcpr.a("hw_entry_upload", "upload_image", "2", paramError, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Bced.a), "");
    }
    if (this.jdField_a_of_type_Bced.d.equals(this.jdField_a_of_type_Bcfa.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Bcfa.a(0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfb
 * JD-Core Version:    0.7.0.1
 */