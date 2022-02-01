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
  public ChatHistoryEmotionAdapter a;
  public ChatHistoryEmotionView.OperateCallBack b;
  long c = 0L;
  boolean d = false;
  private Activity e;
  private View f;
  private GestureSelectGridView g;
  private View h;
  private final WeakReferenceHandler i = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private int j = 0;
  private int k;
  private String l;
  private EmotionDataManager m;
  private boolean n = false;
  private boolean o;
  private boolean p = false;
  private int q = -2147483648;
  private int r = 2147483647;
  
  private boolean a(EmotionPreviewData paramEmotionPreviewData, boolean paramBoolean)
  {
    if (this.D != null)
    {
      if (paramEmotionPreviewData.b != paramBoolean)
      {
        if (paramBoolean)
        {
          if (this.D.b()) {
            return false;
          }
          paramEmotionPreviewData.b = true;
          this.D.a(paramEmotionPreviewData);
          return true;
        }
        paramEmotionPreviewData.b = false;
        this.D.b(paramEmotionPreviewData);
        return true;
      }
    }
    else if ((this.b != null) && (paramEmotionPreviewData.b != paramBoolean))
    {
      if (paramBoolean)
      {
        if (this.b.a()) {
          return false;
        }
        paramEmotionPreviewData.b = true;
        this.b.a(paramEmotionPreviewData);
        return true;
      }
      paramEmotionPreviewData.b = false;
      this.b.b(paramEmotionPreviewData);
    }
    return true;
  }
  
  public View a()
  {
    return this.f;
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.a.e();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((MessageRecord)((Iterator)localObject).next()).uniseq == paramLong)
        {
          i1 = 1;
          break label58;
        }
      }
    }
    int i1 = 0;
    label58:
    if (i1 == 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onRevokeMsg notContain seq:");
        ((StringBuilder)localObject).append(paramLong);
        QLog.d("ChatHistoryEmotionView", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (paramLong == this.c)
    {
      this.i.post(new ChatHistoryEmotionView.4(this));
      return;
    }
    j();
  }
  
  public void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.e = ((Activity)paramContext);
    this.k = paramIntent.getIntExtra("uintype", -1);
    this.l = paramIntent.getStringExtra("uin");
    this.c = paramIntent.getLongExtra("msg_revoke_uniseq", 0L);
    this.m = new EmotionDataManager(this.l, this.k);
    this.f = LayoutInflater.from(paramContext).inflate(2131627072, null);
    this.g = ((GestureSelectGridView)this.f.findViewById(2131434388));
    this.g.setSelectMode(false);
    this.h = this.f.findViewById(2131432529);
    if (AppSetting.e) {
      this.h.setContentDescription(this.e.getString(2131889397));
    }
    int i1 = this.e.getResources().getDimensionPixelSize(2131298139);
    int i2 = this.e.getResources().getDimensionPixelSize(2131298140);
    int i3 = this.e.getResources().getDimensionPixelSize(2131298141);
    int i4 = (ViewUtils.getScreenWidth() - i1 * 2 - i2 * 3) / 4;
    this.g.setGravity(3);
    this.g.setScrollBarStyle(0);
    this.g.setNumColumns(4);
    this.g.setColumnWidth(i4);
    this.g.setHorizontalSpacing(i2);
    this.g.setVerticalSpacing(i3);
    paramIntent = this.g;
    paramIntent.setPadding(i1, paramIntent.getPaddingTop(), i1, this.g.getPaddingBottom());
    this.a = new ChatHistoryEmotionAdapter(this.e, this.m, this.i, i4, this.g);
    this.a.a(true);
    this.a.a(this.k);
    this.g.setAdapter(this.a);
    this.g.setOnItemClickListener(this);
    this.g.setOnScrollListener(this);
    this.g.setOnIndexChangedListener(this);
    this.g.setSelectMode(false);
    this.g.setTouchSlopRate(3);
    AccessibilityUtil.a(this.g, false);
    this.a.b(true);
    ThreadManager.excute(new ChatHistoryEmotionView.1(this), 32, null, false);
  }
  
  public void b()
  {
    ChatHistoryEmotionAdapter localChatHistoryEmotionAdapter = this.a;
    if (localChatHistoryEmotionAdapter != null) {
      localChatHistoryEmotionAdapter.b();
    }
  }
  
  public boolean c()
  {
    ChatHistoryEmotionAdapter localChatHistoryEmotionAdapter = this.a;
    if (localChatHistoryEmotionAdapter != null) {
      return localChatHistoryEmotionAdapter.a();
    }
    return false;
  }
  
  public void d()
  {
    AbstractGifImage.resumeAll();
    this.d = true;
  }
  
  public void e()
  {
    AbstractGifImage.pauseAll();
    this.d = false;
  }
  
  public void f()
  {
    this.a.f();
  }
  
  public void g()
  {
    if (!this.a.g)
    {
      this.n = true;
      this.a.g = true;
      this.g.setSelectMode(true);
      this.a.notifyDataSetChanged();
    }
  }
  
  public void h()
  {
    if (this.a.g)
    {
      this.n = false;
      this.a.g = false;
      this.g.setSelectMode(false);
      this.a.notifyDataSetChanged();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    Object localObject;
    if (paramMessage.obj == null) {
      localObject = new ArrayList();
    } else {
      localObject = (List)paramMessage.obj;
    }
    if (paramMessage.arg1 == 1)
    {
      this.a.a((List)localObject);
    }
    else
    {
      this.a.b((List)localObject);
      if (((List)localObject).isEmpty()) {
        this.h.setVisibility(0);
      }
    }
    paramMessage = this.b;
    if (paramMessage != null) {
      paramMessage.b();
    }
    return false;
  }
  
  public boolean i()
  {
    return this.n;
  }
  
  public void j()
  {
    ThreadManager.excute(new ChatHistoryEmotionView.2(this), 32, null, false);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a.getItem(paramInt);
    if (!EmotionPreviewData.class.isInstance(paramAdapterView)) {
      return;
    }
    paramAdapterView = (EmotionPreviewData)paramAdapterView;
    if (this.n)
    {
      if (a(paramAdapterView, paramAdapterView.b ^ true)) {
        this.a.notifyDataSetChanged();
      }
    }
    else
    {
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.b = this.l;
      localSessionInfo.a = this.k;
      AIOEmotionFragment.a(paramView.getContext(), paramAdapterView.a, localSessionInfo, AnimationUtils.a(paramView));
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = this.g.getLastVisiblePosition();
      int i1 = this.a.c();
      int i2 = this.a.d();
      if (((paramInt >= i1 - 28) || (paramInt == i1)) && (this.j != i2))
      {
        if (QLog.isColorLevel())
        {
          paramAbsListView = new StringBuilder();
          paramAbsListView.append("[onScroll] loadEmotion: mLastLoadingCount=");
          paramAbsListView.append(this.j);
          QLog.d("ChatHistoryEmotionView", 2, paramAbsListView.toString());
        }
        this.j = i2;
        this.a.b(true);
        ThreadManager.excute(new ChatHistoryEmotionView.3(this), 32, null, false);
      }
    }
  }
  
  public void onSelectBegin(int paramInt)
  {
    if (!this.n) {
      return;
    }
    if (this.a.c() <= paramInt) {
      return;
    }
    Object localObject = this.a.b(paramInt);
    if (!EmotionPreviewData.class.isInstance(localObject)) {
      return;
    }
    localObject = (EmotionPreviewData)localObject;
    this.p = ((EmotionPreviewData)localObject).b;
    if (a((EmotionPreviewData)localObject, this.p ^ true)) {
      this.g.invalidateViews();
    }
    this.o = true;
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryEmotionView", 2, "onSelectBegin");
    }
  }
  
  public void onSelectChanged(int paramInt1, int paramInt2)
  {
    if (!this.n) {
      return;
    }
    if (!this.o) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryEmotionView", 2, new Object[] { "onSelectBegin beginIndex:", Integer.valueOf(paramInt1), "  selectIndex:", Integer.valueOf(paramInt2) });
    }
    int i1;
    int i2;
    if (paramInt2 < paramInt1)
    {
      if (this.r > paramInt2) {
        this.r = paramInt2;
      }
      i1 = paramInt2;
      i2 = paramInt1;
    }
    else
    {
      i1 = paramInt1;
      i2 = paramInt2;
      if (this.q < paramInt2)
      {
        this.q = paramInt2;
        i2 = paramInt2;
        i1 = paramInt1;
      }
    }
    paramInt1 = i1;
    Object localObject;
    while (paramInt1 <= i2)
    {
      localObject = this.a.b(paramInt1);
      if (EmotionPreviewData.class.isInstance(localObject)) {
        a((EmotionPreviewData)localObject, this.p ^ true);
      }
      paramInt1 += 1;
    }
    paramInt1 = i2 + 1;
    while (paramInt1 <= this.q)
    {
      localObject = this.a.b(paramInt1);
      if (EmotionPreviewData.class.isInstance(localObject)) {
        a((EmotionPreviewData)localObject, this.p);
      }
      paramInt1 += 1;
    }
    paramInt1 = this.r;
    while (paramInt1 < i1)
    {
      localObject = this.a.b(paramInt1);
      if (EmotionPreviewData.class.isInstance(localObject)) {
        a((EmotionPreviewData)localObject, this.p);
      }
      paramInt1 += 1;
    }
    this.g.invalidateViews();
  }
  
  public void onSelectEnd()
  {
    if (!this.n) {
      return;
    }
    if (!this.o) {
      return;
    }
    this.o = false;
    this.p = false;
    this.q = -2147483648;
    this.r = 2147483647;
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryEmotionView", 2, "onSelectEnd");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryEmotionView
 * JD-Core Version:    0.7.0.1
 */