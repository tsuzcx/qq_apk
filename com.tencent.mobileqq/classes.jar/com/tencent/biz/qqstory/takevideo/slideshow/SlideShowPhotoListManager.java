package com.tencent.biz.qqstory.takevideo.slideshow;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.DiffUtil;
import com.tencent.biz.pubaccount.util.DiffUtil.DiffResult;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import oln;
import olo;
import olv;

public class SlideShowPhotoListManager
  implements View.OnClickListener
{
  public static final int a;
  public static boolean a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SlideShowPhotoListManager.SlideShowActionListener jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowActionListener;
  private SlideShowPhotoListManager.SlideShowAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowAdapter;
  private List jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
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
    c();
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
  
  public static void a(Activity paramActivity, List paramList)
  {
    a(paramActivity, paramList, 720, 1280, 20);
    StoryReportor.a("video_edit", "choose_slides", 0, 0, new String[] { String.valueOf(paramList.size()) });
  }
  
  @TargetApi(18)
  public static void a(Activity paramActivity, List paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramActivity == null) || (paramList == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowPhotoListManager", 2, "activity == null || imgPathList == null");
      }
      return;
    }
    jdField_a_of_type_Boolean = false;
    QQProgressNotifier localQQProgressNotifier = new QQProgressNotifier(paramActivity, 2130970578);
    localQQProgressNotifier.a(0, paramActivity.getString(2131439328), 0, new oln());
    EglHandlerThread localEglHandlerThread = new EglHandlerThread("pic_transitions", null);
    localEglHandlerThread.start();
    ThreadManager.getUIHandler().postDelayed(new olo(localEglHandlerThread, paramInt1, paramInt2, paramList, paramInt3, localQQProgressNotifier, paramActivity), 200L);
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
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131371936);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131371937);
    if (this.d == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845806);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371940));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(this.jdField_a_of_type_AndroidAppActivity, 0, false));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowAdapter = new SlideShowPhotoListManager.SlideShowAdapter(this);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowAdapter);
      new ItemTouchHelper(new SlideShowItemTouchCallback(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowAdapter)).a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371938));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371939));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      d();
      return;
      if (this.d == 1)
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131492914));
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  private void d()
  {
    boolean bool = true;
    int i = this.jdField_a_of_type_JavaUtilList.size();
    label89:
    TextView localTextView;
    if (i > 0) {
      if (this.d == 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131492997));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131439327, new Object[] { Integer.valueOf(i), Integer.valueOf(this.c) }));
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131439326, new Object[] { Integer.valueOf(this.c) }));
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
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
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
  
  public void a(@NonNull List paramList)
  {
    paramList = b(paramList);
    DiffUtil.DiffResult localDiffResult = DiffUtil.a(new olv(this.jdField_a_of_type_JavaUtilList, paramList));
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    localDiffResult.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager$SlideShowAdapter);
    d();
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131371935: 
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