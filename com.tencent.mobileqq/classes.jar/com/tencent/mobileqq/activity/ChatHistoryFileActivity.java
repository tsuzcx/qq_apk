package com.tencent.mobileqq.activity;

import Override;
import aedq;
import aeds;
import aedt;
import aedv;
import aedw;
import aedx;
import aedy;
import aedz;
import aeea;
import aeeb;
import aeec;
import aeed;
import aeee;
import aeef;
import aeeg;
import aeet;
import aeev;
import agej;
import aibo;
import aibq;
import aicv;
import aidw;
import ajby;
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
import anzj;
import asuo;
import atpa;
import atqx;
import atup;
import atur;
import atyt;
import aumg;
import aumw;
import auna;
import aunh;
import aunj;
import auxu;
import axps;
import axpw;
import axqb;
import bdll;
import becb;
import bhlq;
import bhmi;
import bhnv;
import bhpc;
import bjhk;
import blha;
import blir;
import blji;
import bnyz;
import bnzk;
import bnzt;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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
  implements aibq, Handler.Callback, View.OnClickListener
{
  int jdField_a_of_type_Int;
  aedq jdField_a_of_type_Aedq;
  aeeg jdField_a_of_type_Aeeg;
  aeet jdField_a_of_type_Aeet;
  public aeev a;
  private ajby jdField_a_of_type_Ajby;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout a;
  private atpa jdField_a_of_type_Atpa;
  bhpc jdField_a_of_type_Bhpc;
  ChatHistoryImageView jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
  String jdField_a_of_type_JavaLangString;
  public List<ChatMessage> a;
  public final MqqHandler a;
  public boolean a;
  private int jdField_b_of_type_Int;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private bhpc jdField_b_of_type_Bhpc;
  String jdField_b_of_type_JavaLangString;
  public List<FileManagerEntity> b;
  private boolean jdField_b_of_type_Boolean;
  ImageView c;
  public List<aidw> c;
  ImageView d;
  public List<TencentDocData> d;
  List<asuo> e;
  List<ChatMessage> f;
  
  public ChatHistoryFileActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Aeev = null;
    this.jdField_a_of_type_MqqOsMqqHandler = new blha(Looper.getMainLooper(), this, true);
  }
  
  private aeev a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
    case 3: 
      if (this.jdField_a_of_type_Aeeg == null)
      {
        this.jdField_a_of_type_Aeeg = new aeeg();
        this.jdField_a_of_type_Aeeg.a(getIntent(), this.app, this);
      }
      this.jdField_a_of_type_Aeeg.i_(paramInt);
      return this.jdField_a_of_type_Aeeg;
    case 0: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView = new ChatHistoryImageView();
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(getIntent(), this.app, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
    case 2: 
      if (this.jdField_a_of_type_Aeet == null)
      {
        this.jdField_a_of_type_Aeet = new aeet();
        this.jdField_a_of_type_Aeet.a(getIntent(), this.app, this);
      }
      return this.jdField_a_of_type_Aeet;
    }
    if (this.jdField_a_of_type_Aedq == null)
    {
      this.jdField_a_of_type_Aedq = new aedq();
      this.jdField_a_of_type_Aedq.a(getIntent(), this.app, this);
    }
    return this.jdField_a_of_type_Aedq;
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, aeef paramaeef)
  {
    if ((this.jdField_b_of_type_Bhpc != null) && (this.jdField_b_of_type_Bhpc.isShowing())) {
      this.jdField_b_of_type_Bhpc.dismiss();
    }
    bhpc localbhpc = new bhpc(this, 2131755824);
    localbhpc.setContentView(2131559008);
    this.jdField_b_of_type_Bhpc = localbhpc;
    this.jdField_b_of_type_Bhpc.setTitle(paramString1);
    this.jdField_b_of_type_Bhpc.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131690580);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131690912);
    }
    this.jdField_b_of_type_Bhpc.setNegativeButton(paramString1, new aeec(this, paramaeef));
    this.jdField_b_of_type_Bhpc.setPositiveButton(paramString2, new aeed(this, paramaeef));
    this.jdField_b_of_type_Bhpc.setCancelable(true);
    this.jdField_b_of_type_Bhpc.setCanceledOnTouchOutside(false);
    this.jdField_b_of_type_Bhpc.show();
  }
  
  private void a(List<ChatMessage> paramList)
  {
    if (paramList.size() == 1) {
      bnzk.b(this.app, this, getTitleBarHeight(), paramList, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    for (;;)
    {
      bdll.b(this.app, "dc00898", "", "", "0X8009DB9", "0X8009DB9", 0, 0, "", "", "", "");
      return;
      bnzk.a(this.app, this, getTitleBarHeight(), paramList, this.jdField_a_of_type_MqqOsMqqHandler);
    }
  }
  
  private void a(List<aidw> paramList, List<asuo> paramList1)
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
        paramList = (aidw)localIterator.next();
        localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a.a(paramList.a.f);
        if ((localChatMessage instanceof MessageForPic)) {
          paramList = axpw.a((MessageForPic)localChatMessage);
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
            paramList = axpw.b(this.app, paramList);
          } else {
            paramList = axpw.a(this.app, paramList);
          }
        }
        else
        {
          if ((localChatMessage instanceof MessageForFile))
          {
            if (AIOFilePicData.class.isInstance(paramList.a))
            {
              paramList = axpw.a(this.app, localChatMessage);
              paramList.jdField_a_of_type_Int = 4;
              continue;
            }
            if (AIOFileVideoData.class.isInstance(paramList.a))
            {
              paramList = axpw.a(this.app, localChatMessage);
              paramList.jdField_a_of_type_Int = 5;
            }
          }
          else if ((localChatMessage instanceof MessageForTroopFile))
          {
            if (AIOFilePicData.class.isInstance(paramList.a))
            {
              paramList = axpw.a(this.app, localChatMessage);
              paramList.jdField_a_of_type_Int = 6;
              continue;
            }
            if (AIOFileVideoData.class.isInstance(paramList.a))
            {
              paramList = axpw.a(this.app, localChatMessage);
              paramList.jdField_a_of_type_Int = 7;
              continue;
              if ((paramList1 != null) && (!paramList1.isEmpty()))
              {
                paramList = paramList1.iterator();
                while (paramList.hasNext())
                {
                  paramList1 = (asuo)paramList.next();
                  if ((paramList1.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) {
                    localArrayList.add(axpw.a((MessageForPic)paramList1.jdField_a_of_type_ComTencentMobileqqDataMessageRecord));
                  }
                }
              }
              paramList = new axps(this);
              paramList1 = (axqb)this.app.getManager(324);
              paramList1.a(new aedt(this, paramList, paramList1, localArrayList));
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367078));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365700));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377017));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365337));
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = getResources().getDrawable(2130839486);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
    localDrawable = getResources().getDrawable(2130839487);
    localStateListDrawable.addState(new int[] { 16842910 }, localDrawable);
    localDrawable = getResources().getDrawable(2130839486);
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
      this.jdField_a_of_type_Aeev.e();
      setRightButton(2131690580, this);
    }
    label57:
    do
    {
      return;
      bool = false;
      break;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.jdField_a_of_type_Aeev.f();
      setRightButton(2131689937, this);
      this.jdField_d_of_type_JavaUtilList = null;
      this.jdField_c_of_type_JavaUtilList = null;
      this.jdField_a_of_type_JavaUtilList = null;
      this.jdField_b_of_type_JavaUtilList = null;
      this.f = null;
    } while ((this.e == null) || (this.e.isEmpty()));
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((asuo)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
    this.e.clear();
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Aeev != null) {
      this.jdField_a_of_type_Aeev.a(paramLong);
    }
  }
  
  public void a(aidw paramaidw)
  {
    if (this.jdField_c_of_type_JavaUtilList == null) {
      this.jdField_c_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_c_of_type_JavaUtilList.add(paramaidw);
  }
  
  public void a(asuo paramasuo)
  {
    if (this.e == null) {
      this.e = new ArrayList();
    }
    this.e.add(paramasuo);
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
    if (this.jdField_a_of_type_Bhpc == null)
    {
      this.jdField_a_of_type_Bhpc = bhlq.a(this, 230);
      this.jdField_a_of_type_Bhpc.setNegativeButton(2131718195, new aedw(this));
    }
    if (!this.jdField_a_of_type_Bhpc.isShowing()) {
      this.jdField_a_of_type_Bhpc.setMessage(paramString);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bhpc.show();
        return;
      }
      catch (Throwable paramString) {}
      this.jdField_a_of_type_Bhpc.dismiss();
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
        auna.a(2131692232);
      }
      return bool;
    }
  }
  
  public boolean a(int paramInt, List<ChatMessage> paramList, List<FileManagerEntity> paramList1, List<aidw> paramList2, List<TencentDocData> paramList3)
  {
    int n = 0;
    int i1 = 0;
    boolean bool2;
    int k;
    int m;
    if (becb.a(paramList3))
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
              if ((((asuo)((Iterator)localObject1).next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForMarketFace))
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
              int i5 = aicv.a(((aidw)((Iterator)localObject1).next()).a);
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
              auna.c(2131692229);
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
              if (!bhnv.d(BaseApplication.getContext()))
              {
                QQToast.a(this, 2131694008, 1).b(getResources().getDimensionPixelSize(2131299011));
                return false;
              }
              if (i > 1)
              {
                a(getString(2131692223));
                return false;
              }
              if (k != 0)
              {
                a(getString(2131692204));
                return false;
              }
              if ((m != 0) && (paramList2.size() > 1))
              {
                a(getString(2131692225));
                return false;
              }
              if (paramList1 != null)
              {
                if ((paramList1.size() == 1) && (((FileManagerEntity)paramList1.get(0)).sendCloudUnsuccessful()))
                {
                  auna.a(2131692242);
                  return false;
                }
                localObject1 = paramList1.iterator();
                do
                {
                  if (!((Iterator)localObject1).hasNext()) {
                    break;
                  }
                } while (!aumg.a((FileManagerEntity)((Iterator)localObject1).next()).a(false));
              }
              break;
            }
            for (paramInt = 1;; paramInt = 0)
            {
              if (paramInt != 0) {
                aumw.a(this, 2131692326, 2131692331, new aedy(this, paramList1));
              }
              while ((paramList2 != null) && (paramList2.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null))
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.i();
                return false;
                aunj.a(paramList1, this);
              }
              paramList1 = new ArrayList();
              if (paramList != null) {
                paramList1.addAll(paramList);
              }
              if (bool2)
              {
                paramList1.addAll(becb.a(paramList3, this.jdField_a_of_type_JavaLangString, null));
                aunh.a("0X8009AA1");
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
                  auxu.a(this, paramList2, 3);
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
                  paramList.add((ChatMessage)((asuo)paramList1.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
                }
              }
              this.jdField_b_of_type_Boolean = bool1;
              this.jdField_a_of_type_Ajby.a(paramList);
              break;
              if (((n != 0) || (m != 0)) && (i3 != 0))
              {
                a(getString(2131692221));
                return false;
              }
              if ((i4 != 0) || (bool2) || (bool1))
              {
                a(getString(2131692222));
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
                  auna.a(2131692241);
                  return false;
                }
                paramList = paramList1.iterator();
                if (paramList.hasNext())
                {
                  paramList3 = (FileManagerEntity)paramList.next();
                  if (!aumg.a(paramList3).a(true)) {
                    break label2085;
                  }
                  l = paramList3.fileSize + l;
                }
              }
              for (;;)
              {
                break label1164;
                paramList = this.app.a();
                if ((aunj.a()) && (l > atyt.a())) {
                  aunj.a(false, this, new aedz(this, paramList1, paramList));
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
                paramList = this.app.a();
                if ((paramList1.size() == 1) && (((FileManagerEntity)paramList1.get(0)).sendCloudUnsuccessful()))
                {
                  auna.a(2131692243);
                  return false;
                }
                paramList2 = paramList1.iterator();
                do
                {
                  if (!paramList2.hasNext()) {
                    break;
                  }
                } while (!aumg.a((FileManagerEntity)paramList2.next()).a(false));
                for (paramInt = 1;; paramInt = 0)
                {
                  if (paramInt != 0)
                  {
                    if (!bjhk.a(this, 5, new aeea(this, paramList1, paramList))) {
                      break;
                    }
                    aumw.a(this, 2131692326, 2131692329, new aeeb(this, paramList1, paramList));
                    break;
                  }
                  paramList1 = paramList1.iterator();
                  paramInt = 0;
                  while (paramList1.hasNext())
                  {
                    paramList2 = (FileManagerEntity)paramList1.next();
                    if (!paramList2.sendCloudUnsuccessful()) {
                      if (bhmi.b(paramList2.getFilePath()))
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
                    auna.d(getString(2131692445));
                    break;
                  }
                  auna.a(2131692243);
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
                      localObject2 = this.app.a().b(((FileManagerEntity)localObject2).peerUin, ((FileManagerEntity)localObject2).peerType, ((FileManagerEntity)localObject2).uniseq);
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
                        localObject2 = this.app.a().a(((ChatMessage)localObject2).uniseq, ((ChatMessage)localObject2).frienduin, ((ChatMessage)localObject2).istroop);
                        if (localObject2 != null) {
                          this.app.a().b(((FileManagerEntity)localObject2).nSessionId);
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
                      ((List)localObject1).add((ChatMessage)((asuo)paramList.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
                    }
                  }
                  if (((((List)localObject1).size() == 0) && (paramList1 == null) && (!bool2)) || ((((List)localObject1).size() <= 0) && (!becb.a(paramList1)) && (!bool2))) {
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
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(getActivity(), 2131755824);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559572);
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372578);
    localTextView.setText(localTextView.getResources().getString(2131689883));
    if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b(aidw paramaidw)
  {
    if (this.jdField_c_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_c_of_type_JavaUtilList.remove(paramaidw);
  }
  
  public void b(asuo paramasuo)
  {
    if (this.e == null) {
      return;
    }
    this.e.remove(paramasuo);
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
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
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
      localIntent = agej.a(localIntent, null);
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
          this.jdField_a_of_type_Ajby.a(paramIntent);
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
    setContentView(2131558821);
    setTitle(2131690641);
    if (((Intent)localObject).getStringExtra("leftViewText") == null) {
      setLeftViewName(2131690728);
    }
    for (;;)
    {
      paramBundle = (TabBarView)findViewById(2131378372);
      paramBundle.a(0, anzj.a(2131700556));
      paramBundle.a(1, anzj.a(2131700576));
      paramBundle.a(2, anzj.a(2131700566));
      paramBundle.a(3, anzj.a(2131700504));
      paramBundle.a(4, anzj.a(2131700575));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377294));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131379139));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      setRightButton(2131689937, this);
      c();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370561));
      paramBundle.setOnTabChangeListener(new aeds(this));
      localObject = ((Intent)localObject).getStringExtra("com.tencent.mobileqq.ChatHistoryFileActivity.initial_tab");
      try
      {
        i = Integer.parseInt((String)localObject);
        paramBundle.setSelectedTab(i, true);
        this.jdField_a_of_type_Ajby = new ajby(this, 3);
        this.jdField_a_of_type_Ajby.a();
        aibo.a().a(this);
        if (this.jdField_a_of_type_Atpa == null) {
          this.jdField_a_of_type_Atpa = new aeee(this, null);
        }
        this.app.a().addObserver(this.jdField_a_of_type_Atpa);
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
    this.jdField_a_of_type_Ajby.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.d();
    }
    if (this.jdField_a_of_type_Aedq != null) {
      this.jdField_a_of_type_Aedq.d();
    }
    if (this.jdField_a_of_type_Atpa != null) {
      this.app.a().deleteObserver(this.jdField_a_of_type_Atpa);
    }
    aibo.a().b(this);
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
    if (this.jdField_a_of_type_Aeev != null) {
      this.jdField_a_of_type_Aeev.c();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Aeev != null)
    {
      this.jdField_a_of_type_Aeev.i_(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Aeev.b();
    }
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299011);
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
        if (this.jdField_a_of_type_Aeet != null) {
          this.jdField_a_of_type_Aeet.a(this.jdField_a_of_type_JavaUtilList);
        }
        if (this.jdField_a_of_type_Aedq != null) {
          this.jdField_a_of_type_Aedq.g();
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
      bnzt.a(this.app, this, getTitleBarHeight());
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      i = paramMessage.arg1;
    } while (!bnyz.a(i));
    if (bnyz.d(i))
    {
      getString(2131694171);
      paramMessage = "";
      if (bnyz.b(i))
      {
        getString(2131694171);
        paramMessage = getString(2131691885);
      }
      for (;;)
      {
        aedv localaedv = new aedv(this);
        a(getString(2131697944), paramMessage, null, null, localaedv);
        return true;
        if (bnyz.c(i))
        {
          getString(2131694171);
          paramMessage = getString(2131691883);
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
      overridePendingTransition(0, 2130772340);
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
        bdll.b(this.app, "dc00898", "", "", "0X8007125", "0X8007125", 0, 0, "", "", "", "");
        continue;
        if (a(0, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList)) {
          a();
        }
        bdll.b(this.app, "dc00898", "", "", "0X8007129", "0X8007129", 0, 0, "", "", "", "");
        continue;
        if (a(1, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList)) {
          a();
        }
        bdll.b(this.app, "dc00898", "", "", "0X800712A", "0X800712A", 0, 0, "", "", "", "");
        continue;
        if (a(2, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList)) {
          a();
        }
        bdll.b(this.app, "dc00898", "", "", "0X800712B", "0X800712B", 0, 0, "", "", "", "");
        continue;
        bdll.b(this.app, "dc00898", "", "", "0X800712C", "0X800712C", 0, 0, "", "", "", "");
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
          auna.c(2131692229);
        }
        else
        {
          blir localblir = (blir)blji.a(this, null);
          localblir.a(2131695439);
          localblir.a(getString(2131692075), 3);
          localblir.c(2131690580);
          localblir.a(new aedx(this, localblir));
          localblir.show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileActivity
 * JD-Core Version:    0.7.0.1
 */