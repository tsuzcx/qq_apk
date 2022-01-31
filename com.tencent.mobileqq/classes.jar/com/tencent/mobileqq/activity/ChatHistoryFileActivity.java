package com.tencent.mobileqq.activity;

import acip;
import acir;
import acis;
import aciu;
import aciv;
import aciw;
import acix;
import aciy;
import aciz;
import acja;
import acjb;
import acjc;
import acjd;
import acje;
import acjf;
import acjs;
import acju;
import aekt;
import agdf;
import agdh;
import agem;
import agfq;
import agzn;
import alpo;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import apwd;
import aqnl;
import aqns;
import aqsc;
import aqse;
import aqxg;
import armf;
import armv;
import armz;
import arng;
import arni;
import arum;
import aulk;
import aulo;
import ault;
import azmj;
import badt;
import bdcd;
import bdcs;
import bdee;
import bdfq;
import bevd;
import bhoe;
import bhpy;
import bhql;
import bkev;
import bkfg;
import bkfr;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryFileActivity
  extends IphoneTitleBarActivity
  implements agdh, Handler.Callback, View.OnClickListener
{
  int jdField_a_of_type_Int;
  acip jdField_a_of_type_Acip;
  acjf jdField_a_of_type_Acjf;
  acjs jdField_a_of_type_Acjs;
  public acju a;
  private agzn jdField_a_of_type_Agzn;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout a;
  private aqnl jdField_a_of_type_Aqnl;
  bdfq jdField_a_of_type_Bdfq;
  ChatHistoryImageView jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
  String jdField_a_of_type_JavaLangString;
  public List<ChatMessage> a;
  public final MqqHandler a;
  public boolean a;
  private int jdField_b_of_type_Int;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private bdfq jdField_b_of_type_Bdfq;
  String jdField_b_of_type_JavaLangString;
  public List<FileManagerEntity> b;
  ImageView c;
  public List<agfq> c;
  ImageView d;
  public List<TencentDocData> d;
  List<apwd> e;
  List<ChatMessage> f;
  
  public ChatHistoryFileActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Acju = null;
    this.jdField_a_of_type_MqqOsMqqHandler = new bhoe(Looper.getMainLooper(), this, true);
  }
  
  private acju a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
    case 3: 
      if (this.jdField_a_of_type_Acjf == null)
      {
        this.jdField_a_of_type_Acjf = new acjf();
        this.jdField_a_of_type_Acjf.a(getIntent(), this.app, this);
      }
      this.jdField_a_of_type_Acjf.a(paramInt);
      return this.jdField_a_of_type_Acjf;
    case 0: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView = new ChatHistoryImageView();
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(getIntent(), this.app, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
    case 2: 
      if (this.jdField_a_of_type_Acjs == null)
      {
        this.jdField_a_of_type_Acjs = new acjs();
        this.jdField_a_of_type_Acjs.a(getIntent(), this.app, this);
      }
      return this.jdField_a_of_type_Acjs;
    }
    if (this.jdField_a_of_type_Acip == null)
    {
      this.jdField_a_of_type_Acip = new acip();
      this.jdField_a_of_type_Acip.a(getIntent(), this.app, this);
    }
    return this.jdField_a_of_type_Acip;
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, acje paramacje)
  {
    if ((this.jdField_b_of_type_Bdfq != null) && (this.jdField_b_of_type_Bdfq.isShowing())) {
      this.jdField_b_of_type_Bdfq.dismiss();
    }
    bdfq localbdfq = new bdfq(this, 2131755801);
    localbdfq.setContentView(2131558943);
    this.jdField_b_of_type_Bdfq = localbdfq;
    this.jdField_b_of_type_Bdfq.setTitle(paramString1);
    this.jdField_b_of_type_Bdfq.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131690648);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131691088);
    }
    this.jdField_b_of_type_Bdfq.setNegativeButton(paramString1, new acjb(this, paramacje));
    this.jdField_b_of_type_Bdfq.setPositiveButton(paramString2, new acjc(this, paramacje));
    this.jdField_b_of_type_Bdfq.setCancelable(true);
    this.jdField_b_of_type_Bdfq.setCanceledOnTouchOutside(false);
    this.jdField_b_of_type_Bdfq.show();
  }
  
  private void a(List<ChatMessage> paramList)
  {
    if (paramList.size() == 1) {
      bkfg.b(this.app, this, getTitleBarHeight(), paramList, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    for (;;)
    {
      azmj.b(this.app, "dc00898", "", "", "0X8009DB9", "0X8009DB9", 0, 0, "", "", "", "");
      return;
      bkfg.a(this.app, this, getTitleBarHeight(), paramList, this.jdField_a_of_type_MqqOsMqqHandler);
    }
  }
  
  private void a(List<agfq> paramList, List<apwd> paramList1)
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
        paramList = (agfq)localIterator.next();
        localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a.a(paramList.a.f);
        if ((localChatMessage instanceof MessageForPic)) {
          paramList = aulo.a((MessageForPic)localChatMessage);
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
            paramList = aulo.b(this.app, paramList);
          } else {
            paramList = aulo.a(this.app, paramList);
          }
        }
        else
        {
          if ((localChatMessage instanceof MessageForFile))
          {
            if (AIOFilePicData.class.isInstance(paramList.a))
            {
              paramList = aulo.a(this.app, localChatMessage);
              paramList.jdField_a_of_type_Int = 4;
              continue;
            }
            if (AIOFileVideoData.class.isInstance(paramList.a))
            {
              paramList = aulo.a(this.app, localChatMessage);
              paramList.jdField_a_of_type_Int = 5;
            }
          }
          else if ((localChatMessage instanceof MessageForTroopFile))
          {
            if (AIOFilePicData.class.isInstance(paramList.a))
            {
              paramList = aulo.a(this.app, localChatMessage);
              paramList.jdField_a_of_type_Int = 6;
              continue;
            }
            if (AIOFileVideoData.class.isInstance(paramList.a))
            {
              paramList = aulo.a(this.app, localChatMessage);
              paramList.jdField_a_of_type_Int = 7;
              continue;
              if ((paramList1 != null) && (!paramList1.isEmpty()))
              {
                paramList = paramList1.iterator();
                while (paramList.hasNext())
                {
                  paramList1 = (apwd)paramList.next();
                  if ((paramList1.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) {
                    localArrayList.add(aulo.a((MessageForPic)paramList1.jdField_a_of_type_ComTencentMobileqqDataMessageRecord));
                  }
                }
              }
              paramList = new aulk(this);
              paramList1 = (ault)this.app.getManager(324);
              paramList1.a(new acis(this, paramList, paramList1, localArrayList));
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366750));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365420));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376065));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365054));
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = getResources().getDrawable(2130839297);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
    localDrawable = getResources().getDrawable(2130839298);
    localStateListDrawable.addState(new int[] { 16842910 }, localDrawable);
    localDrawable = getResources().getDrawable(2130839297);
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
      this.jdField_a_of_type_Acju.e();
      setRightButton(2131690648, this);
    }
    label57:
    do
    {
      return;
      bool = false;
      break;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.jdField_a_of_type_Acju.f();
      setRightButton(2131690047, this);
      this.jdField_d_of_type_JavaUtilList = null;
      this.jdField_c_of_type_JavaUtilList = null;
      this.jdField_a_of_type_JavaUtilList = null;
      this.jdField_b_of_type_JavaUtilList = null;
      this.f = null;
    } while ((this.e == null) || (this.e.isEmpty()));
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((apwd)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
    this.e.clear();
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Acju != null) {
      this.jdField_a_of_type_Acju.a(paramLong);
    }
  }
  
  public void a(agfq paramagfq)
  {
    if (this.jdField_c_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_c_of_type_JavaUtilList.remove(paramagfq);
  }
  
  public void a(apwd paramapwd)
  {
    if (this.e == null) {
      this.e = new ArrayList();
    }
    this.e.add(paramapwd);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryStruct", 2, "addselect, size: " + this.jdField_a_of_type_JavaUtilList.size());
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
    if (this.jdField_a_of_type_Bdfq == null)
    {
      this.jdField_a_of_type_Bdfq = bdcd.a(this, 230);
      this.jdField_a_of_type_Bdfq.setNegativeButton(2131720083, new aciv(this));
    }
    if (!this.jdField_a_of_type_Bdfq.isShowing()) {
      this.jdField_a_of_type_Bdfq.setMessage(paramString);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bdfq.show();
        return;
      }
      catch (Throwable paramString) {}
      this.jdField_a_of_type_Bdfq.dismiss();
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
        armz.a(2131692639);
      }
      return bool;
    }
  }
  
  public boolean a(int paramInt, List<ChatMessage> paramList, List<FileManagerEntity> paramList1, List<agfq> paramList2, List<TencentDocData> paramList3)
  {
    int n = 0;
    int i1 = 0;
    boolean bool;
    int k;
    int m;
    if (badt.a(paramList3))
    {
      bool = true;
      k = 0;
      m = 0;
      if ((paramList1 == null) || (paramList1.size() <= 0)) {
        break label2168;
      }
      m = 1;
      k = 0 + paramList1.size();
    }
    label187:
    label242:
    label2168:
    for (int i3 = 1;; i3 = 0)
    {
      int i = m;
      int j = k;
      if (bool)
      {
        i = m + 1;
        j = k + paramList3.size();
      }
      int i4;
      if ((paramList != null) && (paramList.size() > 0))
      {
        k = paramList.size();
        i4 = 1;
        k = j + k;
      }
      for (j = i + 1;; j = i)
      {
        Object localObject1;
        int i5;
        if ((this.e != null) && (!this.e.isEmpty())) {
          if (paramInt == 1)
          {
            localObject1 = this.e.iterator();
            while (((Iterator)localObject1).hasNext()) {
              if ((((apwd)((Iterator)localObject1).next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForMarketFace))
              {
                i = 1;
                k += this.e.size();
                j += 1;
                i5 = i;
                i = j;
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
              int i6 = agem.a(((agfq)((Iterator)localObject1).next()).a);
              if ((n == 0) && (i6 == 1))
              {
                n = 1;
                j += 1;
                i2 = j;
                i1 = m;
                if (m == 0)
                {
                  i2 = j;
                  i1 = m;
                  if (i6 == 2)
                  {
                    i1 = 1;
                    i2 = j + 1;
                  }
                }
                if ((i == 0) && (i6 == 3))
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
              armz.c(2131692636);
              return false;
              bool = false;
              break;
              i = 1;
              break label187;
              m = j;
              j = i;
              i = m;
              m = i1;
              break label242;
            }
            switch (paramInt)
            {
            default: 
              return true;
            case 0: 
              if (!bdee.d(BaseApplication.getContext()))
              {
                QQToast.a(this, 2131694829, 1).b(getResources().getDimensionPixelSize(2131298914));
                return false;
              }
              if (i > 1)
              {
                a(getString(2131692630));
                return false;
              }
              if (k != 0)
              {
                a(getString(2131692611));
                return false;
              }
              if ((m != 0) && (paramList2.size() > 1))
              {
                a(getString(2131692632));
                return false;
              }
              if (paramList1 != null)
              {
                if ((paramList1.size() == 1) && (((FileManagerEntity)paramList1.get(0)).sendCloudUnsuccessful()))
                {
                  armz.a(2131692649);
                  return false;
                }
                localObject1 = paramList1.iterator();
                do
                {
                  if (!((Iterator)localObject1).hasNext()) {
                    break;
                  }
                } while (!armf.a((FileManagerEntity)((Iterator)localObject1).next()).a(false));
              }
              break;
            }
            for (paramInt = 1;; paramInt = 0)
            {
              if (paramInt != 0) {
                armv.a(this, 2131692752, 2131692757, new acix(this, paramList1));
              }
              while ((paramList2 != null) && (paramList2.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null))
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.h();
                return false;
                arni.a(paramList1, this);
              }
              paramList1 = new ArrayList();
              if (paramList != null) {
                paramList1.addAll(paramList);
              }
              if (bool)
              {
                paramList1.addAll(badt.a(paramList3, this.jdField_a_of_type_JavaLangString, null));
                arng.a("0X8009AA1");
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
                  arum.a(this, paramList2, 3);
                }
              }
              if (((paramList1 == null) || (paramList1.size() <= 1)) && (i5 == 0)) {
                break;
              }
              paramList = new ArrayList();
              if (paramList1 != null) {
                paramList.addAll(paramList1);
              }
              if (i5 != 0)
              {
                paramList1 = this.e.iterator();
                while (paramList1.hasNext()) {
                  paramList.add((ChatMessage)((apwd)paramList1.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
                }
              }
              this.jdField_a_of_type_Agzn.a(paramList);
              break;
              if (((n != 0) || (m != 0)) && (i3 != 0))
              {
                a(getString(2131692628));
                return false;
              }
              if ((i4 != 0) || (bool) || (i5 != 0))
              {
                a(getString(2131692629));
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
                  armz.a(2131692648);
                  return false;
                }
                paramList = paramList1.iterator();
                if (paramList.hasNext())
                {
                  paramList3 = (FileManagerEntity)paramList.next();
                  if (!armf.a(paramList3).a(true)) {
                    break label2087;
                  }
                  l = paramList3.fileSize + l;
                }
              }
              for (;;)
              {
                break label1166;
                paramList = this.app.a();
                if ((arni.a()) && (l > aqxg.a())) {
                  arni.a(false, this, new aciy(this, paramList1, paramList));
                }
                while (((paramList2 != null) && (paramList2.size() > 0)) || ((i5 == 0) && (this.e != null) && (!this.e.isEmpty())))
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
                  armz.a(2131692650);
                  return false;
                }
                paramList2 = paramList1.iterator();
                do
                {
                  if (!paramList2.hasNext()) {
                    break;
                  }
                } while (!armf.a((FileManagerEntity)paramList2.next()).a(false));
                for (paramInt = 1;; paramInt = 0)
                {
                  if (paramInt != 0)
                  {
                    if (!bevd.a(this, 5, new aciz(this, paramList1, paramList))) {
                      break;
                    }
                    armv.a(this, 2131692752, 2131692755, new acja(this, paramList1, paramList));
                    break;
                  }
                  paramList1 = paramList1.iterator();
                  paramInt = 0;
                  while (paramList1.hasNext())
                  {
                    paramList2 = (FileManagerEntity)paramList1.next();
                    if (!paramList2.sendCloudUnsuccessful()) {
                      if (bdcs.b(paramList2.getFilePath()))
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
                    armz.d(getString(2131692912));
                    break;
                  }
                  armz.a(2131692650);
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
                      ((List)localObject1).add((ChatMessage)((apwd)paramList.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
                    }
                  }
                  if (((((List)localObject1).size() == 0) && (paramList1 == null) && (!bool)) || ((((List)localObject1).size() <= 0) && (!badt.a(paramList1)) && (!bool))) {
                    break;
                  }
                  ThreadManager.post(new ChatHistoryFileActivity.7(this, (List)localObject1, paramList1, bool, paramList3), 8, null, true);
                  break;
                }
              }
            }
            j = i;
            i = i2;
            break label346;
            break label290;
            i1 = i;
            i = j;
            j = i1;
            break label361;
            j = k;
            m = 0;
            k = i1;
          }
          i = 0;
          break label187;
          i = j;
          i5 = 0;
        }
        i4 = 0;
        k = j;
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
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(getActivity(), 2131755801);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559438);
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371874);
    localTextView.setText(localTextView.getResources().getString(2131689979));
    if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b(apwd paramapwd)
  {
    if (this.e == null) {
      return;
    }
    this.e.remove(paramapwd);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList.remove(paramChatMessage);
    } while (!QLog.isColorLevel());
    QLog.d("ChatHistoryStruct", 2, "removeselect, size: " + this.jdField_a_of_type_JavaUtilList.size());
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
    if (this.f == null) {}
    do
    {
      return;
      this.f.remove(paramChatMessage);
    } while (!QLog.isColorLevel());
    QLog.d("ChatHistoryStruct", 2, "removeweiyunselect, size: " + this.f.size());
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
      localIntent = aekt.a(localIntent, null);
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
        this.jdField_a_of_type_Agzn.a(paramIntent);
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
    setContentView(2131558758);
    setTitle(2131690763);
    if (((Intent)localObject).getStringExtra("leftViewText") == null) {
      setLeftViewName(2131690884);
    }
    for (;;)
    {
      paramBundle = (TabBarView)findViewById(2131377336);
      paramBundle.a(0, alpo.a(2131702017));
      paramBundle.a(1, alpo.a(2131702037));
      paramBundle.a(2, alpo.a(2131702027));
      paramBundle.a(3, alpo.a(2131701965));
      paramBundle.a(4, alpo.a(2131702036));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376311));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131378076));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      setRightButton(2131690047, this);
      c();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369998));
      paramBundle.setOnTabChangeListener(new acir(this));
      localObject = ((Intent)localObject).getStringExtra("com.tencent.mobileqq.ChatHistoryFileActivity.initial_tab");
      try
      {
        i = Integer.parseInt((String)localObject);
        paramBundle.setSelectedTab(i, true);
        this.jdField_a_of_type_Agzn = new agzn(this, 3);
        this.jdField_a_of_type_Agzn.a();
        agdf.a().a(this);
        if (this.jdField_a_of_type_Aqnl == null) {
          this.jdField_a_of_type_Aqnl = new acjd(this, null);
        }
        this.app.a().addObserver(this.jdField_a_of_type_Aqnl);
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
    this.jdField_a_of_type_Agzn.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.d();
    }
    if (this.jdField_a_of_type_Acip != null) {
      this.jdField_a_of_type_Acip.d();
    }
    if (this.jdField_a_of_type_Aqnl != null) {
      this.app.a().deleteObserver(this.jdField_a_of_type_Aqnl);
    }
    agdf.a().b(this);
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
    if (this.jdField_a_of_type_Acju != null) {
      this.jdField_a_of_type_Acju.c();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Acju != null)
    {
      this.jdField_a_of_type_Acju.a(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Acju.b();
    }
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131298914);
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
        if (this.jdField_a_of_type_Acjs != null) {
          this.jdField_a_of_type_Acjs.a(this.jdField_a_of_type_JavaUtilList);
        }
        if (this.jdField_a_of_type_Acip != null) {
          this.jdField_a_of_type_Acip.g();
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
      bkfr.a(this.app, this, getTitleBarHeight());
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      i = paramMessage.arg1;
    } while (!bkev.a(i));
    if (bkev.d(i))
    {
      getString(2131695079);
      paramMessage = "";
      if (bkev.b(i))
      {
        getString(2131695079);
        paramMessage = getString(2131692266);
      }
      for (;;)
      {
        aciu localaciu = new aciu(this);
        a(getString(2131699049), paramMessage, null, null, localaciu);
        return true;
        if (bkev.c(i))
        {
          getString(2131695079);
          paramMessage = getString(2131692264);
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
      overridePendingTransition(0, 2130772328);
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    int j = 0;
    switch (paramView.getId())
    {
    default: 
    case 2131368644: 
      do
      {
        return;
        a();
      } while (!this.jdField_a_of_type_Boolean);
      azmj.b(this.app, "dc00898", "", "", "0X8007125", "0X8007125", 0, 0, "", "", "", "");
      return;
    case 2131366750: 
      if (a(0, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList)) {
        a();
      }
      azmj.b(this.app, "dc00898", "", "", "0X8007129", "0X8007129", 0, 0, "", "", "", "");
      return;
    case 2131365420: 
      if (a(1, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList)) {
        a();
      }
      azmj.b(this.app, "dc00898", "", "", "0X800712A", "0X800712A", 0, 0, "", "", "", "");
      return;
    case 2131376065: 
      if (a(2, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList)) {
        a();
      }
      azmj.b(this.app, "dc00898", "", "", "0X800712B", "0X800712B", 0, 0, "", "", "", "");
      return;
    }
    azmj.b(this.app, "dc00898", "", "", "0X800712C", "0X800712C", 0, 0, "", "", "", "");
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
      armz.c(2131692636);
      return;
    }
    paramView = (bhpy)bhql.a(this, null);
    paramView.a(2131696568);
    paramView.a(getString(2131692485), 3);
    paramView.c(2131690648);
    paramView.a(new aciw(this, paramView));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileActivity
 * JD-Core Version:    0.7.0.1
 */