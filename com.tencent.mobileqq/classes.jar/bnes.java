import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSpeedFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSpeedFilter.FilterPagerAdapter;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;

public class bnes
  implements ViewPager.OnPageChangeListener
{
  private bnes(EditVideoSpeedFilter paramEditVideoSpeedFilter) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    paramInt2 = 0;
    int i = paramInt1 % this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a();
    Object localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(i);
    if (localObject != null) {}
    for (paramInt1 = ((bnnq)localObject).jdField_a_of_type_Int;; paramInt1 = 0)
    {
      localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a((i + 1) % this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a());
      if (localObject != null) {
        paramInt2 = ((bnnq)localObject).jdField_a_of_type_Int;
      }
      localObject = (bnel)this.a.a(bnel.class);
      if (localObject != null) {
        ((bnel)localObject).a(paramInt1, paramInt2, paramFloat);
      }
      return;
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Object localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(paramInt);
    if (localObject != null) {}
    for (int i = ((bnnq)localObject).jdField_a_of_type_Int;; i = 0)
    {
      this.a.jdField_a_of_type_AndroidUtilSparseArray.put(this.a.jdField_a_of_type_Bnee.a(), localObject);
      if ((i == 2) || (i == 1) || (i == 3) || (i == 0))
      {
        localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(paramInt);
        if ((localObject != null) && (TextUtils.isEmpty(((bnnr)localObject).jdField_a_of_type_Bnnq.b))) {
          EditVideoSpeedFilter.a((bnnr)localObject);
        }
      }
      localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(paramInt - 1);
      bnnr localbnnr = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(paramInt + 1);
      if (localObject != null) {
        ((bnnr)localObject).jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      if (localbnnr != null) {
        localbnnr.jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      this.a.b = System.currentTimeMillis();
      this.a.jdField_a_of_type_Int = i;
      EditVideoSpeedFilter.a(this.a).put(this.a.jdField_a_of_type_Bnee.a(), paramInt);
      localObject = (bnel)this.a.a(bnel.class);
      if (localObject != null)
      {
        ((bnel)localObject).b(i);
        if ((localObject instanceof HWEditLocalVideoPlayer)) {
          ((HWEditLocalVideoPlayer)localObject).a(i);
        }
        if ((localObject instanceof bnfa)) {
          ((bnfa)localObject).a(i);
        }
      }
      if (i != 0)
      {
        this.a.jdField_a_of_type_Bnee.a("608", "9", "0", true);
        xwb.a("0X80076DE");
      }
      xvv.a("EditVideoSpeedFilter", "LastSelectVideoFilterTime : %s , LastSelectVideoPlayMode : %s .", Long.valueOf(this.a.b), Integer.valueOf(this.a.jdField_a_of_type_Int));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnes
 * JD-Core Version:    0.7.0.1
 */