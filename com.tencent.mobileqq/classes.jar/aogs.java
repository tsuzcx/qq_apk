import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class aogs
  implements FFmpegExecuteResponseCallback
{
  long jdField_a_of_type_Long;
  PublishVideoEntry jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  aogs(aogp paramaogp, PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = paramPublishVideoEntry;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SaveVideoActivity", 2, "VideoSaveAlumCallBack：onStart videoFinalPath= " + this.b);
    }
    SaveVideoActivity.a(true);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SaveVideoActivity", 2, "VideoSaveAlumCallBack|onSuccess videoFinalPath= " + this.b);
    }
    com.tencent.biz.qqstory.utils.FileUtils.a(BaseApplication.getContext(), new File(this.b));
    com.tencent.mobileqq.utils.FileUtils.d(new File(this.jdField_a_of_type_JavaLangString).getParent());
  }
  
  public void a(boolean paramBoolean)
  {
    double d = (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0D;
    if (QLog.isColorLevel()) {
      QLog.d("SaveVideoActivity", 2, "generate files|third step cost:" + d + ",videoFinalPath= " + this.b);
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("generate_video_cost", this.jdField_a_of_type_Aogp.a + "");
    ((HashMap)localObject).put("watermark_cost", d + "");
    StatisticCollector.a(BaseApplication.getContext()).a(null, "qq_ptv_save_time", true, 0L, 0L, (HashMap)localObject, null);
    com.tencent.mobileqq.utils.FileUtils.d(this.jdField_a_of_type_JavaLangString);
    SaveVideoActivity.a(false);
    if (aogp.a(this.jdField_a_of_type_Aogp).get() != null)
    {
      localObject = (Activity)aogp.a(this.jdField_a_of_type_Aogp).get();
      if (aogp.b(this.jdField_a_of_type_Aogp).get() != null) {
        SaveVideoActivity.a((AppInterface)aogp.b(this.jdField_a_of_type_Aogp).get(), this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
      }
      if (!paramBoolean) {
        break label288;
      }
    }
    label288:
    for (int i = aogp.b(this.jdField_a_of_type_Aogp, -1);; i = aogp.b(this.jdField_a_of_type_Aogp, 1))
    {
      ((Activity)localObject).getIntent().putExtra("save_video_path", aogp.a(this.jdField_a_of_type_Aogp));
      ((Activity)localObject).setResult(i, ((Activity)localObject).getIntent());
      ((Activity)localObject).finish();
      if (i == -1) {
        aogp.a(this.jdField_a_of_type_Aogp, aogp.a(this.jdField_a_of_type_Aogp));
      }
      return;
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SaveVideoActivity", 2, "generate files|third step fail:" + paramString + ",videoFinalPath= " + this.b);
    }
  }
  
  public void c(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aogs
 * JD-Core Version:    0.7.0.1
 */