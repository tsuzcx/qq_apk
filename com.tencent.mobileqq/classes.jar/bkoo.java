import android.os.Handler;
import android.os.Looper;
import android.view.View;
import dov.com.tencent.biz.qqstory.takevideo.vote.VoteDashItem.1;
import dov.com.tencent.biz.qqstory.takevideo.vote.VoteDashItem.2;

public class bkoo
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public void a(bkat parambkat, View paramView, boolean paramBoolean, int paramInt1, int paramInt2, Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    int i;
    for (;;)
    {
      i = 0;
      while (i < paramInt1 - paramInt2)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VoteDashItem.1(this, parambkat, paramView), i);
        i += paramInt2;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VoteDashItem.2(this, parambkat, paramBoolean, paramView, paramRunnable), i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkoo
 * JD-Core Version:    0.7.0.1
 */