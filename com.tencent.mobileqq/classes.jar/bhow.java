import android.os.Build;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QzoneHardwareRestriction;

public class bhow
{
  private static final int jdField_a_of_type_Int = QzoneConfig.getInstance().getConfig("QZoneSetting", "PictureViewerPhotoDanmakuCpuLevel", 1);
  private static bhow jdField_a_of_type_Bhow;
  private static final String jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "PictureViewerPhotoDanmakuBlackList", "");
  private static final int jdField_b_of_type_Int = QzoneConfig.getInstance().getConfig("QZoneSetting", "PictureViewerPhotoDanmakuMemoryLevel", 1);
  private long jdField_a_of_type_Long = -1L;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile String jdField_b_of_type_JavaLangString;
  
  public bhow()
  {
    if (this.jdField_a_of_type_Long == -1L) {
      this.jdField_a_of_type_Long = (QzoneHardwareRestriction.getTotalMem() / 1024L);
    }
  }
  
  public static bhow a()
  {
    if (jdField_a_of_type_Bhow == null) {}
    try
    {
      if (jdField_a_of_type_Bhow == null) {
        jdField_a_of_type_Bhow = new bhow();
      }
      return jdField_a_of_type_Bhow;
    }
    finally {}
  }
  
  private boolean a(String paramString)
  {
    try
    {
      String str = Build.MODEL;
      if ((str == null) || (str.length() == 0))
      {
        QZLog.i("PhotoDanmakuUtil", 1, "buildModel is empty, hide PhotoDanmaku .命中禁止大图浮层策略");
        return true;
      }
      if (QZLog.isColorLevel()) {
        QZLog.d("PhotoDanmakuUtil", 2, "buildModel is '" + str + "'");
      }
      if ((paramString == null) || (paramString.length() == 0)) {
        break label150;
      }
      str = "," + str + ",";
      if (("," + paramString + ",").contains(str))
      {
        QZLog.i("PhotoDanmakuUtil", 1, "命中禁止大图浮层策略");
        return true;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    return false;
    label150:
    return false;
  }
  
  public boolean a()
  {
    if ((jdField_a_of_type_JavaLangString != null) && (!jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))) {
      if (a(jdField_a_of_type_JavaLangString)) {
        break label64;
      }
    }
    label64:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
      if ((!this.jdField_a_of_type_Boolean) || (!QzoneHardwareRestriction.meetHardwareRestriction(jdField_b_of_type_Int, jdField_a_of_type_Int))) {
        break;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhow
 * JD-Core Version:    0.7.0.1
 */