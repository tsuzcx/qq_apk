import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ampp
  implements Runnable
{
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  
  public ampp(TroopHWJsPlugin paramTroopHWJsPlugin, HashMap paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)paramHashMap.clone());
  }
  
  public void run()
  {
    Object localObject1 = new File(TroopHWJsPlugin.jdField_a_of_type_JavaLangString);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = new HashMap();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      if (QLog.isColorLevel()) {
        QLog.d("TroopHWJsPlugin", 2, "CompressImage, path = " + (String)localObject2);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        try
        {
          localObject2 = TroopHWJsPlugin.a(i, (String)localObject2, this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.c, this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label207;
          }
          QLog.e("TroopHWJsPlugin", 2, "compressImage failed!");
          TroopHWJsPlugin.a(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin).sendEmptyMessage(0);
        }
        catch (Exception localException)
        {
          QLog.e("TroopHWJsPlugin", 2, "compressImage failed!", localException);
          TroopHWJsPlugin.a(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin).sendEmptyMessage(0);
        }
        continue;
        label207:
        this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), localException);
        ((HashMap)localObject1).put(Integer.valueOf(i), localException);
        ampr localampr = new ampr(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.e, this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.d);
        TroopHWJsPlugin.UploadMediaEntry localUploadMediaEntry = this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.a(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin, i, localException, null, localampr, 1);
        this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(i), localUploadMediaEntry);
        localUploadMediaEntry.a();
      }
      else
      {
        TroopHWJsPlugin.a(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin).sendEmptyMessage(3);
        QLog.e("TroopHWJsPlugin", 2, "compressImage failed! empty image!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ampp
 * JD-Core Version:    0.7.0.1
 */