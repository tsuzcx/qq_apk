package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.mobileqq.qrscan.utils.QRUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class AIOGalleryScene$21
  implements Runnable
{
  AIOGalleryScene$21(AIOGalleryScene paramAIOGalleryScene, int paramInt, SparseArray paramSparseArray, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (AIOGalleryScene.x(this.this$0) != null)
    {
      if (AIOGalleryScene.y(this.this$0).isFinishing()) {
        return;
      }
      boolean bool = QRUtils.a(this.jdField_a_of_type_Int);
      String str2 = "";
      Object localObject4 = null;
      Object localObject3 = null;
      Object localObject1;
      if (bool)
      {
        localObject1 = this.jdField_a_of_type_AndroidUtilSparseArray.get(1);
        if ((localObject1 instanceof Pair))
        {
          localObject1 = (Pair)localObject1;
          String str1 = String.valueOf(((Pair)localObject1).second).trim();
          String str3 = String.valueOf(((Pair)localObject1).first).trim();
          try
          {
            localObject1 = new JSONObject();
            try
            {
              ((JSONObject)localObject1).put("scannerType", str1);
              ((JSONObject)localObject1).put("scannerResult", str3);
            }
            catch (JSONException localJSONException1) {}
            localJSONException2.printStackTrace();
          }
          catch (JSONException localJSONException2)
          {
            localObject1 = null;
          }
        }
        else
        {
          localObject1 = null;
        }
        if (localObject1 == null) {
          localObject1 = "";
        } else {
          localObject1 = ((JSONObject)localObject1).toString();
        }
        AIOGalleryScene.a(this.this$0, 2131692775, 2130840169, 55, (String)localObject1, this.jdField_a_of_type_JavaUtilArrayList);
        ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 0, 0, "", "", "", "");
      }
      if (QRUtils.b(this.jdField_a_of_type_Int))
      {
        Object localObject2 = this.jdField_a_of_type_AndroidUtilSparseArray.get(2);
        localObject1 = localObject4;
        if ((localObject2 instanceof String))
        {
          localObject2 = (String)localObject2;
          try
          {
            localObject1 = new JSONObject();
            try
            {
              ((JSONObject)localObject1).put("strMini", localObject2);
            }
            catch (JSONException localJSONException3) {}
            localJSONException4.printStackTrace();
          }
          catch (JSONException localJSONException4)
          {
            localObject1 = localObject3;
          }
        }
        if (localObject1 == null) {
          localObject1 = str2;
        } else {
          localObject1 = ((JSONObject)localObject1).toString();
        }
        AIOGalleryScene.a(this.this$0, 2131692774, 2130840168, 56, (String)localObject1, this.jdField_a_of_type_JavaUtilArrayList);
        ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 1, 0, "", "", "", "");
      }
      this.this$0.a.updateUI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.21
 * JD-Core Version:    0.7.0.1
 */