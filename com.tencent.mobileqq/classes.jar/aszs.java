import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.customized_interface.ActionCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.now.dynamic.NowEntry.2;
import com.tencent.mobileqq.intervideo.now.dynamic.NowEntry.3;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class aszs
{
  long jdField_a_of_type_Long = 0L;
  public asyp a;
  private aszq jdField_a_of_type_Aszq;
  ActionCallback jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceActionCallback = new aszu(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public aszs(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Asyp = aszx.a().a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private boolean a(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || (paramString.startsWith("//"));
  }
  
  private void c(Bundle paramBundle)
  {
    String str2 = paramBundle.getString("coverurl");
    String str1 = "";
    Object localObject2 = str1;
    if (!TextUtils.isEmpty(str2))
    {
      localObject2 = bame.a(str2);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = bame.a(str2 + "?busiType=3");
      }
      localObject2 = str1;
      if (localObject1 != null) {
        localObject2 = ((File)localObject1).getAbsolutePath();
      }
    }
    paramBundle.putString("cover_file", (String)localObject2);
    paramBundle.putString("appid", "2");
    paramBundle.putString("uid", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    paramBundle.putString("hostVersion", String.valueOf(aowf.a(BaseApplicationImpl.getContext())));
    Object localObject1 = Uri.parse(paramBundle.getString("mqqScheme", "")).getQuery();
    NowLive.doActionWithExtra((String)localObject1 + "&action=openroom", paramBundle, this.jdField_a_of_type_ComTencentIntervideoNowproxyCustomized_interfaceActionCallback);
  }
  
  public void a()
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      QLog.i("DynamicNow | NowEntry", 2, "API 16以下的系统，不支持预加载");
      return;
    }
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 60000L)
    {
      QLog.i("DynamicNow | NowEntry", 2, " 进房操作后一分钟之内不需要做预加载");
      return;
    }
    QLog.i("DynamicNow | NowEntry", 2, "开始预加载Now插件 time = " + System.currentTimeMillis());
    QLog.d("DynamicNow | NowEntry", 1, "preload Now");
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_cpu_64bit", false);
    NowLive.preload(localBundle);
  }
  
  public void a(Bundle paramBundle)
  {
    a(paramBundle, null);
  }
  
  public void a(Bundle paramBundle, aszq paramaszq)
  {
    this.jdField_a_of_type_Aszq = paramaszq;
    paramaszq = paramBundle.getString("mqqUrl", "");
    long l = System.currentTimeMillis();
    if ((l - this.jdField_a_of_type_Long < 1000L) && (!asys.c(paramBundle).equals("1")))
    {
      QLog.i("DynamicNow | NowEntry", 1, "开始处理mqq　scheme,time = " + System.currentTimeMillis() + " 点太快了");
      QQToast.a(BaseApplicationImpl.getContext(), alpo.a(2131708047), 0).a();
      return;
    }
    this.jdField_a_of_type_Long = l;
    QLog.i("DynamicNow | NowEntry", 1, "开始进入now结合版,time = " + System.currentTimeMillis() + " mqqScheme = " + paramaszq);
    paramBundle.putInt("action", 1);
    b(paramBundle);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void b(Bundle paramBundle)
  {
    Object localObject1 = asys.a(paramBundle);
    Object localObject2 = asys.b(paramBundle);
    long l = asys.a(paramBundle);
    this.jdField_a_of_type_Asyp.a(false, (String)localObject2, String.valueOf(l), (String)localObject1, false, false, true);
    paramBundle.putLong("entryTime", System.currentTimeMillis());
    localObject1 = paramBundle.getString("coverurl");
    localObject2 = (String)localObject1 + "?busiType=3";
    if ((a((String)localObject1)) || (bame.a((String)localObject1) != null) || (bame.a((String)localObject2) != null))
    {
      c(paramBundle);
      return;
    }
    localObject2 = new AtomicBoolean(false);
    l = System.currentTimeMillis();
    QLog.i("DynamicNow | NowEntry", 1, "start to download cover pic  url = " + (String)localObject1);
    localObject1 = URLDrawable.getDrawable((String)localObject1, URLDrawable.URLDrawableOptions.obtain());
    ((URLDrawable)localObject1).setURLDrawableListener(new aszt(this, l, (AtomicBoolean)localObject2, paramBundle));
    if (((URLDrawable)localObject1).getStatus() != 1)
    {
      ((AtomicBoolean)localObject2).set(false);
      ThreadManagerV2.excute(new NowEntry.2(this, (URLDrawable)localObject1), 128, null, false);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new NowEntry.3(this, (AtomicBoolean)localObject2, paramBundle), 500L);
      return;
    }
    QLog.i("DynamicNow | NowEntry", 1, "exception case!");
    ((AtomicBoolean)localObject2).set(true);
    c(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aszs
 * JD-Core Version:    0.7.0.1
 */