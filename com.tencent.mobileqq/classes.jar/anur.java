import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;

public class anur
  extends alox
{
  public anur(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramString != null))
    {
      String str = bdbt.c(this.a.app, paramString, false);
      int i = 0;
      while (i < this.a.c.getChildCount())
      {
        Object localObject = this.a.c.getChildAt(i);
        if (((localObject instanceof ViewGroup)) && ((((View)localObject).getTag() instanceof anva)) && (paramString.equals(((anva)((View)localObject).getTag()).a)))
        {
          localObject = (TextView)((View)localObject).findViewById(2131371127);
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
 * Qualified Name:     anur
 * JD-Core Version:    0.7.0.1
 */