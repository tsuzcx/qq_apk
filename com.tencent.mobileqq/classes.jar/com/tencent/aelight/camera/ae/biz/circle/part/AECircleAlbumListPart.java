package com.tencent.aelight.camera.ae.biz.circle.part;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.biz.circle.AECircleAlbumListFragment;
import com.tencent.aelight.camera.ae.biz.circle.AECircleAlbumListFragment.IAlbumListBack;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleTitleAlbumMenuChangeEvent;
import com.tencent.aelight.camera.ae.biz.circle.part.base.AECircleBasePart;
import com.tencent.aelight.camera.ae.biz.circle.part.base.AECircleBasePartFragment;
import com.tencent.aelight.camera.ae.util.AEFastClickThrottle;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class AECircleAlbumListPart
  extends AECircleBasePart
  implements View.OnClickListener, AECircleAlbumListFragment.IAlbumListBack
{
  public AECircleAlbumListFragment a;
  public AsyncTask<Object, Object, List<LocalMediaInfo>> b;
  private FrameLayout f;
  private TextView g;
  private ImageView h;
  private LinearLayout i;
  private int j;
  private int k;
  private final String l = BaseApplication.getContext().getResources().getString(2131895879);
  
  public AECircleAlbumListPart(AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    super(paramAECirclePhotoListLogic);
    this.c.a(this);
  }
  
  private void c(boolean paramBoolean)
  {
    FragmentTransaction localFragmentTransaction = f().getFragmentManager().beginTransaction();
    localFragmentTransaction.setTransition(4097);
    if ((paramBoolean) && (!this.a.isAdded())) {
      localFragmentTransaction.add(2063990877, this.a, null);
    } else {
      localFragmentTransaction.remove(this.a);
    }
    localFragmentTransaction.addToBackStack(null);
    localFragmentTransaction.commit();
    SimpleEventBus.getInstance().dispatchEvent(new AECircleTitleAlbumMenuChangeEvent(paramBoolean));
  }
  
  private void d()
  {
    if (this.a == null)
    {
      this.a = new AECircleAlbumListFragment();
      this.a.a(this);
    }
  }
  
  private void d(boolean paramBoolean)
  {
    ObjectAnimator localObjectAnimator;
    if ((paramBoolean) && (!this.a.isAdded())) {
      localObjectAnimator = ObjectAnimator.ofInt(this.f, "backgroundColor", new int[] { this.k, this.j });
    } else {
      localObjectAnimator = ObjectAnimator.ofInt(this.f, "backgroundColor", new int[] { this.j, this.k });
    }
    localObjectAnimator.setDuration(300L);
    localObjectAnimator.setEvaluator(new ArgbEvaluator());
    localObjectAnimator.setRepeatMode(2);
    localObjectAnimator.start();
  }
  
  protected void a(View paramView)
  {
    this.f = ((FrameLayout)paramView.findViewById(2063990877));
    this.g = ((TextView)paramView.findViewById(2063991168));
    a(this.l);
    this.h = ((ImageView)paramView.findViewById(2063991167));
    this.i = ((LinearLayout)paramView.findViewById(2063991164));
    this.i.setOnClickListener(this);
    this.j = h().getResources().getColor(2131165806);
    this.k = h().getResources().getColor(2131165795);
  }
  
  public void a(QQAlbumInfo paramQQAlbumInfo, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAlbumListChoose--albumId=");
      localStringBuilder.append(paramQQAlbumInfo.id);
      AEQLog.b("AECircleAlbumListPart", localStringBuilder.toString());
      this.c.c.albumName = paramQQAlbumInfo.name;
      this.c.c.albumId = paramQQAlbumInfo.id;
      if (this.c.c.albumName != null) {
        paramQQAlbumInfo = this.c.c.albumName;
      } else {
        paramQQAlbumInfo = this.l;
      }
      a(paramQQAlbumInfo);
      this.d.y = true;
      g().runOnUiThread(new AECircleAlbumListPart.1(this));
    }
    a(false);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    g().setTitle(paramCharSequence);
    this.g.setText(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    d();
    c(paramBoolean);
    d(paramBoolean);
    b(paramBoolean ^ true);
    this.c.b(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = new AECircleAlbumListPart.QueryPhotoTask(this, paramBoolean1, paramBoolean2);
    this.b.execute(new Object[0]);
  }
  
  public void ak_()
  {
    a(false);
  }
  
  public String b()
  {
    return "AECircleAlbumListPart";
  }
  
  public void b(boolean paramBoolean)
  {
    float f1;
    if (paramBoolean) {
      f1 = 180.0F;
    } else {
      f1 = 0.0F;
    }
    float f2;
    if (paramBoolean) {
      f2 = 360.0F;
    } else {
      f2 = 180.0F;
    }
    RotateAnimation localRotateAnimation = new RotateAnimation(f1, f2, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(300L);
    localRotateAnimation.setFillAfter(true);
    this.h.startAnimation(localRotateAnimation);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    paramActivity = this.b;
    if (paramActivity != null) {
      paramActivity.cancel(true);
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    this.b = null;
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (this.d.G)
    {
      if (this.b == null) {
        a(true, true);
      }
    }
    else {
      this.d.G = true;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.c == null) {
      return;
    }
    if (paramView.getId() == 2063991164)
    {
      AEReportUtils.a(5, 2, this.c.i());
      if (AEFastClickThrottle.a(paramView)) {
        return;
      }
      paramView = this.a;
      boolean bool;
      if ((paramView != null) && (paramView.isAdded())) {
        bool = false;
      } else {
        bool = true;
      }
      if (bool) {
        this.c.a(g().getIntent());
      }
      a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECircleAlbumListPart
 * JD-Core Version:    0.7.0.1
 */