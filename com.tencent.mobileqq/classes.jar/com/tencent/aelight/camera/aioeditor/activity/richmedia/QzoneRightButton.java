package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPart;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.base.ToastUtil;
import com.tencent.util.LiuHaiUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.widget.QzoneGuideBubbleHelper;

public class QzoneRightButton
  extends EditVideoPart
{
  private QzEditVideoPartManager a;
  private Activity b;
  private View c;
  private View d;
  private View e;
  private boolean f;
  
  public QzoneRightButton(@NonNull QzEditVideoPartManager paramQzEditVideoPartManager, Activity paramActivity)
  {
    super(paramQzEditVideoPartManager);
    boolean bool = false;
    this.f = false;
    this.a = paramQzEditVideoPartManager;
    this.b = paramActivity;
    if (SlideShowPhotoListManager.a().e() == 22) {
      bool = true;
    }
    this.f = bool;
  }
  
  private void a(String paramString)
  {
    String str = s().getString(2131915001);
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    QZoneHelper.forwardOpenQzoneVip2(this.b, localUserInfo, paramString, QQStoryContext.a().h(), "", 1010, str, false);
  }
  
  private void c()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)d(2063991043);
    this.c = LayoutInflater.from(u()).inflate(2131628679, localRelativeLayout, false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(0, LiuHaiUtils.d, 0, 0);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(10);
    this.d = this.c.findViewById(2131443550);
    this.e = this.c.findViewById(2131443549);
    if (this.f)
    {
      this.d.setVisibility(8);
      this.e.setVisibility(8);
    }
    else
    {
      this.d.setOnClickListener(new QzoneRightButton.1(this));
      this.e.setOnClickListener(new QzoneRightButton.2(this));
    }
    localRelativeLayout.addView(this.c, localLayoutParams);
  }
  
  private void d()
  {
    DialogUtil.a(this.b, 230).setMessage(2131915135).setPositiveButton(2131914647, new QzoneRightButton.4(this)).setNegativeButton(2131916598, new QzoneRightButton.3(this)).show();
  }
  
  private void i()
  {
    DialogUtil.a(this.b, 230).setMessage(2131915136).setPositiveButton(2131914647, new QzoneRightButton.6(this)).setNegativeButton(2131888010, new QzoneRightButton.5(this)).show();
  }
  
  public void a()
  {
    super.a();
    c();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1010) && (paramInt2 == -1))
    {
      ToastUtil.a().a(2131914869);
      this.a.h = true;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 0)
    {
      if (paramInt != 11)
      {
        if (paramInt == 4) {
          break label43;
        }
        if ((paramInt != 5) && (paramInt != 6)) {
          return;
        }
      }
      paramObject = this.c;
      if (paramObject == null) {
        return;
      }
      paramObject.setVisibility(8);
      return;
    }
    label43:
    paramObject = this.c;
    if (paramObject != null) {
      paramObject.setVisibility(0);
    }
  }
  
  public void g()
  {
    super.g();
    QzoneGuideBubbleHelper.getInstance().dismissGuideBubble();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneRightButton
 * JD-Core Version:    0.7.0.1
 */