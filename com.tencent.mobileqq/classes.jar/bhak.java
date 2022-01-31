import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.audiorecorder.LameMp3EncodeThread;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bhak
{
  public static final String a;
  private int jdField_a_of_type_Int = 500;
  private long jdField_a_of_type_Long;
  private final AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private final Handler jdField_a_of_type_AndroidOsHandler = new bhan(this);
  private bhal jdField_a_of_type_Bhal;
  private bham jdField_a_of_type_Bham;
  private bhao jdField_a_of_type_Bhao;
  private final LameMp3EncodeThread jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread = new LameMp3EncodeThread(this, this.jdField_a_of_type_AndroidOsHandler);
  private List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int = 30;
  private long jdField_b_of_type_Long;
  private int jdField_c_of_type_Int = 50;
  private long jdField_c_of_type_Long;
  
  static
  {
    jdField_a_of_type_JavaLangString = bhak.class.getName();
  }
  
  public bhak(Context paramContext)
  {
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
  }
  
  public static Message a(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = -10;
    localMessage.obj = paramString;
    return localMessage;
  }
  
  public static Message b(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = -11;
    localMessage.obj = paramString;
    return localMessage;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (l1 -= l2; localIterator.hasNext(); l1 -= ((Integer)localIterator.next()).intValue()) {}
    return l1;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.a();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(int paramInt)
  {
    b(paramInt);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.a(paramLong);
  }
  
  public void a(bhal parambhal)
  {
    this.jdField_a_of_type_Bhal = parambhal;
  }
  
  public void a(bham parambham)
  {
    this.jdField_a_of_type_Bham = parambham;
  }
  
  public void a(bhao parambhao)
  {
    this.jdField_a_of_type_Bhao = parambhao;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.a(paramString);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.b();
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.a();
  }
  
  public long b()
  {
    return new File(a()).length();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.b()) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.c();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.c(paramInt);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.b(paramString);
  }
  
  public int c()
  {
    return (int)(a() / 1000L);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.a()) {
      return;
    }
    if (c() < 1)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(a(AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getString(2131694398)));
      b();
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.a(true);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.d(paramInt);
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.c(paramString);
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.a()) {
      return;
    }
    int i = (int)(System.currentTimeMillis() - this.jdField_b_of_type_Long);
    if (i > 0) {
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(i));
    }
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.a(false);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.e(paramInt);
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QMLog.e(jdField_a_of_type_JavaLangString, "请先设置音频播放路径");
      return;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.d(paramString);
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.c();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.e()) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(105);
    }
  }
  
  public void e(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.d()) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(102);
    }
  }
  
  public void f(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.b(paramInt);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkRuntimeAudiorecorderLameMp3EncodeThread.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhak
 * JD-Core Version:    0.7.0.1
 */