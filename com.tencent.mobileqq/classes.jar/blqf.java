import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class blqf
  extends bllx
  implements bapx
{
  public static boolean a;
  private float jdField_a_of_type_Float;
  private bapv jdField_a_of_type_Bapv;
  private blpq jdField_a_of_type_Blpq;
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private File jdField_a_of_type_JavaIoFile;
  private Class<? extends blpq> jdField_a_of_type_JavaLangClass;
  
  private MusicItemInfo a()
  {
    MusicItemInfo localMusicItemInfo = new MusicItemInfo();
    localMusicItemInfo.mMusicName = alpo.a(2131713630);
    localMusicItemInfo.mType = 7;
    return localMusicItemInfo;
  }
  
  private MusicItemInfo a(FlowMusic paramFlowMusic, String paramString)
  {
    boolean bool = true;
    String str1 = paramFlowMusic.songName;
    String str2 = paramFlowMusic.url;
    String str3 = paramFlowMusic.singerName;
    int i = paramFlowMusic.songId;
    String str4 = paramFlowMusic.songMid;
    int j = paramFlowMusic.tryBegin;
    int k = paramFlowMusic.tryEnd;
    int m = paramFlowMusic.duration;
    if ((paramFlowMusic.playable == 1) && (!TextUtils.isEmpty(paramFlowMusic.url))) {}
    for (;;)
    {
      paramFlowMusic = new MusicItemInfo(str1, str2, str3, i, str4, j, k, m, bool);
      if ((TextUtils.isEmpty(paramFlowMusic.mUrl)) && (QLog.isColorLevel())) {
        QLog.i("RecognitionManager", 2, "recognitionResultFromFlowMusic: invoked. info: recognitionItem.mUrl = " + paramFlowMusic.mUrl);
      }
      paramFlowMusic.mRecognitionOffset = Float.valueOf(paramString).floatValue();
      paramFlowMusic.musicStart = ((int)(paramFlowMusic.mRecognitionOffset * 1000.0F) + 500);
      paramFlowMusic.musicEnd = (paramFlowMusic.musicStart + 10000);
      paramFlowMusic.musicDuration = (paramFlowMusic.musicEnd + 10000);
      if (QLog.isColorLevel()) {
        QLog.i("RecognitionManager", 2, "recognitionResultFromFlowMusic: invoked. info: recognitionItem = " + paramFlowMusic);
      }
      return paramFlowMusic;
      bool = false;
    }
  }
  
  private String a(JSONObject paramJSONObject)
  {
    String str = "0";
    Object localObject = paramJSONObject.optJSONArray("results");
    paramJSONObject = str;
    if (localObject != null)
    {
      localObject = ((JSONArray)localObject).optJSONObject(0);
      paramJSONObject = str;
      if (localObject != null) {
        paramJSONObject = ((JSONObject)localObject).optString("offset");
      }
    }
    return paramJSONObject;
  }
  
  private List<String> a(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    paramJSONObject = paramJSONObject.optJSONArray("songlist");
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
        if (localJSONObject != null) {
          localArrayList.add(localJSONObject.optString("songmid"));
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private JSONObject a(baqw parambaqw)
  {
    do
    {
      try
      {
        parambaqw = new JSONObject(new String(parambaqw.jdField_a_of_type_ArrayOfByte));
        baqw localbaqw = parambaqw;
        localbaqw = parambaqw;
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.i("RecognitionManager", 2, "fetchResponseJson: invoked. info: responseJson = " + parambaqw);
            localbaqw = parambaqw;
          }
          return localbaqw;
        }
        catch (JSONException localJSONException2)
        {
          continue;
        }
        localJSONException1 = localJSONException1;
        parambaqw = null;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RecognitionManager", 2, "fetchResponseJson: Failed. info: exception = ", localJSONException1);
    return parambaqw;
  }
  
  private void a(baqw parambaqw)
  {
    Object localObject = a(parambaqw);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.e("RecognitionManager", 2, new Object[] { "resolveResponseData: Failed. info: responseJson = ", localObject });
      }
    }
    List localList;
    do
    {
      return;
      parambaqw = a((JSONObject)localObject);
      localList = a((JSONObject)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("RecognitionManager", 2, "resolveResponseData: invoked. info: songMids = " + localList);
      }
      a((JSONObject)localObject);
      localObject = (QIMMusicConfigManager)blmf.a(2);
      if (localList.size() != 0) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = a();
    } while (!this.jdField_a_of_type_JavaLangClass.equals(this.jdField_a_of_type_Blpq.getClass()));
    d();
    return;
    ((QIMMusicConfigManager)localObject).a((String)localList.get(0), new blqg(this, parambaqw));
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecognitionManager", 2, "requestRecognition: invoked. info: postBytes = " + paramArrayOfByte);
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return;
    }
    baps localbaps = new baps();
    localbaps.jdField_a_of_type_JavaLangString = ("http://c.y.qq.com/youtu/humming/search?sessionid=" + System.currentTimeMillis());
    localbaps.jdField_a_of_type_Int = 1;
    localbaps.e = 0;
    localbaps.jdField_a_of_type_Bapx = this;
    localbaps.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Bapv.a(localbaps);
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("is_humming").equals("yes");
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bapv = super.a().getNetEngine(0);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(blpq paramblpq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecognitionManager", 2, "registerObserver: invoked. info: observer = " + paramblpq);
    }
    this.jdField_a_of_type_Blpq = paramblpq;
  }
  
  public void a(File paramFile)
  {
    if (((paramFile == null) || (!paramFile.exists())) && (QLog.isColorLevel())) {
      QLog.e("RecognitionManager", 2, "setTargetAudioFile: invoked. info: audioFile = " + paramFile);
    }
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
  
  public void b() {}
  
  public void b(blpq paramblpq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecognitionManager", 2, "unregisterObserver: invoked. info: observer = " + paramblpq);
    }
    this.jdField_a_of_type_Blpq = null;
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaLangClass = this.jdField_a_of_type_Blpq.getClass();
    try
    {
      byte[] arrayOfByte = blpr.a(this.jdField_a_of_type_JavaIoFile);
      return;
    }
    catch (Throwable localThrowable1)
    {
      do
      {
        try
        {
          arrayOfByte = new blqe().a(this.jdField_a_of_type_Float).a(arrayOfByte);
          a(arrayOfByte);
          return;
        }
        catch (Throwable localThrowable2)
        {
          while (!QLog.isColorLevel()) {}
          QLog.e("RecognitionManager", 2, "performQQMusicInternalMethod: Failed. info: Failed to generate fingerprint. exception = ", localThrowable2);
        }
        localThrowable1 = localThrowable1;
      } while (!QLog.isColorLevel());
      QLog.e("RecognitionManager", 2, "performQQMusicInternalMethod: Failed. info: Failed to invoke HumUtils.fileToByte. exception = ", localThrowable1);
      return;
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecognitionManager", 2, "notifyObserver: invoked. info: this.mHumObserver = " + this.jdField_a_of_type_Blpq);
    }
    if (this.jdField_a_of_type_Blpq != null) {
      this.jdField_a_of_type_Blpq.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    }
  }
  
  public void onResp(baqw parambaqw)
  {
    if (parambaqw != null)
    {
      if (parambaqw.c != 200) {
        break label55;
      }
      a(parambaqw);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RecognitionManager", 2, "onResp: invoked. info: resp.mHttpCode = " + parambaqw.c);
      }
      return;
      label55:
      bfhq.a().a(alpo.a(2131713631) + parambaqw.c);
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqf
 * JD-Core Version:    0.7.0.1
 */