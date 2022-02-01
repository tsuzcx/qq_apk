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
    if (AIOGalleryScene.E(this.this$0) != null)
    {
      if (AIOGalleryScene.F(this.this$0).isFinishing()) {
        return;
      }
      Object localObject1;
      Object localObject3;
      if (QRUtils.a(this.a))
      {
        localObject1 = null;
        Object localObject2 = null;
        Object localObject5 = this.b.get(1);
        if ((localObject5 instanceof Pair))
        {
          localObject1 = (Pair)localObject5;
          localObject5 = String.valueOf(((Pair)localObject1).second).trim();
          String str = String.valueOf(((Pair)localObject1).first).trim();
          try
          {
            localObject1 = new JSONObject();
            try
            {
              ((JSONObject)localObject1).put("scannerType", localObject5);
              ((JSONObject)localObject1).put("scannerResult", str);
            }
            catch (JSONException localJSONException1) {}
            ((JSONException)localObject3).printStackTrace();
          }
          catch (JSONException localJSONException3)
          {
            localObject1 = localJSONException1;
            localObject3 = localJSONException3;
          }
        }
        if (localObject1 == null) {
          localObject1 = "";
        } else {
          localObject1 = ((JSONObject)localObject1).toString();
        }
        AIOGalleryScene.a(this.this$0, 2131889846, 2130840474, 55, (String)localObject1, this.c);
        ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 0, 0, "", "", "", "");
      }
      if (QRUtils.b(this.a))
      {
        localObject1 = new JSONObject();
        localObject3 = this.b.get(2);
        if ((localObject3 instanceof String))
        {
          localObject3 = (String)localObject3;
          try
          {
            ((JSONObject)localObject1).put("strMini", localObject3);
          }
          catch (JSONException localJSONException2)
          {
            localJSONException2.printStackTrace();
          }
        }
        Object localObject4 = this.b.get(1001);
        if ((localObject4 instanceof String))
        {
          localObject4 = (String)localObject4;
          try
          {
            ((JSONObject)localObject1).put("type", localObject4);
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
        localObject1 = ((JSONObject)localObject1).toString();
        AIOGalleryScene.a(this.this$0, 2131889845, 2130840473, 56, (String)localObject1, this.c);
        ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 1, 0, "", "", "", "");
      }
      this.this$0.aF.updateUI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.21
 * JD-Core Version:    0.7.0.1
 */