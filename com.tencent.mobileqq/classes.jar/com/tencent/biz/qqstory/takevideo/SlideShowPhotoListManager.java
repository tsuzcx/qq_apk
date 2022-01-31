package com.tencent.biz.qqstory.takevideo;

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
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import ofz;
import oga;
import ogh;

public class SlideShowPhotoListManager
  implements View.OnClickListener
{
  public static final int a;
  public static boolean a;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SlideShowPhotoListManager.SlideShowAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideShowPhotoListManager$SlideShowAdapter;
  private PhotoListActivity jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity;
  private List jdField_a_of_type_JavaUtilList;
  private TextView b;
  
  static
  {
    jdField_a_of_type_Int = DisplayUtil.a(BaseApplicationImpl.getApplication(), 62.0F);
  }
  
  public SlideShowPhotoListManager(PhotoListActivity paramPhotoListActivity, List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity = paramPhotoListActivity;
    this.jdField_a_of_type_JavaUtilList = b(paramList);
    a();
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
  
  private void a()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.findViewById(2131371766);
    localView.setVisibility(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131371770));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, 0, false));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideShowPhotoListManager$SlideShowAdapter = new SlideShowPhotoListManager.SlideShowAdapter(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideShowPhotoListManager$SlideShowAdapter);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371768));
    this.b = ((TextView)localView.findViewById(2131371769));
    this.b.setOnClickListener(this);
    b();
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
    QQProgressNotifier localQQProgressNotifier = new QQProgressNotifier(paramActivity, 2130970534);
    localQQProgressNotifier.a(0, paramActivity.getString(2131439299), 0, new ofz());
    EglHandlerThread localEglHandlerThread = new EglHandlerThread("pic_transitions", null);
    localEglHandlerThread.start();
    ThreadManager.getUIHandler().postDelayed(new oga(localEglHandlerThread, paramInt1, paramInt2, paramList, paramInt3, localQQProgressNotifier, paramActivity), 200L);
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
  
  private void b()
  {
    int j = 8;
    int k = this.jdField_a_of_type_JavaUtilList.size();
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
    label67:
    boolean bool;
    if (k == 0)
    {
      i = 8;
      ((RecyclerView)localObject).setVisibility(i);
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (k <= 0) {
        break label127;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getResources().getString(2131439298, new Object[] { Integer.valueOf(k) });
      localTextView.setText((CharSequence)localObject);
      localObject = this.b;
      if (k < 2) {
        break label134;
      }
      bool = true;
      label88:
      ((TextView)localObject).setEnabled(bool);
      localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break label140;
      }
    }
    label134:
    label140:
    for (int i = j;; i = 0)
    {
      ((RecyclerView)localObject).setVisibility(i);
      return;
      i = 0;
      break;
      label127:
      localObject = "";
      break label67;
      bool = false;
      break label88;
    }
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(@NonNull List paramList)
  {
    paramList = b(paramList);
    DiffUtil.DiffResult localDiffResult = DiffUtil.a(new ogh(this.jdField_a_of_type_JavaUtilList, paramList));
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    localDiffResult.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideShowPhotoListManager$SlideShowAdapter);
    b();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131371765: 
      paramView = (SlideShowPhotoListManager.SlideItemInfo)paramView.getTag();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.a(this.jdField_a_of_type_JavaUtilList.indexOf(paramView));
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, a(this.jdField_a_of_type_JavaUtilList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.SlideShowPhotoListManager
 * JD-Core Version:    0.7.0.1
 */