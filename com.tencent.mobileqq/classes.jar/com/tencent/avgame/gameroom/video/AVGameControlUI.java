package com.tencent.avgame.gameroom.video;

import android.app.Activity;
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
import com.tencent.avgame.ui.IAVGameRootContainer;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.app.AppActivity;

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
  
  public AVGameControlUI(AVGameAppInterface paramAVGameAppInterface, QBaseActivity paramQBaseActivity, ViewGroup paramViewGroup)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("_");
    localStringBuilder.append(QQAudioHelper.b());
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQBaseActivity);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    paramAVGameAppInterface = a();
    if (paramAVGameAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "AVGameControlUI-->can not get AVActivity");
      }
      return;
    }
    this.jdField_a_of_type_AndroidContentResResources = paramAVGameAppInterface.getResources();
    if (this.jdField_a_of_type_AndroidContentResResources == null)
    {
      AVLog.printAllUserLog(this.jdField_a_of_type_JavaLangString, "mRes is null. exit video progress");
      paramQBaseActivity = new StringBuilder();
      paramQBaseActivity.append(paramAVGameAppInterface.getString(2131720211));
      paramQBaseActivity.append(" 0x08");
      paramQBaseActivity = paramQBaseActivity.toString();
      Toast.makeText(paramAVGameAppInterface.getApplicationContext(), paramQBaseActivity, 0).show();
      paramAVGameAppInterface.finish();
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return true;
  }
  
  AppActivity a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference == null) {
      return null;
    }
    if ((localWeakReference.get() instanceof IAVGameRootContainer)) {
      return (AppActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
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
    AppActivity localAppActivity = a();
    if (localAppActivity == null) {
      return;
    }
    String str;
    if ("android.permission.CAMERA".equals(paramString))
    {
      str = localAppActivity.getString(2131695646);
      paramString = localAppActivity.getString(2131695647);
    }
    else
    {
      if (!"android.permission.RECORD_AUDIO".equals(paramString)) {
        return;
      }
      str = localAppActivity.getString(2131695656);
      paramString = localAppActivity.getString(2131695657);
    }
    a(paramLong, str, paramString);
  }
  
  void a(long paramLong, String paramString1, String paramString2)
  {
    if (a()) {
      return;
    }
    AppActivity localAppActivity = a();
    if (localAppActivity == null) {
      return;
    }
    paramString1 = DialogUtil.a(localAppActivity, 230).setMessage(paramString1).setTitle(paramString2).setNegativeButton(2131690728, new AVGameControlUI.3(this, paramLong));
    int i;
    if (AVGameUtil.a(localAppActivity)) {
      i = 2131695658;
    } else {
      i = 2131695659;
    }
    paramString1.setPositiveButton(i, new AVGameControlUI.2(this, paramLong)).show();
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
    Object localObject = a();
    if (localObject == null) {
      return false;
    }
    int i;
    if (((AppActivity)localObject).checkSelfPermission(paramString) == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      if (a((Context)localObject))
      {
        AVGameControlUI.1 local1 = new AVGameControlUI.1(this, paramString, paramLong, paramInt, paramView);
        String str = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkSelfPermission, begin, permission[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], mRequestPermissionIng[");
        localStringBuilder.append(this.jdField_a_of_type_Boolean);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
        this.jdField_a_of_type_Boolean = true;
        ((AppActivity)localObject).requestPermissions(local1, 0, new String[] { paramString });
        if ("android.permission.CAMERA".equals(paramString))
        {
          ReportController.b(null, "dc00898", "", "", "0X800B03D", "0X800B03D", 0, 0, "", "", "", "");
          return false;
        }
        if ("android.permission.RECORD_AUDIO".equals(paramString))
        {
          b(paramLong, paramView);
          ReportController.b(null, "dc00898", "", "", "0X800B03C", "0X800B03C", 0, 0, "", "", "", "");
          return false;
        }
      }
      else
      {
        paramView = this.jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkSelfPermission, fail, permission[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("], seq[");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append("]");
        QLog.w(paramView, 1, ((StringBuilder)localObject).toString());
        a(paramLong, paramString);
      }
      return false;
    }
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
    a(QQAudioHelper.b(), paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUI
 * JD-Core Version:    0.7.0.1
 */