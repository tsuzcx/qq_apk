package com.tencent.biz.qqstory.takevideo.slideshow;

import android.app.Activity;
import android.content.res.Resources;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.DiffUtil;
import com.tencent.biz.pubaccount.util.DiffUtil.DiffResult;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.biz.qqstory.utils.Image2Video;
import com.tencent.biz.qqstory.utils.Image2Video.Image2VideoListener;
import com.tencent.biz.qqstory.utils.Image2Video.ResultInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;
import dov.com.qq.im.setting.CaptureEntranceParams;
import dov.com.tencent.mobileqq.richmedia.capture.util.JumpUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import oqc;
import oqh;

public class SlideShowPhotoListManager
  implements View.OnClickListener, Image2Video.Image2VideoListener
{
  public static final int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SlideShowPhotoListManager.SlideShowActionListener jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowActionListener;
  private SlideShowPhotoListManager.SlideShowAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowAdapter;
  private Image2Video jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video = new Image2Video();
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  private CameraCaptureView.VideoCaptureResult jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult;
  private QQProgressNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
  private CaptureEntranceParams jdField_a_of_type_DovComQqImSettingCaptureEntranceParams;
  Runnable jdField_a_of_type_JavaLangRunnable = new oqc(this);
  private List jdField_a_of_type_JavaUtilList;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  
  static
  {
    jdField_a_of_type_Int = DisplayUtil.a(BaseApplicationImpl.getApplication(), 62.0F);
  }
  
  public SlideShowPhotoListManager(Activity paramActivity, SlideShowPhotoListManager.SlideShowActionListener paramSlideShowActionListener, List paramList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowActionListener = paramSlideShowActionListener;
    this.jdField_a_of_type_JavaUtilList = b(paramList);
    this.c = paramInt1;
    this.d = paramInt2;
    e();
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video.a();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      b(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  private static List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((SlideShowPhotoListManager.SlideItemInfo)paramList.next()).jdField_a_of_type_JavaLangString);
    }
    return localArrayList;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      if ((!paramBoolean) || (this.jdField_b_of_type_Int == paramInt)) {
        break label47;
      }
    }
    label47:
    for (this.jdField_b_of_type_Int = paramInt;; this.jdField_b_of_type_Int = -1)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowAdapter.notifyItemChanged(paramInt, Integer.valueOf(0));
      return;
    }
  }
  
  private String b()
  {
    String str = "" + System.currentTimeMillis();
    str = AppConstants.aK + "multipicset/" + str + "/" + str + ".mp4";
    File localFile = new File(str);
    if (!localFile.getParentFile().exists()) {
      localFile.getParentFile().mkdirs();
    }
    return str;
  }
  
  private static List b(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      SlideShowPhotoListManager.SlideItemInfo localSlideItemInfo = new SlideShowPhotoListManager.SlideItemInfo((String)paramList.get(i));
      if (localSlideItemInfo.jdField_a_of_type_JavaNetURL != null) {
        localArrayList.add(localSlideItemInfo);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void b(Activity paramActivity, List paramList)
  {
    StoryReportor.a("video_edit", "choose_slides", 0, 0, new String[] { String.valueOf(paramList.size()) });
  }
  
  private void b(@NonNull List paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video.c();
      TransitionHandler localTransitionHandler = (TransitionHandler)QQStoryContext.a().getBusinessHandler(1);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SlideShowPhotoListManager.SlideItemInfo localSlideItemInfo = (SlideShowPhotoListManager.SlideItemInfo)paramList.next();
        if ((!TextUtils.isEmpty(localSlideItemInfo.jdField_a_of_type_JavaLangString)) && (!localTransitionHandler.b(localSlideItemInfo.jdField_a_of_type_JavaLangString)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("SlideShowPhotoListManager", 2, "convertToVideo path = " + localSlideItemInfo.jdField_a_of_type_JavaLangString);
          }
          this.jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video.a(localSlideItemInfo.jdField_a_of_type_JavaLangString, this);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("SlideShowPhotoListManager", 2, "combine video mConvertProcessor is null");
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131371944);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131371945);
    if (this.d == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845887);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371948));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 0, false));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowAdapter = new SlideShowPhotoListManager.SlideShowAdapter(this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowAdapter);
      new ItemTouchHelper(new SlideShowItemTouchCallback(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowAdapter)).a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371946));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371947));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.jdField_a_of_type_AndroidAppActivity, 2130970591);
      g();
      return;
      if (this.d == 1)
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131492914));
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  private void f()
  {
    TransitionHandler localTransitionHandler = (TransitionHandler)QQStoryContext.a().getBusinessHandler(1);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        SlideShowPhotoListManager.SlideItemInfo localSlideItemInfo = (SlideShowPhotoListManager.SlideItemInfo)localIterator.next();
        if (localTransitionHandler.a(localSlideItemInfo.jdField_a_of_type_JavaLangString) == null) {
          if (QLog.isColorLevel()) {
            QLog.d("SlideShowPhotoListManager", 2, "checkAllImageHandle allFinish picInfo.mPath =" + localSlideItemInfo.jdField_a_of_type_JavaLangString);
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SlideShowPhotoListManager", 2, "checkAllImageHandle allFinish push merge runnable");
        }
        this.jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video.a().post(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
    }
  }
  
  private void g()
  {
    boolean bool = true;
    int i = this.jdField_a_of_type_JavaUtilList.size();
    label89:
    TextView localTextView;
    if (i > 0) {
      if (this.d == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131492997));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131439359, new Object[] { Integer.valueOf(i), Integer.valueOf(this.c) }));
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
        localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
        if (i < 2) {
          break label199;
        }
      }
    }
    for (;;)
    {
      localTextView.setEnabled(bool);
      return;
      if (this.d != 1) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131492969));
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131493420));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131439358, new Object[] { Integer.valueOf(this.c) }));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
      break label89;
      label199:
      bool = false;
    }
  }
  
  public String a()
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_b_of_type_Int >= 0)
    {
      str1 = str2;
      if (this.jdField_b_of_type_Int < this.jdField_a_of_type_JavaUtilList.size()) {
        str1 = ((SlideShowPhotoListManager.SlideItemInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int)).jdField_a_of_type_JavaLangString;
      }
    }
    return str1;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SlideShowPhotoListManager", 2, "onResume");
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      JumpUtil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams, null, 7, this.jdField_a_of_type_AndroidOsBundle);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0) {
      if (this.jdField_b_of_type_Int < 0) {
        a(paramInt, true);
      }
    }
    while (this.jdField_b_of_type_Int < 0)
    {
      return;
      a(this.jdField_b_of_type_Int, false);
      a(paramInt, true);
      return;
    }
    a(this.jdField_b_of_type_Int, false);
  }
  
  public void a(Activity paramActivity, List paramList)
  {
    if ((paramActivity == null) || (paramList == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowPhotoListManager", 2, "activity == null || imgPathList == null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("SlideShowPhotoListManager", 2, "createSlideShowNew mReqCombine =" + this.jdField_a_of_type_Boolean);
      }
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, paramActivity.getString(2131439360), 0);
    this.jdField_a_of_type_Boolean = true;
    f();
  }
  
  public void a(Image2Video.ResultInfo paramResultInfo)
  {
    String str;
    LocalMediaInfo localLocalMediaInfo;
    Object localObject;
    if (paramResultInfo.jdField_a_of_type_Int == 0)
    {
      str = paramResultInfo.jdField_a_of_type_JavaLangString;
      localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.path = paramResultInfo.b;
      localLocalMediaInfo.mMimeType = "video";
      localObject = MediaScanner.a(BaseApplicationImpl.getContext());
    }
    for (;;)
    {
      try
      {
        ((MediaScanner)localObject).b(localLocalMediaInfo);
        localObject = (TransitionHandler)QQStoryContext.a().getBusinessHandler(1);
        ((TransitionHandler)localObject).a(str, localLocalMediaInfo);
        if (((TransitionHandler)localObject).a() == null) {
          ((TransitionHandler)localObject).a(paramResultInfo.jdField_a_of_type_AndroidMediaMediaFormat);
        }
        if (QLog.isColorLevel()) {
          QLog.e("SlideShowPhotoListManager", 2, "onImage2VideoResult RESULT_SUCC mReqCombine =" + this.jdField_a_of_type_Boolean);
        }
        if (this.jdField_a_of_type_Boolean) {
          f();
        }
        if (QLog.isColorLevel()) {
          QLog.e("SlideShowPhotoListManager", 2, "onImage2VideoResult " + paramResultInfo);
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        QLog.e("SlideShowPhotoListManager", 1, "pic2video err", localThrowable);
        continue;
      }
      if (paramResultInfo.jdField_a_of_type_Int == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SlideShowPhotoListManager", 2, "onImage2VideoResult cancel" + paramResultInfo);
        }
      }
      else if (paramResultInfo.jdField_a_of_type_Int == 5)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SlideShowPhotoListManager", 2, "onImage2VideoResult fail load");
        }
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "图片加载失败，请稍后再试", 0).a();
      }
      else
      {
        this.jdField_a_of_type_Boolean = false;
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "处理失败，请稍后再试", 0).a();
      }
    }
  }
  
  public void a(@NonNull List paramList)
  {
    paramList = b(paramList);
    DiffUtil.DiffResult localDiffResult = DiffUtil.a(new oqh(this.jdField_a_of_type_JavaUtilList, paramList));
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    localDiffResult.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowAdapter);
    g();
    b(paramList);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video.c();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131371943: 
      int i;
      do
      {
        return;
        paramView = (SlideShowPhotoListManager.SlideItemInfo)paramView.getTag();
        i = this.jdField_a_of_type_JavaUtilList.indexOf(paramView);
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowActionListener != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowActionListener.a(paramView.jdField_a_of_type_JavaLangString);
        }
      } while (this.d != 1);
      a(i);
      return;
    }
    a(this.jdField_a_of_type_AndroidAppActivity, a(this.jdField_a_of_type_JavaUtilList));
    StoryReportor.a("pic_choose_slides", "clk_create", 0, 0, new String[] { "0", this.jdField_a_of_type_JavaUtilList.size() + "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager
 * JD-Core Version:    0.7.0.1
 */