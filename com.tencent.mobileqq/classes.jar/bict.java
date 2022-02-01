import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bict
  extends bici
{
  public static bict a;
  private List<bicu> a;
  
  static
  {
    jdField_a_of_type_Bict = new bict();
  }
  
  private ArrayList<bicu> a()
  {
    localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = new JSONObject(a()).getJSONArray("namePlateUrlConfig");
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        bicu localbicu = new bicu();
        localbicu.a = localJSONObject.optString("vipType");
        localbicu.b = localJSONObject.optString("itemId");
        localbicu.d = localJSONObject.optString("drawerUrl");
        localbicu.e = localJSONObject.optString("VaProfileUrl");
        localbicu.f = localJSONObject.optString("ctocUrl");
        localbicu.c = localJSONObject.optString("nameplateType");
        localbicu.g = localJSONObject.optString("VaProfileGuestUrl");
        localbicu.h = localJSONObject.optString("ctocGuestUrl");
        localbicu.i = localJSONObject.optString("ctocSettingUrl");
        localbicu.j = localJSONObject.optString("ctocSettingGuestUrl");
        localArrayList.add(localbicu);
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  @Nullable
  public bicu a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    bicu localbicu;
    try
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = a();
      }
      Object localObject1 = null;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (!localIterator.hasNext()) {
        break label137;
      }
      localbicu = (bicu)localIterator.next();
      if ((!localbicu.a.equals(String.valueOf(paramInt1))) || (!localbicu.c.equals(String.valueOf(paramInt3)))) {
        break label140;
      }
      if (localbicu.b.equals(String.valueOf(paramInt2))) {
        return localbicu;
      }
    }
    finally {}
    Object localObject3;
    if (localbicu.b.equals("1000000")) {
      localObject3 = localbicu;
    }
    label137:
    label140:
    for (;;)
    {
      break;
      return localObject3;
    }
  }
  
  String a()
  {
    try
    {
      String str = bhmi.b(new File(getSavePath(BaseApplicationImpl.getContext(), "namePlate_UrlConfig")));
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return super.isFileExists(paramQQAppInterface, getBID(), paramString);
  }
  
  public long getBID()
  {
    return 34L;
  }
  
  protected String getRootDir()
  {
    return "vipicon";
  }
  
  protected String getScidPrefix()
  {
    return "namePlate_UrlConfig";
  }
  
  protected boolean isZip_KeepZip()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bict
 * JD-Core Version:    0.7.0.1
 */