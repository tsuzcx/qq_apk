package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.av.utils.UITools;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.BaseActivity;

public class MultiMembersVideoUI
  extends RelativeLayout
  implements MultiMembersUI
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new MultiMembersVideoUI.2(this);
  View jdField_a_of_type_AndroidViewView = null;
  AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new MultiMembersVideoUI.1(this);
  GridView jdField_a_of_type_AndroidWidgetGridView = null;
  HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView = null;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  MultiMembersVideoUI.MVAdapter jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI$MVAdapter = null;
  MultiVideoMembersClickListener jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener = null;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference = null;
  ArrayList<MultiMembersUI.MVMembersInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  
  public MultiMembersVideoUI(Context paramContext)
  {
    super(paramContext);
  }
  
  @TargetApi(9)
  public MultiMembersVideoUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    paramContext = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get activity");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)paramContext.getAppRuntime());
    paramAttributeSet = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (paramAttributeSet == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get AppRuntime");
      }
      paramContext.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = paramAttributeSet.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get videoControl");
      }
      paramContext.finish();
      return;
    }
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559734, null);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371669));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371667));
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(-1);
    this.jdField_a_of_type_AndroidWidgetGridView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setOverScrollMode(2);
      this.jdField_a_of_type_AndroidWidgetGridView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI$MVAdapter = new MultiMembersVideoUI.MVAdapter(this);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI$MVAdapter);
    this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_AndroidWidgetGridView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    super.addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  int a()
  {
    long l = this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getScrollX();
    int i = this.jdField_b_of_type_Int;
    if (i > 0) {
      return (int)l / i;
    }
    return 0;
  }
  
  void a()
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = this.jdField_a_of_type_Int;
    if (((j == 1) || (j == 2)) && (i > 8)) {
      i = this.jdField_b_of_type_Int * 8;
    } else {
      i *= this.jdField_b_of_type_Int;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
    localLayoutParams.width = i;
    this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI$MVAdapter.notifyDataSetChanged();
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    if (paramArrayList != null)
    {
      b(paramArrayList);
      b();
      a();
    }
  }
  
  void b()
  {
    Object localObject = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = UITools.a(((BaseActivity)localObject).getApplicationContext());
    this.jdField_b_of_type_Int = ((BaseActivity)localObject).getResources().getDimensionPixelSize(2131297834);
    this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.jdField_b_of_type_Int);
    double d;
    if (this.jdField_a_of_type_Boolean)
    {
      if (i <= 4)
      {
        i = (j - this.jdField_b_of_type_Int * i) / 2;
        break label198;
      }
      d = j;
      Double.isNaN(d);
      this.jdField_b_of_type_Int = ((int)(d / 4.5D));
      this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.jdField_b_of_type_Int);
    }
    else
    {
      if (i <= 6)
      {
        i = ((BaseActivity)localObject).getResources().getDimensionPixelSize(2131297836);
        this.jdField_b_of_type_Int = ((j - i * 2) / 6);
        this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.jdField_b_of_type_Int);
        break label198;
      }
      d = j;
      Double.isNaN(d);
      this.jdField_b_of_type_Int = ((int)(d / 6.5D));
      this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.jdField_b_of_type_Int);
    }
    i = 0;
    label198:
    j = i;
    if (i < 0) {
      j = 0;
    }
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).leftMargin = j;
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  void b(ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMembersVideoUI", 2, "refreshDataSource");
    }
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMembersVideoUI", 2, "refreshDataSource-->friends list is null");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int i = 0;
    while (i < paramArrayList.size())
    {
      VideoController.GAudioFriends localGAudioFriends = (VideoController.GAudioFriends)paramArrayList.get(i);
      MultiMembersUI.MVMembersInfo localMVMembersInfo = new MultiMembersUI.MVMembersInfo();
      localMVMembersInfo.jdField_a_of_type_Long = localGAudioFriends.jdField_a_of_type_Long;
      localMVMembersInfo.jdField_a_of_type_Int = localGAudioFriends.jdField_b_of_type_Int;
      localMVMembersInfo.jdField_b_of_type_Boolean = localGAudioFriends.jdField_b_of_type_Boolean;
      localMVMembersInfo.jdField_a_of_type_Boolean = localGAudioFriends.jdField_a_of_type_Boolean;
      localMVMembersInfo.c = localGAudioFriends.c;
      localMVMembersInfo.jdField_b_of_type_Int = localGAudioFriends.d;
      localMVMembersInfo.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = localGAudioFriends.jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
      localMVMembersInfo.e = localGAudioFriends.e;
      localMVMembersInfo.f = localGAudioFriends.h;
      this.jdField_a_of_type_JavaUtilArrayList.add(localMVMembersInfo);
      i += 1;
    }
  }
  
  public void c()
  {
    int j = a();
    boolean bool2 = false;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    int k = Math.min(i + 4, this.jdField_a_of_type_JavaUtilArrayList.size());
    j = i;
    boolean bool1;
    for (;;)
    {
      bool1 = bool2;
      if (j >= k) {
        break;
      }
      if (!((MultiMembersUI.MVMembersInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j)).d)
      {
        bool1 = true;
        break;
      }
      j += 1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshHeadbitmap-->minIndex=");
      localStringBuilder.append(i);
      localStringBuilder.append(",maxIndex=");
      localStringBuilder.append(k);
      localStringBuilder.append(",needRefresh=");
      localStringBuilder.append(bool1);
      QLog.d("MultiMembersVideoUI", 2, localStringBuilder.toString());
    }
    if (bool1) {
      this.jdField_a_of_type_ComTencentAvUiMultiMembersVideoUI$MVAdapter.notifyDataSetChanged();
    }
  }
  
  public void setOnItemClickListener(MultiVideoMembersClickListener paramMultiVideoMembersClickListener)
  {
    this.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener = paramMultiVideoMembersClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiMembersVideoUI
 * JD-Core Version:    0.7.0.1
 */