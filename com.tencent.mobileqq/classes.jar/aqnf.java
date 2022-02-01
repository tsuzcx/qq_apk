import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;

public class aqnf
  extends anyu
{
  public aqnf(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramString != null))
    {
      String str = bhlg.c(this.a.app, paramString, false);
      int i = 0;
      while (i < this.a.c.getChildCount())
      {
        Object localObject = this.a.c.getChildAt(i);
        if (((localObject instanceof ViewGroup)) && ((((View)localObject).getTag() instanceof aqno)) && (paramString.equals(((aqno)((View)localObject).getTag()).a)))
        {
          localObject = (TextView)((View)localObject).findViewById(2131371813);
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
 * Qualified Name:     aqnf
 * JD-Core Version:    0.7.0.1
 */