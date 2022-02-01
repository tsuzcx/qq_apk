import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ark.ark;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.gamecenter.data.QGameBusEvent;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.gamecenter.view.GameArkView;
import com.tencent.mobileqq.gamecenter.web.view.QQGamePubWebView;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class autb
  extends Observable
  implements Handler.Callback, Observer, zwr
{
  public static autb a;
  private int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(this);
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<GameArkView> jdField_a_of_type_MqqUtilWeakReference;
  private WeakReference<QQGamePubWebView> b;
  
  public static autb a()
  {
    if (jdField_a_of_type_Autb == null) {}
    try
    {
      if (jdField_a_of_type_Autb == null) {
        jdField_a_of_type_Autb = new autb();
      }
      return jdField_a_of_type_Autb;
    }
    finally {}
  }
  
  public static void b(int paramInt)
  {
    auue.a(paramInt);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      c();
      return;
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      d();
      return;
    }
    QLog.e("GameVideoManager", 2, "qgame_pub type no set");
  }
  
  private void g()
  {
    QLog.d("GameVideoManager", 4, "------>resumeFeedVideo");
  }
  
  public void a()
  {
    QLog.d("GameVideoManager", 4, "--->stopArkVideo viewId:" + this.jdField_a_of_type_JavaLangString);
    Object localObject;
    if (this.jdField_a_of_type_MqqUtilWeakReference != null)
    {
      localObject = (GameArkView)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if ((localObject != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        break label61;
      }
    }
    label61:
    while ((!((GameArkView)localObject).a()) || (!auue.a(((GameArkView)localObject).a()))) {
      return;
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("viewId", this.jdField_a_of_type_JavaLangString);
      ark.arkNotify("com.tencent.gamecenter.newvideo", "notift_ark_video_stop", ((JSONObject)localObject).toString(), "json");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    zwp.a().a(this);
    akwh.a().a("com.tencent.gamecenter.newvideo");
    akwh.a().addObserver(this);
  }
  
  public void a(GameArkView paramGameArkView)
  {
    if (paramGameArkView != null)
    {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramGameArkView);
      return;
    }
    this.jdField_a_of_type_MqqUtilWeakReference = null;
  }
  
  public void a(QQGamePubWebView paramQQGamePubWebView)
  {
    if (paramQQGamePubWebView != null) {
      this.b = new WeakReference(paramQQGamePubWebView);
    }
  }
  
  public void b()
  {
    QLog.d("GameVideoManager", 4, "--->playArkVideo viewId:" + this.jdField_a_of_type_JavaLangString);
    Object localObject;
    if (this.jdField_a_of_type_MqqUtilWeakReference != null)
    {
      localObject = (GameArkView)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if ((localObject != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        break label61;
      }
    }
    label61:
    while ((!((GameArkView)localObject).a()) || (!auue.a(((GameArkView)localObject).a()))) {
      return;
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("viewId", this.jdField_a_of_type_JavaLangString);
      ark.arkNotify("com.tencent.gamecenter.newvideo", "notift_ark_video_play", ((JSONObject)localObject).toString(), "json");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void c()
  {
    GameCenterVideoViewController localGameCenterVideoViewController = ausy.a().a();
    if (localGameCenterVideoViewController != null) {
      localGameCenterVideoViewController.i();
    }
  }
  
  public void d()
  {
    if (this.b != null)
    {
      QQGamePubWebView localQQGamePubWebView = (QQGamePubWebView)this.b.get();
      localQQGamePubWebView.getPluginEngine().a(localQQGamePubWebView.getUrl(), 8589934625L, null);
    }
  }
  
  public void e()
  {
    zwp.a().b(this);
    akwh.a().b("gc_ark_video_play");
    akwh.a().deleteObserver(this);
    this.b = null;
    this.jdField_a_of_type_MqqUtilWeakReference = null;
    jdField_a_of_type_Autb = null;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QGameBusEvent.class);
    return localArrayList;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QGameBusEvent)) {
      QLog.d("GameVideoManager", 4, "onReceiveEvent() called with: event = [" + ((QGameBusEvent)paramSimpleBaseEvent).eventType + "]");
    }
    switch (((QGameBusEvent)paramSimpleBaseEvent).eventType)
    {
    default: 
      return;
    case 4: 
      f();
      return;
    case 3: 
      g();
      return;
    case 2: 
    case 6: 
      a();
      return;
    }
    b();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    try
    {
      if ((paramObject instanceof akwj))
      {
        paramObservable = ((akwj)paramObject).jdField_a_of_type_JavaLangString;
        String str = ((akwj)paramObject).b;
        paramObject = ((akwj)paramObject).c;
        if ((!TextUtils.isEmpty(paramObservable)) && ("com.tencent.gamecenter.newvideo".equals(paramObservable)))
        {
          if (TextUtils.isEmpty(str)) {
            return;
          }
          if (("gc_ark_video_play".equals(str)) && (!TextUtils.isEmpty(paramObject)))
          {
            paramObject = new JSONObject(paramObject);
            paramObservable = paramObject.optString("videoUrl", "");
            paramObject = paramObject.optString("viewId", "");
            Log.d("GameVideoManager", "update videoUrl: " + paramObservable);
            Log.d("GameVideoManager", "update viewId: " + paramObject);
            this.jdField_a_of_type_JavaLangString = paramObject;
            f();
            return;
          }
        }
      }
    }
    catch (Throwable paramObservable)
    {
      paramObservable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     autb
 * JD-Core Version:    0.7.0.1
 */