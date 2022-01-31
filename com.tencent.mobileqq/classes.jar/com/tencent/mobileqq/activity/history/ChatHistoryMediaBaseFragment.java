package com.tencent.mobileqq.activity.history;

import aasg;
import aast;
import aegp;
import aegr;
import aehw;
import aeis;
import aeiy;
import afwf;
import afxy;
import afxz;
import afya;
import afyc;
import afyd;
import afye;
import afyf;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aoun;
import aozg;
import aptx;
import apug;
import asun;
import asur;
import asuw;
import axqy;
import bbdj;
import bbfj;
import bbgu;
import bcql;
import bfnk;
import bfpc;
import bfpp;
import bicz;
import bidk;
import bidv;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryMediaBaseFragment
  extends ChatHistoryBaseFragment
  implements aast, aegr, Handler.Callback, View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private aoun jdField_a_of_type_Aoun;
  public ChatHistoryImageView a;
  public ArrayList<aeiy> a;
  List<ChatMessage> jdField_a_of_type_JavaUtilList;
  public final MqqHandler a;
  private View jdField_b_of_type_AndroidViewView;
  bbgu jdField_b_of_type_Bbgu;
  private Dialog c;
  protected bbgu c;
  
  public ChatHistoryMediaBaseFragment()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new bfnk(Looper.getMainLooper(), this, true);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, aasg paramaasg)
  {
    if ((this.jdField_c_of_type_Bbgu != null) && (this.jdField_c_of_type_Bbgu.isShowing())) {
      this.jdField_c_of_type_Bbgu.dismiss();
    }
    bbgu localbbgu = new bbgu(getActivity(), 2131755791);
    localbbgu.setContentView(2131558906);
    this.jdField_c_of_type_Bbgu = localbbgu;
    this.jdField_c_of_type_Bbgu.setTitle(paramString1);
    this.jdField_c_of_type_Bbgu.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131690596);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131691035);
    }
    this.jdField_c_of_type_Bbgu.setNegativeButton(paramString1, new afyd(this, paramaasg));
    this.jdField_c_of_type_Bbgu.setPositiveButton(paramString2, new afye(this, paramaasg));
    this.jdField_c_of_type_Bbgu.setCancelable(true);
    this.jdField_c_of_type_Bbgu.setCanceledOnTouchOutside(false);
    this.jdField_c_of_type_Bbgu.show();
  }
  
  private void a(List<aeiy> paramList)
  {
    ArrayList localArrayList;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService != null))
    {
      localArrayList = new ArrayList();
      if ((paramList != null) && (paramList.size() > 0)) {
        localObject = paramList.iterator();
      }
    }
    label361:
    for (;;)
    {
      ChatMessage localChatMessage;
      if (((Iterator)localObject).hasNext())
      {
        paramList = (aeiy)((Iterator)localObject).next();
        localChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramList.a.f);
        if ((localChatMessage instanceof MessageForPic)) {
          paramList = asur.a((MessageForPic)localChatMessage);
        }
      }
      for (;;)
      {
        if (paramList == null) {
          break label361;
        }
        localArrayList.add(paramList);
        break;
        if ((localChatMessage instanceof MessageForShortVideo))
        {
          paramList = (MessageForShortVideo)localChatMessage;
          if (paramList.busiType == 0) {
            paramList = asur.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
          } else {
            paramList = asur.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList);
          }
        }
        else
        {
          if ((localChatMessage instanceof MessageForFile))
          {
            if (AIOFilePicData.class.isInstance(paramList.a))
            {
              paramList = asur.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
              paramList.a = 4;
              continue;
            }
            if (AIOFileVideoData.class.isInstance(paramList.a))
            {
              paramList = asur.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
              paramList.a = 5;
            }
          }
          else if ((localChatMessage instanceof MessageForTroopFile))
          {
            int i = apug.a(((MessageForTroopFile)localChatMessage).fileName);
            if (i == 0)
            {
              paramList = asur.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
              paramList.a = 6;
              continue;
            }
            if (i == 2)
            {
              paramList = asur.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage);
              paramList.a = 7;
              continue;
              paramList = new asun(getActivity());
              localObject = (asuw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(324);
              ((asuw)localObject).a(new afya(this, paramList, (asuw)localObject, localArrayList));
              ((asuw)localObject).a(localArrayList, true);
              ((asuw)localObject).a(localArrayList, 1, 5);
              return;
            }
          }
          paramList = null;
        }
      }
    }
  }
  
  private void b(List<ChatMessage> paramList)
  {
    if (paramList.size() == 1) {
      bidk.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), e(), paramList, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    for (;;)
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DB9", "0X8009DB9", 0, 0, "", "", "", "");
      return;
      bidk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), e(), paramList, this.jdField_a_of_type_MqqOsMqqHandler);
    }
  }
  
  private boolean b()
  {
    return ((getActivity() instanceof ChatHistoryActivity)) && (((ChatHistoryActivity)getActivity()).c);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_Aeis != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_Aeis.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryMediaBaseFragment", 2, "onMediaLoaded, mImageView.mAdapter is null");
      }
      this.jdField_a_of_type_Afwf.a(false);
      return;
    }
    this.jdField_a_of_type_Afwf.a(true);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(paramLong);
    }
  }
  
  public void a(aeiy paramaeiy)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramaeiy);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryStruct", 2, "addweiyunselected, size: " + this.jdField_a_of_type_JavaUtilList.size());
    }
  }
  
  void a(ArrayList<aeiy> paramArrayList) {}
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {}
    for (int i = this.jdField_a_of_type_JavaUtilArrayList.size() + 0;; i = 0)
    {
      if (i >= 20) {
        bool = true;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryMediaBaseFragment", 2, "isOverLimit");
        }
        aptx.a(2131692563);
      }
      return bool;
    }
  }
  
  public boolean a(aeiy paramaeiy)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (b())
    {
      int i = aehw.a(paramaeiy.a);
      if ((i == 2) || (i == 3))
      {
        c(getString(2131692578));
        return false;
      }
      if (AIOImageData.class.isInstance(paramaeiy.a))
      {
        AIOImageData localAIOImageData = (AIOImageData)paramaeiy.a;
        if ((localAIOImageData.e == null) || (localAIOImageData.e.length() == 0))
        {
          c(getString(2131692578));
          return false;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramaeiy);
    return true;
  }
  
  protected void b() {}
  
  public void b(ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList.remove(paramChatMessage);
    } while (!QLog.isColorLevel());
    QLog.d("ChatHistoryStruct", 2, "removeweiyunselect, size: " + this.jdField_a_of_type_JavaUtilList.size());
  }
  
  void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      u();
      s();
      return;
    }
    v();
  }
  
  protected int c()
  {
    return 1602;
  }
  
  protected void c() {}
  
  public void c(String paramString)
  {
    if (this.jdField_b_of_type_Bbgu == null)
    {
      this.jdField_b_of_type_Bbgu = bbdj.a(getActivity(), 230);
      this.jdField_b_of_type_Bbgu.setNegativeButton(2131719551, new afxz(this));
    }
    if (!this.jdField_b_of_type_Bbgu.isShowing()) {
      this.jdField_b_of_type_Bbgu.setMessage(paramString);
    }
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_Bbgu.show();
        return;
      }
      catch (Throwable paramString) {}
      this.jdField_b_of_type_Bbgu.dismiss();
    }
  }
  
  public int d()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return 0;
    }
    AIORichMediaData localAIORichMediaData = ((aeiy)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a;
    if ((AIOImageData.class.isInstance(localAIORichMediaData)) || (AIOFilePicData.class.isInstance(localAIORichMediaData))) {
      return 1;
    }
    if (AIOShortVideoData.class.isInstance(localAIORichMediaData)) {
      return 2;
    }
    return 0;
  }
  
  public int e()
  {
    return getResources().getDimensionPixelSize(2131298865);
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService == null) || (!AIOImageProviderService.a.containsValue(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.f();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a();
    }
    v();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_Aeis != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_Aeis.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatHistoryMediaBaseFragment", 2, "doOnResume, mImageView.mAdapter is null");
      }
      if (this.jdField_a_of_type_Afwf != null) {
        this.jdField_a_of_type_Afwf.a(false);
      }
    }
    while (this.jdField_a_of_type_Afwf == null) {
      return;
    }
    this.jdField_a_of_type_Afwf.a(true);
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.b();
    }
  }
  
  public void g()
  {
    super.g();
    aegp.a().b(this);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.c();
    }
    if (this.jdField_a_of_type_Aoun != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aoun);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      return true;
      v();
      q();
      return true;
      if (this.jdField_c_of_type_AndroidAppDialog != null) {
        this.jdField_c_of_type_AndroidAppDialog.dismiss();
      }
      v();
      return true;
      if (this.jdField_c_of_type_AndroidAppDialog != null) {
        this.jdField_c_of_type_AndroidAppDialog.dismiss();
      }
      bidv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), e());
      v();
      return true;
      if (this.jdField_c_of_type_AndroidAppDialog != null) {
        this.jdField_c_of_type_AndroidAppDialog.dismiss();
      }
      v();
      i = paramMessage.arg1;
    } while (!bicz.a(i));
    if (bicz.d(i))
    {
      getString(2131694922);
      paramMessage = "";
      if (bicz.b(i))
      {
        getString(2131694922);
        paramMessage = getString(2131692190);
      }
      for (;;)
      {
        afyc localafyc = new afyc(this);
        a(getString(2131698751), paramMessage, null, null, localafyc);
        return true;
        if (bicz.c(i))
        {
          getString(2131694922);
          paramMessage = getString(2131692188);
        }
      }
    }
    paramMessage = (String)paramMessage.obj;
    bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramMessage, 1).b(e());
    return true;
  }
  
  public void i()
  {
    if (this.jdField_c_of_type_AndroidAppDialog == null)
    {
      this.jdField_c_of_type_AndroidAppDialog = new Dialog(getActivity(), 2131755791);
      this.jdField_c_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_c_of_type_AndroidAppDialog.setContentView(2131559386);
    }
    TextView localTextView = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131371557);
    localTextView.setText(localTextView.getResources().getString(2131689932));
    if (!this.jdField_c_of_type_AndroidAppDialog.isShowing()) {}
    try
    {
      this.jdField_c_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void k()
  {
    if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      CheckPermission.requestStorePermission(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
      return;
    }
    if (!bbfj.d(BaseApplication.getContext()))
    {
      bcql.a(getActivity(), 2131694673, 1).b(getResources().getDimensionPixelSize(2131298865));
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      a(this.jdField_a_of_type_JavaUtilArrayList);
      r();
      return;
    }
    aptx.c(2131692560);
  }
  
  protected void l()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      i();
      b(this.jdField_a_of_type_JavaUtilList);
      t();
      return;
    }
    aptx.c(2131692560);
  }
  
  protected void m()
  {
    int i = 0;
    int j;
    int k;
    int m;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      j = 0;
      i = 0;
      k = 0;
      int n = 0;
      while (localIterator.hasNext())
      {
        int i2 = aehw.a(((aeiy)localIterator.next()).a);
        if ((n != 0) || (i2 != 1)) {
          break label264;
        }
        j += 1;
        n = 1;
        m = j;
        int i1 = k;
        if (k == 0)
        {
          m = j;
          i1 = k;
          if (i2 == 2)
          {
            m = j + 1;
            i1 = 1;
          }
        }
        if ((i != 0) || (i2 != 3)) {
          break label261;
        }
        m += 1;
        i = 1;
        label121:
        j = m;
        k = i1;
      }
      n = 0 + this.jdField_a_of_type_JavaUtilArrayList.size();
      m = k;
      k = i;
      i = n;
    }
    for (;;)
    {
      if (i == 0)
      {
        aptx.c(2131692560);
        return;
      }
      if (!bbfj.d(BaseApplication.getContext()))
      {
        bcql.a(getActivity(), 2131694673, 1).b(getResources().getDimensionPixelSize(2131298865));
        return;
      }
      if (j > 1)
      {
        c(getString(2131692554));
        return;
      }
      if (k != 0)
      {
        c(getString(2131692535));
        return;
      }
      if ((m != 0) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 1))
      {
        c(getString(2131692556));
        return;
      }
      p();
      return;
      label261:
      break label121;
      label264:
      break;
      j = 0;
      k = 0;
      m = 0;
    }
  }
  
  protected void n()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      i = 0 + this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    if (i == 0)
    {
      aptx.c(2131692560);
      return;
    }
    bfpc localbfpc = (bfpc)bfpp.a(getActivity(), null);
    localbfpc.a(2131696396);
    localbfpc.a(getActivity().getString(2131692409), 3);
    localbfpc.c(2131690596);
    localbfpc.a(new afxy(this, localbfpc));
    localbfpc.show();
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {}
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      aptx.c(2131692560);
      return;
    }
    paramView = (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone();
    Iterator localIterator = paramView.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      i = aehw.a(((aeiy)localIterator.next()).a);
    } while ((i != 2) && (i != 3));
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        c(getString(2131692579));
      }
      for (;;)
      {
        getActivity().finish();
        return;
        a(paramView);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    aegp.a().a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView = new ChatHistoryImageView();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a(getActivity().getIntent(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.jdField_a_of_type_Aast = this;
    }
    if ((b()) && ((this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a() instanceof RelativeLayout)))
    {
      paramViewGroup = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a();
      this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131558721, null);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131378708));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -2);
      paramLayoutInflater.addRule(12, -1);
      paramLayoutInflater.addRule(14, -1);
      paramViewGroup.addView(this.jdField_b_of_type_AndroidViewView, paramLayoutInflater);
      return paramViewGroup;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (this.jdField_a_of_type_Aoun == null) {
        this.jdField_a_of_type_Aoun = new afyf(this, null);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aoun);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.a();
  }
  
  protected void p() {}
  
  void q() {}
  
  void r() {}
  
  void s() {}
  
  void t() {}
  
  protected void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.d();
    }
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    }
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryImageView.e();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryMediaBaseFragment
 * JD-Core Version:    0.7.0.1
 */