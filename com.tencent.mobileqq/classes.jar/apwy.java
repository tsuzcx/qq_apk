import android.content.Context;
import android.util.Log;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class apwy
{
  private static apwy jdField_a_of_type_Apwy;
  private List<EmotionPanelListView> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static apwy a()
  {
    if (jdField_a_of_type_Apwy == null) {}
    try
    {
      if (jdField_a_of_type_Apwy == null) {
        jdField_a_of_type_Apwy = new apwy();
      }
      return jdField_a_of_type_Apwy;
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
 * Qualified Name:     apwy
 * JD-Core Version:    0.7.0.1
 */