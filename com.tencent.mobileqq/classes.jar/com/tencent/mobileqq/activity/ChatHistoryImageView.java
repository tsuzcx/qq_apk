package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcelable;
import android.os.Process;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.common.galleryactivity.GalleryImage;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.AIOImageProviderListener;
import com.tencent.mobileqq.activity.aio.photo.AIOLightVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter.ContentHolder;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;
import cooperation.peak.PeakUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistoryImageView
  extends ChatHistoryViewBase
  implements DialogInterface.OnCancelListener, Handler.Callback, AIOImageProviderService.AIOImageProviderListener, INetEventHandler, AbsListView.OnScrollListener, AdapterView.OnItemClickListener, GestureSelectGridView.OnSelectListener
{
  boolean A = false;
  public ChatHistoryImageView.OperCallBack B;
  private int E = 0;
  QQAppInterface a;
  Activity b;
  public AIOImageProviderService c;
  AIOImageListModel d;
  AIORichMediaData e;
  String f;
  View g;
  GestureSelectGridView h;
  View i;
  QQCustomDialog j;
  Dialog k;
  public AIOPhotoListAdapter l;
  int m;
  public ArrayList<AIORichMediaInfo> n = new ArrayList();
  int o;
  boolean p;
  boolean q = false;
  boolean r = false;
  boolean s = false;
  boolean t = false;
  boolean u;
  int v = -2147483648;
  int w = 2147483647;
  ChatHistoryImageView.DownloadAndSaveTask x;
  WeakReferenceHandler y;
  boolean z = false;
  
  public View a()
  {
    AccessibilityUtil.a(this.h, false);
    return this.g;
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (this.k == null)
    {
      this.k = new ReportDialog(this.b, 2131953338);
      this.k.setCancelable(true);
      this.k.setContentView(2131625585);
      this.k.setOnCancelListener(this);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("%");
    localObject = ((StringBuilder)localObject).toString();
    TextView localTextView = (TextView)this.k.findViewById(2131440191);
    StringBuilder localStringBuilder;
    if (paramInt1 != 1)
    {
      if (paramInt1 == 2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localTextView.getResources().getText(2131886524));
        localStringBuilder.append((String)localObject);
        localObject = localStringBuilder.toString();
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(localTextView.getResources().getText(2131886526));
      localStringBuilder.append((String)localObject);
      localObject = localStringBuilder.toString();
    }
    localTextView.setText((CharSequence)localObject);
    if (!this.k.isShowing()) {}
    try
    {
      this.k.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[showDialog] type = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ChatHistoryImageView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.j;
    if ((localObject != null) && (((QQCustomDialog)localObject).isShowing())) {
      this.j.dismiss();
    }
    this.j = DialogUtil.a(this.b, 230);
    localObject = new ChatHistoryImageView.3(this);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt == 4)
          {
            this.j.setCancelable(false);
            this.j.setNegativeButton(2131887648, new ChatHistoryImageView.6(this));
            this.j.setPositiveButton(2131916409, new ChatHistoryImageView.7(this));
          }
        }
        else
        {
          this.j.setNegativeButton(2131887648, (DialogInterface.OnClickListener)localObject);
          this.j.setPositiveButton(2131916409, new ChatHistoryImageView.5(this));
        }
      }
      else
      {
        this.j.setNegativeButton(2131887648, (DialogInterface.OnClickListener)localObject);
        this.j.setPositiveButton(2131916409, new ChatHistoryImageView.4(this));
      }
    }
    else {
      this.j.setNegativeButton(2131916601, (DialogInterface.OnClickListener)localObject);
    }
    this.j.setMessage(paramString);
    try
    {
      this.j.show();
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void a(long paramLong)
  {
    if (!this.A)
    {
      localObject = this.y;
      if (localObject != null)
      {
        ((WeakReferenceHandler)localObject).post(new ChatHistoryImageView.1(this, paramLong));
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onRevokeMsg, seq:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", mDestroy:");
    ((StringBuilder)localObject).append(this.A);
    QLog.i("ChatHistoryImageView", 2, ((StringBuilder)localObject).toString());
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String arg6, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[onImageDownload] id=");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(",subId=");
      ((StringBuilder)localObject1).append(paramInt1);
      QLog.d("ChatHistoryImageView", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.d;
    if (paramInt3 != 1) {
      ??? = "I:E";
    }
    paramInt1 = ((AIOImageListModel)localObject1).a(paramLong, paramInt1, paramInt2, ???, true);
    if (paramInt2 == 2)
    {
      if (paramInt1 >= 0)
      {
        ??? = this.d.h(paramInt1);
        if (!AIORichMediaInfo.class.isInstance(???)) {
          return;
        }
        ??? = (AIORichMediaInfo)???;
        ???.b = 0;
        ???.e = false;
        paramInt2 = this.h.getFirstVisiblePosition();
        paramInt3 = this.h.getChildCount();
        if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3 + paramInt2 - 1)) {
          this.l.a(paramInt1, this.h.getChildAt(paramInt1 - paramInt2));
        }
        ??? = this.x;
        if ((??? != null) && (???.b != null)) {
          synchronized (this.x.b)
          {
            this.x.b.notifyAll();
            return;
          }
        }
      }
    }
    else if (paramInt2 == 1)
    {
      paramInt2 = this.h.getFirstVisiblePosition();
      paramInt3 = this.h.getChildCount();
      if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3 + paramInt2 - 1))
      {
        ??? = this.h.getChildAt(paramInt1 - paramInt2);
        this.l.a(paramInt1, ???);
      }
    }
    else if (paramInt2 == 16)
    {
      paramInt2 = this.h.getFirstVisiblePosition();
      paramInt3 = this.h.getChildCount();
      if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3 + paramInt2 - 1))
      {
        ??? = this.h.getChildAt(paramInt1 - paramInt2);
        this.l.a(paramInt1, ???);
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    if ((paramIntent != null) && ((paramIntent.getParcelableExtra("extra.EXTRA_CURRENT_IMAGE") instanceof AIORichMediaData))) {
      a((AIORichMediaData)paramIntent.getParcelableExtra("extra.EXTRA_CURRENT_IMAGE"), true);
    }
    if (!((IFMConfig)QRoute.api(IFMConfig.class)).preDownloadThumb()) {
      this.l.notifyDataSetChanged();
    }
  }
  
  public void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.a = paramQQAppInterface;
    this.b = ((Activity)paramContext);
    this.p = paramIntent.getBooleanExtra("extra.IS_FROM_CHAT_AIO_GALLERY", false);
    this.e = ((AIORichMediaData)paramIntent.getParcelableExtra("extra.EXTRA_CURRENT_IMAGE"));
    this.y = new WeakReferenceHandler(this);
    this.g = LayoutInflater.from(paramContext).inflate(2131627072, null);
    this.h = ((GestureSelectGridView)this.g.findViewById(2131434388));
    this.h.setSelectMode(false);
    int i1 = this.b.getResources().getDimensionPixelSize(2131298139);
    int i2 = this.b.getResources().getDimensionPixelSize(2131298140);
    int i3 = this.b.getResources().getDimensionPixelSize(2131298141);
    this.m = ((ViewUtils.getScreenWidth() - i1 * 2 - i2 * 3) / 4);
    this.h.setGravity(3);
    this.h.setScrollBarStyle(0);
    this.h.setNumColumns(4);
    this.h.setColumnWidth(this.m);
    this.h.setHorizontalSpacing(i2);
    this.h.setVerticalSpacing(i3);
    paramQQAppInterface = this.h;
    paramQQAppInterface.setPadding(i1, paramQQAppInterface.getPaddingTop(), i1, this.h.getPaddingBottom());
    this.i = this.g.findViewById(2131432529);
    if (AppSetting.e) {
      this.i.setContentDescription(this.b.getString(2131889397));
    }
    this.o = paramIntent.getIntExtra("uintype", -1);
    this.f = paramIntent.getStringExtra("uin");
    j();
    this.h.setOnScrollListener(this);
    this.h.setOnIndexChangedListener(this);
    AccessibilityUtil.a(this.h, false);
  }
  
  void a(AIORichMediaData paramAIORichMediaData, boolean paramBoolean)
  {
    int i1 = 0;
    while (i1 < this.d.m())
    {
      Object localObject = this.d.h(i1);
      if (AIORichMediaInfo.class.isInstance(localObject))
      {
        localObject = (AIORichMediaInfo)localObject;
        if ((((AIORichMediaInfo)localObject).a.L == paramAIORichMediaData.L) && (((AIORichMediaInfo)localObject).a.M == paramAIORichMediaData.M))
        {
          i2 = 1;
          break label91;
        }
      }
      i1 += 1;
    }
    int i2 = 0;
    label91:
    if (i2 != 0)
    {
      if (QLog.isColorLevel())
      {
        paramAIORichMediaData = new StringBuilder();
        paramAIORichMediaData.append("[setSelectionTo] index=");
        paramAIORichMediaData.append(i1);
        paramAIORichMediaData.append(", fist=");
        paramAIORichMediaData.append(this.h.getFirstVisiblePosition());
        paramAIORichMediaData.append(", last=");
        paramAIORichMediaData.append(this.h.getLastVisiblePosition());
        QLog.d("ChatHistoryImageView", 2, paramAIORichMediaData.toString());
      }
      if ((i1 >= this.h.getFirstVisiblePosition()) && (i1 <= this.h.getLastVisiblePosition())) {
        return;
      }
      if (paramBoolean)
      {
        this.h.setSelection(i1);
        return;
      }
      i2 = i1 - 12;
      i1 = i2;
      if (i2 < 0) {
        i1 = 0;
      }
      this.h.setSelection(i1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    AIOPhotoListAdapter localAIOPhotoListAdapter = this.l;
    if (localAIOPhotoListAdapter != null) {
      localAIOPhotoListAdapter.a(paramBoolean);
    }
  }
  
  public void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    this.y.post(new ChatHistoryImageView.2(this, paramArrayOfAIORichMediaData, paramInt));
  }
  
  boolean a(View paramView, GalleryImage paramGalleryImage)
  {
    Object localObject = (AIOPhotoListAdapter.ContentHolder)paramView.getTag();
    if (localObject != null)
    {
      paramView = ((AIOPhotoListAdapter.ContentHolder)localObject).b;
      localObject = ((AIOPhotoListAdapter.ContentHolder)localObject).c;
      int i1 = paramGalleryImage.getSelected();
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          paramView.setVisibility(4);
          ((ImageView)localObject).setVisibility(4);
          return true;
        }
        paramView.setVisibility(4);
        ((ImageView)localObject).setImageResource(2130847333);
        ((ImageView)localObject).setVisibility(0);
        return true;
      }
      paramView.setVisibility(0);
      ((ImageView)localObject).setImageResource(2130847336);
      ((ImageView)localObject).setVisibility(0);
      return true;
    }
    return false;
  }
  
  boolean a(AIORichMediaInfo paramAIORichMediaInfo, boolean paramBoolean)
  {
    int i1 = paramAIORichMediaInfo.getSelected();
    if (((i1 == 1) && (paramBoolean)) || ((i1 == 2) && (!paramBoolean))) {
      return false;
    }
    ChatMessage localChatMessage = this.c.a(paramAIORichMediaInfo.a.L);
    ChatHistoryImageView.OperCallBack localOperCallBack;
    if (paramBoolean)
    {
      if ((this.D != null) && (this.D.b())) {
        return false;
      }
      localOperCallBack = this.B;
      if ((localOperCallBack != null) && (localOperCallBack.a())) {
        return false;
      }
      localOperCallBack = this.B;
      if ((localOperCallBack != null) && (!localOperCallBack.a(paramAIORichMediaInfo))) {
        return false;
      }
      localOperCallBack = this.B;
      if ((localOperCallBack != null) && (localChatMessage != null)) {
        localOperCallBack.a(localChatMessage);
      }
      paramAIORichMediaInfo.setSelected(1);
      this.n.add(paramAIORichMediaInfo);
      if (this.D != null)
      {
        this.D.a(paramAIORichMediaInfo);
        if (localChatMessage != null)
        {
          this.D.a(localChatMessage);
          return true;
        }
      }
    }
    else
    {
      paramAIORichMediaInfo.setSelected(2);
      this.n.remove(paramAIORichMediaInfo);
      if (this.D != null)
      {
        this.D.b(paramAIORichMediaInfo);
        if (localChatMessage != null) {
          this.D.e(localChatMessage);
        }
      }
      localOperCallBack = this.B;
      if (localOperCallBack != null)
      {
        localOperCallBack.b(paramAIORichMediaInfo);
        if (localChatMessage != null) {
          this.B.b(localChatMessage);
        }
      }
    }
    return true;
  }
  
  public void b()
  {
    AIOPhotoListAdapter localAIOPhotoListAdapter = this.l;
    if (localAIOPhotoListAdapter != null) {
      localAIOPhotoListAdapter.b();
    }
  }
  
  public boolean c()
  {
    AIOPhotoListAdapter localAIOPhotoListAdapter = this.l;
    if (localAIOPhotoListAdapter != null) {
      return localAIOPhotoListAdapter.a();
    }
    return false;
  }
  
  public void d()
  {
    this.z = true;
  }
  
  public void e()
  {
    this.z = false;
  }
  
  public void f()
  {
    this.c.a();
    if (this.s) {
      AppNetConnInfo.unregisterNetEventHandler(this);
    }
    this.B = null;
    this.A = true;
  }
  
  public void g()
  {
    if (!this.r)
    {
      this.r = true;
      AIOPhotoListAdapter localAIOPhotoListAdapter = this.l;
      localAIOPhotoListAdapter.c = true;
      localAIOPhotoListAdapter.notifyDataSetChanged();
      this.h.setSelectMode(true);
    }
  }
  
  public void h()
  {
    if (this.r)
    {
      this.r = false;
      Object localObject = this.n.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((GalleryImage)((Iterator)localObject).next()).setSelected(2);
      }
      this.n.clear();
      localObject = this.l;
      ((AIOPhotoListAdapter)localObject).c = false;
      ((AIOPhotoListAdapter)localObject).notifyDataSetChanged();
      this.h.setSelectMode(false);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 102: 
      paramMessage = this.k;
      if ((paramMessage != null) && (paramMessage.isShowing())) {
        this.k.cancel();
      }
      QQToast.makeText(BaseApplication.getContext(), 1, 2131889396, 0).show();
      return true;
    case 101: 
      paramMessage = this.k;
      if (paramMessage != null)
      {
        paramMessage.dismiss();
        this.k = null;
      }
      return true;
    }
    a(paramMessage.arg1, paramMessage.arg2);
    return true;
  }
  
  public boolean i()
  {
    return this.r;
  }
  
  public void j()
  {
    this.c = AIOImageProviderService.a(this.a.getCurrentUin(), this.f, this.o, null, this.p);
    this.c.a(this);
    int i1 = 0;
    this.d = new AIOImageListModel(false);
    this.l = new AIOPhotoListAdapter(this.b, this.m, this.d, this.c, this.h);
    this.l.a(this.o);
    this.h.setAdapter(this.l);
    this.h.setOnItemClickListener(this);
    this.l.b(true);
    this.l.b(2);
    AIOImageProviderService localAIOImageProviderService = this.c;
    if (this.p) {
      i1 = 2;
    }
    localAIOImageProviderService.a(i1);
  }
  
  public Rect k()
  {
    int i1 = this.h.getFirstVisiblePosition();
    int i2 = this.d.l();
    View localView = this.h.getChildAt(i2 - i1);
    if (localView != null)
    {
      Rect localRect = new Rect(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getWidth() - localView.getPaddingRight(), localView.getHeight() - localView.getPaddingBottom());
      i1 = localView.getWidth();
      i2 = localView.getHeight();
      ViewGroup localViewGroup = (ViewGroup)localView.getParent();
      Point localPoint = new Point();
      if ((i1 > 0) && (i2 > 0))
      {
        localPoint.set(-localView.getScrollX(), -localView.getScrollY());
        if (localViewGroup != null) {
          localViewGroup.getChildVisibleRect(localView, localRect, localPoint);
        }
      }
      return localRect;
    }
    return null;
  }
  
  public void l()
  {
    if (this.n.isEmpty()) {
      return;
    }
    Object localObject1 = (AIORichMediaInfo)this.n.get(0);
    if ((!AIOImageData.class.isInstance(((AIORichMediaInfo)localObject1).a)) && (!AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject1).a)))
    {
      if (AIOShortVideoData.class.isInstance(((AIORichMediaInfo)localObject1).a))
      {
        localObject1 = this.c.c(((AIORichMediaInfo)localObject1).a.L, ((AIORichMediaInfo)localObject1).a.M, this.o);
        if (localObject1 != null)
        {
          ForwardBaseOption.a(this.b, (Intent)localObject1);
          if (this.D != null) {
            this.D.a();
          }
        }
      }
      else if (AIOFileVideoData.class.isInstance(((AIORichMediaInfo)localObject1).a))
      {
        Object localObject2 = (AIOFileVideoData)((AIORichMediaInfo)localObject1).a;
        localObject2 = this.c.a(((AIOFileVideoData)localObject2).L);
        if ((localObject2 instanceof MessageForFile))
        {
          if (FileManagerUtil.a(this.a, (MessageForFile)localObject2).sendCloudUnsuccessful())
          {
            FMToastUtil.a(HardCodeUtil.a(2131899854));
            if (this.D != null) {
              this.D.a();
            }
            return;
          }
          localObject1 = this.c.c(((AIORichMediaInfo)localObject1).a.L, ((AIORichMediaInfo)localObject1).a.M, this.o);
          if (localObject1 != null)
          {
            ForwardBaseOption.a(this.b, (Intent)localObject1);
            if (this.D != null) {
              this.D.a();
            }
          }
        }
        else if ((localObject2 instanceof MessageForTroopFile))
        {
          localObject1 = this.c.c(((AIORichMediaInfo)localObject1).a.L, ((AIORichMediaInfo)localObject1).a.M, this.o);
          if (localObject1 != null)
          {
            ForwardBaseOption.a(this.b, (Intent)localObject1);
            if (this.D != null) {
              this.D.a();
            }
          }
        }
      }
    }
    else {
      m();
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "[forward]");
    }
    int i1 = 0;
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext())
    {
      AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)localIterator.next();
      if (AIOImageData.class.isInstance(localAIORichMediaInfo.a)) {
        if (localAIORichMediaInfo.a.Q == 1 ? (localAIORichMediaInfo.a.c(4) != null) || (localAIORichMediaInfo.a.c(2) != null) || (localAIORichMediaInfo.a.c(1) != null) : localAIORichMediaInfo.a.c(2) != null) {
          break;
        }
      } else {
        for (;;)
        {
          i1 += 1;
          break;
          if ((!AIOFilePicData.class.isInstance(localAIORichMediaInfo.a)) || (localAIORichMediaInfo.a.c(20) != null) || (localAIORichMediaInfo.a.c(18) != null) || (localAIORichMediaInfo.a.c(16) != null)) {
            break;
          }
        }
      }
    }
    if (i1 == 0)
    {
      n();
      return;
    }
    if (i1 != this.n.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryImageView", 2, "[forwardAllImage] hasForwardImg = false");
      }
      a(3, HardCodeUtil.a(2131899821));
      return;
    }
    FMToastUtil.a(HardCodeUtil.a(2131899850));
  }
  
  void n()
  {
    Object localObject1 = this.n;
    if ((localObject1 != null) && (((ArrayList)localObject1).get(0) != null))
    {
      localObject1 = (AIORichMediaInfo)this.n.get(0);
      Object localObject2;
      Object localObject3;
      AIORichMediaInfo localAIORichMediaInfo;
      if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject1).a))
      {
        localObject2 = (AIOImageData)((AIORichMediaInfo)localObject1).a;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("forward_type", 12);
        localObject3 = ((AIOImageData)localObject2).b(2);
        ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOImageData)localObject2).b(1));
        ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
        ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
        if (this.n.size() > 1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.n.size());
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131899885));
          ((Bundle)localObject1).putString("forward_text", ((StringBuilder)localObject2).toString());
        }
        ((Bundle)localObject1).putBoolean("sendMultiple", true);
        ((Bundle)localObject1).putBoolean("key_allow_forward_photo_preview_edit", true);
        localObject2 = new ArrayList();
        localObject3 = this.n.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localAIORichMediaInfo = (AIORichMediaInfo)((Iterator)localObject3).next();
          if (AIOImageData.class.isInstance(localAIORichMediaInfo.a))
          {
            if (localAIORichMediaInfo.a.Q == 1)
            {
              if (localAIORichMediaInfo.a.c(4) != null) {
                ((ArrayList)localObject2).add(((AIOImageData)localAIORichMediaInfo.a).c);
              } else if (localAIORichMediaInfo.a.c(2) != null) {
                ((ArrayList)localObject2).add(((AIOImageData)localAIORichMediaInfo.a).b);
              } else if (localAIORichMediaInfo.a.c(1) != null) {
                ((ArrayList)localObject2).add(((AIOImageData)localAIORichMediaInfo.a).a);
              }
            }
            else {
              ((ArrayList)localObject2).add(((AIOImageData)localAIORichMediaInfo.a).b);
            }
          }
          else if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.a)) {
            if (localAIORichMediaInfo.a.c(20) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.a).e);
            } else if (localAIORichMediaInfo.a.c(18) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.a).d);
            } else if (localAIORichMediaInfo.a.c(16) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.a).c);
            }
          }
        }
        ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        ForwardBaseOption.a(this.b, (Intent)localObject2, 1);
        return;
      }
      if (AIOFilePicData.class.isInstance(((AIORichMediaInfo)localObject1).a))
      {
        localObject2 = (AIOFilePicData)((AIORichMediaInfo)localObject1).a;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("forward_type", 12);
        localObject3 = ((AIOFilePicData)localObject2).b(18);
        ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOFilePicData)localObject2).b(16));
        ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
        ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
        if (this.n.size() > 1)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.n.size());
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131899869));
          ((Bundle)localObject1).putString("forward_text", ((StringBuilder)localObject2).toString());
        }
        ((Bundle)localObject1).putBoolean("sendMultiple", true);
        localObject2 = new ArrayList();
        localObject3 = this.n.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localAIORichMediaInfo = (AIORichMediaInfo)((Iterator)localObject3).next();
          if (AIOImageData.class.isInstance(localAIORichMediaInfo.a)) {
            ((ArrayList)localObject2).add(((AIOImageData)localAIORichMediaInfo.a).b);
          } else if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.a)) {
            if (localAIORichMediaInfo.a.c(20) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.a).e);
            } else if (localAIORichMediaInfo.a.c(18) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.a).d);
            } else if (localAIORichMediaInfo.a.c(16) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localAIORichMediaInfo.a).c);
            }
          }
        }
        ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        ForwardBaseOption.a(this.b, (Intent)localObject2, 1);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ChatHistoryImageView", 2, "callForwardRecentActivity error! mSelectedPhotoList ==null || mSelectedPhotoList.get(0) == null || !mSelectedPhotoList.get(0) instanceof AIOImageInfo");
    }
  }
  
  public List<ChatMessage> o()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext())
    {
      AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)localIterator.next();
      ChatMessage localChatMessage = this.c.a(localAIORichMediaInfo.a.L, localAIORichMediaInfo.a.M);
      if (localChatMessage != null) {
        localArrayList.add(localChatMessage);
      }
      this.d.b(localAIORichMediaInfo);
    }
    this.l.notifyDataSetChanged();
    if (this.d.a() == 0) {
      this.i.setVisibility(0);
    }
    return localArrayList;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.y.removeMessages(102);
    this.k = null;
    paramDialogInterface = this.x;
    if (paramDialogInterface != null) {
      paramDialogInterface.e = false;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.d.h(paramInt);
    if (!AIORichMediaInfo.class.isInstance(paramAdapterView)) {
      return;
    }
    paramAdapterView = (AIORichMediaInfo)paramAdapterView;
    boolean bool = this.r;
    int i1 = 0;
    if (bool)
    {
      paramInt = i1;
      if (paramAdapterView.getSelected() == 1) {
        paramInt = 1;
      }
      if ((a(paramAdapterView, paramInt ^ 0x1)) && (!a(paramView, paramAdapterView))) {
        this.l.notifyDataSetChanged();
      }
    }
    else
    {
      this.d.g(paramInt);
      this.d.d(this.h.getFirstVisiblePosition());
      this.d.e(this.h.getLastVisiblePosition());
      if (AIOShortVideoData.class.isInstance(paramAdapterView.a))
      {
        paramView = (AIOShortVideoData)paramAdapterView.a;
        if ((paramView.d == 0) && (this.c.b(paramView.L) != null) && (this.a.isVideoChatting())) {
          QQToast.makeText(BaseApplication.getContext(), 0, 2131916633, 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
        }
      }
      else if (AIOFileVideoData.class.isInstance(paramAdapterView.a))
      {
        paramView = (AIOFileVideoData)paramAdapterView.a;
        paramView = this.c.a(paramView.L);
        if ((paramView instanceof MessageForFile))
        {
          paramView = FileManagerUtil.a(this.a, (MessageForFile)paramView);
          if (paramView == null) {
            return;
          }
          if (FileUtil.b(paramView.getFilePath()))
          {
            if (QLog.isDevelopLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("file existed! isLocalFile:");
              ((StringBuilder)localObject).append(paramView.nSessionId);
              QLog.i("PauseDebug", 1, ((StringBuilder)localObject).toString());
            }
            if ((paramAdapterView.a instanceof AIOFileVideoData)) {
              ((AIOFileVideoData)paramAdapterView.a).c = paramView.getFilePath();
            }
          }
          else if (paramView.sendCloudUnsuccessful())
          {
            FMToastUtil.a(HardCodeUtil.a(2131899852));
            return;
          }
          ShortVideoUtils.reportVideoPlay(this.a.getCurrentAccountUin(), this.f, String.valueOf(0), this.o, "3", "3");
        }
      }
      else if (AIOLightVideoData.class.isInstance(paramAdapterView.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryImageView", 2, "lightvideo could not be opened in chathistory");
        }
        QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.a(2131899891), 0).show();
        return;
      }
      paramView = new Bundle();
      Object localObject = k();
      if (localObject != null) {
        paramView.putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject);
      }
      if (this.o == 3000) {
        paramView.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
      } else {
        paramView.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
      }
      paramView.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
      paramView.putBoolean("extra.IS_FROM_CHAT_FILE_HISTORY", true);
      paramView.putString("uin", this.f);
      paramView.putInt("forward_source_uin_type", this.o);
      paramView.putBoolean("extra.OCR", ((IOCRService)this.a.getRuntimeService(IOCRService.class, "")).isSupportOcr(this.a.getCurrentAccountUin(), 7));
      if (this.o == 1)
      {
        localObject = ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.f);
        if (localObject != null) {
          paramView.putString("extra.GROUP_UIN", ((TroopInfo)localObject).troopuin);
        }
      }
      paramView.putBoolean("extra.ENTER_NEW_GALLERY", true);
      PeakUtils.a(this.b, paramView, this.c, paramAdapterView.a, 2, 3);
      if ((paramAdapterView.a != null) && ((paramAdapterView.a instanceof AIOShortVideoData))) {
        ShortVideoUtils.reportVideoPlay(this.a.getCurrentAccountUin(), this.f, String.valueOf(((AIOShortVideoData)paramAdapterView.a).c * 1000), this.o, "2", "3");
      }
    }
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (AppNetConnInfo.isMobileConn())
    {
      ChatHistoryImageView.DownloadAndSaveTask localDownloadAndSaveTask = this.x;
      if ((localDownloadAndSaveTask != null) && (localDownloadAndSaveTask.e) && (this.x.f) && (this.x.d))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryImageView", 2, "[onNetChangeEvent] show dialog");
        }
        this.x.a(true);
        a(4, this.b.getString(2131889395));
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = this.h.getLastVisiblePosition();
      int i1 = this.d.m();
      int i2 = this.d.n();
      if (((paramInt >= i1 - 28) || (paramInt == i1)) && (this.E != i2))
      {
        if (QLog.isColorLevel())
        {
          paramAbsListView = new StringBuilder();
          paramAbsListView.append("[onScroll] loadMedias: mLastLoadingCount=");
          paramAbsListView.append(this.E);
          QLog.d("ChatHistoryImageView", 2, paramAbsListView.toString());
        }
        this.E = i2;
        this.l.b(true);
        this.c.a(0);
      }
    }
  }
  
  public void onSelectBegin(int paramInt)
  {
    if (!this.r) {
      return;
    }
    if (this.d.m() <= paramInt) {
      return;
    }
    Object localObject = this.d.h(paramInt);
    if (!AIORichMediaInfo.class.isInstance(localObject)) {
      return;
    }
    localObject = (AIORichMediaInfo)localObject;
    boolean bool;
    if (((AIORichMediaInfo)localObject).getSelected() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.t = bool;
    if (a((AIORichMediaInfo)localObject, this.t ^ true))
    {
      this.h.invalidateViews();
      this.l.notifyDataSetChanged();
    }
    this.u = true;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSelectBegin beginIndex:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ChatHistoryImageView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onSelectChanged(int paramInt1, int paramInt2)
  {
    if (!this.r) {
      return;
    }
    if (!this.u) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSelectChanged beginIndex:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" selectIndex:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("ChatHistoryImageView", 2, ((StringBuilder)localObject).toString());
    }
    int i1;
    int i2;
    if (paramInt2 < paramInt1)
    {
      if (this.w > paramInt2) {
        this.w = paramInt2;
      }
      i1 = paramInt2;
      i2 = paramInt1;
    }
    else
    {
      i1 = paramInt1;
      i2 = paramInt2;
      if (this.v < paramInt2)
      {
        this.v = paramInt2;
        i2 = paramInt2;
        i1 = paramInt1;
      }
    }
    paramInt1 = i1;
    for (;;)
    {
      paramInt2 = i2;
      if (paramInt1 > i2) {
        break;
      }
      localObject = this.d.h(paramInt1);
      if (AIORichMediaInfo.class.isInstance(localObject)) {
        a((AIORichMediaInfo)localObject, this.t ^ true);
      }
      paramInt1 += 1;
    }
    for (;;)
    {
      paramInt2 += 1;
      if (paramInt2 > this.v) {
        break;
      }
      localObject = this.d.h(paramInt2);
      if (AIORichMediaInfo.class.isInstance(localObject)) {
        a((AIORichMediaInfo)localObject, this.t);
      }
    }
    paramInt1 = this.w;
    while (paramInt1 < i1)
    {
      localObject = this.d.h(paramInt1);
      if (AIORichMediaInfo.class.isInstance(localObject)) {
        a((AIORichMediaInfo)localObject, this.t);
      }
      paramInt1 += 1;
    }
    this.h.invalidateViews();
    this.l.notifyDataSetChanged();
  }
  
  public void onSelectEnd()
  {
    if (!this.r) {
      return;
    }
    if (!this.u) {
      return;
    }
    this.u = false;
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "onSelectEnd");
    }
    this.t = false;
    this.v = -2147483648;
    this.w = 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryImageView
 * JD-Core Version:    0.7.0.1
 */