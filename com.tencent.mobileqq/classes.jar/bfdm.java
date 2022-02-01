import android.os.Bundle;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bfdm
  implements lba
{
  public bfdm(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void a() {}
  
  public void a(Bundle paramBundle)
  {
    int j = 0;
    paramBundle = paramBundle.getString("sso_GdtLoadAd_rsp_json");
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, "json = " + paramBundle);
    }
    for (;;)
    {
      int i;
      int k;
      try
      {
        JSONObject localJSONObject1 = new JSONObject(paramBundle);
        paramBundle = localJSONObject1.optJSONArray("pos_ads_info");
        localJSONObject1 = new JSONObject(localJSONObject1.optString("busi_cookie")).optJSONObject("index");
        i = 0;
        if (i < paramBundle.length())
        {
          Object localObject = paramBundle.optJSONObject(i);
          JSONObject localJSONObject2 = ((JSONObject)localObject).optJSONArray("ads_info").optJSONObject(0);
          k = j;
          if (localJSONObject2 != null)
          {
            int m = localJSONObject1.optInt(((JSONObject)localObject).optString("pos_id"));
            k = j;
            if (m - 1 > 0)
            {
              k = j;
              if (m - 1 < this.a.jdField_a_of_type_JavaUtilArrayList.size())
              {
                localObject = new bfef(localJSONObject2);
                this.a.jdField_a_of_type_JavaUtilArrayList.add(m - 1, localObject);
                k = 1;
              }
            }
          }
        }
        else
        {
          if (j != 0) {
            this.a.jdField_a_of_type_Bfdt.notifyDataSetChanged();
          }
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      i += 1;
      j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfdm
 * JD-Core Version:    0.7.0.1
 */