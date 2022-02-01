import android.graphics.Bitmap;
import com.qflutter.qqface.data.QQFaceNativeData;
import com.qflutter.qqface.data.QQFaceParam;
import com.qflutter.qqface.loader.QQFaceInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public class aupd
  implements QQFaceInterface
{
  private aupf jdField_a_of_type_Aupf = new aupf(BaseApplicationImpl.getContext());
  private aupj jdField_a_of_type_Aupj = new aupe(this);
  
  public aupd()
  {
    this.jdField_a_of_type_Aupf.a(this.jdField_a_of_type_Aupj);
  }
  
  public void clearCache()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutterFace", 2, "clearCache");
    }
    this.jdField_a_of_type_Aupf.a();
  }
  
  public QQFaceNativeData getFaceData(QQFaceParam paramQQFaceParam)
  {
    paramQQFaceParam = new aupb(paramQQFaceParam.faceType, paramQQFaceParam.account, paramQQFaceParam.faceShape);
    paramQQFaceParam = this.jdField_a_of_type_Aupf.a(paramQQFaceParam);
    QQFaceNativeData localQQFaceNativeData = new QQFaceNativeData();
    localQQFaceNativeData.setBitmap((Bitmap)paramQQFaceParam.first);
    localQQFaceNativeData.isDefaultFace = ((Boolean)paramQQFaceParam.second).booleanValue();
    return localQQFaceNativeData;
  }
  
  public String getLibPath()
  {
    String str = auog.a("libqflutter-resource-loader.so");
    if (QLog.isColorLevel()) {
      QLog.d("QFlutterFace", 2, "getLibPath: " + str + ", isExist: " + FileUtil.isFileExists(str));
    }
    return str;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Aupf.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aupd
 * JD-Core Version:    0.7.0.1
 */