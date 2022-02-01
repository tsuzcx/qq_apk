package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.emotionintegrate.ChatHistoryEmotionAdapter;
import com.tencent.mobileqq.emotionintegrate.EmotionDataManager;
import com.tencent.mobileqq.emotionintegrate.EmotionPreviewData;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistoryEmotionView
  extends ChatHistoryViewBase
  implements Handler.Callback, AbsListView.OnScrollListener, AdapterView.OnItemClickListener, GestureSelectGridView.OnSelectListener
{
  private int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  public ChatHistoryEmotionView.OperateCallBack a;
  public ChatHistoryEmotionAdapter a;
  private EmotionDataManager jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataManager;
  private final WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private GestureSelectGridView jdField_a_of_type_ComTencentWidgetGestureSelectGridView;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = -2147483648;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 2147483647;
  private boolean jdField_d_of_type_Boolean = false;
  
  private boolean a(EmotionPreviewData paramEmotionPreviewData, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null) {
      if (paramEmotionPreviewData.jdField_a_of_type_Boolean != paramBoolean)
      {
        if (!paramBoolean) {
          break label46;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a()) {
          return false;
        }
        paramEmotionPreviewData.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramEmotionPreviewData);
      }
    }
    for (;;)
    {
      return true;
      label46:
      paramEmotionPreviewData.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramEmotionPreviewData);
      continue;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView$OperateCallBack != null) && (paramEmotionPreviewData.jdField_a_of_type_Boolean != paramBoolean))
      {
        if (paramBoolean)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView$OperateCallBack.a()) {
            break;
          }
          paramEmotionPreviewData.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView$OperateCallBack.a(paramEmotionPreviewData);
          continue;
        }
        paramEmotionPreviewData.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView$OperateCallBack.b(paramEmotionPreviewData);
      }
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.a() <= paramInt);
      localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.a(paramInt);
    } while (!EmotionPreviewData.class.isInstance(localObject));
    Object localObject = (EmotionPreviewData)localObject;
    this.jdField_d_of_type_Boolean = ((EmotionPreviewData)localObject).jdField_a_of_type_Boolean;
    if (!this.jdField_d_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      if (a((EmotionPreviewData)localObject, bool)) {
        this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
      }
      this.jdField_c_of_type_Boolean = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChatHistoryEmotionView", 2, "onSelectBegin");
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!this.jdField_b_of_type_Boolean) {}
    while (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryEmotionView", 2, new Object[] { "onSelectBegin beginIndex:", Integer.valueOf(paramInt1), "  selectIndex:", Integer.valueOf(paramInt2) });
    }
    int j;
    int i;
    if (paramInt2 < paramInt1)
    {
      j = paramInt1;
      i = paramInt2;
      if (this.jdField_d_of_type_Int > paramInt2)
      {
        this.jdField_d_of_type_Int = paramInt2;
        i = paramInt2;
        j = paramInt1;
      }
    }
    for (;;)
    {
      paramInt1 = i;
      for (;;)
      {
        if (paramInt1 > j) {
          break label174;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.a(paramInt1);
        if (EmotionPreviewData.class.isInstance(localObject)) {
          break;
        }
        paramInt1 += 1;
      }
      if (this.jdField_c_of_type_Int < paramInt2) {
        this.jdField_c_of_type_Int = paramInt2;
      }
      j = paramInt2;
      i = paramInt1;
    }
    Object localObject = (EmotionPreviewData)localObject;
    if (!this.jdField_d_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      a((EmotionPreviewData)localObject, bool);
      break;
    }
    label174:
    paramInt1 = j + 1;
    if (paramInt1 <= this.jdField_c_of_type_Int)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.a(paramInt1);
      if (!EmotionPreviewData.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        a((EmotionPreviewData)localObject, this.jdField_d_of_type_Boolean);
      }
    }
    paramInt1 = this.jdField_d_of_type_Int;
    if (paramInt1 < i)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.a(paramInt1);
      if (!EmotionPreviewData.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        a((EmotionPreviewData)localObject, this.jdField_d_of_type_Boolean);
      }
    }
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((MessageRecord)((Iterator)localObject).next()).uniseq != paramLong);
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryEmotionView", 2, "onRevokeMsg notContain seq:" + paramLong);
        }
        return;
      }
      if (paramLong == this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new ChatHistoryEmotionView.4(this));
        return;
      }
      g();
      return;
    }
  }
  
  public void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_Long = paramIntent.getLongExtra("msg_revoke_uniseq", 0L);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataManager = new EmotionDataManager(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560939, null);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368061));
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(false);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366349);
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_b_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131692473));
    }
    int i = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297499);
    int j = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297500);
    int k = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297501);
    int m = (ViewUtils.a() - i * 2 - j * 3) / 4;
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setGravity(3);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(4);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(m);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(j);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(k);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setPadding(i, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingTop(), i, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter = new ChatHistoryEmotionAdapter(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataManager, this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, m, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.a(true);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(false);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setTouchSlopRate(3);
    AccessibilityUtil.a(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView, false);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.a(true);
    ThreadManager.excute(new ChatHistoryEmotionView.1(this), 32, null, false);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.a();
    }
    return false;
  }
  
  public void b()
  {
    AbstractGifImage.resumeAll();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    AbstractGifImage.pauseAll();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.b();
  }
  
  public void e()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(true);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.notifyDataSetChanged();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(false);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.notifyDataSetChanged();
    }
  }
  
  public void g()
  {
    ThreadManager.excute(new ChatHistoryEmotionView.2(this), 32, null, false);
  }
  
  public void h()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (!this.jdField_c_of_type_Boolean);
      this.jdField_c_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_c_of_type_Int = -2147483648;
      this.jdField_d_of_type_Int = 2147483647;
    } while (!QLog.isColorLevel());
    QLog.d("ChatHistoryEmotionView", 2, "onSelectEnd");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label86:
    label112:
    for (;;)
    {
      return false;
      Object localObject;
      if (paramMessage.obj == null)
      {
        localObject = new ArrayList();
        if (paramMessage.arg1 != 1) {
          break label86;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.a((List)localObject);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView$OperateCallBack == null) {
          break label112;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryEmotionView$OperateCallBack.a();
        return false;
        localObject = (List)paramMessage.obj;
        break;
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.b((List)localObject);
        if (((List)localObject).isEmpty()) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        }
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.getItem(paramInt);
    if (!EmotionPreviewData.class.isInstance(paramAdapterView)) {}
    for (;;)
    {
      return;
      paramAdapterView = (EmotionPreviewData)paramAdapterView;
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      if (!paramAdapterView.jdField_a_of_type_Boolean) {}
      for (boolean bool = true; a(paramAdapterView, bool); bool = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.notifyDataSetChanged();
        return;
      }
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localSessionInfo.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    AIOEmotionFragment.a(paramView.getContext(), paramAdapterView.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localSessionInfo, AnimationUtils.a(paramView));
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition();
      int i = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.a();
      int j = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.b();
      if (((paramInt >= i - 28) || (paramInt == i)) && (this.jdField_a_of_type_Int != j))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryEmotionView", 2, "[onScroll] loadEmotion: mLastLoadingCount=" + this.jdField_a_of_type_Int);
        }
        this.jdField_a_of_type_Int = j;
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.a(true);
        ThreadManager.excute(new ChatHistoryEmotionView.3(this), 32, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryEmotionView
 * JD-Core Version:    0.7.0.1
 */