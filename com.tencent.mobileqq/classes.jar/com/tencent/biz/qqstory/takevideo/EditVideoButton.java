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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

@TargetApi(11)
public class EditVideoButton
  extends EditVideoPart
  implements View.OnClickListener, EditButtonExport
{
  public static final SparseArray<EditVideoButton.EntryButtonInfo> a;
  public static final int[] a;
  public int a;
  private long jdField_a_of_type_Long = 0L;
  private LayoutTransition jdField_a_of_type_AndroidAnimationLayoutTransition = new LayoutTransition();
  protected SparseIntArray a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean;
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView;
  private SparseArray<ImageView> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131366129, 2131366130, 2131366132, 2131366133, 2131366134, 2131366135, 2131366136, 2131366137, 2131366138, 2131366139, 2131366131 };
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_AndroidUtilSparseArray.put(32, new EditVideoButton.EntryButtonInfo(32, 2130847006, HardCodeUtil.a(2131703857)));
    jdField_a_of_type_AndroidUtilSparseArray.put(1, new EditVideoButton.EntryButtonInfo(1, 2130846921, HardCodeUtil.a(2131703858)));
    jdField_a_of_type_AndroidUtilSparseArray.put(4, new EditVideoButton.EntryButtonInfo(4, 2130847215, HardCodeUtil.a(2131703782)));
    jdField_a_of_type_AndroidUtilSparseArray.put(8, new EditVideoButton.EntryButtonInfo(8, 2130846862, HardCodeUtil.a(2131703916)));
    jdField_a_of_type_AndroidUtilSparseArray.put(128, new EditVideoButton.EntryButtonInfo(128, 2130847049, HardCodeUtil.a(2131703876)));
    jdField_a_of_type_AndroidUtilSparseArray.put(16, new EditVideoButton.EntryButtonInfo(16, 2130846751, HardCodeUtil.a(2131703801)));
    jdField_a_of_type_AndroidUtilSparseArray.put(2, new EditVideoButton.EntryButtonInfo(2, 2130846847, HardCodeUtil.a(2131703750)));
    jdField_a_of_type_AndroidUtilSparseArray.put(131072, new EditVideoButton.EntryButtonInfo(131072, 2130847188, HardCodeUtil.a(2131703834)));
    jdField_a_of_type_AndroidUtilSparseArray.put(1024, new EditVideoButton.EntryButtonInfo(1024, 2130846232, HardCodeUtil.a(2131703762)));
    jdField_a_of_type_AndroidUtilSparseArray.put(4096, new EditVideoButton.EntryButtonInfo(4096, 2130846902, "GIF快慢"));
    jdField_a_of_type_AndroidUtilSparseArray.put(8192, new EditVideoButton.EntryButtonInfo(8192, 2130846886, "生成GIF"));
    jdField_a_of_type_AndroidUtilSparseArray.put(262144, new EditVideoButton.EntryButtonInfo(262144, 2130846916, "跳转到P图"));
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
      paramImageView.setColorFilter(a().getColor(2131166508), PorterDuff.Mode.MULTIPLY);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramImageView = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(32);
      if (paramImageView != null) {
        paramImageView.setColorFilter(a().getColor(2131166510), PorterDuff.Mode.MULTIPLY);
      }
    }
  }
  
  private void a(View... paramVarArgs)
  {
    float f1 = FontSettingManager.getFontLevel();
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
        break label418;
      }
      paramInt += 1;
    }
    label418:
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
        g();
      }
      return arrayOfImageView;
    }
  }
  
  private void g()
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
    } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.b);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText("0%");
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848493);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
  }
  
  public void U_()
  {
    super.U_();
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131365360));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131365359));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = a(2131372873);
    this.jdField_b_of_type_AndroidViewView = a(2131372868);
    this.jdField_c_of_type_AndroidViewView = a(2131372878);
    a(this.jdField_b_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131364261));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)a(2131366398));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131366397));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = a(this.jdField_a_of_type_Int, this.jdField_b_of_type_AndroidViewViewGroup, this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131379680));
    Object localObject;
    if ((this.jdField_a_of_type_Int & 0x400) != 0)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject = (EditVideoButton.EntryButtonInfo)jdField_a_of_type_AndroidUtilSparseArray.get(1024);
    }
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(a(), ((EditVideoButton.EntryButtonInfo)localObject).b);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(localBitmap));
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(((EditVideoButton.EntryButtonInfo)localObject).a);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView = a(2131378870);
      if ((this.jdField_a_of_type_Int & 0x400000) != 0)
      {
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131362768));
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131362772));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131362769));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131362770));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131362771));
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
          break label683;
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
        StoryReportor.a("pub_control", "exp_entry", 0, 0, new String[0]);
        if (!(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeGifSource)) {
          break label695;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131703736));
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131703923));
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle;
        if ((localObject != null) && (((Bundle)localObject).getInt("video_redbag_get", 0) == LocalMediaInfo.REDBAG_TYPE_GET))
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131364264));
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          SLog.d("Q.qqstory.record.EditVideoButton", "VideoRedbag, editVideoButton show redbag tips");
        }
        a(EditButtonExport.class, this);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        SLog.e("Q.qqstory.record.EditVideoButton", "decodeResource OutOfMemoryError : %s", new Object[] { ((EditVideoButton.EntryButtonInfo)localObject).a });
        continue;
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        continue;
        label683:
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        continue;
        label695:
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131703911));
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131703746));
        }
        else if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.c())
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131703878));
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131703960));
        }
        else if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.d()) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131703830));
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131703897));
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131703956));
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131703776));
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
  }
  
  void a(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() != 104) {
        break label48;
      }
      paramView.setText(HardCodeUtil.a(2131703926));
      paramView.setContentDescription(HardCodeUtil.a(2131703921));
    }
    label48:
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 2))
      {
        paramView.setText(HardCodeUtil.a(2131703903));
        paramView.setContentDescription(HardCodeUtil.a(2131703759));
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
        paramView.setText(HardCodeUtil.a(2131703744));
        paramView.setContentDescription(HardCodeUtil.a(2131703913));
        return;
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 6))
      {
        paramView.setText(HardCodeUtil.a(2131703772));
        paramView.setContentDescription(HardCodeUtil.a(2131703952));
        return;
      }
    } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 8);
    paramView.setText(HardCodeUtil.a(2131703761));
    paramView.setContentDescription(HardCodeUtil.a(2131703928));
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848059);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848060);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
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
          TakeVideoUtils.b(this.jdField_a_of_type_AndroidViewView, paramBoolean3);
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
          TakeVideoUtils.a(this.jdField_a_of_type_AndroidViewView, paramBoolean3);
        }
      }
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setAnimation(null);
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramBoolean1) {}
    for (int i = 0;; i = 8)
    {
      localViewGroup.setVisibility(i);
      this.jdField_c_of_type_Long = 0L;
      break;
    }
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (!paramBoolean1)) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
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
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    int j;
    if (Math.abs(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) > 1000L)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      j = paramView.getId();
      if (this.jdField_c_of_type_Long <= System.currentTimeMillis()) {
        break label63;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SLog.d("Q.qqstory.record.EditVideoButton", "you click button too fast, ignore it !");
      continue;
      label63:
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      Object localObject1 = jdField_a_of_type_ArrayOfInt;
      int k = localObject1.length;
      int i = 0;
      for (;;)
      {
        if (i >= k) {
          break label1434;
        }
        if (localObject1[i] == j)
        {
          i = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(j);
          SLog.d("Q.qqstory.record.EditVideoButton", "onClick : mask=%d, view=%s", new Object[] { Integer.valueOf(i), paramView });
          j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(Message.obtain(null, 1, i, 0, paramView));
          if (j > 0)
          {
            SLog.c("Q.qqstory.record.EditVideoButton", "%d parts intercept the click event : " + j);
            break;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.p();
          switch (i)
          {
          }
          for (;;)
          {
            break;
            bool = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b(4);
            localObject1 = (AddressDataProvider)((DataProviderManager)SuperManager.a(20)).a(1);
            if (((AddressDataProvider)localObject1).a((AddressDataProvider.AddressInfo)((AddressDataProvider)localObject1).a()))
            {
              localObject1 = "2";
              label351:
              if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
                break label431;
              }
              localObject2 = "2";
              label366:
              if (!bool) {
                break label439;
              }
            }
            label431:
            label439:
            for (String str = "1";; str = "0")
            {
              StoryReportor.a("video_edit", "clk_music", 0, 0, new String[] { localObject2, localObject1, str, "" });
              this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(2);
              break;
              localObject1 = "1";
              break label351;
              localObject2 = "1";
              break label366;
            }
            bool = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b(5);
            if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a())
            {
              localObject1 = "2";
              label472:
              if (!bool) {
                break label620;
              }
              localObject2 = "1";
              label482:
              StoryReportor.a("video_edit", "clk_graffiti", 0, 0, new String[] { localObject1, "", localObject2, "" });
              this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a("608", "10", "0", true);
              VideoEditReport.b("0X80075C4", VideoEditReport.jdField_a_of_type_Int);
              if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3))
              {
                if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) {
                  break label628;
                }
                LpReportInfo_pf00064.allReport(628, 3);
              }
            }
            for (;;)
            {
              if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(7)) {
                break label639;
              }
              this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
              break;
              localObject1 = "1";
              break label472;
              label620:
              localObject2 = "0";
              break label482;
              label628:
              LpReportInfo_pf00064.allReport(615, 1, 1);
            }
            label639:
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(7);
            continue;
            VideoEditReport.b("0X80075C6", VideoEditReport.jdField_a_of_type_Int);
            if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3))
            {
              if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) {
                break label718;
              }
              LpReportInfo_pf00064.allReport(628, 2);
            }
            for (;;)
            {
              this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(5, Boolean.TRUE);
              break;
              label718:
              LpReportInfo_pf00064.allReport(615, 3, 1);
            }
            bool = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b(3);
            if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a())
            {
              localObject1 = "2";
              label754:
              if (!bool) {
                break label902;
              }
              localObject2 = "1";
              label764:
              StoryReportor.a("video_edit", "add_face", 0, 0, new String[] { localObject1, "", localObject2, "" });
              VideoEditReport.b("0X80075C7", VideoEditReport.jdField_a_of_type_Int);
              if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3))
              {
                if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) {
                  break label910;
                }
                LpReportInfo_pf00064.allReport(628, 4);
              }
            }
            for (;;)
            {
              this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a("608", "11", "0", true);
              if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(6)) {
                break label921;
              }
              this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
              break;
              localObject1 = "1";
              break label754;
              label902:
              localObject2 = "0";
              break label764;
              label910:
              LpReportInfo_pf00064.allReport(615, 4, 1);
            }
            label921:
            ((DoodleEmojiManager)SuperManager.a(8)).a(false);
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(6);
            continue;
            Object localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager;
            if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {}
            for (localObject1 = "2";; localObject1 = "1")
            {
              ((EditVideoPartManager)localObject2).a("add_tag", 0, 0, new String[] { localObject1 });
              this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(1);
              break;
            }
            VideoEditReport.b("0X80075C8", VideoEditReport.jdField_a_of_type_Int);
            if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
              LpReportInfo_pf00064.allReport(615, 5, 1);
            }
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.s();
            continue;
            VideoEditReport.b("0X80075C5", VideoEditReport.jdField_a_of_type_Int);
            if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
              LpReportInfo_pf00064.allReport(615, 2, 1);
            }
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.q();
            continue;
            StoryReportor.a("video_edit", "share_to_group", 0, 0, new String[0]);
            StoryReportor.a("story_grp", "clk_share_grp", 0, 0, new String[] { "", "", "", "" });
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(25);
            continue;
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(19);
            continue;
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(21);
            if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
              if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e())
              {
                LpReportInfo_pf00064.allReport(628, 5, 1);
              }
              else
              {
                LpReportInfo_pf00064.allReport(615, 5, 1);
                continue;
                if (!this.jdField_a_of_type_Boolean) {
                  bool = true;
                }
                this.jdField_a_of_type_Boolean = bool;
                this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(this.jdField_a_of_type_Boolean);
                localObject1 = (ImageView)paramView;
                localObject2 = (ImageView)this.jdField_b_of_type_AndroidUtilSparseArray.get(32);
                if (this.jdField_a_of_type_Boolean)
                {
                  ((ImageView)localObject1).setImageResource(2130846887);
                  if (localObject2 != null) {
                    ((ImageView)localObject2).setColorFilter(a().getColor(2131166510), PorterDuff.Mode.MULTIPLY);
                  }
                }
                else
                {
                  ((ImageView)localObject1).setImageResource(2130846886);
                  if (localObject2 != null)
                  {
                    ((ImageView)localObject2).clearColorFilter();
                    continue;
                    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
                      LpReportInfo_pf00064.allReport(615, 11);
                    }
                    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b == 26) {
                      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
                    } else {
                      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(26);
                    }
                  }
                }
              }
            }
          }
        }
        i += 1;
      }
      switch (j)
      {
      default: 
        break;
      case 2131362768: 
        h();
        break;
      case 2131365359: 
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
          LpReportInfo_pf00064.allReport(615, 8);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.e();
        break;
      case 2131365360: 
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
          LpReportInfo_pf00064.allReport(615, 10);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.d();
          break;
          if (((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 9)) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 10)) {
            ReportController.b(null, "dc00899", "Grp_tribe", "", "video_edit", "Clk_left", 0, 0, "", "", "", "");
          }
        }
      case 2131372868: 
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(22)) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
        } else {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(22);
        }
        break;
      case 2131379680: 
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
          LpReportInfo_pf00064.allReport(615, 9);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(19);
        break;
      case 2131378870: 
        label1434:
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(28);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoButton
 * JD-Core Version:    0.7.0.1
 */