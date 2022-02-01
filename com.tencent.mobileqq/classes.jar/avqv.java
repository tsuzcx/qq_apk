import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.Base64;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.WebRecordApiPlugin;
import com.tencent.mobileqq.jsp.WebRecordApiPlugin.AudioApiHelper.2;
import com.tencent.mobileqq.jsp.WebRecordApiPlugin.AudioUploadTask;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class avqv
  implements bgrf, bgub
{
  private double jdField_a_of_type_Double;
  int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler = new avqw(this, Looper.getMainLooper());
  private bgua jdField_a_of_type_Bgua;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public BaseActivity a;
  protected WebRecordApiPlugin.AudioUploadTask a;
  private QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private int b = 1;
  private int c = 60000;
  
  public avqv(WebRecordApiPlugin paramWebRecordApiPlugin, AppInterface paramAppInterface, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  private String a()
  {
    try
    {
      Thread.sleep(1L);
      long l = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date(l));
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  private String a(int paramInt, boolean paramBoolean)
  {
    String str1 = anhk.ba + "webrecord/";
    Object localObject = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebRecordApiPlugin", 2, "getTransferFilePath dir: " + str1);
      }
      String str2 = a();
      File localFile = new File(str1);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localObject = new File(str1 + str2 + (String)localObject);
      if ((paramBoolean) && (!((File)localObject).exists())) {}
      try
      {
        ((File)localObject).createNewFile();
        label163:
        if (QLog.isColorLevel()) {
          QLog.d("WebRecordApiPlugin", 2, "getTransferFilePath : " + ((File)localObject).getAbsoluteFile().toString());
        }
        return ((File)localObject).getAbsoluteFile().toString();
        localObject = ".amr";
        continue;
        localObject = ".slk";
      }
      catch (IOException localIOException)
      {
        break label163;
      }
    }
  }
  
  private int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void e(String paramString)
  {
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    if (((Time)localObject).hour < 3) {}
    String str;
    do
    {
      return;
      localObject = bgjb.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "LAST_DELETE_TIME");
      str = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
    } while ((localObject != null) && (str.equals(localObject)));
    ThreadManager.post(new WebRecordApiPlugin.AudioApiHelper.2(this, paramString), 8, null, false);
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderStart() is called");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 2000L);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':0,'recordID':'" + this.jdField_a_of_type_JavaLangString + "','msg':''}" });
    return 250;
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onBeginReceiveData() is called");
    }
    this.c -= 200;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16711687, this.c);
    return this.c + 200;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onInitSuccess() is called");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderVolumeStateChanged() is called");
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) || (paramInt1 == 0)) {
      this.b = paramInt1;
    }
    if ((paramInt2 > 0) && (paramInt2 * 1000 < this.c)) {
      this.c = (paramInt2 * 1000);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':-1,'recordID':'-1','msg':'is recording now'}" });
      return;
    }
    Object localObject = Environment.getExternalStorageDirectory();
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      paramInt1 = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (paramInt1 == 0)) {
        break label247;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        localObject = bgln.b();
        if ((new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1) && (localObject != null) && (localObject[1] > 2L))
        {
          if (AudioHelper.b(1))
          {
            this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':-1,'recordID':'-1','msg':'" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697666) + "," + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697667) + "'}" });
            return;
            paramInt1 = 0;
            break;
            label247:
            paramInt1 = 0;
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("WebRecordApiPlugin", 2, "startRecord() is called");
          }
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          }
          e(anhk.ba + "webrecord/");
          if (this.b == 0) {
            localObject = new QQRecorder.RecorderParam(bgrn.jdField_a_of_type_Int, 0, 0);
          }
          for (this.jdField_a_of_type_JavaLangString = a(2, true);; this.jdField_a_of_type_JavaLangString = a(25, true))
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a((QQRecorder.RecorderParam)localObject);
            if (QLog.isColorLevel()) {
              QLog.i("QQRecorder", 2, "path: " + this.jdField_a_of_type_JavaLangString);
            }
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
            bgkl.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, true);
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b(this.jdField_a_of_type_JavaLangString);
            c(0);
            return;
            localObject = new QQRecorder.RecorderParam(bgrn.b, 16000, 1);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':-1,'recordID':'-1','msg':'" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131717591) + "'}" });
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':-1,'recordID':'-1','msg':'" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694003) + "'}" });
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    c(paramString);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderNotReady() is called,path is:" + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':-1,'recordID':'-1','msg':'onRecorderNotReady is called'}" });
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderPrepare() is called");
    }
    paramRecorderParam = bgrn.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
    azte.a(paramString);
    azte.a(paramString, paramRecorderParam, paramRecorderParam.length);
    bgkl.b(2131230745, false);
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderEnd() is called");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    int i = b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "fateOfRecorder is:" + i);
    }
    byte[] arrayOfByte;
    Object localObject;
    if (i == 0)
    {
      azte.b(paramString);
      bgjb.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_JavaLangString, Double.toString(this.jdField_a_of_type_Double));
      arrayOfByte = bgmg.a(paramString);
      localObject = null;
      paramRecorderParam = (QQRecorder.RecorderParam)localObject;
      if (arrayOfByte == null) {}
    }
    try
    {
      paramRecorderParam = Base64.encodeToString(arrayOfByte, 0);
      localObject = paramRecorderParam;
      if (TextUtils.isEmpty(paramRecorderParam)) {
        localObject = "";
      }
      paramRecorderParam = new JSONObject();
      do
      {
        try
        {
          paramRecorderParam.put("code", 1);
          paramRecorderParam.put("recordID", paramString);
          paramRecorderParam.put("msg", localObject);
          paramString = paramRecorderParam.toString();
          if (QLog.isColorLevel()) {
            QLog.d("WebRecordApiPlugin", 2, "onRecorderEnd result=" + paramString);
          }
          this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { paramString });
          return;
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
          }
        }
      } while (i != 1);
      azte.a(paramString);
      return;
    }
    catch (Exception paramRecorderParam)
    {
      for (;;)
      {
        paramRecorderParam = (QQRecorder.RecorderParam)localObject;
      }
    }
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderError() is called");
    }
    azte.a(paramString1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':-1,'recordID':'-1','msg':'onRecorderError is called'}" });
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderSilceEnd() is called maxAmplitude=" + paramInt2);
    }
    azte.a(paramString, paramArrayOfByte, paramInt1);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    this.jdField_a_of_type_Double = paramDouble;
  }
  
  public void a(JSONArray paramJSONArray, String paramString1, String paramString2)
  {
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optString(i, "");
      File localFile = new File((String)localObject);
      String str = bgjb.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (String)localObject);
      long l;
      if ((localFile.exists()) && (!TextUtils.isEmpty(str)))
      {
        double d = Double.valueOf(str).doubleValue();
        localFile = new File((String)localObject);
        if (localFile.exists())
        {
          l = localFile.length();
          label97:
          localObject = new AudioInfo((String)localObject, (int)d, l);
          this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin$AudioUploadTask = new WebRecordApiPlugin.AudioUploadTask(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidOsHandler, paramString1, paramString2, (AudioInfo)localObject);
          ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin$AudioUploadTask, 5, null, true);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        l = 0L;
        break label97;
        this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':1,'recordID':'" + (String)localObject + "','msg':'record not found or its duration is 0'}" });
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a());
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b()) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(16711686)))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711688);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711686);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d("WebRecordApiPlugin", 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null)
      {
        Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(16711686);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 200L);
      }
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = new File(paramString);
    if ((((File)localObject).exists()) && (bgjb.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString) != null))
    {
      double d = Double.valueOf(bgjb.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString)).doubleValue();
      long l;
      if (((File)localObject).exists())
      {
        l = ((File)localObject).length();
        localObject = new AudioInfo(paramString, (int)d, l);
        if (this.jdField_a_of_type_Bgua != null) {
          break label196;
        }
        this.jdField_a_of_type_Bgua = new bgua(((AudioInfo)localObject).path, new Handler(), ((AudioInfo)localObject).getAudioType());
        this.jdField_a_of_type_Bgua.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        this.jdField_a_of_type_Bgua.b();
        this.jdField_a_of_type_Bgua.a(this);
        this.jdField_a_of_type_Bgua.b();
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.c(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':0,'recordID':'" + paramString + "'}" });
        return;
        l = 0L;
        break;
        label196:
        this.jdField_a_of_type_Bgua.c();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.c(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':3,'recordID':'" + paramString + "'}" });
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderAbnormal() is called");
    }
    this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':-1,'recordID':'-1','msg':'onRecorderAbnormal is called'}" });
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Bgua != null)
    {
      this.jdField_a_of_type_Bgua.e();
      this.jdField_a_of_type_Bgua = null;
      this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.c(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':2,'recordID':'" + paramString + "'}" });
    }
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onInitFailed() is called");
    }
    this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':-1,'recordID':'-1','msg':'onInitFailed is called'}" });
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_Bgua != null)
    {
      this.jdField_a_of_type_Bgua.d();
      this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.c(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':1,'recordID':'" + paramString + "'}" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqv
 * JD-Core Version:    0.7.0.1
 */