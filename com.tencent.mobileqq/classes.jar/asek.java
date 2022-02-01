import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class asek
{
  private static int jdField_a_of_type_Int = -1;
  private static asek jdField_a_of_type_Asek;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  public boha a;
  
  public asek()
  {
    this.jdField_a_of_type_Boha = new boha();
  }
  
  private int a()
  {
    Object localObject = (asen)a().getManager(QQManagerFactory.CAMERA_EMOTION_DB_MANAGER);
    if (jdField_a_of_type_Int == -1)
    {
      jdField_a_of_type_Int = 1;
      localObject = ((asen)localObject).a();
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
  
  public static asek a()
  {
    if (jdField_a_of_type_Asek == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Asek == null) {
        jdField_a_of_type_Asek = new asek();
      }
      return jdField_a_of_type_Asek;
    }
  }
  
  private CameraEmotionData a(String paramString1, String paramString2, String paramString3)
  {
    CameraEmotionData localCameraEmotionData = new CameraEmotionData();
    localCameraEmotionData.uin = a().getCurrentAccountUin();
    localCameraEmotionData.emoPath = paramString1;
    localCameraEmotionData.RomaingType = "needUpload";
    localCameraEmotionData.strContext = paramString2;
    localCameraEmotionData.templateId = paramString3;
    return localCameraEmotionData;
  }
  
  private CameraEmotionData a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    CameraEmotionData localCameraEmotionData = new CameraEmotionData();
    localCameraEmotionData.uin = a().getCurrentAccountUin();
    localCameraEmotionData.emoOriginalPath = paramString1;
    localCameraEmotionData.thumbPath = paramString3;
    localCameraEmotionData.RomaingType = "needUpload";
    localCameraEmotionData.strContext = paramString2;
    localCameraEmotionData.templateId = paramString4;
    return localCameraEmotionData;
  }
  
  public QQAppInterface a()
  {
    return (QQAppInterface)bofz.a();
  }
  
  public void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3)
  {
    Object localObject = a();
    if (localObject == null)
    {
      QLog.d("CameraEmoSendControl", 1, "app null");
      return;
    }
    asen localasen = (asen)((QQAppInterface)localObject).getManager(QQManagerFactory.CAMERA_EMOTION_DB_MANAGER);
    localObject = (anrf)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.CAMERA_EMOTICON_HANDLER);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList1.size())
    {
      CameraEmotionData localCameraEmotionData = a((String)paramArrayList1.get(i), (String)paramArrayList2.get(i), (String)paramArrayList3.get(i));
      localCameraEmotionData.emoId = a();
      localasen.c(localCameraEmotionData);
      localArrayList.add(localCameraEmotionData);
      i += 1;
    }
    ((anrf)localObject).notifyUI(4, true, null);
    if (QLog.isColorLevel()) {
      QLog.d("CameraEmoSendControl", 2, "doStep, insert completed");
    }
    this.jdField_a_of_type_Boha.a(String.valueOf(1011), new Object[] { localArrayList });
  }
  
  public void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3, ArrayList<String> paramArrayList4)
  {
    Object localObject = a();
    asen localasen = (asen)((QQAppInterface)localObject).getManager(QQManagerFactory.CAMERA_EMOTION_DB_MANAGER);
    localObject = (anrf)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.CAMERA_EMOTICON_HANDLER);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList1.size())
    {
      CameraEmotionData localCameraEmotionData = a((String)paramArrayList1.get(i), (String)paramArrayList2.get(i), (String)paramArrayList3.get(i), (String)paramArrayList4.get(i));
      localCameraEmotionData.emoId = a();
      localasen.c(localCameraEmotionData);
      localArrayList.add(localCameraEmotionData);
      i += 1;
    }
    ((anrf)localObject).notifyUI(4, true, null);
    if (QLog.isColorLevel()) {
      QLog.d("CameraEmoSendControl", 2, "doStep, insert completed");
    }
    this.jdField_a_of_type_Boha.a(String.valueOf(1011), new Object[] { localArrayList });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asek
 * JD-Core Version:    0.7.0.1
 */