package com.tencent.biz.qqcircle.polylike;

import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.widgets.AnimationView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class QCirclePolyLikeFreeView
  extends QCirclePolyBaseLikeView
{
  public QCirclePolyLikeFreeView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void b()
  {
    if (getParentType() == 256)
    {
      if (this.i != null) {
        this.i.setVisibility(8);
      }
    }
    else if (this.i != null) {
      this.i.setVisibility(0);
    }
    if (this.f != null) {
      this.f.setVisibility(8);
    }
  }
  
  protected void a()
  {
    int[] arrayOfInt;
    Object localObject;
    if (this.a != null)
    {
      arrayOfInt = new int[2];
      this.a.getLocationOnScreen(arrayOfInt);
      localObject = getContext();
      getContext();
      ((Vibrator)((Context)localObject).getSystemService("vibrator")).vibrate(50L);
      if (this.k != null) {
        this.k.a(this.e);
      }
    }
    try
    {
      localObject = new QQCircleFeedBase.StLikeBusiData();
      ((QQCircleFeedBase.StLikeBusiData)localObject).mergeFrom(this.d.likeInfo.busiData.get().toByteArray());
      localObject = ((QQCircleFeedBase.StLikeBusiData)localObject).curPolyLikeInfo;
      this.j.a(this.d, this.e);
      this.j.a(this.e, this.a, 1, arrayOfInt, this.d, (QQCircleFeedBase.StPolyLike)localObject);
      return;
    }
    catch (Exception localException)
    {
      label136:
      break label136;
    }
    QLog.d("QCirclePolyLikeFreeView", 4, "click error");
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    super.bindData(paramObject, paramInt);
  }
  
  public int getLayoutId()
  {
    if (getParentType() == 256) {
      return 2131626914;
    }
    return 2131626913;
  }
  
  protected String getLogTag()
  {
    return "QCircleCommonPolyLikeView";
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    super.onInitView(paramContext, paramView);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.polylike.QCirclePolyLikeFreeView
 * JD-Core Version:    0.7.0.1
 */