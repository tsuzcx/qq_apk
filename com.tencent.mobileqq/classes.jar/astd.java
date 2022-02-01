import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.qphone.base.util.QLog;

class astd
  implements URLDrawableDownListener
{
  astd(astb paramastb, asmu paramasmu) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    QLog.e("RelatedEmoticonListAdapter", 1, "onLoadFailed: " + this.jdField_a_of_type_Asmu.toString());
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("RelatedEmoticonListAdapter", 1, "onLoadFailed: " + this.jdField_a_of_type_Asmu.toString());
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    QLog.e("RelatedEmoticonListAdapter", 1, "onLoadInterrupted: " + this.jdField_a_of_type_Asmu.toString());
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RelatedEmoticonListAdapter", 2, "onLoadSuccessed: " + this.jdField_a_of_type_Asmu.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     astd
 * JD-Core Version:    0.7.0.1
 */