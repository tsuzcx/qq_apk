import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.utils.ContactUtils;

public class aqju
  extends anvi
{
  public aqju(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramString != null))
    {
      String str = ContactUtils.getBuddyNickName(this.a.app, paramString, false);
      int i = 0;
      while (i < this.a.c.getChildCount())
      {
        Object localObject = this.a.c.getChildAt(i);
        if (((localObject instanceof ViewGroup)) && ((((View)localObject).getTag() instanceof aqkd)) && (paramString.equals(((aqkd)((View)localObject).getTag()).a)))
        {
          localObject = (TextView)((View)localObject).findViewById(2131371966);
          if (localObject != null) {
            ((TextView)localObject).setText(str);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqju
 * JD-Core Version:    0.7.0.1
 */