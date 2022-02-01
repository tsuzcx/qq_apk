import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bhch
  extends bhbw
{
  public static bhch a;
  private List<bhci> a;
  
  static
  {
    jdField_a_of_type_Bhch = new bhch();
  }
  
  private ArrayList<bhci> a()
  {
    localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = new JSONObject(a()).getJSONArray("namePlateUrlConfig");
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        bhci localbhci = new bhci();
        localbhci.a = localJSONObject.optString("vipType");
        localbhci.b = localJSONObject.optString("itemId");
        localbhci.d = localJSONObject.optString("drawerUrl");
        localbhci.e = localJSONObject.optString("VaProfileUrl");
        localbhci.f = localJSONObject.optString("ctocUrl");
        localbhci.c = localJSONObject.optString("nameplateType");
        localbhci.g = localJSONObject.optString("VaProfileGuestUrl");
        localbhci.h = localJSONObject.optString("ctocGuestUrl");
        localbhci.i = localJSONObject.optString("ctocSettingUrl");
        localbhci.j = localJSONObject.optString("ctocSettingGuestUrl");
        localArrayList.add(localbhci);
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
  public bhci a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    bhci localbhci;
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
      localbhci = (bhci)localIterator.next();
      if ((!localbhci.a.equals(String.valueOf(paramInt1))) || (!localbhci.c.equals(String.valueOf(paramInt3)))) {
        break label140;
      }
      if (localbhci.b.equals(String.valueOf(paramInt2))) {
        return localbhci;
      }
    }
    finally {}
    Object localObject3;
    if (localbhci.b.equals("1000000")) {
      localObject3 = localbhci;
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
      String str = bgmg.b(new File(getSavePath(BaseApplicationImpl.getContext(), "namePlate_UrlConfig")));
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
 * Qualified Name:     bhch
 * JD-Core Version:    0.7.0.1
 */