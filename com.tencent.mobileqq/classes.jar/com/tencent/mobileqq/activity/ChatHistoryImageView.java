package com.tencent.mobileqq.activity;

import acob;
import acoc;
import acod;
import acoe;
import acof;
import acog;
import acoj;
import agjh;
import agjw;
import agjx;
import agjz;
import agkf;
import alud;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import arbp;
import arri;
import arrr;
import arso;
import aryv;
import avvi;
import bczz;
import bdgm;
import bdjz;
import bdoo;
import bhtd;
import bhtv;
import bhuw;
import bhxl;
import biqe;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIOLightVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zjd;

public class ChatHistoryImageView
  extends acoj
  implements agjw, DialogInterface.OnCancelListener, Handler.Callback, bhtv, bhuw, bhxl, INetEventHandler
{
  int jdField_a_of_type_Int;
  public acog a;
  agjh jdField_a_of_type_Agjh;
  public agjx a;
  Activity jdField_a_of_type_AndroidAppActivity;
  public Dialog a;
  View jdField_a_of_type_AndroidViewView;
  bdjz jdField_a_of_type_Bdjz;
  bhtd jdField_a_of_type_Bhtd;
  public ChatHistoryImageView.DownloadAndSaveTask a;
  public AIOImageProviderService a;
  AIORichMediaData jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  GestureSelectGridView jdField_a_of_type_ComTencentWidgetGestureSelectGridView;
  String jdField_a_of_type_JavaLangString;
  public ArrayList<agkf> a;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = -2147483648;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 2147483647;
  boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean = false;
  boolean f;
  boolean g = false;
  boolean h = false;
  
  public ChatHistoryImageView()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public Rect a()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
    int j = this.jdField_a_of_type_Agjh.f();
    View localView = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(j - i);
    if (localView != null)
    {
      Rect localRect = new Rect(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getWidth() - localView.getPaddingRight(), localView.getHeight() - localView.getPaddingBottom());
      i = localView.getWidth();
      j = localView.getHeight();
      ViewGroup localViewGroup = (ViewGroup)localView.getParent();
      Point localPoint = new Point();
      if ((i > 0) && (j > 0))
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
  
  public View a()
  {
    bczz.a(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView, false);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public List<ChatMessage> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      agkf localagkf = (agkf)localIterator.next();
      ChatMessage localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int);
      if (localChatMessage != null) {
        localArrayList.add(localChatMessage);
      }
      this.jdField_a_of_type_Agjh.b(localagkf);
    }
    this.jdField_a_of_type_Agjx.notifyDataSetChanged();
    if (this.jdField_a_of_type_Agjh.a() == 0) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Agjx != null) {
      this.jdField_a_of_type_Agjx.a();
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidAppActivity, 2131755801);
      this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559437);
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this);
    }
    String str = paramInt2 + "%";
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371894);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localTextView.setText(str);
      if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {}
      try
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
      }
      catch (Exception localException) {}
      str = localTextView.getResources().getText(2131689981) + str;
      continue;
      str = localTextView.getResources().getText(2131689979) + str;
    }
  }
  
  void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "[showDialog] type = " + paramInt);
    }
    if ((this.jdField_a_of_type_Bdjz != null) && (this.jdField_a_of_type_Bdjz.isShowing())) {
      this.jdField_a_of_type_Bdjz.dismiss();
    }
    this.jdField_a_of_type_Bdjz = bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    acob localacob = new acob(this);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdjz.setMessage(paramString);
      try
      {
        this.jdField_a_of_type_Bdjz.show();
        return;
      }
      catch (Exception paramString) {}
      this.jdField_a_of_type_Bdjz.setNegativeButton(2131720095, localacob);
      continue;
      this.jdField_a_of_type_Bdjz.setNegativeButton(2131690648, localacob);
      this.jdField_a_of_type_Bdjz.setPositiveButton(2131719931, new acoc(this));
      continue;
      this.jdField_a_of_type_Bdjz.setNegativeButton(2131690648, localacob);
      this.jdField_a_of_type_Bdjz.setPositiveButton(2131719931, new acod(this));
      continue;
      this.jdField_a_of_type_Bdjz.setCancelable(false);
      this.jdField_a_of_type_Bdjz.setNegativeButton(2131690648, new acoe(this));
      this.jdField_a_of_type_Bdjz.setPositiveButton(2131719931, new acof(this));
    }
  }
  
  public void a(long paramLong)
  {
    if ((this.h) || (this.jdField_a_of_type_Bhtd == null))
    {
      QLog.i("ChatHistoryImageView", 2, "onRevokeMsg, seq:" + paramLong + ", mDestroy:" + this.h);
      return;
    }
    this.jdField_a_of_type_Bhtd.post(new ChatHistoryImageView.1(this, paramLong));
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String arg6, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "[onImageDownload] id=" + paramLong + ",subId=" + paramInt1);
    }
    agjh localagjh = this.jdField_a_of_type_Agjh;
    if (paramInt3 == 1)
    {
      paramInt1 = localagjh.a(paramLong, paramInt1, paramInt2, ???, true);
      if (paramInt2 != 2) {
        break label231;
      }
      if (paramInt1 >= 0)
      {
        ??? = this.jdField_a_of_type_Agjh.a(paramInt1);
        if (agkf.class.isInstance(???)) {
          break label107;
        }
      }
    }
    label107:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            ??? = "I:E";
            break;
            ??? = (agkf)???;
            ???.jdField_a_of_type_Int = 0;
            ???.jdField_a_of_type_Boolean = false;
            paramInt2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
            paramInt3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
            if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3 + paramInt2 - 1)) {
              this.jdField_a_of_type_Agjx.a(paramInt1, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(paramInt1 - paramInt2));
            }
          } while ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.a == null));
          synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.a)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.a.notifyAll();
            return;
          }
          if (paramInt2 != 1) {
            break label296;
          }
          paramInt2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
          paramInt3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
        } while ((paramInt1 < paramInt2) || (paramInt1 > paramInt3 + paramInt2 - 1));
        ??? = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(paramInt1 - paramInt2);
        this.jdField_a_of_type_Agjx.a(paramInt1, ???);
        return;
      } while (paramInt2 != 16);
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      paramInt3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
    } while ((paramInt1 < paramInt2) || (paramInt1 > paramInt3 + paramInt2 - 1));
    label231:
    ??? = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(paramInt1 - paramInt2);
    label296:
    this.jdField_a_of_type_Agjx.a(paramInt1, ???);
  }
  
  public void a(Intent paramIntent)
  {
    if ((paramIntent != null) && ((paramIntent.getParcelableExtra("extra.EXTRA_CURRENT_IMAGE") instanceof AIORichMediaData))) {
      a((AIORichMediaData)paramIntent.getParcelableExtra("extra.EXTRA_CURRENT_IMAGE"), true);
    }
    if (!arbp.a()) {
      this.jdField_a_of_type_Agjx.notifyDataSetChanged();
    }
  }
  
  public void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("extra.IS_FROM_CHAT_AIO_GALLERY", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData = ((AIORichMediaData)paramIntent.getParcelableExtra("extra.EXTRA_CURRENT_IMAGE"));
    this.jdField_a_of_type_Bhtd = new bhtd(this);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560674, null);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367310));
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(false);
    int i = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297300);
    int j = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297301);
    int k = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297302);
    this.jdField_a_of_type_Int = ((bdoo.a() - i * 2 - j * 3) / 4);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setGravity(3);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(4);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(j);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(k);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setPadding(i, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingTop(), i, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365760);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_b_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131692611));
    }
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    g();
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnIndexChangedListener(this);
    bczz.a(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView, false);
  }
  
  void a(AIORichMediaData paramAIORichMediaData, boolean paramBoolean)
  {
    int k = 0;
    int i = 0;
    if (i < this.jdField_a_of_type_Agjh.g())
    {
      Object localObject = this.jdField_a_of_type_Agjh.a(i);
      if (!agkf.class.isInstance(localObject)) {}
      do
      {
        i += 1;
        break;
        localObject = (agkf)localObject;
      } while ((((agkf)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != paramAIORichMediaData.jdField_f_of_type_Long) || (((agkf)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int != paramAIORichMediaData.jdField_f_of_type_Int));
    }
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryImageView", 2, "[setSelectionTo] index=" + i + ", fist=" + this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition() + ", last=" + this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition());
        }
        if ((i < this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition()) || (i > this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition())) {}
      }
      else
      {
        return;
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(i);
        return;
      }
      i -= 12;
      if (i < 0) {
        i = k;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(i);
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Agjx != null) {
      this.jdField_a_of_type_Agjx.a(paramBoolean);
    }
  }
  
  public void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    this.jdField_a_of_type_Bhtd.post(new ChatHistoryImageView.2(this, paramArrayOfAIORichMediaData, paramInt));
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Agjx != null) {
      return this.jdField_a_of_type_Agjx.a();
    }
    return false;
  }
  
  boolean a(agkf paramagkf, boolean paramBoolean)
  {
    int i = paramagkf.b();
    if (((i == 1) && (paramBoolean)) || ((i == 2) && (!paramBoolean))) {}
    ChatMessage localChatMessage;
    do
    {
      return false;
      localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
      if (!paramBoolean) {
        break;
      }
    } while (((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a())) || ((this.jdField_a_of_type_Acog != null) && (this.jdField_a_of_type_Acog.a())) || ((this.jdField_a_of_type_Acog != null) && (!this.jdField_a_of_type_Acog.a(paramagkf))));
    if ((this.jdField_a_of_type_Acog != null) && (localChatMessage != null)) {
      this.jdField_a_of_type_Acog.a(localChatMessage);
    }
    paramagkf.a(1);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramagkf);
    for (;;)
    {
      return true;
      paramagkf.a(2);
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramagkf);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramagkf);
        if (localChatMessage != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.c(localChatMessage);
        }
      }
      if (this.jdField_a_of_type_Acog != null)
      {
        this.jdField_a_of_type_Acog.a(paramagkf);
        if (localChatMessage != null) {
          this.jdField_a_of_type_Acog.b(localChatMessage);
        }
      }
    }
  }
  
  boolean a(View paramView, zjd paramzjd)
  {
    Object localObject = (agjz)paramView.getTag();
    if (localObject != null)
    {
      paramView = ((agjz)localObject).a;
      localObject = ((agjz)localObject).b;
      switch (paramzjd.b())
      {
      default: 
        paramView.setVisibility(4);
        ((ImageView)localObject).setVisibility(4);
      }
      for (;;)
      {
        return true;
        paramView.setVisibility(0);
        ((ImageView)localObject).setImageResource(2130845298);
        ((ImageView)localObject).setVisibility(0);
        continue;
        paramView.setVisibility(4);
        ((ImageView)localObject).setImageResource(2130845295);
        ((ImageView)localObject).setVisibility(0);
      }
    }
    return false;
  }
  
  public void b()
  {
    this.g = true;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void c()
  {
    this.g = false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a();
    if (this.jdField_d_of_type_Boolean) {
      AppNetConnInfo.unregisterNetEventHandler(this);
    }
    this.jdField_a_of_type_Acog = null;
    this.h = true;
  }
  
  public void e()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Agjx.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Agjx.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(true);
    }
  }
  
  public void f()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((zjd)localIterator.next()).a(2);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Agjx.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Agjx.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(false);
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService = AIOImageProviderService.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, null, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(this);
    this.jdField_a_of_type_Agjh = new agjh(false);
    this.jdField_a_of_type_Agjx = new agjx(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_Agjh, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView);
    this.jdField_a_of_type_Agjx.a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this.jdField_a_of_type_Agjx);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(this);
    this.jdField_a_of_type_Agjx.a(true);
    this.jdField_a_of_type_Agjx.b(2);
    AIOImageProviderService localAIOImageProviderService = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 2;; i = 0)
    {
      localAIOImageProviderService.a(i);
      return;
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {}
    label254:
    do
    {
      Object localObject1;
      do
      {
        Object localObject2;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      localObject1 = (agkf)this.jdField_a_of_type_JavaUtilArrayList.get(0);
                      if ((AIOImageData.class.isInstance(((agkf)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) || (AIOFilePicData.class.isInstance(((agkf)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)))
                      {
                        i();
                        return;
                      }
                      if (!AIOShortVideoData.class.isInstance(((agkf)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
                        break;
                      }
                      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(((agkf)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, ((agkf)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int, this.jdField_b_of_type_Int);
                    } while (localObject1 == null);
                    aryv.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject1);
                  } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity == null);
                  this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
                  return;
                } while (!AIOFileVideoData.class.isInstance(((agkf)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
                localObject2 = (AIOFileVideoData)((agkf)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(((AIOFileVideoData)localObject2).jdField_f_of_type_Long);
                if (!(localObject2 instanceof MessageForFile)) {
                  break label254;
                }
                if (!arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject2).sendCloudUnsuccessful()) {
                  break;
                }
                arri.a(alud.a(2131702009));
              } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity == null);
              this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
              return;
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(((agkf)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, ((agkf)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int, this.jdField_b_of_type_Int);
            } while (localObject1 == null);
            aryv.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject1);
          } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity == null);
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
          return;
        } while (!(localObject2 instanceof MessageForTroopFile));
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(((agkf)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, ((agkf)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int, this.jdField_b_of_type_Int);
      } while (localObject1 == null);
      aryv.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject1);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    case 100: 
    case 101: 
      do
      {
        return bool;
        a(paramMessage.arg1, paramMessage.arg2);
        return true;
      } while (this.jdField_a_of_type_AndroidAppDialog == null);
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
      return true;
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.cancel();
    }
    QQToast.a(BaseApplication.getContext(), 1, 2131692610, 0).a();
    return true;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "[forward]");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    agkf localagkf;
    if (localIterator.hasNext())
    {
      localagkf = (agkf)localIterator.next();
      if (AIOImageData.class.isInstance(localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        if (localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.g == 1)
        {
          if ((localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4) != null) || (localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2) != null) || (localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(1) != null)) {
            break label241;
          }
          i += 1;
        }
      }
    }
    label241:
    for (;;)
    {
      break;
      if (localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2) == null)
      {
        i += 1;
        continue;
        if ((AIOFilePicData.class.isInstance(localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) && (localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20) == null) && (localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18) == null) && (localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16) == null))
        {
          i += 1;
          continue;
          if (i == 0)
          {
            j();
            return;
          }
          if (i != this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChatHistoryImageView", 2, "[forwardAllImage] hasForwardImg = false");
            }
            a(3, alud.a(2131701975));
            return;
          }
          arri.a(alud.a(2131702005));
          return;
        }
      }
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.get(0) != null))
    {
      localObject1 = (agkf)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (AIOImageData.class.isInstance(((agkf)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject2 = (AIOImageData)((agkf)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("forward_type", 12);
        localObject3 = ((AIOImageData)localObject2).a(2);
        ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOImageData)localObject2).a(1));
        ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
        ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
          ((Bundle)localObject1).putString("forward_text", this.jdField_a_of_type_JavaUtilArrayList.size() + alud.a(2131702040));
        }
        ((Bundle)localObject1).putBoolean("sendMultiple", true);
        ((Bundle)localObject1).putBoolean("key_allow_forward_photo_preview_edit", true);
        localObject2 = new ArrayList();
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localagkf = (agkf)((Iterator)localObject3).next();
          if (AIOImageData.class.isInstance(localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
          {
            if (localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.g == 1)
            {
              if (localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4) != null) {
                ((ArrayList)localObject2).add(((AIOImageData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).c);
              } else if (localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2) != null) {
                ((ArrayList)localObject2).add(((AIOImageData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).b);
              } else if (localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(1) != null) {
                ((ArrayList)localObject2).add(((AIOImageData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_a_of_type_JavaLangString);
              }
            }
            else {
              ((ArrayList)localObject2).add(((AIOImageData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).b);
            }
          }
          else if (AIOFilePicData.class.isInstance(localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            if (localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).d);
            } else if (localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).c);
            } else if (localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).b);
            }
          }
        }
        ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        aryv.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 1);
      }
    }
    while (!QLog.isColorLevel())
    {
      agkf localagkf;
      do
      {
        return;
      } while (!AIOFilePicData.class.isInstance(((agkf)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
      Object localObject2 = (AIOFilePicData)((agkf)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("forward_type", 12);
      Object localObject3 = ((AIOFilePicData)localObject2).a(18);
      ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOFilePicData)localObject2).a(16));
      ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
      ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
        ((Bundle)localObject1).putString("forward_text", this.jdField_a_of_type_JavaUtilArrayList.size() + alud.a(2131702024));
      }
      ((Bundle)localObject1).putBoolean("sendMultiple", true);
      localObject2 = new ArrayList();
      localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localagkf = (agkf)((Iterator)localObject3).next();
        if (AIOImageData.class.isInstance(localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          ((ArrayList)localObject2).add(((AIOImageData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).b);
        } else if (AIOFilePicData.class.isInstance(localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          if (localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).d);
          } else if (localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).c);
          } else if (localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localagkf.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).b);
          }
        }
      }
      ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      aryv.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 1);
      return;
    }
    QLog.d("ChatHistoryImageView", 2, "callForwardRecentActivity error! mSelectedPhotoList ==null || mSelectedPhotoList.get(0) == null || !mSelectedPhotoList.get(0) instanceof AIOImageInfo");
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bhtd.removeMessages(102);
    this.jdField_a_of_type_AndroidAppDialog = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.jdField_a_of_type_Agjh.a(paramInt);
    if (!agkf.class.isInstance(paramAdapterView)) {}
    label80:
    label84:
    do
    {
      for (;;)
      {
        return;
        paramAdapterView = (agkf)paramAdapterView;
        if (!this.jdField_c_of_type_Boolean) {
          break;
        }
        if (paramAdapterView.b() == 1)
        {
          paramInt = 1;
          if (paramInt != 0) {
            break label80;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          if ((!a(paramAdapterView, bool)) || (a(paramView, paramAdapterView))) {
            break label84;
          }
          this.jdField_a_of_type_Agjx.notifyDataSetChanged();
          return;
          paramInt = 0;
          break;
        }
      }
      this.jdField_a_of_type_Agjh.e(paramInt);
      this.jdField_a_of_type_Agjh.b(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition());
      this.jdField_a_of_type_Agjh.c(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition());
      if (AIOShortVideoData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        paramView = (AIOShortVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if ((paramView.jdField_b_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramView.jdField_f_of_type_Long) == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) {
          break;
        }
        QQToast.a(BaseApplication.getContext(), 0, 2131720131, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
        return;
      }
      if (!AIOFileVideoData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        break label610;
      }
      paramView = (AIOFileVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramView.jdField_f_of_type_Long);
      if (!(paramView instanceof MessageForFile)) {
        break;
      }
      paramView = arrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramView);
    } while (paramView == null);
    label329:
    label357:
    Object localObject;
    if (arso.b(paramView.getFilePath()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("PauseDebug", 1, "file existed! isLocalFile:" + paramView.nSessionId);
      }
      if ((paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOFileVideoData)) {
        ((AIOFileVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).c = paramView.getFilePath();
      }
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, String.valueOf(0), this.jdField_b_of_type_Int, "3", "3");
      paramView = new Bundle();
      localObject = a();
      if (localObject != null) {
        paramView.putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject);
      }
      if (this.jdField_b_of_type_Int != 3000) {
        break label657;
      }
      paramView.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
    }
    for (;;)
    {
      paramView.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
      paramView.putBoolean("extra.IS_FROM_CHAT_FILE_HISTORY", true);
      paramView.putString("uin", this.jdField_a_of_type_JavaLangString);
      paramView.putInt("forward_source_uin_type", this.jdField_b_of_type_Int);
      paramView.putBoolean("extra.OCR", avvi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 7));
      if (this.jdField_b_of_type_Int == 1)
      {
        localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          paramView.putString("extra.GROUP_UIN", ((TroopInfo)localObject).troopuin);
        }
      }
      paramView.putBoolean("extra.ENTER_NEW_GALLERY", true);
      biqe.a(this.jdField_a_of_type_AndroidAppActivity, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService, paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, 2, 3);
      if ((paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null) || (!(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData))) {
        break;
      }
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, String.valueOf(((AIOShortVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_a_of_type_Int * 1000), this.jdField_b_of_type_Int, "2", "3");
      return;
      if (!paramView.sendCloudUnsuccessful()) {
        break label329;
      }
      arri.a(alud.a(2131702007));
      return;
      label610:
      if (!AIOLightVideoData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        break label357;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryImageView", 2, "lightvideo could not be opened in chathistory");
      }
      QQToast.a(BaseApplication.getContext(), alud.a(2131702047), 0).a();
      return;
      label657:
      paramView.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
    }
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if ((AppNetConnInfo.isMobileConn()) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.jdField_b_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryImageView", 2, "[onNetChangeEvent] show dialog");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.a(true);
      a(4, this.jdField_a_of_type_AndroidAppActivity.getString(2131692609));
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition();
      int i = this.jdField_a_of_type_Agjh.g();
      int j = this.jdField_a_of_type_Agjh.h();
      if (((paramInt >= i - 28) || (paramInt == i)) && (this.jdField_e_of_type_Int != j))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryImageView", 2, "[onScroll] loadMedias: mLastLoadingCount=" + this.jdField_e_of_type_Int);
        }
        this.jdField_e_of_type_Int = j;
        this.jdField_a_of_type_Agjx.a(true);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(0);
      }
    }
  }
  
  public void onSelectBegin(int paramInt)
  {
    boolean bool2 = false;
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Agjh.g() <= paramInt);
      localObject = this.jdField_a_of_type_Agjh.a(paramInt);
    } while (!agkf.class.isInstance(localObject));
    Object localObject = (agkf)localObject;
    if (((agkf)localObject).b() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_e_of_type_Boolean = bool1;
      bool1 = bool2;
      if (!this.jdField_e_of_type_Boolean) {
        bool1 = true;
      }
      if (a((agkf)localObject, bool1))
      {
        this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
        this.jdField_a_of_type_Agjx.notifyDataSetChanged();
      }
      this.f = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChatHistoryImageView", 2, "onSelectBegin beginIndex:" + paramInt);
      return;
    }
  }
  
  public void onSelectChanged(int paramInt1, int paramInt2)
  {
    if (!this.jdField_c_of_type_Boolean) {}
    while (!this.f) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "onSelectChanged beginIndex:" + paramInt1 + " selectIndex:" + paramInt2);
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
          break label177;
        }
        localObject = this.jdField_a_of_type_Agjh.a(paramInt1);
        if (agkf.class.isInstance(localObject)) {
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
    Object localObject = (agkf)localObject;
    if (!this.jdField_e_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      a((agkf)localObject, bool);
      break;
    }
    label177:
    paramInt1 = j + 1;
    if (paramInt1 <= this.jdField_c_of_type_Int)
    {
      localObject = this.jdField_a_of_type_Agjh.a(paramInt1);
      if (!agkf.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        a((agkf)localObject, this.jdField_e_of_type_Boolean);
      }
    }
    paramInt1 = this.jdField_d_of_type_Int;
    if (paramInt1 < i)
    {
      localObject = this.jdField_a_of_type_Agjh.a(paramInt1);
      if (!agkf.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        a((agkf)localObject, this.jdField_e_of_type_Boolean);
      }
    }
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
    this.jdField_a_of_type_Agjx.notifyDataSetChanged();
  }
  
  public void onSelectEnd()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    while (!this.f) {
      return;
    }
    this.f = false;
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "onSelectEnd");
    }
    this.jdField_e_of_type_Boolean = false;
    this.jdField_c_of_type_Int = -2147483648;
    this.jdField_d_of_type_Int = 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryImageView
 * JD-Core Version:    0.7.0.1
 */