import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import java.util.ArrayList;

public class ayam
  implements aybd
{
  public ayam(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void a(long paramLong)
  {
    int i = 0;
    while (i < ChooseInterestTagActivity.a(this.a).getChildCount())
    {
      InterestTagInfo localInterestTagInfo = (InterestTagInfo)ChooseInterestTagActivity.a(this.a).getChildAt(i).getTag();
      if ((localInterestTagInfo != null) && (paramLong == localInterestTagInfo.tagId))
      {
        ChooseInterestTagActivity.a(this.a).remove(localInterestTagInfo);
        ChooseInterestTagActivity.a(this.a, localInterestTagInfo);
        ChooseInterestTagActivity.b(this.a, localInterestTagInfo);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayam
 * JD-Core Version:    0.7.0.1
 */