package com.tencent.biz.pubaccount.readinjoy.pts.ui;

import com.tencent.TMG.utils.QLog;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSValueConvertUtil;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/pts/ui/PTSNodeRIJAvatar;", "Lcom/tencent/pts/ui/vnode/PTSNodeVirtual;", "Lcom/tencent/biz/pubaccount/readinjoy/pts/ui/PTSRIJAvatarView;", "ptsAppInstance", "Lcom/tencent/pts/core/PTSAppInstance;", "(Lcom/tencent/pts/core/PTSAppInstance;)V", "liveRingUrl", "", "liveStatusUrl", "uin", "", "onParseValueFinished", "", "setAttribute", "", "key", "value", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PTSNodeRIJAvatar
  extends PTSNodeVirtual<PTSRIJAvatarView>
{
  public static final PTSNodeRIJAvatar.Companion Companion = new PTSNodeRIJAvatar.Companion(null);
  @NotNull
  public static final String TAG = "PTSNodeRIJAvatar";
  private String liveRingUrl = "";
  private String liveStatusUrl = "";
  private long uin;
  
  public PTSNodeRIJAvatar(@NotNull PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    PTSRIJAvatarView localPTSRIJAvatarView = (PTSRIJAvatarView)getView();
    if (localPTSRIJAvatarView != null) {
      localPTSRIJAvatarView.setLiveRingUrl(this.liveRingUrl);
    }
    localPTSRIJAvatarView = (PTSRIJAvatarView)getView();
    if (localPTSRIJAvatarView != null) {
      localPTSRIJAvatarView.setLiveStatusUrl(this.liveStatusUrl);
    }
    if (this.uin != 0L)
    {
      localPTSRIJAvatarView = (PTSRIJAvatarView)getView();
      if (localPTSRIJAvatarView != null) {
        localPTSRIJAvatarView.setUin(this.uin);
      }
    }
  }
  
  public boolean setAttribute(@Nullable String paramString, @Nullable Object paramObject)
  {
    QLog.i("PTSNodeRIJAvatar", 1, "[setAttribute], key = " + paramString + ", value = " + paramObject);
    boolean bool = super.setAttribute(paramString, paramObject);
    if (paramString == null) {}
    label104:
    do
    {
      do
      {
        return bool;
        switch (paramString.hashCode())
        {
        default: 
          return bool;
        }
      } while (!paramString.equals("data-live-ring-url"));
      paramString = PTSValueConvertUtil.getString(paramObject);
      if (paramString == null) {
        break;
      }
      this.liveRingUrl = paramString;
      return true;
    } while (!paramString.equals("data-live-status-url"));
    paramString = PTSValueConvertUtil.getString(paramObject);
    if (paramString != null) {}
    for (;;)
    {
      this.liveStatusUrl = paramString;
      return true;
      if (!paramString.equals("data-uin")) {
        break;
      }
      paramString = PTSValueConvertUtil.getString(paramObject);
      if (paramString != null)
      {
        paramString = StringsKt.toLongOrNull(paramString);
        if (paramString == null) {}
      }
      for (long l = paramString.longValue();; l = 0L)
      {
        this.uin = l;
        return true;
      }
      paramString = "";
      break label104;
      paramString = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSNodeRIJAvatar
 * JD-Core Version:    0.7.0.1
 */