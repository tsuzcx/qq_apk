package com.tencent.biz.pubaccount.readinjoy.viola.videonew;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.VComponentAdapter.OnVideoViewMethodListener;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rys;
import ryu;

public class VVideo
  extends VComponentContainer<VVideoView>
{
  public static String TAG = "VVideo";
  private String mCurrentVid;
  private String mCurrentVideoUrl;
  private VComponentAdapter.OnVideoViewMethodListener mVideoViewMethodListener = new rys(this);
  
  public VVideo(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  private void dealFullScreen(boolean paramBoolean, String paramString)
  {
    ((VVideoView)getHostView()).a(0);
    getVideoViewControlListener().a((VVideoView)getHostView(), paramBoolean, paramString, this.mVideoViewMethodListener);
  }
  
  private void invokeJS(String paramString, Object paramObject)
  {
    ViolaBridgeManager.getInstance().callbackJavascript(this.mInstance.getInstanceId(), "kd-video", "callback", paramString, paramObject, true);
  }
  
  public void addEvent(String paramString)
  {
    if (("stateChange".equals(paramString)) || ("playTimeChange".equals(paramString)) || ("volumeChange".equals(paramString)) || ("didEnterFullScreen".equals(paramString)) || ("didExitFullScreen".equals(paramString)) || ("stateVisible".equals(paramString)) || ("stateHidden".equals(paramString)))
    {
      this.mAppendEvents.add(paramString);
      return;
    }
    super.addEvent(paramString);
  }
  
  public boolean consumeBackKeyEvent()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (getVideoViewControlListener() != null)
    {
      bool1 = bool2;
      if (getVideoViewControlListener().a())
      {
        ((VVideoView)getHostView()).b(1);
        getVideoViewControlListener().b((VVideoView)getHostView(), null, this.mVideoViewMethodListener);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void destroy()
  {
    super.destroy();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "destroy: " + this.mCurrentVid);
    }
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().q();
    }
  }
  
  @JSMethod
  public void exitFullScreen(String paramString)
  {
    if (getVideoViewControlListener() != null)
    {
      ((VVideoView)getHostView()).b(1);
      getVideoViewControlListener().b((VVideoView)getHostView(), paramString, this.mVideoViewMethodListener);
    }
  }
  
  @JSMethod
  public void fullLandspaceScreen(String paramString)
  {
    if (getVideoViewControlListener() != null) {
      dealFullScreen(false, paramString);
    }
  }
  
  @JSMethod
  public void fullPortraitScreen(String paramString)
  {
    if (getVideoViewControlListener() != null) {
      dealFullScreen(true, paramString);
    }
  }
  
  @JSMethod
  public void getPlayInfo(String paramString)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().a((VVideoView)getHostView(), paramString, this.mVideoViewMethodListener);
    }
  }
  
  public ryu getVideoViewControlListener()
  {
    if ((getHostView() != null) && (((VVideoView)getHostView()).a() != null)) {
      return ((VVideoView)getHostView()).a();
    }
    return null;
  }
  
  protected VVideoView initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VVideoView(paramContext, this);
    paramContext.a(this);
    if (getDomObject().getAttributes().containsKey("playerType")) {}
    for (int i = ((Integer)getDomObject().getAttributes().get("playerType")).intValue();; i = 0)
    {
      int j = 100;
      if (getDomObject().getAttributes().containsKey("videoScreenType")) {
        j = ((Integer)getDomObject().getAttributes().get("videoScreenType")).intValue();
      }
      paramContext.a(i, j);
      JSONObject localJSONObject;
      for (;;)
      {
        Map.Entry localEntry;
        Object localObject;
        try
        {
          if (getDomObject().getAttributes() != null)
          {
            Iterator localIterator = getDomObject().getAttributes().entrySet().iterator();
            localJSONObject = initDefaultVideoData();
            if (!localIterator.hasNext()) {
              break;
            }
            localEntry = (Map.Entry)localIterator.next();
            localObject = (String)localEntry.getKey();
            if (!"src".equals(localObject)) {
              break label280;
            }
            if ((localEntry.getValue() instanceof String))
            {
              localObject = new JSONObject();
              this.mCurrentVideoUrl = ((String)localEntry.getValue());
              ((JSONObject)localObject).put("videoUrl", localEntry.getValue());
              localJSONObject.put("video_info", localObject);
              continue;
            }
          }
          else
          {
            return paramContext;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        this.mCurrentVid = ((JSONObject)localEntry.getValue()).getString("vid");
        localJSONObject.put("video_info", localEntry.getValue());
        continue;
        label280:
        if ("timeInterval".equals(localObject)) {
          localJSONObject.put("timeupdateRate", localEntry.getValue());
        } else if ("autoPlay".equals(localObject)) {
          localJSONObject.put("autoplay", localEntry.getValue());
        } else {
          localJSONObject.put((String)localObject, localEntry.getValue());
        }
      }
      paramContext.a().a(paramContext, localJSONObject);
      return paramContext;
    }
  }
  
  public JSONObject initCurrentVideoData()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("muted", false);
      localJSONObject.put("autoplay", true);
      localJSONObject.put("resize", "contain");
      localJSONObject.put("controlType", 0);
      localJSONObject.put("timeupdateRate", 1000);
      localJSONObject.put("disableFullScreen", false);
      if (getDomObject().getAttributes().containsKey("muted")) {
        localJSONObject.put("muted", getDomObject().getAttributes().get("muted"));
      }
      if (getDomObject().getAttributes().containsKey("autoPlay")) {
        localJSONObject.put("autoplay", getDomObject().getAttributes().get("autoPlay"));
      }
      if (getDomObject().getAttributes().containsKey("resize")) {
        localJSONObject.put("resize", getDomObject().getAttributes().get("resize"));
      }
      if (getDomObject().getAttributes().containsKey("controlType")) {
        localJSONObject.put("controlType", getDomObject().getAttributes().get("controlType"));
      }
      if (getDomObject().getAttributes().containsKey("timeInterval")) {
        localJSONObject.put("timeupdateRate", getDomObject().getAttributes().get("timeInterval"));
      }
      if (getDomObject().getAttributes().containsKey("disableFullScreen")) {
        localJSONObject.put("disableFullScreen", getDomObject().getAttributes().get("disableFullScreen"));
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public JSONObject initDefaultVideoData()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("muted", false);
      localJSONObject.put("autoplay", true);
      localJSONObject.put("resize", "contain");
      localJSONObject.put("controlType", 0);
      localJSONObject.put("timeupdateRate", 1000);
      localJSONObject.put("disableFullScreen", false);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public void onActivityCreate()
  {
    super.onActivityCreate();
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().l();
    }
  }
  
  public void onActivityDestroy()
  {
    super.destroy();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onActivityDestroy: ");
    }
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().q();
    }
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().o();
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().n();
    }
  }
  
  public void onActivityStart()
  {
    super.onActivityStart();
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().m();
    }
  }
  
  public void onActivityStop()
  {
    super.onActivityStop();
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().p();
    }
  }
  
  @JSMethod
  public void pause()
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().c((VVideoView)getHostView());
    }
  }
  
  @JSMethod
  public void play()
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().b((VVideoView)getHostView());
    }
  }
  
  @JSMethod
  public void preplay()
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().a((VVideoView)getHostView());
    }
  }
  
  public void removedByJs()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "removedByJs: ");
    }
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().q();
    }
  }
  
  @JSMethod
  public void replay()
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().e((VVideoView)getHostView());
    }
  }
  
  @JSMethod
  public void resetSrc(Object paramObject)
  {
    if (getVideoViewControlListener() != null)
    {
      JSONObject localJSONObject1 = initCurrentVideoData();
      try
      {
        if (((paramObject instanceof String)) && (!this.mCurrentVideoUrl.equals(paramObject)))
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("videoUrl", paramObject);
          localJSONObject1.put("video_info", localJSONObject2);
          this.mCurrentVideoUrl = ((String)paramObject);
          getVideoViewControlListener().b((VVideoView)getHostView(), localJSONObject1);
          return;
        }
        if (((paramObject instanceof JSONObject)) && (!this.mCurrentVid.equals(((JSONObject)paramObject).getString("vid"))))
        {
          localJSONObject1.put("video_info", paramObject);
          this.mCurrentVid = ((JSONObject)paramObject).getString("vid");
          getVideoViewControlListener().b((VVideoView)getHostView(), localJSONObject1);
          return;
        }
      }
      catch (Exception paramObject)
      {
        ViolaLogUtils.e(TAG, "setSrc error :" + paramObject.getMessage());
      }
    }
  }
  
  @JSMethod
  public void seek(int paramInt)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().a((VVideoView)getHostView(), paramInt * 1000);
    }
  }
  
  @VComponentProp(name="autoplay")
  public void setAutoPlay(boolean paramBoolean)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().b((VVideoView)getHostView(), paramBoolean);
    }
  }
  
  @VComponentProp(name="controlType")
  public void setControltype(int paramInt)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().b((VVideoView)getHostView(), paramInt);
    }
  }
  
  @VComponentProp(name="disableFullScreen")
  public void setDisableFullScreen(boolean paramBoolean)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().c((VVideoView)getHostView(), paramBoolean);
    }
  }
  
  @VComponentProp(name="endWithLastFrame")
  public void setEndWithLastFrame(boolean paramBoolean)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().c_(paramBoolean);
    }
  }
  
  public void setHostLayoutParams(VVideoView paramVVideoView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (getHostView() == null) {
      super.setHostLayoutParams(paramVVideoView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    }
    while ((((VVideoView)getHostView()).a() != 1) && (((VVideoView)getHostView()).a() != 9)) {
      return;
    }
    super.setHostLayoutParams(paramVVideoView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  @JSMethod
  public void setLoopBack(boolean paramBoolean)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().b_(paramBoolean);
    }
  }
  
  @VComponentProp(name="muted")
  public void setMuted(boolean paramBoolean)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().a((VVideoView)getHostView(), paramBoolean);
    }
  }
  
  @VComponentProp(name="resize")
  public void setResize(String paramString)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().a((VVideoView)getHostView(), paramString);
    }
  }
  
  @VComponentProp(name="timeInterval")
  public void setTimeInterval(int paramInt)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().c((VVideoView)getHostView(), paramInt);
    }
  }
  
  @VComponentProp(name="start_position")
  public void setstartPosition(int paramInt)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().c(paramInt);
    }
  }
  
  @JSMethod
  public void stop()
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().d((VVideoView)getHostView());
    }
  }
  
  public void videoFireEvent(String paramString, Object paramObject)
  {
    if (!this.mAppendEvents.contains(paramString)) {
      return;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      if (getDomObject() != null)
      {
        String str = getDomObject().getRef();
        if (str != null) {
          localJSONArray.put(str);
        }
      }
      localJSONArray.put(paramString);
      fireEvent(paramString, localJSONArray, paramObject);
      return;
    }
    catch (Exception paramString)
    {
      ViolaLogUtils.e(TAG, "videoFireEvent error :" + paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideo
 * JD-Core Version:    0.7.0.1
 */