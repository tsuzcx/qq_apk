import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter.FilterPagerAdapter;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;

public class bqff
  implements ViewPager.OnPageChangeListener
{
  private bqff(EditVideoFilter paramEditVideoFilter) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    paramInt2 = 0;
    int i = paramInt1 % this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a();
    Object localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(i);
    if (localObject != null) {}
    for (paramInt1 = ((bqrm)localObject).jdField_a_of_type_Int;; paramInt1 = 0)
    {
      localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a((i + 1) % this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a());
      if (localObject != null) {
        paramInt2 = ((bqrm)localObject).jdField_a_of_type_Int;
      }
      localObject = (bqgu)this.a.a(bqgu.class);
      if (localObject != null) {
        ((bqgu)localObject).a(paramInt1, paramInt2, paramFloat);
      }
      return;
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Object localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(paramInt);
    if (localObject != null) {}
    for (int i = ((bqrm)localObject).jdField_a_of_type_Int;; i = 0)
    {
      this.a.jdField_a_of_type_AndroidUtilSparseArray.put(this.a.jdField_a_of_type_Bqgk.a(), localObject);
      if ((i == 2) || (i == 1) || (i == 3) || (i == 0))
      {
        localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(paramInt);
        if ((localObject != null) && (TextUtils.isEmpty(((bqrn)localObject).jdField_a_of_type_Bqrm.b))) {
          EditVideoFilter.a((bqrn)localObject);
        }
      }
      localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(paramInt - 1);
      bqrn localbqrn = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(paramInt + 1);
      if (localObject != null) {
        ((bqrn)localObject).jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      if (localbqrn != null) {
        localbqrn.jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      this.a.jdField_a_of_type_Long = System.currentTimeMillis();
      this.a.jdField_a_of_type_Int = i;
      EditVideoFilter.a(this.a).put(this.a.jdField_a_of_type_Bqgk.a(), paramInt);
      localObject = (bqgu)this.a.a(bqgu.class);
      if (localObject != null)
      {
        ((bqgu)localObject).b(i);
        if ((localObject instanceof HWEditLocalVideoPlayer)) {
          ((HWEditLocalVideoPlayer)localObject).a(i);
        }
        if ((localObject instanceof bqid)) {
          ((bqid)localObject).a(i);
        }
      }
      this.a.j();
      if (i != 0)
      {
        this.a.jdField_a_of_type_Bqgk.a("608", "9", "0", true);
        yuq.a("0X80076DE");
      }
      yuk.a("Q.qqstory.publish.edit.EditVideoFilter", "LastSelectVideoFilterTime : %s , LastSelectVideoPlayMode : %s .", Long.valueOf(this.a.jdField_a_of_type_Long), Integer.valueOf(this.a.jdField_a_of_type_Int));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqff
 * JD-Core Version:    0.7.0.1
 */