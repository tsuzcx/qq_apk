package com.tencent.aelight.camera.aioeditor.takevideo;

import android.os.Message;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QzEditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.view.RotationSeekBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;

public class EditVideoProgressBar
  extends EditVideoPart
{
  private double jdField_a_of_type_Double = 1.0D;
  private int jdField_a_of_type_Int = -1;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QzEditVideoPartManager jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager;
  private QimMusicPlayer jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
  private HWEditLocalVideoPlayer jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer;
  private RotationSeekBar jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewRotationSeekBar;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = -1L;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public EditVideoProgressBar(@NonNull QzEditVideoPartManager paramQzEditVideoPartManager)
  {
    super(paramQzEditVideoPartManager);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager = paramQzEditVideoPartManager;
  }
  
  private static String a(long paramLong)
  {
    paramLong /= 1000L;
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
  }
  
  private void b()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2064122153);
    Object localObject = LayoutInflater.from(a());
    int i = 0;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((LayoutInflater)localObject).inflate(2131562250, localRelativeLayout, false));
    localObject = new RelativeLayout.LayoutParams(-1, AIOUtils.b(40.0F, a()));
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (!this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.g) {
      i = 8;
    }
    localLinearLayout.setVisibility(i);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    if (LiuHaiUtils.e > 0) {
      i = LiuHaiUtils.e + AIOUtils.b(40.0F, a());
    } else {
      i = AIOUtils.b(100.0F, a());
    }
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = i;
    localRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject);
  }
  
  private void g()
  {
    if ((this.jdField_b_of_type_Long < 0L) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer.a() != null))
    {
      this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer.a().mDuration;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer = ((QimMusicPlayer)QIMManager.a().c(8));
      if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer.a() == 1) && (this.jdField_b_of_type_Int != 1))
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130847924);
        this.jdField_b_of_type_Int = 1;
        return;
      }
      if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer.a() == 2) && (this.jdField_b_of_type_Int != 2))
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130847923);
        this.jdField_b_of_type_Int = 2;
      }
    }
  }
  
  private void h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer;
    if (localObject != null) {
      ((HWEditLocalVideoPlayer)localObject).h();
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
    if (localObject != null) {
      ((QimMusicPlayer)localObject).d();
    }
  }
  
  private void j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer;
    if (localObject != null) {
      ((HWEditLocalVideoPlayer)localObject).w_();
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureMusicQimMusicPlayer;
    if (localObject != null) {
      ((QimMusicPlayer)localObject).c();
    }
  }
  
  public void a()
  {
    super.a();
    b();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewRotationSeekBar = ((RotationSeekBar)a(2131366008));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)a(2131366009));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131366010));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131366007));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new EditVideoProgressBar.1(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewRotationSeekBar.setEnabled(true);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 0)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.g)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  protected boolean a(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 9)
    {
      if (i == 13)
      {
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaQzEditVideoPartManager.g)
        {
          g();
          if (this.jdField_b_of_type_Long > 0L)
          {
            long l1 = ((Long[])(Long[])paramMessage.obj)[0].longValue();
            if (this.jdField_a_of_type_Double > 0.0D)
            {
              i = (int)(100L * l1 / this.jdField_b_of_type_Long);
              int j = this.jdField_a_of_type_Int;
              if ((i < j) && (j < 95) && (i > 5))
              {
                paramMessage = new StringBuilder();
                paramMessage.append("progress = ");
                paramMessage.append(j);
                paramMessage.append("；lastProgress = ");
                paramMessage.append(this.jdField_a_of_type_Int);
                paramMessage.append("; need to reset");
                QLog.d("EditVideo - progressBar", 2, paramMessage.toString());
                i = j;
              }
              else
              {
                this.jdField_a_of_type_Int = i;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewRotationSeekBar.setProgress(i);
              paramMessage = this.jdField_a_of_type_AndroidWidgetTextView;
              double d1 = l1;
              double d2 = this.jdField_a_of_type_Double;
              Double.isNaN(d1);
              paramMessage.setText(a((d1 * d2)));
              paramMessage = this.jdField_b_of_type_AndroidWidgetTextView;
              d1 = this.jdField_b_of_type_Long;
              d2 = this.jdField_a_of_type_Double;
              Double.isNaN(d1);
              paramMessage.setText(a((d1 * d2)));
            }
            else
            {
              long l2 = this.jdField_b_of_type_Long;
              i = (int)((l2 - l1) * 100L / l2);
              this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewRotationSeekBar.setProgress(i);
              this.jdField_a_of_type_AndroidWidgetTextView.setText(a(this.jdField_b_of_type_Long - l1));
              this.jdField_b_of_type_AndroidWidgetTextView.setText(a(this.jdField_b_of_type_Long));
            }
          }
          if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer.a() == 1) && (this.jdField_b_of_type_Int != 1))
          {
            this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130847924);
            this.jdField_b_of_type_Int = 1;
            return true;
          }
          if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoHWEditLocalVideoPlayer.a() == 2) && (this.jdField_b_of_type_Int != 2))
          {
            this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130847923);
            this.jdField_b_of_type_Int = 2;
          }
        }
        return true;
      }
    }
    else if (paramMessage.arg1 == 12)
    {
      i = paramMessage.arg2;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i == 5) {
                  this.jdField_a_of_type_Double = -1.0D;
                }
              }
              else {
                this.jdField_a_of_type_Double = 4.0D;
              }
            }
            else {
              this.jdField_a_of_type_Double = 2.0D;
            }
          }
          else {
            this.jdField_a_of_type_Double = 1.0D;
          }
        }
        else {
          this.jdField_a_of_type_Double = 0.5D;
        }
      }
      else {
        this.jdField_a_of_type_Double = 0.25D;
      }
    }
    return super.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoProgressBar
 * JD-Core Version:    0.7.0.1
 */