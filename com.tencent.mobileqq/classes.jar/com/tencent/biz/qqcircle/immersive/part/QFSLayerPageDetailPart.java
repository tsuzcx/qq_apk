package com.tencent.biz.qqcircle.immersive.part;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.fragments.content.QCircleContentModel;
import com.tencent.biz.qqcircle.immersive.adapter.QFSLayerPageAdapter;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSFeedIoc;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.qphone.base.util.QLog;

public class QFSLayerPageDetailPart
  extends QFSLayerBasePart
  implements IQFSFeedIoc
{
  private QCircleLayerBean h;
  private QCircleContentModel i;
  
  public QFSLayerPageDetailPart(QCircleLayerBean paramQCircleLayerBean)
  {
    this.h = paramQCircleLayerBean;
  }
  
  private void t()
  {
    this.i = new QCircleContentModel();
    this.i.e().observe(m(), new QFSLayerPageDetailPart.1(this));
  }
  
  public String a()
  {
    return "FSLayerPageDetailPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    t();
    this.b.a(this);
    this.a.setRefreshEnable(false);
    this.a.setLoadMoreEnable(false);
    a(false, false);
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    PartManager localPartManager = E();
    if (localPartManager == null)
    {
      QLog.d(a(), 1, "[onTabHandlerMessage] manager should not be null.");
      return;
    }
    if (TextUtils.equals(paramString, "event_open_comment"))
    {
      localPartManager.a("comment_panel_show", paramVarArgs[0]);
      return;
    }
    if (TextUtils.equals(paramString, "event_hide_comment"))
    {
      localPartManager.a("comment_panel_dismiss", null);
      return;
    }
    if (TextUtils.equals(paramString, "event_open_comment_input"))
    {
      localPartManager.a("comment_input_window_show", null);
      return;
    }
    if (TextUtils.equals(paramString, "event_open_share"))
    {
      localPartManager.a("share_action_show_share_sheet", paramVarArgs[0]);
      return;
    }
    if (TextUtils.equals(paramString, "event_open_friend_push_panel")) {
      localPartManager.a("light_interact_list_show", paramVarArgs[0]);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      QLog.d(a(), 1, "requestData  refresh");
      this.i.a(this.h, false);
    }
  }
  
  public int bk_()
  {
    return this.d;
  }
  
  public int bl_()
  {
    return 0;
  }
  
  public int d()
  {
    return 0;
  }
  
  public QCircleInitBean e()
  {
    return this.h;
  }
  
  public int f()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSLayerPageDetailPart
 * JD-Core Version:    0.7.0.1
 */