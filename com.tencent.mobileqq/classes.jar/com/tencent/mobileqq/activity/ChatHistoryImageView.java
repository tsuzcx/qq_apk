package com.tencent.mobileqq.activity;

import aass;
import aast;
import aasu;
import aasv;
import aasw;
import aasx;
import aata;
import aeie;
import aeit;
import aeiu;
import aeiv;
import aeja;
import ajyc;
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
import apee;
import aptv;
import apue;
import apvb;
import aqbc;
import atzt;
import bawi;
import bbcv;
import bbgg;
import bbkx;
import bcpw;
import bfnk;
import bfob;
import bfpc;
import bfrq;
import bgkh;
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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xpy;

public class ChatHistoryImageView
  extends aata
  implements aeit, DialogInterface.OnCancelListener, Handler.Callback, bfob, bfpc, bfrq, INetEventHandler
{
  int jdField_a_of_type_Int;
  public aasx a;
  aeie jdField_a_of_type_Aeie;
  public aeiu a;
  Activity jdField_a_of_type_AndroidAppActivity;
  public Dialog a;
  View jdField_a_of_type_AndroidViewView;
  bbgg jdField_a_of_type_Bbgg;
  bfnk jdField_a_of_type_Bfnk;
  public ChatHistoryImageView.DownloadAndSaveTask a;
  public AIOImageProviderService a;
  AIORichMediaData jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  GestureSelectGridView jdField_a_of_type_ComTencentWidgetGestureSelectGridView;
  String jdField_a_of_type_JavaLangString;
  public ArrayList<aeja> a;
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
    int j = this.jdField_a_of_type_Aeie.f();
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
    bawi.a(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView, false);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public List<ChatMessage> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      aeja localaeja = (aeja)localIterator.next();
      ChatMessage localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int);
      if (localChatMessage != null) {
        localArrayList.add(localChatMessage);
      }
      this.jdField_a_of_type_Aeie.b(localaeja);
    }
    this.jdField_a_of_type_Aeiu.notifyDataSetChanged();
    if (this.jdField_a_of_type_Aeie.a() == 0) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.g = true;
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = false;
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Aeie.g() <= paramInt);
      localObject = this.jdField_a_of_type_Aeie.a(paramInt);
    } while (!aeja.class.isInstance(localObject));
    Object localObject = (aeja)localObject;
    if (((aeja)localObject).b() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_e_of_type_Boolean = bool1;
      bool1 = bool2;
      if (!this.jdField_e_of_type_Boolean) {
        bool1 = true;
      }
      if (a((aeja)localObject, bool1))
      {
        this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
        this.jdField_a_of_type_Aeiu.notifyDataSetChanged();
      }
      this.f = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChatHistoryImageView", 2, "onSelectBegin beginIndex:" + paramInt);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
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
          break label175;
        }
        localObject = this.jdField_a_of_type_Aeie.a(paramInt1);
        if (aeja.class.isInstance(localObject)) {
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
    Object localObject = (aeja)localObject;
    if (!this.jdField_e_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      a((aeja)localObject, bool);
      break;
    }
    label175:
    paramInt1 = j + 1;
    if (paramInt1 <= this.jdField_c_of_type_Int)
    {
      localObject = this.jdField_a_of_type_Aeie.a(paramInt1);
      if (!aeja.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        a((aeja)localObject, this.jdField_e_of_type_Boolean);
      }
    }
    paramInt1 = this.jdField_d_of_type_Int;
    if (paramInt1 < i)
    {
      localObject = this.jdField_a_of_type_Aeie.a(paramInt1);
      if (!aeja.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        a((aeja)localObject, this.jdField_e_of_type_Boolean);
      }
    }
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
    this.jdField_a_of_type_Aeiu.notifyDataSetChanged();
  }
  
  void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "[showDialog] type = " + paramInt);
    }
    if ((this.jdField_a_of_type_Bbgg != null) && (this.jdField_a_of_type_Bbgg.isShowing())) {
      this.jdField_a_of_type_Bbgg.dismiss();
    }
    this.jdField_a_of_type_Bbgg = bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    aass localaass = new aass(this);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bbgg.setMessage(paramString);
      try
      {
        this.jdField_a_of_type_Bbgg.show();
        return;
      }
      catch (Exception paramString) {}
      this.jdField_a_of_type_Bbgg.setNegativeButton(2131719540, localaass);
      continue;
      this.jdField_a_of_type_Bbgg.setNegativeButton(2131690596, localaass);
      this.jdField_a_of_type_Bbgg.setPositiveButton(2131719420, new aast(this));
      continue;
      this.jdField_a_of_type_Bbgg.setNegativeButton(2131690596, localaass);
      this.jdField_a_of_type_Bbgg.setPositiveButton(2131719420, new aasu(this));
      continue;
      this.jdField_a_of_type_Bbgg.setCancelable(false);
      this.jdField_a_of_type_Bbgg.setNegativeButton(2131690596, new aasv(this));
      this.jdField_a_of_type_Bbgg.setPositiveButton(2131719420, new aasw(this));
    }
  }
  
  public void a(long paramLong)
  {
    if ((this.h) || (this.jdField_a_of_type_Bfnk == null))
    {
      QLog.i("ChatHistoryImageView", 2, "onRevokeMsg, seq:" + paramLong + ", mDestroy:" + this.h);
      return;
    }
    this.jdField_a_of_type_Bfnk.post(new ChatHistoryImageView.1(this, paramLong));
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String arg6, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "[onImageDownload] id=" + paramLong + ",subId=" + paramInt1);
    }
    aeie localaeie = this.jdField_a_of_type_Aeie;
    if (paramInt3 == 1)
    {
      paramInt1 = localaeie.a(paramLong, paramInt1, paramInt2, ???, true);
      if (paramInt2 != 2) {
        break label230;
      }
      if (paramInt1 >= 0)
      {
        ??? = this.jdField_a_of_type_Aeie.a(paramInt1);
        if (aeja.class.isInstance(???)) {
          break label106;
        }
      }
    }
    label106:
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
            ??? = (aeja)???;
            ???.jdField_a_of_type_Int = 0;
            ???.jdField_a_of_type_Boolean = false;
            paramInt2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
            paramInt3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
            if ((paramInt1 >= paramInt2) && (paramInt1 <= paramInt3 + paramInt2 - 1)) {
              this.jdField_a_of_type_Aeiu.a(paramInt1, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(paramInt1 - paramInt2));
            }
          } while ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.a == null));
          synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.a)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.a.notifyAll();
            return;
          }
          if (paramInt2 != 1) {
            break label295;
          }
          paramInt2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
          paramInt3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
        } while ((paramInt1 < paramInt2) || (paramInt1 > paramInt3 + paramInt2 - 1));
        ??? = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(paramInt1 - paramInt2);
        this.jdField_a_of_type_Aeiu.a(paramInt1, ???);
        return;
      } while (paramInt2 != 16);
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
      paramInt3 = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildCount();
    } while ((paramInt1 < paramInt2) || (paramInt1 > paramInt3 + paramInt2 - 1));
    label230:
    ??? = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(paramInt1 - paramInt2);
    label295:
    this.jdField_a_of_type_Aeiu.a(paramInt1, ???);
  }
  
  public void a(Intent paramIntent)
  {
    if ((paramIntent != null) && ((paramIntent.getParcelableExtra("extra.EXTRA_CURRENT_IMAGE") instanceof AIORichMediaData))) {
      a((AIORichMediaData)paramIntent.getParcelableExtra("extra.EXTRA_CURRENT_IMAGE"), true);
    }
    if (!apee.a()) {
      this.jdField_a_of_type_Aeiu.notifyDataSetChanged();
    }
  }
  
  public void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("extra.IS_FROM_CHAT_AIO_GALLERY", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData = ((AIORichMediaData)paramIntent.getParcelableExtra("extra.EXTRA_CURRENT_IMAGE"));
    this.jdField_a_of_type_Bfnk = new bfnk(this);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560481, null);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367170));
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(false);
    int i = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297281);
    int j = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297282);
    int k = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297283);
    this.jdField_a_of_type_Int = ((bbkx.a() - i * 2 - j * 3) / 4);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setGravity(3);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(4);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(j);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(k);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setPadding(i, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingTop(), i, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365675);
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_b_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131692533));
    }
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    f();
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnIndexChangedListener(this);
    bawi.a(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView, false);
  }
  
  void a(AIORichMediaData paramAIORichMediaData, boolean paramBoolean)
  {
    int k = 0;
    int i = 0;
    if (i < this.jdField_a_of_type_Aeie.g())
    {
      Object localObject = this.jdField_a_of_type_Aeie.a(i);
      if (!aeja.class.isInstance(localObject)) {}
      do
      {
        i += 1;
        break;
        localObject = (aeja)localObject;
      } while ((((aeja)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long != paramAIORichMediaData.jdField_f_of_type_Long) || (((aeja)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int != paramAIORichMediaData.jdField_f_of_type_Int));
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
  
  public void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    this.jdField_a_of_type_Bfnk.post(new ChatHistoryImageView.2(this, paramArrayOfAIORichMediaData, paramInt));
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  boolean a(aeja paramaeja, boolean paramBoolean)
  {
    int i = paramaeja.b();
    if (((i == 1) && (paramBoolean)) || ((i == 2) && (!paramBoolean))) {}
    ChatMessage localChatMessage;
    do
    {
      return false;
      localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long);
      if (!paramBoolean) {
        break;
      }
    } while (((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a())) || ((this.jdField_a_of_type_Aasx != null) && (this.jdField_a_of_type_Aasx.a())) || ((this.jdField_a_of_type_Aasx != null) && (!this.jdField_a_of_type_Aasx.a(paramaeja))));
    if ((this.jdField_a_of_type_Aasx != null) && (localChatMessage != null)) {
      this.jdField_a_of_type_Aasx.a(localChatMessage);
    }
    paramaeja.a(1);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramaeja);
    for (;;)
    {
      return true;
      paramaeja.a(2);
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramaeja);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramaeja);
        if (localChatMessage != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.c(localChatMessage);
        }
      }
      if (this.jdField_a_of_type_Aasx != null)
      {
        this.jdField_a_of_type_Aasx.a(paramaeja);
        if (localChatMessage != null) {
          this.jdField_a_of_type_Aasx.b(localChatMessage);
        }
      }
    }
  }
  
  boolean a(View paramView, xpy paramxpy)
  {
    Object localObject = (aeiv)paramView.getTag();
    if (localObject != null)
    {
      paramView = ((aeiv)localObject).a;
      localObject = ((aeiv)localObject).b;
      switch (paramxpy.b())
      {
      default: 
        paramView.setVisibility(4);
        ((ImageView)localObject).setVisibility(4);
      }
      for (;;)
      {
        return true;
        paramView.setVisibility(0);
        ((ImageView)localObject).setImageResource(2130844861);
        ((ImageView)localObject).setVisibility(0);
        continue;
        paramView.setVisibility(4);
        ((ImageView)localObject).setImageResource(2130844858);
        ((ImageView)localObject).setVisibility(0);
      }
    }
    return false;
  }
  
  public void b()
  {
    this.g = false;
  }
  
  void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidAppActivity, 2131755791);
      this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559386);
      this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this);
    }
    String str = paramInt2 + "%";
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371557);
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
      str = localTextView.getResources().getText(2131689934) + str;
      continue;
      str = localTextView.getResources().getText(2131689932) + str;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a();
    if (this.jdField_d_of_type_Boolean) {
      AppNetConnInfo.unregisterNetEventHandler(this);
    }
    this.jdField_a_of_type_Aasx = null;
    this.h = true;
  }
  
  public void d()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_Aeiu.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Aeiu.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(true);
    }
  }
  
  public void e()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((xpy)localIterator.next()).a(2);
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Aeiu.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Aeiu.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(false);
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService = AIOImageProviderService.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, null, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(this);
    this.jdField_a_of_type_Aeie = new aeie(false);
    this.jdField_a_of_type_Aeiu = new aeiu(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_Aeie, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this.jdField_a_of_type_Aeiu);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(this);
    this.jdField_a_of_type_Aeiu.a(true);
    this.jdField_a_of_type_Aeiu.a(2);
    AIOImageProviderService localAIOImageProviderService = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 2;; i = 0)
    {
      localAIOImageProviderService.a(i);
      return;
    }
  }
  
  public void g()
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
                      localObject1 = (aeja)this.jdField_a_of_type_JavaUtilArrayList.get(0);
                      if ((AIOImageData.class.isInstance(((aeja)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) || (AIOFilePicData.class.isInstance(((aeja)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)))
                      {
                        i();
                        return;
                      }
                      if (!AIOShortVideoData.class.isInstance(((aeja)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
                        break;
                      }
                      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(((aeja)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, ((aeja)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int, this.jdField_b_of_type_Int);
                    } while (localObject1 == null);
                    aqbc.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject1);
                  } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity == null);
                  this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
                  return;
                } while (!AIOFileVideoData.class.isInstance(((aeja)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
                localObject2 = (AIOFileVideoData)((aeja)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(((AIOFileVideoData)localObject2).jdField_f_of_type_Long);
                if (!(localObject2 instanceof MessageForFile)) {
                  break label254;
                }
                if (!apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localObject2).sendCloudUnsuccessful()) {
                  break;
                }
                aptv.a(ajyc.a(2131701613));
              } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity == null);
              this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
              return;
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(((aeja)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, ((aeja)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int, this.jdField_b_of_type_Int);
            } while (localObject1 == null);
            aqbc.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject1);
          } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity == null);
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a();
          return;
        } while (!(localObject2 instanceof MessageForTroopFile));
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(((aeja)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Long, ((aeja)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.jdField_f_of_type_Int, this.jdField_b_of_type_Int);
      } while (localObject1 == null);
      aqbc.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject1);
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
        b(paramMessage.arg1, paramMessage.arg2);
        return true;
      } while (this.jdField_a_of_type_AndroidAppDialog == null);
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
      return true;
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.cancel();
    }
    bcpw.a(BaseApplication.getContext(), 1, 2131692532, 0).a();
    return true;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryImageView", 2, "[forward]");
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    aeja localaeja;
    if (localIterator.hasNext())
    {
      localaeja = (aeja)localIterator.next();
      if (AIOImageData.class.isInstance(localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        if (localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.g == 1)
        {
          if ((localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4) != null) || (localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2) != null) || (localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(1) != null)) {
            break label239;
          }
          i += 1;
        }
      }
    }
    label239:
    for (;;)
    {
      break;
      if (localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2) == null)
      {
        i += 1;
        continue;
        if ((AIOFilePicData.class.isInstance(localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) && (localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20) == null) && (localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18) == null) && (localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16) == null))
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
            a(3, ajyc.a(2131701579));
            return;
          }
          aptv.a(ajyc.a(2131701609));
          return;
        }
      }
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.get(0) != null))
    {
      localObject1 = (aeja)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (AIOImageData.class.isInstance(((aeja)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        localObject2 = (AIOImageData)((aeja)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("forward_type", 12);
        localObject3 = ((AIOImageData)localObject2).a(2);
        ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOImageData)localObject2).a(1));
        ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
        ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
          ((Bundle)localObject1).putString("forward_text", this.jdField_a_of_type_JavaUtilArrayList.size() + ajyc.a(2131701644));
        }
        ((Bundle)localObject1).putBoolean("sendMultiple", true);
        ((Bundle)localObject1).putBoolean("key_allow_forward_photo_preview_edit", true);
        localObject2 = new ArrayList();
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localaeja = (aeja)((Iterator)localObject3).next();
          if (AIOImageData.class.isInstance(localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
          {
            if (localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.g == 1)
            {
              if (localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4) != null) {
                ((ArrayList)localObject2).add(((AIOImageData)localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).c);
              } else if (localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2) != null) {
                ((ArrayList)localObject2).add(((AIOImageData)localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).b);
              } else if (localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(1) != null) {
                ((ArrayList)localObject2).add(((AIOImageData)localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_a_of_type_JavaLangString);
              }
            }
            else {
              ((ArrayList)localObject2).add(((AIOImageData)localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).b);
            }
          }
          else if (AIOFilePicData.class.isInstance(localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
            if (localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).d);
            } else if (localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).c);
            } else if (localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16) != null) {
              ((ArrayList)localObject2).add(((AIOFilePicData)localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).b);
            }
          }
        }
        ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtras((Bundle)localObject1);
        aqbc.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 1);
      }
    }
    while (!QLog.isColorLevel())
    {
      aeja localaeja;
      do
      {
        return;
      } while (!AIOFilePicData.class.isInstance(((aeja)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData));
      Object localObject2 = (AIOFilePicData)((aeja)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("forward_type", 12);
      Object localObject3 = ((AIOFilePicData)localObject2).a(18);
      ((Bundle)localObject1).putString("forward_urldrawable_thumb_url", ((AIOFilePicData)localObject2).a(16));
      ((Bundle)localObject1).putString("forward_urldrawable_big_url", (String)localObject3);
      ((Bundle)localObject1).putBoolean("forward_urldrawable", true);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
        ((Bundle)localObject1).putString("forward_text", this.jdField_a_of_type_JavaUtilArrayList.size() + ajyc.a(2131701628));
      }
      ((Bundle)localObject1).putBoolean("sendMultiple", true);
      localObject2 = new ArrayList();
      localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localaeja = (aeja)((Iterator)localObject3).next();
        if (AIOImageData.class.isInstance(localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          ((ArrayList)localObject2).add(((AIOImageData)localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).b);
        } else if (AIOFilePicData.class.isInstance(localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          if (localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).d);
          } else if (localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).c);
          } else if (localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16) != null) {
            ((ArrayList)localObject2).add(((AIOFilePicData)localaeja.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).b);
          }
        }
      }
      ((Bundle)localObject1).putStringArrayList("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      aqbc.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 1);
      return;
    }
    QLog.d("ChatHistoryImageView", 2, "callForwardRecentActivity error! mSelectedPhotoList ==null || mSelectedPhotoList.get(0) == null || !mSelectedPhotoList.get(0) instanceof AIOImageInfo");
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bfnk.removeMessages(102);
    this.jdField_a_of_type_AndroidAppDialog = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView$DownloadAndSaveTask.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.jdField_a_of_type_Aeie.a(paramInt);
    if (!aeja.class.isInstance(paramAdapterView)) {}
    label80:
    label84:
    do
    {
      for (;;)
      {
        return;
        paramAdapterView = (aeja)paramAdapterView;
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
          this.jdField_a_of_type_Aeiu.notifyDataSetChanged();
          return;
          paramInt = 0;
          break;
        }
      }
      this.jdField_a_of_type_Aeie.e(paramInt);
      this.jdField_a_of_type_Aeie.b(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition());
      this.jdField_a_of_type_Aeie.c(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition());
      if (AIOShortVideoData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))
      {
        paramView = (AIOShortVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        if ((paramView.jdField_b_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramView.jdField_f_of_type_Long) == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) {
          break;
        }
        bcpw.a(BaseApplication.getContext(), 0, 2131719576, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
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
      paramView = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramView);
    } while (paramView == null);
    label329:
    label357:
    Object localObject;
    if (apvb.b(paramView.getFilePath()))
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
        break label656;
      }
      paramView.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
    }
    for (;;)
    {
      paramView.putInt("extra.MOBILE_QQ_PROCESS_ID", Process.myPid());
      paramView.putBoolean("extra.IS_FROM_CHAT_FILE_HISTORY", true);
      paramView.putString("uin", this.jdField_a_of_type_JavaLangString);
      paramView.putInt("forward_source_uin_type", this.jdField_b_of_type_Int);
      paramView.putBoolean("extra.OCR", atzt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 7));
      if (this.jdField_b_of_type_Int == 1)
      {
        localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          paramView.putString("extra.GROUP_UIN", ((TroopInfo)localObject).troopuin);
        }
      }
      paramView.putBoolean("extra.ENTER_NEW_GALLERY", true);
      bgkh.a(this.jdField_a_of_type_AndroidAppActivity, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService, paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData, 2, 3);
      if ((paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null) || (!(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData instanceof AIOShortVideoData))) {
        break;
      }
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, String.valueOf(((AIOShortVideoData)paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData).jdField_a_of_type_Int * 1000), this.jdField_b_of_type_Int, "2", "3");
      return;
      if (!paramView.sendCloudUnsuccessful()) {
        break label329;
      }
      aptv.a(ajyc.a(2131701611));
      return;
      label610:
      if (!AIOLightVideoData.class.isInstance(paramAdapterView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
        break label357;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryImageView", 2, "lightvideo could not be opened in chathistory");
      }
      bcpw.a(BaseApplication.getContext(), ajyc.a(2131701651), 0).a();
      return;
      label656:
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
      a(4, this.jdField_a_of_type_AndroidAppActivity.getString(2131692531));
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getLastVisiblePosition();
      int i = this.jdField_a_of_type_Aeie.g();
      if (((paramInt >= i - 28) || (paramInt == i)) && (this.jdField_e_of_type_Int != i))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryImageView", 2, "[onScroll] loadMedias: mLastLoadingCount=" + this.jdField_e_of_type_Int);
        }
        this.jdField_e_of_type_Int = i;
        this.jdField_a_of_type_Aeiu.a(true);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryImageView
 * JD-Core Version:    0.7.0.1
 */