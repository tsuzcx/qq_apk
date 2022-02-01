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
  private int jdField_a_of_type_Int;
  public AsyncTask<Object, Object, List<LocalMediaInfo>> a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AECircleAlbumListFragment a;
  private final String jdField_a_of_type_JavaLangString = BaseApplication.getContext().getResources().getString(2131698008);
  private int b;
  
  public AECircleAlbumListPart(AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    super(paramAECirclePhotoListLogic);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a(this);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleAlbumListFragment == null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleAlbumListFragment = new AECircleAlbumListFragment();
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleAlbumListFragment.a(this);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    FragmentTransaction localFragmentTransaction = a().getFragmentManager().beginTransaction();
    localFragmentTransaction.setTransition(4097);
    if ((paramBoolean) && (!this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleAlbumListFragment.isAdded())) {
      localFragmentTransaction.add(2064121942, this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleAlbumListFragment, null);
    } else {
      localFragmentTransaction.remove(this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleAlbumListFragment);
    }
    localFragmentTransaction.addToBackStack(null);
    localFragmentTransaction.commit();
    SimpleEventBus.getInstance().dispatchEvent(new AECircleTitleAlbumMenuChangeEvent(paramBoolean));
  }
  
  private void d(boolean paramBoolean)
  {
    ObjectAnimator localObjectAnimator;
    if ((paramBoolean) && (!this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleAlbumListFragment.isAdded())) {
      localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetFrameLayout, "backgroundColor", new int[] { this.b, this.jdField_a_of_type_Int });
    } else {
      localObjectAnimator = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidWidgetFrameLayout, "backgroundColor", new int[] { this.jdField_a_of_type_Int, this.b });
    }
    localObjectAnimator.setDuration(300L);
    localObjectAnimator.setEvaluator(new ArgbEvaluator());
    localObjectAnimator.setRepeatMode(2);
    localObjectAnimator.start();
  }
  
  public String a()
  {
    return "AECircleAlbumListPart";
  }
  
  public void a()
  {
    a(false);
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2064121942));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122290));
    a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122289));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2064122286));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_Int = a().getResources().getColor(2131165485);
    this.b = a().getResources().getColor(2131165474);
  }
  
  public void a(QQAlbumInfo paramQQAlbumInfo, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAlbumListChoose--albumId=");
      localStringBuilder.append(paramQQAlbumInfo.id);
      AEQLog.b("AECircleAlbumListPart", localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a.albumName = paramQQAlbumInfo.name;
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a.albumId = paramQQAlbumInfo.id;
      if (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a.albumName != null) {
        paramQQAlbumInfo = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a.albumName;
      } else {
        paramQQAlbumInfo = this.jdField_a_of_type_JavaLangString;
      }
      a(paramQQAlbumInfo);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.l = true;
      a().runOnUiThread(new AECircleAlbumListPart.1(this));
    }
    a(false);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    a().setTitle(paramCharSequence);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    b();
    c(paramBoolean);
    d(paramBoolean);
    b(paramBoolean ^ true);
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidOsAsyncTask = new AECircleAlbumListPart.QueryPhotoTask(this, paramBoolean1, paramBoolean2);
    this.jdField_a_of_type_AndroidOsAsyncTask.execute(new Object[0]);
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
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localRotateAnimation);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    paramActivity = this.jdField_a_of_type_AndroidOsAsyncTask;
    if (paramActivity != null) {
      paramActivity.cancel(true);
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    this.jdField_a_of_type_AndroidOsAsyncTask = null;
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.o)
    {
      if (this.jdField_a_of_type_AndroidOsAsyncTask == null) {
        a(true, true);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListBaseData.o = true;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic == null) {
      return;
    }
    if (paramView.getId() == 2064122286)
    {
      AEReportUtils.a(5, 2);
      if (AEFastClickThrottle.a(paramView)) {
        return;
      }
      paramView = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleAlbumListFragment;
      boolean bool;
      if ((paramView != null) && (paramView.isAdded())) {
        bool = false;
      } else {
        bool = true;
      }
      if (bool) {
        this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListLogic.b(a().getIntent());
      }
      a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECircleAlbumListPart
 * JD-Core Version:    0.7.0.1
 */