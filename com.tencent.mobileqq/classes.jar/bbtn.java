import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bbtn
  extends bbtc
{
  public static final bbtn a;
  private List<bbto> a;
  
  static
  {
    jdField_a_of_type_Bbtn = new bbtn();
  }
  
  private ArrayList<bbto> a()
  {
    localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = new JSONObject(bbdx.b(new File(getSavePath(BaseApplicationImpl.getContext(), "namePlate_UrlConfig")))).getJSONArray("namePlateUrlConfig");
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        bbto localbbto = new bbto();
        localbbto.a = localJSONObject.optString("vipType");
        localbbto.b = localJSONObject.optString("itemId");
        localbbto.d = localJSONObject.optString("drawerUrl");
        localbbto.e = localJSONObject.optString("VaProfileUrl");
        localbbto.f = localJSONObject.optString("ctocUrl");
        localbbto.c = localJSONObject.optString("nameplateType");
        localbbto.g = localJSONObject.optString("VaProfileGuestUrl");
        localbbto.h = localJSONObject.optString("ctocGuestUrl");
        localbbto.i = localJSONObject.optString("ctocSettingUrl");
        localbbto.j = localJSONObject.optString("ctocSettingGuestUrl");
        localArrayList.add(localbbto);
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public bbto a(int paramInt1, int paramInt2, int paramInt3)
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
        bbto localbbto = (bbto)localIterator.next();
        if ((localbbto.a.equals(String.valueOf(paramInt1))) && (localbbto.b.equals(String.valueOf(paramInt2))) && (localbbto.c.equals(String.valueOf(paramInt3)))) {
          return localbbto;
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
 * Qualified Name:     bbtn
 * JD-Core Version:    0.7.0.1
 */