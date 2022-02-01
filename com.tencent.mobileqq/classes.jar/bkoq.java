import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

class bkoq
  implements IActivityResultListener
{
  bkoq(bkom parambkom, IActivityResultManager paramIActivityResultManager) {}
  
  @SuppressLint({"NewApi"})
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 10020) {
      return false;
    }
    if (paramInt2 != -1)
    {
      bkom.a(this.jdField_a_of_type_Bkom, bkom.a(this.jdField_a_of_type_Bkom), "chooseVideo", null);
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager.removeActivityResultListener(this);
      return true;
    }
    Object localObject = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
    paramIntent = paramIntent.getStringExtra("take_photo_path");
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        paramIntent = new JSONObject();
        String str = ((PublishParam)localObject).j;
        l1 = new File(str).length();
        long l2 = ((PublishParam)localObject).jdField_a_of_type_Long;
        paramInt1 = ((PublishParam)localObject).jdField_a_of_type_Int;
        paramInt2 = ((PublishParam)localObject).b;
        localObject = ((PublishParam)localObject).c;
        paramIntent.put("tempFilePath", ((IMiniAppFileManager)bkom.a(this.jdField_a_of_type_Bkom).getManager(IMiniAppFileManager.class)).getWxFilePath(str));
        paramIntent.put("type", "video");
        paramIntent.put("size", l1);
        paramIntent.put("duration", l2);
        paramIntent.put("width", paramInt1);
        paramIntent.put("height", paramInt2);
        paramIntent.put("thumbTempFilePath", ((IMiniAppFileManager)bkom.a(this.jdField_a_of_type_Bkom).getManager(IMiniAppFileManager.class)).getWxFilePath((String)localObject));
        localObject = new JSONArray();
        ((JSONArray)localObject).put(paramIntent);
        paramIntent = new JSONObject();
        paramIntent.put("tempFiles", localObject);
        bkom.b(this.jdField_a_of_type_Bkom, bkom.a(this.jdField_a_of_type_Bkom), "chooseVideo", paramIntent);
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager.removeActivityResultListener(this);
        return true;
      }
      catch (Exception paramIntent)
      {
        QLog.e("MediaChooseJsProxyImpl", 1, "camera for video parse failed", paramIntent);
        bkom.a(this.jdField_a_of_type_Bkom, bkom.a(this.jdField_a_of_type_Bkom), "chooseVideo", null, "chooseMedia exception:" + paramIntent.getMessage());
        continue;
      }
      if (TextUtils.isEmpty(paramIntent)) {
        continue;
      }
      long l1 = new File(paramIntent).length();
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("tempFilePath", ((IMiniAppFileManager)bkom.a(this.jdField_a_of_type_Bkom).getManager(IMiniAppFileManager.class)).getWxFilePath(paramIntent));
        ((JSONObject)localObject).put("type", "image");
        ((JSONObject)localObject).put("size", l1);
        paramIntent = new JSONArray();
        paramIntent.put(localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("tempFiles", paramIntent);
        bkom.b(this.jdField_a_of_type_Bkom, bkom.a(this.jdField_a_of_type_Bkom), "chooseVideo", (JSONObject)localObject);
        bkom.a(this.jdField_a_of_type_Bkom, bkom.a(this.jdField_a_of_type_Bkom), "chooseVideo", null, "chooseMedia fail.");
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          QLog.e("MediaChooseJsProxyImpl", 1, "camera for image parse failed", paramIntent);
          bkom.a(this.jdField_a_of_type_Bkom, bkom.a(this.jdField_a_of_type_Bkom), "chooseVideo", null, "chooseMedia exception:" + paramIntent.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkoq
 * JD-Core Version:    0.7.0.1
 */