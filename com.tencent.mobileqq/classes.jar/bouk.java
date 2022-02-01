import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSpeedFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSpeedFilter.FilterPagerAdapter;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;

public class bouk
  implements ViewPager.OnPageChangeListener
{
  private bouk(EditVideoSpeedFilter paramEditVideoSpeedFilter) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    paramInt2 = 0;
    int i = paramInt1 % this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a();
    Object localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(i);
    if (localObject != null) {}
    for (paramInt1 = ((bpdi)localObject).jdField_a_of_type_Int;; paramInt1 = 0)
    {
      localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a((i + 1) % this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a());
      if (localObject != null) {
        paramInt2 = ((bpdi)localObject).jdField_a_of_type_Int;
      }
      localObject = (boud)this.a.a(boud.class);
      if (localObject != null) {
        ((boud)localObject).a(paramInt1, paramInt2, paramFloat);
      }
      return;
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Object localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(paramInt);
    if (localObject != null) {}
    for (int i = ((bpdi)localObject).jdField_a_of_type_Int;; i = 0)
    {
      this.a.jdField_a_of_type_AndroidUtilSparseArray.put(this.a.jdField_a_of_type_Botw.a(), localObject);
      if ((i == 2) || (i == 1) || (i == 3) || (i == 0))
      {
        localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(paramInt);
        if ((localObject != null) && (TextUtils.isEmpty(((bpdj)localObject).jdField_a_of_type_Bpdi.b))) {
          EditVideoSpeedFilter.a((bpdj)localObject);
        }
      }
      localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(paramInt - 1);
      bpdj localbpdj = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter$FilterPagerAdapter.a(paramInt + 1);
      if (localObject != null) {
        ((bpdj)localObject).jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      if (localbpdj != null) {
        localbpdj.jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      this.a.b = System.currentTimeMillis();
      this.a.jdField_a_of_type_Int = i;
      EditVideoSpeedFilter.a(this.a).put(this.a.jdField_a_of_type_Botw.a(), paramInt);
      localObject = (boud)this.a.a(boud.class);
      if (localObject != null)
      {
        ((boud)localObject).b(i);
        if ((localObject instanceof HWEditLocalVideoPlayer)) {
          ((HWEditLocalVideoPlayer)localObject).a(i);
        }
        if ((localObject instanceof bous)) {
          ((bous)localObject).a(i);
        }
      }
      if (i != 0)
      {
        this.a.jdField_a_of_type_Botw.a("608", "9", "0", true);
        ykw.a("0X80076DE");
      }
      ykq.a("EditVideoSpeedFilter", "LastSelectVideoFilterTime : %s , LastSelectVideoPlayMode : %s .", Long.valueOf(this.a.b), Integer.valueOf(this.a.jdField_a_of_type_Int));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bouk
 * JD-Core Version:    0.7.0.1
 */