import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.2.1;
import com.tencent.widget.XListView;

public class autl
  implements View.OnClickListener
{
  public autl(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, QQBrowserActivity.class);
    paramView.putExtra("url", "https://ti.qq.com/cgi-node/specialtag/zanlist?_wv=1027&asyncMode=3");
    this.a.startActivity(paramView);
    paramView = PersonalityLabelGalleryActivity.a(this.a);
    paramView.praiseCount += PersonalityLabelGalleryActivity.a(this.a).unreadCount;
    PersonalityLabelGalleryActivity.a(this.a).unreadCount = 0;
    PersonalityLabelGalleryActivity.a(this.a).postDelayed(new PersonalityLabelGalleryActivity.2.1(this), 500L);
    axqw.b(this.a.app, "dc00898", "", "", "0X8007FCF", "0X8007FCF", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     autl
 * JD-Core Version:    0.7.0.1
 */