package com.tencent.mobileqq.activity;

import Override;
import adpd;
import adpf;
import adpg;
import adpi;
import adpj;
import adpk;
import adpl;
import adpm;
import adpn;
import adpo;
import adpp;
import adpq;
import adpr;
import adps;
import adpt;
import adqg;
import adqi;
import ahrf;
import ahrh;
import ahsl;
import ahtm;
import airh;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anvx;
import asku;
import atfq;
import athn;
import atlf;
import atlh;
import atpj;
import aucx;
import audn;
import audr;
import audy;
import auea;
import aupt;
import axjb;
import axjf;
import axjk;
import bdla;
import becr;
import bhdj;
import bixr;
import bkyc;
import bkzi;
import bkzz;
import bmqx;
import bmri;
import bmrr;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryFileActivity
  extends IphoneTitleBarActivity
  implements ahrh, Handler.Callback, View.OnClickListener
{
  int jdField_a_of_type_Int;
  adpd jdField_a_of_type_Adpd;
  adpt jdField_a_of_type_Adpt;
  adqg jdField_a_of_type_Adqg;
  public adqi a;
  private airh jdField_a_of_type_Airh;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout a;
  private atfq jdField_a_of_type_Atfq;
  ChatHistoryImageView jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  String jdField_a_of_type_JavaLangString;
  public List<ChatMessage> a;
  public final MqqHandler a;
  public boolean a;
  private int jdField_b_of_type_Int;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  String jdField_b_of_type_JavaLangString;
  public List<FileManagerEntity> b;
  private boolean jdField_b_of_type_Boolean;
  ImageView c;
  public List<ahtm> c;
  ImageView d;
  public List<TencentDocData> d;
  List<asku> e;
  List<ChatMessage> f;
  
  public ChatHistoryFileActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Adqi = null;
    this.jdField_a_of_type_MqqOsMqqHandler = new bkyc(Looper.getMainLooper(), this, true);
  }
  
  private adqi a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
    case 3: 
      if (this.jdField_a_of_type_Adpt == null)
      {
        this.jdField_a_of_type_Adpt = new adpt();
        this.jdField_a_of_type_Adpt.a(getIntent(), this.app, this);
      }
      this.jdField_a_of_type_Adpt.j_(paramInt);
      return this.jdField_a_of_type_Adpt;
    case 0: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView = new ChatHistoryImageView();
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(getIntent(), this.app, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
    case 2: 
      if (this.jdField_a_of_type_Adqg == null)
      {
        this.jdField_a_of_type_Adqg = new adqg();
        this.jdField_a_of_type_Adqg.a(getIntent(), this.app, this);
      }
      return this.jdField_a_of_type_Adqg;
    }
    if (this.jdField_a_of_type_Adpd == null)
    {
      this.jdField_a_of_type_Adpd = new adpd();
      this.jdField_a_of_type_Adpd.a(getIntent(), this.app, this);
    }
    return this.jdField_a_of_type_Adpd;
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, adps paramadps)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this, 2131755829);
    localQQCustomDialog.setContentView(2131559043);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = localQQCustomDialog;
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(paramString1);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131690697);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131691037);
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(paramString1, new adpp(this, paramadps));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(paramString2, new adpq(this, paramadps));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(true);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void a(List<ChatMessage> paramList)
  {
    if (paramList.size() == 1) {
      bmri.b(this.app, this, getTitleBarHeight(), paramList, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    for (;;)
    {
      bdla.b(this.app, "dc00898", "", "", "0X8009DB9", "0X8009DB9", 0, 0, "", "", "", "");
      return;
      bmri.a(this.app, this, getTitleBarHeight(), paramList, this.jdField_a_of_type_MqqOsMqqHandler);
    }
  }
  
  private void a(List<ahtm> paramList, List<asku> paramList1)
  {
    ArrayList localArrayList;
    Iterator localIterator;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a != null))
    {
      localArrayList = new ArrayList();
      if ((paramList != null) && (paramList.size() > 0)) {
        localIterator = paramList.iterator();
      }
    }
    label429:
    for (;;)
    {
      ChatMessage localChatMessage;
      if (localIterator.hasNext())
      {
        paramList = (ahtm)localIterator.next();
        localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a.a(paramList.a.f);
        if ((localChatMessage instanceof MessageForPic)) {
          paramList = axjf.a((MessageForPic)localChatMessage);
        }
      }
      for (;;)
      {
        if (paramList == null) {
          break label429;
        }
        localArrayList.add(paramList);
        break;
        if ((localChatMessage instanceof MessageForShortVideo))
        {
          paramList = (MessageForShortVideo)localChatMessage;
          if (paramList.busiType == 0) {
            paramList = axjf.b(this.app, paramList);
          } else {
            paramList = axjf.a(this.app, paramList);
          }
        }
        else
        {
          if ((localChatMessage instanceof MessageForFile))
          {
            if (AIOFilePicData.class.isInstance(paramList.a))
            {
              paramList = axjf.a(this.app, localChatMessage);
              paramList.jdField_a_of_type_Int = 4;
              continue;
            }
            if (AIOFileVideoData.class.isInstance(paramList.a))
            {
              paramList = axjf.a(this.app, localChatMessage);
              paramList.jdField_a_of_type_Int = 5;
            }
          }
          else if ((localChatMessage instanceof MessageForTroopFile))
          {
            if (AIOFilePicData.class.isInstance(paramList.a))
            {
              paramList = axjf.a(this.app, localChatMessage);
              paramList.jdField_a_of_type_Int = 6;
              continue;
            }
            if (AIOFileVideoData.class.isInstance(paramList.a))
            {
              paramList = axjf.a(this.app, localChatMessage);
              paramList.jdField_a_of_type_Int = 7;
              continue;
              if ((paramList1 != null) && (!paramList1.isEmpty()))
              {
                paramList = paramList1.iterator();
                while (paramList.hasNext())
                {
                  paramList1 = (asku)paramList.next();
                  if ((paramList1.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) {
                    localArrayList.add(axjf.a((MessageForPic)paramList1.jdField_a_of_type_ComTencentMobileqqDataMessageRecord));
                  }
                }
              }
              paramList = new axjb(this);
              paramList1 = (axjk)this.app.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
              paramList1.a(new adpg(this, paramList, paramList1, localArrayList));
              paramList1.a(localArrayList, true);
              paramList1.a(localArrayList, 1, 5);
              return;
            }
          }
          paramList = null;
        }
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367213));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365827));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377036));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365460));
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = getResources().getDrawable(2130839542);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
    localDrawable = getResources().getDrawable(2130839543);
    localStateListDrawable.addState(new int[] { 16842910 }, localDrawable);
    localDrawable = getResources().getDrawable(2130839542);
    localStateListDrawable.addState(new int[0], localDrawable);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(localStateListDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(true);
  }
  
  public void a()
  {
    boolean bool;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label57;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_Adqi.e();
      setRightButton(2131690697, this);
    }
    label57:
    do
    {
      return;
      bool = false;
      break;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.jdField_a_of_type_Adqi.f();
      setRightButton(2131689980, this);
      this.jdField_d_of_type_JavaUtilList = null;
      this.jdField_c_of_type_JavaUtilList = null;
      this.jdField_a_of_type_JavaUtilList = null;
      this.jdField_b_of_type_JavaUtilList = null;
      this.f = null;
    } while ((this.e == null) || (this.e.isEmpty()));
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((asku)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
    this.e.clear();
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Adqi != null) {
      this.jdField_a_of_type_Adqi.a(paramLong);
    }
  }
  
  public void a(ahtm paramahtm)
  {
    if (this.jdField_c_of_type_JavaUtilList == null) {
      this.jdField_c_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_c_of_type_JavaUtilList.add(paramahtm);
  }
  
  public void a(asku paramasku)
  {
    if (this.e == null) {
      this.e = new ArrayList();
    }
    this.e.add(paramasku);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (this.f == null) {
      this.f = new ArrayList();
    }
    this.f.add(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryStruct", 2, "addweiyunselected, size: " + this.f.size());
    }
  }
  
  public void a(TencentDocData paramTencentDocData)
  {
    if (this.jdField_d_of_type_JavaUtilList == null) {
      this.jdField_d_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_d_of_type_JavaUtilList.add(paramTencentDocData);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilList.add(paramFileManagerEntity);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this, 230);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131718822, new adpj(this));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
      catch (Throwable paramString) {}
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int j = this.jdField_a_of_type_JavaUtilList.size() + 0;; j = 0)
    {
      int i = j;
      if (this.jdField_b_of_type_JavaUtilList != null) {
        i = j + this.jdField_b_of_type_JavaUtilList.size();
      }
      j = i;
      if (this.jdField_c_of_type_JavaUtilList != null) {
        j = i + this.jdField_c_of_type_JavaUtilList.size();
      }
      i = j;
      if (this.jdField_d_of_type_JavaUtilList != null) {
        i = j + this.jdField_d_of_type_JavaUtilList.size();
      }
      j = i;
      if (this.e != null) {
        j = i + this.e.size();
      }
      if (j >= 20) {
        bool = true;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryFIleActivity", 2, "isOverLimit");
        }
        audr.a(2131692370);
      }
      return bool;
    }
  }
  
  public boolean a(int paramInt, List<ChatMessage> paramList, List<FileManagerEntity> paramList1, List<ahtm> paramList2, List<TencentDocData> paramList3)
  {
    int n = 0;
    int i1 = 0;
    boolean bool2;
    int k;
    int m;
    if (becr.a(paramList3))
    {
      bool2 = true;
      k = 0;
      m = 0;
      if ((paramList1 == null) || (paramList1.size() <= 0)) {
        break label2158;
      }
      m = 1;
      k = 0 + paramList1.size();
    }
    label187:
    label234:
    label2158:
    for (int i3 = 1;; i3 = 0)
    {
      int i = m;
      int j = k;
      if (bool2)
      {
        i = m + 1;
        j = k + paramList3.size();
      }
      int i4;
      if ((paramList != null) && (paramList.size() > 0))
      {
        k = paramList.size();
        i4 = 1;
        j += k;
        i += 1;
      }
      for (;;)
      {
        Object localObject1;
        boolean bool1;
        if ((this.e != null) && (!this.e.isEmpty())) {
          if (paramInt == 1)
          {
            localObject1 = this.e.iterator();
            while (((Iterator)localObject1).hasNext()) {
              if ((((asku)((Iterator)localObject1).next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForMarketFace))
              {
                bool1 = true;
                k = j + this.e.size();
                i += 1;
              }
            }
          }
        }
        for (;;)
        {
          int i2;
          if (paramList2 != null)
          {
            localObject1 = paramList2.iterator();
            j = i;
            i = 0;
            m = 0;
            n = 0;
            if (((Iterator)localObject1).hasNext())
            {
              int i5 = ahsl.a(((ahtm)((Iterator)localObject1).next()).a);
              if ((n == 0) && (i5 == 1))
              {
                n = 1;
                j += 1;
                i2 = j;
                i1 = m;
                if (m == 0)
                {
                  i2 = j;
                  i1 = m;
                  if (i5 == 2)
                  {
                    i1 = 1;
                    i2 = j + 1;
                  }
                }
                if ((i == 0) && (i5 == 3))
                {
                  i = i2 + 1;
                  j = 1;
                  if ((paramInt != 1) && (i >= 2))
                  {
                    m = i1;
                    i1 = paramList2.size();
                    i1 += k;
                    k = j;
                    j = i1;
                  }
                }
              }
            }
          }
          for (;;)
          {
            if (j == 0)
            {
              audr.c(2131692367);
              return false;
              bool2 = false;
              break;
              bool1 = true;
              break label187;
              m = j;
              j = i;
              i = m;
              m = i1;
              break label234;
            }
            switch (paramInt)
            {
            default: 
              return true;
            case 0: 
              if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
              {
                QQToast.a(this, 2131694305, 1).b(getResources().getDimensionPixelSize(2131299080));
                return false;
              }
              if (i > 1)
              {
                a(getString(2131692361));
                return false;
              }
              if (k != 0)
              {
                a(getString(2131692342));
                return false;
              }
              if ((m != 0) && (paramList2.size() > 1))
              {
                a(getString(2131692363));
                return false;
              }
              if (paramList1 != null)
              {
                if ((paramList1.size() == 1) && (((FileManagerEntity)paramList1.get(0)).sendCloudUnsuccessful()))
                {
                  audr.a(2131692380);
                  return false;
                }
                localObject1 = paramList1.iterator();
                do
                {
                  if (!((Iterator)localObject1).hasNext()) {
                    break;
                  }
                } while (!aucx.a((FileManagerEntity)((Iterator)localObject1).next()).a(false));
              }
              break;
            }
            for (paramInt = 1;; paramInt = 0)
            {
              if (paramInt != 0) {
                audn.a(this, 2131692476, 2131692481, new adpl(this, paramList1));
              }
              while ((paramList2 != null) && (paramList2.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null))
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.i();
                return false;
                auea.a(paramList1, this);
              }
              paramList1 = new ArrayList();
              if (paramList != null) {
                paramList1.addAll(paramList);
              }
              if (bool2)
              {
                paramList1.addAll(becr.a(paramList3, this.jdField_a_of_type_JavaLangString, null));
                audy.a("0X8009AA1");
              }
              if ((paramList1 != null) && (paramList1.size() == 1))
              {
                paramList2 = (MessageForStructing)paramList1.get(0);
                if (paramList2.structingMsg != null)
                {
                  paramList = new Bundle();
                  if ((paramList2.structingMsg.source_puin != null) && (!"".equals(paramList2.structingMsg.source_puin))) {
                    paramList.putString("source_puin", paramList2.structingMsg.source_puin);
                  }
                  paramList.putInt("forward_type", -3);
                  paramList2.structingMsg.mCommentText = null;
                  paramList.putInt("structmsg_service_id", paramList2.structingMsg.mMsgServiceID);
                  paramList.putByteArray("stuctmsg_bytes", paramList2.structingMsg.getBytes());
                  paramList.putLong("structmsg_uniseq", paramList2.uniseq);
                  paramList.putInt("accostType", paramList2.structingMsg.sourceAccoutType);
                  paramList.putBoolean("forwardDirect", true);
                  paramList2 = new Intent();
                  paramList2.putExtras(paramList);
                  paramList2.putExtra("forwardDirect", true);
                  aupt.a(this, paramList2, 3);
                }
              }
              if (((paramList1 == null) || (paramList1.size() <= 1)) && (!bool1)) {
                break;
              }
              paramList = new ArrayList();
              if (paramList1 != null) {
                paramList.addAll(paramList1);
              }
              if (bool1)
              {
                paramList1 = this.e.iterator();
                while (paramList1.hasNext()) {
                  paramList.add((ChatMessage)((asku)paramList1.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
                }
              }
              this.jdField_b_of_type_Boolean = bool1;
              this.jdField_a_of_type_Airh.a(paramList);
              break;
              if (((n != 0) || (m != 0)) && (i3 != 0))
              {
                a(getString(2131692359));
                return false;
              }
              if ((i4 != 0) || (bool2) || (bool1))
              {
                a(getString(2131692360));
                return false;
              }
              if (!CheckPermission.isHasStoragePermission(this))
              {
                CheckPermission.requestStorePermission(this, null);
                return false;
              }
              long l;
              if (paramList1 != null)
              {
                l = 0L;
                if ((paramList1.size() == 1) && (((FileManagerEntity)paramList1.get(0)).sendCloudUnsuccessful()))
                {
                  audr.a(2131692379);
                  return false;
                }
                paramList = paramList1.iterator();
                if (paramList.hasNext())
                {
                  paramList3 = (FileManagerEntity)paramList.next();
                  if (!aucx.a(paramList3).a(true)) {
                    break label2085;
                  }
                  l = paramList3.fileSize + l;
                }
              }
              for (;;)
              {
                break label1164;
                paramList = this.app.getFileManagerEngine();
                if ((auea.a()) && (l > atpj.a())) {
                  auea.a(false, this, new adpm(this, paramList1, paramList));
                }
                while (((paramList2 != null) && (paramList2.size() > 0)) || ((!bool1) && (this.e != null) && (!this.e.isEmpty())))
                {
                  a(paramList2, this.e);
                  return false;
                  paramList1 = paramList1.iterator();
                  while (paramList1.hasNext())
                  {
                    paramList3 = (FileManagerEntity)paramList1.next();
                    if (!paramList3.sendCloudUnsuccessful()) {
                      paramList.b(paramList3);
                    }
                  }
                }
                if (((paramList2 != null) && (this.f != null)) || ((paramList != null) && (paramList.size() > 0)) || ((paramList1 != null) && (paramList1.size() > 0))) {
                  b();
                }
                if ((paramList2 != null) && (this.f != null)) {
                  a(this.f);
                }
                if (paramList != null)
                {
                  a(paramList);
                  break;
                }
                if ((paramList1 == null) || (paramList1.size() <= 0)) {
                  break;
                }
                paramList = (FileManagerEntity)paramList1.get(0);
                paramList = this.app.getFileManagerEngine();
                if ((paramList1.size() == 1) && (((FileManagerEntity)paramList1.get(0)).sendCloudUnsuccessful()))
                {
                  audr.a(2131692381);
                  return false;
                }
                paramList2 = paramList1.iterator();
                do
                {
                  if (!paramList2.hasNext()) {
                    break;
                  }
                } while (!aucx.a((FileManagerEntity)paramList2.next()).a(false));
                for (paramInt = 1;; paramInt = 0)
                {
                  if (paramInt != 0)
                  {
                    if (!bixr.a(this, 5, new adpn(this, paramList1, paramList))) {
                      break;
                    }
                    audn.a(this, 2131692476, 2131692479, new adpo(this, paramList1, paramList));
                    break;
                  }
                  paramList1 = paramList1.iterator();
                  paramInt = 0;
                  while (paramList1.hasNext())
                  {
                    paramList2 = (FileManagerEntity)paramList1.next();
                    if (!paramList2.sendCloudUnsuccessful()) {
                      if (FileUtils.fileExistsAndNotEmpty(paramList2.getFilePath()))
                      {
                        paramList.a(paramList2.getFilePath(), "", this.app.getCurrentAccountUin(), 0, false);
                        paramInt = 1;
                      }
                      else
                      {
                        paramInt = 1;
                        paramList.a(paramList2, String.valueOf(paramList2.peerUin));
                      }
                    }
                  }
                  if (paramInt != 0)
                  {
                    audr.d(getString(2131692595));
                    break;
                  }
                  audr.a(2131692381);
                  if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
                    break;
                  }
                  this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(102);
                  break;
                  localObject1 = new ArrayList();
                  Iterator localIterator;
                  Object localObject2;
                  if ((paramList1 != null) && (paramList1.size() > 0))
                  {
                    localIterator = paramList1.iterator();
                    while (localIterator.hasNext())
                    {
                      localObject2 = (FileManagerEntity)localIterator.next();
                      localObject2 = this.app.getMessageFacade().queryMsgItemByUniseq(((FileManagerEntity)localObject2).peerUin, ((FileManagerEntity)localObject2).peerType, ((FileManagerEntity)localObject2).uniseq);
                      if (localObject2 != null) {
                        ((List)localObject1).add((ChatMessage)localObject2);
                      }
                    }
                  }
                  if ((paramList2 != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null))
                  {
                    paramList2 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a();
                    localIterator = paramList2.iterator();
                    while (localIterator.hasNext())
                    {
                      localObject2 = (ChatMessage)localIterator.next();
                      if (((ChatMessage)localObject2).msgtype == -2005)
                      {
                        localObject2 = this.app.getFileManagerDataCenter().a(((ChatMessage)localObject2).uniseq, ((ChatMessage)localObject2).frienduin, ((ChatMessage)localObject2).istroop);
                        if (localObject2 != null) {
                          this.app.getFileManagerEngine().b(((FileManagerEntity)localObject2).nSessionId);
                        }
                      }
                    }
                    ((List)localObject1).addAll(paramList2);
                  }
                  if ((paramList != null) && (paramList.size() > 0)) {
                    ((List)localObject1).addAll(paramList);
                  }
                  if ((this.e != null) && (!this.e.isEmpty()))
                  {
                    paramList = this.e.iterator();
                    while (paramList.hasNext()) {
                      ((List)localObject1).add((ChatMessage)((asku)paramList.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
                    }
                  }
                  if (((((List)localObject1).size() == 0) && (paramList1 == null) && (!bool2)) || ((((List)localObject1).size() <= 0) && (!becr.a(paramList1)) && (!bool2))) {
                    break;
                  }
                  ThreadManager.post(new ChatHistoryFileActivity.7(this, (List)localObject1, paramList1, bool2, paramList3), 8, null, true);
                  break;
                }
              }
            }
            j = i;
            i = i2;
            break label338;
            break label282;
            i1 = i;
            i = j;
            j = i1;
            break label353;
            j = k;
            m = 0;
            k = i1;
          }
          bool1 = false;
          break label187;
          bool1 = false;
          k = j;
        }
        i4 = 0;
      }
    }
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilList.contains(paramChatMessage);
  }
  
  public boolean a(TencentDocData paramTencentDocData)
  {
    return (this.jdField_d_of_type_JavaUtilList != null) && (this.jdField_d_of_type_JavaUtilList.contains(paramTencentDocData));
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return false;
    }
    return this.jdField_b_of_type_JavaUtilList.contains(paramFileManagerEntity);
  }
  
  void b()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(getActivity(), 2131755829);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559607);
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372740);
    localTextView.setText(localTextView.getResources().getString(2131689926));
    if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b(ahtm paramahtm)
  {
    if (this.jdField_c_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_c_of_type_JavaUtilList.remove(paramahtm);
  }
  
  public void b(asku paramasku)
  {
    if (this.e == null) {
      return;
    }
    this.e.remove(paramasku);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryStruct", 2, "addselect, size: " + this.jdField_a_of_type_JavaUtilList.size());
    }
  }
  
  public void b(TencentDocData paramTencentDocData)
  {
    if (this.jdField_d_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_d_of_type_JavaUtilList.remove(paramTencentDocData);
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.remove(paramFileManagerEntity);
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList.remove(paramChatMessage);
    } while (!QLog.isColorLevel());
    QLog.d("ChatHistoryStruct", 2, "removeselect, size: " + this.jdField_a_of_type_JavaUtilList.size());
  }
  
  public void d(ChatMessage paramChatMessage)
  {
    if (this.f == null) {}
    do
    {
      return;
      this.f.remove(paramChatMessage);
    } while (!QLog.isColorLevel());
    QLog.d("ChatHistoryStruct", 2, "removeweiyunselect, size: " + this.f.size());
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      if (paramInt1 == 1) {
        a();
      }
      return;
      Intent localIntent = new Intent(this, SendPhotoActivity.class);
      paramIntent = new Bundle(paramIntent.getExtras());
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "AIOListGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
      }
      paramIntent.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
      paramIntent.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent = AIOUtils.setOpenAIOIntent(localIntent, null);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramIntent.putBoolean("PicContants.NEED_COMPRESS", false);
      paramIntent.putBoolean("send_in_background", false);
      localIntent.putExtras(paramIntent);
      startActivity(localIntent);
      continue;
      a();
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(paramIntent);
        continue;
        if (!this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_Airh.a(paramIntent);
        }
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    Object localObject = getIntent();
    this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("uin");
    this.jdField_a_of_type_Int = ((Intent)localObject).getIntExtra("uintype", 0);
    this.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("uinname");
    setContentView(2131558854);
    setTitle(2131690758);
    if (((Intent)localObject).getStringExtra("leftViewText") == null) {
      setLeftViewName(2131690845);
    }
    for (;;)
    {
      paramBundle = (TabBarView)findViewById(2131378427);
      paramBundle.a(0, anvx.a(2131701142));
      paramBundle.a(1, anvx.a(2131701162));
      paramBundle.a(2, anvx.a(2131701152));
      paramBundle.a(3, anvx.a(2131701090));
      paramBundle.a(4, anvx.a(2131701161));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377319));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131379202));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      setRightButton(2131689980, this);
      c();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370712));
      paramBundle.setOnTabChangeListener(new adpf(this));
      localObject = ((Intent)localObject).getStringExtra("com.tencent.mobileqq.ChatHistoryFileActivity.initial_tab");
      try
      {
        i = Integer.parseInt((String)localObject);
        paramBundle.setSelectedTab(i, true);
        this.jdField_a_of_type_Airh = new airh(this, 3);
        this.jdField_a_of_type_Airh.a();
        ahrf.a().a(this);
        if (this.jdField_a_of_type_Atfq == null) {
          this.jdField_a_of_type_Atfq = new adpr(this, null);
        }
        this.app.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_Atfq);
        return true;
        setLeftViewName((Intent)localObject);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("ChatHistoryFIleActivity", 1, "extra KEY_INITIAL_TAB " + (String)localObject + " is not number");
          int i = 0;
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Airh.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.d();
    }
    if (this.jdField_a_of_type_Adpd != null) {
      this.jdField_a_of_type_Adpd.d();
    }
    if (this.jdField_a_of_type_Atfq != null) {
      this.app.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_Atfq);
    }
    ahrf.a().b(this);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.jdField_a_of_type_Boolean))
    {
      a();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Adqi != null) {
      this.jdField_a_of_type_Adqi.c();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Adqi != null)
    {
      this.jdField_a_of_type_Adqi.j_(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Adqi.b();
    }
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299080);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      do
      {
        return true;
        if (this.jdField_a_of_type_Adqg != null) {
          this.jdField_a_of_type_Adqg.a(this.jdField_a_of_type_JavaUtilList);
        }
        if (this.jdField_a_of_type_Adpd != null) {
          this.jdField_a_of_type_Adpd.g();
        }
        a();
        a(this.jdField_b_of_type_Int);
        return true;
      } while (this.jdField_a_of_type_AndroidAppDialog == null);
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      bmrr.a(this.app, this, getTitleBarHeight());
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      i = paramMessage.arg1;
    } while (!bmqx.a(i));
    if (bmqx.d(i))
    {
      getString(2131694472);
      paramMessage = "";
      if (bmqx.b(i))
      {
        getString(2131694472);
        paramMessage = getString(2131692021);
      }
      for (;;)
      {
        adpi localadpi = new adpi(this);
        a(getString(2131698387), paramMessage, null, null, localadpi);
        return true;
        if (bmqx.c(i))
        {
          getString(2131694472);
          paramMessage = getString(2131692019);
        }
      }
    }
    paramMessage = (String)paramMessage.obj;
    QQToast.a(this.app.getApp(), paramMessage, 1).b(getTitleBarHeight());
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    finish();
    if (getIntent().getBooleanExtra("extra.IS_FROM_CHAT_AIO_GALLERY", false)) {
      overridePendingTransition(0, 2130772337);
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    int j = 0;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a();
      if (this.jdField_a_of_type_Boolean)
      {
        bdla.b(this.app, "dc00898", "", "", "0X8007125", "0X8007125", 0, 0, "", "", "", "");
        continue;
        if (a(0, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList)) {
          a();
        }
        bdla.b(this.app, "dc00898", "", "", "0X8007129", "0X8007129", 0, 0, "", "", "", "");
        continue;
        if (a(1, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList)) {
          a();
        }
        bdla.b(this.app, "dc00898", "", "", "0X800712A", "0X800712A", 0, 0, "", "", "", "");
        continue;
        if (a(2, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList)) {
          a();
        }
        bdla.b(this.app, "dc00898", "", "", "0X800712B", "0X800712B", 0, 0, "", "", "", "");
        continue;
        bdla.b(this.app, "dc00898", "", "", "0X800712C", "0X800712C", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_JavaUtilList != null) {
          j = 0 + this.jdField_a_of_type_JavaUtilList.size();
        }
        int i = j;
        if (this.jdField_b_of_type_JavaUtilList != null) {
          i = j + this.jdField_b_of_type_JavaUtilList.size();
        }
        j = i;
        if (this.jdField_c_of_type_JavaUtilList != null) {
          j = i + this.jdField_c_of_type_JavaUtilList.size();
        }
        i = j;
        if (this.jdField_d_of_type_JavaUtilList != null) {
          i = j + this.jdField_d_of_type_JavaUtilList.size();
        }
        j = i;
        if (this.e != null) {
          j = i + this.e.size();
        }
        if (j == 0)
        {
          audr.c(2131692367);
        }
        else
        {
          bkzi localbkzi = (bkzi)bkzz.a(this, null);
          localbkzi.a(2131695830);
          localbkzi.a(getString(2131692213), 3);
          localbkzi.c(2131690697);
          localbkzi.a(new adpk(this, localbkzi));
          localbkzi.show();
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileActivity
 * JD-Core Version:    0.7.0.1
 */