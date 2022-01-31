import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.2.1;
import com.tencent.widget.XListView;

public class atvn
  implements View.OnClickListener
{
  public atvn(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, QQBrowserActivity.class);
    paramView.putExtra("url", "https://ti.qq.com/cgi-node/specialtag/zanlist?_wv=1027&asyncMode=3");
    this.a.startActivity(paramView);
    paramView = PersonalityLabelGalleryActivity.a(this.a);
    paramView.praiseCount += PersonalityLabelGalleryActivity.a(this.a).unreadCount;
    PersonalityLabelGalleryActivity.a(this.a).unreadCount = 0;
    PersonalityLabelGalleryActivity.a(this.a).postDelayed(new PersonalityLabelGalleryActivity.2.1(this), 500L);
    awqx.b(this.a.app, "dc00898", "", "", "0X8007FCF", "0X8007FCF", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvn
 * JD-Core Version:    0.7.0.1
 */