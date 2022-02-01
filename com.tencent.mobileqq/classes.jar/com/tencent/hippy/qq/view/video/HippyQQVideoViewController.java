package com.tencent.hippy.qq.view.video;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.kandian.biz.viola.video.VVideoInit;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@HippyController(name="tkdVideoView")
public class HippyQQVideoViewController
  extends HippyViewController<HippyQQVideoView>
{
  public static final String CLASS_NAME = "tkdVideoView";
  private static final String TAG = "HippyVideoController";
  private String mCurrentVid;
  private String mCurrentVideoUrl;
  private HippyQQVideoView mHostView;
  
  private void dealFullScreen(int paramInt, boolean paramBoolean, Promise paramPromise)
  {
    this.mHostView.enterFullScreen(0);
    getVideoViewControlListener().enterFullScreen(paramInt, this.mHostView, paramBoolean, paramPromise);
  }
  
  public boolean consumeBackKeyEvent()
  {
    Object localObject = getVideoViewControlListener();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (getVideoViewControlListener().isFullScreen())
      {
        localObject = this.mHostView;
        bool1 = true;
        ((HippyQQVideoView)localObject).exitFullScreen(1);
        getVideoViewControlListener().exitFullScreen(this.mHostView, null);
      }
    }
    return bool1;
  }
  
  protected View createViewImpl(Context paramContext)
  {
    return null;
  }
  
  protected View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    this.mHostView = new HippyQQVideoView(paramContext);
    this.mHostView.initView();
    if (paramHippyMap != null) {
      try
      {
        paramContext = paramHippyMap.entrySet().iterator();
        paramHippyMap = VVideoInit.a();
        while (paramContext.hasNext())
        {
          Object localObject1 = (Map.Entry)paramContext.next();
          Object localObject2 = (String)((Map.Entry)localObject1).getKey();
          if ("src".equals(localObject2))
          {
            boolean bool = ((Map.Entry)localObject1).getValue() instanceof String;
            if (bool)
            {
              localObject2 = new JSONObject();
              this.mCurrentVideoUrl = ((String)((Map.Entry)localObject1).getValue());
              ((JSONObject)localObject2).put("videoUrl", ((Map.Entry)localObject1).getValue());
              paramHippyMap.put("video_info", localObject2);
            }
            else if ((((Map.Entry)localObject1).getValue() instanceof HippyMap))
            {
              localObject1 = (HippyMap)((Map.Entry)localObject1).getValue();
              this.mCurrentVid = ((HippyMap)localObject1).getString("vid");
              paramHippyMap.put("video_info", ((HippyMap)localObject1).toJSONObject());
            }
          }
          else if ("timeInterval".equals(localObject2))
          {
            paramHippyMap.put("timeupdateRate", ((Map.Entry)localObject1).getValue());
          }
          else if ("autoPlay".equals(localObject2))
          {
            paramHippyMap.put("autoplay", ((Map.Entry)localObject1).getValue());
          }
          else if ((((Map.Entry)localObject1).getValue() instanceof HippyMap))
          {
            paramHippyMap.put((String)localObject2, ((HippyMap)((Map.Entry)localObject1).getValue()).toJSONObject());
          }
          else if ((((Map.Entry)localObject1).getValue() instanceof HippyArray))
          {
            paramHippyMap.put((String)localObject2, ((HippyArray)((Map.Entry)localObject1).getValue()).toJSONArray());
          }
          else
          {
            paramHippyMap.put((String)localObject2, ((Map.Entry)localObject1).getValue());
          }
        }
        this.mHostView.getVideoViewControlListener().open(this.mHostView, paramHippyMap);
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return this.mHostView;
  }
  
  public void dispatchFunction(HippyQQVideoView paramHippyQQVideoView, String paramString, HippyArray paramHippyArray)
  {
    if (getVideoViewControlListener() != null)
    {
      if ("preplay".equals(paramString))
      {
        getVideoViewControlListener().preplay(paramHippyQQVideoView);
        return;
      }
      if ("play".equals(paramString))
      {
        getVideoViewControlListener().play(paramHippyQQVideoView);
        return;
      }
      if ("pause".equals(paramString))
      {
        getVideoViewControlListener().pause(paramHippyQQVideoView);
        return;
      }
      if ("stop".equals(paramString))
      {
        getVideoViewControlListener().stop(paramHippyQQVideoView);
        return;
      }
      if ("replay".equals(paramString))
      {
        getVideoViewControlListener().replay(paramHippyQQVideoView);
        return;
      }
      if ("seek".equals(paramString))
      {
        getVideoViewControlListener().seek(paramHippyQQVideoView, paramHippyArray.getInt(0) * 1000);
        return;
      }
      if ("setLoopBack".equals(paramString))
      {
        getVideoViewControlListener().setLoopBack(paramHippyArray.getBoolean(0));
        return;
      }
      if ("resetSrc".equals(paramString)) {
        resetSrc(paramHippyArray.getObject(0));
      }
    }
  }
  
  public void dispatchFunction(HippyQQVideoView paramHippyQQVideoView, String paramString, HippyArray paramHippyArray, Promise paramPromise)
  {
    if (getVideoViewControlListener() != null)
    {
      if ("getPlayInfo".equals(paramString))
      {
        getVideoViewControlListener().getPlayInfo(paramHippyQQVideoView, paramPromise);
        return;
      }
      if ("exitFullScreen".equals(paramString))
      {
        paramHippyQQVideoView.exitFullScreen(1);
        getVideoViewControlListener().exitFullScreen(paramHippyQQVideoView, paramPromise);
        return;
      }
      if ("fullLandspaceScreen".equals(paramString))
      {
        dealFullScreen(0, false, paramPromise);
        return;
      }
      if ("fullLandspaceScreenWithType".equals(paramString))
      {
        dealFullScreen(paramHippyArray.getInt(0), false, paramPromise);
        return;
      }
      if ("fullPortraitScreen".equals(paramString)) {
        dealFullScreen(0, true, paramPromise);
      }
    }
  }
  
  public HippyQQVideoView.OnVideoViewControlListener getVideoViewControlListener()
  {
    HippyQQVideoView localHippyQQVideoView = this.mHostView;
    if ((localHippyQQVideoView != null) && (localHippyQQVideoView.getVideoViewControlListener() != null)) {
      return this.mHostView.getVideoViewControlListener();
    }
    return null;
  }
  
  public JSONObject initCurrentVideoData()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("muted", false);
      localJSONObject.put("autoplay", true);
      localJSONObject.put("resize", "contain");
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
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().onActivityCreate();
    }
  }
  
  public void onActivityDestroy()
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().onActivityDestroy();
    }
  }
  
  public void onActivityPause()
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().onActivityPause();
    }
  }
  
  public void onActivityResume()
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().onActivityResume();
    }
  }
  
  public void onActivityStart()
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().onActivityStart();
    }
  }
  
  public void onActivityStop()
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().onActivityStop();
    }
  }
  
  public void resetSrc(Object paramObject)
  {
    if (getVideoViewControlListener() != null)
    {
      Object localObject1 = initCurrentVideoData();
      try
      {
        boolean bool = paramObject instanceof String;
        Object localObject2;
        if ((bool) && (!this.mCurrentVideoUrl.equals(paramObject)))
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("videoUrl", paramObject);
          ((JSONObject)localObject1).put("video_info", localObject2);
          this.mCurrentVideoUrl = ((String)paramObject);
          getVideoViewControlListener().resetSrc(this.mHostView, (JSONObject)localObject1);
          return;
        }
        if ((paramObject instanceof HippyMap))
        {
          paramObject = (HippyMap)paramObject;
          localObject2 = paramObject.getString("vid");
          if (!this.mCurrentVid.equals(localObject2))
          {
            ((JSONObject)localObject1).put("video_info", paramObject.toJSONObject());
            this.mCurrentVid = ((String)localObject2);
            getVideoViewControlListener().resetSrc(this.mHostView, (JSONObject)localObject1);
            return;
          }
        }
      }
      catch (Exception paramObject)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setSrc error :");
        ((StringBuilder)localObject1).append(paramObject.getMessage());
        ViolaLogUtils.e("HippyVideoController", ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  @HippyControllerProps(defaultBoolean=true, defaultType="boolean", name="endWithLastFrame")
  public void setEndWithLastFrame(HippyQQVideoView paramHippyQQVideoView, boolean paramBoolean)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().setEndWithLastFrame(paramBoolean);
    }
  }
  
  @HippyControllerProps(defaultType="boolean", name="muted")
  public void setMuted(HippyQQVideoView paramHippyQQVideoView, boolean paramBoolean)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().setMuted(paramHippyQQVideoView, paramBoolean);
    }
  }
  
  @HippyControllerProps(defaultString="contain", defaultType="string", name="resize")
  public void setResize(HippyQQVideoView paramHippyQQVideoView, String paramString)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().setResize(paramHippyQQVideoView, paramString);
    }
  }
  
  @HippyControllerProps(defaultNumber=1000.0D, defaultType="number", name="timeInterval")
  public void setTimeInterval(HippyQQVideoView paramHippyQQVideoView, int paramInt)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().setTimeInterval(paramHippyQQVideoView, paramInt);
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="start_position")
  public void setstartPosition(HippyQQVideoView paramHippyQQVideoView, int paramInt)
  {
    if (getVideoViewControlListener() != null) {
      getVideoViewControlListener().setStartPosition(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.view.video.HippyQQVideoViewController
 * JD-Core Version:    0.7.0.1
 */