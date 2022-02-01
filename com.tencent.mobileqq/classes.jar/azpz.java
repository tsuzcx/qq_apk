import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class azpz
  extends RecyclerView.OnScrollListener
{
  azpz(azpy paramazpy, PersonalityLabelInfo paramPersonalityLabelInfo) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelGalleryActivity", 2, "onScrollStateChanged newState:" + paramInt);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelGalleryActivity", 2, "onScrolled dx:" + paramInt1 + " dy:" + paramInt2);
    }
    int i;
    int j;
    if (paramInt1 > 0)
    {
      paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.getLayoutManager();
      paramInt2 = paramRecyclerView.getChildCount();
      i = paramRecyclerView.getItemCount();
      j = paramRecyclerView.findLastVisibleItemPositions(null)[0];
      paramRecyclerView = PersonalityLabelGalleryActivity.c(this.jdField_a_of_type_Azpy.a).get(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelInfo.id));
      if (paramRecyclerView == null) {
        break label272;
      }
      if (((Integer)paramRecyclerView).intValue() != 1) {
        break label253;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      azqg localazqg;
      if ((!PersonalityLabelGalleryActivity.b(this.jdField_a_of_type_Azpy.a)) && (paramInt1 == 0) && (paramInt2 > 0) && (j >= i - 1))
      {
        PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Azpy.a, true);
        QLog.i("PersonalityLabelGalleryActivity", 2, "load more photos");
        localazqg = (azqg)this.jdField_a_of_type_Azpy.a.app.getBusinessHandler(BusinessHandlerFactory.PROFILE_PERSONALITY_LABEL);
        if (!PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Azpy.a)) {
          break label258;
        }
      }
      label258:
      for (paramRecyclerView = this.jdField_a_of_type_Azpy.a.app.getCurrentAccountUin();; paramRecyclerView = PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Azpy.a))
      {
        localazqg.a(paramRecyclerView, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelInfo.id, 20, (byte[])PersonalityLabelGalleryActivity.b(this.jdField_a_of_type_Azpy.a).get(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelInfo.id)));
        return;
        label253:
        paramInt1 = 0;
        break;
      }
      label272:
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpz
 * JD-Core Version:    0.7.0.1
 */