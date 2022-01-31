import android.view.View;
import com.tencent.mobileqq.utils.VipUtils.UpdateRecentEfficientVipIconTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class bdov
{
  private static ArrayList<VipUtils.UpdateRecentEfficientVipIconTask> a = new ArrayList();
  
  public static void a(View paramView)
  {
    Iterator localIterator = a.iterator();
    VipUtils.UpdateRecentEfficientVipIconTask localUpdateRecentEfficientVipIconTask2;
    View localView;
    do
    {
      if (!localIterator.hasNext()) {
        break label80;
      }
      localUpdateRecentEfficientVipIconTask2 = (VipUtils.UpdateRecentEfficientVipIconTask)localIterator.next();
      localView = VipUtils.UpdateRecentEfficientVipIconTask.a(localUpdateRecentEfficientVipIconTask2);
      localUpdateRecentEfficientVipIconTask1 = localUpdateRecentEfficientVipIconTask2;
      if (localView == paramView) {
        break;
      }
    } while (localView != null);
    label80:
    for (VipUtils.UpdateRecentEfficientVipIconTask localUpdateRecentEfficientVipIconTask1 = localUpdateRecentEfficientVipIconTask2;; localUpdateRecentEfficientVipIconTask1 = null)
    {
      if (localUpdateRecentEfficientVipIconTask1 != null)
      {
        a.remove(localUpdateRecentEfficientVipIconTask1);
        VipUtils.UpdateRecentEfficientVipIconTask.a(localUpdateRecentEfficientVipIconTask1, false);
        if (QLog.isColorLevel()) {
          QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - diable");
        }
      }
      return;
    }
  }
  
  public static void a(VipUtils.UpdateRecentEfficientVipIconTask paramUpdateRecentEfficientVipIconTask)
  {
    a.add(paramUpdateRecentEfficientVipIconTask);
  }
  
  public static void b(VipUtils.UpdateRecentEfficientVipIconTask paramUpdateRecentEfficientVipIconTask)
  {
    a.remove(paramUpdateRecentEfficientVipIconTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdov
 * JD-Core Version:    0.7.0.1
 */