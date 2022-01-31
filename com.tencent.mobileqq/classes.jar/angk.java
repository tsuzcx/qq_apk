import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.API.ArkAppMusicModule.1;
import com.tencent.mobileqq.ark.API.ArkAppMusicModule.2;
import com.tencent.mobileqq.ark.API.ArkAppMusicModule.3;
import com.tencent.mobileqq.ark.API.ArkAppMusicModule.4;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class angk
  extends anft
{
  private static angl jdField_a_of_type_Angl;
  public static final ArrayList<WeakReference<angk>> a;
  private static String e = "";
  protected SongInfo a;
  private WeakReference<angk> jdField_a_of_type_JavaLangRefWeakReference;
  protected long c = 0L;
  protected String d;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public angk(ark.Application paramApplication, long paramLong)
  {
    super(paramApplication, paramLong);
    jdField_a_of_type_Angl = new angl(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this);
    jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangRefWeakReference);
  }
  
  protected static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 5;
    case 0: 
      return 4;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    }
    return 0;
  }
  
  public static String a()
  {
    if (TextUtils.isEmpty(e)) {
      e = QQPlayerService.a(1, "ark.music.module");
    }
    return e;
  }
  
  public void Destruct()
  {
    QQPlayerService.c(jdField_a_of_type_Angl);
    jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaLangRefWeakReference);
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    super.Destruct();
  }
  
  public String GetTypeName()
  {
    return "QQMusic";
  }
  
  public boolean HasMenthod(String paramString)
  {
    if (paramString.equals("Play")) {}
    while ((paramString.equals("Stop")) || (paramString.equals("Pause")) || (paramString.equals("Resume")) || (paramString.equals("GetCurrentTime")) || (paramString.equals("GetDuration")) || (paramString.equals("GetState")) || (paramString.equals("GetCurrentSong")) || (paramString.equals("SetCallback")) || (paramString.equals("AttachEvent")) || (paramString.equals("DetachEvent"))) {
      return true;
    }
    return false;
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    double d2 = 0.0D;
    if ((QLog.isColorLevel()) && (!paramString.equals("GetCurrentTime")) && (!paramString.equals("GetDuration"))) {
      QLog.i("ark.music.module", 2, String.format("ArkAppMusicModule.invokeFunc.%s", new Object[] { paramString }));
    }
    if (paramString.equals("Play"))
    {
      QQPlayerService.a(null);
      a(paramArrayOfVariantWrapper);
      return true;
    }
    if (paramString.equals("Stop"))
    {
      ArkAppCenter.a().postToMainThread(new ArkAppMusicModule.2(this));
      return true;
    }
    if (paramString.equals("Pause"))
    {
      ArkAppCenter.a().postToMainThread(new ArkAppMusicModule.3(this));
      return true;
    }
    if (paramString.equals("Resume"))
    {
      ArkAppCenter.a().postToMainThread(new ArkAppMusicModule.4(this));
      return true;
    }
    double d1;
    if (paramString.equals("GetCurrentTime"))
    {
      if (QQPlayerService.a() != 2)
      {
        d1 = d2;
        if (QQPlayerService.a() != 3) {
          break label182;
        }
      }
      try
      {
        int i = QQPlayerService.f();
        d1 = i / 1000.0D;
      }
      catch (IllegalStateException paramString)
      {
        for (;;)
        {
          label182:
          QLog.d("ark.music.module", 2, new Object[] { "ArkAppMusicModule.invokeFunc.getCurrentPlayPosition.error", paramString.getMessage() });
          d1 = d2;
        }
      }
      paramVariantWrapper.SetDouble(d1);
      return true;
    }
    if (paramString.equals("GetDuration"))
    {
      paramVariantWrapper.SetDouble(QQPlayerService.d() / 1000.0D);
      return true;
    }
    if (paramString.equals("GetState"))
    {
      paramVariantWrapper.SetInt(a(QQPlayerService.a()));
      return true;
    }
    if (paramString.equals("GetCurrentSong"))
    {
      a(paramArrayOfVariantWrapper[0], QQPlayerService.b());
      return true;
    }
    if (paramString.equals("SetCallback"))
    {
      paramString = a(this.c);
      if (paramString != null) {
        paramString.Reset();
      }
      paramString = paramArrayOfVariantWrapper[0];
      if ((paramString == null) || (!paramString.IsFunction()))
      {
        this.c = 0L;
        return true;
      }
      this.c = a(paramString.Copy());
      QQPlayerService.b(jdField_a_of_type_Angl);
      QQPlayerService.a(null);
      return true;
    }
    if (paramString.equals("AttachEvent"))
    {
      paramString = paramArrayOfVariantWrapper[0];
      if ((paramString == null) || (!paramString.IsString()) || (!"State".equals(paramString.GetString()))) {
        return true;
      }
      paramString = a(this.c);
      if (paramString != null) {
        paramString.Reset();
      }
      paramString = paramArrayOfVariantWrapper[1];
      if ((paramString == null) || (!paramString.IsFunction()))
      {
        this.c = 0L;
        return true;
      }
      this.c = a(paramString.Copy());
      QQPlayerService.a(null);
      return true;
    }
    if (paramString.equals("DetachEvent"))
    {
      paramString = paramArrayOfVariantWrapper[0];
      if ((paramString == null) || (!paramString.IsString()) || (!"State".equals(paramString.GetString()))) {
        return true;
      }
      paramString = a(this.c);
      if (paramString != null) {
        paramString.Reset();
      }
      return true;
    }
    return false;
  }
  
  public void a(int paramInt)
  {
    if (this.c == 0L) {
      if (QLog.isColorLevel()) {
        QLog.d("ark.music.module", 2, "ArkAppMusicModule.callback.invalid");
      }
    }
    do
    {
      return;
      ark.VariantWrapper localVariantWrapper = b(this.c);
      SongInfo localSongInfo2 = QQPlayerService.b();
      SongInfo localSongInfo1 = localSongInfo2;
      if (localSongInfo2 == null) {
        localSongInfo1 = this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
      }
      a(localVariantWrapper, paramInt, localSongInfo1);
    } while (paramInt != 4);
    this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo = null;
  }
  
  public void a(ark.VariantWrapper paramVariantWrapper, int paramInt, SongInfo paramSongInfo)
  {
    if ((paramVariantWrapper == null) || (!paramVariantWrapper.IsFunction()) || (paramSongInfo == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("ark.music.module", 2, "ArkAppMusicModule.callback.invalid");
      }
    }
    do
    {
      return;
      paramInt = a(paramInt);
      if (paramInt != 5) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ark.music.module", 2, "ArkAppMusicModule.callback.state.invalid");
    return;
    ark.VariantWrapper localVariantWrapper1 = paramVariantWrapper.Create();
    if (QLog.isColorLevel()) {
      QLog.i("ark.music.module", 2, String.format(Locale.CHINA, "ArkAppMusicModule.callback.state: %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    localVariantWrapper1.SetInt(paramInt);
    ark.VariantWrapper localVariantWrapper2 = paramVariantWrapper.Create();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", paramSongInfo.jdField_b_of_type_JavaLangString);
      localJSONObject.put("title", paramSongInfo.c);
      localJSONObject.put("singer", paramSongInfo.h);
      localJSONObject.put("id", String.format(Locale.CHINA, "%d", new Object[] { Long.valueOf(paramSongInfo.a) }));
      localVariantWrapper2.SetTableAsJsonString(localJSONObject.toString());
      paramSongInfo = paramVariantWrapper.Create();
      paramVariantWrapper.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper1, localVariantWrapper2 }, paramSongInfo);
      localVariantWrapper2.Reset();
      localVariantWrapper1.Reset();
      paramSongInfo.Reset();
      return;
    }
    catch (JSONException paramSongInfo)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ark.music.module", 2, new Object[] { "ArkAppMusicModule.doCallback.1.json.", paramSongInfo.getMessage() });
        }
      }
    }
  }
  
  public void a(ark.VariantWrapper paramVariantWrapper, SongInfo paramSongInfo)
  {
    if ((paramVariantWrapper == null) || (!paramVariantWrapper.IsFunction())) {
      return;
    }
    ark.VariantWrapper localVariantWrapper1 = paramVariantWrapper.Create();
    ark.VariantWrapper localVariantWrapper2 = paramVariantWrapper.Create();
    JSONObject localJSONObject;
    if (paramSongInfo != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("url", paramSongInfo.jdField_b_of_type_JavaLangString);
      localJSONObject.put("title", paramSongInfo.c);
      localJSONObject.put("singer", paramSongInfo.h);
      localJSONObject.put("id", String.format(Locale.CHINA, "%d", new Object[] { Long.valueOf(paramSongInfo.a) }));
      localVariantWrapper2.SetTableAsJsonString(localJSONObject.toString());
      paramVariantWrapper.InvokeDefault(new ark.VariantWrapper[] { localVariantWrapper2 }, localVariantWrapper1);
      localVariantWrapper2.Reset();
      localVariantWrapper1.Reset();
      return;
    }
    catch (JSONException paramSongInfo)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ark.music.module", 2, new Object[] { "ArkAppMusicModule.doCallback.2.json.", paramSongInfo.getMessage() });
        }
      }
    }
  }
  
  public void a(SongInfo paramSongInfo) {}
  
  protected void a(ark.VariantWrapper[] paramArrayOfVariantWrapper)
  {
    if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 2)) {
      return;
    }
    SongInfo localSongInfo = new SongInfo();
    localSongInfo.jdField_b_of_type_Int = 4;
    localSongInfo.jdField_b_of_type_JavaLangString = paramArrayOfVariantWrapper[0].GetString();
    try
    {
      paramArrayOfVariantWrapper = new JSONObject(paramArrayOfVariantWrapper[1].GetTableAsJsonString());
      localSongInfo.f = paramArrayOfVariantWrapper.optString("url");
      localSongInfo.c = paramArrayOfVariantWrapper.optString("title");
      localSongInfo.h = paramArrayOfVariantWrapper.optString("singer");
      localSongInfo.a = paramArrayOfVariantWrapper.optLong("id");
      this.d = localSongInfo.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo = localSongInfo;
      ArkAppCenter.a().postToMainThread(new ArkAppMusicModule.1(this, localSongInfo));
      return;
    }
    catch (JSONException paramArrayOfVariantWrapper)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ark.music.module", 2, "QQMusic.Play parameter error: " + paramArrayOfVariantWrapper.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angk
 * JD-Core Version:    0.7.0.1
 */