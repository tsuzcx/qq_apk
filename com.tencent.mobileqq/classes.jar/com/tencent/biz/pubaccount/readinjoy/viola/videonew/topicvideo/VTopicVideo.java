package com.tencent.biz.pubaccount.readinjoy.viola.videonew.topicvideo;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideoView;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.dispatch.IObserver;
import com.tencent.viola.core.dispatch.ViolaDispatchManager;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;
import uaf;
import uag;
import ubp;

public class VTopicVideo
  extends VVideo
{
  private static final int TOPIC_VIDEO_CONTROL_PAUSE = 3;
  private static final int TOPIC_VIDEO_CONTROL_PERPLAY = 1;
  private static final int TOPIC_VIDEO_CONTROL_PLAY = 2;
  private static final int TOPIC_VIDEO_CONTROL_REPLAY = 5;
  private static final int TOPIC_VIDEO_CONTROL_STOP = 4;
  private IObserver mVideoAppearEventObserver = new ubp(this);
  
  public VTopicVideo(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  public void destroy()
  {
    super.destroy();
    if (this.mVideoAppearEventObserver != null) {
      ViolaDispatchManager.getInstance().removeObserver("EVENT_NAME_COMPONENT_APPEAR", this.mVideoAppearEventObserver);
    }
  }
  
  public uag getVideoLifeCycleChangeListener()
  {
    if ((getHostView() != null) && (((VVideoView)getHostView()).a() != null)) {
      return ((VVideoView)getHostView()).a();
    }
    return null;
  }
  
  public VVideoView initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VVideoView(paramContext, this);
    paramContext.a(this);
    paramContext.a = 2;
    paramContext.a(0, 0, null, true);
    JSONObject localJSONObject;
    Map.Entry localEntry;
    String str;
    try
    {
      if (getDomObject().getAttributes() != null)
      {
        Iterator localIterator = getDomObject().getAttributes().entrySet().iterator();
        localJSONObject = initDefaultVideoData();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label207;
          }
          localEntry = (Map.Entry)localIterator.next();
          str = (String)localEntry.getKey();
          if (!"src".equals(str)) {
            break;
          }
          localJSONObject.put("video_info", localEntry.getValue());
        }
      }
      ViolaDispatchManager.getInstance().addObserver("EVENT_NAME_COMPONENT_APPEAR", this.mVideoAppearEventObserver);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    for (;;)
    {
      return paramContext;
      if ("timeInterval".equals(str))
      {
        localJSONObject.put("timeupdateRate", localEntry.getValue());
        break;
      }
      if ("autoPlay".equals(str))
      {
        localJSONObject.put("autoplay", localEntry.getValue());
        break;
      }
      localJSONObject.put(str, localEntry.getValue());
      break;
      label207:
      paramContext.a().a(paramContext, localJSONObject);
    }
  }
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
    if (this.mVideoAppearEventObserver != null) {
      ViolaDispatchManager.getInstance().removeObserver("EVENT_NAME_COMPONENT_APPEAR", this.mVideoAppearEventObserver);
    }
  }
  
  @VComponentProp(name="controlAction")
  public void setcontrolAction(int paramInt)
  {
    if (getVideoViewControlListener() != null)
    {
      if (paramInt != 1) {
        break label29;
      }
      getVideoViewControlListener().a((VVideoView)getHostView());
    }
    label29:
    do
    {
      return;
      if (paramInt == 2)
      {
        getVideoViewControlListener().b((VVideoView)getHostView());
        return;
      }
      if (paramInt == 3)
      {
        getVideoViewControlListener().c((VVideoView)getHostView());
        return;
      }
      if (paramInt == 4)
      {
        getVideoViewControlListener().d((VVideoView)getHostView());
        return;
      }
    } while (paramInt != 5);
    getVideoViewControlListener().e((VVideoView)getHostView());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.topicvideo.VTopicVideo
 * JD-Core Version:    0.7.0.1
 */