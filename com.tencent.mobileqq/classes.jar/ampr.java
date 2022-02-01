import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class ampr
  implements amqs
{
  public static List<ampr> a;
  private int jdField_a_of_type_Int;
  private ampy jdField_a_of_type_Ampy;
  private AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new ampx(this);
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  static
  {
    jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  }
  
  public ampr(int paramInt1, int paramInt2, String arg3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    amrk localamrk = ampj.a(paramInt2);
    if (localamrk != null) {
      localamrk.b(0);
    }
    if ("effect".equals(???)) {
      if (localamrk != null) {
        this.jdField_a_of_type_Ampy = new ampy(paramInt2);
      }
    }
    for (;;)
    {
      if (jdField_a_of_type_JavaUtilList != null) {}
      synchronized (jdField_a_of_type_JavaUtilList)
      {
        jdField_a_of_type_JavaUtilList.add(this);
        this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio"));
        return;
        QLog.e("CmGameAudioPlayer", 1, "can not create pool");
        continue;
        this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        a(1);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(new amps(this));
      }
    }
  }
  
  private void a(amqr paramamqr, JSONObject paramJSONObject)
  {
    if (paramamqr != null) {
      paramamqr.a(paramJSONObject);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {}
    for (;;)
    {
      return;
      if (paramBoolean) {}
      for (int i = this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 2); QLog.isColorLevel(); i = this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener))
      {
        QLog.d("CmGameAudioPlayer", 2, new Object[] { "[execAudioFocus], requestFocus:", Boolean.valueOf(paramBoolean), ",ret:", Integer.valueOf(i) });
        return;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public int a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndSet(paramInt);
  }
  
  public String a()
  {
    try
    {
      MediaPlayer localMediaPlayer = this.jdField_a_of_type_AndroidMediaMediaPlayer;
      if (localMediaPlayer != null) {}
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
        if (this.jdField_a_of_type_Ampy != null)
        {
          this.jdField_a_of_type_Ampy.c();
          this.jdField_a_of_type_Ampy = null;
          return null;
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          QLog.e("CmGameAudioPlayer", 1, localThrowable1, new Object[0]);
        }
      }
      return null;
    }
    catch (Throwable localThrowable2)
    {
      QLog.e("CmGameAudioPlayer", 1, "audio destroy falied", localThrowable2);
    }
  }
  
  public JSONObject a(float paramFloat1, float paramFloat2, JSONObject paramJSONObject)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (a() != 9) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setVolume(paramFloat1, paramFloat2);
      }
    }
    else {
      return paramJSONObject;
    }
    QLog.e("CmGameAudioPlayer", 1, " volume in  state " + a());
    return paramJSONObject;
  }
  
  public JSONObject a(int paramInt, JSONObject paramJSONObject, amqr paramamqr)
  {
    int i;
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      i = a();
      if ((i != 3) && (i != 5) && (i != 7) && (i != 10)) {
        break label66;
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnSeekCompleteListener(new ampt(this, paramJSONObject, paramamqr));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(paramInt);
    }
    for (;;)
    {
      return null;
      label66:
      QLog.e("CmGameAudioPlayer", 1, " seek in  state " + i);
    }
  }
  
  public JSONObject a(amqr paramamqr, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        if (paramJSONObject.optInt("N_R_OBJ") == this.jdField_a_of_type_Int)
        {
          String str = paramJSONObject.optString("N_R_CMD");
          if ("cs.audio_play.local".equals(str)) {
            return b(paramJSONObject, paramamqr);
          }
          if ("cs.audio_autoplay.local".equals(str)) {
            return b(paramJSONObject.optBoolean("autoplay"), paramJSONObject);
          }
          if ("cs.audio_load.local".equals(str)) {
            return c(paramJSONObject, paramamqr);
          }
          if ("cs.audio_loop.local".equals(str)) {
            return a(paramJSONObject.optBoolean("loop"), paramJSONObject);
          }
          if ("cs.audio_muted.local".equals(str)) {
            return a(paramJSONObject.optBoolean("muted"), (float)paramJSONObject.optDouble("leftVolume"), (float)paramJSONObject.optDouble("rightVolume"), paramJSONObject);
          }
          if ("cs.audio_pause.local".equals(str)) {
            return b(paramJSONObject);
          }
          if ("cs.audio_seek.local".equals(str)) {
            return a(paramJSONObject.optInt("seek"), paramJSONObject, paramamqr);
          }
          if ("cs.audio_src.local".equals(str)) {
            return a(paramJSONObject.optString("src"), paramJSONObject, paramamqr);
          }
          if ("cs.audio_preload.local".equals(str)) {
            return c(paramJSONObject.optBoolean("preloaded"), paramJSONObject);
          }
          if ("cs.audio_volume.local".equals(str)) {
            return a((float)paramJSONObject.optDouble("leftVolume"), (float)paramJSONObject.optDouble("rightVolume"), paramJSONObject);
          }
          if ("cs.audio_destroy.local".equals(str)) {
            return b(paramamqr, paramJSONObject);
          }
          if ("cs.audio_onend.local".equals(str)) {
            return e(paramJSONObject, paramamqr);
          }
          if ("cs.audio_ontimeupdate.local".equals(str)) {
            return d(paramJSONObject);
          }
          if ("cs.audio_duration.local".equals(str)) {
            return c(paramJSONObject);
          }
          if ("cs.audio_effect_resume.local".equals(str)) {
            return f(paramJSONObject);
          }
          if ("cs.audio_stop.local".equals(str)) {
            return e(paramJSONObject);
          }
          if ("cs.audio_attribute_get.local".equals(str)) {
            return a(paramJSONObject);
          }
          if ("cs.audio_attribute_set.local".equals(str))
          {
            paramamqr = a(paramJSONObject, paramamqr);
            return paramamqr;
          }
        }
      }
      catch (Throwable paramamqr)
      {
        QLog.e("CmGameAudioPlayer", 1, "audio failed", paramamqr);
      }
    }
    return null;
  }
  
  public JSONObject a(String paramString, JSONObject paramJSONObject, amqr paramamqr)
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (a() != 6) && (a() != 9))
    {
      try
      {
        this.c = 0;
        amrk localamrk = ampj.a();
        if (localamrk != null)
        {
          String str2 = "";
          String str1 = str2;
          if (paramString != null)
          {
            str1 = str2;
            if (paramString.startsWith("GameSandBox://")) {
              str1 = "sandbox";
            }
          }
          if (URLUtil.isNetworkUrl(paramString)) {}
          for (;;)
          {
            this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
            a(1);
            if (TextUtils.isEmpty(paramString)) {
              break;
            }
            this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
            a(2);
            return paramJSONObject;
            paramString = amnl.a(paramString, localamrk.a(), str1, false);
          }
        }
        paramJSONObject.put("code", 2);
        paramJSONObject.put("message", "src not exist " + paramString);
        return paramJSONObject;
      }
      catch (Throwable paramString)
      {
        QLog.e("CmGameAudioPlayer", 1, paramString, new Object[0]);
        if (paramJSONObject == null) {
          return paramJSONObject;
        }
      }
      try
      {
        paramJSONObject.put("code", 1);
        paramJSONObject.put("message", "src error " + paramString.getMessage());
        a(paramamqr, paramJSONObject);
        return paramJSONObject;
      }
      catch (Throwable paramString)
      {
        QLog.e("CmGameAudioPlayer", 1, paramString, new Object[0]);
        return paramJSONObject;
      }
    }
    QLog.e("CmGameAudioPlayer", 1, " src in  state " + a());
    return paramJSONObject;
  }
  
  public JSONObject a(JSONObject paramJSONObject)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        if (paramJSONObject.has("duration")) {
          paramJSONObject.put("duration", this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration());
        }
        if (paramJSONObject.has("currentTime")) {
          paramJSONObject.put("currentTime", this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition());
        }
        if (paramJSONObject.has("paused")) {
          if (a() != 7) {
            break label89;
          }
        }
      }
      label89:
      for (boolean bool = true;; bool = false)
      {
        paramJSONObject.put("paused", bool);
        return paramJSONObject;
      }
      return paramJSONObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CmGameAudioPlayer", 1, localThrowable, new Object[0]);
    }
  }
  
  public JSONObject a(JSONObject paramJSONObject, amqr paramamqr)
  {
    try
    {
      if (paramJSONObject.has("src")) {
        a(paramJSONObject.optString("src"), paramJSONObject, paramamqr);
      }
      if (paramJSONObject.has("loop")) {
        a(paramJSONObject.optBoolean("loop"), paramJSONObject);
      }
      if (paramJSONObject.has("autoPlay")) {
        b(paramJSONObject.optBoolean("autoPlay"), paramJSONObject);
      }
      if (paramJSONObject.has("volume")) {
        a((float)paramJSONObject.optDouble("volume"), (float)paramJSONObject.optDouble("volume"), paramJSONObject);
      }
      if (paramJSONObject.has("muted")) {
        a(paramJSONObject.optBoolean("muted"), (float)paramJSONObject.optDouble("volume"), (float)paramJSONObject.optDouble("volume"), paramJSONObject);
      }
      if (paramJSONObject.has("currentTime")) {
        d(paramJSONObject, paramamqr);
      }
      return paramJSONObject;
    }
    catch (Throwable paramamqr)
    {
      QLog.e("CmGameAudioPlayer", 1, paramamqr, new Object[0]);
    }
    return paramJSONObject;
  }
  
  public JSONObject a(boolean paramBoolean, float paramFloat1, float paramFloat2, JSONObject paramJSONObject)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      if (paramBoolean) {
        localObject = a(0.0F, 0.0F, paramJSONObject);
      }
    }
    do
    {
      return localObject;
      return a(paramFloat1, paramFloat2, paramJSONObject);
      localObject = paramJSONObject;
    } while (this.jdField_a_of_type_Ampy == null);
    Object localObject = this.jdField_a_of_type_Ampy;
    if ((paramBoolean) || ((Float.compare(paramFloat1, 0.0F) == 0) && (Float.compare(paramFloat2, 0.0F) == 0))) {}
    for (int i = 0;; i = 1)
    {
      ((ampy)localObject).a(i, BaseActivity.sTopActivity.getAppInterface());
      return paramJSONObject;
    }
  }
  
  public JSONObject a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int i;
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      i = a();
      if ((i == 1) || (i == 2) || (i == 6) || (i == 3) || (i == 5) || (i == 7) || (i == 10)) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(paramBoolean);
      }
    }
    else
    {
      return paramJSONObject;
    }
    QLog.e("CmGameAudioPlayer", 1, " loop in  state " + i);
    return paramJSONObject;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public JSONObject b(amqr arg1, JSONObject paramJSONObject)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      if (this.jdField_a_of_type_Ampy != null) {
        this.jdField_a_of_type_Ampy.c();
      }
      a(8);
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      this.jdField_a_of_type_Ampy = null;
      if (??? != null) {
        ???.b(this);
      }
      if (jdField_a_of_type_JavaUtilList != null) {
        synchronized (jdField_a_of_type_JavaUtilList)
        {
          jdField_a_of_type_JavaUtilList.remove(this);
          return paramJSONObject;
        }
      }
      return paramJSONObject;
    }
    catch (Throwable ???)
    {
      QLog.e("CmGameAudioPlayer", 1, "destroy failed", ???);
    }
  }
  
  public JSONObject b(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
        {
          i = a();
          if ((i == 5) || (i == 7) || (i == 10))
          {
            this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
            a(7);
            a(false);
            return paramJSONObject;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("CmGameAudioPlayer", 1, " pause in  state " + a());
          continue;
        }
        if (this.jdField_a_of_type_Ampy == null) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("CmGameAudioPlayer", 1, "pause failed", localThrowable);
        return paramJSONObject;
      }
      int i = paramJSONObject.optInt("id");
      if (paramJSONObject.optBoolean("auto", true)) {
        this.jdField_a_of_type_Ampy.a();
      } else {
        this.jdField_a_of_type_Ampy.a(i, null);
      }
    }
  }
  
  public JSONObject b(JSONObject paramJSONObject, amqr paramamqr)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      i = a();
      if ((i == 3) || (i == 5) || (i == 7) || (i == 10))
      {
        a(true);
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {}
      }
    }
    while (this.jdField_a_of_type_Ampy == null) {
      for (;;)
      {
        int i;
        try
        {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
          a(5);
          if (this.c != 0) {
            this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(this.c);
          }
          this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new ampu(this));
        }
        catch (Throwable paramJSONObject)
        {
          QLog.e("CmGameAudioPlayer", 1, "audio play failed", paramJSONObject);
          continue;
        }
        return null;
        QLog.e("CmGameAudioPlayer", 1, " play in  state " + i);
      }
    }
    a(true);
    return this.jdField_a_of_type_Ampy.a(paramamqr, paramJSONObject);
  }
  
  public JSONObject b(boolean paramBoolean, JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return paramJSONObject;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public JSONObject c(JSONObject paramJSONObject)
  {
    int i;
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if ((a() == 1) && (a() == 2) && (a() == 9)) {
        break label69;
      }
      i = this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
      if (paramJSONObject == null) {}
    }
    try
    {
      paramJSONObject.put("duration", i);
      return paramJSONObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CmGameAudioPlayer", 1, localThrowable, new Object[0]);
      return paramJSONObject;
    }
    label69:
    QLog.e("CmGameAudioPlayer", 1, " duration in  state " + a());
    return paramJSONObject;
  }
  
  public JSONObject c(JSONObject paramJSONObject, amqr paramamqr)
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && ((a() == 2) || (a() == 6)))
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new ampv(this, paramJSONObject, paramamqr));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
    }
    return null;
  }
  
  public JSONObject c(boolean paramBoolean, JSONObject paramJSONObject)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return paramJSONObject;
  }
  
  public JSONObject d(JSONObject paramJSONObject)
  {
    int i;
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      i = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
    }
    try
    {
      paramJSONObject.put("currentTime", i);
      return paramJSONObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("CmGameAudioPlayer", 1, localThrowable, new Object[0]);
    }
    return paramJSONObject;
  }
  
  public JSONObject d(JSONObject paramJSONObject, amqr paramamqr)
  {
    int i;
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (a() != 9))
    {
      i = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
      if (paramJSONObject != null) {
        if (paramJSONObject.has("currentTime")) {
          this.c = paramJSONObject.optInt("currentTime");
        }
      }
    }
    try
    {
      paramJSONObject.put("currentTime", i);
      return paramJSONObject;
    }
    catch (Throwable paramamqr)
    {
      QLog.e("CmGameAudioPlayer", 1, paramamqr, new Object[0]);
    }
    return paramJSONObject;
  }
  
  public JSONObject e(JSONObject paramJSONObject)
  {
    if (this.jdField_a_of_type_Ampy != null)
    {
      this.jdField_a_of_type_Ampy.c(paramJSONObject.optInt("id"), null);
      this.jdField_a_of_type_Ampy.a(paramJSONObject);
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    }
    return paramJSONObject;
  }
  
  public JSONObject e(JSONObject paramJSONObject, amqr paramamqr)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new ampw(this, paramamqr, paramJSONObject));
    }
    return null;
  }
  
  public JSONObject f(JSONObject paramJSONObject)
  {
    if (this.jdField_a_of_type_Ampy != null)
    {
      if (paramJSONObject.optBoolean("audo", true)) {
        this.jdField_a_of_type_Ampy.b();
      }
    }
    else {
      return paramJSONObject;
    }
    this.jdField_a_of_type_Ampy.b(paramJSONObject.optInt("id"), null);
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ampr
 * JD-Core Version:    0.7.0.1
 */