import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class blrk
  implements bcgo, utp
{
  double jdField_a_of_type_Double = 0.0D;
  amle jdField_a_of_type_Amle;
  blrn jdField_a_of_type_Blrn;
  TroopBarPOI jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = null;
  EditVideoParams jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams;
  ArrayList<TroopBarPOI> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  WeakReference<bmjj> jdField_a_of_type_MqqUtilWeakReference;
  utq jdField_a_of_type_Utq = null;
  double jdField_b_of_type_Double = 0.0D;
  ArrayList<TroopBarPOI> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  
  public blrk(blrn paramblrn)
  {
    this.jdField_a_of_type_Blrn = paramblrn;
  }
  
  private TroopBarPOI a(List<TroopBarPOI> paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopBarPOI localTroopBarPOI = (TroopBarPOI)paramList.next();
      if (localTroopBarPOI.c.equals(paramString)) {
        return localTroopBarPOI;
      }
    }
    return null;
  }
  
  public bmjj a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
      return (bmjj)this.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    return null;
  }
  
  public TroopBarPOI a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI;
  }
  
  public ArrayList<TroopBarPOI> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    wsv.b("FacePoiManager", "requestPoiList");
    utk localutk = (utk)urr.a(9);
    utj localutj = utk.a();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) {
      localutj = xnd.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    }
    if (localutj != null) {
      localutk.a(localutj, this.jdField_a_of_type_Utq, this);
    }
  }
  
  public void a(int paramInt, utq paramutq, List<TroopBarPOI> paramList)
  {
    wsv.b("FacePoiManager", "onPOIListRequestResult.");
    this.jdField_a_of_type_Utq = paramutq;
    boolean bool;
    if ((paramInt == 0) && (paramutq != null)) {
      if (!paramutq.a())
      {
        bool = true;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) && (paramList.size() > 0)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramList.get(0));
        }
        if ((this.jdField_a_of_type_Utq != null) && (this.jdField_a_of_type_Utq.b())) {
          this.jdField_b_of_type_JavaUtilArrayList.clear();
        }
        this.jdField_b_of_type_JavaUtilArrayList.addAll(paramList);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
          a(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.a());
        }
        wsv.a("FacePoiManager", "onPOIListRequestResult, CurrentPOIList : %s , CurrentPOI : %s .", this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        this.jdField_a_of_type_Blrn.a(true, bool, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      }
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      wta.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
      bool = false;
      break;
      this.jdField_a_of_type_Blrn.a(false, false, null, null);
    }
  }
  
  public void a(bmjj parambmjj, String paramString)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(parambmjj);
    a(this.jdField_b_of_type_JavaUtilArrayList, paramString);
  }
  
  public void a(TroopBarPOI paramTroopBarPOI)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = paramTroopBarPOI;
  }
  
  public void a(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
  }
  
  public void a(List<TroopBarPOI> paramList, String paramString)
  {
    String str = TroopBarPOI.a(paramString);
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      paramString = a(this.jdField_a_of_type_JavaUtilArrayList, str);
      paramList = paramString;
      if (paramString == null)
      {
        paramList = new TroopBarPOI("-1", "", str, 0, "", 0, "");
        this.jdField_a_of_type_JavaUtilArrayList.add(paramList);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = paramList;
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if ((3 != paramInt) || (paramJSONObject != null)) {}
    for (;;)
    {
      int i;
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("result");
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, "poiList = " + paramJSONObject);
        }
        if (paramJSONObject == null) {
          continue;
        }
        if (paramJSONObject.optInt("isend", -1) != 1) {
          break label244;
        }
        bool = true;
        paramJSONObject = paramJSONObject.getJSONArray("poilist");
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        if ((paramBundle == null) || (!paramBundle.getBoolean("refresh_all_poi"))) {
          break label250;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label229;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      catch (JSONException paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FacePoiManager", 2, paramJSONObject.toString());
        return;
      }
      if (i < paramJSONObject.length())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(new TroopBarPOI(paramJSONObject.getJSONObject(i)));
        if ((paramInt != 0) && (i == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(0));
        }
      }
      else
      {
        this.jdField_a_of_type_Blrn.a(true, bool, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        return;
        this.jdField_a_of_type_Blrn.a(false, false, null, null);
        return;
        label229:
        i = 0;
        continue;
      }
      i += 1;
      continue;
      label244:
      boolean bool = false;
      continue;
      label250:
      paramInt = 0;
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity)
  {
    wsv.b("FacePoiManager", "requestSosoPoi");
    this.jdField_a_of_type_Blrn.a(2, new String[0]);
    new axlk(paramActivity, new blrl(this, paramBoolean)).a();
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Amle != null)
    {
      SosoInterface.b(this.jdField_a_of_type_Amle);
      this.jdField_a_of_type_Amle = null;
      this.jdField_a_of_type_Double = 0.0D;
      this.jdField_b_of_type_Double = 0.0D;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null)
    {
      bmjj localbmjj = (bmjj)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localbmjj != null) {
        localbmjj.a();
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Utq != null) {
      this.jdField_a_of_type_Utq.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrk
 * JD-Core Version:    0.7.0.1
 */