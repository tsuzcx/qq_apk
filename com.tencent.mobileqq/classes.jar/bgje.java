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

public class bgje
  extends bgit
{
  public static bgje a;
  private List<bgjf> a;
  
  static
  {
    jdField_a_of_type_Bgje = new bgje();
  }
  
  private ArrayList<bgjf> a()
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
        bgjf localbgjf = new bgjf();
        localbgjf.a = localJSONObject.optString("vipType");
        localbgjf.b = localJSONObject.optString("itemId");
        localbgjf.d = localJSONObject.optString("drawerUrl");
        localbgjf.e = localJSONObject.optString("VaProfileUrl");
        localbgjf.f = localJSONObject.optString("ctocUrl");
        localbgjf.c = localJSONObject.optString("nameplateType");
        localbgjf.g = localJSONObject.optString("VaProfileGuestUrl");
        localbgjf.h = localJSONObject.optString("ctocGuestUrl");
        localbgjf.i = localJSONObject.optString("ctocSettingUrl");
        localbgjf.j = localJSONObject.optString("ctocSettingGuestUrl");
        localArrayList.add(localbgjf);
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
  public bgjf a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    bgjf localbgjf;
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
      localbgjf = (bgjf)localIterator.next();
      if ((!localbgjf.a.equals(String.valueOf(paramInt1))) || (!localbgjf.c.equals(String.valueOf(paramInt3)))) {
        break label140;
      }
      if (localbgjf.b.equals(String.valueOf(paramInt2))) {
        return localbgjf;
      }
    }
    finally {}
    Object localObject3;
    if (localbgjf.b.equals("1000000")) {
      localObject3 = localbgjf;
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
 * Qualified Name:     bgje
 * JD-Core Version:    0.7.0.1
 */