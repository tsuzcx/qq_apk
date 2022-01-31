import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.TroopHomeworkHelper;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class anny
  implements Runnable
{
  private annz jdField_a_of_type_Annz;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  
  public anny(TroopHWJsPlugin paramTroopHWJsPlugin, annz paramannz, HashMap paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_Annz = paramannz;
  }
  
  public void run()
  {
    Context localContext = this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.mRuntime.a().getApplicationContext();
    File localFile = new File(TroopHWJsPlugin.a);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject).getKey()).intValue();
      localObject = (String)((Map.Entry)localObject).getValue();
      if (QLog.isColorLevel()) {
        QLog.d("TroopHWJsPlugin", 2, "compressVideo, path = " + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        Bitmap localBitmap;
        String str;
        int j;
        try
        {
          localBitmap = TroopHWJsPlugin.a(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin, i, (String)localObject);
          str = localFile.getAbsolutePath() + new File((String)localObject).getName();
          this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.a(i, 0.05F);
          j = TroopHomeworkHelper.a(localContext, (String)localObject, str);
          this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.a(i, 0.1F);
          if (j != 1) {
            break label298;
          }
          localObject = this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.a(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin, i, (String)localObject, localBitmap, this.jdField_a_of_type_Annz, 2);
          this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.b.put(Integer.valueOf(i), localObject);
          ((TroopHWJsPlugin.UploadMediaEntry)localObject).a();
        }
        catch (Exception localException)
        {
          QLog.e("TroopHWJsPlugin", 2, "compressVideo, Exception happened!", localException);
          TroopHWJsPlugin.a(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin).sendEmptyMessage(0);
        }
        continue;
        label298:
        TroopHWJsPlugin.UploadMediaEntry localUploadMediaEntry;
        if ((j == 0) && (new File(str).exists()))
        {
          localUploadMediaEntry = this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.a(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin, i, str, localBitmap, this.jdField_a_of_type_Annz, 2);
          this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.b.put(Integer.valueOf(i), localUploadMediaEntry);
          localUploadMediaEntry.a();
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.w("TroopHWJsPlugin", 2, "CompressVideoJob failed:" + j);
          }
          localUploadMediaEntry = this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.a(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin, i, localUploadMediaEntry, localBitmap, this.jdField_a_of_type_Annz, 2);
          this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.b.put(Integer.valueOf(i), localUploadMediaEntry);
          localUploadMediaEntry.a();
        }
      }
      else
      {
        TroopHWJsPlugin.a(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin).sendEmptyMessage(4);
        QLog.e("TroopHWJsPlugin", 2, "compressVideo,video empty!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anny
 * JD-Core Version:    0.7.0.1
 */