package com.tencent.biz.pubaccount.readinjoy.pts.lite;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead;
import com.tencent.pts.core.itemview.PTSItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ptk;
import pxk;
import qnx;
import qny;
import qpf;
import qpg;
import qrb;
import snh;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/pts/lite/PTSLitePlayableCardView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/utils/IPlayableView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "componentLastRead", "Lcom/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentLastRead;", "currentDividerType", "", "currentShowLastRead", "", "dividerView", "Landroid/view/View;", "hasTraversed", "ptsItemView", "Lcom/tencent/pts/core/itemview/PTSItemView;", "getPtsItemView", "()Lcom/tencent/pts/core/itemview/PTSItemView;", "videoView", "Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/base/video/VideoView;", "destroy", "", "enumeratePtsItemView", "action", "getFirstVideoView", "viewGroup", "Landroid/view/ViewGroup;", "initUI", "pause", "start", "stop", "updateComponentLastRead", "readInJoyModel", "Lcom/tencent/biz/pubaccount/readinjoy/model/IReadInJoyModel;", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "updateDividerView", "dividerType", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PTSLitePlayableCardView
  extends LinearLayout
  implements ptk
{
  public static final qnx a;
  private int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private VideoView jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
  private ComponentLastRead jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead;
  @NotNull
  private final PTSItemView jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemView;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  static
  {
    jdField_a_of_type_Qnx = new qnx(null);
  }
  
  public PTSLitePlayableCardView(@NotNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemView = new PTSItemView(paramContext);
    this.jdField_a_of_type_AndroidViewView = new View(paramContext);
    d();
  }
  
  private final VideoView a(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof VideoView)) {
        return (VideoView)localView;
      }
      if ((localView instanceof ViewGroup)) {
        return a((ViewGroup)localView);
      }
      i += 1;
    }
    return null;
  }
  
  private final boolean a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView = a((ViewGroup)this);
      this.jdField_a_of_type_Boolean = true;
    }
    VideoView localVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoBaseVideoVideoView;
    if (localVideoView != null)
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 1: 
        return localVideoView.startPlay();
      case 2: 
        localVideoView.stop();
        return false;
      case 3: 
        localVideoView.pause();
        return false;
      }
      localVideoView.destroy();
      return false;
    }
    return false;
  }
  
  private final void d()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-1, 1);
    localMarginLayoutParams.leftMargin = qpf.a.b();
    localMarginLayoutParams.rightMargin = qpf.a.b();
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localMarginLayoutParams);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1710619);
    setOrientation(1);
    addView((View)this.jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemView);
    addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  @NotNull
  public final PTSItemView a()
  {
    return this.jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemView;
  }
  
  public void a()
  {
    a(2);
  }
  
  public final void a(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      return;
      if (localLayoutParams != null) {
        localLayoutParams.height = 1;
      }
      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
      {
        ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = qpf.a.b();
        ((ViewGroup.MarginLayoutParams)localLayoutParams).rightMargin = qpf.a.b();
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1710619);
      continue;
      if (localLayoutParams != null) {
        localLayoutParams.height = qpf.a.a();
      }
      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
      {
        ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = 0;
        ((ViewGroup.MarginLayoutParams)localLayoutParams).rightMargin = 0;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-855310);
      continue;
      if (localLayoutParams != null) {
        localLayoutParams.height = 1;
      }
      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
      {
        ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = qpf.a.c();
        ((ViewGroup.MarginLayoutParams)localLayoutParams).rightMargin = qpf.a.c();
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1710619);
      continue;
      if (localLayoutParams != null) {
        localLayoutParams.height = 0;
      }
    }
  }
  
  public final void a(@NotNull pxk parampxk, @NotNull snh paramsnh)
  {
    Intrinsics.checkParameterIsNotNull(parampxk, "readInJoyModel");
    Intrinsics.checkParameterIsNotNull(paramsnh, "adapter");
    boolean bool = parampxk.g();
    if (this.b == bool) {}
    do
    {
      do
      {
        return;
        this.b = bool;
        if (!bool) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead == null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead = new ComponentLastRead(getContext());
          localObject = new LinearLayout.LayoutParams(-2, -2);
          addView((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead, (ViewGroup.LayoutParams)localObject);
        }
        Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead;
        if (localObject != null) {
          ((ComponentLastRead)localObject).setVisibility(0);
        }
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead;
        if (localObject != null) {
          ((ComponentLastRead)localObject).a(parampxk);
        }
        parampxk = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead;
      } while (parampxk == null);
      parampxk.a((qrb)new qny(paramsnh));
      return;
      parampxk = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead;
    } while (parampxk == null);
    parampxk.setVisibility(8);
  }
  
  public boolean a()
  {
    return a(1);
  }
  
  public void b()
  {
    a(3);
  }
  
  public void c()
  {
    a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLitePlayableCardView
 * JD-Core Version:    0.7.0.1
 */