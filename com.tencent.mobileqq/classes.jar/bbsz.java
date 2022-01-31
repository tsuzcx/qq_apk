import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bbsz
  extends bbso
{
  public static final bbsz a;
  private List<bbta> a;
  
  static
  {
    jdField_a_of_type_Bbsz = new bbsz();
  }
  
  private ArrayList<bbta> a()
  {
    localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = new JSONObject(bbdj.b(new File(getSavePath(BaseApplicationImpl.getContext(), "namePlate_UrlConfig")))).getJSONArray("namePlateUrlConfig");
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        bbta localbbta = new bbta();
        localbbta.a = localJSONObject.optString("vipType");
        localbbta.b = localJSONObject.optString("itemId");
        localbbta.d = localJSONObject.optString("drawerUrl");
        localbbta.e = localJSONObject.optString("VaProfileUrl");
        localbbta.f = localJSONObject.optString("ctocUrl");
        localbbta.c = localJSONObject.optString("nameplateType");
        localbbta.g = localJSONObject.optString("VaProfileGuestUrl");
        localbbta.h = localJSONObject.optString("ctocGuestUrl");
        localbbta.i = localJSONObject.optString("ctocSettingUrl");
        localbbta.j = localJSONObject.optString("ctocSettingGuestUrl");
        localArrayList.add(localbbta);
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public bbta a(int paramInt1, int paramInt2, int paramInt3)
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
        bbta localbbta = (bbta)localIterator.next();
        if ((localbbta.a.equals(String.valueOf(paramInt1))) && (localbbta.b.equals(String.valueOf(paramInt2))) && (localbbta.c.equals(String.valueOf(paramInt3)))) {
          return localbbta;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbsz
 * JD-Core Version:    0.7.0.1
 */