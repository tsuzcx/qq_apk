import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.open.wadl.WadlJsBridge;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class bify
{
  private bifz jdField_a_of_type_Bifz = new bifz();
  private WadlJsBridge jdField_a_of_type_ComTencentOpenWadlWadlJsBridge = new WadlJsBridge(null, null, this.jdField_a_of_type_Bifz);
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridge.doOnDestroy();
    this.jdField_a_of_type_Bifz = null;
  }
  
  public void a(biga parambiga)
  {
    this.jdField_a_of_type_Bifz.a(parambiga);
  }
  
  public void a(String paramString)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appid", paramString);
      localJSONArray.put(localJSONObject);
      this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridge.a().a(localJSONArray.toString(), null);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("WadlMainBridge", 1, paramString, new Object[0]);
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null) {
      return;
    }
    if (paramInt == 2) {}
    try
    {
      String str = paramJSONObject.optString("appId");
      if (!TextUtils.isEmpty(str)) {
        bldt.a().c(7, str);
      }
      paramJSONObject.put("actionCode", paramInt);
      this.jdField_a_of_type_ComTencentOpenWadlWadlJsBridge.a().a(paramJSONObject.toString(), false, 7, null);
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("WadlMainBridge", 1, paramJSONObject, new Object[0]);
    }
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt, ArrayList<WadlResult> paramArrayList)
  {
    boolean bool2;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      bool2 = true;
    }
    boolean bool1;
    do
    {
      return bool2;
      paramArrayList = paramArrayList.iterator();
      bool1 = true;
      bool2 = bool1;
    } while (!paramArrayList.hasNext());
    WadlResult localWadlResult = (WadlResult)paramArrayList.next();
    WadlParams localWadlParams = localWadlResult.a;
    if ((paramString1.equals(localWadlParams.a)) && (paramString2.equals(localWadlParams.jdField_e_of_type_JavaLangString)) && (paramInt == localWadlParams.jdField_e_of_type_Int) && (!TextUtils.isEmpty(localWadlResult.b)) && (FileUtil.isFileExists(localWadlResult.b))) {
      bool1 = false;
    }
    for (;;)
    {
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bify
 * JD-Core Version:    0.7.0.1
 */