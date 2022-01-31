package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import rxb;
import rxc;
import rxd;
import rxe;
import rxf;
import rxg;
import rxh;
import rxi;
import rxj;
import rxk;

public class ChatHistoryFileActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener
{
  int jdField_a_of_type_Int;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout a;
  ChatHistoryFileView jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView;
  ChatHistoryImageView jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
  ChatHistoryStructMsgView jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView;
  public ChatHistoryViewBase a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new rxi(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new rxj(this);
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public QQProgressDialog a;
  String jdField_a_of_type_JavaLangString;
  public List a;
  public final MqqHandler a;
  public boolean a;
  private int jdField_b_of_type_Int;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  String jdField_b_of_type_JavaLangString;
  public List b;
  ImageView c;
  public List c;
  ImageView d;
  
  public ChatHistoryFileActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase = null;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  }
  
  private ChatHistoryViewBase a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
    case 3: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView = new ChatHistoryFileView();
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView.a(getIntent(), this.app, this);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView.a(paramInt);
      return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileView;
    case 0: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView = new ChatHistoryImageView();
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(getIntent(), this.app, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView = new ChatHistoryStructMsgView();
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.a(getIntent(), this.app, this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363499));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363500));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363501));
    this.d = ((ImageView)findViewById(2131363502));
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = getResources().getDrawable(2130838651);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
    localDrawable = getResources().getDrawable(2130838652);
    localStateListDrawable.addState(new int[] { 16842910 }, localDrawable);
    localDrawable = getResources().getDrawable(2130838651);
    localStateListDrawable.addState(new int[0], localDrawable);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(localStateListDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(true);
    this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(true);
    this.d.setEnabled(true);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.a();
      setRightButton(2131432998, this);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.b();
    setRightButton(2131436684, this);
    this.jdField_c_of_type_JavaUtilList = null;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_b_of_type_JavaUtilList = null;
  }
  
  public void a(AIORichMediaInfo paramAIORichMediaInfo)
  {
    if (this.jdField_c_of_type_JavaUtilList == null) {
      this.jdField_c_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_c_of_type_JavaUtilList.add(paramAIORichMediaInfo);
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
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131435252, new rxc(this));
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
  
  public void a(Map paramMap, ArrayList paramArrayList)
  {
    String str = " ";
    if (this.jdField_a_of_type_Int == 0) {}
    for (str = ContactUtils.b(this.app, this.jdField_a_of_type_JavaLangString);; str = this.jdField_b_of_type_JavaLangString) {
      do
      {
        paramMap = ChatActivityFacade.a(this, str, paramArrayList, paramMap, true);
        if (paramMap != null) {
          break;
        }
        return;
      } while ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 3000));
    }
    paramMap.mMsg_A_ActionData = null;
    paramArrayList = new Intent();
    paramArrayList.putExtra("forward_type", -3);
    paramArrayList.putExtra("stuctmsg_bytes", paramMap.getBytes());
    paramArrayList.putExtra("is_need_show_sources", false);
    ForwardBaseOption.a(this, paramArrayList, 3);
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
      if (j >= 20) {
        bool = true;
      }
      if (bool) {
        FMToastUtil.a(2131428153);
      }
      return bool;
    }
  }
  
  public boolean a(int paramInt, List paramList1, List paramList2, List paramList3)
  {
    int k = 0;
    int i = 0;
    if (paramList2 != null)
    {
      i = 1;
      k = 0 + paramList2.size();
    }
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      i += 1;
      k += paramList1.size();
    }
    for (int n = 1;; n = 0)
    {
      Object localObject1;
      int m;
      int i1;
      int j;
      if (paramList3 != null)
      {
        localObject1 = paramList3.iterator();
        m = 0;
        i1 = 0;
        j = i;
        i = i1;
        if (((Iterator)localObject1).hasNext())
        {
          i1 = AIOGalleryUtils.a(((AIORichMediaInfo)((Iterator)localObject1).next()).a);
          if ((m == 0) && (i1 == 1))
          {
            m = 1;
            j += 1;
            label132:
            if ((i == 0) && (i1 == 2))
            {
              i = j + 1;
              j = 1;
              label152:
              if ((m != 0) && (j != 0))
              {
                label162:
                i1 = paramList3.size();
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
          FMToastUtil.c(2131428151);
          return false;
          i1 = j;
          j = i;
          i = i1;
          break;
        }
        switch (paramInt)
        {
        default: 
          return true;
        case 0: 
          if (!NetworkUtil.d(BaseApplication.getContext()))
          {
            QQToast.a(this, 2131434596, 1).b(getResources().getDimensionPixelSize(2131558448));
            return false;
          }
          if (i > 1)
          {
            a(getString(2131428154));
            return false;
          }
          if ((k != 0) && (paramList3.size() > 1))
          {
            a(getString(2131428155));
            return false;
          }
          if (paramList2 != null)
          {
            if ((paramList2.size() == 1) && (((FileManagerEntity)paramList2.get(0)).sendCloudUnsuccessful()))
            {
              FMToastUtil.a("未发送成功的文件不允许转发");
              return false;
            }
            localObject1 = paramList2.iterator();
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
            } while (!FileModel.a((FileManagerEntity)((Iterator)localObject1).next()).a(false));
          }
          break;
        }
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt != 0) {
            FMDialogUtil.a(this, 2131428241, 2131428237, new rxe(this, paramList2));
          }
          while ((paramList3 != null) && (paramList3.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.h();
            return false;
            FileManagerUtil.a(paramList2, this);
          }
          if ((paramList1 == null) || (paramList1.size() <= 0)) {
            break;
          }
          if (paramList1.size() == 1)
          {
            paramList2 = (MessageForStructing)paramList1.get(0);
            if (paramList2.structingMsg == null) {
              break;
            }
            paramList1 = new Bundle();
            if ((paramList2.structingMsg.source_puin != null) && (!"".equals(paramList2.structingMsg.source_puin))) {
              paramList1.putString("source_puin", paramList2.structingMsg.source_puin);
            }
            paramList1.putInt("forward_type", -3);
            paramList2.structingMsg.mCommentText = null;
            paramList1.putInt("structmsg_service_id", paramList2.structingMsg.mMsgServiceID);
            paramList1.putByteArray("stuctmsg_bytes", paramList2.structingMsg.getBytes());
            paramList1.putLong("structmsg_uniseq", paramList2.uniseq);
            paramList1.putInt("accostType", paramList2.structingMsg.sourceAccoutType);
            paramList2 = new Intent();
            paramList2.putExtras(paramList1);
            ForwardBaseOption.a(this, paramList2, 3);
            break;
          }
          paramList2 = new ArrayList();
          MultiMsgManager.a().b(paramList1);
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131433405);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
          paramList3 = paramList1.iterator();
          while (paramList3.hasNext())
          {
            localObject1 = (ChatMessage)paramList3.next();
            if (!paramList2.contains(((ChatMessage)localObject1).senderuin)) {
              paramList2.add(((ChatMessage)localObject1).senderuin);
            }
          }
          MultiMsgManager.a().a.clear();
          MultiMsgManager.a().a.addAll(paramList1);
          if (this.jdField_a_of_type_Int == 1) {
            ((TroopHandler)this.app.a(20)).a(this.jdField_a_of_type_JavaLangString, paramList2, false, null);
          }
          for (;;)
          {
            paramList1 = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1);
            paramList1.arg1 = paramList2.size();
            this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramList1, 30000L);
            break;
            if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 3000)) {
              ((FriendListHandler)this.app.a(1)).a(paramList2);
            }
          }
          if (i > 1)
          {
            a(getString(2131428156));
            return false;
          }
          if ((k != 0) || (n != 0))
          {
            a(getString(2131428157));
            return false;
          }
          long l;
          if (paramList2 != null)
          {
            l = 0L;
            if ((paramList2.size() == 1) && (((FileManagerEntity)paramList2.get(0)).sendCloudUnsuccessful()))
            {
              FMToastUtil.a("未发送成功的文件不允许下载");
              return false;
            }
            paramList1 = paramList2.iterator();
            label968:
            if (paramList1.hasNext())
            {
              localObject1 = (FileManagerEntity)paramList1.next();
              if (!FileModel.a((FileManagerEntity)localObject1).a(true)) {
                break label1733;
              }
              l = ((FileManagerEntity)localObject1).fileSize + l;
            }
          }
          label1326:
          label1733:
          for (;;)
          {
            break label968;
            paramList1 = this.app.a();
            if ((FileManagerUtil.a()) && (l > FMConfig.a())) {
              FileManagerUtil.a(false, this, new rxf(this, paramList2, paramList1));
            }
            while ((paramList3 != null) && (paramList3.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null))
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.f();
              return false;
              paramList2 = paramList2.iterator();
              while (paramList2.hasNext())
              {
                localObject1 = (FileManagerEntity)paramList2.next();
                if (!((FileManagerEntity)localObject1).sendCloudUnsuccessful()) {
                  paramList1.b((FileManagerEntity)localObject1);
                }
              }
            }
            if (i > 1)
            {
              a(getString(2131428159));
              return false;
            }
            if ((m != 0) || (k != 0) || (n != 0))
            {
              a(getString(2131428159));
              return false;
            }
            if ((paramList2 == null) || (paramList2.size() <= 0)) {
              break;
            }
            paramList1 = (FileManagerEntity)paramList2.get(0);
            paramList1 = this.app.a();
            if ((paramList2.size() == 1) && (((FileManagerEntity)paramList2.get(0)).sendCloudUnsuccessful()))
            {
              FMToastUtil.a("未发送成功的文件不允许存微云");
              return false;
            }
            paramList3 = paramList2.iterator();
            do
            {
              if (!paramList3.hasNext()) {
                break;
              }
            } while (!FileModel.a((FileManagerEntity)paramList3.next()).a(false));
            for (paramInt = 1;; paramInt = 0)
            {
              if (paramInt != 0)
              {
                FMDialogUtil.a(this, 2131428241, 2131428238, new rxg(this, paramList2, paramList1));
                break;
              }
              if (paramList2.size() > 1)
              {
                FMToastUtil.d(getString(2131428195));
                paramList2 = paramList2.iterator();
              }
              while (paramList2.hasNext())
              {
                paramList3 = (FileManagerEntity)paramList2.next();
                if (!paramList3.sendCloudUnsuccessful())
                {
                  if (FileUtils.b(paramList3.getFilePath()))
                  {
                    paramList1.a(paramList3.getFilePath(), "", this.app.getCurrentAccountUin(), 0, false);
                    continue;
                    FMToastUtil.d(getString(2131428195));
                    break label1326;
                  }
                  paramList1.a(paramList3, String.valueOf(paramList3.peerUin));
                }
              }
              localObject1 = new ArrayList();
              Iterator localIterator;
              Object localObject2;
              if ((paramList2 != null) && (paramList2.size() > 0))
              {
                localIterator = paramList2.iterator();
                while (localIterator.hasNext())
                {
                  localObject2 = (FileManagerEntity)localIterator.next();
                  localObject2 = this.app.a().b(((FileManagerEntity)localObject2).peerUin, ((FileManagerEntity)localObject2).peerType, ((FileManagerEntity)localObject2).uniseq);
                  if (localObject2 != null) {
                    ((List)localObject1).add((ChatMessage)localObject2);
                  }
                }
              }
              if ((paramList3 != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null))
              {
                paramList3 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a();
                localIterator = paramList3.iterator();
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
                ((List)localObject1).addAll(paramList3);
              }
              if ((paramList1 != null) && (paramList1.size() > 0)) {
                ((List)localObject1).addAll(paramList1);
              }
              if (((((List)localObject1).size() == 0) && (paramList2 == null)) || ((((List)localObject1).size() <= 0) && (paramList2.size() <= 0))) {
                break;
              }
              ThreadManager.post(new rxh(this, (List)localObject1, paramList2), 8, null, true);
              break;
            }
          }
        }
        i1 = i;
        i = j;
        j = i1;
        break label152;
        break label132;
        i1 = i;
        i = j;
        j = i1;
        break label162;
        m = 0;
        i1 = 0;
        j = k;
        k = i1;
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
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return false;
    }
    return this.jdField_b_of_type_JavaUtilList.contains(paramFileManagerEntity);
  }
  
  public void b(AIORichMediaInfo paramAIORichMediaInfo)
  {
    if (this.jdField_c_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_c_of_type_JavaUtilList.remove(paramAIORichMediaInfo);
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
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.remove(paramFileManagerEntity);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
      Object localObject;
      do
      {
        return;
        localObject = new Intent(this, SendPhotoActivity.class);
        paramIntent = new Bundle(paramIntent.getExtras());
        if (QLog.isColorLevel()) {
          QLog.d("forward", 2, "AIOListGallerysence startChatAndSendMsg IS_WAIT_DEST_RESULT=true");
        }
        paramIntent.putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
        paramIntent.putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        localObject = AIOUtils.a((Intent)localObject, null);
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramIntent.putBoolean("PicContants.NEED_COMPRESS", false);
        paramIntent.putBoolean("send_in_background", false);
        ((Intent)localObject).putExtras(paramIntent);
        startActivity((Intent)localObject);
        break;
        a();
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(paramIntent);
        break;
        localObject = StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      } while (localObject == null);
      ((AbsStructMsg)localObject).sourceAccoutType = paramIntent.getIntExtra("accostType", 0);
      String str1 = paramIntent.getStringExtra("uin");
      String str2 = paramIntent.getStringExtra("troop_uin");
      paramInt2 = paramIntent.getIntExtra("uintype", 0);
      if (35 != ((AbsStructMsg)localObject).mMsgServiceID) {
        ShareMsgHelper.b(this.app, str1, str2, paramInt2, (AbsStructMsg)localObject, null);
      } else {
        ThreadManager.post(new rxk(this, str1, str2, paramInt2), 8, null, false);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    Object localObject = getIntent();
    this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("uin");
    this.jdField_a_of_type_Int = ((Intent)localObject).getIntExtra("uintype", 0);
    this.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("uinname");
    setContentView(2130968739);
    setTitle(2131433634);
    if (((Intent)localObject).getStringExtra("leftViewText") == null) {
      setLeftViewName(2131434920);
    }
    for (;;)
    {
      paramBundle = (TabBarView)findViewById(2131363495);
      paramBundle.a(0, "图片/视频");
      paramBundle.a(1, "文档");
      paramBundle.a(2, "链接");
      paramBundle.a(3, "其他");
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363498));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131363497));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      setRightButton(2131436684, this);
      b();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363496));
      paramBundle.setOnTabChangeListener(new rxb(this));
      localObject = ((Intent)localObject).getStringExtra("com.tencent.mobileqq.ChatHistoryFileActivity.initial_tab");
      try
      {
        i = Integer.parseInt((String)localObject);
        paramBundle.setSelectedTab(i, true);
        this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
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
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.e();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.c();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.a(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryViewBase.d();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        QQToast.a(this.app.getApp(), 2131433408, 0).b(getApplicationContext().getResources().getDimensionPixelSize(2131558448));
        continue;
        paramMessage = this.jdField_a_of_type_JavaUtilList;
        a();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryStructMsgView.a(paramMessage);
        }
        a(this.jdField_b_of_type_Int);
      }
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    finish();
    if (getIntent().getBooleanExtra("extra.IS_FROM_CHAT_AIO_GALLERY", false)) {
      overridePendingTransition(0, 2131034410);
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    int j = 0;
    switch (paramView.getId())
    {
    default: 
    case 2131363410: 
      do
      {
        return;
        a();
      } while (!this.jdField_a_of_type_Boolean);
      ReportController.b(this.app, "dc00898", "", "", "0X8007125", "0X8007125", 0, 0, "", "", "", "");
      return;
    case 2131363499: 
      if (a(0, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList)) {
        a();
      }
      ReportController.b(this.app, "dc00898", "", "", "0X8007129", "0X8007129", 0, 0, "", "", "", "");
      return;
    case 2131363500: 
      if (a(1, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList)) {
        a();
      }
      ReportController.b(this.app, "dc00898", "", "", "0X800712A", "0X800712A", 0, 0, "", "", "", "");
      return;
    case 2131363501: 
      if (a(2, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_c_of_type_JavaUtilList)) {
        a();
      }
      ReportController.b(this.app, "dc00898", "", "", "0X800712B", "0X800712B", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.app, "dc00898", "", "", "0X800712C", "0X800712C", 0, 0, "", "", "", "");
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
    if (j == 0)
    {
      FMToastUtil.c(2131428151);
      return;
    }
    paramView = (ActionSheet)ActionSheetHelper.a(this, null);
    paramView.a(2131430158);
    paramView.a(getString(2131428126), 3);
    paramView.c(2131432998);
    paramView.a(new rxd(this, paramView));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileActivity
 * JD-Core Version:    0.7.0.1
 */