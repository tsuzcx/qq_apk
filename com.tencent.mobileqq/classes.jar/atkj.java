import android.graphics.Bitmap;
import com.qflutter.qqface.data.QQFaceNativeData;
import com.qflutter.qqface.data.QQFaceParam;
import com.qflutter.qqface.loader.QQFaceInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public class atkj
  implements QQFaceInterface
{
  private atkl jdField_a_of_type_Atkl = new atkl(BaseApplicationImpl.getContext());
  private atko jdField_a_of_type_Atko = new atkk(this);
  
  public atkj()
  {
    this.jdField_a_of_type_Atkl.a(this.jdField_a_of_type_Atko);
  }
  
  public void clearCache()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutterFace", 2, "clearCache");
    }
    this.jdField_a_of_type_Atkl.a();
  }
  
  public QQFaceNativeData getFaceData(QQFaceParam paramQQFaceParam)
  {
    paramQQFaceParam = new atkh(paramQQFaceParam.faceType, paramQQFaceParam.account, paramQQFaceParam.faceShape);
    paramQQFaceParam = this.jdField_a_of_type_Atkl.a(paramQQFaceParam);
    QQFaceNativeData localQQFaceNativeData = new QQFaceNativeData();
    localQQFaceNativeData.setBitmap((Bitmap)paramQQFaceParam.first);
    localQQFaceNativeData.isDefaultFace = ((Boolean)paramQQFaceParam.second).booleanValue();
    return localQQFaceNativeData;
  }
  
  public String getLibPath()
  {
    String str = atjn.a("libqflutter-resource-loader.so");
    if (QLog.isColorLevel()) {
      QLog.d("QFlutterFace", 2, "getLibPath: " + str + ", isExist: " + FileUtil.isFileExists(str));
    }
    return str;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Atkl.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atkj
 * JD-Core Version:    0.7.0.1
 */