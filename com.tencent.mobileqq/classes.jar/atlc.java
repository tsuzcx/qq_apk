import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import java.util.Iterator;
import java.util.List;

class atlc
  implements atng
{
  atlc(atky paramatky) {}
  
  public boolean a(View paramView)
  {
    paramView = this.a.a.getBooleanArray("forward_is_write_together");
    for (;;)
    {
      int i;
      try
      {
        Object localObject = this.a.a.getParcelableArrayList("forward_multi_target");
        String str = this.a.a.getString("forward_source_uin");
        if ((localObject == null) || (((List)localObject).isEmpty()))
        {
          localObject = this.a.a.getString("uin");
          if ((this.a.a.getInt("uintype") == 1) && (((String)localObject).equals(str)))
          {
            i = 0;
            if (i < paramView.length)
            {
              if (paramView[i] == 0) {
                break label197;
              }
              return true;
            }
          }
        }
        else
        {
          localObject = ((List)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
            if ((localResultRecord.getUinType() != 1) || (!str.equals(localResultRecord.uin))) {
              continue;
            }
            i = 0;
            if (i < paramView.length)
            {
              int j = paramView[i];
              if (j != 0) {
                return true;
              }
              i += 1;
              continue;
            }
            continue;
          }
        }
        return false;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      label197:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atlc
 * JD-Core Version:    0.7.0.1
 */