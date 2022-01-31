package com.tencent.mobileqq.activity;

import aaid;
import aaif;
import aaig;
import aaii;
import aaij;
import aaik;
import aail;
import aaim;
import aain;
import aaio;
import aaip;
import aaiq;
import aair;
import aais;
import aait;
import aajg;
import aaji;
import aciy;
import advs;
import advu;
import adwz;
import adyb;
import aero;
import ajjy;
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
import annl;
import aodp;
import aodw;
import aoig;
import aoii;
import aonj;
import apbf;
import apbx;
import apcb;
import apci;
import apck;
import aphp;
import aryh;
import aryl;
import aryq;
import awqx;
import axfs;
import babr;
import bace;
import badq;
import bafb;
import bbmy;
import bbrm;
import beez;
import begr;
import behe;
import bgtg;
import bgtr;
import bguc;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryFileActivity
  extends IphoneTitleBarActivity
  implements advu, Handler.Callback, View.OnClickListener
{
  int jdField_a_of_type_Int;
  aaid jdField_a_of_type_Aaid;
  aait jdField_a_of_type_Aait;
  aajg jdField_a_of_type_Aajg;
  public aaji a;
  private aero jdField_a_of_type_Aero;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout a;
  private aodp jdField_a_of_type_Aodp;
  bafb jdField_a_of_type_Bafb;
  ChatHistoryImageView jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
  String jdField_a_of_type_JavaLangString;
  public List<ChatMessage> a;
  public final MqqHandler a;
  public boolean a;
  private int jdField_b_of_type_Int;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private bafb jdField_b_of_type_Bafb;
  String jdField_b_of_type_JavaLangString;
  public List<FileManagerEntity> b;
  ImageView c;
  public List<adyb> c;
  ImageView d;
  public List<TencentDocData> d;
  List<annl> e;
  List<ChatMessage> f;
  
  public ChatHistoryFileActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Aaji = null;
    this.jdField_a_of_type_MqqOsMqqHandler = new beez(Looper.getMainLooper(), this, true);
  }
  
  private aaji a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
    case 3: 
      if (this.jdField_a_of_type_Aait == null)
      {
        this.jdField_a_of_type_Aait = new aait();
        this.jdField_a_of_type_Aait.a(getIntent(), this.app, this);
      }
      this.jdField_a_of_type_Aait.h_(paramInt);
      return this.jdField_a_of_type_Aait;
    case 0: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView = new ChatHistoryImageView();
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(getIntent(), this.app, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
    case 2: 
      if (this.jdField_a_of_type_Aajg == null)
      {
        this.jdField_a_of_type_Aajg = new aajg();
        this.jdField_a_of_type_Aajg.a(getIntent(), this.app, this);
      }
      return this.jdField_a_of_type_Aajg;
    }
    if (this.jdField_a_of_type_Aaid == null)
    {
      this.jdField_a_of_type_Aaid = new aaid();
      this.jdField_a_of_type_Aaid.a(getIntent(), this.app, this);
    }
    return this.jdField_a_of_type_Aaid;
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, aais paramaais)
  {
    if ((this.jdField_b_of_type_Bafb != null) && (this.jdField_b_of_type_Bafb.isShowing())) {
      this.jdField_b_of_type_Bafb.dismiss();
    }
    bafb localbafb = new bafb(this, 2131690181);
    localbafb.setContentView(2131493345);
    this.jdField_b_of_type_Bafb = localbafb;
    this.jdField_b_of_type_Bafb.setTitle(paramString1);
    this.jdField_b_of_type_Bafb.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131625035);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131625463);
    }
    this.jdField_b_of_type_Bafb.setNegativeButton(paramString1, new aaip(this, paramaais));
    this.jdField_b_of_type_Bafb.setPositiveButton(paramString2, new aaiq(this, paramaais));
    this.jdField_b_of_type_Bafb.setCancelable(true);
    this.jdField_b_of_type_Bafb.setCanceledOnTouchOutside(false);
    this.jdField_b_of_type_Bafb.show();
  }
  
  private void a(List<ChatMessage> paramList)
  {
    if (paramList.size() == 1) {
      bgtr.b(this.app, this, getTitleBarHeight(), paramList, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    for (;;)
    {
      awqx.b(this.app, "dc00898", "", "", "0X8009DB9", "0X8009DB9", 0, 0, "", "", "", "");
      return;
      bgtr.a(this.app, this, getTitleBarHeight(), paramList, this.jdField_a_of_type_MqqOsMqqHandler);
    }
  }
  
  private void a(List<adyb> paramList, List<annl> paramList1)
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
        paramList = (adyb)localIterator.next();
        localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a.a(paramList.a.f);
        if ((localChatMessage instanceof MessageForPic)) {
          paramList = aryl.a((MessageForPic)localChatMessage);
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
            paramList = aryl.b(this.app, paramList);
          } else {
            paramList = aryl.a(this.app, paramList);
          }
        }
        else
        {
          if ((localChatMessage instanceof MessageForFile))
          {
            if (AIOFilePicData.class.isInstance(paramList.a))
            {
              paramList = aryl.a(this.app, localChatMessage);
              paramList.jdField_a_of_type_Int = 4;
              continue;
            }
            if (AIOFileVideoData.class.isInstance(paramList.a))
            {
              paramList = aryl.a(this.app, localChatMessage);
              paramList.jdField_a_of_type_Int = 5;
            }
          }
          else if ((localChatMessage instanceof MessageForTroopFile))
          {
            if (AIOFilePicData.class.isInstance(paramList.a))
            {
              paramList = aryl.a(this.app, localChatMessage);
              paramList.jdField_a_of_type_Int = 6;
              continue;
            }
            if (AIOFileVideoData.class.isInstance(paramList.a))
            {
              paramList = aryl.a(this.app, localChatMessage);
              paramList.jdField_a_of_type_Int = 7;
              continue;
              if ((paramList1 != null) && (!paramList1.isEmpty()))
              {
                paramList = paramList1.iterator();
                while (paramList.hasNext())
                {
                  paramList1 = (annl)paramList.next();
                  if ((paramList1.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)) {
                    localArrayList.add(aryl.a((MessageForPic)paramList1.jdField_a_of_type_ComTencentMobileqqDataMessageRecord));
                  }
                }
              }
              paramList = new aryh(this);
              paramList1 = (aryq)this.app.getManager(324);
              paramList1.a(new aaig(this, paramList, paramList1, localArrayList));
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301021));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299769));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131309814));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299402));
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = getResources().getDrawable(2130839183);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
    localDrawable = getResources().getDrawable(2130839184);
    localStateListDrawable.addState(new int[] { 16842910 }, localDrawable);
    localDrawable = getResources().getDrawable(2130839183);
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
      this.jdField_a_of_type_Aaji.d();
      setRightButton(2131625035, this);
    }
    label57:
    do
    {
      return;
      bool = false;
      break;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.jdField_a_of_type_Aaji.e();
      setRightButton(2131624448, this);
      this.jdField_d_of_type_JavaUtilList = null;
      this.jdField_c_of_type_JavaUtilList = null;
      this.jdField_a_of_type_JavaUtilList = null;
      this.jdField_b_of_type_JavaUtilList = null;
      this.f = null;
    } while ((this.e == null) || (this.e.isEmpty()));
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      ((annl)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
    this.e.clear();
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Aaji != null) {
      this.jdField_a_of_type_Aaji.a(paramLong);
    }
  }
  
  public void a(adyb paramadyb)
  {
    if (this.jdField_c_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_c_of_type_JavaUtilList.remove(paramadyb);
  }
  
  public void a(annl paramannl)
  {
    if (this.e == null) {
      this.e = new ArrayList();
    }
    this.e.add(paramannl);
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
    if (this.jdField_a_of_type_Bafb == null)
    {
      this.jdField_a_of_type_Bafb = babr.a(this, 230);
      this.jdField_a_of_type_Bafb.setNegativeButton(2131653656, new aaij(this));
    }
    if (!this.jdField_a_of_type_Bafb.isShowing()) {
      this.jdField_a_of_type_Bafb.setMessage(paramString);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bafb.show();
        return;
      }
      catch (Throwable paramString) {}
      this.jdField_a_of_type_Bafb.dismiss();
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
        apcb.a(2131626944);
      }
      return bool;
    }
  }
  
  public boolean a(int paramInt, List<ChatMessage> paramList, List<FileManagerEntity> paramList1, List<adyb> paramList2, List<TencentDocData> paramList3)
  {
    int n = 0;
    int i1 = 0;
    boolean bool;
    int k;
    int m;
    if (axfs.a(paramList3))
    {
      bool = true;
      k = 0;
      m = 0;
      if ((paramList1 == null) || (paramList1.size() <= 0)) {
        break label2154;
      }
      m = 1;
      k = 0 + paramList1.size();
    }
    label187:
    label346:
    label361:
    label2154:
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
              if ((((annl)((Iterator)localObject1).next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForMarketFace))
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
          label242:
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
              int i6 = adwz.a(((adyb)((Iterator)localObject1).next()).a);
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
              apcb.c(2131626941);
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
              if (!badq.d(BaseApplication.getContext()))
              {
                bbmy.a(this, 2131629008, 1).b(getResources().getDimensionPixelSize(2131167766));
                return false;
              }
              if (i > 1)
              {
                a(getString(2131626935));
                return false;
              }
              if (k != 0)
              {
                a(getString(2131626916));
                return false;
              }
              if ((m != 0) && (paramList2.size() > 1))
              {
                a(getString(2131626937));
                return false;
              }
              if (paramList1 != null)
              {
                if ((paramList1.size() == 1) && (((FileManagerEntity)paramList1.get(0)).sendCloudUnsuccessful()))
                {
                  apcb.a(2131626954);
                  return false;
                }
                localObject1 = paramList1.iterator();
                do
                {
                  if (!((Iterator)localObject1).hasNext()) {
                    break;
                  }
                } while (!apbf.a((FileManagerEntity)((Iterator)localObject1).next()).a(false));
              }
              break;
            }
            for (paramInt = 1;; paramInt = 0)
            {
              if (paramInt != 0) {
                apbx.a(this, 2131627035, 2131627040, new aail(this, paramList1));
              }
              while ((paramList2 != null) && (paramList2.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null))
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.h();
                return false;
                apck.a(paramList1, this);
              }
              paramList1 = new ArrayList();
              if (paramList != null) {
                paramList1.addAll(paramList);
              }
              if (bool)
              {
                paramList1.addAll(axfs.a(paramList3, this.jdField_a_of_type_JavaLangString, null));
                apci.a("0X8009AA1");
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
                  aphp.a(this, paramList2, 3);
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
                  paramList.add((ChatMessage)((annl)paramList1.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
                }
              }
              this.jdField_a_of_type_Aero.a(paramList);
              break;
              if (((n != 0) || (m != 0)) && (i3 != 0))
              {
                a(getString(2131626933));
                return false;
              }
              if ((i4 != 0) || (bool) || (i5 != 0))
              {
                a(getString(2131626934));
                return false;
              }
              long l;
              if (paramList1 != null)
              {
                l = 0L;
                if ((paramList1.size() == 1) && (((FileManagerEntity)paramList1.get(0)).sendCloudUnsuccessful()))
                {
                  apcb.a(2131626953);
                  return false;
                }
                paramList = paramList1.iterator();
                if (paramList.hasNext())
                {
                  paramList3 = (FileManagerEntity)paramList.next();
                  if (!apbf.a(paramList3).a(true)) {
                    break label2073;
                  }
                  l = paramList3.fileSize + l;
                }
              }
              for (;;)
              {
                break label1152;
                paramList = this.app.a();
                if ((apck.a()) && (l > aonj.a())) {
                  apck.a(false, this, new aaim(this, paramList1, paramList));
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
                  apcb.a(2131626955);
                  return false;
                }
                paramList2 = paramList1.iterator();
                do
                {
                  if (!paramList2.hasNext()) {
                    break;
                  }
                } while (!apbf.a((FileManagerEntity)paramList2.next()).a(false));
                for (paramInt = 1;; paramInt = 0)
                {
                  if (paramInt != 0)
                  {
                    if (!bbrm.a(this, 5, new aain(this, paramList1, paramList))) {
                      break;
                    }
                    apbx.a(this, 2131627035, 2131627038, new aaio(this, paramList1, paramList));
                    break;
                  }
                  paramList1 = paramList1.iterator();
                  paramInt = 0;
                  while (paramList1.hasNext())
                  {
                    paramList2 = (FileManagerEntity)paramList1.next();
                    if (!paramList2.sendCloudUnsuccessful()) {
                      if (bace.b(paramList2.getFilePath()))
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
                    apcb.d(getString(2131627191));
                    break;
                  }
                  apcb.a(2131626955);
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
                      ((List)localObject1).add((ChatMessage)((annl)paramList.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
                    }
                  }
                  if (((((List)localObject1).size() == 0) && (paramList1 == null) && (!bool)) || ((((List)localObject1).size() <= 0) && (!axfs.a(paramList1)) && (!bool))) {
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
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(getActivity(), 2131690181);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131493818);
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131305861);
    localTextView.setText(localTextView.getResources().getString(2131624384));
    if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b(annl paramannl)
  {
    if (this.e == null) {
      return;
    }
    this.e.remove(paramannl);
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
      localIntent = aciy.a(localIntent, null);
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
        this.jdField_a_of_type_Aero.a(paramIntent);
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
    setContentView(2131493166);
    setTitle(2131625150);
    if (((Intent)localObject).getStringExtra("leftViewText") == null) {
      setLeftViewName(2131625271);
    }
    for (;;)
    {
      paramBundle = (TabBarView)findViewById(2131311012);
      paramBundle.a(0, ajjy.a(2131635849));
      paramBundle.a(1, ajjy.a(2131635869));
      paramBundle.a(2, ajjy.a(2131635859));
      paramBundle.a(3, ajjy.a(2131635797));
      paramBundle.a(4, ajjy.a(2131635868));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131310046));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131311725));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      setRightButton(2131624448, this);
      c();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131304063));
      paramBundle.setOnTabChangeListener(new aaif(this));
      localObject = ((Intent)localObject).getStringExtra("com.tencent.mobileqq.ChatHistoryFileActivity.initial_tab");
      try
      {
        i = Integer.parseInt((String)localObject);
        paramBundle.setSelectedTab(i, true);
        this.jdField_a_of_type_Aero = new aero(this, 3);
        this.jdField_a_of_type_Aero.a();
        advs.a().a(this);
        if (this.jdField_a_of_type_Aodp == null) {
          this.jdField_a_of_type_Aodp = new aair(this, null);
        }
        this.app.a().addObserver(this.jdField_a_of_type_Aodp);
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
    this.jdField_a_of_type_Aero.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.c();
    }
    if (this.jdField_a_of_type_Aaid != null) {
      this.jdField_a_of_type_Aaid.c();
    }
    if (this.jdField_a_of_type_Aodp != null) {
      this.app.a().deleteObserver(this.jdField_a_of_type_Aodp);
    }
    advs.a().b(this);
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
    if (this.jdField_a_of_type_Aaji != null) {
      this.jdField_a_of_type_Aaji.b();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_Aaji != null)
    {
      this.jdField_a_of_type_Aaji.h_(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Aaji.a();
    }
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131167766);
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
        if (this.jdField_a_of_type_Aajg != null) {
          this.jdField_a_of_type_Aajg.a(this.jdField_a_of_type_JavaUtilList);
        }
        if (this.jdField_a_of_type_Aaid != null) {
          this.jdField_a_of_type_Aaid.f();
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
      bguc.a(this.app, this, getTitleBarHeight());
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      i = paramMessage.arg1;
    } while (!bgtg.a(i));
    if (bgtg.d(i))
    {
      getString(2131629244);
      paramMessage = "";
      if (bgtg.b(i))
      {
        getString(2131629244);
        paramMessage = getString(2131626604);
      }
      for (;;)
      {
        aaii localaaii = new aaii(this);
        a(getString(2131633005), paramMessage, null, null, localaaii);
        return true;
        if (bgtg.c(i))
        {
          getString(2131629244);
          paramMessage = getString(2131626602);
        }
      }
    }
    paramMessage = (String)paramMessage.obj;
    bbmy.a(this.app.getApp(), paramMessage, 1).b(getTitleBarHeight());
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
      overridePendingTransition(0, 2130772311);
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    int j = 0;
    switch (paramView.getId())
    {
    default: 
    case 2131302832: 
      do
      {
        return;
        a();
      } while (!this.jdField_a_of_type_Boolean);
      awqx.b(this.app, "dc00898", "", "", "0X8007125", "0X8007125", 0, 0, "", "", "", "");
      return;
    case 2131301021: 
      if (a(0, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList)) {
        a();
      }
      awqx.b(this.app, "dc00898", "", "", "0X8007129", "0X8007129", 0, 0, "", "", "", "");
      return;
    case 2131299769: 
      if (a(1, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList)) {
        a();
      }
      awqx.b(this.app, "dc00898", "", "", "0X800712A", "0X800712A", 0, 0, "", "", "", "");
      return;
    case 2131309814: 
      if (a(2, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList, this.jdField_d_of_type_JavaUtilList)) {
        a();
      }
      awqx.b(this.app, "dc00898", "", "", "0X800712B", "0X800712B", 0, 0, "", "", "", "");
      return;
    }
    awqx.b(this.app, "dc00898", "", "", "0X800712C", "0X800712C", 0, 0, "", "", "", "");
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
      apcb.c(2131626941);
      return;
    }
    paramView = (begr)behe.a(this, null);
    paramView.a(2131630692);
    paramView.a(getString(2131626808), 3);
    paramView.c(2131625035);
    paramView.a(new aaik(this, paramView));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileActivity
 * JD-Core Version:    0.7.0.1
 */