package com.tencent.biz.qqcircle.flutter.layer;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.beans.QCircleCommentInfo;
import com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart;
import com.tencent.biz.qqcircle.events.QCircleDanmakuEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleReportBean;

public class QCircleFlutterCommentLayer
  extends FrameLayout
{
  private QCircleCommentPanelPart a = null;
  
  public QCircleFlutterCommentLayer(@NonNull Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public QCircleFlutterCommentLayer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public QCircleFlutterCommentLayer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    LayoutInflater.from(getContext()).inflate(2131626823, this);
    setVisibility(8);
  }
  
  public void a()
  {
    QCircleCommentPanelPart localQCircleCommentPanelPart = this.a;
    if (localQCircleCommentPanelPart == null)
    {
      QLog.d("QCircleFlutterCommentLayer", 2, "[show] panel part is null.");
      return;
    }
    localQCircleCommentPanelPart.a("comment_panel_dismiss", null);
    this.a = null;
    QCircleFeedPicLoader.g().release();
  }
  
  public void a(Activity paramActivity, QCircleReportBean paramQCircleReportBean)
  {
    this.a = new QCircleCommentPanelPart();
    this.a.a(paramActivity);
    this.a.a(this);
    this.a.a(paramQCircleReportBean);
  }
  
  public void a(@NonNull QCircleCommentInfo paramQCircleCommentInfo)
  {
    if (this.a == null)
    {
      QLog.d("QCircleFlutterCommentLayer", 2, "[show] panel part is null.");
    }
    else
    {
      setVisibility(0);
      this.a.a("comment_panel_show", paramQCircleCommentInfo);
    }
    SimpleEventBus.getInstance().dispatchEvent(new QCircleDanmakuEvent(7, true));
  }
  
  public void b(@NonNull QCircleCommentInfo paramQCircleCommentInfo)
  {
    QCircleCommentPanelPart localQCircleCommentPanelPart = this.a;
    if (localQCircleCommentPanelPart == null)
    {
      QLog.d("QCircleFlutterCommentLayer", 2, "[show] panel part is null.");
      return;
    }
    localQCircleCommentPanelPart.a("comment_input_window_show", paramQCircleCommentInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.layer.QCircleFlutterCommentLayer
 * JD-Core Version:    0.7.0.1
 */