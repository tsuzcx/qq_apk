import com.tencent.mobileqq.apollo.ApolloResManager.ApolloDressInfo;
import com.tencent.mobileqq.apollo.data.ApolloDress.Dress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.filament.CmShowAssetsData;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class anju
{
  public static CmShowAssetsData a(ApolloResManager.ApolloDressInfo paramApolloDressInfo)
  {
    CmShowAssetsData localCmShowAssetsData = new CmShowAssetsData();
    Iterator localIterator = paramApolloDressInfo.a().entrySet().iterator();
    while (localIterator.hasNext())
    {
      ApolloDress.Dress localDress = (ApolloDress.Dress)((Map.Entry)localIterator.next()).getValue();
      String str = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/" + localDress.jdField_a_of_type_Int).getAbsolutePath();
      localCmShowAssetsData.dressResMap.put(localDress.jdField_a_of_type_JavaUtilArrayList.get(0), str);
      QLog.d("cm_res", 1, "part: " + (String)localDress.jdField_a_of_type_JavaUtilArrayList.get(0) + "; dir : " + str);
    }
    localCmShowAssetsData.roleResDir = paramApolloDressInfo.b();
    localCmShowAssetsData.faceDataJsonStr = paramApolloDressInfo.a();
    QLog.d("cm_res", 1, "roleResDir: " + localCmShowAssetsData.roleResDir);
    return localCmShowAssetsData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anju
 * JD-Core Version:    0.7.0.1
 */