package com.tencent.mobileqq.activity.aio.photo;

import aghx;
import android.app.Activity;
import android.util.Pair;
import android.util.SparseArray;
import azqs;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import yak;

public class AIOGalleryScene$19
  implements Runnable
{
  public AIOGalleryScene$19(aghx paramaghx, int paramInt, SparseArray paramSparseArray, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((aghx.O(this.this$0) == null) || (aghx.P(this.this$0).isFinishing())) {
      return;
    }
    Object localObject;
    String str1;
    String str2;
    if (yak.a(this.jdField_a_of_type_Int))
    {
      localObject = this.jdField_a_of_type_AndroidUtilSparseArray.get(1);
      if (!(localObject instanceof Pair)) {
        break label306;
      }
      localObject = (Pair)localObject;
      str1 = String.valueOf(((Pair)localObject).second).trim();
      str2 = String.valueOf(((Pair)localObject).first).trim();
    }
    label278:
    label285:
    label306:
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        localObject = null;
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          try
          {
            ((JSONObject)localObject).put("scannerType", str1);
            ((JSONObject)localObject).put("scannerResult", str2);
            if (localObject == null)
            {
              localObject = "";
              aghx.a(this.this$0, 2131693001, 2130839744, 55, (String)localObject, this.jdField_a_of_type_JavaUtilArrayList);
              azqs.b(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 0, 0, "", "", "", "");
              if (yak.b(this.jdField_a_of_type_Int))
              {
                localObject = this.jdField_a_of_type_AndroidUtilSparseArray.get(2);
                if (!(localObject instanceof String)) {
                  continue;
                }
                str1 = (String)localObject;
              }
            }
          }
          catch (JSONException localJSONException4)
          {
            continue;
            localObject = null;
            continue;
          }
          try
          {
            localObject = new JSONObject();
          }
          catch (JSONException localJSONException2)
          {
            localObject = null;
            localJSONException2.printStackTrace();
            continue;
            localObject = ((JSONObject)localObject).toString();
          }
        }
        try
        {
          ((JSONObject)localObject).put("strMini", str1);
          if (localObject != null) {
            break label285;
          }
          localObject = "";
          aghx.a(this.this$0, 2131693000, 2130839743, 56, (String)localObject, this.jdField_a_of_type_JavaUtilArrayList);
          azqs.b(null, "P_CliOper", "qrcode", "", "0X80059A3", "0X80059A3", 1, 0, "", "", "", "");
          this.this$0.a.updateUI();
          return;
        }
        catch (JSONException localJSONException3)
        {
          break label278;
        }
        localJSONException1 = localJSONException1;
        localObject = null;
        localJSONException1.printStackTrace();
        continue;
        localObject = ((JSONObject)localObject).toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.19
 * JD-Core Version:    0.7.0.1
 */