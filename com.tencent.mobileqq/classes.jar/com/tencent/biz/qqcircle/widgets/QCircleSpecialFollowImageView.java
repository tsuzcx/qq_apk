package com.tencent.biz.qqcircle.widgets;

import aaak;
import aaam;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqcircle.events.QCircleSpecialFollowUpdateEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;

public class QCircleSpecialFollowImageView
  extends URLImageView
  implements aaam<QCircleSpecialFollowUpdateEvent>
{
  private FeedCloudMeta.StUser a;
  
  public QCircleSpecialFollowImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QCircleSpecialFollowImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QCircleSpecialFollowImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setBackgroundURL("https://sola.gtimg.cn/aoi/sola/20200707151832_UJpNKhUizA.png");
    setScaleType(ImageView.ScaleType.FIT_XY);
    setContentDescription("特别关注");
  }
  
  private void b()
  {
    if ((this.a != null) && (this.a.relationState.get() == 1)) {}
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      return;
    }
  }
  
  public ArrayList<Class<QCircleSpecialFollowUpdateEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleSpecialFollowUpdateEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!isInEditMode()) {
      aaak.a().a(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    aaak.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (this.a == null) {
      QLog.d("QCircleSpecialFollowIV", 4, "onReceiveEvent: null user");
    }
    do
    {
      return;
      if (!(paramSimpleBaseEvent instanceof QCircleSpecialFollowUpdateEvent))
      {
        QLog.d("QCircleSpecialFollowIV", 4, "onReceiveEvent: wrong event");
        return;
      }
      paramSimpleBaseEvent = (QCircleSpecialFollowUpdateEvent)paramSimpleBaseEvent;
      QLog.d("QCircleSpecialFollowIV", 4, "onReceiveEvent: " + this.a.id.get() + " " + paramSimpleBaseEvent);
    } while (!this.a.id.get().equals(paramSimpleBaseEvent.uin));
    PBUInt32Field localPBUInt32Field = this.a.relationState;
    if (paramSimpleBaseEvent.isFollow) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      b();
      return;
    }
  }
  
  public void setUser(FeedCloudMeta.StUser paramStUser)
  {
    this.a = paramStUser;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleSpecialFollowImageView
 * JD-Core Version:    0.7.0.1
 */