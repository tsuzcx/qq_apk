package com.tencent.avgame.gameroom.video;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.av.AVLog;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.MemberVideoDisplayInfo;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class AVGameControlUI
  implements View.OnClickListener, IAVControlUiPresenter
{
  int jdField_a_of_type_Int = 0;
  Resources jdField_a_of_type_AndroidContentResResources = null;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  protected AVGameAppInterface a;
  protected IGameRoomPresenter a;
  protected AVGameVideoLayer a;
  protected final String a;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference = null;
  boolean jdField_a_of_type_Boolean = false;
  
  public AVGameControlUI(AVGameAppInterface paramAVGameAppInterface, BaseActivity paramBaseActivity, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_JavaLangString = (getClass().getSimpleName() + "_" + AudioHelper.b());
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    paramAVGameAppInterface = a();
    if (paramAVGameAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "AVGameControlUI-->can not get AVActivity");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidContentResResources = paramAVGameAppInterface.getResources();
    } while (this.jdField_a_of_type_AndroidContentResResources != null);
    AVLog.printAllUserLog(this.jdField_a_of_type_JavaLangString, "mRes is null. exit video progress");
    paramBaseActivity = paramAVGameAppInterface.getString(2131720499) + " 0x08";
    Toast.makeText(paramAVGameAppInterface.getApplicationContext(), paramBaseActivity, 0).show();
    paramAVGameAppInterface.finish();
  }
  
  public static boolean a(Context paramContext)
  {
    return true;
  }
  
  AVGameActivity a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    while (!(this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof AVGameActivity)) {
      return null;
    }
    return (AVGameActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Int = 2;
  }
  
  abstract void a(long paramLong, int paramInt, View paramView);
  
  public abstract void a(long paramLong, int paramInt, String paramString1, String paramString2);
  
  public abstract void a(long paramLong, View paramView);
  
  void a(long paramLong, String paramString)
  {
    AVGameActivity localAVGameActivity = a();
    if (localAVGameActivity == null) {
      return;
    }
    String str;
    if ("android.permission.CAMERA".equals(paramString)) {
      str = localAVGameActivity.getString(2131695632);
    }
    for (paramString = localAVGameActivity.getString(2131695633);; paramString = localAVGameActivity.getString(2131695643))
    {
      a(paramLong, str, paramString);
      return;
      if (!"android.permission.RECORD_AUDIO".equals(paramString)) {
        break;
      }
      str = localAVGameActivity.getString(2131695642);
    }
  }
  
  void a(long paramLong, String paramString1, String paramString2)
  {
    if (a()) {}
    AVGameActivity localAVGameActivity;
    do
    {
      return;
      localAVGameActivity = a();
    } while (localAVGameActivity == null);
    paramString1 = DialogUtil.a(localAVGameActivity, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131690800, new AVGameControlUI.3(this, paramLong));
    if (AVGameUtils.a(localAVGameActivity)) {}
    for (int i = 2131695644;; i = 2131695645)
    {
      paramString1.setPositiveButton(i, new AVGameControlUI.2(this, paramLong)).show();
      return;
    }
  }
  
  public void a(RectF paramRectF) {}
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter = paramIGameRoomPresenter;
  }
  
  public void a(AVGameVideoLayer paramAVGameVideoLayer)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer = paramAVGameVideoLayer;
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameVideoLayer.a(this);
  }
  
  public void a(List<MemberVideoDisplayInfo> paramList) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 6;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  boolean a(long paramLong, String paramString, View paramView, int paramInt)
  {
    AVGameActivity localAVGameActivity = a();
    if (localAVGameActivity == null) {
      return false;
    }
    int i;
    if (localAVGameActivity.checkSelfPermission(paramString) == 0)
    {
      i = 1;
      if (i != 0) {
        break label265;
      }
      if (!a(localAVGameActivity)) {
        break label214;
      }
      AVGameControlUI.1 local1 = new AVGameControlUI.1(this, paramString, paramLong, paramInt, paramView);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "checkSelfPermission, begin, permission[" + paramString + "], mRequestPermissionIng[" + this.jdField_a_of_type_Boolean + "], seq[" + paramLong + "]");
      this.jdField_a_of_type_Boolean = true;
      localAVGameActivity.requestPermissions(local1, 0, new String[] { paramString });
      if (!"android.permission.CAMERA".equals(paramString)) {
        break label169;
      }
      ReportController.b(null, "dc00898", "", "", "0X800B03D", "0X800B03D", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      return false;
      i = 0;
      break;
      label169:
      if ("android.permission.RECORD_AUDIO".equals(paramString))
      {
        b(paramLong, paramView);
        ReportController.b(null, "dc00898", "", "", "0X800B03C", "0X800B03C", 0, 0, "", "", "", "");
        continue;
        label214:
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "checkSelfPermission, fail, permission[" + paramString + "], seq[" + paramLong + "]");
        a(paramLong, paramString);
      }
    }
    label265:
    return true;
  }
  
  public void b() {}
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_Int = 3;
  }
  
  abstract void b(long paramLong, View paramView);
  
  abstract void c();
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_Int = 5;
  }
  
  public void d(long paramLong)
  {
    this.jdField_a_of_type_Int = 6;
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = null;
  }
  
  public void onClick(View paramView)
  {
    a(AudioHelper.b(), paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUI
 * JD-Core Version:    0.7.0.1
 */