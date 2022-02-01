package com.tencent.aelight.camera.aioeditor.takevideo.sendpanel;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.aelight.camera.aioeditor.CaptureReportUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPart;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.StoryMediaEditNotifier;
import com.tencent.aelight.camera.aioeditor.takevideo.StoryMediaEditNotifier.IEditListener;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.ISlidePanelListener;
import com.tencent.mobileqq.widget.SlideBottomPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import java.util.Iterator;
import java.util.List;

public class SendPanelPart
  extends EditVideoPart
  implements View.OnClickListener, StoryMediaEditNotifier.IEditListener, IHeaderUpdateListener, IPanelDataListener, ISlidePanelListener
{
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private SendPanelAdapter jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelAdapter;
  private SlideBottomPanel jdField_a_of_type_ComTencentMobileqqWidgetSlideBottomPanel;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = false;
  private View jdField_c_of_type_AndroidViewView;
  private volatile boolean jdField_c_of_type_Boolean = false;
  private View d;
  
  public SendPanelPart(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private View a()
  {
    View localView = new View(a());
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.b(130.0F, a())));
    localView.setBackgroundResource(2130850703);
    return localView;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramInt1, paramInt2);
    this.jdField_c_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    localAlphaAnimation.setDuration(500L);
    this.jdField_c_of_type_AndroidViewView.setVisibility(paramInt3);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramInt1 == 1)
    {
      if ((paramInt2 == 0) || (paramInt2 == 1000) || (paramInt2 == 1004)) {
        bool1 = true;
      }
      return bool1;
    }
    if (paramInt1 == 4)
    {
      bool1 = bool3;
      if (paramInt2 == 1) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (paramInt1 == 101)
    {
      bool1 = bool2;
      if (paramInt2 == 3000) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(List<SendPanelItemInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((SendPanelItemInfo)paramList.next()).a();
      }
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidViewView = ((ViewStub)a(2064122611)).inflate();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideBottomPanel = ((SlideBottomPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131377660));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365203);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370110));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377234);
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131363349);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379075));
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(a());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelAdapter = new SendPanelAdapter(a(), this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelAdapter.a(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideBottomPanel.setSlidePanelListener(this);
    this.jdField_c_of_type_AndroidViewView.findViewById(2131377187).setOnClickListener(this);
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    SendPanelManager.a().a(this);
    List localList = SendPanelManager.a().a();
    if ((localList != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelAdapter != null))
    {
      b(localList);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelAdapter.a(localList);
    }
    StoryMediaEditNotifier.a().a(this);
  }
  
  private void k()
  {
    Object localObject = this.jdField_c_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getVisibility() == 8) && (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideBottomPanel.b()))
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelAdapter;
      if ((localObject != null) && (((SendPanelAdapter)localObject).a()))
      {
        this.jdField_c_of_type_Boolean = true;
        a(0, 1, 0);
        CaptureReportUtil.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager);
      }
    }
  }
  
  private void l()
  {
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofKeyframe(View.TRANSLATION_Y, new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.3F, 0.0F), Keyframe.ofFloat(0.45F, -80.0F), Keyframe.ofFloat(0.65F, 50.0F), Keyframe.ofFloat(0.8F, -30.0F), Keyframe.ofFloat(0.9F, 10.0F), Keyframe.ofFloat(1.0F, 0.0F) });
    this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this.jdField_b_of_type_AndroidViewView, new PropertyValuesHolder[] { localPropertyValuesHolder });
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(1600L);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setStartDelay(1000L);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatCount(1);
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
    this.jdField_b_of_type_Boolean = true;
  }
  
  @NonNull
  public Context a()
  {
    return super.a();
  }
  
  public void a()
  {
    super.a();
    h();
    j();
  }
  
  public void a(int paramInt, SendPanelItemInfo paramSendPanelItemInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelAdapter;
    if (localObject != null)
    {
      ((SendPanelAdapter)localObject).a(paramInt, paramSendPanelItemInfo);
      localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
      if (localObject != null)
      {
        int i = ((XListView)localObject).getFirstVisiblePosition();
        int j = this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition();
        if ((paramInt >= i) && (paramInt <= j))
        {
          localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt - i);
          if ((((View)localObject).getTag() instanceof SendPanelAdapter.SendPanelViewHolder))
          {
            localObject = (SendPanelAdapter.SendPanelViewHolder)((View)localObject).getTag();
            ((SendPanelAdapter.SendPanelViewHolder)localObject).a = paramSendPanelItemInfo;
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelAdapter.a(paramInt, (SendPanelAdapter.SendPanelViewHolder)localObject);
          }
        }
      }
      if (!this.jdField_c_of_type_Boolean) {
        k();
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SendPanelPart", 4, "onUpdateIcon uin is empty");
      }
      return;
    }
    List localList = SendPanelManager.a().a();
    int j;
    int i;
    if ((localList != null) && (localList.size() > 0))
    {
      j = localList.size();
      i = 0;
    }
    while (i < j)
    {
      SendPanelItemInfo localSendPanelItemInfo = (SendPanelItemInfo)localList.get(i);
      if ((!TextUtils.isEmpty(localSendPanelItemInfo.jdField_a_of_type_JavaLangString)) && (localSendPanelItemInfo.jdField_a_of_type_JavaLangString.equals(paramString1)) && (a(paramInt, localSendPanelItemInfo.jdField_a_of_type_Int)))
      {
        localSendPanelItemInfo.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
        localSendPanelItemInfo.d = paramString2;
        paramString1 = this.jdField_a_of_type_AndroidOsHandler;
        if (paramString1 != null) {
          paramString1.post(new SendPanelPart.2(this, i, localSendPanelItemInfo));
        }
      }
      else
      {
        i += 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("SendPanelPart", 4, "onUpdateIcon itemInfoList is empty");
        }
      }
    }
  }
  
  public void a(List<SendPanelItemInfo> paramList)
  {
    SendPanelAdapter localSendPanelAdapter = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelAdapter;
    if (localSendPanelAdapter != null) {
      localSendPanelAdapter.a(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SlideBottomPanel localSlideBottomPanel = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideBottomPanel;
    if (localSlideBottomPanel != null) {
      if (paramBoolean)
      {
        if (!localSlideBottomPanel.a()) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetSlideBottomPanel.c();
        }
      }
      else if (localSlideBottomPanel.a()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideBottomPanel.d();
      }
    }
  }
  
  public boolean a()
  {
    return super.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelAdapter != null)
    {
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      if (localHandler != null)
      {
        localHandler.post(new SendPanelPart.3(this));
        this.jdField_c_of_type_Boolean = false;
      }
    }
  }
  
  public void c() {}
  
  public void cancelAnimator()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      ObjectAnimator localObjectAnimator = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
      if (localObjectAnimator != null)
      {
        localObjectAnimator.cancel();
        this.jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  public void d()
  {
    super.d();
    if (SendPanelManager.a().jdField_a_of_type_Boolean)
    {
      SendPanelManager.a().jdField_a_of_type_Boolean = false;
      l();
      SendPanelManager.a().a(false);
    }
  }
  
  public void displayPanel()
  {
    k();
    View localView = this.d;
    if (localView != null) {
      localView.setVisibility(0);
    }
    CaptureReportUtil.d(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager);
  }
  
  public void displayPanelFinish()
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setBackgroundResource(2130850002);
    }
  }
  
  public void e()
  {
    SendPanelAdapter localSendPanelAdapter = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelAdapter;
    if (localSendPanelAdapter != null) {
      localSendPanelAdapter.a();
    }
    this.jdField_c_of_type_Boolean = false;
    StoryMediaEditNotifier.a().b(this);
    super.e();
  }
  
  public void f()
  {
    SendPanelAdapter localSendPanelAdapter = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelAdapter;
    if (localSendPanelAdapter != null) {
      localSendPanelAdapter.b();
    }
  }
  
  public void fadeBackground(float paramFloat)
  {
    View localView = this.d;
    if (localView != null)
    {
      localView.setVisibility(0);
      this.d.setAlpha(paramFloat);
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SendPanelPart", 4, "compositeFail");
    }
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.post(new SendPanelPart.1(this));
    }
  }
  
  public void hidePanel()
  {
    View localView = this.jdField_c_of_type_AndroidViewView;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      a(1, 0, 8);
    }
    localView = this.d;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void hidePanelFinish()
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setBackgroundResource(2130850001);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131377187) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.i()) {
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b();
    CaptureReportUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager);
    ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).clearLatestPostMd5();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelPart
 * JD-Core Version:    0.7.0.1
 */