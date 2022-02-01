import android.content.Context;
import android.util.Log;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aspw
{
  private static aspw jdField_a_of_type_Aspw;
  private List<EmotionPanelListView> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static aspw a()
  {
    if (jdField_a_of_type_Aspw == null) {}
    try
    {
      if (jdField_a_of_type_Aspw == null) {
        jdField_a_of_type_Aspw = new aspw();
      }
      return jdField_a_of_type_Aspw;
    }
    finally {}
  }
  
  public EmotionPanelListView a(Context paramContext)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      paramContext = (EmotionPanelListView)this.jdField_a_of_type_JavaUtilList.remove(0);
      if (QLog.isColorLevel()) {
        Log.d("EmotionPanelListViewPool", "from listview pool and poolSize = " + this.jdField_a_of_type_JavaUtilList.size());
      }
      return paramContext;
    }
    return new EmotionPanelListView(paramContext);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      Log.d("EmotionPanelListViewPool", "destory");
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
  }
  
  public void a(EmotionPanelListView paramEmotionPanelListView)
  {
    if (paramEmotionPanelListView == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_JavaUtilList.add(paramEmotionPanelListView);
      }
      while (QLog.isColorLevel())
      {
        Log.d("EmotionPanelListViewPool", "relase listview");
        return;
        if (!this.jdField_a_of_type_JavaUtilList.contains(paramEmotionPanelListView)) {
          this.jdField_a_of_type_JavaUtilList.add(0, paramEmotionPanelListView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspw
 * JD-Core Version:    0.7.0.1
 */