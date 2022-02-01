import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bhrz
  extends bhro
{
  public static bhrz a;
  private List<bhsa> a;
  
  static
  {
    jdField_a_of_type_Bhrz = new bhrz();
  }
  
  private ArrayList<bhsa> a()
  {
    localArrayList = new ArrayList();
    try
    {
      Object localObject = a();
      if ((localObject == null) && (TextUtils.isEmpty((CharSequence)localObject))) {
        return localArrayList;
      }
      localObject = new JSONObject((String)localObject).getJSONArray("namePlateUrlConfig");
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        bhsa localbhsa = new bhsa();
        localbhsa.a = localJSONObject.optString("vipType");
        localbhsa.b = localJSONObject.optString("itemId");
        localbhsa.d = localJSONObject.optString("drawerUrl");
        localbhsa.e = localJSONObject.optString("VaProfileUrl");
        localbhsa.f = localJSONObject.optString("ctocUrl");
        localbhsa.c = localJSONObject.optString("nameplateType");
        localbhsa.g = localJSONObject.optString("VaProfileGuestUrl");
        localbhsa.h = localJSONObject.optString("ctocGuestUrl");
        localbhsa.i = localJSONObject.optString("ctocSettingUrl");
        localbhsa.j = localJSONObject.optString("ctocSettingGuestUrl");
        localArrayList.add(localbhsa);
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
  public bhsa a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    bhsa localbhsa;
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
      localbhsa = (bhsa)localIterator.next();
      if ((!localbhsa.a.equals(String.valueOf(paramInt1))) || (!localbhsa.c.equals(String.valueOf(paramInt3)))) {
        break label140;
      }
      if (localbhsa.b.equals(String.valueOf(paramInt2))) {
        return localbhsa;
      }
    }
    finally {}
    Object localObject3;
    if (localbhsa.b.equals("1000000")) {
      localObject3 = localbhsa;
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
      String str = FileUtils.readFileToString(new File(getSavePath(BaseApplicationImpl.getContext(), "namePlate_UrlConfig")));
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
 * Qualified Name:     bhrz
 * JD-Core Version:    0.7.0.1
 */