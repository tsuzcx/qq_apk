package com.tencent.biz.pubaccount.readinjoy.pts.ui;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAvatarView;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.view.IView;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/pts/ui/PTSRIJAvatarView;", "Lcom/tencent/biz/pubaccount/readinjoy/proteus/view/impl/NativeAvatarView;", "Lcom/tencent/pts/ui/view/IView;", "ptsNodeRijAvatar", "Lcom/tencent/biz/pubaccount/readinjoy/pts/ui/PTSNodeRIJAvatar;", "(Lcom/tencent/biz/pubaccount/readinjoy/pts/ui/PTSNodeRIJAvatar;)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onBindNodeInfo", "", "p0", "Lcom/tencent/pts/ui/PTSNodeInfo;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PTSRIJAvatarView
  extends NativeAvatarView
  implements IView
{
  public static final PTSRIJAvatarView.Companion Companion = new PTSRIJAvatarView.Companion(null);
  @NotNull
  public static final String TAG = "PTSRIJAvatarView";
  private HashMap _$_findViewCache;
  
  public PTSRIJAvatarView(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  public PTSRIJAvatarView(@NotNull PTSNodeRIJAvatar paramPTSNodeRIJAvatar)
  {
    this(paramPTSNodeRIJAvatar);
  }
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void onBindNodeInfo(@Nullable PTSNodeInfo paramPTSNodeInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSRIJAvatarView
 * JD-Core Version:    0.7.0.1
 */