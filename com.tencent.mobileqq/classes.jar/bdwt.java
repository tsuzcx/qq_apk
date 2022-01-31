import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bdwt
  extends bdwi
{
  public static final bdwt a;
  private List<bdwu> a;
  
  static
  {
    jdField_a_of_type_Bdwt = new bdwt();
  }
  
  private ArrayList<bdwu> a()
  {
    localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = new JSONObject(bdhb.b(new File(getSavePath(BaseApplicationImpl.getContext(), "namePlate_UrlConfig")))).getJSONArray("namePlateUrlConfig");
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        bdwu localbdwu = new bdwu();
        localbdwu.a = localJSONObject.optString("vipType");
        localbdwu.b = localJSONObject.optString("itemId");
        localbdwu.d = localJSONObject.optString("drawerUrl");
        localbdwu.e = localJSONObject.optString("VaProfileUrl");
        localbdwu.f = localJSONObject.optString("ctocUrl");
        localbdwu.c = localJSONObject.optString("nameplateType");
        localbdwu.g = localJSONObject.optString("VaProfileGuestUrl");
        localbdwu.h = localJSONObject.optString("ctocGuestUrl");
        localbdwu.i = localJSONObject.optString("ctocSettingUrl");
        localbdwu.j = localJSONObject.optString("ctocSettingGuestUrl");
        localArrayList.add(localbdwu);
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public bdwu a(int paramInt1, int paramInt2, int paramInt3)
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
        bdwu localbdwu = (bdwu)localIterator.next();
        if ((localbdwu.a.equals(String.valueOf(paramInt1))) && (localbdwu.b.equals(String.valueOf(paramInt2))) && (localbdwu.c.equals(String.valueOf(paramInt3)))) {
          return localbdwu;
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
 * Qualified Name:     bdwt
 * JD-Core Version:    0.7.0.1
 */