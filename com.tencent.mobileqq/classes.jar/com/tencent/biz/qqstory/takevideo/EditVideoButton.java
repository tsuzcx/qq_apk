package com.tencent.biz.qqstory.takevideo;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.AddressDataProvider;
import com.tencent.biz.qqstory.model.AddressDataProvider.AddressInfo;
import com.tencent.biz.qqstory.model.DataProviderManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.nearby.now.send.SmallVideoCameraCaptureFragment;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

@TargetApi(11)
public class EditVideoButton
  extends EditVideoPart
  implements View.OnClickListener, EditButtonExport
{
  public static final SparseArray a;
  public static final int[] a;
  public int a;
  private long jdField_a_of_type_Long;
  private LayoutTransition jdField_a_of_type_AndroidAnimationLayoutTransition = new LayoutTransition();
  public SparseIntArray a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public boolean a;
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView;
  private SparseArray jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private View e;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131364441, 2131364442, 2131364443, 2131364444, 2131364445, 2131364446, 2131364447, 2131364448, 2131364449, 2131364450, 2131364451 };
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.put(32, new EditVideoButton.EntryButtonInfo(32, 2130843455, "添加背景音乐"));
    jdField_a_of_type_AndroidUtilSparseArray.put(1, new EditVideoButton.EntryButtonInfo(1, 2130843395, "涂鸦画笔"));
    jdField_a_of_type_AndroidUtilSparseArray.put(4, new EditVideoButton.EntryButtonInfo(4, 2130843650, "添加文字"));
    jdField_a_of_type_AndroidUtilSparseArray.put(8, new EditVideoButton.EntryButtonInfo(8, 2130843350, "添加贴纸"));
    jdField_a_of_type_AndroidUtilSparseArray.put(128, new EditVideoButton.EntryButtonInfo(128, 2130843502, "添加标签"));
    jdField_a_of_type_AndroidUtilSparseArray.put(16, new EditVideoButton.EntryButtonInfo(16, 2130843277, "艺术化滤镜"));
    jdField_a_of_type_AndroidUtilSparseArray.put(2, new EditVideoButton.EntryButtonInfo(2, 2130843340, "裁剪"));
    jdField_a_of_type_AndroidUtilSparseArray.put(131072, new EditVideoButton.EntryButtonInfo(131072, 2130843621, "分享到群"));
    jdField_a_of_type_AndroidUtilSparseArray.put(1024, new EditVideoButton.EntryButtonInfo(1024, 2130843061, "保存到手机"));
    jdField_a_of_type_AndroidUtilSparseArray.put(4096, new EditVideoButton.EntryButtonInfo(4096, 2130843378, "GIF快慢"));
    jdField_a_of_type_AndroidUtilSparseArray.put(8192, new EditVideoButton.EntryButtonInfo(8192, 2130843366, "生成GIF"));
    jdField_a_of_type_AndroidUtilSparseArray.put(262144, new EditVideoButton.EntryButtonInfo(262144, 2130843390, "跳转到P图"));
  }
  
  public EditVideoButton(@NonNull EditVideoPartManager paramEditVideoPartManager, int paramInt)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(@Nullable ImageView paramImageView)
  {
    int i = 0;
    while (i < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localImageView != null) {
        localImageView.clearColorFilter();
      }
      i += 1;
    }
    if (paramImageView != null) {
      paramImageView.setColorFilter(a().getColor(2131493762), PorterDuff.Mode.MULTIPLY);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      paramImageView = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(32);
      if (paramImageView != null) {
        paramImageView.setColorFilter(a().getColor(2131493763), PorterDuff.Mode.MULTIPLY);
      }
    }
  }
  
  private void a(View... paramVarArgs)
  {
    float f1 = FontSettingManager.a();
    int j;
    int i;
    if (f1 > 16.0F)
    {
      j = paramVarArgs.length;
      i = 0;
    }
    for (;;)
    {
      View localView;
      if (i < j)
      {
        localView = paramVarArgs[i];
        if ((localView != null) && (localView.getLayoutParams() != null)) {}
      }
      else
      {
        return;
      }
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localLayoutParams.height = ((int)(localLayoutParams.height * (16.0F / f1)));
      localLayoutParams.width = ((int)(localLayoutParams.width * (16.0F / f1)));
      SLog.b("Q.qqstory.record.EditVideoButton", "new size : " + localView.toString() + ", height=" + localLayoutParams.height + ", width=" + localLayoutParams.width);
      localView.setLayoutParams(localLayoutParams);
      if ((localView instanceof TextView))
      {
        float f2 = ((TextView)localView).getTextSize();
        float f3 = 16.0F / f1;
        ((TextView)localView).setTextSize(0, f2 * f3);
      }
      i += 1;
    }
  }
  
  private ImageView[] a(int paramInt, @NonNull ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    int m = paramViewGroup.getChildCount();
    if (m != jdField_a_of_type_ArrayOfInt.length) {
      throw new IllegalArgumentException("布局文件中的子View个数与EDIT_BUTTON_IDS数组长度不同");
    }
    int j = 0;
    int n = paramInt & 0x630BF;
    int i = 0;
    paramInt = j;
    if (i < 23)
    {
      j = 1 << i;
      if ((n & j) != j) {
        break label419;
      }
      paramInt += 1;
    }
    label419:
    for (;;)
    {
      i += 1;
      break;
      SLog.a("Q.qqstory.record.EditVideoButton", "initEditButtons, needButtonCount = %d", Integer.valueOf(paramInt));
      if (m < paramInt) {
        throw new IllegalArgumentException("too many parts, there is no enough view to show");
      }
      ImageView[] arrayOfImageView = new ImageView[m];
      i = 0;
      Object localObject;
      while (i < m)
      {
        localObject = paramViewGroup.findViewById(jdField_a_of_type_ArrayOfInt[i]);
        if ((localObject instanceof ImageView))
        {
          arrayOfImageView[i] = ((ImageView)localObject);
          i += 1;
        }
        else
        {
          throw new IllegalArgumentException("can not find ImageView by id : " + jdField_a_of_type_ArrayOfInt[i] + ", view : " + localObject);
        }
      }
      this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
      j = 0;
      i = 0;
      int k;
      for (;;)
      {
        k = i;
        if (j < 23)
        {
          int i1 = 1 << j;
          k = i;
          if ((n & i1) == i1)
          {
            paramViewGroup = arrayOfImageView[i];
            localObject = (EditVideoButton.EntryButtonInfo)jdField_a_of_type_AndroidUtilSparseArray.get(i1);
          }
          try
          {
            paramViewGroup.setImageDrawable(new BitmapDrawable(BitmapFactory.decodeResource(a(), ((EditVideoButton.EntryButtonInfo)localObject).b)));
            paramViewGroup.setContentDescription(((EditVideoButton.EntryButtonInfo)localObject).a);
            paramViewGroup.setOnClickListener(paramOnClickListener);
            this.jdField_a_of_type_AndroidUtilSparseIntArray.put(paramViewGroup.getId(), i1);
            this.jdField_b_of_type_AndroidUtilSparseArray.put(i1, paramViewGroup);
            k = i + 1;
            j += 1;
            i = k;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            for (;;)
            {
              SLog.e("Q.qqstory.record.EditVideoButton", "decodeResource OutOfMemoryError : %s", new Object[] { ((EditVideoButton.EntryButtonInfo)localObject).a });
            }
          }
        }
      }
      while (k < m)
      {
        arrayOfImageView[k].setOnClickListener(null);
        arrayOfImageView[k].setVisibility(8);
        k += 1;
      }
      if (paramInt >= 6) {
        e();
      }
      return arrayOfImageView;
    }
  }
  
  private void e()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a().getResources().getDisplayMetrics().widthPixels - UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), 72.0F);
    int j = UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), 48.0F);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getLayoutParams();
    if ((i >= j * 5) && (i < j * 6)) {}
    for (localLayoutParams.width = ((int)(j * 4.5D));; localLayoutParams.width = ((int)(j * 3.5D))) {
      do
      {
        SLog.b("Q.qqstory.record.EditVideoButton", "new size : " + this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.toString() + ", width=" + localLayoutParams.width);
        this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setLayoutParams(localLayoutParams);
        return;
      } while ((i < j * 4) || (i >= j * 5));
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.f()))
    {
      if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.d) {
        break label79;
      }
      a(true, false);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.removeMessages(994);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.sendEmptyMessage(995);
    }
    label79:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.sendEmptyMessageDelayed(994, 0L);
    } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.jdField_b_of_type_Boolean);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText("0%");
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844577);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131364402));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131364428));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = a(2131364418);
    this.jdField_c_of_type_AndroidViewView = a(2131371909);
    this.jdField_d_of_type_AndroidViewView = a(2131371910);
    a(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131363390));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)a(2131364438));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364439));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = a(this.jdField_a_of_type_Int, this.jdField_b_of_type_AndroidViewViewGroup, this);
    this.jdField_a_of_type_AndroidViewView = a(2131364415);
    Object localObject1;
    Object localObject2;
    boolean bool;
    if ((this.jdField_a_of_type_Int & 0x800) != 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_a_of_type_AndroidViewView.findViewById(2131364416));
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle;
      localObject2 = this.jdField_a_of_type_AndroidWidgetCheckBox;
      if ((localObject1 != null) && (((Bundle)localObject1).getBoolean("sync_story_checked", false))) {
        bool = true;
      }
    }
    for (;;)
    {
      a((CheckBox)localObject2, bool);
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131364403));
      if ((this.jdField_a_of_type_Int & 0x400) != 0)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject1 = (EditVideoButton.EntryButtonInfo)jdField_a_of_type_AndroidUtilSparseArray.get(1024);
      }
      try
      {
        localObject2 = BitmapFactory.decodeResource(a(), ((EditVideoButton.EntryButtonInfo)localObject1).b);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable((Bitmap)localObject2));
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(((EditVideoButton.EntryButtonInfo)localObject1).a);
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.e = a(2131367202);
        if ((this.jdField_a_of_type_Int & 0x400000) != 0)
        {
          this.e.setVisibility(0);
          this.e.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131364410));
          this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131364414));
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131364411));
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131364412));
          this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131364413));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          a(new View[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView });
          a(this.jdField_a_of_type_ArrayOfAndroidWidgetImageView);
          this.jdField_a_of_type_AndroidAnimationLayoutTransition.setAnimator(3, ObjectAnimator.ofFloat(null, "alpha", new float[] { 1.0F, 0.0F }));
          this.jdField_a_of_type_AndroidAnimationLayoutTransition.setDuration(3, 500L);
          this.jdField_a_of_type_AndroidAnimationLayoutTransition.setAnimator(2, ObjectAnimator.ofFloat(null, "alpha", new float[] { 0.0F, 1.0F }));
          this.jdField_a_of_type_AndroidAnimationLayoutTransition.setDuration(2, 500L);
          if ((this.jdField_a_of_type_Int & 0x4000) == 0) {
            break label799;
          }
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
          StoryReportor.a("pub_control", "exp_entry", 0, 0, new String[0]);
          if (!(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeGifSource)) {
            break label811;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText("重拍");
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("重拍");
          localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle;
          if ((localObject1 != null) && (((Bundle)localObject1).getInt("video_redbag_get", 0) == LocalMediaInfo.REDBAG_TYPE_GET))
          {
            this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131371912));
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            SLog.d("Q.qqstory.record.EditVideoButton", "VideoRedbag, editVideoButton show redbag tips");
          }
          a(EditButtonExport.class, this);
          return;
          bool = false;
          continue;
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          SLog.e("Q.qqstory.record.EditVideoButton", "decodeResource OutOfMemoryError : %s", new Object[] { ((EditVideoButton.EntryButtonInfo)localObject1).a });
          continue;
          this.e.setVisibility(8);
          continue;
          label799:
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          continue;
          label811:
          if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource))
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setText("返回");
            this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回");
          }
          else if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.c())
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setText("重拍");
            this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("重拍");
          }
          else if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.d()) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1))
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setText("返回");
            this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回");
          }
          else
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setText("取消");
            this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("取消");
          }
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(32);
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      if (paramInt1 < paramInt2) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramInt1 * 100 / paramInt2 + "%");
      }
    }
    else {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText("99%");
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    switch (paramInt2)
    {
    case 18: 
    case 19: 
    case 20: 
    case 22: 
    case 25: 
    default: 
      return;
    case 0: 
      a(null);
      if (paramInt1 == 9)
      {
        paramInt2 = 1;
        if (paramInt1 != 23) {
          break label174;
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((i | paramInt2) == 0) {
          break label180;
        }
        b(true, true);
        return;
        paramInt2 = 0;
        break;
      }
      if (paramInt1 == 27)
      {
        a(true, true, false);
        return;
      }
      b(true, false);
      return;
    case 27: 
      a(false, true, false);
      VideoEditReport.b("0X80080E5", VideoEditReport.jdField_a_of_type_Int);
      return;
    case 10: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 24: 
      a(null);
      b(true, false);
      return;
    case 7: 
      a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(1));
      if (paramInt1 == 8)
      {
        if ((paramObject != null) && ((paramObject instanceof Boolean)))
        {
          a(true, true, ((Boolean)paramObject).booleanValue());
          return;
        }
        b(true, true);
        return;
      }
      b(true, false);
      return;
    case 5: 
      a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(4));
      b(false, false);
      return;
    case 6: 
      a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(8));
      b(false, false);
      return;
    case 8: 
      if ((paramObject != null) && ((paramObject instanceof Boolean)))
      {
        b(false, ((Boolean)paramObject).booleanValue());
        return;
      }
      b(false, true);
      return;
    case 9: 
    case 23: 
      b(false, true);
      return;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 12: 
    case 28: 
      b(false, false);
      return;
    case 11: 
      a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(2));
      b(false, false);
      return;
    case 21: 
      label174:
      label180:
      a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(4096));
      b(false, false);
      return;
    }
    a((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(262144));
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.d())
    {
      paramGenerateContext.d = this.jdField_a_of_type_Boolean;
      SharedPreUtils.d(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity(), this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle == null) {
        break label118;
      }
      paramInt = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getInt("curType", 1);
      if (paramInt != 1) {
        break label123;
      }
      paramGenerateContext = "1";
      label83:
      if (!this.jdField_a_of_type_Boolean) {
        break label130;
      }
    }
    label130:
    for (String str = "2";; str = "1")
    {
      StoryReportor.a("aio_shoot", "clk_send", 0, 0, new String[] { paramGenerateContext, str });
      return;
      label118:
      paramInt = 1;
      break;
      label123:
      paramGenerateContext = "2";
      break label83;
    }
  }
  
  void a(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      int i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a();
      if ((i != 101) && (i != 104)) {
        break label50;
      }
      paramView.setText("分享");
      paramView.setContentDescription("分享");
    }
    label50:
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 2))
      {
        paramView.setText("发送");
        paramView.setContentDescription("发送");
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)
      {
        String str = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_publish_text");
        if (!TextUtils.isEmpty(str))
        {
          paramView.setText(str);
          paramView.setContentDescription(str);
          return;
        }
        paramView.setText("确定");
        paramView.setContentDescription("确定");
        return;
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 6))
      {
        paramView.setText("下一步");
        paramView.setContentDescription("选择好友发送祝福视频");
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 7)
      {
        paramView.setText("添加");
        paramView.setContentDescription("添加");
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 8)
      {
        paramView.setText("确定");
        paramView.setContentDescription("确定");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 9);
    paramView.setText("下一步");
    paramView.setContentDescription("下一步");
  }
  
  protected void a(CheckBox paramCheckBox, boolean paramBoolean)
  {
    paramCheckBox.setChecked(paramBoolean);
    if (paramBoolean)
    {
      paramCheckBox.setButtonDrawable(2130842886);
      return;
    }
    paramCheckBox.setButtonDrawable(2130842884);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
    int i = 0;
    while (i < this.jdField_b_of_type_AndroidUtilSparseArray.size())
    {
      int j = this.jdField_b_of_type_AndroidUtilSparseArray.keyAt(i);
      ((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(j)).setEnabled(paramBoolean);
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    if (!paramBoolean2)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844250);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844251);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j = 0;
    if (paramBoolean2)
    {
      this.jdField_c_of_type_Long = (System.currentTimeMillis() + 500L);
      if (paramBoolean3) {
        this.jdField_c_of_type_Long += 500L;
      }
      if (paramBoolean1)
      {
        TakeVideoUtils.b(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
        if ((this.jdField_a_of_type_Int & 0x4000) != 0) {
          TakeVideoUtils.b(this.jdField_b_of_type_AndroidViewView, paramBoolean3);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 11, Long.valueOf(this.jdField_c_of_type_Long)));
        if (!paramBoolean1) {
          break;
        }
        i = 0;
        while (i < this.jdField_b_of_type_AndroidUtilSparseArray.size())
        {
          ((ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.valueAt(i)).setVisibility(0);
          i += 1;
        }
        TakeVideoUtils.a(this.jdField_a_of_type_AndroidViewViewGroup, paramBoolean3);
        if ((this.jdField_a_of_type_Int & 0x4000) != 0) {
          TakeVideoUtils.a(this.jdField_b_of_type_AndroidViewView, paramBoolean3);
        }
      }
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramBoolean1) {}
    for (int i = 0;; i = 8)
    {
      ((ViewGroup)localObject).setVisibility(i);
      this.jdField_c_of_type_Long = 0L;
      break;
    }
    if ((this.jdField_a_of_type_Int & 0x800) != 0)
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (!paramBoolean1) {
        break label256;
      }
    }
    label256:
    for (i = j;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (!paramBoolean1)) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      return;
    }
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramMessage.arg1);
      if (localImageView != null)
      {
        SLog.b("Q.qqstory.record.EditVideoButton", "perform button click %s", localImageView);
        localImageView.performClick();
      }
      else
      {
        SLog.d("Q.qqstory.record.EditVideoButton", "can not find view performing click by enable mask %d", new Object[] { Integer.valueOf(paramMessage.arg1) });
      }
    }
  }
  
  public void b(int paramInt)
  {
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(131072);
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1, paramBoolean2, true);
  }
  
  public void f()
  {
    super.f();
  }
  
  public void onClick(View paramView)
  {
    int k = 1;
    int j = 1;
    boolean bool = false;
    int m;
    if (Math.abs(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) > 1000L)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      m = paramView.getId();
      if (this.jdField_c_of_type_Long <= System.currentTimeMillis()) {}
    }
    else
    {
      SLog.d("Q.qqstory.record.EditVideoButton", "you click button too fast, ignore it !");
      return;
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    Object localObject = jdField_a_of_type_ArrayOfInt;
    int n = localObject.length;
    int i = 0;
    for (;;)
    {
      if (i >= n) {
        break label1456;
      }
      if (localObject[i] == m)
      {
        i = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(m);
        SLog.d("Q.qqstory.record.EditVideoButton", "onClick : mask=%d, view=%s", new Object[] { Integer.valueOf(i), paramView });
        VideoEditReport.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007822");
        j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 1, i, 0, paramView));
        if (j > 0)
        {
          SLog.c("Q.qqstory.record.EditVideoButton", "%d parts intercept the click event : " + j);
          return;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.q();
        switch (i)
        {
        default: 
          return;
        case 1: 
          bool = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b(5);
          if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a())
          {
            paramView = "2";
            if (!bool) {
              break label649;
            }
            localObject = "1";
            StoryReportor.a("video_edit", "clk_graffiti", 0, 0, new String[] { paramView, "", localObject, "" });
            VideoEditReport.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007821");
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a("608", "10", "0", true);
            VideoEditReport.b("0X80075C4", VideoEditReport.jdField_a_of_type_Int);
            VideoEditReport.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X800781E");
            if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3))
            {
              if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) {
                break label657;
              }
              LpReportInfo_pf00064.allReport(628, 3);
            }
          }
        case 32: 
          for (;;)
          {
            if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(7)) {
              break label668;
            }
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
            return;
            bool = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b(4);
            paramView = (AddressDataProvider)((DataProviderManager)SuperManager.a(20)).a(1);
            if (paramView.a((AddressDataProvider.AddressInfo)paramView.a()))
            {
              paramView = "2";
              if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
                break label626;
              }
              localObject = "2";
              if (!bool) {
                break label634;
              }
            }
            for (String str = "1";; str = "0")
            {
              StoryReportor.a("video_edit", "clk_music", 0, 0, new String[] { localObject, paramView, str, "" });
              this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(2);
              return;
              paramView = "1";
              break;
              localObject = "1";
              break label565;
            }
            paramView = "1";
            break;
            localObject = "0";
            break label347;
            LpReportInfo_pf00064.allReport(615, 1, 1);
          }
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(7);
          return;
        case 4: 
          VideoEditReport.b("0X80075C6", VideoEditReport.jdField_a_of_type_Int);
          VideoEditReport.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X8007820");
          if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3))
          {
            if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) {
              break label759;
            }
            LpReportInfo_pf00064.allReport(628, 2);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(5, Boolean.TRUE);
            return;
            LpReportInfo_pf00064.allReport(615, 3, 1);
          }
        case 8: 
          bool = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b(3);
          if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a())
          {
            paramView = "2";
            if (!bool) {
              break label954;
            }
            localObject = "1";
            StoryReportor.a("video_edit", "add_face", 0, 0, new String[] { paramView, "", localObject, "" });
            VideoEditReport.b("0X80075C7", VideoEditReport.jdField_a_of_type_Int);
            if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3))
            {
              if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) {
                break label962;
              }
              LpReportInfo_pf00064.allReport(628, 4);
            }
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a("608", "11", "0", true);
            VideoEditReport.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), "0X800781D");
            if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(6)) {
              break label973;
            }
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
            return;
            paramView = "1";
            break;
            localObject = "0";
            break label804;
            LpReportInfo_pf00064.allReport(615, 4, 1);
          }
          ((DoodleEmojiManager)SuperManager.a(8)).a(false);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(6);
          return;
        case 128: 
          localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager;
          if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {}
          for (paramView = "2";; paramView = "1")
          {
            ((EditVideoPartManager)localObject).a("add_tag", 0, 0, new String[] { paramView });
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(1);
            return;
          }
        case 16: 
          VideoEditReport.b("0X80075C8", VideoEditReport.jdField_a_of_type_Int);
          if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
            LpReportInfo_pf00064.allReport(615, 5, 1);
          }
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.t();
          return;
        case 2: 
          VideoEditReport.b("0X80075C5", VideoEditReport.jdField_a_of_type_Int);
          if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
            LpReportInfo_pf00064.allReport(615, 2, 1);
          }
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.r();
          return;
        case 131072: 
          StoryReportor.a("video_edit", "share_to_group", 0, 0, new String[0]);
          StoryReportor.a("story_grp", "clk_share_grp", 0, 0, new String[] { "", "", "", "" });
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(25);
          return;
        case 1024: 
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(19);
          return;
        case 4096: 
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(21);
          if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 3)) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e())
          {
            LpReportInfo_pf00064.allReport(628, 5, 1);
            return;
          }
          LpReportInfo_pf00064.allReport(615, 5, 1);
          return;
        case 8192: 
          if (!this.jdField_b_of_type_Boolean) {
            bool = true;
          }
          this.jdField_b_of_type_Boolean = bool;
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(this.jdField_b_of_type_Boolean);
          paramView = (ImageView)paramView;
          localObject = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(32);
          if (this.jdField_b_of_type_Boolean)
          {
            paramView.setImageResource(2130843367);
            if (localObject == null) {
              break;
            }
            ((ImageView)localObject).setColorFilter(a().getColor(2131493763), PorterDuff.Mode.MULTIPLY);
            return;
          }
          paramView.setImageResource(2130843366);
          if (localObject == null) {
            break;
          }
          ((ImageView)localObject).clearColorFilter();
          return;
        case 262144: 
          label347:
          label626:
          label634:
          if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
            LpReportInfo_pf00064.allReport(615, 11);
          }
          label565:
          label759:
          if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.f == 26)
          {
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
            return;
          }
          label649:
          label657:
          label668:
          label804:
          label954:
          label962:
          label973:
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(26);
          return;
        }
      }
      i += 1;
    }
    switch (m)
    {
    default: 
      return;
    case 2131364402: 
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
        LpReportInfo_pf00064.allReport(615, 10);
      }
    case 2131364428: 
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.d();
        return;
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
          LpReportInfo_pf00064.allReport(615, 8);
        }
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 9))
        {
          paramView = "";
          if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle != null) {
            paramView = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getString("_from", "");
          }
          localObject = new NowVideoReporter().h("video_public").i("clk_next");
          if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a()) {
            break label1717;
          }
        }
        for (i = j;; i = 2)
        {
          ((NowVideoReporter)localObject).a(i).d(paramView).b(null);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.f();
          return;
        }
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 9))
        {
          if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b()) {}
          for (i = k;; i = 2)
          {
            new NowVideoReporter().h("video_edit").i("clk_reshoot").d(SmallVideoCameraCaptureFragment.a).a(i).b(null);
            break;
          }
        }
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 10)) {
          ReportController.b(null, "dc00899", "Grp_tribe", "", "video_edit", "Clk_left", 0, 0, "", "", "", "");
        }
      }
    case 2131364415: 
      if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
      {
        bool = true;
        a(this.jdField_a_of_type_AndroidWidgetCheckBox, bool);
        this.jdField_a_of_type_Boolean = bool;
        if ((bool) && (SharedPreUtils.d(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a()))) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(20);
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle == null) {
          break label2004;
        }
        i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getInt("curType", 1);
        if (i != 1) {
          break label2009;
        }
        paramView = "1";
        if (!bool) {
          break label2016;
        }
      }
      for (localObject = "2";; localObject = "1")
      {
        StoryReportor.a("aio_shoot", "clk_sync", 0, 0, new String[] { paramView, localObject });
        return;
        bool = false;
        break;
        i = 1;
        break label1954;
        paramView = "2";
        break label1963;
      }
    case 2131371909: 
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(22))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(22);
      return;
    case 2131364410: 
      h();
      return;
    case 2131364403: 
      label1456:
      label1717:
      label2004:
      label2009:
      label2016:
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
        LpReportInfo_pf00064.allReport(615, 9);
      }
      label1954:
      label1963:
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(19);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(28);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoButton
 * JD-Core Version:    0.7.0.1
 */