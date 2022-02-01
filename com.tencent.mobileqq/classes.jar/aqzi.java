import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.qphone.base.util.QLog;

class aqzi
  implements URLDrawableDownListener
{
  aqzi(aqzb paramaqzb, EmoticonInfo paramEmoticonInfo, aqzj paramaqzj) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    QLog.e("FavEmosmViewPage", 1, "onLoadFailed: " + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo.toString());
    aqzb.a(this.jdField_a_of_type_Aqzb, this.jdField_a_of_type_Aqzj.a, this.jdField_a_of_type_Aqzj);
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("FavEmosmViewPage", 1, "onLoadFailed: " + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo.toString());
    aqzb.a(this.jdField_a_of_type_Aqzb, this.jdField_a_of_type_Aqzj.a, this.jdField_a_of_type_Aqzj);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    QLog.e("FavEmosmViewPage", 1, "onLoadInterrupted: " + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo.toString());
    aqzb.a(this.jdField_a_of_type_Aqzb, this.jdField_a_of_type_Aqzj.a, this.jdField_a_of_type_Aqzj);
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FavEmosmViewPage", 2, "onLoadProgressed: " + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo.toString());
    }
    aqzb.a(this.jdField_a_of_type_Aqzb, this.jdField_a_of_type_Aqzj.a, this.jdField_a_of_type_Aqzj);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FavEmosmViewPage", 2, "onLoadSuccess: " + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo.toString());
    }
    aqzb.a(this.jdField_a_of_type_Aqzb, this.jdField_a_of_type_Aqzj.a, this.jdField_a_of_type_Aqzj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqzi
 * JD-Core Version:    0.7.0.1
 */