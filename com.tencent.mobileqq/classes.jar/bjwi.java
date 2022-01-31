import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter.FilterPagerAdapter;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;

public class bjwi
  implements ViewPager.OnPageChangeListener
{
  private bjwi(EditVideoFilter paramEditVideoFilter) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    paramInt2 = 0;
    int i = paramInt1 % this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a();
    Object localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(i);
    if (localObject != null) {}
    for (paramInt1 = ((bkip)localObject).jdField_a_of_type_Int;; paramInt1 = 0)
    {
      localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a((i + 1) % this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a());
      if (localObject != null) {
        paramInt2 = ((bkip)localObject).jdField_a_of_type_Int;
      }
      localObject = (bjxx)this.a.a(bjxx.class);
      if (localObject != null) {
        ((bjxx)localObject).a(paramInt1, paramInt2, paramFloat);
      }
      return;
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Object localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(paramInt);
    if (localObject != null) {}
    for (int i = ((bkip)localObject).jdField_a_of_type_Int;; i = 0)
    {
      this.a.jdField_a_of_type_AndroidUtilSparseArray.put(this.a.jdField_a_of_type_Bjxn.a(), localObject);
      if ((i == 2) || (i == 1) || (i == 3) || (i == 0))
      {
        localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(paramInt);
        if ((localObject != null) && (TextUtils.isEmpty(((bkiq)localObject).jdField_a_of_type_Bkip.b))) {
          EditVideoFilter.a((bkiq)localObject);
        }
      }
      localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(paramInt - 1);
      bkiq localbkiq = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter$FilterPagerAdapter.a(paramInt + 1);
      if (localObject != null) {
        ((bkiq)localObject).jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      if (localbkiq != null) {
        localbkiq.jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      this.a.jdField_a_of_type_Long = System.currentTimeMillis();
      this.a.jdField_a_of_type_Int = i;
      EditVideoFilter.a(this.a).put(this.a.jdField_a_of_type_Bjxn.a(), paramInt);
      localObject = (bjxx)this.a.a(bjxx.class);
      if (localObject != null)
      {
        ((bjxx)localObject).b(i);
        if ((localObject instanceof HWEditLocalVideoPlayer)) {
          ((HWEditLocalVideoPlayer)localObject).a(i);
        }
        if ((localObject instanceof bjzg)) {
          ((bjzg)localObject).a(i);
        }
      }
      this.a.j();
      if (i != 0)
      {
        this.a.jdField_a_of_type_Bjxn.a("608", "9", "0", true);
        vej.a("0X80076DE");
      }
      ved.a("Q.qqstory.publish.edit.EditVideoFilter", "LastSelectVideoFilterTime : %s , LastSelectVideoPlayMode : %s .", Long.valueOf(this.a.jdField_a_of_type_Long), Integer.valueOf(this.a.jdField_a_of_type_Int));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjwi
 * JD-Core Version:    0.7.0.1
 */