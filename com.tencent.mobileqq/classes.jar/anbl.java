import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class anbl
{
  private static int a;
  public static bhgj a;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_Bhgj = new bhgj();
  }
  
  private static int a()
  {
    Object localObject = (anbo)((QQAppInterface)bhfc.a()).getManager(333);
    if (jdField_a_of_type_Int == -1)
    {
      jdField_a_of_type_Int = 1;
      localObject = ((anbo)localObject).a();
      if (localObject != null)
      {
        i = 0;
        while (i < ((List)localObject).size())
        {
          int j = ((CameraEmotionData)((List)localObject).get(i)).emoId;
          if (jdField_a_of_type_Int < j) {
            jdField_a_of_type_Int = j;
          }
          i += 1;
        }
      }
    }
    int i = jdField_a_of_type_Int + 1;
    jdField_a_of_type_Int = i;
    return i;
  }
  
  private static CameraEmotionData a(String paramString1, String paramString2)
  {
    CameraEmotionData localCameraEmotionData = new CameraEmotionData();
    localCameraEmotionData.uin = bhfc.a().getCurrentAccountUin();
    localCameraEmotionData.emoPath = paramString1;
    localCameraEmotionData.RomaingType = "needUpload";
    localCameraEmotionData.strContext = paramString2;
    return localCameraEmotionData;
  }
  
  private static CameraEmotionData a(String paramString1, String paramString2, String paramString3)
  {
    CameraEmotionData localCameraEmotionData = new CameraEmotionData();
    localCameraEmotionData.uin = bhfc.a().getCurrentAccountUin();
    localCameraEmotionData.emoOriginalPath = paramString1;
    localCameraEmotionData.thumbPath = paramString3;
    localCameraEmotionData.RomaingType = "needUpload";
    localCameraEmotionData.strContext = paramString2;
    return localCameraEmotionData;
  }
  
  public static void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    Object localObject = (QQAppInterface)bhfc.a();
    if (localObject == null) {
      return;
    }
    anbo localanbo = (anbo)((QQAppInterface)localObject).getManager(333);
    localObject = (ajff)((QQAppInterface)localObject).a(160);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList1.size())
    {
      CameraEmotionData localCameraEmotionData = a((String)paramArrayList1.get(i), (String)paramArrayList2.get(i));
      localCameraEmotionData.emoId = a();
      localanbo.c(localCameraEmotionData);
      localArrayList.add(localCameraEmotionData);
      i += 1;
    }
    ((ajff)localObject).notifyUI(4, true, null);
    if (QLog.isColorLevel()) {
      QLog.d("CameraEmoSendControl", 2, "doStep, insert completed");
    }
    jdField_a_of_type_Bhgj.a(String.valueOf(1011), new Object[] { localArrayList });
  }
  
  public static void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3)
  {
    Object localObject = (QQAppInterface)bhfc.a();
    anbo localanbo = (anbo)((QQAppInterface)localObject).getManager(333);
    localObject = (ajff)((QQAppInterface)localObject).a(160);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList1.size())
    {
      CameraEmotionData localCameraEmotionData = a((String)paramArrayList1.get(i), (String)paramArrayList2.get(i), (String)paramArrayList3.get(i));
      localCameraEmotionData.emoId = a();
      localanbo.c(localCameraEmotionData);
      localArrayList.add(localCameraEmotionData);
      i += 1;
    }
    ((ajff)localObject).notifyUI(4, true, null);
    if (QLog.isColorLevel()) {
      QLog.d("CameraEmoSendControl", 2, "doStep, insert completed");
    }
    jdField_a_of_type_Bhgj.a(String.valueOf(1011), new Object[] { localArrayList });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anbl
 * JD-Core Version:    0.7.0.1
 */