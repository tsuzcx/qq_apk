import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class bpjn
  implements FFmpegExecuteResponseCallback
{
  long jdField_a_of_type_Long;
  PublishVideoEntry jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  bpjn(bpjk parambpjk, PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = paramPublishVideoEntry;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onFailure(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SaveVideoActivity", 2, "generate files|third step fail:" + paramString + ",videoFinalPath= " + this.b);
    }
  }
  
  public void onFinish(boolean paramBoolean)
  {
    double d = (System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000.0D;
    if (QLog.isColorLevel()) {
      QLog.d("SaveVideoActivity", 2, "generate files|third step cost:" + d + ",videoFinalPath= " + this.b);
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("generate_video_cost", this.jdField_a_of_type_Bpjk.a + "");
    ((HashMap)localObject).put("watermark_cost", d + "");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "qq_ptv_save_time", true, 0L, 0L, (HashMap)localObject, null);
    FileUtils.deleteFile(this.jdField_a_of_type_JavaLangString);
    int i;
    Intent localIntent;
    if (bpjk.a(this.jdField_a_of_type_Bpjk).get() != null)
    {
      localObject = (Activity)bpjk.a(this.jdField_a_of_type_Bpjk).get();
      if (bpjk.b(this.jdField_a_of_type_Bpjk).get() != null) {
        SaveVideoActivity.a((AppInterface)bpjk.b(this.jdField_a_of_type_Bpjk).get(), this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
      }
      if (!paramBoolean) {
        break label335;
      }
      i = bpjk.b(this.jdField_a_of_type_Bpjk, -1);
      if (!bnlb.e(((Activity)localObject).getIntent())) {
        break label348;
      }
      localIntent = new Intent();
      if (paramBoolean)
      {
        localIntent.setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
        localIntent.putExtra("file_path", this.b);
        localIntent.putExtra("video_thumb_path", this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.miniThumbPath);
        localIntent.putExtra("video_duration", this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDuration);
        localIntent.putExtra("is_video", true);
      }
      ((Activity)localObject).sendBroadcast(localIntent);
      ((Activity)localObject).setResult(i, ((Activity)localObject).getIntent());
      ((Activity)localObject).finish();
    }
    label335:
    label348:
    do
    {
      return;
      i = bpjk.b(this.jdField_a_of_type_Bpjk, 1);
      break;
      localIntent = ((Activity)localObject).getIntent();
      if (paramBoolean) {
        localIntent.putExtra("key_video_save_path", this.b);
      }
      ((Activity)localObject).setResult(i, ((Activity)localObject).getIntent());
      ((Activity)localObject).finish();
    } while (i != -1);
    bpjk.a(this.jdField_a_of_type_Bpjk, bpjk.a(this.jdField_a_of_type_Bpjk));
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SaveVideoActivity", 2, "VideoSaveAlumCallBack：onStart videoFinalPath= " + this.b);
    }
  }
  
  public void onSuccess(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SaveVideoActivity", 2, "VideoSaveAlumCallBack|onSuccess videoFinalPath= " + this.b);
    }
    zeb.a(BaseApplication.getContext(), new File(this.b));
    FileUtils.deleteFile(new File(this.jdField_a_of_type_JavaLangString).getParent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpjn
 * JD-Core Version:    0.7.0.1
 */