import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class bncj
  implements xpb
{
  long jdField_a_of_type_Long;
  PublishVideoEntry jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  bncj(bncg parambncg, PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2)
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
    ((HashMap)localObject).put("generate_video_cost", this.jdField_a_of_type_Bncg.a + "");
    ((HashMap)localObject).put("watermark_cost", d + "");
    azmz.a(BaseApplication.getContext()).a(null, "qq_ptv_save_time", true, 0L, 0L, (HashMap)localObject, null);
    bdcs.d(this.jdField_a_of_type_JavaLangString);
    SaveVideoActivity.a(false);
    int i;
    Intent localIntent;
    if (bncg.a(this.jdField_a_of_type_Bncg).get() != null)
    {
      localObject = (Activity)bncg.a(this.jdField_a_of_type_Bncg).get();
      if (bncg.b(this.jdField_a_of_type_Bncg).get() != null) {
        SaveVideoActivity.a((AppInterface)bncg.b(this.jdField_a_of_type_Bncg).get(), this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry);
      }
      if (!paramBoolean) {
        break label340;
      }
      i = bncg.b(this.jdField_a_of_type_Bncg, -1);
      if (!bkwm.e(((Activity)localObject).getIntent())) {
        break label353;
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
    label340:
    label353:
    do
    {
      return;
      i = bncg.b(this.jdField_a_of_type_Bncg, 1);
      break;
      localIntent = ((Activity)localObject).getIntent();
      if (paramBoolean) {
        localIntent.putExtra("key_video_save_path", this.b);
      }
      ((Activity)localObject).setResult(i, ((Activity)localObject).getIntent());
      ((Activity)localObject).finish();
    } while (i != -1);
    bncg.a(this.jdField_a_of_type_Bncg, bncg.a(this.jdField_a_of_type_Bncg));
  }
  
  public void onProgress(String paramString) {}
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SaveVideoActivity", 2, "VideoSaveAlumCallBack：onStart videoFinalPath= " + this.b);
    }
    SaveVideoActivity.a(true);
  }
  
  public void onSuccess(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SaveVideoActivity", 2, "VideoSaveAlumCallBack|onSuccess videoFinalPath= " + this.b);
    }
    xmx.a(BaseApplication.getContext(), new File(this.b));
    bdcs.d(new File(this.jdField_a_of_type_JavaLangString).getParent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncj
 * JD-Core Version:    0.7.0.1
 */