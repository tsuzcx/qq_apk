package com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.RoundedTransformation;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.File;

public class GuideInfoDialog
  extends ReportDialog
{
  private int jdField_a_of_type_Int = -1;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoView jdField_a_of_type_AndroidWidgetVideoView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  
  public GuideInfoDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a()
  {
    if (!TextUtils.isEmpty(this.e))
    {
      this.jdField_a_of_type_AndroidWidgetVideoView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetVideoView.setVideoPath(this.e);
      this.jdField_a_of_type_AndroidWidgetVideoView.setZOrderOnTop(true);
      this.jdField_a_of_type_AndroidWidgetVideoView.start();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetVideoView.setVisibility(8);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "story_rename_guide";
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = UIUtils.a(getContext(), 3.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = UIUtils.a(getContext(), 155.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = UIUtils.a(getContext(), 307.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (this.jdField_b_of_type_Boolean)
      {
        localObject = URLDrawable.getDrawable(new File(this.jdField_a_of_type_JavaLangString), (URLDrawable.URLDrawableOptions)localObject);
        if (((URLDrawable)localObject).getStatus() != 1) {
          ((URLDrawable)localObject).restartDownload();
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() != 1) {
        ((URLDrawable)localObject).restartDownload();
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      UIUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_JavaLangString, UIUtils.a(getContext(), 307.0F), UIUtils.a(getContext(), 155.0F), new RoundedTransformation(UIUtils.a(getContext(), 4.0F), 0, 0.504886F, null, null));
      return;
    }
    if (this.jdField_a_of_type_Int != -1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(this.jdField_a_of_type_Int);
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public GuideInfoDialog a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    return this;
  }
  
  public GuideInfoDialog a(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public GuideInfoDialog a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public GuideInfoDialog b(View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    return this;
  }
  
  public GuideInfoDialog b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public GuideInfoDialog b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public GuideInfoDialog c(View.OnClickListener paramOnClickListener)
  {
    this.jdField_c_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    return this;
  }
  
  public GuideInfoDialog c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public GuideInfoDialog d(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
  }
  
  public void dismiss()
  {
    VideoView localVideoView = this.jdField_a_of_type_AndroidWidgetVideoView;
    if ((localVideoView != null) && (localVideoView.isPlaying())) {
      this.jdField_a_of_type_AndroidWidgetVideoView.stopPlayback();
    }
    super.dismiss();
  }
  
  public GuideInfoDialog e(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131561675);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131374530));
    this.jdField_a_of_type_AndroidWidgetVideoView = ((VideoView)findViewById(2131380795));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374531));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374529));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374528));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131374533));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131374534));
    a();
    b();
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(this.jdField_b_of_type_JavaLangString) > UIUtils.a(getContext(), 280.0F)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(3);
      } else {
        this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(this.d))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.d);
      paramBundle = this.jdField_a_of_type_AndroidViewView$OnClickListener;
      if (paramBundle != null) {
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramBundle);
      } else {
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new GuideInfoDialog.1(this));
      }
    }
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setTag(this.jdField_c_of_type_JavaLangString);
      paramBundle = this.jdField_b_of_type_AndroidViewView$OnClickListener;
      if (paramBundle != null) {
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(paramBundle);
      } else {
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new GuideInfoDialog.2(this));
      }
    }
    paramBundle = this.jdField_c_of_type_AndroidViewView$OnClickListener;
    if (paramBundle != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramBundle);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new GuideInfoDialog.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.GuideInfoDialog
 * JD-Core Version:    0.7.0.1
 */