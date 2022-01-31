import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.entry.ui.BeginnerGuideFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;

public class bcbt
  implements View.OnClickListener
{
  public bcbt(ReciteFragment paramReciteFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.m();
    BeginnerGuideFragment.b(ReciteFragment.a(this.a), null, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbt
 * JD-Core Version:    0.7.0.1
 */