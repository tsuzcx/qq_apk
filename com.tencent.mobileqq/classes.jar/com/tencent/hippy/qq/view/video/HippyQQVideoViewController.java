package com.tencent.hippy.qq.view.video;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideo;
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
    if (getVideoViewControlListener() != null)
    {
      if (getVideoViewControlListener().isFullScreen())
      {
        this.mHostView.exitFullScreen(1);
        getVideoViewControlListener().exitFullScreen(this.mHostView, null);
        return true;
      }
      return false;
    }
    return false;
  }
  
  public View createViewImpl(Context paramContext)
  {
    return null;
  }
  
  public View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    this.mHostView = new HippyQQVideoView(paramContext);
    this.mHostView.initView();
    if (paramHippyMap != null) {}
    label347:
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        paramContext = paramHippyMap.entrySet().iterator();
        paramHippyMap = VVideo.initDefaultVideoData();
        if (paramContext.hasNext())
        {
          localObject1 = (Map.Entry)paramContext.next();
          localObject2 = (String)((Map.Entry)localObject1).getKey();
          if ("src".equals(localObject2)) {
            if ((((Map.Entry)localObject1).getValue() instanceof String))
            {
              localObject2 = new JSONObject();
              this.mCurrentVideoUrl = ((String)((Map.Entry)localObject1).getValue());
              ((JSONObject)localObject2).put("videoUrl", ((Map.Entry)localObject1).getValue());
              paramHippyMap.put("video_info", localObject2);
              continue;
              return this.mHostView;
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      for (;;)
      {
        if (!(((Map.Entry)localObject1).getValue() instanceof HippyMap)) {
          break label347;
        }
        localObject1 = (HippyMap)((Map.Entry)localObject1).getValue();
        this.mCurrentVid = ((HippyMap)localObject1).getString("vid");
        paramHippyMap.put("video_info", ((HippyMap)localObject1).toJSONObject());
        break;
        if ("timeInterval".equals(localObject2))
        {
          paramHippyMap.put("timeupdateRate", ((Map.Entry)localObject1).getValue());
          break;
        }
        if ("autoPlay".equals(localObject2))
        {
          paramHippyMap.put("autoplay", ((Map.Entry)localObject1).getValue());
          break;
        }
        if ((((Map.Entry)localObject1).getValue() instanceof HippyMap))
        {
          paramHippyMap.put((String)localObject2, ((HippyMap)((Map.Entry)localObject1).getValue()).toJSONObject());
          break;
        }
        if ((((Map.Entry)localObject1).getValue() instanceof HippyArray))
        {
          paramHippyMap.put((String)localObject2, ((HippyArray)((Map.Entry)localObject1).getValue()).toJSONArray());
          break;
        }
        paramHippyMap.put((String)localObject2, ((Map.Entry)localObject1).getValue());
        break;
        this.mHostView.getVideoViewControlListener().open(this.mHostView, paramHippyMap);
      }
    }
  }
  
  public void dispatchFunction(HippyQQVideoView paramHippyQQVideoView, String paramString, HippyArray paramHippyArray)
  {
    if (getVideoViewControlListener() != null)
    {
      if (!"preplay".equals(paramString)) {
        break label27;
      }
      getVideoViewControlListener().preplay(paramHippyQQVideoView);
    }
    label27:
    do
    {
      return;
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
    } while (!"resetSrc".equals(paramString));
    resetSrc(paramHippyArray.getObject(0));
  }
  
  public void dispatchFunction(HippyQQVideoView paramHippyQQVideoView, String paramString, HippyArray paramHippyArray, Promise paramPromise)
  {
    if (getVideoViewControlListener() != null)
    {
      if (!"getPlayInfo".equals(paramString)) {
        break label29;
      }
      getVideoViewControlListener().getPlayInfo(paramHippyQQVideoView, paramPromise);
    }
    label29:
    do
    {
      return;
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
    } while (!"fullPortraitScreen".equals(paramString));
    dealFullScreen(0, true, paramPromise);
  }
  
  public HippyQQVideoView.OnVideoViewControlListener getVideoViewControlListener()
  {
    if ((this.mHostView != null) && (this.mHostView.getVideoViewControlListener() != null)) {
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
      JSONObject localJSONObject = initCurrentVideoData();
      try
      {
        Object localObject;
        if (((paramObject instanceof String)) && (!this.mCurrentVideoUrl.equals(paramObject)))
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("videoUrl", paramObject);
          localJSONObject.put("video_info", localObject);
          this.mCurrentVideoUrl = ((String)paramObject);
          getVideoViewControlListener().resetSrc(this.mHostView, localJSONObject);
          return;
        }
        if ((paramObject instanceof HippyMap))
        {
          paramObject = (HippyMap)paramObject;
          localObject = paramObject.getString("vid");
          if (!this.mCurrentVid.equals(localObject))
          {
            localJSONObject.put("video_info", paramObject.toJSONObject());
            this.mCurrentVid = ((String)localObject);
            getVideoViewControlListener().resetSrc(this.mHostView, localJSONObject);
            return;
          }
        }
      }
      catch (Exception paramObject)
      {
        ViolaLogUtils.e("HippyVideoController", "setSrc error :" + paramObject.getMessage());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.view.video.HippyQQVideoViewController
 * JD-Core Version:    0.7.0.1
 */