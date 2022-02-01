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

public class bppq
  extends bpli
  implements beuq
{
  public static boolean a;
  private float jdField_a_of_type_Float;
  private beuo jdField_a_of_type_Beuo;
  private bppb jdField_a_of_type_Bppb;
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private File jdField_a_of_type_JavaIoFile;
  private Class<? extends bppb> jdField_a_of_type_JavaLangClass;
  
  private MusicItemInfo a()
  {
    MusicItemInfo localMusicItemInfo = new MusicItemInfo();
    localMusicItemInfo.mMusicName = anzj.a(2131712130);
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
  
  private JSONObject a(bevm parambevm)
  {
    do
    {
      try
      {
        parambevm = new JSONObject(new String(parambevm.a));
        bevm localbevm = parambevm;
        localbevm = parambevm;
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.i("RecognitionManager", 2, "fetchResponseJson: invoked. info: responseJson = " + parambevm);
            localbevm = parambevm;
          }
          return localbevm;
        }
        catch (JSONException localJSONException2)
        {
          continue;
        }
        localJSONException1 = localJSONException1;
        parambevm = null;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RecognitionManager", 2, "fetchResponseJson: Failed. info: exception = ", localJSONException1);
    return parambevm;
  }
  
  private void a(bevm parambevm)
  {
    Object localObject = a(parambevm);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.e("RecognitionManager", 2, new Object[] { "resolveResponseData: Failed. info: responseJson = ", localObject });
      }
    }
    List localList;
    do
    {
      return;
      parambevm = a((JSONObject)localObject);
      localList = a((JSONObject)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("RecognitionManager", 2, "resolveResponseData: invoked. info: songMids = " + localList);
      }
      a((JSONObject)localObject);
      localObject = (QIMMusicConfigManager)bplq.a(2);
      if (localList.size() != 0) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = a();
    } while (!this.jdField_a_of_type_JavaLangClass.equals(this.jdField_a_of_type_Bppb.getClass()));
    d();
    return;
    ((QIMMusicConfigManager)localObject).a((String)localList.get(0), new bppr(this, parambevm));
  }
  
  private void a(byte[] paramArrayOfByte) {}
  
  private boolean a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("is_humming").equals("yes");
  }
  
  public void a()
  {
    this.jdField_a_of_type_Beuo = super.a().getNetEngine(0);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(bppb parambppb)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecognitionManager", 2, "registerObserver: invoked. info: observer = " + parambppb);
    }
    this.jdField_a_of_type_Bppb = parambppb;
  }
  
  public void a(File paramFile)
  {
    if (((paramFile == null) || (!paramFile.exists())) && (QLog.isColorLevel())) {
      QLog.e("RecognitionManager", 2, "setTargetAudioFile: invoked. info: audioFile = " + paramFile);
    }
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
  
  public void b() {}
  
  public void b(bppb parambppb)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecognitionManager", 2, "unregisterObserver: invoked. info: observer = " + parambppb);
    }
    this.jdField_a_of_type_Bppb = null;
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaLangClass = this.jdField_a_of_type_Bppb.getClass();
    try
    {
      byte[] arrayOfByte = bppc.a(this.jdField_a_of_type_JavaIoFile);
      return;
    }
    catch (Throwable localThrowable1)
    {
      do
      {
        try
        {
          arrayOfByte = new bppp().a(this.jdField_a_of_type_Float).a(arrayOfByte);
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
      QLog.i("RecognitionManager", 2, "notifyObserver: invoked. info: this.mHumObserver = " + this.jdField_a_of_type_Bppb);
    }
    if (this.jdField_a_of_type_Bppb != null) {
      this.jdField_a_of_type_Bppb.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    }
  }
  
  public void onResp(bevm parambevm)
  {
    if (parambevm != null)
    {
      if (parambevm.c != 200) {
        break label55;
      }
      a(parambevm);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RecognitionManager", 2, "onResp: invoked. info: resp.mHttpCode = " + parambevm.c);
      }
      return;
      label55:
      bjuh.a().a(anzj.a(2131712131) + parambevm.c);
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bppq
 * JD-Core Version:    0.7.0.1
 */