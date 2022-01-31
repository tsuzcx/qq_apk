import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bdsk
  extends bdrz
{
  public static final bdsk a;
  private List<bdsl> a;
  
  static
  {
    jdField_a_of_type_Bdsk = new bdsk();
  }
  
  private ArrayList<bdsl> a()
  {
    localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = new JSONObject(bdcs.b(new File(getSavePath(BaseApplicationImpl.getContext(), "namePlate_UrlConfig")))).getJSONArray("namePlateUrlConfig");
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        bdsl localbdsl = new bdsl();
        localbdsl.a = localJSONObject.optString("vipType");
        localbdsl.b = localJSONObject.optString("itemId");
        localbdsl.d = localJSONObject.optString("drawerUrl");
        localbdsl.e = localJSONObject.optString("VaProfileUrl");
        localbdsl.f = localJSONObject.optString("ctocUrl");
        localbdsl.c = localJSONObject.optString("nameplateType");
        localbdsl.g = localJSONObject.optString("VaProfileGuestUrl");
        localbdsl.h = localJSONObject.optString("ctocGuestUrl");
        localbdsl.i = localJSONObject.optString("ctocSettingUrl");
        localbdsl.j = localJSONObject.optString("ctocSettingGuestUrl");
        localArrayList.add(localbdsl);
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public bdsl a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    try
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = a();
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bdsl localbdsl = (bdsl)localIterator.next();
        if ((localbdsl.a.equals(String.valueOf(paramInt1))) && (localbdsl.b.equals(String.valueOf(paramInt2))) && (localbdsl.c.equals(String.valueOf(paramInt3)))) {
          return localbdsl;
        }
      }
    }
    finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsk
 * JD-Core Version:    0.7.0.1
 */