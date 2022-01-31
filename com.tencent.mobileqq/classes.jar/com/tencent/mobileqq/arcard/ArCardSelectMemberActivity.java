package com.tencent.mobileqq.arcard;

import aann;
import aano;
import aanp;
import aanq;
import aanr;
import aans;
import aant;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberInnerFrame;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.arengine.ARResouceDir;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArCardSelectMemberActivity
  extends SelectMemberActivity
  implements Handler.Callback
{
  private static MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  private int jdField_a_of_type_Int = 0;
  protected Dialog a;
  private ARCardObserver jdField_a_of_type_ComTencentMobileqqArcardARCardObserver;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private String jdField_a_of_type_JavaLangString;
  public ArrayList a;
  private String b;
  private long c;
  private String i;
  private String j = "";
  private String k = "";
  private String l = "";
  private String m = "";
  private String n;
  private String o;
  private String p;
  
  public ArCardSelectMemberActivity()
  {
    this.jdField_i_of_type_JavaLangString = "";
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    DialogUtil.b(paramContext, 232, null, paramContext.getString(paramInt), 2131433015, 2131433017, new aans(paramContext), new aant()).show();
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArcardARCardObserver != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArcardARCardObserver = new aann(this);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqArcardARCardObserver);
  }
  
  protected void a()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_i_of_type_JavaUtilArrayList.size() > 0)
    {
      Iterator localIterator = this.jdField_i_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        this.jdField_a_of_type_JavaUtilArrayList.add(localResultRecord.jdField_a_of_type_JavaLangString);
      }
    }
    e();
  }
  
  protected void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624516);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130968716);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363400).setVisibility(4);
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363399)).setVisibility(8);
    paramString = (ProgressBar)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363398);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    localLayoutParams.height = AIOUtils.a(45.0F, getResources());
    localLayoutParams.width = AIOUtils.a(45.0F, getResources());
    paramString.setLayoutParams(localLayoutParams);
    if (!this.jdField_a_of_type_AndroidAppDialog.isShowing())
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArCardSelectMemberActivity", 2, "showProgressDialog");
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  protected void b()
  {
    super.b();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("param_arcardtype");
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("pic_send_path");
    this.b = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("video_send_path");
    this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("aio_msg_title");
    this.j = this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("aio_msg_summary");
    this.k = this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("aio_msg_imageurl");
    this.l = this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("aio_msg_url");
    this.n = this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("aio_msg_shareid");
    this.m = this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("send_msg_success_url");
    this.o = this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("H5Source");
    try
    {
      this.c = Long.parseLong(this.jdField_a_of_type_AndroidContentIntent.getExtras().getString("taskId"));
      label190:
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.w = false;
      if (this.app.getCurrentNickname().length() > 6) {
        paramBundle = this.app.getCurrentNickname().substring(0, 6) + "...";
      }
      for (;;)
      {
        String[] arrayOfString = this.jdField_i_of_type_JavaLangString.split("\\|");
        if (arrayOfString[0] != null) {}
        try
        {
          this.jdField_i_of_type_JavaLangString = arrayOfString[0];
          this.jdField_i_of_type_JavaLangString = String.format(this.jdField_i_of_type_JavaLangString, new Object[] { paramBundle });
          label297:
          jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
          paramBundle = new Intent("tencent.video.q2v.startUploadPTV");
          paramBundle.putExtra("broadcastType", 2);
          this.app.getApp().sendBroadcast(paramBundle);
          v();
          return true;
          paramBundle = this.app.getCurrentNickname();
        }
        catch (Exception paramBundle)
        {
          break label297;
        }
      }
    }
    catch (Exception paramBundle)
    {
      break label190;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null) {
      jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArcardARCardObserver != null) {
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqArcardARCardObserver);
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    c();
    ((SelectMemberInnerFrame)this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).f();
  }
  
  protected void e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = (FriendsManager)this.app.getManager(50);
    int i1 = 0;
    Object localObject2;
    while ((i1 < this.jdField_a_of_type_JavaUtilArrayList.size()) && (i1 < 50))
    {
      localObject2 = ((FriendsManager)localObject1).c((String)this.jdField_a_of_type_JavaUtilArrayList.get(i1));
      if (localObject2 != null)
      {
        localStringBuilder.append(((Friends)localObject2).getFriendNick());
        if (i1 != this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
          localStringBuilder.append("、");
        }
      }
      i1 += 1;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() != 1) {
      localStringBuilder.append(String.format(getString(2131438264), new Object[] { "", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
    }
    this.p = localStringBuilder.toString();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
      localObject1 = "分别发送到";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.b(this, (String)localObject1, this.p, null, new aano(this), new aanp(this), 0, false);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageCount(this.jdField_i_of_type_JavaLangString);
      try
      {
        localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
        localObject1 = BitmapFactory.decodeFile(ARResouceDir.c() + "arcard_share_aiobg.png", (BitmapFactory.Options)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPreviewImage(new BitmapDrawable((Bitmap)localObject1), true, 1);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPreviewImageScaleType(true);
        if (this.jdField_a_of_type_Int == 2)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getWindow();
          ((Window)localObject1).getAttributes().dimAmount = 0.7F;
          ((Window)localObject1).addFlags(2);
        }
        i1 = getResources().getDisplayMetrics().widthPixels;
        localObject1 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(14);
        ((RelativeLayout.LayoutParams)localObject1).height = ((int)(i1 * 0.800000011920929D / 1.8D));
        localObject2 = (ImageView)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131364050);
        ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
        localObject1 = (TextView)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131364051);
        ((TextView)localObject1).setMaxLines(2);
        ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject1).setGravity(3);
        ((TextView)localObject1).post(new aanq(this));
        localObject1 = (TextView)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131362776);
        ((TextView)localObject1).setMaxLines(1);
        ((TextView)localObject1).setSingleLine(true);
        ((TextView)localObject1).setEllipsize(null);
        ((TextView)localObject1).setGravity(3);
        ((TextView)localObject1).post(new aanr(this, localStringBuilder, (TextView)localObject1));
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
        localObject1 = "发送到" + localStringBuilder.toString();
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
    }
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("ArCardSelectMemberActivity", 2, "handleMessage: send video cannel!");
      }
      t();
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("ArCardSelectMemberActivity", 2, "handleMessage: send bless msg timeout!");
      }
      t();
      a(this, 2131437375);
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
  }
  
  public void t()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ArCardSelectMemberActivity", 2, "cancelProgressDialog");
        }
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      if (jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null) {
        jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(2);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ArCardSelectMemberActivity", 2, "cancelProgressDialog excep!", localException);
    }
  }
  
  public void u()
  {
    ARRelationShipHandler localARRelationShipHandler;
    ArrayList localArrayList;
    Iterator localIterator;
    if (this.jdField_a_of_type_Int == 3)
    {
      localARRelationShipHandler = (ARRelationShipHandler)this.app.a(123);
      localArrayList = new ArrayList();
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(Long.valueOf(Long.parseLong((String)localIterator.next())));
      }
      localARRelationShipHandler.a(this.app.getLongAccountUin(), this.c, this.n, 1, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.j, 0, 0, localArrayList, this.jdField_i_of_type_JavaLangString, this.j, this.k, this.l);
    }
    for (;;)
    {
      a("");
      return;
      localARRelationShipHandler = (ARRelationShipHandler)this.app.a(123);
      localArrayList = new ArrayList();
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(Long.valueOf(Long.parseLong((String)localIterator.next())));
      }
      localARRelationShipHandler.a(this.app.getLongAccountUin(), this.c, this.n, 2, this.b, this.jdField_a_of_type_JavaLangString, this.j, 50, 4111, localArrayList, this.jdField_i_of_type_JavaLangString, this.j, this.k, this.l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ArCardSelectMemberActivity
 * JD-Core Version:    0.7.0.1
 */